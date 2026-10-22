package kotlin.collections;

import android.Manifest;
import android.util.EventsUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u001a-\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0000\u001a9\u0010\u000b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u0010\u001a9\u0010\u000b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00112\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u0010\u001a(\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u0006\u0010\u0014\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\u0015\u001a.\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\n¢\u0006\u0002\u0010\u0016\u001a)\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0087\n\u001a)\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\n\u001a(\u0010\u0017\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u0006\u0010\u0014\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\u0015\u001a.\u0010\u0017\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\n¢\u0006\u0002\u0010\u0016\u001a)\u0010\u0017\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0087\n\u001a)\u0010\u0017\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\n\u001a-\u0010\u0018\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0019*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0014\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u001a\u001a&\u0010\u0018\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0087\b¢\u0006\u0002\u0010\u001d\u001a-\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a.\u0010\u001e\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0019*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\nH\u0087\b\u001a*\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000e\u001a*\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00112\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000e\u001a\u001d\u0010\u001f\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0007¢\u0006\u0002\u0010 \u001a\u001f\u0010!\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0007¢\u0006\u0002\u0010 \u001a\u001d\u0010\"\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0007¢\u0006\u0002\u0010 \u001a\u001f\u0010#\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0007¢\u0006\u0002\u0010 \u001a-\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a.\u0010$\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0019*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\nH\u0087\b\u001a*\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000e\u001a*\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00112\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000e\u001a\u0015\u0010%\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0002\b&¨\u0006'"}, d2 = {"addAll", XmlPullParser.NO_NAMESPACE, "T", XmlPullParser.NO_NAMESPACE, "elements", XmlPullParser.NO_NAMESPACE, "(Ljava/util/Collection;[Ljava/lang/Object;)Z", XmlPullParser.NO_NAMESPACE, "Lkotlin/sequences/Sequence;", "convertToListIfNotCollection", XmlPullParser.NO_NAMESPACE, "filterInPlace", XmlPullParser.NO_NAMESPACE, "predicate", "Lkotlin/Function1;", "predicateResultToRemove", "filterInPlace$CollectionsKt__MutableCollectionsKt", XmlPullParser.NO_NAMESPACE, "minusAssign", XmlPullParser.NO_NAMESPACE, "element", "(Ljava/util/Collection;Ljava/lang/Object;)V", "(Ljava/util/Collection;[Ljava/lang/Object;)V", "plusAssign", "remove", "Lkotlin/internal/OnlyInputTypes;", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "index", XmlPullParser.NO_NAMESPACE, "(Ljava/util/List;I)Ljava/lang/Object;", "removeAll", "removeFirst", "(Ljava/util/List;)Ljava/lang/Object;", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "retainNothing", "retainNothing$CollectionsKt__MutableCollectionsKt", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_IOPRELOAD_DATA, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt {
    public CollectionsKt__MutableCollectionsKt() {
    }

    public static <T> Collection<T> convertToListIfNotCollection(Iterable<? extends T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof Collection) == true) goto L7;
        r1 = CollectionsKt.toList(r1);
    L7:
        return (Collection) r1;
    }

    public static <T> T removeFirst(List<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.isEmpty() == true) goto L7;
        return (T) ListProtector.remove(r1, 0);
    L7:
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T removeFirstOrNull(List<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.isEmpty() == false) goto L6;
        return null;
    L6:
        return (T) ListProtector.remove(r1, 0);
    }

    public static <T> T removeLast(List<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.isEmpty() == true) goto L7;
        return (T) ListProtector.remove(r1, CollectionsKt.getLastIndex(r1));
    L7:
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T removeLastOrNull(List<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.isEmpty() == false) goto L6;
        return null;
    L6:
        return (T) ListProtector.remove(r1, CollectionsKt.getLastIndex(r1));
    }

    private static final boolean retainNothing$CollectionsKt__MutableCollectionsKt(Collection<?> r1) {
        boolean r0 = !r1.isEmpty();
        r1.clear();
        return r0;
    }

    public static <T> boolean addAll(Collection<? super T> r2, Iterable<? extends T> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "elements");
        if ((r3 instanceof Collection) == true) goto L5;
        Iterator<? extends T> r4 = r3.iterator();
        boolean r0 = false;
    L8:
        if (r4.hasNext() == false) goto L12;
        if (r2.add(r4.next()) == false) goto L8;
        r0 = true;
        goto L8
    L12:
        return r0;
    L5:
        return r2.addAll((Collection) r3);
    }

    private static final <T> void minusAssign(Collection<? super T> r1, Iterable<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "elements");
        CollectionsKt.removeAll(r1, r2);
    }

    private static final <T> void plusAssign(Collection<? super T> r1, Iterable<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "elements");
        CollectionsKt.addAll(r1, r2);
    }

    private static final <T> boolean remove(Collection<? extends T> r1, T r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return TypeIntrinsics.asMutableCollection(r1).remove(r2);
    }

    public static <T> boolean removeAll(Collection<? super T> r3, T[] r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "elements");
        if (r4.length != 0) goto L5;
        boolean r0 = true;
    L7:
        if ((!r0) == true) goto L9;
        return false;
    L9:
        if (r3.removeAll(ArraysKt.asList(r4)) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        r0 = false;
        goto L7
    }

    public static final <T> boolean retainAll(Collection<? super T> r2, T[] r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "elements");
        if (r3.length != 0) goto L5;
        boolean r0 = true;
    L7:
        if ((!r0) == false) goto L11;
        return r2.retainAll(ArraysKt.asList(r3));
    L11:
        return retainNothing$CollectionsKt__MutableCollectionsKt(r2);
    L5:
        r0 = false;
        goto L7
    }

    public static <T> boolean addAll(Collection<? super T> r2, Sequence<? extends T> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "elements");
        Iterator<? extends T> r4 = r3.iterator();
        boolean r0 = false;
    L4:
        if (r4.hasNext() == false) goto L8;
        if (r2.add(r4.next()) == false) goto L4;
        r0 = true;
        goto L4
    L8:
        return r0;
    }

    private static final <T> void minusAssign(Collection<? super T> r1, Sequence<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "elements");
        CollectionsKt.removeAll(r1, r2);
    }

    private static final <T> void plusAssign(Collection<? super T> r1, Sequence<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "elements");
        CollectionsKt.addAll(r1, r2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use removeAt(index) instead.", replaceWith = @ReplaceWith(expression = "removeAt(index)", imports = {}))
    private static final <T> T remove(List<T> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return (T) ListProtector.remove(r1, r2);
    }

    public static <T> boolean removeAll(Collection<? super T> r2, Sequence<? extends T> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "elements");
        List r4 = SequencesKt.toList(r3);
        if ((!r4.isEmpty()) == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.removeAll(r4) == false) goto L7;
        return true;
    }

    public static final <T> boolean retainAll(Collection<? super T> r1, Sequence<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "elements");
        List r3 = SequencesKt.toList(r2);
        if ((!r3.isEmpty()) == false) goto L7;
        return r1.retainAll(r3);
    L7:
        return retainNothing$CollectionsKt__MutableCollectionsKt(r1);
    }

    public static <T> boolean addAll(Collection<? super T> r1, T[] r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "elements");
        return r1.addAll(ArraysKt.asList(r2));
    }

    private static final <T> void minusAssign(Collection<? super T> r1, T[] r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "elements");
        CollectionsKt.removeAll(r1, r2);
    }

    private static final <T> void plusAssign(Collection<? super T> r1, T[] r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "elements");
        CollectionsKt.addAll(r1, r2);
    }

    public static <T> boolean removeAll(Collection<? super T> r1, Iterable<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "elements");
        return r1.removeAll(CollectionsKt.convertToListIfNotCollection(r2));
    }

    public static <T> boolean retainAll(Collection<? super T> r1, Iterable<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "elements");
        return r1.retainAll(CollectionsKt.convertToListIfNotCollection(r2));
    }

    private static final <T> void minusAssign(Collection<? super T> r1, T r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.remove(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void plusAssign(Collection<? super T> r1, T r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.add(r2);
    }

    private static final <T> boolean removeAll(Collection<? extends T> r1, Collection<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "elements");
        return TypeIntrinsics.asMutableCollection(r1).removeAll(r2);
    }

    private static final <T> boolean retainAll(Collection<? extends T> r1, Collection<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "elements");
        return TypeIntrinsics.asMutableCollection(r1).retainAll(r2);
    }

    public static <T> boolean removeAll(Iterable<? extends T> r1, Function1<? super T, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt(r1, r2, true);
    }

    public static <T> boolean retainAll(Iterable<? extends T> r1, Function1<? super T, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt(r1, r2, false);
    }

    public static <T> boolean removeAll(List<T> r1, Function1<? super T, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt(r1, r2, true);
    }

    public static <T> boolean retainAll(List<T> r1, Function1<? super T, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt(r1, r2, false);
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(List<T> r6, Function1<? super T, Boolean> r7, boolean r8) {
        if ((r6 instanceof RandomAccess) == true) goto L6;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
        return filterInPlace$CollectionsKt__MutableCollectionsKt(TypeIntrinsics.asMutableIterable(r6), r7, r8);
    L6:
        int r0 = CollectionsKt.getLastIndex(r6);
        if (r0 < 0) goto L17;
        int r2 = 0;
        int r3 = 0;
    L9:
        Manifest.permission r4 = (Object) ListProtector.get(r6, r2);
        if (r7.invoke(r4).booleanValue() == r8) goto L15;
        if (r3 == r2) goto L14;
        ListProtector.set(r6, r3, r4);
    L14:
        r3 = r3 + 1;
    L15:
        if (r2 == r0) goto L19;
        r2 = r2 + 1;
    L19:
        if (r3 >= r6.size()) goto L27;
        int r9 = CollectionsKt.getLastIndex(r6);
        if (r3 > r9) goto L25;
    L22:
        ListProtector.remove(r6, r9);
        if (r9 == r3) goto L30;
        r9 = r9 - 1;
        goto L22
    L30:
        return true;
    L25:
        return true;
    L27:
        return false;
    L17:
        r3 = 0;
        goto L19
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(Iterable<? extends T> r2, Function1<? super T, Boolean> r3, boolean r4) {
        Iterator<? extends T> r5 = r2.iterator();
        boolean r0 = false;
    L4:
        if (r5.hasNext() == false) goto L8;
        if (r3.invoke(r5.next()).booleanValue() != r4) goto L4;
        r5.remove();
        r0 = true;
        goto L4
    L8:
        return r0;
    }
}
