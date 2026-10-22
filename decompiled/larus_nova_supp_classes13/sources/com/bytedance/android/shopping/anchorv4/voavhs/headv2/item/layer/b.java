package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer;

import android.graphics.Bitmap;
import androidx.core.view.ViewCompat;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements p {
    public final /* synthetic */ BgDecorLayer a;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void A(boolean r1) {
    }

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
    public final void i(float r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void k() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void m() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void n(int r1, Boolean r2) {
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
    public final void s() {
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
        BgDecorLayer r0 = this.a;
        CloseableReference<Bitmap> r1 = r0.f;
        if (r1 == null) goto L5;
        r1.close();
    L5:
        r0.f = null;
    }

    public b(BgDecorLayer r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void q(AnchorV4HeadV2VO r2) {
        Intrinsics.checkNotNullParameter(r2, "headVo");
        Intrinsics.checkNotNullParameter(r2, "headVo");
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void j(int r2, ImageInfo r3, boolean r4, int r5) {
        boolean r6 = ViewCompat.isAttachedToWindow(this.a.h);
        Integer r0 = this.a.b;
        if (r0 == null) goto L8;
        if (r2 != r0.intValue()) goto L8;
    L10:
        if (r5 > 0) goto L32;
        HeaderContentModel r7 = this.a.a;
        if (r7 == null) goto L18;
        HeaderMediaModel r8 = r7.getMedia();
        if (r8 == null) goto L18;
        boolean r9 = true;
        if (r8.getDisableNavDecor() != true) goto L18;
    L19:
        if (r9 == true) goto L33;
        BgDecorLayer r10 = this.a;
        CloseableReference<Bitmap> r1 = null;
        if ((r3 instanceof CloseableStaticBitmap) == true) goto L23;
        r3 = null;
    L23:
        CloseableStaticBitmap r11 = (CloseableStaticBitmap) r3;
        if (r11 == null) goto L26;
        r1 = r11.cloneUnderlyingBitmapReference();
    L26:
        r10.f = r1;
        if (r6 == false) goto L34;
        this.a.h.invalidate();
        return;
    L34:
        return;
    L33:
        return;
    L18:
        r9 = false;
        goto L19
    L32:
        return;
    L8:
        if (this.a.i == false) goto L30;
        if (r2 == 0) goto L10;
        return;
    }
}
