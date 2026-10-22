package com.ss.android.lark.conditional.access.network.model.response;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.security.compliance.infra.util.f;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import m8b.c;

/* JADX INFO: loaded from: classes35.dex */
public final class a {
    public static final c b(DecisionData.Action r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = null;
        Integer r102 = null;
        if (r100.getParams().get("deviceChallenge") != null) goto L40;
    L37:
        m8b.a r103 = null;
        String r104 = null;
        String r105 = null;
    L39:
        return new c(r102, r105, r103, r104);
    L40:
        JsonObject r106 = ((JsonElement) f.a(r100.getParams().get("deviceChallenge"), JsonElement.class)).getAsJsonObject();     // Catch: Exception -> L6
    L8:
        if (r106 == null) goto L37;
        JsonElement r107 = a("challengeType", r106);
        if (r107 == null) goto L12;
        Integer r108 = Integer.valueOf(r107.getAsInt());
    L13:
        JsonElement r109 = a("nonce", r106);
        if (r109 == null) goto L16;
        r105 = r109.getAsString();
    L17:
        JsonElement r110 = a("tokenChallengeCode", r106);
        if (r110 == null) goto L20;
        r101 = r110.getAsString();
    L20:
        JsonElement r111 = a("certInfo", r106);
        if (r111 == null) goto L24;
        String r112 = r111.getAsString();
        if (r112 == null) goto L24;
    L25:
        boolean r113 = false;
        if (r112.length() <= 0) goto L28;
        boolean r114 = true;
    L29:
        if (r114 == true) goto L42;
    L36:
        r103 = new m8b.a(r113);
        r104 = r101;
        r102 = r108;
        goto L39
    L42:
        JsonElement r115 = ((JsonObject) f.a(r112, JsonObject.class)).get("needCertVerify");     // Catch: Exception -> L34
        if (r115 == null) goto L36;
        r113 = r115.getAsBoolean();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        int r116 = ScsLogger.f440428a;
        ScsLogger.e("SecurityPolicy_Action", "parseToDeviceChallenge parse certInfo error! " + ExceptionsKt.stackTraceToString(e));
        goto L36
    L28:
        r114 = false;
    L24:
        r112 = "";
        goto L25
    L16:
        r105 = null;
        goto L17
    L12:
        r108 = null;
    L6:
        e = move-exception;
        int r117 = ScsLogger.f440428a;
        ScsLogger.e("SecurityPolicy_Action", "parseToDeviceChallenge get deviceChallenge error! " + ExceptionsKt.stackTraceToString(e));
        r106 = null;
        goto L8
    }

    public static final JsonElement a(String r100, JsonObject r101) {
        JsonElement r102 = r101.get(r100);     // Catch: Exception -> L5
        if (r102.isJsonPrimitive() == false) goto L11;
        return r102;
    L11:
        return null;
    L5:
        e = move-exception;
        int r103 = ScsLogger.f440428a;
        ScsLogger.c("SecurityPolicy_Action", "parseToDeviceChallenge get " + r100 + " error! " + ExceptionsKt.stackTraceToString(e));
        return null;
    }
}
