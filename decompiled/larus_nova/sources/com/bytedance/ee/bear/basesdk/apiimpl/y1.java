package com.bytedance.ee.bear.basesdk.apiimpl;

import com.bytedance.ee.bear.lark.NewerOnboardingBannerAbTestExperiment;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class y1 implements pn4.h {
    public y1() {
    }

    @Override // pn4.h
    public final List<iua.a> a() {
        ArrayList r100 = new ArrayList();
        r100.add(new NewerOnboardingBannerAbTestExperiment());
        r100.add(new t25.c());
        r100.add(new t25.b());
        r100.add(new t25.a());
        r100.add(new t25.e());
        r100.add(new im5.c());
        r100.add(new im5.a());
        r100.add(new com.bytedance.ee.bear.document.ssrrender.c());
        int r101 = co4.a.f24616a;
        ArrayList r102 = new ArrayList();
        r102.add(new au4.a());
        r100.addAll(r102);
        r100.addAll(o25.a.a());
        r100.add(new p25.e());
        return r100;
    }
}
