package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class BottomSheetScaffoldKt$BottomSheetScaffold$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
    final /* synthetic */ long $sheetBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $sheetContent;
    final /* synthetic */ long $sheetContentColor;
    final /* synthetic */ float $sheetElevation;
    final /* synthetic */ boolean $sheetGesturesEnabled;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ Shape $sheetShape;
    final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX WARN: Multi-variable type inference failed */
    public BottomSheetScaffoldKt$BottomSheetScaffold$1(BottomSheetScaffoldState r1, Function2<? super Composer, ? super Integer, Unit> r2, Function2<? super Composer, ? super Integer, Unit> r3, float r4, int r5, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> r6, boolean r7, Shape r8, float r9, long r10, long r12, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r14, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> r15) {
        this.$scaffoldState = r1;
        this.$topBar = r2;
        this.$floatingActionButton = r3;
        this.$sheetPeekHeight = r4;
        this.$floatingActionButtonPosition = r5;
        this.$content = r6;
        this.$sheetGesturesEnabled = r7;
        this.$sheetShape = r8;
        this.$sheetElevation = r9;
        this.$sheetBackgroundColor = r10;
        this.$sheetContentColor = r12;
        this.$sheetContent = r14;
        this.$snackbarHost = r15;
    }

    public static /* synthetic */ float a(BottomSheetScaffoldState r0) {
        return invoke$lambda$1$lambda$0(r0);
    }

    private static final float invoke$lambda$1$lambda$0(BottomSheetScaffoldState r0) {
        return r0.getBottomSheetState().requireOffset();
    }

    public final void invoke(Composer r23, int r24) {
        if ((r24 & 3) == 2) goto L5;
        boolean r2 = true;
    L7:
        if (r23.shouldExecute(r2, r24 & 1) == true) goto L9;
        r23.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-747577963, r24, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:338)");
    L11:
        BottomSheetState r9 = this.$scaffoldState.getBottomSheetState();
        Function2<Composer, Integer, Unit> r1 = this.$topBar;
        final Function3<PaddingValues, Composer, Integer, Unit> r3 = this.$content;
        final float r5 = this.$sheetPeekHeight;
        ComposableLambda r4 = ComposableLambdaKt.rememberComposableLambda(601061661, true, new AnonymousClass1(r3, r5), r23, 54);
        final boolean r12 = this.$sheetGesturesEnabled;
        final BottomSheetScaffoldState r13 = this.$scaffoldState;
        final float r14 = this.$sheetPeekHeight;
        final Shape r15 = this.$sheetShape;
        final float r6 = this.$sheetElevation;
        final long r7 = this.$sheetBackgroundColor;
        final long r8 = this.$sheetContentColor;
        final Function3<ColumnScope, Composer, Integer, Unit> r11 = this.$sheetContent;
        ComposableLambda r10 = ComposableLambdaKt.rememberComposableLambda(1835125948, true, new AnonymousClass2(r12, r13, r14, r15, r6, r7, r8, r11), r23, 54);
        Function2<Composer, Integer, Unit> r16 = this.$floatingActionButton;
        final Function3<SnackbarHostState, Composer, Integer, Unit> r17 = this.$snackbarHost;
        final BottomSheetScaffoldState r18 = this.$scaffoldState;
        ComposableLambda r19 = ComposableLambdaKt.rememberComposableLambda(8287226, true, new AnonymousClass3(r17, r18), r23, 54);
        float r20 = this.$sheetPeekHeight;
        boolean r21 = r23.changed(this.$scaffoldState);
        final BottomSheetScaffoldState r22 = this.$scaffoldState;
        Object r110 = r23.rememberedValue();
        if (r21 == false) goto L14;
    L15:
        r110 = new h2(r22);
        r23.updateRememberedValue(r110);
    L16:
        BottomSheetScaffoldKt.m1961access$BottomSheetScaffoldLayoutHJHHjMs(r1, r4, r10, r16, r19, r20, (Function0) r110, this.$floatingActionButtonPosition, r9, r23, 25008);
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventEnd();
        return;
    L21:
        return;
    L14:
        if (r110 != Composer.Companion.getEmpty()) goto L16;
    L5:
        r2 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
