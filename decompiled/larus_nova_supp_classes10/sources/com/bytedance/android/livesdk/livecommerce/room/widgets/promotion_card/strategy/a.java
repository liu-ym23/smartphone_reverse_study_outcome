package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import si2.e0;
import si2.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface a {
    public static final C0117a a = null;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a$a, reason: collision with other inner class name */
    public static final class C0117a {
        public static final /* synthetic */ C0117a a = null;

        public C0117a() {
        }

        static {
            a = new C0117a();
        }
    }

    public static final class b {
        public static void a(boolean r3) {
            dm.a.a("ExplainCardShowStrategy").i("Received dialog hover hide event, isFromHalf = " + r3);
        }

        public static void b(boolean r3) {
            dm.a.a("ExplainCardShowStrategy").i("Received dialog hover show event, isHalf = " + r3);
        }
    }

    static {
        a = C0117a.a;
    }

    void a(boolean r1);

    void b(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b r1, boolean r2, Function1<? super ECUIPromotion, Unit> r3);

    void d(ECUIPromotion r1);

    void e(boolean r1);

    void g(String r1, ECHotAtmosphere r2);

    void h();

    void j(ECUIPromotion r1);

    void k(boolean r1);

    void l(f0 r1, boolean r2, boolean r3, Function1<? super ECUIPromotion, Unit> r4);

    void m(ECLiveCardPanelType r1);

    void n(e0 r1, boolean r2, boolean r3, Function2<? super ECUIPromotion, ? super Integer, Unit> r4);

    void o();

    void p(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b r1, boolean r2);
}
