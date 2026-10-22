package com.lynx.canvas.callback;

/* JADX INFO: loaded from: classes32.dex */
public class RenderFrameCallbackWrapper implements RenderFrameCallback {
    private final RenderFrameCallback mCallback;

    public RenderFrameCallbackWrapper(RenderFrameCallback r100) {
        this.mCallback = r100;
    }

    @Override // com.lynx.canvas.callback.RenderFrameCallback
    public void onFrameRender(String r100, long r101, long r110) {
        this.mCallback.onFrameRender(r100, r101, r110);
    }
}
