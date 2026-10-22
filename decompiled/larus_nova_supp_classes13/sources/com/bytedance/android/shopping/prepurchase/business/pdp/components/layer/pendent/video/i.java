package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.ec.model.response.ECPDPBaseVideo;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityUtil;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerViewScene;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.HeaderFloatVideoComponent$checkAndShowFloatVideo$$inlined$lets2$lambda$1;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vg3.b0;
import vg3.i0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements b0 {
    public Function0<Boolean> a;
    public final com.bytedance.android.shopping.anchorv4.video.f b;
    public a c;
    public final m d;
    public final ViewGroup e;
    public final vg3.w f;
    public final vg3.l g;

    public final class a implements v {
        public final l a;
        public final s b;
        public final /* synthetic */ i c;

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.v
        public final void a() {
            if (Intrinsics.areEqual(this, this.c.c) == false) goto L6;
            this.b.a();
            return;
        }

        public final void c() {
            this.b.resume();
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.v
        public final void pause() {
            this.b.pause();
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.v
        public final l getParams() {
            return this.a;
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.v
        public final void b(x73.c r2) {
            Intrinsics.checkNotNullParameter(r2, "sharePlayer");
            if (Intrinsics.areEqual(this, this.c.c) == false) goto L6;
            this.b.b(r2);
            return;
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.v
        public final void close(boolean r2) {
            if (Intrinsics.areEqual(this, this.c.c) == false) goto L6;
            this.b.close(r2);
            return;
        }

        public a(i r2, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r3) {
            Intrinsics.checkNotNullParameter(r3, "floatVideo");
            this.c = r2;
            this.b = r3;
            this.a = r3.j;
        }
    }

    @Override // vg3.b0
    public final a i0() {
        return this.c;
    }

    @Override // vg3.b0
    public final void S0(Function0<Boolean> r1) {
        this.a = r1;
    }

    @Override // vg3.b0
    public final a g1(final l r7) {
        Intrinsics.checkNotNullParameter(r7, "params");
        x r0 = r7.c;
        int r2 = 0;
        Unit r3 = null;
        if (r0.g == null) goto L5;
        z73.a r1 = PlayAbilityUtil.a;
        PlayAbilityUtil.f(r0.e.e, null);
        com.bytedance.android.shopping.anchorv4.video.float.f.a("只有新播放器允许使用共享播放器. playerViewScene=" + r7.c.e.e);
    L15:
        final a r4 = null;
    L20:
        if (r4 == null) goto L44;
        this.c = r4;
        final m r5 = this.d;
        boolean r6 = r7.a();
        final Function1<Integer, Unit> r8 = new FloatVideoManagerV2$showFloatVideo$$inlined$apply$lambda$1(r4, this, r7);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r8, "callback");
        if (r6 == false) goto L33;
        Pair<Integer, Boolean> r9 = r5.a;
        if (r9 == null) goto L29;
        Integer r10 = (Integer) r9.getFirst();
        if (r10 == null) goto L28;
        r2 = r10.intValue();
    L28:
        r8.invoke(Integer.valueOf(r2));
    L43:
        return r4;
    L29:
        i0 r11 = r5.c;
        if (r11 == null) goto L32;
        r11.r1(new FloatVideoPositionManager$getFloatVideoTop$1(r8));
        goto L43
    L32:
        r8.invoke(0);
        goto L43
    L33:
        vg3.l r12 = r5.b;
        if (r12 != null) goto L36;
    L42:
        Unit r13 = (Unit) r8.invoke(0);
        goto L43
    L36:
        if (r12.J() == false) goto L40;
        i0 r14 = r5.c;
        if (r14 == null) goto L41;
        r14.r1(new FloatVideoPositionManager$getFloatVideoTop$$inlined$let$lambda$1(r5, r8));
        r3 = Unit.INSTANCE;
    L41:
        if (r3 != null) goto L43;
    L40:
        r12.D(new FloatVideoPositionManager$getFloatVideoTop$$inlined$let$lambda$2(r5, r8));
        r3 = Unit.INSTANCE;
        goto L41
    L44:
        return null;
    L5:
        a r15 = this.c;
        if (r15 == null) goto L16;
        l r16 = r15.a;
        if (r16 == null) goto L12;
        u r17 = r16.e;
        if (r17 == null) goto L12;
        r17.b(r7);
        boolean r18 = true;
    L13:
        if (r18 == true) goto L16;
        com.bytedance.android.shopping.anchorv4.video.float.f.a("禁止展示两个及以上的视频小窗");
    L12:
        r18 = false;
    L16:
        u r19 = r7.e;
        if (r19 != null) goto L19;
        u.a.getClass();
        r19 = u.a.a;
    L19:
        r7.e = new j(this, r19);
        r4 = new a(this, new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a(r7, new k(this)));
        goto L20
    }

    @Override // vg3.b0
    public final l m0(com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r16, x73.c r17, HeaderFloatVideoComponent$checkAndShowFloatVideo$$inlined$lets2$lambda$1 r18, Float r19, Map r20) {
        Intrinsics.checkNotNullParameter(r16, "videoModel");
        Intrinsics.checkNotNullParameter(r17, "sharePlayer");
        ViewGroup r10 = this.e;
        Context r12 = r10.getContext();
        com.bytedance.android.shopping.anchorv4.video.f r2 = this.b;
        Boolean r3 = Boolean.FALSE;
        com.bytedance.android.shopping.api.video.i r1 = r17.d;
        if (r1 == null) goto L5;
        Boolean r4 = Boolean.valueOf(((ECVideoPlayerView) r1).f());
    L6:
        x r13 = new x(r2, r3, r4, AVScene.CONTENT_PRODUCT_DETAIL_HEADER, r16, true, r17, r19);
        Pair<Integer, Boolean> r5 = this.d.a;
        if (r5 == null) goto L11;
        Boolean r6 = (Boolean) r5.getSecond();
        if (r6 == null) goto L11;
        boolean r7 = r6.booleanValue();
    L13:
        return new l(r12, r10, r13, new y(r7, null, null, 121), r18, r20);
    L11:
        r7 = true;
        goto L13
    L5:
        r4 = null;
        goto L6
    }

    public i(com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.m r2, ViewGroup r3, vg3.a r4, vg3.w r5, vg3.l r6, i0 r7) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "avCoordinationAbility");
        this.e = r3;
        this.f = r5;
        this.g = r6;
        this.b = r4.e();
        this.d = new m(r6, r7);
        r2.P1().a(new h(this));
    }

    @Override // vg3.b0
    public final l W(fj.d r19, ECPDPBaseVideo r20, Boolean r21, Boolean r22, u r23, Map r24, String r25, boolean r26) {
        Intrinsics.checkNotNullParameter(r19, "playInfo");
        ViewGroup r6 = this.e;
        if (r26 == false) goto L10;
        Function0<Boolean> r4 = this.a;
        if (r4 == null) goto L10;
        if (((Boolean) r4.invoke()).booleanValue() != true) goto L10;
        boolean r13 = false;
    L11:
        Context r5 = r6.getContext();
        com.bytedance.android.shopping.anchorv4.video.f r8 = this.b;
        if (r20 == null) goto L14;
        AVScene r7 = AVScene.CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW_OPT;
    L15:
        AVScene r11 = r7;
        z73.a r9 = PlayAbilityUtil.a;
        x r17 = new x(r8, r21, r22, r11, PlayAbilityUtil.b(r19, r20, PlayerViewScene.SCENE_FLOAT_WINDOW_VIDEO, 4), r13, null, null);
        this.d.getClass();
        return new l(r5, r6, r17, new y(true, null, r25, 65), r23, r24);
    L14:
        r7 = AVScene.CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW;
    L10:
        r13 = true;
        goto L11
    }
}
