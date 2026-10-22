package com.ss.ttvideoengine.strategrycenter;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public interface IStrategyEventListener {
    public static final int EVENT_KEY_PLAY_RELATED_PRELOAD_FINISHED = 2012;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.strategrycenter.IStrategyEventListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onCustomEvent(IStrategyEventListener r100, String r101, String r102, JSONObject r103) {
        }

        public static void $default$onEvent(IStrategyEventListener r100, String r101, int r102, int r103, String r104) {
        }
    }

    void onCustomEvent(String r100, String r101, JSONObject r102);

    void onEvent(String r100, int r101, int r102, String r103);
}
