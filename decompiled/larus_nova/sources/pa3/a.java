package pa3;

import com.bytedance.android.shopping.buynow.monitor.firstscreen.BuyNowFirstScreenMonitor;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import nl.c;
import sc3.b;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, a> f528355c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C7170a f528356d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BuyNowFirstScreenMonitor f528357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.shopping.buynow.monitor.order.a f528358b;

    /* JADX INFO: renamed from: pa3.a$a, reason: collision with other inner class name */
    public static final class C7170a {
        public C7170a() {
        }

        public static a a(String r100) {
            if (r100 != null) goto L4;
        L7:
            boolean r101 = true;
        L8:
            if (r101 == false) goto L11;
            return null;
        L11:
            return (a) ((LinkedHashMap) a.f528355c).get(r100);
        L4:
            if (r100.length() == 0) goto L7;
            r101 = false;
            goto L8
        }

        public final synchronized a b(String r100, String r101, c r102, b r103) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r100, "sessionId");     // Catch: Throwable -> L7
            Intrinsics.checkNotNullParameter("ies_ecommerce_fe_custom_log", "business");     // Catch: Throwable -> L7
            Intrinsics.checkNotNullParameter(r101, "bizCode");     // Catch: Throwable -> L7
            Intrinsics.checkNotNullParameter(r102, "schemaQuery");     // Catch: Throwable -> L7
            a r104 = new a(r101, r102, r103);     // Catch: Throwable -> L7
            a.f528355c.put(r100, r104);     // Catch: Throwable -> L7
            monitor-exit(this);
            return r104;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static {
        f528356d = new C7170a();
        f528355c = new LinkedHashMap();
    }

    public a(String r100, c r101, b r102) {
        this.f528357a = new BuyNowFirstScreenMonitor(r100, r101, r102);
        this.f528358b = new com.bytedance.android.shopping.buynow.monitor.order.a(r100);
    }
}
