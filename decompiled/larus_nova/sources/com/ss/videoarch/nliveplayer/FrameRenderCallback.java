package com.ss.videoarch.nliveplayer;

import android.opengl.EGLContext;
import com.ss.texturerender.VideoSurface;
import com.ss.videoarch.liveplayer2.VeLivePlayer;
import com.ss.videoarch.liveplayer2.VeLivePlayerObserver;
import com.ss.videoarch.liveplayer2.VeLivePlayerPixelFormat;
import com.ss.videoarch.liveplayer2.VeLivePlayerVideoBufferType;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes38.dex */
public class FrameRenderCallback implements VideoSurface.FrameRenderCallback {
    private final VeLivePlayerVideoBufferType mBufferType;
    private final WeakReference<VeLivePlayer> mLivePlayer;
    private final WeakReference<VeLivePlayerObserver> mObserver;
    private final VeLivePlayerPixelFormat mPixelFormat;

    @Override // com.ss.texturerender.VideoSurface.FrameRenderCallback
    public int onBytebufferCallbck(int r100, ByteBuffer r101, int r102, int r103, long r104) {
        VeLivePlayer r105 = this.mLivePlayer.get();
        VeLivePlayerObserver r106 = this.mObserver.get();
        if (r105 == null) goto L11;
        if (r106 == null) goto L11;
        if (this.mBufferType != VeLivePlayerVideoBufferType.VeLivePlayerVideoBufferTypeByteArray) goto L10;
        if (r101 == null) goto L10;
        int r107 = r101.remaining();
        r101.get(new byte[r107], 0, r107);
    L10:
        r106.b();
    L11:
        return 0;
    }

    @Override // com.ss.texturerender.VideoSurface.FrameRenderCallback
    public int onTextureCallback(int r100, int r101, int r102, EGLContext r103, int r104, int r105, long r106) {
        VeLivePlayer r107 = this.mLivePlayer.get();
        VeLivePlayerObserver r108 = this.mObserver.get();
        if (r107 == null) goto L9;
        if (r108 == null) goto L10;
        r108.b();
        return 0;
    L10:
        return 0;
    L9:
        return 0;
    }
}
