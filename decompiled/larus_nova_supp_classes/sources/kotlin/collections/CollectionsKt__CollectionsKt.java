package kotlin.collections;

import android.util.EventsUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aC\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u00072\u0006\u0010\f\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u00070\u000eH\u0087\bø\u0001\u0000\u001aC\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u00072\u0006\u0010\f\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u00070\u000eH\u0087\bø\u0001\u0000\u001a\u001f\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0015j\b\u0012\u0004\u0012\u0002H\u0007`\u0016\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a5\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0015j\b\u0012\u0004\u0012\u0002H\u0007`\u0016\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010\u0019\u001aN\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u001f\b\u0001\u0010\u001d\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u0013\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\u0002\b\u001fH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001aF\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\b\"\u0004\b\u0000\u0010\u001b2\u001f\b\u0001\u0010\u001d\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u0013\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\u0002\b\u001fH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a!\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u00182\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0002\u0010#\u001a3\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00070\u0018\"\u0004\b\u0000\u0010\u00072\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u00022\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0018H\u0000¢\u0006\u0002\u0010%\u001a\u0012\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007\u001a\u0015\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a+\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010(\u001a%\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\b\b\u0000\u0010\u0007*\u00020!2\b\u0010*\u001a\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010+\u001a3\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\b\b\u0000\u0010\u0007*\u00020!2\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00070\u0018\"\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010(\u001a\u0015\u0010,\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a+\u0010,\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010(\u001a%\u0010-\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H\u0002¢\u0006\u0002\b0\u001a\b\u00101\u001a\u00020\u001eH\u0001\u001a\b\u00102\u001a\u00020\u001eH\u0001\u001a%\u00103\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018H\u0000¢\u0006\u0002\u00104\u001aS\u00105\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\u0006\u0010*\u001a\u0002H\u00072\u001a\u00106\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000707j\n\u0012\u0006\b\u0000\u0012\u0002H\u0007`82\b\b\u0002\u0010.\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\u0006¢\u0006\u0002\u00109\u001a>\u00105\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\b\b\u0002\u0010.\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\u00062\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00060\u000e\u001aE\u00105\u001a\u00020\u0006\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070;*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\b2\b\u0010*\u001a\u0004\u0018\u0001H\u00072\b\b\u0002\u0010.\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\u0006¢\u0006\u0002\u0010<\u001ag\u0010=\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\u000e\b\u0001\u0010>*\b\u0012\u0004\u0012\u0002H>0;*\b\u0012\u0004\u0012\u0002H\u00070\b2\b\u0010?\u001a\u0004\u0018\u0001H>2\b\b\u0002\u0010.\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\u00062\u0016\b\u0004\u0010@\u001a\u0010\u0012\u0004\u0012\u0002H\u0007\u0012\u0006\u0012\u0004\u0018\u0001H>0\u000eH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010A\u001a,\u0010B\u001a\u00020C\"\t\b\u0000\u0010\u0007¢\u0006\u0002\bD*\b\u0012\u0004\u0012\u0002H\u00070\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002H\u0087\b\u001aH\u0010E\u001a\u0002HF\"\u0010\b\u0000\u0010G*\u0006\u0012\u0002\b\u00030\u0002*\u0002HF\"\u0004\b\u0001\u0010F*\u0002HG2\f\u0010H\u001a\b\u0012\u0004\u0012\u0002HF0IH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010J\u001a\u0019\u0010K\u001a\u00020C\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0002H\u0087\b\u001a,\u0010L\u001a\u00020C\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\u001e\u0010M\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\bH\u0000\u001a!\u0010N\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0002H\u0087\b\u001a!\u0010N\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\bH\u0087\b\u001a&\u0010O\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070P2\u0006\u0010Q\u001a\u00020RH\u0007\"\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"!\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006S"}, d2 = {"indices", "Lkotlin/ranges/IntRange;", XmlPullParser.NO_NAMESPACE, "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "lastIndex", XmlPullParser.NO_NAMESPACE, "T", XmlPullParser.NO_NAMESPACE, "getLastIndex", "(Ljava/util/List;)I", "List", "size", "init", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "MutableList", XmlPullParser.NO_NAMESPACE, "arrayListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "elements", XmlPullParser.NO_NAMESPACE, "([Ljava/lang/Object;)Ljava/util/ArrayList;", "buildList", "E", "capacity", "builderAction", XmlPullParser.NO_NAMESPACE, "Lkotlin/ExtensionFunctionType;", "collectionToArrayCommonImpl", XmlPullParser.NO_NAMESPACE, "collection", "(Ljava/util/Collection;)[Ljava/lang/Object;", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "emptyList", "listOf", "([Ljava/lang/Object;)Ljava/util/List;", "listOfNotNull", "element", "(Ljava/lang/Object;)Ljava/util/List;", "mutableListOf", "rangeCheck", "fromIndex", "toIndex", "rangeCheck$CollectionsKt__CollectionsKt", "throwCountOverflow", "throwIndexOverflow", "asCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "binarySearch", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "comparison", XmlPullParser.NO_NAMESPACE, "(Ljava/util/List;Ljava/lang/Comparable;II)I", "binarySearchBy", "K", "key", "selector", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "containsAll", XmlPullParser.NO_NAMESPACE, "Lkotlin/internal/OnlyInputTypes;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "isNullOrEmpty", "optimizeReadOnlyList", "orEmpty", "shuffled", XmlPullParser.NO_NAMESPACE, "random", "Lkotlin/random/Random;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_IOPRELOAD_DATA, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {
    public CollectionsKt__CollectionsKt() {
    }

    private static final <T> ArrayList<T> arrayListOf() {
        return new ArrayList();
    }

    private static final <T> List<T> mutableListOf() {
        return new ArrayList();
    }

    public static void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    private static final <T> List<T> listOf() {
        return CollectionsKt.emptyList();
    }

    public static <T> List<T> emptyList() {
        return EmptyList.INSTANCE;
    }

    public static <T> ArrayList<T> arrayListOf(T... r3) {
        Intrinsics.checkNotNullParameter(r3, "elements");
        if (r3.length != 0) goto L6;
        return new ArrayList();
    L6:
        return new ArrayList(new ArrayAsCollection(r3, true));
    }

    public static final <T> Collection<T> asCollection(T[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return new ArrayAsCollection(r2, false);
    }

    private static final <E> List<E> buildList(Function1<? super List<E>, Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "builderAction");
        List r0 = CollectionsKt.createListBuilder();
        r1.invoke(r0);
        return CollectionsKt.build(r0);
    }

    public static final Object[] collectionToArrayCommonImpl(Collection<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "collection");
        int r1 = 0;
        if (r4.isEmpty() == true) goto L5;
        Object[] r0 = new Object[r4.size()];
        Iterator<?> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        r0[r1] = r5.next();
        r1 = r1 + 1;
        goto L8
    L10:
        return r0;
    L5:
        return new Object[0];
    }

    public static IntRange getIndices(Collection<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return new IntRange(0, r2.size() - 1);
    }

    public static <T> int getLastIndex(List<? extends T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.size() - 1;
    }

    private static final <T> boolean isNotEmpty(Collection<? extends T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return !r1.isEmpty();
    }

    private static final <T> boolean isNullOrEmpty(Collection<? extends T> r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isEmpty() == true) goto L7;
        return false;
    }

    public static <T> List<T> listOf(T... r1) {
        Intrinsics.checkNotNullParameter(r1, "elements");
        if (r1.length <= 0) goto L6;
        return ArraysKt.asList(r1);
    L6:
        return CollectionsKt.emptyList();
    }

    public static <T> List<T> listOfNotNull(T r0) {
        if (r0 == null) goto L5;
        return CollectionsKt.listOf(r0);
    L5:
        return CollectionsKt.emptyList();
    }

    public static <T> List<T> mutableListOf(T... r3) {
        Intrinsics.checkNotNullParameter(r3, "elements");
        if (r3.length != 0) goto L6;
        return new ArrayList();
    L6:
        return new ArrayList(new ArrayAsCollection(r3, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r0 = r2.size();
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L10;
        return r2;
    L10:
        return CollectionsKt.listOf(ListProtector.get(r2, 0));
    L9:
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Collection<T> orEmpty(Collection<? extends T> r0) {
        if (r0 == 0) goto L4;
        return r0;
    L4:
        return CollectionsKt.emptyList();
    }

    public static <T> List<T> listOfNotNull(T... r1) {
        Intrinsics.checkNotNullParameter(r1, "elements");
        return ArraysKt.filterNotNull(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> List<T> orEmpty(List<? extends T> r0) {
        if (r0 == 0) goto L4;
        return r0;
    L4:
        return CollectionsKt.emptyList();
    }

    private static final <T> List<T> List(int r3, Function1<? super Integer, ? extends T> r4) {
        Intrinsics.checkNotNullParameter(r4, "init");
        ArrayList r0 = new ArrayList(r3);
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L5;
        r0.add(r4.invoke(Integer.valueOf(r1)));
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    private static final <T> List<T> MutableList(int r3, Function1<? super Integer, ? extends T> r4) {
        Intrinsics.checkNotNullParameter(r4, "init");
        ArrayList r0 = new ArrayList(r3);
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L5;
        r0.add(r4.invoke(Integer.valueOf(r1)));
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    private static final <E> List<E> buildList(int r1, Function1<? super List<E>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "builderAction");
        List r3 = CollectionsKt.createListBuilder(r1);
        r2.invoke(r3);
        return CollectionsKt.build(r3);
    }

    public static final <T> T[] collectionToArrayCommonImpl(Collection<?> r4, T[] r5) {
        Intrinsics.checkNotNullParameter(r4, "collection");
        Intrinsics.checkNotNullParameter(r5, "array");
        int r1 = 0;
        if (r4.isEmpty() == true) goto L5;
        int r0 = r5.length;
        Object[] r6 = r5;
        if (r0 >= r4.size()) goto L9;
        r6 = (T[]) ArraysKt__ArraysJVMKt.arrayOfNulls(r5, r4.size());
    L9:
        Iterator<?> r2 = r4.iterator();
    L11:
        if (r2.hasNext() == false) goto L14;
        r6[r1] = r2.next();
        r1 = r1 + 1;
        goto L11
    L14:
        return (T[]) CollectionsKt.terminateCollectionToArray(r4.size(), r6);
    L5:
        return (T[]) CollectionsKt.terminateCollectionToArray(0, r5);
    }

    private static final <T> boolean containsAll(Collection<? extends T> r1, Collection<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "elements");
        return r1.containsAll(r2);
    }

    /* JADX WARN: Incorrect types in method signature: <C::Ljava/util/Collection<*>;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    private static final Object ifEmpty(Collection r1, Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "defaultValue");
        if (r1.isEmpty() == true) goto L5;
        return r1;
    L5:
        return r2.invoke();
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> r1, Random r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "random");
        List<T> r3 = CollectionsKt.toMutableList(r1);
        CollectionsKt___CollectionsKt.shuffle(r3, r2);
        return r3;
    }

    private static final void rangeCheck$CollectionsKt__CollectionsKt(int r3, int r4, int r5) {
        if (r4 > r5) goto L12;
        if (r4 < 0) goto L10;
        if (r5 > r3) goto L8;
        return;
    L8:
        throw new IndexOutOfBoundsException("toIndex (" + r5 + ") is greater than size (" + r3 + ").");
    L10:
        throw new IndexOutOfBoundsException("fromIndex (" + r4 + ") is less than zero.");
    L12:
        throw new IllegalArgumentException("fromIndex (" + r4 + ") is greater than toIndex (" + r5 + ").");
    }

    public static <T> int binarySearch(List<? extends T> r2, int r3, int r4, Function1<? super T, Integer> r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r5, "comparison");
        rangeCheck$CollectionsKt__CollectionsKt(r2.size(), r3, r4);
        int r6 = r4 - 1;
    L3:
        if (r3 > r6) goto L11;
        int r0 = (r3 + r6) >>> 1;
        int r1 = r5.invoke((Object) ListProtector.get(r2, r0)).intValue();
        if (r1 < 0) goto L6;
        if (r1 <= 0) goto L9;
        r6 = r0 - 1;
        goto L3
    L9:
        return r0;
    L6:
        r3 = r0 + 1;
        goto L3
    L11:
        return -(r3 + 1);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(List<? extends T> r2, T r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        rangeCheck$CollectionsKt__CollectionsKt(r2.size(), r4, r5);
        int r6 = r5 - 1;
    L3:
        if (r4 > r6) goto L11;
        int r0 = (r4 + r6) >>> 1;
        int r1 = ComparisonsKt.compareValues((Comparable) ListProtector.get(r2, r0), r3);
        if (r1 < 0) goto L6;
        if (r1 <= 0) goto L9;
        r6 = r0 - 1;
        goto L3
    L9:
        return r0;
    L6:
        r4 = r0 + 1;
        goto L3
    L11:
        return -(r4 + 1);
    }

    public static final <T> int binarySearch(List<? extends T> r2, T r3, Comparator<? super T> r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "comparator");
        rangeCheck$CollectionsKt__CollectionsKt(r2.size(), r5, r6);
        int r7 = r6 - 1;
    L3:
        if (r5 > r7) goto L11;
        int r0 = (r5 + r7) >>> 1;
        int r1 = r4.compare((Object) ListProtector.get(r2, r0), r3);
        if (r1 < 0) goto L6;
        if (r1 <= 0) goto L9;
        r7 = r0 - 1;
        goto L3
    L9:
        return r0;
    L6:
        r5 = r0 + 1;
        goto L3
    L11:
        return -(r5 + 1);
    }

    public static final <T, K extends Comparable<? super K>> int binarySearchBy(List<? extends T> r1, K r2, int r3, int r4, Function1<? super T, ? extends K> r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r5, "selector");
        return CollectionsKt.binarySearch(r1, r3, r4, new binarySearchBy.1(r5, r2));
    }

    public static /* synthetic */ int binarySearch$default(List r0, int r1, int r2, Function1 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.size();
    L9:
        return CollectionsKt.binarySearch(r0, r1, r2, r3);
    }

    public static /* synthetic */ int binarySearch$default(List r0, Comparable r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = r0.size();
    L9:
        return binarySearch(r0, r1, r2, r3);
    }

    public static /* synthetic */ int binarySearch$default(List r0, Object r1, Comparator r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 8) == 0) goto L9;
        r4 = r0.size();
    L9:
        return binarySearch(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ int binarySearchBy$default(List r0, Comparable r1, int r2, int r3, Function1 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r3 = r0.size();
    L8:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r4, "selector");
        return CollectionsKt.binarySearch(r0, r2, r3, new binarySearchBy.1(r4, r1));
    }
}
