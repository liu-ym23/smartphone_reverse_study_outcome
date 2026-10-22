package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
public final class r1 {

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(((be8.b) r100).f18755l, ((be8.b) r101).f18755l);
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(((be8.b) r101).f18753j, ((be8.b) r100).f18753j);
        }
    }

    public static final List<be8.b> b(List<be8.b> r100, List<be8.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "current");
        Intrinsics.checkNotNullParameter(r101, "refreshed");
        LinkedHashMap r102 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r101, 10)), 16));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Object r104 = r103.next();
        r102.put(((be8.b) r104).f18744a, r104);
        goto L4
    L6:
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r100.iterator();
    L8:
        if (r106.hasNext() == false) goto L12;
        be8.b r107 = (be8.b) r102.get(((be8.b) r106.next()).f18744a);
        if (r107 == null) goto L8;
        r105.add(r107);
        goto L8
    L12:
        HashSet r108 = new HashSet();
        Iterator r109 = r105.iterator();
    L14:
        if (r109.hasNext() == false) goto L16;
        r108.add(((be8.b) r109.next()).f18744a);
        goto L14
    L16:
        ArrayList r110 = new ArrayList();
        Iterator<T> r111 = r101.iterator();
    L18:
        if (r111.hasNext() == false) goto L23;
        Object r112 = r111.next();
        if (r108.contains(((be8.b) r112).f18744a) == true) goto L18;
        r110.add(r112);
        goto L18
    L23:
        return CollectionsKt.plus(r105, r110);
    }

    public static final List<q1> a(Context r110, List<be8.b> r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "skills");
        Intrinsics.checkNotNullParameter(r112, "query");
        if (r112.length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        List r101 = CollectionsKt.createListBuilder();
        List<be8.b> r102 = r111;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L15:
        if (r104.hasNext() == false) goto L22;
        Object r105 = r104.next();
        if (((be8.b) r105).f18753j == null) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L15;
        r103.add(r105);
        goto L15
    L19:
        r106 = false;
        goto L20
    L22:
        ArrayList r107 = new ArrayList();
        Iterator r108 = r103.iterator();
    L24:
        if (r108.hasNext() == false) goto L31;
        Object r109 = r108.next();
        if (((be8.b) r109).f18755l != null) goto L28;
        boolean r113 = true;
    L29:
        if (r113 == false) goto L24;
        r107.add(r109);
        goto L24
    L28:
        r113 = false;
        goto L29
    L31:
        List r114 = CollectionsKt.sortedWith(r107, new b());
        ArrayList r115 = new ArrayList();
        Iterator r116 = r103.iterator();
    L33:
        if (r116.hasNext() == false) goto L40;
        Object r117 = r116.next();
        if (((be8.b) r117).f18755l == null) goto L37;
        boolean r118 = true;
    L38:
        if (r118 == false) goto L33;
        r115.add(r117);
        goto L33
    L37:
        r118 = false;
        goto L38
    L40:
        List r119 = CollectionsKt.plus(r114, CollectionsKt.sortedWith(r115, new a()));
        if ((!r103.isEmpty()) == true) goto L43;
    L54:
        boolean r120 = false;
    L55:
        if (r120 == false) goto L58;
        StringCompanionObject r121 = StringCompanionObject.INSTANCE;
        r101.add(new q1(String.format(r110.getString(R.string.larus_input_slash_header_recommended), Arrays.copyOf(new Object[]{Integer.valueOf(r103.size())}, 1)), r119, true, false, 8));
    L77:
        LinkedHashMap r122 = new LinkedHashMap();
        Iterator<T> r123 = r102.iterator();
    L79:
        if (r123.hasNext() == false) goto L87;
        Object r124 = r123.next();
        String r125 = ((be8.b) r124).f18752i;
        if (r125 != null) goto L83;
        r125 = "";
    L83:
        Object r126 = r122.get(r125);
        if (r126 != null) goto L86;
        r126 = new ArrayList();
        r122.put(r125, r126);
    L86:
        ((List) r126).add(r124);
        goto L79
    L87:
        Iterator r127 = r122.entrySet().iterator();
    L89:
        if (r127.hasNext() == false) goto L99;
        Map.Entry r128 = (Map.Entry) r127.next();
        String r129 = (String) r128.getKey();
        List r130 = (List) r128.getValue();
        if (r129.length() != 0) goto L93;
        boolean r131 = true;
    L94:
        if (r131 == false) goto L96;
        StringCompanionObject r132 = StringCompanionObject.INSTANCE;
        String r133 = String.format(r110.getString(R.string.larus_input_slash_skillsName), Arrays.copyOf(new Object[]{Integer.valueOf(r130.size())}, 1));
    L97:
        r101.add(new q1(r133, r130, false, false, 12));
        goto L89
    L96:
        r133 = r129 + " (" + r130.size() + ')';
        goto L97
    L93:
        r131 = false;
        goto L94
    L99:
        return CollectionsKt.build(r101);
    L58:
        if ((!r103.isEmpty()) == false) goto L77;
        Iterator<T> r134 = r102.iterator();
    L60:
        Integer r135 = null;
        if (r134.hasNext() == false) goto L65;
        Integer r136 = ((be8.b) r134.next()).f18756m;
        if (r136 == null) goto L60;
    L66:
        if (r136 != null) goto L68;
    L75:
        int r137 = 5;
    L76:
        List r138 = CollectionsKt.take(r119, r137);
        StringCompanionObject r139 = StringCompanionObject.INSTANCE;
        r101.add(new q1(String.format(r110.getString(R.string.larus_input_slash_header_mostUsed), Arrays.copyOf(new Object[]{Integer.valueOf(r138.size())}, 1)), r138, false, true, 4));
        goto L77
    L68:
        if (r136.intValue() < 0) goto L70;
        boolean r140 = true;
    L71:
        if (r140 == false) goto L73;
        r135 = r136;
    L73:
        if (r135 == null) goto L75;
        r137 = r135.intValue();
        goto L76
    L70:
        r140 = false;
        goto L71
    L65:
        r136 = null;
        goto L66
    L43:
        if (r103.isEmpty() == true) goto L51;
        Iterator r141 = r103.iterator();
    L47:
        if (r141.hasNext() == false) goto L51;
        if (((be8.b) r141.next()).f18754k == true) goto L47;
        boolean r142 = false;
    L52:
        if (r142 == false) goto L54;
        r120 = true;
    L51:
        r142 = true;
        goto L52
    L8:
        if (r111.isEmpty() == false) goto L12;
        return CollectionsKt.emptyList();
    L12:
        return CollectionsKt.listOf(new q1(r110.getString(R.string.larus_input_slash_header_skills), r111, false, false, 12));
    L5:
        r100 = false;
        goto L6
    }
}
