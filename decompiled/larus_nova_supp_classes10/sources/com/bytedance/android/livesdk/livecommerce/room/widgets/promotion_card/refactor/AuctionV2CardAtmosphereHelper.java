package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import android.os.Handler;
import android.os.SystemClock;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.ec.core.widget.AuctionHotAtmosphereView;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphereData;
import com.bytedance.android.ec.model.response.ECAuctionCountdownAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionDigitalAtmosphere;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class AuctionV2CardAtmosphereHelper implements q83.a {
    public ECAuctionAtmosphere a;
    public boolean b;
    public volatile boolean c;
    public Runnable d;
    public final String e;
    public final String f;
    public final AuctionHotAtmosphereView g;
    public com.bytedance.android.ec.common.api.jump.model.a h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/AuctionV2CardAtmosphereHelper$CountState;", "", "NOT_START", "IN_PROGRESS", "FINISHED", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
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
        public final /* synthetic */ AuctionV2CardAtmosphereHelper a;

        public b(AuctionV2CardAtmosphereHelper r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void b(ECAuctionDigitalAtmosphere r6) {
        String r0 = r6.getFrequencyKey();
        Long r1 = Long.valueOf(r6.getFrequencyCount());
        int r2 = com.bytedance.android.livesdk.livecommerce.utils.d.a;
        if (com.bytedance.android.livesdk.livecommerce.utils.d.a(this.e, this.f, r0, r1, false) == false) goto L11;
        ECAuctionAtmosphereData r7 = r6.getData();
        if (r7 == null) goto L12;
        ECAuctionAtmosphereData.Companion.getClass();
        ECHotAtmosphere r8 = ECAuctionAtmosphereData.a.a(r7, null);
        r8.auctionType = "digital";
        a(r8, "digital");
        this.c = true;
        this.b = false;
        b r9 = new b(this);
        Handler r3 = UtilityKotlinExtentionsKt.b;
        r3.postDelayed(r9, KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION);
        Unit r4 = Unit.INSTANCE;
        Runnable r5 = this.d;
        if (r5 == null) goto L9;
        r3.removeCallbacks(r5);
    L9:
        this.d = r9;
        return;
    L12:
        return;
    }

    public final boolean onTick(long r19) {
        dm.a.a("AuctionV2").a("auction atmosphere on tick " + r19);
        ECAuctionAtmosphere r2 = this.a;
        ECAuctionCountdownAtmosphere r3 = null;
        if (r2 == null) goto L5;
        ECAuctionCountdownAtmosphere r4 = r2.getCountDown();
    L6:
        dm.a.b r5 = dm.a.a("AuctionV2");
        StringBuilder r6 = new StringBuilder("count down startTime convert to local: ");
        if (r4 == null) goto L9;
        Long r8 = Long.valueOf(wl.a.a(r4.getStartTime() * 1000));
    L10:
        r6.append(r8);
        r6.append(", systemclock: ");
        r6.append(SystemClock.elapsedRealtime());
        r5.a(r6.toString());
        if (r4 != null) goto L13;
    L61:
        return true;
    L13:
        if ((!this.c) == false) goto L15;
        r3 = r4;
    L15:
        if (r3 == null) goto L61;
        ECAuctionAtmosphere r7 = this.a;
        if (r7 != null) goto L19;
    L47:
        Pair r9 = new Pair(CountState.NOT_START, 0L);
    L48:
        CountState r10 = (CountState) r9.component1();
        long r11 = ((Number) r9.component2()).longValue();
        dm.a.a("AuctionV2").i("only countDownAtmosphere, countDownState=" + r10 + ", remainSecond=" + r11);
        int r1 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.b.a[r10.ordinal()];
        if (r1 == 1) goto L59;
        if (r1 == 2) goto L59;
        if (r1 != 3) goto L61;
        ECAuctionAtmosphereData r12 = r4.getData();
        if (r12 == null) goto L61;
        ECAuctionAtmosphereData.a r13 = ECAuctionAtmosphereData.Companion;
        String r14 = String.valueOf(r11);
        r13.getClass();
        ECHotAtmosphere r15 = ECAuctionAtmosphereData.a.a(r12, r14);
        this.b = true;
        r15.auctionType = "count_down";
        r15.afterTextIconResId = 2131234242;
        a(r15, "count_down");
    L59:
        if (this.b == false) goto L61;
        this.g.setVisibility(4);
        this.b = false;
        goto L61
    L19:
        if (r7.getCountDown() == null) goto L47;
        long r16 = SystemClock.elapsedRealtime();
        ECAuctionAtmosphere r17 = this.a;
        if (r17 == null) goto L26;
        ECAuctionCountdownAtmosphere r18 = r17.getCountDown();
        if (r18 == null) goto L26;
        long r110 = wl.a.a(r18.getStartTime() * 1000);
    L27:
        ECAuctionAtmosphere r20 = this.a;
        if (r20 == null) goto L32;
        ECAuctionCountdownAtmosphere r21 = r20.getCountDown();
        if (r21 == null) goto L32;
        long r111 = wl.a.a(r21.getEndTime() * 1000);
    L33:
        long r112 = (r111 - r16) / 1000;
        if (r16 >= r110) goto L36;
        r9 = new Pair(CountState.NOT_START, 0L);
        goto L48
    L36:
        if (r16 < r110) goto L44;
        if (r16 > r111) goto L44;
        if (r112 > 0) goto L42;
        r9 = new Pair(CountState.FINISHED, 0L);
        goto L48
    L42:
        r9 = new Pair(CountState.IN_PROGRESS, Long.valueOf(r112));
    L44:
        if (r16 <= r111) goto L46;
        r9 = new Pair(CountState.FINISHED, 0L);
        goto L48
    L46:
        r9 = new Pair(CountState.NOT_START, 0L);
    L32:
        r111 = 0;
    L26:
        r110 = 0;
        goto L27
    L9:
        r8 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final void a(ECHotAtmosphere r6, String r7) {
        if (this.g.getVisibility() == 0) goto L5;
        this.g.setVisibility(0);
        this.g.f(true);
        AuctionHotAtmosphereView r0 = this.g;
        r0.setAlpha(0.0f);
        r0.setVisibility(0);
        r0.animate().cancel();
        ViewPropertyAnimator r1 = r0.animate().alpha(1.0f);
        r1.setDuration(160);
        r1.start();
        this.g.i = true;
    L5:
        this.g.i(r6, true, false);
        v r8 = new v("livesdk_show_auction_hot_sale", this.h);
        jf.b.e r2 = jf.b.e.b;
        r8.c("ecom_entrance_form", "live_auction_card");
        r8.c("atmosphere_type", r7);
        r8.i("c2627.d4434");
    }

    public AuctionV2CardAtmosphereHelper(String r2, String r3, AuctionHotAtmosphereView r4, com.bytedance.android.ec.common.api.jump.model.a r5) {
        Intrinsics.checkNotNullParameter(r4, "atmosphereView");
        Intrinsics.checkNotNullParameter(r5, "absParam");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
    }
}
