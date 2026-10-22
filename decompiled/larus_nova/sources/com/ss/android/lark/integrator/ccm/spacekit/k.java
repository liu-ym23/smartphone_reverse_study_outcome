package com.ss.android.lark.integrator.ccm.spacekit;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes36.dex */
public final class k implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback f427903a;

    public k(IGetDataCallback r100) {
        this.f427903a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        this.f427903a.onError(new ErrorResult(new Exception(r100)));
    }
}
