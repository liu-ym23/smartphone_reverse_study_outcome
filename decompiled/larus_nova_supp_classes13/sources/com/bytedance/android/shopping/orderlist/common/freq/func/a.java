package com.bytedance.android.shopping.orderlist.common.freq.func;

import com.bytedance.android.shopping.orderlist.common.freq.FreqStrategy;
import com.bytedance.android.shopping.orderlist.common.freq.OrderFreqControlManager;
import com.bytedance.android.shopping.orderlist.common.freq.ProduceFreq;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.protocol.data.q;
import com.bytedance.kmp.ec.yata.store.node.c;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.kmp.ec.yata.event.common.b {
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a a;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.orderlist.common.freq.func.a$a, reason: collision with other inner class name */
    public static final class C0141a {
    }

    static {
    }

    public a(com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(final com.bytedance.kmp.ec.yata.event.core.a r12) {
        Intrinsics.checkNotNullParameter(r12, "input");
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderCommonSelfControlFreqFunction", OrderCommonSelfControlFreqFunction$onExecuteSync$1.INSTANCE);
        final Map r1 = r12.q();
        if (r1 == null) goto L5;
        final String r3 = mq.b.d(r1, "action", null);
    L6:
        c r4 = r12.j();
        if (r4 == null) goto L9;
        Map r5 = r4.s();
    L10:
        OrderCommonLog.c("iesec_orderlist_freq", new OrderCommonSelfControlFreqFunction$onExecuteSync$2(r12, r1, r3));
        if (r5 == null) goto L13;
        Object r6 = r5.get("freq_limit_strategy");
    L15:
        if ((r6 instanceof List) == true) goto L17;
        r6 = null;
    L17:
        List r7 = (List) r6;
        if (r7 == null) goto L20;
        List<FreqStrategy> r8 = com.bytedance.android.shopping.orderlist.common.freq.b.a(r7);
    L21:
        if (r5 == null) goto L23;
        Object r9 = r5.get("max_store_num");
    L25:
        if ((r9 instanceof Integer) == true) goto L27;
        r9 = null;
    L27:
        Integer r10 = (Integer) r9;
        if (r10 == null) goto L30;
        int r11 = r10.intValue();
    L32:
        if (r5 == null) goto L34;
        boolean r13 = mq.b.c(r5, "skip_app_frequency", false);
    L35:
        c r14 = r12.j();
        if (r14 == null) goto L43;
        p r15 = r14.b.b;
        if (r15 == null) goto L40;
        Map r16 = q.a(r15);
    L41:
        if (r16 == null) goto L43;
        String r17 = mq.b.d(r16, "self_show_id", "");
    L44:
        boolean r18 = true;
        if (r3 != null) goto L47;
    L69:
        OrderCommonErrorMonitorKt.a(this.a.E0(), "SELF_FUN_ERROR", "wrong value for action or freq_limit_strategy in selfControlFreq", MapsKt.mapOf(new Pair[]{TuplesKt.to("self_show_id", r17), TuplesKt.to("action", r3), TuplesKt.to("freq_limit_strategy", String.valueOf(r8))}));
        int r19 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "wrong value for action or freq_limit_strategy in selfControlFreq", null, null, 57);
    L47:
        if (com.bytedance.android.shopping.orderlist.common.freq.a.a.contains(r3) == false) goto L69;
        if (r8 != null) goto L50;
    L53:
        boolean r110 = true;
    L54:
        if (r110 == true) goto L69;
        if (r17 != null) goto L58;
    L61:
        if (r18 == false) goto L64;
        int r111 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "wrong value for self_show_id in selfControlFreq", null, null, 57);
    L64:
        OrderFreqControlManager r2 = this.a.C0();
        if (r2 == null) goto L67;
        r2.c(new ProduceFreq(r17, r3, r8, r11), r13);
    L67:
        int r112 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L58:
        if (r17.length() == 0) goto L61;
        r18 = false;
        goto L61
    L50:
        if (r8.isEmpty() == true) goto L53;
        r110 = false;
        goto L54
    L40:
        r16 = null;
    L43:
        r17 = null;
        goto L44
    L34:
        r13 = false;
        goto L35
    L30:
        r11 = 100;
        goto L32
    L23:
        r9 = null;
        goto L25
    L20:
        r8 = null;
        goto L21
    L13:
        r6 = null;
        goto L15
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
