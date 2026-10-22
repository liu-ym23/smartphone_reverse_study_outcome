package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/material/DelegatingThemeAwareRippleNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "<init>", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "rippleNode", "Landroidx/compose/ui/node/DelegatableNode;", "onAttach", "", "onObservedReadsChanged", "updateConfiguration", "attachNewRipple", "removeRipple", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DelegatingThemeAwareRippleNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, ObserverModifierNode {
    private final boolean bounded;
    private final ColorProducer color;
    private final InteractionSource interactionSource;
    private final float radius;
    private DelegatableNode rippleNode;

    public /* synthetic */ DelegatingThemeAwareRippleNode(InteractionSource r1, boolean r2, float r3, ColorProducer r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    public static /* synthetic */ RippleAlpha a(DelegatingThemeAwareRippleNode r0) {
        return attachNewRipple$lambda$1(r0);
    }

    public static /* synthetic */ Unit b(DelegatingThemeAwareRippleNode r0) {
        return updateConfiguration$lambda$0(r0);
    }

    private final void attachNewRipple() {
        ColorProducer r0 = new DelegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1(this);
        Function0 r1 = new c3(this);
        this.rippleNode = delegate(androidx.compose.material.ripple.RippleKt.m2269createRippleModifierNodeTDGSqEk(this.interactionSource, this.bounded, this.radius, r0, r1));
    }

    private final void removeRipple() {
        DelegatableNode r0 = this.rippleNode;
        if (r0 == null) goto L5;
        undelegate(r0);
    L5:
        this.rippleNode = null;
    }

    private final void updateConfiguration() {
        ObserverModifierNodeKt.observeReads(this, new b3(this));
    }

    public void onAttach() {
        updateConfiguration();
    }

    public void onObservedReadsChanged() {
        updateConfiguration();
    }

    public static final /* synthetic */ ColorProducer access$getColor$p(DelegatingThemeAwareRippleNode r0) {
        return r0.color;
    }

    private static final RippleAlpha attachNewRipple$lambda$1(DelegatingThemeAwareRippleNode r4) {
        RippleConfiguration r0 = (RippleConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(r4, RippleKt.getLocalRippleConfiguration());
        if (r0 == null) goto L7;
        RippleAlpha r1 = r0.getRippleAlpha();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return RippleDefaults.INSTANCE.m2136rippleAlphaDxMtmZc(((Color) CompositionLocalConsumerModifierNodeKt.currentValueOf(r4, ContentColorKt.getLocalContentColor())).unbox-impl(), ((Colors) CompositionLocalConsumerModifierNodeKt.currentValueOf(r4, ColorsKt.getLocalColors())).isLight());
    }

    private static final Unit updateConfiguration$lambda$0(DelegatingThemeAwareRippleNode r1) {
        if (((RippleConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(r1, RippleKt.getLocalRippleConfiguration())) != null) goto L6;
        r1.removeRipple();
    L9:
        return Unit.INSTANCE;
    L6:
        if (r1.rippleNode != null) goto L9;
        r1.attachNewRipple();
        goto L9
    }

    private DelegatingThemeAwareRippleNode(InteractionSource r1, boolean r2, float r3, ColorProducer r4) {
        this.interactionSource = r1;
        this.bounded = r2;
        this.radius = r3;
        this.color = r4;
    }
}
