package com.bytedance.privacy.pcc.network.model;

import android.util.Base64;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f266699c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f266700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f266701b;

    static {
        f266699c = a.class.getSimpleName();
    }

    public int getType() {
        return this.f266701b;
    }

    public static a a(String r100) throws Exception {
        JsonObject r101 = JsonParser.parseString(r100).getAsJsonObject();
        int r102 = r101.get("code").getAsInt();
        if (r102 != 0) goto L11;
        JsonObject r103 = JsonParser.parseString(new String(Base64.decode(r101.getAsJsonObject("data").get(WsConstants.KEY_PAYLOAD).getAsString(), 8), StandardCharsets.UTF_8)).getAsJsonObject();
        String r104 = f266699c;
        k67.b.e(r104, "ChallengeResponse payload JSON: " + r103);
        String r105 = r103.get("nonce").getAsString();
        if (r103.has("type") == false) goto L7;
        int r106 = r103.get("type").getAsInt();
    L8:
        k67.b.e(r104, "ChallengeResponse parsed: nonce=" + r105 + ", type=" + r106);
        return new a(r105, r106);
    L7:
        r106 = 1;
        goto L8
    L11:
        throw new Exception("unexpected server code=" + r102);
    }

    public a(String r100, int r101) {
        this.f266700a = r100;
        this.f266701b = r101;
    }
}
