package y8a;

import com.monitor.cloudmessage.callback.IConsumerResultCallback;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface b extends IConsumerResultCallback {
    List<String> handleAlogData(long r100, long r101, JSONObject r102);
}
