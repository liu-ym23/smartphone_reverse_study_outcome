package com.larus.voicecall.impl.degrade;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.common.apphost.AppHost;
import com.larus.voicecall.impl.degrade.bean.QuotaCtaResult;
import com.larus.voicecall.impl.degrade.bean.QuotaInfo;
import hq9.q3;

/* JADX INFO: loaded from: classes32.dex */
public final class g implements q3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ QuotaInfo f378336a;

    @Override // hq9.q3
    public final void a() {
    }

    @Override // hq9.q3
    public final void b(boolean r100) {
    }

    @Override // hq9.q3
    public final void c() {
        QuotaInfo r100 = this.f378336a;
        if (r100 == null) goto L7;
        QuotaCtaResult r101 = r100.getCtaResult();
        if (r101 == null) goto L7;
        String r102 = r101.getActionUrl();
    L8:
        if (r102 != null) goto L10;
    L13:
        boolean r103 = true;
    L14:
        if (r103 == false) goto L16;
        return;
    L16:
        AppHost.Companion r104 = AppHost.f326268a;
        Context r105 = r104.a().getCurrentActivity();
        if (r105 != null) goto L20;
        r105 = r104.getApplication().getApplicationContext();
    L20:
        SmartRouter.buildRoute(r105, r102).d();
        ICommerceMembershipService.f325827a.getClass();
        ICommerceMembershipService r106 = ICommerceMembershipService.a.a();
        if (r106 == null) goto L24;
        r106.w(r102, null);
        return;
    L24:
        return;
    L10:
        if (r102.length() == 0) goto L13;
        r103 = false;
    L7:
        r102 = null;
        goto L8
    }

    public g(QuotaInfo r100) {
        this.f378336a = r100;
    }
}
