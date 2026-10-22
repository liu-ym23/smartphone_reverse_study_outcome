package com.bytedance.ee.bear.bitable.search;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SearchConfigIcon;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements tk5.d<vk5.a> {
    public final View a;
    public final String b;
    public final Runnable c;

    public final String getBiz() {
        return "bitable";
    }

    public final /* synthetic */ String getDependency() {
        return null;
    }

    public final String getId() {
        return "base_new_global_search_guide";
    }

    public final boolean b(vk5.c r6) {
        vk5.a r7 = (vk5.a) r6;
        Intrinsics.checkNotNullParameter(r7, "ui");
        tt5.a.h("BitableSearchFragment", "show>>> SearchConfigMission");
        FragmentActivity r0 = r7.getActivity();
        Function0<Unit> r1 = new BitableSearchConfigOnboard$show$confirm$1(this);
        uk5.c r2 = new uk5.c(null, this.a);
        r2.c = this.b;
        r2.m = r0.getResources().getString(2131886434);
        r2.o = true;
        r2.p = true;
        r2.k = new b(this);
        r7.c(r0.getWindow(), r2, new a(r1));
        return true;
    }

    public c(SearchConfigIcon r2, String r3, BitableSearchFragment.e.a r4) {
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r3, "onboardingText");
        Intrinsics.checkNotNullParameter(r4, "clickSearchConfig");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
