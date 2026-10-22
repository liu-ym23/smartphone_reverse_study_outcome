package com.obric.assistant.session.singleton;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f391664a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f391665b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Object f391666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f391667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f391668e;

    public d() {
    }

    static {
        f391664a = new d();
        f391665b = d.class.getSimpleName();
    }

    public static ComponentName b() {
        ComponentName r100 = null;
        Method r101 = f391668e;     // Catch: Throwable -> L23
        if (r101 == null) goto L30;
    L15:
        if (r101 == null) goto L17;
        Object r102 = r101.invoke(d(), new Object[0]);     // Catch: Throwable -> L23
    L18:
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.content.ComponentName");     // Catch: Throwable -> L23
        ComponentName r103 = (ComponentName) r102;     // Catch: Throwable -> L23
        FLogger.f375446a.i(f391665b, "getActiveServiceComponentName: " + r103);     // Catch: Throwable -> L21
        return r103;
    L21:
        th = th;
        r100 = r103;
    L24:
        FLogger.f375446a.e(f391665b, "getActiveServiceComponentName exception", th);
        return r100;
    L17:
        r102 = null;
        goto L18
    L30:
        Class r104 = c("com.android.internal.app.AssistUtils");     // Catch: Throwable -> L11
        if (r104 == null) goto L13;
        r101 = r104.getMethod("getActiveServiceComponentName", new Class[0]);     // Catch: Throwable -> L11
    L14:
        f391668e = r101;     // Catch: Throwable -> L23
        goto L15
    L13:
        r101 = null;
    L11:
        th = move-exception;
        FLogger.f375446a.e(f391665b, "get mGetActiveServiceComponentMethod exception", th);     // Catch: Throwable -> L23
    L23:
        th = th;
        goto L24
    }

    public static Object d() {
        Object r100 = f391666c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Object r101 = null;
        Class r102 = c("com.android.internal.app.AssistUtils");     // Catch: Throwable -> L13
        if (r102 == null) goto L9;
        Constructor r103 = r102.getDeclaredConstructor(new Class[]{Context.class});     // Catch: Throwable -> L13
    L10:
        if (r103 == null) goto L15;
        r101 = r103.newInstance(new Object[]{AppHost.f326268a.getApplication()});     // Catch: Throwable -> L13
    L15:
        f391666c = r101;
        return r101;
    L9:
        r103 = null;
    L13:
        th = move-exception;
        FLogger.f375446a.e(f391665b, "get mAssistUtils exception", th);
        goto L15
    }

    public static Method e() {
        Method r100 = f391667d;
        if (r100 == null) goto L14;
        return r100;
    L14:
        Class r101 = c("com.android.internal.app.AssistUtils");     // Catch: Throwable -> L9
        if (r101 == null) goto L11;
        Method r102 = r101.getMethod("showSessionForActiveService", new Class[]{Bundle.class, Integer.TYPE, c("com.android.internal.app.IVoiceInteractionSessionShowCallback"), IBinder.class});     // Catch: Throwable -> L9
    L12:
        f391667d = r102;
        return r102;
    L11:
        r102 = null;
    L9:
        th = move-exception;
        FLogger.f375446a.e(f391665b, "get mShowSessionMethod exception", th);
        goto L11
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

    public static Class c(String r100) {
        return a(r100);
    L4:
        th = move-exception;
        FLogger.f375446a.e(f391665b, "getClass failed for ".concat(r100), th);
        return null;
    }
}
