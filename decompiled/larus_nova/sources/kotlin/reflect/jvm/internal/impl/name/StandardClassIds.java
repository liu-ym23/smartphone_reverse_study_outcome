package kotlin.reflect.jvm.internal.impl.name;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
public final class StandardClassIds {
    private static final ClassId Annotation = null;
    private static final ClassId AnnotationRetention = null;
    private static final ClassId AnnotationTarget = null;
    private static final ClassId Any = null;
    private static final ClassId Array = null;
    private static final FqName BASE_ANNOTATION_PACKAGE = null;
    private static final FqName BASE_COLLECTIONS_PACKAGE = null;
    private static final FqName BASE_CONCURRENT_PACKAGE = null;
    private static final FqName BASE_CONTRACTS_PACKAGE = null;
    private static final FqName BASE_COROUTINES_PACKAGE = null;
    private static final FqName BASE_ENUMS_PACKAGE = null;
    private static final FqName BASE_INTERNAL_IR_PACKAGE = null;
    private static final FqName BASE_INTERNAL_PACKAGE = null;
    private static final FqName BASE_JVM_FUNCTIONS_PACKAGE = null;
    private static final FqName BASE_JVM_INTERNAL_PACKAGE = null;
    private static final FqName BASE_JVM_PACKAGE = null;
    private static final FqName BASE_KOTLIN_PACKAGE = null;
    private static final FqName BASE_RANGES_PACKAGE = null;
    private static final FqName BASE_REFLECT_PACKAGE = null;
    private static final FqName BASE_TEST_PACKAGE = null;
    private static final ClassId Boolean = null;
    private static final ClassId Byte = null;
    private static final ClassId Char = null;
    private static final ClassId CharIterator = null;
    private static final ClassId CharRange = null;
    private static final ClassId CharSequence = null;
    private static final ClassId Cloneable = null;
    private static final ClassId Collection = null;
    private static final ClassId Comparable = null;
    private static final ClassId Continuation = null;
    private static final ClassId DeprecationLevel = null;
    private static final ClassId Double = null;
    private static final ClassId Enum = null;
    private static final ClassId EnumEntries = null;
    private static final ClassId Float = null;
    private static final ClassId Function = null;
    public static final StandardClassIds INSTANCE = null;
    private static final ClassId Int = null;
    private static final ClassId IntRange = null;
    private static final ClassId Iterable = null;
    private static final ClassId Iterator = null;
    private static final ClassId KCallable = null;
    private static final ClassId KClass = null;
    private static final ClassId KFunction = null;
    private static final ClassId KMutableProperty = null;
    private static final ClassId KMutableProperty0 = null;
    private static final ClassId KMutableProperty1 = null;
    private static final ClassId KMutableProperty2 = null;
    private static final ClassId KProperty = null;
    private static final ClassId KProperty0 = null;
    private static final ClassId KProperty1 = null;
    private static final ClassId KProperty2 = null;
    private static final ClassId KType = null;
    private static final ClassId List = null;
    private static final ClassId ListIterator = null;
    private static final ClassId Long = null;
    private static final ClassId LongRange = null;
    private static final ClassId Map = null;
    private static final ClassId MapEntry = null;
    private static final ClassId MutableCollection = null;
    private static final ClassId MutableIterable = null;
    private static final ClassId MutableIterator = null;
    private static final ClassId MutableList = null;
    private static final ClassId MutableListIterator = null;
    private static final ClassId MutableMap = null;
    private static final ClassId MutableMapEntry = null;
    private static final ClassId MutableSet = null;
    private static final ClassId Nothing = null;
    private static final ClassId Number = null;
    private static final ClassId Result = null;
    private static final ClassId Set = null;
    private static final ClassId Short = null;
    private static final ClassId String = null;
    private static final ClassId Throwable = null;
    private static final ClassId UByte = null;
    private static final ClassId UInt = null;
    private static final ClassId ULong = null;
    private static final ClassId UShort = null;
    private static final ClassId Unit = null;
    private static final Set<ClassId> allBuiltinTypes = null;
    private static final Set<FqName> builtInsPackages = null;
    private static final Set<FqName> builtInsPackagesWithDefaultNamedImport = null;
    private static final Set<ClassId> constantAllowedTypes = null;
    private static final Map<ClassId, ClassId> elementTypeByPrimitiveArrayType = null;
    private static final Map<ClassId, ClassId> elementTypeByUnsignedArrayType = null;
    private static final Map<ClassId, ClassId> primitiveArrayTypeByElementType = null;
    private static final Set<ClassId> primitiveTypes = null;
    private static final Map<ClassId, ClassId> unsignedArrayTypeByElementType = null;
    private static final Set<ClassId> unsignedTypes = null;

    private StandardClassIds() {
    }

