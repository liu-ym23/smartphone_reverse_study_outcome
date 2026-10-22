package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.ExistMemberResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.SearchUserResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class q<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchUserResult f233580a;

    public q(SearchUserResult r100) {
        this.f233580a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ExistMemberResult r101 = (ExistMemberResult) r100;
        Intrinsics.checkNotNullParameter(r101, "existMemberResult");
        this.f233580a.existMembers = r101.getExistMembers();
        tt5.a.h("SearchUserResultModel", "getExistMember(): " + r101.getExistMembers());
        return this.f233580a;
    }
}
