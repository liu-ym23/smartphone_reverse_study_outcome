package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes5.dex */
public class TypeProjectionImpl extends TypeProjectionBase {
    private final Variance projection;
    private final KotlinType type;

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        if (r100 == 4) goto L6;
        if (r100 == 5) goto L6;
        String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r100 == 4) goto L11;
        if (r100 == 5) goto L11;
        int r102 = 3;
    L12:
        Object[] r103 = new Object[r102];
        switch(r100) {
            case 1: goto L17;
            case 2: goto L17;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L15;
            default: goto L14;
        };
    L14:
        r103[0] = "projection";
    L19:
        if (r100 == 4) goto L23;
        if (r100 == 5) goto L22;
        r103[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
    L24:
        if (r100 == 3) goto L31;
        if (r100 == 4) goto L32;
        if (r100 == 5) goto L32;
        if (r100 == 6) goto L30;
        r103[2] = "<init>";
        goto L32
    L30:
        r103[2] = "refine";
    L32:
        String r104 = String.format(r101, r103);
        if (r100 == 4) goto L37;
        if (r100 == 5) goto L37;
        throw new IllegalArgumentException(r104);
    L37:
        throw new IllegalStateException(r104);
    L31:
        r103[2] = "replaceType";
        goto L32
    L22:
        r103[1] = "getType";
        goto L24
    L23:
        r103[1] = "getProjectionKind";
        goto L24
    L15:
        r103[0] = "kotlinTypeRefiner";
        goto L19
    L16:
        r103[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        goto L19
    L17:
        r103[0] = "type";
    L11:
        r102 = 2;
    L6:
        r101 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public boolean isStarProjection() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public Variance getProjectionKind() {
        Variance r100 = this.projection;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public KotlinType getType() {
        KotlinType r100 = this.type;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r100;
    }

    public TypeProjectionImpl(KotlinType r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        this(Variance.INVARIANT, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public TypeProjection refine(KotlinTypeRefiner r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return new TypeProjectionImpl(this.projection, r100.refineType(this.type));
    }

    public TypeProjectionImpl(Variance r100, KotlinType r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        this.projection = r100;
        this.type = r101;
    }
}
