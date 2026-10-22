package com.bytedance.ee.bear.bitable.msgcenter.view;

import android.graphics.RectF;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements tk5.d<vk5.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f214731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f214732b;

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
        return "base_message_center_upgrade_guide";
    }

    @Override // tk5.d
    public final boolean b(vk5.c r110) {
        vk5.a r111 = (vk5.a) r110;
        Intrinsics.checkNotNullParameter(r111, "ui");
        tt5.a.h("BitableMsgCenterFragment", "show>>> NewMsgCenterMission");
        FragmentActivity r100 = r111.getActivity();
        Function0<Unit> r101 = new BitableNewMsgCenterMission$show$confirm$1(this);
        int[] r102 = new int[2];
        this.f214731a.getLocationOnScreen(r102);
        float r103 = r102[0];
        uk5.c r104 = new uk5.c(r100.getResources().getString(R.string.Bitable_FeedCenter_Onboarding_NotifcationsUpgrade_Title), true, new RectF(r103, r102[1], n.d(44) + r103, r102[1] + n.d(36)));
        r104.f550502c = r100.getResources().getString(R.string.Bitable_FeedCenter_Onboarding_SorMsgIntoCategories_Desc) + "\n" + r100.getResources().getString(R.string.Bitable_FeedCenter_Onboarding_ToggleReadStatus_Desc) + "\n" + r100.getResources().getString(R.string.Bitable_FeedCenter_Onboarding_EnhancedVisual_Desc);
        r104.f550512m = r100.getResources().getString(R.string.Bitable_FeedCenter_Onboarding_TryNow_Button);
        r104.f550511l = r100.getResources().getString(R.string.Bitable_FeedCenter_Onboarding_GotIt_Button);
        r104.f550514o = true;
        r104.f550515p = true;
        r104.f550510k = new e(r101);
        r111.c(r100.getWindow(), r104, new d(r101, this));
        a.c("ccm_bitable_notification_onboarding_view", null);
        return true;
    }

    public f(View r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "click");
        this.f214731a = r100;
        this.f214732b = r101;
    }
}
