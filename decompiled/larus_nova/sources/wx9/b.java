package wx9;

import com.larus.trace.tracespan.span.SpanWrapImpl;
import io.opentelemetry.context.f;
import java.util.Iterator;
import jtc.g;
import jtc.i;
import jtc.l;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class b implements wx9.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f561852c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpanWrapImpl f561853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f561854b;

    public static final class a {
    }

    static {
        f561852c = new b(new SpanWrapImpl(g.f500397b, 0), null);
    }

    @Override // io.opentelemetry.context.b
    public final Object get() {
        Intrinsics.checkNotNullParameter(l.f500399a, "key");
        i r100 = this.f561853a.f370163a;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100;
    }

    @Override // wx9.a
    public final SpanWrapImpl c() {
        return this.f561853a;
    }

    @Override // wx9.a
    public final JSONObject getCommonParams() {
        return this.f561854b;
    }

    @Override // io.opentelemetry.context.b
    public final synchronized b a(SpanWrapImpl r100) {
        f r101 = vx9.f.f557512a;
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r101, "k1");     // Catch: Throwable -> L11
        JSONObject r102 = this.f561854b;     // Catch: Throwable -> L11
        if (r102 == null) goto L7;
        JSONObject r103 = new JSONObject(r102.toString());     // Catch: Throwable -> L11
    L8:
        b r104 = new b(r100, r103);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r104;
    L7:
        r103 = null;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // wx9.a
    public final synchronized void b(JSONObject r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "params");     // Catch: Throwable -> L15
        if (this.f561854b != null) goto L6;
        this.f561854b = new JSONObject(r100.toString());     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L6:
        Iterator<String> r101 = r100.keys();     // Catch: Throwable -> L15
    L8:
        if (r101.hasNext() == false) goto L13;
        String r102 = r101.next();     // Catch: Throwable -> L15
        JSONObject r103 = this.f561854b;     // Catch: Throwable -> L15
        if (r103 == null) goto L8;
        r103.put(r102, r100.get(r102));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public b(SpanWrapImpl r100, JSONObject r101) {
        this.f561853a = r100;
        this.f561854b = r101;
    }
}
