package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0002\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0004\u001a,\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0002\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0004¨\u0006\r"}, d2 = {"minus", "", ExifInterface.GPS_DIRECTION_TRUE, "element", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", SlcElement.KEY_ELEMENTS, "", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "Lkotlin/sequences/Sequence;", "minusElement", "plus", "plusElement", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/SetsKt")
class SetsKt___SetsKt extends SetsKt__SetsKt {
    public SetsKt___SetsKt() {
    }

    public static <T> Set<T> minus(Set<? extends T> r100, Iterable<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ELEMENTS);
        Collection<?> r102 = CollectionsKt.convertToListIfNotCollection(r101);
        if (r102.isEmpty() == false) goto L7;
        return CollectionsKt.toSet(r100);
    L7:
        if ((r102 instanceof Set) == false) goto L15;
        LinkedHashSet r103 = new LinkedHashSet();
        Iterator<T> r104 = r100.iterator();
    L10:
        if (r104.hasNext() == false) goto L14;
        T r105 = r104.next();
        if (r102.contains(r105) == true) goto L10;
        r103.add(r105);
        goto L10
    L14:
        return r103;
    L15:
        LinkedHashSet r106 = new LinkedHashSet(r100);
        r106.removeAll(r102);
        return r106;
    }

    private static final <T> Set<T> minusElement(Set<? extends T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return minus(r100, r101);
    }

    public static <T> Set<T> plus(Set<? extends T> r100, Iterable<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ELEMENTS);
        Integer r102 = CollectionsKt__IterablesKt.collectionSizeOrNull(r101);
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
        int r104 = r100.size() + r103;
    L6:
        LinkedHashSet r105 = new LinkedHashSet(MapsKt.mapCapacity(r104));
        r105.addAll(r100);
        CollectionsKt.addAll(r105, r101);
        return r105;
    L5:
        r104 = r100.size() * 2;
        goto L6
    }

    private static final <T> Set<T> plusElement(Set<? extends T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return plus(r100, r101);
    }

    public static <T> Set<T> minus(Set<? extends T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LinkedHashSet r102 = new LinkedHashSet(MapsKt.mapCapacity(r100.size()));
        Iterator<T> r103 = r100.iterator();
        boolean r104 = false;
    L4:
        if (r103.hasNext() == false) goto L12;
        T r105 = r103.next();
        boolean r106 = true;
        if (r104 == false) goto L8;
    L10:
        if (r106 == false) goto L4;
        r102.add(r105);
        goto L4
    L8:
        if (Intrinsics.areEqual(r105, r101) == false) goto L10;
        r104 = true;
        r106 = false;
        goto L10
    L12:
        return r102;
    }

    public static <T> Set<T> plus(Set<? extends T> r100, Sequence<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ELEMENTS);
        LinkedHashSet r102 = new LinkedHashSet(MapsKt.mapCapacity(r100.size() * 2));
        r102.addAll(r100);
        CollectionsKt.addAll(r102, r101);
        return r102;
    }

    public static final <T> Set<T> minus(Set<? extends T> r100, Sequence<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ELEMENTS);
        LinkedHashSet r102 = new LinkedHashSet(r100);
        CollectionsKt.removeAll(r102, r101);
        return r102;
    }

    public static final <T> Set<T> plus(Set<? extends T> r100, T[] r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ELEMENTS);
        LinkedHashSet r102 = new LinkedHashSet(MapsKt.mapCapacity(r100.size() + r101.length));
        r102.addAll(r100);
        CollectionsKt.addAll(r102, r101);
        return r102;
    }

    public static final <T> Set<T> minus(Set<? extends T> r100, T[] r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ELEMENTS);
        LinkedHashSet r102 = new LinkedHashSet(r100);
        CollectionsKt.removeAll(r102, r101);
        return r102;
    }

    public static <T> Set<T> plus(Set<? extends T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LinkedHashSet r102 = new LinkedHashSet(MapsKt.mapCapacity(r100.size() + 1));
        r102.addAll(r100);
        r102.add(r101);
        return r102;
    }
}
