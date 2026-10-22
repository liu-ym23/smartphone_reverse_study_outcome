package androidx.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.StartOffset;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aO\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001aE\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a&\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u00182\u0006\u0010\n\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0003H\u0002\u001a\u0015\u0010\u0019\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"basicMarquee", "Landroidx/compose/ui/Modifier;", "iterations", "", "animationMode", "Landroidx/compose/foundation/MarqueeAnimationMode;", "repeatDelayMillis", "initialDelayMillis", "spacing", "Landroidx/compose/foundation/MarqueeSpacing;", "velocity", "Landroidx/compose/ui/unit/Dp;", "basicMarquee-1Mj1MLw", "(Landroidx/compose/ui/Modifier;IIIILandroidx/compose/foundation/MarqueeSpacing;F)Landroidx/compose/ui/Modifier;", "createMarqueeAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "targetValue", "delayMillis", "density", "Landroidx/compose/ui/unit/Density;", "createMarqueeAnimationSpec-Z4HSEVQ", "(IFIIFLandroidx/compose/ui/unit/Density;)Landroidx/compose/animation/core/AnimationSpec;", "velocityBasedTween", "Landroidx/compose/animation/core/TweenSpec;", "MarqueeSpacing", "MarqueeSpacing-0680j_4", "(F)Landroidx/compose/foundation/MarqueeSpacing;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BasicMarqueeKt {
    public static /* synthetic */ int a(float r0, Density r1, int r2, int r3) {
        return MarqueeSpacing_0680j_4$lambda$1(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: MarqueeSpacing-0680j_4, reason: not valid java name */
    public static final MarqueeSpacing m345MarqueeSpacing0680j_4(final float r1) {
        return new l(r1);
    }

    private static final TweenSpec<Float> velocityBasedTween(float r1, float r2, int r3) {
        return AnimationSpecKt.tween((int) Math.ceil(r2 / (r1 / 1000.0f)), r3, EasingKt.getLinearEasing());
    }

    private static final int MarqueeSpacing_0680j_4$lambda$1(float r0, Density r1, int r2, int r3) {
        return r1.roundToPx-0680j_4(r0);
    }

    /* JADX INFO: renamed from: access$createMarqueeAnimationSpec-Z4HSEVQ, reason: not valid java name */
    public static final /* synthetic */ AnimationSpec m346access$createMarqueeAnimationSpecZ4HSEVQ(int r0, float r1, int r2, int r3, float r4, Density r5) {
        return m349createMarqueeAnimationSpecZ4HSEVQ(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: createMarqueeAnimationSpec-Z4HSEVQ, reason: not valid java name */
    private static final AnimationSpec<Float> m349createMarqueeAnimationSpecZ4HSEVQ(int r7, float r8, int r9, int r10, float r11, Density r12) {
        TweenSpec<Float> r1 = velocityBasedTween(Math.abs(r12.toPx-0680j_4(r11)), r8, r10);
        long r3 = StartOffset.m282constructorimpl$default((-r10) + r9, 0, 2, null);
        if (r7 != Integer.MAX_VALUE) goto L6;
        return AnimationSpecKt.m249infiniteRepeatable9IiC70o$default(r1, null, r3, 2, null);
    L6:
        return AnimationSpecKt.m251repeatable91I0pcU$default(r7, r1, null, r3, 4, null);
    }

    /* JADX INFO: renamed from: basicMarquee-1Mj1MLw, reason: not valid java name */
    public static final Modifier m347basicMarquee1Mj1MLw(Modifier r9, int r10, int r11, int r12, int r13, MarqueeSpacing r14, float r15) {
        return r9.then(new MarqueeModifierElement(r10, r11, r12, r13, r14, r15, null));
    }

    /* JADX INFO: renamed from: basicMarquee-1Mj1MLw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m348basicMarquee1Mj1MLw$default(Modifier r4, int r5, int r6, int r7, int r8, MarqueeSpacing r9, float r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = MarqueeDefaults.INSTANCE.getIterations();
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = MarqueeAnimationMode.Companion.m433getImmediatelyZbEOnfQ();
    L8:
        int r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = MarqueeDefaults.INSTANCE.getRepeatDelayMillis();
    L11:
        int r0 = r7;
        if ((r11 & 8) != 0) goto L14;
    L17:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L20;
        r9 = MarqueeDefaults.INSTANCE.getSpacing();
    L20:
        MarqueeSpacing r2 = r9;
        if ((r11 & 32) == 0) goto L23;
        r10 = MarqueeDefaults.INSTANCE.m435getVelocityD9Ej5fM();
    L23:
        int r14 = r5;
        return m347basicMarquee1Mj1MLw(r4, r14, r13, r0, r1, r2, r10);
    L14:
        if (MarqueeAnimationMode.m429equalsimpl0(r13, MarqueeAnimationMode.Companion.m433getImmediatelyZbEOnfQ()) == false) goto L16;
        r8 = r0;
        goto L17
    L16:
        r8 = 0;
        goto L17
    }
}
