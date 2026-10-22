package androidx.compose.material3;

import androidx.compose.material3.tokens.RadioButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u0005*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/RadioButtonDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/RadioButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/RadioButtonColors;", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledSelectedColor", "disabledUnselectedColor", "colors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/RadioButtonColors;", "defaultRadioButtonColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultRadioButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/RadioButtonColors;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RadioButtonDefaults {
    public static final int $stable = 0;
    public static final RadioButtonDefaults INSTANCE = null;

    static {
        INSTANCE = new RadioButtonDefaults();
    }

    private RadioButtonDefaults() {
    }

    public final RadioButtonColors getDefaultRadioButtonColors$material3(ColorScheme r18) {
        RadioButtonColors r1 = r18.getDefaultRadioButtonColorsCached$material3();
        if (r1 != null) goto L6;
        RadioButtonTokens r2 = RadioButtonTokens.INSTANCE;
        RadioButtonColors r3 = new RadioButtonColors(ColorSchemeKt.fromToken(r18, r2.getSelectedIconColor()), ColorSchemeKt.fromToken(r18, r2.getUnselectedIconColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r18, r2.getDisabledSelectedIconColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r18, r2.getDisabledUnselectedIconColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r18.setDefaultRadioButtonColorsCached$material3(r3);
        return r3;
    L6:
        return r1;
    }

    public final RadioButtonColors colors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1191566130, r5, -1, "androidx.compose.material3.RadioButtonDefaults.colors (RadioButton.kt:135)");
    L5:
        RadioButtonColors r6 = getDefaultRadioButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    /* JADX INFO: renamed from: colors-ro_MJ88, reason: not valid java name */
    public final RadioButtonColors m3021colorsro_MJ88(long r13, long r15, long r17, long r19, Composer r21, int r22, int r23) {
        if ((r23 & 1) == 0) goto L5;
        long r0 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r23 & 2) == 0) goto L9;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r23 & 4) == 0) goto L13;
        long r4 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r23 & 8) == 0) goto L17;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(-351083046, r22, -1, "androidx.compose.material3.RadioButtonDefaults.colors (RadioButton.kt:155)");
    L21:
        RadioButtonColors r1 = getDefaultRadioButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r21, 6)).m3016copyjRlVdoo(r0, r2, r4, r6);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r1;
    L17:
        r6 = r19;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r2 = r15;
        goto L11
    L5:
        r0 = r13;
        goto L7
    }
}
