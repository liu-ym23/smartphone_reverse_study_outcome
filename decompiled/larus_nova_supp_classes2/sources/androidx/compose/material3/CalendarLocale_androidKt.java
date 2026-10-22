package androidx.compose.material3;

import android.content.res.Configuration;
import android.os.Build;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.os.ConfigurationCompat;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002H\u0001¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"defaultLocale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Landroidx/compose/runtime/Composer;I)Ljava/util/Locale;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CalendarLocale_androidKt {
    public static final Locale defaultLocale(Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(-1612326743, r4, -1, "androidx.compose.material3.defaultLocale (CalendarLocale.android.kt:30)");
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L8;
        r3.startReplaceGroup(2088426481);
        Locale r5 = Locale24.Companion.defaultLocale(r3, 6);
        r3.endReplaceGroup();
    L13:
        if (ComposerKt.isTraceInProgress() == false) goto L15;
        ComposerKt.traceEventEnd();
    L15:
        return r5;
    L8:
        r3.startReplaceGroup(1037201457);
        r5 = ConfigurationCompat.getLocales((Configuration) r3.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).get(0);
        if (r5 != null) goto L11;
        r5 = Locale.getDefault();
    L11:
        r3.endReplaceGroup();
        goto L13
    }
}
