package com.larus.enterprise.impl.apptheme;

import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.api.IFlowAccountThemeConfigProvider;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/larus/enterprise/impl/apptheme/FlowAccountThemeConfigProvider;", "Lcom/larus/platform/api/IFlowAccountThemeConfigProvider;", "<init>", "()V", "getEnterpriseLoginText", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowAccountThemeConfigProvider implements IFlowAccountThemeConfigProvider {

    public static final class a {
    }

    static {
    }

    public FlowAccountThemeConfigProvider() {
    }

    @Override // com.larus.platform.api.IFlowAccountThemeConfigProvider
    public final String a() {
        FLogger.f375446a.i("FlowAccountThemeConfigProvider", "getEnterpriseLoginText");
        return AppHost.f326268a.getApplication().getString(R.string.larus_log_in_page_confirm_note_enterprise_cn);
    }
}
