package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import com.bytedance.ee.bear.contract.setting.OfflineResIntervalConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class b0 implements com.bytedance.ee.bear.doc.resupdate.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f427841a;

    @Override // com.bytedance.ee.bear.doc.resupdate.h
    public final String getDeviceId() {
        return ((epb.a) LarkContext.spiByDwarf(epb.a.class)).getDeviceId();
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.h
    public final boolean isBoe() {
        if (((gpb.a) ApiUtils.getApi(gpb.a.class)).isBoe() == true) goto L7;
        return false;
    L7:
        return true;
    }

    public b0() {
        this.f427841a = eu5.c.b(eu5.b.f474075a);
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.h
    public final long c() {
        long r100 = SettingManager.getInstance().getLong(OfflineResIntervalConfig.class);
        if (r100 != 0) goto L6;
        return 300000;
    L6:
        return r100;
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.h
    public final String d() {
        return jcb.b.c().a("docs_fe_resource_hotfix");
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.h
    public final int getAppId() {
        iva.a.a().getClass();
        return LarkAppContext.inst().appIdInfo().f18218a;
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.h
    public final String b(Context r100) {
        int r101 = com.bytedance.ee.bear.doc.resupdate.c.f218003a;
        return com.bytedance.ee.bear.doc.resupdate.c.a(r100, isBoe());
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.h
    public final boolean isEnable(String r100) {
        return FeatureGatingModule.getFeatureGatingService().isEnable(r100);
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.h
    public final void a(String r100, JSONObject r101) {
        if (this.f427841a == false) goto L5;
        return;
    L5:
        if (isBoe() == true) goto L9;
        com.ss.android.lark.statistics.b.b(r100, r101);
        return;
    }
}
