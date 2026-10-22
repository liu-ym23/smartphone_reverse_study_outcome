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

/* JADX INFO: loaded from: classes16.dex */
public final class BitableNormalTrace extends BitableInnerTrace implements com.bytedance.ee.bear.bitable.statistic.e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e f215690k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f215691l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<BitableStatisticEventModel$NormalPointModel> f215692m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<BitableStatisticEventModel$NormalPointModel> f215693n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<j> f215694o;

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
        ((CopyOnWriteArrayList) this.f215694o).clear();
    }

    public BitableNormalTrace(String r100, e r101) {
        Intrinsics.checkNotNullParameter(r101, "traceProvider");
        super(r100, r101);
        this.f215690k = r101;
        this.f215691l = LazyKt.lazy(BitableNormalTrace$warningTime$2.INSTANCE);
        this.f215692m = new ArrayList();
        this.f215693n = new ArrayList();
        this.f215694o = new CopyOnWriteArrayList();
    }

    public final void n(List<? extends j> r110, BitableStatisticEventModel$NormalPointModel r111, int r112) {
        long r100 = System.currentTimeMillis();
        if (r112 < 3) goto L7;
        com.bytedance.ee.bear.bitable.statistic.common.e.c("BitableNormalTrace", "warning: circular call??");
        return;
    L7:
        if (r111.getUnique() == false) goto L29;
        if (r111.isTempPoint() == false) goto L11;
        List<BitableStatisticEventModel$NormalPointModel> r113 = this.f215693n;
    L12:
        Iterator<T> r114 = r113.iterator();
    L14:
        if (r114.hasNext() == false) goto L23;
        Object r101 = r114.next();
        BitableStatisticEventModel$NormalPointModel r102 = (BitableStatisticEventModel$NormalPointModel) r101;
        if (Intrinsics.areEqual(r102.getName(), r111.getName()) == true) goto L18;
    L20:
        boolean r103 = false;
    L21:
        if (r103 == false) goto L14;
    L25:
        if (((BitableStatisticEventModel$NormalPointModel) r101) == null) goto L29;
        int r115 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        com.bytedance.ee.bear.bitable.statistic.common.e.e("BitableNormalTrace", "point not unique: " + r111.getName() + ' ' + r111.getType());
        return;
    L18:
        if (r102.getType() != r111.getType()) goto L20;
        r103 = true;
        goto L21
    L23:
        r101 = null;
        goto L25
    L11:
        r113 = this.f215692m;
    L29:
        if (r111.isTempPoint() == false) goto L47;
        ((ArrayList) this.f215693n).add(r111);
        if (r111.getType() != BitableStatisticEventModel$NormalPointType.TEMP_POINT_TRIGGER) goto L68;
        List<BitableStatisticEventModel$NormalPointModel> r116 = this.f215693n;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r110.iterator();
    L34:
        if (r105.hasNext() == false) goto L42;
        List<BitableStatisticEventModel$NormalPointModel> r106 = ((j) r105.next()).c(this, r111, r116);     // Catch: Exception -> L40
        if (r106 == null) goto L34;
        r104.addAll(r106);     // Catch: Exception -> L40
    L40:
        e = move-exception;
        com.bytedance.ee.bear.bitable.statistic.common.e.d("BitableNormalTrace", "consumeTempPoint", e);
        goto L34
    L42:
        ((ArrayList) this.f215693n).clear();
        Iterator r117 = r104.iterator();
    L44:
        if (r117.hasNext() == false) goto L46;
        n(r110, (BitableStatisticEventModel$NormalPointModel) r117.next(), 1);
        goto L44
    L46:
        j();
    L68:
        long r107 = System.currentTimeMillis() - r100;
        if (r107 <= ((Number) this.f215691l.getValue()).intValue()) goto L95;
        int r118 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        com.bytedance.ee.bear.bitable.statistic.common.e.c("BitableNormalTrace", "warning: add point too slow " + r107);
        int r119 = com.bytedance.ee.bear.bitable.statistic.common.d.f215627a;
        com.bytedance.ee.bear.bitable.statistic.common.d.a(this, this.f215690k.getLogger(), r111, "add_point_too_slow", Long.valueOf(r107));
        return;
    L95:
        return;
    L47:
        ((ArrayList) this.f215692m).add(r111);
        List<BitableStatisticEventModel$NormalPointModel> r120 = this.f215692m;
        long r108 = System.currentTimeMillis();
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator<T> r121 = r110.iterator();
    L49:
        if (r121.hasNext() == false) goto L51;
        r109.add(((j) r121.next()).getTag());
        goto L49
    L51:
        int r122 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        StringBuilder r123 = new StringBuilder("consumePoint ");
        r123.append(r111.getName());
        r123.append(' ');
        if (r109.size() != 1) goto L54;
        String r124 = (String) ListProtector.get(r109, 0);
    L55:
        r123.append(r124);
        tt5.a.h("BitableStatistic", "BitableNormalTrace " + r123.toString());
        ArrayList r125 = new ArrayList();
        Iterator<T> r126 = r110.iterator();
    L57:
        if (r126.hasNext() == false) goto L65;
        List<BitableStatisticEventModel$NormalPointModel> r127 = ((j) r126.next()).b(this.f215690k.getLogger(), this, r111, r120);     // Catch: Exception -> L63
        if (r127 == null) goto L57;
        r125.addAll(r127);     // Catch: Exception -> L63
    L63:
        e = move-exception;
        com.bytedance.ee.bear.bitable.statistic.common.e.d("BitableNormalTrace", "consumePoint", e);
        goto L57
    L65:
        ((ArrayList) this.f215692m).removeAll(r125);
        j();
        long r128 = System.currentTimeMillis() - r108;
        if (r128 <= ((Number) this.f215691l.getValue()).intValue()) goto L68;
        int r129 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        com.bytedance.ee.bear.bitable.statistic.common.e.c("BitableNormalTrace", "warning: consumeNormalPoint too slow " + r128);
        int r130 = com.bytedance.ee.bear.bitable.statistic.common.d.f215627a;
        com.bytedance.ee.bear.bitable.statistic.common.d.a(this, this.f215690k.getLogger(), r111, "consume_normal_point_too_slow", Long.valueOf(r128));
        goto L68
    L54:
        r124 = r109.toString();
        goto L55
    }
}
