package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes42.dex */
public final class TypeMappingMode {
    public static final TypeMappingMode CLASS_DECLARATION = null;
    public static final Companion Companion = null;
    public static final TypeMappingMode DEFAULT = null;
    public static final TypeMappingMode DEFAULT_UAST = null;
    public static final TypeMappingMode GENERIC_ARGUMENT = null;
    public static final TypeMappingMode GENERIC_ARGUMENT_UAST = null;
    public static final TypeMappingMode RETURN_TYPE_BOXED = null;
    public static final TypeMappingMode SUPER_TYPE = null;
    public static final TypeMappingMode SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS = null;
    public static final TypeMappingMode VALUE_FOR_ANNOTATION = null;
    private final TypeMappingMode genericArgumentMode;
    private final TypeMappingMode genericContravariantArgumentMode;
    private final TypeMappingMode genericInvariantArgumentMode;
    private final boolean isForAnnotationParameter;
    private final boolean kotlinCollectionsToJavaCollections;
    private final boolean mapTypeAliases;
    private final boolean needInlineClassWrapping;
    private final boolean needPrimitiveBoxing;
    private final boolean skipDeclarationSiteWildcards;
    private final boolean skipDeclarationSiteWildcardsIfPossible;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[Variance.values().length];
            r100[Variance.IN_VARIANCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Variance.INVARIANT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public TypeMappingMode() {
        this(false, false, false, false, false, null, false, null, null, false, 1023, null);
    }

    static {
        Companion = new Companion(null);
        boolean r100 = false;
        boolean r101 = false;
        boolean r102 = false;
        boolean r103 = false;
        TypeMappingMode r104 = null;
        boolean r105 = false;
        TypeMappingMode r110 = null;
        TypeMappingMode r111 = null;
        boolean r112 = false;
        DefaultConstructorMarker r113 = null;
        TypeMappingMode r106 = new TypeMappingMode(r100, false, r101, r102, r103, r104, r105, r110, r111, r112, 1023, r113);
        GENERIC_ARGUMENT = r106;
        boolean r114 = false;
        boolean r115 = false;
        boolean r116 = false;
        boolean r117 = false;
        boolean r210 = false;
        boolean r211 = false;
        TypeMappingMode r212 = null;
        TypeMappingMode r213 = null;
        boolean r214 = true;
        DefaultConstructorMarker r215 = null;
        TypeMappingMode r107 = new TypeMappingMode(r114, r115, r116, r117, r210, null, r211, r212, r213, r214, 511, r215);
        GENERIC_ARGUMENT_UAST = r107;
        RETURN_TYPE_BOXED = new TypeMappingMode(r100, true, r101, r102, r103, r104, r105, r110, r111, r112, 1021, r113);
        int r118 = 988;
        DEFAULT = new TypeMappingMode(r100, false, r101, r102, r103, r106, r105, r110, r111, r112, r118, r113);
        DEFAULT_UAST = new TypeMappingMode(r114, r115, r116, r117, r210, r107, r211, r212, r213, r214, 476, r215);
        CLASS_DECLARATION = new TypeMappingMode(r100, true, r101, r102, r103, r106, r105, r110, r111, r112, r118, r113);
        boolean r108 = false;
        boolean r109 = true;
        SUPER_TYPE = new TypeMappingMode(r100, r108, r101, r109, r103, r106, r105, r110, r111, r112, 983, r113);
        SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS = new TypeMappingMode(r100, r108, r101, r109, r103, r106, r105, r110, r111, r112, 919, r113);
        VALUE_FOR_ANNOTATION = new TypeMappingMode(r100, r108, true, false, r103, r106, r105, r110, r111, r112, 984, r113);
    }

    public final TypeMappingMode wrapInlineClassesMode() {
        return new TypeMappingMode(this.needPrimitiveBoxing, true, this.isForAnnotationParameter, this.skipDeclarationSiteWildcards, this.skipDeclarationSiteWildcardsIfPossible, this.genericArgumentMode, this.kotlinCollectionsToJavaCollections, this.genericContravariantArgumentMode, this.genericInvariantArgumentMode, false, 512, null);
    }

    public final boolean getKotlinCollectionsToJavaCollections() {
        return this.kotlinCollectionsToJavaCollections;
    }

    public final boolean getMapTypeAliases() {
        return this.mapTypeAliases;
    }

    public final boolean getNeedInlineClassWrapping() {
        return this.needInlineClassWrapping;
    }

    public final boolean getNeedPrimitiveBoxing() {
        return this.needPrimitiveBoxing;
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    public final TypeMappingMode toGenericArgumentMode(Variance r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "effectiveVariance");
        if (r101 == true) goto L5;
    L7:
        int r102 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        if (r102 != 1) goto L10;
        TypeMappingMode r103 = this.genericContravariantArgumentMode;
        if (r103 == null) goto L20;
        return r103;
    L20:
        return this;
    L10:
        if (r102 == 2) goto L14;
        TypeMappingMode r104 = this.genericArgumentMode;
        if (r104 == null) goto L20;
        return r104;
    L14:
        TypeMappingMode r105 = this.genericInvariantArgumentMode;
        if (r105 == null) goto L20;
        return r105;
    L5:
        if (this.isForAnnotationParameter == false) goto L7;
        goto L7
    }

    public TypeMappingMode(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, TypeMappingMode r105, boolean r106, TypeMappingMode r107, TypeMappingMode r108, boolean r110) {
        this.needPrimitiveBoxing = r100;
        this.needInlineClassWrapping = r101;
        this.isForAnnotationParameter = r102;
        this.skipDeclarationSiteWildcards = r103;
        this.skipDeclarationSiteWildcardsIfPossible = r104;
        this.genericArgumentMode = r105;
        this.kotlinCollectionsToJavaCollections = r106;
        this.genericContravariantArgumentMode = r107;
        this.genericInvariantArgumentMode = r108;
        this.mapTypeAliases = r110;
    }

    public /* synthetic */ TypeMappingMode(boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, TypeMappingMode r115, boolean r116, TypeMappingMode r117, TypeMappingMode r210, boolean r211, int r212, DefaultConstructorMarker r213) {
        boolean r100 = true;
        if ((r212 & 1) == 0) goto L5;
        boolean r101 = true;
    L7:
        if ((r212 & 2) == 0) goto L9;
        boolean r102 = true;
    L10:
        boolean r103 = false;
        if ((r212 & 4) == 0) goto L13;
        boolean r104 = false;
    L15:
        if ((r212 & 8) == 0) goto L17;
        boolean r105 = false;
    L19:
        if ((r212 & 16) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r212 & 32) == 0) goto L25;
        TypeMappingMode r107 = null;
    L27:
        if ((r212 & 64) != 0) goto L31;
        r100 = r116;
    L31:
        if ((r212 & 128) == 0) goto L33;
        TypeMappingMode r108 = r107;
    L35:
        if ((r212 & 256) == 0) goto L37;
        TypeMappingMode r118 = r107;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r103 = r211;
    L42:
        this(r101, r102, r104, r105, r106, r107, r100, r108, r118, r103);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
        goto L35
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}
