package com.larus.home.impl.main.side_bar.view.group.render;

import androidx.collection.SieveCacheKt;
import com.bytedance.ee.bear.document.bitable.TimeZoneItemV2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Long> f345663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<TimeZone> f345664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Locale> f345665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<com.larus.home.impl.main.side_bar.view.group.render.a, Locale, String> f345666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<Integer> f345667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.larus.home.impl.main.side_bar.view.group.render.a f345668f;

    public static final class a {
    }

    static {
    }

    public k() {
        this(null);
    }

    public k(Object r100) {
        DateHeaderInserter$1 r101 = DateHeaderInserter$1.INSTANCE;
        Function0<TimeZone> r102 = new i();
        Function0<Locale> r103 = new j();
        DateHeaderInserter$4 r104 = new DateHeaderInserter$4(v0.f345723a);
        Intrinsics.checkNotNullParameter(r101, "nowProvider");
        Intrinsics.checkNotNullParameter(r102, "zoneProvider");
        Intrinsics.checkNotNullParameter(r103, "localeProvider");
        Intrinsics.checkNotNullParameter(r104, "dateLabelProvider");
        this.f345663a = r101;
        this.f345664b = r102;
        this.f345665c = r103;
        this.f345666d = r104;
        this.f345667e = new LinkedHashSet();
        long r105 = r101.invoke().longValue();
        TimeZone r106 = TimeZone.getDefault();
        TimeZone r107 = com.larus.home.impl.main.side_bar.view.group.render.a.f345602d;
        Intrinsics.checkNotNullParameter(r106, TimeZoneItemV2.TIME_ZONE);
        Calendar r108 = Calendar.getInstance(r106);
        r108.setTimeInMillis(r105);
        Intrinsics.checkNotNull(r108);
        this.f345668f = new com.larus.home.impl.main.side_bar.view.group.render.a(r108.get(1), r108.get(2), r108.get(5));
    }

    public final <T> List<Object> insert(List<? extends T> r310, Function1<? super T, Integer> r311, GroupSortPolicy r312, Function1<? super T, Long> r313) {
        k r100 = this;
        List<? extends T> r101 = r310;
        Intrinsics.checkNotNullParameter(r101, "items");
        Intrinsics.checkNotNullParameter(r311, "unreadCountOf");
        Intrinsics.checkNotNullParameter(r312, "sortPolicy");
        Intrinsics.checkNotNullParameter(r313, "sortKeySecondsOf");
        if (r310.isEmpty() == true) goto L5;
        long r110 = r100.f345663a.invoke().longValue();
        TimeZone r102 = r100.f345664b.invoke();
        TimeZone r103 = com.larus.home.impl.main.side_bar.view.group.render.a.f345602d;
        Intrinsics.checkNotNullParameter(r102, TimeZoneItemV2.TIME_ZONE);
        Calendar r104 = Calendar.getInstance(r102);
        r104.setTimeInMillis(r110);
        Intrinsics.checkNotNull(r104);
        r100.f345668f = new com.larus.home.impl.main.side_bar.view.group.render.a(r104.get(1), r104.get(2), r104.get(5));
        u0 r105 = u0.f345716a;
        List<? extends T> r106 = r101;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L8:
        if (r108.hasNext() == false) goto L10;
        r107.add(Long.valueOf(r313.invoke(r108.next()).longValue() * 1000));
        goto L8
    L10:
        r105.getClass();
        Intrinsics.checkNotNullParameter(r107, "sortKeysDesc");
        Intrinsics.checkNotNullParameter(r102, TimeZoneItemV2.TIME_ZONE);
        if (((Boolean) u0.f345717b.getValue()).booleanValue() == false) goto L26;
        int r109 = r107.size();
        int r111 = 1;
    L13:
        if (r111 >= r109) goto L18;
        if (((Number) ListProtector.get(r107, r111)).longValue() > ((Number) ListProtector.get(r107, r111 - 1)).longValue()) goto L19;
        r111 = r111 + 1;
    L19:
        if (r111 >= 0) goto L21;
        boolean r112 = true;
    L22:
        if (r112 == true) goto L26;
        StringBuilder r113 = new StringBuilder("sortKeysDesc must be non-increasing, but [");
        int r114 = r111 - 1;
        r113.append(r114);
        r113.append("]=");
        r113.append(((Number) ListProtector.get(r107, r114)).longValue());
        r113.append(" < [");
        r113.append(r111);
        r113.append("]=");
        r113.append(((Number) ListProtector.get(r107, r111)).longValue());
        throw new IllegalArgumentException(r113.toString().toString());
    L21:
        r112 = false;
        goto L22
    L18:
        r111 = -1;
    L26:
        TimeZone r115 = com.larus.home.impl.main.side_bar.view.group.render.a.f345602d;
        Intrinsics.checkNotNullParameter(r102, TimeZoneItemV2.TIME_ZONE);
        Calendar r116 = Calendar.getInstance(r102);
        r116.setTimeInMillis(r110);
        Intrinsics.checkNotNull(r116);
        com.larus.home.impl.main.side_bar.view.group.render.a r117 = new com.larus.home.impl.main.side_bar.view.group.render.a(r116.get(1), r116.get(2), r116.get(5));
        int r118 = 8;
        long[] r119 = new long[8];
        int r120 = 0;
    L27:
        int r121 = 7;
        if (r120 >= r118) goto L33;
        if (r120 != 7) goto L31;
        long r122 = Long.MIN_VALUE;
    L32:
        r119[r120] = r122;
        r120 = r120 + 1;
        r117 = r117;
        r118 = 8;
        goto L27
    L31:
        Calendar r123 = Calendar.getInstance(com.larus.home.impl.main.side_bar.view.group.render.a.f345602d);
        r123.clear();
        r123.set(r117.f345603a, r117.f345604b, r117.f345605c);
        r123.add(5, -r120);
        int r124 = r123.get(1);
        int r125 = r123.get(2);
        int r126 = r123.get(5);
        Intrinsics.checkNotNullParameter(r102, TimeZoneItemV2.TIME_ZONE);
        Calendar r127 = Calendar.getInstance(r102);
        r127.clear();
        r127.set(r124, r125, r126);
        r122 = r127.getTimeInMillis();
        goto L32
    L33:
        int r128 = 8;
        ArrayList r129 = new ArrayList(8);
        int r130 = 0;
        int r131 = 0;
    L34:
        if (r130 >= r128) goto L45;
        long r210 = r119[r130];
        int r132 = r131;
    L37:
        if (r132 >= r107.size()) goto L41;
        if (((Number) ListProtector.get(r107, r132)).longValue() < r210) goto L41;
        r132 = r132 + 1;
    L41:
        if (r132 <= r131) goto L43;
        IntRange r133 = RangesKt.until(r131, r132);
    L44:
        r129.add(r133);
        r130 = r130 + 1;
        r131 = r132;
        r128 = 8;
        goto L34
    L43:
        r133 = IntRange.Companion.getEMPTY();
        goto L44
    L45:
        Locale r134 = r100.f345665c.invoke();
        List r135 = CollectionsKt.createListBuilder();
        Iterator r136 = r129.iterator();
        int r137 = 0;
    L47:
        if (r136.hasNext() == false) goto L87;
        Object r138 = r136.next();
        int r211 = r137 + 1;
        if (r137 >= 0) goto L51;
        CollectionsKt.throwIndexOverflow();
    L51:
        IntRange r139 = (IntRange) r138;
        if (r139.isEmpty() == true) goto L84;
        boolean r212 = !r100.f345667e.contains(Integer.valueOf(r137));
        List<? extends T> r140 = r101.subList(r139.getFirst(), r139.getLast() + 1);
        v0 r141 = v0.f345723a;
        com.larus.home.impl.main.side_bar.view.group.render.a r142 = r100.f345668f;
        Function2<com.larus.home.impl.main.side_bar.view.group.render.a, Locale, String> r143 = r100.f345666d;
        r141.getClass();
        Intrinsics.checkNotNullParameter(r142, "today");
        Intrinsics.checkNotNullParameter(r134, "locale");
        Intrinsics.checkNotNullParameter(r143, "dateLabel");
        if (r137 != 0) goto L56;
        eb9.e r144 = new eb9.e.b(v0.f345724b);
    L62:
        if (r212 == false) goto L64;
        int r145 = 0;
    L69:
        u0 r146 = u0.f345716a;
        TimeZone r147 = TimeZone.getDefault();
        r146.getClass();
        Intrinsics.checkNotNullParameter(r147, TimeZoneItemV2.TIME_ZONE);
        if (r137 < 0) goto L73;
        if (r137 >= 8) goto L73;
        boolean r148 = true;
    L74:
        if (r148 == false) goto L83;
        Calendar r149 = Calendar.getInstance(r147);
        r149.setTimeInMillis(r110);
        r149.add(5, -r137);
        r149.set(11, 0);
        r149.set(12, 0);
        r149.set(13, 0);
        r149.set(14, 0);
        if (r137 != 7) goto L78;
        long r150 = 0;
    L79:
        r149.add(5, 1);
        r149.set(11, 0);
        r149.set(12, 0);
        r149.set(13, 0);
        r149.set(14, 0);
        List r151 = r135;
        r151.add(new l(r137, r144, r212, r145, new s0(r150, r149.getTimeInMillis() / 1000), r312));
        if (r212 == false) goto L85;
        Intrinsics.checkNotNull(r140, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        r151.addAll(r140);
    L85:
        r100 = this;
        r101 = r310;
        r135 = r151;
        r137 = r211;
        r136 = r136;
        r134 = r134;
        r121 = 7;
        goto L47
    L78:
        r150 = r149.getTimeInMillis() / 1000;
        goto L79
    L83:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L73:
        r148 = false;
        goto L74
    L64:
        Iterator<T> r152 = r140.iterator();
        long r153 = 0;
    L66:
        if (r152.hasNext() == false) goto L68;
        r153 = r153 + ((long) RangesKt.coerceAtLeast(r311.invoke(r152.next()).intValue(), 0));
        goto L66
    L68:
        r145 = (int) RangesKt.coerceAtMost(r153, SieveCacheKt.NodeLinkMask);
        goto L69
    L56:
        if (r137 == 1) goto L60;
        if (r137 == r121) goto L59;
        r142.getClass();
        Calendar r154 = Calendar.getInstance(com.larus.home.impl.main.side_bar.view.group.render.a.f345602d);
        r154.clear();
        r154.set(r142.f345603a, r142.f345604b, r142.f345605c);
        r154.add(5, -r137);
        r144 = new eb9.e.a(r143.invoke(new com.larus.home.impl.main.side_bar.view.group.render.a(r154.get(1), r154.get(2), r154.get(5)), r134));
        goto L62
    L59:
        r144 = new eb9.e.b(v0.f345726d);
        goto L62
    L60:
        r144 = new eb9.e.b(v0.f345725c);
        goto L62
    L84:
        r136 = r136;
        r134 = r134;
        r151 = r135;
        goto L85
    L87:
        return CollectionsKt.build(r135);
    L5:
        return CollectionsKt.emptyList();
    }
}
