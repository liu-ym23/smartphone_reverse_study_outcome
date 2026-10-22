package net.sqlcipher;

import android.database.CharArrayBuffer;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes42.dex */
public class CursorWindow extends android.database.CursorWindow implements Parcelable {
    public static final Parcelable.Creator<CursorWindow> CREATOR = null;
    private static CursorWindowAllocation allocation;
    private int mRequiredPos;
    private int mStartPos;
    private long nWindow;

    private native boolean allocRow_native();

    private native void close_native();

    private native char[] copyStringToBuffer_native(int r100, int r101, int r102, CharArrayBuffer r103);

    private native void freeLastRow_native();

    private native byte[] getBlob_native(int r100, int r101);

    private native double getDouble_native(int r100, int r101);

    private native long getLong_native(int r100, int r101);

    private native int getNumRows_native();

    private native String getString_native(int r100, int r101);

    private native int getType_native(int r100, int r101);

    private native boolean isBlob_native(int r100, int r101);

    private native boolean isFloat_native(int r100, int r101);

    private native boolean isInteger_native(int r100, int r101);

    private native boolean isNull_native(int r100, int r101);

    private native boolean isString_native(int r100, int r101);

    private native void native_clear();

    private native IBinder native_getBinder();

    private native void native_init(IBinder r100);

    private native void native_init(boolean r100, long r101, long r102, long r103);

    private native boolean putBlob_native(byte[] r100, int r101, int r102);

    private native boolean putDouble_native(double r100, int r101, int r102);

    private native boolean putLong_native(long r100, int r101, int r102);

    private native boolean putNull_native(int r100, int r101);

    private native boolean putString_native(String r100, int r101, int r102);

    private native boolean setNumColumns_native(int r100);

