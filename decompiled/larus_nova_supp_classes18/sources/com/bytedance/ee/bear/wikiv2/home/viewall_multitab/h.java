package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ WikiSpaceListView a;

    public h(WikiSpaceListView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        List<String> r3 = (List) r2;
        WikiSpaceListRvView r0 = this.a.getRecyclerViewFromXml();
        Intrinsics.checkNotNull(r3);
        r0.setCacheRelationIds(r3);
    }
}
