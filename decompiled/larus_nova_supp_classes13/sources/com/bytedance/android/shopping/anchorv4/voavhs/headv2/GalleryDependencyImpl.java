package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ecom.arch.slice.action.ActionContext;
import com.bytedance.android.shopping.anchorv4.containers.page.PdContext;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryVO;
import com.bytedance.android.shopping.anchorv4.event_chain.PDPYataCommonEventService;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class GalleryDependencyImpl implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r {
    public final d a;
    public final AnchorV4VM b;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final String getSessionId() {
        return this.b.getSessionId();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final ActionContext n0() {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v r0 = this.b.getHeadViewAbilityV2New();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.n0();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final q p0() {
        return new v(this.b, this.a);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final p q0() {
        return new u(this.b);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final ng3.a r0() {
        return new com.bytedance.android.shopping.anchorv4.event_chain.e(this.b);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final GalleryVO s0() {
        return (GalleryVO) this.b.getState(GalleryDependencyImpl$getGalleryVO$1.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final String v0() {
        PdContext r0 = this.b.getPdContext();
        if (r0 == null) goto L9;
        AnchorV4Param r1 = r0.d;
        if (r1 == null) goto L9;
        V4NativeParams r2 = r1.getNativeParams();
        if (r2 == null) goto L9;
        return r2.getPdpEventTransparentId();
    L9:
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final com.bytedance.android.shopping.anchorv4.video.f x0() {
        return this.b.getPlayerStateManager();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final String y0() {
        SkuRestoreState r0 = this.b.skuStore();
        if (r0 == null) goto L7;
        String[] r1 = r0.getSelectSkuKeys();
        if (r1 == null) goto L7;
        return (String) ArraysKt.firstOrNull(r1);
    L7:
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n o0() {
        return this.a;
    }

    public GalleryDependencyImpl(AnchorV4VM r2) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        this.b = r2;
        this.a = new d(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final void k0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sliceId");
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v r0 = this.b.getHeadViewAbilityV2New();
        if (r0 == null) goto L6;
        r0.k0(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final com.bytedance.android.ecom.arch.slice.action.j t0(FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        return new PDPYataCommonEventService(r3, this.b);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final com.bytedance.android.ecom.arch.slice.action.p u0(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        return new di3.d(r3, this.b);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final void w0(boolean r1) {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v r2 = this.b.getHeadViewAbilityV2New();
        if (r2 == null) goto L6;
        r2.r9();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final void l0(int r2, String r3) {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v r0 = this.b.getHeadViewAbilityV2New();
        if (r0 == null) goto L6;
        r0.l0(r2, r3);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final boolean m0(Boolean r2, boolean r3) {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v r0 = this.b.getHeadViewAbilityV2New();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.m0(r2, r3) != true) goto L7;
        return true;
    }
}
