package com.obric.miniapp.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Vibrator;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Icons;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.miniapp.view.CalendarMiniAppActivity;
import com.obric.miniapp.view.MiniAppBaseActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public final class MiniAppUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MiniAppUtils f398427a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f398428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f398429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Job f398430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f398431e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f398432f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f398433g = null;

    public MiniAppUtils() {
    }

    static {
        f398427a = new MiniAppUtils();
        f398431e = LazyKt.lazy(new s0());
        f398432f = LazyKt.lazy(new t0());
        f398433g = LazyKt.lazy(new u0());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("bytedanceos.api.VibratorSmt");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("bytedanceos.api.VibratorSmt");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("bytedanceos.api.VibratorSmt");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("bytedanceos.api.VibratorSmt");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("bytedanceos.api.VibratorSmt");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("bytedanceos.api.VibratorSmt");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("bytedanceos.api.VibratorSmt");
    }

    public static void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "effect");
        FLogger.f375446a.i("MiniAppUtils", "performVibratorSmtFeedback ".concat(r100));
        Class r101 = (Class) f398432f.getValue();     // Catch: Exception -> L8
        if (r101 == null) goto L10;
        Field r102 = r101.getField(r100);     // Catch: Exception -> L8
        if (r102 == null) goto L10;
        Integer r103 = Integer.valueOf(r102.getInt(null));     // Catch: Exception -> L8
    L11:
        if (r103 == null) goto L20;
        int r104 = r103.intValue();     // Catch: Exception -> L8
        Method r105 = (Method) f398433g.getValue();     // Catch: Exception -> L8
        if (r105 == null) goto L21;
        r105.invoke(null, new Object[]{(Vibrator) f398431e.getValue(), Integer.valueOf(r104)});     // Catch: Exception -> L8
        return;
    L21:
        return;
    L20:
        return;
    L10:
        r103 = null;
    L8:
        e = move-exception;
        FLogger.f375446a.e("MiniAppUtils", "vibrator invoke failed", e);
    }

    public static void h(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r100 = f398428b;
        String r101 = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
        if (Intrinsics.areEqual(r100, "com.flow.music.auth") == false) goto L9;
        r101 = "//flow/applet/music";
    L12:
        if (r101.length() <= 0) goto L14;
        boolean r102 = true;
    L15:
        if (r102 == false) goto L23;
        Job r103 = f398430d;
        if (r103 != null) goto L19;
    L21:
        String r104 = f398429c;
        f398430d = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new MiniAppUtils$routeToApplet$2(r110, r101, r104, null), 3, null);
        return;
    L19:
        if (r103.isCompleted() == true) goto L21;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
        goto L21
    L23:
        return;
    L14:
        r102 = false;
        goto L15
    L9:
        if (Intrinsics.areEqual(r100, "com.flow.calendar") == false) goto L12;
        r101 = "//flow/applet/calendar";
        goto L12
    }

    public static void d(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, IFlowAppIntentIDL.PARAM_APPLET_ID);
        SharedPreferences r102 = r100.getSharedPreferences("com.obric.miniapp.sp", 0);
        Intrinsics.checkNotNull(r102);
        SharedPreferences.Editor r103 = r102.edit();
        r103.remove("enter_count_" + r101);
        r103.apply();
    }

    public static boolean e(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, IFlowAppIntentIDL.PARAM_APPLET_ID);
        if (Build.VERSION.SDK_INT < 25) goto L15;
        ShortcutManager r102 = (ShortcutManager) r100.getSystemService(ShortcutManager.class);
        if (r102 == null) goto L22;
        Iterator<ShortcutInfo> r103 = r102.getPinnedShortcuts().iterator();
    L8:
        if (r103.hasNext() == false) goto L23;
        ShortcutInfo r104 = r103.next();
        if (Intrinsics.areEqual(r104.getId(), "miniapp." + r101) == true) goto L13;
        if (Intrinsics.areEqual(r104.getId(), r101) == false) goto L8;
        return true;
    L13:
        return true;
    L23:
        return false;
    L22:
        return false;
    L15:
        return false;
    }

    public static void g(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, IFlowAppIntentIDL.PARAM_APPLET_ID);
        SharedPreferences r102 = r100.getSharedPreferences("com.obric.miniapp.sp", 0);
        String r103 = "enter_count_" + r101;
        int r104 = r102.getInt(r103, 0) + 1;
        Intrinsics.checkNotNull(r102);
        SharedPreferences.Editor r105 = r102.edit();
        r105.putInt(r103, r104);
        r105.apply();
    }

    public static boolean i(ComponentActivity r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, IFlowAppIntentIDL.PARAM_APPLET_ID);
        if (Intrinsics.areEqual(r111, "com.flow.calendar") == false) goto L5;
        Pair r100 = new Pair(Integer.valueOf(R.string.mini_label_calendar), Integer.valueOf(R.drawable.icon_calendar));
    L6:
        int r101 = ((Number) r100.component1()).intValue();
        int r102 = ((Number) r100.component2()).intValue();
        if (r101 == 0) goto L38;
        if (r102 == 0) goto L38;
        int r103 = com.larus.utils.j0.f375426a;
        String r104 = com.larus.utils.j0.d(r101);
        Drawable r105 = ContextCompat.getDrawable(r110.getApplication(), r102);
        if ((r105 instanceof BitmapDrawable) == false) goto L12;
        Bitmap r106 = ((BitmapDrawable) r105).getBitmap();
    L35:
        if (r106 == null) goto L38;
        r110.setTaskDescription(new ActivityManager.TaskDescription(r104, r106, 0));
        return true;
    L12:
        if (r105 != null) goto L14;
        r106 = null;
        goto L35
    L14:
        Integer r107 = Integer.valueOf(r105.getIntrinsicWidth());
        if (r107.intValue() <= 0) goto L17;
        boolean r108 = true;
    L18:
        if (r108 == true) goto L21;
        r107 = null;
    L21:
        if (r107 == null) goto L23;
        int r109 = r107.intValue();
    L24:
        Integer r112 = Integer.valueOf(r105.getIntrinsicHeight());
        if (r112.intValue() <= 0) goto L27;
        boolean r113 = true;
    L28:
        if (r113 == true) goto L31;
        r112 = null;
    L31:
        if (r112 == null) goto L33;
        int r114 = r112.intValue();
    L34:
        Bitmap r115 = Bitmap.createBitmap(r109, r114, Bitmap.Config.ARGB_8888);
        Canvas r116 = new Canvas(r115);
        r105.setBounds(0, 0, r116.getWidth(), r116.getHeight());
        r105.draw(r116);
        r106 = r115;
        goto L35
    L33:
        r114 = 1;
        goto L34
    L27:
        r113 = false;
        goto L28
    L23:
        r109 = 1;
        goto L24
    L17:
        r108 = false;
    L38:
        AppletRuntimeManager.INSTANCE.getClass();
        AppletRuntime r117 = AppletRuntimeManager.i("SYSTEM_CVS_ID", "SYSTEM_CVS_ID", r111);
        if (r117 == null) goto L41;
        Applet r118 = r117.f36719h;
    L42:
        if (r118 == null) goto L50;
        String r119 = r118.f36894a;
        Icons r120 = r118.f36900g;
        if (r120 == null) goto L50;
        String r121 = r120.get3x();
        if (r121 == null) goto L50;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r110), Dispatchers.getIO(), null, new MiniAppUtils$updateTaskDescription$1$1(r118, r121, r110, r119, null), 2, null);
        return true;
    L50:
        return false;
    L41:
        r118 = null;
        goto L42
    L5:
        r100 = new Pair(0, 0);
        goto L6
    }

    public final void c(Context r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, IFlowAppIntentIDL.PARAM_APPLET_ID);
        if (Intrinsics.areEqual(r111, "com.flow.calendar") == false) goto L6;
        b(this, r110, r111, R.string.mini_label_calendar, null, R.drawable.icon_calendar, null, 40);
        return;
    }

    public static void b(MiniAppUtils r100, Context r101, String r102, int r103, String r104, int r110, Bitmap r111, int r112) {
        boolean r105 = false;
        if ((r112 & 4) == 0) goto L6;
        r103 = 0;
    L6:
        if ((r112 & 8) == 0) goto L9;
        r104 = null;
    L9:
        if ((r112 & 16) == 0) goto L12;
        r110 = 0;
    L12:
        if ((r112 & 32) == 0) goto L14;
        r111 = null;
    L14:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, IFlowAppIntentIDL.PARAM_APPLET_ID);
        if (Intrinsics.areEqual(r102, "com.flow.calendar") == false) goto L17;
        Class r113 = CalendarMiniAppActivity.class;
    L18:
        Intent r106 = new Intent(r101.getApplicationContext(), r113);
        r106.putExtra("fromLauncher", true);
        r106.putExtra(IFlowAppIntentIDL.PARAM_APPLET_ID, r102);
        r106.setData(com.larus.utils.y0.j(r102));
        r106.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        int r107 = Build.VERSION.SDK_INT;
        if (r107 < 25) goto L45;
        ShortcutManager r114 = (ShortcutManager) ContextCompat.getSystemService(r101, ShortcutManager.class);
        if (r114 != null) goto L23;
        return;
    L23:
        if (r107 >= 26) goto L25;
        return;
    L25:
        if (r114.isRequestPinShortcutSupported() == false) goto L48;
        if (r104 != null) goto L28;
    L29:
        r105 = true;
    L30:
        if (r105 == false) goto L35;
        if (r103 == 0) goto L34;
        r104 = r101.getString(r103);
        goto L35
    L34:
        r104 = "unknown";
    L35:
        if (r111 == null) goto L37;
        Icon r108 = Icon.createWithBitmap(r111);
    L42:
        if (r108 == null) goto L49;
        r114.requestPinShortcut(new ShortcutInfo.Builder(r101, "miniapp." + r102).setShortLabel(r104).setIcon(r108).setIntent(r106).build(), null);
        return;
    L49:
        return;
    L37:
        if (r110 != 0) goto L39;
    L41:
        r108 = null;
        goto L42
    L39:
        if (Intrinsics.areEqual(r101.getResources().getResourceTypeName(r110), "drawable") == false) goto L41;
        r108 = Icon.createWithResource(r101, r110);
        goto L42
    L28:
        if (r104.length() != 0) goto L30;
    L48:
        return;
    L45:
        return;
    L17:
        r113 = MiniAppBaseActivity.class;
        goto L18
    }
}
