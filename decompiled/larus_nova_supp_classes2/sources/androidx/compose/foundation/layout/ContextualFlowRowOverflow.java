package androidx.compose.foundation.layout;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Deprecated(message = "ContextualFlowLayouts are no longer maintained")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0089\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00120\b\u0002\u0010\u0007\u001a*\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000f\u0018\u00010\b\u00120\b\u0002\u0010\u0010\u001a*\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000f\u0018\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "Landroidx/compose/foundation/layout/FlowLayoutOverflow;", "type", "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "minLinesToShowCollapse", "", "minCrossAxisSizeToShowCollapse", "seeMoreGetter", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "state", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "collapseGetter", "<init>", "(Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Companion", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextualFlowRowOverflow extends FlowLayoutOverflow {
    public static final int $stable = 0;
    private static final ContextualFlowRowOverflow Clip = null;
    public static final Companion Companion = null;
    private static final ContextualFlowRowOverflow Visible = null;

    @Deprecated(message = "FlowLayout overflow is no longer maintained")
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\f\u001a\u00020\u00052\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013J_\u0010\u0014\u001a\u00020\u00052\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122\u001c\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\b¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/layout/ContextualFlowRowOverflow$Companion;", "", "<init>", "()V", "Visible", "Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "getVisible$annotations", "getVisible", "()Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "Clip", "getClip$annotations", "getClip", "expandIndicator", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ContextualFlowRowOverflowScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "expandOrCollapseIndicator", "collapseIndicator", "minRowsToShowCollapse", "", "minHeightToShowCollapse", "Landroidx/compose/ui/unit/Dp;", "expandOrCollapseIndicator--jt2gSs", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;IFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ Function2 a(Function3 r0, FlowLayoutOverflowState r1) {
            return expandIndicator$lambda$0(r0, r1);
        }

        public static /* synthetic */ Function2 b(Function3 r0, FlowLayoutOverflowState r1) {
            return expandOrCollapseIndicator__jt2gSs$lambda$4$lambda$2(r0, r1);
        }

        public static /* synthetic */ Function2 c(Function3 r0, FlowLayoutOverflowState r1) {
            return expandOrCollapseIndicator__jt2gSs$lambda$4$lambda$3(r0, r1);
        }

        public static /* synthetic */ void getClip$annotations() {
        }

        public static /* synthetic */ void getVisible$annotations() {
        }

        public final ContextualFlowRowOverflow getClip() {
            return ContextualFlowRowOverflow.access$getClip$cp();
        }

        public final ContextualFlowRowOverflow getVisible() {
            return ContextualFlowRowOverflow.access$getVisible$cp();
        }

        public final ContextualFlowRowOverflow expandIndicator(final Function3<? super ContextualFlowRowOverflowScope, ? super Composer, ? super Integer, Unit> r9) {
            Function1 r4 = new x(r9);
            return new ContextualFlowRowOverflow(FlowLayoutOverflow.OverflowType.ExpandIndicator, 0, 0, r4, null, 22, null);
        }

        private static final Function2 expandIndicator$lambda$0(final Function3 r1, final FlowLayoutOverflowState r2) {
            return ComposableLambdaKt.composableLambdaInstance(1173882609, true, new ContextualFlowRowOverflow$Companion$expandIndicator$seeMoreGetter$1$1(r2, r1));
        }

        private static final Function2 expandOrCollapseIndicator__jt2gSs$lambda$4$lambda$2(final Function3 r1, final FlowLayoutOverflowState r2) {
            return ComposableLambdaKt.composableLambdaInstance(2006590568, true, new ContextualFlowRowOverflow$Companion$expandOrCollapseIndicator$1$seeMoreGetter$1$1(r2, r1));
        }

        private static final Function2 expandOrCollapseIndicator__jt2gSs$lambda$4$lambda$3(final Function3 r1, final FlowLayoutOverflowState r2) {
            return ComposableLambdaKt.composableLambdaInstance(-628801663, true, new ContextualFlowRowOverflow$Companion$expandOrCollapseIndicator$1$collapseGetter$1$1(r2, r1));
        }

        /* JADX INFO: renamed from: expandOrCollapseIndicator--jt2gSs, reason: not valid java name */
        public final ContextualFlowRowOverflow m851expandOrCollapseIndicatorjt2gSs(final Function3<? super ContextualFlowRowOverflowScope, ? super Composer, ? super Integer, Unit> r14, final Function3<? super ContextualFlowRowOverflowScope, ? super Composer, ? super Integer, Unit> r15, int r16, float r17, Composer r18, int r19, int r20) {
            boolean r5 = true;
            if ((r20 & 4) == 0) goto L5;
            int r8 = 1;
        L7:
            if ((r20 & 8) == 0) goto L9;
            float r4 = Dp.constructor-impl(0);
        L11:
            if (ComposerKt.isTraceInProgress() == false) goto L13;
            ComposerKt.traceEventStart(1802465558, r19, -1, "androidx.compose.foundation.layout.ContextualFlowRowOverflow.Companion.expandOrCollapseIndicator (FlowLayoutOverflow.kt:405)");
        L13:
            int r9 = ((Density) r18.consume(CompositionLocalsKt.getLocalDensity())).roundToPx-0680j_4(r4);
            if (((r19 & 896) ^ 384) <= 256) goto L18;
            if (r18.changed(r8) == false) goto L18;
        L19:
            boolean r6 = true;
        L21:
            boolean r7 = r6 | r18.changed(r9);
            if (((r19 & 14) ^ 6) <= 4) goto L26;
            if (r18.changed(r14) == false) goto L26;
        L27:
            boolean r10 = true;
        L29:
            boolean r11 = r7 | r10;
            if (((r19 & 112) ^ 48) <= 32) goto L34;
            if (r18.changed(r15) == false) goto L34;
        L37:
            boolean r3 = r11 | r5;
            Object r12 = r18.rememberedValue();
            if (r3 == false) goto L40;
        L41:
            r12 = new ContextualFlowRowOverflow(FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator, r8, r9, new y(r14), new z(r15), null);
            r18.updateRememberedValue(r12);
        L42:
            ContextualFlowRowOverflow r13 = (ContextualFlowRowOverflow) r12;
            if (ComposerKt.isTraceInProgress() == false) goto L45;
            ComposerKt.traceEventEnd();
        L45:
            return r13;
        L40:
            if (r12 != Composer.Companion.getEmpty()) goto L42;
        L34:
            if ((r19 & 48) == 32) goto L37;
            r5 = false;
        L26:
            if ((r19 & 6) == 4) goto L27;
            r10 = false;
        L18:
            if ((r19 & 384) == 256) goto L19;
            r6 = false;
            goto L21
        L9:
            r4 = r17;
            goto L11
        L5:
            r8 = r16;
            goto L7
        }
    }

    public /* synthetic */ ContextualFlowRowOverflow(FlowLayoutOverflow.OverflowType r1, int r2, int r3, Function1 r4, Function1 r5, DefaultConstructorMarker r6) {
        this(r1, r2, r3, r4, r5);
    }

    static {
        Companion = new Companion(null);
        Visible = new ContextualFlowRowOverflow(FlowLayoutOverflow.OverflowType.Visible, 0, 0, null, null, 30, null);
        Clip = new ContextualFlowRowOverflow(FlowLayoutOverflow.OverflowType.Clip, 0, 0, null, null, 30, null);
    }

    public static final /* synthetic */ ContextualFlowRowOverflow access$getClip$cp() {
        return Clip;
    }

    public static final /* synthetic */ ContextualFlowRowOverflow access$getVisible$cp() {
        return Visible;
    }

    private ContextualFlowRowOverflow(FlowLayoutOverflow.OverflowType r8, int r9, int r10, Function1<? super FlowLayoutOverflowState, ? extends Function2<? super Composer, ? super Integer, Unit>> r11, Function1<? super FlowLayoutOverflowState, ? extends Function2<? super Composer, ? super Integer, Unit>> r12) {
        super(r8, r9, r10, r11, r12, null);
    }

    public /* synthetic */ ContextualFlowRowOverflow(FlowLayoutOverflow.OverflowType r8, int r9, int r10, Function1 r11, Function1 r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L5;
        int r3 = 0;
    L7:
        if ((r13 & 4) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r13 & 8) == 0) goto L13;
        Function1 r5 = null;
    L15:
        if ((r13 & 16) == 0) goto L17;
        Function1 r6 = null;
    L18:
        this(r8, r3, r4, r5, r6);
        return;
    L17:
        r6 = r12;
        goto L18
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }
}
