package com.ss.ttvideoengine.net;

import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public abstract class TTVNetClient {
    public static final int METHOD_GET = 0;
    public static final int METHOD_POST = 1;
    private static final String TAG = "TTVNetClient";

    public interface CompletionListener {
        void onCompletion(JSONObject r100, Error r101);
    }

    public interface RawCompletionListener {
        void onCompletion(String r100, Error r101);
    }

    public TTVNetClient() {
    }

    public void cancel() {
        TTVideoEngineLog.e(TAG, "TTVNetClient is a abstract class, imp is null");
    }

    public void startTask(String r100, CompletionListener r101) {
        TTVideoEngineLog.e(TAG, "TTVNetClient is a abstract class, imp is null");
    }

    public void startTask(String r100, Map<String, String> r101, CompletionListener r102) {
        TTVideoEngineLog.e(TAG, "TTVNetClient is a abstract class, imp is null");
    }

    public void startTask(String r100, Map<String, String> r101, JSONObject r102, int r103, CompletionListener r104) {
        TTVideoEngineLog.e(TAG, "TTVNetClient is a abstract class, imp is null");
    }

    public void startTask(String r100, Map<String, String> r101, JSONObject r102, int r103, RawCompletionListener r104) {
        TTVideoEngineLog.e(TAG, "TTVNetClient is a abstract class, imp is null");
    }
}
