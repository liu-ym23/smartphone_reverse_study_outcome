package com.ss.android.lark.rustinfrabridge.capacity_insufficient;

import android.app.Application;
import com.larksuite.component.ui.dialog.d;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes38.dex */
public class CapacityCallback<Data> implements IGetDataCallback<Data> {
    private static final int ERROR_CODE_CAPACITY_INSUFFICIENT_10019 = 10019;
    private static final int ERROR_CODE_CAPACITY_INSUFFICIENT_507 = 507;
    private IGetDataCallback<Data> mCallback;

    public CapacityCallback() {
    }

    public CapacityCallback(IGetDataCallback<Data> r100) {
        this.mCallback = r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        int r101 = r100.getErrorCode();
        if (r101 != 10019) goto L5;
    L6:
        Application r102 = LarkContext.getApplication();
        if (r102 == null) goto L10;
        d r103 = new d(r102);
        r103.j(R.string.Lark_Chat_CloudDiskFullTitle);
        r103.f284132c.message(R.string.Lark_Chat_CloudDiskFull);
        r103.a(R.id.lkui_dialog_btn_right, R.string.Lark_Legacy_ApplicationPhoneCallTimeButtonKnow, null);
        r103.f284132c.cancelOnTouchOutside(false);
        r103.d();
    L10:
        IGetDataCallback<Data> r104 = this.mCallback;
        if (r104 == null) goto L14;
        r104.onError(r100);
        return;
    L14:
        return;
    L5:
        if (r101 != 507) goto L10;
        goto L6
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public void onSuccess(Data r100) {
        IGetDataCallback<Data> r101 = this.mCallback;
        if (r101 == null) goto L6;
        r101.onSuccess(r100);
        return;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }
}
