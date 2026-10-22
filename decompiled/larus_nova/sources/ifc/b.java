package ifc;

import android.content.Context;
import android.content.res.Resources;
import com.bytedance.push.utils.f;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f489697a;

    public static int a(Context r100, float r101) {
        if (f489697a != 0.0f) goto L5;
        Resources r102 = r100.getResources();
        f489697a = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
    L5:
        f.b("DpUtils", "dp2px: mScale is " + f489697a);
        return (int) ((r101 * f489697a) + 0.5f);
    }
}
