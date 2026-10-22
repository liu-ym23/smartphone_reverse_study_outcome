package com.ss.android.download.api.settings;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class DownLoadConverter {
    public DownLoadConverter() {
    }

    public String from(JSONObject r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.toString();
    }

    /* JADX INFO: renamed from: to, reason: collision with other method in class */
    public JSONObject m8598to(String r100) {
        return new JSONObject(r100);
    L4:
        e = move-exception;
        e.printStackTrace();
        return new JSONObject();
    }

    public /* bridge */ /* synthetic */ String from(Object r100) {
        return from((JSONObject) r100);
    }

    public /* bridge */ /* synthetic */ Object to(String r100) {
        return m8598to(r100);
    }
}
