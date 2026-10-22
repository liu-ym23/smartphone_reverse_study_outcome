package com.bytedance.android.shopping.feed.view;

import com.bytedance.android.shopping.feed.repository.dto.PromotionSearchSuggestWord;
import com.bytedance.android.shopping.feed.repository.dto.SearchSuggestWord;
import com.bytedance.android.shopping.feed.repository.dto.SearchSuggestWordResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l implements Observer<SearchSuggestWordResponse> {
    public final /* synthetic */ InnerFeedPageHeadWidget a;

    public final void onComplete() {
    }

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
    }

    public l(InnerFeedPageHeadWidget r1) {
        this.a = r1;
    }

    public final void onNext(Object r2) {
        SearchSuggestWordResponse r3 = (SearchSuggestWordResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "searchSuggestWordResponse");
        this.a.n = r3;
        List<PromotionSearchSuggestWord> r4 = r3.getData();
        if (r4 == null) goto L9;
        PromotionSearchSuggestWord r5 = (PromotionSearchSuggestWord) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L9;
        List<SearchSuggestWord> r6 = r5.getWords();
        if (r6 == null) goto L9;
        SearchSuggestWord r7 = (SearchSuggestWord) CollectionsKt.firstOrNull(r6);
    L10:
        InnerFeedPageHeadWidget r0 = this.a;
        if (r7 == null) goto L13;
        r7.getWord();
    L13:
        r0.getClass();
        return;
    L9:
        r7 = null;
        goto L10
    }
}
