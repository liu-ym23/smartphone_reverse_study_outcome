package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum FunctionClassKind extends Enum<FunctionClassKind> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ FunctionClassKind[] $VALUES = null;
    public static final Companion Companion = null;
    public static final FunctionClassKind Function = null;
    public static final FunctionClassKind KFunction = null;
    public static final FunctionClassKind KSuspendFunction = null;
    public static final FunctionClassKind SuspendFunction = null;
    public static final FunctionClassKind UNKNOWN = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final FunctionClassKind getFunctionClassKind(FunctionTypeKind r100) {
            Intrinsics.checkNotNullParameter(r100, "functionTypeKind");
            if (Intrinsics.areEqual(r100, FunctionTypeKind.Function.INSTANCE) == false) goto L6;
            return FunctionClassKind.Function;
        L6:
            if (Intrinsics.areEqual(r100, FunctionTypeKind.SuspendFunction.INSTANCE) == false) goto L9;
            return FunctionClassKind.SuspendFunction;
        L9:
            if (Intrinsics.areEqual(r100, FunctionTypeKind.KFunction.INSTANCE) == false) goto L12;
            return FunctionClassKind.KFunction;
        L12:
            if (Intrinsics.areEqual(r100, FunctionTypeKind.KSuspendFunction.INSTANCE) == false) goto L15;
            return FunctionClassKind.KSuspendFunction;
        L15:
            return FunctionClassKind.UNKNOWN;
        }
    }

    private static final /* synthetic */ FunctionClassKind[] $values() {
        return new FunctionClassKind[]{Function, SuspendFunction, KFunction, KSuspendFunction, UNKNOWN};
    }

    static {
        Function = new FunctionClassKind("Function", 0);
        SuspendFunction = new FunctionClassKind("SuspendFunction", 1);
        KFunction = new FunctionClassKind("KFunction", 2);
        KSuspendFunction = new FunctionClassKind("KSuspendFunction", 3);
        UNKNOWN = new FunctionClassKind("UNKNOWN", 4);
        FunctionClassKind[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
    }

    public static FunctionClassKind[] values() {
        return (FunctionClassKind[]) $VALUES.clone();
    }

    public static FunctionClassKind valueOf(String r100) {
        return (FunctionClassKind) a.a(FunctionClassKind.class, r100);
    }

    private FunctionClassKind(String r100, int r101) {
        super(r100, r101);
    }
}
