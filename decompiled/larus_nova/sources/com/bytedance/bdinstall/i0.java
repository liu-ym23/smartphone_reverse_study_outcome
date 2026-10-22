package com.bytedance.bdinstall;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.baidu.platform.comapi.map.NodeType;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements Handler.Callback {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f199653k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0 f199654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b84.m f199655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f199656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j74.b f199657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public u f199658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f199659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public y0 f199660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.bdinstall.c f199661h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f199662i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public k74.c f199663j;

    public static class a extends i84.r<d> {
        public a() {
        }

        @Override // i84.r
        public final d a(Object[] r100) {
            return new d((Context) r100[0]);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i0 f199664a;

        public final void a() {
            b84.m r100 = this.f199664a.f199655b;
            n0 r101 = r100.e();
            String r102 = r101.f199720a;
            String r103 = r101.f199721b;
            String r104 = r101.f199724e;
            i84.b r105 = r100.f18051o;
            if (r105 == null) goto L6;
            r105.onIdLoaded(r102, r103, r104);
        L6:
            if (TextUtils.isEmpty(r101.f199720a) == false) goto L8;
            return;
        L8:
            if (TextUtils.isEmpty(r101.f199721b) == true) goto L16;
            k74.c r106 = r100.f18050n;
            if (r106 == null) goto L15;
            r106.a(new l74.b(r101));
            return;
        L15:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(i0 r100) {
            this.f199664a = r100;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseWorker f199665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i0 f199666b;

        /* JADX INFO: loaded from: classes8.dex */
        public class a implements d.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f199667a;

            @Override // com.bytedance.bdinstall.i0.d.a
            public final void onNetworkReady() {
                c r100 = this.f199667a;
                if (r100.f199666b.f199656c.hasMessages(NodeType.E_STREET_ARROW, r100.f199665a) == false) goto L5;
                c r101 = this.f199667a;
                r101.f199666b.f199656c.removeMessages(NodeType.E_STREET_ARROW, r101.f199665a);
                c r102 = this.f199667a;
                r102.f199666b.f199656c.obtainMessage(NodeType.E_STREET_ARROW, r102.f199665a).sendToTarget();
                int r103 = t.f199790a;
            L5:
                c r104 = this.f199667a;
                r104.f199665a.f199598g = null;
                i0.f199653k.b(new Object[]{r104.f199666b.f199654a.getContext()}).b(this);
                t.d("remove observer " + this.f199667a.f199665a + ", " + this);
            }

            public a(c r100) {
                this.f199667a = r100;
            }
        }

        public final void a() {
            o0 r100 = this.f199666b.f199654a;
            if (r100.f199751x == false) goto L30;
            BaseWorker r101 = this.f199665a;
            d.a r102 = r101.f199598g;
            if (r102 == null) goto L7;
            r101.f199598g = null;
            i0.f199653k.b(new Object[]{r100.getContext()}).b(r102);
            int r103 = t.f199790a;
        L7:
            BaseWorker.a r104 = this.f199665a.j();
            i0.a(this.f199666b, r104, this.f199665a);
            BaseWorker r105 = this.f199665a;
            if (r105.f199597f == false) goto L12;
            int r106 = t.f199790a;
            return;
        L12:
            if (r104.f199599a == true) goto L29;
            r105.e();
            if (r104.f199600b != 1) goto L29;
            a r107 = new a(this);
            this.f199665a.f199598g = r107;
            d r108 = i0.f199653k.b(new Object[]{this.f199666b.f199654a.getContext()});
            monitor-enter(r108);
            r108.f199668a.add(new WeakReference(r107));     // Catch: Throwable -> L26
            if (r108.f199669b.compareAndSet(false, true) == true) goto L35;
        L24:
            monitor-exit(r108);
            goto L29
        L35:
            d.a(r108.f199670c, new l0(r108), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));     // Catch: Exception -> L22 Throwable -> L26
        L22:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            throw th;
        L29:
            Handler r109 = this.f199666b.f199656c;
            r109.sendMessageDelayed(r109.obtainMessage(NodeType.E_STREET_ARROW, this.f199665a), r104.f199601c);
            return;
        L30:
            BaseWorker.a r110 = this.f199665a.j();
            i0.a(this.f199666b, r110, this.f199665a);
            BaseWorker r111 = this.f199665a;
            if (r111.f199597f == true) goto L33;
            Handler r112 = this.f199666b.f199656c;
            r112.sendMessageDelayed(r112.obtainMessage(NodeType.E_STREET_ARROW, r111), r110.f199601c);
            return;
        L33:
            int r113 = t.f199790a;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(i0 r100, BaseWorker r101) {
            this.f199666b = r100;
            this.f199665a = r101;
        }
    }

    /* JADX INFO: loaded from: classes8.dex */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<WeakReference<a>> f199668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f199669b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Context f199670c;

        public interface a {
            void onNetworkReady();
        }

        public d(Context r100) {
            this.f199668a = Collections.synchronizedSet(new HashSet());
            this.f199669b = new AtomicBoolean(false);
            this.f199670c = r100;
        }

        public final synchronized void b(a r100) {
            monitor-enter(this);
            Iterator<WeakReference<a>> r101 = this.f199668a.iterator();     // Catch: Throwable -> L14
        L5:
            if (r101.hasNext() == false) goto L12;
            WeakReference<a> r102 = r101.next();     // Catch: Throwable -> L14
            if (r102 == null) goto L8;
            if (r102.get() != r100) goto L5;
            r101.remove();     // Catch: Throwable -> L14
            goto L12
        L8:
            r101.remove();     // Catch: Throwable -> L14
        L12:
            monitor-exit(this);
            return;
        L14:
            th = move-exception;
            throw th;
        }

        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
        public static void a(Context r100, l0 r101, IntentFilter r110) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        L39:
        L33:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
            ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
            return;
        L38:
            throw e;
        L6:
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
            if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
            int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L33
            if (r102 != 1) goto L12;
            r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
            return;
        L12:
            if (r102 != 2) goto L14;
            new Intent();     // Catch: Exception -> L33
            return;
        L14:
            if (r102 == 3) goto L40;
            r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
            return;
        L40:
            return;
        L22:
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
            ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
            r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
            return;
        L26:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
        L31:
            r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
            return;
        L28:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L31;
            ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
            ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
        }
    }

    static {
        f199653k = new a();
    }

    public final void b(com.bytedance.bdinstall.c r100) {
        t.a("dispatcher#activeImmediately");
        this.f199659f.set(true);
        com.bytedance.bdinstall.c r101 = this.f199661h;
        if (r101 == null) goto L5;
        r101.f199597f = true;
        this.f199656c.removeMessages(NodeType.E_STREET_ARROW, r101);
    L5:
        this.f199661h = r100;
        g(r100, false);
    }

    public final void f(BaseWorker r100) {
        v.f(String.valueOf(this.f199654a.f199728a), new c(this, r100));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        int r101 = r100.what;
        if (r101 != 1234) goto L5;
        e(this.f199658e, ((Boolean) r100.obj).booleanValue());
    L19:
        return false;
    L5:
        if (r101 != 1235) goto L19;
        BaseWorker r102 = (BaseWorker) r100.obj;
        if (this.f199654a.C == true) goto L10;
    L12:
        boolean r103 = false;
    L13:
        if (r103 == true) goto L19;
        if (r102.f199597f == true) goto L19;
        f(r102);
        goto L19
    L10:
        if (((j74.a) this.f199657d).f497575b == true) goto L12;
        int r104 = t.f199790a;
        Handler r105 = this.f199656c;
        Message r106 = r105.obtainMessage(NodeType.E_STREET_ARROW, r102);
        r102.getClass();
        r105.sendMessageDelayed(r106, 60000);
        r103 = true;
        goto L13
    }

    public final boolean c(u r100, boolean r101) {
        if (this.f199658e.equals(r100) == false) goto L6;
        return false;
    L6:
        this.f199658e = r100;
        b84.m r102 = this.f199655b;
        r102.f18040d = r100;
        r102.f18046j = r102.b(r102.f18041e, r100);
        h84.k.a(r102.f18041e, r100, r102.f18042f);
        Map<Class<?>, b84.d> r103 = r102.f18037a;
        monitor-enter(r103);
        r102.f18037a.put(b84.w.class, new b84.w(r102.f18042f, r100));     // Catch: Throwable -> L20
        r102.f18037a.put(b84.n.class, new b84.n(r102.f18042f, r100));     // Catch: Throwable -> L20
        r102.f18037a.put(b84.g.class, new b84.g(r102.f18042f));     // Catch: Throwable -> L20
        r102.f18037a.put(b84.f.class, new b84.f(r102.f18042f));     // Catch: Throwable -> L20
        monitor-exit(r103);     // Catch: Throwable -> L20
        SharedPreferences r104 = r100.a(r102.f18042f);
        if (r104 == null) goto L13;
        r104.edit().putLong("register_time", 0).apply();
    L13:
        if (r101 == false) goto L25;
        r102.g();
        k74.c r105 = r102.f18050n;
        if (r105 == null) goto L17;
        r105.a(new l74.a(r102.f18045i));
    L17:
        r102.j();
        return true;
    L25:
        return true;
    L20:
        th = move-exception;
        throw th;
    }

    public final void e(u r100, boolean r101) {
        v.f(String.valueOf(this.f199654a.f199728a), new b(this));
        if (this.f199655b.g() == false) goto L20;
        y0 r102 = new y0(this.f199654a, this.f199655b, r100, this.f199657d);
        k74.c r103 = this.f199663j;
        if (r103 == null) goto L8;
        r103.a(new l74.a(this.f199655b.f18045i));
    L8:
        if (r101 == true) goto L18;
        b84.m r104 = this.f199655b;
        if (i84.a.a(r104.f18041e, r104.f18042f).getLong("dr_install_vc", 0) == r104.f18045i.optLong("version_code", 0)) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L18;
        b84.m r106 = this.f199655b;
        if ((!TextUtils.equals(i84.a.a(r106.f18041e, r106.f18042f).getString("dr_channel", null), r106.f18042f.f199734g)) == true) goto L18;
        b84.m r107 = this.f199655b;
        if ((!TextUtils.equals(i84.a.a(r107.f18041e, r107.f18042f).getString("dr_aid", null), String.valueOf(r107.f18042f.f199728a))) == true) goto L18;
    L19:
        i.b().getClass();
        f(r102);
        this.f199660g = r102;
        return;
    L12:
        r105 = false;
    L18:
        r102.f199595d = 0;
        goto L19
    L20:
        this.f199656c.removeMessages(NodeType.E_STREET_POI);
        Handler r108 = this.f199656c;
        r108.sendMessageDelayed(r108.obtainMessage(NodeType.E_STREET_POI, Boolean.valueOf(r101)), 1000);
    }

    public final void g(BaseWorker r100, boolean r101) {
        Handler r102 = this.f199656c;
        if (r102 == null) goto L11;
        r102.removeMessages(NodeType.E_STREET_ARROW, r100);
        Handler r103 = this.f199656c;
        r100.f199595d = 0;
        Message r104 = r103.obtainMessage(NodeType.E_STREET_ARROW, r100);
        if (r101 == true) goto L7;
    L9:
        this.f199656c.sendMessage(r104);
        return;
    L7:
        if (Looper.myLooper() != this.f199656c.getLooper()) goto L9;
        handleMessage(r104);
        return;
    }

    public i0(o0 r100, b84.m r101, u r102) {
        j74.a r103 = i.f199651a;
        this.f199659f = new AtomicBoolean(false);
        new AtomicBoolean(false);
        this.f199654a = r100;
        this.f199655b = r101;
        this.f199657d = r103;
        this.f199656c = new Handler(v.d(r100.a()), this);
        this.f199658e = r102;
    }

    public static void a(i0 r100, BaseWorker.a r101, BaseWorker r102) {
        r100.getClass();
        if (r102 != null) goto L5;
    L7:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r101.f199600b != 4) goto L14;
        r102.i(r101.f199602d);
        r102.h(r101.f199599a);
        r102.a();
        return;
    L14:
        return;
    L5:
        if (r101.f199599a == false) goto L7;
        r102.i(r101.f199602d);
        r102.h(r101.f199599a);
        r102.a();
    }

    public final void d(u r100, boolean r101, boolean r102) {
        if (c(r100, r102) == true) goto L7;
        if (r101 == true) goto L7;
        t.b("the env is the same with before,ignore." + r100);
        return;
    L7:
        this.f199656c.removeMessages(NodeType.E_STREET_ARROW);
        if (this.f199656c.hasMessages(NodeType.E_STREET_POI) == false) goto L10;
        this.f199656c.removeMessages(NodeType.E_STREET_POI);
        Handler r103 = this.f199656c;
        r103.sendMessage(r103.obtainMessage(NodeType.E_STREET_POI, Boolean.TRUE));
        return;
    L10:
        y0 r104 = new y0(this.f199654a, this.f199655b, r100, this.f199657d);
        g(r104, false);
        this.f199660g = r104;
        if (this.f199654a.f199743p == true) goto L13;
        return;
    L13:
        if (this.f199659f.get() == false) goto L18;
        b(new com.bytedance.bdinstall.c(this.f199654a, r100));
        return;
    }
}
