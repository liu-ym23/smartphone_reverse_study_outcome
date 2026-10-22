package com.bytedance.sdk.account.impl;

import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f269003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f269004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f269005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f269006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f269007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f269008f;

    public static i0 a(String r100) {
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L8
        String r102 = r101.optString("message");     // Catch: JSONException -> L8
        int r103 = r101.optInt(SpeechEngineDefines.PARAMS_KEY_PROTOCOL_TYPE_INT);     // Catch: JSONException -> L8
        String r104 = r101.optString("log_id");     // Catch: JSONException -> L8
        boolean r105 = r101.optBoolean("degrade");     // Catch: JSONException -> L8
        r101.optBoolean("allow_login");     // Catch: JSONException -> L8
        boolean r106 = r101.optBoolean("kick_new_text_switch");     // Catch: JSONException -> L8
        r101.optString("reason");     // Catch: JSONException -> L8
        JSONObject r107 = r101.optJSONObject("params");     // Catch: JSONException -> L8
        if (r107 == null) goto L5;
        r107.optString(ICEffectKeys.KEY_IS_IC_EFFECT_DEVICE_NAME);     // Catch: JSONException -> L8
        r107.optString(ITwitterService.ResponseConstants.USER_NAME);     // Catch: JSONException -> L8
        long r108 = r107.optLong("user_id");     // Catch: JSONException -> L8
    L6:
        return new i0(r102, r103, r108, r104, r105, r106);
    L5:
        r108 = 0;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public i0(String r100, int r101, long r102, String r103, boolean r104, boolean r105) {
        this.f269003a = r100;
        this.f269004b = r101;
        this.f269005c = r102;
        this.f269006d = r103;
        this.f269007e = r104;
        this.f269008f = r105;
    }
}
