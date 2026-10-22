package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;

/* JADX INFO: loaded from: classes35.dex */
class SystemContentUtil$6$1$1 implements IGetDataCallback<Boolean> {
    final /* synthetic */ SystemContentUtil.AnonymousClass6.a this$1;

    public SystemContentUtil$6$1$1(SystemContentUtil.AnonymousClass6.a r100) {
        this.this$1 = r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        if (TextUtils.isEmpty(r100.getDisplayMsg()) == false) goto L5;
        return;
    L5:
        this.this$1.getClass();
        throw null;
    }

    public void onSuccess(Boolean r100) {
        this.this$1.getClass();
        throw null;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((Boolean) r100);
    }
}
