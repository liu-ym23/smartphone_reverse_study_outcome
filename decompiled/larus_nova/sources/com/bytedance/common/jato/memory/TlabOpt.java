package com.bytedance.common.jato.memory;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes15.dex */
public class TlabOpt {
    private static WeakReference<Object> sGcWatcher;

    public TlabOpt() {
    }

    private static native void nativeDisableExpandTlab();

    private static native void nativeExpandTlab(String[] r100, int[] r101, int r102);
}
