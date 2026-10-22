package androidx.compose.material.ripple;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.DelegatableNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a=\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¨\u0006\u0016"}, d2 = {"createPlatformRippleNode", "Landroidx/compose/ui/node/DelegatableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "createPlatformRippleNode-TDGSqEk", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function0;)Landroidx/compose/ui/node/DelegatableNode;", "createAndAttachRippleContainerIfNeeded", "Landroidx/compose/material/ripple/RippleContainer;", "view", "Landroid/view/ViewGroup;", "findNearestViewGroup", "initialView", "Landroid/view/View;", "material-ripple"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Ripple_androidKt {
    public static final /* synthetic */ RippleContainer access$createAndAttachRippleContainerIfNeeded(ViewGroup r0) {
        return createAndAttachRippleContainerIfNeeded(r0);
    }

    public static final /* synthetic */ ViewGroup access$findNearestViewGroup(View r0) {
        return findNearestViewGroup(r0);
    }

    private static final RippleContainer createAndAttachRippleContainerIfNeeded(ViewGroup r4) {
        int r0 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        View r2 = r4.getChildAt(r1);
        if ((r2 instanceof RippleContainer) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return (RippleContainer) r2;
    L9:
        RippleContainer r3 = new RippleContainer(r4.getContext());
        r4.addView(r3);
        return r3;
    }

    private static final ViewGroup findNearestViewGroup(View r2) {
    L3:
        if ((r2 instanceof ViewGroup) == true) goto L10;
        ViewParent r0 = ((View) r2).getParent();
        if ((r0 instanceof View) == false) goto L8;
        Object r3 = r0;
        goto L3
    L8:
        throw new IllegalArgumentException(("Couldn't find a valid parent for " + r3 + ". Are you overriding LocalView and providing a View that is not attached to the view hierarchy?").toString());
    L10:
        return (ViewGroup) r3;
    }

    /* JADX INFO: renamed from: createPlatformRippleNode-TDGSqEk, reason: not valid java name */
    public static final DelegatableNode m2276createPlatformRippleNodeTDGSqEk(InteractionSource r8, boolean r9, float r10, ColorProducer r11, Function0<RippleAlpha> r12) {
        return new AndroidRippleNode(r8, r9, r10, r11, r12, null);
    }
}
