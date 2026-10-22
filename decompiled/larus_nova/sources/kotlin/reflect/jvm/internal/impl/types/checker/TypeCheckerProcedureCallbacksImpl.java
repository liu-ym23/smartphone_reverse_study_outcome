package kotlin.reflect.jvm.internal.impl.types.checker;

import com.bytedance.ee.space.sync.PushAction$ESubType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: loaded from: classes42.dex */
class TypeCheckerProcedureCallbacksImpl implements TypeCheckingProcedureCallbacks {
    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        Object[] r101 = new Object[3];
        switch(r100) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L4;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L9;
            case 8: goto L6;
            case 9: goto L5;
            case 10: goto L8;
            case 11: goto L7;
            default: goto L4;
        };
    L4:
        r101[0] = BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY;
    L11:
        r101[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl";
        switch(r100) {
            case 3: goto L17;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L14;
            default: goto L13;
        };
    L13:
        r101[2] = "assertEqualTypes";
    L19:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r101));
    L14:
        r101[2] = "noCorrespondingSupertype";
        goto L19
    L15:
        r101[2] = "capture";
        goto L19
    L16:
        r101[2] = "assertSubtype";
        goto L19
    L17:
        r101[2] = "assertEqualTypeConstructors";
        goto L19
    L5:
        r101[0] = "typeProjection";
        goto L11
    L6:
        r101[0] = "type";
        goto L11
    L7:
        r101[0] = "supertype";
        goto L11
    L8:
        r101[0] = PushAction$ESubType.KEY_NAME;
        goto L11
    L9:
        r101[0] = "typeCheckingProcedure";
        goto L11
    L10:
        r101[0] = "b";
        goto L11
    }

    public TypeCheckerProcedureCallbacksImpl() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks
    public boolean assertEqualTypeConstructors(TypeConstructor r100, TypeConstructor r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        if (r101 != null) goto L7;
        $$$reportNull$$$0(4);
    L7:
        return r100.equals(r101);
    }
}
