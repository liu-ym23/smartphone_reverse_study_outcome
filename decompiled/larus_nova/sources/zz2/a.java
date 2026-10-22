package zz2;

import com.bytedance.android.monitorV2.util.l;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import jz2.h;
import jz2.i;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final JSONObject a(i r100) {
        Intrinsics.checkNotNullParameter(r100, "jsbInfo");
        JSONObject r101 = new JSONObject();
        l.q(r101, "event_type", "jsbPerf");
        l.q(r101, "bridge_name", r100.f501150a);
        l.n(r101, "status_code", r100.f501151b);
        l.q(r101, "status_description", r100.f501152c);
        l.q(r101, "protocol_version", r100.f501153d);
        l.o(r101, HiAnalyticsConstant.BI_KEY_COST_TIME, r100.f501154e);
        l.o(r101, "invoke_ts", r100.f501155f);
        l.o(r101, "callback_ts", r100.f501156g);
        l.o(r101, "fireEvent_ts", 0);
        l.q(r101, BdpAppEventConstant.PARAMS_REQUEST_URL, r100.f501157h);
        return r101;
    }

    @JvmStatic
    public static final JSONObject b(h r100) {
        Intrinsics.checkNotNullParameter(r100, "jsbError");
        JSONObject r101 = new JSONObject();
        l.q(r101, "event_type", "jsbError");
        l.q(r101, "bridge_name", r100.f501149c);
        l.q(r101, "error_activity", null);
        l.n(r101, "error_code", r100.f501147a);
        l.q(r101, "error_message", r100.f501148b);
        l.q(r101, "js_type", null);
        l.q(r101, "error_url", null);
        l.n(r101, "is_sync", 0);
        return r101;
    }

    @JvmStatic
    public static final JSONObject c(String r100, Boolean r101, Integer r102, String r103, Integer r104) {
        JSONObject r105 = new JSONObject();
        l.q(r105, "event_type", "nativeError");
        if (r102 == null) goto L5;
        r102.intValue();
        l.n(r105, "error_code", r102.intValue());
    L5:
        if (r103 == null) goto L8;
        l.q(r105, "error_msg", r103);
    L8:
        if (r101 != null) goto L11;
        l.q(r105, "scene", "web_process_terminate");
    L15:
        if (r100 == null) goto L17;
        l.q(r105, "error_url", r100);
    L17:
        if (r104 == null) goto L19;
        r104.intValue();
        l.n(r105, BdpAppEventConstant.HTTP_STATUS, r104.intValue());
    L19:
        return r105;
    L11:
        if (r101.booleanValue() == false) goto L13;
        String r106 = "main_frame";
    L14:
        l.q(r105, "scene", r106);
        goto L15
    L13:
        r106 = "child_resource";
        goto L14
    }
}
