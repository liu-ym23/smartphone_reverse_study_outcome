package com.bytedance.bdp.appbase.ui.contextservice;

import com.bytedance.bdp.appbase.context.BdpAppContext;
import com.bytedance.bdp.appbase.context.service.ContextService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/bdp/appbase/ui/contextservice/BasicUiService;", "Lcom/bytedance/bdp/appbase/context/service/ContextService;", "Lcom/bytedance/bdp/appbase/context/BdpAppContext;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/bdp/appbase/context/BdpAppContext;", "getContext", "()Lcom/bytedance/bdp/appbase/context/BdpAppContext;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bdp-appbase-ext_release"}, k = 1, mv = {1, 4, 0})
public class BasicUiService extends ContextService<BdpAppContext> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f201067a = 0;

    public static final class a {
    }

    static {
    }

    public final BdpAppContext getContext() {
        return null;
    }

    @Override // com.bytedance.bdp.appbase.context.service.ContextService
    public final void onDestroy() {
    }
}
