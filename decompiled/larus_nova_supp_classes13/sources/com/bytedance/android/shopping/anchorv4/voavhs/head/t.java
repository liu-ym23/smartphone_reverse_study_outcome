package com.bytedance.android.shopping.anchorv4.voavhs.head;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.shopping.anchorv3.comment.model.StatTagItem;
import com.bytedance.android.shopping.anchorv4.data.FindSameSource;
import com.bytedance.android.shopping.anchorv4.video.AnchorV4PlayerStateManager;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4DownTabIndicator;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4HeadIndicator;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t implements com.bytedance.android.shopping.anchorv4.voavhs.head.base.d {
    public final /* synthetic */ SlidesAndIndicatorV4Component a;

    public static final class a implements Runnable {
        public final /* synthetic */ t a;

        public a(t r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnchorV4VM r0 = (AnchorV4VM) this.a.a.E.invoke();     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            com.bytedance.android.shopping.anchorv4.containers.g r1 = r0.containerAbility();     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            r1.a();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void b() {
        l r0 = this.a.d;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final AnchorV4PlayerStateManager e() {
        AnchorV4VM r0 = (AnchorV4VM) this.a.E.invoke();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPlayerStateManager();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final Object f() {
        return this.a.F.invoke();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final Integer getDefaultIndex() {
        Integer r0 = this.a.r;
        if (r0 != null) goto L5;
    L14:
        return null;
    L5:
        if (r0.intValue() < 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L14;
        r0.intValue();
        return this.a.r;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final boolean l() {
        return this.a.j;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final boolean m() {
        if (this.a.q == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final boolean n() {
        return this.a.z.a();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void o() {
        this.a.y.z();
        com.bytedance.android.shopping.anchorv4.containers.i r0 = this.a.b;
        if (r0 == null) goto L6;
        r0.t();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final g83.a q() {
        return this.a.c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final c63.d t() {
        return this.a.y;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void u() {
        this.a.y.i();
        com.bytedance.android.shopping.anchorv4.containers.e r2 = this.a.a;
        if (r2 == null) goto L6;
        com.bytedance.android.shopping.anchorv4.containers.e.a.a(r2, new StatTagItem(1, 0, null, null, 0, false, null, 0, 254, null), 2, null, null, 12);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final c63.b u1() {
        return this.a.C;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void v() {
        this.a.v.post(new a(this));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final boolean i() {
        if (s73.b.b() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.a.j == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final SlidesAndIndicatorV4Component r() {
        return this.a;
    }

    public t(SlidesAndIndicatorV4Component r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void a(boolean r3) {
        if (r3 == false) goto L4;
        ViewExtensionsKt.c(this.a.w, false, 3);
        return;
    L4:
        ViewExtensionsKt.i(this.a.w);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void c(float r2) {
        if (this.a.z.a() == false) goto L8;
        l r0 = this.a.d;
        if (r0 == null) goto L9;
        r0.c(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void h(boolean r2) {
        f83.k r0 = this.a.f;
        if (r0 == null) goto L6;
        r0.h(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void p(boolean r3) {
        f83.k r0 = this.a.f;
        if (r0 == null) goto L12;
        AnchorV4HeadIndicator r1 = r0.a;
        if (r1.d == true) goto L13;
        TextView r2 = r1.h;
        if (r3 == false) goto L9;
        int r4 = 0;
    L10:
        r2.setVisibility(r4);
        return;
    L9:
        r4 = 8;
        goto L10
    L13:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void j(AnchorV4HeadViewPager.a r2, FindSameSource r3) {
        Intrinsics.checkNotNullParameter(r2, "req");
        Intrinsics.checkNotNullParameter(r3, "source");
        this.a.B.j(r2, r3);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void s(Integer r9, int r10) {
        int r0 = this.a.v.getId();
        if (z53.b.a == r0) goto L5;
        z53.b.a = r0;
        z53.b.b = 0;
    L5:
        long r1 = System.currentTimeMillis();
        if ((r1 - z53.b.b) >= 500) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        z53.b.b = r1;
    L11:
        if (r2 == true) goto L14;
        this.a.l(r9, r10, false);
        SlidesAndIndicatorV4Component r11 = this.a;
        System.currentTimeMillis();
        r11.getClass();
        return;
    L14:
        return;
    L8:
        r2 = false;
        goto L9
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void g(String r2, com.bytedance.android.shopping.anchorv4.dto.business.d r3, Integer r4) {
        this.a.B.g(r2, r3, r4);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void k(boolean r13, String r14, String r15) {
        f83.k r0 = this.a.f;
        if (r0 == null) goto L57;
        AnchorV4HeadIndicator r1 = r0.a;
        if (r1.i != null) goto L15;
        Context r2 = r1.getContext();
        if (r1.c == false) goto L9;
        int r7 = 2131560510;
    L10:
        View r3 = View.inflate(r2, r7, null);
        r1.i = r3;
        if (r1.c == false) goto L13;
        int r8 = 20;
    L14:
        r1.addView(r3, new FrameLayout.LayoutParams(-1, com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r8))));
        goto L15
    L13:
        r8 = 24;
        goto L14
    L9:
        r7 = 2131560509;
    L15:
        View r4 = r1.i;
        int r9 = 0;
        if (r4 == null) goto L29;
        if (r13 == false) goto L19;
        int r11 = 0;
    L20:
        r4.setVisibility(r11);
        TextView r12 = (TextView) r4.findViewById(2131386870);
        if (r12 == null) goto L23;
        r12.setText(r14);
        r12.setVisibility(0);
    L23:
        TextView r16 = (TextView) r4.findViewById(2131386848);
        if (r16 == null) goto L26;
        r16.setText(r15);
    L26:
        TextView r5 = (TextView) r4.findViewById(2131386867);
        if (r5 == null) goto L29;
        r5.setText(r15);
        goto L29
    L19:
        r11 = 8;
    L29:
        r1.h(false);
        if (r1.d == true) goto L32;
        r1.h.setVisibility(8);
    L32:
        AnchorV4DownTabIndicator r17 = r0.b;
        if (r17 != null) goto L35;
        return;
    L35:
        if (r17.b != null) goto L37;
        View r6 = View.inflate(r17.getContext(), 2131560510, null);
        r17.b = r6;
        r17.addView(r6, new FrameLayout.LayoutParams(-1, com.bytedance.android.shopping.extensions.b.b(20)));
    L37:
        View r10 = r17.b;
        if (r10 == null) goto L48;
        if (r13 == true) goto L42;
        r9 = 8;
    L42:
        r10.setVisibility(r9);
        TextView r18 = (TextView) r10.findViewById(2131386870);
        if (r18 == null) goto L45;
        r18.setText(r14);
    L45:
        TextView r19 = (TextView) r10.findViewById(2131386848);
        if (r19 == null) goto L48;
        r19.setVisibility(8);
    L48:
        Integer r110 = r17.e;
        if (r110 != null) goto L52;
    L53:
        FrameLayout r111 = r17.j;
        if (r111 == null) goto L60;
        wg.a.h(r111, r13);
        return;
    L60:
        return;
    L52:
        if (r110.intValue() != 0) goto L53;
        return;
    }
}
