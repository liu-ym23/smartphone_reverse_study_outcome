package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;

/* JADX INFO: loaded from: classes42.dex */
public final class ExpandedTypeUtilsKt {
    public static final KotlinTypeMarker computeExpandedTypeForInlineClass(TypeSystemCommonBackendContext r100, KotlinTypeMarker r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "inlineClassType");
        return computeExpandedTypeInner(r100, r101, new HashSet());
    }

    private static final KotlinTypeMarker computeExpandedTypeInner(TypeSystemCommonBackendContext r100, KotlinTypeMarker r101, HashSet<TypeConstructorMarker> r102) {
        TypeConstructorMarker r103 = r100.typeConstructor(r101);
        if (r102.add(r103) == true) goto L5;
        return null;
    L5:
        TypeParameterMarker r104 = r100.getTypeParameterClassifier(r103);
        if (r104 == null) goto L35;
        KotlinTypeMarker r105 = r100.getRepresentativeUpperBound(r104);
        KotlinTypeMarker r106 = computeExpandedTypeInner(r100, r105, r102);
        if (r106 == null) goto L56;
        if (r100.isInlineClass(r100.typeConstructor(r105)) == false) goto L12;
    L17:
        boolean r107 = true;
    L19:
        if ((r106 instanceof SimpleTypeMarker) == false) goto L27;
        if (r100.isPrimitiveType((SimpleTypeMarker) r106) == false) goto L27;
        if (r100.isNullableType(r101) == false) goto L27;
        if (r107 == false) goto L27;
        KotlinTypeMarker r108 = r100.makeNullable(r105);
    L55:
        return r108;
    L27:
        if (r100.isNullableType(r106) == true) goto L58;
        if (r100.isMarkedNullable(r101) == false) goto L58;
        r108 = r100.makeNullable(r106);
    L58:
        return r106;
    L12:
        if ((r105 instanceof SimpleTypeMarker) == true) goto L14;
    L16:
        r107 = false;
        goto L19
    L14:
        if (r100.isPrimitiveType((SimpleTypeMarker) r105) == false) goto L16;
    L56:
        return null;
    L35:
        if (r100.isInlineClass(r103) == false) goto L57;
        KotlinTypeMarker r109 = r100.getUnsubstitutedUnderlyingType(r101);
        if (r109 != null) goto L39;
        return null;
    L39:
        r106 = computeExpandedTypeInner(r100, r109, r102);
        if (r106 != null) goto L43;
        return null;
    L43:
        if (r100.isNullableType(r101) == false) goto L58;
        if (r100.isNullableType(r106) == false) goto L49;
        return r101;
    L49:
        if ((r106 instanceof SimpleTypeMarker) == false) goto L54;
        if (r100.isPrimitiveType((SimpleTypeMarker) r106) == false) goto L54;
        return r101;
    L54:
        return r100.makeNullable(r106);
    L57:
        return r101;
    }
}
