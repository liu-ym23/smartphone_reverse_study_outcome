package com.bytedance.realx;

import android.view.Surface;

/* JADX INFO: loaded from: classes21.dex */
public class RXVideoSurfaceController {
    private static RXVideoSurfaceController instance;
    private RXSurfaceListener mSurfaceLisener;
    private boolean usePassSurfaceMode;

    public interface RXSurfaceListener {
        void onSurfaceAvailable(Surface r100);
    }

    static {
        instance = new RXVideoSurfaceController();
    }

    private RXVideoSurfaceController() {
        this.usePassSurfaceMode = false;
        this.mSurfaceLisener = null;
    }

    public static RXVideoSurfaceController getInstance() {
        return instance;
    }

    public boolean usePassSurfaceMode() {
        return this.usePassSurfaceMode;
    }

    public void setPassSurfaceMode(boolean r100) {
        this.usePassSurfaceMode = r100;
    }

    public void setSurface(Surface r100) {
        RXSurfaceListener r101 = this.mSurfaceLisener;
        if (r101 == null) goto L6;
        r101.onSurfaceAvailable(r100);
        return;
    }

    public void setSurfaceListener(RXSurfaceListener r100) {
        this.mSurfaceLisener = r100;
    }
}
