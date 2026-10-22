package com.ss.android.ttve.nativePort;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes38.dex */
public class TEBundle {
    private static final int POOL_SIZE = 8;
    private static final String TAG = "TEBundle";
    private static final Object sPoolSync = null;
    private static Queue<TEBundle> sPools;
    private long mHandle;

    private native long nativeCreate();

    private native boolean nativeGetBool(long r100, String r101);

    private native float nativeGetFloat(long r100, String r101);

    private native int[] nativeGetIntArray(long r100, String r101);

    private native long nativeGetLong(long r100, String r101);

    private native String nativeGetString(long r100, String r101);

    private native String[] nativeGetStringArray(long r100, String r101);

    private static native void nativeRelease(long r100);

    private static native void nativeReleaseAll(long[] r100);

    private native int nativeSetBool(long r100, String r101, boolean r102);

    private native int nativeSetBoolArray(long r100, String r101, boolean[] r102);

    private native int nativeSetByteBuffer(long r100, String r101, ByteBuffer r102);

    private native int nativeSetDouble(long r100, String r101, double r102);

    private native int nativeSetDoubleArray(long r100, String r101, double[] r102);

    private native int nativeSetFloat(long r100, String r101, float r102);

    private native int nativeSetFloatArray(long r100, String r101, float[] r102);

    private native int nativeSetHandle(long r100, String r101, long r102);

    private native int nativeSetInt(long r100, String r101, int r102);

    private native int nativeSetIntArray(long r100, String r101, int[] r102);

    private native int nativeSetLong(long r100, String r101, long r102);

    private native int nativeSetLongArray(long r100, String r101, long[] r102);

    private native int nativeSetString(long r100, String r101, String r102);

    private native int nativeSetStringArray(long r100, String r101, String[] r102);

    static {
        sPools = new ArrayDeque(8);
        sPoolSync = new Object();
        TENativeLibsLoader.loadRecorder();
    }

    public static void cleanAll() {
        Object r100 = sPoolSync;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sPools.isEmpty() == true) goto L10;
        int r101 = sPools.size();     // Catch: Throwable -> L12
        long[] r102 = new long[r101];     // Catch: Throwable -> L12
        int r103 = 0;
    L7:
        if (r103 >= r101) goto L9;
        TEBundle r104 = sPools.poll();     // Catch: Throwable -> L12
        r102[r103] = r104.getHandle();     // Catch: Throwable -> L12
        r104.mHandle = 0;     // Catch: Throwable -> L12
        r103 = r103 + 1;     // Catch: Throwable -> L12
        goto L7
    L9:
        nativeReleaseAll(r102);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
    }

    public static TEBundle obtain() {
        Object r100 = sPoolSync;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sPools.isEmpty() == true) goto L7;
        TEBundle r101 = sPools.poll();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L7:
        r101 = new TEBundle();     // Catch: Throwable -> L10
        goto L8
    }

    public void recycle() {
        Object r100 = sPoolSync;
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sPools.contains(this) == true) goto L7;
        sPools.add(this);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    }

    private TEBundle() {
        this.mHandle = nativeCreate();
    }

    public void finalize() throws Throwable {
        super.finalize();
        long r100 = this.mHandle;
        if (r100 == 0) goto L6;
        nativeRelease(r100);
        return;
    }

    public long getHandle() {
        return this.mHandle;
    }

    public TEBundle(long r100) {
        this.mHandle = r100;
    }

    public boolean getBool(String r100) {
        return nativeGetBool(this.mHandle, r100);
    }

    public float getFloat(String r100) {
        return nativeGetFloat(this.mHandle, r100);
    }

    public int[] getIntArray(String r100) {
        return nativeGetIntArray(this.mHandle, r100);
    }

    public long getLong(String r100) {
        return nativeGetLong(this.mHandle, r100);
    }

    public String getString(String r100) {
        return nativeGetString(this.mHandle, r100);
    }

    public String[] getStringArray(String r100) {
        return nativeGetStringArray(this.mHandle, r100);
    }

    public int setBool(String r100, boolean r101) {
        return nativeSetBool(this.mHandle, r100, r101);
    }

    public int setBooleanArray(String r100, boolean[] r101) {
        return nativeSetBoolArray(this.mHandle, r100, r101);
    }

    public int setByteBuffer(String r100, ByteBuffer r101) {
        return nativeSetByteBuffer(this.mHandle, r100, r101);
    }

    public int setDouble(String r100, double r101) {
        return nativeSetDouble(this.mHandle, r100, r101);
    }

    public int setDoubleArray(String r100, double[] r101) {
        return nativeSetDoubleArray(this.mHandle, r100, r101);
    }

    public int setFloat(String r100, float r101) {
        return nativeSetFloat(this.mHandle, r100, r101);
    }

    public int setFloatArray(String r100, float[] r101) {
        return nativeSetFloatArray(this.mHandle, r100, r101);
    }

    public int setHandle(String r100, long r101) {
        return nativeSetHandle(this.mHandle, r100, r101);
    }

    public int setInt(String r100, int r101) {
        return nativeSetInt(this.mHandle, r100, r101);
    }

    public int setIntArray(String r100, int[] r101) {
        return nativeSetIntArray(this.mHandle, r100, r101);
    }

    public int setLong(String r100, long r101) {
        return nativeSetLong(this.mHandle, r100, r101);
    }

    public int setLongArray(String r100, long[] r101) {
        return nativeSetLongArray(this.mHandle, r100, r101);
    }

    public int setString(String r100, String r101) {
        return nativeSetString(this.mHandle, r100, r101);
    }

    public int setStringArray(String r100, String[] r101) {
        return nativeSetStringArray(this.mHandle, r100, r101);
    }
}
