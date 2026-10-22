package com.ss.android.ad.applinksdk.interceptor.url;

import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ad.applinksdk.model.AppLinkResult;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements com.ss.android.ad.applinksdk.interceptor.a {
    public b() {
    }

    @Override // com.ss.android.ad.applinksdk.interceptor.a
    public final AppLinkResult intercept(com.ss.android.ad.applinksdk.interceptor.b r110) {
        String r100 = r110.f406370b.f406366b.f495529e;
        String r101 = UriProtector.parse(r100).getScheme();
        Object r102 = null;
        if (StringsKt.equals$default(r101, "https", false, 2, null) == false) goto L5;
    L9:
        boolean r103 = true;
        if (mra.e.a(r100) == true) goto L53;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L37
        Object r105 = Result.m9449constructorimpl(new JSONObject().putOpt("do_not_handle_url", r100));     // Catch: Throwable -> L37
    L40:
        if (Result.m9455isFailureimpl(r105) == true) goto L43;
        r102 = r105;
    L43:
        com.ss.android.ad.applinksdk.core.b.g("bdal_ruler_not_match", (JSONObject) r102);
        AppLinkResult.Type.Companion.getClass();
        AppLinkResult.Message.Companion.getClass();
        AppLinkResult r106 = new AppLinkResult(-1, 12);
        ira.e r111 = r110.f406370b.f406367c;
        ira.b r107 = r111.f495542a;
        if (r107 != null) goto L46;
    L50:
        return r106;
    L46:
        if (r107.f495506d != true) goto L50;
        com.ss.android.ad.applinksdk.core.a r112 = r111.f495543b;
        if (r112 == null) goto L50;
        r112.onResponse(r106);
    L37:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L40
    L53:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L13
        Object r113 = Result.m9449constructorimpl(new JSONObject().putOpt("open_url", r100).put("cid", r110.f406370b.f406366b.f495526b));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r113) == false) goto L18;
        r113 = null;
    L18:
        com.ss.android.ad.applinksdk.core.b.g("bdal_applink_quick_url_http", (JSONObject) r113);
        if (r100 != null) goto L21;
    L24:
        if (r103 == true) goto L34;
        if (mra.c.a().optInt("enable_change_quick_url", 0) == 0) goto L34;
        if (StringsKt.startsWith$default(r100, "http://hapjs.org/app", false, 2, null) == false) goto L32;
        r110.f406370b.f406366b.f495529e = StringsKt.replace$default(r100, "http://hapjs.org/app", "hap://app", false, 4, null);
        goto L34
    L32:
        r110.f406370b.f406366b.f495529e = StringsKt.replace$default(r100, "https://hapjs.org/app", "hap://app", false, 4, null);
    L34:
        return r110.a();
    L21:
        if (r100.length() == 0) goto L24;
        r103 = false;
    L13:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L5:
        if (StringsKt.equals$default(r101, "http", false, 2, null) == true) goto L9;
        return r110.a();
    }
}
