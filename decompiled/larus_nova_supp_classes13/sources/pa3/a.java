package pa3;

import com.bytedance.android.shopping.buynow.monitor.firstscreen.BuyNowFirstScreenMonitor;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import nl.c;
import sc3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final Map<String, a> c = null;
    public static final C0222a d = null;
    public final BuyNowFirstScreenMonitor a;
    public final com.bytedance.android.shopping.buynow.monitor.order.a b;

    /* JADX INFO: renamed from: pa3.a$a, reason: collision with other inner class name */
    public static final class C0222a {
        public C0222a() {
        }

        public static a a(String r1) {
            if (r1 != null) goto L4;
        L7:
            boolean r0 = true;
        L8:
            if (r0 == false) goto L11;
            return null;
        L11:
            return (a) ((LinkedHashMap) a.c).get(r1);
        L4:
            if (r1.length() == 0) goto L7;
            r0 = false;
            goto L8
        }

        public final synchronized a b(String r3, String r4, c r5, b r6) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r3, "sessionId");     // Catch: Throwable -> L7
            Intrinsics.checkNotNullParameter("ies_ecommerce_fe_custom_log", "business");     // Catch: Throwable -> L7
            Intrinsics.checkNotNullParameter(r4, "bizCode");     // Catch: Throwable -> L7
            Intrinsics.checkNotNullParameter(r5, "schemaQuery");     // Catch: Throwable -> L7
            a r0 = new a(r4, r5, r6);     // Catch: Throwable -> L7
            a.c.put(r3, r0);     // Catch: Throwable -> L7
            monitor-exit(this);
            return r0;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static {
        d = new C0222a();
        c = new LinkedHashMap();
    }

    public a(String r2, c r3, b r4) {
        this.a = new BuyNowFirstScreenMonitor(r2, r3, r4);
        this.b = new com.bytedance.android.shopping.buynow.monitor.order.a(r2);
    }
}
