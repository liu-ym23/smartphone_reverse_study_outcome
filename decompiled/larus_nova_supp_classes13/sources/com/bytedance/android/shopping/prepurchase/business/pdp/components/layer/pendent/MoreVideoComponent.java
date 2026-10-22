package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityCacheScene;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityUtil;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerViewScene;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.dto.business.HeadMoreVideo;
import com.bytedance.android.shopping.anchorv4.dto.business.VideoHolderItem;
import com.bytedance.android.shopping.anchorv4.video.AnchorV4PlayerStateManager;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdVideoView;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdpVideoView;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.api.video.ScaleType;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.legacy.DragRelativeLayout;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vg3.i0;
import vg3.t;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MoreVideoComponent extends com.bytedance.android.shopping.prepurchase.business.pdp.components.m implements t {
    public b m;
    public float n;
    public int o;
    public final Lazy p;
    public boolean q;

    public static final class a {
    }

    public static final class b extends FrameLayout implements com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c, fj.e {
        public final TextView a;
        public final ECDraweeView b;
        public final x73.a c;

        public static final class a {
        }

        static {
        }

        public final void B0() {
        }

        public final void P1(boolean r1) {
        }

        public final void Q(float r1) {
        }

        public final void R2() {
        }

        public final void b(float r1) {
        }

        public final void e() {
        }

        public final void y(boolean r1) {
        }

        public final void y3(String r1) {
        }

        public final void E3() {
            this.b.setVisibility(0);
        }

        public final void H() {
            this.b.setVisibility(8);
        }

        public final void S() {
            this.b.setVisibility(8);
        }

        public final void Z2() {
            this.b.setVisibility(8);
        }

        public b(Context r13) {
            Intrinsics.checkNotNullParameter(r13, "context");
            super(r13);
            int r0 = com.bytedance.android.shopping.extensions.b.a(2);
            setPadding(r0, r0, r0, 0);
            Drawable r1 = new BackgroundDrawable(r13, null, false, 4, null);
            r1.setCornerRadius(com.bytedance.android.shopping.extensions.b.a(Float.valueOf(12.0f)));
            r1.setBgColor((int) 3238002687L);
            r1.setStrokeColor(-1);
            r1.setStrokeWidth(com.bytedance.android.shopping.extensions.b.a(1));
            r1.invalidate();
            Unit r3 = Unit.INSTANCE;
            setBackground(r1);
            int r2 = com.bytedance.android.shopping.extensions.b.a(66);
            if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L5;
            View r4 = new BasePdpVideoView(r13, null, 6, 0);
            ViewExtensionsKt.g(r4, 10.0f, 10.0f, 10.0f, 10.0f);
        L6:
            this.c = r4;
            addView(r4, new FrameLayout.LayoutParams(r2, r2));
            View r5 = new ECDraweeView(r13, null, 0, 6, null);
            this.b = r5;
            ViewExtensionsKt.g(r5, 10.0f, 10.0f, 10.0f, 10.0f);
            addView(r5, new FrameLayout.LayoutParams(r2, r2));
            TextView r6 = new TextView(r13);
            this.a = r6;
            r6.setGravity(17);
            int r7 = g1.a;
            r6.setCompoundDrawablesWithIntrinsicBounds(null, null, g1.a.b(r13, 2131231286), null);
            r6.setTextColor(g1.a.a(r13, 2131105908));
            ViewExtensionsKt.h(r6, 10);
            FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.a(24));
            r14.topMargin = r2;
            r14.gravity = 1;
            addView(r6, r14);
            return;
        L5:
            r4 = new BasePdVideoView(r13, null);
            ViewExtensionsKt.g(r4, 10.0f, 10.0f, 10.0f, 10.0f);
            goto L6
        }

        public final void i2(boolean r2) {
            if (r2 == false) goto L5;
            this.b.setVisibility(8);
            return;
        }

        public final void m3(boolean r2) {
            if (r2 == true) goto L5;
            this.b.setVisibility(0);
            return;
        }
    }

    public static final class c<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ MoreVideoComponent a;

        public c(MoreVideoComponent r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r20) {
            HeadMoreVideo r0 = (HeadMoreVideo) r20;
            if (r0 == null) goto L107;
            MoreVideoComponent r2 = this.a;
            if (r2.q == true) goto L108;
            r2.q = true;
            VideoModel r4 = r0.getAnchorVideo();
            AnchorV4PlayerStateManager r5 = null;
            if (r4 != null) goto L15;
            List r6 = r0.getVideoHolderList();
            if (r6 == null) goto L14;
            VideoHolderItem r7 = (VideoHolderItem) CollectionsKt.getOrNull(r6, r0.getAnchorIndex());
            if (r7 == null) goto L14;
            r4 = r7.getVideo();
        L14:
            r4 = null;
        L15:
            if (r4 == null) goto L109;
            z73.a r8 = PlayAbilityUtil.a;
            com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r9 = PlayAbilityUtil.a(r4, null, PlayerViewScene.SCENE_HEAD_MORE_VIDEO);
            if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L25;
            b r10 = r2.m;
            if (r10 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L21:
            if (r10 == null) goto L32;
            x73.a r11 = r10.c;
            if (r11 == null) goto L32;
            r11.k(AVScene.CONTENT_PD_MORE_VIDEO_WINDOW, true, new a83.a(), PlayAbilityCacheScene.SCENE_MORE_VIDEO);
            r11.i(r9, new com.bytedance.android.shopping.api.video.d(true, true, 0, 0, false, 508), null);
            r11.f(true, false);
            r11.setScaleType(ScaleType.CENTER_CROP);
        L32:
            b r12 = r2.m;
            if (r12 != null) goto L35;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L35:
            if (r12 != null) goto L37;
        L40:
            b r13 = r2.m;
            if (r13 != null) goto L43;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L43:
            if (r13 == null) goto L47;
            TextView r14 = r13.a;
            if (r14 == null) goto L47;
            r14.setText("更多视频");
        L47:
            b r15 = r2.m;
            if (r15 != null) goto L50;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L50:
            if (r15 == null) goto L60;
            ECDraweeView r16 = r15.b;
            if (r16 == null) goto L60;
            GenericDraweeHierarchy r17 = r16.getHierarchy();
            if (r17 == null) goto L56;
            r17.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        L56:
            String r18 = r9.f();
            if (r18 == null) goto L59;
            y.d(r16, r18);
            goto L60
        L59:
            r16.setVisibility(8);
            Unit r19 = Unit.INSTANCE;
        L60:
            b r21 = r2.m;
            if (r21 != null) goto L63;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L63:
            if (r21 == null) goto L65;
            r21.setOnClickListener(new f(r2, r0));
        L65:
            vg3.a r22 = (vg3.a) r2.N1(vg3.a.class);
            if (r22 == null) goto L68;
            r5 = r22.e();
        L68:
            if (r5 == null) goto L70;
            r5.c(new g(r2, r5, r5));
        L70:
            b r23 = r2.m;
            if (r23 != null) goto L73;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L73:
            if (r23 == null) goto L79;
            x73.a r24 = r23.c;
            if (r24 == null) goto L79;
            if (r24.isPlaying() != true) goto L79;
        L84:
            b r3 = r2.m;
            if (r3 != null) goto L88;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L88:
            if (r3 == null) goto L90;
            r3.setAlpha(0.0f);
        L90:
            b r25 = r2.m;
            if (r25 != null) goto L93;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L93:
            if (r25 != null) goto L95;
        L105:
            MoreVideoComponent.j2(r2, "pdp_module_show", r0.getTrack());
            return;
        L95:
            if (ViewCompat.isLaidOut(r25) == true) goto L97;
        L104:
            r25.addOnLayoutChangeListener(new k(r2));
            goto L105
        L97:
            if (r25.isLayoutRequested() == true) goto L104;
            b r26 = r2.m;
            if (r26 != null) goto L101;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L101:
            if (r26 == null) goto L103;
            r26.setAlpha(1.0f);
        L103:
            r25.setTranslationX(r25.getWidth() + com.bytedance.android.shopping.extensions.b.a(12));
            r25.animate().translationX(0.0f).setDuration(1000).start();
        L79:
            b r27 = r2.m;
            if (r27 != null) goto L82;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L82:
            if (r27 == null) goto L84;
            r27.postDelayed(new l(r2), 800);
            goto L84
        L37:
            if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L39;
            r12.c.g(r12);
            r12.c.c(r12);
            goto L40
        L39:
            r12.c.j(r12);
            r12.c.l(r12);
            goto L40
        L25:
            b r28 = r2.m;
            if (r28 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L28:
            if (r28 == null) goto L32;
            x73.a r29 = r28.c;
            if (r29 == null) goto L32;
            r29.h(AVScene.CONTENT_PD_MORE_VIDEO_WINDOW, true);
            r29.i(r9, new com.bytedance.android.shopping.api.video.d(true, true, 0, 0, false, 508), null);
            r29.f(true, false);
            r29.setScaleType(ScaleType.CENTER_CROP);
            goto L32
        L109:
            return;
        L108:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{vg3.l.class, w.class, vg3.a.class, i0.class});
    }

    @Override // vg3.t
    public final boolean d() {
        b r0 = this.m;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
    L6:
        if (r0.getVisibility() != 0) goto L8;
        return true;
    L8:
        return false;
    }

    public MoreVideoComponent() {
        this.p = LazyKt.lazy(new MoreVideoComponent$halfScreenMargin$2(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) O1().d().getData().n.getValue(), this, new c(this));
        AbsComponent.Y1(this, t.class, this, false, 12);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        b r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
    L5:
        r0.c.release();
    }

    public static final int h2(MoreVideoComponent r2) {
        if (r2.o != 0) goto L15;
        i0 r0 = (i0) r2.N1(i0.class);
        if (r0 == null) goto L7;
        Rect r1 = r0.a1();
    L8:
        if (r1 == null) goto L16;
        if (r1.height() <= 0) goto L16;
        r2.o = r1.bottom + com.bytedance.android.shopping.extensions.b.a(48);
    L16:
        return com.bytedance.android.shopping.extensions.b.a(152);
    L7:
        r1 = null;
    L15:
        return r2.o;
    }

    public static final /* synthetic */ b i2(MoreVideoComponent r1) {
        b r2 = r1.m;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
    L5:
        return r2;
    }

    @Override // vg3.t
    public final void g(boolean r2) {
        if (r2 == false) goto L10;
        b r3 = this.m;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
    L7:
        if (r3 == null) goto L22;
        r3.setVisibility(0);
        return;
    L22:
        return;
    L10:
        if (ECSettingKeys.A0().g() == false) goto L16;
        b r4 = this.m;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
    L14:
        if (r4 == null) goto L24;
        r4.setVisibility(4);
        return;
    L24:
        return;
    L16:
        b r5 = this.m;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
    L19:
        if (r5 == null) goto L26;
        r5.setVisibility(8);
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        Intrinsics.checkNotNullParameter(r6, "container");
        DragRelativeLayout r7 = new DragRelativeLayout(r6.getContext());
        r7.setId(2131377550);
        r7.setDockMode(3);
        b r0 = new b(r6.getContext());
        this.m = r0;
        Unit r1 = Unit.INSTANCE;
        RelativeLayout.LayoutParams r2 = new RelativeLayout.LayoutParams(-2, -2);
        r2.addRule(11, -1);
        r2.rightMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r7.addView(r0, r2);
        r7.b();
        b r3 = this.m;
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
    L6:
        if (ViewCompat.isLaidOut(r3) == true) goto L8;
    L10:
        r3.addOnLayoutChangeListener(new h(r7, this, r6));
    L12:
        if (ECSettingKeys.A0().g() == true) goto L14;
    L19:
        return r7;
    L14:
        if (g2().getNativeParams().getFullMode() == true) goto L19;
        b r8 = this.m;
        if (r8 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
    L18:
        r8.setVisibility(4);
        goto L19
    L8:
        if (r3.isLayoutRequested() == true) goto L10;
        r7.setEnableKeepLayout(true);
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.c, this, new i(this));
        goto L12
    }

    public static void j2(MoreVideoComponent r12, String r13, Map r14) {
        r12.Z1(w.class, new MoreVideoComponent$logCommon$1(r14, "a1.b8094.c05258.d150175", r13, true, "", null, null, false, null));
    }
}
