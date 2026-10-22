package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0017¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0014"}, d2 = {"Landroidx/compose/material/DefaultRadioButtonColors;", "Landroidx/compose/material/RadioButtonColors;", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledColor", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "radioColor", "Landroidx/compose/runtime/State;", "enabled", "", "selected", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "", "hashCode", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultRadioButtonColors implements RadioButtonColors {
    private final long disabledColor;
    private final long selectedColor;
    private final long unselectedColor;

    public /* synthetic */ DefaultRadioButtonColors(long r1, long r3, long r5, DefaultConstructorMarker r7) {
        this(r1, r3, r5);
    }

    public int hashCode() {
        return (((Color.hashCode-impl(this.selectedColor) * 31) + Color.hashCode-impl(this.unselectedColor)) * 31) + Color.hashCode-impl(this.disabledColor);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L20:
        return false;
    L8:
        if (DefaultRadioButtonColors.class != r7.getClass()) goto L20;
        DefaultRadioButtonColors r8 = (DefaultRadioButtonColors) r7;
        if (Color.equals-impl0(this.selectedColor, r8.selectedColor) == true) goto L14;
        return false;
    L14:
        if (Color.equals-impl0(this.unselectedColor, r8.unselectedColor) == true) goto L17;
        return false;
    L17:
        if (Color.equals-impl0(this.disabledColor, r8.disabledColor) == true) goto L19;
        return false;
    L19:
        return true;
    }

    private DefaultRadioButtonColors(long r1, long r3, long r5) {
        this.selectedColor = r1;
        this.unselectedColor = r3;
        this.disabledColor = r5;
    }

    @Override // androidx.compose.material.RadioButtonColors
    public State<Color> radioColor(boolean r11, boolean r12, Composer r13, int r14) {
        r13.startReplaceGroup(1243421834);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1243421834, r14, -1, "androidx.compose.material.DefaultRadioButtonColors.radioColor (RadioButton.kt:176)");
    L5:
        if (r11 == true) goto L8;
        long r0 = this.disabledColor;
    L7:
        long r2 = r0;
        if (r11 == false) goto L14;
        r13.startReplaceGroup(-1312642667);
        State<Color> r15 = SingleValueAnimationKt.m212animateColorAsStateeuL9pac(r2, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, r13, 48, 12);
        r13.endReplaceGroup();
    L16:
        if (ComposerKt.isTraceInProgress() == false) goto L18;
        ComposerKt.traceEventEnd();
    L18:
        r13.endReplaceGroup();
        return r15;
    L14:
        r13.startReplaceGroup(-1312539964);
        r15 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r2), r13, 0);
        r13.endReplaceGroup();
        goto L16
    L8:
        if (r12 == true) goto L10;
        r0 = this.unselectedColor;
        goto L7
    L10:
        r0 = this.selectedColor;
        goto L7
    }
}
