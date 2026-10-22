package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes42.dex */
public final class JavaTypeQualifiers {
    public static final Companion Companion = null;
    private static final JavaTypeQualifiers NONE = null;
    private final boolean definitelyNotNull;
    private final boolean isNullabilityQualifierForWarning;
    private final MutabilityQualifier mutability;
    private final NullabilityQualifier nullability;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final JavaTypeQualifiers getNONE() {
            return JavaTypeQualifiers.access$getNONE$cp();
        }
    }

    static {
        Companion = new Companion(null);
        NONE = new JavaTypeQualifiers(null, null, false, false, 8, null);
    }

    public static final /* synthetic */ JavaTypeQualifiers access$getNONE$cp() {
        return NONE;
    }

    public final boolean getDefinitelyNotNull() {
        return this.definitelyNotNull;
    }

    public final MutabilityQualifier getMutability() {
        return this.mutability;
    }

    public final NullabilityQualifier getNullability() {
        return this.nullability;
    }

    public final boolean isNullabilityQualifierForWarning() {
        return this.isNullabilityQualifierForWarning;
    }

    public JavaTypeQualifiers(NullabilityQualifier r100, MutabilityQualifier r101, boolean r102, boolean r103) {
        this.nullability = r100;
        this.mutability = r101;
        this.definitelyNotNull = r102;
        this.isNullabilityQualifierForWarning = r103;
    }

    public /* synthetic */ JavaTypeQualifiers(NullabilityQualifier r100, MutabilityQualifier r101, boolean r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = false;
    L5:
        this(r100, r101, r102, r103);
    }
}
