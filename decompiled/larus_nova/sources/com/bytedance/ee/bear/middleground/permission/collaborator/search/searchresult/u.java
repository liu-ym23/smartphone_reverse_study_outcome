package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f233587a;

    public u(s r100) {
        this.f233587a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.h("SearchUserResultPresenter", "loadMore()...failed: " + ((Throwable) r100));
        s.H8(this.f233587a).d6();
    }
}
