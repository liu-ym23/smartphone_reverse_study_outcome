package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.util.LiveKtvMidiRenderElementFpsAnimator;
import com.bytedance.android.livesdkapi.depend.message.BackgroundMaterial;
import com.bytedance.android.livesdkapi.depend.message.BuoyMaterial;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.text.DecimalFormat;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j extends com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a {
    public final Handler A;
    public AnimatorSet B;
    public AnimatorSet C;
    public float D;
    public final int E;
    public final Bitmap F;
    public final Bitmap G;
    public final Bitmap H;
    public final Bitmap I;
    public final Bitmap J;
    public final Bitmap K;
    public boolean L;
    public final c M;
    public final c N;
    public final c O;
    public final u P;
    public final c Q;
    public final float k;
    public final float l;
    public final float m;
    public float n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public int s;
    public int t;
    public final int u;
    public final int v;
    public LiveDegradeFpsAnimator w;
    public volatile boolean x;
    public int y;
    public boolean z;

    public static final class a implements Handler.Callback {
        public final /* synthetic */ j a;

        public a(j r1) {
            this.a = r1;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r11) {
            Intrinsics.checkNotNullParameter(r11, "msg");
            int r12 = r11.what;
            if (r12 == 0) goto L30;
            if (r12 != 1) goto L62;
            j r13 = this.a;
            r13.z = false;
            AnimatorSet r6 = r13.C;
            if (r6 != null) goto L9;
        L11:
            AnimatorSet r7 = r13.B;
            if (r7 != null) goto L14;
        L18:
            LiveKtvMidiRenderElementFpsAnimator r8 = LiveKtvMidiRenderElementFpsAnimator.a(r13.M, "alpha", new float[]{1.0f, 0.0f});
            int r9 = KtvSettingHelper.k();
            if (r9 <= 0) goto L21;
            r8.a = r9;
        L21:
            r8.setDuration(500);
            r8.setInterpolator(new LinearInterpolator());
            LiveKtvMidiRenderElementFpsAnimator r2 = LiveKtvMidiRenderElementFpsAnimator.a(r13.Q, "alpha", new float[]{1.0f, 0.0f});
            int r10 = KtvSettingHelper.k();
            if (r10 <= 0) goto L24;
            r2.a = r10;
        L24:
            r2.setDuration(500);
            r2.setInterpolator(new LinearInterpolator());
            com.bytedance.android.live.ktv.common.midi.g r0 = r13.d;
            if (r0 != null) goto L27;
        L29:
            AnimatorSet r1 = new AnimatorSet();
            r1.playTogether(new Animator[]{r8, r2});
            r1.addListener(new l(r13));
            Unit r3 = Unit.INSTANCE;
            r13.C = r1;
            r1.start();
            goto L62
        L27:
            if (r0.getCurrentMode() != 1) goto L29;
            AnimatorSet r4 = new AnimatorSet();
            r4.playTogether(new Animator[]{r8});
            r4.addListener(new k(r13));
            Unit r5 = Unit.INSTANCE;
            r13.C = r4;
            r4.start();
            goto L62
        L14:
            if (r7.isRunning() != true) goto L18;
            AnimatorSet r14 = r13.B;
            if (r14 == null) goto L18;
            r14.cancel();
            goto L18
        L9:
            if (r6.isRunning() != true) goto L11;
        L62:
            return true;
        L30:
            j r15 = this.a;
            r15.z = true;
            AnimatorSet r16 = r15.B;
            if (r16 != null) goto L33;
        L35:
            AnimatorSet r17 = r15.C;
            if (r17 != null) goto L38;
        L42:
            r15.M.g = r15.L;
            r15.M.a = 0.0f;
            LiveKtvMidiRenderElementFpsAnimator r18 = LiveKtvMidiRenderElementFpsAnimator.a(r15.M, "alpha", new float[]{0.0f, 1.0f});
            int r19 = KtvSettingHelper.k();
            if (r19 <= 0) goto L45;
            r18.a = r19;
        L45:
            r18.setDuration(500);
            r18.setInterpolator(new LinearInterpolator());
            c r20 = r15.Q;
            com.bytedance.android.live.ktv.common.midi.g r21 = r15.d;
            if (r21 != null) goto L48;
        L51:
            boolean r22 = true;
        L52:
            r20.g = r22;
            r15.Q.a = 0.0f;
            LiveKtvMidiRenderElementFpsAnimator r23 = LiveKtvMidiRenderElementFpsAnimator.a(r15.Q, "alpha", new float[]{0.0f, 1.0f});
            int r24 = KtvSettingHelper.k();
            if (r24 <= 0) goto L55;
            r23.a = r24;
        L55:
            r23.setDuration(500);
            r23.setInterpolator(new LinearInterpolator());
            com.bytedance.android.live.ktv.common.midi.g r25 = r15.d;
            if (r25 != null) goto L58;
        L61:
            AnimatorSet r26 = new AnimatorSet();
            r26.playTogether(new Animator[]{r18, r23});
            Unit r27 = Unit.INSTANCE;
            r15.B = r26;
            r26.start();
            goto L62
        L58:
            if (r25.getCurrentMode() != 1) goto L61;
            AnimatorSet r28 = new AnimatorSet();
            r28.playTogether(new Animator[]{r18});
            Unit r29 = Unit.INSTANCE;
            r15.B = r28;
            r28.start();
            goto L62
        L48:
            if (r21.getCurrentMode() != 1) goto L51;
            r22 = false;
            goto L52
        L38:
            if (r17.isRunning() != true) goto L42;
            AnimatorSet r30 = r15.C;
            if (r30 == null) goto L42;
            r30.cancel();
            goto L42
        L33:
            if (r16.isRunning() != true) goto L35;
            goto L35
        }
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void f() {
        this.D = -1.0f;
        this.q = 0;
        this.s = 0;
        this.t = 0;
        this.z = false;
        u r1 = this.P;
        r1.k = s1.B(2131918567);
        this.M.g = false;
        this.Q.g = false;
        u r2 = this.P;
        Typeface r3 = Typeface.defaultFromStyle(0);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r2.l = r3;
        this.P.m.setTypeface(Typeface.defaultFromStyle(0));
        this.O.d(this.G);
        this.P.m.setColor(s1.h(2131107710));
    }

    public j() {
        this.k = s1.f(55.0f);
        this.l = s1.f(13.0f);
        this.m = s1.f(16.0f);
        this.o = true;
        this.u = vm2.h.H();
        this.v = vm2.h.J();
        this.D = -1.0f;
        this.E = 1;
        this.F = s1.g(2131252043);
        this.G = s1.g(2131252045);
        this.H = s1.g(2131252042);
        this.I = s1.g(2131252044);
        this.J = s1.g(2131252079);
        this.K = s1.g(2131252080);
        this.L = true;
        this.M = new c();
        this.N = new c();
        this.O = new c();
        this.P = new u();
        this.Q = new c();
        this.A = new Handler(Looper.getMainLooper(), new a(this));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void e() {
        super.e();
        Handler r0 = this.A;
        if (r0 == null) goto L5;
        r0.removeMessages(0);
    L5:
        Handler r1 = this.A;
        if (r1 == null) goto L8;
        r1.removeMessages(1);
    L8:
        AnimatorSet r2 = this.C;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        AnimatorSet r3 = this.B;
        if (r3 == null) goto L14;
        r3.cancel();
    L14:
        LiveDegradeFpsAnimator r4 = this.w;
        if (r4 == null) goto L17;
        r4.cancel();
    L17:
        this.x = false;
        Bitmap r5 = this.F;
        if (r5 == null) goto L20;
        r5.recycle();
    L20:
        Bitmap r6 = this.G;
        if (r6 == null) goto L23;
        r6.recycle();
    L23:
        Bitmap r7 = this.H;
        if (r7 == null) goto L26;
        r7.recycle();
    L26:
        Bitmap r8 = this.I;
        if (r8 == null) goto L29;
        r8.recycle();
    L29:
        this.M.c();
        this.Q.c();
        this.M.c();
        this.N.c();
        this.P.getClass();
        this.O.c();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.t
    public final void a(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        this.Q.b(r2);
        this.M.b(r2);
        this.N.b(r2);
        if (this.o == false) goto L6;
        this.O.b(r2);
        this.P.b(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void d(db0.a r10) {
        Intrinsics.checkNotNullParameter(r10, "model");
        Intrinsics.checkNotNullParameter(r10, "model");
        this.e = r10;
        v r11 = this.f;
        if (r11 != null) goto L5;
        return;
    L5:
        this.n = (r11.j * r11.m) - r11.b;
        com.bytedance.android.live.ktv.common.midi.f r0 = this.c;
        boolean r1 = false;
        if (r0 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        this.L = r2;
        this.M.g = r2;
        ImageLoader.downloadBitmap(com.bytedance.android.live.ktv.common.midi.c.d, new m(this.Q));
        this.N.d(this.J);
        if (this.L == false) goto L14;
        this.M.a = 0.0f;
        this.M.d(this.K);
    L14:
        this.N.g = true;
        float r3 = this.a;
        float r4 = r11.b;
        float r5 = (r3 - r4) / 2.0f;
        RectF r7 = this.N.h;
        float r8 = this.n;
        r7.set(r8, r5, r4 + r8, r5 + r4);
        int r6 = (int) r5;
        this.q = r6;
        this.r = r6;
        float r9 = ((this.n + r11.b) - this.k) - s1.f(2.0f);
        RectF r12 = this.N.h;
        float r13 = r12.top;
        float r14 = r12.height();
        float r15 = this.l;
        float r16 = r13 + ((r14 - r15) / 2.0f);
        this.M.h.set(r9, r16, this.k + r9, r15 + r16);
        this.Q.h.set(0.0f, 0.0f, this.n + (r11.b / 2.0f), this.a);
        this.P.m.setColor(s1.h(2131107710));
        u r17 = this.P;
        Typeface r18 = Typeface.defaultFromStyle(2);
        r17.getClass();
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r17.l = r18;
        float r19 = 9;
        this.P.n = UtilityKotlinExtentionsKt.h(r19);
        this.P.m.setTextSize(UtilityKotlinExtentionsKt.h(r19));
        this.P.g = true;
        this.P.k = s1.B(2131918567);
        float r20 = this.P.m.measureText("44.44");
        float r21 = (s1.f(1.0f) * 2) + r20;
        RectF r22 = this.N.h;
        float r23 = r22.left - ((r21 - r11.b) / 2.0f);
        float r110 = r22.top;
        float r24 = this.m;
        float r111 = r110 - r24;
        this.O.g = true;
        this.O.d(this.G);
        this.O.h.set(r23, r111, r21 + r23, r24 + r111);
        RectF r112 = this.O.h;
        float r25 = r112.left + ((r112.width() - r20) / 2.0f);
        RectF r113 = this.O.h;
        float r114 = r113.bottom - UtilityKotlinExtentionsKt.h(3);
        this.P.h.set(r25, r113.top, r20 + r25, r114);
        com.bytedance.android.live.ktv.common.midi.g r115 = this.d;
        if (r115 != null) goto L17;
    L23:
        this.o = r1;
        return;
    L17:
        if (r115.L() != true) goto L23;
        com.bytedance.android.live.ktv.common.midi.f r116 = this.c;
        if (r116 == null) goto L23;
        if (r116.b() != true) goto L23;
        r1 = true;
        goto L23
    L8:
        if (r0.c() != true) goto L10;
        r2 = true;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void h(MidiSkinDressInfo r3) {
        this.g = r3;
        String r0 = null;
        if (r3 == null) goto L5;
        String r4 = r3.getDressId();
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L14;
        MidiSkinDressInfo r5 = this.g;
        if (r5 == null) goto L11;
        r0 = r5.getDressId();
    L11:
        boolean r6 = Intrinsics.areEqual(r0, BDLocationException.ERROR_TIMEOUT);
        boolean r1 = true;
        if ((!r6) == false) goto L14;
    L15:
        if (r1 == false) goto L51;
        MidiSkinDressInfo r7 = this.g;
        if (r7 == null) goto L27;
        MidiSkinMaterial r8 = r7.getMaterial();
        if (r8 == null) goto L27;
        BackgroundMaterial r9 = r8.getBg();
        if (r9 == null) goto L27;
        py.k r10 = r9.getBuoyAreaBg();
        if (r10 == null) goto L27;
        String r11 = KtvUtilsKt.g(r10);
        if (r11 == null) goto L27;
        ImageLoader.downloadBitmap(r11, new m(this.Q));
    L27:
        MidiSkinDressInfo r12 = this.g;
        if (r12 == null) goto L39;
        MidiSkinMaterial r13 = r12.getMaterial();
        if (r13 == null) goto L39;
        BuoyMaterial r14 = r13.getBuoy();
        if (r14 == null) goto L39;
        py.k r15 = r14.getBuoyBall();
        if (r15 == null) goto L39;
        String r16 = KtvUtilsKt.g(r15);
        if (r16 == null) goto L39;
        ImageLoader.downloadBitmap(r16, new m(this.N));
    L39:
        if (this.L == false) goto L55;
        MidiSkinDressInfo r17 = this.g;
        if (r17 == null) goto L56;
        MidiSkinMaterial r18 = r17.getMaterial();
        if (r18 == null) goto L57;
        BuoyMaterial r19 = r18.getBuoy();
        if (r19 == null) goto L58;
        py.k r20 = r19.getBuoyTailing();
        if (r20 == null) goto L59;
        String r21 = KtvUtilsKt.g(r20);
        if (r21 == null) goto L60;
        ImageLoader.downloadBitmap(r21, new m(this.M));
        return;
    L60:
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L56:
        return;
    L55:
        return;
    L51:
        ImageLoader.downloadBitmap(com.bytedance.android.live.ktv.common.midi.c.d, new m(this.Q));
        this.N.d(this.J);
        if (this.L == false) goto L62;
        this.M.d(this.K);
        return;
    L62:
        return;
    L14:
        r1 = false;
        goto L15
    L5:
        r4 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void b(com.bytedance.android.live.ktv.common.midi.k r9, Long r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "scoreInfo");
        super.b(r9, r10, r11);
        float r12 = r9.a;
        float r0 = r9.b;
        float r13 = r9.d;
        v r1 = this.f;
        if (r1 != null) goto L5;
        Pair<Float, Float> r14 = new Pair(Float.valueOf(this.n), Float.valueOf(this.y));
    L107:
        s r15 = this.j;
        if (r15 == null) goto L111;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r15.b = r14;
        return;
    L111:
        return;
    L5:
        com.bytedance.android.live.ktv.common.midi.g r2 = this.d;
        if (r2 == null) goto L8;
        int r3 = r2.getCurrentMode();
    L10:
        if (r3 == 0) goto L17;
        com.bytedance.android.live.ktv.common.midi.f r4 = this.c;
        if (r4 != null) goto L14;
    L16:
        boolean r5 = false;
    L18:
        com.bytedance.android.live.ktv.common.midi.g r6 = this.d;
        if (r6 != null) goto L21;
    L27:
        boolean r7 = false;
    L28:
        this.p = r7;
        if (r5 == false) goto L66;
        float r8 = 0;
        if (r12 > r8) goto L33;
    L37:
        boolean r16 = false;
    L38:
        Message r17 = null;
        if (r16 == true) goto L41;
    L52:
        if (r16 == true) goto L66;
        if (this.z == false) goto L66;
        Handler r18 = this.A;
        if (r18 == null) goto L58;
        r17 = r18.obtainMessage(1);
    L58:
        Handler r19 = this.A;
        if (r19 == null) goto L61;
        r19.removeMessages(0);
    L61:
        if (r17 == null) goto L66;
        Handler r20 = this.A;
        if (r20 == null) goto L66;
        r20.sendMessageDelayed(r17, 300);
        goto L66
    L41:
        if (this.z == true) goto L52;
        Handler r21 = this.A;
        if (r21 == null) goto L45;
        r17 = r21.obtainMessage(0);
    L45:
        Handler r22 = this.A;
        if (r22 == null) goto L48;
        r22.removeMessages(1);
    L48:
        if (r17 == null) goto L66;
        Handler r23 = this.A;
        if (r23 == null) goto L66;
        r23.sendMessageDelayed(r17, 300);
        goto L66
    L33:
        if (r0 <= r8) goto L37;
        if (Math.abs(r12 - r0) > ((Number) KtvSettingHelper.C0.getValue()).intValue()) goto L37;
        r16 = true;
    L66:
        if (this.p == false) goto L85;
        this.o = true;
        if (r13 > 0) goto L70;
    L87:
        int r24 = this.t % this.u;
        this.t = r24 + 1;
        if (r24 == 0) goto L91;
        r14 = new Pair(Float.valueOf(this.n), Float.valueOf(this.y));
        goto L107
    L91:
        if (r12 >= r1.g) goto L93;
    L96:
        int r25 = this.s + 1;
        this.s = r25;
        if (r25 >= this.v) goto L99;
        r14 = new Pair(Float.valueOf(this.n), Float.valueOf(this.y));
        goto L107
    L99:
        this.s = 0;
    L100:
        float r110 = Integer.valueOf(r1.a(this.a, (int) r12)).intValue() - (this.N.h.height() / 2.0f);
        int r26 = (int) r110;
        this.y = r26;
        if (this.x == false) goto L103;
    L106:
        r14 = new Pair(Float.valueOf(this.n), Float.valueOf(this.y));
        goto L107
    L103:
        if (this.q == r26) goto L106;
        float r111 = r110 - this.r;
        this.x = true;
        LiveDegradeFpsAnimator r112 = LiveDegradeFpsAnimator.ofFloat(new float[]{this.N.e, r111}).setFpsConfig(KtvSettingHelper.k());
        r112.setDuration(100);
        r112.setInterpolator(new LinearInterpolator());
        r112.setEvaluator(new com.bytedance.android.live.ktv.common.midi.v2.h());
        r112.addListener(new n(r111, this));
        r112.addUpdateListener(new o(this));
        Unit r113 = Unit.INSTANCE;
        this.w = r112;
        r112.start();
        this.q = r26;
        goto L106
    L93:
        if (r12 > r1.h) goto L96;
        this.s = 0;
        goto L100
    L70:
        if (r13 == this.D) goto L87;
        if (r13 == 0.0f) goto L87;
        this.D = r13;
        this.O.g = true;
        this.P.g = true;
        this.P.k = new DecimalFormat("#0.0").format(Float.valueOf(this.D));
        int r27 = this.E;
        if (r27 == 1) goto L82;
        if (r27 != 2) goto L87;
        if (this.D < vm2.h.z()) goto L80;
        this.O.d(this.H);
        this.P.m.setColor(s1.h(2131107709));
        goto L87
    L80:
        this.O.d(this.I);
        this.P.m.setColor(s1.h(2131107710));
        goto L87
    L82:
        if (this.D < vm2.h.z()) goto L84;
        this.O.d(this.F);
        this.P.m.setColor(s1.h(2131107709));
        goto L87
    L84:
        this.O.d(this.G);
        this.P.m.setColor(s1.h(2131107710));
        goto L87
    L85:
        if (r11 == true) goto L87;
        this.o = false;
        goto L87
    L21:
        if (r6.L() != true) goto L27;
        com.bytedance.android.live.ktv.common.midi.f r28 = this.c;
        if (r28 == null) goto L27;
        if (r28.b() != true) goto L27;
        r7 = true;
        goto L28
    L14:
        if (r4.c() != true) goto L16;
    L17:
        r5 = true;
        goto L18
    L8:
        r3 = -1;
        goto L10
    }
}
