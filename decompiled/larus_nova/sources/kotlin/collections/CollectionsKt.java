package kotlin.collections;

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

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"kotlin/collections/CollectionsKt__CollectionsJVMKt", "kotlin/collections/CollectionsKt__CollectionsKt", "kotlin/collections/CollectionsKt__IterablesKt", "kotlin/collections/CollectionsKt__IteratorsJVMKt", "kotlin/collections/CollectionsKt__IteratorsKt", "kotlin/collections/CollectionsKt__MutableCollectionsJVMKt", "kotlin/collections/CollectionsKt__MutableCollectionsKt", "kotlin/collections/CollectionsKt__ReversedViewsKt", "kotlin/collections/CollectionsKt___CollectionsJvmKt", "kotlin/collections/CollectionsKt___CollectionsKt"}, k = 4, mv = {1, 9, 0}, xi = 49)
public final class CollectionsKt extends CollectionsKt___CollectionsKt {
    public static /* bridge */ /* synthetic */ boolean addAll(Collection r100, Iterable r101) {
        return CollectionsKt__MutableCollectionsKt.addAll(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean addAll(Collection r100, Sequence r101) {
        return CollectionsKt__MutableCollectionsKt.addAll(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean addAll(Collection r100, Object[] r101) {
        return CollectionsKt__MutableCollectionsKt.addAll(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean all(Iterable r100, Function1 r101) {
        return CollectionsKt___CollectionsKt.all(r100, r101);
    }

    public static /* bridge */ /* synthetic */ ArrayList arrayListOf(Object... r100) {
        return CollectionsKt__CollectionsKt.arrayListOf(r100);
    }

    public static /* bridge */ /* synthetic */ List asReversed(List r100) {
        return CollectionsKt__ReversedViewsKt.asReversed(r100);
    }

    public static /* bridge */ /* synthetic */ List asReversedMutable(List r100) {
        return CollectionsKt__ReversedViewsKt.asReversedMutable(r100);
    }

    public static /* bridge */ /* synthetic */ Sequence asSequence(Iterable r100) {
        return CollectionsKt___CollectionsKt.asSequence(r100);
    }

    public static /* bridge */ /* synthetic */ double averageOfDouble(Iterable r100) {
        return CollectionsKt___CollectionsKt.averageOfDouble(r100);
    }

    public static /* bridge */ /* synthetic */ double averageOfFloat(Iterable r100) {
        return CollectionsKt___CollectionsKt.averageOfFloat(r100);
    }

    public static /* bridge */ /* synthetic */ double averageOfInt(Iterable r100) {
        return CollectionsKt___CollectionsKt.averageOfInt(r100);
    }

    public static /* bridge */ /* synthetic */ double averageOfLong(Iterable r100) {
        return CollectionsKt___CollectionsKt.averageOfLong(r100);
    }

    public static /* bridge */ /* synthetic */ int binarySearch(List r100, int r101, int r102, Function1 r103) {
        return CollectionsKt__CollectionsKt.binarySearch(r100, r101, r102, r103);
    }

    public static /* bridge */ /* synthetic */ int binarySearch$default(List r100, int r101, int r102, Function1 r103, int r104, Object r105) {
        return CollectionsKt__CollectionsKt.binarySearch$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ int binarySearch$default(List r100, Comparable r101, int r102, int r103, int r104, Object r105) {
        return CollectionsKt__CollectionsKt.binarySearch$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ List build(List r100) {
        return CollectionsKt__CollectionsJVMKt.build(r100);
    }

    public static /* bridge */ /* synthetic */ List chunked(Iterable r100, int r101) {
        return CollectionsKt___CollectionsKt.chunked(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List chunked(Iterable r100, int r101, Function1 r102) {
        return CollectionsKt___CollectionsKt.chunked(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ int collectionSizeOrDefault(Iterable r100, int r101) {
        return CollectionsKt__IterablesKt.collectionSizeOrDefault(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean contains(Iterable r100, Object r101) {
        return CollectionsKt___CollectionsKt.contains(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Collection convertToListIfNotCollection(Iterable r100) {
        return CollectionsKt__MutableCollectionsKt.convertToListIfNotCollection(r100);
    }

    public static /* bridge */ /* synthetic */ int count(Iterable r100) {
        return CollectionsKt___CollectionsKt.count(r100);
    }

    public static /* bridge */ /* synthetic */ List createListBuilder() {
        return CollectionsKt__CollectionsJVMKt.createListBuilder();
    }

    public static /* bridge */ /* synthetic */ List createListBuilder(int r100) {
        return CollectionsKt__CollectionsJVMKt.createListBuilder(r100);
    }

    public static /* bridge */ /* synthetic */ List distinct(Iterable r100) {
        return CollectionsKt___CollectionsKt.distinct(r100);
    }

    public static /* bridge */ /* synthetic */ List drop(Iterable r100, int r101) {
        return CollectionsKt___CollectionsKt.drop(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List dropLast(List r100, int r101) {
        return CollectionsKt___CollectionsKt.dropLast(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Object elementAt(Iterable r100, int r101) {
        return CollectionsKt___CollectionsKt.elementAt(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Object elementAtOrNull(Iterable r100, int r101) {
        return CollectionsKt___CollectionsKt.elementAtOrNull(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List emptyList() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static /* bridge */ /* synthetic */ List filter(Iterable r100, Function1 r101) {
        return CollectionsKt___CollectionsKt.filter(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List filterIsInstance(Iterable r100, Class r101) {
        return CollectionsKt___CollectionsJvmKt.filterIsInstance(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List filterNotNull(Iterable r100) {
        return CollectionsKt___CollectionsKt.filterNotNull(r100);
    }

    public static /* bridge */ /* synthetic */ Collection filterNotNullTo(Iterable r100, Collection r101) {
        return CollectionsKt___CollectionsKt.filterNotNullTo(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Object first(Iterable r100) {
        return CollectionsKt___CollectionsKt.first(r100);
    }

    public static /* bridge */ /* synthetic */ Object first(List r100) {
        return CollectionsKt___CollectionsKt.first(r100);
    }

    public static /* bridge */ /* synthetic */ Object firstOrNull(Iterable r100) {
        return CollectionsKt___CollectionsKt.firstOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Object firstOrNull(List r100) {
        return CollectionsKt___CollectionsKt.firstOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ List flatten(Iterable r100) {
        return CollectionsKt__IterablesKt.flatten(r100);
    }

    public static /* bridge */ /* synthetic */ IntRange getIndices(Collection r100) {
        return CollectionsKt__CollectionsKt.getIndices(r100);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(List r100) {
        return CollectionsKt__CollectionsKt.getLastIndex(r100);
    }

    public static /* bridge */ /* synthetic */ Object getOrNull(List r100, int r101) {
        return CollectionsKt___CollectionsKt.getOrNull(r100, r101);
    }

    public static /* bridge */ /* synthetic */ int indexOf(Iterable r100, Object r101) {
        return CollectionsKt___CollectionsKt.indexOf(r100, r101);
    }

    public static /* bridge */ /* synthetic */ int indexOf(List r100, Object r101) {
        return CollectionsKt___CollectionsKt.indexOf(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Set intersect(Iterable r100, Iterable r101) {
        return CollectionsKt___CollectionsKt.intersect(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Iterator iterator(Enumeration r100) {
        return CollectionsKt__IteratorsJVMKt.iterator(r100);
    }

    public static /* bridge */ /* synthetic */ Appendable joinTo$default(Iterable r100, Appendable r101, CharSequence r102, CharSequence r103, CharSequence r104, int r105, CharSequence r106, Function1 r107, int r108, Object r109) {
        return CollectionsKt___CollectionsKt.joinTo$default(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109);
    }

    public static /* bridge */ /* synthetic */ String joinToString(Iterable r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, Function1 r106) {
        return CollectionsKt___CollectionsKt.joinToString(r100, r101, r102, r103, r104, r105, r106);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(Iterable r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, Function1 r106, int r107, Object r108) {
        return CollectionsKt___CollectionsKt.joinToString$default(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }

    public static /* bridge */ /* synthetic */ Object last(Iterable r100) {
        return CollectionsKt___CollectionsKt.last(r100);
    }

    public static /* bridge */ /* synthetic */ Object last(List r100) {
        return CollectionsKt___CollectionsKt.last(r100);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf(List r100, Object r101) {
        return CollectionsKt___CollectionsKt.lastIndexOf(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Object lastOrNull(Iterable r100) {
        return CollectionsKt___CollectionsKt.lastOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Object lastOrNull(List r100) {
        return CollectionsKt___CollectionsKt.lastOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ List listOf(Object r100) {
        return CollectionsKt__CollectionsJVMKt.listOf(r100);
    }

    public static /* bridge */ /* synthetic */ List listOf(Object... r100) {
        return CollectionsKt__CollectionsKt.listOf(r100);
    }

    public static /* bridge */ /* synthetic */ List listOfNotNull(Object r100) {
        return CollectionsKt__CollectionsKt.listOfNotNull(r100);
    }

    public static /* bridge */ /* synthetic */ List listOfNotNull(Object... r100) {
        return CollectionsKt__CollectionsKt.listOfNotNull(r100);
    }

    public static /* bridge */ /* synthetic */ List map(Iterable r100, Function1 r101) {
        return CollectionsKt___CollectionsKt.map(r100, r101);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static /* bridge */ /* synthetic */ Comparable max(Iterable r100) {
        return CollectionsKt___CollectionsJvmKt.max(r100);
    }

    public static /* bridge */ /* synthetic */ Comparable maxOrNull(Iterable r100) {
        return CollectionsKt___CollectionsKt.maxOrNull(r100);
    }

    /* JADX INFO: renamed from: maxOrNull, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Double m9876maxOrNull(Iterable r100) {
        return CollectionsKt___CollectionsKt.m9889maxOrNull(r100);
    }

    /* JADX INFO: renamed from: maxOrNull, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Float m9877maxOrNull(Iterable r100) {
        return CollectionsKt___CollectionsKt.m9890maxOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ double maxOrThrow(Iterable r100) {
        return CollectionsKt___CollectionsKt.maxOrThrow(r100);
    }

    public static /* bridge */ /* synthetic */ Object maxWithOrNull(Iterable r100, Comparator r101) {
        return CollectionsKt___CollectionsKt.maxWithOrNull(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Comparable minOrNull(Iterable r100) {
        return CollectionsKt___CollectionsKt.minOrNull(r100);
    }

    /* JADX INFO: renamed from: minOrNull, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Double m9878minOrNull(Iterable r100) {
        return CollectionsKt___CollectionsKt.m9897minOrNull(r100);
    }

    /* JADX INFO: renamed from: minOrNull, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Float m9879minOrNull(Iterable r100) {
        return CollectionsKt___CollectionsKt.m9898minOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ double minOrThrow(Iterable r100) {
        return CollectionsKt___CollectionsKt.minOrThrow(r100);
    }

    /* JADX INFO: renamed from: minOrThrow, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Comparable m9880minOrThrow(Iterable r100) {
        return CollectionsKt___CollectionsKt.m9900minOrThrow(r100);
    }

    public static /* bridge */ /* synthetic */ Object minWithOrNull(Iterable r100, Comparator r101) {
        return CollectionsKt___CollectionsKt.minWithOrNull(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List minus(Iterable r100, Iterable r101) {
        return CollectionsKt___CollectionsKt.minus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List minus(Iterable r100, Object r101) {
        return CollectionsKt___CollectionsKt.minus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List mutableListOf(Object... r100) {
        return CollectionsKt__CollectionsKt.mutableListOf(r100);
    }

    public static /* bridge */ /* synthetic */ List plus(Iterable r100, Iterable r101) {
        return CollectionsKt___CollectionsKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List plus(Iterable r100, Object r101) {
        return CollectionsKt___CollectionsKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List plus(Collection r100, Iterable r101) {
        return CollectionsKt___CollectionsKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List plus(Collection r100, Object r101) {
        return CollectionsKt___CollectionsKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List plus(Collection r100, Object[] r101) {
        return CollectionsKt___CollectionsKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Object random(Collection r100, Random r101) {
        return CollectionsKt___CollectionsKt.random(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Object randomOrNull(Collection r100, Random r101) {
        return CollectionsKt___CollectionsKt.randomOrNull(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean removeAll(Iterable r100, Function1 r101) {
        return CollectionsKt__MutableCollectionsKt.removeAll(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean removeAll(Collection r100, Iterable r101) {
        return CollectionsKt__MutableCollectionsKt.removeAll(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean removeAll(Collection r100, Sequence r101) {
        return CollectionsKt__MutableCollectionsKt.removeAll(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean removeAll(Collection r100, Object[] r101) {
        return CollectionsKt__MutableCollectionsKt.removeAll(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean removeAll(List r100, Function1 r101) {
        return CollectionsKt__MutableCollectionsKt.removeAll(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Object removeFirst(List r100) {
        return CollectionsKt__MutableCollectionsKt.removeFirst(r100);
    }

    public static /* bridge */ /* synthetic */ Object removeFirstOrNull(List r100) {
        return CollectionsKt__MutableCollectionsKt.removeFirstOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Object removeLast(List r100) {
        return CollectionsKt__MutableCollectionsKt.removeLast(r100);
    }

    public static /* bridge */ /* synthetic */ Object removeLastOrNull(List r100) {
        return CollectionsKt__MutableCollectionsKt.removeLastOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ boolean retainAll(Iterable r100, Function1 r101) {
        return CollectionsKt__MutableCollectionsKt.retainAll(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean retainAll(Collection r100, Iterable r101) {
        return CollectionsKt__MutableCollectionsKt.retainAll(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean retainAll(List r100, Function1 r101) {
        return CollectionsKt__MutableCollectionsKt.retainAll(r100, r101);
    }

    public static /* bridge */ /* synthetic */ void reverse(List r100) {
        CollectionsKt___CollectionsJvmKt.reverse(r100);
    }

    public static /* bridge */ /* synthetic */ List reversed(Iterable r100) {
        return CollectionsKt___CollectionsKt.reversed(r100);
    }

    public static /* bridge */ /* synthetic */ List shuffled(Iterable r100) {
        return CollectionsKt__CollectionsJVMKt.shuffled(r100);
    }

    public static /* bridge */ /* synthetic */ List shuffled(Iterable r100, java.util.Random r101) {
        return CollectionsKt__CollectionsJVMKt.shuffled(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Object single(Iterable r100) {
        return CollectionsKt___CollectionsKt.single(r100);
    }

    public static /* bridge */ /* synthetic */ Object single(List r100) {
        return CollectionsKt___CollectionsKt.single(r100);
    }

    public static /* bridge */ /* synthetic */ Object singleOrNull(Iterable r100) {
        return CollectionsKt___CollectionsKt.singleOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Object singleOrNull(List r100) {
        return CollectionsKt___CollectionsKt.singleOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ List slice(List r100, IntRange r101) {
        return CollectionsKt___CollectionsKt.slice(r100, r101);
    }

    public static /* bridge */ /* synthetic */ void sort(List r100) {
        CollectionsKt__MutableCollectionsJVMKt.sort(r100);
    }

    public static /* bridge */ /* synthetic */ void sortDescending(List r100) {
        CollectionsKt___CollectionsKt.sortDescending(r100);
    }

    public static /* bridge */ /* synthetic */ void sortWith(List r100, Comparator r101) {
        CollectionsKt__MutableCollectionsJVMKt.sortWith(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List sorted(Iterable r100) {
        return CollectionsKt___CollectionsKt.sorted(r100);
    }

    public static /* bridge */ /* synthetic */ List sortedDescending(Iterable r100) {
        return CollectionsKt___CollectionsKt.sortedDescending(r100);
    }

    public static /* bridge */ /* synthetic */ List sortedWith(Iterable r100, Comparator r101) {
        return CollectionsKt___CollectionsKt.sortedWith(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Set subtract(Iterable r100, Iterable r101) {
        return CollectionsKt___CollectionsKt.subtract(r100, r101);
    }

    public static /* bridge */ /* synthetic */ double sumOfDouble(Iterable r100) {
        return CollectionsKt___CollectionsKt.sumOfDouble(r100);
    }

    public static /* bridge */ /* synthetic */ float sumOfFloat(Iterable r100) {
        return CollectionsKt___CollectionsKt.sumOfFloat(r100);
    }

    public static /* bridge */ /* synthetic */ int sumOfInt(Iterable r100) {
        return CollectionsKt___CollectionsKt.sumOfInt(r100);
    }

    public static /* bridge */ /* synthetic */ long sumOfLong(Iterable r100) {
        return CollectionsKt___CollectionsKt.sumOfLong(r100);
    }

    public static /* bridge */ /* synthetic */ List take(Iterable r100, int r101) {
        return CollectionsKt___CollectionsKt.take(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List takeLast(List r100, int r101) {
        return CollectionsKt___CollectionsKt.takeLast(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Object[] terminateCollectionToArray(int r100, Object[] r101) {
        return CollectionsKt__CollectionsJVMKt.terminateCollectionToArray(r100, r101);
    }

    public static /* bridge */ /* synthetic */ void throwCountOverflow() {
        CollectionsKt__CollectionsKt.throwCountOverflow();
    }

    public static /* bridge */ /* synthetic */ void throwIndexOverflow() {
        CollectionsKt__CollectionsKt.throwIndexOverflow();
    }

    public static /* bridge */ /* synthetic */ boolean[] toBooleanArray(Collection r100) {
        return CollectionsKt___CollectionsKt.toBooleanArray(r100);
    }

    public static /* bridge */ /* synthetic */ byte[] toByteArray(Collection r100) {
        return CollectionsKt___CollectionsKt.toByteArray(r100);
    }

    public static /* bridge */ /* synthetic */ char[] toCharArray(Collection r100) {
        return CollectionsKt___CollectionsKt.toCharArray(r100);
    }

    public static /* bridge */ /* synthetic */ Collection toCollection(Iterable r100, Collection r101) {
        return CollectionsKt___CollectionsKt.toCollection(r100, r101);
    }

    public static /* bridge */ /* synthetic */ double[] toDoubleArray(Collection r100) {
        return CollectionsKt___CollectionsKt.toDoubleArray(r100);
    }

    public static /* bridge */ /* synthetic */ float[] toFloatArray(Collection r100) {
        return CollectionsKt___CollectionsKt.toFloatArray(r100);
    }

    public static /* bridge */ /* synthetic */ HashSet toHashSet(Iterable r100) {
        return CollectionsKt___CollectionsKt.toHashSet(r100);
    }

    public static /* bridge */ /* synthetic */ int[] toIntArray(Collection r100) {
        return CollectionsKt___CollectionsKt.toIntArray(r100);
    }

    public static /* bridge */ /* synthetic */ List toList(Iterable r100) {
        return CollectionsKt___CollectionsKt.toList(r100);
    }

    public static /* bridge */ /* synthetic */ long[] toLongArray(Collection r100) {
        return CollectionsKt___CollectionsKt.toLongArray(r100);
    }

    public static /* bridge */ /* synthetic */ List toMutableList(Iterable r100) {
        return CollectionsKt___CollectionsKt.toMutableList(r100);
    }

    public static /* bridge */ /* synthetic */ List toMutableList(Collection r100) {
        return CollectionsKt___CollectionsKt.toMutableList(r100);
    }

    public static /* bridge */ /* synthetic */ Set toMutableSet(Iterable r100) {
        return CollectionsKt___CollectionsKt.toMutableSet(r100);
    }

    public static /* bridge */ /* synthetic */ Set toSet(Iterable r100) {
        return CollectionsKt___CollectionsKt.toSet(r100);
    }

    public static /* bridge */ /* synthetic */ SortedSet toSortedSet(Iterable r100) {
        return CollectionsKt___CollectionsJvmKt.toSortedSet(r100);
    }

    public static /* bridge */ /* synthetic */ Set union(Iterable r100, Iterable r101) {
        return CollectionsKt___CollectionsKt.union(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List windowed$default(Iterable r100, int r101, int r102, boolean r103, int r104, Object r105) {
        return CollectionsKt___CollectionsKt.windowed$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ List windowed$default(Iterable r100, int r101, int r102, boolean r103, Function1 r104, int r105, Object r106) {
        return CollectionsKt___CollectionsKt.windowed$default(r100, r101, r102, r103, r104, r105, r106);
    }

    public static /* bridge */ /* synthetic */ Iterable withIndex(Iterable r100) {
        return CollectionsKt___CollectionsKt.withIndex(r100);
    }

    public static /* bridge */ /* synthetic */ Iterator withIndex(Iterator r100) {
        return CollectionsKt__IteratorsKt.withIndex(r100);
    }

    public static /* bridge */ /* synthetic */ List zip(Iterable r100, Iterable r101) {
        return CollectionsKt___CollectionsKt.zip(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List zip(Iterable r100, Object[] r101) {
        return CollectionsKt___CollectionsKt.zip(r100, r101);
    }

    private CollectionsKt() {
    }
}
