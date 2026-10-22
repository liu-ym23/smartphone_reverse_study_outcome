package com.obric.assistant.common.spi.network;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/common/spi/network/DefaultObricSecurityNetworkServiceImpl;", "Lcom/obric/assistant/common/spi/network/IObricSecurityNetworkService;", "<init>", "()V", "setTLSAuth", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "addObricHostsToOriginHost", "boeEnable", "", "ppeEnable", "hosts", "", "", "allowedToDisplayPrivateUrl", RuleConditionBean.OPEN_URL_KEY, "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricSecurityNetworkServiceImpl implements IObricSecurityNetworkService {
    public DefaultObricSecurityNetworkServiceImpl() {
    }

    @Override // com.obric.assistant.common.spi.network.IObricSecurityNetworkService
    public final boolean a(String r100) {
        return false;
    }

    @Override // com.obric.assistant.common.spi.network.IObricSecurityNetworkService
    public final void b(boolean r100, boolean r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r102, "hosts");
    }

    @Override // com.obric.assistant.common.spi.network.IObricSecurityNetworkService
    public final void c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}
