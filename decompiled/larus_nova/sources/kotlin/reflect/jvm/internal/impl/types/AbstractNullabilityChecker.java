package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* JADX INFO: loaded from: classes42.dex */
public final class AbstractNullabilityChecker {
    public static final AbstractNullabilityChecker INSTANCE = null;

    static {
        INSTANCE = new AbstractNullabilityChecker();
    }

    private AbstractNullabilityChecker() {
    }

    private final boolean isApplicableAsEndNode(TypeCheckerState r100, SimpleTypeMarker r101, TypeConstructorMarker r102) {
        TypeSystemContext r103 = r100.getTypeSystemContext();
        if (r103.isNothing(r101) == false) goto L6;
        return true;
    L6:
        if (r103.isMarkedNullable(r101) == false) goto L10;
        return false;
    L10:
        if (r100.isStubTypeEqualsToAnything() == false) goto L15;
        if (r103.isStubType(r101) == false) goto L15;
        return true;
    L15:
        return r103.areEqualTypeConstructors(r103.typeConstructor(r101), r102);
    }

    private final boolean runIsPossibleSubtype(TypeCheckerState r100, SimpleTypeMarker r101, SimpleTypeMarker r102) {
        TypeSystemContext r103 = r100.getTypeSystemContext();
        if (AbstractTypeChecker.RUN_SLOW_ASSERTIONS == false) goto L13;
        if (r103.isSingleClassifierType(r101) == true) goto L10;
        if (r103.isIntersection(r103.typeConstructor(r101)) == true) goto L10;
        r100.isAllowedTypeVariable(r101);
    L10:
        if (r103.isSingleClassifierType(r102) == true) goto L13;
        r100.isAllowedTypeVariable(r102);
    L13:
        if (r103.isMarkedNullable(r102) == false) goto L16;
        return true;
    L16:
        if (r103.isDefinitelyNotNullType(r101) == false) goto L18;
    L39:
        return true;
    L18:
        if (r103.isNotNullTypeParameter(r101) == true) goto L39;
        if ((r101 instanceof CapturedTypeMarker) == true) goto L23;
    L25:
        AbstractNullabilityChecker r104 = INSTANCE;
        if (r104.hasNotNullSupertype(r100, r101, TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE) == false) goto L29;
        return true;
    L29:
        if (r103.isDefinitelyNotNullType(r102) == false) goto L32;
        return false;
    L32:
        if (r104.hasNotNullSupertype(r100, r102, TypeCheckerState.SupertypesPolicy.UpperIfFlexible.INSTANCE) == false) goto L35;
        return false;
    L35:
        if (r103.isClassType(r101) == false) goto L38;
        return false;
    L38:
        return r104.hasPathByNotMarkedNullableNodes(r100, r101, r103.typeConstructor(r102));
    L23:
        if (r103.isProjectionNotNull((CapturedTypeMarker) r101) == false) goto L25;
        return true;
    }

