package com.ss.ttvideoengine;

/* JADX INFO: loaded from: classes34.dex */
public class FeatureManager {
    public static final String ABR = "abr";
    public static final String AUDIO_ONLY = "audio_only";
    public static final String AUDIO_TRACK = "audio_track";
    public static final String BASH = "bash";
    public static final String BVC1 = "bvc1";
    public static final String BYTEVC2 = "bytevc2";
    public static final String DASH = "dash";
    public static final String DOWNLOAD = "download";
    public static final String HTTP_DNS = "http_dns";
    public static final String LITE = "lite";
    public static final String NATIVE_MDL = "native_mdl";
    public static final String NET_SPEED = "net_speed";
    public static final String PCDN = "pcdn";
    public static final String PRELOAD = "preload";
    public static final String STRATEGY_CENTER = "strategy_center";
    public static final String SUBTITLE_MASK = "subtitle_mask";
    public static final String SUPER_RESOLUTION = "super_resolution";
    public static final String VOLUME_BALANCE = "volume_balance";
    public static final String VR_PANORAMA = "vr_panorama";

    public FeatureManager() {
    }

    public static String getModuleName() {
        return "";
    }

    public static boolean hasPermission() {
        return true;
    }

    public static boolean hasPermission(String r100) {
        return true;
    }

    public static boolean isLicenseExpired() {
        return false;
    }
}
