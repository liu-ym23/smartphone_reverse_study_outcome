package kotlin.collections;

import android.util.EventsUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"kotlin/collections/CollectionsKt__CollectionsJVMKt", "kotlin/collections/CollectionsKt__CollectionsKt", "kotlin/collections/CollectionsKt__IterablesKt", "kotlin/collections/CollectionsKt__IteratorsJVMKt", "kotlin/collections/CollectionsKt__IteratorsKt", "kotlin/collections/CollectionsKt__MutableCollectionsJVMKt", "kotlin/collections/CollectionsKt__MutableCollectionsKt", "kotlin/collections/CollectionsKt__ReversedViewsKt", "kotlin/collections/CollectionsKt___CollectionsJvmKt", "kotlin/collections/CollectionsKt___CollectionsKt"}, k = 4, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_IOPRELOAD_DATA)
public final class CollectionsKt extends CollectionsKt___CollectionsKt {
    public static /* bridge */ /* synthetic */ boolean addAll(Collection r0, Iterable r1) {
        return CollectionsKt__MutableCollectionsKt.addAll(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean addAll(Collection r0, Sequence r1) {
        return CollectionsKt__MutableCollectionsKt.addAll(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean addAll(Collection r0, Object[] r1) {
        return CollectionsKt__MutableCollectionsKt.addAll(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean all(Iterable r0, Function1 r1) {
        return CollectionsKt___CollectionsKt.all(r0, r1);
    }

    public static /* bridge */ /* synthetic */ ArrayList arrayListOf(Object... r0) {
        return CollectionsKt__CollectionsKt.arrayListOf(r0);
    }

    public static /* bridge */ /* synthetic */ List asReversed(List r0) {
        return CollectionsKt__ReversedViewsKt.asReversed(r0);
    }

    public static /* bridge */ /* synthetic */ List asReversedMutable(List r0) {
        return CollectionsKt__ReversedViewsKt.asReversedMutable(r0);
    }

    public static /* bridge */ /* synthetic */ Sequence asSequence(Iterable r0) {
        return CollectionsKt___CollectionsKt.asSequence(r0);
    }

    public static /* bridge */ /* synthetic */ double averageOfDouble(Iterable r2) {
        return CollectionsKt___CollectionsKt.averageOfDouble(r2);
    }

    public static /* bridge */ /* synthetic */ double averageOfFloat(Iterable r2) {
        return CollectionsKt___CollectionsKt.averageOfFloat(r2);
    }

    public static /* bridge */ /* synthetic */ double averageOfInt(Iterable r2) {
        return CollectionsKt___CollectionsKt.averageOfInt(r2);
    }

    public static /* bridge */ /* synthetic */ double averageOfLong(Iterable r2) {
        return CollectionsKt___CollectionsKt.averageOfLong(r2);
    }

    public static /* bridge */ /* synthetic */ int binarySearch(List r0, int r1, int r2, Function1 r3) {
        return CollectionsKt__CollectionsKt.binarySearch(r0, r1, r2, r3);
    }

    public static /* bridge */ /* synthetic */ int binarySearch$default(List r0, int r1, int r2, Function1 r3, int r4, Object r5) {
        return CollectionsKt__CollectionsKt.binarySearch$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ int binarySearch$default(List r0, Comparable r1, int r2, int r3, int r4, Object r5) {
        return CollectionsKt__CollectionsKt.binarySearch$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ List build(List r0) {
        return CollectionsKt__CollectionsJVMKt.build(r0);
    }

    public static /* bridge */ /* synthetic */ List chunked(Iterable r0, int r1) {
        return CollectionsKt___CollectionsKt.chunked(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List chunked(Iterable r0, int r1, Function1 r2) {
        return CollectionsKt___CollectionsKt.chunked(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ int collectionSizeOrDefault(Iterable r0, int r1) {
        return CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean contains(Iterable r0, Object r1) {
        return CollectionsKt___CollectionsKt.contains(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Collection convertToListIfNotCollection(Iterable r0) {
        return CollectionsKt__MutableCollectionsKt.convertToListIfNotCollection(r0);
    }

    public static /* bridge */ /* synthetic */ int count(Iterable r0) {
        return CollectionsKt___CollectionsKt.count(r0);
    }

    public static /* bridge */ /* synthetic */ List createListBuilder() {
        return CollectionsKt__CollectionsJVMKt.createListBuilder();
    }

    public static /* bridge */ /* synthetic */ List createListBuilder(int r0) {
        return CollectionsKt__CollectionsJVMKt.createListBuilder(r0);
    }

    public static /* bridge */ /* synthetic */ List distinct(Iterable r0) {
        return CollectionsKt___CollectionsKt.distinct(r0);
    }

    public static /* bridge */ /* synthetic */ List drop(Iterable r0, int r1) {
        return CollectionsKt___CollectionsKt.drop(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List dropLast(List r0, int r1) {
        return CollectionsKt___CollectionsKt.dropLast(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Object elementAt(Iterable r0, int r1) {
        return CollectionsKt___CollectionsKt.elementAt(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Object elementAtOrNull(Iterable r0, int r1) {
        return CollectionsKt___CollectionsKt.elementAtOrNull(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List emptyList() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static /* bridge */ /* synthetic */ List filter(Iterable r0, Function1 r1) {
        return CollectionsKt___CollectionsKt.filter(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List filterIsInstance(Iterable r0, Class r1) {
        return CollectionsKt___CollectionsJvmKt.filterIsInstance(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List filterNotNull(Iterable r0) {
        return CollectionsKt___CollectionsKt.filterNotNull(r0);
    }

    public static /* bridge */ /* synthetic */ Collection filterNotNullTo(Iterable r0, Collection r1) {
        return CollectionsKt___CollectionsKt.filterNotNullTo(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Object first(Iterable r0) {
        return CollectionsKt___CollectionsKt.first(r0);
    }

    public static /* bridge */ /* synthetic */ Object first(List r0) {
        return CollectionsKt___CollectionsKt.first(r0);
    }

    public static /* bridge */ /* synthetic */ Object firstOrNull(Iterable r0) {
        return CollectionsKt___CollectionsKt.firstOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Object firstOrNull(List r0) {
        return CollectionsKt___CollectionsKt.firstOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ List flatten(Iterable r0) {
        return CollectionsKt__IterablesKt.flatten(r0);
    }

    public static /* bridge */ /* synthetic */ IntRange getIndices(Collection r0) {
        return CollectionsKt__CollectionsKt.getIndices(r0);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(List r0) {
        return CollectionsKt__CollectionsKt.getLastIndex(r0);
    }

    public static /* bridge */ /* synthetic */ Object getOrNull(List r0, int r1) {
        return CollectionsKt___CollectionsKt.getOrNull(r0, r1);
    }

    public static /* bridge */ /* synthetic */ int indexOf(Iterable r0, Object r1) {
        return CollectionsKt___CollectionsKt.indexOf(r0, r1);
    }

    public static /* bridge */ /* synthetic */ int indexOf(List r0, Object r1) {
        return CollectionsKt___CollectionsKt.indexOf(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Set intersect(Iterable r0, Iterable r1) {
        return CollectionsKt___CollectionsKt.intersect(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Iterator iterator(Enumeration r0) {
        return CollectionsKt__IteratorsJVMKt.iterator(r0);
    }

    public static /* bridge */ /* synthetic */ Appendable joinTo$default(Iterable r0, Appendable r1, CharSequence r2, CharSequence r3, CharSequence r4, int r5, CharSequence r6, Function1 r7, int r8, Object r9) {
        return CollectionsKt___CollectionsKt.joinTo$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* bridge */ /* synthetic */ String joinToString(Iterable r0, CharSequence r1, CharSequence r2, CharSequence r3, int r4, CharSequence r5, Function1 r6) {
        return CollectionsKt___CollectionsKt.joinToString(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(Iterable r0, CharSequence r1, CharSequence r2, CharSequence r3, int r4, CharSequence r5, Function1 r6, int r7, Object r8) {
        return CollectionsKt___CollectionsKt.joinToString$default(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* bridge */ /* synthetic */ Object last(Iterable r0) {
        return CollectionsKt___CollectionsKt.last(r0);
    }

    public static /* bridge */ /* synthetic */ Object last(List r0) {
        return CollectionsKt___CollectionsKt.last(r0);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf(List r0, Object r1) {
        return CollectionsKt___CollectionsKt.lastIndexOf(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Object lastOrNull(Iterable r0) {
        return CollectionsKt___CollectionsKt.lastOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Object lastOrNull(List r0) {
        return CollectionsKt___CollectionsKt.lastOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ List listOf(Object r0) {
        return CollectionsKt__CollectionsJVMKt.listOf(r0);
    }

    public static /* bridge */ /* synthetic */ List listOf(Object... r0) {
        return CollectionsKt__CollectionsKt.listOf(r0);
    }

    public static /* bridge */ /* synthetic */ List listOfNotNull(Object r0) {
        return CollectionsKt__CollectionsKt.listOfNotNull(r0);
    }

    public static /* bridge */ /* synthetic */ List listOfNotNull(Object... r0) {
        return CollectionsKt__CollectionsKt.listOfNotNull(r0);
    }

    public static /* bridge */ /* synthetic */ List map(Iterable r0, Function1 r1) {
        return CollectionsKt___CollectionsKt.map(r0, r1);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static /* bridge */ /* synthetic */ Comparable max(Iterable r0) {
        return CollectionsKt___CollectionsJvmKt.max(r0);
    }

    public static /* bridge */ /* synthetic */ Comparable maxOrNull(Iterable r0) {
        return CollectionsKt___CollectionsKt.maxOrNull(r0);
    }

    /* JADX INFO: renamed from: maxOrNull, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Double m131maxOrNull(Iterable r0) {
        return CollectionsKt___CollectionsKt.m144maxOrNull(r0);
    }

    /* JADX INFO: renamed from: maxOrNull, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Float m132maxOrNull(Iterable r0) {
        return CollectionsKt___CollectionsKt.m145maxOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ double maxOrThrow(Iterable r2) {
        return CollectionsKt___CollectionsKt.maxOrThrow(r2);
    }

    public static /* bridge */ /* synthetic */ Object maxWithOrNull(Iterable r0, Comparator r1) {
        return CollectionsKt___CollectionsKt.maxWithOrNull(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Comparable minOrNull(Iterable r0) {
        return CollectionsKt___CollectionsKt.minOrNull(r0);
    }

    /* JADX INFO: renamed from: minOrNull, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Double m133minOrNull(Iterable r0) {
        return CollectionsKt___CollectionsKt.m152minOrNull(r0);
    }

    /* JADX INFO: renamed from: minOrNull, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Float m134minOrNull(Iterable r0) {
        return CollectionsKt___CollectionsKt.m153minOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ double minOrThrow(Iterable r2) {
        return CollectionsKt___CollectionsKt.minOrThrow(r2);
    }

    /* JADX INFO: renamed from: minOrThrow, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Comparable m135minOrThrow(Iterable r0) {
        return CollectionsKt___CollectionsKt.m155minOrThrow(r0);
    }

    public static /* bridge */ /* synthetic */ Object minWithOrNull(Iterable r0, Comparator r1) {
        return CollectionsKt___CollectionsKt.minWithOrNull(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List minus(Iterable r0, Iterable r1) {
        return CollectionsKt___CollectionsKt.minus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List minus(Iterable r0, Object r1) {
        return CollectionsKt___CollectionsKt.minus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List mutableListOf(Object... r0) {
        return CollectionsKt__CollectionsKt.mutableListOf(r0);
    }

    public static /* bridge */ /* synthetic */ List plus(Iterable r0, Iterable r1) {
        return CollectionsKt___CollectionsKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List plus(Iterable r0, Object r1) {
        return CollectionsKt___CollectionsKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List plus(Collection r0, Iterable r1) {
        return CollectionsKt___CollectionsKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List plus(Collection r0, Object r1) {
        return CollectionsKt___CollectionsKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List plus(Collection r0, Object[] r1) {
        return CollectionsKt___CollectionsKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Object random(Collection r0, Random r1) {
        return CollectionsKt___CollectionsKt.random(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Object randomOrNull(Collection r0, Random r1) {
        return CollectionsKt___CollectionsKt.randomOrNull(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean removeAll(Iterable r0, Function1 r1) {
        return CollectionsKt__MutableCollectionsKt.removeAll(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean removeAll(Collection r0, Iterable r1) {
        return CollectionsKt__MutableCollectionsKt.removeAll(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean removeAll(Collection r0, Sequence r1) {
        return CollectionsKt__MutableCollectionsKt.removeAll(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean removeAll(Collection r0, Object[] r1) {
        return CollectionsKt__MutableCollectionsKt.removeAll(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean removeAll(List r0, Function1 r1) {
        return CollectionsKt__MutableCollectionsKt.removeAll(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Object removeFirst(List r0) {
        return CollectionsKt__MutableCollectionsKt.removeFirst(r0);
    }

    public static /* bridge */ /* synthetic */ Object removeFirstOrNull(List r0) {
        return CollectionsKt__MutableCollectionsKt.removeFirstOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Object removeLast(List r0) {
        return CollectionsKt__MutableCollectionsKt.removeLast(r0);
    }

    public static /* bridge */ /* synthetic */ Object removeLastOrNull(List r0) {
        return CollectionsKt__MutableCollectionsKt.removeLastOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ boolean retainAll(Iterable r0, Function1 r1) {
        return CollectionsKt__MutableCollectionsKt.retainAll(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean retainAll(Collection r0, Iterable r1) {
        return CollectionsKt__MutableCollectionsKt.retainAll(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean retainAll(List r0, Function1 r1) {
        return CollectionsKt__MutableCollectionsKt.retainAll(r0, r1);
    }

    public static /* bridge */ /* synthetic */ void reverse(List r0) {
        CollectionsKt___CollectionsJvmKt.reverse(r0);
    }

    public static /* bridge */ /* synthetic */ List reversed(Iterable r0) {
        return CollectionsKt___CollectionsKt.reversed(r0);
    }

    public static /* bridge */ /* synthetic */ List shuffled(Iterable r0) {
        return CollectionsKt__CollectionsJVMKt.shuffled(r0);
    }

    public static /* bridge */ /* synthetic */ List shuffled(Iterable r0, java.util.Random r1) {
        return CollectionsKt__CollectionsJVMKt.shuffled(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Object single(Iterable r0) {
        return CollectionsKt___CollectionsKt.single(r0);
    }

    public static /* bridge */ /* synthetic */ Object single(List r0) {
        return CollectionsKt___CollectionsKt.single(r0);
    }

    public static /* bridge */ /* synthetic */ Object singleOrNull(Iterable r0) {
        return CollectionsKt___CollectionsKt.singleOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Object singleOrNull(List r0) {
        return CollectionsKt___CollectionsKt.singleOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ List slice(List r0, IntRange r1) {
        return CollectionsKt___CollectionsKt.slice(r0, r1);
    }

    public static /* bridge */ /* synthetic */ void sort(List r0) {
        CollectionsKt__MutableCollectionsJVMKt.sort(r0);
    }

    public static /* bridge */ /* synthetic */ void sortDescending(List r0) {
        CollectionsKt___CollectionsKt.sortDescending(r0);
    }

    public static /* bridge */ /* synthetic */ void sortWith(List r0, Comparator r1) {
        CollectionsKt__MutableCollectionsJVMKt.sortWith(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List sorted(Iterable r0) {
        return CollectionsKt___CollectionsKt.sorted(r0);
    }

    public static /* bridge */ /* synthetic */ List sortedDescending(Iterable r0) {
        return CollectionsKt___CollectionsKt.sortedDescending(r0);
    }

    public static /* bridge */ /* synthetic */ List sortedWith(Iterable r0, Comparator r1) {
        return CollectionsKt___CollectionsKt.sortedWith(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Set subtract(Iterable r0, Iterable r1) {
        return CollectionsKt___CollectionsKt.subtract(r0, r1);
    }

    public static /* bridge */ /* synthetic */ double sumOfDouble(Iterable r2) {
        return CollectionsKt___CollectionsKt.sumOfDouble(r2);
    }

    public static /* bridge */ /* synthetic */ float sumOfFloat(Iterable r0) {
        return CollectionsKt___CollectionsKt.sumOfFloat(r0);
    }

    public static /* bridge */ /* synthetic */ int sumOfInt(Iterable r0) {
        return CollectionsKt___CollectionsKt.sumOfInt(r0);
    }

    public static /* bridge */ /* synthetic */ long sumOfLong(Iterable r2) {
        return CollectionsKt___CollectionsKt.sumOfLong(r2);
    }

    public static /* bridge */ /* synthetic */ List take(Iterable r0, int r1) {
        return CollectionsKt___CollectionsKt.take(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List takeLast(List r0, int r1) {
        return CollectionsKt___CollectionsKt.takeLast(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Object[] terminateCollectionToArray(int r0, Object[] r1) {
        return CollectionsKt__CollectionsJVMKt.terminateCollectionToArray(r0, r1);
    }

    public static /* bridge */ /* synthetic */ void throwCountOverflow() {
        CollectionsKt__CollectionsKt.throwCountOverflow();
    }

    public static /* bridge */ /* synthetic */ void throwIndexOverflow() {
        CollectionsKt__CollectionsKt.throwIndexOverflow();
    }

    public static /* bridge */ /* synthetic */ boolean[] toBooleanArray(Collection r0) {
        return CollectionsKt___CollectionsKt.toBooleanArray(r0);
    }

    public static /* bridge */ /* synthetic */ byte[] toByteArray(Collection r0) {
        return CollectionsKt___CollectionsKt.toByteArray(r0);
    }

    public static /* bridge */ /* synthetic */ char[] toCharArray(Collection r0) {
        return CollectionsKt___CollectionsKt.toCharArray(r0);
    }

    public static /* bridge */ /* synthetic */ Collection toCollection(Iterable r0, Collection r1) {
        return CollectionsKt___CollectionsKt.toCollection(r0, r1);
    }

    public static /* bridge */ /* synthetic */ double[] toDoubleArray(Collection r0) {
        return CollectionsKt___CollectionsKt.toDoubleArray(r0);
    }

    public static /* bridge */ /* synthetic */ float[] toFloatArray(Collection r0) {
        return CollectionsKt___CollectionsKt.toFloatArray(r0);
    }

    public static /* bridge */ /* synthetic */ HashSet toHashSet(Iterable r0) {
        return CollectionsKt___CollectionsKt.toHashSet(r0);
    }

    public static /* bridge */ /* synthetic */ int[] toIntArray(Collection r0) {
        return CollectionsKt___CollectionsKt.toIntArray(r0);
    }

    public static /* bridge */ /* synthetic */ List toList(Iterable r0) {
        return CollectionsKt___CollectionsKt.toList(r0);
    }

    public static /* bridge */ /* synthetic */ long[] toLongArray(Collection r0) {
        return CollectionsKt___CollectionsKt.toLongArray(r0);
    }

    public static /* bridge */ /* synthetic */ List toMutableList(Iterable r0) {
        return CollectionsKt___CollectionsKt.toMutableList(r0);
    }

    public static /* bridge */ /* synthetic */ List toMutableList(Collection r0) {
        return CollectionsKt___CollectionsKt.toMutableList(r0);
    }

    public static /* bridge */ /* synthetic */ Set toMutableSet(Iterable r0) {
        return CollectionsKt___CollectionsKt.toMutableSet(r0);
    }

    public static /* bridge */ /* synthetic */ Set toSet(Iterable r0) {
        return CollectionsKt___CollectionsKt.toSet(r0);
    }

    public static /* bridge */ /* synthetic */ SortedSet toSortedSet(Iterable r0) {
        return CollectionsKt___CollectionsJvmKt.toSortedSet(r0);
    }

    public static /* bridge */ /* synthetic */ Set union(Iterable r0, Iterable r1) {
        return CollectionsKt___CollectionsKt.union(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List windowed$default(Iterable r0, int r1, int r2, boolean r3, int r4, Object r5) {
        return CollectionsKt___CollectionsKt.windowed$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ List windowed$default(Iterable r0, int r1, int r2, boolean r3, Function1 r4, int r5, Object r6) {
        return CollectionsKt___CollectionsKt.windowed$default(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* bridge */ /* synthetic */ Iterable withIndex(Iterable r0) {
        return CollectionsKt___CollectionsKt.withIndex(r0);
    }

    public static /* bridge */ /* synthetic */ Iterator withIndex(Iterator r0) {
        return CollectionsKt__IteratorsKt.withIndex(r0);
    }

    public static /* bridge */ /* synthetic */ List zip(Iterable r0, Iterable r1) {
        return CollectionsKt___CollectionsKt.zip(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List zip(Iterable r0, Object[] r1) {
        return CollectionsKt___CollectionsKt.zip(r0, r1);
    }

    private CollectionsKt() {
    }
}
