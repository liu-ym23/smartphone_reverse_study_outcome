package kotlin.sequences;

import android.util.EventsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\bø\u0001\u0000\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001ab\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\f2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00050\u000eH\u0000\u001a&\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004\u001a<\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000e\u001a=\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u0001H\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000eH\u0007¢\u0006\u0002\u0010\u0014\u001a+\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0017\"\u0002H\u0002¢\u0006\u0002\u0010\u0018\u001a\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001aC\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00050\u000eH\u0002¢\u0006\u0002\b\u001c\u001a)\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001d0\u0001H\u0007¢\u0006\u0002\b\u001e\u001a\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a2\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0007\u001a!\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\b\u001a\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a&\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0007\u001a@\u0010%\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0'0&\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0&0\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006("}, d2 = {"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", XmlPullParser.NO_NAMESPACE, "emptySequence", "flatMapIndexed", "R", "C", "source", "transform", "Lkotlin/Function2;", XmlPullParser.NO_NAMESPACE, "Lkotlin/Function1;", "generateSequence", XmlPullParser.NO_NAMESPACE, "nextFunction", "seedFunction", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", XmlPullParser.NO_NAMESPACE, "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "flatten$SequencesKt__SequencesKt", XmlPullParser.NO_NAMESPACE, "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "shuffled", "random", "Lkotlin/random/Random;", "unzip", "Lkotlin/Pair;", XmlPullParser.NO_NAMESPACE, "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_IOPRELOAD_DATA, xs = "kotlin/sequences/SequencesKt")
class SequencesKt__SequencesKt extends SequencesKt__SequencesJVMKt {
    public SequencesKt__SequencesKt() {
    }

    public static <T> Sequence<T> emptySequence() {
        return EmptySequence.INSTANCE;
    }

    private static final <T> Sequence<T> Sequence(Function0<? extends Iterator<? extends T>> r1) {
        Intrinsics.checkNotNullParameter(r1, "iterator");
        return new Sequence.1(r1);
    }

    public static <T> Sequence<T> asSequence(final Iterator<? extends T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return SequencesKt.constrainOnce(new SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(r1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Sequence<T> constrainOnce(Sequence<? extends T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof ConstrainedOnceSequence) == false) goto L6;
        return r1;
    L6:
        return new ConstrainedOnceSequence(r1);
    }

    public static final <T> Sequence<T> flatten(Sequence<? extends Sequence<? extends T>> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return flatten$SequencesKt__SequencesKt(r1, flatten.1.INSTANCE);
    }

    public static <T> Sequence<T> flattenSequenceOfIterable(Sequence<? extends Iterable<? extends T>> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return flatten$SequencesKt__SequencesKt(r1, flatten.2.INSTANCE);
    }

    public static <T> Sequence<T> generateSequence(Function0<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "nextFunction");
        return SequencesKt.constrainOnce(new GeneratorSequence(r2, new generateSequence.1(r2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Sequence<T> orEmpty(Sequence<? extends T> r0) {
        if (r0 == 0) goto L4;
        return r0;
    L4:
        return SequencesKt.emptySequence();
    }

    public static <T> Sequence<T> sequenceOf(T... r1) {
        Intrinsics.checkNotNullParameter(r1, "elements");
        return ArraysKt.asSequence(r1);
    }

    public static final <T> Sequence<T> shuffled(Sequence<? extends T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return shuffled(r1, Random.Default);
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Sequence<? extends Pair<? extends T, ? extends R>> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator<? extends Pair<? extends T, ? extends R>> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        Pair<? extends T, ? extends R> r2 = r5.next();
        r0.add(r2.getFirst());
        r1.add(r2.getSecond());
        goto L4
    L7:
        return TuplesKt.to(r0, r1);
    }

    private static final <T, R> Sequence<R> flatten$SequencesKt__SequencesKt(Sequence<? extends T> r2, Function1<? super T, ? extends Iterator<? extends R>> r3) {
        if ((r2 instanceof TransformingSequence) == false) goto L7;
        return ((TransformingSequence) r2).flatten$kotlin_stdlib(r3);
    L7:
        return new FlatteningSequence(r2, flatten.3.INSTANCE, r3);
    }

    public static <T> Sequence<T> generateSequence(T r2, Function1<? super T, ? extends T> r3) {
        Intrinsics.checkNotNullParameter(r3, "nextFunction");
        if (r2 != null) goto L6;
        return EmptySequence.INSTANCE;
    L6:
        return new GeneratorSequence(new generateSequence.2(r2), r3);
    }

    public static final <T> Sequence<T> ifEmpty(Sequence<? extends T> r2, Function0<? extends Sequence<? extends T>> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        return SequencesKt.sequence(new ifEmpty.1(r2, r3, null));
    }

    public static final <T> Sequence<T> shuffled(Sequence<? extends T> r2, Random r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "random");
        return SequencesKt.sequence(new shuffled.1(r2, r3, null));
    }

    public static <T> Sequence<T> generateSequence(Function0<? extends T> r1, Function1<? super T, ? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "seedFunction");
        Intrinsics.checkNotNullParameter(r2, "nextFunction");
        return new GeneratorSequence(r1, r2);
    }

    public static final <T, C, R> Sequence<R> flatMapIndexed(Sequence<? extends T> r2, Function2<? super Integer, ? super T, ? extends C> r3, Function1<? super C, ? extends Iterator<? extends R>> r4) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "transform");
        Intrinsics.checkNotNullParameter(r4, "iterator");
        return SequencesKt.sequence(new flatMapIndexed.1(r2, r3, r4, null));
    }
}
