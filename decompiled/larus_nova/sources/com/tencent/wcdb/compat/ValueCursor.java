package com.tencent.wcdb.compat;

import android.database.AbstractCursor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.tencent.wcdb.base.Value;
import com.tencent.wcdb.winq.ColumnType;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
class ValueCursor extends AbstractCursor {
    private final String[] mColumnNames;
    private final List<Value[]> mRows;

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getCount() {
        return this.mRows.size();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return this.mColumnNames;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public byte[] getBlob(int r100) {
        return ((Value[]) ListProtector.get(this.mRows, ((AbstractCursor) this).mPos))[r100].getBLOB();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public double getDouble(int r100) {
        return ((Value[]) ListProtector.get(this.mRows, ((AbstractCursor) this).mPos))[r100].getDouble();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public float getFloat(int r100) {
        return (float) ((Value[]) ListProtector.get(this.mRows, ((AbstractCursor) this).mPos))[r100].getDouble();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getInt(int r100) {
        return ((Value[]) ListProtector.get(this.mRows, ((AbstractCursor) this).mPos))[r100].getInt();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public long getLong(int r100) {
        return ((Value[]) ListProtector.get(this.mRows, ((AbstractCursor) this).mPos))[r100].getLong();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public short getShort(int r100) {
        return (short) ((Value[]) ListProtector.get(this.mRows, ((AbstractCursor) this).mPos))[r100].getLong();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String getString(int r100) {
        return ((Value[]) ListProtector.get(this.mRows, ((AbstractCursor) this).mPos))[r100].getText();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getType(int r100) {
        return ((Value[]) ListProtector.get(this.mRows, ((AbstractCursor) this).mPos))[r100].getType().ordinal();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public boolean isNull(int r100) {
        if (((Value[]) ListProtector.get(this.mRows, ((AbstractCursor) this).mPos))[r100].getType() != ColumnType.Null) goto L5;
        return true;
    L5:
        return false;
    }

    public ValueCursor(List<Value[]> r100, String[] r101) {
        this.mRows = r100;
        this.mColumnNames = r101;
    }
}
