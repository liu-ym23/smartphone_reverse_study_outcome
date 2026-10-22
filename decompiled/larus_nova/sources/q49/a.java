package q49;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.annotation.EnvObserveChangeReason;
import com.larus.dora.impl.device.settings.lab.env.DoraEnvObserveManager;
import g49.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a extends p49.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C7279a f531706b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f531707c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f531708a;

    /* JADX INFO: renamed from: q49.a$a, reason: collision with other inner class name */
    public static final class C7279a {
        public final a a() {
            a r100 = a.f531707c;
            if (r100 != null) goto L15;
            monitor-enter(this);
            r100 = a.f531707c;     // Catch: Throwable -> L9
            if (r100 != null) goto L11;
            r100 = new a();     // Catch: Throwable -> L9
            a.f531707c = r100;     // Catch: Throwable -> L9
        L11:
            monitor-exit(this);
        L9:
            th = move-exception;
            throw th;
        L15:
            return r100;
        }

        public C7279a() {
        }
    }

    public static final class b extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f531709a;

        public b(a r100) {
            this.f531709a = r100;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network r100) {
            Intrinsics.checkNotNullParameter(r100, "network");
            super.onAvailable(r100);
            d.d("NetWorkJob", "network = " + r100);
            a r101 = this.f531709a;
            EnvObserveChangeReason r102 = EnvObserveChangeReason.NETWORK_CHANGE;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, "reason");
            DoraEnvObserveManager.f334593a.getClass();
            DoraEnvObserveManager.h(r102, 0);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network r100) {
            Intrinsics.checkNotNullParameter(r100, "network");
            super.onLost(r100);
            d.d("NetWorkJob", "onLost network = " + r100);
        }
    }

    static {
        f531706b = new C7279a();
    }

    @Override // p49.a
    public final void a() {
        Object r100 = AppHost.f326268a.getApplication().getSystemService("connectivity");     // Catch: Exception -> L6
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L6
        ConnectivityManager r101 = (ConnectivityManager) r100;     // Catch: Exception -> L6
        r101.unregisterNetworkCallback(this.f531708a);     // Catch: Exception -> L8
    L4:
        r101.registerNetworkCallback(new NetworkRequest.Builder().build(), this.f531708a);     // Catch: Exception -> L6
        return;
    L6:
        d.d("NetWorkJob", "registerNetworkCallback failed!");
    }

    public a() {
        this.f531708a = new b(this);
    }
}
