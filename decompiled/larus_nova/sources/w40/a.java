package w40;

import android.app.Activity;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.android.live.core.ILiveCoreService;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.monitor.trace.c;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.live.core.verify.interceptor.MinorInterceptor;
import com.bytedance.android.live.core.verify.monitor.RealNameFullMonitor;
import com.bytedance.android.live.network.impl.interceptor.u;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.vs.f;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Arrays;
import java.util.Map;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public class a implements ILiveCoreService {
    public a() {
    }

    @Override // com.bytedance.android.live.core.ILiveCoreService
    public boolean realNameUseTracePlatform() {
        int r100 = RealNameFullMonitor.f66487a;
        return true;
    }

    @Override // com.bytedance.android.live.core.ILiveCoreService
    public void sendLog(String r100, Map<String, String> r101, Object... r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "extraParams");
        Intrinsics.checkNotNullParameter(r102, "args");
        f.f159373c.c(r100, r101, Arrays.copyOf(r102, r102.length));
    }

    @Override // com.bytedance.android.live.core.ILiveCoreService
    public void reportUseTrace(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        int r104 = RealNameFullMonitor.f66487a;
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        int r105 = e.f64997m;
        e.a r106 = e.b.a(r100, LiveTracingMonitor.EventModule.REAL_NAME.getName());
        r106.f65012c = "webcast_client_community";
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L5
        Object r108 = Result.m9449constructorimpl(((IUserService) k.n(IUserService.class)).user().n());     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r108) == false) goto L10;
        r108 = "";
    L10:
        r106.f65016g = (String) r108;
        e r109 = r106.a();
        a60.e r110 = c.f64995a;
        Intrinsics.checkNotNullParameter(r109, "traceMeta");
        TraceMonitor.i(r109, r101, r102, r103);
        return;
    L5:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // com.bytedance.android.live.core.ILiveCoreService
    public boolean liveRechargeIntercept(String r100, int r101, BaseResponse<?, ?> r110, String r111, RequestError r112) {
        Intrinsics.checkNotNullParameter(r110, "response");
        Intrinsics.checkNotNullParameter(r111, "requestPage");
        return u.f83895b.a(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.android.live.core.ILiveCoreService
    public void minorInterceptOld(Activity r100, int r101, String r110, RequestError r111, t80.a r112) {
        Intrinsics.checkNotNullParameter(r110, "requestPage");
        MinorInterceptor.f66446d.h(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.android.live.core.ILiveCoreService
    public void minorIntercept(Activity r110, int r111, String r112, RequestError r113, t80.a r114, JSONObject r210) {
        Intrinsics.checkNotNullParameter(r112, "requestPage");
        Intrinsics.checkNotNullParameter(r210, "result");
        MinorInterceptor r100 = MinorInterceptor.f66446d;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r112, "requestPage");
        Intrinsics.checkNotNullParameter(r210, "result");
        if (MinorInterceptor.f66444b.contains(Integer.valueOf(r111)) == false) goto L30;
        JSONObject r101 = r210.optJSONObject(TemplateNodeType.RAW);
        if (r101 == null) goto L8;
        JSONObject r102 = r101.optJSONObject("extra");
    L10:
        if (r102 == null) goto L12;
        String r115 = r102.optString("scene", "");
    L13:
        if (r102 == null) goto L15;
        String r116 = r102.optString(BytedCertConstant.CertKey.FLOW, "");
    L16:
        if (r102 == null) goto L18;
        String r117 = r102.optString("ticket", "");
    L19:
        if (r115 != null) goto L21;
    L24:
        boolean r103 = true;
    L25:
        if (r103 == false) goto L27;
        r100.h(r110, r111, "live_detail", r113, r114);
        return;
    L27:
        r100.g(r110, r111, "live_detail", r113, r114, r115, r116, r117, true);
        return;
    L21:
        if (r115.length() == 0) goto L24;
        r103 = false;
        goto L25
    L18:
        r117 = null;
        goto L19
    L15:
        r116 = null;
        goto L16
    L12:
        r115 = null;
        goto L13
    L8:
        r102 = null;
        goto L10
    }
}
