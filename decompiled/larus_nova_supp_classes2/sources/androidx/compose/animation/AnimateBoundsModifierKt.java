package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LookaheadScope;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\"\u0014\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"animateBounds", "Landroidx/compose/ui/Modifier;", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "modifier", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "animateMotionFrameOfReference", "", "DefaultBoundsTransform", "getDefaultBoundsTransform$annotations", "()V", "animation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AnimateBoundsModifierKt {
    private static final BoundsTransform DefaultBoundsTransform = null;

    public static /* synthetic */ FiniteAnimationSpec a(Rect r0, Rect r1) {
        return DefaultBoundsTransform$lambda$0(r0, r1);
    }

    private static /* synthetic */ void getDefaultBoundsTransform$annotations() {
    }

    static {
        DefaultBoundsTransform = new a();
    }

    private static final FiniteAnimationSpec DefaultBoundsTransform$lambda$0(Rect r1, Rect r2) {
        return AnimationSpecKt.spring(1.0f, 400.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion));
    }

    public static final Modifier animateBounds(Modifier r2, LookaheadScope r3, Modifier r4, BoundsTransform r5, boolean r6) {
        return r2.then(new BoundsAnimationElement(r3, r5, AnonymousClass1.INSTANCE, r6)).then(r4).then(new BoundsAnimationElement(r3, r5, AnonymousClass2.INSTANCE, r6));
    }

    public static /* synthetic */ Modifier animateBounds$default(Modifier r0, LookaheadScope r1, Modifier r2, BoundsTransform r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = Modifier.Companion;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = DefaultBoundsTransform;
    L9:
        if ((r5 & 8) == 0) goto L12;
        r4 = false;
    L12:
        return animateBounds(r0, r1, r2, r3, r4);
    }
}
