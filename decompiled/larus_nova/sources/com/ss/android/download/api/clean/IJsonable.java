package com.ss.android.download.api.clean;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface IJsonable {
    void parse(JSONObject r100);

    JSONObject toJson();
}
