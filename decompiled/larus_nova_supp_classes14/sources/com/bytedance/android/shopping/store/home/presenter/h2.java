package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.shopping.store.home.entity.ECTopSearchInfo;
import com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView;
import com.bytedance.android.shopping.store.repository.vo.SearchSuggestWord;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h2<T> implements Observer {
    public final /* synthetic */ ECShopSliceTopBarPresenter.b a;

    public h2(ECShopSliceTopBarPresenter.b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        ECTopSearchInfo r4 = (ECTopSearchInfo) r3;
        if (r4 == null) goto L31;
        List<SearchSuggestWord> r5 = r4.getWords();
        if (r5 == null) goto L28;
        SearchSuggestWord r6 = (SearchSuggestWord) CollectionsKt.firstOrNull(r5);
        if (r6 == null) goto L32;
        ECStoreCollapsibleTextView r0 = this.a.a.x;
        if (r0 == null) goto L29;
        String r7 = r6.getWord();
        if (r7 != null) goto L15;
    L18:
        boolean r1 = true;
    L19:
        if (r1 == true) goto L33;
        com.bytedance.android.ec.store.view.q r8 = r0.i(r7);
        r0.m = r8;
        r8.a(0.0f);
        View r9 = r0.f;
        if ((r9 instanceof TextView) == true) goto L24;
        r9 = null;
    L24:
        TextView r10 = (TextView) r9;
        if (r10 == null) goto L30;
        r10.setText(r0.m);
        return;
    L30:
        return;
    L33:
        return;
    L15:
        if (StringsKt.isBlank(r7) == true) goto L18;
        r1 = false;
        goto L19
    L29:
        return;
    L32:
        return;
    L28:
        return;
    }
}
