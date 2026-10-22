package p47;

import com.bytedance.pia.core.metrics.TraceEvent;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements f47.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, String> f527709c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f47.c f527710b;

    static {
        HashMap r100 = new HashMap();
        f527709c = r100;
        r100.put(TraceEvent.WARMUP_START, "pia_warmup_start");
        r100.put(TraceEvent.WARMUP_END, "pia_warmup_end");
        r100.put(TraceEvent.INITIALIZE_START, "pia_initialize_start");
        r100.put(TraceEvent.REQUEST_HTML_START, "pia_request_html_start");
        r100.put(TraceEvent.REQUEST_HTML_END, "pia_request_html_end");
        r100.put(TraceEvent.INTERCEPT_HTML_START, "pia_intercept_html_start");
        r100.put(TraceEvent.INTERCEPT_HTML_END, "pia_intercept_html_end");
        r100.put(TraceEvent.MANIFEST_PARSE_END, "pia_manifest_parsed");
        r100.put(TraceEvent.REQUEST_WORKER_START, "pia_request_worker_start");
        r100.put(TraceEvent.REQUEST_WORKER_END, "pia_request_worker_end");
    }

    public i(f47.c r100) {
        this.f527710b = r100;
    }

    @Override // f47.c
    public final void a(String r100, long r101) {
        this.f527710b.a(r100, r101);
        String r102 = (String) ((HashMap) f527709c).get(r100);
        if (r102 == null) goto L6;
        this.f527710b.a(r102, r101);
        return;
    }

    @Override // f47.c
    public final void b(String r100, Object r101) {
        this.f527710b.b(r100, r101);
    }
}
