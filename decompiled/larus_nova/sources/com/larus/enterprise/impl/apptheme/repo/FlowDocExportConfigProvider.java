package com.larus.enterprise.impl.apptheme.repo;

import com.larus.platform.api.IFlowDocExportConfigProvider;
import com.larus.platform.service.n0;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/larus/enterprise/impl/apptheme/repo/FlowDocExportConfigProvider;", "Lcom/larus/platform/api/IFlowDocExportConfigProvider;", "<init>", "()V", "isTxtExportDisabled", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowDocExportConfigProvider implements IFlowDocExportConfigProvider {

    public static final class a {
    }

    static {
    }

    public FlowDocExportConfigProvider() {
    }

    @Override // com.larus.platform.api.IFlowDocExportConfigProvider
    public final boolean a() {
        boolean r100 = n0.f365775a.b();
        FLogger.f375446a.i("FlowDocExportConfigProvider", "isTxtExportDisabled isInEnterpriseMode=" + r100);
        return r100;
    }
}
