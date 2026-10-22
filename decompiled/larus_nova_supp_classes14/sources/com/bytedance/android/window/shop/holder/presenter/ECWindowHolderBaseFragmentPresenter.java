package com.bytedance.android.window.shop.holder.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class ECWindowHolderBaseFragmentPresenter extends QFragmentPresenter {
    public View f;
    public final Lazy g;
    public final Lazy h;

    public final ECWindowViewModel d0() {
        return (ECWindowViewModel) this.g.getValue();
    }

    public final LifecycleOwner e0() {
        ECWindowDialogFragment r0 = (ECWindowDialogFragment) this.h.getValue();
        if (r0 == null) goto L6;
        return r0;
    L6:
        return ECQuickUtilKt.a(Y());
    }

    public View h0() {
        View r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return a0();
    }

    public ECWindowHolderBaseFragmentPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.g = LazyKt.lazy(new ECWindowHolderBaseFragmentPresenter$viewModel$2(this));
        this.h = LazyKt.lazy(new ECWindowHolderBaseFragmentPresenter$dialogFragment$2(this));
    }
}
