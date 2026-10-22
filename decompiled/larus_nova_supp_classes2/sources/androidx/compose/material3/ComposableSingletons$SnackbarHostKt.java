package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$SnackbarHostKt {
    public static final ComposableSingletons$SnackbarHostKt INSTANCE = null;

    /* JADX INFO: renamed from: lambda$-1548712596, reason: not valid java name */
    private static Function3<SnackbarData, Composer, Integer, Unit> f40lambda$1548712596;

    public ComposableSingletons$SnackbarHostKt() {
    }

    /* JADX INFO: renamed from: getLambda$-1548712596$material3, reason: not valid java name */
    public final Function3<SnackbarData, Composer, Integer, Unit> m2539getLambda$1548712596$material3() {
        return f40lambda$1548712596;
    }

    static {
        INSTANCE = new ComposableSingletons$SnackbarHostKt();
        f40lambda$1548712596 = ComposableLambdaKt.composableLambdaInstance(-1548712596, false, ComposableSingletons$SnackbarHostKt$lambda$1548712596$1.INSTANCE);
    }
}
