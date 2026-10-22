package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ IGetDataCallback<Boolean> a;

    public d(ShareDocMemberPresenter.AnonymousClass1 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        tt5.a.f("ShareDocMemberModel", r4, false);
        this.a.onError(new ErrorResult(r4.getMessage()));
    }
}
