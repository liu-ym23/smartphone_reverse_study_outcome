package com.bytedance.lynx.webview.glue;

/* JADX INFO: loaded from: classes21.dex */
public class TTRenderProcessGoneDetail {
    private final boolean mDidCrash;
    private final int mRendererPriority;

    public boolean didCrash() {
        return this.mDidCrash;
    }

    public int rendererPriority() {
        return this.mRendererPriority;
    }

    public TTRenderProcessGoneDetail(boolean r100, int r101) {
        this.mDidCrash = r100;
        this.mRendererPriority = r101;
    }
}
