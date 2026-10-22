package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.name.StandardClassIds;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class JavaToKotlinClassMap {
    private static final ClassId CLASS_CLASS_ID = null;
    private static final ClassId FUNCTION_N_CLASS_ID = null;
    private static final FqName FUNCTION_N_FQ_NAME = null;
    public static final JavaToKotlinClassMap INSTANCE = null;
    private static final ClassId K_CLASS_CLASS_ID = null;
    private static final ClassId K_FUNCTION_CLASS_ID = null;
    private static final String NUMBERED_FUNCTION_PREFIX = null;
    private static final String NUMBERED_K_FUNCTION_PREFIX = null;
    private static final String NUMBERED_K_SUSPEND_FUNCTION_PREFIX = null;
    private static final String NUMBERED_SUSPEND_FUNCTION_PREFIX = null;
    private static final HashMap<FqNameUnsafe, ClassId> javaToKotlin = null;
    private static final HashMap<FqNameUnsafe, ClassId> kotlinToJava = null;
    private static final List<PlatformMutabilityMapping> mutabilityMappings = null;
    private static final HashMap<FqNameUnsafe, FqName> mutableToReadOnly = null;
    private static final HashMap<ClassId, ClassId> mutableToReadOnlyClassId = null;
    private static final HashMap<FqNameUnsafe, FqName> readOnlyToMutable = null;
    private static final HashMap<ClassId, ClassId> readOnlyToMutableClassId = null;

    public static final class PlatformMutabilityMapping {
        private final ClassId javaClass;
        private final ClassId kotlinMutable;
        private final ClassId kotlinReadOnly;

        public final ClassId component1() {
            return this.javaClass;
        }

        public final ClassId component2() {
            return this.kotlinReadOnly;
        }

        public final ClassId component3() {
            return this.kotlinMutable;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof PlatformMutabilityMapping) == true) goto L8;
            return false;
        L8:
            PlatformMutabilityMapping r101 = (PlatformMutabilityMapping) r100;
            if (Intrinsics.areEqual(this.javaClass, r101.javaClass) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.kotlinReadOnly, r101.kotlinReadOnly) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.kotlinMutable, r101.kotlinMutable) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.javaClass.hashCode() * 31) + this.kotlinReadOnly.hashCode()) * 31) + this.kotlinMutable.hashCode();
        }

        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.javaClass + ", kotlinReadOnly=" + this.kotlinReadOnly + ", kotlinMutable=" + this.kotlinMutable + ')';
        }

        public final ClassId getJavaClass() {
            return this.javaClass;
        }

        public PlatformMutabilityMapping(ClassId r100, ClassId r101, ClassId r102) {
            Intrinsics.checkNotNullParameter(r100, "javaClass");
            Intrinsics.checkNotNullParameter(r101, "kotlinReadOnly");
            Intrinsics.checkNotNullParameter(r102, "kotlinMutable");
            this.javaClass = r100;
            this.kotlinReadOnly = r101;
            this.kotlinMutable = r102;
        }
    }

    private JavaToKotlinClassMap() {
    }

    static {
        JavaToKotlinClassMap r100 = new JavaToKotlinClassMap();
        INSTANCE = r100;
        StringBuilder r101 = new StringBuilder();
        FunctionTypeKind.Function r102 = FunctionTypeKind.Function.INSTANCE;
        r101.append(r102.getPackageFqName());
        r101.append('.');
        r101.append(r102.getClassNamePrefix());
        NUMBERED_FUNCTION_PREFIX = r101.toString();
        StringBuilder r103 = new StringBuilder();
        FunctionTypeKind.KFunction r104 = FunctionTypeKind.KFunction.INSTANCE;
        r103.append(r104.getPackageFqName());
        r103.append('.');
        r103.append(r104.getClassNamePrefix());
        NUMBERED_K_FUNCTION_PREFIX = r103.toString();
        StringBuilder r105 = new StringBuilder();
        FunctionTypeKind.SuspendFunction r106 = FunctionTypeKind.SuspendFunction.INSTANCE;
        r105.append(r106.getPackageFqName());
        r105.append('.');
        r105.append(r106.getClassNamePrefix());
        NUMBERED_SUSPEND_FUNCTION_PREFIX = r105.toString();
        StringBuilder r107 = new StringBuilder();
        FunctionTypeKind.KSuspendFunction r108 = FunctionTypeKind.KSuspendFunction.INSTANCE;
        r107.append(r108.getPackageFqName());
        r107.append('.');
        r107.append(r108.getClassNamePrefix());
        NUMBERED_K_SUSPEND_FUNCTION_PREFIX = r107.toString();
        ClassId.Companion r109 = ClassId.Companion;
        ClassId r110 = r109.topLevel(new FqName("kotlin.jvm.functions.FunctionN"));
        FUNCTION_N_CLASS_ID = r110;
        FUNCTION_N_FQ_NAME = r110.asSingleFqName();
        StandardClassIds r111 = StandardClassIds.INSTANCE;
        K_FUNCTION_CLASS_ID = r111.getKFunction();
        K_CLASS_CLASS_ID = r111.getKClass();
        CLASS_CLASS_ID = r100.classId(Class.class);
        javaToKotlin = new HashMap();
        kotlinToJava = new HashMap();
        mutableToReadOnly = new HashMap();
        readOnlyToMutable = new HashMap();
        mutableToReadOnlyClassId = new HashMap();
        readOnlyToMutableClassId = new HashMap();
        ClassId r112 = r109.topLevel(StandardNames.FqNames.iterable);
        int r113 = 0;
        ClassId r114 = new ClassId(r112.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableIterable, r112.getPackageFqName()), false);
        ClassId r115 = r109.topLevel(StandardNames.FqNames.iterator);
        ClassId r116 = new ClassId(r115.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableIterator, r115.getPackageFqName()), false);
        ClassId r117 = r109.topLevel(StandardNames.FqNames.collection);
        ClassId r118 = new ClassId(r117.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableCollection, r117.getPackageFqName()), false);
        ClassId r119 = r109.topLevel(StandardNames.FqNames.list);
        ClassId r120 = new ClassId(r119.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableList, r119.getPackageFqName()), false);
        ClassId r121 = r109.topLevel(StandardNames.FqNames.set);
        ClassId r122 = new ClassId(r121.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableSet, r121.getPackageFqName()), false);
        ClassId r123 = r109.topLevel(StandardNames.FqNames.listIterator);
        ClassId r124 = new ClassId(r123.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableListIterator, r123.getPackageFqName()), false);
        FqName r125 = StandardNames.FqNames.map;
        ClassId r126 = r109.topLevel(r125);
        ClassId r127 = new ClassId(r126.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableMap, r126.getPackageFqName()), false);
        ClassId r128 = r109.topLevel(r125).createNestedClassId(StandardNames.FqNames.mapEntry.shortName());
        List<PlatformMutabilityMapping> r129 = CollectionsKt.listOf(new PlatformMutabilityMapping[]{new PlatformMutabilityMapping(r100.classId(Iterable.class), r112, r114), new PlatformMutabilityMapping(r100.classId(Iterator.class), r115, r116), new PlatformMutabilityMapping(r100.classId(Collection.class), r117, r118), new PlatformMutabilityMapping(r100.classId(List.class), r119, r120), new PlatformMutabilityMapping(r100.classId(Set.class), r121, r122), new PlatformMutabilityMapping(r100.classId(ListIterator.class), r123, r124), new PlatformMutabilityMapping(r100.classId(Map.class), r126, r127), new PlatformMutabilityMapping(r100.classId(Map.Entry.class), r128, new ClassId(r128.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableMapEntry, r128.getPackageFqName()), false))});
        mutabilityMappings = r129;
        r100.addTopLevel(Object.class, StandardNames.FqNames.any);
        r100.addTopLevel(String.class, StandardNames.FqNames.string);
        r100.addTopLevel(CharSequence.class, StandardNames.FqNames.charSequence);
        r100.addTopLevel(Throwable.class, StandardNames.FqNames.throwable);
        r100.addTopLevel(Cloneable.class, StandardNames.FqNames.cloneable);
        r100.addTopLevel(Number.class, StandardNames.FqNames.number);
        r100.addTopLevel(Comparable.class, StandardNames.FqNames.comparable);
        r100.addTopLevel(Enum.class, StandardNames.FqNames._enum);
        r100.addTopLevel(Annotation.class, StandardNames.FqNames.f504566annotation);
        Iterator<PlatformMutabilityMapping> r130 = r129.iterator();
    L4:
        if (r130.hasNext() == false) goto L6;
        INSTANCE.addMapping(r130.next());
        goto L4
    L6:
        JvmPrimitiveType[] r131 = JvmPrimitiveType.values();
        int r132 = r131.length;
        int r133 = 0;
    L7:
        if (r133 >= r132) goto L9;
        JvmPrimitiveType r134 = r131[r133];
        JavaToKotlinClassMap r135 = INSTANCE;
        ClassId.Companion r136 = ClassId.Companion;
        r135.add(r136.topLevel(r134.getWrapperFqName()), r136.topLevel(StandardNames.getPrimitiveFqName(r134.getPrimitiveType())));
        r133 = r133 + 1;
        goto L7
    L9:
        Iterator<ClassId> r137 = CompanionObjectMapping.INSTANCE.allClassesWithIntrinsicCompanions().iterator();
    L11:
        if (r137.hasNext() == false) goto L13;
        ClassId r138 = r137.next();
        INSTANCE.add(ClassId.Companion.topLevel(new FqName("kotlin.jvm.internal." + r138.getShortClassName().asString() + "CompanionObject")), r138.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT));
        goto L11
    L13:
        int r139 = 0;
    L15:
        if (r139 >= 23) goto L18;
        JavaToKotlinClassMap r140 = INSTANCE;
        r140.add(ClassId.Companion.topLevel(new FqName("kotlin.jvm.functions.Function" + r139)), StandardNames.getFunctionClassId(r139));
        r140.addKotlinToJava(new FqName(NUMBERED_K_FUNCTION_PREFIX + r139), K_FUNCTION_CLASS_ID);
        r139 = r139 + 1;
    L18:
        if (r113 >= 22) goto L20;
        FunctionTypeKind.KSuspendFunction r141 = FunctionTypeKind.KSuspendFunction.INSTANCE;
        String r142 = r141.getPackageFqName() + '.' + r141.getClassNamePrefix();
        INSTANCE.addKotlinToJava(new FqName(r142 + r113), K_FUNCTION_CLASS_ID);
        r113 = r113 + 1;
        goto L18
    L20:
        JavaToKotlinClassMap r143 = INSTANCE;
        r143.addKotlinToJava(StandardNames.FqNames.nothing.toSafe(), r143.classId(Void.class));
    }

    public final FqName getFUNCTION_N_FQ_NAME() {
        return FUNCTION_N_FQ_NAME;
    }

    public final List<PlatformMutabilityMapping> getMutabilityMappings() {
        return mutabilityMappings;
    }

    private final void addMapping(PlatformMutabilityMapping r100) {
        ClassId r101 = r100.component1();
        ClassId r102 = r100.component2();
        ClassId r103 = r100.component3();
        add(r101, r102);
        addKotlinToJava(r103.asSingleFqName(), r101);
        mutableToReadOnlyClassId.put(r103, r102);
        readOnlyToMutableClassId.put(r102, r103);
        FqName r104 = r102.asSingleFqName();
        FqName r105 = r103.asSingleFqName();
        mutableToReadOnly.put(r103.asSingleFqName().toUnsafe(), r104);
        readOnlyToMutable.put(r104.toUnsafe(), r105);
    }

    private final ClassId classId(Class<?> r100) {
        if (r100.isPrimitive() == true) goto L5;
        r100.isArray();
    L5:
        Class<?> r101 = r100.getDeclaringClass();
        if (r101 != null) goto L9;
        return ClassId.Companion.topLevel(new FqName(r100.getCanonicalName()));
    L9:
        return classId(r101).createNestedClassId(Name.identifier(r100.getSimpleName()));
    }

    public final boolean isMutable(FqNameUnsafe r100) {
        return mutableToReadOnly.containsKey(r100);
    }

    public final boolean isReadOnly(FqNameUnsafe r100) {
        return readOnlyToMutable.containsKey(r100);
    }

    public final ClassId mapJavaToKotlin(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        return javaToKotlin.get(r100.toUnsafe());
    }

    public final ClassId mapKotlinToJava(FqNameUnsafe r100) {
        Intrinsics.checkNotNullParameter(r100, "kotlinFqName");
        if (isKotlinFunctionWithBigArity(r100, NUMBERED_FUNCTION_PREFIX) == false) goto L6;
        return FUNCTION_N_CLASS_ID;
    L6:
        if (isKotlinFunctionWithBigArity(r100, NUMBERED_SUSPEND_FUNCTION_PREFIX) == false) goto L9;
        return FUNCTION_N_CLASS_ID;
    L9:
        if (isKotlinFunctionWithBigArity(r100, NUMBERED_K_FUNCTION_PREFIX) == false) goto L12;
        return K_FUNCTION_CLASS_ID;
    L12:
        if (isKotlinFunctionWithBigArity(r100, NUMBERED_K_SUSPEND_FUNCTION_PREFIX) == false) goto L15;
        return K_FUNCTION_CLASS_ID;
    L15:
        return kotlinToJava.get(r100);
    }

    public final FqName mutableToReadOnly(FqNameUnsafe r100) {
        return mutableToReadOnly.get(r100);
    }

    public final FqName readOnlyToMutable(FqNameUnsafe r100) {
        return readOnlyToMutable.get(r100);
    }

    private final void add(ClassId r100, ClassId r101) {
        addJavaToKotlin(r100, r101);
        addKotlinToJava(r101.asSingleFqName(), r100);
    }

    private final void addJavaToKotlin(ClassId r100, ClassId r101) {
        javaToKotlin.put(r100.asSingleFqName().toUnsafe(), r101);
    }

    private final void addKotlinToJava(FqName r100, ClassId r101) {
        kotlinToJava.put(r100.toUnsafe(), r101);
    }

    private final void addTopLevel(Class<?> r100, FqName r101) {
        add(classId(r100), ClassId.Companion.topLevel(r101));
    }

    private final boolean isKotlinFunctionWithBigArity(FqNameUnsafe r100, String r101) {
        String r102 = r100.asString();
        if (StringsKt.startsWith$default(r102, r101, false, 2, null) == true) goto L5;
        return false;
    L5:
        String r103 = r102.substring(r101.length());
        if (StringsKt.startsWith$default(r103, '0', false, 2, null) == true) goto L13;
        Integer r104 = StringsKt.toIntOrNull(r103);
        if (r104 != null) goto L10;
        return false;
    L10:
        if (r104.intValue() < 23) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    private final void addTopLevel(Class<?> r100, FqNameUnsafe r101) {
        addTopLevel(r100, r101.toSafe());
    }
}
