package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import defpackage.DeepThinkTopHeaderComponent$runCollapseAnimation$2;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u009e\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052b\u0010\u0006\u001a^\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\bø\u0001\u0000\u001a·\u0001\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102b\u0010\u0006\u001a^\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aI\u0010\u0014\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0016\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00150\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u0010H\u0007¢\u0006\u0002\u0010\u0016\u001a¿\u0001\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u000526\u0010\u0018\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u00192K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u001aH\u0087\bø\u0001\u0000\u001a\u007f\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u001b\u001a\u0002H\u000326\u0010\u0006\u001a2\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u0019H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001aØ\u0001\u0010\u001d\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u001026\u0010\u0018\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u00192K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u001aH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a\u0093\u0001\u0010\u001d\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102\u0006\u0010\u001b\u001a\u0002H\u000326\u0010\u0006\u001a2\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u0019H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001f\u001a\u008b\u0001\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0\u0001\"\u0004\b\u0000\u0010!\"\b\b\u0001\u0010\u0004*\u0002H!\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H!¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H!0\u001aH\u0087\bø\u0001\u0000\u001a¤\u0001\u0010\"\u001a\u0002H\u0010\"\u0004\b\u0000\u0010!\"\b\b\u0001\u0010\u0004*\u0002H!\"\u0004\b\u0002\u0010\u0002\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H!¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H!0\u001aH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010#\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2 = {"aggregate", "", "K", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/Grouping;", WikiFolderPushPlugin.OPT, "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "key", "accumulator", "element", "", SoloKtvContext.SOLO_PAGE_FIRST, "aggregateTo", "M", "", a.KEY_DESTINATION, "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function4;)Ljava/util/Map;", "eachCountTo", "", "(Lkotlin/collections/Grouping;Ljava/util/Map;)Ljava/util/Map;", "fold", "initialValueSelector", "Lkotlin/Function2;", "Lkotlin/Function3;", "initialValue", "(Lkotlin/collections/Grouping;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "foldTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "(Lkotlin/collections/Grouping;Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "reduce", ExifInterface.LATITUDE_SOUTH, "reduceTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/GroupingKt")
class GroupingKt__GroupingKt extends GroupingKt__GroupingJVMKt {
    public GroupingKt__GroupingKt() {
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    public static final <T, K, R> Map<K, R> aggregate(Grouping<T, ? extends K> r100, Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<T> r103 = r100.sourceIterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        ?? r104 = r103.next();
        Object r105 = r100.keyOf(r104);
        DeepThinkTopHeaderComponent$runCollapseAnimation$2 r106 = (Object) r102.get(r105);
        if (r106 == null) goto L8;
    L10:
        boolean r107 = false;
    L11:
        r102.put(r105, r101.invoke(r105, r106, r104, Boolean.valueOf(r107)));
        goto L4
    L8:
        if (r102.containsKey(r105) == true) goto L10;
        r107 = true;
        goto L11
    L12:
        return r102;
    }

    public static final <T, K, M extends Map<? super K, Integer>> M eachCountTo(Grouping<T, ? extends K> r100, M r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, a.KEY_DESTINATION);
        Iterator<T> r102 = r100.sourceIterator();
    L4:
        if (r102.hasNext() == false) goto L14;
        K r103 = r100.keyOf(r102.next());
        Object r104 = r101.get(r103);
        if (r104 == null) goto L8;
    L10:
        boolean r105 = false;
    L11:
        if (r105 == false) goto L13;
        r104 = 0;
    L13:
        r101.put(r103, Integer.valueOf(((Number) r104).intValue() + 1));
        goto L4
    L8:
        if (r101.containsKey(r103) == true) goto L10;
        r105 = true;
        goto L11
    L14:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <S, T extends S, K> Map<K, S> reduce(Grouping<T, ? extends K> r100, Function3<? super K, ? super S, ? super T, ? extends S> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = r100.sourceIterator();
    L4:
        if (r103.hasNext() == false) goto L15;
        S r104 = (Object) r103.next();
        Object r105 = r100.keyOf(r104);
        DeepThinkTopHeaderComponent$runCollapseAnimation$2 r106 = (Object) r102.get(r105);
        if (r106 == null) goto L8;
    L10:
        boolean r107 = false;
    L11:
        if (r107 == true) goto L14;
        r104 = r101.invoke(r105, r106, r104);
    L14:
        r102.put(r105, r104);
        goto L4
    L8:
        if (r102.containsKey(r105) == true) goto L10;
        r107 = true;
        goto L11
    L15:
        return r102;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    public static final <T, K, R, M extends Map<? super K, R>> M aggregateTo(Grouping<T, ? extends K> r100, M r101, Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, a.KEY_DESTINATION);
        Intrinsics.checkNotNullParameter(r102, WikiFolderPushPlugin.OPT);
        Iterator<T> r103 = r100.sourceIterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        ?? r104 = r103.next();
        Object r105 = r100.keyOf(r104);
        DeepThinkTopHeaderComponent$runCollapseAnimation$2 r106 = (Object) r101.get(r105);
        if (r106 == null) goto L8;
    L10:
        boolean r107 = false;
    L11:
        r101.put(r105, r102.invoke(r105, r106, r104, Boolean.valueOf(r107)));
        goto L4
    L8:
        if (r101.containsKey(r105) == true) goto L10;
        r107 = true;
        goto L11
    L12:
        return r101;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    public static final <T, K, R> Map<K, R> fold(Grouping<T, ? extends K> r100, Function2<? super K, ? super T, ? extends R> r101, Function3<? super K, ? super R, ? super T, ? extends R> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "initialValueSelector");
        Intrinsics.checkNotNullParameter(r102, WikiFolderPushPlugin.OPT);
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<T> r104 = r100.sourceIterator();
    L4:
        if (r104.hasNext() == false) goto L14;
        ?? r105 = r104.next();
        Object r106 = r100.keyOf(r105);
        R r107 = (Object) r103.get(r106);
        if (r107 == null) goto L8;
    L10:
        boolean r108 = false;
    L11:
        if (r108 == false) goto L13;
        r107 = r101.invoke(r106, r105);
    L13:
        r103.put(r106, r102.invoke(r106, r107, r105));
        goto L4
    L8:
        if (r103.containsKey(r106) == true) goto L10;
        r108 = true;
        goto L11
    L14:
        return r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <S, T extends S, K, M extends Map<? super K, S>> M reduceTo(Grouping<T, ? extends K> r100, M r101, Function3<? super K, ? super S, ? super T, ? extends S> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, a.KEY_DESTINATION);
        Intrinsics.checkNotNullParameter(r102, WikiFolderPushPlugin.OPT);
        Iterator r103 = r100.sourceIterator();
    L4:
        if (r103.hasNext() == false) goto L15;
        S r104 = (Object) r103.next();
        Object r105 = r100.keyOf(r104);
        DeepThinkTopHeaderComponent$runCollapseAnimation$2 r106 = (Object) r101.get(r105);
        if (r106 == null) goto L8;
    L10:
        boolean r107 = false;
    L11:
        if (r107 == true) goto L14;
        r104 = r102.invoke(r105, r106, r104);
    L14:
        r101.put(r105, r104);
        goto L4
    L8:
        if (r101.containsKey(r105) == true) goto L10;
        r107 = true;
        goto L11
    L15:
        return r101;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    public static final <T, K, R> Map<K, R> fold(Grouping<T, ? extends K> r100, R r101, Function2<? super R, ? super T, ? extends R> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, WikiFolderPushPlugin.OPT);
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<T> r104 = r100.sourceIterator();
    L4:
        if (r104.hasNext() == false) goto L14;
        ?? r105 = r104.next();
        K r106 = r100.keyOf(r105);
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r107 = (Object) r103.get(r106);
        if (r107 == null) goto L8;
    L10:
        boolean r108 = false;
    L11:
        if (r108 == false) goto L13;
        r107 = (Object) r101;
    L13:
        r103.put(r106, r102.invoke(r107, r105));
        goto L4
    L8:
        if (r103.containsKey(r106) == true) goto L10;
        r108 = true;
        goto L11
    L14:
        return r103;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    public static final <T, K, R, M extends Map<? super K, R>> M foldTo(Grouping<T, ? extends K> r100, M r101, Function2<? super K, ? super T, ? extends R> r102, Function3<? super K, ? super R, ? super T, ? extends R> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, a.KEY_DESTINATION);
        Intrinsics.checkNotNullParameter(r102, "initialValueSelector");
        Intrinsics.checkNotNullParameter(r103, WikiFolderPushPlugin.OPT);
        Iterator<T> r104 = r100.sourceIterator();
    L4:
        if (r104.hasNext() == false) goto L14;
        ?? r105 = r104.next();
        Object r106 = r100.keyOf(r105);
        R r107 = (Object) r101.get(r106);
        if (r107 == null) goto L8;
    L10:
        boolean r108 = false;
    L11:
        if (r108 == false) goto L13;
        r107 = r102.invoke(r106, r105);
    L13:
        r101.put(r106, r103.invoke(r106, r107, r105));
        goto L4
    L8:
        if (r101.containsKey(r106) == true) goto L10;
        r108 = true;
        goto L11
    L14:
        return r101;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    public static final <T, K, R, M extends Map<? super K, R>> M foldTo(Grouping<T, ? extends K> r100, M r101, R r102, Function2<? super R, ? super T, ? extends R> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, a.KEY_DESTINATION);
        Intrinsics.checkNotNullParameter(r103, WikiFolderPushPlugin.OPT);
        Iterator<T> r104 = r100.sourceIterator();
    L4:
        if (r104.hasNext() == false) goto L14;
        ?? r105 = r104.next();
        K r106 = r100.keyOf(r105);
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r107 = (Object) r101.get(r106);
        if (r107 == null) goto L8;
    L10:
        boolean r108 = false;
    L11:
        if (r108 == false) goto L13;
        r107 = (Object) r102;
    L13:
        r101.put(r106, r103.invoke(r107, r105));
        goto L4
    L8:
        if (r101.containsKey(r106) == true) goto L10;
        r108 = true;
        goto L11
    L14:
        return r101;
    }
}
