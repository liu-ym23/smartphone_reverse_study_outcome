package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.passport.signinsdk_api.account.Tenant;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@ClaymoreImpl(com.bytedance.ee.bear.lark.dependency.b.class)
public class AccountDependencyImpl implements com.bytedance.ee.bear.lark.dependency.b {
    private static final String TAG = "AccountDependencyImpl";

    public AccountDependencyImpl() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.b
    public String getTenantCode() {
        int r100 = jl5.a.f499529a;
        User r101 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r101 == null) goto L5;
        String r102 = r101.getTenantCode();
    L6:
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.lark.dependency.b
    public String getTenantId() {
        int r100 = jl5.a.f499529a;
        User r101 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r101 == null) goto L5;
        String r102 = r101.getTenantId();
    L6:
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public String getUserName() {
        int r100 = jl5.a.f499529a;
        User r101 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r101 == null) goto L5;
        String r102 = b0c.a.a(r101);
    L6:
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public boolean isCustomer() {
        int r100 = jl5.a.f499529a;
        User r101 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r101 == null) goto L11;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Tenant r102 = r101.tenant;
        if (r102 == null) goto L7;
        String r103 = r102.tenantId;
    L8:
        int r104 = com.ss.android.lark.passport.signinsdk_api.contants.a.f438069a;
        if (Intrinsics.areEqual(r103, "0") != true) goto L11;
        return true;
    L7:
        r103 = null;
    L11:
        return false;
    }

    @Override // com.bytedance.ee.bear.lark.dependency.b
    public boolean isFeishuBrand() {
        int r100 = jl5.a.f499529a;
        return ((gpb.a) ApiUtils.getApi(gpb.a.class)).isFeishuBrand();
    }

    public boolean isSimpleTenant() {
        int r100 = jl5.a.f499529a;
        User r101 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.getTenantTag());
    L7:
        if (r102 != null) goto L10;
        return false;
    L10:
        if (r102.intValue() == 0) goto L13;
        return true;
    L13:
        return false;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.lark.dependency.b
    public String getSession() {
        return jl5.a.a();
    }

    @Override // com.bytedance.ee.bear.lark.dependency.b
    public String getUserId() {
        return jl5.a.b();
    }

    @Override // com.bytedance.ee.bear.lark.dependency.b
    public boolean isPrimaryHost() {
        return jl5.a.c();
    }
}
