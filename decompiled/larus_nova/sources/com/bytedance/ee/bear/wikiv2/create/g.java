package com.bytedance.ee.bear.wikiv2.create;

import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;

/* JADX INFO: loaded from: classes18.dex */
public final class g {
    static {
    }

    public static SelectCreationMenuConfig a() {
        BenefitStore r100 = ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1();
        boolean r101 = r100.hasBenefit("ccm_create_doc");
        boolean r102 = r100.hasBenefit("ccm_create_base");
        tt5.a.h("WikiCreateSelectConfiguration", "canCreateDocs = " + r101 + ", ccmCanCreateBitable = " + r102);
        j r103 = j.a.f217090a;
        boolean r104 = false;
        if (r103 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        SelectCreationMenuConfig r106 = new SelectCreationMenuConfig();
        r106.f216805a = r105;
        r106.f216813i = true;
        if (yp5.c.a() == false) goto L12;
        if (r101 == false) goto L12;
        boolean r107 = true;
    L13:
        r106.f216820p = r107;
        r106.f216806b = true;
        r106.f216807c = r101;
        r106.f216809e = true;
        if (yp5.c.f() == false) goto L17;
        if (r101 == false) goto L17;
        boolean r108 = true;
    L18:
        r106.f216816l = r108;
        r106.f216812h = r105;
        if (yp5.c.d() == false) goto L22;
        if (r102 == false) goto L22;
        boolean r109 = true;
    L23:
        r106.f216819o = r109;
        r106.f216815k = true;
        r106.f216810f = r105;
        r106.f216811g = r105;
        r106.f216814j = r105;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.i("bitable.wiki.hassurvey.enable", false) == false) goto L27;
        if (r102 == false) goto L27;
        r104 = true;
    L27:
        r106.f216821q = r104;
        return r106;
    L22:
        r109 = false;
    L17:
        r108 = false;
    L12:
        r107 = false;
        goto L13
    L5:
        if (r103.getNetworkState().a() != true) goto L7;
        r105 = true;
        goto L8
    }
}
