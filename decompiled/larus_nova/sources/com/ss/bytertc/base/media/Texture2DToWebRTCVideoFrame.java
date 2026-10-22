package com.ss.bytertc.base.media;

import android.graphics.Matrix;
import android.os.Handler;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.TextureBufferImpl;
import com.bytedance.realx.video.VideoFrame;
import com.bytedance.realx.video.YuvConverter;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes40.dex */
public class Texture2DToWebRTCVideoFrame {
    boolean isFrameInUse;
    boolean isReleased;
    Handler mHandler;
    Matrix mMat;
    boolean needPendingRelease;
    YuvConverter yuvConverter;

    public static /* synthetic */ void a(Texture2DToWebRTCVideoFrame r100) {
        r100.lambda$releaseFrame$0();
    }

    public static /* synthetic */ void b(Texture2DToWebRTCVideoFrame r100) {
        r100.lambda$release$1();
    }

    public static /* synthetic */ void c(Texture2DToWebRTCVideoFrame r100) {
        r100.releaseFrame();
    }

    private void releaseFrame() {
        this.isFrameInUse = false;
        if (this.needPendingRelease == true) goto L5;
        return;
    L5:
        if (this.isReleased == true) goto L9;
        this.isReleased = true;
        ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new t(this));
        return;
    }

    private /* synthetic */ void lambda$release$1() {
        this.yuvConverter.release();
        ThreadMethodProxy.quit(this.mHandler.getLooper());
    }

    private /* synthetic */ void lambda$releaseFrame$0() {
        this.yuvConverter.release();
        ThreadMethodProxy.quit(this.mHandler.getLooper());
    }

    public void release() {
        if (this.isFrameInUse == false) goto L5;
        this.needPendingRelease = true;
        return;
    L5:
        this.isReleased = true;
        ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new s(this));
    }

    public Texture2DToWebRTCVideoFrame() {
        this.yuvConverter = new YuvConverter();
        this.mHandler = null;
        this.needPendingRelease = false;
        this.isReleased = false;
        this.isFrameInUse = false;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("Texture2DToVideoFrame");
        ThreadMethodProxy.start(r100);
        this.mHandler = new Handler(r100.getLooper());
        this.needPendingRelease = false;
        Matrix r101 = new Matrix();
        this.mMat = r101;
        r101.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f});
    }

    public boolean isFameInUse() {
        return this.isFrameInUse;
    }

    public VideoFrame convertTexture2DToWebRTCVideoFrame(int r110, int r111, int r112) {
        if (this.needPendingRelease == false) goto L5;
        return null;
    L5:
        if (this.isReleased == true) goto L11;
        this.isFrameInUse = true;
        return new VideoFrame(new TextureBufferImpl(r111, r112, VideoFrame.TextureBuffer.Type.RGB, r110, this.mMat, this.mHandler, this.yuvConverter, new u(this)), 0, 0);
    L11:
        return null;
    }
}
