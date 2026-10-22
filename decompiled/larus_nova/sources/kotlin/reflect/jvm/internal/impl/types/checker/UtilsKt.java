package kotlin.reflect.jvm.internal.impl.types.checker;

import com.bytedance.ee.space.sync.PushAction$ESubType;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;

/* JADX INFO: loaded from: classes42.dex */
public final class UtilsKt {
    private static final KotlinType approximate(KotlinType r100) {
        return CapturedTypeApproximationKt.approximateCapturedTypes(r100).getUpper();
    }

    private static final String debugInfo(TypeConstructor r100) {
        StringBuilder r101 = new StringBuilder();
        debugInfo$lambda$1$unaryPlus("type: " + r100, r101);
        debugInfo$lambda$1$unaryPlus("hashCode: " + r100.hashCode(), r101);
        debugInfo$lambda$1$unaryPlus("javaClass: " + r100.getClass().getCanonicalName(), r101);
        DeclarationDescriptor r102 = r100.mo10732getDeclarationDescriptor();
    L3:
        if (r102 == null) goto L6;
        debugInfo$lambda$1$unaryPlus("fqName: " + DescriptorRenderer.FQ_NAMES_IN_TYPES.render(r102), r101);
        debugInfo$lambda$1$unaryPlus("javaClass: " + r102.getClass().getCanonicalName(), r101);
        r102 = r102.getContainingDeclaration();
        goto L3
    L6:
        return r101.toString();
    }

    private static final StringBuilder debugInfo$lambda$1$unaryPlus(String r100, StringBuilder r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r101.append(r100);
        r101.append('\n');
        return r101;
    }

    public static final KotlinType findCorrespondingSupertype(KotlinType r100, KotlinType r110, TypeCheckingProcedureCallbacks r111) {
        Intrinsics.checkNotNullParameter(r100, PushAction$ESubType.KEY_NAME);
        Intrinsics.checkNotNullParameter(r110, "supertype");
        Intrinsics.checkNotNullParameter(r111, "typeCheckingProcedureCallbacks");
        ArrayDeque r101 = new ArrayDeque();
        r101.add(new SubtypePathNode(r100, null));
        TypeConstructor r102 = r110.getConstructor();
    L4:
        if (r101.isEmpty() == true) goto L43;
        SubtypePathNode r112 = (SubtypePathNode) r101.poll();
        KotlinType r103 = r112.getType();
        TypeConstructor r104 = r103.getConstructor();
        if (r111.assertEqualTypeConstructors(r104, r102) == true) goto L7;
        Iterator<KotlinType> r105 = r104.mo10733getSupertypes().iterator();
    L41:
        if (r105.hasNext() == false) goto L4;
        KotlinType r106 = r105.next();
        Intrinsics.checkNotNull(r106);
        r101.add(new SubtypePathNode(r106, r112));
        goto L41
    L7:
        boolean r107 = r103.isMarkedNullable();
        SubtypePathNode r113 = r112.getPrevious();
    L8:
        if (r113 == null) goto L33;
        KotlinType r108 = r113.getType();
        List<TypeProjection> r109 = r108.getArguments();
        if ((r109 instanceof Collection) == true) goto L12;
    L14:
        Iterator<T> r114 = r109.iterator();
    L16:
        if (r114.hasNext() == false) goto L13;
        if (((TypeProjection) r114.next()).getProjectionKind() == Variance.INVARIANT) goto L20;
        boolean r115 = true;
    L21:
        if (r115 == false) goto L16;
        boolean r116 = true;
    L23:
        if (r116 == false) goto L25;
        r103 = approximate(CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(TypeConstructorSubstitution.Companion.create(r108), false, 1, null).buildSubstitutor().safeSubstitute(r103, Variance.INVARIANT));
    L26:
        if (r107 == false) goto L28;
    L31:
        r107 = true;
    L32:
        r113 = r113.getPrevious();
        goto L8
    L28:
        if (r108.isMarkedNullable() == true) goto L31;
        r107 = false;
        goto L32
    L25:
        r103 = TypeConstructorSubstitution.Companion.create(r108).buildSubstitutor().safeSubstitute(r103, Variance.INVARIANT);
        Intrinsics.checkNotNull(r103);
        goto L26
    L20:
        r115 = false;
    L13:
        r116 = false;
        goto L23
    L12:
        if (r109.isEmpty() == false) goto L14;
    L33:
        TypeConstructor r117 = r103.getConstructor();
        if (r111.assertEqualTypeConstructors(r117, r102) == false) goto L38;
        return TypeUtils.makeNullableAsSpecified(r103, r107);
    L38:
        throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + debugInfo(r117) + ", \n\nsupertype: " + debugInfo(r102) + " \n" + r111.assertEqualTypeConstructors(r117, r102));
    L43:
        return null;
    }
}
