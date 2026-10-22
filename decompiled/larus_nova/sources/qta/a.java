package qta;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.dypay.activity.DyPayEntranceActivity;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.dypay.utils.i;
import com.ss.android.dypay.utils.k;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class a {
    public static int c(Context r100) {
        if (r100 != null) goto L5;
    L14:
        return 0;
    L5:
        if (r100.getResources() == null) goto L14;
        int r101 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");     // Catch: Exception -> L12
        int r102 = (int) r100.getResources().getDimension(r101);
        if (r102 >= 0) goto L11;
        return 0;
    L11:
        return r102;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static final void f(DyPayEntranceActivity r100, Intent r101, int r102, i.b r103, Function1 r104, i.d r105) {
    L26:
        e = move-exception;
        if (r104 == null) goto L37;
        String r106 = e.getMessage();     // Catch: Throwable -> L24
        if (r106 != null) goto L32;
        r106 = "start activity for result failed";
    L32:
        Unit r107 = (Unit) r104.invoke(r106);     // Catch: Throwable -> L24
    L37:
        if (r105 == null) goto L45;
    L38:
        Unit r108 = r105.invoke();
        return;
    L45:
        return;
    L3:
        if (r100.isFinishing() == false) goto L10;
        if (r104 == null) goto L6;
        Unit r109 = (Unit) r104.invoke("activity is finishing");     // Catch: Throwable -> L24 Exception -> L26
    L6:
        if (r105 == null) goto L42;
        Unit r110 = r105.invoke();
        return;
    L42:
        return;
    L10:
        if (r100.getWindowManager() != null) goto L12;
    L19:
        if (r104 == null) goto L21;
        Unit r111 = (Unit) r104.invoke("window manager is null");     // Catch: Throwable -> L24 Exception -> L26
    L21:
        if (r105 == null) goto L43;
        Unit r112 = r105.invoke();
        return;
    L43:
        return;
    L12:
        if (r100.getWindowManager().getDefaultDisplay() == null) goto L19;
        r100.startActivityForResult(r101, r102);     // Catch: Throwable -> L24 Exception -> L26
        if (r103 == null) goto L17;
        Unit r113 = r103.invoke();     // Catch: Throwable -> L24 Exception -> L26
    L17:
        if (r105 != null) goto L38;
        return;
    L24:
        th = move-exception;
        if (r105 == null) goto L36;
        Unit r114 = r105.invoke();
    L36:
        throw th;
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

    public static View b(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final void d(Activity r100) {
        if (r100 == null) goto L24;
        int[] r101 = {R.anim.dy_pay_activity_fade_in_animation, R.anim.dy_pay_activity_fade_no_animation};
        Map<String, Integer> r102 = com.ss.android.dypay.utils.d.f408483a;
        if (r102 != null) goto L6;
    L22:
        r100.overridePendingTransition(r101[0], r101[1]);
        return;
    L6:
        if (r102.containsKey(DyPayConstant.DY_PAY_SDK_ACTIVITY_FADE_IN_ANIMATION_KEY) == true) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == true) goto L14;
        r102 = null;
    L14:
        if (r102 == null) goto L22;
        Integer r104 = r102.get(DyPayConstant.DY_PAY_SDK_ACTIVITY_FADE_IN_ANIMATION_KEY);
        if (r104 != null) goto L18;
        Intrinsics.throwNpe();
    L18:
        r101[0] = r104.intValue();
        Integer r105 = r102.get(DyPayConstant.DY_PAY_SDK_ACTIVITY_FADE_OUT_ANIMATION_KEY);
        if (r105 != null) goto L21;
        Intrinsics.throwNpe();
    L21:
        r101[1] = r105.intValue();
        goto L22
    L8:
        if (r102.containsKey(DyPayConstant.DY_PAY_SDK_ACTIVITY_FADE_OUT_ANIMATION_KEY) == false) goto L10;
        r103 = true;
        goto L11
    }

    public static void e(Activity r100, View r110, boolean r111) {
        if (r110 == null) goto L66;
        boolean r101 = false;
        if (r111 == false) goto L6;
        r110.setPadding(0, c(r100), 0, 0);
    L7:
        int r112 = Build.VERSION.SDK_INT;
        if (r112 >= 23) goto L10;
        float r102 = 1.0f - (51 / 255.0f);
        int r103 = ((int) (((double) (255 * r102)) + 0.5d)) | (((((int) (((double) (255 * r102)) + 0.5d)) << 16) | (-16777216)) | (((int) (((double) (255 * r102)) + 0.5d)) << 8));
    L11:
        if (r112 >= 23) goto L13;
    L51:
        Window r104 = r100.getWindow();
        if (r104 != null) goto L55;
        return;
    L55:
        if (r104.getStatusBarColor() == r103) goto L68;
        r104.setStatusBarColor(r103);
        return;
    L68:
        return;
    L13:
        if (b(r100.getWindow()) == null) goto L51;
        View r113 = b(r100.getWindow());
        if (r113 == null) goto L62;
        int r114 = r113.getSystemUiVisibility();
        if ((r114 & 9216) == 9216) goto L62;
        r113.setSystemUiVisibility(r114 | 9216);
    L62:
        Window r105 = r100.getWindow();     // Catch: Throwable -> L39
        if (r105 == null) goto L40;
        if (k.f408504a == true) goto L34;
        if (a("miui.os.Build").getName().length() <= 0) goto L30;
        boolean r106 = true;
    L31:
        k.f408505b = r106;     // Catch: Exception -> L59 Throwable -> L39
        goto L32
    L30:
        r106 = false;
    L32:
        k.f408504a = true;     // Catch: Throwable -> L39
    L34:
        if (k.f408505b == false) goto L40;
        Class<?> r107 = r105.getClass();     // Catch: Throwable -> L39
        Class r108 = a("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L39
        int r109 = r108.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(r108);     // Catch: Throwable -> L39
        Class<?> r115 = Integer.TYPE;     // Catch: Throwable -> L39
        r107.getMethod("setExtraFlags", new Class[]{r115, r115}).invoke(r100.getWindow(), new Object[]{Integer.valueOf(r109), Integer.valueOf(r109)});     // Catch: Throwable -> L39
    L40:
        boolean r116 = k.f408504a;
        String r117 = Build.DISPLAY;
        if (TextUtils.isEmpty(r117) == true) goto L45;
        if (StringsKt.contains$default(r117, "Flyme", false, 2, null) == false) goto L45;
    L46:
        r101 = true;
    L47:
        if (r101 == false) goto L51;
        WindowManager.LayoutParams r118 = r100.getWindow().getAttributes();     // Catch: Throwable -> L50
        Field r119 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");     // Catch: Throwable -> L50
        Field r120 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");     // Catch: Throwable -> L50
        r119.setAccessible(true);     // Catch: Throwable -> L50
        r120.setAccessible(true);     // Catch: Throwable -> L50
        r120.setInt(r118, r119.getInt(null) | r120.getInt(r118));     // Catch: Throwable -> L50
        r100.getWindow().setAttributes(r118);     // Catch: Throwable -> L50
    L45:
        if (Intrinsics.areEqual("flyme", Build.USER) == false) goto L47;
    L10:
        r103 = 0;
        goto L11
    L6:
        r110.setPadding(0, 0, 0, 0);
        goto L7
    }

    public static void g(com.ss.android.dypay.webview.d r100, String r101, int r102, JSONObject r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = "success";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = 1;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = null;
    L11:
        com.ss.android.dypay.webview.a.C4736a r105 = (com.ss.android.dypay.webview.a.C4736a) r100;
        com.ss.android.dypay.webview.a r106 = r105.f408531a;
        if (r103 != null) goto L15;
        r103 = new JSONObject();
    L15:
        com.ss.android.dypay.webview.a.a(r106, r102, r101, r103, r105.f408532b);
    }
}
