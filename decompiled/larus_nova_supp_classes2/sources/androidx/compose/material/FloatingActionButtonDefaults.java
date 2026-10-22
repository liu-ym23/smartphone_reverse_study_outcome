package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ7\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/material/FloatingActionButtonDefaults;", "", "<init>", "()V", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "elevation-ixp7dh8", "(FFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/FloatingActionButtonElevation;", "hoveredElevation", "focusedElevation", "elevation-xZ9-QkE", "(FFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/FloatingActionButtonElevation;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FloatingActionButtonDefaults {
    public static final int $stable = 0;
    public static final FloatingActionButtonDefaults INSTANCE = null;

    static {
        INSTANCE = new FloatingActionButtonDefaults();
    }

    private FloatingActionButtonDefaults() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another overload of elevation")
    /* JADX INFO: renamed from: elevation-ixp7dh8, reason: not valid java name */
    public final /* synthetic */ FloatingActionButtonElevation m2074elevationixp7dh8(float r11, float r12, Composer r13, int r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        r11 = Dp.constructor-impl(6);
    L5:
        float r3 = r11;
        if ((r15 & 2) == 0) goto L8;
        r12 = Dp.constructor-impl(12);
    L8:
        float r4 = r12;
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-654132828, r14, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:215)");
    L11:
        float r16 = 8;
        FloatingActionButtonElevation r17 = m2075elevationxZ9QkE(r3, r4, Dp.constructor-impl(r16), Dp.constructor-impl(r16), r13, (((r14 & 14) | 3456) | (r14 & 112)) | (57344 & (r14 << 6)), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
    L14:
        return r17;
    }

    /* JADX INFO: renamed from: elevation-xZ9-QkE, reason: not valid java name */
    public final FloatingActionButtonElevation m2075elevationxZ9QkE(float r9, float r10, float r11, float r12, Composer r13, int r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        r9 = Dp.constructor-impl(6);
    L5:
        float r3 = r9;
        if ((r15 & 2) == 0) goto L8;
        r10 = Dp.constructor-impl(12);
    L8:
        float r4 = r10;
        if ((r15 & 4) == 0) goto L11;
        r11 = Dp.constructor-impl(8);
    L11:
        float r5 = r11;
        if ((r15 & 8) == 0) goto L14;
        r12 = Dp.constructor-impl(8);
    L14:
        float r6 = r12;
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventStart(380403812, r14, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:238)");
    L17:
        boolean r16 = false;
        if (((r14 & 14) ^ 6) <= 4) goto L22;
        if (r13.changed(r3) == false) goto L22;
    L23:
        boolean r17 = true;
    L26:
        if (((r14 & 112) ^ 48) <= 32) goto L30;
        if (r13.changed(r4) == false) goto L30;
    L31:
        boolean r18 = true;
    L33:
        boolean r19 = r17 | r18;
        if (((r14 & 896) ^ 384) <= 256) goto L38;
        if (r13.changed(r5) == false) goto L38;
    L39:
        boolean r110 = true;
    L41:
        boolean r20 = r19 | r110;
        if (((r14 & 7168) ^ 3072) <= 2048) goto L46;
        if (r13.changed(r6) == false) goto L46;
    L47:
        r16 = true;
    L48:
        boolean r21 = r20 | r16;
        Object r111 = r13.rememberedValue();
        if (r21 == false) goto L51;
    L52:
        r111 = new DefaultFloatingActionButtonElevation(r3, r4, r5, r6, null);
        r13.updateRememberedValue(r111);
    L53:
        DefaultFloatingActionButtonElevation r112 = (DefaultFloatingActionButtonElevation) r111;
        if (ComposerKt.isTraceInProgress() == false) goto L56;
        ComposerKt.traceEventEnd();
    L56:
        return r112;
    L51:
        if (r111 != Composer.Companion.getEmpty()) goto L53;
    L46:
        if ((r14 & 3072) != 2048) goto L48;
    L38:
        if ((r14 & 384) == 256) goto L39;
        r110 = false;
    L30:
        if ((r14 & 48) == 32) goto L31;
        r18 = false;
    L22:
        if ((r14 & 6) == 4) goto L23;
        r17 = false;
        goto L26
    }
}
