package com.jaeger.library;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.home.impl.utils.c;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import el9.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class StatusBarUtil {
    public static final int DEFAULT_STATUS_BAR_ALPHA = 112;
    private static final int FAKE_STATUS_BAR_VIEW_ID = 2131387322;
    private static final int FAKE_TRANSLUCENT_VIEW_ID = 2131387323;
    private static final int TAG_KEY_HAVE_SET_OFFSET = -123;

    public StatusBarUtil() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static int calculateStatusColor(int r100, int r101) {
        if (r101 != 0) goto L4;
        return r100;
    L4:
        float r102 = 1.0f - (r101 / 255.0f);
        return ((int) (((double) ((r100 & 255) * r102)) + 0.5d)) | (((((int) (((double) (((r100 >> 16) & 255) * r102)) + 0.5d)) << 16) | (-16777216)) | (((int) (((double) (((r100 >> 8) & 255) * r102)) + 0.5d)) << 8));
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_jaeger_library_StatusBarUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static View INVOKEVIRTUAL_com_jaeger_library_StatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    private static void clearPreviousSetting(Activity r100) {
        ViewGroup r101 = (ViewGroup) INVOKEVIRTUAL_com_jaeger_library_StatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow());
        View r102 = r101.findViewById(FAKE_STATUS_BAR_VIEW_ID);
        if (r102 == null) goto L6;
        r101.removeView(r102);
        ((ViewGroup) ((ViewGroup) r100.findViewById(R.id.content)).getChildAt(0)).setPadding(0, 0, 0, 0);
        return;
    }

    private static int getStatusBarHeight(Context r100) {
        int r101 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return r100.getResources().getDimensionPixelSize(r101);
    }

    public static void hideFakeStatusBarView(Activity r100) {
        ViewGroup r101 = (ViewGroup) INVOKEVIRTUAL_com_jaeger_library_StatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow());
        View r102 = r101.findViewById(FAKE_STATUS_BAR_VIEW_ID);
        if (r102 == null) goto L5;
        r102.setVisibility(8);
    L5:
        View r103 = r101.findViewById(FAKE_TRANSLUCENT_VIEW_ID);
        if (r103 == null) goto L9;
        r103.setVisibility(8);
        return;
    }

    public static void setDarkMode(Activity r100) {
        setMIUIStatusBarDarkIcon(r100, false);
        setMeizuStatusBarDarkIcon(r100, false);
        if (Build.VERSION.SDK_INT < 23) goto L6;
        INVOKEVIRTUAL_com_jaeger_library_StatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).setSystemUiVisibility(1024);
        return;
    }

    public static void setLightMode(Activity r100) {
        setMIUIStatusBarDarkIcon(r100, true);
        setMeizuStatusBarDarkIcon(r100, true);
        if (Build.VERSION.SDK_INT < 23) goto L6;
        INVOKEVIRTUAL_com_jaeger_library_StatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).setSystemUiVisibility(9216);
        return;
    }

    private static void setRootView(Activity r100) {
        ViewGroup r101 = (ViewGroup) r100.findViewById(R.id.content);
        int r102 = r101.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        View r104 = r101.getChildAt(r103);
        if ((r104 instanceof ViewGroup) == false) goto L7;
        r104.setFitsSystemWindows(true);
        ((ViewGroup) r104).setClipToPadding(true);
    L7:
        r103 = r103 + 1;
        goto L3
    }

    public static void setTranslucent(Activity r100) {
        setTranslucent(r100, 112);
    }

    public static void setTranslucentDiff(Activity r100) {
        r100.getWindow().addFlags(67108864);
        setRootView(r100);
    }

    public static void setTransparent(Activity r100) {
        transparentStatusBar(r100);
        setRootView(r100);
    }

    private static void setTransparentForWindow(Activity r100) {
        r100.getWindow().setStatusBarColor(0);
        INVOKEVIRTUAL_com_jaeger_library_StatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).setSystemUiVisibility(1280);
    }

    private static void transparentStatusBar(Activity r100) {
        r100.getWindow().addFlags(Integer.MIN_VALUE);
        r100.getWindow().clearFlags(67108864);
        r100.getWindow().addFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
        r100.getWindow().setStatusBarColor(0);
    }

    private static void addTranslucentView(Activity r100, int r101) {
        ViewGroup r102 = (ViewGroup) r100.findViewById(R.id.content);
        View r103 = r102.findViewById(FAKE_TRANSLUCENT_VIEW_ID);
        if (r103 != null) goto L5;
        r102.addView(createTranslucentStatusBarView(r100, r101));
        return;
    L5:
        if (r103.getVisibility() != 8) goto L7;
        r103.setVisibility(0);
    L7:
        r103.setBackgroundColor(Color.argb(r101, 0, 0, 0));
    }

    private static View createStatusBarView(Activity r100, int r101) {
        return createStatusBarView(r100, r101, 0);
    }

    private static View createTranslucentStatusBarView(Activity r100, int r101) {
        View r102 = new View(r100);
        r102.setLayoutParams(new LinearLayout.LayoutParams(-1, getStatusBarHeight(r100)));
        r102.setBackgroundColor(Color.argb(r101, 0, 0, 0));
        r102.setId(FAKE_TRANSLUCENT_VIEW_ID);
        return r102;
    }

    public static void setColor(Activity r100, int r101) {
        setColor(r100, r101, 112);
    }

    public static void setColorDiff(Activity r100, int r101) {
        transparentStatusBar(r100);
        ViewGroup r102 = (ViewGroup) r100.findViewById(R.id.content);
        View r103 = r102.findViewById(FAKE_STATUS_BAR_VIEW_ID);
        if (r103 != null) goto L5;
        r102.addView(createStatusBarView(r100, r101));
    L9:
        setRootView(r100);
        return;
    L5:
        if (r103.getVisibility() != 8) goto L7;
        r103.setVisibility(0);
    L7:
        r103.setBackgroundColor(r101);
        goto L9
    }

    public static void setColorForSwipeBack(Activity r100, int r101) {
        setColorForSwipeBack(r100, r101, 112);
    }

    public static void setColorNoTranslucent(Activity r100, int r101) {
        setColor(r100, r101, 0);
    }

    private static void setDrawerLayoutProperty(DrawerLayout r100, ViewGroup r101) {
        ViewGroup r102 = (ViewGroup) r100.getChildAt(1);
        r100.setFitsSystemWindows(false);
        r101.setFitsSystemWindows(false);
        r101.setClipToPadding(true);
        r102.setFitsSystemWindows(false);
    }

    private static void setMIUIStatusBarDarkIcon(Activity r100, boolean r101) {
        Class<?> r102 = r100.getWindow().getClass();
        Class r103 = INVOKESTATIC_com_jaeger_library_StatusBarUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Exception -> L9
        int r104 = r103.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(r103);     // Catch: Exception -> L9
        Class<?> r105 = Integer.TYPE;     // Catch: Exception -> L9
        Method r106 = r102.getMethod("setExtraFlags", new Class[]{r105, r105});     // Catch: Exception -> L9
        Window r107 = r100.getWindow();     // Catch: Exception -> L9
        Object[] r108 = new Object[2];     // Catch: Exception -> L9
        if (r101 == false) goto L6;
        int r109 = r104;
    L7:
        r108[0] = Integer.valueOf(r109);     // Catch: Exception -> L9
        r108[1] = Integer.valueOf(r104);     // Catch: Exception -> L9
        r106.invoke(r107, r108);     // Catch: Exception -> L9
        return;
    L6:
        r109 = 0;
    }

    private static void setMeizuStatusBarDarkIcon(Activity r100, boolean r101) {
        WindowManager.LayoutParams r102 = r100.getWindow().getAttributes();     // Catch: Exception -> L8
        Field r103 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");     // Catch: Exception -> L8
        Field r104 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");     // Catch: Exception -> L8
        r103.setAccessible(true);     // Catch: Exception -> L8
        r104.setAccessible(true);     // Catch: Exception -> L8
        int r105 = r103.getInt(null);     // Catch: Exception -> L8
        int r106 = r104.getInt(r102);     // Catch: Exception -> L8
        if (r101 == false) goto L5;
        int r107 = r106 | r105;     // Catch: Exception -> L8
    L6:
        r104.setInt(r102, r107);     // Catch: Exception -> L8
        r100.getWindow().setAttributes(r102);     // Catch: Exception -> L8
        return;
    L5:
        r107 = (~r105) & r106;     // Catch: Exception -> L8
    }

    public static void setTranslucent(Activity r100, int r101) {
        setTransparent(r100);
        addTranslucentView(r100, r101);
    }

    public static void setTranslucentForCoordinatorLayout(Activity r100, int r101) {
        transparentStatusBar(r100);
        addTranslucentView(r100, r101);
    }

    public static void setTranslucentForDrawerLayout(Activity r100, DrawerLayout r101) {
        setTranslucentForDrawerLayout(r100, r101, 112);
    }

    public static void setTranslucentForDrawerLayoutDiff(Activity r100, DrawerLayout r101) {
        r100.getWindow().addFlags(67108864);
        ViewGroup r102 = (ViewGroup) r101.getChildAt(0);
        r102.setFitsSystemWindows(true);
        r102.setClipToPadding(true);
        ((ViewGroup) r101.getChildAt(1)).setFitsSystemWindows(false);
        r101.setFitsSystemWindows(false);
    }

    public static void setTranslucentForImageView(Activity r100, View r101) {
        setTranslucentForImageView(r100, 112, r101);
    }

    public static void setTranslucentForImageViewInFragment(Activity r100, View r101) {
        setTranslucentForImageViewInFragment(r100, 112, r101);
    }

    public static void setTransparentForDrawerLayout(Activity r100, DrawerLayout r101) {
        r100.getWindow().addFlags(Integer.MIN_VALUE);
        r100.getWindow().clearFlags(67108864);
        r100.getWindow().setStatusBarColor(0);
        ViewGroup r102 = (ViewGroup) r101.getChildAt(0);
        if ((r102 instanceof LinearLayout) == false) goto L5;
    L7:
        setDrawerLayoutProperty(r101, r102);
        return;
    L5:
        if (r102.getChildAt(1) == null) goto L7;
        r102.getChildAt(1).setPadding(0, getStatusBarHeight(r100), 0, 0);
        goto L7
    }

    public static void setTransparentForImageView(Activity r100, View r101) {
        setTranslucentForImageView(r100, 0, r101);
    }

    public static void setTransparentForImageViewInFragment(Activity r100, View r101) {
        setTranslucentForImageViewInFragment(r100, 0, r101);
    }

    private static View createStatusBarView(Activity r100, int r101, int r102) {
        View r103 = new View(r100);
        r103.setLayoutParams(new LinearLayout.LayoutParams(-1, getStatusBarHeight(r100)));
        r103.setBackgroundColor(calculateStatusColor(r101, r102));
        r103.setId(FAKE_STATUS_BAR_VIEW_ID);
        return r103;
    }

    public static void setColor(Activity r100, int r101, int r102) {
        r100.getWindow().addFlags(Integer.MIN_VALUE);
        r100.getWindow().clearFlags(67108864);
        r100.getWindow().setStatusBarColor(calculateStatusColor(r101, r102));
    }

    public static void setColorForDrawerLayout(Activity r100, DrawerLayout r101, int r102) {
        setColorForDrawerLayout(r100, r101, r102, 112);
    }

    public static void setColorForDrawerLayoutDiff(Activity r100, DrawerLayout r101, int r102) {
        r100.getWindow().addFlags(67108864);
        ViewGroup r103 = (ViewGroup) r101.getChildAt(0);
        View r104 = r103.findViewById(FAKE_STATUS_BAR_VIEW_ID);
        if (r104 != null) goto L5;
        r103.addView(createStatusBarView(r100, r102), 0);
    L10:
        if ((r103 instanceof LinearLayout) == false) goto L12;
    L14:
        setDrawerLayoutProperty(r101, r103);
        return;
    L12:
        if (r103.getChildAt(1) == null) goto L14;
        r103.getChildAt(1).setPadding(0, getStatusBarHeight(r100), 0, 0);
        goto L14
    L5:
        if (r104.getVisibility() != 8) goto L7;
        r104.setVisibility(0);
    L7:
        r104.setBackgroundColor(calculateStatusColor(r102, 112));
        goto L10
    }

    public static void setColorForSwipeBack(Activity r100, int r101, int r102) {
        ViewGroup r103 = (ViewGroup) r100.findViewById(R.id.content);
        View r104 = r103.getChildAt(0);
        int r105 = getStatusBarHeight(r100);
        if (r104 != null) goto L5;
    L7:
        r103.setPadding(0, r105, 0, 0);
        r103.setBackgroundColor(calculateStatusColor(r101, r102));
    L8:
        setTransparentForWindow(r100);
        return;
    L5:
        if ((r104 instanceof CoordinatorLayout) == false) goto L7;
        ((CoordinatorLayout) r104).setStatusBarBackgroundColor(calculateStatusColor(r101, r102));
        goto L8
    }

    public static void setColorNoTranslucentForDrawerLayout(Activity r100, DrawerLayout r101, int r102) {
        setColorForDrawerLayout(r100, r101, r102, 0);
    }

    public static void setTranslucentForDrawerLayout(Activity r100, DrawerLayout r101, int r102) {
        setTransparentForDrawerLayout(r100, r101);
        addTranslucentView(r100, r102);
    }

    public static void setTranslucentForImageView(Activity r100, int r101, View r102) {
        setTransparentForWindow(r100);
        addTranslucentView(r100, r101);
        if (r102 == null) goto L11;
        Object r103 = r102.getTag(-123);
        if (r103 != null) goto L7;
    L9:
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r102.getLayoutParams();
        r104.setMargins(r104.leftMargin, r104.topMargin + getStatusBarHeight(r100), r104.rightMargin, r104.bottomMargin);
        r102.setTag(-123, Boolean.TRUE);
        return;
    L7:
        if (((Boolean) r103).booleanValue() == false) goto L9;
        return;
    }

    public static void setTranslucentForImageViewInFragment(Activity r100, int r101, View r102) {
        setTranslucentForImageView(r100, r101, r102);
    }

    public static void setColorForDrawerLayout(Activity r100, DrawerLayout r101, int r102, int r103) {
        r100.getWindow().addFlags(Integer.MIN_VALUE);
        r100.getWindow().clearFlags(67108864);
        r100.getWindow().setStatusBarColor(0);
        ViewGroup r104 = (ViewGroup) r101.getChildAt(0);
        View r105 = r104.findViewById(FAKE_STATUS_BAR_VIEW_ID);
        if (r105 != null) goto L5;
        r104.addView(createStatusBarView(r100, r102), 0);
    L10:
        if ((r104 instanceof LinearLayout) == false) goto L12;
    L14:
        setDrawerLayoutProperty(r101, r104);
        addTranslucentView(r100, r103);
        return;
    L12:
        if (r104.getChildAt(1) == null) goto L14;
        r104.getChildAt(1).setPadding(r104.getPaddingLeft(), getStatusBarHeight(r100) + r104.getPaddingTop(), r104.getPaddingRight(), r104.getPaddingBottom());
        goto L14
    L5:
        if (r105.getVisibility() != 8) goto L7;
        r105.setVisibility(0);
    L7:
        r105.setBackgroundColor(r102);
        goto L10
    }
}
