package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u00020\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/TimePickerDialogDefaults;", "", "<init>", "()V", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "MinHeightForTimePicker", "Landroidx/compose/ui/unit/Dp;", "getMinHeightForTimePicker-D9Ej5fM", "()F", "F", "DisplayModeToggle", "", "onDisplayModeChange", "Lkotlin/Function0;", "displayMode", "Landroidx/compose/material3/TimePickerDisplayMode;", "modifier", "Landroidx/compose/ui/Modifier;", "DisplayModeToggle-S7Bxtbk", "(Lkotlin/jvm/functions/Function0;ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Title", "Title-pK_nZyw", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TimePickerDialogDefaults {
    public static final int $stable = 0;
    public static final TimePickerDialogDefaults INSTANCE = null;
    private static final float MinHeightForTimePicker = 0.0f;

    private TimePickerDialogDefaults() {
    }

    private static final Unit DisplayModeToggle_S7Bxtbk$lambda$0(TimePickerDialogDefaults r7, Function0 r8, int r9, Modifier r10, int r11, int r12, Composer r13, int r14) {
        r7.m3391DisplayModeToggleS7Bxtbk(r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    private static final Unit Title_pK_nZyw$lambda$1(TimePickerDialogDefaults r6, int r7, Modifier r8, int r9, int r10, Composer r11, int r12) {
        r6.m3392TitlepK_nZyw(r7, r8, r11, RecomposeScopeImplKt.updateChangedFlags(r9 | 1), r10);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(TimePickerDialogDefaults r0, Function0 r1, int r2, Modifier r3, int r4, int r5, Composer r6, int r7) {
        return DisplayModeToggle_S7Bxtbk$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit b(TimePickerDialogDefaults r0, int r1, Modifier r2, int r3, int r4, Composer r5, int r6) {
        return Title_pK_nZyw$lambda$1(r0, r1, r2, r3, r4, r5, r6);
    }

    static {
        INSTANCE = new TimePickerDialogDefaults();
        MinHeightForTimePicker = Dp.constructor-impl(300);
    }

    /* JADX INFO: renamed from: getMinHeightForTimePicker-D9Ej5fM, reason: not valid java name */
    public final float m3393getMinHeightForTimePickerD9Ej5fM() {
        return MinHeightForTimePicker;
    }

    public final long getContainerColor(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-443775449, r5, -1, "androidx.compose.material3.TimePickerDialogDefaults.<get-containerColor> (TimePickerDialog.kt:242)");
    L5:
        long r6 = ColorSchemeKt.getValue(DialogTokens.INSTANCE.getContainerColor(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1241096723, r5, -1, "androidx.compose.material3.TimePickerDialogDefaults.<get-shape> (TimePickerDialog.kt:246)");
    L5:
        Shape r6 = ShapesKt.getValue(DialogTokens.INSTANCE.getContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    /* JADX INFO: renamed from: Title-pK_nZyw, reason: not valid java name */
    public final void m3392TitlepK_nZyw(final int r31, Modifier r32, Composer r33, final int r34, final int r35) {
        Composer r1 = r33.startRestartGroup(1546564986);
        if ((r35 & 1) == 0) goto L6;
        int r3 = r34 | 6;
    L13:
        int r4 = r35 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r32;
    L25:
        if ((r3 & 19) == 18) goto L27;
        boolean r6 = true;
    L29:
        if (r1.shouldExecute(r6, r3 & 1) == false) goto L44;
        if (r4 == 0) goto L32;
        Modifier r29 = Modifier.Companion;
    L34:
        if (ComposerKt.isTraceInProgress() == false) goto L36;
        ComposerKt.traceEventStart(1546564986, r3, -1, "androidx.compose.material3.TimePickerDialogDefaults.Title (TimePickerDialog.kt:294)");
    L36:
        Modifier r7 = PaddingKt.m964paddingqDBjuR0$default(r29, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, Dp.constructor-impl(20), 7, null);
        TextStyle r24 = MaterialTheme.INSTANCE.getTypography(r1, 6).getLabelMedium();
        if (TimePickerDisplayMode.m3400equalsimpl0(r31, TimePickerDisplayMode.Companion.m3405getPickerONbchU()) == false) goto L39;
        int r0 = Strings.constructor-impl(2131911761);
    L40:
        TextKt.m3363TextNvy7gAk(Strings_androidKt.getString-2EP1pXo(r0, r1, 0), r7, 0, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, r24, r1, 0, 0, 131068);
        if (ComposerKt.isTraceInProgress() == false) goto L43;
        ComposerKt.traceEventEnd();
    L43:
        final Modifier r8 = r29;
    L45:
        ScopeUpdateScope r9 = r1.endRestartGroup();
        if (r9 == null) goto L49;
        r9.updateScope(new ju(this, r31, r8, r34, r35));
        return;
    L49:
        return;
    L39:
        r0 = Strings.constructor-impl(2131911759);
        goto L40
    L32:
        r29 = r5;
        goto L34
    L44:
        r1.skipToGroupEnd();
        r8 = r5;
        goto L45
    L27:
        r6 = false;
        goto L29
    L17:
        if ((r34 & 48) != 0) goto L23;
        r5 = r32;
        if (r1.changed(r5) == false) goto L21;
        int r10 = 32;
    L22:
        r3 = r3 | r10;
        goto L25
    L21:
        r10 = 16;
        goto L22
    L6:
        if ((r34 & 6) == 0) goto L8;
        r3 = r34;
        goto L13
    L8:
        if (r1.changed(r31) == false) goto L10;
        int r11 = 4;
    L11:
        r3 = r34 | r11;
        goto L13
    L10:
        r11 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: DisplayModeToggle-S7Bxtbk, reason: not valid java name */
    public final void m3391DisplayModeToggleS7Bxtbk(final Function0<Unit> r18, final int r19, Modifier r20, Composer r21, final int r22, final int r23) {
        Composer r1 = r21.startRestartGroup(-1283607635);
        if ((r23 & 1) == 0) goto L6;
        int r4 = r22 | 6;
    L14:
        if ((r23 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L23:
        int r6 = r23 & 4;
        if (r6 == 0) goto L27;
        r4 = r4 | 384;
    L33:
        Modifier r7 = r20;
    L35:
        if ((r4 & 147) == 146) goto L37;
        boolean r8 = true;
    L39:
        if (r1.shouldExecute(r8, r4 & 1) == false) goto L50;
        if (r6 == 0) goto L42;
        Modifier r16 = Modifier.Companion;
    L44:
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventStart(-1283607635, r4, -1, "androidx.compose.material3.TimePickerDialogDefaults.DisplayModeToggle (TimePickerDialog.kt:264)");
    L46:
        Modifier r9 = r16;
        IconButtonKt.IconButton(r18, r9, false, null, null, null, ComposableLambdaKt.rememberComposableLambda(-698026161, true, new TimePickerDialogDefaults$DisplayModeToggle$1(r19), r1, 54), r1, ((r4 & 14) | 1572864) | ((r4 >> 3) & 112), 60);
        if (ComposerKt.isTraceInProgress() == false) goto L49;
        ComposerKt.traceEventEnd();
    L49:
        final Modifier r5 = r16;
    L51:
        ScopeUpdateScope r10 = r1.endRestartGroup();
        if (r10 == null) goto L55;
        r10.updateScope(new iu(this, r18, r19, r5, r22, r23));
        return;
    L55:
        return;
    L42:
        r16 = r7;
        goto L44
    L50:
        r1.skipToGroupEnd();
        r5 = r7;
        goto L51
    L37:
        r8 = false;
        goto L39
    L27:
        if ((r22 & 384) != 0) goto L33;
        r7 = r20;
        if (r1.changed(r7) == false) goto L31;
        int r11 = 256;
    L32:
        r4 = r4 | r11;
        goto L35
    L31:
        r11 = 128;
        goto L32
    L17:
        if ((r22 & 48) != 0) goto L23;
        if (r1.changed(r19) == false) goto L21;
        int r12 = 32;
    L22:
        r4 = r4 | r12;
        goto L23
    L21:
        r12 = 16;
        goto L22
    L6:
        if ((r22 & 6) == 0) goto L8;
        r4 = r22;
        goto L14
    L8:
        if (r1.changedInstance(r18) == false) goto L10;
        int r13 = 4;
    L11:
        r4 = r13 | r22;
        goto L14
    L10:
        r13 = 2;
        goto L11
    }
}
