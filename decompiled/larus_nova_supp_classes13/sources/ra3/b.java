package ra3;

import com.bytedance.android.ec.core.utils.k0;
import com.bytedance.android.ec.monitor.duration.d;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a implements Action {
        public final /* synthetic */ SsResponse a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;

        public a(SsResponse r1, long r2, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void run() {
            i r0 = i.a;
            d r1 = r0.get(r0.create("ecom_network_perf_monitor"));
            Map r2 = ra3.a.a(k0.c(this.a, this.b));
            if (r2 == null) goto L10;
            Iterator r3 = ((LinkedHashMap) r2).entrySet().iterator();
        L6:
            if (r3.hasNext() == false) goto L10;
            Map.Entry r4 = (Map.Entry) r3.next();
            if (r1 == null) goto L6;
            r1.b((String) r4.getKey(), r4.getValue());
        L10:
            if (r1 == null) goto L12;
            r1.b("api_path", this.c);
        L12:
            long r5 = System.currentTimeMillis();
            if (r1 == null) goto L15;
            r1.d("initial", r5);
        L15:
            if (r1 == null) goto L17;
            r1.d("request_start", r5);
        L17:
            if (r1 == null) goto L19;
            r1.d("request_end", r5);
        L19:
            if (r1 == null) goto L21;
            r1.d("render_start", r5);
        L21:
            if (r1 == null) goto L23;
            r1.d("render_end", r5);
        L23:
            ih.a.d.getClass();
            ih.a.b.getClass();
            JSONObject r6 = ih.a.b();
            if (r6 == null) goto L31;
            Iterator<String> r7 = r6.keys();
        L27:
            if (r7.hasNext() == false) goto L31;
            String r8 = r7.next();
            if (r1 == null) goto L27;
            r1.b(r8, r6.opt(r8));
        L31:
            if (r1 == null) goto L44;
            r1.report();
            return;
        }
    }

    /* JADX INFO: renamed from: ra3.b$b, reason: collision with other inner class name */
    public static final class C0230b implements Action {
        public static final C0230b a = null;

        static {
            a = new C0230b();
        }

        public C0230b() {
        }

        public final void run() {
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            Lazy r0 = BuyNowLog.a;
            BuyNowLog.c("BuyNowNetworkMonitor", "reportAsync + " + ((Throwable) r3).getCause());
        }
    }

    static {
    }

    public static void a(String r1, SsResponse r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "apiPath");
        Intrinsics.checkNotNullParameter(r2, "retrofitResponse");
        fa3.c.b(Completable.fromAction(new a(r2, r3, r1)).subscribeOn(Schedulers.io()).subscribe(C0230b.a, c.a));
    }
}
