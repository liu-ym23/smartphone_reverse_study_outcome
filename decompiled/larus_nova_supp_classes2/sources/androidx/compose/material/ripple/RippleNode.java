package androidx.compose.material.ripple;

import androidx.collection.MutableObjectList;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B5\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016¢\u0006\u0004\b2\u00103J\b\u00104\u001a\u00020/H\u0016J\u0010\u00105\u001a\u00020/2\u0006\u00106\u001a\u00020-H\u0002J\f\u00107\u001a\u00020/*\u000208H\u0016J\f\u00109\u001a\u00020/*\u00020:H&J'\u0010;\u001a\u00020/2\u0006\u0010<\u001a\u00020=2\u0006\u00100\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001cH&¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u00020/2\u0006\u0010<\u001a\u00020=H&J\u0018\u0010A\u001a\u00020/2\u0006\u0010<\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"@BX\u0084\u000e¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0011\u0010'\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010%R\u000e\u0010*\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Landroidx/compose/material/ripple/RippleNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "<init>", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBounded", "()Z", "F", "getRippleAlpha", "()Lkotlin/jvm/functions/Function0;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "stateLayer", "Landroidx/compose/material/ripple/StateLayer;", "targetRadius", "", "getTargetRadius", "()F", "setTargetRadius", "(F)V", "value", "Landroidx/compose/ui/geometry/Size;", "rippleSize", "getRippleSize-NH-jbRc", "()J", "J", "rippleColor", "Landroidx/compose/ui/graphics/Color;", "getRippleColor-0d7_KjU", "hasValidSize", "pendingInteractions", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/foundation/interaction/PressInteraction;", "onRemeasured", "", "size", "Landroidx/compose/ui/unit/IntSize;", "onRemeasured-ozmzZPI", "(J)V", "onAttach", "handlePressInteraction", "pressInteraction", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawRipples", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "addRipple", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "addRipple-12SF9DM", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;JF)V", "removeRipple", "updateStateLayer", "Landroidx/compose/foundation/interaction/Interaction;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class RippleNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, DrawModifierNode, LayoutAwareModifierNode {
    public static final int $stable = 8;
    private final boolean bounded;
    private final ColorProducer color;
    private boolean hasValidSize;
    private final InteractionSource interactionSource;
    private final MutableObjectList<PressInteraction> pendingInteractions;
    private final float radius;
    private final Function0<RippleAlpha> rippleAlpha;
    private long rippleSize;
    private final boolean shouldAutoInvalidate;
    private StateLayer stateLayer;
    private float targetRadius;

    /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleNode$onAttach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.ripple.RippleNode$onAttach$1", f = "Ripple.kt", i = {}, l = {364}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RippleNode this$0;

        public AnonymousClass1(RippleNode r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
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
            Flow<Interaction> r2 = RippleNode.access$getInteractionSource$p(this.this$0).getInteractions();
            final RippleNode r4 = this.this$0;
            FlowCollector r3 = new C00641(r4, r7);
            this.label = 1;
            if (r2.collect(r3, this) != r0) goto L12;
            return r0;
        }
    }

    public /* synthetic */ RippleNode(InteractionSource r1, boolean r2, float r3, ColorProducer r4, Function0 r5, DefaultConstructorMarker r6) {
        this(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: addRipple-12SF9DM */
    public abstract void mo2259addRipple12SF9DM(PressInteraction.Press r1, long r2, float r4);

    public abstract void drawRipples(DrawScope r1);

    public final /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.-CC.$default$onMeasureResultChanged(this);
    }

    public final /* synthetic */ void onPlaced(LayoutCoordinates r1) {
        LayoutAwareModifierNode.-CC.$default$onPlaced(this, r1);
    }

    public abstract void removeRipple(PressInteraction.Press r1);

    /* JADX INFO: renamed from: getRippleColor-0d7_KjU, reason: not valid java name */
    public final long m2271getRippleColor0d7_KjU() {
        return this.color.invoke-0d7_KjU();
    }

    public void onAttach() {
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final boolean getBounded() {
        return this.bounded;
    }

    public final Function0<RippleAlpha> getRippleAlpha() {
        return this.rippleAlpha;
    }

    /* JADX INFO: renamed from: getRippleSize-NH-jbRc, reason: not valid java name */
    public final long m2272getRippleSizeNHjbRc() {
        return this.rippleSize;
    }

    public final boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public final float getTargetRadius() {
        return this.targetRadius;
    }

    public static final /* synthetic */ boolean access$getHasValidSize$p(RippleNode r0) {
        return r0.hasValidSize;
    }

    public static final /* synthetic */ InteractionSource access$getInteractionSource$p(RippleNode r0) {
        return r0.interactionSource;
    }

    public static final /* synthetic */ MutableObjectList access$getPendingInteractions$p(RippleNode r0) {
        return r0.pendingInteractions;
    }

    private final void handlePressInteraction(PressInteraction r4) {
        if ((r4 instanceof PressInteraction.Press) == false) goto L6;
        mo2259addRipple12SF9DM((PressInteraction.Press) r4, this.rippleSize, this.targetRadius);
        return;
    L6:
        if ((r4 instanceof PressInteraction.Release) == false) goto L9;
        removeRipple(((PressInteraction.Release) r4).getPress());
        return;
    L9:
        if ((r4 instanceof PressInteraction.Cancel) == false) goto L14;
        removeRipple(((PressInteraction.Cancel) r4).getPress());
        return;
    }

    public void draw(ContentDrawScope r5) {
        r5.drawContent();
        StateLayer r0 = this.stateLayer;
        if (r0 == null) goto L5;
        r0.m2277drawStateLayermxwnekA(r5, this.targetRadius, m2271getRippleColor0d7_KjU());
    L5:
        drawRipples(r5);
    }

    /* JADX INFO: renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    public void m2273onRemeasuredozmzZPI(long r4) {
        this.hasValidSize = true;
        Density r0 = DelegatableNodeKt.requireDensity(this);
        this.rippleSize = IntSizeKt.toSize-ozmzZPI(r4);
        if (Float.isNaN(this.radius) == false) goto L5;
        float r5 = RippleAnimationKt.m2264getRippleEndRadiuscSwnlzA(r0, this.bounded, this.rippleSize);
    L6:
        this.targetRadius = r5;
        MutableObjectList<PressInteraction> r6 = this.pendingInteractions;
        Object[] r7 = r6.content;
        int r8 = r6._size;
        int r1 = 0;
    L7:
        if (r1 >= r8) goto L9;
        handlePressInteraction((PressInteraction) r7[r1]);
        r1 = r1 + 1;
        goto L7
    L9:
        this.pendingInteractions.clear();
        return;
    L5:
        r5 = r0.toPx-0680j_4(this.radius);
        goto L6
    }

    public final void setTargetRadius(float r1) {
        this.targetRadius = r1;
    }

    public static final /* synthetic */ void access$handlePressInteraction(RippleNode r0, PressInteraction r1) {
        r0.handlePressInteraction(r1);
    }

    private final void updateStateLayer(Interaction r4, CoroutineScope r5) {
        StateLayer r0 = this.stateLayer;
        if (r0 != null) goto L5;
        r0 = new StateLayer(this.bounded, this.rippleAlpha);
        DrawModifierNodeKt.invalidateDraw(this);
        this.stateLayer = r0;
    L5:
        r0.handleInteraction$material_ripple(r4, r5);
    }

    public static final /* synthetic */ void access$updateStateLayer(RippleNode r0, Interaction r1, CoroutineScope r2) {
        r0.updateStateLayer(r1, r2);
    }

    private RippleNode(InteractionSource r1, boolean r2, float r3, ColorProducer r4, Function0<RippleAlpha> r5) {
        this.interactionSource = r1;
        this.bounded = r2;
        this.radius = r3;
        this.color = r4;
        this.rippleAlpha = r5;
        this.rippleSize = Size.Companion.getZero-NH-jbRc();
        this.pendingInteractions = new MutableObjectList(0, 1, null);
    }
}
