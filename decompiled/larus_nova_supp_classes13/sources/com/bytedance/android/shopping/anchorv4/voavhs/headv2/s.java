package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.model.ECUrlModel;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p {
    public final int a;
    public final /* synthetic */ t b;

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
    public final void j(int r1, ImageInfo r2, boolean r3, int r4) {
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
    public final void onDestroy() {
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

    public s(t r1) {
        this.b = r1;
        this.a = r1.a.getCurrentPosition();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPageSelected(int r18) {
        if (r18 <= this.a) goto L5;
        boolean r2 = true;
    L6:
        int r5 = PdpPerfOpt.b().d();
        int r6 = 0;
    L7:
        if (r6 >= r5) goto L26;
        t r7 = this.b;
        if (r2 == false) goto L11;
        int r8 = (r18 + 1) + r6;
    L12:
        AnchorV4HeadV2VO r9 = r7.a.K10();
        if (r9 == null) goto L25;
        List<HeaderContentModel> r10 = r9.getCells();
        if (r10 == null) goto L25;
        HeaderContentModel r11 = (HeaderContentModel) CollectionsKt.getOrNull(r10, r8);
        if (r11 == null) goto L25;
        HeaderMediaModel r12 = r11.getMedia();
        if (r12 == null) goto L25;
        ECUrlModel r13 = HeaderMediaModel.getImageUrl$default(r12, false, 1, null);
        if (r13 == null) goto L25;
        String r14 = r13.getFirstUrl();
        if (r14 == null) goto L25;
        int r15 = com.bytedance.android.ec.core.imagex.r.h;
        ImageExtensionsKt.B(r14, com.bytedance.android.ec.core.imagex.r.a.a("ec_product_header_image"), null, null, Priority.IMMEDIATE, null, null, false, 192);
    L25:
        r6 = r6 + 1;
        goto L7
    L11:
        r8 = (r18 - 1) - r6;
        goto L12
    L26:
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void q(AnchorV4HeadV2VO r2) {
        Intrinsics.checkNotNullParameter(r2, "headVo");
        Intrinsics.checkNotNullParameter(r2, "headVo");
    }
}
