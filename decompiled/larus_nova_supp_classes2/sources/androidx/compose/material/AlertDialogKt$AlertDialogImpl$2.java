package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
public final class AlertDialogKt$AlertDialogImpl$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $buttons;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;

    public AlertDialogKt$AlertDialogImpl$2(Function2<? super Composer, ? super Integer, Unit> r1, Modifier r2, Function2<? super Composer, ? super Integer, Unit> r3, Function2<? super Composer, ? super Integer, Unit> r4, Shape r5, long r6, long r8) {
        this.$buttons = r1;
        this.$modifier = r2;
        this.$title = r3;
        this.$text = r4;
        this.$shape = r5;
        this.$backgroundColor = r6;
        this.$contentColor = r8;
    }

    public final void invoke(Composer r17, int r18) {
        if ((r18 & 3) == 2) goto L5;
        boolean r2 = true;
    L7:
        if (r17.shouldExecute(r2, r18 & 1) == true) goto L9;
        r17.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-488319269, r18, -1, "androidx.compose.material.AlertDialogImpl.<anonymous> (AlertDialog.kt:181)");
    L11:
        AlertDialogKt.m1912AlertDialogContentWMdw5o4(this.$buttons, this.$modifier, this.$title, this.$text, this.$shape, this.$backgroundColor, this.$contentColor, r17, 0, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L16;
        ComposerKt.traceEventEnd();
        return;
    L16:
        return;
    L5:
        r2 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
