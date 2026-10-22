package com.ss.mediakit.net;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public abstract class AVMDLNetClient {
    public static final int METHOD_GET = 0;
    public static final int METHOD_POST = 1;

    public interface CompletionListener {
        void onCompletion(JSONObject r100, Error r101);
    }

    public AVMDLNetClient() {
    }

    public void cancel() {
    }

    public void startTask(String r100, CompletionListener r101) {
    }

    public void startTask(String r100, Map<String, String> r101, CompletionListener r102) {
    }

    public void startTask(String r100, Map<String, String> r101, JSONObject r102, int r103, CompletionListener r104) {
    }
}
