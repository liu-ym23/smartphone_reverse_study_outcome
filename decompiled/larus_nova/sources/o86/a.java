package o86;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f522385a = 0;

    static {
    }

    public static int a(Context r100, int r101) {
        Resources r102 = r100.getResources();
        return (int) (r101 / (WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).densityDpi / 160));
    }
}
