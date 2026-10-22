package kotlinx.datetime.internal.format.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class q {
    public static final <T> u<T> a(List<? extends u<? super T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        u r101 = new u(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        if (r100.isEmpty() == true) goto L9;
        ListIterator<? extends u<? super T>> r102 = r100.listIterator(r100.size());
    L6:
        if (r102.hasPrevious() == false) goto L9;
        r101 = b(r102.previous(), r101);
    L9:
        return c(r101, CollectionsKt.emptyList());
    }

    public static final <T> u<T> b(u<? super T> r100, u<? super T> r101) {
        if (r100.f505343b.isEmpty() == true) goto L12;
        List<r<? super T>> r102 = r100.f505342a;
        List<u<? super T>> r103 = r100.f505343b;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L10;
        r104.add(b((u) r105.next(), r101));
        goto L7
    L10:
        return new u(r102, r104);
    L12:
        return new u(CollectionsKt.plus(r100.f505342a, r101.f505342a), r101.f505343b);
    }

    public static final <T> u<T> c(u<? super T> r100, List<c0<T>> r101) {
        ArrayList r102 = new ArrayList();
        List r103 = CollectionsKt.toMutableList(r101);
        Iterator<r<? super T>> r104 = r100.f505342a.iterator();
        List r105 = null;
    L4:
        if (r104.hasNext() == false) goto L16;
        r<? super T> r106 = r104.next();
        if ((r106 instanceof j) == true) goto L7;
        if ((r106 instanceof c0) == true) goto L12;
        if (r105 == null) goto L15;
        r102.add(new j(r105));
        r105 = null;
    L15:
        r102.add(r106);
        goto L4
    L12:
        r103.add(r106);
        goto L4
    L7:
        if (r105 != null) goto L8;
        r105 = CollectionsKt.toMutableList(((j) r106).f505329a);
        goto L4
    L8:
        r105.addAll(((j) r106).f505329a);
        goto L4
    L16:
        List<u<? super T>> r107 = r100.f505343b;
        List r108 = new ArrayList();
        Iterator<T> r109 = r107.iterator();
    L18:
        if (r109.hasNext() == false) goto L28;
        u r110 = c((u) r109.next(), r103);
        if (r110.f505342a.isEmpty() == false) goto L25;
        Collection r111 = r110.f505343b;
        if (r111.isEmpty() == false) goto L24;
        r111 = CollectionsKt.listOf(r110);
    L24:
        List r112 = (List) r111;
    L26:
        CollectionsKt.addAll(r108, r112);
        goto L18
    L25:
        r112 = CollectionsKt.listOf(r110);
        goto L26
    L28:
        if (r108.isEmpty() == false) goto L30;
        r108 = CollectionsKt.listOf(new u(r103, CollectionsKt.emptyList()));
    L30:
        List r113 = r108;
        if (r105 == null) goto L86;
        List r114 = r113;
        if ((r114 instanceof Collection) == true) goto L36;
    L38:
        Iterator<T> r115 = r114.iterator();
    L40:
        if (r115.hasNext() == false) goto L37;
        r r116 = (r) CollectionsKt.firstOrNull(((u) r115.next()).f505342a);
        boolean r117 = false;
        if (r116 != null) goto L44;
    L46:
        boolean r118 = false;
    L47:
        if (r118 == false) goto L40;
    L48:
        if (r117 == false) goto L50;
        r102.add(new j(r105));
        return new u(r102, r113);
    L50:
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator<T> r120 = r114.iterator();
    L52:
        if (r120.hasNext() == false) goto L61;
        u r121 = (u) r120.next();
        r r122 = (r) CollectionsKt.firstOrNull(r121.f505342a);
        if ((r122 instanceof j) == false) goto L56;
        u r123 = new u(CollectionsKt.plus(CollectionsKt.listOf(new j(CollectionsKt.plus(r105, ((j) r122).f505329a))), CollectionsKt.drop(r121.f505342a, 1)), r121.f505343b);
    L59:
        r119.add(r123);
        goto L52
    L56:
        if (r122 != null) goto L58;
        r123 = new u(CollectionsKt.listOf(new j(r105)), r121.f505343b);
        goto L59
    L58:
        r123 = new u(CollectionsKt.plus(CollectionsKt.listOf(new j(r105)), r121.f505342a), r121.f505343b);
        goto L59
    L61:
        return new u(r102, r119);
    L44:
        if ((r116 instanceof j) != true) goto L46;
        r118 = true;
    L37:
        r117 = true;
        goto L48
    L36:
        if (r114.isEmpty() == false) goto L38;
    L86:
        return new u(r102, r113);
    }
}
