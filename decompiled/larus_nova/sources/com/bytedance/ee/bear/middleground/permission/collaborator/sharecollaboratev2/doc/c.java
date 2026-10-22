package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc;

import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback<Boolean> f233704a;

    public c(ShareDocMemberPresenter.AnonymousClass1 r100) {
        this.f233704a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f233704a.onSuccess(Boolean.TRUE);
    }
}
