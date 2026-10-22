package com.bytedance.android.livesdk.livecommerce.intro.event;

import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class IntroCardEventCenter {
    public final com.bytedance.android.livesdk.livecommerce.intro.event.a a;
    public final com.bytedance.android.livesdk.livecommerce.promotion.card.e b;
    public final il.a c;
    public final Function1<ql.a, com.bytedance.android.ec.common.api.jump.model.g> d;

    public static final class a implements Runnable {
        public final /* synthetic */ IntroCardEventCenter a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ String d;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.intro.event.IntroCardEventCenter$a$a, reason: collision with other inner class name */
        public static final class RunnableC0063a implements Runnable {
            public final /* synthetic */ IntroPromotionVO a;
            public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
            public final /* synthetic */ a c;

            public RunnableC0063a(IntroPromotionVO r1, com.bytedance.android.ec.common.api.jump.model.g r2, a r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void a() {
                a r0 = this.c;
                IntroCardEventCenter r1 = r0.a;
                String r2 = r0.b;
                com.bytedance.android.ec.common.api.jump.model.b r3 = this.b;
                if (r3 != null) goto L5;
                r3 = com.bytedance.android.ec.common.api.jump.model.b.a;
            L5:
                v r4 = new v(r2, r3);
                IntroPromotionVO r5 = this.a;
                if (r5 == null) goto L8;
                String r6 = r5.getProductId();
            L9:
                r4.c("product_id", r6);
                IntroPromotionVO r7 = this.a;
                r4.d(r7.getEventParams());
                r4.c("product_id", r7.getProductId());
                if (r7.isOnExplaining() == false) goto L12;
                String r8 = "1";
            L13:
                r4.c("is_explaining", r8);
                int r9 = 1;
                r4.a("with_sku", !r7.getSingleSku() ? 1 : 0);
                r4.a("local_num", r7.getLocalNum());
                ECUIAskExplainInfo r10 = r7.getAskExplainInfo();
                if (r10 != null) goto L16;
            L18:
                r9 = 0;
            L19:
                r4.a("is_explain_apply", r9);
                Unit r11 = Unit.INSTANCE;
                r4.d(this.c.c);
                r1.d(r4, this.c.d);
                return;
            L16:
                if (r10.isAsked() != true) goto L18;
            L12:
                r8 = BDLocationException.ERROR_TIMEOUT;
                goto L13
            L8:
                r6 = null;
                goto L9
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

        public a(IntroCardEventCenter r1, String r2, Map r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.ec.common.api.jump.model.g r0 = IntroCardEventCenter.c(this.a);     // Catch: Throwable -> L11
            if (r0 == null) goto L14;
            ql.a r1 = r0.a;     // Catch: Throwable -> L11
            if ((r1 instanceof IntroPromotionVO) == true) goto L7;
            r1 = null;
        L7:
            IntroPromotionVO r2 = (IntroPromotionVO) r1;     // Catch: Throwable -> L11
            if (r2 == null) goto L18;
            oh.a.c(this.b, new RunnableC0063a(r2, r0, this));     // Catch: Throwable -> L11
            return;
        L18:
            return;
        L14:
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Runnable a;

        public b(Runnable r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static void b(Runnable r2) {
        UtilityKotlinExtentionsKt.b.post(new b(r2));
    }

    public static com.bytedance.android.ec.common.api.jump.model.g c(IntroCardEventCenter r1) {
        return (com.bytedance.android.ec.common.api.jump.model.g) r1.d.invoke(null);
    }

    public final void d(final v r8, String r9) {
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        com.bytedance.android.livesdk.livecommerce.promotion.card.e r1 = this.b;
        if (r1 == null) goto L11;
        String r2 = r8.d;
        Map<String, String> r3 = r8.g();
        com.bytedance.android.ec.common.api.jump.model.g r4 = r8.e.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.g.class));
        if (r4 == null) goto L7;
        ql.a r5 = r4.a;
    L8:
        boolean r6 = r1.a(r2, r3, r9, r5, new IntroCardEventCenter$saveByIntercept$1(r8, r0));
        boolean r7 = true;
        if (r6 != true) goto L11;
    L12:
        r0.element = r7;
        if (r7 == false) goto L15;
        return;
    L15:
        r8.i(r9);
        return;
    L7:
        r5 = null;
    L11:
        r7 = false;
        goto L12
    }

    public final void a(String r2, Map<String, String> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        b(new a(this, r2, r3, r4));
    }

    public IntroCardEventCenter(com.bytedance.android.livesdk.livecommerce.intro.event.a r2, com.bytedance.android.livesdk.livecommerce.promotion.card.e r3, il.a r4, Function1<? super ql.a, com.bytedance.android.ec.common.api.jump.model.g> r5) {
        Intrinsics.checkNotNullParameter(r4, "eventMap");
        Intrinsics.checkNotNullParameter(r5, "getPromotionParams");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
