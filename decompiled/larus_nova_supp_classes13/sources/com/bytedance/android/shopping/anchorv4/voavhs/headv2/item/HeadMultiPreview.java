package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.ec.hybrid.tools.TransitionAnimationHelper;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderSliceModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.d0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.ItemMediaLayer;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class HeadMultiPreview extends LinearLayout implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p {
    public final LinearLayout a;
    public final LinearLayout b;
    public List<HeaderContentModel> c;
    public HeaderContentModel d;
    public final List<ItemMediaLayer> e;
    public int f;
    public boolean g;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s h;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b i;

    public static final class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ HeadMultiPreview a;

        public a(HeadMultiPreview r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            this.a.h.eh().x(this.a);
            this.a.r();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            this.a.h.eh().z(this.a);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ HeadMultiPreview b;
        public final /* synthetic */ HeaderContentModel c;
        public final /* synthetic */ int d;
        public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.headv2.k e;

        public b(View r1, HeadMultiPreview r2, HeaderContentModel r3, int r4, com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            IAction r10 = this.c.getClickAction();
            if (r10 == null) goto L13;
            d0 r1 = this.b.h.yd();
            View r2 = this.a;
            Pair[] r3 = new Pair[3];
            HeaderMediaModel r4 = this.c.getMedia();
            if (r4 == null) goto L7;
            VideoModel r5 = r4.getVideo();
        L9:
            if (r5 == null) goto L11;
            boolean r6 = true;
        L12:
            r3[0] = TuplesKt.to("disable_gallery_anim", Boolean.valueOf(r6));
            r3[1] = TuplesKt.to("multi_position", Integer.valueOf(this.d));
            r3[2] = TuplesKt.to("index", Integer.valueOf(this.b.f));
            r1.d(r10, r2, MapsKt.mutableMapOf(r3));
            goto L13
        L11:
            r6 = false;
            goto L12
        L7:
            r5 = null;
        L13:
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r11 = this.e;
            if (r11 == null) goto L19;
            IAction r12 = r11.b();
            if (r12 == null) goto L20;
            this.b.h.yd().d(r12, this.b, null);
            return;
        L20:
            return;
        }
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

    public final void r() {
        if (this.h.wq() == false) goto L5;
        setPadding(0, 0, 0, 0);
        return;
    L5:
        int r0 = com.bytedance.android.shopping.utils.x.a;
        float r1 = com.bytedance.android.ec.core.utils.q.a(12);
        float r2 = com.bytedance.android.ec.core.utils.q.a(44);
        float r3 = r2 - r1;
        int r4 = (int) (r1 + (r3 * this.h.HG()));
        int r5 = com.bytedance.android.ec.hybrid.list.util.c.a;
        setPadding(com.bytedance.android.ec.hybrid.list.util.c.d(12), r4, com.bytedance.android.ec.hybrid.list.util.c.d(12), com.bytedance.android.ec.hybrid.list.util.c.d(20));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.h.rR().b0() == true) goto L33;
        List<HeaderContentModel> r0 = this.c;
        if (r0 == null) goto L16;
        Iterator r1 = ((ArrayList) r0).iterator();
    L8:
        if (r1.hasNext() == false) goto L16;
        HeaderContentModel r2 = (HeaderContentModel) r1.next();
        if (r2 == null) goto L8;
        HeaderSliceModel r3 = r2.getSlice();
        if (r3 == null) goto L8;
        IAction r4 = r3.getShowActions();
        if (r4 == null) goto L8;
        this.h.yd().d(r4, this, null);
    L16:
        HeaderContentModel r5 = this.d;
        if (r5 == null) goto L34;
        HeaderSliceModel r6 = r5.getSlice();
        if (r6 == null) goto L35;
        IAction r7 = r6.getShowActions();
        if (r7 == null) goto L36;
        this.h.yd().d(r7, this, null);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void A(boolean r1) {
        r();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void i(float r1) {
        r();
    }

    public final HeaderContentModel l(com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r3) {
        HeaderContentModel r0 = r3.a();
        if (r0 != null) goto L12;
        Integer r4 = r3.c();
        if (r4 == null) goto L13;
        int r5 = r4.intValue();
        AnchorV4HeadV2VO r1 = this.h.K10();
        if (r1 == null) goto L14;
        List<HeaderContentModel> r2 = r1.getCells();
        if (r2 != null) goto L11;
        return null;
    L11:
        return (HeaderContentModel) CollectionsKt.getOrNull(r2, r5);
    L14:
        return null;
    L13:
        return null;
    L12:
        return r0;
    }

    public final void o(View r3) {
        if (r3 != null) goto L7;
        ItemMediaLayer r4 = (ItemMediaLayer) CollectionsKt.firstOrNull(this.e);
        if (r4 == null) goto L6;
        r3 = r4.b;
        goto L7
    L6:
        r3 = null;
    L7:
        if (r3 == null) goto L10;
        TransitionAnimationHelper.e(r3, 0.0f, true);
        r3.setPadding(0, 0, 0, 0);
        r3.setBackgroundColor(0);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void q(AnchorV4HeadV2VO r2) {
        Intrinsics.checkNotNullParameter(r2, "headVo");
        Intrinsics.checkNotNullParameter(r2, "headVo");
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        int r0 = View.MeasureSpec.getSize(r4);
        g(r0, this.a, 0);
        g(r0, this.b, 1);
        super.onMeasure(r4, r5);
    }

    public HeadMultiPreview(Context r3, com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s r4, com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "headAbility");
        Intrinsics.checkNotNullParameter(r5, "sizeHelper");
        super(r3);
        this.h = r4;
        this.i = r5;
        this.e = new ArrayList();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(0);
        LinearLayout r6 = new LinearLayout(getContext());
        r6.setOrientation(1);
        r6.setClipChildren(false);
        r6.setClipToPadding(false);
        this.a = r6;
        Unit r0 = Unit.INSTANCE;
        addView(r6, -2, -2);
        LinearLayout r7 = new LinearLayout(getContext());
        r7.setOrientation(1);
        r7.setClipChildren(false);
        r7.setClipToPadding(false);
        this.b = r7;
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-2, -2);
        int r9 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r8.leftMargin = com.bytedance.android.ec.hybrid.list.util.c.d(6);
        addView(r7, r8);
        addOnAttachStateChangeListener(new a(this));
    }

    public final void g(int r6, ViewGroup r7, int r8) {
        boolean r0 = this.h.wq();
        int r1 = k83.a.a;
        int r9 = (int) (r6 * k83.a.a(this.h.XU(), r8));
        if (r8 == 0) goto L5;
        int r2 = -2;
    L9:
        int r3 = r7.getChildCount();
        int r4 = 0;
    L10:
        if (r4 >= r3) goto L12;
        View r5 = r7.getChildAt(r4);
        r5.getLayoutParams().width = r9;
        r5.getLayoutParams().height = r9;
        r4 = r4 + 1;
        goto L10
    L12:
        if (r8 == 0) goto L14;
    L15:
        r7.getLayoutParams().width = r2;
        r7.getLayoutParams().height = r2;
        return;
    L14:
        if (this.g == false) goto L15;
        return;
    L5:
        if (r0 == false) goto L7;
        r9 = -1;
    L7:
        r2 = r9;
        r9 = -1;
        goto L9
    }

    public final void b(ItemMediaLayer r11, HeaderContentModel r12, com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r13, int r14) {
        if (r12.getMedia() != null) goto L5;
    L8:
        ViewGroup r0 = r11.b;
        if ((r0 instanceof ViewGroup) == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L30;
        int r2 = r0.getChildCount() - 1;
    L15:
        if (r2 < 0) goto L24;
        View r5 = r0.getChildAt(r2);
        if (r5 == null) goto L19;
        Object r6 = r5.getTag();
    L21:
        if (Intrinsics.areEqual(r6, "head_multi_preview_slice") == false) goto L23;
        r0.removeViewAt(r2);
    L23:
        r2 = r2 - 1;
        goto L15
    L19:
        r6 = null;
        goto L21
    L24:
        HeaderSliceModel r3 = r12.getSlice();
        if (r3 == null) goto L30;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i r4 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i(this.h);
        r4.b(r3, this.f, Integer.valueOf(r14));
        View r7 = r4.a;
        if (r7 == null) goto L30;
        wg.a.a(r7);
        r7.setTag("head_multi_preview_slice");
        r0.addView(r7, new ViewGroup.LayoutParams(-1, -1));
    L30:
        ViewGroup r15 = r11.b;
        Lazy r1 = TransitionAnimationHelper.a;
        if (this.h.wq() == false) goto L33;
        float r8 = 0.0f;
    L34:
        TransitionAnimationHelper.e(r15, r8, true);
        r15.setOnClickListener(new b(r15, this, r12, r14, r13));
        return;
    L33:
        r8 = 12.0f;
        goto L34
    L5:
        if (r12.getMedia().getVideo() != null) goto L7;
        r11.b.setBackgroundColor(-1);
    L7:
        r11.i = new HeadMultiPreview$bindMediaLayer$1(this, r11, r12, r13);
        r11.B(r12.getMedia(), this.f, Integer.valueOf(r14));
        goto L8
    }
}
