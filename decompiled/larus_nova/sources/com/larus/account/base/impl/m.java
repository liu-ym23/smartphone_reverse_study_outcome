package com.larus.account.base.impl;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Unit;
import n38.c0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class m implements n38.y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n38.y f286174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f286175b;

    @Override // n38.y
    public final void b(c0 r100) {
        this.f286174a.b(r100);
        com.larus.platform.service.o r101 = com.larus.platform.service.o.f365780a;
        JSONObject r102 = new JSONObject();
        long r103 = this.f286175b;
        r102.put("success", 1);
        r102.put(ChameleonOpenTracker.ParamKey.COST, System.currentTimeMillis() - r103);
        Unit r104 = Unit.INSTANCE;
        r101.reportEvent("get_carrier_result", r102);
    }

    public m(n38.y r100, long r101) {
        this.f286174a = r100;
        this.f286175b = r101;
    }

    @Override // n38.y
    public final void a(String r100, String r101) {
        this.f286174a.a(r100, r101);
        com.larus.platform.service.o r102 = com.larus.platform.service.o.f365780a;
        JSONObject r103 = new JSONObject();
        long r104 = this.f286175b;
        r103.put("success", 0);
        r103.put("error_msg", r101);
        r103.put(ChameleonOpenTracker.ParamKey.COST, System.currentTimeMillis() - r104);
        Unit r105 = Unit.INSTANCE;
        r102.reportEvent("get_carrier_result", r103);
    }
}
