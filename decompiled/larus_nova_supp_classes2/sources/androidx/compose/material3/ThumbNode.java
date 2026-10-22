package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010!\u001a\u00020\"H\u0016J#\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u0006\u0010,\u001a\u00020\"R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Landroidx/compose/material3/ThumbNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "checked", "", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "<init>", "(Landroidx/compose/foundation/interaction/InteractionSource;ZLandroidx/compose/animation/core/FiniteAnimationSpec;)V", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "setInteractionSource", "(Landroidx/compose/foundation/interaction/InteractionSource;)V", "getChecked", "()Z", "setChecked", "(Z)V", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "isPressed", "offsetAnim", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "sizeAnim", "initialOffset", "initialSize", "onAttach", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "update", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ThumbNode extends Modifier.Node implements LayoutModifierNode {
    private FiniteAnimationSpec<Float> animationSpec;
    private boolean checked;
    private float initialOffset;
    private float initialSize;
    private InteractionSource interactionSource;
    private boolean isPressed;
    private Animatable<Float, AnimationVector1D> offsetAnim;
    private Animatable<Float, AnimationVector1D> sizeAnim;

    /* JADX INFO: renamed from: androidx.compose.material3.ThumbNode$onAttach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.ThumbNode$onAttach$1", f = "Switch.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ThumbNode this$0;

        public AnonymousClass1(ThumbNode r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
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
            Flow<Interaction> r2 = this.this$0.getInteractionSource().getInteractions();
            final ThumbNode r4 = this.this$0;
            FlowCollector r3 = new C00751(r7, r4);
            this.label = 1;
            if (r2.collect(r3, this) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ Unit a(Placeable r0, ThumbNode r1, float r2, Placeable.PlacementScope r3) {
        return measure_3p2s80s$lambda$0(r0, r1, r2, r3);
    }

    public boolean getShouldAutoInvalidate() {
        return false;
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

    public final void update() {
        if (this.sizeAnim != null) goto L8;
        if (Float.isNaN(this.initialSize) == true) goto L8;
        this.sizeAnim = AnimatableKt.Animatable$default(this.initialSize, MenuKt.ClosedAlphaTarget, 2, null);
    L8:
        if (this.offsetAnim == null) goto L10;
        return;
    L10:
        if (Float.isNaN(this.initialOffset) == true) goto L14;
        this.offsetAnim = AnimatableKt.Animatable$default(this.initialOffset, MenuKt.ClosedAlphaTarget, 2, null);
        return;
    }

    public void onAttach() {
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final FiniteAnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final InteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public static final /* synthetic */ Animatable access$getOffsetAnim$p(ThumbNode r0) {
        return r0.offsetAnim;
    }

    public static final /* synthetic */ Animatable access$getSizeAnim$p(ThumbNode r0) {
        return r0.sizeAnim;
    }

    public static final /* synthetic */ boolean access$isPressed$p(ThumbNode r0) {
        return r0.isPressed;
    }

    public final void setAnimationSpec(FiniteAnimationSpec<Float> r1) {
        this.animationSpec = r1;
    }

    public final void setChecked(boolean r1) {
        this.checked = r1;
    }

    public final void setInteractionSource(InteractionSource r1) {
        this.interactionSource = r1;
    }

    public static final /* synthetic */ void access$setPressed$p(ThumbNode r0, boolean r1) {
        r0.isPressed = r1;
    }

    public ThumbNode(InteractionSource r1, boolean r2, FiniteAnimationSpec<Float> r3) {
        this.interactionSource = r1;
        this.checked = r2;
        this.animationSpec = r3;
        this.initialOffset = Float.NaN;
        this.initialSize = Float.NaN;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m3367measure3p2s80s(MeasureScope r10, Measurable r11, long r12) {
        if (r11.maxIntrinsicHeight(Constraints.getMaxWidth-impl(r12)) != 0) goto L5;
    L7:
        boolean r13 = false;
    L9:
        if (this.isPressed == false) goto L11;
        float r14 = SwitchTokens.INSTANCE.getPressedHandleWidth-D9Ej5fM();
    L17:
        float r15 = r10.toPx-0680j_4(r14);
        Animatable<Float, AnimationVector1D> r16 = this.sizeAnim;
        if (r16 == null) goto L20;
        float r17 = r16.getValue().floatValue();
    L21:
        int r2 = (int) r17;
        final Placeable r18 = r11.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(r2, r2));
        final float r19 = r10.toPx-0680j_4(Dp.constructor-impl(Dp.constructor-impl(SwitchKt.access$getSwitchHeight$p() - r10.toDp-u2uoSUM(r15)) / 2.0f));
        float r0 = r10.toPx-0680j_4(Dp.constructor-impl(Dp.constructor-impl(SwitchKt.access$getSwitchWidth$p() - SwitchKt.getThumbDiameter()) - SwitchKt.access$getThumbPadding$p()));
        boolean r1 = this.isPressed;
        if (r1 == true) goto L24;
    L26:
        if (r1 == false) goto L31;
        if (this.checked == true) goto L31;
        r19 = r10.toPx-0680j_4(SwitchTokens.INSTANCE.getTrackOutlineWidth-D9Ej5fM());
    L33:
        Animatable<Float, AnimationVector1D> r3 = this.sizeAnim;
        if (r3 == null) goto L36;
        Float r4 = r3.getTargetValue();
    L38:
        if (Intrinsics.areEqual(r4, r15) == true) goto L40;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new ThumbNode$measure$1(this, r15, null), 3, null);
    L40:
        Animatable<Float, AnimationVector1D> r5 = this.offsetAnim;
        if (r5 == null) goto L43;
        Float r6 = r5.getTargetValue();
    L45:
        if (Intrinsics.areEqual(r6, r19) == true) goto L48;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new ThumbNode$measure$2(this, r19, null), 3, null);
    L48:
        if (Float.isNaN(this.initialSize) == false) goto L53;
        if (Float.isNaN(this.initialOffset) == false) goto L53;
        this.initialSize = r15;
        this.initialOffset = r19;
    L53:
        return MeasureScope.-CC.layout$default(r10, r2, r2, null, new hu(r18, this, r19), 4, null);
    L43:
        r6 = null;
        goto L45
    L36:
        r4 = null;
    L31:
        if (this.checked == false) goto L33;
        r19 = r0;
        goto L33
    L24:
        if (this.checked == false) goto L26;
        r19 = r0 - r10.toPx-0680j_4(SwitchTokens.INSTANCE.getTrackOutlineWidth-D9Ej5fM());
        goto L33
    L20:
        r17 = r15;
        goto L21
    L11:
        if (r13 == false) goto L13;
    L16:
        r14 = SwitchKt.getThumbDiameter();
        goto L17
    L13:
        if (this.checked == true) goto L16;
        r14 = SwitchKt.getUncheckedThumbDiameter();
        goto L17
    L5:
        if (r11.maxIntrinsicWidth(Constraints.getMaxHeight-impl(r12)) == 0) goto L7;
        r13 = true;
        goto L9
    }

    private static final Unit measure_3p2s80s$lambda$0(Placeable r7, ThumbNode r8, float r9, Placeable.PlacementScope r10) {
        Animatable<Float, AnimationVector1D> r11 = r8.offsetAnim;
        if (r11 == null) goto L5;
        int r12 = (int) r11.getValue().floatValue();
    L6:
        Placeable.PlacementScope.placeRelative$default(r10, r7, r12, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    L5:
        r12 = (int) r9;
        goto L6
    }
}
