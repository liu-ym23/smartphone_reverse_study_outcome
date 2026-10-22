package f74;

import android.content.Context;
import android.os.SystemClock;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.ISDKInitializerListener;
import com.baidu.mapapi.RequestAuthResultListener;
import com.baidu.mapapi.SDKInitializer;
import com.bytedance.map.api.MapGlobalConfig;
import com.bytedance.map.api.logger.MapLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f475750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile long f475751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f475752c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C5863a f475753d = null;

    /* JADX INFO: renamed from: f74.a$a, reason: collision with other inner class name */
    public static class C5863a implements RequestAuthResultListener {
        public C5863a() {
        }

        @Override // com.baidu.mapapi.RequestAuthResultListener
        public final void onAuthResult(int r100, String r101) {
            long r102 = a.f475751b;
            if (r102 <= 0) goto L5;
            long r103 = SystemClock.elapsedRealtime() - r102;
        L6:
            MapLogger.i("BaiduMapInitializer", "Baidu auth result: status=" + r100 + ", message=" + r101 + ", cost=" + r103);
            return;
        L5:
            r103 = -1;
            goto L6
        }
    }

    public static class b implements ISDKInitializerListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f475754a;

        @Override // com.baidu.mapapi.ISDKInitializerListener
        public final void initializerFinish() {
            MapLogger.i("BaiduMapInitializer", "Baidu SDK initializer finish, privacyConfirmed=" + MapGlobalConfig.isPrivacyConfirmed() + ", cost=" + (SystemClock.elapsedRealtime() - this.f475754a) + ", thread=" + ThreadMethodProxy.currentThread().getName());
        }

        public b(long r100) {
            this.f475754a = r100;
        }
    }

    public a() {
    }

    static {
        f475752c = new AtomicBoolean(false);
        f475753d = new C5863a();
    }

    public static void a(Context r100) {
        if (f475750a == false) goto L6;
        return;
    L6:
        monitor-enter(a.class);
    L26:
        th = move-exception;
        throw th;
    L8:
        if (f475750a == false) goto L11;
        monitor-exit(a.class);     // Catch: Throwable -> L26
        return;
    L11:
        Context r101 = r100.getApplicationContext();     // Catch: Throwable -> L26
        SDKInitializer.setAgreePrivacy(r101, MapGlobalConfig.isPrivacyConfirmed());     // Catch: Throwable -> L26
        if (f475752c.compareAndSet(false, true) == true) goto L32;
    L18:
        long r102 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L26
        f475751b = r102;     // Catch: Throwable -> L26
        SDKInitializer.initialize(r101, new b(r102));     // Catch: Throwable -> L21
        f475750a = true;     // Catch: Throwable -> L21
    L23:
        SDKInitializer.setCoordType(CoordType.GCJ02);     // Catch: Throwable -> L26
        monitor-exit(a.class);     // Catch: Throwable -> L26
        return;
    L21:
        th = move-exception;
        MapLogger.e("BaiduMapInitializer", "BaiduMapInitializer initialize failed, privacyConfirmed=" + MapGlobalConfig.isPrivacyConfirmed() + ", cost=" + (SystemClock.elapsedRealtime() - r102), th);     // Catch: Throwable -> L26
        f475750a = false;     // Catch: Throwable -> L26
        goto L23
    L32:
        SDKInitializer.addAuthResultListener(f475753d);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        f475752c.set(false);     // Catch: Throwable -> L26
        MapLogger.e("BaiduMapInitializer", "Baidu auth result listener add failed", th);     // Catch: Throwable -> L26
        goto L18
    }
}
