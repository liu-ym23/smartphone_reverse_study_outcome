package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderSliceModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ScrollContainerFooter;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.BgDecorLayer;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends FrameLayout implements o<HeaderSliceModel>, com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p {
    public final BgDecorLayer a;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s b;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b c;

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
    public final void v() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void w(int r1) {
    }

    private final int getFooterHeight() {
        return this.c.e(false, -1);
    }

    public final void b() {
        int r1 = 0;
        if (this.b.isExpanded() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        ViewGroup.LayoutParams r2 = getLayoutParams();
        if (r0 == false) goto L11;
        int r3 = -2;
    L12:
        r2.width = r3;
        if (r0 == false) goto L15;
        r1 = getFooterHeight();
    L15:
        r2.height = r1;
        Unit r4 = Unit.INSTANCE;
        setLayoutParams(r2);
        return;
    L11:
        r3 = 0;
        goto L12
    L5:
        if (this.b.eI() == true) goto L7;
        r0 = true;
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void u() {
        AnchorV4HeadV2VO r0 = this.b.K10();
        if (r0 == null) goto L10;
        ScrollContainerFooter r1 = r0.getFooter();
        if (r1 == null) goto L11;
        IAction r2 = r1.getScrollAction();
        if (r2 == null) goto L12;
        this.b.yd().d(r2, this, null);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void s() {
        b();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void A(boolean r1) {
        b();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super.onDraw(r2);
        BgDecorLayer r0 = this.a;
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void q(AnchorV4HeadV2VO r2) {
        Intrinsics.checkNotNullParameter(r2, "headVo");
        Intrinsics.checkNotNullParameter(r2, "headVo");
    }

    public a(Context r7, com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s r8, com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "headAbility");
        Intrinsics.checkNotNullParameter(r9, "sizeHelper");
        super(r7);
        this.b = r8;
        this.c = r9;
        r8.eh().x(this);
        setLayoutParams(new ViewGroup.LayoutParams(-2, getFooterHeight()));
        b();
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.d == false) goto L6;
        this.a = new BgDecorLayer(r8, this, false, true, 4);
        setWillNotDraw(false);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o
    public final /* bridge */ /* synthetic */ void l(HeaderSliceModel r1, int r2, Integer r3) {
    }
}
