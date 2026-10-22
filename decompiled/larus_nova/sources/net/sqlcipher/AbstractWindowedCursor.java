package net.sqlcipher;

import android.database.CharArrayBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes42.dex */
public abstract class AbstractWindowedCursor extends AbstractCursor {
    protected CursorWindow mWindow;

    public boolean hasWindow() {
        if (this.mWindow == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // net.sqlcipher.AbstractCursor
    public void checkPosition() {
        super.checkPosition();
        if (this.mWindow == null) goto L6;
        return;
    L6:
        throw new StaleDataException("Access closed cursor");
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public /* bridge */ /* synthetic */ android.database.CursorWindow getWindow() {
        return getWindow();
    }

    public AbstractWindowedCursor() {
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public CursorWindow getWindow() {
        return this.mWindow;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public byte[] getBlob(int r100) {
        checkPosition();
        HashMap<Long, Map<String, Object>> r101 = this.mUpdatedRows;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (isFieldUpdated(r100) == false) goto L9;
        byte[] r102 = (byte[]) getUpdatedField(r100);     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return this.mWindow.getBlob(this.mPos, r100);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public double getDouble(int r100) {
        checkPosition();
        HashMap<Long, Map<String, Object>> r101 = this.mUpdatedRows;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (isFieldUpdated(r100) == false) goto L9;
        double r102 = ((Number) getUpdatedField(r100)).doubleValue();     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return this.mWindow.getDouble(this.mPos, r100);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public float getFloat(int r100) {
        checkPosition();
        HashMap<Long, Map<String, Object>> r101 = this.mUpdatedRows;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (isFieldUpdated(r100) == false) goto L9;
        float r102 = ((Number) getUpdatedField(r100)).floatValue();     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return this.mWindow.getFloat(this.mPos, r100);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getInt(int r100) {
        checkPosition();
        HashMap<Long, Map<String, Object>> r101 = this.mUpdatedRows;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (isFieldUpdated(r100) == false) goto L9;
        int r102 = ((Number) getUpdatedField(r100)).intValue();     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return this.mWindow.getInt(this.mPos, r100);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public long getLong(int r100) {
        checkPosition();
        HashMap<Long, Map<String, Object>> r101 = this.mUpdatedRows;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (isFieldUpdated(r100) == false) goto L9;
        long r102 = ((Number) getUpdatedField(r100)).longValue();     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return this.mWindow.getLong(this.mPos, r100);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public short getShort(int r100) {
        checkPosition();
        HashMap<Long, Map<String, Object>> r101 = this.mUpdatedRows;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (isFieldUpdated(r100) == false) goto L9;
        short r102 = ((Number) getUpdatedField(r100)).shortValue();     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return this.mWindow.getShort(this.mPos, r100);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String getString(int r100) {
        checkPosition();
        HashMap<Long, Map<String, Object>> r101 = this.mUpdatedRows;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (isFieldUpdated(r100) == false) goto L9;
        String r102 = (String) getUpdatedField(r100);     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return this.mWindow.getString(this.mPos, r100);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor, net.sqlcipher.Cursor
    public int getType(int r100) {
        checkPosition();
        return this.mWindow.getType(this.mPos, r100);
    }

    public boolean isBlob(int r100) {
        checkPosition();
        HashMap<Long, Map<String, Object>> r101 = this.mUpdatedRows;
        monitor-enter(r101);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isFieldUpdated(r100) == false) goto L15;
        Object r102 = getUpdatedField(r100);     // Catch: Throwable -> L18
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L18
        return r103;
    L9:
        if ((r102 instanceof byte[]) == true) goto L12;
        r103 = false;
        goto L13
    L15:
        monitor-exit(r101);     // Catch: Throwable -> L18
        return this.mWindow.isBlob(this.mPos, r100);
    }

    public boolean isFloat(int r100) {
        checkPosition();
        HashMap<Long, Map<String, Object>> r101 = this.mUpdatedRows;
        monitor-enter(r101);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (isFieldUpdated(r100) == false) goto L16;
        Object r102 = getUpdatedField(r100);     // Catch: Throwable -> L19
        if (r102 != null) goto L9;
    L13:
        boolean r103 = false;
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L19
        return r103;
    L9:
        if ((r102 instanceof Float) == false) goto L11;
    L12:
        r103 = true;
        goto L14
    L11:
        if ((r102 instanceof Double) == false) goto L13;
    L16:
        monitor-exit(r101);     // Catch: Throwable -> L19
        return this.mWindow.isFloat(this.mPos, r100);
    }

    public boolean isLong(int r100) {
        checkPosition();
        HashMap<Long, Map<String, Object>> r101 = this.mUpdatedRows;
        monitor-enter(r101);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (isFieldUpdated(r100) == false) goto L16;
        Object r102 = getUpdatedField(r100);     // Catch: Throwable -> L19
        if (r102 != null) goto L9;
    L13:
        boolean r103 = false;
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L19
        return r103;
    L9:
        if ((r102 instanceof Integer) == false) goto L11;
    L12:
        r103 = true;
        goto L14
    L11:
        if ((r102 instanceof Long) == false) goto L13;
    L16:
        monitor-exit(r101);     // Catch: Throwable -> L19
        return this.mWindow.isLong(this.mPos, r100);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public boolean isNull(int r100) {
        checkPosition();
        HashMap<Long, Map<String, Object>> r101 = this.mUpdatedRows;
        monitor-enter(r101);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (isFieldUpdated(r100) == true) goto L7;
        monitor-exit(r101);     // Catch: Throwable -> L15
        return this.mWindow.isNull(this.mPos, r100);
    L7:
        if (getUpdatedField(r100) != null) goto L9;
        boolean r102 = true;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return r102;
    L9:
        r102 = false;
        goto L10
    }

    public boolean isString(int r100) {
        checkPosition();
        HashMap<Long, Map<String, Object>> r101 = this.mUpdatedRows;
        monitor-enter(r101);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isFieldUpdated(r100) == false) goto L15;
        Object r102 = getUpdatedField(r100);     // Catch: Throwable -> L18
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L18
        return r103;
    L9:
        if ((r102 instanceof String) == true) goto L12;
        r103 = false;
        goto L13
    L15:
        monitor-exit(r101);     // Catch: Throwable -> L18
        return this.mWindow.isString(this.mPos, r100);
    }

    public void setWindow(CursorWindow r100) {
        CursorWindow r101 = this.mWindow;
        if (r101 == null) goto L5;
        r101.close();
    L5:
        this.mWindow = r100;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void copyStringToBuffer(int r100, CharArrayBuffer r101) {
        checkPosition();
        HashMap<Long, Map<String, Object>> r102 = this.mUpdatedRows;
        monitor-enter(r102);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (isFieldUpdated(r100) == false) goto L7;
        super.copyStringToBuffer(r100, r101);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L10
        this.mWindow.copyStringToBuffer(this.mPos, r100, r101);
    }
}
