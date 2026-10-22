package com.ss.android.account;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sdk.account.dialog.Gravity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.badger.AccountBadger;
import com.ss.android.token.TokenFactory;
import com.ss.android.token.h0;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Pair;
import kotlin.reflect.KProperty;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f406317a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile wqa.f f406318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile wqa.h f406319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile wqa.c f406320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f406321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f406322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f406323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile boolean f406324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile ExecutorService f406325i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final wqa.b f406326j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f406327k;

    /* JADX INFO: loaded from: classes34.dex */
    public static class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.b();     // Catch: Throwable -> L4
            rgc.b.b(sgc.a.class, com.ss.android.account.b.z0());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class b extends Handler {
        public b(Looper r100) {
            super(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            switch(r100.what) {
                case 2001: goto L11;
                case 2002: goto L9;
                case 2003: goto L5;
                default: goto L17;
            };
        L5:
            Object r101 = r100.obj;
            if (r101 == null) goto L18;
            Gravity r102 = Gravity.CENTER;
            hb7.b r103 = new hb7.b("！！重要提醒！！", r101.toString(), new hb7.a("我知道了", null, 6, 0), null, false);
            com.bytedance.sdk.account.utils.b.f269536a.a(r103);
            return;
        L18:
            return;
        L9:
            k.f406318b.isLocalTest();
            return;
        L17:
            return;
        L11:
            if (TokenFactory.E == true) goto L16;
            k.f406318b.isLocalTest();
            com.bytedance.sdk.account.monitor.a.a("never_call_token_init", null);
            return;
        }
    }

    public k() {
    }

    static {
        f406317a = new b(Looper.getMainLooper());
        f406321e = false;
        f406326j = new wqa.b();
        f406327k = 0;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.ss.android.account.adapter.InternalAccountAdapter");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.ss.android.account.adapter.InternalAccountAdapter");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.ss.android.account.adapter.InternalAccountAdapter");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.ss.android.account.adapter.InternalAccountAdapter");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.ss.android.account.adapter.InternalAccountAdapter");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.ss.android.account.adapter.InternalAccountAdapter");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.ss.android.account.adapter.InternalAccountAdapter");
    }

    public static void b() {
        f406326j.a("DoComponentReflectionStart", 0, new Pair[0]);
        a().getMethod("init", new Class[]{Context.class}).invoke(null, new Object[]{f406318b.getApplicationContext()});     // Catch: Exception -> L5
    L7:
        f406326j.a("DoComponentReflectionEnd", 0, new Pair[0]);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static Context c() {
        if (f406318b != null) goto L7;
        return null;
    L7:
        return f406318b.getApplicationContext();
    }

    public static wqa.f d() {
        if (f406318b == null) goto L7;
        return f406318b;
    L7:
        throw new IllegalStateException("not init TTAccount config");
    }

    public static void e(boolean r100) {
        if (r100 == false) goto L4;
        f406317a.postDelayed(new a(), 5000);
    L6:
        if (h0.d(f406318b.getApplicationContext()) == false) goto L14;
        b r101 = f406317a;
        r101.sendEmptyMessageDelayed(2001, 60000);
        r101.sendEmptyMessageDelayed(2002, 10000);
        KProperty[] r102 = AccountBadger.f407244a;
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.H == true) goto L11;
        return;
    L11:
        if (AccountBadger.f407246c.compareAndSet(false, true) == false) goto L15;
        ThreadPlus.submitRunnable(com.ss.android.badger.c.f407251a);
        return;
    L15:
        return;
    L14:
        return;
    L4:
        b();
        rgc.b.b(sgc.a.class, com.ss.android.account.b.z0());
        goto L6
    }
}
