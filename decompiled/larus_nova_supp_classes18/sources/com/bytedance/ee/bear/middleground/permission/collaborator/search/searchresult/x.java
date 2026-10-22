package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ s a;

    public x(s r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        tt5.a.d("SearchUserResultPresenter", "search()...failed: " + ((Throwable) r3));
        s.H8(this.a).hideLoading();
        s.H8(this.a).d0(false);
    }
}
