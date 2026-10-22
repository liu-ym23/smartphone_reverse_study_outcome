package com.bytedance.android.window.shop.innerflow.presenter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.y1;
import com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel;
import com.bytedance.android.window.shop.innerflow.widget.ECWindowInnerFlowAddShopCartView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/presenter/ECWindowInnerFlowToolbarPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QPresenter;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/LifecycleEventObserver;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowInnerFlowToolbarPresenter extends QPresenter implements View.OnClickListener, LifecycleEventObserver {
    public final Lazy e;
    public final Lazy f;
    public final ECWindowInnerFlowToolbarPresenter$cartObserver$1 g;
    public vp3.a h;

    public final ECWindowInnerFlowViewModel D() {
        return (ECWindowInnerFlowViewModel) this.e.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.android.window.shop.innerflow.presenter.ECWindowInnerFlowToolbarPresenter$cartObserver$1] */
    public ECWindowInnerFlowToolbarPresenter() {
        this.e = LazyKt.lazy(new ECWindowInnerFlowToolbarPresenter$viewModel$2(this));
        this.f = LazyKt.lazy(new ECWindowInnerFlowToolbarPresenter$cartView$2(this));
        this.g = new ECWindowInnerFlowToolbarPresenter$cartObserver$1(this);
    }

    public final void C() {
        D().getCartInfoLiveData().f(this.g);
        ECQuickUtilKt.a(u()).getLifecycle().removeObserver(this);
    }

    public final void A(QModel r4) {
        QContext r5 = u();
        Activity r0 = l0.c(r5.c());
        if ((r0 instanceof FragmentActivity) == true) goto L5;
        r0 = null;
    L5:
        if (r0 != null) goto L7;
        r0 = r5.a();
    L7:
        int r6 = y1.a;
        y1.c(r0, r0.getWindow(), true);
        View r7 = w().b(2131370915).f();
        ViewGroup.LayoutParams r1 = r7.getLayoutParams();
        r1.height = eh.b.b(r7.getContext());
        Unit r2 = Unit.INSTANCE;
        r7.setLayoutParams(r1);
        w().b(2131370967).f().setOnClickListener(this);
        ((ECWindowInnerFlowAddShopCartView) this.f.getValue()).setOnClickListener(new d(this));
        D().getCartInfoLiveData().b(ECQuickUtilKt.a(u()), this.g);
        ECQuickUtilKt.a(u()).getLifecycle().addObserver(this);
        int r8 = com.bytedance.android.window.shop.innerflow.a.a;
        ECWindowInnerFlowViewModel r9 = D();
        Intrinsics.checkNotNullParameter(r9, "innerFlowViewModel");
        r9.doEventAction("show_product_flow", com.bytedance.android.window.shop.innerflow.a.b(r9), new Pair[0]);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        int r0 = rp.a.a;
        if (rp.a.a(r3.getId()) == false) goto L6;
        return;
    L6:
        if (r3.getId() != 2131370967) goto L14;
        int r4 = com.bytedance.android.window.shop.innerflow.a.a;
        com.bytedance.android.window.shop.innerflow.a.d(D(), "close", new Pair[0]);
        QContext r5 = u();
        FragmentActivity r1 = l0.c(r5.c());
        if ((r1 instanceof FragmentActivity) == true) goto L10;
        r1 = null;
    L10:
        if (r1 != null) goto L12;
        r1 = r5.a();
    L12:
        r1.finish();
        return;
    }

    public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "event");
        if (r3 == Lifecycle.Event.ON_RESUME) goto L5;
        return;
    L5:
        D().getShopCartInfo();
    }
}
