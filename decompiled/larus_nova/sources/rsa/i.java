package rsa;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.RectF;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.bytedcert.manager.AutoTestManager;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes34.dex */
public final class i {
    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static float d(Context r100) {
        WindowManager r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r102 = new DisplayMetrics();
        r101.getDefaultDisplay().getMetrics(r102);
        int r103 = r102.widthPixels;
        int r104 = r102.heightPixels;
        int r105 = Math.min(r103, r104);
        if (AutoTestManager.getInstance().isAutoTest() == true) goto L5;
        if (r103 <= r104) goto L10;
        return r105 * 0.25f;
    L10:
        return (r105 * 0.75910366f) / 2.0f;
    L5:
        return r105 * 0.375f;
    }

    public static int e(Context r100) {
        Resources r101 = r100.getResources();
        return WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).heightPixels;
    }

    public static int f(Context r100) {
        Resources r101 = r100.getResources();
        return WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).widthPixels;
    }

    public static float b(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }

    public static Point g(View r100, View r101) {
        if (r100 == null) goto L9;
        if (r101 == null) goto L9;
        int[] r102 = new int[2];
        r100.getLocationOnScreen(r102);
        int[] r103 = new int[2];
        r101.getLocationOnScreen(r103);
        return new Point(r103[0] - r102[0], r103[1] - r102[1]);
    L9:
        return new Point(0, 0);
    }

    public static void h(TextView r100, String r101, String r102, qsa.c r103) {
        SpannableString r104 = new SpannableString(r101);
        int r105 = r101.indexOf(r102);
        int r106 = r102.length() + r105;
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r104) == true) goto L13;
        r104.setSpan(new h(r103), r105, r106, 33);
        if (TextUtils.isEmpty("") == false) goto L9;
        int r107 = r100.getContext().getResources().getColor(R.color.byted_red_FE2C55);
    L10:
        r104.setSpan(new ForegroundColorSpan(r107), r105, r106, 33);
        r100.setMovementMethod(LinkMovementMethod.getInstance());
        r100.setText(r104);
        return;
    L9:
        r107 = ColorProtector.parseColor("");
        goto L10
    }

    public static void i(View r100, float r101, float r102, boolean r103) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r101 <= 0.0f) goto L7;
        r100.setScaleX(r101);
        r100.setScaleY(r101);
    L7:
        if (r103 == false) goto L10;
        r100.setTranslationX(0.0f);
    L10:
        if (r102 != 0.0f) goto L12;
        if (r103 == true) goto L12;
        return;
    L12:
        r100.setTranslationY(r102);
    }

    public static RectF c(Context r100, int r101, int r102, int r110, int r111, boolean r112) {
        float r103 = r101;
        float r104 = r110;
        float r105 = r104 / 2.0f;
        float r106 = r103 - r105;
        float r107 = 0.0f;
        if (r112 == false) goto L5;
        float r108 = b(r100, 3.0f);
    L6:
        float r109 = r106 + r108;
        float r113 = r103 + r105;
        if (r112 == false) goto L9;
        float r114 = b(r100, 3.0f);
    L10:
        float r115 = r113 - r114;
        float r116 = r102;
        float r117 = r111;
        float r118 = r117 / 2.0f;
        float r119 = r116 + r118;
        if (r112 == false) goto L13;
        float r120 = b(r100, 3.0f);
    L14:
        float r121 = r119 - r120;
        float r122 = r116 - r118;
        if (r112 == false) goto L17;
        r107 = b(r100, 3.0f);
    L17:
        float r123 = r122 + r107;
        CertLog.e("getCenterRect", "width " + r110 + " rect left " + r109 + " top : " + r123 + " right: " + r115 + " bottom: " + r121 + " rectWidth: " + r104 + " rectHeight " + r117);
        return new RectF(r109, r123, r115, r121);
    L13:
        r120 = 0.0f;
        goto L14
    L9:
        r114 = 0.0f;
        goto L10
    L5:
        r108 = 0.0f;
        goto L6
    }
}
