package com.larus.live.impl.ttlivesdk;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.livehostapi.business.IHostRealNameAuthorization;
import com.bytedance.android.livehostapi.wrap.AbsHostRealNameAuthorization;
import com.larus.caijing_pay.api.ICJPayService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class k extends AbsHostRealNameAuthorization {

    public static final class a {
    }

    public static final class b implements zw8.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IHostRealNameAuthorization.FaceLiveCallback f355861a;

        public b(IHostRealNameAuthorization.FaceLiveCallback r100) {
            this.f355861a = r100;
        }

        @Override // zw8.b
        public final void onDetectFaceLiveFinish(boolean r100, int r101, String r102, JSONObject r103) {
            Intrinsics.checkNotNullParameter(r102, "errorMsg");
            Intrinsics.checkNotNullParameter(r103, "data");
            this.f355861a.onDetectFaceLiveFinish(r100, r101, r102, r103);
        }
    }

    public static final class c implements zw8.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IHostRealNameAuthorization.BytedCertCallback f355862a;

        public c(IHostRealNameAuthorization.BytedCertCallback r100) {
            this.f355862a = r100;
        }

        @Override // zw8.a
        public final void onVerifyResult(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f355862a.onVerifyResult(r100);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostRealNameAuthorization
    public final void preloadInit(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public k() {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostRealNameAuthorization
    public final void startBytedCert(Context r100, Map<String, String> r101, Map<String, ? extends Object> r102, IHostRealNameAuthorization.BytedCertCallback r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "userInfo");
        Intrinsics.checkNotNullParameter(r102, "themeData");
        Intrinsics.checkNotNullParameter(r103, "callback");
        if ((r100 instanceof Activity) == false) goto L5;
        Activity r104 = (Activity) r100;
    L6:
        if (r104 != null) goto L9;
        FLogger.f375446a.i("LiveHostRealNameAuthorization", "doFaceLive call, " + r100 + " is not activity");
        JSONObject r105 = new JSONObject();
        r105.put("error_msg", "context must be activity");
        JSONObject r106 = new JSONObject();
        r106.put("jsonData", r105);
        r103.onVerifyResult(r106);
        return;
    L9:
        ICJPayService r107 = (ICJPayService) ServiceManager.get().getService(ICJPayService.class);
        if (r107 == null) goto L13;
        r107.d(r100, r101, r102, new c(r103));
        return;
    L13:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.android.livehostapi.business.IHostRealNameAuthorization
    public final void doFaceLive(Context r100, String r110, String r111, Map<String, String> r112, Map<String, ? extends Object> r113, IHostRealNameAuthorization.FaceLiveCallback r114) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "identityCode");
        Intrinsics.checkNotNullParameter(r111, "identityName");
        Intrinsics.checkNotNullParameter(r112, "userInfo");
        Intrinsics.checkNotNullParameter(r113, "themeData");
        Intrinsics.checkNotNullParameter(r114, "callback");
        ICJPayService r101 = (ICJPayService) ServiceManager.get().getService(ICJPayService.class);
        if (r101 == null) goto L6;
        r101.f(r100, r110, r111, r112, r113, new b(r114));
        return;
    }
}
