package lu;

import com.bytedance.android.gamecp.common.network.biz.impl.monitor.apm.DetailTracingNetWorkMonitorStrategy;
import com.bytedance.android.gamecp.common.setting.LiveConfigSettingKeys;
import com.bytedance.android.gamecp.common.setting.config.NetworkApmSetting;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;

/* JADX INFO: loaded from: classes44.dex */
public final class j implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mu.f f510800a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f510801a = null;

        static {
            f510801a = new j(LiveConfigSettingKeys.LIVE_NETWORK_APM_CONFIG.getValue());
        }
    }

    public j(NetworkApmSetting r110) {
        if (hu.b.f487193a.getValue().booleanValue() == false) goto L6;
        this.f510800a = new mu.e();
        return;
    L6:
        if (r110.e() != 1) goto L9;
        this.f510800a = new com.bytedance.android.gamecp.common.network.biz.impl.monitor.apm.a(r110.b());
        return;
    L9:
        if (r110.e() != 2) goto L11;
        this.f510800a = new DetailTracingNetWorkMonitorStrategy(r110.b(), r110.c(), r110.d(), r110.a());
        return;
    L11:
        this.f510800a = new mu.e();
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse intercept(Interceptor.Chain r100) throws Exception {
        Request r101 = r100.request();
        long r102 = System.currentTimeMillis();
        SsResponse r103 = r100.proceed(r101);     // Catch: Exception -> L5
        long r104 = System.currentTimeMillis();     // Catch: Exception -> L5
        this.f510800a.b(r101, r103, r104 - r102);     // Catch: Exception -> L5
        return r103;
    L5:
        e = move-exception;
        System.currentTimeMillis();
        this.f510800a.a(r101, e);
        throw e;
    }
}
