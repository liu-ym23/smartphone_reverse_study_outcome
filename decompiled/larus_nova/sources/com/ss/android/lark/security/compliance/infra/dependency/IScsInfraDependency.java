package com.ss.android.lark.security.compliance.infra.dependency;

import kotlin.Metadata;
import x18.b;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/security/compliance/infra/dependency/IScsInfraDependency;", "", "getUserId", "", "getTenantId", "getDeviceId", "getForegroundUserSession", "isBoe", "", "isChinaMainlandGeo", "isFeishuBrand", "getLarkHttpClient", "Lcom/larksuite/framework/http/client/IHttpClient;", "security-compliance-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IScsInfraDependency {
    String getDeviceId();

    String getForegroundUserSession();

    b getLarkHttpClient();

    String getTenantId();

    String getUserId();

    boolean isBoe();

    boolean isChinaMainlandGeo();

    boolean isFeishuBrand();
}
