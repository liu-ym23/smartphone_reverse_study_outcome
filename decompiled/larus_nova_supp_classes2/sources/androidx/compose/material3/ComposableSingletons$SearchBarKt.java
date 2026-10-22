package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$SearchBarKt {
    public static final ComposableSingletons$SearchBarKt INSTANCE = null;

    /* JADX INFO: renamed from: lambda$-1146652811, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f39lambda$1146652811;
    private static Function2<Composer, Integer, Unit> lambda$1165377840;

    public ComposableSingletons$SearchBarKt() {
    }

    /* JADX INFO: renamed from: getLambda$-1146652811$material3, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2538getLambda$1146652811$material3() {
        return f39lambda$1146652811;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1165377840$material3() {
        return lambda$1165377840;
    }

    static {
        INSTANCE = new ComposableSingletons$SearchBarKt();
        lambda$1165377840 = ComposableLambdaKt.composableLambdaInstance(1165377840, false, ComposableSingletons$SearchBarKt$lambda$1165377840$1.INSTANCE);
        f39lambda$1146652811 = ComposableLambdaKt.composableLambdaInstance(-1146652811, false, ComposableSingletons$SearchBarKt$lambda$1146652811$1.INSTANCE);
    }
}
