package com.larus.account.saas.core.ttaccount;

import b48.g;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class f extends ua7.a<ua7.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b48.b f286298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f286299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x38.b f286300c;

    @Override // ua7.a
    public final void onResponse(ua7.b r110) {
        ua7.c r111 = (ua7.c) r110;
        if (r111 == null) goto L27;
        b48.b r100 = this.f286298a;
        String r101 = this.f286299b;
        x38.b r102 = this.f286300c;
        if (r111.f549249c == false) goto L22;
        com.larus.account.saas.core.internal.a r112 = com.larus.account.saas.core.internal.a.f286235a;
        String r113 = r100.f17595c;
        if (r113 != null) goto L9;
    L15:
        CopyOnWriteArraySet<x38.f> r114 = com.larus.account.saas.core.internal.b.f286237a;
        Intrinsics.checkNotNullParameter(r100, "info");
        Iterator<x38.f> r115 = com.larus.account.saas.core.internal.b.f286237a.iterator();
    L17:
        if (r115.hasNext() == false) goto L19;
        r115.next().a(r101, r100);
        goto L17
    L19:
        if (r102 == null) goto L21;
        r102.b(new g(null));
    L21:
        JSONObject r116 = new JSONObject();
        r116.put("success", 1);
        r116.put("scene", r101);
        SaasTracking.f286464a.reportEvent("doubao_account_logout_result", r116);
        return;
    L9:
        if ((!StringsKt.isBlank(r113)) == true) goto L12;
        r113 = null;
    L12:
        if (r113 == null) goto L15;
        com.larus.account.saas.core.internal.a.f286236b.remove(r113);
        com.larus.account.saas.core.internal.a.c().remove("account_saas_user_info_".concat(r113));
        goto L15
    L22:
        if (r102 == null) goto L24;
        r102.a(new b48.c(r111.f549254h, r111.f549255i));
    L24:
        JSONObject r103 = new JSONObject();
        r103.put("success", 0);
        r103.put("scene", r101);
        r103.put("err_code", String.valueOf(r111.f549254h));
        r103.put(LocationMonitorConst.ERR_MSG, r111.f549256j);
        r103.put("origin_err_code", String.valueOf(r111.f549253g));
        r103.put("origin_err_msg", r111.f549255i);
        SaasTracking.f286464a.reportEvent("doubao_account_logout_result", r103);
        return;
    }

    public f(b48.b r100, String r101, com.larus.account.saas.jsb.core.d r102) {
        this.f286298a = r100;
        this.f286299b = r101;
        this.f286300c = r102;
    }
}
