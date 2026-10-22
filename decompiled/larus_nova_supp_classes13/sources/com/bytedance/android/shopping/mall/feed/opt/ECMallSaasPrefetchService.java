package com.bytedance.android.shopping.mall.feed.opt;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.api.mall.feed.g;
import com.bytedance.android.shopping.api.mall.feed.j;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.slice.action.entity.CheckLoginParam;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallSaasPrefetchService implements g {
    public final HashMap<String, Double> a;
    public final Handler b;
    public final ConcurrentHashMap<String, SaasHomepagePrefetch> c;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Job a;

        public b(Job r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Job.DefaultImpls.cancel$default(this.a, null, 1, null);     // Catch: Throwable -> L4
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

    public ECMallSaasPrefetchService() {
        int r0 = s93.c.a;
        Object r1 = new HashMap();
        IHybridHostService r2 = com.bytedance.android.ec.hybrid.a.h();
        if (r2 == null) goto L10;
        yj.g r3 = r2.getHostAB();
        if (r3 == null) goto L10;
        Object r4 = r3.a("mall_gyl_saas_api_cache_duration", r1);
        if (r4 == null) goto L10;
        r1 = r4;
    L10:
        Lazy r5 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : mall_gyl_saas_api_cache_duration, Value: " + r1);
        this.a = (HashMap) r1;
        this.b = new Handler(Looper.getMainLooper());
        this.c = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.g
    public final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "fetchId");
        return this.c.containsKey(r2);
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.g
    public final String b(String r13, j r14) {
        Intrinsics.checkNotNullParameter(r14, "extraParams");
        if (r13 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
    L14:
        String r1 = r14.a;
    L15:
        Job r15 = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getDefault(), null, new ECMallSaasPrefetchService$startPrefetch$scope$1(this, r1, r13, r14, null), 2, null);
        this.b.postDelayed(new b(r15), 3000);
        return r1;
    L11:
        if (r14.b == false) goto L14;
        r1 = String.valueOf(System.currentTimeMillis());
        goto L15
    L5:
        if (r13.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public static final void d(ECMallSaasPrefetchService r8, Map r9, String r10) {
        r8.getClass();
        if ((!Intrinsics.areEqual(r10, "order_details_page")) == true) goto L5;
    L9:
        int r0 = r10.hashCode();
        String r3 = "";
        if (r0 == (-726165788)) goto L21;
        if (r0 == 287716940) goto L18;
        if (r0 == 600961981) goto L15;
    L23:
        String r1 = "";
    L24:
        int r7 = r10.hashCode();
        if (r7 == (-726165788)) goto L36;
        if (r7 == 287716940) goto L33;
        if (r7 == 600961981) goto L30;
    L38:
        LinkedHashMap r11 = (LinkedHashMap) r9;
        String r2 = (String) r11.get(r1);
        if (r2 == null) goto L60;
        r9.put("order_ids", r2);
    L60:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L54
        String r12 = (String) r11.get("entrance_info");     // Catch: Throwable -> L54
        Unit r5 = null;
        if (r12 == null) goto L52;
        JSONObject r6 = new JSONObject(r12);     // Catch: Throwable -> L54
        Iterator<String> r13 = r6.keys();     // Catch: Throwable -> L54
    L45:
        if (r13.hasNext() == false) goto L51;
        String r14 = r13.next();     // Catch: Throwable -> L54
        Object r15 = r6.opt(r14);     // Catch: Throwable -> L54
        if (r15 == null) goto L49;
        String r16 = r15.toString();     // Catch: Throwable -> L54
    L50:
        r9.put(r14, r16);     // Catch: Throwable -> L54
        goto L45
    L49:
        r16 = null;
        goto L50
    L51:
        r5 = Unit.INSTANCE;     // Catch: Throwable -> L54
    L52:
        Result.constructor-impl(r5);     // Catch: Throwable -> L54
    L57:
        if ((!Intrinsics.areEqual(r10, "order_logistics_page")) == false) goto L65;
        r9.put("gyl_id", r3);
        return;
    L65:
        return;
    L54:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L57
    L30:
        if (r10.equals("order_details_page") == false) goto L38;
        r3 = "order_detail_001";
        goto L38
    L33:
        if (r10.equals("order_logistics_page") == false) goto L38;
        r3 = "express_detail_na_001";
        goto L38
    L36:
        if (r10.equals("payment_success_page") == false) goto L38;
        r3 = "payment_success_001";
        goto L38
    L15:
        if (r10.equals("order_details_page") == false) goto L23;
        r1 = "id";
        goto L24
    L18:
        if (r10.equals("order_logistics_page") == false) goto L23;
        r1 = "shop_order_id";
        goto L24
    L21:
        if (r10.equals("payment_success_page") == false) goto L23;
        r1 = "order_id";
        goto L24
    L5:
        if ((!Intrinsics.areEqual(r10, "payment_success_page")) == false) goto L9;
        if ((!Intrinsics.areEqual(r10, "order_logistics_page")) == false) goto L9;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.g
    public final boolean c(String r5, Function2<? super String, Object, Unit> r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r5, "fetchId");
        Intrinsics.checkNotNullParameter(r6, "success");
        Intrinsics.checkNotNullParameter(r7, CheckLoginParam.KEY_FAILED);
        SaasHomepagePrefetch r0 = this.c.get(r5);
        boolean r1 = true;
        if (r0 == null) goto L23;
        Intrinsics.checkNotNullParameter(r6, "success");
        Intrinsics.checkNotNullParameter(r7, CheckLoginParam.KEY_FAILED);
        Object r2 = r0.b;
        monitor-enter(r2);
        Pair<String, HomePageDTO> r3 = r0.c;     // Catch: Throwable -> L20
        if (r3 == null) goto L12;
        r6.invoke(r3.getFirst(), r3.getSecond());     // Catch: Throwable -> L20
        r0.c = null;     // Catch: Throwable -> L20
        monitor-exit(r2);
    L18:
        this.c.remove(r5);
        return r1;
    L12:
        if (r0.d == false) goto L16;
        r0.e = r6;     // Catch: Throwable -> L20
        r0.f = r7;     // Catch: Throwable -> L20
        monitor-exit(r2);
        r1 = false;
        goto L18
    L16:
        r7.invoke();     // Catch: Throwable -> L20
        monitor-exit(r2);
    L20:
        th = move-exception;
        throw th;
    L23:
        r7.invoke();
        return true;
    }
}
