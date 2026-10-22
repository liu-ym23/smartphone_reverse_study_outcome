package com.larus.common.account.platform.larkauth;

import com.larus.applog.api.IApplog;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class c extends sa7.h<xa7.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i<a09.a> f326128a;

    public c(j r100) {
        this.f326128a = r100;
    }

    @Override // sa7.h
    public final void onSuccess(ua7.b r110) {
        xa7.c r111 = (xa7.c) r110;
        IApplog.Companion r100 = IApplog.f287053a;
        JSONObject r101 = new JSONObject();
        r101.put("success", 1);
        Unit r102 = Unit.INSTANCE;
        r100.reportEvent("lark_auth_act_result", r101);
        if (r111 == null) goto L8;
        JSONObject r103 = r111.f563072z;
        if (r103 == null) goto L8;
        String r104 = r103.optString("access_token");
        if (r104 == null) goto L8;
    L9:
        String r105 = r104;
        if (r111 == null) goto L15;
        JSONObject r106 = r111.f563072z;
        if (r106 == null) goto L15;
        String r107 = r106.optString("auth_scheme");
        if (r107 == null) goto L15;
    L16:
        String r108 = r107;
        if (r111 == null) goto L21;
        JSONObject r112 = r111.f563072z;
        if (r112 == null) goto L21;
        Long r113 = Long.valueOf(r112.optLong("expires_in"));
    L22:
        a09.a r109 = new a09.a(r105, r108, r113, Long.valueOf(System.currentTimeMillis()), null, 36);
        if (this.f326128a.isActive() == false) goto L26;
        this.f326128a.resumeWith(Result.m9449constructorimpl(r109));
        return;
    L26:
        return;
    L21:
        r113 = null;
    L15:
        r107 = "DPoP";
    L8:
        r104 = "";
        goto L9
    }

    @Override // sa7.h
    public final void onError(ua7.b r100, int r110) {
        xa7.c r101 = (xa7.c) r100;
        FLogger.f375446a.e("LarkAuthTokenFetcher", "enterprise account get access token error: " + r110);
        IApplog.Companion r102 = IApplog.f287053a;
        JSONObject r103 = new JSONObject();
        r103.put("success", 0);
        r103.put("error_code", r110);
        Unit r104 = Unit.INSTANCE;
        r102.reportEvent("lark_auth_act_result", r103);
        if (this.f326128a.isActive() == false) goto L6;
        i<a09.a> r105 = this.f326128a;
        Result.Companion r106 = Result.Companion;
        r105.resumeWith(Result.m9449constructorimpl(new a09.a(null, null, null, null, Integer.valueOf(r110), 31)));
        return;
    }
}
