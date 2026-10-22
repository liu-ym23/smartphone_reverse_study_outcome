package s69;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.larus.common.apphost.AppHost;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet<a> f540847a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConnectivityManager f540848b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WifiManager f540849c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f540850d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Handler f540851e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static AbstractC7574b f540852f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f540853g = null;

    /* JADX INFO: loaded from: classes4.dex */
    public interface a {
        void j(String r100);
    }

    /* JADX INFO: renamed from: s69.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC7574b {

        /* JADX INFO: renamed from: s69.b$b$a */
        public static final class a extends AbstractC7574b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Network f540854a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f540854a, ((a) r100).f540854a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f540854a.hashCode();
            }

            public final String toString() {
                return "Available(network=" + this.f540854a + ')';
            }

            public a(Network r100) {
                Intrinsics.checkNotNullParameter(r100, "network");
                this.f540854a = r100;
            }
        }

        /* JADX INFO: renamed from: s69.b$b$b, reason: collision with other inner class name */
        public static final class C7575b extends AbstractC7574b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Network f540855a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C7575b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f540855a, ((C7575b) r100).f540855a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f540855a.hashCode();
            }

            public final String toString() {
                return "CapabilitiesChanged(network=" + this.f540855a + ')';
            }

            public C7575b(Network r100) {
                Intrinsics.checkNotNullParameter(r100, "network");
                this.f540855a = r100;
            }
        }

        /* JADX INFO: renamed from: s69.b$b$c */
        public static final class c extends AbstractC7574b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f540856a = null;

            static {
                f540856a = new c();
            }

            public c() {
            }
        }

        /* JADX INFO: renamed from: s69.b$b$d */
        public static final class d extends AbstractC7574b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f540857a = null;

            static {
                f540857a = new d();
            }

            public d() {
            }
        }

        public AbstractC7574b() {
        }
    }

    public static final class c extends ConnectivityManager.NetworkCallback {
        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onUnavailable() {
            super.onUnavailable();
            g49.d.a("DoraWifiManager", "wifi unavailable");
            CopyOnWriteArraySet<a> r100 = b.f540847a;
            b.a(AbstractC7574b.d.f540857a);
        }

        public c() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network r100) {
            Intrinsics.checkNotNullParameter(r100, "network");
            super.onAvailable(r100);
            g49.d.a("DoraWifiManager", "network onAvailable");
            CopyOnWriteArraySet<a> r101 = b.f540847a;
            b.a(new AbstractC7574b.a(r100));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network r100) {
            Intrinsics.checkNotNullParameter(r100, "network");
            super.onLost(r100);
            g49.d.a("DoraWifiManager", "wifi lost");
            CopyOnWriteArraySet<a> r101 = b.f540847a;
            b.a(AbstractC7574b.c.f540856a);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onCapabilitiesChanged(Network r100, NetworkCapabilities r101) {
            Intrinsics.checkNotNullParameter(r100, "network");
            Intrinsics.checkNotNullParameter(r101, "networkCapabilities");
            super.onCapabilitiesChanged(r100, r101);
            g49.d.a("DoraWifiManager", "network capabilities changed");
            CopyOnWriteArraySet<a> r102 = b.f540847a;
            b.a(new AbstractC7574b.C7575b(r100));
        }
    }

    public b() {
    }

    static {
        f540847a = new CopyOnWriteArraySet();
        AppHost.Companion r100 = AppHost.f326268a;
        Object r101 = r100.getApplication().getSystemService("connectivity");
        WifiManager r102 = null;
        if ((r101 instanceof ConnectivityManager) == false) goto L5;
        ConnectivityManager r103 = (ConnectivityManager) r101;
    L6:
        f540848b = r103;
        Object r104 = r100.getApplication().getApplicationContext().getSystemService("wifi");
        if ((r104 instanceof WifiManager) == false) goto L9;
        r102 = (WifiManager) r104;
    L9:
        f540849c = r102;
        f540850d = new AtomicBoolean(false);
        f540851e = new Handler(Looper.getMainLooper());
        f540853g = new c();
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static final void a(AbstractC7574b r100) {
        g49.d.d("DoraWifiManager", "handleNetworkEvent event:" + r100);
        if (f540850d.get() == true) goto L5;
        g49.d.d("DoraWifiManager", "not initialized, skip network event");
        return;
    L5:
        Handler r101 = f540851e;
        r101.removeCallbacksAndMessages(null);
        f540852f = r100;
        r101.postDelayed(new s69.a(), 300);
    }

    public static WifiInfo b(WifiManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102301);
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
        f06.d r106 = r105.preInvoke(102301, "android/net/wifi/WifiManager", BpeaManager.getConnectionInfo, r110, r111, "android.net.wifi.WifiInfo", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (WifiInfo) r106.f474983b;
    L21:
        return r110.getConnectionInfo();
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

    public static void c(Network r100) {
        ConnectivityManager r101 = f540848b;
        boolean r102 = false;
        if (r101 == null) goto L9;
        NetworkCapabilities r103 = r101.getNetworkCapabilities(r100);
        if (r103 == null) goto L9;
        if (r103.hasTransport(1) != true) goto L9;
        boolean r104 = true;
    L10:
        String r105 = "none";
        if (r104 == true) goto L57;
        g49.d.e("DoraWifiManager", "network is not WiFi, skip update");
        Iterator<a> r106 = f540847a.iterator();
    L14:
        if (r106.hasNext() == false) goto L16;
        r106.next().j("none");
        goto L14
    L16:
        return;
    L57:
        WifiManager r107 = f540849c;     // Catch: Exception -> L21
        if (r107 == null) goto L23;
        WifiInfo r108 = b(r107);     // Catch: Exception -> L21
    L24:
        if (r108 != null) goto L59;
        g49.d.e("DoraWifiManager", "wifiInfo is null");
        Iterator<a> r109 = f540847a.iterator();
    L54:
        if (r109.hasNext() == false) goto L56;
        r109.next().j("none");
        goto L54
    L56:
        return;
    L59:
        int r110 = r108.getFrequency();     // Catch: Exception -> L27
    L30:
        if (r110 > 0) goto L33;
        g49.d.e("DoraWifiManager", "Invalid frequency: " + r110);
    L48:
        g49.d.d("DoraWifiManager", "wifi band：" + r105 + "，frequency：" + r110 + " MHz");
        Iterator<a> r111 = f540847a.iterator();
    L50:
        if (r111.hasNext() == false) goto L64;
        r111.next().j(r105);
        goto L50
    L64:
        return;
    L33:
        if (2400 <= r110) goto L35;
    L37:
        boolean r112 = false;
    L38:
        if (r112 == false) goto L41;
        r105 = "2.4G";
        goto L48
    L41:
        if (5150 <= r110) goto L43;
    L45:
        if (r102 == false) goto L47;
        r105 = "5G";
        goto L48
    L47:
        g49.d.e("DoraWifiManager", "Unknown frequency band: " + r110 + " MHz");
        goto L48
    L43:
        if (r110 >= 5851) goto L45;
        r102 = true;
        goto L45
    L35:
        if (r110 >= 2484) goto L37;
        r112 = true;
    L27:
        e = move-exception;
        g49.d.c("DoraWifiManager", "Failed to get frequency", e);
        r110 = 0;
    L23:
        r108 = null;
    L21:
        e = move-exception;
        g49.d.c("DoraWifiManager", "Failed to get wifiInfo", e);
    L9:
        r104 = false;
        goto L10
    }
}
