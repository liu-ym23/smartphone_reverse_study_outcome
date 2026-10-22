package wx9;

import com.larus.trace.tracespan.span.SpanWrapImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public interface a extends io.opentelemetry.context.b {
    void b(JSONObject r100);

    SpanWrapImpl c();

    JSONObject getCommonParams();
}
