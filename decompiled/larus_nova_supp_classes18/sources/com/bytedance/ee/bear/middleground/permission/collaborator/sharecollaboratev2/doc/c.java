package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc;

import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ IGetDataCallback<Boolean> a;

    public c(ShareDocMemberPresenter.AnonymousClass1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        this.a.onSuccess(Boolean.TRUE);
    }
}
