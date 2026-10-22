package com.ss.ttm.player;

/* JADX INFO: loaded from: classes40.dex */
public class TTVersion {
    public static final boolean ENABLE_AUDIO_EFFECT = false;
    public static final boolean ENABLE_BORINGSSL = true;
    public static final boolean ENABLE_EXT_LIBYUV = false;
    public static final boolean ENABLE_EXT_SSL = false;
    public static final boolean ENABLE_SHARED_FFMPEG = true;
    public static final int VERSION = 1;
    public static final String VERSION_INFO = "2026-06-02 11:54:26";
    public static final String VERSION_NAME = "2.10.252.850-doubao";

    public TTVersion() {
    }

    public static void saveVersionInfo() {
        TTPlayerConfiger.setValue(15, "2026-06-02 11:54:26");
        TTPlayerConfiger.setValue(13, 1);
        TTPlayerConfiger.setValue(14, "2.10.252.850-doubao");
    }
}
