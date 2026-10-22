package com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right_kmp.slice.component;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.ec.core.widget.AuctionHotAtmosphereView;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphereData;
import com.bytedance.android.ec.model.response.ECAuctionCountdownAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionDigitalAtmosphere;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.d;
import com.bytedance.android.livesdk.livecommerce.utils.m0;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KMPAuctionHeaderV2ViewManager extends com.bytedance.android.ecom.arch.slice.render.elements.b<AuctionHotAtmosphereView> {
    public AtmosphereHelper H3;

    public static final class AtmosphereHelper {
        public boolean a;
        public ECAuctionAtmosphere b;
        public volatile boolean c;
        public Runnable d;
        public final String e;
        public final String f;
        public final AuctionHotAtmosphereView g;
        public final com.bytedance.android.ec.common.api.jump.model.a h;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/bottom_right_kmp/slice/component/KMPAuctionHeaderV2ViewManager$AtmosphereHelper$CountState;", "", "NOT_START", "IN_PROGRESS", "FINISHED", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
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
            public final /* synthetic */ AtmosphereHelper a;

            public b(AtmosphereHelper r1) {
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

        public final void b(ECAuctionCountdownAtmosphere r15) {
            dm.a.a("AuctionV2").a("count down startTime convert to local: " + wl.a.a(r15.getStartTime() * 1000) + ", systemclock: " + SystemClock.elapsedRealtime());
            if ((!this.c) == false) goto L5;
            ECAuctionCountdownAtmosphere r1 = r15;
        L6:
            if (r1 == null) goto L35;
            long r3 = SystemClock.elapsedRealtime();
            long r7 = wl.a.a(r15.getStartTime() * 1000);
            long r9 = wl.a.a(r15.getEndTime() * 1000);
            long r11 = (r9 - r3) / 1000;
            if (r3 >= r7) goto L10;
            Pair r4 = new Pair(CountState.NOT_START, 0L);
        L21:
            CountState r2 = (CountState) r4.component1();
            long r5 = ((Number) r4.component2()).longValue();
            dm.a.a("AuctionV2").i("only countDownAtmosphere, countDownState=" + r2 + ", remainSecond=" + r5);
            int r0 = com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right_kmp.slice.component.a.a[r2.ordinal()];
            if (r0 == 1) goto L32;
            if (r0 == 2) goto L32;
            if (r0 != 3) goto L39;
            ECAuctionAtmosphereData r16 = r15.getData();
            if (r16 == null) goto L36;
            ECAuctionAtmosphereData.a r6 = ECAuctionAtmosphereData.Companion;
            String r8 = String.valueOf(r5);
            r6.getClass();
            ECHotAtmosphere r17 = ECAuctionAtmosphereData.a.a(r16, r8);
            this.a = true;
            r17.auctionType = "count_down";
            r17.afterTextIconResId = 2131234242;
            a(r17, "count_down");
            return;
        L36:
            return;
        L39:
            return;
        L32:
            if (this.a == false) goto L38;
            this.a = false;
            this.g.setVisibility(4);
            return;
        L38:
            return;
        L10:
            if (r3 < r7) goto L18;
            if (r3 > r9) goto L18;
            if (r11 > 0) goto L16;
            r4 = new Pair(CountState.FINISHED, 0L);
            goto L21
        L16:
            r4 = new Pair(CountState.IN_PROGRESS, Long.valueOf(r11));
        L18:
            if (r3 <= r9) goto L20;
            r4 = new Pair(CountState.FINISHED, 0L);
            goto L21
        L20:
            r4 = new Pair(CountState.NOT_START, 0L);
            goto L21
        L35:
            return;
        L5:
            r1 = null;
            goto L6
        }

        public final void c(ECAuctionDigitalAtmosphere r6) {
            String r0 = r6.getFrequencyKey();
            Long r1 = Long.valueOf(r6.getFrequencyCount());
            int r2 = d.a;
            if (d.a(this.e, this.f, r0, r1, false) == false) goto L11;
            ECAuctionAtmosphereData r7 = r6.getData();
            if (r7 == null) goto L14;
            ECAuctionAtmosphereData.Companion.getClass();
            ECHotAtmosphere r8 = ECAuctionAtmosphereData.a.a(r7, null);
            r8.auctionType = "digital";
            a(r8, "digital");
            this.c = true;
            this.a = false;
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
        L14:
            return;
        L11:
            if (this.a == true) goto L16;
            this.g.setVisibility(4);
            return;
        }

        public final void a(ECHotAtmosphere r6, String r7) {
            if (this.g.getVisibility() != 4) goto L5;
            AuctionHotAtmosphereView r0 = this.g;
            r0.setAlpha(0.0f);
            r0.setVisibility(0);
            r0.animate().cancel();
            ViewPropertyAnimator r1 = r0.animate().alpha(1.0f);
            r1.setDuration(160);
            r1.start();
        L5:
            this.g.i(r6, true, false);
            v r8 = new v("livesdk_show_auction_hot_sale", this.h);
            jf.b.e r2 = jf.b.e.b;
            r8.c("ecom_entrance_form", "live_auction_card");
            r8.c("atmosphere_type", r7);
            r8.i("c2627.d4434");
        }

        public AtmosphereHelper(String r2, String r3, AuctionHotAtmosphereView r4, com.bytedance.android.ec.common.api.jump.model.a r5) {
            Intrinsics.checkNotNullParameter(r4, "atmosphereView");
            Intrinsics.checkNotNullParameter(r5, "absParam");
            this.e = r2;
            this.f = r3;
            this.g = r4;
            this.h = r5;
        }
    }

    public static final class a {
    }

    static {
    }

    public KMPAuctionHeaderV2ViewManager(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "templateContext");
        super(r2);
    }

    public final void H0(Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "props");
        Object r4 = r3.get("model");
        if (r4 != null) goto L14;
    L6:
        ECAuctionAtmosphere r5 = null;
    L8:
        if (((Unit) UtilityKotlinExtentionsKt.f(r5, k1(), new KMPAuctionHeaderV2ViewManager$onUpdateProp$1(this))) != null) goto L16;
        AtmosphereHelper r6 = this.H3;
        if (r6 == null) goto L17;
        r6.g.setVisibility(4);
        Unit r7 = Unit.INSTANCE;
        return;
    L17:
        return;
    L16:
        return;
    L14:
        int r0 = m0.a;     // Catch: Exception -> L13
        Gson r1 = m0.a.a;     // Catch: Exception -> L13
        r5 = (ECAuctionAtmosphere) r1.fromJson(r1.toJson(r4), ECAuctionAtmosphere.class);     // Catch: Exception -> L13
        goto L8
    }

    public final View n1(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        AuctionHotAtmosphereView r0 = new AuctionHotAtmosphereView(r3, null);
        r0.setVisibility(0);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r0.f(true);
        return r0;
    }
}
