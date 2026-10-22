package com.bytedance.android.shopping.buynow.cache;

import android.os.SystemClock;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.sku.UltimateBuyCacheConfig;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.sku.common.controller.SkuCommonBigPicCacheController;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.protocol.data.c;
import com.bytedance.kmp.ec.yata.common.protocol.data.f;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.protocol.utils.d;
import com.bytedance.kmp.ec.yata.event.common.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import ma3.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class UltimateBuyCacheHelper {
    public static final long a = 0;
    public static final Map<String, UltimateBuyCacheQueryHelper> b = null;

    public UltimateBuyCacheHelper() {
    }

    static {
        UltimateBuyCacheConfig r0 = UltimateBuyQueryResponseCache.a;
        a = UltimateBuyQueryResponseCache.a.getExpireTime() * ((long) 1000);
        b = new LinkedHashMap();
    }

    public static boolean a(a r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        q r1 = UltimateBuyQueryResponseCache.a(r2);
        if (r1 != null) goto L8;
        return false;
    L8:
        return b(r2, r1);
    }

    public static q c(a r8) {
        Object r1 = null;
        if ((r8 instanceof a) == true) goto L5;
        return null;
    L5:
        String r0 = r8.b;
        if (r0 != null) goto L8;
    L11:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L16;
        Lazy r3 = BuyNowLog.a;
        BuyNowLog.d("UltimateBuyQueryCacheHelper", "缓存key不合法:key:" + r8);
        return null;
    L16:
        q r4 = UltimateBuyQueryResponseCache.a(r8);
        if (r4 == null) goto L64;
        Lazy r5 = BuyNowLog.a;
        BuyNowLog.d("UltimateBuyQueryCacheHelper", "命中缓存:key:" + r8);
        if (b(r8, r4) == false) goto L64;
        SkuCommonBigPicCacheController.a r6 = SkuCommonBigPicCacheController.a;
        String r9 = r8.b;
        if (r9 != null) goto L23;
        r9 = "";
    L23:
        com.bytedance.android.shopping.sku.common.controller.b r10 = SkuCommonBigPicCacheController.a(r9);
        if (r10 == null) goto L26;
        long r7 = r10.b;
    L27:
        if (r10 != null) goto L29;
    L62:
        BuyNowLog.d("UltimateBuyQueryCacheHelper", "缓存数据 logId:" + r4.b);
        return r4;
    L29:
        if ((System.currentTimeMillis() - r7) >= 1800000) goto L62;
        if (r10.a == false) goto L33;
        Object r11 = "big_pic";
    L34:
        c r12 = r4.a.i();
        if (r12 == null) goto L43;
        Map r13 = r12.getData();
        if (r13 == null) goto L43;
        p r14 = (p) r13.get("specs_1");
        if (r14 == null) goto L43;
        Map r15 = r14.h();
        if (r15 == null) goto L43;
        Object r16 = r15.get("specs_state");
    L45:
        if ((r16 instanceof Map) == true) goto L47;
        r16 = null;
    L47:
        Map r17 = (Map) r16;
        if (r17 == null) goto L50;
        Object r18 = r17.get("0");
    L52:
        if (TypeIntrinsics.isMutableMap(r18) == true) goto L54;
        r18 = null;
    L54:
        Map r19 = (Map) r18;
        if (r19 == null) goto L58;
        r1 = r19.get("cur_show_mode");
    L58:
        if (Intrinsics.areEqual(r1, "small_pic") == false) goto L60;
    L61:
        r19.put("cur_show_mode", r11);
        goto L62
    L60:
        if (Intrinsics.areEqual(r1, "big_pic") == false) goto L62;
    L50:
        r18 = null;
    L43:
        r16 = null;
        goto L45
    L33:
        r11 = "small_pic";
        goto L34
    L26:
        r7 = 0;
    L64:
        return null;
    L8:
        if (r0.length() == 0) goto L11;
        r2 = false;
        goto L13
    }

    public static boolean b(a r7, final q r8) {
        if ((SystemClock.elapsedRealtime() - r8.c) <= a) goto L6;
        Lazy r9 = BuyNowLog.a;
        BuyNowLog.b("UltimateBuyQueryCacheHelper", new UltimateBuyCacheHelper$checkValid$1(r8));
        return false;
    L6:
        List r10 = UltimateBuyQueryResponseCache.a.getSceneTypeBlackList();
        if (r10 != null) goto L9;
    L12:
        return true;
    L9:
        if (CollectionsKt.contains(r10, r7.c) != true) goto L12;
        BuyNowLog.d("UltimateBuyQueryCacheHelper", "sceneTypeBlackList, so not get");
        return false;
    }

    public static UltimateBuyCacheQueryHelper d(IOrderSchema r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "orderSchema");
        if (r2 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return null;
    L11:
        if (r1.C() == false) goto L20;
        Map<String, UltimateBuyCacheQueryHelper> r3 = b;
        UltimateBuyCacheQueryHelper r4 = (UltimateBuyCacheQueryHelper) ((LinkedHashMap) r3).get(r2);
        if (r4 == null) goto L16;
        return r4;
    L16:
        UltimateBuyCacheQueryHelper r5 = new UltimateBuyCacheQueryHelper(r2);
        r3.put(r2, r5);
        return r5;
    L20:
        return null;
    L5:
        if (r2.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public static boolean e(AndroidYaTaInstance r2, e r3) {
        if (r3 == null) goto L11;
        Map r4 = r3.q();
        if (r4 == null) goto L11;
        Object r5 = r4.get("is_client_cache");
        if (r5 == null) goto L11;
        String r6 = r5.toString();
        if (r6 == null) goto L11;
        Boolean r7 = Boolean.valueOf(k.n(r6, false));
    L18:
        if (r7 != null) goto L20;
        return false;
    L20:
        return r7.booleanValue();
    L11:
        if (r2 == null) goto L17;
        Object r8 = r2.i("is_client_cache");
        if (r8 == null) goto L17;
        String r9 = r8.toString();
        if (r9 == null) goto L17;
        r7 = Boolean.valueOf(k.n(r9, false));
    L17:
        r7 = null;
        goto L18
    }

    public static boolean f(nl.b r7, q r8, boolean r9, boolean r10, int r11) {
        boolean r1 = false;
        if ((r11 & 4) == 0) goto L6;
        r9 = false;
    L6:
        if ((r11 & 8) == 0) goto L8;
        r10 = false;
    L8:
        Intrinsics.checkNotNullParameter(r8, "ultimateBuyNowCacheResponse");
        if (r7 != null) goto L11;
        return false;
    L11:
        if ((r7 instanceof a) == false) goto L112;
        a r12 = (a) r7;
        String r0 = r12.b;
        if (r0 != null) goto L15;
    L18:
        boolean r2 = true;
    L19:
        if (r2 == false) goto L22;
        return false;
    L22:
        if (f.d(r8.a) == true) goto L24;
        BuyNowLog.d("UltimateBuyQueryCacheHelper", "is not success ,so not put");
        return false;
    L24:
        List r3 = UltimateBuyQueryResponseCache.a.getSceneTypeBlackList();
        if (r3 == null) goto L30;
        if (CollectionsKt.contains(r3, r12.c) != true) goto L30;
        BuyNowLog.d("UltimateBuyQueryCacheHelper", "sceneTypeBlackList, so not put");
        return false;
    L30:
        if (BuyNowPerformanceOpt.d() == true) goto L33;
        if (r9 == true) goto L33;
        Lazy r13 = BuyNowLog.a;
        BuyNowLog.d("UltimateBuyQueryCacheHelper", "enableUltimateBuyResponseCache:" + BuyNowPerformanceOpt.d() + ",so return");
        return false;
    L33:
        ma3.b r14 = r8.a;
        String r4 = null;
        if (r14 == null) goto L40;
        c r15 = r14.i();
        if (r15 == null) goto L40;
        Map r16 = r15.g();
        if (r16 == null) goto L40;
        Object r17 = r16.get("tracker_common_params");
    L42:
        if (TypeIntrinsics.isMutableMap(r17) == true) goto L44;
        r17 = null;
    L44:
        Map r18 = (Map) r17;
        if (r18 != null) goto L48;
        r18 = new LinkedHashMap();
    L48:
        if (mq.b.c(r18, "all_forbidden", false) == true) goto L117;
        c r19 = r8.a.i();
        if (r19 == null) goto L54;
        r8.a.j(new d(r19, new UltimateBuyCacheHelper$cropProtocolV2$newYataData$1()).a());
    L54:
        UltimateBuyCacheHelper$putCache$1 r20 = UltimateBuyCacheHelper$putCache$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r20, "timeValidChecker");
        Iterator r5 = ((ArrayList) UltimateBuyQueryResponseCache.b.h()).iterator();
    L56:
        if (r5.hasNext() == false) goto L62;
        Pair r6 = (Pair) r5.next();
        q r21 = (q) r6.getSecond();
        if (r21 == null) goto L56;
        if (((Boolean) r20.invoke(Long.valueOf(r21.c))).booleanValue() == true) goto L56;
        UltimateBuyQueryResponseCache.b.i(r6.getFirst());
        goto L56
    L62:
        if (r10 == false) goto L102;
        c r22 = r8.a.i();
        if (r22 == null) goto L70;
        Map r23 = r22.getData();
        if (r23 == null) goto L70;
        p r24 = (p) r23.get("specs_1");
        if (r24 == null) goto L70;
        Map r25 = r24.h();
    L71:
        if (r25 == null) goto L73;
        Object r26 = r25.get("specs_state");
    L75:
        if ((r26 instanceof Map) == true) goto L77;
        r26 = null;
    L77:
        Map r27 = (Map) r26;
        if (r27 == null) goto L80;
        Object r28 = r27.get("0");
    L82:
        if ((r28 instanceof Map) == true) goto L84;
        r28 = null;
    L84:
        Map r29 = (Map) r28;
        if (r29 == null) goto L101;
        Object r30 = r29.get("selected_spec_item_id");
        if (r30 == null) goto L101;
        if ((r30 instanceof String) == true) goto L91;
    L96:
        if (r1 == true) goto L99;
        r30 = null;
    L99:
        if (r30 == null) goto L101;
        r4 = r30.toString();
        goto L101
    L91:
        if (((CharSequence) r30).length() <= 0) goto L93;
        boolean r31 = true;
    L94:
        if (r31 == false) goto L96;
        r1 = true;
        goto L96
    L93:
        r31 = false;
    L101:
        r7 = new a(r12.a, r12.b, r12.c, r4);
        goto L102
    L80:
        r28 = null;
        goto L82
    L73:
        r26 = null;
    L70:
        r25 = null;
    L102:
        UltimateBuyCacheConfig r32 = UltimateBuyQueryResponseCache.a;
        final a r33 = (a) r7;
        Intrinsics.checkNotNullParameter(r33, "key");
        Lazy r34 = BuyNowLog.a;
        BuyNowLog.b("UltimateBuyQueryResponseCache", new UltimateBuyQueryResponseCache$putCache$1(r33));
        UltimateBuyQueryResponseCache.b.g(r33, r8);
        return true;
    L117:
        return false;
    L40:
        r17 = null;
        goto L42
    L15:
        if (r0.length() == 0) goto L18;
        r2 = false;
        goto L19
    L112:
        return false;
    }
}
