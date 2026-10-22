package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import com.bytedance.ee.bear.middleground.permission.collaborator.search.SearchUserResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class r<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchUserResult f233581a;

    public r(SearchUserResult r100) {
        this.f233581a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        tt5.a.d("SearchUserResultModel", "getExistMember error: " + r101);
        return this.f233581a;
    }
}
