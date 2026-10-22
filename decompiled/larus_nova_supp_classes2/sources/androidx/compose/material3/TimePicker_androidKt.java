package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"defaultTimePickerLayoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "(Landroidx/compose/runtime/Composer;I)I", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TimePicker_androidKt {
    public static final int defaultTimePickerLayoutType(Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-721362352, r4, -1, "androidx.compose.material3.defaultTimePickerLayoutType (TimePicker.android.kt:26)");
    L5:
        Configuration r5 = (Configuration) r3.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        if (r5.screenHeightDp >= r5.screenWidthDp) goto L8;
        int r6 = TimePickerLayoutType.Companion.m3430getHorizontalQJTpgSE();
    L10:
        if (ComposerKt.isTraceInProgress() == false) goto L12;
        ComposerKt.traceEventEnd();
    L12:
        return r6;
    L8:
        r6 = TimePickerLayoutType.Companion.m3431getVerticalQJTpgSE();
        goto L10
    }
}
