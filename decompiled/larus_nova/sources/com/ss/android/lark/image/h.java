package com.ss.android.lark.image;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.image.impl.PerfCompressPicMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback f426364a;

    public h(IGetDataCallback r100) {
        this.f426364a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        PerfCompressPicMonitor.sendCompressPicFailedToTea();
        this.f426364a.onError(new ErrorResult(new RuntimeException(r100)));
    }
}
