package kotlin.sequences;

import android.util.EventsUtils;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"kotlin/sequences/SequencesKt__SequenceBuilderKt", "kotlin/sequences/SequencesKt__SequencesJVMKt", "kotlin/sequences/SequencesKt__SequencesKt", "kotlin/sequences/SequencesKt___SequencesJvmKt", "kotlin/sequences/SequencesKt___SequencesKt"}, k = 4, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_IOPRELOAD_DATA)
public final class SequencesKt extends SequencesKt___SequencesKt {
    public static /* bridge */ /* synthetic */ Iterable asIterable(Sequence r0) {
        return SequencesKt___SequencesKt.asIterable(r0);
    }

    public static /* bridge */ /* synthetic */ Sequence asSequence(Iterator r0) {
        return SequencesKt__SequencesKt.asSequence(r0);
    }

    public static /* bridge */ /* synthetic */ Sequence chunked(Sequence r0, int r1) {
        return SequencesKt___SequencesKt.chunked(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Sequence constrainOnce(Sequence r0) {
        return SequencesKt__SequencesKt.constrainOnce(r0);
    }

    public static /* bridge */ /* synthetic */ boolean contains(Sequence r0, Object r1) {
        return SequencesKt___SequencesKt.contains(r0, r1);
    }

    public static /* bridge */ /* synthetic */ int count(Sequence r0) {
        return SequencesKt___SequencesKt.count(r0);
    }

    public static /* bridge */ /* synthetic */ Sequence distinct(Sequence r0) {
        return SequencesKt___SequencesKt.distinct(r0);
    }

    public static /* bridge */ /* synthetic */ Sequence distinctBy(Sequence r0, Function1 r1) {
        return SequencesKt___SequencesKt.distinctBy(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Sequence drop(Sequence r0, int r1) {
        return SequencesKt___SequencesKt.drop(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Sequence dropWhile(Sequence r0, Function1 r1) {
        return SequencesKt___SequencesKt.dropWhile(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Object elementAtOrNull(Sequence r0, int r1) {
        return SequencesKt___SequencesKt.elementAtOrNull(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Sequence emptySequence() {
        return SequencesKt__SequencesKt.emptySequence();
    }

    public static /* bridge */ /* synthetic */ Sequence filter(Sequence r0, Function1 r1) {
        return SequencesKt___SequencesKt.filter(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Sequence filterIndexed(Sequence r0, Function2 r1) {
        return SequencesKt___SequencesKt.filterIndexed(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Sequence filterIsInstance(Sequence r0, Class r1) {
        return SequencesKt___SequencesJvmKt.filterIsInstance(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Sequence filterNot(Sequence r0, Function1 r1) {
        return SequencesKt___SequencesKt.filterNot(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Sequence filterNotNull(Sequence r0) {
        return SequencesKt___SequencesKt.filterNotNull(r0);
    }

    public static /* bridge */ /* synthetic */ Object first(Sequence r0) {
        return SequencesKt___SequencesKt.first(r0);
    }

    public static /* bridge */ /* synthetic */ Object firstOrNull(Sequence r0) {
        return SequencesKt___SequencesKt.firstOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Sequence flatMap(Sequence r0, Function1 r1) {
        return SequencesKt___SequencesKt.flatMap(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Sequence flatMapIterable(Sequence r0, Function1 r1) {
        return SequencesKt___SequencesKt.flatMapIterable(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Sequence flattenSequenceOfIterable(Sequence r0) {
        return SequencesKt__SequencesKt.flattenSequenceOfIterable(r0);
    }

    public static /* bridge */ /* synthetic */ Sequence generateSequence(Object r0, Function1 r1) {
        return SequencesKt__SequencesKt.generateSequence(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Sequence generateSequence(Function0 r0) {
        return SequencesKt__SequencesKt.generateSequence(r0);
    }

    public static /* bridge */ /* synthetic */ Sequence generateSequence(Function0 r0, Function1 r1) {
        return SequencesKt__SequencesKt.generateSequence(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Iterator iterator(Function2 r0) {
        return SequencesKt__SequenceBuilderKt.iterator(r0);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(Sequence r0, CharSequence r1, CharSequence r2, CharSequence r3, int r4, CharSequence r5, Function1 r6, int r7, Object r8) {
        return SequencesKt___SequencesKt.joinToString$default(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* bridge */ /* synthetic */ Object last(Sequence r0) {
        return SequencesKt___SequencesKt.last(r0);
    }

    public static /* bridge */ /* synthetic */ Object lastOrNull(Sequence r0) {
        return SequencesKt___SequencesKt.lastOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Sequence map(Sequence r0, Function1 r1) {
        return SequencesKt___SequencesKt.map(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Sequence mapIndexed(Sequence r0, Function2 r1) {
        return SequencesKt___SequencesKt.mapIndexed(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Sequence mapNotNull(Sequence r0, Function1 r1) {
        return SequencesKt___SequencesKt.mapNotNull(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Comparable maxOrNull(Sequence r0) {
        return SequencesKt___SequencesKt.maxOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Object maxWithOrNull(Sequence r0, Comparator r1) {
        return SequencesKt___SequencesKt.maxWithOrNull(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Comparable minOrNull(Sequence r0) {
        return SequencesKt___SequencesKt.minOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Object minWithOrNull(Sequence r0, Comparator r1) {
        return SequencesKt___SequencesKt.minWithOrNull(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean none(Sequence r0) {
        return SequencesKt___SequencesKt.none(r0);
    }

    public static /* bridge */ /* synthetic */ Sequence onEach(Sequence r0, Function1 r1) {
        return SequencesKt___SequencesKt.onEach(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Sequence plus(Sequence r0, Iterable r1) {
        return SequencesKt___SequencesKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Sequence plus(Sequence r0, Object r1) {
        return SequencesKt___SequencesKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Sequence plus(Sequence r0, Sequence r1) {
        return SequencesKt___SequencesKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Sequence sequence(Function2 r0) {
        return SequencesKt__SequenceBuilderKt.sequence(r0);
    }

    public static /* bridge */ /* synthetic */ Sequence sequenceOf(Object... r0) {
        return SequencesKt__SequencesKt.sequenceOf(r0);
    }

    public static /* bridge */ /* synthetic */ Object singleOrNull(Sequence r0) {
        return SequencesKt___SequencesKt.singleOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Sequence sorted(Sequence r0) {
        return SequencesKt___SequencesKt.sorted(r0);
    }

    public static /* bridge */ /* synthetic */ Sequence sortedWith(Sequence r0, Comparator r1) {
        return SequencesKt___SequencesKt.sortedWith(r0, r1);
    }

    public static /* bridge */ /* synthetic */ double sumOfDouble(Sequence r2) {
        return SequencesKt___SequencesKt.sumOfDouble(r2);
    }

    public static /* bridge */ /* synthetic */ Sequence take(Sequence r0, int r1) {
        return SequencesKt___SequencesKt.take(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Sequence takeWhile(Sequence r0, Function1 r1) {
        return SequencesKt___SequencesKt.takeWhile(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Collection toCollection(Sequence r0, Collection r1) {
        return SequencesKt___SequencesKt.toCollection(r0, r1);
    }

    public static /* bridge */ /* synthetic */ HashSet toHashSet(Sequence r0) {
        return SequencesKt___SequencesKt.toHashSet(r0);
    }

    public static /* bridge */ /* synthetic */ List toList(Sequence r0) {
        return SequencesKt___SequencesKt.toList(r0);
    }

    public static /* bridge */ /* synthetic */ List toMutableList(Sequence r0) {
        return SequencesKt___SequencesKt.toMutableList(r0);
    }

    public static /* bridge */ /* synthetic */ Set toMutableSet(Sequence r0) {
        return SequencesKt___SequencesKt.toMutableSet(r0);
    }

    public static /* bridge */ /* synthetic */ Set toSet(Sequence r0) {
        return SequencesKt___SequencesKt.toSet(r0);
    }

    public static /* bridge */ /* synthetic */ Sequence withIndex(Sequence r0) {
        return SequencesKt___SequencesKt.withIndex(r0);
    }

    public static /* bridge */ /* synthetic */ Sequence zip(Sequence r0, Sequence r1, Function2 r2) {
        return SequencesKt___SequencesKt.zip(r0, r1, r2);
    }

    private SequencesKt() {
    }
}
