package com.bytedance.android.shopping.inflow.view;

import com.bytedance.android.shopping.feed.widget.searchsimilar.SearchSimilarView;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements SearchSimilarView.a {
    public final /* synthetic */ Ref.ObjectRef a;

    @Override // com.bytedance.android.shopping.feed.widget.searchsimilar.SearchSimilarView.a
    public final void onClick() {
        ce3.b r0 = (ce3.b) this.a.element;
        if (r0 == null) goto L6;
        r0.qa();
        return;
    }

    public d(Ref.ObjectRef r1) {
        this.a = r1;
    }
}
