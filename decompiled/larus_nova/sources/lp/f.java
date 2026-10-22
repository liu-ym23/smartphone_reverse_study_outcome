package lp;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements ComponentCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f510196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int[] f510197b;

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        if (r100.fontScale <= 0) goto L5;
        e r101 = this.f510196a;
        Resources r102 = Resources.getSystem();
        r101.f510183f = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).scaledDensity;
    L5:
        this.f510196a.getClass();
        e r103 = this.f510196a;
        int[] r104 = this.f510197b;
        r103.f510187j = r104[0];
        r103.f510188k = r104[1];
    }

    public f(e r100, int[] r101) {
        this.f510196a = r100;
        this.f510197b = r101;
    }
}
