package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import com.bytedance.ee.bear.share.export.UserInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z implements SearchUserResultAdapter.a {
    public final /* synthetic */ y a;

    public z(y r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.SearchUserResultAdapter.a
    public final void P(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        b.a r0 = this.a.f;
        if (r0 == null) goto L6;
        r0.P(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.SearchUserResultAdapter.a
    public final void a(SearchUserResultAdapter.SearchUserViewHolder r2, UserInfo r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "viewHolder");
        Intrinsics.checkNotNullParameter(r3, "item");
        if (r4 == false) goto L7;
        b.a r5 = this.a.f;
        if (r5 == null) goto L11;
        r5.F8(r3);
        return;
    L11:
        return;
    L7:
        b.a r6 = this.a.f;
        if (r6 == null) goto L13;
        r6.w8(r3);
        return;
    }
}
