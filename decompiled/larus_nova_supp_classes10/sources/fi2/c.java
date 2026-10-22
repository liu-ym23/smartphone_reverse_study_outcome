package fi2;

import com.bytedance.android.livesdk.livecommerce.LiveUserDataCenterModule_ProvideJumpDispatcherFactoryFactory;
import com.bytedance.android.livesdk.livecommerce.iron.helper.PromotionJumpDispatcher;
import jf.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final a a = null;

    public static final class a {
        public b a;

        public a() {
            this.a = LiveUserDataCenterModule_ProvideJumpDispatcherFactoryFactory.proxyProvideJumpDispatcherFactory(hh2.a.a().a);
        }
    }

    public c() {
    }

    static {
        a = new a();
    }

    public static d a(bk2.d r1, jf.c r2, com.bytedance.android.livesdk.livecommerce.promotion.card.d r3) {
        Intrinsics.checkNotNullParameter(r1, "disposableScope");
        Intrinsics.checkNotNullParameter(r3, "promotionSimpleSku");
        b r0 = a.a;
        if (r0 == null) goto L7;
        PromotionJumpDispatcher r4 = r0.a(r1, r2, r3);
        if (r4 == null) goto L7;
        return r4;
    L7:
        return jf.a.b;
    }

    public static /* synthetic */ d b(bk2.d r2, jf.c r3, int r4) {
        com.bytedance.android.livesdk.livecommerce.promotion.card.a r1 = null;
        if ((r4 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r1 = com.bytedance.android.livesdk.livecommerce.promotion.card.a.a;
    L9:
        return a(r2, r3, r1);
    }
}
