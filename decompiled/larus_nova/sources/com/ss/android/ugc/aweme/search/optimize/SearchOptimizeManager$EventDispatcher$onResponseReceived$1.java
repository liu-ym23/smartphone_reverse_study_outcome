package com.ss.android.ugc.aweme.search.optimize;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/ugc/aweme/search/optimize/IOptimize;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class SearchOptimizeManager$EventDispatcher$onResponseReceived$1 extends Lambda implements Function1<IOptimize, Unit> {
    final /* synthetic */ ResponseStatus $responseStatus;
    final /* synthetic */ SearchOptimizeResponseInfo $searchOptimizeResponseInfo;

    public SearchOptimizeManager$EventDispatcher$onResponseReceived$1(ResponseStatus r100, SearchOptimizeResponseInfo r101) {
        this.$responseStatus = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(IOptimize r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.d(this.$responseStatus);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IOptimize r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
