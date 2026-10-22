package xf;

import android.util.Log;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.g;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, String> f563439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f563440b;

    /* JADX INFO: renamed from: xf.a$a, reason: collision with other inner class name */
    public static final class C8226a {
    }

    public static final class b<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f563441a;

        public b(xf.b r100) {
            this.f563441a = r100;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            g r100 = g.f48122a;     // Catch: Throwable -> L9
            String r101 = this.f563441a.f563440b;     // Catch: Throwable -> L9
            Map r102 = this.f563441a.f563439a;     // Catch: Throwable -> L9
            if ((r102 instanceof Map) == true) goto L5;
            r102 = null;
        L5:
            if (r102 != null) goto L7;
            r102 = MapsKt.emptyMap();     // Catch: Throwable -> L9
        L7:
            r100.logV3(r101, new JSONObject(r102));     // Catch: Throwable -> L9
            return Unit.INSTANCE;
        L9:
            th = move-exception;
            ECExceptionMonitor.e(th);
            return Integer.valueOf(Log.w("MetricsEvent", "post event failed: " + this.f563441a.f563440b, th));
        }
    }

    static {
    }

    public final void b() {
        a("data_type", com.bytedance.android.ec.core.event.a.VALUE_DATA_TYPE);
        a(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        Single.fromCallable(new b((xf.b) this)).subscribeOn(Schedulers.io()).subscribe();
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f563440b = r100;
        this.f563439a = new HashMap();
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 == null) goto L6;
        String r102 = this.f563439a.put(r100, r101);
        return;
    }
}
