package io.ktor.http;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes41.dex */
public final class FileContentTypeKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f491812a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f491813b = null;

    static {
        f491812a = LazyKt.lazy(FileContentTypeKt$contentTypesByExtensions$2.INSTANCE);
        f491813b = LazyKt.lazy(FileContentTypeKt$extensionsByContentType$2.INSTANCE);
    }

    public static final <A, B> Map<A, List<B>> a(Sequence<? extends Pair<? extends A, ? extends B>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<? extends Pair<? extends A, ? extends B>> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Pair<? extends A, ? extends B> r103 = r102.next();
        A r104 = r103.getFirst();
        Object r105 = r101.get(r104);
        if (r105 != null) goto L8;
        r105 = new ArrayList();
        r101.put(r104, r105);
    L8:
        ((List) r105).add(r103);
        goto L4
    L9:
        LinkedHashMap r106 = new LinkedHashMap(MapsKt.mapCapacity(r101.size()));
        Iterator r107 = r101.entrySet().iterator();
    L11:
        if (r107.hasNext() == false) goto L17;
        Map.Entry r108 = (Map.Entry) r107.next();
        Object r109 = r108.getKey();
        Iterable r110 = (Iterable) r108.getValue();
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r112 = r110.iterator();
    L14:
        if (r112.hasNext() == false) goto L16;
        r111.add(((Pair) r112.next()).getSecond());
        goto L14
    L16:
        r106.put(r109, r111);
        goto L11
    L17:
        return r106;
    }
}
