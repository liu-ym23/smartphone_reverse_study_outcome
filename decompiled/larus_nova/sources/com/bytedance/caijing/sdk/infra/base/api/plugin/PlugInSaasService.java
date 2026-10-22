package com.bytedance.caijing.sdk.infra.base.api.plugin;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0006H&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/plugin/PlugInSaasService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "checkIsCaijingSaasEnv", "", "getSaasHeaders", "", "", "getSaasUrl", "url", "hasEnvHeader", "headerName", "isSaasJsbRequest", "value", "isSaasRequest", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PlugInSaasService extends ICJService {
    boolean checkIsCaijingSaasEnv();

    Map<String, String> getSaasHeaders();

    String getSaasUrl(String r100);

    boolean hasEnvHeader(String r100);

    boolean isSaasJsbRequest(String r100);

    boolean isSaasRequest(String r100);
}
