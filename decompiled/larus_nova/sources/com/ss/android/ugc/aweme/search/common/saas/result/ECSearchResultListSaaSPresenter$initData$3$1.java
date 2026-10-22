package com.ss.android.ugc.aweme.search.common.saas.result;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/ss/android/ugc/aweme/search/model/SearchResultParam;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECSearchResultListSaaSPresenter$initData$3$1 extends FunctionReferenceImpl implements Function1<SearchResultParam, Unit> {
    public ECSearchResultListSaaSPresenter$initData$3$1(ECSearchResultListSaaSVM r100) {
        super(1, r100, ECSearchResultListSaaSVM.class, "sort", "sort(Lcom/ss/android/ugc/aweme/search/model/SearchResultParam;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SearchResultParam r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SearchResultParam r100) {
        ((ECSearchResultListSaaSVM) this.receiver).sort(r100);
    }
}
