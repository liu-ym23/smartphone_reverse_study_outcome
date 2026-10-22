package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.content.Context;
import android.graphics.Rect;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ecom.arch.slice.action.ActionContext;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class a implements i0, com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r {
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r a;
    public final GalleryFromType b;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i0
    public Rect a(q r1) {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i0
    public void b(q r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i0
    public void d(q r1, h r2) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i0
    public void e(int r1, q r2, boolean r3) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final String getSessionId() {
        return this.a.getSessionId();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final void k0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sliceId");
        this.a.k0(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final void l0(int r2, String r3) {
        this.a.l0(r2, r3);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final boolean m0(Boolean r2, boolean r3) {
        return this.a.m0(r2, r3);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final ActionContext n0() {
        return this.a.n0();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n o0() {
        return this.a.o0();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.q p0() {
        return this.a.p0();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.p q0() {
        return this.a.q0();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final ng3.a r0() {
        return this.a.r0();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final GalleryVO s0() {
        return this.a.s0();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final com.bytedance.android.ecom.arch.slice.action.j t0(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return this.a.t0(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final com.bytedance.android.ecom.arch.slice.action.p u0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return this.a.u0(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final String v0() {
        return this.a.v0();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final void w0(boolean r2) {
        this.a.w0(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final com.bytedance.android.shopping.anchorv4.video.f x0() {
        return this.a.x0();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
    public final String y0() {
        return this.a.y0();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i0
    public final GalleryFromType c() {
        return this.b;
    }

    public a(com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r r2, GalleryFromType r3) {
        Intrinsics.checkNotNullParameter(r2, "galleryDependency");
        Intrinsics.checkNotNullParameter(r3, "fromType");
        this.a = r2;
        this.b = r3;
    }
}
