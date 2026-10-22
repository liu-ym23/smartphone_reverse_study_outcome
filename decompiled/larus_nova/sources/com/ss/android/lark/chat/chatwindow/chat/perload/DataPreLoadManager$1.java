package com.ss.android.lark.chat.chatwindow.chat.perload;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.concurrent.CountDownLatch;
import u3b.e;

/* JADX INFO: loaded from: classes35.dex */
class DataPreLoadManager$1 implements IGetDataCallback<e> {
    final /* synthetic */ c this$0;
    final /* synthetic */ CountDownLatch val$countDownLatch;
    final /* synthetic */ e val$preLoadResult;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        this.val$preLoadResult.f548632b = r100;
        this.val$countDownLatch.countDown();
    }

    public void onSuccess(e r100) {
        e r101 = this.val$preLoadResult;
        r101.f548631a = r100.f548631a;
        r101.f548632b = r100.f548632b;
        this.val$countDownLatch.countDown();
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((e) r100);
    }

    public DataPreLoadManager$1(c r100, e r101, CountDownLatch r102) {
        this.this$0 = r100;
        this.val$preLoadResult = r101;
        this.val$countDownLatch = r102;
    }
}
