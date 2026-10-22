package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$CoreTextFieldKt {
    public static final ComposableSingletons$CoreTextFieldKt INSTANCE = null;
    private static Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> lambda$559628295;

    public ComposableSingletons$CoreTextFieldKt() {
    }

    public final Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> getLambda$559628295$foundation_release() {
        return lambda$559628295;
    }

    static {
        INSTANCE = new ComposableSingletons$CoreTextFieldKt();
        lambda$559628295 = ComposableLambdaKt.composableLambdaInstance(559628295, false, ComposableSingletons$CoreTextFieldKt$lambda$559628295$1.INSTANCE);
    }
}
