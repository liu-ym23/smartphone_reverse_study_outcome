package com.bytedance.ug.sdk.luckydog.base.container;

import android.app.Application;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import me.ele.lancet.base.annotations.Skip;
import rk7.m;
import zl7.g;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile g f271724a;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class m() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.ug.sdk.lucky.container.LuckyDogContainerServiceImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.ug.sdk.lucky.container.LuckyDogContainerServiceImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.ug.sdk.lucky.container.LuckyDogContainerServiceImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.ug.sdk.lucky.container.LuckyDogContainerServiceImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.ug.sdk.lucky.container.LuckyDogContainerServiceImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.ug.sdk.lucky.container.LuckyDogContainerServiceImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.ug.sdk.lucky.container.LuckyDogContainerServiceImpl");
    }

    public final g x() {
        if (this.f271724a == null) goto L7;
        return this.f271724a;
    L7:
        monitor-enter(b.class);
    L24:
        th = move-exception;
        throw th;
    L9:
        if (this.f271724a != null) goto L17;
        g r100 = null;
        Object r101 = m().newInstance();     // Catch: Throwable -> L27
        if ((r101 instanceof g) == true) goto L14;
        r101 = null;
    L14:
        r100 = (g) r101;     // Catch: Throwable -> L27
    L16:
        this.f271724a = r100;     // Catch: Throwable -> L24
    L17:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(b.class);
        if (this.f271724a == null) goto L23;
        il7.g.e("LuckyDogContainerServiceImpl");
    L23:
        return this.f271724a;
    }

    @Override // zl7.g
    public final void d0() {
        g r100 = x();
        if (r100 == null) goto L6;
        r100.d0();
        return;
    }

    @Override // zl7.g
    public final float getDeviceScore() {
        g r100 = x();
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getDeviceScore();
    }

    @Override // zl7.g
    public final void o() {
        g r100 = x();
        if (r100 == null) goto L6;
        r100.o();
        return;
    }

    @Override // zl7.g
    public final void Z() {
        Application r100 = m.f538347a;
    }

    @Override // zl7.g
    public final void l() {
        Application r100 = m.f538347a;
    }

    @Override // zl7.g
    public final void s() {
        Application r100 = m.f538347a;
    }

    @Override // zl7.g
    public final void w() {
        Application r100 = m.f538347a;
    }
}
