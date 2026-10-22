package net.sqlcipher;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.mt.protector.impl.string2number.CastShortProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes42.dex */
public class MatrixCursor extends AbstractCursor {
    private final int columnCount;
    private final String[] columnNames;
    private Object[] data;
    private int rowCount;

    public class RowBuilder {
        private final int endIndex;
        private int index;
        final /* synthetic */ MatrixCursor this$0;

        public RowBuilder add(Object r100) {
            if (this.index == this.endIndex) goto L7;
            Object[] r101 = MatrixCursor.access$000(this.this$0);
            int r102 = this.index;
            this.index = r102 + 1;
            r101[r102] = r100;
            return this;
        L7:
            throw new CursorIndexOutOfBoundsException("No more columns left.");
        }

        public RowBuilder(MatrixCursor r100, int r101, int r102) {
            this.this$0 = r100;
            this.index = r101;
            this.endIndex = r102;
        }
    }

    public RowBuilder newRow() {
        int r100 = this.rowCount + 1;
        this.rowCount = r100;
        int r101 = r100 * this.columnCount;
        ensureCapacity(r101);
        return new RowBuilder(this, r101 - this.columnCount, r101);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return this.columnNames;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getCount() {
        return this.rowCount;
    }

    public MatrixCursor(String[] r100) {
        this(r100, 16);
    }

    public static /* synthetic */ Object[] access$000(MatrixCursor r100) {
        return r100.data;
    }

    private void ensureCapacity(int r100) {
        Object[] r101 = this.data;
        if (r100 <= r101.length) goto L10;
        int r102 = r101.length * 2;
        if (r102 < r100) goto L8;
        r100 = r102;
    L8:
        Object[] r103 = new Object[r100];
        this.data = r103;
        System.arraycopy(r101, 0, r103, 0, r101.length);
        return;
    }

    private Object get(int r100) {
        if (r100 < 0) goto L16;
        int r101 = this.columnCount;
        if (r100 >= r101) goto L16;
        int r102 = this.mPos;
        if (r102 < 0) goto L14;
        if (r102 >= this.rowCount) goto L12;
        return this.data[(r102 * r101) + r100];
    L12:
        throw new CursorIndexOutOfBoundsException("After last row.");
    L14:
        throw new CursorIndexOutOfBoundsException("Before first row.");
    L16:
        throw new CursorIndexOutOfBoundsException("Requested column: " + r100 + ", # of columns: " + this.columnCount);
    }

    public void addRow(Iterable<?> r100) {
        int r101 = this.rowCount;
        int r102 = this.columnCount;
        int r103 = r101 * r102;
        int r104 = r102 + r103;
        ensureCapacity(r104);
        if ((r100 instanceof ArrayList) == false) goto L6;
        addRow((ArrayList) r100, r103);
        return;
    L6:
        Object[] r105 = this.data;
        Iterator<?> r106 = r100.iterator();
    L8:
        if (r106.hasNext() == false) goto L14;
        Object r107 = r106.next();
        if (r103 == r104) goto L13;
        r105[r103] = r107;
        r103 = r103 + 1;
        goto L8
    L13:
        throw new IllegalArgumentException("columnValues.size() > columnNames.length");
    L14:
        if (r103 != r104) goto L18;
        this.rowCount++;
        return;
    L18:
        throw new IllegalArgumentException("columnValues.size() < columnNames.length");
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public double getDouble(int r100) {
        Object r101 = get(r100);
        if (r101 != null) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        if ((r101 instanceof Number) == false) goto L11;
        return ((Number) r101).doubleValue();
    L11:
        return CastDoubleProtector.parseDouble(r101.toString());
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public float getFloat(int r100) {
        Object r101 = get(r100);
        if (r101 != null) goto L7;
        return 0.0f;
    L7:
        if ((r101 instanceof Number) == false) goto L11;
        return ((Number) r101).floatValue();
    L11:
        return CastFloatProtector.parseFloat(r101.toString());
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getInt(int r100) {
        Object r101 = get(r100);
        if (r101 != null) goto L7;
        return 0;
    L7:
        if ((r101 instanceof Number) == false) goto L11;
        return ((Number) r101).intValue();
    L11:
        return CastIntegerProtector.parseInt(r101.toString());
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public long getLong(int r100) {
        Object r101 = get(r100);
        if (r101 != null) goto L7;
        return 0;
    L7:
        if ((r101 instanceof Number) == false) goto L11;
        return ((Number) r101).longValue();
    L11:
        return CastLongProtector.parseLong(r101.toString());
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public short getShort(int r100) {
        Object r101 = get(r100);
        if (r101 != null) goto L7;
        return 0;
    L7:
        if ((r101 instanceof Number) == false) goto L11;
        return ((Number) r101).shortValue();
    L11:
        return CastShortProtector.parseShort(r101.toString());
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String getString(int r100) {
        Object r101 = get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.toString();
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor, net.sqlcipher.Cursor
    public int getType(int r100) {
        return DatabaseUtils.getTypeOfObject(get(r100));
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public boolean isNull(int r100) {
        if (get(r100) != null) goto L5;
        return true;
    L5:
        return false;
    }

    public void addRow(Object[] r100) {
        int r101 = r100.length;
        int r102 = this.columnCount;
        if (r101 != r102) goto L7;
        int r103 = this.rowCount;
        this.rowCount = r103 + 1;
        int r104 = r103 * r102;
        ensureCapacity(r102 + r104);
        System.arraycopy(r100, 0, this.data, r104, this.columnCount);
        return;
    L7:
        throw new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.length = " + r100.length);
    }

    public MatrixCursor(String[] r100, int r101) {
        this.rowCount = 0;
        this.columnNames = r100;
        int r102 = r100.length;
        this.columnCount = r102;
        if (r101 >= 1) goto L5;
        r101 = 1;
    L5:
        this.data = new Object[r102 * r101];
    }

    private void addRow(ArrayList<?> r100, int r101) {
        int r102 = r100.size();
        if (r102 != this.columnCount) goto L9;
        this.rowCount++;
        Object[] r103 = this.data;
        int r104 = 0;
    L5:
        if (r104 >= r102) goto L7;
        r103[r101 + r104] = ListProtector.get(r100, r104);
        r104 = r104 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.size() = " + r102);
    }
}
