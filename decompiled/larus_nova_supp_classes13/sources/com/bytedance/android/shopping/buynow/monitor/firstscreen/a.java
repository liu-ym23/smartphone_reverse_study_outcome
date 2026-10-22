package com.bytedance.android.shopping.buynow.monitor.firstscreen;

import android.net.Uri;
import com.bytedance.android.ec.model.d;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.buynow.starter.BuyNowRouter;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.data.api.ChainPoint;
import com.bytedance.android.shopping.utils.l0;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sc3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements b {
    public static a d;
    public static final C0028a e = null;
    public final HashMap<ChainPoint, Long> a;
    public boolean b;
    public final d c;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.buynow.monitor.firstscreen.a$a, reason: collision with other inner class name */
    public static final class C0028a {
        public C0028a() {
        }
    }

    static {
        e = new C0028a();
    }

    @Override // sc3.b
    public final HashMap<ChainPoint, Long> a() {
        if (this.b == true) goto L29;
        if (f() == true) goto L9;
        HashMap<ChainPoint, Long> r0 = this.a;
        ChainPoint r1 = ChainPoint.DELAY_START;
        ChainPoint r2 = ChainPoint.CREATE_SCHEMA_END;
        r0.put(r1, r0.get(r2));
        HashMap<ChainPoint, Long> r3 = this.a;
        r3.put(ChainPoint.DELAY_END, r3.get(r2));
    L9:
        if (g() == true) goto L12;
        HashMap<ChainPoint, Long> r4 = this.a;
        ChainPoint r5 = ChainPoint.SKU_CHECK_START;
        ChainPoint r6 = ChainPoint.PAGE_INIT;
        r4.put(r5, r4.get(r6));
        HashMap<ChainPoint, Long> r7 = this.a;
        r7.put(ChainPoint.SKU_CHECK_END, r7.get(r6));
    L12:
        if (e() == true) goto L14;
        HashMap<ChainPoint, Long> r8 = this.a;
        ChainPoint r9 = ChainPoint.AUTO_COUPON_START;
        ChainPoint r10 = ChainPoint.PAGE_INIT;
        r8.put(r9, r8.get(r10));
        HashMap<ChainPoint, Long> r11 = this.a;
        r11.put(ChainPoint.AUTO_COUPON_END, r11.get(r10));
    L14:
        Iterator r12 = CollectionsKt.listOf(new Pair[]{TuplesKt.to(ChainPoint.AUTO_COUPON_START, ChainPoint.AUTO_COUPON_END), TuplesKt.to(ChainPoint.SKU_CHECK_START, ChainPoint.SKU_CHECK_END), TuplesKt.to(ChainPoint.CREATE_SCHEMA_START, ChainPoint.CREATE_SCHEMA_END), TuplesKt.to(ChainPoint.DELAY_START, ChainPoint.DELAY_END)}).iterator();
    L16:
        if (r12.hasNext() == false) goto L29;
        Pair r13 = (Pair) r12.next();
        Long r14 = this.a.get(r13.getSecond());
        Long r15 = this.a.get(r13.getFirst());
        if (r14 == null) goto L16;
        if (r15 == null) goto L16;
        Long r16 = this.a.get(r13.getSecond());
        if (r16 != null) goto L24;
        r16 = 0L;
    L24:
        long r17 = r16.longValue();
        Long r18 = this.a.get(r13.getFirst());
        if (r18 != null) goto L27;
        r18 = 0L;
    L27:
        long r19 = r17 - r18.longValue();
        Lazy r20 = BuyNowLog.a;
        BuyNowLog.a("BuyNowChainMonitor", "【" + ((ChainPoint) r13.getSecond()) + "】-【" + ((ChainPoint) r13.getFirst()) + "】: " + r19);
    L29:
        return this.a;
    }

    public final boolean e() {
        Long r0 = this.a.get(ChainPoint.AUTO_COUPON_END);
        Long r1 = this.a.get(ChainPoint.AUTO_COUPON_START);
        if (r0 == null) goto L6;
        if (r1 == null) goto L6;
        return true;
    L6:
        return false;
    }

    public final boolean f() {
        Long r0 = this.a.get(ChainPoint.DELAY_END);
        Long r1 = this.a.get(ChainPoint.DELAY_START);
        if (r0 == null) goto L6;
        if (r1 == null) goto L6;
        return true;
    L6:
        return false;
    }

    public final boolean g() {
        Long r0 = this.a.get(ChainPoint.SKU_CHECK_END);
        Long r1 = this.a.get(ChainPoint.SKU_CHECK_START);
        if (r0 == null) goto L6;
        if (r1 == null) goto L6;
        return true;
    L6:
        return false;
    }

    public a(d r1) {
        this.c = r1;
        this.a = new HashMap();
    }

    @Override // sc3.b
    public final String b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Lazy r0 = BuyNowLog.a;
        StringBuilder r1 = new StringBuilder("checkSchema isNative:");
        if (d == null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        BuyNowLog.a("BuyNowChainMonitor", r1.toString());
        if (f() == true) goto L10;
        HashMap<ChainPoint, Long> r3 = this.a;
        ChainPoint r4 = ChainPoint.DELAY_START;
        ChainPoint r6 = ChainPoint.CREATE_SCHEMA_END;
        r3.put(r4, r3.get(r6));
        HashMap<ChainPoint, Long> r7 = this.a;
        r7.put(ChainPoint.DELAY_END, r7.get(r6));
    L10:
        if (g() == true) goto L13;
        HashMap<ChainPoint, Long> r8 = this.a;
        ChainPoint r9 = ChainPoint.SKU_CHECK_START;
        ChainPoint r10 = ChainPoint.PAGE_INIT;
        r8.put(r9, r8.get(r10));
        HashMap<ChainPoint, Long> r11 = this.a;
        r11.put(ChainPoint.SKU_CHECK_END, r11.get(r10));
    L13:
        if (e() == true) goto L15;
        HashMap<ChainPoint, Long> r12 = this.a;
        ChainPoint r13 = ChainPoint.AUTO_COUPON_START;
        ChainPoint r14 = ChainPoint.PAGE_INIT;
        r12.put(r13, r12.get(r14));
        HashMap<ChainPoint, Long> r15 = this.a;
        r15.put(ChainPoint.AUTO_COUPON_END, r15.get(r14));
    L15:
        JSONObject r16 = new JSONObject();
        Iterator<Map.Entry<ChainPoint, Long>> r17 = this.a.entrySet().iterator();
    L17:
        if (r17.hasNext() == false) goto L19;
        Map.Entry<ChainPoint, Long> r18 = r17.next();
        ChainPoint r19 = r18.getKey();
        Long r20 = r18.getValue();
        r16.put(r19.getValue(), r20);
        goto L17
    L19:
        Uri r21 = l0.c(UriProtector.parse(r5), "buynow_time", r16.toString());
        int r22 = BuyNowRouter.a;
        Intrinsics.checkNotNullParameter(r21, "uri");
        if (Intrinsics.areEqual(r21.getHost(), "buy_now") == true) goto L23;
        d = null;
    L23:
        return r21.toString();
    L5:
        r2 = false;
        goto L6
    }

    @Override // sc3.b
    public final void d(IOrderSchema r5) {
        Intrinsics.checkNotNullParameter(r5, "orderSchema");
        Lazy r0 = BuyNowLog.a;
        StringBuilder r1 = new StringBuilder("checkSchema isNative:");
        if (d == null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        BuyNowLog.a("BuyNowChainMonitor", r1.toString());
        if (f() == true) goto L10;
        HashMap<ChainPoint, Long> r3 = this.a;
        ChainPoint r4 = ChainPoint.DELAY_START;
        ChainPoint r6 = ChainPoint.CREATE_SCHEMA_END;
        r3.put(r4, r3.get(r6));
        HashMap<ChainPoint, Long> r7 = this.a;
        r7.put(ChainPoint.DELAY_END, r7.get(r6));
    L10:
        if (g() == true) goto L13;
        HashMap<ChainPoint, Long> r8 = this.a;
        ChainPoint r9 = ChainPoint.SKU_CHECK_START;
        ChainPoint r10 = ChainPoint.PAGE_INIT;
        r8.put(r9, r8.get(r10));
        HashMap<ChainPoint, Long> r11 = this.a;
        r11.put(ChainPoint.SKU_CHECK_END, r11.get(r10));
    L13:
        if (e() == true) goto L15;
        HashMap<ChainPoint, Long> r12 = this.a;
        ChainPoint r13 = ChainPoint.AUTO_COUPON_START;
        ChainPoint r14 = ChainPoint.PAGE_INIT;
        r12.put(r13, r12.get(r14));
        HashMap<ChainPoint, Long> r15 = this.a;
        r15.put(ChainPoint.AUTO_COUPON_END, r15.get(r14));
    L15:
        JSONObject r16 = new JSONObject();
        Iterator<Map.Entry<ChainPoint, Long>> r17 = this.a.entrySet().iterator();
    L17:
        if (r17.hasNext() == false) goto L19;
        Map.Entry<ChainPoint, Long> r18 = r17.next();
        ChainPoint r19 = r18.getKey();
        Long r20 = r18.getValue();
        r16.put(r19.getValue(), r20);
        goto L17
    L19:
        String r21 = r16.toString();
        if (r21 == null) goto L23;
        r5.replaceOrAppendParam("buynow_time", r21);
    L23:
        if (r5.u() == true) goto L27;
        d = null;
        return;
    L27:
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // sc3.b
    public final void c(ChainPoint r6, Long r7) {
        Intrinsics.checkNotNullParameter(r6, "chainPoint");
        if (this.b == false) goto L6;
        return;
    L6:
        if (this.a.get(r6) == null) goto L9;
        this.b = true;
        Lazy r8 = BuyNowLog.a;
        BuyNowLog.a("BuyNowChainMonitor", "重复上报" + r6);
        return;
    L9:
        ECAppInfoService r0 = ECAppInfoService.e;
        if (r0.isDebug() == true) goto L12;
    L18:
        HashMap<ChainPoint, Long> r1 = this.a;
        if (r7 == null) goto L21;
        long r2 = r7.longValue();
    L22:
        r1.put(r6, Long.valueOf(r2));
        return;
    L21:
        r2 = System.currentTimeMillis();
        goto L22
    L12:
        if (r0.isLocalTest() == false) goto L18;
        StringBuilder r3 = new StringBuilder("add point:" + r6);
    L15:
        if (r3.length() >= 40) goto L17;
        r3.append(" ");
        goto L15
    L17:
        String r4 = String.valueOf(System.currentTimeMillis());
        String r5 = r4.substring(r4.length() - 6, r4.length());
        Lazy r9 = BuyNowLog.a;
        BuyNowLog.a("BuyNowChainMonitor", r3 + ' ' + r5);
        goto L18
    }
}
