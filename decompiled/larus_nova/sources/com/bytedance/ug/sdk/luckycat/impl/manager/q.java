package com.bytedance.ug.sdk.luckycat.impl.manager;

import android.app.Application;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f271356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f271357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f271358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<WebView> f271359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f271360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f271361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile fj7.a f271362g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f271363h;

    /* JADX INFO: loaded from: classes22.dex */
    public class a implements qj7.a.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f271364a;

        public a(q r100) {
            this.f271364a = r100;
        }

        public final void a(int r100, String r101) {
            this.f271364a.f271363h = true;
            this.f271364a.getClass();
            com.bytedance.ug.sdk.luckycat.impl.model.d.e(r100, r101);
            if (this.f271364a.f271362g == null) goto L6;
            ((ej7.a) this.f271364a.f271362g).a();
            this.f271364a.f271362g = null;
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f271365a = null;

        static {
            f271365a = new q();
        }
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.ug.sdk.luckycat.flower.FlowerSDKImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.ug.sdk.luckycat.flower.FlowerSDKImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.ug.sdk.luckycat.flower.FlowerSDKImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.ug.sdk.luckycat.flower.FlowerSDKImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.ug.sdk.luckycat.flower.FlowerSDKImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.ug.sdk.luckycat.flower.FlowerSDKImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.ug.sdk.luckycat.flower.FlowerSDKImpl");
    }

    public static c96.c b() {
        m r100 = m.a.f271349a;
        String r101 = r100.i();
        int r102 = r100.g();
        ti7.b r103 = r100.h();
        if (r103 == null) goto L5;
        String r104 = r103.f546218c;
        String r105 = r103.f546217b;
    L6:
        c96.a r106 = new c96.a(String.valueOf(r102), r104, r101, r105);
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatManager", "getInteractiveConfig: " + r106.toString());
        c96.c r107 = new c96.c();
        r107.f22855d = "BDUG_BID";
        r107.f22854c = r100.f271344l;
        r107.f22852a = r106;
        r107.f22853b = new com.bytedance.ug.sdk.luckycat.impl.model.g();
        return r107;
    L5:
        r104 = "";
        r105 = "";
        goto L6
    }

    public final void f() {
        m r100 = m.a.f271349a;
        r100.m();
        if (ej7.b.a.f472883a.f472882b == false) goto L6;
        return;
    L6:
        if (r100.r() == false) goto L9;
        com.bytedance.ug.sdk.luckycat.impl.utils.u.a().h("key_had_try_show_big_red_packet", true);
        return;
    L9:
        rj7.c.a(new qj7.a(new a(this)));
    }

    public q() {
        this.f271357b = false;
        this.f271358c = false;
        this.f271359d = null;
        this.f271360e = false;
    }

    public static boolean c(String r100) {
        if (com.bytedance.ug.sdk.luckycat.utils.i.j(r100) == false) goto L5;
    L10:
        return true;
    L5:
        if (com.bytedance.ug.sdk.luckycat.utils.i.i(r100) == true) goto L10;
        if (com.bytedance.ug.sdk.luckycat.utils.i.h(r100) == true) goto L10;
        return false;
    }

    public final synchronized void d(String r100) {
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L4:
        if (this.f271358c == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (TextUtils.isEmpty(r100) == false) goto L11;
        monitor-exit(this);
        return;
    L11:
        cj7.a.b("update_did");     // Catch: Throwable -> L27
        this.f271358c = true;     // Catch: Throwable -> L27
        m r101 = m.a.f271349a;     // Catch: Throwable -> L27
        com.bytedance.ug.sdk.luckycat.impl.model.h.a(r101.f());     // Catch: Throwable -> L27
        ti7.a r102 = r101.f271342j;     // Catch: Throwable -> L27
        if (r102 == null) goto L14;
        boolean r103 = r102.f546215j;     // Catch: Throwable -> L27
    L16:
        if (r103 == false) goto L24;
        i r104 = i.a.f271322a;     // Catch: Throwable -> L27
        r104.getClass();     // Catch: Throwable -> L27
        LuckyCatSettingsManger r105 = LuckyCatSettingsManger.b.f271283a;     // Catch: Throwable -> L27
        r105.getClass();     // Catch: Throwable -> L27
        Object r106 = r105.c(new String[]{"common", "enable_intercept_network_request"});     // Catch: Throwable -> L27
        if ((r106 instanceof Boolean) == false) goto L20;
        boolean r107 = ((Boolean) r106).booleanValue();     // Catch: Throwable -> L27
    L21:
        if (r107 == false) goto L23;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("InitSettingManager", "init() enableInterceptNetworkRequest");     // Catch: Throwable -> L27
        goto L24
    L23:
        rj7.c.a(new qj7.b(new h(r104)));     // Catch: Throwable -> L27
        goto L24
    L20:
        r107 = false;
    L24:
        e(this.f271356a, true);     // Catch: Throwable -> L27
        f();     // Catch: Throwable -> L27
        r101.o();     // Catch: Throwable -> L27
        r101.p();     // Catch: Throwable -> L27
        com.bytedance.ug.sdk.luckycat.impl.model.e.c(0);     // Catch: Throwable -> L27
        xj7.a.a().b();     // Catch: Throwable -> L27
        com.bytedance.ug.sdk.luckycat.impl.utils.u.b(this.f271356a, "luckycat_product_configs.prefs").g("cache_did", r100);     // Catch: Throwable -> L27
        ak7.c.f4079b.m();     // Catch: Throwable -> L27
        com.bytedance.ug.sdk.luckycat.impl.model.f.a();     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L14:
        r103 = true;
        goto L16
    }

    public static void e(Application r100, boolean r101) {
        Set<String> r102 = to7.a.f546943k;
        to7.a.d.f546961a.i(r100, r101);
        l r103 = l.b.f271332a;
        if (r103.f271330a == true) goto L6;
        to7.c.d(r103);
        r103.f271330a = true;
    L6:
        boolean r104 = y.f271375a;
        if (y.f271375a == true) goto L11;
        r100.registerActivityLifecycleCallbacks(new x());
        y.f271375a = true;
        return;
    }
}
