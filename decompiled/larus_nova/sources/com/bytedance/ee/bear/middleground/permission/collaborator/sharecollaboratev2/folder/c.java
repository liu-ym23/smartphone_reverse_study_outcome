package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder;

import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback<Boolean> f233754a;

    public c(ShareFolderMemberPresenter.C105371 r100) {
        this.f233754a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f233754a.onSuccess(Boolean.TRUE);
    }
}