    @Override // android.database.CursorWindow, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        allocation = new DefaultCursorWindowAllocation();
        CREATOR = new AnonymousClass1();
    }

    @Override // android.database.CursorWindow
    public void finalize() {
        if (this.nWindow != 0) goto L5;
        return;
    L5:
        close_native();
    }

    @Override // android.database.CursorWindow
    public boolean allocRow() {
        acquireReference();
        boolean r100 = allocRow_native();     // Catch: Throwable -> L6
        releaseReference();
        return r100;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow
    public void clear() {
        acquireReference();
        this.mStartPos = 0;     // Catch: Throwable -> L6
        native_clear();     // Catch: Throwable -> L6
        releaseReference();
        return;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow
    public void freeLastRow() {
        acquireReference();
        freeLastRow_native();     // Catch: Throwable -> L6
        releaseReference();
        return;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow
    public int getNumRows() {
        acquireReference();
        int r100 = getNumRows_native();     // Catch: Throwable -> L6
        releaseReference();
        return r100;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow, android.database.sqlite.SQLiteClosable
    public void onAllReferencesReleased() {
        close_native();
        super.onAllReferencesReleased();
    }

    public static CursorWindowAllocation getCursorWindowAllocation() {
        return allocation;
    }

    @Override // android.database.sqlite.SQLiteClosable, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        releaseReference();
    }

    public int getRequiredPosition() {
        return this.mRequiredPos;
    }

    @Override // android.database.CursorWindow
    public int getStartPosition() {
        return this.mStartPos;
    }

    public CursorWindow(boolean r110) {
        super(r110);
        this.mStartPos = 0;
        if (allocation != null) goto L5;
        allocation = new DefaultCursorWindowAllocation();
    L5:
        native_init(r110, allocation.getInitialAllocationSize(), allocation.getGrowthPaddingSize(), allocation.getMaxAllocationSize());
    }

    public static CursorWindow newFromParcel(Parcel r100) {
        return CREATOR.createFromParcel(r100);
    }

    public static void setCursorWindowAllocation(CursorWindowAllocation r100) {
        allocation = r100;
    }

    @Override // android.database.CursorWindow
    public boolean setNumColumns(int r100) {
        acquireReference();
        boolean r101 = setNumColumns_native(r100);     // Catch: Throwable -> L6
        releaseReference();
        return r101;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public void setRequiredPosition(int r100) {
        this.mRequiredPos = r100;
    }

    @Override // android.database.CursorWindow
    public void setStartPosition(int r100) {
        this.mStartPos = r100;
    }

    public CursorWindow(Parcel r100, int r101) {
        super(true);
        IBinder r102 = r100.readStrongBinder();
        this.mStartPos = r100.readInt();
        native_init(r102);
    }

    @Override // android.database.CursorWindow
    public byte[] getBlob(int r100, int r101) {
        acquireReference();
        byte[] r102 = getBlob_native(r100 - this.mStartPos, r101);     // Catch: Throwable -> L6
        releaseReference();
        return r102;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow
    public double getDouble(int r100, int r101) {
        acquireReference();
        double r102 = getDouble_native(r100 - this.mStartPos, r101);     // Catch: Throwable -> L6
        releaseReference();
        return r102;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow
    public float getFloat(int r100, int r101) {
        acquireReference();
        float r102 = (float) getDouble_native(r100 - this.mStartPos, r101);
        releaseReference();
        return r102;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow
    public int getInt(int r100, int r101) {
        acquireReference();
        int r102 = (int) getLong_native(r100 - this.mStartPos, r101);
        releaseReference();
        return r102;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow
    public long getLong(int r100, int r101) {
        acquireReference();
        long r102 = getLong_native(r100 - this.mStartPos, r101);     // Catch: Throwable -> L6
        releaseReference();
        return r102;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow
    public short getShort(int r100, int r101) {
        acquireReference();
        short r102 = (short) getLong_native(r100 - this.mStartPos, r101);
        releaseReference();
        return r102;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow
    public String getString(int r100, int r101) {
        acquireReference();
        String r102 = getString_native(r100 - this.mStartPos, r101);     // Catch: Throwable -> L6
        releaseReference();
        return r102;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow
    public int getType(int r100, int r101) {
        acquireReference();
        int r102 = getType_native(r100 - this.mStartPos, r101);     // Catch: Throwable -> L6
        releaseReference();
        return r102;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow
    public boolean isBlob(int r100, int r101) {
        acquireReference();
        boolean r102 = isBlob_native(r100 - this.mStartPos, r101);     // Catch: Throwable -> L6
        releaseReference();
        return r102;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow
    public boolean isFloat(int r100, int r101) {
        acquireReference();
        boolean r102 = isFloat_native(r100 - this.mStartPos, r101);     // Catch: Throwable -> L6
        releaseReference();
        return r102;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow
    public boolean isLong(int r100, int r101) {
        acquireReference();
        boolean r102 = isInteger_native(r100 - this.mStartPos, r101);     // Catch: Throwable -> L6
        releaseReference();
        return r102;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow
    public boolean isNull(int r100, int r101) {
        acquireReference();
        boolean r102 = isNull_native(r100 - this.mStartPos, r101);     // Catch: Throwable -> L6
        releaseReference();
        return r102;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow
    public boolean isString(int r100, int r101) {
        acquireReference();
        boolean r102 = isString_native(r100 - this.mStartPos, r101);     // Catch: Throwable -> L6
        releaseReference();
        return r102;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow
    public boolean putNull(int r100, int r101) {
        acquireReference();
        boolean r102 = putNull_native(r100 - this.mStartPos, r101);     // Catch: Throwable -> L6
        releaseReference();
        return r102;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeStrongBinder(native_getBinder());
        r100.writeInt(this.mStartPos);
    }

    @Override // android.database.CursorWindow
    public void copyStringToBuffer(int r100, int r101, CharArrayBuffer r102) {
        if (r102 == null) goto L16;
        if (r102.data != null) goto L6;
        r102.data = new char[64];
    L6:
        acquireReference();
        char[] r103 = copyStringToBuffer_native(r100 - this.mStartPos, r101, r102.data.length, r102);     // Catch: Throwable -> L12
        if (r103 == null) goto L10;
        r102.data = r103;     // Catch: Throwable -> L12
    L10:
        releaseReference();
        return;
    L12:
        th = move-exception;
        releaseReference();
        throw th;
    L16:
        throw new IllegalArgumentException("CharArrayBuffer should not be null");
    }

    @Override // android.database.CursorWindow
    public boolean putBlob(byte[] r100, int r101, int r102) {
        acquireReference();
        boolean r103 = putBlob_native(r100, r101 - this.mStartPos, r102);     // Catch: Throwable -> L6
        releaseReference();
        return r103;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow
    public boolean putDouble(double r100, int r101, int r102) {
        acquireReference();
        boolean r103 = putDouble_native(r100, r101 - this.mStartPos, r102);     // Catch: Throwable -> L6
        releaseReference();
        return r103;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow
    public boolean putLong(long r100, int r101, int r102) {
        acquireReference();
        boolean r103 = putLong_native(r100, r101 - this.mStartPos, r102);     // Catch: Throwable -> L6
        releaseReference();
        return r103;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // android.database.CursorWindow
    public boolean putString(String r100, int r101, int r102) {
        acquireReference();
        boolean r103 = putString_native(r100, r101 - this.mStartPos, r102);     // Catch: Throwable -> L6
        releaseReference();
        return r103;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }
}
