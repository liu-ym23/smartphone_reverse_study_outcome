package com.bytedance.ee.bear.bitable.itemview.util;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class n implements tk5.d<vk5.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OnBoardingData.CustomData f214296a;

    @Override // tk5.d
    public final String getBiz() {
        return DocumentType.BITABLE_NAME;
    }

    @Override // tk5.d
    public final /* synthetic */ String getDependency() {
        return null;
    }

    @Override // tk5.d
    public final String getId() {
        return "base_mobile_item_view_config_guide";
    }

    public n(OnBoardingData.CustomData r100) {
        this.f214296a = r100;
    }

    @Override // tk5.d
    public final boolean b(vk5.c r100) {
        vk5.a r101 = (vk5.a) r100;
        Intrinsics.checkNotNullParameter(r101, "ui");
        OnBoardingData.CustomData r102 = this.f214296a;
        if (r102 == null) goto L7;
        FragmentActivity r103 = r101.getActivity();
        if (r103 == null) goto L7;
        String r104 = r102.title;
        String r105 = "";
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        String r106 = r102.body;
        if (r106 != null) goto L14;
        r106 = "";
    L14:
        String r107 = r102.confirmText;
        if (r107 == null) goto L18;
        r105 = r107;
    L18:
        uk5.b r108 = new uk5.b(r104, Integer.valueOf(com.bytedance.ee.util.ui.n.n(r103, r102.imgRes)));
        r108.f550497c = r106;
        r108.f550499e = r105;
        r108.f550500f = true;
        l.a("ItemViewOnboard showCard", null, null, null, 14);
        r101.b(r103.getWindow(), r108, new m(this));
        return true;
    L7:
        return false;
    }
}
