package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$SnackbarKt {
    public static final ComposableSingletons$SnackbarKt INSTANCE = null;
    private static Function2<Composer, Integer, Unit> lambda$984817901;

    public ComposableSingletons$SnackbarKt() {
    }

    public final Function2<Composer, Integer, Unit> getLambda$984817901$material3() {
        return lambda$984817901;
    }

    static {
        INSTANCE = new ComposableSingletons$SnackbarKt();
        lambda$984817901 = ComposableLambdaKt.composableLambdaInstance(984817901, false, ComposableSingletons$SnackbarKt$lambda$984817901$1.INSTANCE);
    }
}
