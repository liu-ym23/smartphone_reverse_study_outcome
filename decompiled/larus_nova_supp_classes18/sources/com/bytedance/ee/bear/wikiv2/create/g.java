package com.bytedance.ee.bear.wikiv2.create;

import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g {
    static {
    }

    public static SelectCreationMenuConfig a() {
        BenefitStore r0 = ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1();
        boolean r1 = r0.hasBenefit("ccm_create_doc");
        boolean r2 = r0.hasBenefit("ccm_create_base");
        tt5.a.h("WikiCreateSelectConfiguration", "canCreateDocs = " + r1 + ", ccmCanCreateBitable = " + r2);
        j r3 = j.a.a;
        boolean r4 = false;
        if (r3 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        SelectCreationMenuConfig r6 = new SelectCreationMenuConfig();
        r6.a = r5;
        r6.i = true;
        if (yp5.c.a() == false) goto L12;
        if (r1 == false) goto L12;
        boolean r7 = true;
    L13:
        r6.p = r7;
        r6.b = true;
        r6.c = r1;
        r6.e = true;
        if (yp5.c.f() == false) goto L17;
        if (r1 == false) goto L17;
        boolean r8 = true;
    L18:
        r6.l = r8;
        r6.h = r5;
        if (yp5.c.d() == false) goto L22;
        if (r2 == false) goto L22;
        boolean r9 = true;
    L23:
        r6.o = r9;
        r6.k = true;
        r6.f = r5;
        r6.g = r5;
        r6.j = r5;
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("bitable.wiki.hassurvey.enable", false) == false) goto L27;
        if (r2 == false) goto L27;
        r4 = true;
    L27:
        r6.q = r4;
        return r6;
    L22:
        r9 = false;
    L17:
        r8 = false;
    L12:
        r7 = false;
        goto L13
    L5:
        if (r3.getNetworkState().a() != true) goto L7;
        r5 = true;
        goto L8
    }
}
