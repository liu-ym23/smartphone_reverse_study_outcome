package androidx.compose.animation;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00014BA\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0004\b\u0010\u0010\u0011J\f\u0010)\u001a\u00020**\u00020+H\u0016J\b\u00102\u001a\u00020*H\u0016J\b\u00103\u001a\u00020*H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR+\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0013\u0010%\u001a\u0004\u0018\u00010&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0013\u0010,\u001a\u0004\u0018\u00010-8F¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\b\u0018\u000101R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Landroidx/compose/animation/RenderInTransitionOverlayNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "sharedScope", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "renderInOverlay", "Lkotlin/Function0;", "", "zIndexInOverlay", "", "clipInOverlay", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/Path;", "<init>", "(Landroidx/compose/animation/SharedTransitionScopeImpl;Lkotlin/jvm/functions/Function0;FLkotlin/jvm/functions/Function2;)V", "getSharedScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "setSharedScope", "(Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "getRenderInOverlay", "()Lkotlin/jvm/functions/Function0;", "setRenderInOverlay", "(Lkotlin/jvm/functions/Function0;)V", "getClipInOverlay", "()Lkotlin/jvm/functions/Function2;", "setClipInOverlay", "(Lkotlin/jvm/functions/Function2;)V", "<set-?>", "getZIndexInOverlay", "()F", "setZIndexInOverlay", "(F)V", "zIndexInOverlay$delegate", "Landroidx/compose/runtime/MutableFloatState;", "parentState", "Landroidx/compose/animation/SharedElementInternalState;", "getParentState", "()Landroidx/compose/animation/SharedElementInternalState;", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layerWithRenderer", "Landroidx/compose/animation/RenderInTransitionOverlayNode$LayerWithRenderer;", "onAttach", "onDetach", "LayerWithRenderer", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RenderInTransitionOverlayNode extends Modifier.Node implements DrawModifierNode, ModifierLocalModifierNode {
    public static final int $stable = 8;
    private Function2<? super LayoutDirection, ? super Density, ? extends Path> clipInOverlay;
    private LayerWithRenderer layerWithRenderer;
    private Function0<Boolean> renderInOverlay;
    private SharedTransitionScopeImpl sharedScope;
    private final MutableFloatState zIndexInOverlay$delegate;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Landroidx/compose/animation/RenderInTransitionOverlayNode$LayerWithRenderer;", "Landroidx/compose/animation/LayerRenderer;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "<init>", "(Landroidx/compose/animation/RenderInTransitionOverlayNode;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentState", "Landroidx/compose/animation/SharedElementInternalState;", "getParentState", "()Landroidx/compose/animation/SharedElementInternalState;", "zIndex", "", "getZIndex", "()F", "drawInOverlay", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class LayerWithRenderer implements LayerRenderer {
        private final GraphicsLayer layer;
        final /* synthetic */ RenderInTransitionOverlayNode this$0;

        @Override // androidx.compose.animation.LayerRenderer
        public SharedElementInternalState getParentState() {
            return this.this$0.getParentState();
        }

        @Override // androidx.compose.animation.LayerRenderer
        public float getZIndex() {
            return this.this$0.getZIndexInOverlay();
        }

        public final GraphicsLayer getLayer() {
            return this.layer;
        }

        @Override // androidx.compose.animation.LayerRenderer
        public void drawInOverlay(DrawScope r9) {
            if (((Boolean) this.this$0.getRenderInOverlay().invoke()).booleanValue() == false) goto L23;
            RenderInTransitionOverlayNode r0 = this.this$0;
            long r1 = r0.getSharedScope().getRoot$animation().localPositionOf-R5De75A(DelegatableNodeKt.requireLayoutCoordinates(r0), Offset.Companion.getZero-F1C5BW0());
            float r3 = Float.intBitsToFloat((int) (r1 >> 32));
            float r2 = Float.intBitsToFloat((int) (r1 & 4294967295L));
            Path r4 = (Path) r0.getClipInOverlay().invoke(r9.getLayoutDirection(), DelegatableNodeKt.requireDensity(r0));
            if (r4 == null) goto L17;
            int r5 = ClipOp.Companion.getIntersect-rtfAjoo();
            DrawContext r6 = r9.getDrawContext();
            long r7 = r6.getSize-NH-jbRc();
            r6.getCanvas().save();
            r6.getTransform().clipPath-mtrdD-E(r4, r5);     // Catch: Throwable -> L14
            r9.getDrawContext().getTransform().translate(r3, r2);     // Catch: Throwable -> L14
            GraphicsLayerKt.drawLayer(r9, this.layer);     // Catch: Throwable -> L11
            r9.getDrawContext().getTransform().translate(-r3, -r2);     // Catch: Throwable -> L14
            r6.getCanvas().restore();
            r6.setSize-uvyYCjk(r7);
            return;
        L11:
            th = move-exception;
            r9.getDrawContext().getTransform().translate(-r3, -r2);     // Catch: Throwable -> L14
            throw th;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            r6.getCanvas().restore();
            r6.setSize-uvyYCjk(r7);
            throw th;
        L17:
            r9.getDrawContext().getTransform().translate(r3, r2);
            GraphicsLayerKt.drawLayer(r9, this.layer);     // Catch: Throwable -> L20
            r9.getDrawContext().getTransform().translate(-r3, -r2);
            return;
        L20:
            th = move-exception;
            r9.getDrawContext().getTransform().translate(-r3, -r2);
            throw th;
        }

        public LayerWithRenderer(RenderInTransitionOverlayNode r1, GraphicsLayer r2) {
            this.this$0 = r1;
            this.layer = r2;
        }
    }

    public final /* synthetic */ Object getCurrent(ModifierLocal r1) {
        return ModifierLocalModifierNode.-CC.$default$getCurrent(this, r1);
    }

    public final /* synthetic */ ModifierLocalMap getProvidedValues() {
        return ModifierLocalModifierNode.-CC.$default$getProvidedValues(this);
    }

    public final /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.-CC.$default$onMeasureResultChanged(this);
    }

    public final /* synthetic */ void provide(ModifierLocal r1, Object r2) {
        ModifierLocalModifierNode.-CC.$default$provide(this, r1, r2);
    }

    public final GraphicsLayer getLayer() {
        LayerWithRenderer r0 = this.layerWithRenderer;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLayer();
    }

    public final float getZIndexInOverlay() {
        return this.zIndexInOverlay$delegate.getFloatValue();
    }

    public void onAttach() {
        LayerWithRenderer r0 = new LayerWithRenderer(this, DelegatableNodeKt.requireGraphicsContext(this).createGraphicsLayer());
        this.sharedScope.onLayerRendererCreated$animation(r0);
        this.layerWithRenderer = r0;
    }

    public void onDetach() {
        LayerWithRenderer r0 = this.layerWithRenderer;
        if (r0 == null) goto L6;
        this.sharedScope.onLayerRendererRemoved$animation(r0);
        DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(r0.getLayer());
        return;
    }

    public final SharedElementInternalState getParentState() {
        return (SharedElementInternalState) ModifierLocalModifierNode.-CC.$default$getCurrent(this, SharedContentNodeKt.getModifierLocalSharedElementInternalState());
    }

    public final Function2<LayoutDirection, Density, Path> getClipInOverlay() {
        return this.clipInOverlay;
    }

    public final Function0<Boolean> getRenderInOverlay() {
        return this.renderInOverlay;
    }

    public final SharedTransitionScopeImpl getSharedScope() {
        return this.sharedScope;
    }

    public void draw(final ContentDrawScope r9) {
        GraphicsLayer r7 = getLayer();
        if (r7 == null) goto L9;
        DrawScope.-CC.record-JVtK1S4$default(r9, r7, 0, new AnonymousClass1(r9), 1, null);
        if (((Boolean) this.renderInOverlay.invoke()).booleanValue() == true) goto L10;
        GraphicsLayerKt.drawLayer(r9, r7);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Error: layer never initialized".toString());
    }

    public final void setClipInOverlay(Function2<? super LayoutDirection, ? super Density, ? extends Path> r1) {
        this.clipInOverlay = r1;
    }

    public final void setRenderInOverlay(Function0<Boolean> r1) {
        this.renderInOverlay = r1;
    }

    public final void setSharedScope(SharedTransitionScopeImpl r1) {
        this.sharedScope = r1;
    }

    public final void setZIndexInOverlay(float r2) {
        this.zIndexInOverlay$delegate.setFloatValue(r2);
    }

    public RenderInTransitionOverlayNode(SharedTransitionScopeImpl r1, Function0<Boolean> r2, float r3, Function2<? super LayoutDirection, ? super Density, ? extends Path> r4) {
        this.sharedScope = r1;
        this.renderInOverlay = r2;
        this.clipInOverlay = r4;
        this.zIndexInOverlay$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(r3);
    }
}
