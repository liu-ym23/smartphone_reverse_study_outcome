package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$BottomSheetScaffoldKt {
    public static final ComposableSingletons$BottomSheetScaffoldKt INSTANCE = null;

    /* JADX INFO: renamed from: lambda$-788244078, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f31lambda$788244078;
    private static Function2<Composer, Integer, Unit> lambda$1392012807;
    private static Function3<SnackbarHostState, Composer, Integer, Unit> lambda$1768941633;

    public ComposableSingletons$BottomSheetScaffoldKt() {
    }

    /* JADX INFO: renamed from: getLambda$-788244078$material3, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2530getLambda$788244078$material3() {
        return f31lambda$788244078;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1392012807$material3() {
        return lambda$1392012807;
    }

    public final Function3<SnackbarHostState, Composer, Integer, Unit> getLambda$1768941633$material3() {
        return lambda$1768941633;
    }

    static {
        INSTANCE = new ComposableSingletons$BottomSheetScaffoldKt();
        lambda$1392012807 = ComposableLambdaKt.composableLambdaInstance(1392012807, false, ComposableSingletons$BottomSheetScaffoldKt$lambda$1392012807$1.INSTANCE);
        lambda$1768941633 = ComposableLambdaKt.composableLambdaInstance(1768941633, false, ComposableSingletons$BottomSheetScaffoldKt$lambda$1768941633$1.INSTANCE);
        f31lambda$788244078 = ComposableLambdaKt.composableLambdaInstance(-788244078, false, ComposableSingletons$BottomSheetScaffoldKt$lambda$788244078$1.INSTANCE);
    }
}
