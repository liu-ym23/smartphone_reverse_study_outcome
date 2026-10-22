package androidx.compose.animation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u0013\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\f\u0010&\u001a\u00020\u001f*\u00020'H\u0016J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\u001d\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bHÆ\u0003JK\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bHÆ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR%\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006/"}, d2 = {"Landroidx/compose/animation/RenderInTransitionOverlayNodeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/RenderInTransitionOverlayNode;", "sharedTransitionScope", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "renderInOverlay", "Lkotlin/Function0;", "", "zIndexInOverlay", "", "clipInOverlay", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/Path;", "<init>", "(Landroidx/compose/animation/SharedTransitionScopeImpl;Lkotlin/jvm/functions/Function0;FLkotlin/jvm/functions/Function2;)V", "getSharedTransitionScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "setSharedTransitionScope", "(Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "getRenderInOverlay", "()Lkotlin/jvm/functions/Function0;", "setRenderInOverlay", "(Lkotlin/jvm/functions/Function0;)V", "getZIndexInOverlay", "()F", "getClipInOverlay", "()Lkotlin/jvm/functions/Function2;", "create", "update", "", "node", "hashCode", "", "equals", "other", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "copy", "toString", "", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RenderInTransitionOverlayNodeElement extends ModifierNodeElement<RenderInTransitionOverlayNode> {
    public static final int $stable = 0;
    private final Function2<LayoutDirection, Density, Path> clipInOverlay;
    private Function0<Boolean> renderInOverlay;
    private SharedTransitionScopeImpl sharedTransitionScope;
    private final float zIndexInOverlay;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RenderInTransitionOverlayNodeElement copy$default(RenderInTransitionOverlayNodeElement r0, SharedTransitionScopeImpl r1, Function0 r2, float r3, Function2 r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.sharedTransitionScope;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.renderInOverlay;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.zIndexInOverlay;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.clipInOverlay;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final SharedTransitionScopeImpl component1() {
        return this.sharedTransitionScope;
    }

    public final Function0<Boolean> component2() {
        return this.renderInOverlay;
    }

    public final float component3() {
        return this.zIndexInOverlay;
    }

    public final Function2<LayoutDirection, Density, Path> component4() {
        return this.clipInOverlay;
    }

    public final RenderInTransitionOverlayNodeElement copy(SharedTransitionScopeImpl r2, Function0<Boolean> r3, float r4, Function2<? super LayoutDirection, ? super Density, ? extends Path> r5) {
        return new RenderInTransitionOverlayNodeElement(r2, r3, r4, r5);
    }

    public String toString() {
        return "RenderInTransitionOverlayNodeElement(sharedTransitionScope=" + this.sharedTransitionScope + ", renderInOverlay=" + this.renderInOverlay + ", zIndexInOverlay=" + this.zIndexInOverlay + ", clipInOverlay=" + this.clipInOverlay + ')';
    }

    public RenderInTransitionOverlayNode create() {
        return new RenderInTransitionOverlayNode(this.sharedTransitionScope, this.renderInOverlay, this.zIndexInOverlay, this.clipInOverlay);
    }

    public int hashCode() {
        return (((((this.sharedTransitionScope.hashCode() * 31) + this.renderInOverlay.hashCode()) * 31) + Float.floatToIntBits(this.zIndexInOverlay)) * 31) + this.clipInOverlay.hashCode();
    }

    public final Function2<LayoutDirection, Density, Path> getClipInOverlay() {
        return this.clipInOverlay;
    }

    public final Function0<Boolean> getRenderInOverlay() {
        return this.renderInOverlay;
    }

    public final SharedTransitionScopeImpl getSharedTransitionScope() {
        return this.sharedTransitionScope;
    }

    public final float getZIndexInOverlay() {
        return this.zIndexInOverlay;
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m191create() {
        return create();
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof RenderInTransitionOverlayNodeElement) == false) goto L17;
        RenderInTransitionOverlayNodeElement r6 = (RenderInTransitionOverlayNodeElement) r5;
        if (Intrinsics.areEqual(this.sharedTransitionScope, r6.sharedTransitionScope) == true) goto L7;
        return false;
    L7:
        if (this.renderInOverlay == r6.renderInOverlay) goto L9;
        return false;
    L9:
        if (this.zIndexInOverlay != r6.zIndexInOverlay) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == true) goto L14;
        return false;
    L14:
        if (this.clipInOverlay != r6.clipInOverlay) goto L21;
        return true;
    L21:
        return false;
    L11:
        r0 = false;
        goto L12
    L17:
        return false;
    }

    public void inspectableProperties(InspectorInfo r4) {
        r4.setName("renderInSharedTransitionOverlay");
        r4.getProperties().set("sharedTransitionScope", this.sharedTransitionScope);
        r4.getProperties().set("renderInOverlay", this.renderInOverlay);
        r4.getProperties().set("zIndexInOverlay", Float.valueOf(this.zIndexInOverlay));
        r4.getProperties().set("clipInOverlayDuringTransition", this.clipInOverlay);
    }

    public final void setRenderInOverlay(Function0<Boolean> r1) {
        this.renderInOverlay = r1;
    }

    public final void setSharedTransitionScope(SharedTransitionScopeImpl r1) {
        this.sharedTransitionScope = r1;
    }

    public void update(RenderInTransitionOverlayNode r2) {
        r2.setSharedScope(this.sharedTransitionScope);
        r2.setRenderInOverlay(this.renderInOverlay);
        r2.setZIndexInOverlay(this.zIndexInOverlay);
        r2.setClipInOverlay(this.clipInOverlay);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((RenderInTransitionOverlayNode) r1);
    }

    public RenderInTransitionOverlayNodeElement(SharedTransitionScopeImpl r1, Function0<Boolean> r2, float r3, Function2<? super LayoutDirection, ? super Density, ? extends Path> r4) {
        this.sharedTransitionScope = r1;
        this.renderInOverlay = r2;
        this.zIndexInOverlay = r3;
        this.clipInOverlay = r4;
    }
}
