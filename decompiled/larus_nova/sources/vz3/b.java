package vz3;

import android.app.Activity;
import android.content.res.Resources;
import android.util.TypedValue;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f557702a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f557703b = 0;

    static {
        Resources r100 = Resources.getSystem();
        f557702a = MathKt.roundToInt(TypedValue.applyDimension(1, 10, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics())));
        Resources r101 = Resources.getSystem();
        f557703b = MathKt.roundToInt(TypedValue.applyDimension(1, 56, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())));
    }

    public static int a(Activity r100, boolean r101, boolean r102, int r103) {
        if (r102 == false) goto L10;
        boolean r104 = d0.e(y54.a.a());
        boolean r105 = d0.f(r100);
        if (r101 == true) goto L13;
        if (r104 == false) goto L9;
        if (r105 == true) goto L9;
        return f557702a;
    L9:
        return 0;
    L13:
        return f557703b;
    L10:
        if (r101 == true) goto L12;
        return r103;
    L12:
        return r103 + f557703b;
    }

    public static int b(Activity r100, boolean r101, boolean r102, int r103) {
        if (r102 == false) goto L9;
        boolean r104 = d0.e(y54.a.a());
        boolean r105 = d0.f(r100);
        if (r101 == true) goto L10;
        if (r104 == false) goto L10;
        if (r105 == true) goto L10;
        return f557702a;
    L10:
        return 0;
    L9:
        if (r101 == true) goto L10;
        return r103;
    }
}
