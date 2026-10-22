package com.ss.videoarch.liveplayer.model;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f459554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f459555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f459556c;

    public String getVCodec() {
    L7:
        e = move-exception;
        e.printStackTrace();
    L9:
        JSONObject r100 = null;
    L10:
        if (r100 != null) goto L12;
        return null;
    L12:
        if (r100.has("VCodec") == false) goto L20;
        String r101 = r100.optString("VCodec");
        if (TextUtils.isEmpty(r101) == false) goto L16;
        return null;
    L16:
        return r101;
    L20:
        return null;
    L4:
        if (this.f459556c == null) goto L9;
        r100 = new JSONObject(this.f459556c);     // Catch: JSONException -> L7
        goto L10
    }

    public static c build(JSONObject r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new c(r100.optString("main_play_url"), r100.optString("backup_play_url"), r100.optString("SdkParams"));
    }

    public c(String r100, String r101, String r102) {
        this.f459556c = null;
        this.f459554a = r100;
        this.f459555b = r101;
        this.f459556c = r102;
    }
}
