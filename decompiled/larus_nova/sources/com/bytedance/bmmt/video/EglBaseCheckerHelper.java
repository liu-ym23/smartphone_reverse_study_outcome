package com.bytedance.bmmt.video;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes8.dex */
public class EglBaseCheckerHelper {
    protected static WeakReference<EglBase.EglContextChecker> eglContextChecker;

    public EglBaseCheckerHelper() {
    }

    public static void EglContextDestoryEnd() {
        WeakReference<EglBase.EglContextChecker> r100 = eglContextChecker;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.get() == null) goto L9;
        eglContextChecker.get().EglContextDestoryEnd();
        return;
    }

    public static void EglContextDestoryStart() {
        WeakReference<EglBase.EglContextChecker> r100 = eglContextChecker;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.get() == null) goto L9;
        eglContextChecker.get().EglContextDestoryStart();
        return;
    }

    public static void setEglContextChecker(EglBase.EglContextChecker r100) {
        eglContextChecker = new WeakReference(r100);
    }
}
