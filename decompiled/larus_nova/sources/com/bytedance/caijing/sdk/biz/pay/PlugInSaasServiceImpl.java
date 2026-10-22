package com.bytedance.caijing.sdk.biz.pay;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.saas.CJPaySaasUtils;
import com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInSaasService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/caijing/sdk/biz/pay/PlugInSaasServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/plugin/PlugInSaasService;", "()V", "checkIsCaijingSaasEnv", "", "getSaasHeaders", "", "", "getSaasUrl", "url", "hasEnvHeader", "headerName", "isSaasJsbRequest", "value", "isSaasRequest", "cjpay-se-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PlugInSaasServiceImpl implements PlugInSaasService {
    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInSaasService
    public boolean checkIsCaijingSaasEnv() {
        return CJPaySaasUtils.INSTANCE.checkIsCaijingSaasEnv();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInSaasService
    public Map<String, String> getSaasHeaders() {
        return CJPaySaasUtils.INSTANCE.getSaasHeaders();
    }

    public PlugInSaasServiceImpl() {
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInSaasService
    public String getSaasUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return CJPaySaasUtils.INSTANCE.getSaasUrl(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInSaasService
    public boolean hasEnvHeader(String r100) {
        return CJPayConstant.CAIJING_SAAS_REQUEST_ENV_HEADER.equals(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInSaasService
    public boolean isSaasJsbRequest(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return CJPaySaasUtils.INSTANCE.isSaasJsbRequest(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInSaasService
    public boolean isSaasRequest(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return CJPaySaasUtils.INSTANCE.isSaasRequest(r100);
    }
}
