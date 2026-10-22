package com.ss.videoarch.strategy;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public interface IAppInfoBundle {

    /* JADX INFO: renamed from: com.ss.videoarch.strategy.IAppInfoBundle$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onStrategyResult(IAppInfoBundle r100, String r101, JSONObject r102) {
        }
    }

    <T> T getAppInfoForKey(String r100, T r101);

    void onStrategyResult(String r100, JSONObject r101);
}
