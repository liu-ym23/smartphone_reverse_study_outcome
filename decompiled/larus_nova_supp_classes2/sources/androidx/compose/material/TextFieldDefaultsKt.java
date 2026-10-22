package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aE\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"animateBorderStrokeAsState", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material/TextFieldColors;", "focusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "unfocusedBorderThickness", "animateBorderStrokeAsState-NuRrP5Q", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;FFLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material", "focused"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldDefaultsKt {
    private static final boolean animateBorderStrokeAsState_NuRrP5Q$lambda$0(State<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    /* JADX INFO: renamed from: access$animateBorderStrokeAsState-NuRrP5Q, reason: not valid java name */
    public static final /* synthetic */ State m2222access$animateBorderStrokeAsStateNuRrP5Q(boolean r0, boolean r1, InteractionSource r2, TextFieldColors r3, float r4, float r5, Composer r6, int r7) {
        return m2223animateBorderStrokeAsStateNuRrP5Q(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: animateBorderStrokeAsState-NuRrP5Q, reason: not valid java name */
    private static final State<BorderStroke> m2223animateBorderStrokeAsStateNuRrP5Q(boolean r11, boolean r12, InteractionSource r13, TextFieldColors r14, float r15, float r16, Composer r17, int r18) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1097899920, r18, -1, "androidx.compose.material.animateBorderStrokeAsState (TextFieldDefaults.kt:949)");
    L5:
        State<Boolean> r8 = FocusInteractionKt.collectIsFocusedAsState(r13, r17, (r18 >> 6) & 14);
        State<Color> r9 = r14.indicatorColor(r11, r12, r13, r17, (((r18 & 14) | (r18 & 112)) | (r18 & 896)) | (r18 & 7168));
        if (animateBorderStrokeAsState_NuRrP5Q$lambda$0(r8) == false) goto L8;
        float r0 = r15;
    L10:
        if (r11 == false) goto L12;
        r17.startReplaceGroup(1361102414);
        State<Dp> r1 = AnimateAsStateKt.m238animateDpAsStateAjpBEmI(r0, AnimationSpecKt.tween$default(TextFieldImplKt.AnimationDuration, 0, null, 6, null), null, null, r17, 48, 12);
        r17.endReplaceGroup();
    L13:
        State<BorderStroke> r2 = SnapshotStateKt.rememberUpdatedState(new BorderStroke(((Dp) r1.getValue()).unbox-impl(), new SolidColor(((Color) r9.getValue()).unbox-impl(), null), null), r17, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L16;
        ComposerKt.traceEventEnd();
    L16:
        return r2;
    L12:
        r17.startReplaceGroup(1361206636);
        r1 = SnapshotStateKt.rememberUpdatedState(Dp.box-impl(r16), r17, (r18 >> 15) & 14);
        r17.endReplaceGroup();
        goto L13
    L8:
        r0 = r16;
        goto L10
    }
}
