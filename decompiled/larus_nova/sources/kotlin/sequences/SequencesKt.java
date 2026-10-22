package kotlin.sequences;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"kotlin/sequences/SequencesKt__SequenceBuilderKt", "kotlin/sequences/SequencesKt__SequencesJVMKt", "kotlin/sequences/SequencesKt__SequencesKt", "kotlin/sequences/SequencesKt___SequencesJvmKt", "kotlin/sequences/SequencesKt___SequencesKt"}, k = 4, mv = {1, 9, 0}, xi = 49)
public final class SequencesKt extends SequencesKt___SequencesKt {
    public static /* bridge */ /* synthetic */ Iterable asIterable(Sequence r100) {
        return SequencesKt___SequencesKt.asIterable(r100);
    }

    public static /* bridge */ /* synthetic */ Sequence asSequence(Iterator r100) {
        return SequencesKt__SequencesKt.asSequence(r100);
    }

    public static /* bridge */ /* synthetic */ Sequence chunked(Sequence r100, int r101) {
        return SequencesKt___SequencesKt.chunked(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Sequence constrainOnce(Sequence r100) {
        return SequencesKt__SequencesKt.constrainOnce(r100);
    }

    public static /* bridge */ /* synthetic */ boolean contains(Sequence r100, Object r101) {
        return SequencesKt___SequencesKt.contains(r100, r101);
    }

    public static /* bridge */ /* synthetic */ int count(Sequence r100) {
        return SequencesKt___SequencesKt.count(r100);
    }

    public static /* bridge */ /* synthetic */ Sequence distinct(Sequence r100) {
        return SequencesKt___SequencesKt.distinct(r100);
    }

    public static /* bridge */ /* synthetic */ Sequence distinctBy(Sequence r100, Function1 r101) {
        return SequencesKt___SequencesKt.distinctBy(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Sequence drop(Sequence r100, int r101) {
        return SequencesKt___SequencesKt.drop(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Sequence dropWhile(Sequence r100, Function1 r101) {
        return SequencesKt___SequencesKt.dropWhile(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Object elementAtOrNull(Sequence r100, int r101) {
        return SequencesKt___SequencesKt.elementAtOrNull(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Sequence emptySequence() {
        return SequencesKt__SequencesKt.emptySequence();
    }

    public static /* bridge */ /* synthetic */ Sequence filter(Sequence r100, Function1 r101) {
        return SequencesKt___SequencesKt.filter(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Sequence filterIndexed(Sequence r100, Function2 r101) {
        return SequencesKt___SequencesKt.filterIndexed(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Sequence filterIsInstance(Sequence r100, Class r101) {
        return SequencesKt___SequencesJvmKt.filterIsInstance(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Sequence filterNot(Sequence r100, Function1 r101) {
        return SequencesKt___SequencesKt.filterNot(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Sequence filterNotNull(Sequence r100) {
        return SequencesKt___SequencesKt.filterNotNull(r100);
    }

    public static /* bridge */ /* synthetic */ Object first(Sequence r100) {
        return SequencesKt___SequencesKt.first(r100);
    }

    public static /* bridge */ /* synthetic */ Object firstOrNull(Sequence r100) {
        return SequencesKt___SequencesKt.firstOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Sequence flatMap(Sequence r100, Function1 r101) {
        return SequencesKt___SequencesKt.flatMap(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Sequence flatMapIterable(Sequence r100, Function1 r101) {
        return SequencesKt___SequencesKt.flatMapIterable(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Sequence flattenSequenceOfIterable(Sequence r100) {
        return SequencesKt__SequencesKt.flattenSequenceOfIterable(r100);
    }

    public static /* bridge */ /* synthetic */ Sequence generateSequence(Object r100, Function1 r101) {
        return SequencesKt__SequencesKt.generateSequence(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Sequence generateSequence(Function0 r100) {
        return SequencesKt__SequencesKt.generateSequence(r100);
    }

    public static /* bridge */ /* synthetic */ Sequence generateSequence(Function0 r100, Function1 r101) {
        return SequencesKt__SequencesKt.generateSequence(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Iterator iterator(Function2 r100) {
        return SequencesKt__SequenceBuilderKt.iterator(r100);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(Sequence r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, Function1 r106, int r107, Object r108) {
        return SequencesKt___SequencesKt.joinToString$default(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }

    public static /* bridge */ /* synthetic */ Object last(Sequence r100) {
        return SequencesKt___SequencesKt.last(r100);
    }

    public static /* bridge */ /* synthetic */ Object lastOrNull(Sequence r100) {
        return SequencesKt___SequencesKt.lastOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Sequence map(Sequence r100, Function1 r101) {
        return SequencesKt___SequencesKt.map(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Sequence mapIndexed(Sequence r100, Function2 r101) {
        return SequencesKt___SequencesKt.mapIndexed(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Sequence mapNotNull(Sequence r100, Function1 r101) {
        return SequencesKt___SequencesKt.mapNotNull(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Comparable maxOrNull(Sequence r100) {
        return SequencesKt___SequencesKt.maxOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Object maxWithOrNull(Sequence r100, Comparator r101) {
        return SequencesKt___SequencesKt.maxWithOrNull(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Comparable minOrNull(Sequence r100) {
        return SequencesKt___SequencesKt.minOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Object minWithOrNull(Sequence r100, Comparator r101) {
        return SequencesKt___SequencesKt.minWithOrNull(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean none(Sequence r100) {
        return SequencesKt___SequencesKt.none(r100);
    }

    public static /* bridge */ /* synthetic */ Sequence onEach(Sequence r100, Function1 r101) {
        return SequencesKt___SequencesKt.onEach(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Sequence plus(Sequence r100, Iterable r101) {
        return SequencesKt___SequencesKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Sequence plus(Sequence r100, Object r101) {
        return SequencesKt___SequencesKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Sequence plus(Sequence r100, Sequence r101) {
        return SequencesKt___SequencesKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Sequence sequence(Function2 r100) {
        return SequencesKt__SequenceBuilderKt.sequence(r100);
    }

    public static /* bridge */ /* synthetic */ Sequence sequenceOf(Object... r100) {
        return SequencesKt__SequencesKt.sequenceOf(r100);
    }

    public static /* bridge */ /* synthetic */ Object singleOrNull(Sequence r100) {
        return SequencesKt___SequencesKt.singleOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Sequence sorted(Sequence r100) {
        return SequencesKt___SequencesKt.sorted(r100);
    }

    public static /* bridge */ /* synthetic */ Sequence sortedWith(Sequence r100, Comparator r101) {
        return SequencesKt___SequencesKt.sortedWith(r100, r101);
    }

    public static /* bridge */ /* synthetic */ double sumOfDouble(Sequence r100) {
        return SequencesKt___SequencesKt.sumOfDouble(r100);
    }

    public static /* bridge */ /* synthetic */ Sequence take(Sequence r100, int r101) {
        return SequencesKt___SequencesKt.take(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Sequence takeWhile(Sequence r100, Function1 r101) {
        return SequencesKt___SequencesKt.takeWhile(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Collection toCollection(Sequence r100, Collection r101) {
        return SequencesKt___SequencesKt.toCollection(r100, r101);
    }

    public static /* bridge */ /* synthetic */ HashSet toHashSet(Sequence r100) {
        return SequencesKt___SequencesKt.toHashSet(r100);
    }

    public static /* bridge */ /* synthetic */ List toList(Sequence r100) {
        return SequencesKt___SequencesKt.toList(r100);
    }

    public static /* bridge */ /* synthetic */ List toMutableList(Sequence r100) {
        return SequencesKt___SequencesKt.toMutableList(r100);
    }

    public static /* bridge */ /* synthetic */ Set toMutableSet(Sequence r100) {
        return SequencesKt___SequencesKt.toMutableSet(r100);
    }

    public static /* bridge */ /* synthetic */ Set toSet(Sequence r100) {
        return SequencesKt___SequencesKt.toSet(r100);
    }

    public static /* bridge */ /* synthetic */ Sequence withIndex(Sequence r100) {
        return SequencesKt___SequencesKt.withIndex(r100);
    }

    public static /* bridge */ /* synthetic */ Sequence zip(Sequence r100, Sequence r101, Function2 r102) {
        return SequencesKt___SequencesKt.zip(r100, r101, r102);
    }

    private SequencesKt() {
    }
}
