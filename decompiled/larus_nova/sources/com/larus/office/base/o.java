package com.larus.office.base;

import com.ss.android.lark.officesdk.api.init.HostUriParamGroup;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKHostAppHeaderProvider;
import java.util.List;

/* JADX INFO: loaded from: classes29.dex */
public final class o implements IOfficeSDKHostAppHeaderProvider {
    public o() {
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKHostAppHeaderProvider
    public final List<HostUriParamGroup> getOfficeSDKHeader() {
        return OfficeSdkInitor.a(OfficeSdkInitor.f360451a);
    }
}
