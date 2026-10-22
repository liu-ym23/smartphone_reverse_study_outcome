package y8a;

import com.monitor.cloudmessage.callback.IConsumerResultCallback;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface b extends IConsumerResultCallback {
    List<String> handleAlogData(long r1, long r3, JSONObject r5);
}
