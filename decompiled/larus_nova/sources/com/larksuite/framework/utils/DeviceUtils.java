package com.larksuite.framework.utils;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.log.Log;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes24.dex */
public class DeviceUtils {
    public static final int APP_MODE_DESKTOP = 2;
    public static final int APP_MODE_PHONE = 1;
    private static final int APP_MODE_UN_INIT = -1;
    public static final String PROPERTIES_KEY_CHARACTERISTICS = "ro.build.characteristics";
    private static final String TAG = "DeviceUtils";
    private static final String TAG_ANDROID_PAD = "tablet";
    private static volatile Boolean isSizeValid = null;
    private static int sCurrentMode = -1;
    private static List<String> sPadBlockList = null;
    private static List<String> sPadWhiteList = null;
    private static volatile float sScreenDensity = 0.0f;
    private static volatile int sScreenHeight = 0;
    private static volatile int sScreenWidth = 0;
    private static int sStatusHeight = -1;

    public class a implements ComponentCallbacks {
        public a() {
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r100) {
            DeviceUtils.access$002(Boolean.FALSE);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f285884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f285885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f285886c;

        public b(int r100, int r101, float r102) {
            this.f285884a = r100;
            this.f285885b = r101;
            this.f285886c = r102;
        }
    }

    public DeviceUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        sPadWhiteList = new ArrayList();
        sPadBlockList = new ArrayList();
    }

