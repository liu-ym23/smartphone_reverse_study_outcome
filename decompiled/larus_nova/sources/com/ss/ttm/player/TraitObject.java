package com.ss.ttm.player;

import com.ss.vcbkit.UnExpected;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes40.dex */
public class TraitObject {
    public static final int AVLoadControl = 5;
    public static final int ExtRender = 6;
    public static final int ExtVoice = 1;
    public static final int HLSInfo = 7;
    public static final int Illegal = 0;
    private long mNativeObj;
    private long mRecycleObj;
    private ReleaseNativeTrait mReleaseFunc;
    private final int mType;
    private final int mVersion;

    public interface ReleaseNativeTrait {
        void releaseNativeTrait(long r100);
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface Type {
    }

    private static native void _nativeRelease(long r100);

    private static native void _nativeUnref(long r100);

    private void releaseRecycleObj() {
        long r100 = this.mRecycleObj;
        this.mRecycleObj = 0;
        if (r100 == 0) goto L6;
        _nativeUnref(r100);
        return;
    }

    private long takeNativeObj() {
        long r100 = this.mNativeObj;
        this.mNativeObj = 0;
        return r100;
    }

    public final void release() {
        long r100 = takeNativeObj();
        if (r100 != 0) goto L14;
    L12:
        releaseRecycleObj();
        return;
    L14:
        _nativeRelease(r100);     // Catch: UnsatisfiedLinkError -> L6
    L7:
        if (this.mReleaseFunc == null) goto L9;
        this.mReleaseFunc.releaseNativeTrait(r100);
        goto L12
    L9:
        Throwable r101 = new Throwable("MemLeak");
        if (UnExpected.f458542a == false) goto L12;
        com.bytedance.crash.d.d(r101, "NativeTrait");
        goto L12
    }

    private long getRecycleObj() {
        return this.mRecycleObj;
    }

    public void finalize() {
        release();
    }

    public final int type() {
        return this.mType;
    }

    public final int version() {
        return this.mVersion;
    }

    private void setRecycleObj(long r100) {
        releaseRecycleObj();
        this.mRecycleObj = r100;
    }

    public boolean sameAs(TraitObject r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return equals(r100);
    }

    public final void setReleaseFunc(ReleaseNativeTrait r100) {
        this.mReleaseFunc = r100;
    }

    public TraitObject(int r100, long r101) {
        this.mReleaseFunc = null;
        this.mType = r100;
        this.mVersion = -1;
        this.mNativeObj = r101;
        this.mRecycleObj = 0;
    }

    public TraitObject(int r100, int r101, long r102) {
        this.mReleaseFunc = null;
        this.mType = r100;
        this.mVersion = r101;
        this.mNativeObj = 0;
        this.mRecycleObj = 0;
    }
}
