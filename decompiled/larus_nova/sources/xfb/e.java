package xfb;

import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.ss.android.floatbubble.util.RomUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Deprecated(message = "use DisplayCompatUtils")
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f563556a = 0;

    static {
    }

    public static int a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (b(r100) == 0) goto L21;
        boolean r101 = true;
        if ((!TextUtils.isEmpty(RomUtils.a(com.alipay.sdk.m.c.a.f25238a))) == true) goto L8;
    L13:
        Object r102 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.WindowManager");
        Display r103 = ((WindowManager) r102).getDefaultDisplay();
        DisplayMetrics r104 = new DisplayMetrics();
        r103.getRealMetrics(r104);
        int r105 = r104.heightPixels;
        int r106 = r104.widthPixels;
        DisplayMetrics r107 = new DisplayMetrics();
        r103.getMetrics(r107);
        int r108 = r107.heightPixels;
        int r109 = r107.widthPixels;
        if ((b(r100) + r108) > r105) goto L21;
        if ((r106 - r109) <= 0) goto L19;
    L22:
        if (r101 == true) goto L24;
        return 0;
    L24:
        return b(r100);
    L19:
        if ((r105 - r108) <= 0) goto L21;
    L8:
        if (Settings.Global.getInt(r100.getContentResolver(), "navigationbar_is_min", 0) == 0) goto L10;
        boolean r110 = true;
    L11:
        if (r110 == false) goto L13;
    L10:
        r110 = false;
    L21:
        r101 = false;
        goto L22
    }

    public static int b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r101 = r100.getResources();
        int r102 = r101.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r102 <= 0) goto L5;
        int r103 = r101.getDimensionPixelSize(r102);
    L6:
        Log.d("DisplayUtils--->", "getNavigationBarHeight = " + r103);
        return r103;
    L5:
        r103 = 0;
        goto L6
    }
}
