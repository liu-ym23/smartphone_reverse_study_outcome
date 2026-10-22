package com.ss.android.ad.applinksdk.interceptor.pack;

import com.ss.android.ad.applinksdk.core.d;
import com.ss.android.ad.applinksdk.interceptor.b;
import com.ss.android.ad.applinksdk.model.AppLinkResult;
import ira.e;
import java.util.List;
import jra.c;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements com.ss.android.ad.applinksdk.interceptor.a {
    public a() {
    }

    @Override // com.ss.android.ad.applinksdk.interceptor.a
    public final AppLinkResult intercept(b r100) {
        e r101 = r100.f406370b.f406367c;
        ira.b r102 = r101.f495542a;
        Object r103 = null;
        if (r102 != null) goto L5;
    L8:
        com.ss.android.ad.applinksdk.core.b.c("applink_click", null, r101);
    L9:
        e r104 = r100.f406370b.f406367c;
        d r105 = d.f406360e;
        r105.getClass();
        AppLinkResult.Type.Companion.getClass();
        AppLinkResult.Message.Companion.getClass();
        AppLinkResult r106 = new AppLinkResult(-1, 15);
        if (r106.a() == false) goto L22;
        int r107 = com.ss.android.ad.applinksdk.core.b.f406354a;
        com.ss.android.ad.applinksdk.core.b.f(r100.f406370b.f406367c);
        List<Object> r108 = jra.a.f500155a;
        mra.d.b(new jra.b(r100.f406370b.f406367c), 5000);
        int r109 = c.f500159a;
        e r110 = r100.f406370b.f406367c;
        r105.getClass();
    L21:
        return r106;
    L22:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L14
        Object r112 = Result.m9449constructorimpl(new JSONObject().putOpt("open_fail_message", 15).putOpt("open_url", r100.f406370b.f406366b.f495530f).putOpt("applink_jump_type", Integer.valueOf(r100.f406370b.f406366b.f495535k)));     // Catch: Throwable -> L14
    L17:
        if (Result.m9455isFailureimpl(r112) == true) goto L20;
        r103 = r112;
    L20:
        JSONObject r113 = (JSONObject) r103;
        com.ss.android.ad.applinksdk.core.b.g("bdal_applink_open_fail", r113);
        com.ss.android.ad.applinksdk.core.b.e(false, r100.f406370b.f406367c, r113);
    L14:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L5:
        if (r102.f495505c != true) goto L8;
        if (r102.f495509g != true) goto L9;
        goto L8
    }
}
