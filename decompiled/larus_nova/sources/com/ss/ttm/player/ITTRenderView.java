package com.ss.ttm.player;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.View;

/* JADX INFO: loaded from: classes40.dex */
interface ITTRenderView {

    /* JADX INFO: renamed from: com.ss.ttm.player.ITTRenderView$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$reuse(ITTRenderView r100) {
        }
    }

    public interface RenderCallback {
        void onSurfaceChanged(int r100, int r101);

        void onSurfaceCreated(Surface r100);

        void onSurfaceDestroyed();
    }

    public interface SnapshotCallback {
        void onResult(int r100, Bitmap r101);
    }

    Surface getSurface();

    View getView();

    void reCreateSurface();

    void reuse();

    void setFixedSizeIfNeeded(int r100, int r101);

    void setRenderCallback(RenderCallback r100);

    void snapshotBitmap(boolean r100, SnapshotCallback r101);
}
