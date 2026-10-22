package com.bytedance.ee.bear.office.list.menuconfig;

import com.bytedance.ee.bear.office.list.adapter.b0;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.bear.widgets.menuconfig.d;
import com.bytedance.ee.bear.widgets.menuconfig.e;
import com.bytedance.ee.bear.widgets.menuconfig.f;
import com.bytedance.ee.bear.widgets.menuconfig.g;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeLongPressMenuConfigComposer {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Comparator {
        public final /* synthetic */ Map a;

        public a(Map r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            int r5 = (Integer) this.a.get(((g) r3).c);
            if (r5 != null) goto L6;
            r5 = Integer.MAX_VALUE;
        L6:
            int r6 = (Integer) this.a.get(((g) r4).c);
            if (r6 != null) goto L11;
            r6 = Integer.MAX_VALUE;
        L11:
            return ComparisonsKt.compareValues(r5, r6);
        }
    }

    public static final class b<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public b(a r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r0 = this.a.compare(r2, r3);
            if (r0 == 0) goto L6;
            return r0;
        L6:
            return ComparisonsKt.compareValues(Integer.valueOf(((g) r2).d), Integer.valueOf(((g) r3).d));
        }
    }

    static {
    }

    public static String c(b0 r0) {
        int r1 = r0.b;
        switch(r1) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            default: goto L4;
        };
    L4:
        switch(r1) {
            case 102: goto L21;
            case 103: goto L20;
            case 104: goto L19;
            case 105: goto L18;
            case 106: goto L18;
            case 107: goto L17;
            case 108: goto L16;
            default: goto L5;
        };
    L5:
        return "";
    L16:
        return "mark_copy";
    L17:
        return "rename";
    L18:
        return "delete";
    L19:
        return "secret_setting";
    L20:
        return "add_shortcut";
    L21:
        return "move_to";
    L6:
        return "display_mode";
    L7:
        return "filter";
    L8:
        return "sort";
    L9:
        return "more";
    L10:
        return "copy_link";
    L11:
        return "favorite";
    L12:
        return "multi_select";
    L13:
        return OperationName.OPERATION_DOWNLOAD;
    L14:
        return "share";
    L15:
        return "ask_doubao";
    }

    public static List a(d r6, List r7, List r8) {
        Intrinsics.checkNotNullParameter(r7, "mainSpecs");
        Intrinsics.checkNotNullParameter(r8, "moreSpecs");
        if (r6 != null) goto L5;
        return null;
    L5:
        e r1 = r6.a("list_context");
        if (r1 != null) goto L9;
        return null;
    L9:
        if ((!r1.b) == true) goto L11;
        LinkedHashMap r4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16));
        Iterator r9 = r7.iterator();
    L14:
        if (r9.hasNext() == false) goto L16;
        Object r2 = r9.next();
        r4.put(c((b0) r2), r2);
        goto L14
    L16:
        LinkedHashMap r0 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r8, 10)), 16));
        Iterator r10 = r8.iterator();
    L18:
        if (r10.hasNext() == false) goto L21;
        Object r11 = r10.next();
        r0.put(c((b0) r11), r11);
        goto L18
    L21:
        return b(r1, r4, MapsKt.mapOf(TuplesKt.to("list_context_more", b(r6.a("list_context_more"), r0, MapsKt.emptyMap()))));
    L11:
        return CollectionsKt.emptyList();
    }

    public static List b(e r5, final Map r6, final Map r7) {
        if (r5 == null) goto L23;
        if ((!r5.b) == true) goto L23;
        List<f> r0 = r5.c;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        Object r3 = r2.next();
        if (((f) r3).b == false) goto L8;
        r1.add(r3);
        goto L8
    L12:
        final LinkedHashMap r4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));
        Iterator r8 = r1.iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        Object r9 = r8.next();
        r4.put(((f) r9).a, r9);
        goto L14
    L16:
        LinkedHashMap r10 = new LinkedHashMap(MapsKt.mapCapacity(r4.size()));
        Iterator r11 = r4.entrySet().iterator();
    L18:
        if (r11.hasNext() == false) goto L21;
        Map.Entry r12 = (Map.Entry) r11.next();
        r10.put(r12.getKey(), Integer.valueOf(((f) r12.getValue()).c));
        goto L18
    L21:
        return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(SequencesKt.filter(SequencesKt.filter(CollectionsKt.asSequence(r5.d), OfficeLongPressMenuConfigComposer$composeLeafItems$1.INSTANCE), new OfficeLongPressMenuConfigComposer$composeLeafItems$2(r4)), new b(new a(r10))), new OfficeLongPressMenuConfigComposer$composeLeafItems$5(r6, r7)));
    L23:
        return CollectionsKt.emptyList();
    }
}
