package pfa;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f528987a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static IBinder f528988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f528989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f528990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f528991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f528992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final pfa.a f528993g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f528994h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f528995i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f528996j = null;

    public static final class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            FLogger.f375446a.w("MemoryProcessControler", "onServiceDisconnected: " + r100 + ", will reconnect after " + e.f528990d + "ms");
            e r101 = e.f528987a;
            IBinder r102 = e.f528988b;
            if (r102 != null) goto L9;
        L7:
            e.f528988b = null;
            e.c();
            return;
        L9:
            r102.unlinkToDeath(e.f528993g, 0);     // Catch: Exception -> L6
        L6:
            Unit r103 = Unit.INSTANCE;
            goto L7
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, final IBinder r101) {
            FLogger r102 = FLogger.f375446a;
            r102.i("MemoryProcessControler", "onServiceConnected: " + r100);
            if (r101 != null) goto L6;
            r102.e("MemoryProcessControler", "onServiceConnected: service binder is null, will reconnect");
            e r103 = e.f528987a;
            e.c();
            return;
        L6:
            e.f528988b = r101;
            e r104 = e.f528987a;
            ((Handler) s.f529026c.getValue()).post(new d(r101));
        }
    }

    public e() {
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [pfa.a] */
    /* JADX WARN: Type inference failed for: r0v6, types: [pfa.b] */
    /* JADX WARN: Type inference failed for: r0v7, types: [pfa.c] */
    static {
        f528987a = new e();
        f528990d = 5000;
        f528991e = 1000;
        f528992f = "MidLevel";
        f528993g = new pfa.a();
        f528994h = new a();
        f528995i = new b();
        f528996j = new c();
    }

    public static void a() {
        FLogger.f375446a.i("MemoryProcessControler", "reconnectRunnable: rebinding service");
        f528987a.bindService();
    }

    public static void b() {
        FLogger r100 = FLogger.f375446a;
        r100.i("MemoryProcessControler", "initBindRunnable: start bind after delay=" + f528991e + "ms");
        e r101 = f528987a;
        if (f528989c == false) goto L5;
        r100.d("MemoryProcessControler", "startBind: already bound, skip");
        return;
    L5:
        r101.bindService();
    }

    private final void bindService() {
        Application r100 = AppHost.f326268a.getApplication();
        if (r100 != null) goto L5;
        return;
    L5:
        FLogger r101 = FLogger.f375446a;
        r101.i("MemoryProcessControler", "bindService: context = " + r100);
        Intent r102 = new Intent("com.obric.memorydata.awareness.CONTEXT_AWARENESS_SERVICE");
        r102.setPackage("com.larus.nova");
        boolean r103 = Intrinsics.areEqual(f528992f, "HighLevel");     // Catch: Exception -> L17
        a r104 = f528994h;
        if (r103 == true) goto L10;
        boolean r105 = r100.bindService(r102, r104, 33);     // Catch: Exception -> L17
    L12:
        f528989c = r105;     // Catch: Exception -> L17
        if (r105 == true) goto L15;
        r101.e("MemoryProcessControler", "bindService returned false, will retry");     // Catch: Exception -> L17
        c();     // Catch: Exception -> L17
        return;
    L15:
        r101.i("MemoryProcessControler", "bindService: request sent");     // Catch: Exception -> L17
        return;
    L10:
        r105 = r100.bindService(r102, r104, 65);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        FLogger.f375446a.e("MemoryProcessControler", "bindService failed", e);
        f528989c = false;
        c();
    }

    public static void c() {
        Lazy r100 = s.f529026c;
        Handler r101 = (Handler) r100.getValue();
        b r102 = f528995i;
        r101.removeCallbacks(r102);
        ((Handler) r100.getValue()).postDelayed(r102, f528990d);
    }
}
