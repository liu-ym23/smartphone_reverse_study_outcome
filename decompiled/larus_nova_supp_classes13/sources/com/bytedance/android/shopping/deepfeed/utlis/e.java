package com.bytedance.android.shopping.deepfeed.utlis;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedCouponResult;
import com.bytedance.android.shopping.deepfeed.data.api.DeepFeedProductCouponApi;
import he3.d1;
import he3.h2;
import he3.l;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public static DeepFeedProductCouponApi a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function2 a;
        public final /* synthetic */ DeepFeedProductCouponApi b;

        public a(Function2 r1, DeepFeedProductCouponApi r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Function2 r0 = this.a;
            r0.invoke((l) r3, "success");
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function2 a;
        public final /* synthetic */ DeepFeedProductCouponApi b;

        public b(Function2 r1, DeepFeedProductCouponApi r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            this.a.invoke(null, DeepFeedCouponResult.FAIL);
        }
    }

    static {
    }

    public static boolean a(d1 r4) {
        Intrinsics.checkNotNullParameter(r4, "couponInfo");
        Map<String, Object> r0 = r4.b();
        Object r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.get("is_new_architecture");
    L7:
        if ((r2 instanceof String) == true) goto L9;
        r2 = null;
    L9:
        String r3 = (String) r2;
        if (r3 == null) goto L12;
        boolean r5 = Boolean.parseBoolean(r3);
    L14:
        if (r5 == false) goto L29;
        Map<String, Object> r6 = r4.b();
        if (r6 == null) goto L18;
        Object r7 = r6.get("guess_mixed_coupon_info");
    L20:
        if ((r7 instanceof String) == false) goto L23;
        r1 = r7;
    L23:
        String r8 = (String) r1;
        if (r8 != null) goto L26;
    L27:
        return true;
    L26:
        if (r8.length() == 0) goto L27;
        return false;
    L18:
        r7 = null;
        goto L20
    L29:
        List<String> r9 = r4.a();
        if (r9 != null) goto L32;
    L35:
        boolean r10 = true;
    L36:
        if (r10 == true) goto L45;
        String r11 = r4.d();
        if (r11 != null) goto L40;
    L43:
        boolean r12 = true;
    L44:
        if (r12 == true) goto L45;
        return false;
    L40:
        if (r11.length() == 0) goto L43;
        r12 = false;
    L45:
        return true;
    L32:
        if (r9.isEmpty() == true) goto L35;
        r10 = false;
        goto L36
    L12:
        r5 = false;
        goto L14
    L5:
        r2 = null;
        goto L7
    }

    public static void b(h2 r15, String r16, boolean r17, Function2 r18) {
        Intrinsics.checkNotNullParameter(r15, "promotionInfo");
        Intrinsics.checkNotNullParameter(r18, "result");
        DeepFeedProductCouponApi r0 = a;
        Object r3 = null;
        if (r0 != null) goto L17;
        DeepFeedProductCouponApi.a.getClass();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl((DeepFeedProductCouponApi) n.a.create("https://ecom.snssdk.com", DeepFeedProductCouponApi.class, null, null));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r2) == false) goto L12;
        r2 = null;
    L12:
        r0 = (DeepFeedProductCouponApi) r2;
        if (r0 == null) goto L15;
        a = r0;
        goto L17
    L15:
        r0 = null;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
    L17:
        if (r0 != null) goto L20;
        r18.invoke(null, DeepFeedCouponResult.UN_REQUEST);
        return;
    L20:
        List<d1> r5 = r15.a();
        if (r5 == null) goto L23;
        d1 r6 = (d1) CollectionsKt.firstOrNull(r5);
    L24:
        if (r6 != null) goto L27;
        r18.invoke(null, DeepFeedCouponResult.UN_REQUEST);
        return;
    L27:
        List<d1> r7 = r15.a();
        if (r7 == null) goto L63;
        d1 r8 = (d1) CollectionsKt.firstOrNull(r7);
        if (r8 != null) goto L32;
        return;
    L32:
        if (a(r8) == false) goto L35;
        r18.invoke(null, DeepFeedCouponResult.UN_REQUEST);
        return;
    L35:
        LinkedHashMap r14 = new LinkedHashMap();
        Map<String, Object> r9 = r8.b();
        String r10 = "";
        if (r9 == null) goto L58;
        Object r11 = r9.get("apply_source");
        if ((r11 instanceof String) == true) goto L40;
        r11 = null;
    L40:
        String r12 = (String) r11;
        if (r12 != null) goto L43;
        r12 = "";
    L43:
        Object r13 = r9.get("coupon_apply_uniq_key");
        if ((r13 instanceof String) == true) goto L46;
        r13 = null;
    L46:
        String r19 = (String) r13;
        if (r19 == null) goto L50;
        r10 = r19;
    L50:
        Object r20 = r9.get("guess_mixed_coupon_info");
        if ((r20 instanceof String) == false) goto L54;
        r3 = r20;
    L54:
        String r21 = (String) r3;
        if (r21 == null) goto L57;
        String r22 = (String) r14.put("guess_mixed_coupon_info", r21);
    L57:
        String r110 = r10;
        String r23 = r12;
    L59:
        bg4.b.c(r0.loadProductCouponInfo(new he3.k(r8.a(), r8.d(), r23, 0L, r16, r110, Boolean.valueOf(r17), r14))).subscribe(new a(r18, r0), new b(r18, r0));
        return;
    L58:
        r23 = "";
        r110 = r23;
        goto L59
    L63:
        return;
    L23:
        r6 = null;
        goto L24
    }
}
