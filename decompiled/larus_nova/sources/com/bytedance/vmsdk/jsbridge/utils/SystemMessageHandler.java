package com.bytedance.vmsdk.jsbridge.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class SystemMessageHandler extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f272504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f272505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Method f272506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f272507d;

    private native void nativeRunWork(long r100);

    private void stop() {
        this.f272505b = false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.Message");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.Message");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.Message");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.Message");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.Message");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.Message");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.Message");
    }

    private void scheduleWork() {
        Message r100 = Message.obtain();
        r100.what = 1;
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 22) goto L6;
        r100.setAsynchronous(true);
    L27:
        sendMessage(r100);
        return;
    L6:
        if (this.f272507d == true) goto L18;
        if (r101 < 22) goto L29;
    L17:
        this.f272507d = true;
        goto L18
    L29:
        this.f272506c = a().getMethod("setAsynchronous", new Class[]{Boolean.TYPE});     // Catch: RuntimeException -> L11 NoSuchMethodException -> L13 ClassNotFoundException -> L15
    L15:
        e = move-exception;
        e.toString();
    L13:
        e = move-exception;
        e.toString();
    L11:
        e = move-exception;
        e.toString();
    L18:
        Method r102 = this.f272506c;
        if (r102 == null) goto L27;
        r102.invoke(r100, new Object[]{Boolean.TRUE});     // Catch: IllegalAccessException -> L23 RuntimeException -> L24 IllegalArgumentException -> L25 InvocationTargetException -> L26
    L23:
        this.f272506c = null;
    L25:
        this.f272506c = null;
    L24:
        this.f272506c = null;
    L26:
        this.f272506c = null;
        goto L27
    }

    public SystemMessageHandler(long r100) {
        this.f272504a = 0;
        this.f272507d = false;
        this.f272504a = r100;
        this.f272505b = true;
    }

    public static SystemMessageHandler create(long r100) {
        return new SystemMessageHandler(r100);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        if (this.f272505b == false) goto L6;
        nativeRunWork(this.f272504a);
        return;
    }
}
