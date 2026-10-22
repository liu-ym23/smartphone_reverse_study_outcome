package com.bytedance.android.shopping.slice.elements.bgdecorprojection;

import android.graphics.Bitmap;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements p {
    public final WeakReference<SlcBgDecorProjectionOptimizedView> a;
    public final Function0<Float> b;
    public final Function0<Integer> c;
    public final Function0<Boolean> d;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void a(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void c(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void d(boolean r1, int r2) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void e() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void f(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void h(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void k() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void m() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPageSelected(int r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPause() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onResume() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void p(String r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void t() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void u() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void v() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void w(int r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onDestroy() {
        SlcBgDecorProjectionOptimizedView r0 = this.a.get();
        if (r0 == null) goto L5;
        r0.s();
    L5:
        this.a.clear();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void s() {
        SlcBgDecorProjectionOptimizedView r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.o();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void A(boolean r2) {
        SlcBgDecorProjectionOptimizedView r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.q(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void i(float r2) {
        SlcBgDecorProjectionOptimizedView r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.r(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void q(AnchorV4HeadV2VO r5) {
        Intrinsics.checkNotNullParameter(r5, "headVo");
        SlcBgDecorProjectionOptimizedView r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.h(r5, ((Number) this.b.invoke()).floatValue(), ((Number) this.c.invoke()).intValue(), ((Boolean) this.d.invoke()).booleanValue());
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void n(int r4, Boolean r5) {
        SlcBgDecorProjectionOptimizedView r6 = this.a.get();
        if (r6 == null) goto L21;
        Iterator<SlcBgDecorProjectionOptimizedView.d> r0 = r6.o.iterator();
    L6:
        if (r0.hasNext() == false) goto L11;
        SlcBgDecorProjectionOptimizedView.d r1 = r0.next();
        if (r1.a != r4) goto L6;
        r0.remove();
        r6.o.addFirst(r1);
    L11:
        if (r6.w() == true) goto L22;
        int r2 = r6.f.a;
        if (r4 < 0) goto L24;
        if (r2 <= r4) goto L23;
        r6.e.scrollToPosition(r4);
        return;
    L23:
        return;
    L24:
        return;
    L22:
        return;
    }

    public a(SlcBgDecorProjectionOptimizedView r2, Function0<Float> r3, Function0<Integer> r4, Function0<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "projectionView");
        Intrinsics.checkNotNullParameter(r3, "scaleParamProvider");
        Intrinsics.checkNotNullParameter(r4, "itemSpaceProvider");
        Intrinsics.checkNotNullParameter(r5, "isExpandedProvider");
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.a = new WeakReference(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void j(int r1, ImageInfo r2, boolean r3, int r4) {
        if (r3 == true) goto L18;
        if (r4 <= 0) goto L6;
        return;
    L6:
        if ((r2 instanceof CloseableStaticBitmap) == true) goto L8;
        r2 = null;
    L8:
        CloseableStaticBitmap r5 = (CloseableStaticBitmap) r2;
        if (r5 == null) goto L19;
        CloseableReference<Bitmap> r6 = r5.cloneUnderlyingBitmapReference();
        if (r6 == null) goto L22;
        SlcBgDecorProjectionOptimizedView r7 = this.a.get();
        if (r7 == null) goto L16;
        r7.p(r1, r6);
        return;
    L16:
        r6.close();
        return;
    L22:
        return;
    L19:
        return;
    }
}
