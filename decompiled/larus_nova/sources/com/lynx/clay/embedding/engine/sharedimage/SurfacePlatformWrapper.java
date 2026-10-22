package com.lynx.clay.embedding.engine.sharedimage;

import android.graphics.SurfaceTexture;
import android.view.Surface;

/* JADX INFO: loaded from: classes32.dex */
class SurfacePlatformWrapper {
    public SurfacePlatformWrapper() {
    }

    private static Surface createSurface(SurfaceTexture r100) {
        return new Surface(r100);
    }

    private static void releaseSurface(Surface r100) {
        r100.release();
    }

    private static boolean surfaceIsValid(Surface r100) {
        return r100.isValid();
    }
}
