package com.bytedance.ee.util.ui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes19.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f243167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f243168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Integer> f243169c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Integer> f243170d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f243171e;

    static {
        f243169c = new HashMap();
        f243170d = new HashMap();
        f243171e = 0;
    }

    private static Resources getResources() {
        int r100 = com.larksuite.framework.utils.autoscale.a.f285947a;
        return Resources.getSystem();
    }

    @JvmStatic
    public static int t() {
        return a(getResources()).heightPixels;
    }

    public static int v() {
        return a(getResources()).widthPixels;
    }

    public static boolean A(Activity r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.isDestroyed() == false) goto L8;
        return false;
    L8:
        if (r100.isFinishing() == true) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean C(Context r100) {
        if (r100.getResources().getConfiguration().orientation != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean D(Activity r100) {
        if (r100 != null) goto L6;
        tt5.a.k("UIUtils", "context can't be null");
        return false;
    L6:
        return com.ss.android.lark.base.embedded.b.b(r100);
    }

    public static int E(int r100) {
        return (int) ((r100 / a(getResources()).density) + 0.5f);
    }

    public static int F(int r100) {
        return (int) ((r100 / a(getResources()).scaledDensity) + 0.5f);
    }

    public static int G(int r100) {
        return (int) ((r100 * a(getResources()).scaledDensity) + 0.5f);
    }

    public static DisplayMetrics a(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static RectF b(View r100) {
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        int r102 = r101[0];
        return new RectF(r102, r101[1], r102 + r100.getMeasuredWidth(), r101[1] + r100.getMeasuredHeight());
    }

    public static int c(float r100) {
        return (int) ((r100 * a(getResources()).density) + 0.5f);
    }

    public static int d(int r100) {
        return c(Float.valueOf(r100).floatValue());
    }

    public static Activity g(Context r100) {
    L3:
        if ((r100 instanceof ContextWrapper) == false) goto L9;
        if ((r100 instanceof Activity) == true) goto L7;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L7:
        return (Activity) r100;
    L9:
        return null;
    }

    public static Resources getResources(Context r100) {
        return r100.getResources();
    }

    public static int p(Context r100) {
        WindowManager r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r102 = new DisplayMetrics();
        r101.getDefaultDisplay().getMetrics(r102);
        return r102.heightPixels;
    }

    public static int q(Context r100) {
        WindowManager r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r102 = new DisplayMetrics();
        r101.getDefaultDisplay().getMetrics(r102);
        return r102.widthPixels;
    }

    public static int r(Context r100) {
        int r101 = f243171e;
        if (r101 != 0) goto L6;
        Display r102 = ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
        DisplayMetrics r103 = new DisplayMetrics();
        r102.getRealMetrics(r103);
        int r104 = r103.heightPixels;
        f243171e = r104;
        return r104;
    L6:
        return r101;
    }

    public static int u(Context r100) {
        if (f243168b > 0) goto L6;
        WindowManager r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r102 = new DisplayMetrics();
        r101.getDefaultDisplay().getMetrics(r102);
        f243168b = r102.heightPixels;
    L6:
        return f243168b;
    }

    public static int w(Context r100) {
        if (f243167a > 0) goto L6;
        WindowManager r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r102 = new DisplayMetrics();
        r101.getDefaultDisplay().getMetrics(r102);
        f243167a = r102.widthPixels;
    L6:
        return f243167a;
    }

    public static String y(String r100) {
        return "ud_" + r100.replace('-', '_');
    }

    public static int z(Context r100) {
        Display r101 = ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
        DisplayMetrics r102 = new DisplayMetrics();
        r101.getRealMetrics(r102);
        return r102.heightPixels;
    }

    public static boolean B(View r100, MotionEvent r101) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return b(r100).contains(r101.getRawX(), r101.getRawY());
    }

    public static int e(Context r100, float r101) {
        return (int) ((r101 * a(r100.getResources()).density) + 0.5f);
    }

    public static int f(Context r100, int r101) {
        return e(r100, Float.valueOf(r101).floatValue());
    }

    public static int h(Context r100, int r101) {
        return getResources(r100).getColor(r101);
    }

    public static int i(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return R.color.black_alpha_70;
    L5:
        HashMap r102 = (HashMap) f243170d;
        if (r102.containsKey(r101) == true) goto L8;
    L11:
        int r103 = r100.getResources().getIdentifier(y(r101), "color", r100.getPackageName());
        if (r103 == 0) goto L16;
        r102.put(r101, Integer.valueOf(r103));
        return r103;
    L16:
        return R.color.black_alpha_70;
    L8:
        if (r102.get(r101) == null) goto L11;
        return ((Integer) r102.get(r101)).intValue();
    }

    public static int j(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return R.color.black_alpha_70;
    L5:
        HashMap r102 = (HashMap) f243170d;
        if (r102.containsKey(r101) == true) goto L8;
    L11:
        int r103 = r100.getResources().getIdentifier(r101, "color", r100.getPackageName());
        if (r103 == 0) goto L16;
        r102.put(r101, Integer.valueOf(r103));
        return r103;
    L16:
        return R.color.black_alpha_70;
    L8:
        if (r102.get(r101) == null) goto L11;
        return ((Integer) r102.get(r101)).intValue();
    }

    public static Drawable k(Context r100, int r101) {
        return AppCompatResources.getDrawable(r100, kac.a.b(r101));
    }

    public static int l(Context r100, int r101) {
        return getResources(r100).getDimensionPixelSize(r101);
    }

    public static Drawable m(Context r100, int r101) {
        int r102 = kac.a.b(r101);
        return getResources(r100).getDrawable(r102);
    }

    public static int n(Context r100, String r101) {
        boolean r102 = TextUtils.isEmpty(r101);
        int r103 = R.drawable.ud_icon_bitableunknow_outlined;
        if (r102 == true) goto L5;
        Map<String, Integer> r104 = f243169c;
        if (((HashMap) r104).containsKey(r101) == true) goto L9;
    L12:
        int r105 = r100.getResources().getIdentifier(y(r101), "drawable", r100.getPackageName());
        if (r105 == 0) goto L17;
        HashMap r106 = (HashMap) r104;
        r106.put(r101, Integer.valueOf(r105));
        r103 = r105;
    L17:
        return kac.a.b(r103);
    L9:
        if (((HashMap) r104).get(r101) == null) goto L12;
        return kac.a.b(((Integer) ((HashMap) r104).get(r101)).intValue());
    L5:
        return kac.a.b(R.drawable.ud_icon_bitableunknow_outlined);
    }

    public static int o(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L5;
        Map<String, Integer> r102 = f243169c;
        if (((HashMap) r102).containsKey(r101) == true) goto L9;
    L12:
        int r103 = r100.getResources().getIdentifier(y(r101), "drawable", r100.getPackageName());
        if (r103 == 0) goto L16;
        HashMap r104 = (HashMap) r102;
        r104.put(r101, Integer.valueOf(r103));
    L16:
        return kac.a.b(r103);
    L9:
        if (((HashMap) r102).get(r101) == null) goto L12;
        return kac.a.b(((Integer) ((HashMap) r102).get(r101)).intValue());
    L5:
        return kac.a.b(R.drawable.ud_icon_bitableunknow_outlined);
    }

    public static String x(Context r100, int r101) {
        return getResources(r100).getString(r101);
    }

    public static RectF s(View r100, int r101, int r102, int r103, int r104) {
        RectF r105 = new RectF();
        int[] r106 = new int[2];
        r100.getLocationOnScreen(r106);
        r105.left = r106[0] - d(r101);
        r105.top = r106[1] - d(r102);
        r105.right = (r106[0] + r100.getMeasuredWidth()) + d(r103);
        r105.bottom = (r106[1] + r100.getMeasuredHeight()) + d(r104);
        return r105;
    }
}
