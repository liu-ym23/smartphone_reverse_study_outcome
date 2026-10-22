package com.lynx.animax.util;

import android.content.Context;
import android.content.res.Resources;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import q4a.c;

/* JADX INFO: loaded from: classes32.dex */
public class AnimaX {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile AnimaX f380463d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f380464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f380465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f380466c;

    private native void nativeRegisterLogger(long r100);

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class b() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.ss.android.agilelogger.ALog");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.ss.android.agilelogger.ALog");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.ss.android.agilelogger.ALog");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.ss.android.agilelogger.ALog");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.ss.android.agilelogger.ALog");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.ss.android.agilelogger.ALog");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.ss.android.agilelogger.ALog");
    }

    public static AnimaX e() {
        if (f380463d != null) goto L15;
        monitor-enter(AnimaX.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f380463d != null) goto L9;
        f380463d = new AnimaX();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AnimaX.class);     // Catch: Throwable -> L11
    L15:
        return f380463d;
    }

    public AnimaX() {
        this.f380464a = false;
    }

    public static long c() {
        return ((Long) b().getMethod("getALogSimpleWriteFuncAddr", new Class[0]).invoke(null, new Object[0])).longValue();
    L4:
        e = move-exception;
        AnimaXLog.a("AnimaX", "No ALog found in the host [ " + e.getMessage() + " ]");
        return 0;
    }

    @JvmStatic
    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> ".concat(r100));
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> ".concat(r100));
    }

    public final void d(LynxAnimaX.a r100) {
        if (this.f380464a == true) goto L29;
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L6:
        if (this.f380464a == false) goto L9;
        monitor-exit(this);
    L26:
        return;
    L9:
        this.f380465b = r100;     // Catch: Throwable -> L22
        if (f("lynxbase") == true) goto L15;
        AnimaXLog.a("AnimaX", "AnimaX failed to load liblynxbase.so");     // Catch: Throwable -> L22
        monitor-exit(this);
        goto L26
    L15:
        if (f("animax") == true) goto L19;
        AnimaXLog.a("AnimaX", "AnimaX failed to load libanimax.so");     // Catch: Throwable -> L22
        monitor-exit(this);
        goto L26
    L19:
        f("animax_textra");     // Catch: Throwable -> L22
        f("animax_bytevc1");     // Catch: Throwable -> L22
        nativeRegisterLogger(c());     // Catch: Throwable -> L22
        this.f380464a = true;     // Catch: Throwable -> L22
        monitor-exit(this);
        goto L26
    }

    public final boolean f(String r100) {
        c r101 = this.f380465b;     // Catch: UnsatisfiedLinkError -> L9
        if (r101 == null) goto L6;
        ((LynxAnimaX.a) r101).f380471a.loadLibrary(r100);     // Catch: UnsatisfiedLinkError -> L9
        AnimaXLog.b("AnimaX", "Native library load " + r100 + " success with native library loader");     // Catch: UnsatisfiedLinkError -> L9
        return true;
    L6:
        a(r100);     // Catch: UnsatisfiedLinkError -> L9
        AnimaXLog.b("AnimaX", "Native library load " + r100 + " success with System.loadLibrary");     // Catch: UnsatisfiedLinkError -> L9
        return true;
    L9:
        e = move-exception;
        if (this.f380465b != null) goto L13;
        AnimaXLog.a("AnimaX", "Native library load " + r100 + " from system with error message " + e.getMessage());
        return false;
    L13:
        AnimaXLog.a("AnimaX", "Native Library load from " + this.f380465b.getClass().getName() + " with error message " + e.getMessage());
        return false;
    }

    public final void g(Context r100) {
        if (this.f380466c != null) goto L19;
        if (r100 == null) goto L20;
        this.f380466c = r100;
        Context r101 = e().f380466c;
        if (r101 == null) goto L8;
        Resources r102 = r101.getResources();
        float r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
    L10:
        if (y4a.a.f566165f == false) goto L12;
        return;
    L12:
        if (r103 < 2.0f) goto L14;
    L16:
        boolean r104 = false;
    L17:
        y4a.a.f566166g = r104;
        y4a.a.f566165f = true;
        return;
    L14:
        if (r103 <= 0.01f) goto L16;
        r104 = true;
        goto L17
    L8:
        AnimaXLog.a("AnimaX", "getDensity failed, context is null");
        r103 = 1.0f;
        goto L10
    L20:
        return;
    }
}
