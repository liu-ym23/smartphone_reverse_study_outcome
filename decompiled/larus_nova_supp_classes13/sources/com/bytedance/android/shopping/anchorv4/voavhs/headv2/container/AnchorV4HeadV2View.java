package com.bytedance.android.shopping.anchorv4.voavhs.headv2.container;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.abtest.d;
import com.bytedance.android.shopping.anchorv4.containers.g;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.PdpHeadPerfOptManager$setup$1;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.e;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.HeadPagerSnapHelper;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.PreloadLinearLayoutManager;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.SnapOnScrollListener;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.BgDecorLayer;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.h;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.t;
import com.bytedance.android.shopping.utils.j0;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AnchorV4HeadV2View extends FrameLayout implements p {
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b a;
    public final HeadRecyclerView b;
    public final HeadPagerSnapHelper c;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.c d;
    public final HeadAdapter e;
    public final h f;
    public final View g;
    public View h;
    public final BgDecorLayer i;
    public boolean j;
    public final s k;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AnchorV4HeadV2View a;

        public a(AnchorV4HeadV2View r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            g r4 = this.a.k.rR().k0();
            if (r4 == null) goto L6;
            r4.b(true, true, false);
            return;
        }
    }

    public static final class b implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.a {
        public final /* synthetic */ AnchorV4HeadV2View a;

        public b(AnchorV4HeadV2View r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.a
        public final void a(int r4) {
            e.b r0 = this.a.k.eh();
            if (this.a.e.getItemViewType(r4) != 1) goto L6;
            if (r4 <= 0) goto L6;
            r4 = r4 - 1;
        L6:
            r0.onPageSelected(r4);
        }
    }

    public static final class c {
    }

    static {
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
    public final void u() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void v() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void w(int r1) {
    }

    public final void b() {
        boolean r0 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.d == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.c == false) goto L14;
        ViewGroup.LayoutParams r1 = getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r1 = null;
    L9:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (r2 == null) goto L15;
        r2.topMargin = this.k.FB();
        setLayoutParams(r2);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void s() {
        this.d.a();
    }

    private final void setIsFullScreenMode(boolean r2) {
        if (r2 == false) goto L5;
        this.c.attachToRecyclerView(this.b);
        return;
    L5:
        if (this.a.o() == false) goto L7;
        this.c.attachToRecyclerView(null);
        return;
    L7:
        this.c.attachToRecyclerView(this.b);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void A(boolean r2) {
        this.d.c(r2);
        b();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void i(float r3) {
        this.d.f(r3);
        View r0 = this.g;
        if (r0 == null) goto L5;
        r0.setAlpha(1 - r3);
    L5:
        b();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void q(AnchorV4HeadV2VO r2) {
        Intrinsics.checkNotNullParameter(r2, "headVo");
        Intrinsics.checkNotNullParameter(r2, "headVo");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.view.View, android.view.ViewGroup, androidx.recyclerview.widget.RecyclerView, com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.HeadRecyclerView] */
    public AnchorV4HeadV2View(Context r8, s r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "headAbility");
        super(r8);
        this.k = r9;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b r0 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b(r8, r9);
        this.a = r0;
        ?? r3 = new HeadRecyclerView(r8, r9, r0);
        r3.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        PreloadLinearLayoutManager r1 = new PreloadLinearLayoutManager(r8, r3.getHeadAbility());
        r1.setOrientation(0);
        Unit r5 = Unit.INSTANCE;
        r3.setLayoutManager(r1);
        ViewCompat.setNestedScrollingEnabled(r3, false);
        this.b = r3;
        HeadPagerSnapHelper r2 = new HeadPagerSnapHelper(r3, r9);
        this.c = r2;
        this.d = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.c(r9, r3, r0, r2);
        HeadAdapter r6 = new HeadAdapter(r0, r9, r3);
        this.e = r6;
        h r4 = new h(r8, r9);
        this.f = r4;
        r9.D6(r3);
        this.h = r3.getChildAt(0);
        r3.addOnScrollListener(new SnapOnScrollListener(r2, r9, new b(this)));
        r3.addOnScrollListener(new AnonymousClass2(this));
        addView(r3);
        r3.setAdapter(r6);
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(r4);
        r9.eh().x(this);
        setIsFullScreenMode(r9.n0());
        if (r9.n0() == true) goto L6;
        ImageView r7 = new ImageView(r8);
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.a(28), com.bytedance.android.shopping.extensions.b.a(28));
        r10.gravity = 53;
        r10.rightMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r10.topMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r7.setLayoutParams(r10);
        r7.setScaleType(ImageView.ScaleType.FIT_XY);
        r7.setImageResource(2131233377);
        r7.setOnClickListener(new a(this));
        this.g = r7;
        addView(r7);
    L6:
        if (j0.a == false) goto L13;
        View r11 = new View(getContext());
        Lazy r12 = PdpAB.a;
        if (d.a() == false) goto L10;
        r11.setBackgroundColor(-16776961);
    L11:
        r11.setAlpha(0.7f);
        r11.setOnClickListener(i83.a.a);
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.a(35), com.bytedance.android.shopping.extensions.b.a(35));
        r13.gravity = 19;
        addView(r11, r13);
        goto L13
    L10:
        r11.setBackgroundColor(-65536);
    L13:
        if (r9.rR().d() == false) goto L18;
        View r14 = this.g;
        if (r14 == null) goto L18;
        r14.setVisibility(8);
    L18:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.d == false) goto L20;
        this.i = new BgDecorLayer(r9, r3, true, false, 8);
    L20:
        final t r15 = r9.hq();
        RecyclerView r16 = r15.a.getRecyclerView();
        if (r16 == null) goto L23;
        r16.addOnScrollListener(new PdpHeadPerfOptManager$setup$1(r15));
    L23:
        r15.a.eh().x(new com.bytedance.android.shopping.anchorv4.voavhs.headv2.s(r15));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void n(int r5, Boolean r6) {
        if (r5 >= 0) goto L4;
        return;
    L4:
        if (r5 >= this.e.getItemCount()) goto L29;
        this.k.pK(Integer.valueOf(r5));
        if (s.a.b(this.k, Integer.valueOf(r5), 2) == false) goto L26;
        int r7 = this.a.l(this.k.isExpanded(), r5);
        AnchorV4HeadV2VO r0 = this.k.K10();
        if (r0 == null) goto L10;
        int r1 = r0.getLastScaleIndex();
    L11:
        if (r5 != r1) goto L13;
        boolean r2 = true;
    L14:
        RecyclerView.LayoutManager r3 = this.b.getLayoutManager();
        if ((r3 instanceof LinearLayoutManager) == true) goto L17;
        r3 = null;
    L17:
        LinearLayoutManager r4 = (LinearLayoutManager) r3;
        if (r7 > 0) goto L20;
    L24:
        if (r4 == null) goto L32;
        r4.scrollToPositionWithOffset(r5, (this.b.getWidth() - r7) - this.a.h(this.k.isExpanded(), r5));
        return;
    L32:
        return;
    L20:
        if (r7 >= this.b.getWidth()) goto L24;
        if (r2 == true) goto L24;
        if (r4 == null) goto L30;
        r4.scrollToPositionWithOffset(r5, (this.b.getWidth() - r7) / 2);
        return;
    L30:
        return;
    L13:
        r2 = false;
        goto L14
    L10:
        r1 = -1;
        goto L11
    L26:
        this.b.scrollToPosition(r5);
        return;
    }
}
