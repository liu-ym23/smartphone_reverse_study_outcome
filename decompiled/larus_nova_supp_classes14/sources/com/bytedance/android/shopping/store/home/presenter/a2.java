package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.bytedance.android.shopping.store.home.entity.ECTopSearchInfo;
import com.bytedance.android.shopping.store.repository.vo.SearchSuggestWord;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a2 implements View.OnClickListener {
    public final /* synthetic */ ECShopSliceTopBarPresenter a;

    public a2(ECShopSliceTopBarPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        ECShopSliceTopBarPresenter r0 = this.a;
        ECTopSearchInfo r9 = (ECTopSearchInfo) r0.T().getTopSearchInfo().getValue();
        if (r9 == null) goto L10;
        List<SearchSuggestWord> r10 = r9.getWords();
        if (r10 == null) goto L10;
        SearchSuggestWord r11 = (SearchSuggestWord) CollectionsKt.firstOrNull(r10);
        if (r11 == null) goto L10;
        String r12 = r11.getWord();
        if (r12 == null) goto L10;
    L11:
        ECShopBasePresenter.l0(r0, r12, null, null, null, null, 30);
        return;
    L10:
        r12 = "";
        goto L11
    }
}
