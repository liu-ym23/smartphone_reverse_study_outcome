package androidx.compose.material3;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class NavigationDrawerKt$DismissibleDrawerSheet$2 implements Function3<DrawerPredictiveBackState, Composer, Integer, Unit> {
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ long $drawerContainerColor;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ float $drawerTonalElevation;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX WARN: Multi-variable type inference failed */
    public NavigationDrawerKt$DismissibleDrawerSheet$2(WindowInsets r1, Modifier r2, Shape r3, long r4, long r6, float r8, DrawerState r9, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r10) {
        this.$windowInsets = r1;
        this.$modifier = r2;
        this.$drawerShape = r3;
        this.$drawerContainerColor = r4;
        this.$drawerContentColor = r6;
        this.$drawerTonalElevation = r8;
        this.$drawerState = r9;
        this.$content = r10;
    }

    public static /* synthetic */ float a(DrawerState r0) {
        return invoke$lambda$1$lambda$0(r0);
    }

    private static final float invoke$lambda$1$lambda$0(DrawerState r0) {
        return r0.getAnchoredDraggableState$material3().getOffset();
    }

    public final void invoke(DrawerPredictiveBackState r17, Composer r18, int r19) {
        if ((r19 & 6) == 0) goto L5;
        int r2 = r19;
    L11:
        if ((r2 & 19) == 18) goto L13;
        boolean r3 = true;
    L15:
        if (r18.shouldExecute(r3, r2 & 1) == true) goto L17;
        r18.skipToGroupEnd();
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(1623455535, r2, -1, "androidx.compose.material3.DismissibleDrawerSheet.<anonymous> (NavigationDrawer.kt:732)");
    L19:
        WindowInsets r4 = this.$windowInsets;
        Modifier r5 = this.$modifier;
        Shape r6 = this.$drawerShape;
        long r7 = this.$drawerContainerColor;
        long r8 = this.$drawerContentColor;
        float r10 = this.$drawerTonalElevation;
        boolean r11 = r18.changed(this.$drawerState);
        final DrawerState r13 = this.$drawerState;
        Object r14 = r18.rememberedValue();
        if (r11 == false) goto L22;
    L23:
        r14 = new gh(r13);
        r18.updateRememberedValue(r14);
    L24:
        NavigationDrawerKt.m2905DrawerSheetcm3T3N0(r17, r4, r5, r6, r7, r8, r10, (FloatProducer) r14, this.$content, r18, r2 & 14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventEnd();
        return;
    L29:
        return;
    L22:
        if (r14 != Composer.Companion.getEmpty()) goto L24;
    L13:
        r3 = false;
        goto L15
    L5:
        if (r18.changed(r17) == false) goto L7;
        int r9 = 4;
    L8:
        r2 = r19 | r9;
        goto L11
    L7:
        r9 = 2;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((DrawerPredictiveBackState) r1, (Composer) r2, ((Number) r3).intValue());
        return Unit.INSTANCE;
    }
}
