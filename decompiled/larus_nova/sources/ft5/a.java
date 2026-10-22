package ft5;

import com.ss.android.lark.optrace.api.TracingCoreSpan;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public interface a {
    TracingCoreSpan getBaseTraceSpan();

    String getBizType();

    Map<String, Object> getCommonParams();

    Map<String, Object> getReasonParams();

    long getStartTime();

    void reportEvent(String r100, JSONObject r101);
}
