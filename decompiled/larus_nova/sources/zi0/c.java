package zi0;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class c {
    public static final void a(JSONObject r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$set");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.put(r101, r102);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        ALogger.e("LinkRoomFightFullLinkMonitorV2", e);
    }
}
