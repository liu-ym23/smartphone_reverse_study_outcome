package com.bytedance.bmmt;

import android.view.Surface;

/* JADX INFO: loaded from: classes46.dex */
public class VideoSurfaceController {
    private static VideoSurfaceController instance;
    private BmmtSurfaceListener mSurfaceLisener;
    private boolean usePassSurfaceMode;

    public interface BmmtSurfaceListener {
        void onSurfaceAvailable(Surface r100);
    }

    static {
        instance = new VideoSurfaceController();
    }

    private VideoSurfaceController() {
        this.usePassSurfaceMode = false;
        this.mSurfaceLisener = null;
    }

    public static VideoSurfaceController getInstance() {
        return instance;
    }

    public boolean usePassSurfaceMode() {
        return this.usePassSurfaceMode;
    }

    public void setSurface(Surface r100) {
        BmmtSurfaceListener r101 = this.mSurfaceLisener;
        if (r101 == null) goto L6;
        r101.onSurfaceAvailable(r100);
        return;
    }
}
