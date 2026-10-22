package com.ss.android.lark.download.service.impl;

import android.content.Context;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;

/* JADX INFO: loaded from: classes35.dex */
class DownloadService$4 implements IGetDataCallback<wbb.d.b> {
    final /* synthetic */ j this$0;
    final /* synthetic */ IGetDataCallback val$callback;
    final /* synthetic */ Context val$context;
    final /* synthetic */ Token val$token;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        IGetDataCallback r101 = this.val$callback;
        if (r101 == null) goto L6;
        r101.onError(r100);
        return;
    }

    public void onSuccess(wbb.d.b r100) {
        String r101 = r100.f559035a;
        IGetDataCallback r102 = this.val$callback;
        if (r102 == null) goto L5;
        r102.onSuccess(r101);
    L5:
        j.a(this.val$context, r101, this.val$token);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((wbb.d.b) r100);
    }

    public DownloadService$4(j r100, IGetDataCallback r101, Context r102, Token r103) {
        this.this$0 = r100;
        this.val$callback = r101;
        this.val$context = r102;
        this.val$token = r103;
    }
}
