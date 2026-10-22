package com.bytedance.bdp.bdpbase.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes11.dex */
public final class DevicesUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f201324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f201325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f201326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f201327d;

    public static final enum NotchResult extends Enum<NotchResult> {
        public static final NotchResult RET_FAIL = null;
        public static final NotchResult RET_FALSE = null;
        public static final NotchResult RET_TRUE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NotchResult[] f201328a = null;

        static {
            NotchResult r100 = new NotchResult("RET_FALSE", 0);
            RET_FALSE = r100;
            NotchResult r101 = new NotchResult("RET_TRUE", 1);
            RET_TRUE = r101;
            NotchResult r102 = new NotchResult("RET_FAIL", 2);
            RET_FAIL = r102;
            f201328a = new NotchResult[]{r100, r101, r102};
        }

        public static NotchResult[] values() {
            return (NotchResult[]) f201328a.clone();
        }

        public static NotchResult valueOf(String r100) {
            return (NotchResult) r27.a.a(NotchResult.class, r100);
        }

        public NotchResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static String c() {
        BufferedReader r100 = null;
        BufferedReader r101 = new BufferedReader(new InputStreamReader(b(Runtime.getRuntime(), "getprop ro.miui.ui.version.name").getInputStream()), 1024);     // Catch: Throwable -> L9 Exception -> L12
        String r102 = r101.readLine();     // Catch: Throwable -> L7 Exception -> L15
        r101.close();     // Catch: Throwable -> L7 Exception -> L15
        f.b(r101);
        return r102;
    L7:
        th = move-exception;
        th = th;
        r100 = r101;
    L10:
        f.b(r100);
        throw th;
    L13:
        f.b(r101);
        return null;
    L12:
        r101 = null;
    L9:
        th = th;
        goto L10
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
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
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
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

    public static int d(Context r100) {
        int r101 = f201327d;
        if (r101 <= 0) goto L5;
        return r101;
    L5:
        int r102 = c.f201330a;
        int r103 = 0;
        if (r102 == (-1)) goto L77;
        if (r102 != 1) goto L9;
        boolean r104 = true;
    L14:
        if (r104 == true) goto L39;
        int r105 = c.f201331b;
        if (r105 == (-1)) goto L75;
        if (r105 != 1) goto L19;
        int r106 = 1;
    L36:
        if (r106 != 0) goto L39;
        boolean r107 = false;
    L40:
        if (r107 == false) goto L43;
        int r108 = (int) o.a(r100, 27.0f);
        f201327d = r108;
        return r108;
    L43:
        int r109 = c.f201332c;
        if (r109 == (-1)) goto L79;
        if (r109 != 1) goto L47;
        boolean r110 = true;
    L52:
        if (r110 == false) goto L68;
        int r111 = c.f201333d;
        if (r111 != (-1)) goto L66;
        int[] r112 = {0, 0};
        if (r100 != null) goto L81;
    L62:
        r111 = r112[1];
        if (r111 > 0) goto L65;
        r111 = (int) o.a(r100, 28.0f);
    L65:
        c.f201333d = r111;
        goto L66
    L81:
        Class r113 = c.b(b.a());     // Catch: Throwable -> L61
        r112 = (int[]) r113.getMethod("getNotchSize", new Class[0]).invoke(r113, new Object[0]);     // Catch: Throwable -> L61
    L66:
        f201327d = r111;
        return r111;
    L68:
        int r114 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r114 <= 0) goto L71;
        r103 = r100.getResources().getDimensionPixelOffset(r114);
    L71:
        if (r103 != 0) goto L73;
        r103 = (int) o.a(r100, 25.0f);
    L73:
        f201327d = r103;
        return r103;
    L47:
        r110 = false;
        goto L52
    L79:
        Class r115 = c.b(b.a());     // Catch: Exception -> L50
        r110 = ((Boolean) r115.getMethod("hasNotchInScreen", new Class[0]).invoke(r115, new Object[0])).booleanValue();     // Catch: Exception -> L50
    L51:
        c.f201332c = r110 ? 1 : 0;
    L50:
        r110 = false;
        goto L51
    L19:
        r106 = 0;
        goto L36
    L75:
        if (TextUtils.equals(AppConstants.CHANNEL_OPPO, Build.BRAND.toLowerCase()) == false) goto L26;
        if (r100 == null) goto L26;
        boolean r116 = r100.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");     // Catch: Throwable -> L25
    L27:
        if (r116 == false) goto L34;
        if (r100 != null) goto L30;
        int r117 = 0;
    L32:
        if (r117 < 2280) goto L34;
        r106 = 1;
    L35:
        c.f201331b = r106;
        goto L36
    L30:
        DisplayMetrics r118 = new DisplayMetrics();
        ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getRealMetrics(r118);
        r117 = r118.heightPixels;
    L34:
        r106 = 0;
    L26:
        r116 = false;
    L39:
        r107 = true;
        goto L40
    L9:
        r104 = false;
        goto L14
    L77:
        Class r119 = c.a();     // Catch: Exception -> L12
        r104 = ((Boolean) r119.getDeclaredMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(r119, new Object[]{32})).booleanValue();     // Catch: Exception -> L12
    L13:
        c.f201330a = r104 ? 1 : 0;
    L12:
        r104 = false;
        goto L13
    }

    public static Process b(Runtime r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }
}
