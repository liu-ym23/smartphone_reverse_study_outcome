package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.shopping.anchorv4.log.GULShowManager;
import com.bytedance.android.shopping.api.mall.feed.ECMallFeedState;
import com.bytedance.android.shopping.api.mall.feed.InitGYLComponentBehavior;
import com.bytedance.android.shopping.api.mall.feed.d;
import com.bytedance.android.shopping.api.mall.feed.f;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.m;
import com.bytedance.android.shopping.prepurchase.business.pdp.e;
import com.bytedance.android.shopping.prepurchase.business.pdp.view.MultiRecyclerNestedScrollView;
import com.bytedance.android.shopping.utils.z;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import vg3.d0;
import vg3.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class GULSDKComponent extends m implements j {
    public static final /* synthetic */ int t = 0;
    public MultiRecyclerNestedScrollView m;
    public d n;
    public Deferred<? extends d> o;
    public boolean p;
    public boolean q;
    public long r;
    public boolean s;

    public static final class a implements f {
        public boolean a;
        public final /* synthetic */ GULSDKComponent b;
        public final /* synthetic */ d c;

        @Override // com.bytedance.android.shopping.api.mall.feed.f
        public final void a(ECMallFeedState r6) {
            Intrinsics.checkNotNullParameter(r6, "state");
            int r0 = b.a[r6.ordinal()];
            if (r0 == 1) goto L9;
            if (r0 != 4) goto L6;
        L8:
            int r1 = z.a;
            z.c("gul init success state=" + r6, "gul", 4);
            this.c.b();
            return;
        L6:
            if (r0 == 5) goto L8;
            return;
        L9:
            int r2 = z.a;
            z.c("gul init failed state=" + r6, "gul", 4);
            if (this.a == true) goto L14;
            this.a = true;
            this.b.i2(this.c);
            return;
        }

        public a(GULSDKComponent r1, d r2) {
            this.b = r1;
            this.c = r2;
        }
    }

    @Override // vg3.j
    public final void u0() {
        this.s = false;
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this, "forceInitGULComponent");
        k2();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(d0.class);
    }

    public final void k2() {
        if (this.q == true) goto L10;
        this.q = true;
        d r0 = this.n;
        if (r0 != null) goto L7;
        BuildersKt.launch$default(Q1(), Dispatchers.getMain().getImmediate(), null, new GULSDKComponent$tryInitGulSdkComponent$1(this, null), 2, null);
        return;
    L7:
        if (r0 == null) goto L12;
        j2(r0);
        return;
    L12:
        return;
    }

    public GULSDKComponent() {
        this.s = true;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        AbsComponent.Y1(this, j.class, this, false, 12);
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this, "onAttach");
        BuildersKt.launch$default(Q1(), Dispatchers.getMain().getImmediate(), null, new GULSDKComponent$onAttach$1(this, null), 2, null);
    }

    public static final d h2(GULSDKComponent r7) {
        r7.getClass();
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(r7, "safeCreateGulComponent");
        FragmentActivity r1 = r7.O1().getContainerAbility().mo2525getContext();
        Object r2 = null;
        if (r1 == null) goto L24;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        GULShowManager.a r4 = GULShowManager.i;     // Catch: Throwable -> L11
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul.a r5 = new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul.a(r7.O1(), r7);     // Catch: Throwable -> L11
        boolean r6 = ECServiceManager.a;     // Catch: Throwable -> L11
        if (((IECHostService) ECServiceManager.c(IECHostService.class)).getRecommendStatus() == false) goto L8;
        int r8 = 2131895743;
    L9:
        String r9 = th.a.g(r1, r8);     // Catch: Throwable -> L11
        boolean r10 = ((e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r7.O1())).b.a;     // Catch: Throwable -> L11
        r4.getClass();     // Catch: Throwable -> L11
        d r11 = GULShowManager.a.a(r1, r5, r9, r10);     // Catch: Throwable -> L11
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(r7, "safeCreateGulComponent finish: " + r11);     // Catch: Throwable -> L11
        Object r0 = Result.constructor-impl(r11);     // Catch: Throwable -> L11
    L13:
        Throwable r12 = Result.exceptionOrNull-impl(r0);
        if (r12 == null) goto L17;
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.b(r7, "create gul component error", r12);
    L17:
        if (Result.isFailure-impl(r0) == true) goto L21;
        r2 = r0;
    L21:
        return (d) r2;
    L8:
        r8 = 2131895744;
    L11:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L24:
        return null;
    }

    public final void i2(d r4) {
        int r0 = z.a;
        z.c("call handleGulInit fromScroll=" + this.s, "gul", 4);
        if (this.s == false) goto L5;
        r4.f(InitGYLComponentBehavior.PRODUCT_DETAIL_SCROLL_TO_GYL);
        return;
    L5:
        r4.f(InitGYLComponentBehavior.PRODUCT_DETAIL_CLICK_RECOMMEND);
    }

    public final void j2(d r4) {
        RecyclerView r0 = r4.getFeedView();
        if (r0 == null) goto L10;
        r0.setOverScrollMode(2);
        wg.a.a(r0);
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this, "add gul to scrollView");
        MultiRecyclerNestedScrollView r1 = this.m;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("parentNestScrollView");
    L7:
        int r2 = MultiRecyclerNestedScrollView.n;
        if (r1.c != null) goto L10;
        r1.c = r0;
        r1.a.addView(r0);
        r0.addOnScrollListener(r1.m);
    L10:
        r4.setFeedStateListener(new a(this, r4));
        i2(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final void b2(ViewGroup r1, ViewGroup.LayoutParams r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parentView");
        this.m = (MultiRecyclerNestedScrollView) r1;
    }
}
