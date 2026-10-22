package com.bytedance.bdp.appbase.auth.contextservice.manager;

import com.bytedance.bdp.appbase.auth.contextservice.ILifecycle;
import com.bytedance.bdp.appbase.context.BdpAppContext;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import g94.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0001\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/bdp/appbase/auth/contextservice/manager/AuthorizeManager;", "Lcom/bytedance/bdp/appbase/auth/contextservice/ILifecycle;", "", "onDestroyed", "Lcom/bytedance/bdp/appbase/context/BdpAppContext;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/bdp/appbase/context/BdpAppContext;", "getContext", "()Lcom/bytedance/bdp/appbase/context/BdpAppContext;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bdp-eco-core_release"}, k = 1, mv = {1, 4, 0})
public abstract class AuthorizeManager implements ILifecycle {

    public static final class a {
    }

    static {
    }

    public final BdpAppContext getContext() {
        return null;
    }

    @Override // com.bytedance.bdp.appbase.auth.contextservice.ILifecycle
    public void onDestroyed() {
        throw null;     // Catch: Exception -> L4
    L4:
        e = move-exception;
        b.b("AuthorizeManager", new Object[]{e});
    }
}
