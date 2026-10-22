package com.ss.android.tecommonenvinitializer;

import android.app.Application;
import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.tecommonenvinitializer.diagnosis.d;
import com.ss.android.tecommonenvinitializer.diagnosis.e;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public final class MultiMediaEnv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f449589a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f449590b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile int f449591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<d> f449592d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static WeakReference<Context> f449593e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static MultiMediaEnvContext$HostBuildType f449594f;

    public static final class a {
        public final Context getContext() {
            WeakReference<Context> r100 = MultiMediaEnv.f449593e;
            if (r100 != null) goto L6;
            return null;
        L6:
            return r100.get();
        }

        public a() {
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
    }

    public static final Context getContext() {
        return f449589a.getContext();
    }

    static {
        f449589a = new a();
        List<String> r100 = CollectionsKt.listOf(new String[]{"com.ss.android.ugc.aweme.local_test.impl.LocalTest", "com.ss.android.ugc.sicily.localtest.api.LocalTestService"});
        f449590b = r100;
        f449592d = LazyKt.lazy(MultiMediaEnv$Companion$diagnosis$2.INSTANCE);
        MultiMediaEnvContext$BundleType r101 = MultiMediaEnvContext$BundleType.INTEGRATION;
        f449594f = MultiMediaEnvContext$HostBuildType.OFFICIAL;
        if (f449591c == 1) goto L46;
        List<String> r102 = r100;
        boolean r103 = false;
        if ((r102 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r104 = r102.iterator();
    L11:
        if (r104.hasNext() == false) goto L20;
        String r105 = (String) r104.next();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L15
        Object r107 = Result.m9449constructorimpl(a.a(r105));     // Catch: Throwable -> L15
    L18:
        if (Result.m9456isSuccessimpl(r107) == false) goto L11;
        boolean r108 = true;
    L21:
        if (r108 == false) goto L23;
        MultiMediaEnvContext$HostBuildType r109 = MultiMediaEnvContext$HostBuildType.INTERNAL;
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        f449594f = r109;
        f449592d.getValue().f449601a = true;
    L23:
        Context r110 = null;
        Class r111 = a.a("android.app.ActivityThread");     // Catch: Exception -> L29
        Field r112 = r111.getDeclaredField("mInitialApplication");     // Catch: Exception -> L29
        Object r113 = r111.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L29
        r112.setAccessible(true);     // Catch: Exception -> L29
        Object r114 = r112.get(r113);     // Catch: Exception -> L29
        if (r114 == null) goto L28;
        r110 = ((Application) r114).getApplicationContext();     // Catch: Exception -> L29
    L31:
        f449593e = new WeakReference(r110);
        if (e.f449609g == true) goto L34;
    L36:
        if (r103 == false) goto L38;
        f449592d.getValue().f449602b = true;
    L38:
        f449591c = 2;
        return;
    L34:
        if (e.f449603a == true) goto L36;
        r103 = true;
        goto L36
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");     // Catch: Exception -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
    L15:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L20:
        r108 = false;
        goto L21
    L7:
        if (r102.isEmpty() == false) goto L9;
    }
}
