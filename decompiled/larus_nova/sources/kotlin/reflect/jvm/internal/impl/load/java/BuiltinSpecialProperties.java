package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes42.dex */
public final class BuiltinSpecialProperties {
    private static final Set<FqName> GETTER_FQ_NAMES = null;
    private static final Map<Name, List<Name>> GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = null;
    public static final BuiltinSpecialProperties INSTANCE = null;
    private static final Map<FqName, Name> PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = null;
    private static final Set<FqName> SPECIAL_FQ_NAMES = null;
    private static final Set<Name> SPECIAL_SHORT_NAMES = null;

    private BuiltinSpecialProperties() {
    }

    static {
        INSTANCE = new BuiltinSpecialProperties();
        FqNameUnsafe r100 = StandardNames.FqNames._enum;
        FqName r101 = StandardNames.FqNames.map;
        Map<FqName, Name> r102 = MapsKt.mapOf(new Pair[]{TuplesKt.to(BuiltinSpecialPropertiesKt.access$childSafe(r100, "name"), StandardNames.NAME), TuplesKt.to(BuiltinSpecialPropertiesKt.access$childSafe(r100, "ordinal"), Name.identifier("ordinal")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(StandardNames.FqNames.collection, "size"), Name.identifier("size")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(r101, "size"), Name.identifier("size")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$childSafe(StandardNames.FqNames.charSequence, "length"), Name.identifier("length")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(r101, "keys"), Name.identifier("keySet")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(r101, "values"), Name.identifier("values")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(r101, "entries"), Name.identifier("entrySet"))});
        PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = r102;
        Set<Map.Entry<FqName, Name>> r103 = r102.entrySet();
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        Map.Entry r106 = (Map.Entry) r105.next();
        r104.add(new Pair(((FqName) r106.getKey()).shortName(), r106.getValue()));
        goto L4
    L6:
        LinkedHashMap r107 = new LinkedHashMap();
        Iterator r108 = r104.iterator();
    L8:
        if (r108.hasNext() == false) goto L13;
        Pair r109 = (Pair) r108.next();
        Name r110 = (Name) r109.getSecond();
        Object r111 = r107.get(r110);
        if (r111 != null) goto L12;
        r111 = new ArrayList();
        r107.put(r110, r111);
    L12:
        ((List) r111).add((Name) r109.getFirst());
        goto L8
    L13:
        LinkedHashMap r112 = new LinkedHashMap(MapsKt.mapCapacity(r107.size()));
        Iterator r113 = r107.entrySet().iterator();
    L15:
        if (r113.hasNext() == false) goto L17;
        Map.Entry r114 = (Map.Entry) r113.next();
        r112.put(r114.getKey(), CollectionsKt.distinct((Iterable) r114.getValue()));
        goto L15
    L17:
        GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = r112;
        Map<FqName, Name> r115 = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
        LinkedHashSet r116 = new LinkedHashSet();
        Iterator<Map.Entry<FqName, Name>> r117 = r115.entrySet().iterator();
    L19:
        if (r117.hasNext() == false) goto L21;
        Map.Entry<FqName, Name> r118 = r117.next();
        ClassId r119 = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(r118.getKey().parent().toUnsafe());
        Intrinsics.checkNotNull(r119);
        r116.add(r119.asSingleFqName().child(r118.getValue()));
        goto L19
    L21:
        GETTER_FQ_NAMES = r116;
        Set<FqName> r120 = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.keySet();
        SPECIAL_FQ_NAMES = r120;
        Set<FqName> r121 = r120;
        ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
        Iterator<T> r123 = r121.iterator();
    L23:
        if (r123.hasNext() == false) goto L25;
        r122.add(((FqName) r123.next()).shortName());
        goto L23
    L25:
        SPECIAL_SHORT_NAMES = CollectionsKt.toSet(r122);
    }

    public final Map<FqName, Name> getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP() {
        return PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    }

    public final Set<FqName> getSPECIAL_FQ_NAMES() {
        return SPECIAL_FQ_NAMES;
    }

    public final Set<Name> getSPECIAL_SHORT_NAMES() {
        return SPECIAL_SHORT_NAMES;
    }

    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(Name r100) {
        Intrinsics.checkNotNullParameter(r100, "name1");
        List<Name> r101 = GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return CollectionsKt.emptyList();
    }
}
