package com.bytedance.ee.bear.office.list.menuconfig;

import com.bytedance.ee.bear.office.list.adapter.b0;
import com.bytedance.ee.bear.widgets.menuconfig.d;
import com.bytedance.ee.bear.widgets.menuconfig.e;
import com.bytedance.ee.bear.widgets.menuconfig.f;
import com.bytedance.ee.bear.widgets.menuconfig.g;
import com.larus.bmhome.share.panel.ShareChannel;
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

/* JADX INFO: loaded from: classes18.dex */
public final class OfficeLongPressMenuConfigComposer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f235925a = 0;

    public static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f235926a;

        public a(Map r100) {
            this.f235926a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = (Integer) this.f235926a.get(((g) r100).f240259c);
            if (r102 != null) goto L6;
            r102 = Integer.MAX_VALUE;
        L6:
            int r103 = (Integer) this.f235926a.get(((g) r101).f240259c);
            if (r103 != null) goto L11;
            r103 = Integer.MAX_VALUE;
        L11:
            return ComparisonsKt.compareValues(r102, r103);
        }
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f235927a;

        public b(a r100) {
            this.f235927a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f235927a.compare(r100, r101);
            if (r102 == 0) goto L6;
            return r102;
        L6:
            return ComparisonsKt.compareValues(Integer.valueOf(((g) r100).f240260d), Integer.valueOf(((g) r101).f240260d));
        }
    }

    static {
    }

    public static String c(b0 r100) {
        int r101 = r100.f235724b;
        switch(r101) {
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
        switch(r101) {
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
        return "download";
    L14:
        return "share";
    L15:
        return ShareChannel.ASK_DOUBAO;
    }

    public static List a(d r100, List r101, List r102) {
        Intrinsics.checkNotNullParameter(r101, "mainSpecs");
        Intrinsics.checkNotNullParameter(r102, "moreSpecs");
        if (r100 != null) goto L5;
        return null;
    L5:
        e r103 = r100.a("list_context");
        if (r103 != null) goto L9;
        return null;
    L9:
        if ((!r103.f240251b) == true) goto L11;
        LinkedHashMap r104 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r101, 10)), 16));
        Iterator r105 = r101.iterator();
    L14:
        if (r105.hasNext() == false) goto L16;
        Object r106 = r105.next();
        r104.put(c((b0) r106), r106);
        goto L14
    L16:
        LinkedHashMap r107 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r102, 10)), 16));
        Iterator r108 = r102.iterator();
    L18:
        if (r108.hasNext() == false) goto L21;
        Object r109 = r108.next();
        r107.put(c((b0) r109), r109);
        goto L18
    L21:
        return b(r103, r104, MapsKt.mapOf(TuplesKt.to("list_context_more", b(r100.a("list_context_more"), r107, MapsKt.emptyMap()))));
    L11:
        return CollectionsKt.emptyList();
    }

    public static List b(e r100, final Map r101, final Map r102) {
        if (r100 == null) goto L23;
        if ((!r100.f240251b) == true) goto L23;
        List<f> r103 = r100.f240252c;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L8:
        if (r105.hasNext() == false) goto L12;
        Object r106 = r105.next();
        if (((f) r106).f240255b == false) goto L8;
        r104.add(r106);
        goto L8
    L12:
        final LinkedHashMap r107 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r104, 10)), 16));
        Iterator r108 = r104.iterator();
    L14:
        if (r108.hasNext() == false) goto L16;
        Object r109 = r108.next();
        r107.put(((f) r109).f240254a, r109);
        goto L14
    L16:
        LinkedHashMap r110 = new LinkedHashMap(MapsKt.mapCapacity(r107.size()));
        Iterator r111 = r107.entrySet().iterator();
    L18:
        if (r111.hasNext() == false) goto L21;
        Map.Entry r112 = (Map.Entry) r111.next();
        r110.put(r112.getKey(), Integer.valueOf(((f) r112.getValue()).f240256c));
        goto L18
    L21:
        return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(SequencesKt.filter(SequencesKt.filter(CollectionsKt.asSequence(r100.f240253d), OfficeLongPressMenuConfigComposer$composeLeafItems$1.INSTANCE), new OfficeLongPressMenuConfigComposer$composeLeafItems$2(r107)), new b(new a(r110))), new OfficeLongPressMenuConfigComposer$composeLeafItems$5(r101, r102)));
    L23:
        return CollectionsKt.emptyList();
    }
}