    public static String getAPIVersion() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    public static boolean isPad() {
        String r100 = Build.MODEL;
        if (sPadBlockList.contains(r100) == false) goto L6;
        return false;
    L6:
        if (sPadWhiteList.contains(r100) == false) goto L9;
        return true;
    L9:
        if (TAG_ANDROID_PAD.equals(getSystemPropertyByReflect(PROPERTIES_KEY_CHARACTERISTICS).toLowerCase()) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getRomVersion() {
        return Build.VERSION.INCREMENTAL;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_larksuite_framework_utils_DeviceUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public static View INVOKEVIRTUAL_com_larksuite_framework_utils_DeviceUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static /* synthetic */ Boolean access$002(Boolean r100) {
        isSizeValid = r100;
        return r100;
    }

    public static void enterFullScreen(Activity r100) {
        hideTitleBar(r100);
        setFullScreen(r100);
    }

    public static void exitFullScreen(Activity r100) {
        if (r100 == null) goto L5;
        r100.getWindow().clearFlags(1024);
        return;
    }

    public static int getApplicationWindowHeight(Context r100) {
        Rect r101 = new Rect();
        INVOKEVIRTUAL_com_larksuite_framework_utils_DeviceUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(((Activity) r100).getWindow()).getWindowVisibleDisplayFrame(r101);
        return r101.height();
    }

    public static int getCurrentMode(Context r100) {
        int r101 = sCurrentMode;
        if (r101 == (-1)) goto L6;
        return r101;
    L6:
        if (getDisplayId(r100) != 0) goto L8;
        int r102 = 1;
    L9:
        sCurrentMode = r102;
        return r102;
    L8:
        r102 = 2;
        goto L9
    }

    private static int getDisplayId(Context r100) {
        Display r101 = (Display) Context.class.getMethod("getDisplay", new Class[0]).invoke(r100, new Object[0]);     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        if (r101 == null) goto L16;
    L17:
        return r101.getDisplayId();
    L16:
        return 0;
    L9:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L11:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static int getRealScreenHeight(Context r100) {
        WindowManager r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r102 = new DisplayMetrics();
        r101.getDefaultDisplay().getRealMetrics(r102);
        return r102.heightPixels;
    }

    public static float getScreenDensity(Context r100) {
        int r101 = com.larksuite.framework.utils.autoscale.a.f285947a;
        if (getCurrentMode(r100) == 2) goto L5;
        refreshSizeIfNeed(r100);
        return sScreenDensity;
    L5:
        return getScreenSizeImpl(r100).f285886c;
    }

    public static int getScreenDensityDpi(Context r100) {
        int r101 = com.larksuite.framework.utils.autoscale.a.f285947a;
        WindowManager r102 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r103 = new DisplayMetrics();
        r102.getDefaultDisplay().getMetrics(r103);
        return r103.densityDpi;
    }

    public static int getScreenHeight(Context r100) {
        if (getCurrentMode(r100) == 2) goto L5;
        refreshSizeIfNeed(r100);
        return sScreenHeight;
    L5:
        return getScreenSizeImpl(r100).f285885b;
    }

    private static b getScreenSizeImpl(Context r100) {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        WindowManager r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        WindowMetrics r102 = r101.getMaximumWindowMetrics();
        Rect r103 = r102.getBounds();
        Insets r104 = r102.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
        int r105 = (r103.width() - r104.left) - r104.right;
        int r106 = (r103.height() - r104.top) - r104.bottom;
        DisplayMetrics r107 = new DisplayMetrics();
        r101.getDefaultDisplay().getRealMetrics(r107);
        float r108 = r107.scaledDensity;
    L7:
        return new b(r105, r106, r108);
    L5:
        WindowManager r109 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r110 = new DisplayMetrics();
        r109.getDefaultDisplay().getRealMetrics(r110);
        r105 = r110.widthPixels;
        int r111 = (r110.heightPixels - getStatusHeight(r100)) - UIUtils.getNavigationBarHeight(r100);
        float r112 = r110.scaledDensity;
        r106 = r111;
        r108 = r112;
        goto L7
    }

    public static int getScreenWidth(Context r100) {
        if (getCurrentMode(r100) == 2) goto L5;
        refreshSizeIfNeed(r100);
        return sScreenWidth;
    L5:
        return getScreenSizeImpl(r100).f285884a;
    }

    public static int getStatusHeight(Context r100) {
        int r101 = sStatusHeight;
        if (r101 == (-1)) goto L5;
        return r101;
    L5:
        Resources r102 = r100.getResources();
        int r103 = r102.getDimensionPixelSize(r102.getIdentifier("status_bar_height", "dimen", "android"));
        sStatusHeight = r103;
        if (r103 == (-1)) goto L17;
        return r103;
    L17:
        Class r104 = INVOKESTATIC_com_larksuite_framework_utils_DeviceUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.internal.R$dimen");     // Catch: Exception -> L10
        sStatusHeight = r100.getResources().getDimensionPixelSize(CastIntegerProtector.parseInt(r104.getField("status_bar_height").get(r104.newInstance()).toString()));     // Catch: Exception -> L10
    L13:
        if (sStatusHeight > 0) goto L16;
        Log.e(TAG, "getStatusHeight error, height is： " + sStatusHeight);
    L16:
        return sStatusHeight;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static String getSystemPropertyByReflect(String r100) {
        Class r101 = INVOKESTATIC_com_larksuite_framework_utils_DeviceUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L5
        return (String) r101.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r101, new Object[]{r100, ""});
    L5:
        return "";
    }

    public static void hideTitleBar(Activity r100) {
        if (r100 == null) goto L5;
        r100.requestWindowFeature(1);
        return;
    }

    private static void refreshSizeIfNeed(Context r100) {
        if (isSizeValid == null) goto L7;
        if (isSizeValid.booleanValue() == false) goto L7;
        return;
    L7:
        if (isSizeValid != null) goto L9;
        r100.getApplicationContext().registerComponentCallbacks(new a());
    L9:
        b r101 = getScreenSizeImpl(r100);
        sScreenWidth = r101.f285884a;
        sScreenHeight = r101.f285885b;
        sScreenDensity = r101.f285886c;
        isSizeValid = Boolean.TRUE;
    }

    public static void setFullScreen(Activity r100) {
        if (r100 == null) goto L5;
        r100.getWindow().setFlags(1024, 1024);
        return;
    }

    public static int getDpFromDimenXml(Context r100, int r101) {
        return (int) (r100.getResources().getDimension(r101) / getScreenDensity(r100));
    }

    public static void setPadConfig(List<String> r100, List<String> r101) {
        sPadWhiteList = r100;
        sPadBlockList = r101;
        Log.i(TAG, "setPadConfig: " + r100 + ", " + r101);
    }
}
