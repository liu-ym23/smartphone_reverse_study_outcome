package rcb;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f537196a;

    static {
        f537196a = -1;
    }

    @JvmStatic
    public static final int a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.WindowManager");
        Display r102 = ((WindowManager) r101).getDefaultDisplay();
        DisplayMetrics r103 = new DisplayMetrics();
        r102.getRealMetrics(r103);
        return r103.heightPixels;
    }
}
