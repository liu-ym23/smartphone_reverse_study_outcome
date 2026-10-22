package com.bytedance.android.shopping.store.home.presenter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopLoadStatusPresenter extends ECShopBasePresenter {
    public static final /* synthetic */ int u = 0;

    public static final class a<T> implements Observer {
        public final /* synthetic */ ECShopLoadStatusPresenter a;

        public a(ECShopLoadStatusPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L5;
            this.a.s0();
            return;
        L5:
            Activity r3 = com.bytedance.android.ec.core.utils.l0.b(this.a.u().c());
            if (r3 == null) goto L20;
            View r4 = ECShopLoadStatusPresenter.q0(r3.getWindow());
            if ((r4 instanceof ViewGroup) == true) goto L11;
            r4 = null;
        L11:
            ViewGroup r5 = (ViewGroup) r4;
            if (r5 == null) goto L21;
            View r0 = r5.findViewById(2131371047);
            if (r0 == null) goto L19;
            r5.removeView(r0);
            return;
        L19:
            return;
        L21:
            return;
        }
    }

    public final void s0() {
        Activity r0 = com.bytedance.android.ec.core.utils.l0.b(u().c());
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = q0(r0.getWindow());
        ColorDrawable r3 = null;
        if ((r1 instanceof ViewGroup) == true) goto L8;
        r1 = null;
    L8:
        ViewGroup r2 = (ViewGroup) r1;
        if (r2 != null) goto L12;
        return;
    L12:
        if (r0.findViewById(2131371047) == null) goto L14;
        return;
    L14:
        boolean r4 = U();
        FrameLayout r5 = new FrameLayout(r0);
        if (r4 == true) goto L18;
        r3 = new ColorDrawable(-1);
    L18:
        int r6 = qc3.a.a;
        Intrinsics.checkNotNullParameter(r5, "$this$setBackgroundCompat");
        r5.setBackground(r3);
        if (r4 == false) goto L21;
        int r7 = ((Number) this.q.getValue()).intValue();
    L22:
        r5.setPadding(0, r7, 0, 0);
        r5.setId(2131371047);
        t0(r5, r4).b(com.bytedance.android.ec.store.status.b.c.a);
        r2.addView(r5, -1, -1);
        return;
    L21:
        r7 = 0;
        goto L22
    }

    public ECShopLoadStatusPresenter(Fragment r1) {
        super(r1);
    }

    public static View q0(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void A(QModel r10) {
        if (Intrinsics.areEqual((Boolean) T().getStoreClosingStatus().getValue(), Boolean.TRUE) == false) goto L5;
        s0();
    L5:
        T().getStoreClosingStatus().a(W(), new a(this), false);
        boolean r11 = U();
        ViewGroup r0 = (ViewGroup) w().b(2131371142).f();
        if (r11 == false) goto L8;
        Drawable r4 = null;
    L9:
        int r5 = qc3.a.a;
        Intrinsics.checkNotNullParameter(r0, "$this$setBackgroundCompat");
        r0.setBackground(r4);
        if (r11 == false) goto L12;
        int r6 = ((Number) this.q.getValue()).intValue();
    L13:
        r0.setPadding(0, r6, 0, 0);
        LazyStatusView r12 = t0(r0, r11);
        com.bytedance.android.ec.store.status.b.c r7 = com.bytedance.android.ec.store.status.b.c.a;
        r12.b(r7);
        T().getRestoreCoverVisible().a(W(), new b1(this, r0, r12), false);
        T().getLoadStatus().a(W(), new c1(this, r12, r0), false);
        T().getTabArea().a(W(), new d1(this, r0), false);
        final Context r13 = th.a.e(u().c(), true);
        ViewGroup r8 = (ViewGroup) w().b(2131371151).f();
        r8.setVisibility(0);
        final LazyStatusView r9 = new LazyStatusView(r13, null);
        r9.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r8.addView(r9);
        r9.setCreators(MapsKt.mapOf(new Pair[]{TuplesKt.to(r7, new com.bytedance.android.ec.store.status.c(new ECShopLoadStatusPresenter$mayInitOptTabStatusView$1(this, r13), null, 6)), TuplesKt.to(com.bytedance.android.ec.store.status.b.b.a, new com.bytedance.android.ec.store.status.c(new ECShopLoadStatusPresenter$mayInitOptTabStatusView$2(this, r9), null, 6))}));
        ViewGroup r14 = (ViewGroup) w().b(2131371128).f();
        Context r1 = th.a.e(u().c(), true);
        int r3 = r0(r1);
        int r15 = e0();
        ShoppingAsyncInflater.e.getClass();
        View r2 = ShoppingAsyncInflater.a.a(r1).aU(2131560947, null, false);
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(r3, r15);
        r16.gravity = 80;
        Unit r17 = Unit.INSTANCE;
        r2.setLayoutParams(r16);
        r14.addView(r2);
        r9.b(r7);
        v0(r14, r2, (LoadStatus) T().getTabLoadStatus().getValue());
        T().getLoadStatus().a(W(), new e1(this, r14, r2), false);
        T().getHeaderArea().a(W(), new f1(this, r14, r2), false);
        T().getTabLoadStatus().a(W(), new g1(this, r14, r2, r9), false);
        return;
    L12:
        r6 = 0;
        goto L13
    L8:
        r4 = new ColorDrawable(-1);
        goto L9
    }

    public final int r0(Context r2) {
        Point r3 = com.bytedance.android.ec.core.utils.l0.f(r2);
        if (r3 == null) goto L5;
        int r4 = r3.x;
    L7:
        if (T().getStoreParam().isSplitMode() == false) goto L9;
        r4 = r4 / 2;
    L9:
        if (r4 > 0) goto L13;
        return -1;
    L13:
        return r4;
    L5:
        r4 = 0;
        goto L7
    }

    public final void u0(int r4) {
        View r0 = w().b(2131371057).f();
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r1 = null;
    L5:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (r2 != null) goto L8;
        return;
    L8:
        if (r2.bottomMargin == r4) goto L12;
        r2.bottomMargin = r4;
        r0.requestLayout();
        return;
    }

    public final LazyStatusView t0(ViewGroup r8, boolean r9) {
        final LazyStatusView r0 = new LazyStatusView(th.a.e(u().c(), true), null);
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        r1.gravity = 17;
        Unit r4 = Unit.INSTANCE;
        r0.setLayoutParams(r1);
        if (r9 == false) goto L5;
        ColorDrawable r10 = new ColorDrawable(-1);
        int r2 = qc3.a.a;
        Intrinsics.checkNotNullParameter(r0, "$this$setBackgroundCompat");
        r0.setBackground(r10);
        qc3.a.i(r0, 12.0f, 12.0f);
    L5:
        r8.addView(r0);
        r0.setCreators(MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.store.status.b.c.a, new com.bytedance.android.ec.store.status.c(new ECShopLoadStatusPresenter$tryAddLoadStatusViewToContainer$1(this), new ECShopLoadStatusPresenter$tryAddLoadStatusViewToContainer$2(this), 4)), TuplesKt.to(com.bytedance.android.ec.store.status.b.b.a, new com.bytedance.android.ec.store.status.c(new ECShopLoadStatusPresenter$tryAddLoadStatusViewToContainer$3(this, r0), null, 6))}));
        return r0;
    }

    public final void v0(ViewGroup r5, View r6, LoadStatus r7) {
        boolean r2 = true;
        int r3 = 0;
        if (((LoadStatus) T().getLoadStatus().getValue()) != LoadStatus.InitializeSuccess) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
    L18:
        r6.setVisibility(8);
        if (T().getHeaderArea().getValue() != null) goto L21;
    L25:
        boolean r8 = false;
    L26:
        if (r8 == false) goto L28;
        r5.setVisibility(8);
        u0(0);
        return;
    L28:
        ECStoreTabAreaVO r9 = (ECStoreTabAreaVO) T().getTabArea().getValue();
        if (r9 == null) goto L31;
        List<uj3.j> r10 = r9.b;
    L32:
        if (r10 != null) goto L34;
    L35:
        com.bytedance.android.shopping.store.home.entity.n r11 = (com.bytedance.android.shopping.store.home.entity.n) T().getHeaderArea().getValue();
        if (r11 != null) goto L38;
    L40:
        if (r10 == null) goto L42;
        int r12 = r10.size();
    L43:
        if (r12 <= 1) goto L45;
    L49:
        if (r2 == false) goto L55;
        r5.setVisibility(0);
        if (U() == true) goto L54;
        r3 = e0();
    L54:
        u0(r3);
        return;
    L55:
        r5.setVisibility(8);
        u0(0);
        return;
    L45:
        if (Intrinsics.areEqual((Boolean) T().isBrandShop().getValue(), Boolean.TRUE) == false) goto L47;
    L48:
        r2 = false;
        goto L49
    L47:
        if (T().isMiddleTabFramework() == false) goto L49;
    L42:
        r12 = 0;
        goto L43
    L38:
        if (r11.c() != true) goto L40;
    L34:
        if (r10.isEmpty() == true) goto L48;
    L31:
        r10 = null;
        goto L32
    L21:
        if (r7 != LoadStatus.Initialize) goto L23;
    L24:
        r8 = true;
        goto L26
    L23:
        if (r7 != LoadStatus.InitializeError) goto L25;
    L10:
        if (r7 != LoadStatus.Initialize) goto L12;
    L13:
        r5.setVisibility(0);
        if (U() == false) goto L16;
        int r13 = 0;
    L17:
        u0(r13);
        r6.setVisibility(0);
        return;
    L16:
        r13 = e0();
        goto L17
    L12:
        if (r7 != LoadStatus.InitializeError) goto L18;
    L5:
        if (T().getHeaderArea().getValue() != null) goto L7;
        r0 = true;
        goto L8
    }
}
