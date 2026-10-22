package tx9;

import com.bytedance.android.livehostapi.business.IHostShare;
import com.ixigua.lib.track.TrackParams;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class j3 {
    public static void a(List r100, List r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(IHostShare.ShareType.SCREENSHOT, "captureType");
        Intrinsics.checkNotNullParameter(r100, "msgIds");
        Intrinsics.checkNotNullParameter(r101, "logIds");
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.put("capture_type", IHostShare.ShareType.SCREENSHOT);
        r102.put("message_id_list", new JSONArray(r100));
        r102.put("log_id_list", new JSONArray(r101));
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("screen_capture_messages");
        r104.f21463a.merge(r103);
        r104.b();
    }
}
