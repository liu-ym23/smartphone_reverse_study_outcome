package com.bytedance.bdinstall;

import android.content.Context;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f199805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o0 f199806b;

    /* JADX INFO: loaded from: classes8.dex */
    public interface a {
    }

    public v0(Context r100) {
        this.f199805a = r100;
    }

    @Override // com.bytedance.bdinstall.e0
    public final void a(n0 r100) {
        if (this.f199806b != null) goto L5;
        return;
    L5:
        r100.getClass();
        JSONObject r101 = new JSONObject();
        r101.put(com.bytedance.android.ec.core.event.a.KEY_DID, r100.f199720a);     // Catch: JSONException -> L8
        r101.put(WsConstants.KEY_INSTALL_ID, r100.f199721b);     // Catch: JSONException -> L8
        r101.put("openudid", r100.f199722c);     // Catch: JSONException -> L8
        r101.put("cliend_udid", r100.f199723d);     // Catch: JSONException -> L8
        r101.put("ssid", r100.f199724e);     // Catch: JSONException -> L8
        r101.put("eDid", null);     // Catch: JSONException -> L8
        r101.put("eIid", null);     // Catch: JSONException -> L8
        r101.put("egdi", r100.f199725f);     // Catch: JSONException -> L8
    L10:
        String r102 = r101.toString();
        if (this.f199806b.O == false) goto L13;
        this.f199805a.getSharedPreferences("ug_install_op_pref", 0).edit().putString("install_info", r102).apply();
    L13:
        a1.a(this.f199805a).c(this.f199806b.a(), "install_info", r102);
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }
}
