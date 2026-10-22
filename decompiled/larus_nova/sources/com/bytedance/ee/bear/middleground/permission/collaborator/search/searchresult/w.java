package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import com.bytedance.ee.bear.middleground.permission.collaborator.search.SearchUserResult;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class w<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f233590a;

    public w(s r100) {
        this.f233590a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        SearchUserResult r101 = (SearchUserResult) r100;
        tt5.a.h("SearchUserResultPresenter", "search()...succeed");
        s.H8(this.f233590a).hideLoading();
        b r102 = s.H8(this.f233590a);
        Intrinsics.checkNotNull(r101);
        r102.F4(r101);
        s.H8(this.f233590a).d0(r101.hasMore);
    }
}
