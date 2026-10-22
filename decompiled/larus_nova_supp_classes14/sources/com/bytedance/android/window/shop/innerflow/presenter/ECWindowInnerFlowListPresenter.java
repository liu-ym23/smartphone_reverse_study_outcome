package com.bytedance.android.window.shop.innerflow.presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.window.base.shop.SpacesItemDecoration;
import com.bytedance.android.ec.window.base.utils.playable.controller.playcontrol.WindowPlayControlStrategy;
import com.bytedance.android.window.shop.holder.footer.FooterStatus;
import com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowActivity;
import com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel;
import com.bytedance.android.window.shop.innerflow.widget.ECWindowInnerFlowAdapter;
import com.bytedance.android.window.shop.innerflow.widget.ECWindowInnerFlowRecyclerView;
import com.bytedance.android.window.shop.widget.WindowStatusView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/presenter/ECWindowInnerFlowListPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QPresenter;", "Landroidx/lifecycle/LifecycleEventObserver;", "<init>", "()V", "a", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowInnerFlowListPresenter extends QPresenter implements LifecycleEventObserver {
    public static final /* synthetic */ int n = 0;
    public final Lazy e;
    public boolean f;
    public boolean g;
    public WindowStatusView h;
    public final Lazy i;
    public final Lazy j;
    public final b k;
    public com.bytedance.android.ec.window.base.utils.playable.controller.b l;
    public final ECWindowInnerFlowListPresenter$scrollListener$1 m;

    public static final class a {
    }

    public final class b implements com.bytedance.android.window.shop.innerflow.repo.d {
        public final /* synthetic */ ECWindowInnerFlowListPresenter a;

        @Override // com.bytedance.android.window.shop.innerflow.repo.d
        public final void a() {
            ECWindowInnerFlowListPresenter r0 = this.a;
            int r1 = ECWindowInnerFlowListPresenter.n;
            if (r0.D().getBasicItemCount() != 0) goto L8;
            WindowStatusView r2 = this.a.h;
            if (r2 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
        L7:
            r2.setVisibility(0);
            r2.setECStatus(2);
        L12:
            ECWindowInnerFlowListPresenter r3 = this.a;
            r3.g = false;
            r3.f = true;
            r3.D().z2(FooterStatus.NO_MORE);
            return;
        L8:
            WindowStatusView r4 = this.a.h;
            if (r4 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
        L11:
            r4.b();
            goto L12
        }

        @Override // com.bytedance.android.window.shop.innerflow.repo.d
        public final void onError() {
            Intrinsics.checkNotNullParameter("", "msg");
            ECWindowInnerFlowListPresenter r0 = this.a;
            int r1 = ECWindowInnerFlowListPresenter.n;
            if (r0.D().getBasicItemCount() != 0) goto L8;
            WindowStatusView r2 = this.a.h;
            if (r2 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
        L7:
            r2.setVisibility(0);
            r2.setECStatus(2);
        L12:
            this.a.g = false;
            return;
        L8:
            WindowStatusView r3 = this.a.h;
            if (r3 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
        L11:
            r3.b();
            goto L12
        }

        public b(ECWindowInnerFlowListPresenter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.window.shop.innerflow.repo.d
        public final void b(List<? extends vp3.b> r5) {
            Intrinsics.checkNotNullParameter(r5, "data");
            WindowStatusView r0 = this.a.h;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
        L5:
            r0.b();
            ECWindowInnerFlowListPresenter r1 = this.a;
            r1.g = false;
            ECWindowInnerFlowAdapter r2 = r1.D();
            monitor-enter(r2);
            Intrinsics.checkNotNullParameter(r5, "innerFlowList");     // Catch: Throwable -> L13
            int r3 = ((ArrayList) r2.c).size();     // Catch: Throwable -> L13
            ArrayList r4 = (ArrayList) r2.c;     // Catch: Throwable -> L13
            r4.addAll(r5);     // Catch: Throwable -> L13
            if (r3 != 0) goto L10;
            r2.notifyDataSetChanged();     // Catch: Throwable -> L13
        L11:
            monitor-exit(r2);
            return;
        L10:
            r2.notifyItemRangeInserted(r3, r5.size());     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    public final ECWindowInnerFlowAdapter D() {
        return (ECWindowInnerFlowAdapter) this.i.getValue();
    }

    public final ECWindowInnerFlowRecyclerView E() {
        return (ECWindowInnerFlowRecyclerView) this.e.getValue();
    }

    public final void C() {
        com.bytedance.android.ec.window.base.utils.playable.controller.b r0 = this.l;
        if (r0 == null) goto L5;
        r0.e.c();
    L5:
        QContext r1 = u();
        FragmentActivity r2 = l0.c(r1.c());
        if ((r2 instanceof ECWindowInnerFlowActivity) == true) goto L8;
        r2 = null;
    L8:
        FragmentActivity r3 = (ECWindowInnerFlowActivity) r2;
        if (r3 != null) goto L11;
        r3 = r1.a();
    L11:
        ((ECWindowInnerFlowActivity) r3).getLifecycle().removeObserver(this);
    }

    public final void F() {
        ((ECWindowInnerFlowViewModel) this.j.getValue()).loadMore(this.k);
        this.g = true;
        D().z2(FooterStatus.LOADING);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.android.window.shop.innerflow.presenter.ECWindowInnerFlowListPresenter$scrollListener$1] */
    public ECWindowInnerFlowListPresenter() {
        this.e = LazyKt.lazy(new ECWindowInnerFlowListPresenter$recyclerView$2(this));
        this.i = LazyKt.lazy(new ECWindowInnerFlowListPresenter$adapter$2(this));
        this.j = LazyKt.lazy(new ECWindowInnerFlowListPresenter$viewModel$2(this));
        this.k = new b(this);
        this.m = new ECWindowInnerFlowListPresenter$scrollListener$1(this);
    }

    public final void A(QModel r7) {
        this.h = (WindowStatusView) y().findViewById(2131370916);
        ShoppingAsyncInflater.a r8 = ShoppingAsyncInflater.e;
        Context r0 = u().c();
        r8.getClass();
        ShoppingAsyncInflater r9 = ShoppingAsyncInflater.a.a(r0);
        WindowStatusView r1 = this.h;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L5:
        View r10 = com.bytedance.android.ec.opt.asyncInflate.c.a(r9, 2131561057, r1, 4);
        ViewGroup.LayoutParams r2 = r10.getLayoutParams();
        if (r2 == null) goto L33;
        ((FrameLayout.LayoutParams) r2).gravity = 17;
        if (ECQuickUtilKt.c(u(), ECWindowInnerFlowViewModel.class).getInnerFlowParam().c != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        int r4 = 2131560888;
    L14:
        LayoutInflater r5 = LayoutInflater.from(u().c());
        WindowStatusView r6 = this.h;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L17:
        View r11 = r5.inflate(r4, r6, false);
        WindowStatusView r12 = this.h;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L20:
        r12.c(r11, r10, true);
        ((TextView) r10.findViewById(2131387440)).setOnClickListener(new com.bytedance.android.window.shop.innerflow.presenter.b(this));
        WindowStatusView r13 = this.h;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L23:
        r13.setVisibility(0);
        r13.setECStatus(0);
        E().setLayoutManager(new LinearLayoutManager(u().c()));
        E().setAdapter(D());
        int r14 = com.bytedance.android.shopping.extensions.b.b(12);
        E().addItemDecoration(new SpacesItemDecoration(r14, r14, r14));
        FragmentActivity r15 = null;
        com.bytedance.android.ec.window.base.utils.playable.controller.b r16 = new com.bytedance.android.ec.window.base.utils.playable.controller.b(new vp.a(), new wp.a(E()), null, WindowPlayControlStrategy.ORDER_FIRST);
        ECWindowInnerFlowRecyclerView r17 = E();
        Intrinsics.checkNotNullParameter(r17, "recyclerView");
        r16.a = r17;
        r17.addOnScrollListener(r16.d);
        Unit r18 = Unit.INSTANCE;
        this.l = r16;
        E().addOnScrollListener(this.m);
        F();
        QContext r19 = u();
        FragmentActivity r20 = l0.c(r19.c());
        if ((r20 instanceof ECWindowInnerFlowActivity) == false) goto L27;
        r15 = r20;
    L27:
        FragmentActivity r21 = (ECWindowInnerFlowActivity) r15;
        if (r21 != null) goto L30;
        r21 = r19.a();
    L30:
        ((ECWindowInnerFlowActivity) r21).getLifecycle().addObserver(this);
        return;
    L13:
        r4 = 2131560893;
        goto L14
    L10:
        r3 = false;
        goto L11
    L33:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "event");
        int r4 = com.bytedance.android.window.shop.innerflow.presenter.a.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        com.bytedance.android.ec.window.base.utils.playable.controller.b r5 = this.l;
        if (r5 == null) goto L16;
        r5.e.b();
        return;
    L16:
        return;
    L5:
        if (r4 != 2) goto L17;
        com.bytedance.android.ec.window.base.utils.playable.controller.b r6 = this.l;
        if (r6 == null) goto L14;
        r6.e.d();
        return;
    L14:
        return;
    }
}
