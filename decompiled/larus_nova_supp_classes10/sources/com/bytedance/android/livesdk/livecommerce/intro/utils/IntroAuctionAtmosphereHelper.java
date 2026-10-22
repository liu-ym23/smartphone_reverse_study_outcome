package com.bytedance.android.livesdk.livecommerce.intro.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.card.presenter.IntroAuctionAtmosphereState;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.auction.IntroAuctionHotAtmosphereView;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroAtmosphere;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.n;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.p;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class IntroAuctionAtmosphereHelper implements q83.a {
    public String a;
    public String b;
    public boolean c;
    public com.bytedance.android.livesdk.livecommerce.intro.model.resp.d d;
    public boolean e;
    public IntroAuctionAtmosphereState f;
    public volatile boolean g;
    public Runnable h;
    public Runnable i;
    public boolean j;
    public final View k;
    public final IntroAuctionHotAtmosphereView l;
    public final ECDraweeView m;
    public final Function1<Boolean, Unit> n;
    public final Function1<String, Unit> o;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/utils/IntroAuctionAtmosphereHelper$CountState;", "", "NOT_START", "IN_PROGRESS", "FINISHED", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
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
        public final /* synthetic */ IntroAuctionAtmosphereHelper a;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e b;

        public b(IntroAuctionAtmosphereHelper r1, com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.e(this.b, true);     // Catch: Throwable -> L4
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
        public final /* synthetic */ IntroAuctionAtmosphereHelper a;

        public c(IntroAuctionAtmosphereHelper r1) {
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
        public final /* synthetic */ IntroAuctionAtmosphereHelper a;

        public d(IntroAuctionAtmosphereHelper r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (ViewCompat.isAttachedToWindow(this.a.l) == false) goto L6;
            IntroAuctionHotAtmosphereView r3 = this.a.l;
            r3.i = true;
            r3.g(false);
            this.a.n.invoke(Boolean.FALSE);
            return;
        }
    }

    public static final class e implements com.bytedance.android.ec.core.widget.h {
        public final /* synthetic */ IntroAuctionAtmosphereHelper a;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e b;

        public final void a(ECHotAtmosphere r1) {
        }

        public final void c(ECHotAtmosphere r1) {
        }

        public final void b() {
            this.a.n.invoke(Boolean.TRUE);
        }

        public final void onAttachedToWindow() {
            if (this.a.l.getTag() != null) goto L6;
            this.a.e(this.b, false);
            return;
        }

        public final void onDetachedFromWindow() {
            this.a.l.setTag(null);
            this.a.l.a();
        }

        public e(IntroAuctionAtmosphereHelper r1, com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final void a(com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e r9) {
        Intrinsics.checkNotNullParameter(r9, "model");
        this.a = r9.g;
        this.b = r9.h;
        IntroAtmosphere r0 = r9.b;
        n r1 = null;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.d r2 = r0.b();
        if (r2 == null) goto L7;
        p r3 = r2.b();
    L8:
        IntroAtmosphere r4 = r9.b;
        if (r4 == null) goto L14;
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.d r5 = r4.b();
        if (r5 == null) goto L14;
        r1 = r5.a();
    L14:
        if (r3 != null) goto L28;
        if (r1 == null) goto L28;
        Pair<CountState, Long> r6 = b(r1);
        CountState r7 = (CountState) r6.component1();
        ((Number) r6.component2()).longValue();
        int r8 = com.bytedance.android.livesdk.livecommerce.intro.utils.a.a[r7.ordinal()];
        if (r8 != 2) goto L19;
        e(r9, false);
        return;
    L19:
        if (r8 != 3) goto L40;
        c(r9, false);
        long r10 = (SystemClock.elapsedRealtime() + ((r1.d() * 1000) - System.currentTimeMillis())) - SystemClock.elapsedRealtime();
        if (r10 <= 0) goto L35;
        b r11 = new b(this, r9);
        Handler r12 = UtilityKotlinExtentionsKt.b;
        r12.postDelayed(r11, r10);
        Unit r13 = Unit.INSTANCE;
        Runnable r14 = this.i;
        if (r14 == null) goto L26;
        r12.removeCallbacks(r14);
    L26:
        this.i = r11;
        return;
    L35:
        return;
    L40:
        return;
    L28:
        if (r3 == null) goto L33;
        String r15 = r3.c();
        Long r16 = Long.valueOf(r3.b());
        int r17 = com.bytedance.android.livesdk.livecommerce.utils.d.a;
        if (com.bytedance.android.livesdk.livecommerce.utils.d.a(this.a, this.b, r15, r16, true) == false) goto L32;
        e(r9, false);
        return;
    L32:
        c(r9, true);
        return;
    L33:
        c(r9, false);
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final Pair<CountState, Long> b(n r16) {
        if (r16 == null) goto L5;
        long r3 = SystemClock.elapsedRealtime();
        long r11 = SystemClock.elapsedRealtime() + ((r16.d() * 1000) - System.currentTimeMillis());
        long r13 = SystemClock.elapsedRealtime() + ((r16.b() * 1000) - System.currentTimeMillis());
        long r5 = Math.round((r13 - r3) / 1000);
        if (r3 >= r11) goto L9;
        Pair<CountState, Long> r0 = new Pair(CountState.NOT_START, 0L);
    L20:
        dm.a.a("IntroAuction").a("getCountState, result = " + r0 + ", currentTime = " + r3 + ", startTime = " + r11 + ", endTime = " + r13 + ", remainSecond = " + r5);
        return r0;
    L9:
        if (r3 < r11) goto L17;
        if (r3 > r13) goto L17;
        if (r5 > 0) goto L15;
        r0 = new Pair(CountState.FINISHED, 0L);
        goto L20
    L15:
        r0 = new Pair(CountState.IN_PROGRESS, Long.valueOf(r5));
    L17:
        if (r3 <= r13) goto L19;
        r0 = new Pair(CountState.FINISHED, 0L);
        goto L20
    L19:
        r0 = new Pair(CountState.NOT_START, 0L);
        goto L20
    L5:
        return new Pair(CountState.NOT_START, 0L);
    }

    public final boolean onTick(long r18) {
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.d r1 = this.d;
        String r2 = null;
        if (r1 == null) goto L5;
        final n r3 = r1.a();
    L7:
        if (r3 != null) goto L9;
    L59:
        return true;
    L9:
        if ((!this.g) == false) goto L11;
        n r4 = r3;
    L12:
        if (r4 == null) goto L59;
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.d r5 = this.d;
        if (r5 == null) goto L16;
        n r6 = r5.a();
    L17:
        Pair<CountState, Long> r7 = b(r6);
        CountState r8 = (CountState) r7.component1();
        final long r9 = ((Number) r7.component2()).longValue();
        int r10 = com.bytedance.android.livesdk.livecommerce.intro.utils.a.b[r8.ordinal()];
        boolean r11 = false;
        if (r10 == 1) goto L53;
        if (r10 == 2) goto L53;
        if (r10 != 3) goto L59;
        int r12 = n.a;
        String r13 = String.valueOf(r9);
        Intrinsics.checkNotNullParameter(r3, "$this$convertToHotAtmosphere");
        ECHotAtmosphere r14 = new ECHotAtmosphere();
        ECUrlModel r15 = r3.c();
        if (r15 == null) goto L27;
        String r16 = r15.getFirstUrl();
    L28:
        r14.img = r16;
        r14.type = 100;
        r14.uiType = 5000;
        r14.num = r13;
        r14.bgColor = "#00000000";
        r14.borderColor = "#00000000";
        r14.bgColors = CollectionsKt.listOf(new String[]{"#00000000", "#00000000", "#00000000"});
        r14.borderColors = CollectionsKt.listOf(new String[]{"#00000000", "#00000000", "#00000000"});
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        ECUrlModel r17 = r3.a();
        if (r17 == null) goto L31;
        this.m.setVisibility(0);
        h0.d(this.m, r17, null, null, null, null, null, 120);
        UtilityKotlinExtentionsKt.f(Integer.valueOf(r17.getWidth()), Integer.valueOf(r17.getHeight()), new IntroAuctionAtmosphereHelper$onTick$$inlined$also$lambda$1(r9, this, r3));
    L32:
        r14.auctionType = "count_down";
        IntroAuctionAtmosphereState r19 = this.f;
        if (r19 != null) goto L35;
    L42:
        boolean r20 = true;
    L43:
        this.e = true;
        r14.afterTextIconResId = 2131234597;
        IntroAuctionHotAtmosphereView r21 = this.l;
        r21.i = true;
        r21.g(false);
        IntroAuctionHotAtmosphereView r22 = this.l;
        IntroAuctionAtmosphereState r23 = this.f;
        if (r23 == null) goto L46;
        r11 = r23.isFold();
    L46:
        r22.i(r14, r20, r11);
        this.o.invoke("count_down");
        IntroAuctionAtmosphereState r24 = this.f;
        if (r24 == null) goto L49;
        r24.setLastInfo(String.valueOf(r9));
    L49:
        IntroAuctionAtmosphereState r25 = this.f;
        if (r25 == null) goto L59;
        r25.setLastType(1);
        goto L59
    L35:
        if (r19.getLastType() != 1) goto L42;
        IntroAuctionAtmosphereState r26 = this.f;
        if (r26 == null) goto L40;
        r2 = r26.getLastInfo();
    L40:
        if (Intrinsics.areEqual(r2, String.valueOf(r9)) == false) goto L42;
        r20 = false;
        goto L43
    L31:
        this.m.setVisibility(8);
        Unit r27 = Unit.INSTANCE;
        goto L32
    L27:
        r16 = null;
    L53:
        if (this.e == false) goto L58;
        this.n.invoke(Boolean.TRUE);
        IntroAuctionAtmosphereState r28 = this.f;
        if (r28 == null) goto L57;
        r28.reset();
    L57:
        this.l.setCallback(null);
        this.l.setTag(null);
        this.l.setVisibility(4);
        this.l.h();
        this.m.setVisibility(4);
    L58:
        this.e = false;
        goto L59
    L16:
        r6 = null;
        goto L17
    L11:
        r4 = null;
        goto L12
    L5:
        r3 = null;
        goto L7
    }

    public final void c(com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "model");
        if (r4 == true) goto L5;
        this.d = null;
    L5:
        this.n.invoke(Boolean.TRUE);
        r3.a.reset();
        this.l.setCallback(null);
        this.l.setTag(null);
        this.l.setVisibility(4);
        this.l.h();
        this.m.setVisibility(4);
    }

    public final void d(p r18, com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e r19) {
        String r2 = r18.e();
        if (Intrinsics.areEqual(r2, r19.a.getLastInfo()) == true) goto L5;
    L7:
        boolean r3 = true;
    L9:
        if (Intrinsics.areEqual(this.l.getTag(2131370767), r2) == false) goto L11;
        r3 = false;
    L11:
        if (r3 == false) goto L13;
        r19.a.setFold(false);
    L13:
        int r11 = com.bytedance.android.livesdk.livecommerce.utils.d.a;
        if (com.bytedance.android.livesdk.livecommerce.utils.d.a(this.a, this.b, r18.c(), Long.valueOf(r18.b()), !r3) == true) goto L18;
        if (r3 == false) goto L18;
        c(r19, true);
        return;
    L18:
        this.l.setVisibility(0);
        ECUrlModel r7 = r18.a();
        if (r7 == null) goto L21;
        this.m.setVisibility(0);
        h0.d(this.m, r7, null, null, null, null, null, 120);
        UtilityKotlinExtentionsKt.f(Integer.valueOf(r7.getWidth()), Integer.valueOf(r7.getHeight()), new IntroAuctionAtmosphereHelper$showDigitalAtmosphere$$inlined$also$lambda$1(this));
    L22:
        int r8 = p.a;
        Intrinsics.checkNotNullParameter(r18, "$this$convertToHotAtmosphere");
        ECHotAtmosphere r9 = new ECHotAtmosphere();
        ECUrlModel r10 = r18.d();
        if (r10 == null) goto L25;
        String r12 = r10.getFirstUrl();
    L26:
        r9.img = r12;
        r9.type = 100;
        r9.uiType = 5000;
        r9.num = r18.e();
        r9.bgColor = "#00000000";
        r9.borderColor = "#00000000";
        r9.bgColors = CollectionsKt.listOf(new String[]{"#00000000", "#00000000", "#00000000"});
        r9.borderColors = CollectionsKt.listOf(new String[]{"#00000000", "#00000000", "#00000000"});
        r9.auctionType = "digital";
        this.l.i(r9, r3, r19.a.isFold());
        this.o.invoke("digital");
        IntroAuctionAtmosphereState r4 = r19.a;
        if (r2 != null) goto L29;
        String r13 = "";
    L30:
        r4.setLastInfo(r13);
        r19.a.setLastType(2);
        IntroAuctionHotAtmosphereView r1 = this.l;
        if (r2 != null) goto L33;
        r2 = "";
    L33:
        r1.setTag(2131370767, r2);
        this.e = false;
        this.g = true;
        c r5 = new c(this);
        Handler r6 = UtilityKotlinExtentionsKt.b;
        r6.postDelayed(r5, KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION);
        Unit r14 = Unit.INSTANCE;
        Runnable r15 = this.h;
        if (r15 == null) goto L36;
        r6.removeCallbacks(r15);
    L36:
        this.h = r5;
        return;
    L29:
        r13 = r2;
        goto L30
    L25:
        r12 = null;
        goto L26
    L21:
        this.m.setVisibility(8);
        Unit r16 = Unit.INSTANCE;
        goto L22
    L5:
        if (2 != r19.a.getLastType()) goto L7;
        r3 = false;
        goto L9
    }

    public final void e(com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e r9, boolean r10) {
        IntroAtmosphere r0 = r9.b;
        String r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.d r2 = r0.b();
    L6:
        this.d = r2;
        this.f = r9.a;
        if (r2 == null) goto L9;
        p r3 = r2.b();
    L10:
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.d r4 = this.d;
        if (r4 == null) goto L13;
        n r5 = r4.a();
    L14:
        this.g = false;
        Runnable r6 = this.h;
        if (r6 == null) goto L17;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r6);
    L17:
        this.h = null;
        if (this.d == null) goto L53;
        IntroProduct r7 = r9.e;
        if (r7 == null) goto L22;
        String r8 = r7.i();
    L23:
        Object r11 = this.l.getTag();
        if ((r11 instanceof com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e) == true) goto L26;
        r11 = null;
    L26:
        com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e r12 = (com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e) r11;
        if (r12 == null) goto L32;
        IntroProduct r13 = r12.e;
        if (r13 == null) goto L32;
        r1 = r13.i();
    L32:
        if ((!Intrinsics.areEqual(r8, r1)) == false) goto L34;
        this.l.h();
    L34:
        this.l.setVisibility(0);
        this.l.setMaxWidth(UtilityKotlinExtentionsKt.d(Float.valueOf(116.0f)));
        this.l.f(r9.d, 24.0f, 18);
        dm.a.a("IntroAuction").a("updateAuctionAtmosphere, isFirstShow: " + this.j);
        if (this.j == true) goto L37;
        this.l.setTag(r9);
        this.l.i = true;
        this.n.invoke(Boolean.FALSE);
        this.l.setAlpha(1.0f);
    L41:
        r9.a.setHasShown(true);
        if (r3 != null) goto L44;
        if (r5 == null) goto L44;
    L52:
        this.l.setCallback(new e(this, r9));
        return;
    L44:
        if (r3 == null) goto L48;
        if (r5 != null) goto L48;
        if (r10 == true) goto L52;
        d(r3, r9);
    L48:
        if (r3 == null) goto L52;
        if (r5 == null) goto L52;
        if (r10 == true) goto L52;
        d(r3, r9);
        goto L52
    L37:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_ANIM() == false) goto L39;
        this.k.setTranslationX(UtilityKotlinExtentionsKt.c(100));
        this.k.setAlpha(0.0f);
        this.k.animate().translationX(0.0f).alpha(1.0f).setDuration(500).setInterpolator(new DecelerateInterpolator()).setListener(new d(this)).start();
    L39:
        this.j = false;
        goto L41
    L22:
        r8 = null;
        goto L23
    L53:
        c(r9, false);
        return;
    L13:
        r5 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IntroAuctionAtmosphereHelper(View r2, IntroAuctionHotAtmosphereView r3, ECDraweeView r4, Function1<? super Boolean, Unit> r5, Function1<? super String, Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "hotAtmosphereView");
        Intrinsics.checkNotNullParameter(r4, "bgView");
        Intrinsics.checkNotNullParameter(r5, "setTopLeftTagVisibility");
        Intrinsics.checkNotNullParameter(r6, "onShowHotAtmosphere");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.n = r5;
        this.o = r6;
        this.j = true;
    }
}
