package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public class YogaConfigJNIFinalizer extends YogaConfigJNIBase {
    public void freeNatives() {
        long r100 = this.mNativePointer;
        if (r100 == 0) goto L6;
        this.mNativePointer = 0;
        YogaNative.jni_YGConfigFreeJNI(r100);
        return;
    }

    public void finalize() throws Throwable {
        freeNatives();     // Catch: Throwable -> L5
        super.finalize();
        return;
    L5:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public YogaConfigJNIFinalizer() {
    }
}
