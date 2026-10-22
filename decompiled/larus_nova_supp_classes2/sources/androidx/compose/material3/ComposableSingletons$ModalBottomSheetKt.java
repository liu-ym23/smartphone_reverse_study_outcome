package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$ModalBottomSheetKt {
    public static final ComposableSingletons$ModalBottomSheetKt INSTANCE = null;

    /* JADX INFO: renamed from: lambda$-655173438, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f34lambda$655173438;
    private static Function2<Composer, Integer, Unit> lambda$1121996006;
    private static Function2<Composer, Integer, Unit> lambda$1716959002;

    public ComposableSingletons$ModalBottomSheetKt() {
    }

    /* JADX INFO: renamed from: getLambda$-655173438$material3, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2533getLambda$655173438$material3() {
        return f34lambda$655173438;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1121996006$material3() {
        return lambda$1121996006;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1716959002$material3() {
        return lambda$1716959002;
    }

    static {
        INSTANCE = new ComposableSingletons$ModalBottomSheetKt();
        lambda$1121996006 = ComposableLambdaKt.composableLambdaInstance(1121996006, false, ComposableSingletons$ModalBottomSheetKt$lambda$1121996006$1.INSTANCE);
        f34lambda$655173438 = ComposableLambdaKt.composableLambdaInstance(-655173438, false, ComposableSingletons$ModalBottomSheetKt$lambda$655173438$1.INSTANCE);
        lambda$1716959002 = ComposableLambdaKt.composableLambdaInstance(1716959002, false, ComposableSingletons$ModalBottomSheetKt$lambda$1716959002$1.INSTANCE);
    }
}
