package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.bottom.d0;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BottomNavV1SkuDependency implements d0, j73.m {
    public final d a;
    public final /* synthetic */ j73.m b;

    public final void F(String r2, com.bytedance.android.shopping.utils.a0 r3) {
        Intrinsics.checkNotNullParameter(r2, "skuSessionId");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.b.F(r2, r3);
    }

    public final boolean I() {
        return this.b.I();
    }

    public final SkuRestoreState P() {
        return this.b.P();
    }

    public final void S(String r2) {
        Intrinsics.checkNotNullParameter(r2, "specId");
        this.b.S(r2);
    }

    public final boolean X() {
        return this.b.X();
    }

    public final void d0(int r2) {
        this.b.d0(r2);
    }

    public final void e0(SkuRestoreState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.b.e0(r2);
    }

    public final void f0() {
        this.b.f0();
    }

    public final boolean h0() {
        return this.b.h0();
    }

    public final void l(SkuProductDetailInfo r2) {
        this.b.l(r2);
    }

    public final void n0(boolean r2) {
        this.b.n0(false);
    }

    public final void q(SkuRestoreState r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.b.q(r2, r3);
    }

    public final void v() {
        this.b.v();
    }

    public final void z() {
        this.b.z();
    }

    public final CommonMeta a() {
        return this.a.a();
    }

    public final boolean e() {
        return this.a.e();
    }

    public final String getSessionId() {
        return this.a.getSessionId();
    }

    public final Boolean i() {
        return this.a.i();
    }

    public final int r() {
        return this.a.r();
    }

    public final V4NativeParams w() {
        return this.a.c();
    }

    public final void g(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.a.g(r2);
    }

    public final void h(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "extraElementId");
        this.a.h(r2);
    }

    public final void k(SkuRestoreState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a.k(r2);
    }

    public BottomNavV1SkuDependency(d r2, j73.m r3) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        Intrinsics.checkNotNullParameter(r3, "eventChainDependency");
        this.b = r3;
        this.a = r2;
    }

    public final boolean m(IAction r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        this.a.m(r2, r3);
        return true;
    }

    public final void n(final String r12, final Map<String, ? extends Object> r13, final boolean r14, final boolean r15, final String r16, final PageFinder r17) {
        Intrinsics.checkNotNullParameter(r12, "eventName");
        this.a.d(new BottomNavV1SkuDependency$track$1(this, r13, r16, r17, r12, r15, r14));
    }
}
