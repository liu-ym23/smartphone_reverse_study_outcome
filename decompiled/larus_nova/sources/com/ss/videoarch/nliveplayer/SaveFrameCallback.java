package com.ss.videoarch.nliveplayer;

import android.graphics.Bitmap;
import com.ss.texturerender.VideoSurface;
import com.ss.videoarch.liveplayer2.VeLivePlayer;
import com.ss.videoarch.liveplayer2.VeLivePlayerObserver;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes38.dex */
public class SaveFrameCallback implements VideoSurface.SaveFrameCallback {
    private final WeakReference<VeLivePlayer> mLivePlayer;
    private final WeakReference<VeLivePlayerObserver> mObserver;
    final int mPlayerId;

    @Override // com.ss.texturerender.VideoSurface.SaveFrameCallback
    public int onFrame(ByteBuffer r100, int r101, int r102) {
        LivePlayerLog.c(this.mPlayerId, "snapshot,onFrame:width=" + r101 + ",height=" + r102);
        VeLivePlayer r103 = this.mLivePlayer.get();
        VeLivePlayerObserver r104 = this.mObserver.get();
        if (r103 == null) goto L9;
        if (r104 == null) goto L10;
        Bitmap r105 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);
        r100.rewind();
        r105.copyPixelsFromBuffer(r100);
        r104.a(r105);
        return 0;
    L10:
        return 0;
    L9:
        return 0;
    }
}
