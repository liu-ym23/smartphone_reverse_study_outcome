package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback<Boolean> f233705a;

    public d(ShareDocMemberPresenter.AnonymousClass1 r100) {
        this.f233705a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        tt5.a.f("ShareDocMemberModel", r101, false);
        this.f233705a.onError(new ErrorResult(r101.getMessage()));
    }
}
