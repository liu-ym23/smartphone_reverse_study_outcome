package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.ExistMemberResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.SearchUserResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q<T, R> implements Function {
    public final /* synthetic */ SearchUserResult a;

    public q(SearchUserResult r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        ExistMemberResult r4 = (ExistMemberResult) r3;
        Intrinsics.checkNotNullParameter(r4, "existMemberResult");
        this.a.existMembers = r4.getExistMembers();
        tt5.a.h("SearchUserResultModel", "getExistMember(): " + r4.getExistMembers());
        return this.a;
    }
}
