package com.bytedance.android.shopping.orderlist.common.freq;

import android.content.Context;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderFreqControlManager {
    public final String a;
    public Map<String, Map<String, SingleFreqCache>> b;
    public final AtomicBoolean c;
    public final Type d;
    public final Context e;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00020\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/android/shopping/orderlist/common/freq/OrderFreqControlManager$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "Lcom/bytedance/android/shopping/orderlist/common/freq/SingleFreqCache;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<Map<String, Map<String, SingleFreqCache>>> {
        public a() {
        }
    }

    public final Map<String, Map<String, SingleFreqCache>> a() {
        if (this.c.get() == true) goto L5;
        b();
    L5:
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("iesec_orderlist_freq", new OrderFreqControlManager$getCacheData$1(this));
        return this.b;
    }

    public final void b() {
        if (this.c.get() == false) goto L21;
        return;
    L21:
        Context r0 = this.e;     // Catch: Throwable -> L18
        Object r1 = null;
        if (r0 == null) goto L8;
        String r2 = ka3.b.a(r0, "__iesec_order_list_freq_control_key__");     // Catch: Throwable -> L18
    L9:
        Object r3 = u0.c().fromJson(r2, this.d);     // Catch: Throwable -> L18
        if (TypeIntrinsics.isMutableMap(r3) == false) goto L13;
        r1 = r3;
    L13:
        Map<String, Map<String, SingleFreqCache>> r4 = (Map) r1;     // Catch: Throwable -> L18
        if (r4 != null) goto L16;
        r4 = new LinkedHashMap();     // Catch: Throwable -> L18
    L16:
        this.b = r4;     // Catch: Throwable -> L18
        this.c.compareAndSet(false, true);     // Catch: Throwable -> L18
        return;
    L8:
        r2 = null;
    L18:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th);
    }

    public OrderFreqControlManager(Context r2) {
        this.e = r2;
        this.a = r.a.getCurrentUserId();
        this.c = new AtomicBoolean(false);
        this.d = new a().getType();
    }

    public static JudgeStrategyResult g(JudgeStrategyParams r19) {
        List<FreqStrategy> r0 = r19.getStrategy();
        if (r0 == null) goto L124;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L124;
        FreqStrategy r2 = (FreqStrategy) r1.next();
        FreqStatus r3 = r2.getTargetStatus();
        Iterator<String> r4 = c.a.iterator();
        boolean r6 = false;
    L9:
        if (r4.hasNext() == false) goto L108;
        String r7 = r4.next();
        SingleFreqCache r8 = r19.getSingleFreqCache();
        long r9 = r19.getFreqTime();
        int r10 = r7.hashCode();
        if (r10 == 3619493) goto L24;
        if (r10 == 94750088) goto L20;
        if (r10 == 94756344) goto L16;
    L27:
        List<Long> r11 = null;
    L28:
        FreqActionType r12 = r2.getActions();
        Long r16 = r2.getFreezingPeriod();
        Long r17 = r2.getLookBackPeriod();
        int r5 = r7.hashCode();
        if (r5 == 3619493) goto L42;
        if (r5 == 94750088) goto L38;
        if (r5 == 94756344) goto L34;
    L45:
        FreqParam r13 = null;
    L47:
        if (r13 == null) goto L59;
        Integer r14 = r13.getMin();
        if (r14 == null) goto L59;
        if (r14.intValue() < 0) goto L53;
        boolean r15 = true;
    L54:
        if (r15 == true) goto L57;
        r14 = null;
    L57:
        if (r14 == null) goto L59;
        int r18 = r14.intValue();
    L60:
        if (r13 == null) goto L72;
        Integer r20 = r13.getMax();
        if (r20 == null) goto L72;
        if (r20.intValue() < 0) goto L66;
        boolean r110 = true;
    L67:
        if (r110 == true) goto L70;
        r20 = null;
    L70:
        if (r20 == null) goto L72;
        int r21 = r20.intValue();
    L73:
        if (r16 == null) goto L86;
        if (r11 == null) goto L85;
        ArrayList r111 = new ArrayList();
        Iterator<T> r22 = r11.iterator();
    L77:
        if (r22.hasNext() == false) goto L84;
        Object r112 = r22.next();
        if (((Number) r112).longValue() < (r9 - r16.longValue())) goto L81;
        boolean r113 = true;
    L82:
        if (r113 == false) goto L77;
        r111.add(r112);
        goto L77
    L81:
        r113 = false;
        goto L82
    L84:
        r11 = CollectionsKt.toMutableList(r111);
        goto L86
    L85:
        r11 = null;
    L86:
        if (r17 == null) goto L99;
        if (r11 == null) goto L98;
        ArrayList r114 = new ArrayList();
        Iterator<T> r23 = r11.iterator();
    L90:
        if (r23.hasNext() == false) goto L97;
        Object r115 = r23.next();
        if (((Number) r115).longValue() < (r9 - r17.longValue())) goto L94;
        boolean r116 = true;
    L95:
        if (r116 == false) goto L90;
        r114.add(r115);
        goto L90
    L94:
        r116 = false;
        goto L95
    L97:
        r11 = CollectionsKt.toMutableList(r114);
        goto L99
    L98:
        r11 = null;
    L99:
        if (r11 == null) goto L101;
        int r24 = r11.size();
    L102:
        if (r18 > r24) goto L106;
        if (r21 < r24) goto L106;
        r6 = true;
    L107:
        if (r6 == true) goto L9;
    L106:
        r6 = false;
        goto L107
    L101:
        r24 = 0;
        goto L102
    L66:
        r110 = false;
    L72:
        r21 = Integer.MAX_VALUE;
        goto L73
    L53:
        r15 = false;
    L59:
        r18 = Integer.MIN_VALUE;
        goto L60
    L34:
        if (r7.equals(FreqActions.ACTION_CLOSE) == false) goto L45;
        if (r12 == null) goto L45;
        r13 = r12.getClose();
        goto L47
    L38:
        if (r7.equals("click") == false) goto L45;
        if (r12 == null) goto L45;
        r13 = r12.getClick();
        goto L47
    L42:
        if (r7.equals(FreqActions.ACTION_VIEW) == false) goto L45;
        if (r12 == null) goto L45;
        r13 = r12.getView();
        goto L47
    L16:
        if (r7.equals(FreqActions.ACTION_CLOSE) == false) goto L27;
        if (r8 == null) goto L27;
        r11 = r8.getClose();
        goto L28
    L20:
        if (r7.equals("click") == false) goto L27;
        if (r8 == null) goto L27;
        r11 = r8.getClick();
        goto L28
    L24:
        if (r7.equals(FreqActions.ACTION_VIEW) == false) goto L27;
        if (r8 == null) goto L27;
        r11 = r8.getView();
    L108:
        if (r6 == false) goto L6;
        SingleFreqCache r25 = r19.getSingleFreqCache();
        if (r25 == null) goto L113;
        r25.setStatus(r3);
    L113:
        if (r3 == FreqStatus.STATUS_FREEZE) goto L115;
    L119:
        SingleFreqCache r26 = r19.getSingleFreqCache();
        if (r26 == null) goto L123;
        r26.clearActionIfNeeded();
    L123:
        return new JudgeStrategyResult(r19.getId(), r19.getSingleFreqCache());
    L115:
        if (r2.getFreezingPeriod() == null) goto L119;
        SingleFreqCache r27 = r19.getSingleFreqCache();
        if (r27 == null) goto L119;
        r27.setUnfreezeDate(Long.valueOf(r19.getFreqTime() + r2.getFreezingPeriod().longValue()));
    L124:
        String r28 = r19.getId();
        SingleFreqCache r29 = r19.getSingleFreqCache();
        if (r29 == null) goto L127;
        SingleFreqCache r30 = SingleFreqCache.copy$default(r29, FreqStatus.STATUS_ACTIVE, null, null, null, null, 30, null);
    L129:
        return new JudgeStrategyResult(r28, r30);
    L127:
        r30 = null;
        goto L129
    }

    public static boolean h(SingleFreqCache r4) {
        FreqStatus r0 = null;
        if (r4 == null) goto L5;
        FreqStatus r1 = r4.getStatus();
    L7:
        if (r1 == FreqStatus.STATUS_DEAD) goto L18;
        if (r4 == null) goto L11;
        r0 = r4.getStatus();
    L11:
        if (r0 == FreqStatus.STATUS_FREEZE) goto L13;
    L17:
        return false;
    L13:
        if (r4.getUnfreezeDate() == null) goto L17;
        Long r5 = r4.getUnfreezeDate();
        Intrinsics.checkNotNull(r5);
        if (r5.longValue() < System.currentTimeMillis()) goto L17;
    L18:
        return true;
    L5:
        r1 = null;
        goto L7
    }

    public final Map<String, JudgeStrategyResult> f(TransferParams r20) {
        FreqStorage r1 = r20.getServerStore();
        if (r1 == null) goto L5;
        Map<String, List<Long>> r2 = r1.getView();
    L6:
        if (r2 == null) goto L8;
        Set<String> r3 = r2.keySet();
    L9:
        LinkedHashMap r4 = new LinkedHashMap();
        if (r3 == null) goto L23;
        Iterator<T> r5 = r3.iterator();
    L13:
        if (r5.hasNext() == false) goto L23;
        String r6 = (String) r5.next();
        String r10 = r20.getFreqLimitID() + r6;
        Map<String, Map<String, SingleFreqCache>> r7 = this.b;
        if (r7 == null) goto L19;
        Map<String, SingleFreqCache> r8 = r7.get(r10);
        if (r8 == null) goto L19;
        SingleFreqCache r9 = r8.get(this.a);
    L20:
        if (r9 == null) goto L21;
        r4.put(r6, new JudgeStrategyResult("", new SingleFreqCache(null, null, null, null, null, 31, null)));
        goto L13
    L21:
        SingleFreqCache r11 = new SingleFreqCache(null, null, null, null, null, 31, null);
        long r12 = System.currentTimeMillis();
        r11.setView(r2.get(r6));
        r4.put(r6, g(new JudgeStrategyParams(r11, r10, r20.getStrategy(), r12)));
    L19:
        r9 = null;
    L23:
        return r4;
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public final void c(ProduceFreq r19, final boolean r20) {
        Intrinsics.checkNotNullParameter(r19, "produceParams");
        final String r1 = r19.getId();
        final String r7 = r19.getAction();
        List<FreqStrategy> r8 = r19.getStrategy();
        final int r9 = r19.getMaxStoreNum();
        Map<String, Map<String, SingleFreqCache>> r2 = this.b;
        if (r2 == null) goto L10;
        Map<String, SingleFreqCache> r3 = r2.get(r1);
        if (r3 == null) goto L10;
        SingleFreqCache r4 = r3.get(this.a);
        if (r4 == null) goto L10;
        SingleFreqCache r10 = r4;
    L11:
        long r11 = System.currentTimeMillis();
        final boolean r13 = h(r10);
        if (r7 == null) goto L31;
        int r5 = r7.hashCode();
        if (r5 == 3619493) goto L28;
        if (r5 == 94750088) goto L25;
        if (r5 != 94756344) goto L31;
        if (r7.equals(FreqActions.ACTION_CLOSE) == false) goto L31;
        List<Long> r6 = r10.getClose();
    L30:
        List<Long> r15 = r6;
    L32:
        Lazy r12 = OrderCommonLog.a;
        OrderCommonLog.c("iesec_orderlist_freq", new OrderFreqControlManager$selfFreqProduce$1(r20, r9, r13, r1, r7));
        if (r9 == 0) goto L60;
        if (r13 == true) goto L60;
        if (r20 == true) goto L60;
        if (r10.getStatus() != FreqStatus.STATUS_FREEZE) goto L40;
        boolean r14 = true;
    L42:
        if (r10.getUnfreezeDate() == null) goto L46;
        Long r16 = r10.getUnfreezeDate();
        Intrinsics.checkNotNull(r16);
        if (r16.longValue() >= r11) goto L46;
        boolean r17 = true;
    L47:
        if (r14 == false) goto L50;
        if (r17 == false) goto L50;
        r10.setStatus(FreqStatus.STATUS_ACTIVE);
        r10.setUnfreezeDate(0L);
    L50:
        if (r15 == null) goto L52;
        ListProtector.add(r15, 0, Long.valueOf(r11));
    L52:
        if (r15 == null) goto L54;
        Integer r18 = Integer.valueOf(r15.size());
    L56:
        if (k.f(r18) <= r9) goto L59;
        if (r15 == null) goto L59;
        CollectionsKt.dropLast(r15, 1);
    L59:
        JudgeStrategyResult r21 = g(new JudgeStrategyParams(r10, r1, r8, r11));
    L62:
        if (r21.getKey() != null) goto L64;
        return;
    L64:
        if (r21.getValue() == null) goto L68;
        d(r21.getKey(), r21.getValue());
        return;
    L68:
        return;
    L54:
        r18 = null;
    L46:
        r17 = false;
        goto L47
    L40:
        r14 = false;
    L60:
        r21 = new JudgeStrategyResult("", new SingleFreqCache(null, null, null, null, null, 31, null));
        goto L62
    L25:
        if (r7.equals("click") == false) goto L31;
        r6 = r10.getClick();
        goto L30
    L28:
        if (r7.equals(FreqActions.ACTION_VIEW) == false) goto L31;
        r6 = r10.getView();
    L31:
        r15 = null;
    L10:
        r10 = new SingleFreqCache(null, null, null, null, null, 31, null);
        goto L11
    }

    public final void d(final String r4, final SingleFreqCache r5) {
        Intrinsics.checkNotNullParameter(r4, "id");
        Intrinsics.checkNotNullParameter(r5, "singleCache");
        Map<String, Map<String, SingleFreqCache>> r0 = this.b;
        if (r0 == null) goto L5;
        Map<String, SingleFreqCache> r1 = r0.get(r4);
    L6:
        if (r1 != null) goto L10;
        Map<String, Map<String, SingleFreqCache>> r2 = this.b;
        if (r2 == null) goto L10;
        r2.put(r4, new LinkedHashMap());
    L10:
        Map<String, Map<String, SingleFreqCache>> r3 = this.b;
        if (r3 == null) goto L15;
        Map<String, SingleFreqCache> r6 = r3.get(r4);
        if (r6 == null) goto L15;
        SingleFreqCache r7 = r6.put(this.a, r5);
    L15:
        Lazy r8 = OrderCommonLog.a;
        OrderCommonLog.c("iesec_orderlist_freq", new OrderFreqControlManager$saveCacheData$1(r4, r5));
        Context r9 = this.e;
        if (r9 == null) goto L19;
        int r10 = ka3.b.a;
        ka3.b.b(r9, "__iesec_order_list_freq_control_key__", GsonProtectorUtils.toJson(u0.c(), this.b, this.d));
        OrderCommonLog.c("iesec_orderlist_freq", new OrderFreqControlManager$saveCacheData$$inlined$let$lambda$1(this));
        return;
    L19:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final ConsumeResult e(List<String> r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "freqLimitId");
        if (r4 != null) goto L5;
        r4 = CollectionsKt.listOf(c.b);
    L5:
        Iterator<T> r6 = r4.iterator();
    L7:
        if (r6.hasNext() == false) goto L21;
        String r0 = (String) r6.next();
        Map<String, Map<String, SingleFreqCache>> r1 = this.b;
        if (r1 == null) goto L13;
        Map<String, SingleFreqCache> r2 = r1.get(r5 + r0);
        if (r2 == null) goto L13;
        SingleFreqCache r3 = r2.get(this.a);
    L14:
        if (r3 == null) goto L17;
        r3.getUnfreezeDate();
    L17:
        if (h(r3) == true) goto L7;
        return new ConsumeResult(r5 + r0);
    L13:
        r3 = null;
        goto L14
    L21:
        return new ConsumeResult("");
    }
}
