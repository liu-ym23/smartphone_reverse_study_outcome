package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$ScaffoldKt {
    public static final ComposableSingletons$ScaffoldKt INSTANCE = null;

    /* JADX INFO: renamed from: lambda$-1514016380, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f37lambda$1514016380;

    /* JADX INFO: renamed from: lambda$-39202156, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f38lambda$39202156;
    private static Function2<Composer, Integer, Unit> lambda$1582488484;
    private static Function2<Composer, Integer, Unit> lambda$414328099;

    public ComposableSingletons$ScaffoldKt() {
    }

    /* JADX INFO: renamed from: getLambda$-1514016380$material3, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2536getLambda$1514016380$material3() {
        return f37lambda$1514016380;
    }

    /* JADX INFO: renamed from: getLambda$-39202156$material3, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2537getLambda$39202156$material3() {
        return f38lambda$39202156;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1582488484$material3() {
        return lambda$1582488484;
    }

    public final Function2<Composer, Integer, Unit> getLambda$414328099$material3() {
        return lambda$414328099;
    }

    static {
        INSTANCE = new ComposableSingletons$ScaffoldKt();
        f38lambda$39202156 = ComposableLambdaKt.composableLambdaInstance(-39202156, false, ComposableSingletons$ScaffoldKt$lambda$39202156$1.INSTANCE);
        lambda$1582488484 = ComposableLambdaKt.composableLambdaInstance(1582488484, false, ComposableSingletons$ScaffoldKt$lambda$1582488484$1.INSTANCE);
        lambda$414328099 = ComposableLambdaKt.composableLambdaInstance(414328099, false, ComposableSingletons$ScaffoldKt$lambda$414328099$1.INSTANCE);
        f37lambda$1514016380 = ComposableLambdaKt.composableLambdaInstance(-1514016380, false, ComposableSingletons$ScaffoldKt$lambda$1514016380$1.INSTANCE);
    }
}
