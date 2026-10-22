package com.bytedance.bdp.appbase.ui.toast;

import com.bytedance.bdp.appbase.context.BdpAppContext;
import com.bytedance.bdp.appbase.context.service.ContextService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/bdp/appbase/ui/toast/BdpToastService;", "Lcom/bytedance/bdp/appbase/context/service/ContextService;", "Lcom/bytedance/bdp/appbase/context/BdpAppContext;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public abstract class BdpToastService extends ContextService<BdpAppContext> {

    public interface a {
        void onSucceed();
    }

    public abstract void a();
}
