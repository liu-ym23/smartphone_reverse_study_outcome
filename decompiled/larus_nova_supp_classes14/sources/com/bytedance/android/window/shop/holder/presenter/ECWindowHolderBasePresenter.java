package com.bytedance.android.window.shop.holder.presenter;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class ECWindowHolderBasePresenter extends QPresenter {
    public final Lazy e;
    public final Lazy f;

    public final ECWindowViewModel D() {
        return (ECWindowViewModel) this.e.getValue();
    }

    public final LifecycleOwner E() {
        ECWindowDialogFragment r0 = (ECWindowDialogFragment) this.f.getValue();
        if (r0 == null) goto L6;
        return r0;
    L6:
        return ECQuickUtilKt.a(u());
    }

    public ECWindowHolderBasePresenter() {
        this.e = LazyKt.lazy(new ECWindowHolderBasePresenter$viewModel$2(this));
        this.f = LazyKt.lazy(new ECWindowHolderBasePresenter$dialogFragment$2(this));
    }
}
