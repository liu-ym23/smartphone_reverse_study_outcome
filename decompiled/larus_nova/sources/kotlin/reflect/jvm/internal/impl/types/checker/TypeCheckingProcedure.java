package kotlin.reflect.jvm.internal.impl.types.checker;

import com.bytedance.ee.space.sync.PushAction$ESubType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes42.dex */
public class TypeCheckingProcedure {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        if (r100 == 7) goto L6;
        if (r100 == 10) goto L6;
        String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r100 == 7) goto L11;
        if (r100 == 10) goto L11;
        int r102 = 3;
    L12:
        Object[] r103 = new Object[r102];
        switch(r100) {
            case 1: goto L27;
            case 2: goto L14;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L25;
            case 9: goto L24;
            case 10: goto L23;
            case 11: goto L22;
            case 12: goto L21;
            case 13: goto L20;
            case 14: goto L19;
            case 15: goto L18;
            case 16: goto L17;
            case 17: goto L14;
            case 18: goto L27;
            case 19: goto L14;
            case 20: goto L27;
            case 21: goto L16;
            case 22: goto L15;
            case 23: goto L25;
            default: goto L14;
        };
    L14:
        r103[0] = PushAction$ESubType.KEY_NAME;
    L29:
        if (r100 == 7) goto L33;
        if (r100 == 10) goto L32;
        r103[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure";
    L34:
        switch(r100) {
            case 5: goto L42;
            case 6: goto L42;
            case 7: goto L43;
            case 8: goto L41;
            case 9: goto L41;
            case 10: goto L43;
            case 11: goto L40;
            case 12: goto L40;
            case 13: goto L39;
            case 14: goto L39;
            case 15: goto L39;
            case 16: goto L39;
            case 17: goto L38;
            case 18: goto L38;
            case 19: goto L37;
            case 20: goto L37;
            case 21: goto L36;
            case 22: goto L36;
            case 23: goto L36;
            default: goto L35;
        };
    L35:
        r103[2] = "findCorrespondingSupertype";
        goto L43
    L36:
        r103[2] = "capture";
        goto L43
    L37:
        r103[2] = "checkSubtypeForTheSameConstructor";
        goto L43
    L38:
        r103[2] = "isSubtypeOf";
        goto L43
    L39:
        r103[2] = "getEffectiveProjectionKind";
        goto L43
    L40:
        r103[2] = "equalTypes";
        goto L43
    L41:
        r103[2] = "getInType";
        goto L43
    L42:
        r103[2] = "getOutType";
    L43:
        String r104 = String.format(r101, r103);
        if (r100 == 7) goto L48;
        if (r100 == 10) goto L48;
        throw new IllegalArgumentException(r104);
    L48:
        throw new IllegalStateException(r104);
    L32:
        r103[1] = "getInType";
        goto L34
    L33:
        r103[1] = "getOutType";
        goto L34
    L15:
        r103[0] = "supertypeArgumentProjection";
        goto L29
    L16:
        r103[0] = "subtypeArgumentProjection";
        goto L29
    L17:
        r103[0] = "typeArgumentVariance";
        goto L29
    L18:
        r103[0] = "typeParameterVariance";
        goto L29
    L19:
        r103[0] = "typeArgument";
        goto L29
    L20:
        r103[0] = "typeParameter";
        goto L29
    L21:
        r103[0] = "type2";
        goto L29
    L22:
        r103[0] = "type1";
        goto L29
    L23:
        r103[0] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure";
        goto L29
    L24:
        r103[0] = "argument";
        goto L29
    L25:
        r103[0] = "parameter";
        goto L29
    L26:
        r103[0] = "typeCheckingProcedureCallbacks";
        goto L29
    L27:
        r103[0] = "supertype";
    L11:
        r102 = 2;
    L6:
        r101 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    static {
    }

    public static KotlinType findCorrespondingSupertype(KotlinType r100, KotlinType r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r101 != null) goto L7;
        $$$reportNull$$$0(1);
    L7:
        return findCorrespondingSupertype(r100, r101, new TypeCheckerProcedureCallbacksImpl());
    }

    public static KotlinType findCorrespondingSupertype(KotlinType r100, KotlinType r101, TypeCheckingProcedureCallbacks r102) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(3);
    L6:
        if (r102 != null) goto L9;
        $$$reportNull$$$0(4);
    L9:
        return UtilsKt.findCorrespondingSupertype(r100, r101, r102);
    }
}
