package com.bytedance.ee.bear.bitable.itemview.util;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f214297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ sk5.c f214298b;

    public o(FragmentActivity r100, sk5.c r101) {
        this.f214297a = r100;
        this.f214298b = r101;
    }

    public final void a() {
        FragmentActivity r100 = this.f214297a;
        if (r100 != null) goto L6;
        l.a("tryShowConfigOnboard>>> activityNull or viewNotAttach", null, null, null, 14);
        return;
    L6:
        sk5.c r101 = this.f214298b;
        OnBoardingData r102 = new OnBoardingData();
        r102.action = "base_mobile_item_view_config_guide";
        OnBoardingData.CustomData r103 = new OnBoardingData.CustomData(r102);
        r103.type = OnBoardingData.OnBoardingType.CARD;
        r103.imgRes = "icon_bitable_item_view_config";
        r103.title = com.bytedance.ee.util.ui.n.x(r100, R.string.Bitable_CustomDetailsPage_IntroducingNewRecordDetailsPage_Title_Mob);
        r103.body = com.bytedance.ee.util.ui.n.x(r100, R.string.Bitable_CustomDetailsPage_CustomizeLayoutOnDemand_Desc_Mob);
        r103.confirmText = com.bytedance.ee.util.ui.n.x(r100, R.string.Bitable_Common_GotIt_Button);
        r102.customData = r103;
        r101.g(new n(r103), r100);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
