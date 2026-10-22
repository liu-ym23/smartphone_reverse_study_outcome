package j19;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f496869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k19.e f496870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f496871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f496872d;

    public final float a() {
        float r100 = 1 - (this.f496870b.f501407f / this.f496871c);
        if (r100 <= 1.0f) goto L6;
        return 1.0f;
    L6:
        if (r100 >= 0.3f) goto L8;
        return 0.3f;
    L8:
        return r100;
    }

    public final Context getContext() {
        return this.f496869a;
    }

    public b(Context r100, k19.e r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "detector");
        this.f496869a = r100;
        this.f496870b = r101;
        Resources r102 = r100.getResources();
        int r103 = 0;
        if (r102 == null) goto L7;
        DisplayMetrics r104 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics());
        if (r104 == null) goto L7;
        int r105 = r104.heightPixels;
    L8:
        int r106 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r106 <= 0) goto L11;
        r103 = r100.getResources().getDimensionPixelSize(r106);
    L11:
        this.f496871c = (r105 + r103) / 2;
        this.f496872d = 0.4f;
        return;
    L7:
        r105 = 0;
        goto L8
    }
}
