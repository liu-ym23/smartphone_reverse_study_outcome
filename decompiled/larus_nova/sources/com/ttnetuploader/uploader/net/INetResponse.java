package com.ttnetuploader.uploader.net;

import com.ttnetuploader.uploader.slice_task.SliceConfig;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public interface INetResponse {
    JSONObject getBodyJson();

    int getCode();

    String getRequestLog();

    Map<String, String> getResponseHeaders();

    SliceConfig getSliceConfig();
}
