package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.foundation.MagnifierNode;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.selection.SelectionMagnifierKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J(\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010!\u001a\u00020\u001fH\u0002J\f\u0010\"\u001a\u00020\u001f*\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&H\u0016J\f\u0010'\u001a\u00020\u001f*\u00020(H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNodeImpl28;", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "visible", "", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Z)V", "<set-?>", "Landroidx/compose/ui/unit/IntSize;", "magnifierSize", "getMagnifierSize-YbymL2g", "()J", "setMagnifierSize-ozmzZPI", "(J)V", "magnifierSize$delegate", "Landroidx/compose/runtime/MutableState;", "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/animation/core/AnimationVector2D;", "magnifierNode", "Landroidx/compose/foundation/MagnifierNode;", "animationJob", "Lkotlinx/coroutines/Job;", "onAttach", "", "update", "restartAnimationJob", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldMagnifierNodeImpl28 extends TextFieldMagnifierNode implements CompositionLocalConsumerModifierNode {
    public static final int $stable = 0;
    private final Animatable<Offset, AnimationVector2D> animatable;
    private Job animationJob;
    private final MagnifierNode magnifierNode;
    private final MutableState magnifierSize$delegate;
    private TextFieldSelectionState textFieldSelectionState;
    private TransformedTextFieldState textFieldState;
    private TextLayoutState textLayoutState;
    private boolean visible;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$restartAnimationJob$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$restartAnimationJob$1", f = "AndroidTextFieldMagnifier.android.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TextFieldMagnifierNodeImpl28 this$0;

        public AnonymousClass1(TextFieldMagnifierNodeImpl28 r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public static /* synthetic */ Offset a(TextFieldMagnifierNodeImpl28 r0) {
            return invokeSuspend$lambda$0(r0);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        private static final Offset invokeSuspend$lambda$0(TextFieldMagnifierNodeImpl28 r5) {
            if (TextFieldMagnifierNodeImpl28.access$getVisible$p(r5) == true) goto L9;
            if (TextFieldMagnifierNodeImpl28.access$getTextFieldSelectionState$p(r5).getDirectDragGestureInitiator() == TextFieldSelectionState.InputType.Touch) goto L9;
            return Offset.box-impl(Offset.Companion.getUnspecified-F1C5BW0());
        L9:
            return Offset.box-impl(TextFieldMagnifierKt.m1706calculateSelectionMagnifierCenterAndroidhUlJWOE(TextFieldMagnifierNodeImpl28.access$getTextFieldState$p(r5), TextFieldMagnifierNodeImpl28.access$getTextFieldSelectionState$p(r5), TextFieldMagnifierNodeImpl28.access$getTextLayoutState$p(r5), TextFieldMagnifierNodeImpl28.m1707access$getMagnifierSizeYbymL2g(r5)));
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
            final CoroutineScope r7 = (CoroutineScope) this.L$0;
            final TextFieldMagnifierNodeImpl28 r2 = this.this$0;
            Flow r3 = SnapshotStateKt.snapshotFlow(new c(r2));
            final TextFieldMagnifierNodeImpl28 r4 = this.this$0;
            FlowCollector r5 = new AnonymousClass2(r4, r7);
            this.label = 1;
            if (r3.collect(r5, this) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ Unit a(TextFieldMagnifierNodeImpl28 r0, DpSize r1) {
        return magnifierNode$lambda$2(r0, r1);
    }

    public static /* synthetic */ Offset b(TextFieldMagnifierNodeImpl28 r0, Density r1) {
        return magnifierNode$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: getMagnifierSize-YbymL2g, reason: not valid java name */
    private final long m1708getMagnifierSizeYbymL2g() {
        return ((IntSize) this.magnifierSize$delegate.getValue()).unbox-impl();
    }

    private final void restartAnimationJob() {
        Job r0 = this.animationJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.animationJob = null;
        if (Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, null) == true) goto L8;
        return;
    L8:
        this.animationJob = BuildersKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public void onAttach() {
        restartAnimationJob();
    }

    public static final /* synthetic */ Animatable access$getAnimatable$p(TextFieldMagnifierNodeImpl28 r0) {
        return r0.animatable;
    }

    /* JADX INFO: renamed from: access$getMagnifierSize-YbymL2g, reason: not valid java name */
    public static final /* synthetic */ long m1707access$getMagnifierSizeYbymL2g(TextFieldMagnifierNodeImpl28 r2) {
        return r2.m1708getMagnifierSizeYbymL2g();
    }

    public static final /* synthetic */ TextFieldSelectionState access$getTextFieldSelectionState$p(TextFieldMagnifierNodeImpl28 r0) {
        return r0.textFieldSelectionState;
    }

    public static final /* synthetic */ TransformedTextFieldState access$getTextFieldState$p(TextFieldMagnifierNodeImpl28 r0) {
        return r0.textFieldState;
    }

    public static final /* synthetic */ TextLayoutState access$getTextLayoutState$p(TextFieldMagnifierNodeImpl28 r0) {
        return r0.textLayoutState;
    }

    public static final /* synthetic */ boolean access$getVisible$p(TextFieldMagnifierNodeImpl28 r0) {
        return r0.visible;
    }

    /* JADX INFO: renamed from: setMagnifierSize-ozmzZPI, reason: not valid java name */
    private final void m1709setMagnifierSizeozmzZPI(long r2) {
        this.magnifierSize$delegate.setValue(IntSize.box-impl(r2));
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode
    public void applySemantics(SemanticsPropertyReceiver r2) {
        this.magnifierNode.applySemantics(r2);
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode
    public void draw(ContentDrawScope r2) {
        r2.drawContent();
        this.magnifierNode.draw(r2);
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode
    public void onGloballyPositioned(LayoutCoordinates r2) {
        this.magnifierNode.onGloballyPositioned(r2);
    }

    private static final Offset magnifierNode$lambda$0(TextFieldMagnifierNodeImpl28 r0, Density r1) {
        return r0.animatable.getValue();
    }

    private static final Unit magnifierNode$lambda$2(TextFieldMagnifierNodeImpl28 r6, DpSize r7) {
        Density r0 = (Density) CompositionLocalConsumerModifierNodeKt.currentValueOf(r6, CompositionLocalsKt.getLocalDensity());
        int r1 = r0.roundToPx-0680j_4(DpSize.getWidth-D9Ej5fM(r7.unbox-impl()));
        int r8 = r0.roundToPx-0680j_4(DpSize.getHeight-D9Ej5fM(r7.unbox-impl()));
        r6.m1709setMagnifierSizeozmzZPI(IntSize.constructor-impl((((long) r1) << 32) | (((long) r8) & 4294967295L)));
        return Unit.INSTANCE;
    }

    public TextFieldMagnifierNodeImpl28(TransformedTextFieldState r24, TextFieldSelectionState r25, TextLayoutState r26, boolean r27) {
        this.textFieldState = r24;
        this.textFieldSelectionState = r25;
        this.textLayoutState = r26;
        this.visible = r27;
        this.magnifierSize$delegate = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), null, 2, null);
        this.animatable = new Animatable(Offset.box-impl(TextFieldMagnifierKt.m1706calculateSelectionMagnifierCenterAndroidhUlJWOE(this.textFieldState, this.textFieldSelectionState, this.textLayoutState, m1708getMagnifierSizeYbymL2g())), SelectionMagnifierKt.getUnspecifiedSafeOffsetVectorConverter(), Offset.box-impl(SelectionMagnifierKt.getOffsetDisplacementThreshold()), null, 8, null);
        this.magnifierNode = delegate(new MagnifierNode(new a(this), null, new b(this), MenuKt.ClosedAlphaTarget, true, 0, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, false, null, 1002, null));
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode
    public void update(TransformedTextFieldState r5, TextFieldSelectionState r6, TextLayoutState r7, boolean r8) {
        TransformedTextFieldState r0 = this.textFieldState;
        TextFieldSelectionState r1 = this.textFieldSelectionState;
        TextLayoutState r2 = this.textLayoutState;
        boolean r3 = this.visible;
        this.textFieldState = r5;
        this.textFieldSelectionState = r6;
        this.textLayoutState = r7;
        this.visible = r8;
        if (Intrinsics.areEqual(r5, r0) == true) goto L5;
    L9:
        restartAnimationJob();
        return;
    L5:
        if (Intrinsics.areEqual(r6, r1) == false) goto L9;
        if (Intrinsics.areEqual(r7, r2) == false) goto L9;
        if (r8 != r3) goto L9;
    }
}
