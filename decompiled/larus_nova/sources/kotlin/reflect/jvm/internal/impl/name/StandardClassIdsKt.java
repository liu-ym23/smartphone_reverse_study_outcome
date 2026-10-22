package kotlin.reflect.jvm.internal.impl.name;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
public final class StandardClassIdsKt {
    public static final /* synthetic */ ClassId access$annotationId(String r100) {
        return annotationId(r100);
    }

    public static final /* synthetic */ ClassId access$baseId(String r100) {
        return baseId(r100);
    }

    public static final /* synthetic */ ClassId access$collectionsId(String r100) {
        return collectionsId(r100);
    }

    public static final /* synthetic */ ClassId access$coroutinesId(String r100) {
        return coroutinesId(r100);
    }

    public static final /* synthetic */ ClassId access$enumsId(String r100) {
        return enumsId(r100);
    }

    public static final /* synthetic */ Map access$inverseMap(Map r100) {
        return inverseMap(r100);
    }

    public static final /* synthetic */ ClassId access$primitiveArrayId(Name r100) {
        return primitiveArrayId(r100);
    }

    public static final /* synthetic */ ClassId access$rangesId(String r100) {
        return rangesId(r100);
    }

    public static final /* synthetic */ ClassId access$reflectId(String r100) {
        return reflectId(r100);
    }

    public static final /* synthetic */ ClassId access$unsignedId(ClassId r100) {
        return unsignedId(r100);
    }

    private static final ClassId annotationId(String r100) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_ANNOTATION_PACKAGE(), Name.identifier(r100));
    }

    private static final ClassId baseId(String r100) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_KOTLIN_PACKAGE(), Name.identifier(r100));
    }

    private static final ClassId collectionsId(String r100) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_COLLECTIONS_PACKAGE(), Name.identifier(r100));
    }

    private static final ClassId coroutinesId(String r100) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_COROUTINES_PACKAGE(), Name.identifier(r100));
    }

    private static final ClassId enumsId(String r100) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_ENUMS_PACKAGE(), Name.identifier(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <K, V> Map<V, K> inverseMap(Map<K, ? extends V> r100) {
        Set<Map.Entry<K, ? extends V>> r101 = r100.entrySet();
        LinkedHashMap r102 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r101, 10)), 16));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry r104 = (Map.Entry) r103.next();
        Object r105 = r104.getKey();
        Pair r106 = TuplesKt.to(r104.getValue(), r105);
        r102.put(r106.getFirst(), r106.getSecond());
        goto L4
    L6:
        return r102;
    }

    private static final ClassId primitiveArrayId(Name r100) {
        StandardClassIds r101 = StandardClassIds.INSTANCE;
        return new ClassId(r101.getArray().getPackageFqName(), Name.identifier(r100.getIdentifier() + r101.getArray().getShortClassName().getIdentifier()));
    }

    private static final ClassId rangesId(String r100) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_RANGES_PACKAGE(), Name.identifier(r100));
    }

    private static final ClassId reflectId(String r100) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_REFLECT_PACKAGE(), Name.identifier(r100));
    }

    private static final ClassId unsignedId(ClassId r100) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_KOTLIN_PACKAGE(), Name.identifier("U" + r100.getShortClassName().getIdentifier()));
    }
}
