package sk3;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements ComponentCallbacks {
    public final /* synthetic */ e a;
    public final /* synthetic */ int[] b;

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r4) {
        Intrinsics.checkNotNullParameter(r4, "newConfig");
        if (r4.fontScale <= 0) goto L5;
        e r5 = this.a;
        Resources r1 = Resources.getSystem();
        r5.f = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).scaledDensity;
    L5:
        this.a.getClass();
        e r6 = this.a;
        int[] r2 = this.b;
        r6.j = r2[0];
        r6.k = r2[1];
    }

    public f(e r1, int[] r2) {
        this.a = r1;
        this.b = r2;
    }
}
