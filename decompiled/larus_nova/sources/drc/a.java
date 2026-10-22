package drc;

import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f469802a = 0;

    static {
    }

    @JvmStatic
    public static final int a(float r100) {
        Resources r101 = Resources.getSystem();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public static float b(crc.a r100, float r101, int r102) {
        return (r101 / 2) + ((r100.f465147i + r100.f465145g) * r102);
    }
}
