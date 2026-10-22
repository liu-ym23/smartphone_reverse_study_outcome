package com.bytedance.android.window.shop.home.tab.presenter;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.window.base.product.lynxcard.ECLynxCardEvent;
import com.bytedance.android.ec.window.base.status.WindowLazyStatusView;
import com.bytedance.android.window.shop.holder.presenter.ECWindowHolderBasePresenter;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/presenter/WindowH5TabPresenter;", "Lcom/bytedance/android/window/shop/holder/presenter/ECWindowHolderBasePresenter;", "Landroidx/lifecycle/LifecycleEventObserver;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowH5TabPresenter extends ECWindowHolderBasePresenter implements LifecycleEventObserver {
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Function2<com.bytedance.android.window.shop.repository.tab.entity.v, ECLynxCardEvent, Unit> j;
    public final Fragment k;

    public final BaseWindowTabViewModel F() {
        return (BaseWindowTabViewModel) this.g.getValue();
    }

    public WindowH5TabPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.j = null;
        this.k = r2;
        this.g = LazyKt.lazy(new WindowH5TabPresenter$windowTabViewModel$2(this));
        this.h = LazyKt.lazy(new WindowH5TabPresenter$bindOnce$2(this));
        this.i = LazyKt.lazy(new WindowH5TabPresenter$statusView$2(this));
    }

    public final void A(QModel r2) {
        this.k.getLifecycle().addObserver(this);
        ((WindowLazyStatusView) this.i.getValue()).b(com.bytedance.android.ec.window.base.status.c.d.a);
        Unit r3 = (Unit) this.h.getValue();
    }

    public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "event");
        Lifecycle.Event r4 = Lifecycle.Event.ON_RESUME;
        Lifecycle.Event r5 = Lifecycle.Event.ON_PAUSE;
        Lifecycle.Event.Companion r6 = Lifecycle.Event.Companion;
    }
}
