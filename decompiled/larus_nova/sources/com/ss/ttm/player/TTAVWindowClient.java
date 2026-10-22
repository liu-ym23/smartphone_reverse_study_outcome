package com.ss.ttm.player;

import android.graphics.Bitmap;
import android.view.Surface;

/* JADX INFO: loaded from: classes40.dex */
public interface TTAVWindowClient {

    public interface ExternalInterface {

        /* JADX INFO: renamed from: com.ss.ttm.player.TTAVWindowClient$ExternalInterface$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$snapshotBitmap(ExternalInterface r100, SnapshotListener r101) {
                r101.onResult(-1, null);
            }
        }

        void onNewWindowAvailable(Surface r100);

        void onWindowChanged(int r100, int r101);

        void onWindowDestroyed();

        void snapshotBitmap(SnapshotListener r100);
    }

    public interface SnapshotListener {
        void onResult(int r100, Bitmap r101);
    }

    void bindExternal(ExternalInterface r100);

    void bindMediaClient(MediaPlayerClient r100);

    void setWindowUsage(int r100);

    void snapshotBitmap(boolean r100, SnapshotListener r101);

    void unbindExternal(ExternalInterface r100);

    void unbindMediaClient(MediaPlayerClient r100);

    void updateVideoSize(int r100, int r101);
}
