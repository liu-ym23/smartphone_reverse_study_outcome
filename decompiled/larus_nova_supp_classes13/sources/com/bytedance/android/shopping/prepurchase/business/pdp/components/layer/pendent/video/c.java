package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.os.SystemClock;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityCacheScene;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityUtil;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerViewScene;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.legacy.DragRelativeLayout;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements t {
    public gj.b a;
    public boolean b;
    public final x73.d c;
    public final /* synthetic */ com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a d;

    public static final class a implements fj.e {
        public final /* synthetic */ c a;

        public final void B0() {
        }

        public final void Q(float r1) {
        }

        public final void R2() {
        }

        public final void y(boolean r1) {
        }

        public final void Z2() {
            com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r0 = this.a.d;
            if (r0.c == true) goto L9;
            r0.c = true;
            Float r1 = r0.j.c.h;
            if (r1 == null) goto L9;
            float r2 = r1.floatValue();
            gj.b r3 = this.a.a;
            if (r3 == null) goto L9;
            r3.seek(r2);
        L9:
            e r4 = this.a.d.b;
            if (r4 == null) goto L14;
            com.bytedance.android.shopping.anchorv4.video.f r5 = ((com.bytedance.android.shopping.anchorv4.video.d) r4).d;
            if (r5 == null) goto L14;
            com.bytedance.android.shopping.anchorv4.video.f.a.b(r5, r4, false, 6);
        L14:
            this.a.d.j.getClass();
            this.a.d.h.b();
            com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r6 = this.a.d;
            r6.d = SystemClock.elapsedRealtime();
            n r7 = this.a.d.h;
            a0 r8 = r7.a;
            if (r8 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("videoWrapper");
        L17:
            ECDraweeView r9 = r8.getIvCover();
            if (r9 == null) goto L20;
            Object r10 = r9.getTag();
        L21:
            if (r10 != null) goto L43;
            a0 r11 = r7.a;
            if (r11 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("videoWrapper");
        L26:
            ECDraweeView r12 = r11.getIvCover();
            if (r12 == null) goto L29;
            r12.setTag(r7);
        L29:
            a0 r13 = r7.a;
            if (r13 != null) goto L32;
            Intrinsics.throwUninitializedPropertyAccessException("videoWrapper");
        L32:
            ECDraweeView r14 = r13.getIvCover();
            if (r14 == null) goto L40;
            ViewPropertyAnimator r15 = r14.animate();
            if (r15 == null) goto L41;
            ViewPropertyAnimator r16 = r15.alpha(0.0f);
            if (r16 == null) goto L42;
            r16.setDuration(300);
            r16.setListener(new r(r7));
            r16.start();
            return;
        L42:
            return;
        L41:
            return;
        L40:
            return;
        L43:
            return;
        L20:
            r10 = null;
            goto L21
        }

        public final void e() {
            if (this.a.d.j.a() == false) goto L6;
            t.a.a(this.a, false, false, true, false, 10);
            return;
        }

        public final void H() {
            Z2();
        }

        public a(c r1) {
            this.a = r1;
        }

        public final void m3(boolean r2) {
            com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r3 = this.a.d;
            if (r3.e == false) goto L5;
            r3.e = false;
        L6:
            Lazy r4 = UIUtils.a;
            UIUtils.c().post(new b(this));
            return;
        L5:
            r3.h.b();
            goto L6
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.t
    public final void d() {
        gj.b r0 = this.a;
        if (r0 != null) goto L5;
    L10:
        this.d.d();
        return;
    L5:
        if (r0.isPlaying() != true) goto L10;
        u r1 = this.d.j.e;
        if (r1 == null) goto L12;
        r1.a();
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.t
    public final gj.b e() {
        x r1 = this.d.j.c;
        if (this.a != null) goto L30;
        boolean r3 = true;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L16;
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r2 = this.d;
        if (r2.j.c.g == null) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L21;
        z73.a r6 = PlayAbilityUtil.a;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r7 = r1.e;
        ViewGroup r8 = r2.h.getVideoContainer();
        PlayerViewScene r9 = r1.e.e;
        AVScene r10 = r1.d;
        com.bytedance.android.shopping.api.video.d r4 = new com.bytedance.android.shopping.api.video.d(false, true, 0, 0, false, 509);
        if (this.d.j.c.g != null) goto L15;
        r3 = false;
    L15:
        r4.h = r3;
        Unit r11 = Unit.INSTANCE;
        this.a = PlayAbilityUtil.d(r7, r8, r9, r10, r4, PlayAbilityCacheScene.SCENE_FLOAT_VIDEO);
    L21:
        f();
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == true) goto L26;
        gj.b r12 = this.a;
        if (r12 == null) goto L26;
        r12.t();
    L26:
        gj.b r13 = this.a;
        if (r13 == null) goto L30;
        r13.A(new a(this));
        goto L30
    L9:
        r5 = false;
        goto L10
    L16:
        z73.a r14 = PlayAbilityUtil.a;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r15 = r1.e;
        ViewGroup r16 = this.d.h.getVideoContainer();
        PlayerViewScene r17 = r1.e.e;
        AVScene r18 = r1.d;
        com.bytedance.android.shopping.api.video.d r19 = new com.bytedance.android.shopping.api.video.d(false, true, 0, 0, false, 509);
        if (this.d.j.c.g != null) goto L20;
        r3 = false;
    L20:
        r19.h = r3;
        Unit r20 = Unit.INSTANCE;
        this.a = PlayAbilityUtil.d(r15, r16, r17, r18, r19, null);
    L30:
        return this.a;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.t
    public final l getParams() {
        return this.d.j;
    }

    public final void f() {
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L16;
        x73.c r0 = this.d.j.c.g;
        if (r0 == null) goto L31;
        gj.b r1 = r0.i(this.c);
        this.a = r1;
        if (r1 != null) goto L9;
        return;
    L9:
        r1.V(this.d.h.getVideoContainer(), true);
        boolean r2 = r1.isMute();
        if (this.b == r2) goto L15;
        this.b = r2;
        e r3 = this.d.b;
        if (r3 == null) goto L14;
        r3.n(r2, false);
    L14:
        this.d.h.a();
    L15:
        r1.resume();
        return;
    L31:
        return;
    L16:
        gj.b r4 = this.a;
        if ((r4 instanceof com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.g) == true) goto L19;
        r4 = null;
    L19:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.g r5 = (com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.g) r4;
        x73.c r6 = this.d.j.c.g;
        if (r5 == null) goto L33;
        if (r6 == null) goto L34;
        r5.H(r6.j(this.c));
        boolean r7 = this.b;
        com.bytedance.android.shopping.api.video.i r8 = r6.d;
        if (r8 != null) goto L25;
    L26:
        c(false);
    L27:
        gj.b r9 = e();
        if (r9 == null) goto L35;
        r9.resume();
        return;
    L35:
        return;
    L25:
        if (r7 == ((ECVideoPlayerView) r8).f()) goto L27;
    L34:
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.t
    public final boolean b() {
        return this.b;
    }

    public c(com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r1) {
        this.d = r1;
        this.c = new x73.d();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.t
    public final void c(boolean r3) {
        this.b = !this.b;
        gj.b r0 = e();
        if (r0 == null) goto L5;
        r0.a(this.b);
    L5:
        e r1 = this.d.b;
        if (r1 == null) goto L8;
        r1.n(this.b, r3);
    L8:
        this.d.h.a();
        d r4 = this.d.i;
        boolean r2 = this.b;
        r4.getClass();
        if (r2 == true) goto L11;
        String r5 = "open";
    L12:
        r4.b("pd_sound_icon_click", MapsKt.mapOf(TuplesKt.to("click_type", r5)));
        return;
    L11:
        r5 = FreqActions.ACTION_CLOSE;
        goto L12
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.t
    public final void a(boolean r3, boolean r4, boolean r5, boolean r6) {
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r0 = this.d;
        if (r0.j.c.g == null) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L35;
        if (r4 == true) goto L35;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.g r7 = null;
        if (r3 == true) goto L14;
        if (r5 == true) goto L14;
        if (r6 == true) goto L14;
        Boolean r8 = null;
    L15:
        x73.c r2 = this.d.j.c.g;
        if (r2 != null) goto L18;
    L21:
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r9 = this.d;
        DragRelativeLayout r10 = r9.a;
        if (r10 == null) goto L27;
        if (r9.j.b.indexOfChild(r10) < 0) goto L27;
        this.d.j.b.removeView(r10);
    L27:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == true) goto L46;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.g r11 = this.a;
        if ((r11 instanceof com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.g) == false) goto L32;
        r7 = r11;
    L32:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.g r12 = r7;
        if (r12 == null) goto L46;
        r12.d0();
    L46:
        u r13 = this.d.j.e;
        if (r13 == null) goto L49;
        r13.onClose(r3);
    L49:
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r14 = this.d;
        e r15 = r14.b;
        if (r15 == null) goto L52;
        r14.j.c.a.g(r15);
    L52:
        this.d.i.a(r5, "quit");
        return;
    L18:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L20;
        r2.g(this.c, Boolean.TRUE);
        goto L21
    L20:
        r2.h(this.c, r8);
    L14:
        r0.pause();
        r8 = Boolean.FALSE;
    L35:
        gj.b r16 = this.a;
        if (r16 == null) goto L38;
        r16.r();
    L38:
        gj.b r17 = this.a;
        if (r17 == null) goto L41;
        r17.release();
    L41:
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r18 = this.d;
        DragRelativeLayout r19 = r18.a;
        if (r19 == null) goto L46;
        if (r18.j.b.indexOfChild(r19) < 0) goto L46;
        this.d.j.b.removeView(r19);
        goto L46
    L5:
        r1 = false;
        goto L6
    }
}
