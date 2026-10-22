package androidx.compose.animation;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u001aV\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032:\b\u0002\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u001a`\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\f\u001a\u00020\r2:\b\u0002\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\"\u0016\u0010\u000e\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010\"\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"animateContentSize", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntSize;", "finishedListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "initialValue", "targetValue", "", "alignment", "Landroidx/compose/ui/Alignment;", "InvalidSize", "getInvalidSize", "()J", "J", "isValid", "", "isValid-ozmzZPI", "(J)Z", "animation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AnimationModifierKt {
    private static final long InvalidSize = 0;

    static {
        long r0 = RtlSpacingHelper.UNDEFINED;
        InvalidSize = IntSize.constructor-impl((r0 & 4294967295L) | (r0 << 32));
    }

    public static final long getInvalidSize() {
        return InvalidSize;
    }

    /* JADX INFO: renamed from: isValid-ozmzZPI, reason: not valid java name */
    public static final boolean m148isValidozmzZPI(long r2) {
        return !IntSize.equals-impl0(r2, InvalidSize);
    }

    public static final Modifier animateContentSize(Modifier r2, FiniteAnimationSpec<IntSize> r3, Function2<? super IntSize, ? super IntSize, Unit> r4) {
        return ClipKt.clipToBounds(r2).then(new SizeAnimationModifierElement(r3, Alignment.Companion.getTopStart(), r4));
    }

    public static final Modifier animateContentSize(Modifier r1, FiniteAnimationSpec<IntSize> r2, Alignment r3, Function2<? super IntSize, ? super IntSize, Unit> r4) {
        return ClipKt.clipToBounds(r1).then(new SizeAnimationModifierElement(r2, r3, r4));
    }

    public static /* synthetic */ Modifier animateContentSize$default(Modifier r3, FiniteAnimationSpec r4, Function2 r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r4 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
    L6:
        if ((r6 & 2) == 0) goto L9;
        r5 = null;
    L9:
        return animateContentSize(r3, r4, r5);
    }

    public static /* synthetic */ Modifier animateContentSize$default(Modifier r3, FiniteAnimationSpec r4, Alignment r5, Function2 r6, int r7, Object r8) {
        if ((r7 & 1) == 0) goto L6;
        r4 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
    L6:
        if ((r7 & 2) == 0) goto L9;
        r5 = Alignment.Companion.getTopStart();
    L9:
        if ((r7 & 4) == 0) goto L12;
        r6 = null;
    L12:
        return animateContentSize(r3, r4, r5, r6);
    }
}
