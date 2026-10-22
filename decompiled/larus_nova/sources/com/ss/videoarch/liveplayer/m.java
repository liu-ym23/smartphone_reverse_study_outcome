package com.ss.videoarch.liveplayer;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f459443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f459444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f459445e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Method f459446f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Method f459447g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Method f459448h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Method f459449i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Method f459450j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Method f459451k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Method f459452l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Method f459453m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Method f459454n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Method f459455o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static Method f459456p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f459457q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f459458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f459459b;

    public interface a {
        void onPreloadEvent(int r100, Bundle r101);
    }

    public static class b implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f459460a;

        public b(a r100) {
            this.f459460a = r100;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
            if (TextUtils.equals("onPreloadEvent", r101.getName()) == true) goto L5;
            return null;
        L5:
            if (r102.length < 2) goto L12;
            a r103 = this.f459460a;
            if (r103 == null) goto L13;
            r103.onPreloadEvent(((Integer) r102[0]).intValue(), (Bundle) r102[1]);
            return null;
        L13:
            return null;
        L12:
            return null;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public int cancelAll() {
        int r100 = -5;
    L9:
        e = move-exception;
        e.toString();
        return r100;
    L4:
        if (this.f459458a == null) goto L14;
        f459454n.setAccessible(true);     // Catch: Exception -> L9
        Object r101 = f459454n.invoke(this.f459458a, new Object[0]);     // Catch: Exception -> L9
        if (r101 == null) goto L15;
        r100 = ((Integer) r101).intValue();     // Catch: Exception -> L9
        return r100;
    L15:
        return -5;
    L14:
        return -5;
    }

    public int destroy() {
    L10:
        e = move-exception;
        Exception e100 = e;
        int r100 = -5;
    L12:
        e100.toString();
        return r100;
    L4:
        if (this.f459458a == null) goto L18;
        f459445e.setAccessible(true);     // Catch: Exception -> L10
        r100 = 0;
        f459445e.invoke(this.f459458a, new Object[0]);     // Catch: Exception -> L10
        return 0;
    L8:
        e100 = e;
        goto L12
    L18:
        return -5;
    }

    public int getActivePlayer() {
        int r100 = -5;
    L9:
        e = move-exception;
        e.toString();
        return r100;
    L4:
        if (this.f459458a == null) goto L14;
        f459448h.setAccessible(true);     // Catch: Exception -> L9
        Object r101 = f459448h.invoke(this.f459458a, new Object[0]);     // Catch: Exception -> L9
        if (r101 == null) goto L15;
        r100 = ((Integer) r101).intValue();     // Catch: Exception -> L9
        return r100;
    L15:
        return -5;
    L14:
        return -5;
    }

    public int getCurrentTaskState() {
        int r100 = -5;
    L9:
        e = move-exception;
        e.toString();
        return r100;
    L4:
        if (this.f459458a == null) goto L14;
        f459455o.setAccessible(true);     // Catch: Exception -> L9
        Object r101 = f459455o.invoke(this.f459458a, new Object[0]);     // Catch: Exception -> L9
        if (r101 == null) goto L15;
        r100 = ((Integer) r101).intValue();     // Catch: Exception -> L9
        return r100;
    L15:
        return -5;
    L14:
        return -5;
    }

    private static void loadPreload() {
        Class r100 = INVOKESTATIC_com_ss_videoarch_liveplayer_PreloadProxy_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.videoarch.live.ttquic.PreloadManager");     // Catch: Exception -> L4
        f459443c = r100.getMethod("getInstance", new Class[0]);     // Catch: Exception -> L4
        f459444d = r100.getMethod("init", new Class[]{Context.class, String.class});     // Catch: Exception -> L4
        f459445e = r100.getMethod(MapMonitorConst.EVENT_DESTROY, new Class[0]);     // Catch: Exception -> L4
        Class<?> r101 = Integer.TYPE;     // Catch: Exception -> L4
        f459446f = r100.getMethod("attachPlayer", new Class[]{r101});     // Catch: Exception -> L4
        f459447g = r100.getMethod("detachPlayer", new Class[]{r101});     // Catch: Exception -> L4
        f459448h = r100.getMethod("getActivePlayer", new Class[0]);     // Catch: Exception -> L4
        f459449i = r100.getMethod("addListener", new Class[]{r101, Object.class});     // Catch: Exception -> L4
        f459450j = r100.getMethod("removeListener", new Class[]{r101});     // Catch: Exception -> L4
        f459451k = r100.getMethod("recordResource", new Class[]{String.class});     // Catch: Exception -> L4
        f459452l = r100.getMethod("preload", new Class[]{r101, String.class, String.class, Bundle.class});     // Catch: Exception -> L4
        f459453m = r100.getMethod("cancel", new Class[]{r101, String.class});     // Catch: Exception -> L4
        f459454n = r100.getMethod("cancelAll", new Class[0]);     // Catch: Exception -> L4
        f459455o = r100.getMethod("getCurrentTaskState", new Class[0]);     // Catch: Exception -> L4
        f459456p = r100.getMethod("getPreloadInfo", new Class[]{String.class, r101});     // Catch: Exception -> L4
        f459457q = true;     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.toString();
    }

    static {
        loadPreload();
    }

    public m(a r100) {
        if (f459457q == false) goto L11;
        f459443c.setAccessible(true);     // Catch: Exception -> L6
        this.f459458a = f459443c.invoke(null, new Object[0]);     // Catch: Exception -> L6
        this.f459459b = r100;     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.toString();
        return;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_videoarch_liveplayer_PreloadProxy_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
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

    public int addListener(int r100) {
        int r101 = -5;
        Class r102 = INVOKESTATIC_com_ss_videoarch_liveplayer_PreloadProxy_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.videoarch.live.ttquic.PreloadListener");     // Catch: Exception -> L10
        if (r102 == null) goto L17;
        b r103 = new b(this.f459459b);     // Catch: Exception -> L10
        Object r104 = Proxy.newProxyInstance(r102.getClassLoader(), new Class[]{r102}, r103);     // Catch: Exception -> L10
        f459449i.setAccessible(true);     // Catch: Exception -> L10
        f459449i.invoke(this.f459458a, new Object[]{Integer.valueOf(r100), r104});     // Catch: Exception -> L10
        return 0;
    L8:
        e = e;
        r101 = 0;
    L11:
        e.toString();
        return r101;
    L17:
        return -5;
    L10:
        e = e;
        goto L11
    }

    public int attachPlayer(int r100) {
        int r101 = -5;
    L10:
        e = e;
    L11:
        e.toString();
        return r101;
    L4:
        if (this.f459458a == null) goto L17;
        f459446f.setAccessible(true);     // Catch: Exception -> L10
        f459446f.invoke(this.f459458a, new Object[]{Integer.valueOf(r100)});     // Catch: Exception -> L10
        return 0;
    L8:
        e = e;
        r101 = 0;
        goto L11
    L17:
        return -5;
    }

    public int detachPlayer(int r100) {
        int r101 = -5;
    L10:
        e = e;
    L11:
        e.toString();
        return r101;
    L4:
        if (this.f459458a == null) goto L17;
        f459447g.setAccessible(true);     // Catch: Exception -> L10
        f459447g.invoke(this.f459458a, new Object[]{Integer.valueOf(r100)});     // Catch: Exception -> L10
        return 0;
    L8:
        e = e;
        r101 = 0;
        goto L11
    L17:
        return -5;
    }

    public int recordResource(String r100) {
        int r101 = -5;
    L10:
        e = e;
    L11:
        e.toString();
        return r101;
    L4:
        if (this.f459458a == null) goto L17;
        f459451k.setAccessible(true);     // Catch: Exception -> L10
        f459451k.invoke(this.f459458a, new Object[]{r100});     // Catch: Exception -> L10
        return 0;
    L8:
        e = e;
        r101 = 0;
        goto L11
    L17:
        return -5;
    }

    public int removeListener(int r100) {
        int r101 = -5;
    L10:
        e = e;
    L11:
        e.toString();
        return r101;
    L4:
        if (this.f459458a == null) goto L17;
        f459450j.setAccessible(true);     // Catch: Exception -> L10
        f459450j.invoke(this.f459458a, new Object[]{Integer.valueOf(r100)});     // Catch: Exception -> L10
        return 0;
    L8:
        e = e;
        r101 = 0;
        goto L11
    L17:
        return -5;
    }

    public int cancel(int r100, String r101) {
        int r102 = -5;
    L9:
        e = move-exception;
        e.toString();
        return r102;
    L4:
        if (this.f459458a == null) goto L14;
        f459453m.setAccessible(true);     // Catch: Exception -> L9
        Object r103 = f459453m.invoke(this.f459458a, new Object[]{Integer.valueOf(r100), r101});     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r102 = ((Integer) r103).intValue();     // Catch: Exception -> L9
        return r102;
    L15:
        return -5;
    L14:
        return -5;
    }

    public Bundle getPreloadInfo(String r100, int r101) {
        Bundle r102 = null;
    L12:
        e = e;
    L13:
        e.toString();
        return r102;
    L4:
        if (this.f459458a == null) goto L19;
        f459456p.setAccessible(true);     // Catch: Exception -> L12
        Object r103 = f459456p.invoke(this.f459458a, new Object[]{r100, Integer.valueOf(r101)});     // Catch: Exception -> L12
        if (r103 == null) goto L20;
        Bundle r104 = (Bundle) r103;     // Catch: Exception -> L12
        r104.toString();     // Catch: Exception -> L10
        return r104;
    L10:
        e = e;
        r102 = r104;
        goto L13
    L20:
        return null;
    L19:
        return null;
    }

    public int init(Context r100, String r101) {
        int r102 = -5;
    L9:
        e = move-exception;
        e.toString();
        return r102;
    L4:
        if (this.f459458a == null) goto L14;
        f459444d.setAccessible(true);     // Catch: Exception -> L9
        Object r103 = f459444d.invoke(this.f459458a, new Object[]{r100, r101});     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r102 = ((Integer) r103).intValue();     // Catch: Exception -> L9
        return r102;
    L15:
        return -5;
    L14:
        return -5;
    }

    public int preload(int r100, String r101, String r102, Bundle r110) {
        int r103 = -5;
    L9:
        e = move-exception;
        e.toString();
        return r103;
    L4:
        if (this.f459458a == null) goto L14;
        f459452l.setAccessible(true);     // Catch: Exception -> L9
        Object r104 = f459452l.invoke(this.f459458a, new Object[]{Integer.valueOf(r100), r101, r102, r110});     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r103 = ((Integer) r104).intValue();     // Catch: Exception -> L9
        return r103;
    L15:
        return -5;
    L14:
        return -5;
    }
}
