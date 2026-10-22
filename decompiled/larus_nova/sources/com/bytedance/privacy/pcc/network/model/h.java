package com.bytedance.privacy.pcc.network.model;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/* JADX INFO: loaded from: classes21.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f266708a;

    public h(String r100) {
        this.f266708a = r100;
    }

    public static h a(String r100) throws Exception {
        JsonObject r101 = JsonParser.parseString(r100).getAsJsonObject();
        int r102 = r101.get("code").getAsInt();
        if (r102 != 0) goto L11;
        if (r101.has("log_id") == false) goto L7;
        String r103 = r101.get("log_id").getAsString();
    L9:
        return new h(r103);
    L7:
        r103 = "";
        goto L9
    L11:
        throw new Exception("unexpected server code=" + r102);
    }
}
