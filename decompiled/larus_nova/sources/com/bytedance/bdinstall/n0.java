package com.bytedance.bdinstall;

import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f199720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f199721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f199722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f199723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f199724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f199725f;

    public final String toString() {
        return "{d='" + this.f199720a + "', i='" + this.f199721b + "', o='" + this.f199722c + "', c='" + this.f199723d + "', s='" + this.f199724e + "', eDid='null', eIid='null', e='" + this.f199725f + "'}";
    }

    public n0() {
        this.f199720a = "";
        this.f199721b = "";
    }

    public final n0 a() {
        return (n0) super.clone();
    L4:
        e = move-exception;
        t.c("clone error", e);
        return null;
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    public static n0 b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return null;
    L10:
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L7
        n0 r102 = new n0();     // Catch: JSONException -> L7
        r102.f199720a = r101.optString(com.bytedance.android.ec.core.event.a.KEY_DID, "");     // Catch: JSONException -> L7
        r102.f199721b = r101.optString(WsConstants.KEY_INSTALL_ID, "");     // Catch: JSONException -> L7
        r102.f199722c = r101.optString("openudid", "");     // Catch: JSONException -> L7
        r102.f199723d = r101.optString("cliend_udid", "");     // Catch: JSONException -> L7
        r102.f199724e = r101.optString("ssid", "");     // Catch: JSONException -> L7
        r102.f199724e = r101.optString("eDid", "");     // Catch: JSONException -> L7
        r102.f199724e = r101.optString("eIid", "");     // Catch: JSONException -> L7
        r102.f199725f = r101.optString("egdi", "");     // Catch: JSONException -> L7
        t.a("aaa# parse install info " + r102);     // Catch: JSONException -> L7
        return r102;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
