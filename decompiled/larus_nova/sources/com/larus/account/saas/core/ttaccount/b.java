package com.larus.account.saas.core.ttaccount;

import com.larus.account.saas.FlowAccountSdk;
import com.larus.account.saas.model.AccountLoginType;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wb7.j;

/* JADX INFO: loaded from: classes24.dex */
public final class b extends yb7.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f286288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f286289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x38.c f286290c;

    public final void b(ua7.e<j> r100) {
        if (this.f286288a == false) goto L6;
        v38.a.a();
    L6:
        if (r100 == null) goto L14;
        j r101 = (j) r100.f549264p;
        if (r101 == null) goto L14;
        com.ss.android.account.d r102 = r101.f559025e;
        if (r102 == null) goto L14;
        if (r102.f541366g != true) goto L14;
        boolean r103 = true;
    L15:
        JSONObject r104 = new JSONObject();
        r104.put("type", "phone_verify_code");
        r104.put("success", 1);
        SaasTracking.f286464a.reportEvent("doubao_account_login_result", r104);
        if (r100 == null) goto L23;
        j r105 = (j) r100.f549264p;
        if (r105 == null) goto L23;
        com.ss.android.account.d r106 = r105.f559025e;
        if (r106 == null) goto L23;
        String r107 = Long.valueOf(r106.f541360a).toString();
        if (r107 == null) goto L23;
    L24:
        CopyOnWriteArraySet<x38.f> r108 = com.larus.account.saas.core.internal.b.f286237a;
        Intrinsics.checkNotNullParameter(r107, "uid");
        Iterator<x38.f> r109 = com.larus.account.saas.core.internal.b.f286237a.iterator();
    L26:
        if (r109.hasNext() == false) goto L28;
        r109.next().d(r107);
        goto L26
    L28:
        this.f286290c.b(new b48.f(Boolean.valueOf(r103), FlowAccountSdk.f().getAccountInfo(), AccountLoginType.SMS, this.f286289b));
        return;
    L23:
        r107 = "";
    L14:
        r103 = false;
        goto L15
    }

    @Override // sa7.h
    public final /* bridge */ /* synthetic */ void onSuccess(ua7.b r100) {
        b((ua7.e) r100);
    }

    public b(boolean r100, com.larus.account.saas.jsb.core.f r101) {
        this.f286288a = r100;
        this.f286289b = "mobile_sms_login_jsb";
        this.f286290c = r101;
    }

    public final void a(ua7.e<j> r100, int r101) {
        if (this.f286288a == false) goto L5;
        v38.a.a();
    L5:
        x38.c r102 = this.f286290c;
        String r103 = null;
        if (r100 == null) goto L8;
        String r104 = r100.f549255i;
    L9:
        String r105 = "";
        if (r104 != null) goto L16;
        if (r100 == null) goto L13;
        r104 = r100.f549256j;
    L14:
        if (r104 != null) goto L16;
        r104 = "";
        goto L16
    L13:
        r104 = null;
    L16:
        r102.a(new b48.c(r101, r104));
        JSONObject r106 = new JSONObject();
        r106.put("type", "phone_verify_code");
        r106.put("success", 0);
        r106.put("err_code", r101);
        if (r100 == null) goto L19;
        r103 = r100.f549255i;
    L19:
        if (r103 == null) goto L22;
        r105 = r103;
    L22:
        r106.put("err_tips", r105);
        SaasTracking.f286464a.reportEvent("doubao_account_login_result", r106);
        return;
    L8:
        r104 = null;
        goto L9
    }

    @Override // sa7.h
    public final /* bridge */ /* synthetic */ void onError(ua7.b r100, int r101) {
        a((ua7.e) r100, r101);
    }
}
