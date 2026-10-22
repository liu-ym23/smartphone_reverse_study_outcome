package vx9;

import androidx.collection.LruCache;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import io.opentelemetry.context.g;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class e implements otc.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, String> f557510b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f557511a;

    public static final class a {
    }

    static {
        f557510b = new LruCache(50);
    }

    @Override // otc.e
    public final ltc.d shutdown() {
        if (this.f557511a.compareAndSet(false, true) == false) goto L5;
        ltc.d r100 = new ltc.d();
        r100.e();
        return r100;
    L5:
        return ltc.d.f510763d;
    }

    public e() {
        this.f557511a = new AtomicBoolean();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        shutdown().c(TimeUnit.SECONDS);
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [vx9.c] */
    @Override // otc.e
    public final ltc.d Jd(Collection<? extends ntc.f> r100) {
        Intrinsics.checkNotNullParameter(r100, "spans");
        if (this.f557511a.get() == true) goto L5;
        Iterator<? extends ntc.f> r101 = r100.iterator();
    L8:
        if (r101.hasNext() == false) goto L35;
        ntc.f r102 = r101.next();
        final JSONObject r103 = new JSONObject();
        io.opentelemetry.context.c r104 = g.f492702b;
        wx9.a r105 = null;
        if ((r104 instanceof zx9.a) == false) goto L12;
        zx9.a r106 = (zx9.a) r104;
    L13:
        if (r106 == null) goto L15;
        r105 = r106.getContext(r102.getTraceId(), r102.a());
    L15:
        if (r105 == null) goto L22;
        JSONObject r107 = r105.getCommonParams();
        if (r107 == null) goto L22;
        Iterator<String> r108 = r107.keys();
    L20:
        if (r108.hasNext() == false) goto L22;
        String r109 = r108.next();
        r103.put(r109, r107.get(r109));
    L22:
        String r110 = r102.a();
        if (r110 != null) goto L25;
        r110 = "";
    L25:
        String r111 = f557510b.remove(r110);
        if (r111 != null) goto L28;
        r111 = r102.e().c();
    L28:
        r103.put(BindCardPayConfirmConstants.Key.TRACE_ID, r102.getTraceId());
        r103.put("trace_parent_id", r102.b());
        r103.put("trace_span_id", r110);
        r103.put("trace_span_scene", r111);
        r103.put("trace_span_name", r102.getName());
        long r112 = 1000;
        r103.put("trace_span_start_timestamp", r102.c() / r112);
        r103.put("trace_span_duration", (r102.d() - r102.c()) / r112);
        itc.g r113 = r102.getAttributes();
        final ?? r114 = new c(r103);
        r113.forEach(new d(r114));
        yx9.c.f569437c.d("span named $" + r102.getName() + " export params: " + r103);
        ntc.c r115 = (ntc.c) CollectionsKt.firstOrNull(r102.getEvents());
        if (r115 == null) goto L32;
        String r116 = r115.getName();
        if (r116 == null) goto L32;
    L33:
        yx9.f r117 = yx9.f.f569442c;
        Intrinsics.checkNotNull(r116);
        r117.a(r116, r103);
    L32:
        r116 = r102.getName();
        goto L33
    L12:
        r106 = null;
        goto L13
    L35:
        return ltc.d.f510763d;
    L5:
        return ltc.d.f510764e;
    }
}
