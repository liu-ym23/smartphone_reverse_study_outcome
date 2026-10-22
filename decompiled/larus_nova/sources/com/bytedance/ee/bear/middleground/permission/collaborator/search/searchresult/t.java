package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import com.bytedance.ee.bear.middleground.permission.collaborator.search.SearchUserResult;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class t<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f233586a;

    public t(s r100) {
        this.f233586a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        SearchUserResult r101 = (SearchUserResult) r100;
        tt5.a.h("SearchUserResultPresenter", "loadMore()...succeed");
        b r102 = s.H8(this.f233586a);
        Intrinsics.checkNotNull(r101);
        r102.y6(r101);
        s.H8(this.f233586a).d0(r101.hasMore);
    }
}
