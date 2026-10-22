package androidx.compose.material3;

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
public final class BottomSheetScaffoldKt$BottomSheetScaffold$1$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
    final /* synthetic */ long $sheetContainerColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $sheetContent;
    final /* synthetic */ long $sheetContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $sheetDragHandle;
    final /* synthetic */ float $sheetMaxWidth;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ float $sheetShadowElevation;
    final /* synthetic */ Shape $sheetShape;
    final /* synthetic */ boolean $sheetSwipeEnabled;
    final /* synthetic */ float $sheetTonalElevation;
    final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX WARN: Multi-variable type inference failed */
    public BottomSheetScaffoldKt$BottomSheetScaffold$1$1(BottomSheetScaffoldState r4, Function2<? super Composer, ? super Integer, Unit> r5, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> r6, float r7, float r8, boolean r9, Shape r10, long r11, long r13, float r15, float r16, Function2<? super Composer, ? super Integer, Unit> r17, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r18, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> r19) {
        this.$scaffoldState = r4;
        this.$topBar = r5;
        this.$content = r6;
        this.$sheetPeekHeight = r7;
        this.$sheetMaxWidth = r8;
        this.$sheetSwipeEnabled = r9;
        this.$sheetShape = r10;
        this.$sheetContainerColor = r11;
        this.$sheetContentColor = r13;
        this.$sheetTonalElevation = r15;
        this.$sheetShadowElevation = r16;
        this.$sheetDragHandle = r17;
        this.$sheetContent = r18;
        this.$snackbarHost = r19;
    }

    public static /* synthetic */ float a(BottomSheetScaffoldState r0) {
        return invoke$lambda$1$lambda$0(r0);
    }

    private static final float invoke$lambda$1$lambda$0(BottomSheetScaffoldState r0) {
        return r0.getBottomSheetState().requireOffset();
    }

    public final void invoke(Composer r26, int r27) {
        if ((r27 & 3) == 2) goto L5;
        boolean r2 = true;
    L7:
        if (r26.shouldExecute(r2, r27 & 1) == true) goto L9;
        r26.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(999829022, r27, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:140)");
    L11:
        SheetState r6 = this.$scaffoldState.getBottomSheetState();
        Function2<Composer, Integer, Unit> r1 = this.$topBar;
        final Function3<PaddingValues, Composer, Integer, Unit> r3 = this.$content;
        final float r5 = this.$sheetPeekHeight;
        ComposableLambda r4 = ComposableLambdaKt.rememberComposableLambda(-519581786, true, new AnonymousClass1(r3, r5), r26, 54);
        final BottomSheetScaffoldState r9 = this.$scaffoldState;
        final float r10 = this.$sheetPeekHeight;
        final float r11 = this.$sheetMaxWidth;
        final boolean r12 = this.$sheetSwipeEnabled;
        final Shape r13 = this.$sheetShape;
        final long r14 = this.$sheetContainerColor;
        final long r7 = this.$sheetContentColor;
        final float r8 = this.$sheetTonalElevation;
        final float r15 = this.$sheetShadowElevation;
        final Function2<Composer, Integer, Unit> r16 = this.$sheetDragHandle;
        final Function3<ColumnScope, Composer, Integer, Unit> r17 = this.$sheetContent;
        ComposableLambda r18 = ComposableLambdaKt.rememberComposableLambda(-815624571, true, new AnonymousClass2(r9, r10, r11, r12, r13, r14, r7, r8, r15, r16, r17), r26, 54);
        final Function3<SnackbarHostState, Composer, Integer, Unit> r19 = this.$snackbarHost;
        final BottomSheetScaffoldState r20 = this.$scaffoldState;
        ComposableLambda r21 = ComposableLambdaKt.rememberComposableLambda(-1111667356, true, new AnonymousClass3(r19, r20), r26, 54);
        boolean r22 = r26.changed(this.$scaffoldState);
        final BottomSheetScaffoldState r23 = this.$scaffoldState;
        Object r24 = r26.rememberedValue();
        if (r22 == false) goto L14;
    L15:
        r24 = new d2(r23);
        r26.updateRememberedValue(r24);
    L16:
        BottomSheetScaffoldKt.access$BottomSheetScaffoldLayout(r1, r4, r18, r21, (Function0) r24, r6, r26, 3504);
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventEnd();
        return;
    L21:
        return;
    L14:
        if (r24 != Composer.Companion.getEmpty()) goto L16;
    L5:
        r2 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
