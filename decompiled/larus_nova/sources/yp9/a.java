package yp9;

import android.os.Bundle;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.platform.service.g;
import com.larus.platform.service.o;
import com.larus.utils.f;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f568722a = 0;

    static {
    }

    public static void a(Long r100, Long r101, String r102, String r110, Map r111) {
        Bundle r103 = f.c(new Pair[]{TuplesKt.to("code", r100), TuplesKt.to(HiAnalyticsConstant.BI_KEY_COST_TIME, r101), TuplesKt.to("msg", r102), TuplesKt.to("path", r110)});
        if (r111 == null) goto L5;
        f.a(r103, r111);
    L5:
        o.f365780a.b("flow_request_event", r103);
        JSONObject r112 = new JSONObject();
        r112.put("code", r100);
        r112.put(HiAnalyticsConstant.BI_KEY_COST_TIME, r101);
        r112.put("msg", r102);
        r112.put("path", r110);
        g.f365738a.monitorEventForSlardar("flow_request_event", r112, null, null);
    }
}
