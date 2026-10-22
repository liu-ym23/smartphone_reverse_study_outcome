package v3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ai.bridge.method.device.wifi.WifiError;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class h implements e3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<e3.d> f552797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f552798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f552799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f552800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f552801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConnectivityManager f552802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ConnectivityManager.NetworkCallback f552803g;

    public static final class a {
    }

    static {
    }

    @Override // e3.b
    public final void a() {
        Object r100 = this.f552798b;
        monitor-enter(r100);
        this.f552801e = true;     // Catch: Throwable -> L9
        this.f552800d = false;     // Catch: Throwable -> L9
        b();     // Catch: Throwable -> L9
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r100);
        b.g();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void b() {
        ConnectivityManager.NetworkCallback r100 = this.f552803g;
        if (r100 == null) goto L26;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
        ConnectivityManager r102 = this.f552802f;     // Catch: Throwable -> L10
        if (r102 == null) goto L7;
        r102.unregisterNetworkCallback(r100);     // Catch: Throwable -> L10
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L10
    L12:
        Result.m9448boximpl(r104);
        goto L26
    L7:
        r103 = null;
    L10:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L26:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L20
        if (Build.VERSION.SDK_INT < 23) goto L18;
        ConnectivityManager r107 = this.f552802f;     // Catch: Throwable -> L20
        if (r107 == null) goto L18;
        r107.bindProcessToNetwork(null);     // Catch: Throwable -> L20
    L18:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        this.f552803g = null;
        this.f552802f = null;
        return;
    L20:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    public final WifiError h() {
        Object r100 = this.f552798b;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f552801e == false) goto L8;
        WifiError r101 = new WifiError(f3.a.f475265f, "context is null");     // Catch: Throwable -> L14
    L12:
        monitor-exit(r100);
        return r101;
    L8:
        if (this.f552800d == true) goto L11;
        f3.a.C5852a r102 = f3.a.f475262c;     // Catch: Throwable -> L14
        f3.a r103 = f3.b.f475287a;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r102, "<this>");     // Catch: Throwable -> L14
        r101 = new WifiError(f3.b.f475291e, "wifi module is not initialized");     // Catch: Throwable -> L14
        goto L12
    L11:
        r101 = null;
        goto L12
    }

    public final Context j() {
        e3.d r100 = this.f552797a.get();
        if (r100 == null) goto L10;
        Context r101 = e3.e.b(r100);
        if (r101 == null) goto L10;
        Context r102 = r101.getApplicationContext();
        if (r102 != null) goto L12;
        return r101;
    L12:
        return r102;
    L10:
        return null;
    }

    public h(e3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        this.f552797a = new WeakReference(r100);
        this.f552798b = new Object();
        this.f552799c = new Handler(Looper.getMainLooper());
    }

    public static String c(WifiConfiguration r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101102);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(101102, "android/net/wifi/WifiConfiguration", "BSSID", r110, r111, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (String) r106.f474983b;
    L21:
        return r110.BSSID;
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static String e(WifiConfiguration r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101004);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(101004, "android/net/wifi/WifiConfiguration", "SSID", r110, r111, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (String) r106.f474983b;
    L21:
        return r110.SSID;
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static List g(WifiManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101001);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(101001, "android/net/wifi/WifiManager", "getConfiguredNetworks", r110, r111, "java.util.List", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (List) r106.f474983b;
    L21:
        return r110.getConfiguredNetworks();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static String i(e r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.f552787a);
        r101.append('#');
        String r102 = r100.f552788b;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.append(r102);
        return r101.toString();
    }

    public static void d(WifiConfiguration r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r112 = new Object[0];
        f06.b r113 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101102);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r114 = r102;
        int r103 = r114.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r114[r104];
        int r115 = r104;
        int r116 = r103;
        f06.d r106 = r105.preInvoke(101102, "android/net/wifi/WifiConfiguration", "BSSID", r110, r112, "java.lang.String", r113);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L20;
        String r107 = (String) r106.f474983b;
        return;
    L20:
        r110.BSSID = r111;
        return;
    L14:
        r104 = r115 + 1;
        r103 = r116;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static void f(WifiConfiguration r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r112 = new Object[0];
        f06.b r113 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101004);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r114 = r102;
        int r103 = r114.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r114[r104];
        int r115 = r104;
        int r116 = r103;
        f06.d r106 = r105.preInvoke(101004, "android/net/wifi/WifiConfiguration", "SSID", r110, r112, "java.lang.String", r113);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L20;
        String r107 = (String) r106.f474983b;
        return;
    L20:
        r110.SSID = r111;
        return;
    L14:
        r104 = r115 + 1;
        r103 = r116;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }
}
