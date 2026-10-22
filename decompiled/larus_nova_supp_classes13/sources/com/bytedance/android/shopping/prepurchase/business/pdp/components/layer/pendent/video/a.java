package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.shopping.legacy.DragRelativeLayout;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements s {
    public DragRelativeLayout a;
    public e b;
    public boolean c;
    public long d;
    public boolean e;
    public boolean f;
    public final c g;
    public final n h;
    public final d i;
    public final l j;
    public final g k;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a$a, reason: collision with other inner class name */
    public static final class C0160a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.s
    public final void Q0() {
        if (this.k.a() == false) goto L7;
        if (this.j.a() == false) goto L7;
        return;
    L7:
        if (c() == false) goto L13;
        this.e = true;
        e r0 = this.b;
        if (r0 == null) goto L13;
        com.bytedance.android.shopping.anchorv4.video.f r1 = ((com.bytedance.android.shopping.anchorv4.video.d) r0).d;
        if (r1 == null) goto L13;
        r1.a(r0);
    L13:
        pause();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.s
    public final void a() {
        c r0 = this.g;
        r0.getClass();
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L7;
        x73.c r1 = r0.d.j.c.g;
        if (r1 == null) goto L11;
        r1.g(r0.c, Boolean.TRUE);
        return;
    L11:
        return;
    L7:
        x73.c r2 = r0.d.j.c.g;
        if (r2 == null) goto L13;
        x73.d r3 = r0.c;
        boolean r4 = x73.c.f;
        r2.h(r3, null);
        return;
    }

    public final boolean c() {
        if (this.j.a() == false) goto L5;
    L9:
        gj.b r0 = this.g.e();
        if (r0 != null) goto L12;
    L14:
        return false;
    L12:
        if (r0.isPlaying() != true) goto L14;
        return true;
    L5:
        if (this.j.c.f == false) goto L9;
        if (this.f == true) goto L9;
        return true;
    }

    public final void d() {
        gj.b r0 = this.g.e();
        if (r0 == null) goto L6;
        r0.play();
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.s
    public final void onPageDestroy() {
        t.a.a(this.g, false, true, false, false, 12);
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.s
    public final void pause() {
        gj.b r0 = this.g.e();
        if (r0 == null) goto L5;
        r0.pause();
    L5:
        this.f = true;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.s
    public final void resume() {
        gj.b r0 = this.g.e();
        if (r0 == null) goto L6;
        r0.resume();
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.s
    public final void show() {
        DragRelativeLayout r0 = new DragRelativeLayout(this.j.getContext());
        r0.setDockMode(2);
        boolean r1 = false;
        r0.b = 0;
        r0.d = 0;
        r0.c = 0;
        r0.e = 0;
        r0.setOnViewPositionChanged(new FloatVideo$initView$$inlined$apply$lambda$1(this));
        r0.setEnableKeepLayout(true);
        n r3 = this.h;
        RelativeLayout.LayoutParams r4 = new RelativeLayout.LayoutParams(-2, -2);
        y r5 = this.j.d;
        r4.topMargin = r5.a;
        if (r5.b == false) goto L5;
        r4.addRule(11, -1);
    L5:
        Unit r6 = Unit.INSTANCE;
        r0.addView(r3, r4);
        r0.b();
        this.j.b.addView(r0);
        this.a = r0;
        if (this.j.d.f == false) goto L18;
        this.h.setVisibility(4);
        n r7 = this.h;
        if (ViewCompat.isLaidOut(r7) == true) goto L10;
    L16:
        r7.addOnLayoutChangeListener(new f(this, r0));
        goto L18
    L10:
        if (r7.isLayoutRequested() == true) goto L16;
        r7.setVisibility(0);
        if (this.j.d.b == false) goto L14;
        r7.setTranslationX(r0.getWidth() - r7.getLeft());
    L15:
        r7.animate().translationX(0.0f).setDuration(300).start();
        goto L18
    L14:
        r7.setTranslationX(-r7.getRight());
    L18:
        if (this.j.c.f == true) goto L21;
        this.h.b();
    L21:
        if (this.b != null) goto L23;
        x r8 = this.j.c;
        e r2 = new e(this, r8.a, r8.b);
        this.j.c.a.c(r2);
        this.b = r2;
    L23:
        Boolean r9 = this.j.c.c;
        if (r9 == null) goto L26;
        this.g.b = r9.booleanValue();
    L33:
        gj.b r10 = this.g.e();
        if (r10 == null) goto L36;
        r10.a(this.g.b);
    L36:
        this.h.a();
        d r11 = this.i;
        boolean r12 = this.g.b;
        r11.getClass();
        if (r12 == true) goto L39;
        String r13 = "open";
    L40:
        r11.b("pd_sound_icon_show", MapsKt.mapOf(TuplesKt.to("icon_status", r13)));
        if (this.j.c.f == true) goto L43;
    L58:
        u r14 = this.j.e;
        if (r14 == null) goto L62;
        r14.onShow();
        return;
    L62:
        return;
    L43:
        if (this.g.d.j.c.g == null) goto L45;
        r1 = true;
    L45:
        if (r1 == true) goto L47;
        d();
    L51:
        if (c() == false) goto L58;
        Float r15 = this.j.c.h;
        if (r15 == null) goto L57;
        float r16 = r15.floatValue();
        gj.b r17 = this.g.e();
        if (r17 == null) goto L57;
        r17.seek(r16);
    L57:
        this.c = true;
        goto L58
    L47:
        if (c() == true) goto L51;
        d();
        goto L51
    L39:
        r13 = FreqActions.ACTION_CLOSE;
        goto L40
    L26:
        c r18 = this.g;
        e r19 = this.b;
        if (r19 == null) goto L31;
        com.bytedance.android.shopping.anchorv4.video.f r20 = ((com.bytedance.android.shopping.anchorv4.video.d) r19).d;
        if (r20 == null) goto L31;
        boolean r21 = r20.h(r19);
    L32:
        r18.b = r21;
    L31:
        r21 = r18.b;
        goto L32
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.s
    public final void b(x73.c r5) {
        Intrinsics.checkNotNullParameter(r5, "sharePlayer");
        c r1 = this.g;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "sharePlayer");
        x73.c r0 = r1.d.j.c.g;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L9;
        if (r0 == null) goto L7;
        r0.g(r1.c, Boolean.TRUE);
    L7:
        if ((!Intrinsics.areEqual(r5, r0)) == false) goto L14;
        r1.d.j.c.g = r5;
    L14:
        r1.f();
        return;
    L9:
        if (r0 == null) goto L12;
        x73.d r2 = r1.c;
        boolean r3 = x73.c.f;
        r0.h(r2, null);
    L12:
        if ((!Intrinsics.areEqual(r5, r0)) == false) goto L14;
        r1.d.j.c.g = r5;
        goto L14
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.s
    public final void close(boolean r7) {
        t.a.a(this.g, false, false, false, r7, 6);
    }

    public a(l r3, k r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        this.j = r3;
        this.k = r4;
        this.d = -1;
        c r5 = new c(this);
        this.g = r5;
        this.h = new n(r3.getContext(), r5);
        this.i = new d(this);
    }
}
