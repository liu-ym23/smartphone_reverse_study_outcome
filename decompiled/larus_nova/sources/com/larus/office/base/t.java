package com.larus.office.base;

import com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi;
import com.ss.android.lark.officesdk.api.init.HostUriParamGroup;
import java.util.List;

/* JADX INFO: loaded from: classes29.dex */
public final class t implements com.larus.office.base.net.b {
    public t() {
    }

    @Override // com.larus.office.base.net.b
    public final void a() {
        List<HostUriParamGroup> r100 = OfficeSdkInitor.a(OfficeSdkInitor.f360451a);
        OfficeSDKGlobalApi r101 = OfficeSdkInitor.f360455e;
        if (r101 == null) goto L8;
        utb.a r102 = (utb.a) r101.getService(utb.a.class);
        if (r102 == null) goto L9;
        r102.G3(r100);
        return;
    L9:
        return;
    }
}
