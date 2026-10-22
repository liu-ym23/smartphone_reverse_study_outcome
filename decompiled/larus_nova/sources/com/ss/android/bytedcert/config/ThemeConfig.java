package com.ss.android.bytedcert.config;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes34.dex */
public interface ThemeConfig {
    public static final String NAV_BAR_COLOR = "NAV_BAR_COLOR";
    public static final String PROGRESS_BG_COLOR = "PROGRESS_BG_COLOR";
    public static final String PROGRESS_COLOR = "PROGRESS_COLOR";
    public static final String PROGRESS_GAP = "PROGRESS_GAP";
    public static final String PROGRESS_WIDTH = "PROGRESS_WIDTH";
    public static final String RETURN_STYPE = "RETURN_STYPE";
    public static final String SCREEN_COLOR = "SCREEN_COLOR";
    public static final String SDK_INIT_LOADING = "SDK_INIT_LOADING";
    public static final String TEXT_COLOR = "TEXT_COLOR";
    public static final String TEXT_SIZE = "TEXT_SIZE";
    public static final ThemeConfig THEME_CONFIG = null;
    public static final String WEB_THEME_MODE = "WEB_THEME_MODE";

    Drawable faceLiveBackImage();

    int faceLiveNavBarColor();

    int faceLiveProgressBgColor();

    int faceLiveProgressColor();

    float faceLiveProgressGap();

    float faceLiveProgressWidth();

    int faceLiveScreenBgColor();

    int faceLiveTextColor();

    float faceLiveTextSize();

    int getBeautyIntensity();

    boolean isFaceLiveBack();

    boolean isInitNeedLoading();

    boolean isWebDarkMode();

    void setBeautyIntensity(int r100);

    static {
        THEME_CONFIG = new ThemeConfigAdapter();
    }
}
