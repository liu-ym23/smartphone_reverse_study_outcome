package com.ss.videoarch.liveplayer2;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes38.dex */
public interface VeLivePlayerObserver {

    /* JADX INFO: renamed from: com.ss.videoarch.liveplayer2.VeLivePlayerObserver$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onRenderVideoFrame(VeLivePlayerObserver r100, VeLivePlayer r101, c r102) {
        }

        public static void $default$onSnapshotComplete(VeLivePlayerObserver r100, VeLivePlayer r101, Bitmap r102) {
        }
    }

    void a(Bitmap r100);

    void b();
}
