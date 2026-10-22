package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.midi.KtvMidiHitDisplayView;
import com.bytedance.android.live.ktv.common.midi.f;
import com.bytedance.android.live.ktv.common.midi.g;
import com.bytedance.android.live.ktv.common.midi.v2.KtvHitAnimationViewV2;
import com.bytedance.android.live.ktv.common.midi.v2.KtvMidiViewV2;
import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdkapi.depend.message.BackgroundMaterial;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001(B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016RT\u0010\u0017\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/midi/KtvComponentMidiView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/b;", "Lcom/bytedance/android/live/ktv/common/midi/g;", "strategy", "", "setPerformStrategy", "Lcom/bytedance/android/live/ktv/common/model/api/g0;", "config", "setConfig", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isTimeOut", "", "timeStamp", "s", "Lkotlin/jvm/functions/Function2;", "getOneDrawCallback", "()Lkotlin/jvm/functions/Function2;", "setOneDrawCallback", "(Lkotlin/jvm/functions/Function2;)V", "oneDrawCallback", "", "t", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "setTypeName", "(Ljava/lang/String;)V", "typeName", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentMidiView extends ConstraintLayout implements com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b {
    public KtvMidiHitDisplayView a;
    public KtvMidiViewV2 b;
    public ViewGroup c;
    public KtvHitAnimationViewV2 d;
    public long e;
    public int f;
    public final int g;
    public final int h;
    public boolean i;
    public int j;
    public g k;
    public f l;
    public final e m;
    public MidiSkinDressInfo n;
    public Animator o;
    public Animator p;
    public HSImageView q;
    public k r;
    public Function2<? super Boolean, ? super Long, Unit> s;
    public String t;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ KtvComponentMidiView a;
        public final /* synthetic */ Pair b;

        public b(KtvComponentMidiView r1, Pair r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            KtvHitAnimationViewV2 r0 = this.a.d;
            if (r0 == null) goto L6;
            qb0.c.a.a(r0, ((Number) this.b.getFirst()).floatValue(), ((Number) this.b.getSecond()).floatValue(), Integer.valueOf(this.a.j), this.a.i);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ KtvComponentMidiView a;

        public c(KtvComponentMidiView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getViewTreeObserver().addOnGlobalLayoutListener(this.a.m);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ KtvComponentMidiView a;

        public d(KtvComponentMidiView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getViewTreeObserver().addOnGlobalLayoutListener(this.a.m);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ KtvComponentMidiView a;

        /* JADX WARN: Type inference failed for: r1v0, types: [android.view.ViewGroup, com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvComponentMidiView] */
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            KtvMidiViewV2 r0 = this.a.b;
            if (r0 == null) goto L16;
            Pair r1 = r0.getTimeRange();
            ?? r2 = this.a;
            long r3 = ((Number) r1.getFirst()).longValue();
            long r4 = ((Number) r1.getSecond()).longValue() + r3;
            int r5 = r2.getWidth();
            if (r5 == 0) goto L16;
            float r6 = (r5 * r3) / r4;
            KtvHitAnimationViewV2 r7 = r2.d;
            if (r7 == null) goto L10;
            ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        L11:
            if (r8 == null) goto L13;
            r8.width = (int) r6;
        L13:
            KtvHitAnimationViewV2 r9 = r2.d;
            if (r9 == null) goto L16;
            r9.setLayoutParams(r8);
            goto L16
        L10:
            r8 = null;
        L16:
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        public e(KtvComponentMidiView r1) {
            this.a = r1;
        }
    }

    static {
    }

    public KtvComponentMidiView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvComponentMidiView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void A1() {
        this.i = false;
        Animator r0 = this.p;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRunning() != true) goto L11;
        Animator r1 = this.p;
        if (r1 == null) goto L12;
        r1.cancel();
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final View asView() {
        return this;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public void setConfig(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public void setContainerVisibility(int r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void onDetach() {
        KtvHitAnimationViewV2 r0 = this.d;
        if (r0 == null) goto L10;
        KtvHitAnimationViewV2.d r1 = r0.b;
        if (r1 == null) goto L7;
        r1.clear();
    L7:
        KtvHitAnimationViewV2.d r2 = r0.a;
        if (r2 == null) goto L10;
        r2.clear();
    L10:
        KtvMidiHitDisplayView r3 = this.a;
        if (r3 == null) goto L13;
        r3.onDetach();
    L13:
        KtvMidiViewV2 r4 = this.b;
        if (r4 == null) goto L16;
        r4.detach();
    L16:
        g r5 = this.k;
        if (r5 == null) goto L19;
        r5.clear();
    L19:
        setVisibility(8);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void reset() {
        Animator r0 = this.p;
        if (r0 != null) goto L5;
    L9:
        this.i = false;
        KtvMidiViewV2 r1 = this.b;
        if (r1 == null) goto L12;
        r1.clear();
    L12:
        this.f = -1;
        this.j = 0;
        return;
    L5:
        if (r0.isRunning() != true) goto L9;
        Animator r2 = this.p;
        if (r2 == null) goto L9;
        r2.cancel();
        goto L9
    }

    public Function2<Boolean, Long, Unit> getOneDrawCallback() {
        return this.s;
    }

    public String getTypeName() {
        return this.t;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void R2(long r3) {
        KtvMidiViewV2 r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L15;
        r0.D3(r3);
        return;
    L15:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void dispatchDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.dispatchDraw(r4);
        Function2<Boolean, Long, Unit> r5 = getOneDrawCallback();
        if (r5 == null) goto L6;
        Unit r6 = (Unit) r5.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void qc(f r3) {
        Intrinsics.checkNotNullParameter(r3, "strategy");
        this.l = r3;
        KtvMidiViewV2 r1 = this.b;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "strategy");
        r1.K = r3;
        return;
    }

    public void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r1) {
        this.s = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public void setPerformStrategy(g r3) {
        Intrinsics.checkNotNullParameter(r3, "strategy");
        this.k = r3;
        MidiSkinDressInfo r1 = r3.z();
        if (r1 == null) goto L5;
        r3.y(r1);
    L5:
        KtvMidiViewV2 r4 = this.b;
        if (r4 == null) goto L8;
        r4.setPerformStrategy(this.k);
    L8:
        KtvHitAnimationViewV2 r5 = this.d;
        if (r5 == null) goto L11;
        r5.b(this.k);
    L11:
        KtvMidiHitDisplayView r6 = this.a;
        if (r6 == null) goto L15;
        g r2 = this.k;
        Intrinsics.checkNotNullParameter(r2, "strategy");
        r6.h = r2;
    L15:
        if (this.k.getCurrentMode() != 2) goto L25;
        KtvMidiHitDisplayView r7 = this.a;
        if (r7 == null) goto L19;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
    L20:
        if (r8 == null) goto L22;
        r8.width = s1.f(144.0f);
    L22:
        KtvMidiHitDisplayView r0 = this.a;
        if (r0 == null) goto L25;
        r0.setLayoutParams(r8);
        goto L25
    L19:
        r8 = null;
    L25:
        postDelayed(new d(this), 100);
    }

    public void setTypeName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.t = r2;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void xc(Pair<Integer, Integer> r3) {
        if (r3 == null) goto L7;
        KtvMidiViewV2 r0 = this.b;
        if (r0 == null) goto L8;
        r0.D5(((Number) r3.getFirst()).intValue(), ((Number) r3.getSecond()).intValue());
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void y(MidiSkinDressInfo r2) {
        this.n = r2;
        this.k.y(r2);
        KtvMidiViewV2 r0 = this.b;
        if (r0 == null) goto L6;
        r0.y(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void Gk(db0.a r3, g r4) {
        Intrinsics.checkNotNullParameter(r3, "model");
        if (r4 == null) goto L6;
        this.k = r4;
    L6:
        if (this.k.getCurrentMode() != 2) goto L8;
        UIUtils.updateLayout(this, -3, -1);
        UIUtils.updateLayout(this.c, -3, -1);
        UIUtils.updateLayout(this.a, -3, -1);
    L8:
        KtvMidiViewV2 r5 = this.b;
        if (r5 == null) goto L11;
        r5.f0(r3, this.k);
    L11:
        KtvMidiViewV2 r6 = this.b;
        if (r6 == null) goto L14;
        r6.setScoreInterval(h.D());
    L14:
        postDelayed(new c(this), 100);
    }

    public final void R5(SpannableString r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "spannableString");
        KtvMidiViewV2 r1 = this.b;
        if (r1 == null) goto L18;
        Intrinsics.checkNotNullParameter(r3, "spannableString");
        if (r4 == false) goto L9;
        ConstraintLayout r5 = r1.C;
        if (r5 == null) goto L10;
        r5.setVisibility(0);
    L10:
        TextView r6 = r1.D;
        if (r6 == null) goto L13;
        r6.setText(r3);
    L13:
        TextView r7 = r1.D;
        if (r7 == null) goto L16;
        r7.setBackgroundResource(2131252046);
    L16:
        KtvMidiViewV2.S5(r1.E);
        return;
    L9:
        KtvMidiViewV2.S5(r1.C);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KtvComponentMidiView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.f = -1;
        this.g = h.G();
        this.h = h.I();
        this.k = new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.a();
        this.m = new e(this);
        LayoutInflater.from(r2).inflate(2131566667, this);
        this.c = (ViewGroup) findViewById(2131376912);
        this.b = findViewById(2131367611);
        KtvHitAnimationViewV2 r5 = findViewById(2131367609);
        this.d = r5;
        Intrinsics.checkNotNull(r5);
        r5.b(this.k);
        KtvMidiHitDisplayView r6 = findViewById(2131367610);
        this.a = r6;
        Intrinsics.checkNotNull(r6);
        g r7 = this.k;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "strategy");
        r6.h = r7;
        this.q = findViewById(2131376979);
        KtvHitAnimationViewV2 r8 = this.d;
        if (r8 == null) goto L5;
        r8.setAnimGap(0);
    L5:
        MidiSkinDressInfo r9 = this.n;
        if (r9 == null) goto L12;
        MidiSkinMaterial r10 = r9.getMaterial();
        if (r10 == null) goto L12;
        BackgroundMaterial r11 = r10.getBg();
        if (r11 == null) goto L12;
        k r12 = r11.getGlobalBg();
    L13:
        this.r = r12;
        this.t = "midi";
        return;
    L12:
        r12 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void F9(com.bytedance.android.live.ktv.common.midi.k r11, Long r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "scoreInfo");
        if (r12 == null) goto L7;
        KtvMidiViewV2 r0 = this.b;
        if (r0 == null) goto L7;
        r0.c = r12.longValue();
    L7:
        KtvMidiViewV2 r3 = this.b;
        if (r3 == null) goto L11;
        Pair r14 = qb0.b.a.a(r3, r11.a, r11.b, r11.d, false, r13, 8);
        if (r14 == null) goto L11;
    L12:
        int r15 = this.f;
        int r1 = r11.e;
        if (r15 != r1) goto L15;
    L132:
        float r16 = r11.a;
        float r2 = 0;
        if (r16 <= r2) goto L151;
        float r17 = r11.b;
        if (r17 > r2) goto L137;
        return;
    L137:
        if (Math.abs(r16 - r17) > this.h) goto L153;
        KtvMidiViewV2 r18 = this.b;
        if (r18 == null) goto L141;
        r18.S3();
    L141:
        f r19 = this.l;
        if (r19 != null) goto L144;
        return;
    L144:
        if (r19.a() != true) goto L155;
        long r4 = this.e % ((long) this.g);
        this.e = 1 + r4;
        if (r4 != 0) goto L156;
        KtvHitAnimationViewV2 r110 = this.d;
        if (r110 == null) goto L157;
        r110.post(new b(this, r14));
        return;
    L157:
        return;
    L156:
        return;
    L155:
        return;
    L153:
        return;
    L151:
        return;
    L15:
        if (r11.d <= 0) goto L132;
        if (r1 < 0) goto L132;
        f r111 = this.l;
        if (r111 != null) goto L20;
    L126:
        this.f = r11.e;
        Integer r112 = r11.f;
        if (r112 == null) goto L129;
        int r113 = r112.intValue();
    L130:
        if (r113 <= 0) goto L132;
        Integer r114 = r11.f;
        Intrinsics.checkNotNull(r114);
        this.j = r114.intValue();
        goto L132
    L129:
        r113 = 0;
        goto L130
    L20:
        if (r111.d() != true) goto L126;
        Integer r115 = r11.f;
        if (r115 == null) goto L24;
        int r116 = r115.intValue();
    L25:
        int r5 = r11.g;
        com.bytedance.android.live.ktv.common.midi.e.b("KtvComponentMidiView", "showHitAnimation hitType " + r116 + " comboCount " + r5);
        if (KtvSettingHelper.z() == false) goto L28;
        int r6 = KtvSettingHelper.l();
    L30:
        if (r116 == 3) goto L32;
    L35:
        if (r116 != 3) goto L37;
    L40:
        KtvMidiHitDisplayView r7 = this.a;
        if (r7 == null) goto L48;
        if (this.i == false) goto L45;
        this.k.H();
        boolean r8 = true;
    L46:
        r7.C4(r116, r5, r8);
        goto L48
    L45:
        r8 = false;
    L48:
        if (this.k.A() == false) goto L126;
        if (this.i == false) goto L112;
        Animator r117 = this.o;
        if (r117 != null) goto L54;
    L55:
        Animator r118 = this.p;
        if (r118 == null) goto L60;
        if (r118.isRunning() == true) goto L126;
    L60:
        if (this.k.getCurrentMode() == 2) goto L126;
        ObjectAnimator r119 = ObjectAnimator.ofFloat(this.q, View.ALPHA, new float[]{0.0f, 1.0f});
        r119.setDuration(500);
        r119.setInterpolator(new LinearInterpolator());
        r119.addListener(new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.b(this));
        Unit r9 = Unit.INSTANCE;
        this.o = r119;
        ObjectAnimator r120 = ObjectAnimator.ofFloat(this.q, View.ALPHA, new float[]{1.0f, 0.0f});
        r120.setDuration(500);
        r120.setInterpolator(new LinearInterpolator());
        r120.addListener(new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.c(this));
        this.p = r120;
        MidiSkinDressInfo r121 = this.n;
        k r10 = null;
        if (r121 == null) goto L65;
        String r122 = r121.getDressId();
    L67:
        if (TextUtils.isEmpty(r122) == true) goto L75;
        MidiSkinDressInfo r123 = this.n;
        if (r123 == null) goto L71;
        String r124 = r123.getDressId();
    L73:
        if ((!Intrinsics.areEqual(r124, BDLocationException.ERROR_TIMEOUT)) == false) goto L75;
        boolean r125 = true;
    L76:
        if (r125 == false) goto L111;
        MidiSkinDressInfo r126 = this.n;
        if (r126 == null) goto L84;
        MidiSkinMaterial r127 = r126.getMaterial();
        if (r127 == null) goto L84;
        BackgroundMaterial r128 = r127.getBg();
        if (r128 == null) goto L84;
        k r129 = r128.getGlobalBg();
    L86:
        if (Intrinsics.areEqual(r129, this.r) == false) goto L95;
        HSImageView r130 = this.q;
        if (r130 == null) goto L91;
        r130.setVisibility(0);
    L91:
        if (this.i == false) goto L126;
        Animator r131 = this.o;
        if (r131 == null) goto L126;
        r131.start();
        goto L126
    L95:
        MidiSkinDressInfo r132 = this.n;
        if (r132 == null) goto L102;
        MidiSkinMaterial r133 = r132.getMaterial();
        if (r133 == null) goto L102;
        BackgroundMaterial r134 = r133.getBg();
        if (r134 == null) goto L102;
        k r135 = r134.getGlobalBg();
    L103:
        this.r = r135;
        FrescoLoader r136 = FrescoLoader.with(getContext());
        MidiSkinDressInfo r20 = this.n;
        if (r20 == null) goto L110;
        MidiSkinMaterial r21 = r20.getMaterial();
        if (r21 == null) goto L110;
        BackgroundMaterial r22 = r21.getBg();
        if (r22 == null) goto L110;
        r10 = r22.getGlobalBg();
    L110:
        r136.load(r10).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(com.bytedance.android.live.ktv.common.midi.e.a(this, new KtvComponentMidiView$playMidiBgAnimation$3(this))).into(this.q);
    L102:
        r135 = null;
    L84:
        r129 = null;
        goto L86
    L111:
        FrescoLoader.with(getContext()).load(com.bytedance.android.live.ktv.common.midi.c.b).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(com.bytedance.android.live.ktv.common.midi.e.a(this, new KtvComponentMidiView$playMidiBgAnimation$4(this))).into(this.q);
        goto L126
    L71:
        r124 = null;
    L75:
        r125 = false;
        goto L76
    L65:
        r122 = null;
        goto L67
    L54:
        if (r117.isRunning() == true) goto L126;
    L112:
        Animator r137 = this.o;
        if (r137 != null) goto L115;
    L116:
        Animator r138 = this.p;
        if (r138 == null) goto L126;
        if (r138.isRunning() != true) goto L126;
    L120:
        Animator r139 = this.o;
        if (r139 == null) goto L123;
        r139.end();
    L123:
        Animator r140 = this.p;
        if (r140 == null) goto L126;
        r140.end();
        goto L126
    L115:
        if (r137.isRunning() == true) goto L120;
    L37:
        if (this.i == false) goto L40;
        if (r5 >= r6) goto L40;
        this.i = false;
        goto L40
    L32:
        if (this.i == true) goto L35;
        if (r5 < r6) goto L35;
        this.i = true;
        goto L40
    L28:
        r6 = h.x();
        goto L30
    L24:
        r116 = 0;
    L11:
        r14 = new Pair(Float.valueOf(0.0f), Float.valueOf(0.0f));
        goto L12
    }

    public /* synthetic */ KtvComponentMidiView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
