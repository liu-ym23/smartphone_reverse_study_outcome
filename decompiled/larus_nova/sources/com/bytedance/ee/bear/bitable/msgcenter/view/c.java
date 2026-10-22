package com.bytedance.ee.bear.bitable.msgcenter.view;

import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements tk5.d<vk5.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f214727a;

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
        return "base_message_center_view_history_guide";
    }

    public c(AppCompatImageView r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f214727a = r100;
    }

    @Override // tk5.d
    public final boolean b(vk5.c r100) {
        vk5.a r101 = (vk5.a) r100;
        Intrinsics.checkNotNullParameter(r101, "ui");
        tt5.a.h("BitableMsgCenterFragment", "show>>> HistoryGuideMission");
        FragmentActivity r102 = r101.getActivity();
        String r103 = r102.getResources().getString(R.string.Bitable_FeedCenter_Onboarding_ViewEarlierNotifications_Desc);
        Window r104 = r102.getWindow();
        uk5.e r105 = new uk5.e(r103, this.f214727a);
        r105.f550524j = true;
        r105.f550523i = 5000;
        Unit r106 = Unit.INSTANCE;
        r101.d(r104, r105, new b(this));
        return true;
    }
}
