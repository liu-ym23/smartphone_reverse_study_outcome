package com.ss.ttvideoengine.strategrycenter;

import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public interface IStrategyStateSupplier {
    public static final String KEY_INFO_COMMENT = "comment";
    public static final String KEY_INFO_LIKE = "like";
    public static final String KEY_INFO_SHARE = "share";
    public static final String KEY_STREAM_AUDIO = "audio";
    public static final String KEY_STREAM_VIDEO = "video";
    public static final int SELECT_BITRATE_TYPE_PLAY = 1;
    public static final int SELECT_BITRATE_TYPE_PRELOAD = 2;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Map $default$selectBitrate(IStrategyStateSupplier r100, StrategyMediaParam r101) {
            return null;
        }
    }

    double getNetworkSpeed();

    Map<String, Object> mediaInfo(String r100);

    Map<String, Integer> selectBitrate(StrategyMediaParam r100);

    Map<String, Integer> selectBitrate(String r100, int r101);
}
