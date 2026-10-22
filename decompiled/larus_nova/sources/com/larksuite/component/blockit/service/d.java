package com.larksuite.component.blockit.service;

import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.http.response.BaseResponse;
import com.larksuite.framework.http.response.ErrorResult;
import java.io.IOException;

/* JADX INFO: loaded from: classes24.dex */
public final class d extends z18.b<BaseResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BlockitService.g f283143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback f283144b;

    @Override // z18.b
    public final void a(ErrorResult r100) {
        this.f283143a.onError(new com.larksuite.framework.callback.Entity.ErrorResult(-1, r100.getErrorMessage()));
    }

    @Override // z18.c
    public final void onSuccess(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        AppBrandLogger.i("BlockitService", new Object[]{"onSuccess: resp code ", Integer.valueOf(r101.code())});     // Catch: IOException -> L8
        if (r101.isSuccessful() == false) goto L6;
        this.f283143a.a(r101.message(), r101.headers());     // Catch: IOException -> L8
    L11:
        return;
    L6:
        this.f283144b.onError(new com.larksuite.framework.callback.Entity.ErrorResult(r101.code()));     // Catch: IOException -> L8
    L8:
        e = move-exception;
        AppBrandLogger.e("BlockitService", new Object[]{"createBlockEntity fail: parse message error " + e.getMessage()});
        e.printStackTrace();
    }

    public d(c r100, IGetDataCallback r101) {
        this.f283143a = r100;
        this.f283144b = r101;
    }
}
