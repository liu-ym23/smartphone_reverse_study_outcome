package xfb;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.ss.android.lark.utils.i0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f563555a = 0;

    static {
    }

    public static int a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r102 = (WindowManager) r101;
        if (i0.a(r100) == true) goto L5;
    L7:
        DisplayMetrics r103 = new DisplayMetrics();
        r102.getDefaultDisplay().getRealMetrics(r103);
        return r103.heightPixels;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L7;
        Display r104 = r102.getDefaultDisplay();
        return RangesKt.coerceAtMost(r104.getMode().getPhysicalHeight(), r104.getMode().getPhysicalWidth());
    }

    public static int b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r102 = (WindowManager) r101;
        if (i0.a(r100) == true) goto L5;
    L7:
        DisplayMetrics r103 = new DisplayMetrics();
        r102.getDefaultDisplay().getMetrics(r103);
        return r103.widthPixels;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L7;
        Display r104 = r102.getDefaultDisplay();
        return RangesKt.coerceAtLeast(r104.getMode().getPhysicalWidth(), r104.getMode().getPhysicalHeight());
    }

    public static Rect c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Rect r101 = new Rect();
        r101.left = 0;
        r101.top = 0;
        r101.right = b(r100);
        r101.bottom = a(r100) - e.a(r100);
        return r101;
    }
}
