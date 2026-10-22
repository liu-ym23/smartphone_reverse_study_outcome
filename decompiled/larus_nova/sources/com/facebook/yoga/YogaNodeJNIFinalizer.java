package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public class YogaNodeJNIFinalizer extends YogaNodeJNIBase {
    public void freeNatives() {
        long r100 = this.mNativePointer;
        if (r100 == 0) goto L6;
        this.mNativePointer = 0;
        YogaNative.jni_YGNodeFinalizeJNI(r100);
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

    public YogaNodeJNIFinalizer() {
    }

    public YogaNodeJNIFinalizer(YogaConfig r100) {
        super(r100);
    }
}
