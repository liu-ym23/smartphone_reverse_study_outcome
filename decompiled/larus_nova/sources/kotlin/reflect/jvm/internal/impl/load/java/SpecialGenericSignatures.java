package kotlin.reflect.jvm.internal.impl.load.java;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.HashSet;
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
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public class SpecialGenericSignatures {
    public static final Companion Companion = null;
    private static final List<String> ERASED_COLLECTION_PARAMETER_NAMES = null;
    private static final List<Companion.NameAndSignature> ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES = null;
    private static final List<String> ERASED_COLLECTION_PARAMETER_SIGNATURES = null;
    private static final Set<Name> ERASED_VALUE_PARAMETERS_SHORT_NAMES = null;
    private static final Set<String> ERASED_VALUE_PARAMETERS_SIGNATURES = null;
    private static final Map<Companion.NameAndSignature, TypeSafeBarrierDescription> GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP = null;
    private static final Map<Name, Name> JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP = null;
    private static final Set<String> JVM_SIGNATURES_FOR_RENAMED_BUILT_INS = null;
    private static final Map<Companion.NameAndSignature, Name> NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP = null;
    private static final Set<Name> ORIGINAL_SHORT_NAMES = null;
    private static final Companion.NameAndSignature REMOVE_AT_NAME_AND_SIGNATURE = null;
    private static final Map<String, TypeSafeBarrierDescription> SIGNATURE_TO_DEFAULT_VALUES_MAP = null;
    private static final Map<String, Name> SIGNATURE_TO_JVM_REPRESENTATION_NAME = null;

    public static final class Companion {

        public static final class NameAndSignature {
            private final String classInternalName;
            private final Name name;
            private final String parameters;
            private final String returnType;
            private final String signature;

            public static /* synthetic */ NameAndSignature copy$default(NameAndSignature r100, String r101, Name r102, String r103, String r104, int r105, Object r106) {
                if ((r105 & 1) == 0) goto L6;
                r101 = r100.classInternalName;
            L6:
                if ((r105 & 2) == 0) goto L9;
                r102 = r100.name;
            L9:
                if ((r105 & 4) == 0) goto L12;
                r103 = r100.parameters;
            L12:
                if ((r105 & 8) == 0) goto L15;
                r104 = r100.returnType;
            L15:
                return r100.copy(r101, r102, r103, r104);
            }

            public final NameAndSignature copy(String r100, Name r101, String r102, String r103) {
                Intrinsics.checkNotNullParameter(r100, "classInternalName");
                Intrinsics.checkNotNullParameter(r101, "name");
                Intrinsics.checkNotNullParameter(r102, "parameters");
                Intrinsics.checkNotNullParameter(r103, "returnType");
                return new NameAndSignature(r100, r101, r102, r103);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof NameAndSignature) == true) goto L8;
                return false;
            L8:
                NameAndSignature r101 = (NameAndSignature) r100;
                if (Intrinsics.areEqual(this.classInternalName, r101.classInternalName) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.parameters, r101.parameters) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.returnType, r101.returnType) == true) goto L20;
                return false;
            L20:
                return true;
            }

            public int hashCode() {
                return (((((this.classInternalName.hashCode() * 31) + this.name.hashCode()) * 31) + this.parameters.hashCode()) * 31) + this.returnType.hashCode();
            }

            public String toString() {
                return "NameAndSignature(classInternalName=" + this.classInternalName + ", name=" + this.name + ", parameters=" + this.parameters + ", returnType=" + this.returnType + ')';
            }

            public final Name getName() {
                return this.name;
            }

            public final String getSignature() {
                return this.signature;
            }

            public NameAndSignature(String r100, Name r101, String r102, String r103) {
                Intrinsics.checkNotNullParameter(r100, "classInternalName");
                Intrinsics.checkNotNullParameter(r101, "name");
                Intrinsics.checkNotNullParameter(r102, "parameters");
                Intrinsics.checkNotNullParameter(r103, "returnType");
                this.classInternalName = r100;
                this.name = r101;
                this.parameters = r102;
                this.returnType = r103;
                this.signature = SignatureBuildingComponents.INSTANCE.signature(r100, r101 + '(' + r102 + ')' + r103);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final List<String> getERASED_COLLECTION_PARAMETER_SIGNATURES() {
            return SpecialGenericSignatures.access$getERASED_COLLECTION_PARAMETER_SIGNATURES$cp();
        }

        public final Set<Name> getERASED_VALUE_PARAMETERS_SHORT_NAMES() {
            return SpecialGenericSignatures.access$getERASED_VALUE_PARAMETERS_SHORT_NAMES$cp();
        }

        public final Set<String> getERASED_VALUE_PARAMETERS_SIGNATURES() {
            return SpecialGenericSignatures.access$getERASED_VALUE_PARAMETERS_SIGNATURES$cp();
        }

        public final Map<Name, Name> getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP() {
            return SpecialGenericSignatures.access$getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP$cp();
        }

        public final Set<Name> getORIGINAL_SHORT_NAMES() {
            return SpecialGenericSignatures.access$getORIGINAL_SHORT_NAMES$cp();
        }

        public final NameAndSignature getREMOVE_AT_NAME_AND_SIGNATURE() {
            return SpecialGenericSignatures.access$getREMOVE_AT_NAME_AND_SIGNATURE$cp();
        }

        public final Map<String, TypeSafeBarrierDescription> getSIGNATURE_TO_DEFAULT_VALUES_MAP() {
            return SpecialGenericSignatures.access$getSIGNATURE_TO_DEFAULT_VALUES_MAP$cp();
        }

        public final Map<String, Name> getSIGNATURE_TO_JVM_REPRESENTATION_NAME() {
            return SpecialGenericSignatures.access$getSIGNATURE_TO_JVM_REPRESENTATION_NAME$cp();
        }

        public final Name getBuiltinFunctionNamesByJvmName(Name r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            return getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP().get(r100);
        }

        public final boolean getSameAsRenamedInJvmBuiltin(Name r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            return getORIGINAL_SHORT_NAMES().contains(r100);
        }

        public final SpecialSignatureInfo getSpecialSignatureInfo(String r100) {
            Intrinsics.checkNotNullParameter(r100, "builtinSignature");
            if (getERASED_COLLECTION_PARAMETER_SIGNATURES().contains(r100) == false) goto L7;
            return SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
        L7:
            if (((TypeSafeBarrierDescription) MapsKt.getValue(getSIGNATURE_TO_DEFAULT_VALUES_MAP(), r100)) != TypeSafeBarrierDescription.NULL) goto L10;
            return SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC;
        L10:
            return SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
        }

        private final NameAndSignature method(String r100, String r101, String r102, String r103) {
            return new NameAndSignature(r100, Name.identifier(r101), r102, r103);
        }

        public static final /* synthetic */ NameAndSignature access$method(Companion r100, String r101, String r102, String r103, String r104) {
            return r100.method(r101, r102, r103, r104);
        }
    }

    public static final enum SpecialSignatureInfo extends Enum<SpecialSignatureInfo> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ SpecialSignatureInfo[] $VALUES = null;
        public static final SpecialSignatureInfo OBJECT_PARAMETER_GENERIC = null;
        public static final SpecialSignatureInfo OBJECT_PARAMETER_NON_GENERIC = null;
        public static final SpecialSignatureInfo ONE_COLLECTION_PARAMETER = null;
        private final boolean isObjectReplacedWithTypeParameter;
        private final String valueParametersSignature;

        private static final /* synthetic */ SpecialSignatureInfo[] $values() {
            return new SpecialSignatureInfo[]{ONE_COLLECTION_PARAMETER, OBJECT_PARAMETER_NON_GENERIC, OBJECT_PARAMETER_GENERIC};
        }

        static {
            ONE_COLLECTION_PARAMETER = new SpecialSignatureInfo("ONE_COLLECTION_PARAMETER", 0, "Ljava/util/Collection<+Ljava/lang/Object;>;", false);
            OBJECT_PARAMETER_NON_GENERIC = new SpecialSignatureInfo("OBJECT_PARAMETER_NON_GENERIC", 1, null, true);
            OBJECT_PARAMETER_GENERIC = new SpecialSignatureInfo("OBJECT_PARAMETER_GENERIC", 2, "Ljava/lang/Object;", true);
            SpecialSignatureInfo[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static SpecialSignatureInfo[] values() {
            return (SpecialSignatureInfo[]) $VALUES.clone();
        }

        public static SpecialSignatureInfo valueOf(String r100) {
            return (SpecialSignatureInfo) a.a(SpecialSignatureInfo.class, r100);
        }

        private SpecialSignatureInfo(String r100, int r101, String r102, boolean r103) {
            super(r100, r101);
            this.valueParametersSignature = r102;
            this.isObjectReplacedWithTypeParameter = r103;
        }
    }

    public static final enum TypeSafeBarrierDescription extends Enum<TypeSafeBarrierDescription> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ TypeSafeBarrierDescription[] $VALUES = null;
        public static final TypeSafeBarrierDescription FALSE = null;
        public static final TypeSafeBarrierDescription INDEX = null;
        public static final TypeSafeBarrierDescription MAP_GET_OR_DEFAULT = null;
        public static final TypeSafeBarrierDescription NULL = null;
        private final Object defaultValue;

        public static final class MAP_GET_OR_DEFAULT extends TypeSafeBarrierDescription {
            public MAP_GET_OR_DEFAULT(String r100, int r101) {
                DefaultConstructorMarker r102 = null;
                super(r100, r101, r102, r102);
            }
        }

        private static final /* synthetic */ TypeSafeBarrierDescription[] $values() {
            return new TypeSafeBarrierDescription[]{NULL, INDEX, FALSE, MAP_GET_OR_DEFAULT};
        }

        public /* synthetic */ TypeSafeBarrierDescription(String r100, int r101, Object r102, DefaultConstructorMarker r103) {
            this(r100, r101, r102);
        }

        static {
            NULL = new TypeSafeBarrierDescription("NULL", 0, null);
            INDEX = new TypeSafeBarrierDescription("INDEX", 1, -1);
            FALSE = new TypeSafeBarrierDescription("FALSE", 2, Boolean.FALSE);
            MAP_GET_OR_DEFAULT = new MAP_GET_OR_DEFAULT("MAP_GET_OR_DEFAULT", 3);
            TypeSafeBarrierDescription[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static TypeSafeBarrierDescription[] values() {
            return (TypeSafeBarrierDescription[]) $VALUES.clone();
        }

        public static TypeSafeBarrierDescription valueOf(String r100) {
            return (TypeSafeBarrierDescription) a.a(TypeSafeBarrierDescription.class, r100);
        }

        private TypeSafeBarrierDescription(String r100, int r101, Object r102) {
            super(r100, r101);
            this.defaultValue = r102;
        }
    }

    public SpecialGenericSignatures() {
    }

    static {
        Companion = new Companion(null);
        Set r100 = SetsKt.setOf(new String[]{"containsAll", "removeAll", "retainAll"});
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(Companion.access$method(Companion, "java/util/Collection", (String) r102.next(), "Ljava/util/Collection;", JvmPrimitiveType.BOOLEAN.getDesc()));
        goto L4
    L6:
        ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES = r101;
        ArrayList r103 = r101;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        r104.add(((Companion.NameAndSignature) r105.next()).getSignature());
        goto L8
    L10:
        ERASED_COLLECTION_PARAMETER_SIGNATURES = r104;
        List<Companion.NameAndSignature> r106 = ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L12:
        if (r108.hasNext() == false) goto L14;
        r107.add(((Companion.NameAndSignature) r108.next()).getName().asString());
        goto L12
    L14:
        ERASED_COLLECTION_PARAMETER_NAMES = r107;
        SignatureBuildingComponents r109 = SignatureBuildingComponents.INSTANCE;
        Companion r110 = Companion;
        String r111 = r109.javaUtil("Collection");
        JvmPrimitiveType r112 = JvmPrimitiveType.BOOLEAN;
        Companion.NameAndSignature r113 = Companion.access$method(r110, r111, "contains", "Ljava/lang/Object;", r112.getDesc());
        TypeSafeBarrierDescription r114 = TypeSafeBarrierDescription.FALSE;
        Companion.NameAndSignature r115 = Companion.access$method(r110, r109.javaUtil("Map"), MonitorConstants.CONNECT_TYPE_GET, "Ljava/lang/Object;", "Ljava/lang/Object;");
        TypeSafeBarrierDescription r116 = TypeSafeBarrierDescription.NULL;
        String r117 = r109.javaUtil("List");
        JvmPrimitiveType r118 = JvmPrimitiveType.INT;
        Companion.NameAndSignature r119 = Companion.access$method(r110, r117, "indexOf", "Ljava/lang/Object;", r118.getDesc());
        TypeSafeBarrierDescription r120 = TypeSafeBarrierDescription.INDEX;
        Map<Companion.NameAndSignature, TypeSafeBarrierDescription> r121 = MapsKt.mapOf(new Pair[]{TuplesKt.to(r113, r114), TuplesKt.to(Companion.access$method(r110, r109.javaUtil("Collection"), "remove", "Ljava/lang/Object;", r112.getDesc()), r114), TuplesKt.to(Companion.access$method(r110, r109.javaUtil("Map"), "containsKey", "Ljava/lang/Object;", r112.getDesc()), r114), TuplesKt.to(Companion.access$method(r110, r109.javaUtil("Map"), "containsValue", "Ljava/lang/Object;", r112.getDesc()), r114), TuplesKt.to(Companion.access$method(r110, r109.javaUtil("Map"), "remove", "Ljava/lang/Object;Ljava/lang/Object;", r112.getDesc()), r114), TuplesKt.to(Companion.access$method(r110, r109.javaUtil("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT), TuplesKt.to(r115, r116), TuplesKt.to(Companion.access$method(r110, r109.javaUtil("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), r116), TuplesKt.to(r119, r120), TuplesKt.to(Companion.access$method(r110, r109.javaUtil("List"), "lastIndexOf", "Ljava/lang/Object;", r118.getDesc()), r120)});
        GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP = r121;
        LinkedHashMap r122 = new LinkedHashMap(MapsKt.mapCapacity(r121.size()));
        Iterator<T> r123 = r121.entrySet().iterator();
    L16:
        if (r123.hasNext() == false) goto L18;
        Map.Entry r124 = (Map.Entry) r123.next();
        r122.put(((Companion.NameAndSignature) r124.getKey()).getSignature(), r124.getValue());
        goto L16
    L18:
        SIGNATURE_TO_DEFAULT_VALUES_MAP = r122;
        Set r125 = SetsKt.plus(GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP.keySet(), ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES);
        ArrayList r126 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r125, 10));
        Iterator r127 = r125.iterator();
    L20:
        if (r127.hasNext() == false) goto L22;
        r126.add(((Companion.NameAndSignature) r127.next()).getName());
        goto L20
    L22:
        ERASED_VALUE_PARAMETERS_SHORT_NAMES = CollectionsKt.toSet(r126);
        ArrayList r128 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r125, 10));
        Iterator r129 = r125.iterator();
    L24:
        if (r129.hasNext() == false) goto L26;
        r128.add(((Companion.NameAndSignature) r129.next()).getSignature());
        goto L24
    L26:
        ERASED_VALUE_PARAMETERS_SIGNATURES = CollectionsKt.toSet(r128);
        Companion r130 = Companion;
        JvmPrimitiveType r131 = JvmPrimitiveType.INT;
        Companion.NameAndSignature r132 = Companion.access$method(r130, "java/util/List", "removeAt", r131.getDesc(), "Ljava/lang/Object;");
        REMOVE_AT_NAME_AND_SIGNATURE = r132;
        SignatureBuildingComponents r133 = SignatureBuildingComponents.INSTANCE;
        Map<Companion.NameAndSignature, Name> r134 = MapsKt.mapOf(new Pair[]{TuplesKt.to(Companion.access$method(r130, r133.javaLang("Number"), "toByte", "", JvmPrimitiveType.BYTE.getDesc()), Name.identifier("byteValue")), TuplesKt.to(Companion.access$method(r130, r133.javaLang("Number"), "toShort", "", JvmPrimitiveType.SHORT.getDesc()), Name.identifier("shortValue")), TuplesKt.to(Companion.access$method(r130, r133.javaLang("Number"), "toInt", "", r131.getDesc()), Name.identifier("intValue")), TuplesKt.to(Companion.access$method(r130, r133.javaLang("Number"), "toLong", "", JvmPrimitiveType.LONG.getDesc()), Name.identifier("longValue")), TuplesKt.to(Companion.access$method(r130, r133.javaLang("Number"), "toFloat", "", JvmPrimitiveType.FLOAT.getDesc()), Name.identifier("floatValue")), TuplesKt.to(Companion.access$method(r130, r133.javaLang("Number"), "toDouble", "", JvmPrimitiveType.DOUBLE.getDesc()), Name.identifier("doubleValue")), TuplesKt.to(r132, Name.identifier("remove")), TuplesKt.to(Companion.access$method(r130, r133.javaLang("CharSequence"), MonitorConstants.CONNECT_TYPE_GET, r131.getDesc(), JvmPrimitiveType.CHAR.getDesc()), Name.identifier("charAt"))});
        NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP = r134;
        LinkedHashMap r135 = new LinkedHashMap(MapsKt.mapCapacity(r134.size()));
        Iterator<T> r136 = r134.entrySet().iterator();
    L28:
        if (r136.hasNext() == false) goto L30;
        Map.Entry r137 = (Map.Entry) r136.next();
        r135.put(((Companion.NameAndSignature) r137.getKey()).getSignature(), r137.getValue());
        goto L28
    L30:
        SIGNATURE_TO_JVM_REPRESENTATION_NAME = r135;
        Map<Companion.NameAndSignature, Name> r138 = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP;
        LinkedHashSet r139 = new LinkedHashSet();
        Iterator<Map.Entry<Companion.NameAndSignature, Name>> r140 = r138.entrySet().iterator();
    L32:
        if (r140.hasNext() == false) goto L34;
        Map.Entry<Companion.NameAndSignature, Name> r141 = r140.next();
        r139.add(Companion.NameAndSignature.copy$default(r141.getKey(), null, r141.getValue(), null, null, 13, null).getSignature());
        goto L32
    L34:
        JVM_SIGNATURES_FOR_RENAMED_BUILT_INS = r139;
        Set<Companion.NameAndSignature> r142 = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.keySet();
        HashSet r143 = new HashSet();
        Iterator<T> r144 = r142.iterator();
    L36:
        if (r144.hasNext() == false) goto L38;
        r143.add(((Companion.NameAndSignature) r144.next()).getName());
        goto L36
    L38:
        ORIGINAL_SHORT_NAMES = r143;
        Set<Map.Entry<Companion.NameAndSignature, Name>> r145 = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.entrySet();
        ArrayList r146 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r145, 10));
        Iterator<T> r147 = r145.iterator();
    L40:
        if (r147.hasNext() == false) goto L42;
        Map.Entry r148 = (Map.Entry) r147.next();
        r146.add(new Pair(((Companion.NameAndSignature) r148.getKey()).getName(), r148.getValue()));
        goto L40
    L42:
        LinkedHashMap r149 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r146, 10)), 16));
        Iterator r150 = r146.iterator();
    L44:
        if (r150.hasNext() == false) goto L46;
        Pair r151 = (Pair) r150.next();
        r149.put((Name) r151.getSecond(), (Name) r151.getFirst());
        goto L44
    L46:
        JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP = r149;
    }

    public static final /* synthetic */ List access$getERASED_COLLECTION_PARAMETER_SIGNATURES$cp() {
        return ERASED_COLLECTION_PARAMETER_SIGNATURES;
    }

    public static final /* synthetic */ Set access$getERASED_VALUE_PARAMETERS_SHORT_NAMES$cp() {
        return ERASED_VALUE_PARAMETERS_SHORT_NAMES;
    }

    public static final /* synthetic */ Set access$getERASED_VALUE_PARAMETERS_SIGNATURES$cp() {
        return ERASED_VALUE_PARAMETERS_SIGNATURES;
    }

    public static final /* synthetic */ Map access$getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP$cp() {
        return JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
    }

    public static final /* synthetic */ Set access$getORIGINAL_SHORT_NAMES$cp() {
        return ORIGINAL_SHORT_NAMES;
    }

    public static final /* synthetic */ Companion.NameAndSignature access$getREMOVE_AT_NAME_AND_SIGNATURE$cp() {
        return REMOVE_AT_NAME_AND_SIGNATURE;
    }

    public static final /* synthetic */ Map access$getSIGNATURE_TO_DEFAULT_VALUES_MAP$cp() {
        return SIGNATURE_TO_DEFAULT_VALUES_MAP;
    }

    public static final /* synthetic */ Map access$getSIGNATURE_TO_JVM_REPRESENTATION_NAME$cp() {
        return SIGNATURE_TO_JVM_REPRESENTATION_NAME;
    }
}
