package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$SnackbarHostKt {
    public static final ComposableSingletons$SnackbarHostKt INSTANCE = null;
    private static Function3<SnackbarData, Composer, Integer, Unit> lambda$1890101041;

    public ComposableSingletons$SnackbarHostKt() {
    }

    public final Function3<SnackbarData, Composer, Integer, Unit> getLambda$1890101041$material() {
        return lambda$1890101041;
    }

    static {
        INSTANCE = new ComposableSingletons$SnackbarHostKt();
        lambda$1890101041 = ComposableLambdaKt.composableLambdaInstance(1890101041, false, ComposableSingletons$SnackbarHostKt$lambda$1890101041$1.INSTANCE);
    }
}