    static {
        INSTANCE = new StandardClassIds();
        FqName r100 = new FqName("kotlin");
        BASE_KOTLIN_PACKAGE = r100;
        FqName r101 = r100.child(Name.identifier("reflect"));
        BASE_REFLECT_PACKAGE = r101;
        FqName r102 = r100.child(Name.identifier("collections"));
        BASE_COLLECTIONS_PACKAGE = r102;
        FqName r103 = r100.child(Name.identifier("ranges"));
        BASE_RANGES_PACKAGE = r103;
        FqName r104 = r100.child(Name.identifier("jvm"));
        BASE_JVM_PACKAGE = r104;
        BASE_JVM_INTERNAL_PACKAGE = r104.child(Name.identifier("internal"));
        BASE_JVM_FUNCTIONS_PACKAGE = r104.child(Name.identifier("functions"));
        FqName r105 = r100.child(Name.identifier("annotation"));
        BASE_ANNOTATION_PACKAGE = r105;
        FqName r106 = r100.child(Name.identifier("internal"));
        BASE_INTERNAL_PACKAGE = r106;
        BASE_INTERNAL_IR_PACKAGE = r106.child(Name.identifier("ir"));
        FqName r107 = r100.child(Name.identifier("coroutines"));
        BASE_COROUTINES_PACKAGE = r107;
        BASE_ENUMS_PACKAGE = r100.child(Name.identifier("enums"));
        BASE_CONTRACTS_PACKAGE = r100.child(Name.identifier("contracts"));
        BASE_CONCURRENT_PACKAGE = r100.child(Name.identifier("concurrent"));
        BASE_TEST_PACKAGE = r100.child(Name.identifier(EffectConstants.CHANNEL_TEST));
        builtInsPackagesWithDefaultNamedImport = SetsKt.setOf(new FqName[]{r100, r102, r103, r105});
        builtInsPackages = SetsKt.setOf(new FqName[]{r100, r102, r103, r105, r101, r106, r107});
        Nothing = StandardClassIdsKt.access$baseId("Nothing");
        Unit = StandardClassIdsKt.access$baseId("Unit");
        Any = StandardClassIdsKt.access$baseId("Any");
        Enum = StandardClassIdsKt.access$baseId("Enum");
        Annotation = StandardClassIdsKt.access$baseId("Annotation");
        Array = StandardClassIdsKt.access$baseId("Array");
        ClassId r108 = StandardClassIdsKt.access$baseId("Boolean");
        Boolean = r108;
        ClassId r109 = StandardClassIdsKt.access$baseId("Char");
        Char = r109;
        ClassId r110 = StandardClassIdsKt.access$baseId("Byte");
        Byte = r110;
        ClassId r111 = StandardClassIdsKt.access$baseId("Short");
        Short = r111;
        ClassId r112 = StandardClassIdsKt.access$baseId("Int");
        Int = r112;
        ClassId r113 = StandardClassIdsKt.access$baseId("Long");
        Long = r113;
        ClassId r114 = StandardClassIdsKt.access$baseId("Float");
        Float = r114;
        ClassId r115 = StandardClassIdsKt.access$baseId("Double");
        Double = r115;
        UByte = StandardClassIdsKt.access$unsignedId(r110);
        UShort = StandardClassIdsKt.access$unsignedId(r111);
        UInt = StandardClassIdsKt.access$unsignedId(r112);
        ULong = StandardClassIdsKt.access$unsignedId(r113);
        CharSequence = StandardClassIdsKt.access$baseId("CharSequence");
        String = StandardClassIdsKt.access$baseId("String");
        Throwable = StandardClassIdsKt.access$baseId("Throwable");
        Cloneable = StandardClassIdsKt.access$baseId("Cloneable");
        KProperty = StandardClassIdsKt.access$reflectId("KProperty");
        KMutableProperty = StandardClassIdsKt.access$reflectId("KMutableProperty");
        KProperty0 = StandardClassIdsKt.access$reflectId("KProperty0");
        KMutableProperty0 = StandardClassIdsKt.access$reflectId("KMutableProperty0");
        KProperty1 = StandardClassIdsKt.access$reflectId("KProperty1");
        KMutableProperty1 = StandardClassIdsKt.access$reflectId("KMutableProperty1");
        KProperty2 = StandardClassIdsKt.access$reflectId("KProperty2");
        KMutableProperty2 = StandardClassIdsKt.access$reflectId("KMutableProperty2");
        KFunction = StandardClassIdsKt.access$reflectId("KFunction");
        KClass = StandardClassIdsKt.access$reflectId("KClass");
        KCallable = StandardClassIdsKt.access$reflectId("KCallable");
        KType = StandardClassIdsKt.access$reflectId("KType");
        Comparable = StandardClassIdsKt.access$baseId("Comparable");
        Number = StandardClassIdsKt.access$baseId("Number");
        Function = StandardClassIdsKt.access$baseId("Function");
        Set<ClassId> r116 = SetsKt.setOf(new ClassId[]{r108, r109, r110, r111, r112, r113, r114, r115});
        primitiveTypes = r116;
        Set<ClassId> r117 = r116;
        LinkedHashMap r118 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r117, 10)), 16));
        Iterator<T> r119 = r117.iterator();
    L4:
        if (r119.hasNext() == false) goto L6;
        Object r120 = r119.next();
        r118.put(r120, StandardClassIdsKt.access$primitiveArrayId(((ClassId) r120).getShortClassName()));
        goto L4
    L6:
        primitiveArrayTypeByElementType = r118;
        elementTypeByPrimitiveArrayType = StandardClassIdsKt.access$inverseMap(r118);
        Set<ClassId> r121 = SetsKt.setOf(new ClassId[]{UByte, UShort, UInt, ULong});
        unsignedTypes = r121;
        Set<ClassId> r122 = r121;
        LinkedHashMap r123 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r122, 10)), 16));
        Iterator<T> r124 = r122.iterator();
    L8:
        if (r124.hasNext() == false) goto L10;
        Object r125 = r124.next();
        r123.put(r125, StandardClassIdsKt.access$primitiveArrayId(((ClassId) r125).getShortClassName()));
        goto L8
    L10:
        unsignedArrayTypeByElementType = r123;
        elementTypeByUnsignedArrayType = StandardClassIdsKt.access$inverseMap(r123);
        Set<ClassId> r126 = primitiveTypes;
        Set<ClassId> r127 = unsignedTypes;
        Set r128 = SetsKt.plus(r126, r127);
        ClassId r129 = String;
        constantAllowedTypes = SetsKt.plus(r128, r129);
        Continuation = StandardClassIdsKt.access$coroutinesId("Continuation");
        Iterator = StandardClassIdsKt.access$collectionsId("Iterator");
        Iterable = StandardClassIdsKt.access$collectionsId("Iterable");
        Collection = StandardClassIdsKt.access$collectionsId("Collection");
        List = StandardClassIdsKt.access$collectionsId("List");
        ListIterator = StandardClassIdsKt.access$collectionsId("ListIterator");
        Set = StandardClassIdsKt.access$collectionsId("Set");
        ClassId r130 = StandardClassIdsKt.access$collectionsId("Map");
        Map = r130;
        MutableIterator = StandardClassIdsKt.access$collectionsId("MutableIterator");
        CharIterator = StandardClassIdsKt.access$collectionsId("CharIterator");
        MutableIterable = StandardClassIdsKt.access$collectionsId("MutableIterable");
        MutableCollection = StandardClassIdsKt.access$collectionsId("MutableCollection");
        MutableList = StandardClassIdsKt.access$collectionsId("MutableList");
        MutableListIterator = StandardClassIdsKt.access$collectionsId("MutableListIterator");
        MutableSet = StandardClassIdsKt.access$collectionsId("MutableSet");
        ClassId r131 = StandardClassIdsKt.access$collectionsId("MutableMap");
        MutableMap = r131;
        MapEntry = r130.createNestedClassId(Name.identifier("Entry"));
        MutableMapEntry = r131.createNestedClassId(Name.identifier("MutableEntry"));
        Result = StandardClassIdsKt.access$baseId("Result");
        IntRange = StandardClassIdsKt.access$rangesId("IntRange");
        LongRange = StandardClassIdsKt.access$rangesId("LongRange");
        CharRange = StandardClassIdsKt.access$rangesId("CharRange");
        AnnotationRetention = StandardClassIdsKt.access$annotationId("AnnotationRetention");
        AnnotationTarget = StandardClassIdsKt.access$annotationId("AnnotationTarget");
        DeprecationLevel = StandardClassIdsKt.access$baseId("DeprecationLevel");
        EnumEntries = StandardClassIdsKt.access$enumsId("EnumEntries");
        allBuiltinTypes = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(r126, r127), r129), Unit), Any), Enum);
    }

    public final ClassId getArray() {
        return Array;
    }

    public final FqName getBASE_ANNOTATION_PACKAGE() {
        return BASE_ANNOTATION_PACKAGE;
    }

    public final FqName getBASE_COLLECTIONS_PACKAGE() {
        return BASE_COLLECTIONS_PACKAGE;
    }

    public final FqName getBASE_COROUTINES_PACKAGE() {
        return BASE_COROUTINES_PACKAGE;
    }

    public final FqName getBASE_ENUMS_PACKAGE() {
        return BASE_ENUMS_PACKAGE;
    }

    public final FqName getBASE_KOTLIN_PACKAGE() {
        return BASE_KOTLIN_PACKAGE;
    }

    public final FqName getBASE_RANGES_PACKAGE() {
        return BASE_RANGES_PACKAGE;
    }

    public final FqName getBASE_REFLECT_PACKAGE() {
        return BASE_REFLECT_PACKAGE;
    }

    public final ClassId getEnumEntries() {
        return EnumEntries;
    }

    public final ClassId getKClass() {
        return KClass;
    }

    public final ClassId getKFunction() {
        return KFunction;
    }

    public final ClassId getMutableList() {
        return MutableList;
    }

    public final ClassId getMutableMap() {
        return MutableMap;
    }

    public final ClassId getMutableSet() {
        return MutableSet;
    }
}
