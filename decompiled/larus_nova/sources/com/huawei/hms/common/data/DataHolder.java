package com.huawei.hms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.common.sqlite.HMSCursorWrapper;
import com.huawei.hms.support.log.HMSLog;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    private static final Builder BUILDER = null;
    public static final Parcelable.Creator<DataHolder> CREATOR = null;
    private static final String TAG = "DataHolder";
    public static final String TYPE_BOOLEAN = "type_boolean";
    public static final String TYPE_BYTE_ARRAY = "type_byte_array";
    public static final String TYPE_DOUBLE = "type_double";
    public static final String TYPE_FLOAT = "type_float";
    public static final String TYPE_INT = "type_int";
    public static final String TYPE_LONG = "type_long";
    public static final String TYPE_STRING = "type_string";
    private String[] columns;
    private Bundle columnsBundle;
    private CursorWindow[] cursorWindows;
    private int dataCount;
    private boolean isInstance;
    private boolean mClosed;
    private Bundle metadata;
    private int[] perCursorCounts;
    private int statusCode;
    private int version;

    /* JADX INFO: renamed from: com.huawei.hms.common.data.DataHolder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String[] f277058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<HashMap<String, Object>> f277059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f277060c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final HashMap<Object, Integer> f277061d;

        public static /* synthetic */ String[] a(Builder r100) {
            return r100.f277058a;
        }

        public static /* synthetic */ ArrayList b(Builder r100) {
            return r100.f277059b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public DataHolder build(int r100) {
            return new DataHolder(this, r100, null, 0 == true ? 1 : 0);
        }

        public Builder setDataForContentValuesHashMap(HashMap<String, Object> r100) {
            Preconditions.checkNotNull(r100, "contentValuesHashMap cannot be null");
            String r101 = this.f277060c;
            if (r101 == null) goto L10;
            Object r102 = r100.get(r101);
            if (r102 == null) goto L10;
            Integer r103 = this.f277061d.get(r102);
            if (r103 == null) goto L9;
            int r104 = r103.intValue();
            boolean r105 = true;
        L11:
            if (r105 == false) goto L13;
            ListProtector.remove(this.f277059b, r104);
            ListProtector.add(this.f277059b, r104, r100);
        L14:
            return this;
        L13:
            this.f277059b.add(r100);
            goto L14
        L9:
            this.f277061d.put(r102, Integer.valueOf(this.f277059b.size()));
        L10:
            r104 = 0;
            r105 = false;
            goto L11
        }

        public Builder withRow(ContentValues r100) {
            Preconditions.checkNotNull(r100, "contentValues cannot be null");
            HashMap<String, Object> r101 = new HashMap(r100.size());
            Iterator<Map.Entry<String, Object>> r102 = r100.valueSet().iterator();
        L4:
            if (r102.hasNext() == false) goto L7;
            Map.Entry<String, Object> r103 = r102.next();
            r101.put(r103.getKey(), r103.getValue());
            goto L4
        L7:
            return setDataForContentValuesHashMap(r101);
        }

        private Builder(String[] r100, String r101) {
            Preconditions.checkNotNull(r100, "builderColumnsP cannot be null");
            this.f277058a = r100;
            this.f277059b = new ArrayList();
            this.f277060c = r101;
            this.f277061d = new HashMap();
        }

        public DataHolder build(int r100, Bundle r101) {
            return new DataHolder(this, r100, r101, -1, null);
        }

        public Builder(String[] r100, String r101, DataHolderBuilderCreator r102) {
            this(r100, null);
        }

        public /* synthetic */ Builder(String[] r100, String r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public static class DataHolderException extends RuntimeException {
        public DataHolderException(String r100) {
            super(r100);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mClosed == true) goto L9;
        CursorWindow[] r100 = this.cursorWindows;     // Catch: Throwable -> L11
        int r101 = r100.length;     // Catch: Throwable -> L11
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L8;
        r100[r102].close();     // Catch: Throwable -> L11
        r102 = r102 + 1;     // Catch: Throwable -> L11
        goto L6
    L8:
        this.mClosed = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
    }

    public final synchronized boolean isClosed() {
        monitor-enter(this);
        boolean r100 = this.mClosed;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        CREATOR = new DataHolderCreator();
        BUILDER = new DataHolderBuilderCreator(new String[0], null);
    }

    public final void collectColumsAndCount() {
        this.columnsBundle = new Bundle();
        String[] r100 = this.columns;
        int r101 = 0;
        if (r100 != null) goto L5;
    L24:
        this.dataCount = 0;
        return;
    L5:
        if (r100.length == 0) goto L24;
        int r102 = 0;
    L8:
        String[] r103 = this.columns;
        if (r102 >= r103.length) goto L11;
        this.columnsBundle.putInt(r103[r102], r102);
        r102 = r102 + 1;
        goto L8
    L11:
        CursorWindow[] r104 = this.cursorWindows;
        if (r104 != null) goto L14;
    L22:
        this.dataCount = 0;
        return;
    L14:
        if (r104.length == 0) goto L22;
        this.perCursorCounts = new int[r104.length];
        int r105 = 0;
    L17:
        CursorWindow[] r106 = this.cursorWindows;
        if (r101 >= r106.length) goto L20;
        this.perCursorCounts[r101] = r105;
        r105 = r106[r101].getStartPosition() + this.cursorWindows[r101].getNumRows();
        r101 = r101 + 1;
        goto L17
    L20:
        this.dataCount = r105;
    }

    public final void finalize() throws Throwable {
        if (this.isInstance == true) goto L5;
    L9:
        super.finalize();
        return;
    L5:
        if (this.cursorWindows.length <= 0) goto L9;
        if (isClosed() == true) goto L9;
        close();
        goto L9
    }

    public final int getCount() {
        return this.dataCount;
    }

    public final Bundle getMetadata() {
        return this.metadata;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder builder(String[] r100) {
        return new Builder(r100, null, 0 == true ? 1 : 0);
    }

    public static DataHolder empty(int r100) {
        return new DataHolder(BUILDER, r100, null);
    }

    private static CursorWindow[] getCursorWindows(HMSCursorWrapper r100) {
        ArrayList r101 = new ArrayList();
        int r102 = r100.getCount();     // Catch: Throwable -> L12
        CursorWindow r103 = r100.getWindow();     // Catch: Throwable -> L12
        if (r103 != null) goto L6;
    L8:
        int r104 = 0;
    L9:
        r101.addAll(iterCursorWrapper(r100, r104, r102));     // Catch: Throwable -> L12
        CursorWindow[] r105 = (CursorWindow[]) r101.toArray(new CursorWindow[r101.size()]);     // Catch: Throwable -> L12
        r100.close();
        return r105;
    L6:
        if (r103.getStartPosition() != 0) goto L8;
        r103.acquireReference();     // Catch: Throwable -> L12
        r100.setWindow(null);     // Catch: Throwable -> L12
        r101.add(r103);     // Catch: Throwable -> L12
        r104 = r103.getNumRows();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        HMSLog.e(TAG, "fail to getCursorWindows: " + th.getMessage());     // Catch: Throwable -> L16
        CursorWindow[] r106 = new CursorWindow[0];     // Catch: Throwable -> L16
        r100.close();
        return r106;
    L16:
        th = move-exception;
        r100.close();
        throw th;
    }

    public final int getWindowIndex(int r100) {
        int r101 = 0;
        if (r100 < 0) goto L5;
    L8:
        boolean r102 = true;
    L9:
        Preconditions.checkArgument(r102, "rowIndex is out of index:" + r100);
    L10:
        int[] r103 = this.perCursorCounts;
        if (r101 >= r103.length) goto L17;
        if (r100 < r103[r101]) goto L14;
        r101 = r101 + 1;
        goto L10
    L14:
        r101 = r101 - 1;
    L17:
        if (r101 == r103.length) goto L19;
        return r101;
    L19:
        return r101 - 1;
    L5:
        if (r100 < this.dataCount) goto L8;
        r102 = false;
        goto L9
    }

    public final boolean hasColumn(String r100) {
        return this.columnsBundle.containsKey(r100);
    }

    private void checkAvailable(String r100, int r101) {
        Bundle r102 = this.columnsBundle;
        if (r102 != null) goto L5;
    L16:
        String r103 = "cannot find column: " + r100;
    L17:
        Preconditions.checkArgument(r103.isEmpty(), r103);
        return;
    L5:
        if (r102.containsKey(r100) == false) goto L16;
        if (isClosed() == false) goto L10;
        r103 = "buffer has been closed";
        goto L17
    L10:
        if (r101 >= 0) goto L12;
    L15:
        r103 = "row is out of index:" + r101;
        goto L17
    L12:
        if (r101 >= this.dataCount) goto L15;
        r103 = "";
        goto L17
    }

    private static CursorWindow[] getCursorWindows(Builder r100, int r101) {
        if (Builder.a(r100).length == 0) goto L5;
        if (r101 >= 0) goto L8;
    L9:
        r101 = Builder.b(r100).size();
    L10:
        ArrayList<CursorWindow> r102 = iterCursorWindow(r100, r101, Builder.b(r100).subList(0, r101));
        return (CursorWindow[]) r102.toArray(new CursorWindow[r102.size()]);
    L8:
        if (r101 < Builder.b(r100).size()) goto L10;
    L5:
        return new CursorWindow[0];
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r102 = SafeParcelWriter.beginObjectHeader(r100);
        SafeParcelWriter.writeStringArray(r100, 1, this.columns, false);
        SafeParcelWriter.writeTypedArray(r100, 2, this.cursorWindows, r101, false);
        SafeParcelWriter.writeInt(r100, 3, getStatusCode());
        SafeParcelWriter.writeBundle(r100, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(r100, 1000, this.version);
        SafeParcelWriter.finishObjectHeader(r100, r102);
        if ((r101 & 1) == 0) goto L8;
        close();
        return;
    }

    private DataHolder(Builder r100, int r101, Bundle r102) {
        this(Builder.a(r100), getCursorWindows(r100, -1), r101, null);
    }

    private static ArrayList<CursorWindow> iterCursorWindow(Builder r110, int r111, List r112) {
        ArrayList<CursorWindow> r100 = new ArrayList();
        CursorWindow r101 = new CursorWindow(null);
        r101.setNumColumns(Builder.a(r110).length);
        r100.add(r101);
        int r102 = 0;
    L3:
        if (r102 >= r111) goto L30;
    L23:
        CursorWindow r103 = r101;
    L24:
        Iterator<CursorWindow> r104 = r100.iterator();
    L26:
        if (r104.hasNext() == false) goto L28;
        r104.next().close();
        goto L26
    L28:
        HMSLog.w(TAG, "iter CursorWindow failed, RuntimeException occured.");
        r101 = r103;
    L29:
        r102 = r102 + 1;
        goto L3
    L5:
        if (r101.allocRow() == true) goto L13;
        HMSLog.d(TAG, "Failed to allocate a row");     // Catch: RuntimeException -> L23
        r103 = new CursorWindow(null);     // Catch: RuntimeException -> L23
        r103.setStartPosition(r102);     // Catch: RuntimeException -> L31
        r103.setNumColumns(Builder.a(r110).length);     // Catch: RuntimeException -> L31
        if (r103.allocRow() == true) goto L11;
        HMSLog.e(TAG, "Failed to retry to allocate a row");     // Catch: RuntimeException -> L31
        return r100;
    L11:
        r100.add(r103);     // Catch: RuntimeException -> L31
        r101 = r103;
    L13:
        HashMap r105 = (HashMap) ListProtector.get(r112, r102);     // Catch: RuntimeException -> L23
        boolean r106 = true;
        int r107 = 0;
    L15:
        if (r107 >= Builder.a(r110).length) goto L20;
        r106 = putValue(r101, r105.get(Builder.a(r110)[r107]), r102, r107);     // Catch: RuntimeException -> L23
        if (r106 == false) goto L20;
        r107 = r107 + 1;     // Catch: RuntimeException -> L23
    L20:
        if (r106 == true) goto L29;
        HMSLog.d(TAG, "fail to put data for row " + r102);     // Catch: RuntimeException -> L23
        r101.freeLastRow();     // Catch: RuntimeException -> L23
        CursorWindow r108 = new CursorWindow(null);     // Catch: RuntimeException -> L23
        r108.setStartPosition(r102);     // Catch: RuntimeException -> L23
        r108.setNumColumns(Builder.a(r110).length);     // Catch: RuntimeException -> L23
        r100.add(r108);     // Catch: RuntimeException -> L23
    L30:
        return r100;
    }

    private static ArrayList<CursorWindow> iterCursorWrapper(HMSCursorWrapper r100, int r101, int r102) {
        ArrayList<CursorWindow> r103 = new ArrayList();
    L3:
        if (r101 >= r102) goto L14;
        if (r100.moveToPosition(r101) == false) goto L14;
        CursorWindow r104 = r100.getWindow();
        if (r104 != null) goto L9;
        r104 = new CursorWindow(null);
        r104.setStartPosition(r101);
        r100.fillWindow(r101, r104);
    L11:
        if (r104.getNumRows() == 0) goto L14;
        r103.add(r104);
        r101 = r104.getNumRows() + r104.getStartPosition();
        goto L3
    L9:
        r104.acquireReference();
        r100.setWindow(null);
    L14:
        return r103;
    }

    public final boolean hasNull(String r100, int r101, int r102) {
        checkAvailable(r100, r101);
        if (this.cursorWindows[r102].getType(r101, this.columnsBundle.getInt(r100)) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private DataHolder(HMSCursorWrapper r100, int r101, Bundle r102) {
        this(r100.getColumnNames(), getCursorWindows(r100), r101, r102);
    }

    public DataHolder(Cursor r100, int r101, Bundle r102) {
        this(new HMSCursorWrapper(r100), r101, r102);
    }

    public DataHolder(String[] r100, CursorWindow[] r101, int r102, Bundle r103) {
        Preconditions.checkNotNull(r100, "columnsP cannot be null");
        Preconditions.checkNotNull(r101, "cursorWindowP cannot be null");
        this.mClosed = false;
        this.isInstance = true;
        this.version = 1;
        this.columns = r100;
        this.cursorWindows = r101;
        this.statusCode = r102;
        this.metadata = r103;
        collectColumsAndCount();
    }

    private static boolean putValue(CursorWindow r100, Object r101, int r102, int r103) throws IllegalArgumentException {
        if (r101 != null) goto L6;
        return r100.putNull(r102, r103);
    L6:
        if ((r101 instanceof Boolean) == false) goto L14;
        if (((Boolean) r101).booleanValue() == false) goto L10;
        long r104 = 1;
    L12:
        return r100.putLong(r104, r102, r103);
    L10:
        r104 = 0;
        goto L12
    L14:
        if ((r101 instanceof Integer) == false) goto L18;
        return r100.putLong(((Integer) r101).intValue(), r102, r103);
    L18:
        if ((r101 instanceof Long) == false) goto L22;
        return r100.putLong(((Long) r101).longValue(), r102, r103);
    L22:
        if ((r101 instanceof Float) == false) goto L26;
        return r100.putDouble(((Float) r101).floatValue(), r102, r103);
    L26:
        if ((r101 instanceof Double) == false) goto L30;
        return r100.putDouble(((Double) r101).doubleValue(), r102, r103);
    L30:
        if ((r101 instanceof String) == false) goto L34;
        return r100.putString((String) r101, r102, r103);
    L34:
        if ((r101 instanceof byte[]) == false) goto L38;
        return r100.putBlob((byte[]) r101, r102, r103);
    L38:
        throw new IllegalArgumentException("unsupported type for column: " + r101);
    }

    public final void copyToBuffer(String r100, int r101, int r102, CharArrayBuffer r103) {
        checkAvailable(r100, r101);
        this.cursorWindows[r102].copyStringToBuffer(r101, this.columnsBundle.getInt(r100), r103);
    }

    public final Object getValue(String r100, int r101, int r102, String r103) {
        r103.getClass();
        boolean r104 = true;
        byte r105 = -1;
        switch(r103.hashCode()) {
            case -1092271849: goto L30;
            case -870070237: goto L26;
            case -675993238: goto L22;
            case 445002870: goto L18;
            case 519136353: goto L14;
            case 878975158: goto L10;
            case 1300508295: goto L6;
            default: goto L33;
        };
    L33:
        switch(r105) {
            case 0: goto L52;
            case 1: goto L46;
            case 2: goto L44;
            case 3: goto L42;
            case 4: goto L40;
            case 5: goto L38;
            case 6: goto L36;
            default: goto L34;
        };
    L34:
        return null;
    L36:
        checkAvailable(r100, r101);
        return this.cursorWindows[r102].getBlob(r101, this.columnsBundle.getInt(r100));
    L38:
        checkAvailable(r100, r101);
        return this.cursorWindows[r102].getString(r101, this.columnsBundle.getInt(r100));
    L40:
        checkAvailable(r100, r101);
        return Long.valueOf(this.cursorWindows[r102].getLong(r101, this.columnsBundle.getInt(r100)));
    L42:
        checkAvailable(r100, r101);
        return Double.valueOf(this.cursorWindows[r102].getDouble(r101, this.columnsBundle.getInt(r100)));
    L44:
        checkAvailable(r100, r101);
        return Integer.valueOf(this.cursorWindows[r102].getInt(r101, this.columnsBundle.getInt(r100)));
    L46:
        checkAvailable(r100, r101);
        if (this.cursorWindows[r102].getLong(r101, this.columnsBundle.getInt(r100)) == 1) goto L51;
        r104 = false;
    L51:
        return Boolean.valueOf(r104);
    L52:
        checkAvailable(r100, r101);
        return Float.valueOf(this.cursorWindows[r102].getFloat(r101, this.columnsBundle.getInt(r100)));
    L6:
        if (r103.equals(TYPE_BYTE_ARRAY) == false) goto L33;
        r105 = 6;
        goto L33
    L10:
        if (r103.equals(TYPE_STRING) == false) goto L33;
        r105 = 5;
        goto L33
    L14:
        if (r103.equals(TYPE_LONG) == false) goto L33;
        r105 = 4;
        goto L33
    L18:
        if (r103.equals(TYPE_DOUBLE) == false) goto L33;
        r105 = 3;
        goto L33
    L22:
        if (r103.equals(TYPE_INT) == false) goto L33;
        r105 = 2;
        goto L33
    L26:
        if (r103.equals(TYPE_BOOLEAN) == false) goto L33;
        r105 = 1;
        goto L33
    L30:
        if (r103.equals(TYPE_FLOAT) == false) goto L33;
        r105 = 0;
        goto L33
    }

    private DataHolder(Builder r100, int r101, Bundle r102, int r103) {
        this(Builder.a(r100), getCursorWindows(r100, -1), r101, r102);
    }

    public /* synthetic */ DataHolder(Builder r100, int r101, Bundle r102, AnonymousClass1 r103) {
        this(r100, r101, r102);
    }

    public DataHolder(int r100, String[] r101, CursorWindow[] r102, int r103, Bundle r104) {
        this.mClosed = false;
        this.isInstance = true;
        this.version = r100;
        this.columns = r101;
        this.cursorWindows = r102;
        this.statusCode = r103;
        this.metadata = r104;
        collectColumsAndCount();
    }

    public /* synthetic */ DataHolder(Builder r100, int r101, Bundle r102, int r103, AnonymousClass1 r104) {
        this(r100, r101, r102, r103);
    }
}
