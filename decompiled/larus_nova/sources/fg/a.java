package fg;

import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.ss.android.lark.utils.statistics.PerfLog;
import gg.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import of.b;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements IECUserTrackerService {
    public a() {
    }

    @Override // com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService
    public final of.a getMarketingService() {
        return c.f481093f;
    }

    @Override // com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService
    public final void enterPage(b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ConcurrentHashMap<String, Map<String, hg.a>> r101 = c.f481088a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService
    public final void leavePage(b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        c.f481093f.leavePage(r100);
    }
}
