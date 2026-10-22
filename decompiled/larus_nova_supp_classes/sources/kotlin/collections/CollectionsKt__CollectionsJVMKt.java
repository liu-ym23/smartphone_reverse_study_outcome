package kotlin.collections;

import android.util.EventsUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.builders.ListBuilder;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0001\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u001d\u0010\b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\u0081\bø\u0001\u0000\u001a7\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001d\u0010\b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\u0081\bø\u0001\u0000\u001a\u0011\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0081\b\u001a\u0011\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0081\b\u001a\"\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0081\b¢\u0006\u0002\u0010\u0015\u001a4\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0011\"\u0004\b\u0000\u0010\u00162\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0011H\u0081\b¢\u0006\u0002\u0010\u0018\u001a\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u0002H\u0001\u001a\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u001b\u001a\u0002H\u0016¢\u0006\u0002\u0010\u001c\u001a/\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0011\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u001e\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0011H\u0000¢\u0006\u0002\u0010\u001f\u001a1\u0010 \u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00120\u0011\"\u0004\b\u0000\u0010\u0016*\n\u0012\u0006\b\u0001\u0012\u0002H\u00160\u00112\u0006\u0010!\u001a\u00020\"H\u0000¢\u0006\u0002\u0010#\u001a\u001e\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160%H\u0007\u001a&\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160%2\u0006\u0010&\u001a\u00020'H\u0007\u001a\u001f\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160)H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006*"}, d2 = {"build", XmlPullParser.NO_NAMESPACE, "E", "builder", XmlPullParser.NO_NAMESPACE, "buildListInternal", "capacity", XmlPullParser.NO_NAMESPACE, "builderAction", "Lkotlin/Function1;", XmlPullParser.NO_NAMESPACE, "Lkotlin/ExtensionFunctionType;", "checkCountOverflow", "count", "checkIndexOverflow", "index", "collectionToArray", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "collection", XmlPullParser.NO_NAMESPACE, "(Ljava/util/Collection;)[Ljava/lang/Object;", "T", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "createListBuilder", "listOf", "element", "(Ljava/lang/Object;)Ljava/util/List;", "terminateCollectionToArray", "collectionSize", "(I[Ljava/lang/Object;)[Ljava/lang/Object;", "copyToArrayOfAny", "isVarargs", XmlPullParser.NO_NAMESPACE, "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "shuffled", XmlPullParser.NO_NAMESPACE, "random", "Ljava/util/Random;", "toList", "Ljava/util/Enumeration;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_IOPRELOAD_DATA, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__CollectionsJVMKt {
    public CollectionsKt__CollectionsJVMKt() {
    }

    public static <E> List<E> createListBuilder() {
        return new ListBuilder(0, 1, null);
    }

    public static <E> List<E> build(List<E> r1) {
        Intrinsics.checkNotNullParameter(r1, "builder");
        return ((ListBuilder) r1).build();
    }

    private static final <E> List<E> buildListInternal(Function1<? super List<E>, Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "builderAction");
        List r0 = CollectionsKt.createListBuilder();
        r1.invoke(r0);
        return CollectionsKt.build(r0);
    }

    private static final int checkCountOverflow(int r3) {
        if (r3 < 0) goto L4;
    L8:
        return r3;
    L4:
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L7;
        CollectionsKt.throwCountOverflow();
        goto L8
    L7:
        throw new ArithmeticException("Count overflow has happened.");
    }

    private static final int checkIndexOverflow(int r3) {
        if (r3 < 0) goto L4;
    L8:
        return r3;
    L4:
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L7;
        CollectionsKt.throwIndexOverflow();
        goto L8
    L7:
        throw new ArithmeticException("Index overflow has happened.");
    }

    private static final Object[] collectionToArray(Collection<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "collection");
        return CollectionToArray.toArray(r1);
    }

    public static <E> List<E> createListBuilder(int r1) {
        return new ListBuilder(r1);
    }

    public static <T> List<T> listOf(T r0) {
        return Collections.singletonList(r0);
    }

    public static <T> List<T> shuffled(Iterable<? extends T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        List<T> r2 = CollectionsKt.toMutableList(r1);
        Collections.shuffle(r2);
        return r2;
    }

    private static final <T> List<T> toList(Enumeration<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Collections.list(r1);
    }

    private static final <E> List<E> buildListInternal(int r1, Function1<? super List<E>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "builderAction");
        List r3 = CollectionsKt.createListBuilder(r1);
        r2.invoke(r3);
        return CollectionsKt.build(r3);
    }

    private static final <T> T[] collectionToArray(Collection<?> r1, T[] r2) {
        Intrinsics.checkNotNullParameter(r1, "collection");
        Intrinsics.checkNotNullParameter(r2, "array");
        return (T[]) CollectionToArray.toArray(r1, r2);
    }

    public static final <T> Object[] copyToArrayOfAny(T[] r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == false) goto L8;
        if (Intrinsics.areEqual(r1.getClass(), Object[].class) == false) goto L8;
        return r1;
    L8:
        return Arrays.copyOf(r1, r1.length, Object[].class);
    }

    public static <T> List<T> shuffled(Iterable<? extends T> r1, Random r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "random");
        List<T> r3 = CollectionsKt.toMutableList(r1);
        Collections.shuffle(r3, r2);
        return r3;
    }

    public static <T> T[] terminateCollectionToArray(int r1, T[] r2) {
        Intrinsics.checkNotNullParameter(r2, "array");
        if (r1 >= r2.length) goto L5;
        r2[r1] = null;
    L5:
        return r2;
    }
}
