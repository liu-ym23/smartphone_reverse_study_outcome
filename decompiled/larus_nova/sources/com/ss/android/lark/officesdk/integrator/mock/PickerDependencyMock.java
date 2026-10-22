package com.ss.android.lark.officesdk.integrator.mock;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.picker.IPickerDependency;
import com.ss.android.lark.utils.LarkContext;
import yzb.b;

/* JADX INFO: loaded from: classes37.dex */
@ClaymoreImpl(IPickerDependency.class)
public class PickerDependencyMock implements IPickerDependency {
    private static final String TAG = "OfficeSdkMock";

    public PickerDependencyMock() {
    }

    @Override // com.ss.android.lark.picker.IPickerDependency
    public String getLoginUserTenantId() {
        User r100 = ((b) LarkContext.spiByDwarf(b.class)).getForegroundUser();
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r100.getTenantId() != null) goto L8;
        return "";
    L8:
        return r100.getTenantId();
    }
}
