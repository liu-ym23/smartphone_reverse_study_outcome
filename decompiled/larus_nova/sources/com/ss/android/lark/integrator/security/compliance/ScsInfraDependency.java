package com.ss.android.lark.integrator.security.compliance;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.security.compliance.infra.dependency.IScsInfraDependency;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@ClaymoreImpl(IScsInfraDependency.class)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/integrator/security/compliance/ScsInfraDependency;", "Lcom/ss/android/lark/security/compliance/infra/dependency/IScsInfraDependency;", "<init>", "()V", "getUserId", "", "getTenantId", "getDeviceId", "getForegroundUserSession", "isBoe", "", "isChinaMainlandGeo", "isFeishuBrand", "getLarkHttpClient", "Lcom/larksuite/framework/http/client/IHttpClient;", "security-compliance-assembly-officesdk_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScsInfraDependency implements IScsInfraDependency {
    public ScsInfraDependency() {
    }

    @Override // com.ss.android.lark.security.compliance.infra.dependency.IScsInfraDependency
    public x18.b getLarkHttpClient() {
        return null;
    }

    @Override // com.ss.android.lark.security.compliance.infra.dependency.IScsInfraDependency
    public String getDeviceId() {
        return ((epb.a) LarkContext.spiByDwarf(epb.a.class)).getDeviceId();
    }

    @Override // com.ss.android.lark.security.compliance.infra.dependency.IScsInfraDependency
    public String getForegroundUserSession() {
        User r100 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r100 == null) goto L6;
        String r101 = r100.getSession();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.ss.android.lark.security.compliance.infra.dependency.IScsInfraDependency
    public String getTenantId() {
        User r100 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r100 == null) goto L6;
        String r101 = r100.getTenantId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.ss.android.lark.security.compliance.infra.dependency.IScsInfraDependency
    public String getUserId() {
        return ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();
    }

    @Override // com.ss.android.lark.security.compliance.infra.dependency.IScsInfraDependency
    public boolean isBoe() {
        return ((gpb.a) ApiUtils.getApi(gpb.a.class)).isBoe();
    }

    @Override // com.ss.android.lark.security.compliance.infra.dependency.IScsInfraDependency
    public boolean isChinaMainlandGeo() {
        return ((gpb.a) ApiUtils.getApi(gpb.a.class)).isChinaMainlandGeo();
    }

    @Override // com.ss.android.lark.security.compliance.infra.dependency.IScsInfraDependency
    public boolean isFeishuBrand() {
        return ((gpb.a) ApiUtils.getApi(gpb.a.class)).isFeishuBrand();
    }
}
