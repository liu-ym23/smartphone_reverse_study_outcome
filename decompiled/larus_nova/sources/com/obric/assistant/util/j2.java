package com.obric.assistant.util;

import android.app.Activity;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public final class j2 implements f09.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OrionChatExtensionUtils f393752a;

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public final void onAppBackground() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.larus.home.impl.MainActivity");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.larus.home.impl.MainActivity");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.larus.home.impl.MainActivity");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.larus.home.impl.MainActivity");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.larus.home.impl.MainActivity");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.larus.home.impl.MainActivity");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.larus.home.impl.MainActivity");
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        Class<? extends Activity> r100 = a();     // Catch: Exception -> L6
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type java.lang.Class<out android.app.Activity>");     // Catch: Exception -> L6
        if (AppHost.f326268a.a().h(r100) == true) goto L11;
        OrionChatExtensionUtils.l(this.f393752a);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        FLogger.f375446a.e(this.f393752a.f393639a, "onAppForeground error", e);
    }

    public j2(OrionChatExtensionUtils r100) {
        this.f393752a = r100;
    }
}
