package com.bytedance.android.shopping.card_list.router;

import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.shopping.card_list.container.init.LauncherBizType;
import com.bytedance.android.shopping.card_list.monitor.CardListYataMonitorManager;
import com.bytedance.android.shopping.card_list.monitor.cache.CacheMonitor;
import com.bytedance.android.shopping.card_list.monitor.error.CardListErrorMonitorType;
import com.bytedance.android.shopping.card_list.monitor.firstScreen.CardListFirstScreenPoint;
import com.bytedance.android.shopping.card_list.monitor.firstScreen.CardListYataFirstScreenDurationMonitor;
import com.bytedance.android.shopping.card_list.monitor.fps.CardListYataFpsMonitor;
import com.bytedance.android.shopping.card_list.monitor.success_rate.CardListSuccessRateMonitor;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.utils.CardListExtentionsKt;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.services.apm.api.EnsureManager;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class CardListKitStarter {
    public static final /* synthetic */ int i = 0;
    public String a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public String e;
    public CardListYataMonitorManager f;
    public final String g;
    public final Map<String, Object> h;

    public static final class a {
        @JvmStatic
        public static CardListKitStarter a(String r2, Map r3) {
            Intrinsics.checkNotNullParameter(r2, "sessionId");
            Intrinsics.checkNotNullParameter(r3, "pageConfig");
            Object r0 = r3.get("biz_type");
            if (Intrinsics.areEqual(r0, Integer.valueOf(LauncherBizType.CART.ordinal())) == false) goto L6;
            return new e(r2, r3);
        L6:
            if (Intrinsics.areEqual(r0, Integer.valueOf(LauncherBizType.COLLECT.ordinal())) == false) goto L9;
            return new f(r2, r3);
        L9:
            return new CardListKitStarter(r2, r3);
        }
    }

    static {
    }

    public CardPassThroughData b(HashMap<String, String> r12) {
        Intrinsics.checkNotNullParameter(r12, "schemaMap");
        String r0 = r12.get("ecom_scene_id");
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r4 = this.g;
        String r6 = this.e;
        return new CardPassThroughData(null, null, r4, r12, r6, r0, null, 67, null);
    }

    public CardListKitStarter(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r3, "pageConfig");
        this.g = r2;
        this.h = r3;
        this.b = LazyKt.lazy(new CardListKitStarter$useDialogFragmentOpen$2(this));
        this.c = LazyKt.lazy(new CardListKitStarter$queryDataInStarter$2(this));
        this.d = LazyKt.lazy(new CardListKitStarter$cardLauncher$2(this));
    }

    public final void c(String r10, String r11) {
        JSONObject r0 = new JSONObject();
        r0.put(PdpOpenThirdParam.KEY_PAGE_NAME, CardListExtentionsKt.f(this.h, PdpOpenThirdParam.KEY_PAGE_NAME, ""));
        r0.put("session_id", this.g);
        r0.put("previous_page", r10);
        r0.put("biz_type", CardListExtentionsKt.d(this.h, "biz_type", 0));
        r0.put("page_type", r11);
        Map<String, CardListYataMonitorManager> r12 = CardListYataMonitorManager.k;
        Intrinsics.checkNotNullParameter(r0, "config");
        CardListYataMonitorManager r13 = new CardListYataMonitorManager(r0);
        String r5 = UUID.randomUUID().toString();
        CardListYataMonitorManager.k.put(r5, r13);
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        JSONObject r6 = new JSONObject();
        r6.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r6.put("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        r6.put(PdpOpenThirdParam.KEY_PAGE_NAME, (String) r13.a.getValue());
        r6.put("previous_page", (String) r13.b.getValue());
        r6.put("session_id", (String) r13.c.getValue());
        r6.put("biz_type", r0.optInt("biz_type"));
        r6.put("page_type", r0.optString("page_type"));
        CardListYataFirstScreenDurationMonitor r14 = new CardListYataFirstScreenDurationMonitor(r5, x0.a(r6));
        r13.d = r14;
        CardListYataFirstScreenDurationMonitor.b(r14, CardListFirstScreenPoint.START);
        Map<String, com.bytedance.android.shopping.card_list.monitor.error.a> r15 = com.bytedance.android.shopping.card_list.monitor.error.a.b;
        JSONObject r16 = x0.a(r6);
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r16, "baseParams");
        com.bytedance.android.shopping.card_list.monitor.error.a r2 = new com.bytedance.android.shopping.card_list.monitor.error.a(r16);
        com.bytedance.android.shopping.card_list.monitor.error.a.b.put(r5, r2);
        r13.e = r2;
        r13.f = new CardListYataFpsMonitor(r5, x0.a(r6));
        Map<String, CardListSuccessRateMonitor> r17 = CardListSuccessRateMonitor.g;
        JSONObject r18 = x0.a(r6);
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r18, "baseParams");
        CardListSuccessRateMonitor r3 = new CardListSuccessRateMonitor(r18);
        CardListSuccessRateMonitor.g.put(r5, r3);
        r13.g = r3;
        r13.h = new com.bytedance.kmp.ec.yata.common.perf.d("biz_first_enter");
        Map<String, CacheMonitor> r19 = CacheMonitor.d;
        JSONObject r110 = x0.a(r6);
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r110, "baseParams");
        CacheMonitor r1 = new CacheMonitor(r110);
        CacheMonitor.d.put(r5, r1);
        r13.i = r1;
        this.e = r5;
        this.f = CardListYataMonitorManager.a.a(r5);
        if (((Boolean) this.c.getValue()).booleanValue() == false) goto L9;
        CardListYataMonitorManager r111 = this.f;
        if (r111 == null) goto L9;
        CardListYataFirstScreenDurationMonitor r112 = r111.d;
        if (r112 == null) goto L9;
        CardListYataFirstScreenDurationMonitor.b(r112, CardListFirstScreenPoint.REQUEST_START);
    L9:
        CardListYataMonitorManager r113 = this.f;
        if (r113 == null) goto L19;
        CardListSuccessRateMonitor r114 = r113.g;
        if (r114 != null) goto L14;
        return;
    L14:
        if (((LauncherBizType) r114.e.getValue()) != LauncherBizType.COLLECT) goto L16;
        MonitorScenes r115 = MonitorScenes.EC_PERF_PAGE_START_COLLECT;
    L17:
        Map r4 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.b(r115, null, r114.a());
        return;
    L16:
        r115 = MonitorScenes.EC_PERF_PAGE_START_CART;
        goto L17
    }

    public static final void a(CardListKitStarter r5, com.bytedance.kmp.ec.yata.common.protocol.data.e r6, Throwable r7) {
        String r0 = r5.g;
        com.bytedance.kmp.ec.yata.common.protocol.data.e r1 = new com.bytedance.kmp.ec.yata.common.protocol.data.e(null);
        boolean r3 = true;
        r1.d(1);
        Unit r4 = Unit.INSTANCE;
        s0.b(new d(r0, r1));
        String r2 = r7.getMessage();
        String r8 = "";
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        if (r2.length() == 0) goto L9;
        r3 = false;
    L9:
        if (r3 == false) goto L21;
        EnsureManager.ensureNotReachHere(r7);
        Intrinsics.checkNotNullParameter(r7, "$this$stackTraceToString");
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L13
        StringWriter r10 = new StringWriter();     // Catch: Throwable -> L13
        PrintWriter r11 = new PrintWriter(r10);     // Catch: Throwable -> L13
        r7.printStackTrace(r11);     // Catch: Throwable -> L13
        r11.flush();     // Catch: Throwable -> L13
        Object r12 = Result.constructor-impl(r10.toString());     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r12) == false) goto L18;
        r12 = null;
    L18:
        r2 = (String) r12;
        if (r2 != null) goto L21;
        r2 = "";
    L13:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L21:
        StringBuilder r14 = new StringBuilder();
        r14.append(r2);
        r14.append("; cause: ");
        Throwable r15 = r7.getCause();
        if (r15 == null) goto L24;
        String r16 = r15.getMessage();
    L25:
        r14.append(r16);
        String r17 = r14.toString();
        String r18 = com.bytedance.android.shopping.card_list.monitor.a.a;
        if (r6 == null) goto L30;
        Integer r19 = r6.a();
        if (r19 == null) goto L30;
        int r20 = r19.intValue();
    L31:
        if (r6 == null) goto L34;
        String r21 = r6.b();
        if (r21 == null) goto L34;
    L35:
        if (r21 != null) goto L37;
        r21 = "";
    L37:
        com.bytedance.android.shopping.card_list.monitor.a.a(r20, r21);
        CardListYataMonitorManager r22 = r5.f;
        if (r22 == null) goto L42;
        com.bytedance.android.shopping.card_list.monitor.error.a r23 = r22.e;
        if (r23 == null) goto L42;
        Map<String, com.bytedance.android.shopping.card_list.monitor.error.a> r24 = com.bytedance.android.shopping.card_list.monitor.error.a.b;
        r23.b(CardListErrorMonitorType.FIRST_FETCH_RESP_ERROR, "CardListKitStarter-" + r17, null);
    L42:
        CardListYataMonitorManager r25 = r5.f;
        if (r25 == null) goto L54;
        CacheMonitor r26 = r25.i;
        if (r26 == null) goto L55;
        String r27 = r5.a;
        if (r27 == null) goto L50;
        r8 = r27;
    L50:
        CacheMonitor.b(r26, "error", r8);
        return;
    L55:
        return;
    L54:
        return;
    L34:
        r21 = r7.getMessage();
    L30:
        r20 = -1;
        goto L31
    L24:
        r16 = null;
        goto L25
    }
}
