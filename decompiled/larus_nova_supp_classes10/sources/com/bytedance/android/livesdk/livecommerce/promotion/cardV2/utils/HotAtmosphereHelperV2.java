package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.widget.AuctionHotAtmosphereView;
import com.bytedance.android.ec.core.widget.h;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphereData;
import com.bytedance.android.ec.model.response.ECAuctionCountdownAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionDigitalAtmosphere;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.model.AuctionAtmosphereState;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.roundcorner.ECPromotionTopTagLinearlayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class HotAtmosphereHelperV2 implements q83.a {
    public String a;
    public String b;
    public ECAuctionAtmosphere c;
    public boolean d;
    public AuctionAtmosphereState e;
    public int f;
    public volatile boolean g;
    public Runnable h;
    public Runnable i;
    public final AuctionHotAtmosphereView j;
    public final View k;
    public final Function2<Integer, String, Unit> l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/utils/HotAtmosphereHelperV2$CountState;", "", "NOT_START", "IN_PROGRESS", "FINISHED", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CountState extends Enum<CountState> {
        public static final CountState FINISHED = null;
        public static final CountState IN_PROGRESS = null;
        public static final CountState NOT_START = null;
        public static final /* synthetic */ CountState[] a = null;

        static {
            CountState r1 = new CountState("NOT_START", 0);
            NOT_START = r1;
            CountState r2 = new CountState("IN_PROGRESS", 1);
            IN_PROGRESS = r2;
            CountState r3 = new CountState("FINISHED", 2);
            FINISHED = r3;
            a = new CountState[]{r1, r2, r3};
        }

        public static CountState valueOf(String r1) {
            return (CountState) r27.a.a(CountState.class, r1);
        }

        public static CountState[] values() {
            return (CountState[]) a.clone();
        }

        public CountState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ HotAtmosphereHelperV2 a;
        public final /* synthetic */ jj2.c b;
        public final /* synthetic */ boolean c;

        public b(HotAtmosphereHelperV2 r1, jj2.c r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.e(this.b, this.c, true);     // Catch: Throwable -> L4
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
        public final /* synthetic */ HotAtmosphereHelperV2 a;

        public c(HotAtmosphereHelperV2 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.g = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d extends AnimatorListenerAdapter {
        public final /* synthetic */ HotAtmosphereHelperV2 a;
        public final /* synthetic */ jj2.c b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (ViewCompat.isAttachedToWindow(this.a.j) == false) goto L6;
            this.b.a.setHasShown(true);
            AuctionHotAtmosphereView r3 = this.a.j;
            r3.i = true;
            r3.g(false);
            return;
        }

        public d(HotAtmosphereHelperV2 r1, jj2.c r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e implements h {
        public final /* synthetic */ HotAtmosphereHelperV2 a;
        public final /* synthetic */ jj2.c b;
        public final /* synthetic */ View c;

        public final void a(ECHotAtmosphere r1) {
        }

        public final void c(ECHotAtmosphere r1) {
        }

        public final void b() {
            this.c.animate().alpha(1.0f).setDuration(120).start();
        }

        public final void onAttachedToWindow() {
            if (this.a.j.getTag() != null) goto L6;
            this.a.e(this.b, false, false);
            return;
        }

        public final void onDetachedFromWindow() {
            this.a.j.setTag(null);
            this.c.animate().cancel();
            this.a.j.a();
        }

        public e(HotAtmosphereHelperV2 r1, jj2.c r2, View r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public final Pair<CountState, Long> b(ECAuctionCountdownAtmosphere r16) {
        if (r16 == null) goto L5;
        long r3 = SystemClock.elapsedRealtime();
        long r5 = r16.getStartTime() * 1000;
        long r9 = System.currentTimeMillis();
        long r11 = SystemClock.elapsedRealtime() + (r5 - r9);
        long r6 = r16.getEndTime() * 1000;
        long r10 = System.currentTimeMillis();
        long r13 = SystemClock.elapsedRealtime() + (r6 - r10);
        long r7 = (r13 - r3) / 1000;
        if (r3 < r11) goto L21;
        if (r3 < r11) goto L17;
        if (r3 > r13) goto L17;
        if (r7 > 0) goto L23;
        return new Pair(CountState.FINISHED, 0L);
    L23:
        return new Pair(CountState.IN_PROGRESS, Long.valueOf(r7));
    L17:
        if (r3 <= r13) goto L20;
        return new Pair(CountState.FINISHED, 0L);
    L20:
        return new Pair(CountState.NOT_START, 0L);
    L21:
        return new Pair(CountState.NOT_START, 0L);
    L5:
        return new Pair(CountState.NOT_START, 0L);
    }

    public final void c(jj2.c r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        this.k.setAlpha(1.0f);
        r3.a.reset();
        this.j.setCallback(null);
        this.j.setTag(null);
        this.j.setVisibility(4);
        this.j.h();
    }

    public final boolean onTick(long r8) {
        ECAuctionAtmosphere r9 = this.c;
        String r10 = null;
        if (r9 == null) goto L5;
        ECAuctionCountdownAtmosphere r11 = r9.getCountDown();
    L7:
        if (r11 != null) goto L9;
    L52:
        return true;
    L9:
        if ((!this.g) == false) goto L11;
        ECAuctionCountdownAtmosphere r1 = r11;
    L12:
        if (r1 == null) goto L52;
        ECAuctionAtmosphere r2 = this.c;
        if (r2 == null) goto L16;
        ECAuctionCountdownAtmosphere r3 = r2.getCountDown();
    L17:
        Pair<CountState, Long> r4 = b(r3);
        CountState r5 = (CountState) r4.component1();
        long r6 = ((Number) r4.component2()).longValue();
        int r7 = com.bytedance.android.livesdk.livecommerce.promotion.cardV2.utils.b.b[r5.ordinal()];
        boolean r12 = false;
        if (r7 == 1) goto L47;
        if (r7 == 2) goto L47;
        if (r7 != 3) goto L52;
        ECAuctionAtmosphereData r13 = r11.getData();
        if (r13 == null) goto L52;
        ECAuctionAtmosphereData.a r14 = ECAuctionAtmosphereData.Companion;
        String r15 = String.valueOf(r6);
        r14.getClass();
        ECHotAtmosphere r16 = ECAuctionAtmosphereData.a.a(r13, r15);
        r16.auctionType = "count_down";
        AuctionAtmosphereState r17 = this.e;
        if (r17 != null) goto L29;
    L36:
        boolean r18 = true;
    L37:
        this.d = true;
        r16.afterTextIconResId = 2131234243;
        AuctionHotAtmosphereView r19 = this.j;
        AuctionAtmosphereState r20 = this.e;
        if (r20 == null) goto L40;
        r12 = r20.isFold();
    L40:
        r19.i(r16, r18, r12);
        this.l.invoke(Integer.valueOf(this.f), "count_down");
        AuctionAtmosphereState r21 = this.e;
        if (r21 == null) goto L43;
        r21.setLastInfo(String.valueOf(r6));
    L43:
        AuctionAtmosphereState r22 = this.e;
        if (r22 == null) goto L52;
        r22.setLastType(1);
        goto L52
    L29:
        if (r17.getLastType() != 1) goto L36;
        AuctionAtmosphereState r23 = this.e;
        if (r23 == null) goto L34;
        r10 = r23.getLastInfo();
    L34:
        if (Intrinsics.areEqual(r10, String.valueOf(r6)) == false) goto L36;
        r18 = false;
    L47:
        if (this.d == false) goto L52;
        this.k.setAlpha(1.0f);
        AuctionAtmosphereState r24 = this.e;
        if (r24 == null) goto L51;
        r24.reset();
    L51:
        this.j.setCallback(null);
        this.j.setTag(null);
        this.j.setVisibility(4);
        this.j.h();
        this.d = false;
        goto L52
    L16:
        r3 = null;
        goto L17
    L11:
        r1 = null;
        goto L12
    L5:
        r11 = null;
        goto L7
    }

    public final void a(jj2.c r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "model");
        this.f = r9.i;
        this.a = r9.l;
        this.b = r9.m;
        ECAuctionAtmosphere r0 = r9.c.a();
        ECAuctionCountdownAtmosphere r1 = null;
        if (r0 == null) goto L5;
        ECAuctionDigitalAtmosphere r2 = r0.getDigital();
    L6:
        ECAuctionAtmosphere r3 = r9.c.a();
        if (r3 == null) goto L10;
        r1 = r3.getCountDown();
    L10:
        if (r2 != null) goto L24;
        if (r1 == null) goto L24;
        Pair<CountState, Long> r4 = b(r1);
        CountState r5 = (CountState) r4.component1();
        ((Number) r4.component2()).longValue();
        int r6 = com.bytedance.android.livesdk.livecommerce.promotion.cardV2.utils.b.a[r5.ordinal()];
        if (r6 != 2) goto L15;
        e(r9, r10, false);
        return;
    L15:
        if (r6 != 3) goto L35;
        c(r9);
        long r7 = (SystemClock.elapsedRealtime() + ((r1.getStartTime() * 1000) - System.currentTimeMillis())) - SystemClock.elapsedRealtime();
        if (r7 <= 0) goto L30;
        b r8 = new b(this, r9, r10);
        Handler r11 = UtilityKotlinExtentionsKt.b;
        r11.postDelayed(r8, r7);
        Unit r12 = Unit.INSTANCE;
        Runnable r13 = this.i;
        if (r13 == null) goto L22;
        r11.removeCallbacks(r13);
    L22:
        this.i = r8;
        return;
    L30:
        return;
    L35:
        return;
    L24:
        if (r2 == null) goto L28;
        String r14 = r2.getFrequencyKey();
        Long r15 = Long.valueOf(r2.getFrequencyCount());
        int r16 = com.bytedance.android.livesdk.livecommerce.utils.d.a;
        if (com.bytedance.android.livesdk.livecommerce.utils.d.a(this.a, this.b, r14, r15, true) == false) goto L33;
        e(r9, r10, false);
        return;
    L33:
        return;
    L28:
        c(r9);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public HotAtmosphereHelperV2(AuctionHotAtmosphereView r2, ECPromotionTopTagLinearlayout r3, Function2 r4) {
        Intrinsics.checkNotNullParameter(r2, "hotAtmosphereView");
        Intrinsics.checkNotNullParameter(r3, "topLeftContainer");
        Intrinsics.checkNotNullParameter(r4, "onShowHotAtmosphere");
        this.j = r2;
        this.k = r3;
        this.l = r4;
    }

    public final void d(ECAuctionDigitalAtmosphere r11, jj2.c r12, boolean r13) {
        ECAuctionAtmosphereData r0 = r11.getData();
        if (r0 == null) goto L5;
        String r1 = r0.getNum();
    L7:
        if (Intrinsics.areEqual(r1, r12.b.getLastInfo()) == true) goto L9;
    L12:
        boolean r14 = true;
    L14:
        if (Intrinsics.areEqual(this.j.getTag(2131370767), r1) == false) goto L16;
        r14 = false;
    L16:
        if (r14 == false) goto L18;
        r12.b.setFold(false);
    L18:
        int r8 = com.bytedance.android.livesdk.livecommerce.utils.d.a;
        if (com.bytedance.android.livesdk.livecommerce.utils.d.a(this.a, this.b, r11.getFrequencyKey(), Long.valueOf(r11.getFrequencyCount()), !r14) == true) goto L21;
        if (r14 == false) goto L21;
        return;
    L21:
        ECAuctionAtmosphereData r15 = r11.getData();
        if (r15 == null) goto L24;
        ECAuctionAtmosphereData.Companion.getClass();
        ECHotAtmosphere r16 = ECAuctionAtmosphereData.a.a(r15, null);
        r16.auctionType = "digital";
        this.j.i(r16, r14, r12.b.isFold());
        this.l.invoke(Integer.valueOf(r12.i), "digital");
    L24:
        AuctionAtmosphereState r17 = r12.b;
        if (r1 != null) goto L27;
        String r2 = "";
    L28:
        r17.setLastInfo(r2);
        r12.b.setLastType(2);
        AuctionHotAtmosphereView r18 = this.j;
        if (r1 != null) goto L31;
        r1 = "";
    L31:
        r18.setTag(2131370767, r1);
        this.g = true;
        c r19 = new c(this);
        Handler r110 = UtilityKotlinExtentionsKt.b;
        r110.postDelayed(r19, KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION);
        Unit r111 = Unit.INSTANCE;
        Runnable r112 = this.h;
        if (r112 == null) goto L34;
        r110.removeCallbacks(r112);
    L34:
        this.h = r19;
        return;
    L27:
        r2 = r1;
        goto L28
    L9:
        if (2 != r12.b.getLastType()) goto L12;
        if (r13 == true) goto L12;
        r14 = false;
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    public final void e(jj2.c r10, boolean r11, boolean r12) {
        View r0 = this.k;
        ECAuctionAtmosphere r1 = r10.c.a();
        this.c = r1;
        this.e = r10.b;
        String r2 = null;
        if (r1 == null) goto L5;
        ECAuctionDigitalAtmosphere r3 = r1.getDigital();
    L6:
        ECAuctionAtmosphere r4 = this.c;
        if (r4 == null) goto L9;
        ECAuctionCountdownAtmosphere r5 = r4.getCountDown();
    L10:
        this.g = false;
        Runnable r6 = this.h;
        if (r6 == null) goto L13;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r6);
    L13:
        this.h = null;
        if (Intrinsics.areEqual(r10.c.i(), Boolean.TRUE) == true) goto L16;
    L43:
        c(r10);
        return;
    L16:
        if (this.c == null) goto L43;
        String r7 = r10.f;
        Object r8 = this.j.getTag();
        if ((r8 instanceof jj2.c) == true) goto L20;
        r8 = null;
    L20:
        jj2.c r9 = (jj2.c) r8;
        if (r9 == null) goto L24;
        r2 = r9.f;
    L24:
        if ((!Intrinsics.areEqual(r7, r2)) == false) goto L26;
        this.j.h();
    L26:
        this.j.setVisibility(0);
        this.j.setMaxWidth(UtilityKotlinExtentionsKt.d(Float.valueOf(116.0f)));
        this.j.f(false);
        if (r10.a.getHasShown() == false) goto L29;
        this.j.setTag(r10);
        this.j.i = true;
        r0.animate().cancel();
        r0.setAlpha(0.0f);
        this.j.setAlpha(1.0f);
    L32:
        if (r3 != null) goto L34;
        if (r5 == null) goto L34;
    L42:
        this.j.setCallback(new e(this, r10, r0));
        return;
    L34:
        if (r3 == null) goto L38;
        if (r5 != null) goto L38;
        if (r12 == true) goto L42;
        d(r3, r10, r11);
    L38:
        if (r3 == null) goto L42;
        if (r5 == null) goto L42;
        if (r12 == true) goto L42;
        d(r3, r10, r11);
        goto L42
    L29:
        if (this.j.getTag() != null) goto L32;
        this.j.setTag(r10);
        r0.animate().alpha(0.0f).setDuration(120).start();
        this.j.setAlpha(0.0f);
        this.j.animate().alpha(1.0f).setDuration(160).setStartDelay(80).setListener(new d(this, r10)).start();
        goto L32
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
