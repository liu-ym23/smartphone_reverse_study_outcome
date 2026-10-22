package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.animation.LinearInterpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.util.LiveKtvMidiRenderElementFpsAnimator;
import com.bytedance.bdlocation.sensor.SensorBatchGpsCollector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i extends a {
    public final float k;
    public final float l;
    public final float m;
    public final float n;
    public final c o;
    public final c p;
    public final u q;
    public final u r;
    public final c s;
    public AnimatorSet t;
    public AnimatorSet u;

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void f() {
        AnimatorSet r0 = this.t;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        AnimatorSet r1 = this.u;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.o.a();
        this.p.a();
        this.q.a();
        this.r.a();
        this.s.a();
    }

    public i() {
        this.k = UtilityKotlinExtentionsKt.h(96);
        this.l = UtilityKotlinExtentionsKt.h(56);
        float r0 = 10;
        this.m = UtilityKotlinExtentionsKt.h(r0);
        this.n = UtilityKotlinExtentionsKt.h(r0);
        this.o = new c();
        this.p = new c();
        this.q = new u();
        this.r = new u();
        this.s = new c();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void e() {
        super.e();
        AnimatorSet r0 = this.t;
        if (r0 != null) goto L5;
    L9:
        AnimatorSet r1 = this.u;
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.isRunning() != true) goto L18;
        AnimatorSet r2 = this.u;
        if (r2 == null) goto L19;
        r2.cancel();
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (r0.isRunning() != true) goto L9;
        AnimatorSet r3 = this.t;
        if (r3 == null) goto L9;
        r3.cancel();
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.t
    public final void a(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        this.o.b(r2);
        this.p.b(r2);
        this.s.b(r2);
        this.q.b(r2);
        this.r.b(r2);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void d(db0.a r8) {
        Intrinsics.checkNotNullParameter(r8, "model");
        Intrinsics.checkNotNullParameter(r8, "model");
        this.e = r8;
        float r9 = this.a;
        float r1 = this.l;
        float r10 = r9 - r1;
        float r2 = this.b;
        float r3 = r2 - this.k;
        float r4 = this.m;
        float r5 = r3 - r4;
        float r6 = r1 + r10;
        float r7 = r2 - r4;
        this.p.h.set(r3, r10, r2, r6);
        this.o.h.set(r5, r10, r7, r6);
        this.s.h.set(r5, r10, r7, r6);
        this.o.l = true;
        this.s.l = true;
        u r11 = this.q;
        float r12 = this.n;
        r11.n = r12;
        r11.m.setTextSize(r12);
        u r13 = this.r;
        float r14 = this.n;
        r13.n = r14;
        r13.m.setTextSize(r14);
        this.q.m.setColor(-1);
        this.r.m.setColor(-1);
        Typeface r15 = Typeface.create(Typeface.createFromAsset(jc1.a.b().getAssets(), "font/ttlive_ktv_midi_combo_font.ttf"), 2);     // Catch: Exception -> L5
        u r16 = this.q;     // Catch: Exception -> L5
        r16.getClass();     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(r15, "<set-?>");     // Catch: Exception -> L5
        r16.l = r15;     // Catch: Exception -> L5
        u r17 = this.r;     // Catch: Exception -> L5
        r17.getClass();     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(r15, "<set-?>");     // Catch: Exception -> L5
        r17.l = r15;     // Catch: Exception -> L5
    L7:
        float r18 = this.q.m.measureText("x444");
        Paint.FontMetrics r0 = this.q.m.getFontMetrics();
        float r19 = (r0.bottom - r0.top) + r0.leading;
        float r20 = this.b;
        float r21 = this.m;
        float r22 = (r20 - r18) - r21;
        float r23 = this.a;
        float r24 = (r23 - r19) - r21;
        float r25 = r20 - r21;
        float r26 = r23 - r21;
        this.q.h.set(r22, r24, r25, r26);
        this.r.h.set(r22, r24, r25, r26);
        return;
    L5:
        e = move-exception;
        ALogger.e("KtvRoomMidiHitDisplayView", "load font asset exception: " + e.getMessage());
        goto L7
    }

    public static final void i(i r2, String r3, Bitmap r4) {
        r2.p.g = true;
        c r0 = r2.p;
        r0.o = r3;
        r0.d(r4);
        AnimatorSet r5 = r2.t;
        if (r5 == null) goto L6;
        r5.start();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void b(com.bytedance.android.live.ktv.common.midi.k r36, Long r37, boolean r38) {
        i r14 = this;
        Intrinsics.checkNotNullParameter(r36, "scoreInfo");
        super.b(r36, r37, r38);
        s r0 = r14.j;
        if (r0 == null) goto L5;
        int r1 = r0.a;
    L6:
        int r2 = r36.e;
        if (r1 == r2) goto L240;
        if (r36.d <= 0) goto L240;
        if (r2 < 0) goto L240;
        com.bytedance.android.live.ktv.common.midi.f r3 = r14.c;
        if (r3 != null) goto L14;
    L227:
        i r8 = r14;
    L229:
        Integer r4 = r36.f;
        if (r4 == null) goto L232;
        int r13 = r4.intValue();
    L233:
        s r5 = r8.j;
        if (r5 == null) goto L236;
        r5.a = r36.e;
    L236:
        if (r13 <= 0) goto L241;
        if (r5 == null) goto L242;
        r5.d = r13;
        return;
    L242:
        return;
    L241:
        return;
    L232:
        r13 = 0;
        goto L233
    L14:
        if (r3.d() != true) goto L227;
        Integer r6 = r36.f;
        if (r6 == null) goto L18;
        int r7 = r6.intValue();
    L19:
        int r9 = r36.g;
        com.bytedance.android.live.ktv.common.midi.e.b("KtvComponentMidiView", "showHitAnimation hitType " + r7 + " comboCount " + r9);
        s r10 = r14.j;
        if (r10 == null) goto L22;
        boolean r11 = r10.c;
    L23:
        int r12 = KtvSettingHelper.l();
        if (r7 != 3) goto L30;
        if (r11 == true) goto L30;
        if (r9 < r12) goto L30;
        s r15 = r14.j;
        if (r15 == null) goto L36;
        r15.c = true;
    L36:
        if (r11 == false) goto L40;
        com.bytedance.android.live.ktv.common.midi.g r16 = r14.d;
        if (r16 == null) goto L40;
        r16.H();
        boolean r17 = true;
    L41:
        com.bytedance.android.live.ktv.common.midi.e.b("KtvRoomMidiHitDisplayView", "showHitAnimation hitType " + r7 + " comboCount " + r9 + "  isAdvanced " + r17);
        com.bytedance.android.live.ktv.common.midi.g r18 = r14.d;
        if (r18 == null) goto L227;
        String r19 = r18.K(r7, r17);
        if (r19 == null) goto L227;
        com.bytedance.android.live.ktv.common.midi.g r20 = r14.d;
        if (r20 == null) goto L50;
        String r21 = r20.J();
    L52:
        if (r7 == 1) goto L195;
        if (r7 == 2) goto L195;
        if (r7 == 3) goto L57;
    L121:
        r8 = r14;
        goto L229
    L57:
        if (r17 == false) goto L123;
        if (r21 != null) goto L60;
        r21 = com.bytedance.android.live.ktv.common.midi.c.a;
    L60:
        r14.q.k = "x" + r9;
        r14.r.k = "x" + r9;
        final LiveKtvMidiRenderElementFpsAnimator r22 = LiveKtvMidiRenderElementFpsAnimator.a(r14.q, "alpha", new float[]{0.0f, 1.0f});
        int r23 = KtvSettingHelper.k();
        if (r23 <= 0) goto L63;
        r22.a = r23;
    L63:
        r22.setStartDelay(400);
        r22.setDuration(300);
        r22.setInterpolator(new LinearInterpolator());
        final LiveKtvMidiRenderElementFpsAnimator r110 = LiveKtvMidiRenderElementFpsAnimator.a(r14.q, "scaleX", new float[]{2.0f, 1.0f});
        int r24 = KtvSettingHelper.k();
        if (r24 <= 0) goto L66;
        r110.a = r24;
    L66:
        r110.setStartDelay(400);
        r110.setDuration(300);
        r110.setInterpolator(PathInterpolatorCompat.create(0.63f, 0.0f, 0.8f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r25 = LiveKtvMidiRenderElementFpsAnimator.a(r14.q, "scaleY", new float[]{2.0f, 1.0f});
        int r26 = KtvSettingHelper.k();
        if (r26 <= 0) goto L69;
        r25.a = r26;
    L69:
        r25.setStartDelay(400);
        r25.setDuration(300);
        r25.setInterpolator(PathInterpolatorCompat.create(0.63f, 0.0f, 0.8f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r111 = LiveKtvMidiRenderElementFpsAnimator.a(r14.q, "alpha", new float[]{1.0f, 0.0f});
        int r27 = KtvSettingHelper.k();
        if (r27 <= 0) goto L72;
        r111.a = r27;
    L72:
        r111.setStartDelay(1800);
        r111.setDuration(200);
        r111.setInterpolator(PathInterpolatorCompat.create(0.17f, 0.17f, 0.67f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r28 = LiveKtvMidiRenderElementFpsAnimator.a(r14.r, "alpha", new float[]{0.0f, 1.0f});
        int r29 = KtvSettingHelper.k();
        if (r29 <= 0) goto L75;
        r28.a = r29;
    L75:
        long r30 = 700;
        r28.setStartDelay(700);
        r28.setDuration(300);
        r28.setInterpolator(new LinearInterpolator());
        final LiveKtvMidiRenderElementFpsAnimator r112 = LiveKtvMidiRenderElementFpsAnimator.a(r14.r, "alpha", new float[]{1.0f, 0.0f});
        int r31 = KtvSettingHelper.k();
        if (r31 <= 0) goto L78;
        r112.a = r31;
        r30 = 700;
    L78:
        r112.setStartDelay(r30);
        r112.setDuration(300);
        r112.setInterpolator(PathInterpolatorCompat.create(0.17f, 0.17f, 0.67f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r32 = LiveKtvMidiRenderElementFpsAnimator.a(r14.r, "scaleX", new float[]{2.0f, 1.0f});
        int r33 = KtvSettingHelper.k();
        if (r33 <= 0) goto L81;
        r32.a = r33;
    L81:
        r32.setStartDelay(700);
        r32.setDuration(300);
        String r113 = r21;
        r32.setInterpolator(PathInterpolatorCompat.create(0.63f, 0.0f, 0.8f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r34 = LiveKtvMidiRenderElementFpsAnimator.a(r14.r, "scaleY", new float[]{2.0f, 1.0f});
        int r35 = KtvSettingHelper.k();
        if (r35 <= 0) goto L84;
        r34.a = r35;
    L84:
        r34.setStartDelay(700);
        r34.setDuration(300);
        r34.setInterpolator(PathInterpolatorCompat.create(0.63f, 0.0f, 0.8f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r39 = LiveKtvMidiRenderElementFpsAnimator.a(r14.s, "scaleX", new float[]{3.0f, 1.0f});
        int r40 = KtvSettingHelper.k();
        if (r40 <= 0) goto L87;
        r39.a = r40;
    L87:
        r39.setStartDelay(200);
        r39.setDuration(200);
        r39.setInterpolator(PathInterpolatorCompat.create(0.18f, 0.0f, 0.0f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r41 = LiveKtvMidiRenderElementFpsAnimator.a(r14.s, "scaleY", new float[]{3.0f, 1.0f});
        int r42 = KtvSettingHelper.k();
        if (r42 <= 0) goto L90;
        r41.a = r42;
    L90:
        r41.setStartDelay(200);
        r41.setDuration(200);
        r41.setInterpolator(PathInterpolatorCompat.create(0.18f, 0.0f, 0.0f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r43 = LiveKtvMidiRenderElementFpsAnimator.a(r14.s, "alpha", new float[]{0.0f, 1.0f});
        int r44 = KtvSettingHelper.k();
        if (r44 <= 0) goto L93;
        r43.a = r44;
    L93:
        r43.setStartDelay(200);
        r43.setDuration(200);
        r43.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.0f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r45 = LiveKtvMidiRenderElementFpsAnimator.a(r14.s, "alpha", new float[]{1.0f, 0.0f});
        int r46 = KtvSettingHelper.k();
        if (r46 <= 0) goto L96;
        r45.a = r46;
    L96:
        r45.setStartDelay(1800);
        r45.setDuration(200);
        r45.setInterpolator(new LinearInterpolator());
        LiveKtvMidiRenderElementFpsAnimator r47 = LiveKtvMidiRenderElementFpsAnimator.a(r14.o, "alpha", new float[]{0.0f, 1.0f});
        int r48 = KtvSettingHelper.k();
        if (r48 <= 0) goto L99;
        r47.a = r48;
    L99:
        r47.setDuration(200);
        r47.setInterpolator(new LinearInterpolator());
        LiveKtvMidiRenderElementFpsAnimator r49 = LiveKtvMidiRenderElementFpsAnimator.a(r14.o, "alpha", new float[]{1.0f, 0.0f});
        int r50 = KtvSettingHelper.k();
        if (r50 <= 0) goto L102;
        r49.a = r50;
    L102:
        r49.setStartDelay(SensorBatchGpsCollector.DEFAULT_NETWORK_FALLBACK_TIMEOUT_MS);
        r49.setDuration(200);
        r49.setInterpolator(new LinearInterpolator());
        AnimatorSet r51 = new AnimatorSet();
        com.bytedance.android.live.ktv.common.midi.v2.a.a(r51, new KtvMidiComboRender$showAdvancedPerfectCombo$$inlined$apply$lambda$1(this, r22, r110, r25, r39, r41, r43, r45, r111, r28, r112, r34, r32));
        r51.playTogether(new Animator[]{r22, r110, r25, r39, r41, r43, r45, r111, r28, r112, r34, r32});
        Unit r52 = Unit.INSTANCE;
        r14 = this;
        r14.t = r51;
        AnimatorSet r53 = new AnimatorSet();
        r53.playTogether(new Animator[]{r49, r47});
        r14.u = r53;
        if ((!Intrinsics.areEqual(r113, r14.o.o)) == true) goto L111;
        c r54 = r14.o;
        if (r54.n == null) goto L111;
        r54.g = true;
        AnimatorSet r55 = r14.u;
        if (r55 == null) goto L110;
        r55.start();
    L110:
        String r114 = r19;
    L113:
        if ((!Intrinsics.areEqual(r114, r14.s.o)) == true) goto L120;
        c r56 = r14.s;
        if (r56.n == null) goto L120;
        r56.g = true;
        r14.q.g = true;
        r14.r.g = true;
        AnimatorSet r57 = r14.t;
        if (r57 == null) goto L121;
        r57.start();
    L120:
        ImageLoader.downloadBitmap(r114, new e(r14, r114));
    L111:
        r114 = r19;
        ImageLoader.downloadBitmap(r113, new d(r14, r114));
        goto L113
    L123:
        if (r9 <= 1) goto L163;
        r14.q.k = "x" + r9;
        r14.q.g = true;
        final LiveKtvMidiRenderElementFpsAnimator r115 = LiveKtvMidiRenderElementFpsAnimator.a(r14.q, "alpha", new float[]{0.0f, 1.0f});
        int r58 = KtvSettingHelper.k();
        if (r58 <= 0) goto L127;
        r115.a = r58;
    L127:
        r115.setDuration(300);
        r115.setInterpolator(new LinearInterpolator());
        final LiveKtvMidiRenderElementFpsAnimator r59 = LiveKtvMidiRenderElementFpsAnimator.a(r14.q, "scaleX", new float[]{2.0f, 1.0f});
        int r60 = KtvSettingHelper.k();
        if (r60 <= 0) goto L130;
        r59.a = r60;
    L130:
        r59.setDuration(300);
        r59.setInterpolator(PathInterpolatorCompat.create(0.63f, 0.0f, 0.8f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r61 = LiveKtvMidiRenderElementFpsAnimator.a(r14.q, "scaleY", new float[]{2.0f, 1.0f});
        int r62 = KtvSettingHelper.k();
        if (r62 <= 0) goto L133;
        r61.a = r62;
    L133:
        r61.setDuration(300);
        r61.setInterpolator(PathInterpolatorCompat.create(0.63f, 0.0f, 0.8f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r63 = LiveKtvMidiRenderElementFpsAnimator.a(r14.p, "scaleX", new float[]{1.0f, 1.3f});
        int r64 = KtvSettingHelper.k();
        if (r64 <= 0) goto L136;
        r63.a = r64;
    L136:
        r63.setStartDelay(150);
        r63.setDuration(90);
        r63.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r116 = LiveKtvMidiRenderElementFpsAnimator.a(r14.p, "scaleY", new float[]{1.0f, 1.3f});
        int r65 = KtvSettingHelper.k();
        if (r65 <= 0) goto L139;
        r116.a = r65;
    L139:
        r116.setStartDelay(150);
        r116.setDuration(90);
        r116.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r117 = LiveKtvMidiRenderElementFpsAnimator.a(r14.p, "scaleX", new float[]{1.3f, 1.0f});
        int r66 = KtvSettingHelper.k();
        if (r66 <= 0) goto L142;
        r117.a = r66;
    L142:
        r117.setStartDelay(270);
        r117.setDuration(80);
        r117.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r67 = LiveKtvMidiRenderElementFpsAnimator.a(r14.p, "alpha", new float[]{0.0f, 1.0f});
        int r68 = KtvSettingHelper.k();
        if (r68 <= 0) goto L145;
        r67.a = r68;
    L145:
        r67.setDuration(300);
        r67.setInterpolator(new LinearInterpolator());
        final LiveKtvMidiRenderElementFpsAnimator r69 = LiveKtvMidiRenderElementFpsAnimator.a(r14.p, "scaleY", new float[]{1.3f, 1.0f});
        int r70 = KtvSettingHelper.k();
        if (r70 <= 0) goto L148;
        r69.a = r70;
    L148:
        r69.setStartDelay(270);
        r69.setDuration(80);
        r69.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r71 = LiveKtvMidiRenderElementFpsAnimator.a(r14.q, "alpha", new float[]{1.0f, 0.0f});
        int r72 = KtvSettingHelper.k();
        if (r72 <= 0) goto L151;
        r71.a = r72;
    L151:
        r71.setStartDelay(1300);
        r71.setDuration(200);
        r71.setInterpolator(PathInterpolatorCompat.create(0.17f, 0.17f, 0.67f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r73 = LiveKtvMidiRenderElementFpsAnimator.a(r14.p, "alpha", new float[]{1.0f, 0.0f});
        int r74 = KtvSettingHelper.k();
        if (r74 <= 0) goto L154;
        r73.a = r74;
    L154:
        r73.setStartDelay(1300);
        r73.setDuration(200);
        r73.setInterpolator(PathInterpolatorCompat.create(0.17f, 0.17f, 0.67f, 1.0f));
        AnimatorSet r75 = new AnimatorSet();
        com.bytedance.android.live.ktv.common.midi.v2.a.a(r75, new KtvMidiComboRender$showPerfectCombo$$inlined$apply$lambda$1(this, r115, r59, r61, r63, r67, r116, r117, r69, r71, r73));
        r75.playTogether(new Animator[]{r115, r59, r61, r63, r67, r116, r117, r69, r71, r73});
        Unit r76 = Unit.INSTANCE;
        r8 = this;
        r8.t = r75;
        if ((!Intrinsics.areEqual(r19, r8.p.o)) == true) goto L162;
        c r77 = r8.p;
        if (r77.n == null) goto L162;
        r77.g = true;
        r8.q.g = true;
        AnimatorSet r78 = r8.t;
        if (r78 == null) goto L229;
        r78.start();
    L162:
        ImageLoader.downloadBitmap(r19, new g(r8, r19));
        goto L229
    L163:
        r8 = r14;
        AnimatorSet r79 = r8.t;
        if (r79 == null) goto L168;
        boolean r80 = true;
        if (r79.isRunning() == true) goto L229;
    L169:
        AnimatorSet r81 = r8.u;
        if (r81 != null) goto L172;
    L174:
        final LiveKtvMidiRenderElementFpsAnimator r118 = LiveKtvMidiRenderElementFpsAnimator.a(r8.p, "alpha", new float[]{0.0f, 1.0f});
        int r82 = KtvSettingHelper.k();
        if (r82 <= 0) goto L177;
        r118.a = r82;
    L177:
        r118.setDuration(200);
        r118.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.0f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r119 = LiveKtvMidiRenderElementFpsAnimator.a(r8.p, "scaleX", new float[]{2.0f, 1.0f});
        int r83 = KtvSettingHelper.k();
        if (r83 <= 0) goto L180;
        r119.a = r83;
    L180:
        r119.setDuration(200);
        r119.setInterpolator(PathInterpolatorCompat.create(0.18f, 0.0f, 0.0f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r120 = LiveKtvMidiRenderElementFpsAnimator.a(r8.p, "scaleY", new float[]{2.0f, 1.0f});
        int r85 = KtvSettingHelper.k();
        if (r85 <= 0) goto L183;
        r120.a = r85;
    L183:
        r120.setDuration(200);
        r120.setInterpolator(PathInterpolatorCompat.create(0.18f, 0.0f, 0.0f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r86 = LiveKtvMidiRenderElementFpsAnimator.a(r8.p, "alpha", new float[]{1.0f, 0.0f});
        int r87 = KtvSettingHelper.k();
        if (r87 <= 0) goto L186;
        r86.a = r87;
    L186:
        r86.setDuration(200);
        r86.setStartDelay(1500);
        r86.setInterpolator(new LinearInterpolator());
        AnimatorSet r88 = new AnimatorSet();
        com.bytedance.android.live.ktv.common.midi.v2.a.a(r88, new KtvMidiComboRender$showPerfectHit$$inlined$apply$lambda$1(this, r120, r119, r118, r86));
        r88.playTogether(new Animator[]{r120, r119, r118, r86});
        Unit r89 = Unit.INSTANCE;
        r8.t = r88;
        if ((!Intrinsics.areEqual(r19, r8.p.o)) == true) goto L194;
        c r90 = r8.p;
        if (r90.n == null) goto L194;
        r90.g = true;
        AnimatorSet r91 = r8.t;
        if (r91 == null) goto L229;
        r91.start();
    L194:
        ImageLoader.downloadBitmap(r19, new h(r8, r19));
        goto L229
    L172:
        if (r81.isRunning() != r80) goto L174;
    L168:
        r80 = true;
    L195:
        r8 = r14;
        AnimatorSet r92 = r8.t;
        if (r92 == null) goto L200;
        boolean r93 = true;
        if (r92.isRunning() == true) goto L229;
    L201:
        AnimatorSet r94 = r8.u;
        if (r94 != null) goto L204;
    L206:
        final LiveKtvMidiRenderElementFpsAnimator r121 = LiveKtvMidiRenderElementFpsAnimator.a(r8.p, "alpha", new float[]{0.0f, 1.0f});
        r121.setDuration(200);
        r121.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.0f, 1.0f));
        int r95 = KtvSettingHelper.k();
        if (r95 <= 0) goto L209;
        r121.a = r95;
    L209:
        final LiveKtvMidiRenderElementFpsAnimator r122 = LiveKtvMidiRenderElementFpsAnimator.a(r8.p, "scaleX", new float[]{1.6f, 1.0f});
        r122.setDuration(200);
        r122.setInterpolator(PathInterpolatorCompat.create(0.18f, 0.0f, 0.0f, 1.0f));
        int r96 = KtvSettingHelper.k();
        if (r96 <= 0) goto L212;
        r122.a = r96;
    L212:
        final LiveKtvMidiRenderElementFpsAnimator r123 = LiveKtvMidiRenderElementFpsAnimator.a(r8.p, "scaleY", new float[]{1.6f, 1.0f});
        r123.setDuration(200);
        r123.setInterpolator(PathInterpolatorCompat.create(0.18f, 0.0f, 0.0f, 1.0f));
        int r97 = KtvSettingHelper.k();
        if (r97 <= 0) goto L215;
        r123.a = r97;
    L215:
        final LiveKtvMidiRenderElementFpsAnimator r98 = LiveKtvMidiRenderElementFpsAnimator.a(r8.p, "alpha", new float[]{1.0f, 0.0f});
        r98.setDuration(200);
        r98.setStartDelay(1500);
        r98.setInterpolator(new LinearInterpolator());
        int r99 = KtvSettingHelper.k();
        if (r99 <= 0) goto L218;
        r98.a = r99;
    L218:
        AnimatorSet r100 = new AnimatorSet();
        com.bytedance.android.live.ktv.common.midi.v2.a.a(r100, new KtvMidiComboRender$showGoodOrGreatHit$$inlined$apply$lambda$1(this, r123, r122, r121, r98));
        r100.playTogether(new Animator[]{r123, r122, r121, r98});
        Unit r101 = Unit.INSTANCE;
        r8.t = r100;
        if ((!Intrinsics.areEqual(r19, r8.p.o)) == true) goto L226;
        c r102 = r8.p;
        if (r102.n == null) goto L226;
        r102.g = true;
        AnimatorSet r103 = r8.t;
        if (r103 == null) goto L229;
        r103.start();
    L226:
        ImageLoader.downloadBitmap(r19, new f(r8, r19));
        goto L229
    L204:
        if (r94.isRunning() != r93) goto L206;
    L200:
        r93 = true;
        goto L201
    L50:
        r21 = null;
    L40:
        r17 = false;
    L30:
        if (r7 == 3) goto L36;
        if (r11 == false) goto L36;
        if (r9 >= r12) goto L36;
        s r104 = r14.j;
        if (r104 == null) goto L36;
        r104.c = false;
        goto L36
    L22:
        r11 = false;
        goto L23
    L18:
        r7 = 0;
    L240:
        return;
    L5:
        r1 = -1;
        goto L6
    }
}
