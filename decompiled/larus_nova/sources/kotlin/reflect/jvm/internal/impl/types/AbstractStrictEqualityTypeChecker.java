package kotlin.reflect.jvm.internal.impl.types;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* JADX INFO: loaded from: classes42.dex */
public final class AbstractStrictEqualityTypeChecker {
    public static final AbstractStrictEqualityTypeChecker INSTANCE = null;

    static {
        INSTANCE = new AbstractStrictEqualityTypeChecker();
    }

    private AbstractStrictEqualityTypeChecker() {
    }

    private final boolean strictEqualSimpleTypes(TypeSystemContext r100, SimpleTypeMarker r110, SimpleTypeMarker r111) {
        if (r100.argumentsCount(r110) == r100.argumentsCount(r111)) goto L5;
    L36:
        return false;
    L5:
        if (r100.isMarkedNullable(r110) != r100.isMarkedNullable(r111)) goto L36;
        if (r100.asDefinitelyNotNullType(r110) != null) goto L9;
        boolean r101 = true;
    L11:
        if (r100.asDefinitelyNotNullType(r111) != null) goto L13;
        boolean r102 = true;
    L14:
        if (r101 != r102) goto L36;
        if (r100.areEqualTypeConstructors(r100.typeConstructor(r110), r100.typeConstructor(r111)) == false) goto L36;
        if (r100.identicalArguments(r110, r111) == false) goto L21;
        return true;
    L21:
        int r103 = r100.argumentsCount(r110);
        int r104 = 0;
    L22:
        if (r104 >= r103) goto L35;
        TypeArgumentMarker r105 = r100.getArgument(r110, r104);
        TypeArgumentMarker r106 = r100.getArgument(r111, r104);
        if (r100.isStarProjection(r105) != r100.isStarProjection(r106)) goto L25;
        if (r100.isStarProjection(r105) == true) goto L34;
        if (r100.getVariance(r105) != r100.getVariance(r106)) goto L30;
        if (strictEqualTypesInternal(r100, r100.getType(r105), r100.getType(r106)) == true) goto L34;
        return false;
    L30:
        return false;
    L34:
        r104 = r104 + 1;
        goto L22
    L25:
        return false;
    L35:
        return true;
    L13:
        r102 = false;
        goto L14
    L9:
        r101 = false;
        goto L11
    }

    private final boolean strictEqualTypesInternal(TypeSystemContext r100, KotlinTypeMarker r101, KotlinTypeMarker r102) {
        if (r101 != r102) goto L5;
        return true;
    L5:
        SimpleTypeMarker r103 = r100.asSimpleType(r101);
        SimpleTypeMarker r104 = r100.asSimpleType(r102);
        if (r103 == null) goto L10;
        if (r104 == null) goto L10;
        return strictEqualSimpleTypes(r100, r103, r104);
    L10:
        FlexibleTypeMarker r105 = r100.asFlexibleType(r101);
        FlexibleTypeMarker r106 = r100.asFlexibleType(r102);
        if (r105 == null) goto L20;
        if (r106 == null) goto L20;
        if (strictEqualSimpleTypes(r100, r100.lowerBound(r105), r100.lowerBound(r106)) == true) goto L16;
    L18:
        return false;
    L16:
        if (strictEqualSimpleTypes(r100, r100.upperBound(r105), r100.upperBound(r106)) == false) goto L18;
        return true;
    L20:
        return false;
    }

    public final boolean strictEqualTypes(TypeSystemContext r100, KotlinTypeMarker r101, KotlinTypeMarker r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r102, "b");
        return strictEqualTypesInternal(r100, r101, r102);
    }
}
