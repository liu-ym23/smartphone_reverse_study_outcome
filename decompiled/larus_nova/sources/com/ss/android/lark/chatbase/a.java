package com.ss.android.lark.chatbase;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.core.model.PageLoader;

/* JADX INFO: loaded from: classes35.dex */
public final class a<PageData, T> implements PageLoader.IReceiver<PageData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IGetDataCallback<PageData> f416854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.chatbase.model.c<?, T, PageData, com.ss.android.lark.chat.core.model.d<T>> f416855b;

    @Override // com.ss.android.lark.chat.core.model.PageLoader.IReceiver
    public final void b(Throwable r100) {
        IGetDataCallback<PageData> r101 = this.f416854a;
        if (r101 == null) goto L6;
        r101.onError(new ErrorResult(r100.getMessage()));
        return;
    }

    public a(BasePageStore r100, IGetDataCallback r101) {
        this.f416854a = r101;
        this.f416855b = r100;
    }

    @Override // com.ss.android.lark.chat.core.model.PageLoader.IReceiver
    public final void a(int r100, x4b.a r101) {
        if (r100 != 0) goto L5;
        this.f416855b.e(r101);
    L8:
        IGetDataCallback<PageData> r102 = this.f416854a;
        if (r102 == null) goto L12;
        r102.onSuccess(r101);
        return;
    L12:
        return;
    L5:
        if (r100 != 1) goto L7;
        this.f416855b.b(r101);
        goto L8
    L7:
        this.f416855b.f(r101);
        goto L8
    }
}
