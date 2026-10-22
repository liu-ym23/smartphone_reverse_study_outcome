package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class SnackbarKt$Snackbar$actionComposable$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ long $actionColor;
    final /* synthetic */ String $actionLabel;
    final /* synthetic */ SnackbarData $snackbarData;

    public SnackbarKt$Snackbar$actionComposable$1(long r1, SnackbarData r3, String r4) {
        this.$actionColor = r1;
        this.$snackbarData = r3;
        this.$actionLabel = r4;
    }

    public static /* synthetic */ Unit a(SnackbarData r0) {
        return invoke$lambda$1$lambda$0(r0);
    }

    private static final Unit invoke$lambda$1$lambda$0(SnackbarData r0) {
        r0.performAction();
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r16, int r17) {
        if ((r17 & 3) == 2) goto L5;
        boolean r2 = true;
    L7:
        if (r16.shouldExecute(r2, r17 & 1) == true) goto L9;
        r16.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(1843479216, r17, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:170)");
    L11:
        ButtonColors r8 = ButtonDefaults.INSTANCE.m1976textButtonColorsRGew2ao(0, this.$actionColor, 0, r16, 3072, 5);
        boolean r1 = r16.changedInstance(this.$snackbarData);
        final SnackbarData r3 = this.$snackbarData;
        Object r4 = r16.rememberedValue();
        if (r1 == false) goto L14;
    L15:
        r4 = new sa(r3);
        r16.updateRememberedValue(r4);
    L16:
        final String r13 = this.$actionLabel;
        ButtonKt.TextButton((Function0) r4, null, false, null, null, null, null, r8, null, ComposableLambdaKt.rememberComposableLambda(-929149933, true, new AnonymousClass2(r13), r16, 54), r16, 805306368, 382);
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventEnd();
        return;
    L21:
        return;
    L14:
        if (r4 != Composer.Companion.getEmpty()) goto L16;
    L5:
        r2 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
