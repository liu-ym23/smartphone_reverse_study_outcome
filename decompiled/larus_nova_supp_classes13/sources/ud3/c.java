package ud3;

import com.bytedance.android.shopping.feed.repository.api.AnchorV3Api;
import com.bytedance.android.shopping.feed.repository.dto.SearchSuggestRequestParams;
import com.bytedance.android.shopping.feed.repository.dto.SearchSuggestWordResponse;
import com.bytedance.jedi.model.fetcher.AbstractFetcher;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends AbstractFetcher<SearchSuggestRequestParams, SearchSuggestWordResponse, SearchSuggestRequestParams, SearchSuggestWordResponse> {
    public c() {
    }

    public final Object d(Object r2) {
        SearchSuggestRequestParams r3 = (SearchSuggestRequestParams) r2;
        Intrinsics.checkNotNullParameter(r3, "req");
        return r3;
    }

    public final Observable g(Object r9) {
        SearchSuggestRequestParams r10 = (SearchSuggestRequestParams) r9;
        Intrinsics.checkNotNullParameter(r10, "req");
        AnchorV3Api.a.getClass();
        Intrinsics.checkNotNullParameter(r10, "req");
        AnchorV3Api r2 = AnchorV3Api.a.a;
        if (r2 == null) goto L6;
        Observable<SearchSuggestWordResponse> r11 = r2.getSearchSuggestWords(r10.getBusinessId(), r10.getPd(), r10.getCategoryName(), r10.getWordSource(), r10.getPromotionId());
        if (r11 == null) goto L6;
    L8:
        return r11.subscribeOn(Schedulers.io());
    L6:
        r11 = Observable.error(new Throwable());
        goto L8
    }

    public final Object e(Object r2, Object r3) {
        SearchSuggestWordResponse r4 = (SearchSuggestWordResponse) r3;
        Intrinsics.checkNotNullParameter((SearchSuggestRequestParams) r2, "req");
        Intrinsics.checkNotNullParameter(r4, "resp");
        return r4;
    }
}
