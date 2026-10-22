package com.ss.videoarch.nliveplayer;

import android.opengl.EGLContext;
import android.view.Surface;
import com.ss.texturerender.VideoSurface;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes38.dex */
public class TextureRenderListener extends VideoSurface.OnErrorListenerExt implements VideoSurface.FrameRenderCallback, VideoSurface.OnDrawFrameListener, VideoSurface.OnExtraSurfaceDrawListener, VideoSurface.SaveFrameCallback, VideoSurface.VQScoreCallback {
    private long mBridgePtr;

    private native void cpp_deleteBridge(long r100);

    private native long cpp_newBridge(long r100);

    private native int cpp_onBytebufferCallback(long r100, int r101, ByteBuffer r102, int r103, int r104, long r105);

    private native void cpp_onDraw(long r100, long r101);

    private native void cpp_onError(long r100, int r101, int r102, String r103);

    private native void cpp_onExtraSurfaceDraw(long r100, Surface r101, long r102);

    private native int cpp_onFrame(long r100, ByteBuffer r101, int r102, int r103);

    private native int cpp_onProcessScore(long r100, float r101, long r102, long r103);

    private native int cpp_onTextureCallback(long r100, int r101, int r102, int r103, EGLContext r104, int r105, int r106, long r107);

    public void finalize() throws Throwable {
    L7:
        e = move-exception;
        LivePlayerLog.b("delete bridge failed, " + e);
    L9:
        super.finalize();
        return;
    L4:
        if (this.mBridgePtr == 0) goto L9;
        LivePlayerLog.a("delete bridge " + this.mBridgePtr);     // Catch: Exception -> L7
        cpp_deleteBridge(this.mBridgePtr);     // Catch: Exception -> L7
        this.mBridgePtr = 0;     // Catch: Exception -> L7
        goto L9
    }

    @Override // com.ss.texturerender.VideoSurface.OnDrawFrameListener
    public void onDraw(long r100) {
        cpp_onDraw(this.mBridgePtr, r100);
    }

    @Override // com.ss.texturerender.VideoSurface.OnExtraSurfaceDrawListener
    public void onExtraSurfaceDraw(Surface r100, long r101) {
        cpp_onExtraSurfaceDraw(this.mBridgePtr, r100, r101);
    }

    @Override // com.ss.texturerender.VideoSurface.OnErrorListenerExt
    public void onError(int r100, int r101, String r102) {
        cpp_onError(this.mBridgePtr, r100, r101, r102);
    }

    @Override // com.ss.texturerender.VideoSurface.SaveFrameCallback
    public int onFrame(ByteBuffer r100, int r101, int r102) {
        return cpp_onFrame(this.mBridgePtr, r100, r101, r102);
    }

    @Override // com.ss.texturerender.VideoSurface.VQScoreCallback
    public int onProcessScore(float r100, long r110, long r111) {
        return cpp_onProcessScore(this.mBridgePtr, r100, r110, r111);
    }

    @Override // com.ss.texturerender.VideoSurface.FrameRenderCallback
    public int onBytebufferCallbck(int r110, ByteBuffer r111, int r112, int r113, long r114) {
        return cpp_onBytebufferCallback(this.mBridgePtr, r110, r111, r112, r113, r114);
    }

    @Override // com.ss.texturerender.VideoSurface.FrameRenderCallback
    public int onTextureCallback(int r110, int r111, int r112, EGLContext r113, int r114, int r115, long r116) {
        return cpp_onTextureCallback(this.mBridgePtr, r110, r111, r112, r113, r114, r115, r116);
    }
}
