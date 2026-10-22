package com.larus.init.task;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final class QueuedWorkHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f351120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static LinkedList<Runnable> f351121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static LinkedList<Runnable> f351122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Field f351123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Object f351124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f351125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Class<?> f351126g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Method f351127h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f351128i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f351129j;

    /* JADX INFO: loaded from: classes30.dex */
    public static class ProxyFinisher extends LinkedList<Runnable> {
        public boolean add(Runnable r100) {
            return true;
        }

        @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
        public boolean remove(Object r100) {
            return true;
        }

        @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
        public Runnable poll() {
        L12:
            th = move-exception;
            FLogger.f375446a.e("QueuedWorkHelper", th.getMessage());
        L14:
            return null;
        L4:
            if (Build.VERSION.SDK_INT < 31) goto L7;
            QueuedWorkHelper.f351121b = (LinkedList) QueuedWorkHelper.f351123d.get(null);     // Catch: Throwable -> L12
        L7:
            if (QueuedWorkHelper.f351128i == true) goto L14;
            if (QueuedWorkHelper.f351121b == null) goto L14;
            FLogger.f375446a.d("QueuedWorkHelper", "ProxyFinisher: sWork.size: " + QueuedWorkHelper.f351121b.size());     // Catch: Throwable -> L12
            goto L14
        }

        private ProxyFinisher() {
        }

        @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
        public /* bridge */ /* synthetic */ Object poll() {
            return poll();
        }

        public /* synthetic */ ProxyFinisher(a r100) {
            this();
        }

        @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
        public /* bridge */ /* synthetic */ boolean add(Object r100) {
            return add((Runnable) r100);
        }
    }

    /* JADX INFO: loaded from: classes30.dex */
    public static /* synthetic */ class a {
    }

    /* JADX INFO: loaded from: classes30.dex */
    public static class b extends Handler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static boolean f351130b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static boolean f351131c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LinkedList<Runnable> f351132a;

        public b(Looper r100) {
            super(r100);
            this.f351132a = new LinkedList();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            if (QueuedWorkHelper.f351128i == true) goto L6;
            FLogger.f375446a.d("QueuedWorkHelper", "handleMessage begin cache.size: " + this.f351132a.size());
        L6:
            if (this.f351132a.isEmpty() == false) goto L8;
            return;
        L8:
            Object r101 = QueuedWorkHelper.f351124e;
            monitor-enter(r101);
            LinkedList<Runnable> r102 = this.f351132a;     // Catch: Throwable -> L29
            this.f351132a = new LinkedList();     // Catch: Throwable -> L29
            monitor-exit(r101);     // Catch: Throwable -> L29
            f351130b = true;
            Thread.sleep(100);     // Catch: InterruptedException -> L15
        L18:
            if (QueuedWorkHelper.f351128i == true) goto L20;
            FLogger.f375446a.d("QueuedWorkHelper", "handleMessage clone.size: " + r102.size());
        L20:
            Iterator<Runnable> r103 = r102.iterator();
        L22:
            if (r103.hasNext() == false) goto L25;
            r103.next().run();
            goto L22
        L25:
            if (this.f351132a.isEmpty() == true) goto L27;
            sendMessageAtFrontOfQueue(Message.obtain(this, 2));
            return;
        L27:
            f351130b = false;
            return;
        L15:
            e = move-exception;
            FLogger.f375446a.i("QueuedWorkHelper", "ignore: " + e);
        L29:
            th = move-exception;
            throw th;
        }

        @Override // android.os.Handler
        public final boolean sendMessageAtTime(Message r100, long r101) {
            boolean r102 = f351131c;
            if (r102 == true) goto L6;
            QueuedWorkHelper.f351121b = (LinkedList) QueuedWorkHelper.f351123d.get(null);     // Catch: Throwable -> L26
            QueuedWorkHelper.f351120a.removeMessages(1);     // Catch: Throwable -> L26
            QueuedWorkHelper.f351122c.clear();     // Catch: Throwable -> L26
            f351131c = true;     // Catch: Throwable -> L26
        L9:
            if (QueuedWorkHelper.f351121b.isEmpty() == false) goto L14;
            if (QueuedWorkHelper.f351129j == true) goto L14;
            QueuedWorkHelper.f351129j = true;
        L14:
            if (QueuedWorkHelper.f351121b.size() != 1) goto L17;
            this.f351132a.addLast(QueuedWorkHelper.f351121b.poll());
        L22:
            if (f351130b == true) goto L25;
            r100.what = 2;
            return sendMessageAtFrontOfQueue(r100);
        L25:
            return true;
        L17:
            if (QueuedWorkHelper.f351121b.size() <= 1) goto L22;
            Runnable r103 = QueuedWorkHelper.f351121b.poll();
        L19:
            if (r103 == null) goto L22;
            this.f351132a.addLast(r103);
            r103 = QueuedWorkHelper.f351121b.poll();
        L6:
            if (QueuedWorkHelper.f351128i == true) goto L9;
            Object r104 = QueuedWorkHelper.f351127h.invoke(null, new Object[0]);     // Catch: Throwable -> L26
            FLogger.f375446a.d("QueuedWorkHelper", "sendMessageAtTime cache.size: " + this.f351132a.size() + "  sWork.size: " + QueuedWorkHelper.f351121b.size() + "  hasRunBackUp: " + r102 + "  hasRun: " + f351131c + "  hasPendingWork:" + r104);     // Catch: Throwable -> L26
            goto L9
        }
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.app.QueuedWork");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.QueuedWork");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.QueuedWork");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.app.QueuedWork");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.QueuedWork");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.QueuedWork");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.QueuedWork");
    }

    public static void b() {
        if (f351125f == false) goto L5;
        return;
    L5:
        f351128i = !AppHost.f326268a.isDebug();
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 26) goto L8;
    L38:
        FLogger.f375446a.d("QueuedWorkHelper", "QueuedWorkHelper does not support " + r100);
        return;
    L8:
        if (r100 > 33) goto L38;
        Class<?> r101 = a();     // Catch: Throwable -> L31
        f351126g = r101;     // Catch: Throwable -> L31
        Field r102 = c27.a.a(r101, "sHandler");     // Catch: Throwable -> L31
        f351123d = c27.a.a(f351126g, "sWork");     // Catch: Throwable -> L31
        Field r103 = c27.a.a(f351126g, "sFinishers");     // Catch: Throwable -> L31
        Field r104 = c27.a.a(f351126g, "sLock");     // Catch: Throwable -> L31
        Method r105 = c27.a.b(f351126g, "getHandler", new Class[0]);     // Catch: Throwable -> L31
        f351127h = c27.a.b(f351126g, "hasPendingWork", new Class[0]);     // Catch: Throwable -> L31
        if (r105 != null) goto L14;
        FLogger.f375446a.d("QueuedWorkHelper", "init: " + f351125f);
        return;
    L14:
        a r106 = null;
        r105.invoke(null, new Object[0]);     // Catch: Throwable -> L31
        if (r102 != null) goto L18;
        FLogger.f375446a.d("QueuedWorkHelper", "init: " + f351125f);
        return;
    L18:
        f351120a = (Handler) r102.get(null);     // Catch: Throwable -> L31
        Field r107 = f351123d;     // Catch: Throwable -> L31
        if (r107 == null) goto L23;
        if (r104 == null) goto L23;
        f351121b = (LinkedList) r107.get(null);     // Catch: Throwable -> L31
        f351124e = r104.get(null);     // Catch: Throwable -> L31
    L23:
        if (f351121b != null) goto L25;
    L29:
        FLogger.f375446a.d("QueuedWorkHelper", "init: " + f351125f);
        return;
    L25:
        if (f351124e == null) goto L29;
        ProxyFinisher r108 = new ProxyFinisher(r106);     // Catch: Throwable -> L31
        f351122c = r108;     // Catch: Throwable -> L31
        r103.set(null, r108);     // Catch: Throwable -> L31
        r102.set(null, new b(f351120a.getLooper()));     // Catch: Throwable -> L31
        f351125f = true;     // Catch: Throwable -> L31
        FLogger.f375446a.d("QueuedWorkHelper", "init: " + f351125f);
        return;
    L31:
        th = move-exception;
        FLogger r109 = FLogger.f375446a;     // Catch: Throwable -> L35
        r109.d("QueuedWorkHelper", "ignore: " + th);     // Catch: Throwable -> L35
        r109.d("QueuedWorkHelper", "init: " + f351125f);
        return;
    L35:
        th = move-exception;
        FLogger.f375446a.d("QueuedWorkHelper", "init: " + f351125f);
        throw th;
    }
}
