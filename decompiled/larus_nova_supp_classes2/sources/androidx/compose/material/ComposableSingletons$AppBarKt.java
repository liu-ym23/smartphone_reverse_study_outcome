package androidx.compose.material;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$AppBarKt {
    public static final ComposableSingletons$AppBarKt INSTANCE = null;
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1260131259;
    private static Function3<RowScope, Composer, Integer, Unit> lambda$269254275;

    public ComposableSingletons$AppBarKt() {
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1260131259$material() {
        return lambda$1260131259;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$269254275$material() {
        return lambda$269254275;
    }

    static {
        INSTANCE = new ComposableSingletons$AppBarKt();
        lambda$269254275 = ComposableLambdaKt.composableLambdaInstance(269254275, false, ComposableSingletons$AppBarKt$lambda$269254275$1.INSTANCE);
        lambda$1260131259 = ComposableLambdaKt.composableLambdaInstance(1260131259, false, ComposableSingletons$AppBarKt$lambda$1260131259$1.INSTANCE);
    }
}
