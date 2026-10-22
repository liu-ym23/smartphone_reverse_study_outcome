package com.obric.aiagent.assistant.utils;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f384627j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile i f384628k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f384629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f384630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f384631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f384632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f384633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f384634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f384635g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f384636h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f384637i;

    public static final class a {
        public a() {
        }
    }

    static {
        f384627j = new a();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.app.role.OnRoleHoldersChangedListener");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.role.OnRoleHoldersChangedListener");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.role.OnRoleHoldersChangedListener");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.app.role.OnRoleHoldersChangedListener");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.role.OnRoleHoldersChangedListener");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.role.OnRoleHoldersChangedListener");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.role.OnRoleHoldersChangedListener");
    }

    public i(Context r100) {
        this.f384629a = r100;
        this.f384630b = LazyKt.lazy(new e(this));
        this.f384631c = LazyKt.lazy(new f());
        this.f384633e = LazyKt.lazy(new g(this));
        this.f384634f = LazyKt.lazy(new h(this));
    }

    public final void b(Class<?> r100) {
        final int r101 = System.identityHashCode(this);
        InvocationHandler r102 = new d(r101, this);
        this.f384632d = Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, r102);
    }
}
