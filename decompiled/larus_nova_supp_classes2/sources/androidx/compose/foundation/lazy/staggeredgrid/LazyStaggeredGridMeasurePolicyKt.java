package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ae\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a!\u0010\u0018\u001a\u00020\u000e*\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010\u001b\u001a)\u0010\u001c\u001a\u00020\u000e*\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010\u001d\u001a)\u0010\u001e\u001a\u00020\u000e*\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010\u001d¨\u0006\u001f"}, d2 = {"rememberStaggeredGridMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "rememberStaggeredGridMeasurePolicy-qKj4JfE", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;FFLkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "startPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/unit/LayoutDirection;)F", "beforePadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/unit/LayoutDirection;)F", "afterPadding", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridMeasurePolicyKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Orientation.values().length];
            r0[Orientation.Vertical.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Orientation.Horizontal.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final /* synthetic */ float access$startPadding(PaddingValues r0, Orientation r1, LayoutDirection r2) {
        return startPadding(r0, r1, r2);
    }

    private static final float startPadding(PaddingValues r1, Orientation r2, LayoutDirection r3) {
        int r4 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r4 == 1) goto L10;
        if (r4 != 2) goto L8;
        return r1.mo901calculateTopPaddingD9Ej5fM();
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return PaddingKt.calculateStartPadding(r1, r3);
    }

    public static final /* synthetic */ float access$afterPadding(PaddingValues r0, Orientation r1, boolean r2, LayoutDirection r3) {
        return afterPadding(r0, r1, r2, r3);
    }

    public static final /* synthetic */ float access$beforePadding(PaddingValues r0, Orientation r1, boolean r2, LayoutDirection r3) {
        return beforePadding(r0, r1, r2, r3);
    }

    private static final float afterPadding(PaddingValues r1, Orientation r2, boolean r3, LayoutDirection r4) {
        int r5 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r5 != 1) goto L5;
        if (r3 == false) goto L14;
        return r1.mo901calculateTopPaddingD9Ej5fM();
    L14:
        return r1.mo898calculateBottomPaddingD9Ej5fM();
    L5:
        if (r5 != 2) goto L10;
        if (r3 == false) goto L16;
        return PaddingKt.calculateStartPadding(r1, r4);
    L16:
        return PaddingKt.calculateEndPadding(r1, r4);
    L10:
        throw new NoWhenBranchMatchedException();
    }

    private static final float beforePadding(PaddingValues r1, Orientation r2, boolean r3, LayoutDirection r4) {
        int r5 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r5 != 1) goto L5;
        if (r3 == false) goto L14;
        return r1.mo898calculateBottomPaddingD9Ej5fM();
    L14:
        return r1.mo901calculateTopPaddingD9Ej5fM();
    L5:
        if (r5 != 2) goto L10;
        if (r3 == false) goto L16;
        return PaddingKt.calculateEndPadding(r1, r4);
    L16:
        return PaddingKt.calculateStartPadding(r1, r4);
    L10:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: rememberStaggeredGridMeasurePolicy-qKj4JfE, reason: not valid java name */
    public static final LazyLayoutMeasurePolicy m1228rememberStaggeredGridMeasurePolicyqKj4JfE(final LazyStaggeredGridState r16, final Function0<? extends LazyStaggeredGridItemProvider> r17, final PaddingValues r18, final boolean r19, final Orientation r20, final float r21, float r22, final CoroutineScope r23, final LazyGridStaggeredGridSlotsProvider r24, final GraphicsContext r25, Composer r26, int r27) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(234882793, r27, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridMeasurePolicy (LazyStaggeredGridMeasurePolicy.kt:50)");
    L5:
        boolean r4 = false;
        if (((r27 & 14) ^ 6) <= 4) goto L12;
        if (r26.changed(r16) == false) goto L12;
    L13:
        boolean r3 = true;
    L16:
        if (((r27 & 112) ^ 48) <= 32) goto L20;
        if (r26.changed(r17) == false) goto L20;
    L21:
        boolean r6 = true;
    L23:
        boolean r5 = r3 | r6;
        if (((r27 & 896) ^ 384) <= 256) goto L28;
        if (r26.changed(r18) == false) goto L28;
    L29:
        boolean r7 = true;
    L31:
        boolean r8 = r5 | r7;
        if (((r27 & 7168) ^ 3072) <= 2048) goto L36;
        if (r26.changed(r19) == false) goto L36;
    L37:
        boolean r9 = true;
    L39:
        boolean r10 = r8 | r9;
        if (((57344 & r27) ^ 24576) <= 16384) goto L44;
        if (r26.changed(r20.ordinal()) == false) goto L44;
    L45:
        boolean r11 = true;
    L47:
        boolean r12 = r10 | r11;
        if (((458752 & r27) ^ 196608) <= 131072) goto L52;
        if (r26.changed(r21) == false) goto L52;
    L53:
        boolean r13 = true;
    L55:
        boolean r14 = r12 | r13;
        if (((3670016 & r27) ^ 1572864) <= 1048576) goto L60;
        if (r26.changed(r22) == false) goto L60;
    L61:
        boolean r15 = true;
    L63:
        boolean r28 = r14 | r15;
        if (((234881024 & r27) ^ 100663296) <= 67108864) goto L68;
        if (r26.changed(r24) == false) goto L68;
    L69:
        r4 = true;
    L70:
        boolean r1 = (r28 | r4) | r26.changed(r25);
        Object r29 = r26.rememberedValue();
        if (r1 == false) goto L73;
    L74:
        r29 = new LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1(r16, r20, r24, r17, r18, r19, r21, r23, r25);
        r26.updateRememberedValue(r29);
    L75:
        LazyLayoutMeasurePolicy r30 = (LazyLayoutMeasurePolicy) r29;
        if (ComposerKt.isTraceInProgress() == false) goto L78;
        ComposerKt.traceEventEnd();
    L78:
        return r30;
    L73:
        if (r29 != Composer.Companion.getEmpty()) goto L75;
    L68:
        if ((r27 & 100663296) != 67108864) goto L70;
    L60:
        if ((r27 & 1572864) == 1048576) goto L61;
        r15 = false;
    L52:
        if ((r27 & 196608) == 131072) goto L53;
        r13 = false;
    L44:
        if ((r27 & 24576) == 16384) goto L45;
        r11 = false;
    L36:
        if ((r27 & 3072) == 2048) goto L37;
        r9 = false;
    L28:
        if ((r27 & 384) == 256) goto L29;
        r7 = false;
    L20:
        if ((r27 & 48) == 32) goto L21;
        r6 = false;
    L12:
        if ((r27 & 6) == 4) goto L13;
        r3 = false;
        goto L16
    }
}
