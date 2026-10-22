package androidx.compose.material;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"getString", "", "string", "Landroidx/compose/material/Strings;", "getString-4foXLRw", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Strings_androidKt {
    /* JADX INFO: renamed from: getString-4foXLRw, reason: not valid java name */
    public static final String m2174getString4foXLRw(int r3, Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-726638443, r5, -1, "androidx.compose.material.getString (Strings.android.kt:25)");
    L5:
        r4.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        Resources r6 = ((Context) r4.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources();
        Strings.Companion r7 = Strings.Companion;
        if (Strings.m2162equalsimpl0(r3, r7.m2170getNavigationMenuUdPEhr4()) == false) goto L9;
        String r8 = r6.getString(2131911858);
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventEnd();
    L33:
        return r8;
    L9:
        if (Strings.m2162equalsimpl0(r3, r7.m2166getCloseDrawerUdPEhr4()) == false) goto L12;
        r8 = r6.getString(2131895696);
        goto L31
    L12:
        if (Strings.m2162equalsimpl0(r3, r7.m2167getCloseSheetUdPEhr4()) == false) goto L15;
        r8 = r6.getString(2131895697);
        goto L31
    L15:
        if (Strings.m2162equalsimpl0(r3, r7.m2168getDefaultErrorMessageUdPEhr4()) == false) goto L18;
        r8 = r6.getString(2131896082);
        goto L31
    L18:
        if (Strings.m2162equalsimpl0(r3, r7.m2169getExposedDropdownMenuUdPEhr4()) == false) goto L21;
        r8 = r6.getString(2131896113);
        goto L31
    L21:
        if (Strings.m2162equalsimpl0(r3, r7.m2172getSliderRangeStartUdPEhr4()) == false) goto L24;
        r8 = r6.getString(2131913590);
        goto L31
    L24:
        if (Strings.m2162equalsimpl0(r3, r7.m2171getSliderRangeEndUdPEhr4()) == false) goto L27;
        r8 = r6.getString(2131913589);
        goto L31
    L27:
        if (Strings.m2162equalsimpl0(r3, r7.m2173getSnackbarPaneTitleUdPEhr4()) == false) goto L29;
        r8 = r6.getString(2131911791);
        goto L31
    L29:
        r8 = "";
        goto L31
    }
}
