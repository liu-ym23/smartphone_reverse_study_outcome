package com.bytedance.android.shopping.orderlist.common.freq.func;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.orderlist.common.freq.ConsumeResult;
import com.bytedance.android.shopping.orderlist.common.freq.FreqStorage;
import com.bytedance.android.shopping.orderlist.common.freq.FreqStrategy;
import com.bytedance.android.shopping.orderlist.common.freq.JudgeStrategyResult;
import com.bytedance.android.shopping.orderlist.common.freq.OrderFreqControlManager;
import com.bytedance.android.shopping.orderlist.common.freq.SingleFreqCache;
import com.bytedance.android.shopping.orderlist.common.freq.TransferParams;
import com.bytedance.android.shopping.orderlist.common.freq.c;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.kmp.ec.yata.event.common.b {
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a a;

    public static final class a {
    }

    static {
    }

    public b(com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(final com.bytedance.kmp.ec.yata.event.core.a r22) {
        Intrinsics.checkNotNullParameter(r22, "input");
        Lazy r2 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSelfJudgeFreqFunction", OrderSelfJudgeFreqFunction$onExecuteSync$1.INSTANCE);
        final Map r3 = r22.q();
        if (r3 == null) goto L5;
        final boolean r4 = mq.b.c(r3, "skip_app_frequency", false);
    L6:
        OrderCommonLog.c("iesec_orderlist_freq", new OrderSelfJudgeFreqFunction$onExecuteSync$2(r22, r3));
        OrderCommonLog.c("iesec_orderlist_freq", new OrderSelfJudgeFreqFunction$onExecuteSync$3(r3, r4));
        if (r4 == false) goto L10;
        int r1 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L10:
        if (r3 == null) goto L12;
        Object r5 = r3.get("max_store_num");
    L14:
        if ((r5 instanceof Integer) == true) goto L16;
        r5 = null;
    L16:
        Integer r6 = (Integer) r5;
        if (r6 == null) goto L19;
        int r7 = r6.intValue();
    L20:
        if (r3 == null) goto L22;
        Object r8 = r3.get("freq_scene");
    L24:
        if ((r8 instanceof List) == true) goto L26;
        r8 = null;
    L26:
        List<String> r9 = (List) r8;
        if (r9 != null) goto L29;
        r9 = CollectionsKt.listOf(c.b);
    L29:
        OrderFreqControlManager r10 = this.a.C0();
        if (r10 == null) goto L32;
        final Map<String, Map<String, SingleFreqCache>> r11 = r10.a();
    L34:
        if (r3 == null) goto L37;
        final String r12 = mq.b.d(r3, "freq_limit_id", null);
        if (r12 == null) goto L37;
    L39:
        if (r7 != 0) goto L60;
        Iterator<T> r13 = r9.iterator();
    L42:
        if (r13.hasNext() == false) goto L57;
        final String r14 = (String) r13.next();
        if (r11 == null) goto L52;
        Map<String, SingleFreqCache> r15 = r11.get(r12 + r14);
        if (r15 == null) goto L52;
        OrderFreqControlManager r16 = this.a.C0();
        if (r16 == null) goto L50;
        String r17 = r16.a;
    L51:
        SingleFreqCache r18 = r15.get(r17);
    L53:
        if (r18 == null) goto L42;
        Lazy r19 = OrderCommonLog.a;
        OrderCommonLog.c("iesec_orderlist_freq", new OrderSelfJudgeFreqFunction$onExecuteSync$$inlined$forEach$lambda$1(r14, this, r11, r12));
        OrderFreqControlManager r20 = this.a.C0();
        if (r20 == null) goto L42;
        r20.d(r12 + r14, new SingleFreqCache(null, null, null, null, null, 31, null));
        goto L42
    L50:
        r17 = null;
    L52:
        r18 = null;
        goto L53
    L57:
        int r21 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, MapsKt.mapOf(TuplesKt.to("self_show_id", "")), null, 5);
    L60:
        if (r3 == null) goto L64;
        Object r23 = r3.get("freq_server_store");
        if (r23 == null) goto L64;
        final String r24 = r23.toString();
    L65:
        if (r24 == null) goto L67;
        Intrinsics.checkNotNullParameter(r24, "$this$toFreqStorage");
        FreqStorage r110 = (FreqStorage) u0.b(r24, FreqStorage.class);
    L69:
        if (r3 == null) goto L71;
        Object r25 = r3.get("freq_limit_strategy");
    L73:
        if ((r25 instanceof List) == true) goto L75;
        r25 = null;
    L75:
        List r26 = (List) r25;
        if (r26 == null) goto L78;
        List<FreqStrategy> r27 = com.bytedance.android.shopping.orderlist.common.freq.b.a(r26);
    L80:
        if (r12.length() != 0) goto L82;
        boolean r111 = true;
    L83:
        if (r111 == true) goto L104;
        if (r27 != null) goto L86;
    L88:
        if (r110 != null) goto L90;
    L99:
        ConsumeResult r28 = new ConsumeResult("");
        OrderFreqControlManager r29 = this.a.C0();
        if (r29 == null) goto L102;
        r28 = r29.e(r9, r12);
    L102:
        int r30 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, MapsKt.mapOf(TuplesKt.to("self_show_id", r28.getSelfShowId())), null, 5);
    L90:
        if (r110.containsContent() == false) goto L99;
        OrderCommonLog.c("iesec_orderlist_freq", new OrderSelfJudgeFreqFunction$onExecuteSync$5(r24, r12));
        OrderFreqControlManager r31 = this.a.C0();
        if (r31 == null) goto L99;
        TransferParams r32 = new TransferParams(r110, r12, r27);
        Intrinsics.checkNotNullParameter(r32, "transferParams");
        Iterator r33 = ((LinkedHashMap) r31.f(r32)).entrySet().iterator();
    L95:
        if (r33.hasNext() == false) goto L99;
        Map.Entry r34 = (Map.Entry) r33.next();
        SingleFreqCache r35 = ((JudgeStrategyResult) r34.getValue()).getValue();
        if (r35 == null) goto L95;
        r31.d((String) r34.getKey(), r35);
        goto L95
    L86:
        if (r27.isEmpty() != true) goto L88;
    L104:
        OrderCommonErrorMonitorKt.a(this.a.E0(), "SELF_FUN_ERROR", "missing freq_limit_id or freq_limit_strategy in selfJudgeFrequency", MapsKt.mapOf(new Pair[]{TuplesKt.to("freq_server_store", r110), TuplesKt.to("freq_limit_id", r12), TuplesKt.to("freq_limit_strategy", r27)}));
        int r36 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "missing freq_limit_id or freq_limit_strategy in selfJudgeFrequency", null, null, 57);
    L82:
        r111 = false;
        goto L83
    L78:
        r27 = null;
        goto L80
    L71:
        r25 = null;
        goto L73
    L67:
        r110 = null;
    L64:
        r24 = null;
    L37:
        r12 = "";
        goto L39
    L32:
        r11 = null;
        goto L34
    L22:
        r8 = null;
        goto L24
    L19:
        r7 = 100;
        goto L20
    L12:
        r5 = null;
        goto L14
    L5:
        r4 = false;
        goto L6
    }
}
