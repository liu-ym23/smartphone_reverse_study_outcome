package com.lynx.canvas;

import android.graphics.SurfaceTexture;

/* JADX INFO: loaded from: classes32.dex */
public interface KryptonCamera {

    public static class Config {
        public static final String RESOLUTION_HIGH = "high";
        public static final String RESOLUTION_LOW = "low";
        public static final String RESOLUTION_MEDIUM = "medium";
        public boolean autoFocus;
        public String extraJson;
        public String faceMode;
        public String resolution;
        public CustomSize size;

        public Config() {
        }
    }

    public static class CustomSize {
        public int height;
        public int width;

        public CustomSize(int r100, int r101) {
            this.width = r100;
            this.height = r101;
        }
    }

    void focus();

    int getHeight();

    int getWidth();

    void pause();

    void play();

    void release();

    boolean requestWithConfig(Config r100);

    void setupPreviewTexture(SurfaceTexture r100);
}
