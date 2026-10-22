package com.ss.ttvideoengine;

import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public interface VideoEngineGetInfoListener {
    public static final int GET_INFO_KEY_APP_VV_TRACKING = 4;
    public static final int GET_INFO_KEY_BEFORE_PLAY = 6;
    public static final int GET_INFO_KEY_BEFORE_PREPARE = 5;
    public static final int GET_INFO_KEY_FORE_BACK_SWITCH_LIST = 2;
    public static final int GET_INFO_KEY_IS_BACKGROUND = 1;
    public static final int GET_INFO_KEY_LAST_FOREBACK_SWITCH_TIME = 3;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.VideoEngineGetInfoListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Object $default$getInfo(VideoEngineGetInfoListener r100, int r101) {
            return null;
        }

        public static Map $default$getInfoMap(VideoEngineGetInfoListener r100, int r101) {
            return null;
        }
    }

    Object getInfo(int r100);

    Map<String, Object> getInfoMap(int r100);
}
