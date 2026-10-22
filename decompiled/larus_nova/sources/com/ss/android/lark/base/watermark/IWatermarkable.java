package com.ss.android.lark.base.watermark;

/* JADX INFO: loaded from: classes34.dex */
public interface IWatermarkable {

    public @interface WatermarkMode {
        public static final int DARK = 1;
        public static final int NORMAL = 0;
    }

    boolean enableGlobalWatermark();

    int getWatermarkMode();
}
