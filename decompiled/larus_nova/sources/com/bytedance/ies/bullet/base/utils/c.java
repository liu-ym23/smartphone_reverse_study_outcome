package com.bytedance.ies.bullet.base.utils;

import com.bytedance.env.api.EnvManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Boolean f246325a;

    public static final class a {
        public static com.bytedance.env.api.d b() {
            if (c.f246325a != null) goto L21;
            monitor-enter(c.class);
        L17:
            th = move-exception;
            throw th;
        L7:
            if (c.f246325a != null) goto L14;
            Boolean r100 = c.f246325a;     // Catch: Throwable -> L17
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
            a("com.bytedance.env.api.GeckoConfig");     // Catch: Throwable -> L11
            Object r102 = Result.m9449constructorimpl(a("com.bytedance.env.core.impl.EnvManagerApiImpl"));     // Catch: Throwable -> L11
        L13:
            c.f246325a = Boolean.valueOf(Result.m9456isSuccessimpl(r102));     // Catch: Throwable -> L17
            goto L14
        L11:
            th = move-exception;
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L17
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L17
        L14:
            Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L17
            monitor-exit(c.class);
        L21:
            if (Intrinsics.areEqual(c.f246325a, Boolean.TRUE) == false) goto L23;
            EnvManager.Companion.getClass();
            return EnvManager.a.a().getGeckoConfig();
        L23:
            return null;
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

    static {
    }

    public c() {
    }
}
