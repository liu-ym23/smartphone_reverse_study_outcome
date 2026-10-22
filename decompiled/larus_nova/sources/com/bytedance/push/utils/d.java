package com.bytedance.push.utils;

import android.os.Handler;
import android.os.Message;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    public static class a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f267061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler.Callback f267062b;

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r100) {
            if (r100 != null) goto L25;
        L20:
            Handler.Callback r101 = this.f267062b;
            if (r101 != null) goto L23;
            return false;
        L23:
            return r101.handleMessage(r100);
        L25:
        L18:
            th = move-exception;
            th.printStackTrace();
            goto L20
        L5:
            if (f.f267065a == false) goto L7;
            f.b("PushJobService", "handleMsg what = " + r100.what);     // Catch: Throwable -> L18
        L7:
            Handler.Callback r102 = this.f267062b;     // Catch: Throwable -> L18
            if (r102 == null) goto L10;
            boolean r103 = r102.handleMessage(r100);     // Catch: Throwable -> L18
        L12:
            if (r103 == false) goto L14;
            return true;
        L14:
            Handler r104 = this.f267061a;     // Catch: Throwable -> L18
            if (r104 == null) goto L17;
            r104.handleMessage(r100);     // Catch: Throwable -> L18
        L17:
            return true;
        L10:
            r103 = false;
            goto L12
        }

        public a(Handler r100, Handler.Callback r101) {
            this.f267061a = r100;
            this.f267062b = r101;
        }
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.app.job.JobService$JobHandler");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.job.JobService$JobHandler");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.job.JobService$JobHandler");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.app.job.JobService$JobHandler");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.job.JobService$JobHandler");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.job.JobService$JobHandler");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.job.JobService$JobHandler");
    }
}
