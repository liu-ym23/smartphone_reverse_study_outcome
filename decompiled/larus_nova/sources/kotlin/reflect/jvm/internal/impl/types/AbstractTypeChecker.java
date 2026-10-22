package kotlin.reflect.jvm.internal.impl.types;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* JADX INFO: loaded from: classes42.dex */
public final class AbstractTypeChecker {
    public static final AbstractTypeChecker INSTANCE = null;
    public static boolean RUN_SLOW_ASSERTIONS;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r100 = new int[TypeVariance.values().length];
            r100[TypeVariance.INV.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r100[TypeVariance.OUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r100[TypeVariance.IN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            $EnumSwitchMapping$0 = r100;
            int[] r101 = new int[TypeCheckerState.LowerCapturedTypePolicy.values().length];
            r101[TypeCheckerState.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r101[TypeCheckerState.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r101[TypeCheckerState.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            $EnumSwitchMapping$1 = r101;
        }
    }

    static {
        INSTANCE = new AbstractTypeChecker();
    }

    private AbstractTypeChecker() {
    }

    public static /* synthetic */ Unit accessor$AbstractTypeChecker$lambda0(Collection r100, TypeCheckerState r101, TypeSystemContext r102, SimpleTypeMarker r103, TypeCheckerState.ForkPointContext r104) {
        return isSubtypeOfForSingleClassifierType$lambda$21$lambda$20(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ boolean accessor$AbstractTypeChecker$lambda1(TypeCheckerState r100, TypeSystemContext r101, SimpleTypeMarker r102, SimpleTypeMarker r103) {
        return isSubtypeOfForSingleClassifierType$lambda$21$lambda$20$lambda$19(r100, r101, r102, r103);
    }

    public final boolean isSubtypeOf(TypeCheckerState r100, KotlinTypeMarker r110, KotlinTypeMarker r111) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r110, "subType");
        Intrinsics.checkNotNullParameter(r111, "superType");
        return isSubtypeOf$default(this, r100, r110, r111, false, 8, null);
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isCapturedIntegerLiteralType(TypeSystemContext r100, SimpleTypeMarker r101) {
        if ((r101 instanceof CapturedTypeMarker) == true) goto L5;
        return false;
    L5:
        TypeArgumentMarker r102 = r100.projection(r100.typeConstructor((CapturedTypeMarker) r101));
        if (r100.isStarProjection(r102) == false) goto L8;
        return false;
    L8:
        if (r100.isIntegerLiteralType(r100.upperBoundIfFlexible(r100.getType(r102))) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeInIntersectionComponents(TypeSystemContext r100, SimpleTypeMarker r101) {
        TypeConstructorMarker r102 = r100.typeConstructor(r101);
        if ((r102 instanceof IntersectionTypeConstructorMarker) == false) goto L28;
        Collection<KotlinTypeMarker> r103 = r100.supertypes(r102);
        if ((r103 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L8;
        SimpleTypeMarker r105 = r100.asSimpleType((KotlinTypeMarker) r104.next());
        if (r105 != null) goto L15;
    L17:
        boolean r106 = false;
    L18:
        if (r106 == false) goto L11;
        boolean r107 = true;
    L20:
        if (r107 == false) goto L29;
        return true;
    L29:
        return false;
    L15:
        if (r100.isIntegerLiteralType(r105) != true) goto L17;
        r106 = true;
    L8:
        r107 = false;
        goto L20
    L7:
        if (r103.isEmpty() == false) goto L9;
    L28:
        return false;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(TypeSystemContext r100, SimpleTypeMarker r101) {
        if (r100.isIntegerLiteralType(r101) == false) goto L5;
    L8:
        return true;
    L5:
        if (checkSubtypeForIntegerLiteralType$lambda$7$isCapturedIntegerLiteralType(r100, r101) == true) goto L8;
        return false;
    }

    private final boolean hasNothingSupertype(TypeCheckerState r110, SimpleTypeMarker r111) {
        TypeSystemContext r100 = r110.getTypeSystemContext();
        TypeConstructorMarker r101 = r100.typeConstructor(r111);
        if (r100.isClassTypeConstructor(r101) == false) goto L7;
        return r100.isNothingConstructor(r101);
    L7:
        if (r100.isNothingConstructor(r100.typeConstructor(r111)) == true) goto L47;
        r110.initialize();
        ArrayDeque<SimpleTypeMarker> r102 = r110.getSupertypesDeque();
        Intrinsics.checkNotNull(r102);
        Set<SimpleTypeMarker> r103 = r110.getSupertypesSet();
        Intrinsics.checkNotNull(r103);
        r102.push(r111);
    L11:
        if ((!r102.isEmpty()) == false) goto L35;
        if (r103.size() > 1000) goto L34;
        SimpleTypeMarker r104 = r102.pop();
        Intrinsics.checkNotNull(r104);
        if (r103.add(r104) == false) goto L11;
        if (r100.isClassType(r104) == false) goto L19;
        TypeCheckerState.SupertypesPolicy r105 = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
    L21:
        if ((!Intrinsics.areEqual(r105, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) == true) goto L24;
        r105 = null;
    L24:
        if (r105 == null) goto L11;
        TypeSystemContext r106 = r110.getTypeSystemContext();
        Iterator<KotlinTypeMarker> r107 = r106.supertypes(r106.typeConstructor(r104)).iterator();
    L28:
        if (r107.hasNext() == false) goto L11;
        SimpleTypeMarker r108 = r105.mo10736transformType(r110, r107.next());
        if (r100.isNothingConstructor(r100.typeConstructor(r108)) == true) goto L31;
        r102.add(r108);
        goto L28
    L31:
        r110.clear();
        return true;
    L19:
        r105 = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
        goto L21
    L34:
        throw new IllegalStateException(("Too many supertypes for type: " + r111 + ". Supertypes = " + CollectionsKt.joinToString$default(r103, null, null, null, 0, null, null, 63, null)).toString());
    L35:
        r110.clear();
        return false;
    L47:
        return true;
    }

    private final boolean isCommonDenotableType(TypeSystemContext r100, KotlinTypeMarker r101) {
        if (r100.isDenotable(r100.typeConstructor(r101)) == true) goto L5;
    L13:
        return false;
    L5:
        if (r100.isDynamic(r101) == true) goto L13;
        if (r100.isDefinitelyNotNullType(r101) == true) goto L13;
        if (r100.isNotNullTypeParameter(r101) == true) goto L13;
        if (r100.isFlexibleWithDifferentTypeConstructors(r101) == true) goto L13;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<SimpleTypeMarker> selectOnlyPureKotlinSupertypes(TypeCheckerState r110, List<? extends SimpleTypeMarker> r111) {
        TypeSystemContext r112 = r110.getTypeSystemContext();
        if (r111.size() >= 2) goto L5;
        return r111;
    L5:
        ArrayList r100 = new ArrayList();
        Iterator r101 = r111.iterator();
    L6:
        boolean r102 = true;
        if (r101.hasNext() == false) goto L20;
        Object r103 = r101.next();
        TypeArgumentListMarker r104 = r112.asArgumentList((SimpleTypeMarker) r103);
        int r105 = r112.size(r104);
        int r106 = 0;
    L9:
        if (r106 >= r105) goto L17;
        if (r112.asFlexibleType(r112.getType(r112.get(r104, r106))) != null) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == false) goto L15;
        r106 = r106 + 1;
        goto L9
    L15:
        r102 = false;
        goto L17
    L13:
        r107 = false;
    L17:
        if (r102 == false) goto L6;
        r100.add(r103);
        goto L6
    L20:
        if ((!r100.isEmpty()) == true) goto L22;
        return r111;
    L22:
        return r100;
    }

    public final TypeVariance effectiveVariance(TypeVariance r100, TypeVariance r101) {
        Intrinsics.checkNotNullParameter(r100, "declared");
        Intrinsics.checkNotNullParameter(r101, "useSite");
        TypeVariance r102 = TypeVariance.INV;
        if (r100 != r102) goto L5;
        return r101;
    L5:
        if (r101 != r102) goto L7;
        return r100;
    L7:
        if (r100 != r101) goto L9;
        return r100;
    L9:
        return null;
    }

    private final Boolean checkSubtypeForIntegerLiteralType(TypeCheckerState r100, SimpleTypeMarker r101, SimpleTypeMarker r102) {
        TypeSystemContext r103 = r100.getTypeSystemContext();
        if (r103.isIntegerLiteralType(r101) == true) goto L8;
        if (r103.isIntegerLiteralType(r102) == true) goto L8;
        return null;
    L8:
        if (checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(r103, r101) == false) goto L14;
        if (checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(r103, r102) == false) goto L14;
        return Boolean.TRUE;
    L14:
        if (r103.isIntegerLiteralType(r101) == false) goto L20;
        if (checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(r103, r100, r101, r102, false) == true) goto L18;
    L27:
        return null;
    L18:
        return Boolean.TRUE;
    L20:
        if (r103.isIntegerLiteralType(r102) == false) goto L27;
        if (checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeInIntersectionComponents(r103, r101) == true) goto L26;
        if (checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(r103, r100, r102, r101, true) == false) goto L27;
    L26:
        return Boolean.TRUE;
    }

    private final Boolean checkSubtypeForSpecialCases(TypeCheckerState r110, SimpleTypeMarker r111, SimpleTypeMarker r112) {
        TypeSystemContext r100 = r110.getTypeSystemContext();
        boolean r113 = false;
        if (r100.isError(r111) == true) goto L96;
        if (r100.isError(r112) == true) goto L96;
        if (r100.isStubTypeForBuilderInference(r111) == false) goto L19;
        if (r100.isStubTypeForBuilderInference(r112) == false) goto L19;
        if (INSTANCE.isStubTypeSubtypeOfAnother(r100, r111, r112) == false) goto L14;
    L15:
        r113 = true;
    L17:
        return Boolean.valueOf(r113);
    L14:
        if (r110.isStubTypeEqualsToAnything() == false) goto L17;
    L19:
        if (r100.isStubType(r111) == true) goto L94;
        if (r100.isStubType(r112) == true) goto L94;
        DefinitelyNotNullTypeMarker r101 = r100.asDefinitelyNotNullType(r112);
        if (r101 == null) goto L27;
        SimpleTypeMarker r102 = r100.original(r101);
        if (r102 == null) goto L27;
    L28:
        CapturedTypeMarker r103 = r100.asCapturedType(r102);
        if (r103 == null) goto L31;
        KotlinTypeMarker r104 = r100.lowerType(r103);
    L32:
        if (r103 == null) goto L57;
        if (r104 == null) goto L57;
        if (r100.isMarkedNullable(r112) == false) goto L39;
        r104 = r100.withNullability(r104, true);
    L37:
        KotlinTypeMarker r105 = r104;
        int r106 = WhenMappings.$EnumSwitchMapping$1[r110.getLowerCapturedTypePolicy(r111, r103).ordinal()];
        if (r106 == 1) goto L55;
        if (r106 == 2) goto L51;
        if (r106 == 3) goto L57;
        throw new NoWhenBranchMatchedException();
    L51:
        if (isSubtypeOf$default(INSTANCE, r110, r111, r105, false, 8, null) == false) goto L57;
        return Boolean.TRUE;
    L55:
        return Boolean.valueOf(isSubtypeOf$default(INSTANCE, r110, r111, r105, false, 8, null));
    L39:
        if (r100.isDefinitelyNotNullType(r112) == false) goto L37;
        r104 = r100.makeDefinitelyNotNullOrNotNull(r104);
    L57:
        TypeConstructorMarker r107 = r100.typeConstructor(r112);
        if (r100.isIntersection(r107) == false) goto L71;
        r100.isMarkedNullable(r112);
        Collection<KotlinTypeMarker> r108 = r100.supertypes(r107);
        if ((r108 instanceof Collection) == true) goto L62;
    L64:
        Iterator<T> r109 = r108.iterator();
    L66:
        if (r109.hasNext() == false) goto L63;
        if (isSubtypeOf$default(INSTANCE, r110, r111, (KotlinTypeMarker) r109.next(), false, 8, null) == true) goto L66;
    L70:
        return Boolean.valueOf(r113);
    L63:
        r113 = true;
        goto L70
    L62:
        if (r108.isEmpty() == false) goto L64;
    L71:
        TypeConstructorMarker r114 = r100.typeConstructor(r111);
        if ((r111 instanceof CapturedTypeMarker) == false) goto L74;
    L86:
        TypeParameterMarker r115 = INSTANCE.getTypeParameterForArgumentInBaseIfItEqualToTarget(r110.getTypeSystemContext(), r112, r111);
        if (r115 != null) goto L89;
    L92:
        return null;
    L89:
        if (r100.hasRecursiveBounds(r115, r100.typeConstructor(r112)) == false) goto L92;
        return Boolean.TRUE;
    L74:
        if (r100.isIntersection(r114) == false) goto L92;
        Collection<KotlinTypeMarker> r116 = r100.supertypes(r114);
        if ((r116 instanceof Collection) == true) goto L78;
    L80:
        Iterator<T> r117 = r116.iterator();
    L82:
        if (r117.hasNext() == false) goto L79;
        if ((((KotlinTypeMarker) r117.next()) instanceof CapturedTypeMarker) == true) goto L82;
    L85:
        if (r113 == false) goto L92;
    L79:
        r113 = true;
        goto L85
    L78:
        if (r116.isEmpty() == false) goto L80;
    L31:
        r104 = null;
    L27:
        r102 = r112;
    L94:
        return Boolean.valueOf(r110.isStubTypeEqualsToAnything());
    L96:
        if (r110.isErrorTypeEqualsToAnything() == false) goto L100;
        return Boolean.TRUE;
    L100:
        if (r100.isMarkedNullable(r111) == false) goto L106;
        if (r100.isMarkedNullable(r112) == true) goto L106;
        return Boolean.FALSE;
    L106:
        return Boolean.valueOf(AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes(r100, r100.withNullability(r111, false), r100.withNullability(r112, false)));
    }

    private final List<SimpleTypeMarker> collectAllSupertypesWithGivenTypeConstructor(TypeCheckerState r110, SimpleTypeMarker r111, TypeConstructorMarker r112) {
        SimpleTypeMarker r100 = r111;
        TypeSystemContext r101 = r110.getTypeSystemContext();
        List<SimpleTypeMarker> r102 = r101.fastCorrespondingSupertypes(r100, r112);
        if (r102 == null) goto L6;
        return r102;
    L6:
        if (r101.isClassTypeConstructor(r112) == true) goto L12;
        if (r101.isClassType(r100) == false) goto L12;
        return CollectionsKt.emptyList();
    L12:
        if (r101.isCommonFinalClassConstructor(r112) == true) goto L14;
        SmartList r103 = new SmartList();
        r110.initialize();
        ArrayDeque<SimpleTypeMarker> r104 = r110.getSupertypesDeque();
        Intrinsics.checkNotNull(r104);
        Set<SimpleTypeMarker> r105 = r110.getSupertypesSet();
        Intrinsics.checkNotNull(r105);
        r104.push(r100);
    L24:
        if ((!r104.isEmpty()) == false) goto L52;
        if (r105.size() > 1000) goto L51;
        SimpleTypeMarker r106 = r104.pop();
        Intrinsics.checkNotNull(r106);
        if (r105.add(r106) == false) goto L24;
        SimpleTypeMarker r107 = r101.captureFromArguments(r106, CaptureStatus.FOR_SUBTYPING);
        if (r107 != null) goto L33;
        r107 = r106;
    L33:
        if (r101.areEqualTypeConstructors(r101.typeConstructor(r107), r112) == false) goto L36;
        r103.add(r107);
        TypeCheckerState.SupertypesPolicy r108 = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
    L40:
        if ((!Intrinsics.areEqual(r108, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) == true) goto L43;
        r108 = null;
    L43:
        if (r108 == null) goto L24;
        TypeSystemContext r109 = r110.getTypeSystemContext();
        Iterator<KotlinTypeMarker> r113 = r109.supertypes(r109.typeConstructor(r106)).iterator();
    L47:
        if (r113.hasNext() == false) goto L24;
        r104.add(r108.mo10736transformType(r110, r113.next()));
        goto L47
    L36:
        if (r101.argumentsCount(r107) != 0) goto L38;
        r108 = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
        goto L40
    L38:
        r108 = r110.getTypeSystemContext().substitutionSupertypePolicy(r107);
        goto L40
    L51:
        throw new IllegalStateException(("Too many supertypes for type: " + r100 + ". Supertypes = " + CollectionsKt.joinToString$default(r105, null, null, null, 0, null, null, 63, null)).toString());
    L52:
        r110.clear();
        return r103;
    L14:
        if (r101.areEqualTypeConstructors(r101.typeConstructor(r100), r112) == false) goto L21;
        SimpleTypeMarker r114 = r101.captureFromArguments(r100, CaptureStatus.FOR_SUBTYPING);
        if (r114 == null) goto L62;
        r100 = r114;
    L62:
        return CollectionsKt.listOf(r100);
    L21:
        return CollectionsKt.emptyList();
    }

    private final List<SimpleTypeMarker> collectAndFilter(TypeCheckerState r100, SimpleTypeMarker r101, TypeConstructorMarker r102) {
        return selectOnlyPureKotlinSupertypes(r100, collectAllSupertypesWithGivenTypeConstructor(r100, r101, r102));
    }

    private final TypeParameterMarker getTypeParameterForArgumentInBaseIfItEqualToTarget(TypeSystemContext r100, KotlinTypeMarker r101, KotlinTypeMarker r110) {
        int r102 = r100.argumentsCount(r101);
        int r103 = 0;
    L3:
        TypeArgumentMarker r104 = null;
        if (r103 >= r102) goto L30;
        TypeArgumentMarker r105 = r100.getArgument(r101, r103);
        boolean r106 = true;
        if ((!r100.isStarProjection(r105)) == false) goto L8;
        r104 = r105;
    L8:
        if (r104 == null) goto L29;
        KotlinTypeMarker r107 = r100.getType(r104);
        if (r107 == null) goto L29;
        if (r100.isCapturedType(r100.originalIfDefinitelyNotNullable(r100.lowerBoundIfFlexible(r107))) == true) goto L15;
    L17:
        r106 = false;
    L19:
        if (Intrinsics.areEqual(r107, r110) == true) goto L28;
        if (r106 == true) goto L22;
    L24:
        TypeParameterMarker r108 = getTypeParameterForArgumentInBaseIfItEqualToTarget(r100, r107, r110);
        if (r108 == null) goto L29;
        return r108;
    L22:
        if (Intrinsics.areEqual(r100.typeConstructor(r107), r100.typeConstructor(r110)) == false) goto L24;
    L28:
        return r100.getParameter(r100.typeConstructor(r101), r103);
    L15:
        if (r100.isCapturedType(r100.originalIfDefinitelyNotNullable(r100.lowerBoundIfFlexible(r110))) == false) goto L17;
    L29:
        r103 = r103 + 1;
        goto L3
    L30:
        return null;
    }

    private final boolean isStubTypeSubtypeOfAnother(TypeSystemContext r100, SimpleTypeMarker r101, SimpleTypeMarker r102) {
        DefinitelyNotNullTypeMarker r103 = r100.asDefinitelyNotNullType(r101);
        if (r103 == null) goto L6;
        SimpleTypeMarker r104 = r100.original(r103);
        if (r104 == null) goto L6;
    L7:
        DefinitelyNotNullTypeMarker r105 = r100.asDefinitelyNotNullType(r102);
        if (r105 == null) goto L11;
        SimpleTypeMarker r106 = r100.original(r105);
        if (r106 == null) goto L11;
    L13:
        if (r100.typeConstructor(r104) == r100.typeConstructor(r106)) goto L16;
        return false;
    L16:
        if (r100.isDefinitelyNotNullType(r101) == true) goto L21;
        if (r100.isDefinitelyNotNullType(r102) == false) goto L21;
        return false;
    L21:
        if (r100.isMarkedNullable(r101) == true) goto L23;
        return true;
    L23:
        if (r100.isMarkedNullable(r102) == true) goto L27;
        return false;
    L27:
        return true;
    L11:
        r106 = r102;
    L6:
        r104 = r101;
        goto L7
    }

    private final boolean isSubtypeOfForSingleClassifierType(final TypeCheckerState r110, SimpleTypeMarker r111, final SimpleTypeMarker r210) {
        final TypeSystemContext r100 = r110.getTypeSystemContext();
        if (RUN_SLOW_ASSERTIONS == false) goto L13;
        if (r100.isSingleClassifierType(r111) == true) goto L10;
        if (r100.isIntersection(r100.typeConstructor(r111)) == true) goto L10;
        r110.isAllowedTypeVariable(r111);
    L10:
        if (r100.isSingleClassifierType(r210) == true) goto L13;
        r110.isAllowedTypeVariable(r210);
    L13:
        if (AbstractNullabilityChecker.INSTANCE.isPossibleSubtype(r110, r111, r210) == true) goto L15;
        return false;
    L15:
        AbstractTypeChecker r101 = INSTANCE;
        Boolean r102 = r101.checkSubtypeForIntegerLiteralType(r110, r100.lowerBoundIfFlexible(r111), r100.upperBoundIfFlexible(r210));
        if (r102 == null) goto L19;
        boolean r103 = r102.booleanValue();
        TypeCheckerState.addSubtypeConstraint$default(r110, r111, r210, false, 4, null);
        return r103;
    L19:
        TypeConstructorMarker r104 = r100.typeConstructor(r210);
        if (r100.areEqualTypeConstructors(r100.typeConstructor(r111), r104) == false) goto L25;
        if (r100.parametersCount(r104) != 0) goto L25;
        return true;
    L25:
        if (r100.isAnyConstructor(r100.typeConstructor(r210)) == false) goto L27;
        return true;
    L27:
        List<SimpleTypeMarker> r105 = r101.findCorrespondingSupertypes(r110, r111, r104);
        int r112 = 10;
        if (r105.size() <= 1) goto L47;
        TypeSystemContext r106 = r110.getTypeSystemContext();
        if ((r106 instanceof TypeSystemInferenceExtensionContext) == false) goto L32;
        TypeSystemInferenceExtensionContext r107 = (TypeSystemInferenceExtensionContext) r106;
    L33:
        if (r107 != null) goto L35;
    L37:
        boolean r108 = false;
    L38:
        if (r108 == false) goto L47;
        final Collection r109 = new LinkedHashSet();
        Iterator<T> r113 = r105.iterator();
    L41:
        if (r113.hasNext() == false) goto L55;
        SimpleTypeMarker r114 = (SimpleTypeMarker) r113.next();
        SimpleTypeMarker r115 = r100.asSimpleType(r110.prepareType(r114));
        if (r115 == null) goto L46;
        r114 = r115;
    L46:
        r109.add(r114);
    L55:
        int r116 = r109.size();
        if (r116 == 0) goto L97;
        if (r116 == 1) goto L95;
        ArgumentList r117 = new ArgumentList(r100.parametersCount(r104));
        int r118 = r100.parametersCount(r104);
        int r119 = 0;
        boolean r120 = false;
    L59:
        if (r119 >= r118) goto L87;
        if (r120 == false) goto L62;
    L65:
        r120 = true;
    L66:
        if (r120 == true) goto L86;
        ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, r112));
        Iterator r122 = r109.iterator();
    L69:
        if (r122.hasNext() == false) goto L85;
        SimpleTypeMarker r123 = (SimpleTypeMarker) r122.next();
        TypeArgumentMarker r124 = r100.getArgumentOrNull(r123, r119);
        if (r124 == null) goto L84;
        if (r100.getVariance(r124) != TypeVariance.INV) goto L75;
        boolean r125 = true;
    L76:
        if (r125 == true) goto L79;
        r124 = null;
    L79:
        if (r124 == null) goto L84;
        KotlinTypeMarker r126 = r100.getType(r124);
        if (r126 == null) goto L84;
        r121.add(r126);
        goto L69
    L75:
        r125 = false;
    L84:
        throw new IllegalStateException(("Incorrect type: " + r123 + ", subType: " + r111 + ", superType: " + r210).toString());
    L85:
        r117.add(r100.asTypeArgument(r100.intersectTypes(r121)));
    L86:
        r119 = r119 + 1;
        r112 = 10;
        goto L59
    L62:
        if (r100.getVariance(r100.getParameter(r104, r119)) != TypeVariance.OUT) goto L65;
        r120 = false;
        goto L66
    L87:
        if (r120 == true) goto L93;
        if (INSTANCE.isSubtypeForSameConstructor(r110, r117, r210) == false) goto L93;
        return true;
    L93:
        return r110.runForkingPoint(new AbstractTypeChecker$$Lambda$0(r109, r110, r100, r210));
    L95:
        return INSTANCE.isSubtypeForSameConstructor(r110, r100.asArgumentList((SimpleTypeMarker) CollectionsKt.first(r109)), r210);
    L97:
        return INSTANCE.hasNothingSupertype(r110, r111);
    L35:
        if (r107.isK2() != true) goto L37;
        r108 = true;
        goto L38
    L32:
        r107 = null;
    L47:
        List<SimpleTypeMarker> r127 = r105;
        r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r127, 10));
        Iterator<T> r128 = r127.iterator();
    L49:
        if (r128.hasNext() == false) goto L55;
        SimpleTypeMarker r129 = (SimpleTypeMarker) r128.next();
        SimpleTypeMarker r130 = r100.asSimpleType(r110.prepareType(r129));
        if (r130 == null) goto L54;
        r129 = r130;
    L54:
        r109.add(r129);
        goto L49
    }

    public final boolean equalTypes(TypeCheckerState r110, KotlinTypeMarker r111, KotlinTypeMarker r112) {
        Intrinsics.checkNotNullParameter(r110, "state");
        Intrinsics.checkNotNullParameter(r111, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r112, "b");
        TypeSystemContext r100 = r110.getTypeSystemContext();
        if (r111 != r112) goto L5;
        return true;
    L5:
        AbstractTypeChecker r101 = INSTANCE;
        if (r101.isCommonDenotableType(r100, r111) == false) goto L25;
        if (r101.isCommonDenotableType(r100, r112) == false) goto L25;
        KotlinTypeMarker r102 = r110.prepareType(r110.refineType(r111));
        KotlinTypeMarker r103 = r110.prepareType(r110.refineType(r112));
        SimpleTypeMarker r104 = r100.lowerBoundIfFlexible(r102);
        if (r100.areEqualTypeConstructors(r100.typeConstructor(r102), r100.typeConstructor(r103)) == true) goto L13;
        return false;
    L13:
        if (r100.argumentsCount(r104) != 0) goto L25;
        if (r100.hasFlexibleNullability(r102) == false) goto L17;
        return true;
    L17:
        if (r100.hasFlexibleNullability(r103) == false) goto L20;
        return true;
    L20:
        if (r100.isMarkedNullable(r104) == r100.isMarkedNullable(r100.lowerBoundIfFlexible(r103))) goto L33;
        return false;
    L33:
        return true;
    L25:
        if (isSubtypeOf$default(r101, r110, r111, r112, false, 8, null) == true) goto L27;
    L29:
        return false;
    L27:
        if (isSubtypeOf$default(r101, r110, r112, r111, false, 8, null) == false) goto L29;
        return true;
    }

    public final List<SimpleTypeMarker> findCorrespondingSupertypes(TypeCheckerState r110, SimpleTypeMarker r111, TypeConstructorMarker r112) {
        Intrinsics.checkNotNullParameter(r110, "state");
        Intrinsics.checkNotNullParameter(r111, "subType");
        Intrinsics.checkNotNullParameter(r112, "superConstructor");
        TypeSystemContext r100 = r110.getTypeSystemContext();
        if (r100.isClassType(r111) == false) goto L7;
        return INSTANCE.collectAndFilter(r110, r111, r112);
    L7:
        if (r100.isClassTypeConstructor(r112) == false) goto L9;
    L12:
        SmartList r101 = new SmartList();
        r110.initialize();
        ArrayDeque<SimpleTypeMarker> r102 = r110.getSupertypesDeque();
        Intrinsics.checkNotNull(r102);
        Set<SimpleTypeMarker> r103 = r110.getSupertypesSet();
        Intrinsics.checkNotNull(r103);
        r102.push(r111);
    L14:
        if ((!r102.isEmpty()) == false) goto L35;
        if (r103.size() > 1000) goto L34;
        SimpleTypeMarker r104 = r102.pop();
        Intrinsics.checkNotNull(r104);
        if (r103.add(r104) == false) goto L14;
        if (r100.isClassType(r104) == false) goto L22;
        r101.add(r104);
        TypeCheckerState.SupertypesPolicy r105 = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
    L24:
        if ((!Intrinsics.areEqual(r105, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) == true) goto L27;
        r105 = null;
    L27:
        if (r105 == null) goto L14;
        TypeSystemContext r106 = r110.getTypeSystemContext();
        Iterator<KotlinTypeMarker> r107 = r106.supertypes(r106.typeConstructor(r104)).iterator();
    L31:
        if (r107.hasNext() == false) goto L14;
        r102.add(r105.mo10736transformType(r110, r107.next()));
        goto L31
    L22:
        r105 = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
        goto L24
    L34:
        throw new IllegalStateException(("Too many supertypes for type: " + r111 + ". Supertypes = " + CollectionsKt.joinToString$default(r103, null, null, null, 0, null, null, 63, null)).toString());
    L35:
        r110.clear();
        ArrayList r108 = new ArrayList();
        Iterator<E> r109 = r101.iterator();
    L37:
        if (r109.hasNext() == false) goto L39;
        SimpleTypeMarker r113 = (SimpleTypeMarker) r109.next();
        AbstractTypeChecker r114 = INSTANCE;
        Intrinsics.checkNotNull(r113);
        CollectionsKt.addAll(r108, r114.collectAndFilter(r110, r113, r112));
        goto L37
    L39:
        return r108;
    L9:
        if (r100.isIntegerLiteralTypeConstructor(r112) == true) goto L12;
        return INSTANCE.collectAllSupertypesWithGivenTypeConstructor(r110, r111, r112);
    }

    public final boolean isSubtypeForSameConstructor(TypeCheckerState r110, TypeArgumentListMarker r111, SimpleTypeMarker r112) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "capturedSubArguments");
        Intrinsics.checkNotNullParameter(r112, "superType");
        TypeSystemContext r113 = r110.getTypeSystemContext();
        TypeConstructorMarker r114 = r113.typeConstructor(r112);
        int r100 = r113.size(r111);
        int r115 = r113.parametersCount(r114);
        if (r100 == r115) goto L5;
    L45:
        return false;
    L5:
        if (r100 != r113.argumentsCount(r112)) goto L45;
        int r116 = 0;
    L9:
        if (r116 >= r115) goto L44;
        TypeArgumentMarker r101 = r113.getArgument(r112, r116);
        if (r113.isStarProjection(r101) == true) goto L43;
        KotlinTypeMarker r102 = r113.getType(r101);
        TypeArgumentMarker r103 = r113.get(r111, r116);
        r113.getVariance(r103);
        TypeVariance r104 = TypeVariance.INV;
        KotlinTypeMarker r105 = r113.getType(r103);
        AbstractTypeChecker r106 = INSTANCE;
        TypeVariance r107 = r106.effectiveVariance(r113.getVariance(r113.getParameter(r114, r116)), r113.getVariance(r101));
        if (r107 == null) goto L15;
        if (r107 == r104) goto L18;
    L22:
        boolean r108 = false;
    L23:
        if (r108 == true) goto L43;
        if (TypeCheckerState.access$getArgumentsDepth(r110) > 100) goto L42;
        TypeCheckerState.access$setArgumentsDepth(r110, TypeCheckerState.access$getArgumentsDepth(r110) + 1);
        int r109 = WhenMappings.$EnumSwitchMapping$0[r107.ordinal()];
        if (r109 != 1) goto L30;
        boolean r117 = r106.equalTypes(r110, r105, r102);
    L38:
        TypeCheckerState.access$setArgumentsDepth(r110, TypeCheckerState.access$getArgumentsDepth(r110) - 1);
        if (r117 == true) goto L43;
        return false;
    L30:
        if (r109 != 2) goto L32;
        r117 = isSubtypeOf$default(r106, r110, r105, r102, false, 8, null);
        goto L38
    L32:
        if (r109 != 3) goto L35;
        r117 = isSubtypeOf$default(r106, r110, r102, r105, false, 8, null);
        goto L38
    L35:
        throw new NoWhenBranchMatchedException();
    L42:
        throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + r105).toString());
    L18:
        if (r106.isTypeVariableAgainstStarProjectionForSelfType(r113, r105, r102, r114) == false) goto L20;
    L21:
        r108 = true;
        goto L23
    L20:
        if (r106.isTypeVariableAgainstStarProjectionForSelfType(r113, r102, r105, r114) == false) goto L22;
    L15:
        return r110.isErrorTypeEqualsToAnything();
    L43:
        r116 = r116 + 1;
        goto L9
    L44:
        return true;
    }

    private final boolean completeIsSubTypeOf(TypeCheckerState r100, KotlinTypeMarker r101, KotlinTypeMarker r102, boolean r103) {
        TypeSystemContext r104 = r100.getTypeSystemContext();
        KotlinTypeMarker r105 = r100.prepareType(r100.refineType(r101));
        KotlinTypeMarker r106 = r100.prepareType(r100.refineType(r102));
        AbstractTypeChecker r107 = INSTANCE;
        Boolean r108 = r107.checkSubtypeForSpecialCases(r100, r104.lowerBoundIfFlexible(r105), r104.upperBoundIfFlexible(r106));
        if (r108 == null) goto L6;
        boolean r109 = r108.booleanValue();
        r100.addSubtypeConstraint(r105, r106, r103);
        return r109;
    L6:
        Boolean r110 = r100.addSubtypeConstraint(r105, r106, r103);
        if (r110 == null) goto L11;
        return r110.booleanValue();
    L11:
        return r107.isSubtypeOfForSingleClassifierType(r100, r104.lowerBoundIfFlexible(r105), r104.upperBoundIfFlexible(r106));
    }

    private static final boolean isSubtypeOfForSingleClassifierType$lambda$21$lambda$20$lambda$19(TypeCheckerState r100, TypeSystemContext r101, SimpleTypeMarker r102, SimpleTypeMarker r103) {
        Intrinsics.checkNotNullParameter(r100, "$state");
        Intrinsics.checkNotNullParameter(r101, "$this_with");
        Intrinsics.checkNotNullParameter(r102, "$subTypeArguments");
        Intrinsics.checkNotNullParameter(r103, "$superType");
        return INSTANCE.isSubtypeForSameConstructor(r100, r101.asArgumentList(r102), r103);
    }

    private final boolean isTypeVariableAgainstStarProjectionForSelfType(TypeSystemContext r100, KotlinTypeMarker r101, KotlinTypeMarker r102, TypeConstructorMarker r103) {
        SimpleTypeMarker r104 = r100.asSimpleType(r101);
        if ((r104 instanceof CapturedTypeMarker) == false) goto L24;
        CapturedTypeMarker r105 = (CapturedTypeMarker) r104;
        if (r100.isOldCapturedType(r105) == false) goto L7;
        return false;
    L7:
        if (r100.isStarProjection(r100.projection(r100.typeConstructor(r105))) == true) goto L10;
        return false;
    L10:
        if (r100.captureStatus(r105) == CaptureStatus.FOR_SUBTYPING) goto L12;
        return false;
    L12:
        TypeConstructorMarker r106 = r100.typeConstructor(r102);
        if ((r106 instanceof TypeVariableTypeConstructorMarker) == false) goto L15;
        TypeVariableTypeConstructorMarker r107 = (TypeVariableTypeConstructorMarker) r106;
    L16:
        if (r107 != null) goto L18;
        return false;
    L18:
        TypeParameterMarker r108 = r100.getTypeParameter(r107);
        if (r108 != null) goto L21;
        return false;
    L21:
        if (r100.hasRecursiveBounds(r108, r103) != true) goto L27;
        return true;
    L27:
        return false;
    L15:
        r107 = null;
        goto L16
    L24:
        return false;
    }

    public final boolean isSubtypeOf(TypeCheckerState r100, KotlinTypeMarker r101, KotlinTypeMarker r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "subType");
        Intrinsics.checkNotNullParameter(r102, "superType");
        if (r101 != r102) goto L7;
        return true;
    L7:
        if (r100.customIsSubtypeOf(r101, r102) == true) goto L11;
        return false;
    L11:
        return completeIsSubTypeOf(r100, r101, r102, r103);
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(TypeSystemContext r110, TypeCheckerState r111, SimpleTypeMarker r112, SimpleTypeMarker r113, boolean r114) {
        Collection<KotlinTypeMarker> r115 = r110.possibleIntegerTypes(r112);
        if ((r115 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r116 = r115.iterator();
    L9:
        if (r116.hasNext() == false) goto L27;
        KotlinTypeMarker r100 = (KotlinTypeMarker) r116.next();
        if (Intrinsics.areEqual(r110.typeConstructor(r100), r110.typeConstructor(r113)) == true) goto L17;
        if (r114 == true) goto L14;
    L16:
        boolean r101 = false;
    L18:
        if (r101 == false) goto L9;
        return true;
    L14:
        if (isSubtypeOf$default(INSTANCE, r111, r113, r100, false, 8, null) == false) goto L16;
    L17:
        r101 = true;
        goto L18
    L27:
        return false;
    L5:
        if (r115.isEmpty() == false) goto L7;
        return false;
    }

    private static final Unit isSubtypeOfForSingleClassifierType$lambda$21$lambda$20(Collection r100, final TypeCheckerState r101, final TypeSystemContext r102, final SimpleTypeMarker r103, TypeCheckerState.ForkPointContext r104) {
        Intrinsics.checkNotNullParameter(r100, "$supertypesWithSameConstructor");
        Intrinsics.checkNotNullParameter(r101, "$state");
        Intrinsics.checkNotNullParameter(r102, "$this_with");
        Intrinsics.checkNotNullParameter(r103, "$superType");
        Intrinsics.checkNotNullParameter(r104, "$this$runForkingPoint");
        Iterator r105 = r100.iterator();
    L4:
        if (r105.hasNext() == false) goto L7;
        final SimpleTypeMarker r106 = (SimpleTypeMarker) r105.next();
        r104.fork(new AbstractTypeChecker$$Lambda$1(r101, r102, r106, r103));
        goto L4
    L7:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ boolean isSubtypeOf$default(AbstractTypeChecker r100, TypeCheckerState r101, KotlinTypeMarker r102, KotlinTypeMarker r103, boolean r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L6;
        r104 = false;
    L6:
        return r100.isSubtypeOf(r101, r102, r103, r104);
    }
}
