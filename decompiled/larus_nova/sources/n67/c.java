package n67;

import android.content.Context;
import com.bytedance.push.utils.f;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.lib.AppLogNewUtils;
import org.json.JSONObject;
import v67.e;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements e {
    public c() {
    }

    public final void b(String r100, JSONObject r101) {
        f.b("DefaultEventSender", "[onEventV3] " + r100);
        AppLogNewUtils.onEventV3(r100, r101);
    }

    public final void a(Context r100, String r101, String r102, String r103, long r104, long r105, JSONObject r110) {
        f.b("DefaultEventSender", "[onEventV2] tag:" + r102 + " category:" + r101 + " label:" + r103 + " ext_json:" + r110);
        AppLog.E(r100, r101, r102, r103, r104, r105, r110);
    }
}
