package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.util.LiveKtvMidiRenderElementFpsAnimator;
import com.bytedance.bdlocation.sensor.SensorBatchGpsCollector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p extends com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a {
    public final int k;
    public long l;
    public final float m;
    public float n;
    public final SecureRandom o;
    public b p;
    public b q;
    public final List<Pair<Integer, Integer>> r;
    public long s;
    public final int t;
    public final int u;
    public final int v;
    public final int w;
    public final int x;
    public final int y;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final r a;

        public a(com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c r2) {
            Intrinsics.checkNotNullParameter(r2, "target");
            this.a = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            Object r4 = r3.getAnimatedValue();
            if (r4 == null) goto L7;
            PointF r5 = (PointF) r4;
            r r0 = this.a;
            r0.d = r5.x;
            r r1 = this.a;
            r1.e = r5.y;
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");
        }
    }

    public static final class b implements c {
        public final CopyOnWriteArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c> a;
        public final CopyOnWriteArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c> b;

        public final void b() {
            this.a.clear();
            this.b.clear();
        }

        public final void c() {
            Iterator<T> r0 = this.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c) r0.next()).c();
            goto L4
        L6:
            Iterator<T> r1 = this.b.iterator();
        L8:
            if (r1.hasNext() == false) goto L10;
            ((com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c) r1.next()).c();
            goto L8
        }

        public b(int r4) {
            CopyOnWriteArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c> r0 = new CopyOnWriteArrayList();
            int r1 = 0;
        L3:
            if (r1 >= r4) goto L5;
            r0.add(new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c());
            r1 = r1 + 1;
            goto L3
        L5:
            Unit r5 = Unit.INSTANCE;
            this.a = r0;
            this.b = new CopyOnWriteArrayList();
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.p.c
        public final void a(com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c r2) {
            Intrinsics.checkNotNullParameter(r2, "particle");
            if (this.b.remove(r2) == false) goto L6;
            r2.g = false;
            this.a.add(r2);
            return;
        }

        public final void d(Canvas r3) {
            Intrinsics.checkNotNullParameter(r3, "canvas");
            Iterator<T> r0 = this.b.iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            ((com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c) r0.next()).b(r3);     // Catch: Exception -> L8
            goto L4
        }
    }

    public interface c {
        void a(com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c r1);
    }

    public p() {
        this.k = vm2.h.G();
        this.m = s1.f(92.0f);
        this.o = new SecureRandom();
        this.r = CollectionsKt.listOf(new Pair(Integer.valueOf(s1.f(14.0f)), Integer.valueOf(s1.f(14.0f))));
        this.s = SensorBatchGpsCollector.DEFAULT_NETWORK_FALLBACK_TIMEOUT_MS;
        this.t = s1.f(80.0f);
        this.u = s1.f(40.0f);
        this.v = s1.f(70.0f);
        this.w = s1.f(30.0f);
        this.x = s1.f(0.0f);
        this.y = s1.f(2.0f);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void e() {
        super.e();
        b r0 = this.p;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        b r1 = this.q;
        if (r1 == null) goto L9;
        r1.c();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.t
    public final void a(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        b r0 = this.p;
        if (r0 == null) goto L5;
        r0.d(r2);
    L5:
        b r1 = this.q;
        if (r1 == null) goto L9;
        r1.d(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void d(db0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r2, "model");
        this.e = r2;
        b r3 = this.p;
        if (r3 == null) goto L5;
        r3.b();
    L5:
        b r4 = this.q;
        if (r4 == null) goto L8;
        r4.b();
    L8:
        com.bytedance.android.live.ktv.common.midi.g r0 = this.d;
        if (r0 == null) goto L11;
        int r1 = r0.F();
    L12:
        this.p = new b(r1);
        com.bytedance.android.live.ktv.common.midi.g r5 = this.d;
        if (r5 == null) goto L15;
        int r6 = r5.D();
    L16:
        this.q = new b(r6);
        return;
    L15:
        r6 = vm2.h.w();
        goto L16
    L11:
        r1 = 4;
        goto L12
    }

    public final PointF i(PointF r5, PointF r6) {
        float r0 = r5.x - r6.x;
        int r7 = (int) ((r5.y - r6.y) + 1);
        if (r7 <= 0) goto L5;
        int r8 = this.o.nextInt(r7);
    L6:
        float r2 = r6.x + (r0 / 2);
        float r1 = this.y;
        return new PointF(r2 - r1, (r6.y + r8) - r1);
    L5:
        r8 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void b(com.bytedance.android.live.ktv.common.midi.k r22, Long r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r22, "scoreInfo");
        super.b(r22, r23, r24);
        s r1 = this.j;
        if (r1 != null) goto L5;
        return;
    L5:
        Pair<Float, Float> r3 = r1.b;
        int r4 = r1.d;
        boolean r2 = r1.c;
        if (c(r22) == false) goto L108;
        com.bytedance.android.live.ktv.common.midi.f r5 = this.c;
        if (r5 == null) goto L110;
        boolean r6 = true;
        if (r5.a() != true) goto L111;
        long r7 = this.l % ((long) this.k);
        this.l = 1 + r7;
        if (r7 != 0) goto L112;
        float r8 = ((Number) r3.getFirst()).floatValue();
        float r9 = ((Number) r3.getSecond()).floatValue();
        Integer r10 = Integer.valueOf(r4);
        int r11 = 0;
        if (r2 == true) goto L23;
        b r12 = this.p;
        if (r12 != null) goto L18;
        return;
    L18:
        if (r12.a.size() <= 0) goto L20;
        boolean r13 = true;
    L21:
        if (r13 == true) goto L23;
        return;
    L20:
        r13 = false;
    L23:
        if (r2 == false) goto L32;
        b r14 = this.q;
        if (r14 != null) goto L27;
        return;
    L27:
        if (r14.a.size() <= 0) goto L29;
        boolean r15 = true;
    L30:
        if (r15 == true) goto L32;
        return;
    L29:
        r15 = false;
    L32:
        this.n = r9;
        com.bytedance.android.live.ktv.common.midi.g r16 = this.d;
        if (r16 == null) goto L115;
        List r17 = r16.I(r10, r2);
        if (r17 == null) goto L118;
        p r18 = this;
        int r19 = 0;
    L38:
        int r20 = r18.o.nextInt(r17.size());
        int r110 = r18.o.nextInt(r18.r.size());
        if (r2 == false) goto L41;
        boolean r111 = r18.o.nextBoolean();
    L42:
        if (r2 == false) goto L44;
        b r112 = r18.q;
    L45:
        Bitmap r21 = (Bitmap) ListProtector.get(r17, r20);
        if (r112 != null) goto L48;
    L104:
        List r25 = r17;
    L106:
        if (r19 == 1) goto L119;
        r19 = r19 + 1;
        r2 = r2;
        r8 = r8;
        r9 = r9;
        r17 = r25;
        r6 = true;
        r11 = 0;
        goto L38
    L119:
        return;
    L48:
        if (r112.a.size() > 0) goto L50;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c r113 = null;
    L53:
        if (r113 == null) goto L104;
        r113.d(r21);
        r113.g = r6;
        r113.a = 1.0f;
        Pair r26 = (Pair) ListProtector.get(r18.r, r110);
        r113.h.set(0.0f, 0.0f, ((Number) r26.getFirst()).intValue(), ((Number) r26.getSecond()).intValue());
        r113.d = r8;
        r113.e = r9;
        if (r2 == false) goto L57;
        int r27 = r18.t;
    L58:
        if (r2 == false) goto L60;
        int r114 = r18.u;
    L61:
        int r115 = r18.o.nextInt((r27 * 2) / 3);
        int r116 = r18.o.nextInt(r114);
        if (r111 == false) goto L64;
        float r117 = (((r18.n + r18.x) - r114) + r116) - r18.y;
    L65:
        PointF r28 = new PointF(((r18.m - r27) + r115) - r18.y, r117 % r18.a);
        float r118 = r18.m;
        float r119 = r18.y;
        PointF r29 = new PointF(r118 - r119, (r18.n + r18.x) - r119);
        if (r2 == false) goto L68;
        int r120 = r18.t;
    L69:
        if (r2 == false) goto L71;
        int r121 = r18.u;
    L72:
        if (r2 == false) goto L74;
        long r122 = 2500;
    L75:
        float r30 = r29.x - r28.x;
        float r31 = r29.y - r28.y;
        r18.s = (long) ((Math.sqrt((r30 * r30) + (r31 * r31)) / ((double) ((int) Math.sqrt((r120 * r120) + (r121 * r121))))) * r122);
        if (KtvSettingHelper.o() == false) goto L78;
    L81:
        ValueAnimator r32 = LiveDegradeFpsAnimator.ofObject(new com.bytedance.android.live.ktv.common.midi.a(r18.i(r29, r28)), new Object[]{r29, r28}).setFpsConfig(KtvSettingHelper.k());
    L82:
        r32.addUpdateListener(new a(r113));
        r32.setTarget(r113);
        r32.setDuration(r18.s);
        LiveKtvMidiRenderElementFpsAnimator r33 = LiveKtvMidiRenderElementFpsAnimator.a(r113, "rotation", new float[]{0.0f, 360.0f});
        int r34 = KtvSettingHelper.k();
        if (r34 <= 0) goto L85;
        r33.a = r34;
    L85:
        r33.setDuration(r18.s);
        AnimatorSet r35 = new AnimatorSet();
        r35.playTogether(new Animator[]{r33, r32});
        LiveKtvMidiRenderElementFpsAnimator r36 = LiveKtvMidiRenderElementFpsAnimator.a(r113, "alpha", new float[]{0.0f, 1.0f});
        int r37 = KtvSettingHelper.k();
        if (r37 <= 0) goto L88;
        r36.a = r37;
    L88:
        LiveKtvMidiRenderElementFpsAnimator r38 = LiveKtvMidiRenderElementFpsAnimator.a(r113, "scaleX", new float[]{0.0f, 1.0f});
        int r123 = KtvSettingHelper.k();
        if (r123 <= 0) goto L91;
        r38.a = r123;
    L91:
        LiveKtvMidiRenderElementFpsAnimator r124 = LiveKtvMidiRenderElementFpsAnimator.a(r113, "scaleY", new float[]{0.0f, 1.0f});
        int r125 = KtvSettingHelper.k();
        if (r125 <= 0) goto L94;
        r124.a = r125;
    L94:
        AnimatorSet r39 = new AnimatorSet();
        r25 = r17;
        r39.setDuration(r18.s / ((long) 3));
        r39.setInterpolator(new LinearInterpolator());
        r39.playTogether(new Animator[]{r36, r38, r124});
        r39.setTarget(r113);
        LiveKtvMidiRenderElementFpsAnimator r40 = LiveKtvMidiRenderElementFpsAnimator.a(r113, "alpha", new float[]{1.0f, 0.0f});
        int r41 = KtvSettingHelper.k();
        if (r41 <= 0) goto L97;
        r40.a = r41;
    L97:
        LiveKtvMidiRenderElementFpsAnimator r42 = LiveKtvMidiRenderElementFpsAnimator.a(r113, "scaleX", new float[]{1.0f, 0.0f});
        int r43 = KtvSettingHelper.k();
        if (r43 <= 0) goto L100;
        r42.a = r43;
    L100:
        LiveKtvMidiRenderElementFpsAnimator r44 = LiveKtvMidiRenderElementFpsAnimator.a(r113, "scaleY", new float[]{1.0f, 0.0f});
        int r45 = KtvSettingHelper.k();
        if (r45 <= 0) goto L103;
        r44.a = r45;
    L103:
        AnimatorSet r46 = new AnimatorSet();
        r46.setDuration(this.s / ((long) 5));
        r46.setInterpolator(new LinearInterpolator());
        r46.setStartDelay(this.s - r46.getDuration());
        r46.playTogether(new Animator[]{r40, r42, r44});
        r46.setTarget(r113);
        AnimatorSet r47 = new AnimatorSet();
        r47.playTogether(new Animator[]{r39, r35, r46});
        r47.setInterpolator(new LinearInterpolator());
        r47.setTarget(r113);
        r47.addListener(new q(r113, r112));
        r47.start();
        r18 = this;
        goto L106
    L78:
        if (KtvSettingHelper.z() == true) goto L81;
        r32 = ValueAnimator.ofObject(new com.bytedance.android.live.ktv.common.midi.a(r18.i(r29, r28)), new Object[]{r29, r28});
        goto L82
    L74:
        r122 = SensorBatchGpsCollector.DEFAULT_NETWORK_FALLBACK_TIMEOUT_MS;
        goto L75
    L71:
        r121 = r18.w;
        goto L72
    L68:
        r120 = r18.v;
        goto L69
    L64:
        r117 = (((r18.n + r18.x) + r114) - r116) + r18.y;
        goto L65
    L60:
        r114 = r18.w;
        goto L61
    L57:
        r27 = r18.v;
        goto L58
    L50:
        r113 = r112.a.remove(r11);
        if (r113 == null) goto L53;
        r113.g = r6;
        r113.a = 1.0f;
        r112.b.add(r113);
        goto L53
    L44:
        r112 = r18.p;
        goto L45
    L41:
        r111 = true;
        goto L42
    L118:
        return;
    L115:
        return;
    L112:
        return;
    L111:
        return;
    L110:
        return;
    }
}
