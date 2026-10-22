package kotlin.reflect.jvm.internal.impl.builtins;

import com.bytedance.android.service.manager.pull.PullConfiguration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class StandardNames {
    public static final FqName ANNOTATION_PACKAGE_FQ_NAME = null;
    public static final Name BACKING_FIELD = null;
    public static final FqName BUILT_INS_PACKAGE_FQ_NAME = null;
    public static final Set<FqName> BUILT_INS_PACKAGE_FQ_NAMES = null;
    public static final Name BUILT_INS_PACKAGE_NAME = null;
    public static final Name CHAR_CODE = null;
    public static final FqName COLLECTIONS_PACKAGE_FQ_NAME = null;
    public static final Name CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME = null;
    public static final FqName CONTINUATION_INTERFACE_FQ_NAME = null;
    public static final FqName COROUTINES_INTRINSICS_PACKAGE_FQ_NAME = null;
    public static final FqName COROUTINES_JVM_INTERNAL_PACKAGE_FQ_NAME = null;
    public static final FqName COROUTINES_PACKAGE_FQ_NAME = null;
    public static final String DATA_CLASS_COMPONENT_PREFIX = null;
    public static final Name DATA_CLASS_COPY = null;
    public static final Name DEFAULT_VALUE_PARAMETER = null;
    public static final FqName DYNAMIC_FQ_NAME = null;
    public static final Name ENUM_ENTRIES = null;
    public static final Name ENUM_VALUES = null;
    public static final Name ENUM_VALUE_OF = null;
    public static final Name EQUALS_NAME = null;
    public static final Name HASHCODE_NAME = null;
    public static final Name IMPLICIT_LAMBDA_PARAMETER_NAME = null;
    public static final StandardNames INSTANCE = null;
    public static final FqName KOTLIN_INTERNAL_FQ_NAME = null;
    public static final FqName KOTLIN_REFLECT_FQ_NAME = null;
    public static final Name MAIN = null;
    public static final Name NAME = null;
    public static final Name NEXT_CHAR = null;
    private static final FqName NON_EXISTENT_CLASS = null;
    public static final List<String> PREFIXES = null;
    public static final FqName RANGES_PACKAGE_FQ_NAME = null;
    public static final FqName RESULT_FQ_NAME = null;
    public static final FqName TEXT_PACKAGE_FQ_NAME = null;
    public static final Name TO_STRING_NAME = null;

    public static final class FqNames {
        public static final FqNames INSTANCE = null;
        public static final FqNameUnsafe _boolean = null;
        public static final FqNameUnsafe _byte = null;
        public static final FqNameUnsafe _char = null;
        public static final FqNameUnsafe _double = null;
        public static final FqNameUnsafe _enum = null;
        public static final FqNameUnsafe _float = null;
        public static final FqNameUnsafe _int = null;
        public static final FqNameUnsafe _long = null;
        public static final FqNameUnsafe _short = null;
        public static final FqName accessibleLateinitPropertyLiteral = null;

        /* JADX INFO: renamed from: annotation, reason: collision with root package name */
        public static final FqName f504566annotation = null;
        public static final FqName annotationRetention = null;
        public static final FqName annotationTarget = null;
        public static final FqNameUnsafe any = null;
        public static final FqNameUnsafe array = null;
        public static final Map<FqNameUnsafe, PrimitiveType> arrayClassFqNameToPrimitiveType = null;
        public static final FqNameUnsafe charSequence = null;
        public static final FqNameUnsafe cloneable = null;
        public static final FqName collection = null;
        public static final FqName comparable = null;
        public static final FqName contextFunctionTypeParams = null;
        public static final FqName deprecated = null;
        public static final FqName deprecatedSinceKotlin = null;
        public static final FqName deprecationLevel = null;
        public static final FqName extensionFunctionType = null;
        public static final FqNameUnsafe findAssociatedObject = null;
        public static final Map<FqNameUnsafe, PrimitiveType> fqNameToPrimitiveType = null;
        public static final FqNameUnsafe functionSupertype = null;
        public static final FqNameUnsafe intRange = null;
        public static final FqName iterable = null;
        public static final FqName iterator = null;
        public static final FqNameUnsafe kCallable = null;
        public static final FqNameUnsafe kClass = null;
        public static final FqNameUnsafe kDeclarationContainer = null;
        public static final FqNameUnsafe kMutableProperty0 = null;
        public static final FqNameUnsafe kMutableProperty1 = null;
        public static final FqNameUnsafe kMutableProperty2 = null;
        public static final FqNameUnsafe kMutablePropertyFqName = null;
        public static final ClassId kProperty = null;
        public static final FqNameUnsafe kProperty0 = null;
        public static final FqNameUnsafe kProperty1 = null;
        public static final FqNameUnsafe kProperty2 = null;
        public static final FqNameUnsafe kPropertyFqName = null;
        public static final FqNameUnsafe kType = null;
        public static final FqName list = null;
        public static final FqName listIterator = null;
        public static final FqNameUnsafe longRange = null;
        public static final FqName map = null;
        public static final FqName mapEntry = null;
        public static final FqName mustBeDocumented = null;
        public static final FqName mutableCollection = null;
        public static final FqName mutableIterable = null;
        public static final FqName mutableIterator = null;
        public static final FqName mutableList = null;
        public static final FqName mutableListIterator = null;
        public static final FqName mutableMap = null;
        public static final FqName mutableMapEntry = null;
        public static final FqName mutableSet = null;
        public static final FqNameUnsafe nothing = null;
        public static final FqNameUnsafe number = null;
        public static final FqName parameterName = null;
        public static final ClassId parameterNameClassId = null;
        public static final FqName platformDependent = null;
        public static final ClassId platformDependentClassId = null;
        public static final Set<Name> primitiveArrayTypeShortNames = null;
        public static final Set<Name> primitiveTypeShortNames = null;
        public static final FqName publishedApi = null;
        public static final FqName repeatable = null;
        public static final ClassId repeatableClassId = null;
        public static final FqName replaceWith = null;
        public static final FqName retention = null;
        public static final ClassId retentionClassId = null;
        public static final FqName set = null;
        public static final FqNameUnsafe string = null;
        public static final FqName suppress = null;
        public static final FqName target = null;
        public static final ClassId targetClassId = null;
        public static final FqName throwable = null;
        public static final ClassId uByte = null;
        public static final FqName uByteArrayFqName = null;
        public static final FqName uByteFqName = null;
        public static final ClassId uInt = null;
        public static final FqName uIntArrayFqName = null;
        public static final FqName uIntFqName = null;
        public static final ClassId uLong = null;
        public static final FqName uLongArrayFqName = null;
        public static final FqName uLongFqName = null;
        public static final ClassId uShort = null;
        public static final FqName uShortArrayFqName = null;
        public static final FqName uShortFqName = null;
        public static final FqNameUnsafe unit = null;
        public static final FqName unsafeVariance = null;

        private FqNames() {
        }

        static {
            FqNames r100 = new FqNames();
            INSTANCE = r100;
            any = r100.fqNameUnsafe("Any");
            nothing = r100.fqNameUnsafe("Nothing");
            cloneable = r100.fqNameUnsafe("Cloneable");
            suppress = r100.fqName("Suppress");
            unit = r100.fqNameUnsafe("Unit");
            charSequence = r100.fqNameUnsafe("CharSequence");
            string = r100.fqNameUnsafe("String");
            array = r100.fqNameUnsafe("Array");
            _boolean = r100.fqNameUnsafe("Boolean");
            _char = r100.fqNameUnsafe("Char");
            _byte = r100.fqNameUnsafe("Byte");
            _short = r100.fqNameUnsafe("Short");
            _int = r100.fqNameUnsafe("Int");
            _long = r100.fqNameUnsafe("Long");
            _float = r100.fqNameUnsafe("Float");
            _double = r100.fqNameUnsafe("Double");
            number = r100.fqNameUnsafe("Number");
            _enum = r100.fqNameUnsafe("Enum");
            functionSupertype = r100.fqNameUnsafe("Function");
            throwable = r100.fqName("Throwable");
            comparable = r100.fqName("Comparable");
            intRange = r100.rangesFqName("IntRange");
            longRange = r100.rangesFqName("LongRange");
            deprecated = r100.fqName("Deprecated");
            deprecatedSinceKotlin = r100.fqName("DeprecatedSinceKotlin");
            deprecationLevel = r100.fqName("DeprecationLevel");
            replaceWith = r100.fqName("ReplaceWith");
            extensionFunctionType = r100.fqName("ExtensionFunctionType");
            contextFunctionTypeParams = r100.fqName("ContextFunctionTypeParams");
            FqName r101 = r100.fqName("ParameterName");
            parameterName = r101;
            ClassId.Companion r102 = ClassId.Companion;
            parameterNameClassId = r102.topLevel(r101);
            f504566annotation = r100.fqName("Annotation");
            FqName r103 = r100.annotationName("Target");
            target = r103;
            targetClassId = r102.topLevel(r103);
            annotationTarget = r100.annotationName("AnnotationTarget");
            annotationRetention = r100.annotationName("AnnotationRetention");
            FqName r104 = r100.annotationName("Retention");
            retention = r104;
            retentionClassId = r102.topLevel(r104);
            FqName r105 = r100.annotationName("Repeatable");
            repeatable = r105;
            repeatableClassId = r102.topLevel(r105);
            mustBeDocumented = r100.annotationName("MustBeDocumented");
            unsafeVariance = r100.fqName("UnsafeVariance");
            publishedApi = r100.fqName("PublishedApi");
            accessibleLateinitPropertyLiteral = r100.internalName("AccessibleLateinitPropertyLiteral");
            FqName r106 = new FqName("kotlin.internal.PlatformDependent");
            platformDependent = r106;
            platformDependentClassId = r102.topLevel(r106);
            iterator = r100.collectionsFqName("Iterator");
            iterable = r100.collectionsFqName("Iterable");
            collection = r100.collectionsFqName("Collection");
            list = r100.collectionsFqName("List");
            listIterator = r100.collectionsFqName("ListIterator");
            set = r100.collectionsFqName("Set");
            FqName r107 = r100.collectionsFqName("Map");
            map = r107;
            mapEntry = r107.child(Name.identifier("Entry"));
            mutableIterator = r100.collectionsFqName("MutableIterator");
            mutableIterable = r100.collectionsFqName("MutableIterable");
            mutableCollection = r100.collectionsFqName("MutableCollection");
            mutableList = r100.collectionsFqName("MutableList");
            mutableListIterator = r100.collectionsFqName("MutableListIterator");
            mutableSet = r100.collectionsFqName("MutableSet");
            FqName r108 = r100.collectionsFqName("MutableMap");
            mutableMap = r108;
            mutableMapEntry = r108.child(Name.identifier("MutableEntry"));
            kClass = reflect("KClass");
            kType = reflect("KType");
            kCallable = reflect("KCallable");
            kProperty0 = reflect("KProperty0");
            kProperty1 = reflect("KProperty1");
            kProperty2 = reflect("KProperty2");
            kMutableProperty0 = reflect("KMutableProperty0");
            kMutableProperty1 = reflect("KMutableProperty1");
            kMutableProperty2 = reflect("KMutableProperty2");
            FqNameUnsafe r109 = reflect("KProperty");
            kPropertyFqName = r109;
            kMutablePropertyFqName = reflect("KMutableProperty");
            kProperty = r102.topLevel(r109.toSafe());
            kDeclarationContainer = reflect("KDeclarationContainer");
            findAssociatedObject = reflect("findAssociatedObject");
            FqName r110 = r100.fqName("UByte");
            uByteFqName = r110;
            FqName r111 = r100.fqName("UShort");
            uShortFqName = r111;
            FqName r112 = r100.fqName("UInt");
            uIntFqName = r112;
            FqName r113 = r100.fqName("ULong");
            uLongFqName = r113;
            uByte = r102.topLevel(r110);
            uShort = r102.topLevel(r111);
            uInt = r102.topLevel(r112);
            uLong = r102.topLevel(r113);
            uByteArrayFqName = r100.fqName("UByteArray");
            uShortArrayFqName = r100.fqName("UShortArray");
            uIntArrayFqName = r100.fqName("UIntArray");
            uLongArrayFqName = r100.fqName("ULongArray");
            HashSet r114 = CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] r115 = PrimitiveType.values();
            int r116 = r115.length;
            int r117 = 0;
            int r118 = 0;
        L3:
            if (r118 >= r116) goto L5;
            r114.add(r115[r118].getTypeName());
            r118 = r118 + 1;
            goto L3
        L5:
            primitiveTypeShortNames = r114;
            HashSet r119 = CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] r120 = PrimitiveType.values();
            int r121 = r120.length;
            int r122 = 0;
        L6:
            if (r122 >= r121) goto L8;
            r119.add(r120[r122].getArrayTypeName());
            r122 = r122 + 1;
            goto L6
        L8:
            primitiveArrayTypeShortNames = r119;
            HashMap r123 = CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] r124 = PrimitiveType.values();
            int r125 = r124.length;
            int r126 = 0;
        L9:
            if (r126 >= r125) goto L11;
            PrimitiveType r127 = r124[r126];
            r123.put(INSTANCE.fqNameUnsafe(r127.getTypeName().asString()), r127);
            r126 = r126 + 1;
            goto L9
        L11:
            fqNameToPrimitiveType = r123;
            HashMap r128 = CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] r129 = PrimitiveType.values();
            int r130 = r129.length;
        L12:
            if (r117 >= r130) goto L14;
            PrimitiveType r131 = r129[r117];
            r128.put(INSTANCE.fqNameUnsafe(r131.getArrayTypeName().asString()), r131);
            r117 = r117 + 1;
            goto L12
        L14:
            arrayClassFqNameToPrimitiveType = r128;
        }

        private final FqName annotationName(String r100) {
            return StandardNames.ANNOTATION_PACKAGE_FQ_NAME.child(Name.identifier(r100));
        }

        private final FqName collectionsFqName(String r100) {
            return StandardNames.COLLECTIONS_PACKAGE_FQ_NAME.child(Name.identifier(r100));
        }

        private final FqName fqName(String r100) {
            return StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(r100));
        }

        private final FqNameUnsafe fqNameUnsafe(String r100) {
            return fqName(r100).toUnsafe();
        }

        private final FqName internalName(String r100) {
            return StandardNames.KOTLIN_INTERNAL_FQ_NAME.child(Name.identifier(r100));
        }

        private final FqNameUnsafe rangesFqName(String r100) {
            return StandardNames.RANGES_PACKAGE_FQ_NAME.child(Name.identifier(r100)).toUnsafe();
        }

        @JvmStatic
        public static final FqNameUnsafe reflect(String r100) {
            Intrinsics.checkNotNullParameter(r100, "simpleName");
            return StandardNames.KOTLIN_REFLECT_FQ_NAME.child(Name.identifier(r100)).toUnsafe();
        }
    }

    private StandardNames() {
    }

    static {
        INSTANCE = new StandardNames();
        BACKING_FIELD = Name.identifier("field");
        DEFAULT_VALUE_PARAMETER = Name.identifier("value");
        ENUM_VALUES = Name.identifier("values");
        ENUM_ENTRIES = Name.identifier("entries");
        ENUM_VALUE_OF = Name.identifier("valueOf");
        DATA_CLASS_COPY = Name.identifier("copy");
        DATA_CLASS_COMPONENT_PREFIX = "component";
        HASHCODE_NAME = Name.identifier("hashCode");
        TO_STRING_NAME = Name.identifier("toString");
        EQUALS_NAME = Name.identifier("equals");
        CHAR_CODE = Name.identifier("code");
        NAME = Name.identifier("name");
        MAIN = Name.identifier(PullConfiguration.PROCESS_NAME_MAIN);
        NEXT_CHAR = Name.identifier("nextChar");
        IMPLICIT_LAMBDA_PARAMETER_NAME = Name.identifier("it");
        CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME = Name.identifier("count");
        DYNAMIC_FQ_NAME = new FqName("<dynamic>");
        FqName r100 = new FqName("kotlin.coroutines");
        COROUTINES_PACKAGE_FQ_NAME = r100;
        COROUTINES_JVM_INTERNAL_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.jvm.internal");
        COROUTINES_INTRINSICS_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.intrinsics");
        CONTINUATION_INTERFACE_FQ_NAME = r100.child(Name.identifier("Continuation"));
        RESULT_FQ_NAME = new FqName("kotlin.Result");
        FqName r101 = new FqName("kotlin.reflect");
        KOTLIN_REFLECT_FQ_NAME = r101;
        PREFIXES = kotlin.collections.CollectionsKt.listOf(new String[]{"KProperty", "KMutableProperty", "KFunction", "KSuspendFunction"});
        Name r102 = Name.identifier("kotlin");
        BUILT_INS_PACKAGE_NAME = r102;
        FqName r103 = FqName.topLevel(r102);
        BUILT_INS_PACKAGE_FQ_NAME = r103;
        FqName r104 = r103.child(Name.identifier("annotation"));
        ANNOTATION_PACKAGE_FQ_NAME = r104;
        FqName r105 = r103.child(Name.identifier("collections"));
        COLLECTIONS_PACKAGE_FQ_NAME = r105;
        FqName r106 = r103.child(Name.identifier("ranges"));
        RANGES_PACKAGE_FQ_NAME = r106;
        TEXT_PACKAGE_FQ_NAME = r103.child(Name.identifier("text"));
        FqName r107 = r103.child(Name.identifier("internal"));
        KOTLIN_INTERNAL_FQ_NAME = r107;
        NON_EXISTENT_CLASS = new FqName("error.NonExistentClass");
        BUILT_INS_PACKAGE_FQ_NAMES = SetsKt.setOf(new FqName[]{r103, r105, r106, r104, r101, r107, r100});
    }

    @JvmStatic
    public static final ClassId getFunctionClassId(int r100) {
        return new ClassId(BUILT_INS_PACKAGE_FQ_NAME, Name.identifier(getFunctionName(r100)));
    }

    @JvmStatic
    public static final String getFunctionName(int r100) {
        return "Function" + r100;
    }

    @JvmStatic
    public static final FqName getPrimitiveFqName(PrimitiveType r100) {
        Intrinsics.checkNotNullParameter(r100, "primitiveType");
        return BUILT_INS_PACKAGE_FQ_NAME.child(r100.getTypeName());
    }

    @JvmStatic
    public static final String getSuspendFunctionName(int r100) {
        return FunctionTypeKind.SuspendFunction.INSTANCE.getClassNamePrefix() + r100;
    }

    @JvmStatic
    public static final boolean isPrimitiveArray(FqNameUnsafe r100) {
        Intrinsics.checkNotNullParameter(r100, "arrayFqName");
        if (FqNames.arrayClassFqNameToPrimitiveType.get(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
