package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.facebook.keyframes.model.KFAnimation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum KotlinTarget extends Enum<KotlinTarget> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ KotlinTarget[] $VALUES = null;
    private static final Set<KotlinTarget> ALL_TARGET_SET = null;
    public static final KotlinTarget ANNOTATION_CLASS = null;
    private static final List<KotlinTarget> ANNOTATION_CLASS_LIST = null;
    public static final KotlinTarget ANONYMOUS_FUNCTION = null;
    public static final KotlinTarget BACKING_FIELD = null;
    public static final KotlinTarget CLASS = null;
    private static final List<KotlinTarget> CLASS_LIST = null;
    public static final KotlinTarget CLASS_ONLY = null;
    public static final KotlinTarget COMPANION_OBJECT = null;
    private static final List<KotlinTarget> COMPANION_OBJECT_LIST = null;
    public static final KotlinTarget CONSTRUCTOR = null;
    public static final Companion Companion = null;
    private static final Set<KotlinTarget> DEFAULT_TARGET_SET = null;
    public static final KotlinTarget DESTRUCTURING_DECLARATION = null;
    public static final KotlinTarget ENUM_CLASS = null;
    public static final KotlinTarget ENUM_ENTRY = null;
    private static final List<KotlinTarget> ENUM_ENTRY_LIST = null;
    private static final List<KotlinTarget> ENUM_LIST = null;
    public static final KotlinTarget EXPRESSION = null;
    public static final KotlinTarget FIELD = null;
    public static final KotlinTarget FILE = null;
    private static final List<KotlinTarget> FILE_LIST = null;
    public static final KotlinTarget FUNCTION = null;
    private static final List<KotlinTarget> FUNCTION_LIST = null;
    public static final KotlinTarget INITIALIZER = null;
    public static final KotlinTarget INTERFACE = null;
    private static final List<KotlinTarget> INTERFACE_LIST = null;
    public static final KotlinTarget LAMBDA_EXPRESSION = null;
    public static final KotlinTarget LOCAL_CLASS = null;
    private static final List<KotlinTarget> LOCAL_CLASS_LIST = null;
    public static final KotlinTarget LOCAL_FUNCTION = null;
    public static final KotlinTarget LOCAL_VARIABLE = null;
    public static final KotlinTarget MEMBER_FUNCTION = null;
    public static final KotlinTarget MEMBER_PROPERTY = null;
    public static final KotlinTarget MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = null;
    public static final KotlinTarget MEMBER_PROPERTY_WITH_BACKING_FIELD = null;
    public static final KotlinTarget MEMBER_PROPERTY_WITH_DELEGATE = null;
    public static final KotlinTarget OBJECT = null;
    private static final List<KotlinTarget> OBJECT_LIST = null;
    public static final KotlinTarget OBJECT_LITERAL = null;
    public static final KotlinTarget PROPERTY = null;
    public static final KotlinTarget PROPERTY_GETTER = null;
    private static final List<KotlinTarget> PROPERTY_GETTER_LIST = null;
    public static final KotlinTarget PROPERTY_PARAMETER = null;
    public static final KotlinTarget PROPERTY_SETTER = null;
    private static final List<KotlinTarget> PROPERTY_SETTER_LIST = null;
    public static final KotlinTarget STANDALONE_OBJECT = null;
    public static final KotlinTarget STAR_PROJECTION = null;
    public static final KotlinTarget TOP_LEVEL_FUNCTION = null;
    public static final KotlinTarget TOP_LEVEL_PROPERTY = null;
    public static final KotlinTarget TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = null;
    public static final KotlinTarget TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD = null;
    public static final KotlinTarget TOP_LEVEL_PROPERTY_WITH_DELEGATE = null;
    public static final KotlinTarget TYPE = null;
    public static final KotlinTarget TYPEALIAS = null;
    public static final KotlinTarget TYPE_PARAMETER = null;
    public static final KotlinTarget TYPE_PROJECTION = null;
    private static final Map<AnnotationUseSiteTarget, KotlinTarget> USE_SITE_MAPPING = null;
    public static final KotlinTarget VALUE_PARAMETER = null;
    private static final HashMap<String, KotlinTarget> map = null;
    private final String description;
    private final boolean isDefault;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    private static final /* synthetic */ KotlinTarget[] $values() {
        return new KotlinTarget[]{CLASS, ANNOTATION_CLASS, TYPE_PARAMETER, PROPERTY, FIELD, LOCAL_VARIABLE, VALUE_PARAMETER, CONSTRUCTOR, FUNCTION, PROPERTY_GETTER, PROPERTY_SETTER, TYPE, EXPRESSION, FILE, TYPEALIAS, TYPE_PROJECTION, STAR_PROJECTION, PROPERTY_PARAMETER, CLASS_ONLY, OBJECT, STANDALONE_OBJECT, COMPANION_OBJECT, INTERFACE, ENUM_CLASS, ENUM_ENTRY, LOCAL_CLASS, LOCAL_FUNCTION, MEMBER_FUNCTION, TOP_LEVEL_FUNCTION, MEMBER_PROPERTY, MEMBER_PROPERTY_WITH_BACKING_FIELD, MEMBER_PROPERTY_WITH_DELEGATE, MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE, TOP_LEVEL_PROPERTY, TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD, TOP_LEVEL_PROPERTY_WITH_DELEGATE, TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE, BACKING_FIELD, INITIALIZER, DESTRUCTURING_DECLARATION, LAMBDA_EXPRESSION, ANONYMOUS_FUNCTION, OBJECT_LITERAL};
    }

    public static EnumEntries<KotlinTarget> getEntries() {
        return $ENTRIES;
    }

    static {
        CLASS = new KotlinTarget("CLASS", 0, "class", false, 2, null);
        ANNOTATION_CLASS = new KotlinTarget("ANNOTATION_CLASS", 1, "annotation class", false, 2, null);
        TYPE_PARAMETER = new KotlinTarget("TYPE_PARAMETER", 2, "type parameter", false);
        boolean r100 = false;
        int r110 = 2;
        DefaultConstructorMarker r111 = null;
        PROPERTY = new KotlinTarget("PROPERTY", 3, KFAnimation.PROPERTY_TYPE_JSON_FIELD, r100, r110, r111);
        boolean r112 = false;
        int r113 = 2;
        DefaultConstructorMarker r114 = null;
        FIELD = new KotlinTarget("FIELD", 4, "field", r112, r113, r114);
        LOCAL_VARIABLE = new KotlinTarget("LOCAL_VARIABLE", 5, "local variable", r100, r110, r111);
        VALUE_PARAMETER = new KotlinTarget("VALUE_PARAMETER", 6, "value parameter", r112, r113, r114);
        CONSTRUCTOR = new KotlinTarget("CONSTRUCTOR", 7, "constructor", r100, r110, r111);
        FUNCTION = new KotlinTarget("FUNCTION", 8, "function", r112, r113, r114);
        PROPERTY_GETTER = new KotlinTarget("PROPERTY_GETTER", 9, "getter", r100, r110, r111);
        PROPERTY_SETTER = new KotlinTarget("PROPERTY_SETTER", 10, "setter", r112, r113, r114);
        TYPE = new KotlinTarget("TYPE", 11, "type usage", false);
        EXPRESSION = new KotlinTarget("EXPRESSION", 12, "expression", false);
        FILE = new KotlinTarget("FILE", 13, "file", false);
        TYPEALIAS = new KotlinTarget("TYPEALIAS", 14, "typealias", false);
        TYPE_PROJECTION = new KotlinTarget("TYPE_PROJECTION", 15, "type projection", false);
        STAR_PROJECTION = new KotlinTarget("STAR_PROJECTION", 16, "star projection", false);
        PROPERTY_PARAMETER = new KotlinTarget("PROPERTY_PARAMETER", 17, "property constructor parameter", false);
        CLASS_ONLY = new KotlinTarget("CLASS_ONLY", 18, "class", false);
        OBJECT = new KotlinTarget("OBJECT", 19, "object", false);
        STANDALONE_OBJECT = new KotlinTarget("STANDALONE_OBJECT", 20, "standalone object", false);
        COMPANION_OBJECT = new KotlinTarget("COMPANION_OBJECT", 21, "companion object", false);
        INTERFACE = new KotlinTarget("INTERFACE", 22, "interface", false);
        ENUM_CLASS = new KotlinTarget("ENUM_CLASS", 23, "enum class", false);
        ENUM_ENTRY = new KotlinTarget("ENUM_ENTRY", 24, "enum entry", false);
        LOCAL_CLASS = new KotlinTarget("LOCAL_CLASS", 25, "local class", false);
        LOCAL_FUNCTION = new KotlinTarget("LOCAL_FUNCTION", 26, "local function", false);
        MEMBER_FUNCTION = new KotlinTarget("MEMBER_FUNCTION", 27, "member function", false);
        TOP_LEVEL_FUNCTION = new KotlinTarget("TOP_LEVEL_FUNCTION", 28, "top level function", false);
        MEMBER_PROPERTY = new KotlinTarget("MEMBER_PROPERTY", 29, "member property", false);
        MEMBER_PROPERTY_WITH_BACKING_FIELD = new KotlinTarget("MEMBER_PROPERTY_WITH_BACKING_FIELD", 30, "member property with backing field", false);
        MEMBER_PROPERTY_WITH_DELEGATE = new KotlinTarget("MEMBER_PROPERTY_WITH_DELEGATE", 31, "member property with delegate", false);
        MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = new KotlinTarget("MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 32, "member property without backing field or delegate", false);
        TOP_LEVEL_PROPERTY = new KotlinTarget("TOP_LEVEL_PROPERTY", 33, "top level property", false);
        TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD = new KotlinTarget("TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD", 34, "top level property with backing field", false);
        TOP_LEVEL_PROPERTY_WITH_DELEGATE = new KotlinTarget("TOP_LEVEL_PROPERTY_WITH_DELEGATE", 35, "top level property with delegate", false);
        TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = new KotlinTarget("TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 36, "top level property without backing field or delegate", false);
        BACKING_FIELD = new KotlinTarget("BACKING_FIELD", 37, "backing field", false, 2, null);
        INITIALIZER = new KotlinTarget("INITIALIZER", 38, "initializer", false);
        DESTRUCTURING_DECLARATION = new KotlinTarget("DESTRUCTURING_DECLARATION", 39, "destructuring declaration", false);
        LAMBDA_EXPRESSION = new KotlinTarget("LAMBDA_EXPRESSION", 40, "lambda expression", false);
        ANONYMOUS_FUNCTION = new KotlinTarget("ANONYMOUS_FUNCTION", 41, "anonymous function", false);
        OBJECT_LITERAL = new KotlinTarget("OBJECT_LITERAL", 42, "object literal", false);
        KotlinTarget[] r101 = $values();
        $VALUES = r101;
        $ENTRIES = EnumEntriesKt.enumEntries(r101);
        Companion = new Companion(null);
        map = new HashMap();
        Iterator<KotlinTarget> r102 = getEntries().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        KotlinTarget r103 = r102.next();
        map.put(r103.name(), r103);
        goto L4
    L6:
        EnumEntries<KotlinTarget> r104 = getEntries();
        ArrayList r105 = new ArrayList();
        Iterator<KotlinTarget> r106 = r104.iterator();
    L8:
        if (r106.hasNext() == false) goto L12;
        KotlinTarget r107 = r106.next();
        if (r107.isDefault == false) goto L8;
        r105.add(r107);
        goto L8
    L12:
        DEFAULT_TARGET_SET = CollectionsKt.toSet(r105);
        ALL_TARGET_SET = CollectionsKt.toSet(getEntries());
        KotlinTarget r108 = CLASS;
        ANNOTATION_CLASS_LIST = CollectionsKt.listOf(new KotlinTarget[]{ANNOTATION_CLASS, r108});
        LOCAL_CLASS_LIST = CollectionsKt.listOf(new KotlinTarget[]{LOCAL_CLASS, r108});
        CLASS_LIST = CollectionsKt.listOf(new KotlinTarget[]{CLASS_ONLY, r108});
        KotlinTarget r109 = OBJECT;
        COMPANION_OBJECT_LIST = CollectionsKt.listOf(new KotlinTarget[]{COMPANION_OBJECT, r109, r108});
        OBJECT_LIST = CollectionsKt.listOf(new KotlinTarget[]{STANDALONE_OBJECT, r109, r108});
        INTERFACE_LIST = CollectionsKt.listOf(new KotlinTarget[]{INTERFACE, r108});
        ENUM_LIST = CollectionsKt.listOf(new KotlinTarget[]{ENUM_CLASS, r108});
        KotlinTarget r115 = PROPERTY;
        KotlinTarget r116 = FIELD;
        ENUM_ENTRY_LIST = CollectionsKt.listOf(new KotlinTarget[]{ENUM_ENTRY, r115, r116});
        KotlinTarget r117 = PROPERTY_SETTER;
        PROPERTY_SETTER_LIST = CollectionsKt.listOf(r117);
        KotlinTarget r118 = PROPERTY_GETTER;
        PROPERTY_GETTER_LIST = CollectionsKt.listOf(r118);
        FUNCTION_LIST = CollectionsKt.listOf(FUNCTION);
        KotlinTarget r119 = FILE;
        FILE_LIST = CollectionsKt.listOf(r119);
        AnnotationUseSiteTarget r120 = AnnotationUseSiteTarget.CONSTRUCTOR_PARAMETER;
        KotlinTarget r121 = VALUE_PARAMETER;
        USE_SITE_MAPPING = MapsKt.mapOf(new Pair[]{TuplesKt.to(r120, r121), TuplesKt.to(AnnotationUseSiteTarget.FIELD, r116), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY, r115), TuplesKt.to(AnnotationUseSiteTarget.FILE, r119), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_GETTER, r118), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_SETTER, r117), TuplesKt.to(AnnotationUseSiteTarget.RECEIVER, r121), TuplesKt.to(AnnotationUseSiteTarget.SETTER_PARAMETER, r121), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD, r116)});
    }

    public static KotlinTarget[] values() {
        return (KotlinTarget[]) $VALUES.clone();
    }

    public static KotlinTarget valueOf(String r100) {
        return (KotlinTarget) a.a(KotlinTarget.class, r100);
    }

    private KotlinTarget(String r100, int r101, String r102, boolean r103) {
        super(r100, r101);
        this.description = r102;
        this.isDefault = r103;
    }

    public /* synthetic */ KotlinTarget(String r100, int r101, String r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = true;
    L5:
        this(r100, r101, r102, r103);
    }
}
