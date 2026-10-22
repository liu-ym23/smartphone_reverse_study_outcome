package com.ss.android.lark.im.sdk.utils;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes36.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback<T> f426210a;

    public b(IGetDataCallback<T> r100) {
        this.f426210a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if ((r101 instanceof ErrorResult) == false) goto L7;
        IGetDataCallback<T> r102 = this.f426210a;
        if (r102 == null) goto L11;
        r102.onError((ErrorResult) r101);
        return;
    L11:
        return;
    L7:
        IGetDataCallback<T> r103 = this.f426210a;
        if (r103 == null) goto L13;
        Exception r104 = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        String r105 = r101.getMessage();
        ErrorResult r106 = new ErrorResult(0);
        ErrorResult.access$002(r106, -1);
        ErrorResult.access$102(r106, -9999);
        ErrorResult.access$202(r106, 0);
        ErrorResult.access$302(r106, r104);
        ErrorResult.access$402(r106, "");
        ErrorResult.access$502(r106, r105);
        ErrorResult.access$602(r106, "");
        ErrorResult.access$702(r106, "");
        ErrorResult.access$802(r106, 0);
        ErrorResult.access$902(r106, null);
        ErrorResult.access$1002(r106, null);
        ErrorResult.access$1102(r106, null);
        r103.onError(r106);
        return;
    }
}
