package androidx.compose.material.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$ExposedDropdownMenuPopup_androidKt {
    public static final ComposableSingletons$ExposedDropdownMenuPopup_androidKt INSTANCE = null;

    /* JADX INFO: renamed from: lambda$-1578637197, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f10lambda$1578637197;

    public ComposableSingletons$ExposedDropdownMenuPopup_androidKt() {
    }

    /* JADX INFO: renamed from: getLambda$-1578637197$material, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2241getLambda$1578637197$material() {
        return f10lambda$1578637197;
    }

    static {
        INSTANCE = new ComposableSingletons$ExposedDropdownMenuPopup_androidKt();
        f10lambda$1578637197 = ComposableLambdaKt.composableLambdaInstance(-1578637197, false, ComposableSingletons$ExposedDropdownMenuPopup_androidKt$lambda$1578637197$1.INSTANCE);
    }
}
