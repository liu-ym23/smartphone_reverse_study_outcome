package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes42.dex */
public final class TypeSystemContextKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[Variance.values().length];
            r100[Variance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Variance.IN_VARIANCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Variance.OUT_VARIANCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public static final TypeVariance convertVariance(Variance r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L10;
        return TypeVariance.OUT;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return TypeVariance.IN;
    L13:
        return TypeVariance.INV;
    }
}
