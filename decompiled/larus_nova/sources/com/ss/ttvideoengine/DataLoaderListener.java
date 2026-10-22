package com.ss.ttvideoengine;

import com.ss.ttvideoengine.utils.DataLoaderCDNLog;
import com.ss.ttvideoengine.utils.Error;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface DataLoaderListener {

    /* JADX INFO: renamed from: com.ss.ttvideoengine.DataLoaderListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onMultiNetworkSwitch(DataLoaderListener r100, String r101, String r102) {
        }

        public static void $default$onStartComplete(DataLoaderListener r100) {
        }
    }

    String apiStringForFetchVideoModel(Map<String, String> r100, String r101, Resolution r102);

    String authStringForFetchVideoModel(String r100, Resolution r101);

    void dataLoaderError(String r100, int r101, Error r102);

    String getCheckSumInfo(String r100);

    HashMap<String, String> getCustomHttpHeaders(String r100);

    boolean loadLibrary(String r100);

    void onLoadProgress(DataLoaderHelper.DataLoaderTaskLoadProgress r100);

    void onLogInfo(int r100, String r101, JSONObject r102);

    void onLogInfoToMonitor(int r100, String r101, JSONObject r102);

    void onMultiNetworkSwitch(String r100, String r101);

    void onNotify(int r100, long r101, long r102, String r103);

    void onNotifyCDNLog(DataLoaderCDNLog r100);

    void onNotifyCDNLog(JSONObject r100);

    void onStartComplete();

    void onTaskProgress(DataLoaderHelper.DataLoaderTaskProgressInfo r100);
}
