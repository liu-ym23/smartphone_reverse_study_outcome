package com.ss.android.lark.chatbase.model;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.core.model.PageLoader;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements PageLoader.a<x4b.a<Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback f416888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FirstScreenLoader f416889b;

    @Override // com.ss.android.lark.chat.core.model.PageLoader.a
    public final void a(final x4b.a r100) {
        Executor r101 = this.f416889b.f416881c;
        final IGetDataCallback r102 = this.f416888a;
        r101.execute(new a(this, r100, r102));
    }

    @Override // com.ss.android.lark.chat.core.model.PageLoader.a
    public final void onError(Throwable r100) {
        IGetDataCallback r101 = this.f416888a;
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof ErrorResult) == false) goto L9;
        r101.onError((ErrorResult) r100);
        return;
    }

    public b(FirstScreenLoader r100, IGetDataCallback r101) {
        this.f416889b = r100;
        this.f416888a = r101;
    }
}
