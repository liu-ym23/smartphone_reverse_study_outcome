package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerModifierKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerNode;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequester;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.foundation.text.input.internal.selection.AndroidTextFieldMagnifier_androidKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006Ba\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010-\u001a\u00020.H\u0016J`\u0010/\u001a\u00020.2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ#\u00100\u001a\u000201*\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J\f\u00109\u001a\u00020.*\u00020:H\u0016J#\u0010;\u001a\u000201*\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002¢\u0006\u0004\b<\u00108J#\u0010=\u001a\u000201*\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002¢\u0006\u0004\b>\u00108J'\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020)2\u0006\u0010B\u001a\u00020)H\u0002¢\u0006\u0004\bC\u0010DJ3\u0010E\u001a\u00020.*\u00020F2\u0006\u0010G\u001a\u00020)2\u0006\u0010H\u001a\u00020)2\u0006\u0010@\u001a\u00020%2\u0006\u0010I\u001a\u00020JH\u0002¢\u0006\u0004\bK\u0010LJ#\u0010M\u001a\u00020.*\u00020N2\u0006\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020QH\u0002¢\u0006\u0004\bR\u0010SJ(\u0010T\u001a\u00020.*\u00020N2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020%0V2\u0006\u0010P\u001a\u00020QH\u0002J\u0014\u0010X\u001a\u00020.*\u00020N2\u0006\u0010P\u001a\u00020QH\u0002J\f\u0010Y\u001a\u00020.*\u00020NH\u0002J\b\u0010Z\u001a\u00020.H\u0002J\u0010\u0010[\u001a\u00020.2\u0006\u0010\\\u001a\u00020]H\u0016J\f\u0010^\u001a\u00020.*\u00020_H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "isFocused", "", "isDragHovered", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "writeable", "scrollState", "Landroidx/compose/foundation/ScrollState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "toolbarRequester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "platformSelectionBehaviors", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "<init>", "(ZZLandroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/graphics/Brush;ZLandroidx/compose/foundation/ScrollState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;)V", "cursorAnimation", "Landroidx/compose/foundation/text/input/internal/CursorAnimationState;", "showCursor", "getShowCursor", "()Z", "changeObserverJob", "Lkotlinx/coroutines/Job;", "previousSelection", "Landroidx/compose/ui/text/TextRange;", "previousCursorRect", "Landroidx/compose/ui/geometry/Rect;", "previousTextLayoutSize", "", "previousContainerSize", "textFieldMagnifierNode", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNode;", "onAttach", "", "updateNode", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "measureVerticalScroll", "measureVerticalScroll-3p2s80s", "measureHorizontalScroll", "measureHorizontalScroll-3p2s80s", "calculateOffsetToFollow", "currSelection", "currContainerSize", "currTextLayoutSize", "calculateOffsetToFollow-8ffj60Q", "(JII)I", "updateScrollState", "Landroidx/compose/ui/unit/Density;", "containerSize", "textLayoutSize", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "updateScrollState-tIlFzwE", "(Landroidx/compose/ui/unit/Density;IIJLandroidx/compose/ui/unit/LayoutDirection;)V", "drawSelection", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "selection", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "drawSelection-Sb-Bc2M", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/text/TextLayoutResult;)V", "drawHighlight", "highlight", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/input/TextHighlightType;", "drawText", "drawCursor", "startCursorJob", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldCoreModifierNode extends DelegatingNode implements LayoutModifierNode, DrawModifierNode, CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private Job changeObserverJob;
    private CursorAnimationState cursorAnimation;
    private Brush cursorBrush;
    private boolean isDragHovered;
    private boolean isFocused;
    private Orientation orientation;
    private PlatformSelectionBehaviors platformSelectionBehaviors;
    private int previousContainerSize;
    private Rect previousCursorRect;
    private TextRange previousSelection;
    private int previousTextLayoutSize;
    private ScrollState scrollState;
    private final TextFieldMagnifierNode textFieldMagnifierNode;
    private TextFieldSelectionState textFieldSelectionState;
    private TransformedTextFieldState textFieldState;
    private TextLayoutState textLayoutState;
    private ToolbarRequester toolbarRequester;
    private boolean writeable;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$1", f = "TextFieldCoreModifier.kt", i = {}, l = {209, 210}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TextFieldCoreModifierNode this$0;

        public AnonymousClass1(TextFieldCoreModifierNode r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(1, r2);
        }

        public final Continuation<Unit> create(Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r7);
        L18:
            TextFieldCoreModifierNode.access$getTextFieldSelectionState$p(this.this$0).setTextToolbarShown$foundation_release(true);
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
        L13:
            PlatformSelectionBehaviors r8 = TextFieldCoreModifierNode.access$getPlatformSelectionBehaviors$p(this.this$0);
            if (r8 == null) goto L18;
            CharSequence r2 = TextFieldCoreModifierNode.access$getTextFieldSelectionState$p(this.this$0).getTextFieldState$foundation_release().getVisualText().getText();
            long r4 = TextFieldCoreModifierNode.access$getTextFieldSelectionState$p(this.this$0).getTextFieldState$foundation_release().getVisualText().m1535getSelectiond9O1mEE();
            this.label = 2;
            if (r8.mo1836onShowContextMenuSbBc2M(r2, r4, this) != r0) goto L18;
            return r0;
        L10:
            ResultKt.throwOnFailure(r7);
            TextFieldSelectionState r9 = TextFieldCoreModifierNode.access$getTextFieldSelectionState$p(this.this$0);
            this.label = 1;
            if (r9.updateClipboardEntry(this) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$2", f = "TextFieldCoreModifier.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TextFieldCoreModifierNode this$0;

        public AnonymousClass2(TextFieldCoreModifierNode r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(1, r2);
        }

        public final Continuation<Unit> create(Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            TextFieldCoreModifierNode.access$getTextFieldSelectionState$p(this.this$0).setTextToolbarShown$foundation_release(false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1", f = "TextFieldCoreModifier.kt", i = {}, l = {618}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TextFieldCoreModifierNode this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "isWindowFocused", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1$2", f = "TextFieldCoreModifier.kt", i = {}, l = {620}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
            /* synthetic */ int I$0;
            int label;
            final /* synthetic */ TextFieldCoreModifierNode this$0;

            public AnonymousClass2(TextFieldCoreModifierNode r1, Continuation<? super AnonymousClass2> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r4);
                r0.I$0 = ((Number) r3).intValue();
                return r0;
            }

            public final Object invoke(int r1, Continuation<? super Unit> r2) {
                return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke(((Number) r1).intValue(), (Continuation) r2);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L16:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                if (Math.abs(this.I$0) != 1) goto L16;
                CursorAnimationState r5 = TextFieldCoreModifierNode.access$getCursorAnimation$p(this.this$0);
                if (r5 == null) goto L16;
                this.label = 1;
                if (r5.snapToVisibleAndAnimate(this) != r0) goto L16;
                return r0;
            }
        }

        public C02121(TextFieldCoreModifierNode r1, Continuation<? super C02121> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public static /* synthetic */ int a(TextFieldCoreModifierNode r0, Ref.IntRef r1) {
            return invokeSuspend$lambda$1(r0, r1);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02121(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            final Ref.IntRef r7 = new Ref.IntRef();
            r7.element = 1;
            final TextFieldCoreModifierNode r2 = this.this$0;
            Flow r8 = SnapshotStateKt.snapshotFlow(new q0(r2, r7));
            AnonymousClass2 r3 = new AnonymousClass2(this.this$0, null);
            this.label = 1;
            if (kotlinx.coroutines.flow.e.i(r8, r3, this) != r0) goto L12;
            return r0;
        }

        private static final int invokeSuspend$lambda$1(TextFieldCoreModifierNode r2, Ref.IntRef r3) {
            TextFieldCoreModifierNode.access$getTextFieldState$p(r2).getVisualText();
            int r1 = 1;
            if (r2.isAttached() == true) goto L5;
        L7:
            boolean r4 = false;
        L8:
            if (r4 == true) goto L11;
            r1 = 2;
        L11:
            int r5 = r3.element;
            int r6 = r1 * r5;
            r3.element = r5 * (-1);
            return r6;
        L5:
            if (((WindowInfo) CompositionLocalConsumerModifierNodeKt.currentValueOf(r2, CompositionLocalsKt.getLocalWindowInfo())).isWindowFocused() == false) goto L7;
            r4 = true;
            goto L8
        }
    }

    public static /* synthetic */ Rect a(TextFieldCoreModifierNode r0, LayoutCoordinates r1) {
        return _init_$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit b(TextFieldCoreModifierNode r0, int r1, Placeable r2, MeasureScope r3, Placeable.PlacementScope r4) {
        return measureVerticalScroll_3p2s80s$lambda$3(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit c(TextFieldCoreModifierNode r0, int r1, Placeable r2, MeasureScope r3, Placeable.PlacementScope r4) {
        return measureHorizontalScroll_3p2s80s$lambda$4(r0, r1, r2, r3, r4);
    }

    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldClearDescendantSemantics(this);
    }

    public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldMergeDescendantSemantics(this);
    }

    public final /* synthetic */ boolean isImportantForBounds() {
        return SemanticsModifierNode.-CC.$default$isImportantForBounds(this);
    }

    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifierNode.-CC.$default$maxIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifierNode.-CC.$default$maxIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifierNode.-CC.$default$minIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifierNode.-CC.$default$minIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.-CC.$default$onMeasureResultChanged(this);
    }

    private final boolean getShowCursor() {
        if (this.writeable == true) goto L5;
    L11:
        return false;
    L5:
        if (this.isFocused == true) goto L9;
        if (this.isDragHovered == false) goto L11;
    L9:
        if (TextFieldCoreModifierKt.access$isSpecified(this.cursorBrush) == false) goto L11;
        return true;
    }

    private final void startCursorJob() {
        if (this.cursorAnimation != null) goto L5;
        this.cursorAnimation = new CursorAnimationState(((Boolean) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalCursorBlinkEnabled())).booleanValue());
        DrawModifierNodeKt.invalidateDraw(this);
    L5:
        this.changeObserverJob = BuildersKt.launch$default(getCoroutineScope(), null, null, new C02121(this, null), 3, null);
    }

    public void onAttach() {
        if (this.isFocused == true) goto L5;
        return;
    L5:
        if (getShowCursor() == false) goto L9;
        startCursorJob();
        return;
    }

    public static final /* synthetic */ CursorAnimationState access$getCursorAnimation$p(TextFieldCoreModifierNode r0) {
        return r0.cursorAnimation;
    }

    public static final /* synthetic */ PlatformSelectionBehaviors access$getPlatformSelectionBehaviors$p(TextFieldCoreModifierNode r0) {
        return r0.platformSelectionBehaviors;
    }

    public static final /* synthetic */ ScrollState access$getScrollState$p(TextFieldCoreModifierNode r0) {
        return r0.scrollState;
    }

    public static final /* synthetic */ TextFieldSelectionState access$getTextFieldSelectionState$p(TextFieldCoreModifierNode r0) {
        return r0.textFieldSelectionState;
    }

    public static final /* synthetic */ TransformedTextFieldState access$getTextFieldState$p(TextFieldCoreModifierNode r0) {
        return r0.textFieldState;
    }

    public static final /* synthetic */ TextLayoutState access$getTextLayoutState$p(TextFieldCoreModifierNode r0) {
        return r0.textLayoutState;
    }

    private final void drawCursor(DrawScope r18) {
        CursorAnimationState r1 = this.cursorAnimation;
        if (r1 == null) goto L5;
        float r12 = r1.getCursorAlpha();
    L7:
        if (r12 != MenuKt.ClosedAlphaTarget) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        return;
    L12:
        if (getShowCursor() == false) goto L17;
        Rect r3 = this.textFieldSelectionState.getCursorRect();
        DrawScope.-CC.drawLine-1RTmtNc$default(r18, this.cursorBrush, r3.getTopCenter-F1C5BW0(), r3.getBottomCenter-F1C5BW0(), r3.getRight() - r3.getLeft(), 0, null, r12, null, 0, 432, null);
        return;
    L17:
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r12 = MenuKt.ClosedAlphaTarget;
        goto L7
    }

    public void applySemantics(SemanticsPropertyReceiver r2) {
        this.textFieldMagnifierNode.applySemantics(r2);
    }

    public void draw(ContentDrawScope r5) {
        r5.drawContent();
        TextFieldCharSequence r0 = this.textFieldState.getVisualText();
        TextLayoutResult r1 = this.textLayoutState.getLayoutResult();
        if (r1 != null) goto L5;
        return;
    L5:
        Pair<TextHighlightType, TextRange> r2 = r0.getHighlight();
        if (r2 == null) goto L9;
        drawHighlight(r5, r2, r1);
    L9:
        if (TextRange.getCollapsed-impl(r0.m1535getSelectiond9O1mEE()) == false) goto L14;
        drawText(r5, r1);
        if (r0.shouldShowSelection() == false) goto L17;
        drawCursor(r5);
    L17:
        this.textFieldMagnifierNode.draw(r5);
        return;
    L14:
        if (r0.shouldShowSelection() == false) goto L16;
        m1630drawSelectionSbBc2M(r5, r0.m1535getSelectiond9O1mEE(), r1);
    L16:
        drawText(r5, r1);
        goto L17
    }

    public void onGloballyPositioned(LayoutCoordinates r2) {
        this.textLayoutState.setCoreNodeCoordinates(r2);
        this.textFieldMagnifierNode.onGloballyPositioned(r2);
    }

    private static final Rect _init_$lambda$0(TextFieldCoreModifierNode r1, LayoutCoordinates r2) {
        Rect r0 = r1.textFieldSelectionState.getDerivedVisibleContentBounds$foundation_release();
        if (r0 != null) goto L5;
        r0 = Rect.Companion.getZero();
    L5:
        LayoutCoordinates r3 = r1.textLayoutState.getTextLayoutNodeCoordinates();
        if (r3 != null) goto L8;
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    L8:
        return TextContextMenuToolbarHandlerModifierKt.translateRootToDestination(r0, r3, r2);
    }

    private final void drawText(DrawScope r2, TextLayoutResult r3) {
        Canvas r4 = r2.getDrawContext().getCanvas();
        TextPainter.INSTANCE.paint(r4, r3);
    }

    /* JADX INFO: renamed from: calculateOffsetToFollow-8ffj60Q, reason: not valid java name */
    private final int m1629calculateOffsetToFollow8ffj60Q(long r7, int r9, int r10) {
        TextRange r0 = this.previousSelection;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L26;
        TextRange r3 = this.previousSelection;
        if (r3 != null) goto L13;
    L15:
        r1 = false;
    L16:
        if (r1 == true) goto L19;
        return TextRange.getStart-impl(r7);
    L19:
        if (r10 != this.previousTextLayoutSize) goto L25;
        if (r9 != this.previousContainerSize) goto L25;
        return -1;
    L25:
        return TextRange.getStart-impl(r7);
    L13:
        if (TextRange.getStart-impl(r7) != TextRange.getStart-impl(r3.unbox-impl())) goto L15;
    L26:
        return TextRange.getEnd-impl(r7);
    L5:
        if (TextRange.getEnd-impl(r7) != TextRange.getEnd-impl(r0.unbox-impl())) goto L7;
        r2 = true;
        goto L8
    }

    private final void drawHighlight(DrawScope r13, Pair<TextHighlightType, TextRange> r14, TextLayoutResult r15) {
        int r0 = ((TextHighlightType) r14.component1()).m1548unboximpl();
        long r1 = ((TextRange) r14.component2()).unbox-impl();
        if (TextRange.getCollapsed-impl(r1) == false) goto L5;
        return;
    L5:
        Path r3 = r15.getPathForRange(TextRange.getMin-impl(r1), TextRange.getMax-impl(r1));
        if (TextHighlightType.m1545equalsimpl0(r0, TextHighlightType.Companion.m1549getHandwritingDeletePreviewsxJuwY()) == false) goto L18;
        Brush r4 = r15.getLayoutInput().getStyle().getBrush();
        if (r4 == null) goto L10;
        DrawScope.-CC.drawPath-GBMwjPU$default(r13, r3, r4, 0.2f, null, null, 0, 56, null);
        return;
    L10:
        long r16 = r15.getLayoutInput().getStyle().getColor-0d7_KjU();
        if (r16 == 16) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L17;
        r16 = Color.Companion.getBlack-0d7_KjU();
    L17:
        long r5 = r16;
        DrawScope.-CC.drawPath-LG529CI$default(r13, r3, Color.copy-wmQWz5c$default(r5, Color.getAlpha-impl(r5) * 0.2f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), MenuKt.ClosedAlphaTarget, null, null, 0, 60, null);
        return;
    L13:
        r2 = false;
        goto L14
    L18:
        DrawScope.-CC.drawPath-LG529CI$default(r13, r3, ((TextSelectionColors) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, TextSelectionColorsKt.getLocalTextSelectionColors())).m1910getBackgroundColor0d7_KjU(), MenuKt.ClosedAlphaTarget, null, null, 0, 60, null);
    }

    /* JADX INFO: renamed from: drawSelection-Sb-Bc2M, reason: not valid java name */
    private final void m1630drawSelectionSbBc2M(DrawScope r12, long r13, TextLayoutResult r15) {
        int r0 = TextRange.getMin-impl(r13);
        int r14 = TextRange.getMax-impl(r13);
        if (r0 == r14) goto L6;
        long r3 = ((TextSelectionColors) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, TextSelectionColorsKt.getLocalTextSelectionColors())).m1910getBackgroundColor0d7_KjU();
        DrawScope.-CC.drawPath-LG529CI$default(r12, r15.getPathForRange(r0, r14), r3, MenuKt.ClosedAlphaTarget, null, null, 0, 60, null);
        return;
    }

    /* JADX INFO: renamed from: measureHorizontalScroll-3p2s80s, reason: not valid java name */
    private final MeasureResult m1631measureHorizontalScroll3p2s80s(final MeasureScope r9, Measurable r10, long r11) {
        final Placeable r12 = r10.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r11, 0, Integer.MAX_VALUE, 0, 0, 13, null));
        final int r2 = Math.min(r12.getWidth(), Constraints.getMaxWidth-impl(r11));
        return MeasureScope.-CC.layout$default(r9, r2, r12.getHeight(), null, new p0(this, r2, r12, r9), 4, null);
    }

    /* JADX INFO: renamed from: measureVerticalScroll-3p2s80s, reason: not valid java name */
    private final MeasureResult m1632measureVerticalScroll3p2s80s(final MeasureScope r9, Measurable r10, long r11) {
        final Placeable r12 = r10.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r11, 0, 0, 0, Integer.MAX_VALUE, 7, null));
        final int r3 = Math.min(r12.getHeight(), Constraints.getMaxHeight-impl(r11));
        return MeasureScope.-CC.layout$default(r9, r12.getWidth(), r3, null, new n0(this, r3, r12, r9), 4, null);
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m1634measure3p2s80s(MeasureScope r3, Measurable r4, long r5) {
        if (this.orientation != Orientation.Vertical) goto L6;
        return m1632measureVerticalScroll3p2s80s(r3, r4, r5);
    L6:
        return m1631measureHorizontalScroll3p2s80s(r3, r4, r5);
    }

    private static final Unit measureHorizontalScroll_3p2s80s$lambda$4(TextFieldCoreModifierNode r7, int r8, Placeable r9, MeasureScope r10, Placeable.PlacementScope r11) {
        r7.m1633updateScrollStatetIlFzwE(r11, r8, r9.getWidth(), r7.textFieldState.getVisualText().m1535getSelectiond9O1mEE(), r10.getLayoutDirection());
        Placeable.PlacementScope.placeRelative$default(r11, r9, -r7.scrollState.getValue(), 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit measureVerticalScroll_3p2s80s$lambda$3(TextFieldCoreModifierNode r14, int r15, Placeable r16, MeasureScope r17, Placeable.PlacementScope r18) {
        r14.m1633updateScrollStatetIlFzwE(r18, r15, r16.getHeight(), r14.textFieldState.getVisualText().m1535getSelectiond9O1mEE(), r17.getLayoutDirection());
        Placeable.PlacementScope.placeRelative$default(r18, r16, 0, -r14.scrollState.getValue(), MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: updateScrollState-tIlFzwE, reason: not valid java name */
    private final void m1633updateScrollStatetIlFzwE(Density r9, int r10, int r11, long r12, LayoutDirection r14) {
        this.scrollState.setViewportSize$foundation_release(r10);
        this.scrollState.setMaxValue$foundation_release(r11 - r10);
        int r0 = m1629calculateOffsetToFollow8ffj60Q(r12, r10, r11);
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (getShowCursor() == false) goto L58;
        TextLayoutResult r1 = this.textLayoutState.getLayoutResult();
        if (r1 != null) goto L10;
        return;
    L10:
        boolean r4 = false;
        Rect r2 = r1.getCursorRect(RangesKt.coerceIn(r0, new IntRange(0, r1.getLayoutInput().getText().length())));
        if (r14 != LayoutDirection.Rtl) goto L13;
        boolean r15 = true;
    L14:
        Rect r13 = TextFieldCoreModifierKt.access$getCursorRectInScroller(r9, r2, r15, r11);
        if (r13.getLeft() != this.previousCursorRect.getLeft()) goto L17;
        boolean r16 = true;
    L18:
        if (r16 == true) goto L20;
    L28:
        boolean r17 = true;
    L29:
        if (r17 == true) goto L33;
        if (r10 != this.previousContainerSize) goto L33;
        return;
    L33:
        if (this.orientation != Orientation.Vertical) goto L35;
        r4 = true;
    L35:
        if (r4 == false) goto L37;
        float r3 = r13.getTop();
    L38:
        if (r4 == false) goto L40;
        float r5 = r13.getBottom();
    L41:
        int r6 = this.scrollState.getValue();
        float r7 = r6 + r10;
        if (r5 <= r7) goto L44;
    L43:
        float r8 = r5 - r7;
    L54:
        this.previousSelection = TextRange.box-impl(r12);
        this.previousCursorRect = r13;
        this.previousContainerSize = r10;
        this.previousTextLayoutSize = r11;
        BuildersKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new TextFieldCoreModifierNode$updateScrollState$1(this, r8, r17, r2, null), 1, null);
        return;
    L44:
        float r18 = r6;
        if (r3 < r18) goto L47;
    L49:
        if (r3 < r18) goto L51;
    L53:
        r8 = MenuKt.ClosedAlphaTarget;
        goto L54
    L51:
        if ((r5 - r3) > r10) goto L53;
        r8 = r3 - r18;
        goto L54
    L47:
        if ((r5 - r3) <= r10) goto L49;
    L40:
        r5 = r13.getRight();
        goto L41
    L37:
        r3 = r13.getLeft();
        goto L38
    L20:
        if (r13.getTop() != this.previousCursorRect.getTop()) goto L22;
        boolean r19 = true;
    L23:
        if (r19 == false) goto L28;
        if (r11 != this.previousTextLayoutSize) goto L28;
        r17 = false;
        goto L29
    L22:
        r19 = false;
        goto L23
    L17:
        r16 = false;
        goto L18
    L13:
        r15 = false;
        goto L14
    }

    public TextFieldCoreModifierNode(boolean r1, boolean r2, TextLayoutState r3, TransformedTextFieldState r4, TextFieldSelectionState r5, Brush r6, boolean r7, ScrollState r8, Orientation r9, ToolbarRequester r10, PlatformSelectionBehaviors r11) {
        this.isFocused = r1;
        this.isDragHovered = r2;
        this.textLayoutState = r3;
        this.textFieldState = r4;
        this.textFieldSelectionState = r5;
        this.cursorBrush = r6;
        this.writeable = r7;
        this.scrollState = r8;
        this.orientation = r9;
        this.toolbarRequester = r10;
        this.platformSelectionBehaviors = r11;
        this.previousCursorRect = new Rect(-1.0f, -1.0f, -1.0f, -1.0f);
        TransformedTextFieldState r12 = this.textFieldState;
        TextFieldSelectionState r13 = this.textFieldSelectionState;
        TextLayoutState r14 = this.textLayoutState;
        if (this.isFocused == false) goto L5;
    L8:
        boolean r15 = true;
    L9:
        this.textFieldMagnifierNode = delegate(AndroidTextFieldMagnifier_androidKt.textFieldMagnifierNode(r12, r13, r14, r15));
        delegate(new TextContextMenuToolbarHandlerNode(this.toolbarRequester, new AnonymousClass1(this, null), new AnonymousClass2(this, null), new o0(this)));
        return;
    L5:
        if (this.isDragHovered == true) goto L8;
        r15 = false;
        goto L9
    }

    public final void updateNode(boolean r16, boolean r17, TextLayoutState r18, TransformedTextFieldState r19, TextFieldSelectionState r20, Brush r21, boolean r22, ScrollState r23, Orientation r24, ToolbarRequester r25, PlatformSelectionBehaviors r26) {
        boolean r7 = getShowCursor();
        boolean r8 = this.isFocused;
        TransformedTextFieldState r9 = this.textFieldState;
        TextLayoutState r10 = this.textLayoutState;
        TextFieldSelectionState r11 = this.textFieldSelectionState;
        ScrollState r12 = this.scrollState;
        this.isFocused = r16;
        this.isDragHovered = r17;
        this.textLayoutState = r18;
        this.textFieldState = r19;
        this.textFieldSelectionState = r20;
        this.cursorBrush = r21;
        this.writeable = r22;
        this.scrollState = r23;
        this.orientation = r24;
        this.toolbarRequester = r25;
        this.platformSelectionBehaviors = r26;
        TextFieldMagnifierNode r13 = this.textFieldMagnifierNode;
        if (r16 == true) goto L7;
        if (r17 == true) goto L7;
        boolean r1 = false;
    L8:
        r13.update(r19, r20, r18, r1);
        if (getShowCursor() == true) goto L16;
        Job r2 = this.changeObserverJob;
        if (r2 == null) goto L13;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L13:
        this.changeObserverJob = null;
        CursorAnimationState r3 = this.cursorAnimation;
        if (r3 == null) goto L22;
        r3.cancelAndHide();
    L22:
        if (Intrinsics.areEqual(r9, r19) == true) goto L24;
    L29:
        LayoutModifierNodeKt.invalidateMeasurement(this);
        return;
    L24:
        if (Intrinsics.areEqual(r10, r18) == false) goto L29;
        if (Intrinsics.areEqual(r11, r20) == false) goto L29;
        if (Intrinsics.areEqual(r12, r23) == false) goto L29;
        return;
    L16:
        if (r8 == true) goto L18;
    L20:
        startCursorJob();
        goto L22
    L18:
        if (Intrinsics.areEqual(r9, r19) == false) goto L20;
        if (r7 == true) goto L22;
    L7:
        r1 = true;
        goto L8
    }
}
