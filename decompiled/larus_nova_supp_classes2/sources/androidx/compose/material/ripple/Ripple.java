package androidx.compose.material.ripple;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationInstance;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Deprecated(message = "Replaced by the new RippleNode implementation")
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b!\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010JC\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/material/ripple/Ripple;", "Landroidx/compose/foundation/Indication;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "<init>", "(ZFLandroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "rememberUpdatedInstance", "Landroidx/compose/foundation/IndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/IndicationInstance;", "rememberUpdatedRippleInstance", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rememberUpdatedRippleInstance-942rkJo", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleIndicationInstance;", "equals", "other", "", "hashCode", "", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class Ripple implements Indication {
    public static final int $stable = 0;
    private final boolean bounded;
    private final State<Color> color;
    private final float radius;

    public /* synthetic */ Ripple(boolean r1, float r2, State r3, DefaultConstructorMarker r4) {
        this(r1, r2, r3);
    }

    /* JADX INFO: renamed from: rememberUpdatedRippleInstance-942rkJo */
    public abstract RippleIndicationInstance mo2260rememberUpdatedRippleInstance942rkJo(InteractionSource r1, boolean r2, float r3, State<Color> r4, State<RippleAlpha> r5, Composer r6, int r7);

    public int hashCode() {
        if (this.bounded == false) goto L5;
        int r0 = 1231;
    L7:
        return (((r0 * 31) + Dp.hashCode-impl(this.radius)) * 31) + this.color.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Ripple) == true) goto L8;
        return false;
    L8:
        Ripple r6 = (Ripple) r5;
        if (this.bounded == r6.bounded) goto L12;
        return false;
    L12:
        if (Dp.equals-impl0(this.radius, r6.radius) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.color, r6.color) == true) goto L17;
        return false;
    L17:
        return true;
    }

    private Ripple(boolean r1, float r2, State<Color> r3) {
        this.bounded = r1;
        this.radius = r2;
        this.color = r3;
    }

    @Override // androidx.compose.foundation.Indication
    @Deprecated(message = "Super method is deprecated")
    public final IndicationInstance rememberUpdatedInstance(InteractionSource r16, Composer r17, int r18) {
        r17.startReplaceGroup(988743187);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(988743187, r18, -1, "androidx.compose.material.ripple.Ripple.rememberUpdatedInstance (Ripple.kt:190)");
    L5:
        RippleTheme r0 = (RippleTheme) r17.consume(RippleThemeKt.getLocalRippleTheme());
        boolean r12 = true;
        if (((Color) this.color.getValue()).unbox-impl() == 16) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        r17.startReplaceGroup(762952444);
        r17.endReplaceGroup();
        long r2 = ((Color) this.color.getValue()).unbox-impl();
    L12:
        State<Color> r4 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r2), r17, 0);
        State<RippleAlpha> r5 = SnapshotStateKt.rememberUpdatedState(r0.rippleAlpha(r17, 0), r17, 0);
        int r14 = r18 & 14;
        RippleIndicationInstance r3 = mo2260rememberUpdatedRippleInstance942rkJo(r16, this.bounded, this.radius, r4, r5, r17, r14 | ((r18 << 12) & 458752));
        if ((r14 ^ 6) <= 4) goto L17;
        if (r17.changed(r16) == false) goto L17;
    L20:
        boolean r6 = r17.changedInstance(r3) | r12;
        Object r7 = r17.rememberedValue();
        if (r6 == false) goto L23;
    L24:
        r7 = new Ripple$rememberUpdatedInstance$1$1(r16, r3, null);
        r17.updateRememberedValue(r7);
    L25:
        EffectsKt.LaunchedEffect(r3, r16, (Function2) r7, r17, (r18 << 3) & 112);
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
    L28:
        r17.endReplaceGroup();
        return r3;
    L23:
        if (r7 != Composer.Companion.getEmpty()) goto L25;
    L17:
        if ((r18 & 6) == 4) goto L20;
        r12 = false;
        goto L20
    L11:
        r17.startReplaceGroup(763010228);
        r2 = r0.mo2262defaultColorWaAFU9c(r17, 0);
        r17.endReplaceGroup();
        goto L12
    L8:
        r1 = false;
        goto L9
    }
}
