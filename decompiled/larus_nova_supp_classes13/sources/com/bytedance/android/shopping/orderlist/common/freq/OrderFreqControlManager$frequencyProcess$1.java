package com.bytedance.android.shopping.orderlist.common.freq;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderFreqControlManager$frequencyProcess$1 extends com.bytedance.kmp.ec.yata.store.core.a {
    public final /* synthetic */ OrderFreqControlManager a;

    public OrderFreqControlManager$frequencyProcess$1(OrderFreqControlManager r1) {
        this.a = r1;
    }

    public final void b(final com.bytedance.kmp.ec.yata.store.core.a.a r19) {
        Intrinsics.checkNotNullParameter(r19, "modifier");
        if (Intrinsics.areEqual(((com.bytedance.kmp.ec.yata.store.core.a.b) r19).b, aa6.a.a.b) == false) goto L5;
        return;
    L5:
        Map r1 = r19.d();
        SingleFreqCache r2 = null;
        if (r1 == null) goto L8;
        Object r3 = r1.get("freq_limit_id");
    L9:
        if (r3 == null) goto L81;
        OrderFreqControlManager r4 = this.a;
        final Map r5 = r19.d();
        r4.getClass();
        final boolean r6 = false;
        if (r5 == null) goto L13;
        r6 = mq.b.c(r5, "skip_app_frequency", false);
    L13:
        if (r5 == null) goto L15;
        Object r7 = r5.get("freq_scene");
    L17:
        if ((r7 instanceof List) == true) goto L19;
        r7 = null;
    L19:
        List<String> r8 = (List) r7;
        if (r8 != null) goto L22;
        r8 = CollectionsKt.listOf(c.b);
    L22:
        if (r5 == null) goto L26;
        Object r9 = r5.get("freq_server_store");
        if (r9 == null) goto L26;
        final String r10 = r9.toString();
    L27:
        if (r10 == null) goto L29;
        Intrinsics.checkNotNullParameter(r10, "$this$toFreqStorage");
        FreqStorage r11 = (FreqStorage) u0.b(r10, FreqStorage.class);
    L31:
        if (r5 == null) goto L34;
        final String r12 = mq.b.d(r5, "freq_limit_id", null);
        if (r12 == null) goto L34;
    L35:
        if (r5 == null) goto L37;
        Object r13 = r5.get("max_store_num");
    L39:
        if ((r13 instanceof Integer) == true) goto L41;
        r13 = null;
    L41:
        Integer r14 = (Integer) r13;
        if (r14 == null) goto L44;
        int r15 = r14.intValue();
    L45:
        if (r5 == null) goto L47;
        Object r16 = r5.get("freq_limit_strategy");
    L49:
        if ((r16 instanceof List) == true) goto L51;
        r16 = null;
    L51:
        List r17 = (List) r16;
        if (r17 == null) goto L54;
        List<FreqStrategy> r18 = b.a(r17);
    L55:
        Lazy r110 = OrderCommonLog.a;
        OrderCommonLog.c("iesec_orderlist_freq", new OrderFreqControlManager$consumeFreq$1(r5, r6));
        if (r6 == false) goto L58;
        ConsumeResult r20 = new ConsumeResult("");
    L79:
        r19.e("self_show_id", r20.getSelfShowId());
        Lazy r21 = OrderCommonLog.a;
        OrderCommonLog.c("iesec_orderlist_freq", new OrderFreqControlManager$frequencyProcess$1$doProcessModify$1(r19));
        return;
    L58:
        if (r11 != null) goto L60;
    L62:
        ConsumeResult r22 = new ConsumeResult("");
        if (r15 == 0) goto L66;
        r20 = r4.e(r8, r12);
        goto L79
    L66:
        if ((!r8.isEmpty()) == false) goto L78;
        Iterator<T> r23 = r8.iterator();
    L69:
        if (r23.hasNext() == false) goto L78;
        String r24 = (String) r23.next();
        Map<String, Map<String, SingleFreqCache>> r25 = r4.a();
        if (r25 == null) goto L75;
        Map<String, SingleFreqCache> r26 = r25.get(r12 + r24);
        if (r26 == null) goto L75;
        SingleFreqCache r27 = r26.get(r4.a);
    L76:
        if (r27 == null) goto L69;
        r4.d(r12 + r24, new SingleFreqCache(null, null, null, null, null, 31, null));
        r2 = null;
    L75:
        r27 = r2;
    L78:
        r20 = r22;
        goto L79
    L60:
        if (r11.containsContent() == false) goto L62;
        OrderCommonLog.c("iesec_orderlist_freq", new OrderFreqControlManager$consumeFreq$2(r10, r12));
        r4.f(new TransferParams(r11, r12, r18));
        goto L62
    L54:
        r18 = null;
        goto L55
    L47:
        r16 = null;
        goto L49
    L44:
        r15 = 100;
        goto L45
    L37:
        r13 = null;
    L34:
        r12 = "";
        goto L35
    L29:
        r11 = null;
    L26:
        r10 = null;
        goto L27
    L15:
        r7 = null;
        goto L17
    L81:
        return;
    L8:
        r3 = null;
        goto L9
    }
}
