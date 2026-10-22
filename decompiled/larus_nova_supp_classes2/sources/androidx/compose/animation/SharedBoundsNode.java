package androidx.compose.animation;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.ApproachIntrinsicMeasureScope;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001a\u001a\u00020\u000fH\u0002J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020,H\u0016J#\u00100\u001a\u000201*\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J\u0014\u00109\u001a\u00020,*\u00020:2\u0006\u0010;\u001a\u00020<H\u0002J\u0014\u0010=\u001a\u00020,*\u00020:2\u0006\u0010;\u001a\u00020<H\u0002J\u0014\u0010>\u001a\u000201*\u0002022\u0006\u0010;\u001a\u00020<H\u0002J\u0017\u0010?\u001a\u00020\u00132\u0006\u0010@\u001a\u00020AH\u0016¢\u0006\u0004\bB\u0010CJ#\u0010D\u001a\u000201*\u00020E2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016¢\u0006\u0004\bF\u0010GJ\f\u0010H\u001a\u00020,*\u00020IH\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\tR\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006J"}, d2 = {"Landroidx/compose/animation/SharedBoundsNode;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/animation/BoundsProvider;", "state", "Landroidx/compose/animation/SharedElementInternalState;", "<init>", "(Landroidx/compose/animation/SharedElementInternalState;)V", "lastBoundsInSharedTransitionScope", "Landroidx/compose/ui/geometry/Rect;", "getLastBoundsInSharedTransitionScope", "()Landroidx/compose/ui/geometry/Rect;", "approachCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getApproachCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "isPlaced", "", "rootCoords", "getRootCoords", "value", "getState", "()Landroidx/compose/animation/SharedElementInternalState;", "setState$animation", "requireLookaheadLayoutCoordinates", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "getBoundsAnimation", "()Landroidx/compose/animation/BoundsAnimation;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "setLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "sharedElement", "Landroidx/compose/animation/SharedElement;", "getSharedElement", "()Landroidx/compose/animation/SharedElement;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "setup", "", "onAttach", "onDetach", "onReset", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "approachPlaceMatchBeyondTransition", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "approachPlaceMatchInTransition", "approachPlace", "isMeasurementApproachInProgress", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "approachMeasure", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SharedBoundsNode extends Modifier.Node implements ApproachLayoutModifierNode, DrawModifierNode, ModifierLocalModifierNode, BoundsProvider {
    public static final int $stable = 8;
    private boolean isPlaced;
    private GraphicsLayer layer;
    private final ModifierLocalMap providedValues;
    private SharedElementInternalState state;

    public final /* synthetic */ Object getCurrent(ModifierLocal r1) {
        return ModifierLocalModifierNode.-CC.$default$getCurrent(this, r1);
    }

    public final /* synthetic */ boolean isPlacementApproachInProgress(Placeable.PlacementScope r1, LayoutCoordinates r2) {
        return ApproachLayoutModifierNode.-CC.$default$isPlacementApproachInProgress(this, r1, r2);
    }

    public final /* synthetic */ int maxApproachIntrinsicHeight(ApproachIntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return ApproachLayoutModifierNode.-CC.$default$maxApproachIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int maxApproachIntrinsicWidth(ApproachIntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return ApproachLayoutModifierNode.-CC.$default$maxApproachIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifierNode.-CC.$default$maxIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifierNode.-CC.$default$maxIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ int minApproachIntrinsicHeight(ApproachIntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return ApproachLayoutModifierNode.-CC.$default$minApproachIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int minApproachIntrinsicWidth(ApproachIntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return ApproachLayoutModifierNode.-CC.$default$minApproachIntrinsicWidth(this, r1, r2, r3);
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

    public final /* synthetic */ void provide(ModifierLocal r1, Object r2) {
        ModifierLocalModifierNode.-CC.$default$provide(this, r1, r2);
    }

    private final BoundsAnimation getBoundsAnimation() {
        return this.state.getBoundsAnimation();
    }

    private final SharedElement getSharedElement() {
        return this.state.getSharedElement();
    }

    private final LayoutCoordinates requireLookaheadLayoutCoordinates() {
        return this.state.getSharedElement().getScope().toLookaheadCoordinates(DelegatableNodeKt.requireLayoutCoordinates(this));
    }

    private final LayoutCoordinates getApproachCoordinates() {
        return DelegatableNodeKt.requireLayoutCoordinates(this);
    }

    private final LayoutCoordinates getRootCoords() {
        return getSharedElement().getScope().getRoot$animation();
    }

    private final void setup() {
        ModifierLocalModifierNode.-CC.$default$provide(this, SharedContentNodeKt.getModifierLocalSharedElementInternalState(), this.state);
        this.state.setParentState((SharedElementInternalState) ModifierLocalModifierNode.-CC.$default$getCurrent(this, SharedContentNodeKt.getModifierLocalSharedElementInternalState()));
        setLayer(DelegatableNodeKt.requireGraphicsContext(this).createGraphicsLayer());
        this.isPlaced = false;
        this.state.setBoundsProvider(this);
    }

    @Override // androidx.compose.animation.BoundsProvider
    public Rect getLastBoundsInSharedTransitionScope() {
        if (isAttached() == true) goto L5;
        return null;
    L5:
        if (this.isPlaced == true) goto L8;
        return null;
    L8:
        return RectKt.Rect-tz77jQw(LayoutCoordinates.-CC.localPositionOf-S_NoaFU$default(getRootCoords(), getApproachCoordinates(), 0, false, 6, null), IntSizeKt.toSize-ozmzZPI(getApproachCoordinates().getSize-YbymL2g()));
    }

    public void onAttach() {
        super.onAttach();
        setup();
    }

    public void onDetach() {
        super.onDetach();
        setLayer(null);
        this.state.setParentState(null);
        this.state.setBoundsProvider(null);
        this.isPlaced = false;
    }

    public void onReset() {
        super.onReset();
        GraphicsLayer r0 = this.layer;
        if (r0 == null) goto L5;
        DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(r0);
    L5:
        setLayer(DelegatableNodeKt.requireGraphicsContext(this).createGraphicsLayer());
    }

    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    public final SharedElementInternalState getState() {
        return this.state;
    }

    public SharedBoundsNode(SharedElementInternalState r2) {
        this.state = r2;
        this.layer = r2.getLayer();
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(SharedContentNodeKt.getModifierLocalSharedElementInternalState(), r2));
    }

    public static final /* synthetic */ SharedElement access$getSharedElement(SharedBoundsNode r0) {
        return r0.getSharedElement();
    }

    private final void setLayer(GraphicsLayer r3) {
        if (r3 != null) goto L6;
        GraphicsLayer r0 = this.layer;
        if (r0 == null) goto L7;
        DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(r0);
    L7:
        this.layer = r3;
        return;
    L6:
        this.state.setLayer(r3);
        goto L7
    }

    public void draw(final ContentDrawScope r9) {
        SharedElementInternalState r0 = this.state;
        if (getSharedElement().getFoundMatch() == true) goto L5;
    L7:
        Path r1 = null;
    L8:
        r0.setClipPathInOverlay$animation(r1);
        GraphicsLayer r2 = this.state.getLayer();
        if (r2 == null) goto L15;
        DrawScope.-CC.record-JVtK1S4$default(r9, r2, 0, new C01031(r9, this), 1, null);
        if (this.state.getShouldRenderInPlace() == false) goto L16;
        GraphicsLayerKt.drawLayer(r9, r2);
        return;
    L16:
        return;
    L15:
        throw new IllegalArgumentException(("Error: Layer is null when accessed for shared bounds/element : " + getSharedElement().getKey() + ",target: " + this.state.getBoundsAnimation().getTarget() + ", is attached: " + isAttached()).toString());
    L5:
        if (getSharedElement().getCurrentBoundsWhenMatched() == null) goto L7;
        SharedTransitionScope.OverlayClip r3 = this.state.getOverlayClip();
        SharedTransitionScope.SharedContentState r4 = this.state.getUserState();
        Rect r5 = getSharedElement().getCurrentBoundsWhenMatched();
        Intrinsics.checkNotNull(r5);
        r1 = r3.getClipPath(r4, r5, r9.getLayoutDirection(), DelegatableNodeKt.requireDensity(this));
        goto L8
    }

    /* JADX INFO: renamed from: isMeasurementApproachInProgress-ozmzZPI, reason: not valid java name */
    public boolean m197isMeasurementApproachInProgressozmzZPI(long r1) {
        if (getSharedElement().getFoundMatch() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.state.getSharedElement().getScope().isTransitionActive() == false) goto L7;
        return true;
    }

    public final void setState$animation(SharedElementInternalState r2) {
        if (Intrinsics.areEqual(r2, this.state) == true) goto L8;
        this.state = r2;
        if (isAttached() == false) goto L9;
        setup();
        return;
    L9:
        return;
    }

    private final MeasureResult approachPlace(MeasureScope r21, final Placeable r22) {
        this.isPlaced = true;
        if (getSharedElement().getFoundMatch() == true) goto L7;
        getSharedElement().setCurrentBoundsWhenMatched(null);
        return MeasureScope.-CC.layout$default(r21, r22.getWidth(), r22.getHeight(), null, new AnonymousClass1(r22), 4, null);
    L7:
        if (getSharedElement().getScope().isTransitionActive() == false) goto L9;
        SharedTransitionScope.PlaceHolderSize r2 = this.state.getPlaceHolderSize();
        long r3 = requireLookaheadLayoutCoordinates().getSize-YbymL2g();
        int r5 = r22.getWidth();
        long r4 = r2.mo202calculateSizeJyjRU_E(r3, IntSize.constructor-impl((((long) r5) << 32) | (((long) r22.getHeight()) & 4294967295L)));
        return MeasureScope.-CC.layout$default(r21, (int) (r4 >> 32), (int) (r4 & 4294967295L), null, new AnonymousClass3(this, r22), 4, null);
    L9:
        return MeasureScope.-CC.layout$default(r21, r22.getWidth(), r22.getHeight(), null, new AnonymousClass2(this, r22), 4, null);
    }

    private final void approachPlaceMatchBeyondTransition(Placeable.PlacementScope r17, Placeable r18) {
        if (getBoundsAnimation().getTarget() == true) goto L13;
        Rect r0 = getSharedElement().getCurrentBoundsWhenMatched();
        if (r0 == null) goto L11;
        LayoutCoordinates r1 = r17.getCoordinates();
        if (r1 == null) goto L9;
        long r2 = getRootCoords().localPositionOf-R5De75A(r1, Offset.Companion.getZero-F1C5BW0());
        long r3 = IntOffsetKt.round-k-4lQ0M(Offset.minus-MK-Hz9U(r0.getTopLeft-F1C5BW0(), r2));
    L10:
        Placeable.PlacementScope.place$default(r17, r18, IntOffset.getX-impl(r3), IntOffset.getY-impl(r3), MenuKt.ClosedAlphaTarget, 4, null);
        return;
    L9:
        r3 = IntOffset.Companion.getZero-nOcc-ac();
        goto L10
    L11:
        Placeable.PlacementScope.place$default(r17, r18, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return;
    L13:
        if (getBoundsAnimation().getTarget() == false) goto L15;
    L16:
        Placeable.PlacementScope.place$default(r17, r18, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return;
    L15:
        if (getSharedElement().getFoundMatch() == false) goto L16;
    }

    private final void approachPlaceMatchInTransition(Placeable.PlacementScope r15, Placeable r16) {
        LayoutCoordinates r0 = r15.getCoordinates();
        if (r0 != null) goto L6;
        Placeable.PlacementScope.place$default(r15, r16, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return;
    L6:
        long r1 = getRootCoords().localPositionOf-R5De75A(r0, Offset.Companion.getZero-F1C5BW0());
        if (getSharedElement().getTargetData$animation() == null) goto L12;
        Rect r3 = getSharedElement().getCurrentBoundsWhenMatched();
        if (r3 != null) goto L11;
        float r4 = r16.getWidth();
        float r7 = r16.getHeight();
        r3 = RectKt.Rect-tz77jQw(r1, Size.constructor-impl((Float.floatToRawIntBits(r4) << 32) | (Float.floatToRawIntBits(r7) & 4294967295L)));
    L11:
        BoundsAnimation r8 = getBoundsAnimation();
        TargetData r9 = getSharedElement().getTargetData$animation();
        Intrinsics.checkNotNull(r9);
        r8.animate(r3, SharedElementKt.getTargetBounds(r9));
    L12:
        Rect r5 = getBoundsAnimation().getValue();
        if (r5 == null) goto L15;
        TargetData r10 = getSharedElement().getTargetData$animation();
        Intrinsics.checkNotNull(r10);
        Offset r11 = Offset.box-impl(SharedElementKt.calculateOffsetFromDirectManipulation(r10, r5));
    L17:
        if (getBoundsAnimation().getTarget() == false) goto L25;
        if (r11 == null) goto L20;
        long r12 = r11.unbox-impl();
    L21:
        if (r11 != null) goto L23;
        Rect r2 = RectKt.Rect-tz77jQw(r1, IntSizeKt.toSize-ozmzZPI(r0.getSize-YbymL2g()));
    L24:
        getSharedElement().setCurrentBoundsWhenMatched(r2);
    L29:
        long r6 = Offset.minus-MK-Hz9U(r12, r1);
        Placeable.PlacementScope.place$default(r15, r16, Math.round(Float.intBitsToFloat((int) (r6 >> 32))), Math.round(Float.intBitsToFloat((int) (r6 & 4294967295L))), MenuKt.ClosedAlphaTarget, 4, null);
        return;
    L23:
        r2 = RectKt.Rect-tz77jQw(r11.unbox-impl(), r5.getSize-NH-jbRc());
        goto L24
    L20:
        r12 = r1;
        goto L21
    L25:
        if (r11 == null) goto L27;
        long r13 = r11.unbox-impl();
    L28:
        r12 = r13;
        goto L29
    L27:
        Rect r14 = getSharedElement().getCurrentBoundsWhenMatched();
        Intrinsics.checkNotNull(r14);
        r13 = r14.getTopLeft-F1C5BW0();
        goto L28
    L15:
        r11 = null;
        goto L17
    }

    public static final /* synthetic */ void access$approachPlaceMatchBeyondTransition(SharedBoundsNode r0, Placeable.PlacementScope r1, Placeable r2) {
        r0.approachPlaceMatchBeyondTransition(r1, r2);
    }

    public static final /* synthetic */ void access$approachPlaceMatchInTransition(SharedBoundsNode r0, Placeable.PlacementScope r1, Placeable r2) {
        r0.approachPlaceMatchInTransition(r1, r2);
    }

    /* JADX INFO: renamed from: approachMeasure-3p2s80s, reason: not valid java name */
    public MeasureResult m196approachMeasure3p2s80s(ApproachMeasureScope r5, Measurable r6, long r7) {
        if (getSharedElement().getFoundMatch() == false) goto L19;
        Rect r0 = getBoundsAnimation().getValue();
        if (r0 != null) goto L8;
        r0 = getSharedElement().tryInitializingCurrentBounds();
    L8:
        if (r0 == null) goto L19;
        long r8 = IntSizeKt.roundToIntSize-uvyYCjk(r0.getSize-NH-jbRc());
        int r1 = (int) (r8 >> 32);
        int r9 = (int) (r8 & 4294967295L);
        if (r1 == Integer.MAX_VALUE) goto L13;
        if (r9 == Integer.MAX_VALUE) goto L13;
        boolean r10 = true;
    L14:
        if (r10 == false) goto L17;
        r7 = Constraints.Companion.fixed-JhjzzOo(RangesKt.coerceAtLeast(r1, 0), RangesKt.coerceAtLeast(r9, 0));
        goto L19
    L17:
        throw new IllegalArgumentException(("Error: Infinite width/height is invalid. animated bounds: " + getBoundsAnimation().getValue() + ", current bounds: " + getSharedElement().getCurrentBoundsWhenMatched()).toString());
    L13:
        r10 = false;
    L19:
        return approachPlace(r5, r6.measure-BRTryo0(r7));
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m198measure3p2s80s(MeasureScope r8, Measurable r9, long r10) {
        final Placeable r11 = r9.measure-BRTryo0(r10);
        return MeasureScope.-CC.layout$default(r8, r11.getWidth(), r11.getHeight(), null, new SharedBoundsNode$measure$1(r11, this), 4, null);
    }
}
