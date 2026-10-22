package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import com.bytedance.ee.bear.middleground.permission.collaborator.search.SearchUserResult;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ s a;

    public t(s r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        SearchUserResult r4 = (SearchUserResult) r3;
        tt5.a.h("SearchUserResultPresenter", "loadMore()...succeed");
        b r0 = s.H8(this.a);
        Intrinsics.checkNotNull(r4);
        r0.y6(r4);
        s.H8(this.a).d0(r4.hasMore);
    }
}
