package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g extends com.bytedance.android.shopping.anchorv3.activities.quick.uimodule.a {
    public final FragmentActivity l;

    public final QIPresenter h() {
        return new AnchorV4RulePresenter(this.l);
    }

    public final FragmentActivity getActivity() {
        return this.l;
    }

    public g(FragmentActivity r1, AnchorV4VM r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        this.l = r1;
    }

    public final View f(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        ShoppingAsyncInflater.e.getClass();
        return ShoppingAsyncInflater.a.a(r3).aU(2131564606, r4, false);
    }
}
