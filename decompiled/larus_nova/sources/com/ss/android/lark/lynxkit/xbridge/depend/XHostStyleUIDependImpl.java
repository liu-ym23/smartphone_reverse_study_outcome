package com.ss.android.lark.lynxkit.xbridge.depend;

import android.app.Activity;
import com.bytedance.ies.xbridge.base.runtime.depend.ActionSheetBuilder;
import com.bytedance.ies.xbridge.base.runtime.depend.DialogBuilder;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.PageTitleBar;
import com.bytedance.ies.xbridge.base.runtime.depend.ShowActionSheetListener;
import com.bytedance.ies.xbridge.base.runtime.depend.ToastBuilder;
import com.larksuite.component.universe_design.toast.UDToast;
import g66.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s56.f;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/depend/XHostStyleUIDependImpl;", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostStyleUIDepend;", "<init>", "()V", "showToast", "", "toastBuilder", "Lcom/bytedance/ies/xbridge/base/runtime/depend/ToastBuilder;", "(Lcom/bytedance/ies/xbridge/base/runtime/depend/ToastBuilder;)Ljava/lang/Boolean;", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XHostStyleUIDependImpl implements IHostStyleUIDepend {
    public XHostStyleUIDependImpl() {
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
    public Boolean hideLoading(c r100) {
        return null;
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
    public void setPageNaviStyle(c r100, Activity r101, PageTitleBar r102) {
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
    public Boolean showLoading(c r100) {
        return null;
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
    public Boolean showDialog(DialogBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogBuilder");
        return null;
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
    public Boolean showToast(ToastBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "toastBuilder");
        String r101 = r100.getMessage();
        if (r101 == null) goto L12;
        String r102 = r100.getType();
        if (Intrinsics.areEqual(r102, "success") == false) goto L8;
        UDToast.show(r100.getContext(), r101);
        goto L12
    L8:
        if (Intrinsics.areEqual(r102, "error") == false) goto L10;
        UDToast.show(r100.getContext(), r101);
        goto L12
    L10:
        UDToast.show(r100.getContext(), r101);
    L12:
        return Boolean.TRUE;
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
    public Boolean showActionSheet(ActionSheetBuilder r100, ShowActionSheetListener r101) {
        Intrinsics.checkNotNullParameter(r100, "actionSheetBuilder");
        Intrinsics.checkNotNullParameter(r101, "showActionSheetListener");
        return null;
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
    public Boolean showLoading(f r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "showLoadingParams");
        return null;
    }
}
