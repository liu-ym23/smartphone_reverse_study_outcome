package com.bytedance.sdk.account.impl;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.ss.android.token.TTTokenMonitor;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class g0 extends va7.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f268996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f268997b;

    @Override // sa7.h
    public final void onSuccess(ua7.b r100) {
        xa7.l r101 = (xa7.l) r100;
        i0 r102 = this.f268997b.f269001c;
        if (r102 == null) goto L9;
        int r103 = r102.f269004b;
        JSONObject r104 = new JSONObject();
        r104.put(SpeechEngineDefines.PARAMS_KEY_PROTOCOL_TYPE_INT, r103);     // Catch: JSONException -> L7
        com.bytedance.sdk.account.monitor.a.a("passport_frontier_message_error", r104);     // Catch: JSONException -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
    L9:
        this.f268997b.c(false, this.f268996a, null);
    }

    public g0(h0 r100, String r101) {
        this.f268997b = r100;
        this.f268996a = r101;
    }

    @Override // sa7.h
    public final void onError(ua7.b r100, int r101) {
        xa7.l r102 = (xa7.l) r100;
        if (r102 != null) goto L5;
    L14:
        if (r102 == null) goto L16;
        String r103 = r102.f549256j;
    L17:
        TTTokenMonitor.k(r101, r103);
        this.f268997b.c(false, this.f268996a, null);
        return;
    L16:
        r103 = "";
        goto L17
    L5:
        if (AppConstants.SESSION_EXPIRED.equalsIgnoreCase(r102.f563091p) == false) goto L14;
        ArrayList r104 = new ArrayList();
        JSONObject r105 = r102.f549259m;
        if (r105 != null) goto L9;
    L13:
        this.f268997b.c(true, this.f268996a, r104);
        return;
    L9:
        if (r105.optJSONObject("data") == null) goto L13;
        String r106 = r102.f549259m.optJSONObject("data").optString("log_id");
        if (TextUtils.isEmpty(r106) == true) goto L13;
        r104.add(new com.ss.android.token.o("X-TT-LOGID", r106));
        goto L13
    }
}
