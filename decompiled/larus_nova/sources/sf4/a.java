package sf4;

import android.content.Context;
import com.bytedance.caijing.sdk.infra.base.api.bpea.BpeaService;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BpeaService f541726a = null;

    static {
        ve4.a.f554342a.getClass();
        f541726a = (BpeaService) ve4.a.d(BpeaService.class);
    }

    public static String a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("bpea-cj_risk_sim_info", "bpeaToken");
        return f541726a.getNetworkOperatorIfAvailable(r100, "bpea-cj_risk_sim_info");
    L5:
        e = move-exception;
        CJLogger.e("CJBpea", "getSimLabelIfAvailable fail: " + e);
        return null;
    }
}
