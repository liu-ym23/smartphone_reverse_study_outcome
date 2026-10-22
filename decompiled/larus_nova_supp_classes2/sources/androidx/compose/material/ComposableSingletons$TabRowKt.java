package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$TabRowKt {
    public static final ComposableSingletons$TabRowKt INSTANCE = null;

    /* JADX INFO: renamed from: lambda$-1216856915, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f8lambda$1216856915;

    /* JADX INFO: renamed from: lambda$-222041980, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f9lambda$222041980;

    public ComposableSingletons$TabRowKt() {
    }

    /* JADX INFO: renamed from: getLambda$-1216856915$material, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2027getLambda$1216856915$material() {
        return f8lambda$1216856915;
    }

    /* JADX INFO: renamed from: getLambda$-222041980$material, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2028getLambda$222041980$material() {
        return f9lambda$222041980;
    }

    static {
        INSTANCE = new ComposableSingletons$TabRowKt();
        f8lambda$1216856915 = ComposableLambdaKt.composableLambdaInstance(-1216856915, false, ComposableSingletons$TabRowKt$lambda$1216856915$1.INSTANCE);
        f9lambda$222041980 = ComposableLambdaKt.composableLambdaInstance(-222041980, false, ComposableSingletons$TabRowKt$lambda$222041980$1.INSTANCE);
    }
}
