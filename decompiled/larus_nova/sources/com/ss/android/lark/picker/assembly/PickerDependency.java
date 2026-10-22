package com.ss.android.lark.picker.assembly;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.picker.IPickerDependency;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import yzb.b;

/* JADX INFO: loaded from: classes37.dex */
@ClaymoreImpl(IPickerDependency.class)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/assembly/PickerDependency;", "Lcom/ss/android/lark/picker/IPickerDependency;", "<init>", "()V", "getLoginUserTenantId", "", "picker-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PickerDependency implements IPickerDependency {
    public PickerDependency() {
    }

    @Override // com.ss.android.lark.picker.IPickerDependency
    public String getLoginUserTenantId() {
        User r100 = ((b) LarkContext.spiByDwarf(b.class)).getForegroundUser();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTenantId();
    }
}
