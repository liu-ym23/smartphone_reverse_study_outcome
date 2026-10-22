package com.bytedance.ee.bear.bitable.search;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SearchConfigIcon;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements tk5.d<vk5.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f215300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f215301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f215302c;

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
        return "base_new_global_search_guide";
    }

    @Override // tk5.d
    public final boolean b(vk5.c r100) {
        vk5.a r101 = (vk5.a) r100;
        Intrinsics.checkNotNullParameter(r101, "ui");
        tt5.a.h("BitableSearchFragment", "show>>> SearchConfigMission");
        FragmentActivity r102 = r101.getActivity();
        Function0<Unit> r103 = new BitableSearchConfigOnboard$show$confirm$1(this);
        uk5.c r104 = new uk5.c(null, this.f215300a);
        r104.f550502c = this.f215301b;
        r104.f550512m = r102.getResources().getString(R.string.Bitable_FeedCenter_Onboarding_GotIt_Button);
        r104.f550514o = true;
        r104.f550515p = true;
        r104.f550510k = new b(this);
        r101.c(r102.getWindow(), r104, new a(r103));
        return true;
    }

    public c(SearchConfigIcon r100, String r101, BitableSearchFragment.e.a r102) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "onboardingText");
        Intrinsics.checkNotNullParameter(r102, "clickSearchConfig");
        this.f215300a = r100;
        this.f215301b = r101;
        this.f215302c = r102;
    }
}
