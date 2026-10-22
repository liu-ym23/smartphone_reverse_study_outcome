package com.bytedance.android.shopping.buynow.cache;

import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.buynow.starter.d;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.sku.common.data.e;
import com.bytedance.android.shopping.utils.s;
import com.bytedance.kmp.ec.yata.common.protocol.data.f;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import ma3.l;
import ma3.r;
import na3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class UltimateBuyCacheQueryHelper {
    public Pair<r, ? extends Map<String, String>> a;
    public com.bytedance.android.shopping.buynow.cache.a b;
    public Disposable c;
    public d d;
    public volatile long e;
    public volatile boolean f;
    public volatile boolean g;
    public final String h;

    public static final class a implements Observer<SsResponse<String>> {
        public final /* synthetic */ UltimateBuyCacheQueryHelper a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Function1 c;

        public final void onComplete() {
        }

        public final void onError(Throwable r14) {
            Intrinsics.checkNotNullParameter(r14, "e");
            if (this.b != this.a.e) goto L6;
            Function1 r0 = this.c;
            String r3 = this.a.h;
            ma3.b r5 = new ma3.b(null, 6);
            r5.d(1);
            Unit r1 = Unit.INSTANCE;
            r0.invoke(new d(r3, null, r5, false, r14, s.a(r14), 0, false, false, 384));
            return;
        }

        public final void onNext(Object r15) {
            final SsResponse r16 = (SsResponse) r15;
            Intrinsics.checkNotNullParameter(r16, "retrofitResponse");
            if (this.b != this.a.e) goto L11;
            long r0 = System.currentTimeMillis();
            final ma3.b r6 = (ma3.b) GsonProtectorUtils.fromJson(u0.c(), (String) r16.body(), ma3.b.class);
            if (f.d(r6) == false) goto L7;
            ra3.b.a("/order/component/confirmOrder/", r16, r0);
            final String r1 = l.a(r16);
            final int r2 = ((String) r16.body()).length();
            d r3 = new d(this.a.h, r1, r6, false, null, null, r2, false, false, 400);
            this.c.invoke(r3);
            this.a.d = r3;
            b2.b(new UltimateBuyCacheQueryHelper$query$2$onNext$1(this, r16, r1, r2));
            return;
        L7:
            d r17 = this.a.d;
            if (r17 == null) goto L13;
            this.c.invoke(r17);
            Lazy r18 = BuyNowLog.a;
            BuyNowLog.b("UltimateBuyCacheQueryHelper", new UltimateBuyCacheQueryHelper$query$2$onNext$$inlined$also$lambda$1(this, r6));
            return;
        L13:
            return;
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
            this.a.c = r2;
        }

        public a(UltimateBuyCacheQueryHelper r1, long r2, Function1 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }
    }

    public final void a() {
        this.g = false;
        Lazy r0 = BuyNowLog.a;
        BuyNowLog.b("UltimateBuyCacheQueryHelper", UltimateBuyCacheQueryHelper$blockQuery$1.INSTANCE);
        Disposable r1 = this.c;
        if (r1 == null) goto L6;
        r1.dispose();
        return;
    }

    public UltimateBuyCacheQueryHelper(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        this.h = r2;
        this.g = true;
    }

    public final void query(boolean r23, e r24, int r25, Function1<? super d, Unit> r26) {
        Intrinsics.checkNotNullParameter(r24, "nextData");
        Intrinsics.checkNotNullParameter(r26, "responseCallback");
        if (this.g == true) goto L6;
        Lazy r1 = BuyNowLog.a;
        BuyNowLog.b("UltimateBuyCacheQueryHelper", AnonymousClass1.INSTANCE);
        return;
    L6:
        Pair<r, ? extends Map<String, String>> r3 = this.a;
        if (r3 == null) goto L9;
        r r6 = (r) r3.getFirst();
    L10:
        Pair<r, ? extends Map<String, String>> r4 = this.a;
        if (r4 == null) goto L13;
        Map r5 = (Map) r4.getSecond();
    L14:
        if (r6 == null) goto L85;
        if (r5 == null) goto L86;
        this.f = true;
        Integer r7 = r6.c();
        String r10 = "1";
        if (r7 != null) goto L21;
    L61:
        r5.put("disable_server_specs_default_select", "true");
        String r8 = r24.a;
        if (r8 == null) goto L67;
        final String r9 = k.x(StringsKt.split$default(r8, new String[]{"_"}, false, 0, 6, null));
        if (r9 != null) goto L66;
        r9 = "";
    L66:
        r5.put("default_spec_id", r9);
        Lazy r11 = BuyNowLog.a;
        BuyNowLog.b("UltimateBuyCacheQueryHelper", new UltimateBuyCacheQueryHelper$replaceFields$4$1(r9));
    L67:
        Integer r12 = r24.b;
        if (r12 == null) goto L70;
        r5.put("default_count", String.valueOf(r12.intValue()));
    L70:
        Boolean r2 = r24.c;
        if (r2 != null) goto L73;
    L77:
        ma3.e r13 = r6.a();
        if (r13 == null) goto L80;
        r13.a(k.x(r5));
    L80:
        int r14 = com.bytedance.android.shopping.buynow.utils.e.a();
        int r15 = com.bytedance.android.shopping.buynow.utils.e.b(r23);
        Disposable r16 = this.c;
        if (r16 == null) goto L83;
        r16.dispose();
    L83:
        this.e++;
        long r17 = this.e;
        g r18 = g.a;
        g.d(r6, r14, r15, Integer.valueOf(r25), false, null, 48).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r17, r26));
        return;
    L73:
        if (r2.booleanValue() == true) goto L76;
        r10 = "2";
    L76:
        r5.put("spec_mode", r10);
        r5.put("spec_mode_time", String.valueOf(System.currentTimeMillis() / ((long) 1000)));
        goto L77
    L21:
        if (r7.intValue() != 0) goto L61;
        Map<String, Object> r19 = r6.b();
        if (r19 == null) goto L25;
        Object r20 = r19.get("sku_schema_param");
    L27:
        if (TypeIntrinsics.isMutableMap(r20) == true) goto L29;
        r20 = null;
    L29:
        Map r21 = (Map) r20;
        if (r21 == null) goto L32;
        Object r22 = r21.get("client_params");
    L34:
        if (TypeIntrinsics.isMutableMap(r22) == true) goto L36;
        Object r110 = null;
    L37:
        Map r27 = (Map) r110;
        if (r27 == null) goto L40;
        r27.put("disable_server_specs_default_select", Boolean.TRUE);
    L40:
        String r28 = r24.a;
        if (r28 == null) goto L46;
        final List r29 = StringsKt.split$default(r28, new String[]{"_"}, false, 0, 6, null);
        if (r27 == null) goto L45;
        r27.put("default_spec_id", r29);
    L45:
        Lazy r30 = BuyNowLog.a;
        BuyNowLog.b("UltimateBuyCacheQueryHelper", new UltimateBuyCacheQueryHelper$replaceFields$1$1(r29));
    L46:
        Integer r31 = r24.b;
        if (r31 == null) goto L51;
        int r32 = r31.intValue();
        if (r27 == null) goto L51;
        r27.put("default_count", Integer.valueOf(r32));
    L51:
        Boolean r33 = r24.c;
        if (r33 == null) goto L59;
        boolean r34 = r33.booleanValue();
        if (r27 == null) goto L59;
        if (r34 == true) goto L58;
        r10 = "2";
    L58:
        r27.put("spec_mode", r10);
    L59:
        if (r27 == null) goto L80;
        r27.put("spec_mode_time", String.valueOf(System.currentTimeMillis() / ((long) 1000)));
        goto L80
    L36:
        r110 = r22;
        goto L37
    L32:
        r22 = null;
        goto L34
    L25:
        r20 = null;
        goto L27
    L86:
        return;
    L85:
        return;
    L13:
        r5 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    }
}
