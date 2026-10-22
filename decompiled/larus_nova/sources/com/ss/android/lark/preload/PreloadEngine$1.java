package com.ss.android.lark.preload;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.preload.moment.PreloadMoment;

/* JADX INFO: loaded from: classes37.dex */
class PreloadEngine$1 implements IGetDataCallback<Object> {
    final /* synthetic */ a this$0;
    final /* synthetic */ PreloadMoment val$moment;
    final /* synthetic */ d1c.a val$preloadTask;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        a.a(this.this$0, this.val$preloadTask, this.val$moment);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public void onSuccess(Object r100) {
        a.a(this.this$0, this.val$preloadTask, this.val$moment);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    public PreloadEngine$1(a r100, d1c.a r101, PreloadMoment r102) {
        this.this$0 = r100;
        this.val$preloadTask = r101;
        this.val$moment = r102;
    }
}
