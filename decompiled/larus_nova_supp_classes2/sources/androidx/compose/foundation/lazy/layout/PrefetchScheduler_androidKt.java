package androidx.compose.foundation.lazy.layout;

import android.os.Build;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.precompose.PausableSubPreComposeController;
import androidx.compose.ui.precompose.PausableSubPreComposeControllerKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001\u0004\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\"\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u0007\u0012\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"rememberDefaultPrefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "RobolectricImpl", "androidx/compose/foundation/lazy/layout/PrefetchScheduler_androidKt$RobolectricImpl$1", "getRobolectricImpl$annotations", "()V", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler_androidKt$RobolectricImpl$1;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PrefetchScheduler_androidKt {
    private static final PrefetchScheduler_androidKt$RobolectricImpl$1 RobolectricImpl = null;

    private static /* synthetic */ void getRobolectricImpl$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        if (Intrinsics.areEqual(Build.FINGERPRINT.toLowerCase(Locale.ROOT), "robolectric") == false) goto L5;
        PrefetchScheduler_androidKt$RobolectricImpl$1 r0 = new PrefetchScheduler_androidKt$RobolectricImpl$1();
    L6:
        RobolectricImpl = r0;
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public static final PrefetchScheduler rememberDefaultPrefetchScheduler(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1141871251, r5, -1, "androidx.compose.foundation.lazy.layout.rememberDefaultPrefetchScheduler (PrefetchScheduler.android.kt:38)");
    L5:
        PrefetchScheduler r6 = RobolectricImpl;
        if (r6 == null) goto L8;
        r4.startReplaceGroup(1345648624);
        r4.endReplaceGroup();
    L21:
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventEnd();
    L23:
        return r6;
    L8:
        r4.startReplaceGroup(1345701541);
        View r7 = (View) r4.consume(AndroidCompositionLocals_androidKt.getLocalView());
        PausableSubPreComposeController r0 = (PausableSubPreComposeController) r4.consume(PausableSubPreComposeControllerKt.getLocalPausableSubPreComposeController());
        boolean r1 = r4.changed(r7);
        Object r2 = r4.rememberedValue();
        if (r1 == false) goto L11;
    L12:
        Object r3 = r7.getTag(2131367615);
        if ((r3 instanceof PrefetchScheduler) == false) goto L15;
        r2 = (PrefetchScheduler) r3;
    L16:
        if (r2 != null) goto L18;
        r2 = new AndroidPrefetchScheduler(r7, r0);
        r7.setTag(2131367615, r2);
    L18:
        r4.updateRememberedValue(r2);
    L19:
        r6 = (PrefetchScheduler) r2;
        r4.endReplaceGroup();
        goto L21
    L15:
        r2 = null;
        goto L16
    L11:
        if (r2 != Composer.Companion.getEmpty()) goto L19;
        goto L12
    }
}
