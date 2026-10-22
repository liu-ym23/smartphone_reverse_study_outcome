package q3b;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.core.model.PageLoader;
import com.ss.android.lark.chatbase.BasePageStore;

/* JADX INFO: loaded from: classes35.dex */
public final class q<PageData, T> implements PageLoader.IReceiver<PageData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IGetDataCallback<com.ss.android.lark.chat.core.model.d<T>> f531589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.chatbase.model.c<?, T, PageData, com.ss.android.lark.chat.core.model.d<T>> f531590b;

    @Override // com.ss.android.lark.chat.core.model.PageLoader.IReceiver
    public final void b(Throwable r100) {
        IGetDataCallback<com.ss.android.lark.chat.core.model.d<T>> r101 = this.f531589a;
        if (r101 == null) goto L6;
        r101.onError(new ErrorResult(r100.getMessage()));
        return;
    }

    public q(BasePageStore r100, IGetDataCallback r101) {
        this.f531589a = r101;
        this.f531590b = r100;
    }

    @Override // com.ss.android.lark.chat.core.model.PageLoader.IReceiver
    public final void a(int r100, x4b.a r101) {
        if (r100 != 0) goto L5;
        this.f531590b.e(r101);
    L8:
        IGetDataCallback<com.ss.android.lark.chat.core.model.d<T>> r102 = this.f531589a;
        if (r102 == null) goto L12;
        r102.onSuccess((com.ss.android.lark.chat.core.model.d) this.f531590b.d());
        return;
    L12:
        return;
    L5:
        if (r100 != 1) goto L7;
        this.f531590b.b(r101);
        goto L8
    L7:
        this.f531590b.f(r101);
        goto L8
    }
}
