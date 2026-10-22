package com.ss.bduploader.net;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public interface DNSCompletionListener {
    void onCancelled();

    void onCompletion(JSONObject r100, Error r101);

    void onRetry(Error r100);
}
