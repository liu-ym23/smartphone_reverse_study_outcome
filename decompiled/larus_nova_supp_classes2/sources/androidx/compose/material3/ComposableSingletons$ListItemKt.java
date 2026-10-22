package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$ListItemKt {
    public static final ComposableSingletons$ListItemKt INSTANCE = null;

    /* JADX INFO: renamed from: lambda$-489887388, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f32lambda$489887388;

    /* JADX INFO: renamed from: lambda$-546752734, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f33lambda$546752734;
    private static Function2<Composer, Integer, Unit> lambda$1572298241;
    private static Function2<Composer, Integer, Unit> lambda$1629163587;

    public ComposableSingletons$ListItemKt() {
    }

    /* JADX INFO: renamed from: getLambda$-489887388$material3, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2531getLambda$489887388$material3() {
        return f32lambda$489887388;
    }

    /* JADX INFO: renamed from: getLambda$-546752734$material3, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2532getLambda$546752734$material3() {
        return f33lambda$546752734;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1572298241$material3() {
        return lambda$1572298241;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1629163587$material3() {
        return lambda$1629163587;
    }

    static {
        INSTANCE = new ComposableSingletons$ListItemKt();
        f32lambda$489887388 = ComposableLambdaKt.composableLambdaInstance(-489887388, false, ComposableSingletons$ListItemKt$lambda$489887388$1.INSTANCE);
        lambda$1629163587 = ComposableLambdaKt.composableLambdaInstance(1629163587, false, ComposableSingletons$ListItemKt$lambda$1629163587$1.INSTANCE);
        f33lambda$546752734 = ComposableLambdaKt.composableLambdaInstance(-546752734, false, ComposableSingletons$ListItemKt$lambda$546752734$1.INSTANCE);
        lambda$1572298241 = ComposableLambdaKt.composableLambdaInstance(1572298241, false, ComposableSingletons$ListItemKt$lambda$1572298241$1.INSTANCE);
    }
}
