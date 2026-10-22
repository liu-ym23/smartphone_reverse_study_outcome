package com.bytedance.timonbase.scene.silenceimpl;

import android.view.View;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.report.TMMetric;
import com.bytedance.timonbase.scene.ScenesDetector;
import com.bytedance.timonbase.utils.TMThreadUtils;
import com.bytedance.timonbase.utils.WindowManagerGlobalUtil;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public final class WindowManagerGlobalInfiltrator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f270889a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WindowManagerGlobalInfiltrator f270890b = null;

    public static final class a implements WindowManagerGlobalUtil.a {
        public a() {
        }

        @Override // com.bytedance.timonbase.utils.WindowManagerGlobalUtil.a
        public final void a() {
        }

        @Override // com.bytedance.timonbase.utils.WindowManagerGlobalUtil.a
        public final void b(View r100) {
            com.bytedance.timonbase.scene.silenceimpl.a.f270895e.getClass();
            com.bytedance.timonbase.scene.silenceimpl.a.b(r100);
        }
    }

    public WindowManagerGlobalInfiltrator() {
    }

    static {
        f270890b = new WindowManagerGlobalInfiltrator();
        f270889a = WindowManagerGlobalInfiltrator.class.getSimpleName();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.view.WindowManagerGlobal");
    }

    public static void b() {
        TMMetric.e(0, "");
        if (TMEnv.f270782p == true) goto L5;
        Class r100 = a();     // Catch: Exception -> L14
        Field r101 = r100.getDeclaredField("mViews");     // Catch: Exception -> L14
        r101.setAccessible(true);     // Catch: Exception -> L14
        Object r102 = r100.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L14
        Object r103 = r101.get(r102);     // Catch: Exception -> L14
        if (r103 == null) goto L13;
        r101.set(r102, new AdHocListForInfiltration((ArrayList) r103));     // Catch: Exception -> L14
        return;
    L13:
        throw new TypeCastException("null cannot be cast to non-null type java.util.ArrayList<android.view.View>");     // Catch: Exception -> L14
    L14:
        e = move-exception;
        int r104 = com.bytedance.timonbase.b.f270799a;
        com.bytedance.timonbase.b.d(f270889a, e.getMessage(), e.getCause());
        TMThreadUtils r105 = TMThreadUtils.f270906d;
        Function0<Unit> r106 = new WindowManagerGlobalInfiltrator$infiltrate$2(e);
        r105.getClass();
        TMThreadUtils.a(r106);
        boolean r107 = ScenesDetector.f270865a;
        ScenesDetector.d("infiltrate:" + e.getMessage(), -2);
        return;
    L5:
        if (((Boolean) WindowManagerGlobalUtil.f270907a.getValue()).booleanValue() == false) goto L7;
        WindowManagerGlobalUtil.f270908b.add(new a());
        return;
    L7:
        boolean r108 = ScenesDetector.f270865a;
        ScenesDetector.d("infiltrate: WindowManagerGlobalUtil init failed", -2);
    }
}
