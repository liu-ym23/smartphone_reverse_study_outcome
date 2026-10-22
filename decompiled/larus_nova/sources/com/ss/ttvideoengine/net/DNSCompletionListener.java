package com.ss.ttvideoengine.net;

import com.ss.ttvideoengine.utils.Error;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface DNSCompletionListener {
    void onCancelled();

    void onCompletion(JSONObject r100, Error r101);

    void onRetry(Error r100);
}
