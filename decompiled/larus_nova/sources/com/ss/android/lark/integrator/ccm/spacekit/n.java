package com.ss.android.lark.integrator.ccm.spacekit;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes36.dex */
public final class n implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback f427907a;

    public n(IGetDataCallback r100) {
        this.f427907a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        Throwable r101 = r100;
        IGetDataCallback r102 = this.f427907a;
        if (r102 == null) goto L6;
        r102.onError(new ErrorResult(new Exception(r101)));
        return;
    }
}
