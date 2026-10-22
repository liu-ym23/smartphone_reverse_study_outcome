package xkc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.collection.ArrayMap;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements xkc.f {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ArrayMap f564387o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xkc.e f564388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PThreadPoolExecutor f564389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HandlerC8249a f564390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f564391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f564392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Callable<?>> f564393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f564394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f564395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Set<String> f564396i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f564397j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f564398k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f564399l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f564400m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f564401n;

    /* JADX INFO: renamed from: xkc.a$a, reason: collision with other inner class name */
    public class HandlerC8249a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f564402a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r100.what != 1024) goto L11;
            a r101 = this.f564402a;
            if (r101.f564399l == false) goto L8;
            r101.b();
            return;
        L8:
            vkc.d.b().f555576c.a();
            return;
        }

        public HandlerC8249a(a r100, Looper r101) {
            this.f564402a = r100;
            super(r101);
        }
    }

    public class b extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f564403a;

        public b(a r100) {
            this.f564403a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            if (isInitialStickyBroadcast() == false) goto L6;
            return;
        L6:
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r101.getAction()) == true) goto L24;
            return;
        L24:
            ConnectivityManager r102 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Exception -> L23
            if (r102 == null) goto L16;
            NetworkInfo r103 = r102.getActiveNetworkInfo();     // Catch: Exception -> L23
            if (r103 == null) goto L16;
            if (r103.isConnected() == false) goto L16;
            boolean r104 = true;
        L18:
            if (r104 == true) goto L21;
            this.f564403a.f564390c.removeMessages(1024);
            a.a(this.f564403a);
            return;
        L21:
            this.f564403a.f564390c.removeMessages(1024);
            a.a(this.f564403a);
            this.f564403a.b();
            return;
        L16:
            r104 = false;
            goto L18
        }
    }

    public class c implements vkc.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f564404a;

        public c(a r100) {
            this.f564404a = r100;
        }

        @Override // vkc.e.b
        public final void a(wkc.a r100) {
            a r101 = this.f564404a;
            if (r100 != null) goto L5;
            r101.getClass();
            return;
        L5:
            if (r101.f564395h == false) goto L14;
            r101.d(r100);
            if (r101.f564398k == false) goto L15;
            r101.b();
            return;
        L15:
            return;
        }
    }

    public class d implements f<wkc.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f564405a;

        public d(a r100) {
            this.f564405a = r100;
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public void call2(wkc.a r100) {
            a r101 = this.f564405a;
            ArrayMap r102 = a.f564387o;
            r101.d(r100);
            this.f564405a.f564390c.removeMessages(1024);
            a r103 = this.f564405a;
            r103.f564390c.sendEmptyMessageDelayed(1024, r103.f564397j);
        }

        @Override // xkc.a.f
        public /* bridge */ /* synthetic */ void call(wkc.a r100) {
            call2(r100);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callable f564406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f564407b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f564408c;

        /* JADX INFO: renamed from: xkc.a$e$a, reason: collision with other inner class name */
        public class RunnableC8250a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f564409a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f564410b;

            public final void a() {
                List<Callable<?>> r100 = this.f564410b.f564408c.f564393f;
                monitor-enter(r100);
                e r101 = this.f564410b;     // Catch: Throwable -> L13
                List<Callable<?>> r102 = r101.f564408c.f564393f;     // Catch: Throwable -> L13
                LinkedList r103 = (LinkedList) r102;     // Catch: Throwable -> L13
                if (r103.remove(r101.f564406a) == true) goto L7;
                boolean r104 = true;
            L8:
                monitor-exit(r100);     // Catch: Throwable -> L13
                if (r104 == false) goto L11;
                return;
            L11:
                this.f564410b.f564407b.call(this.f564409a);
                return;
            L7:
                r104 = false;
            L13:
                th = move-exception;
                throw th;
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

            public RunnableC8250a(e r100, Object r101) {
                this.f564410b = r100;
                this.f564409a = r101;
            }
        }

        public final void a() {
            List<Callable<?>> r100 = this.f564408c.f564393f;
            monitor-enter(r100);
            List<Callable<?>> r101 = this.f564408c.f564393f;     // Catch: Throwable -> L17
            LinkedList r102 = (LinkedList) r101;     // Catch: Throwable -> L17
            if (r102.contains(this.f564406a) == true) goto L7;
            boolean r103 = true;
        L8:
            monitor-exit(r100);     // Catch: Throwable -> L17
            if (r103 == false) goto L22;
            return;
        L22:
            Object r104 = this.f564406a.call();     // Catch: Exception -> L13
        L15:
            this.f564408c.f564390c.post(new RunnableC8250a(this, r104));
            return;
        L13:
            e = move-exception;
            e.printStackTrace();
            r104 = null;
            goto L15
        L7:
            r103 = false;
        L17:
            th = move-exception;
            throw th;
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

        public e(a r100, Callable r101, f r102) {
            this.f564408c = r100;
            this.f564406a = r101;
            this.f564407b = r102;
        }
    }

    public interface f<T> {
        void call(T r100);
    }

    public static class g implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f564411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f564412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f564413c;

        public g() {
            this.f564412b = new AtomicInteger(1);
            SecurityManager r100 = System.getSecurityManager();
            if (r100 == null) goto L5;
            ThreadGroup r101 = r100.getThreadGroup();
        L6:
            this.f564411a = r101;
            this.f564413c = "dns-optimizer-";
            return;
        L5:
            r101 = ThreadMethodProxy.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(this.f564411a, r100, this.f564413c + this.f564412b.getAndIncrement(), 0);
            if (r101.isDaemon() == false) goto L6;
            r101.setDaemon(false);
        L6:
            if (r101.getPriority() == 1) goto L8;
            ThreadMethodProxy.setPriority(r101, 1);
        L8:
            return r101;
        }
    }

    static {
        h.f564418a = false;
        f564387o = new ArrayMap();
    }

    public final void b() {
        if (this.f564399l == false) goto L13;
        ArrayMap r100 = f564387o;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.size() != 0) goto L9;
        c(new xkc.d(), new d(this));
        return;
    L9:
        this.f564400m = 0;
        Iterator r101 = r100.values().iterator();
    L11:
        if (r101.hasNext() == false) goto L17;
        i r102 = (i) r101.next();
        c(new xkc.g(r102.f564419a), new xkc.b(this, r102));
        goto L11
    L17:
        return;
    }

    public a(Context r110) {
        this.f564390c = new HandlerC8249a(this, Looper.getMainLooper());
        this.f564392e = new b(this);
        new ArrayMap();
        this.f564393f = new LinkedList();
        this.f564394g = new ArrayList();
        this.f564395h = false;
        this.f564397j = 300000;
        this.f564398k = true;
        this.f564399l = true;
        this.f564400m = 0;
        this.f564401n = false;
        this.f564391d = r110;
        c r111 = new c(this);
        ((HashSet) vkc.d.b().f555576c.f555578a).add(r111);
        vkc.d.b().getClass();
        PThreadPoolExecutor r112 = new PThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new g());
        this.f564389b = r112;
        r112.allowCoreThreadTimeOut(true);
        boolean r113 = vkc.d.b().f555577d;
        this.f564401n = r113;
        if (r113 == false) goto L6;
        Intrinsics.checkNotNullParameter("vctfo", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> vctfo");
        com.bytedance.librarian.a.c("vctfo");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> vctfo");
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(a r100) {
        Set<String> r101 = r100.f564396i;
        if (r101 != null) goto L5;
    L13:
        f564387o.clear();
        return;
    L5:
        if (((HashSet) r101).size() == 0) goto L13;
        Iterator r102 = ((HashSet) r100.f564396i).iterator();
    L9:
        if (r102.hasNext() == false) goto L20;
        String r103 = (String) r102.next();
        i r104 = (i) f564387o.get(r103);
        if (r104 == null) goto L9;
        r104.f564422d.lock();
        r104.f564421c = null;
        r104.f564422d.unlock();
        r104.a();
        r104.f564422d.lock();
        r104.f564420b = null;
        r104.f564422d.unlock();
        r104.a();
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(wkc.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        HashSet r101 = new HashSet();
        if (r100.f560159a != 0) goto L18;
        JSONObject r102 = r100.f560160b;
        if (r102 == null) goto L18;
        if (r102.length() <= 0) goto L18;
        Iterator<String> r103 = r100.f560160b.keys();
    L12:
        if (r103.hasNext() == false) goto L18;
        String r104 = r103.next();
        if (r104 == null) goto L12;
        if (r104.equals("") == true) goto L12;
        r101.add(r104);
    L18:
        this.f564396i = r101;
        long r105 = r100.f560161c * 1000;
        if (r105 >= 300000) goto L21;
        r105 = 300000;
    L21:
        this.f564397j = r105;
        this.f564398k = r100.f560162d;
        this.f564399l = r100.f560163e;
        if (r101.size() != 0) goto L25;
        f564387o.clear();
        return;
    L25:
        Iterator r106 = ((HashSet) this.f564396i).iterator();
    L27:
        if (r106.hasNext() == false) goto L53;
        String r107 = (String) r106.next();
        i r108 = (i) f564387o.get(r107);
        if (r108 != null) goto L32;
        r108 = new i(r107);
    L32:
        if (r100.f560159a != 0) goto L46;
        JSONObject r109 = r100.f560160b;
        if (r109 == null) goto L46;
        if (r109.length() <= 0) goto L46;
        ArrayList r110 = new ArrayList();     // Catch: JSONException -> L44
        if (r100.f560160b.has(r107) == false) goto L46;
        JSONArray r111 = JSONObjectProtectorUtils.getJSONArray(r100.f560160b, r107);     // Catch: JSONException -> L44
        int r112 = 0;
    L41:
        if (r112 >= r111.length()) goto L47;
        r110.add(JSONArrayProtectorUtils.getString(r111, r112));     // Catch: JSONException -> L44
        r112 = r112 + 1;
    L47:
        j r113 = new j(r107, r110);
        r108.f564422d.lock();
        r108.f564420b = r113;
        r108.f564422d.unlock();
        r108.a();
        f564387o.put(r107, r108);
        if (this.f564401n == false) goto L27;
        if (r110 == null) goto L27;
        if (r110.isEmpty() == true) goto L27;
        c(new l(r110, this.f564394g), new xkc.c(this));
    L44:
        e = move-exception;
        e.printStackTrace();
    L46:
        r110 = null;
        goto L47
    }

    public final <T> void c(Callable<T> r100, f<T> r101) {
        if (this.f564395h == true) goto L5;
        return;
    L5:
        List<Callable<?>> r102 = this.f564393f;
        monitor-enter(r102);
        ((LinkedList) this.f564393f).add(r100);     // Catch: Throwable -> L11
        monitor-exit(r102);     // Catch: Throwable -> L11
        this.f564389b.submit(new e(this, r100, r101));
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
