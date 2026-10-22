package com.bytedance.android.shopping.store.search.presenter;

import com.bytedance.android.ec.store.search.recyclerview.searchsug.adapter.SearchSugListAdapter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m0<T> implements Observer {
    public final /* synthetic */ StoreSearchSugListPresenter a;

    public m0(StoreSearchSugListPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        uj3.g r4 = (uj3.g) r3;
        SearchSugListAdapter r0 = this.a.g;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r4, "data");
        ((ArrayList) r0.a).clear();
        List r1 = r0.a;
        ArrayList r2 = (ArrayList) r1;
        r2.addAll(r4.a);
        r0.notifyDataSetChanged();
        return;
    }
}
