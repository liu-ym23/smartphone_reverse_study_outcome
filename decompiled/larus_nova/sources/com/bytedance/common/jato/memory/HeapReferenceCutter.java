package com.bytedance.common.jato.memory;

/* JADX INFO: loaded from: classes15.dex */
public class HeapReferenceCutter {
    public HeapReferenceCutter() {
    }

    private static native void nCutReference(Object[] r100);

    private static native void nReplaceReference(Object[] r100, Object[] r101, boolean r102);
}
