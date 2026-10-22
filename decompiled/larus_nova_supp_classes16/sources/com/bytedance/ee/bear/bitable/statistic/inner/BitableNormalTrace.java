package com.bytedance.ee.bear.bitable.statistic.inner;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointType;
import com.bytedance.ee.bear.bitable.statistic.BitableTraceType;
import com.bytedance.ee.bear.bitable.statistic.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class BitableNormalTrace extends BitableInnerTrace implements com.bytedance.ee.bear.bitable.statistic.e {
    public final e k;
    public final Lazy l;
    public final List<BitableStatisticEventModel$NormalPointModel> m;
    public final List<BitableStatisticEventModel$NormalPointModel> n;
    public final List<j> o;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.inner.BitableInnerTrace, com.bytedance.ee.bear.bitable.statistic.n
    public /* bridge */ /* synthetic */ BitableTraceType getType() {
        return com.bytedance.ee.bear.bitable.statistic.d.a(this);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.inner.BitableInnerTrace
    public final void m() {
        ((CopyOnWriteArrayList) this.o).clear();
    }

    public BitableNormalTrace(String r2, e r3) {
        Intrinsics.checkNotNullParameter(r3, "traceProvider");
        super(r2, r3);
        this.k = r3;
        this.l = LazyKt.lazy(BitableNormalTrace$warningTime$2.INSTANCE);
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new CopyOnWriteArrayList();
    }

    public final void n(List<? extends j> r12, BitableStatisticEventModel$NormalPointModel r13, int r14) {
        long r0 = System.currentTimeMillis();
        if (r14 < 3) goto L7;
        com.bytedance.ee.bear.bitable.statistic.common.e.c("BitableNormalTrace", "warning: circular call??");
        return;
    L7:
        if (r13.getUnique() == false) goto L29;
        if (r13.isTempPoint() == false) goto L11;
        List<BitableStatisticEventModel$NormalPointModel> r16 = this.n;
    L12:
        Iterator<T> r17 = r16.iterator();
    L14:
        if (r17.hasNext() == false) goto L23;
        Object r6 = r17.next();
        BitableStatisticEventModel$NormalPointModel r7 = (BitableStatisticEventModel$NormalPointModel) r6;
        if (Intrinsics.areEqual(r7.getName(), r13.getName()) == true) goto L18;
    L20:
        boolean r8 = false;
    L21:
        if (r8 == false) goto L14;
    L25:
        if (((BitableStatisticEventModel$NormalPointModel) r6) == null) goto L29;
        int r18 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
        com.bytedance.ee.bear.bitable.statistic.common.e.e("BitableNormalTrace", "point not unique: " + r13.getName() + ' ' + r13.getType());
        return;
    L18:
        if (r7.getType() != r13.getType()) goto L20;
        r8 = true;
        goto L21
    L23:
        r6 = null;
        goto L25
    L11:
        r16 = this.m;
    L29:
        if (r13.isTempPoint() == false) goto L47;
        ((ArrayList) this.n).add(r13);
        if (r13.getType() != BitableStatisticEventModel$NormalPointType.TEMP_POINT_TRIGGER) goto L68;
        List<BitableStatisticEventModel$NormalPointModel> r19 = this.n;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r12.iterator();
    L34:
        if (r5.hasNext() == false) goto L42;
        List<BitableStatisticEventModel$NormalPointModel> r9 = ((j) r5.next()).c(this, r13, r19);     // Catch: Exception -> L40
        if (r9 == null) goto L34;
        r4.addAll(r9);     // Catch: Exception -> L40
    L40:
        e = move-exception;
        com.bytedance.ee.bear.bitable.statistic.common.e.d("BitableNormalTrace", "consumeTempPoint", e);
        goto L34
    L42:
        ((ArrayList) this.n).clear();
        Iterator r110 = r4.iterator();
    L44:
        if (r110.hasNext() == false) goto L46;
        n(r12, (BitableStatisticEventModel$NormalPointModel) r110.next(), 1);
        goto L44
    L46:
        j();
    L68:
        long r10 = System.currentTimeMillis() - r0;
        if (r10 <= ((Number) this.l.getValue()).intValue()) goto L95;
        int r111 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
        com.bytedance.ee.bear.bitable.statistic.common.e.c("BitableNormalTrace", "warning: add point too slow " + r10);
        int r112 = com.bytedance.ee.bear.bitable.statistic.common.d.a;
        com.bytedance.ee.bear.bitable.statistic.common.d.a(this, this.k.getLogger(), r13, "add_point_too_slow", Long.valueOf(r10));
        return;
    L95:
        return;
    L47:
        ((ArrayList) this.m).add(r13);
        List<BitableStatisticEventModel$NormalPointModel> r113 = this.m;
        long r11 = System.currentTimeMillis();
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r21 = r12.iterator();
    L49:
        if (r21.hasNext() == false) goto L51;
        r20.add(((j) r21.next()).getTag());
        goto L49
    L51:
        int r22 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
        StringBuilder r23 = new StringBuilder("consumePoint ");
        r23.append(r13.getName());
        r23.append(' ');
        if (r20.size() != 1) goto L54;
        String r2 = (String) ListProtector.get(r20, 0);
    L55:
        r23.append(r2);
        tt5.a.h("BitableStatistic", "BitableNormalTrace " + r23.toString());
        ArrayList r3 = new ArrayList();
        Iterator<T> r114 = r12.iterator();
    L57:
        if (r114.hasNext() == false) goto L65;
        List<BitableStatisticEventModel$NormalPointModel> r24 = ((j) r114.next()).b(this.k.getLogger(), this, r13, r113);     // Catch: Exception -> L63
        if (r24 == null) goto L57;
        r3.addAll(r24);     // Catch: Exception -> L63
    L63:
        e = move-exception;
        com.bytedance.ee.bear.bitable.statistic.common.e.d("BitableNormalTrace", "consumePoint", e);
        goto L57
    L65:
        ((ArrayList) this.m).removeAll(r3);
        j();
        long r26 = System.currentTimeMillis() - r11;
        if (r26 <= ((Number) this.l.getValue()).intValue()) goto L68;
        int r115 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
        com.bytedance.ee.bear.bitable.statistic.common.e.c("BitableNormalTrace", "warning: consumeNormalPoint too slow " + r26);
        int r116 = com.bytedance.ee.bear.bitable.statistic.common.d.a;
        com.bytedance.ee.bear.bitable.statistic.common.d.a(this, this.k.getLogger(), r13, "consume_normal_point_too_slow", Long.valueOf(r26));
        goto L68
    L54:
        r2 = r20.toString();
        goto L55
    }
}
