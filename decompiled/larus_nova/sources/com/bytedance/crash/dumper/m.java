package com.bytedance.crash.dumper;

import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final m f203179j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c[] f203180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c[] f203181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f203182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Class f203183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f203184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f203185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Field f203186g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f203187h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f203188i;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f203189a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f203189a.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(m r100) {
            this.f203189a = r100;
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public class b implements Comparator<c> {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(c r100, c r101) {
            long r102 = r100.f203190a;
            long r103 = r101.f203190a;
            if (r102 <= r103) goto L5;
            return -1;
        L5:
            if (r102 != r103) goto L7;
            return 0;
        L7:
            return 1;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f203190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f203191b;

        public c() {
        }
    }

    public final synchronized void b() {
        monitor-enter(this);
        c r100 = this.f203180a[this.f203182c];     // Catch: Throwable -> L6
        r100.f203190a = 0;     // Catch: Throwable -> L6
        r100.f203191b = 0;     // Catch: Throwable -> L6
        r100.f203190a = System.currentTimeMillis();     // Catch: Throwable -> L6
        c r101 = this.f203180a[this.f203182c];     // Catch: Throwable -> L6
        r101.f203191b = d();     // Catch: Throwable -> L6
        this.f203182c = (this.f203182c + 1) % 10;     // Catch: Throwable -> L6
        wh4.b.postDelayed(this.f203188i, 3000);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        f203179j = new m();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.ActivityThread");
    }

    public final int d() {
        if (this.f203184e != null) goto L6;
        Class r100 = a();     // Catch: Throwable -> L20
        this.f203183d = r100;     // Catch: Throwable -> L20
        Method r101 = com.bytedance.crash.util.e.b(r100, "currentActivityThread");     // Catch: Throwable -> L20
        r101.setAccessible(true);     // Catch: Throwable -> L20
        this.f203184e = r101.invoke(this.f203183d, new Object[0]);     // Catch: Throwable -> L20
    L6:
        if (Build.VERSION.SDK_INT < 29) goto L12;
        if (this.f203186g != null) goto L10;
        this.f203186g = com.bytedance.crash.util.e.a(this.f203183d);     // Catch: Throwable -> L20
    L10:
        this.f203186g.setAccessible(true);     // Catch: Throwable -> L20
        return ((Integer) this.f203186g.get(this.f203184e)).intValue();
    L12:
        if (this.f203185f != null) goto L14;
        Method r102 = com.bytedance.crash.util.e.b(this.f203183d, "getApplicationThread");     // Catch: Throwable -> L20
        r102.setAccessible(true);     // Catch: Throwable -> L20
        Object r103 = r102.invoke(this.f203184e, new Object[0]);     // Catch: Throwable -> L20
        this.f203185f = r103;     // Catch: Throwable -> L20
        this.f203186g = com.bytedance.crash.util.e.a(r103.getClass());     // Catch: Throwable -> L20
    L14:
        Field r104 = this.f203186g;     // Catch: Throwable -> L20
        if (r104 == null) goto L18;
        r104.setAccessible(true);     // Catch: Throwable -> L20
        return ((Integer) this.f203186g.get(this.f203185f)).intValue();
    L18:
        return -1;
    }

    public m() {
        this.f203180a = new c[10];
        this.f203181b = new c[10];
        this.f203182c = 0;
        this.f203184e = null;
        this.f203185f = null;
        this.f203186g = null;
        this.f203187h = false;
        this.f203188i = new a(this);
    }

    public final void c(File r100) {
        if (this.f203187h == true) goto L33;
        return;
    L33:
        wh4.b.f(this.f203188i);     // Catch: Throwable -> L28
        b();     // Catch: Throwable -> L28
        monitor-enter(this);     // Catch: Throwable -> L28
        c[] r101 = this.f203180a;     // Catch: Throwable -> L24
        monitor-enter(r101);     // Catch: Throwable -> L24
        int r102 = 0;
    L11:
        if (r102 >= 10) goto L13;
        this.f203181b[r102] = this.f203180a[r102];     // Catch: Throwable -> L21
        r102 = r102 + 1;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
        goto L36
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L28
        StringBuilder r103 = new StringBuilder();     // Catch: Throwable -> L28
        Arrays.sort(this.f203181b, new b());     // Catch: Throwable -> L28
        int r104 = 0;
    L16:
        c[] r105 = this.f203181b;     // Catch: Throwable -> L28
        if (r104 >= r105.length) goto L19;
        r103.append(r105[r104].f203190a);     // Catch: Throwable -> L28
        r103.append(",");     // Catch: Throwable -> L28
        r103.append(this.f203181b[r104].f203191b);     // Catch: Throwable -> L28
        r103.append("\n");     // Catch: Throwable -> L28
        r104 = r104 + 1;     // Catch: Throwable -> L28
        goto L16
    L19:
        com.bytedance.crash.util.h.h(new PolarisFileWrapper(r100, "process_state.txt"), r103.toString(), false);     // Catch: Throwable -> L28
        return;
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    }
}