    public final boolean hasNotNullSupertype(TypeCheckerState r110, SimpleTypeMarker r111, TypeCheckerState.SupertypesPolicy r210) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r210, "supertypesPolicy");
        TypeSystemContext r100 = r110.getTypeSystemContext();
        if (r100.isClassType(r111) == false) goto L7;
        if (r100.isMarkedNullable(r111) == true) goto L7;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
    L11:
        return true;
    L12:
        r110.initialize();
        ArrayDeque<SimpleTypeMarker> r102 = r110.getSupertypesDeque();
        Intrinsics.checkNotNull(r102);
        Set<SimpleTypeMarker> r103 = r110.getSupertypesSet();
        Intrinsics.checkNotNull(r103);
        r102.push(r111);
    L14:
        if ((!r102.isEmpty()) == false) goto L45;
        if (r103.size() > 1000) goto L44;
        SimpleTypeMarker r104 = r102.pop();
        Intrinsics.checkNotNull(r104);
        if (r103.add(r104) == false) goto L14;
        if (r100.isMarkedNullable(r104) == false) goto L22;
        TypeCheckerState.SupertypesPolicy r105 = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
    L24:
        if ((!Intrinsics.areEqual(r105, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) == true) goto L27;
        r105 = null;
    L27:
        if (r105 == null) goto L14;
        TypeSystemContext r112 = r110.getTypeSystemContext();
        Iterator<KotlinTypeMarker> r106 = r112.supertypes(r112.typeConstructor(r104)).iterator();
    L31:
        if (r106.hasNext() == false) goto L14;
        SimpleTypeMarker r113 = r105.mo10736transformType(r110, r106.next());
        if (r100.isClassType(r113) == false) goto L37;
        if (r100.isMarkedNullable(r113) == true) goto L37;
    L38:
        boolean r114 = true;
    L40:
        if (r114 == true) goto L41;
        r102.add(r113);
        goto L31
    L41:
        r110.clear();
    L37:
        if (r100.isDefinitelyNotNullType(r113) == true) goto L38;
        r114 = false;
        goto L40
    L22:
        r105 = r210;
        goto L24
    L44:
        throw new IllegalStateException(("Too many supertypes for type: " + r111 + ". Supertypes = " + CollectionsKt.joinToString$default(r103, null, null, null, 0, null, null, 63, null)).toString());
    L45:
        r110.clear();
        return false;
    L7:
        if (r100.isDefinitelyNotNullType(r111) == true) goto L8;
        r101 = false;
        goto L10
    }

    public final boolean hasPathByNotMarkedNullableNodes(TypeCheckerState r110, SimpleTypeMarker r111, TypeConstructorMarker r112) {
        Intrinsics.checkNotNullParameter(r110, "state");
        Intrinsics.checkNotNullParameter(r111, "start");
        Intrinsics.checkNotNullParameter(r112, "end");
        TypeSystemContext r100 = r110.getTypeSystemContext();
        if (INSTANCE.isApplicableAsEndNode(r110, r111, r112) == true) goto L43;
        r110.initialize();
        ArrayDeque<SimpleTypeMarker> r101 = r110.getSupertypesDeque();
        Intrinsics.checkNotNull(r101);
        Set<SimpleTypeMarker> r102 = r110.getSupertypesSet();
        Intrinsics.checkNotNull(r102);
        r101.push(r111);
    L7:
        if ((!r101.isEmpty()) == false) goto L31;
        if (r102.size() > 1000) goto L30;
        SimpleTypeMarker r103 = r101.pop();
        Intrinsics.checkNotNull(r103);
        if (r102.add(r103) == false) goto L7;
        if (r100.isMarkedNullable(r103) == false) goto L15;
        TypeCheckerState.SupertypesPolicy r104 = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
    L17:
        if ((!Intrinsics.areEqual(r104, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) == true) goto L20;
        r104 = null;
    L20:
        if (r104 == null) goto L7;
        TypeSystemContext r105 = r110.getTypeSystemContext();
        Iterator<KotlinTypeMarker> r106 = r105.supertypes(r105.typeConstructor(r103)).iterator();
    L24:
        if (r106.hasNext() == false) goto L7;
        SimpleTypeMarker r107 = r104.mo10736transformType(r110, r106.next());
        if (INSTANCE.isApplicableAsEndNode(r110, r107, r112) == true) goto L27;
        r101.add(r107);
        goto L24
    L27:
        r110.clear();
        return true;
    L15:
        r104 = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
        goto L17
    L30:
        throw new IllegalStateException(("Too many supertypes for type: " + r111 + ". Supertypes = " + CollectionsKt.joinToString$default(r102, null, null, null, 0, null, null, 63, null)).toString());
    L31:
        r110.clear();
        return false;
    L43:
        return true;
    }

    public final boolean isPossibleSubtype(TypeCheckerState r100, SimpleTypeMarker r101, SimpleTypeMarker r102) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "subType");
        Intrinsics.checkNotNullParameter(r102, "superType");
        return runIsPossibleSubtype(r100, r101, r102);
    }
}
