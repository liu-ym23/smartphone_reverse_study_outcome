package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class SnackbarKt$Snackbar$dismissActionComposable$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ SnackbarData $snackbarData;

    public SnackbarKt$Snackbar$dismissActionComposable$1(SnackbarData r1) {
        this.$snackbarData = r1;
    }

    public static /* synthetic */ Unit a(SnackbarData r0) {
        return invoke$lambda$1$lambda$0(r0);
    }

    private static final Unit invoke$lambda$1$lambda$0(SnackbarData r0) {
        r0.dismiss();
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r13, int r14) {
        if ((r14 & 3) == 2) goto L5;
        boolean r0 = true;
    L7:
        if (r13.shouldExecute(r0, r14 & 1) == true) goto L9;
        r13.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-1812633777, r14, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:223)");
    L11:
        boolean r15 = r13.changed(this.$snackbarData);
        final SnackbarData r1 = this.$snackbarData;
        Object r2 = r13.rememberedValue();
        if (r15 == false) goto L14;
    L15:
        r2 = new dr(r1);
        r13.updateRememberedValue(r2);
    L16:
        IconButtonKt.IconButton((Function0) r2, null, false, null, null, null, ComposableSingletons$SnackbarKt.INSTANCE.getLambda$984817901$material3(), r13, 1572864, 62);
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventEnd();
        return;
    L21:
        return;
    L14:
        if (r2 != Composer.Companion.getEmpty()) goto L16;
    L5:
        r0 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
