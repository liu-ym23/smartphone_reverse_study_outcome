package jwb;

import android.content.Context;
import android.content.res.Resources;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f500742a = 0;

    static {
    }

    public static int a(Context r100) {
        float r101 = r100.getResources().getDimension(R.dimen.office_sdk_mm_dialog_corner_radius_doubao);
        Resources r102 = r100.getResources();
        return MathKt.roundToInt(r101 / WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density);
    }
}
