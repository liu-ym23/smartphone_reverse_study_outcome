package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiSpaceListView f240785a;

    public h(WikiSpaceListView r100) {
        this.f240785a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        List<String> r101 = (List) r100;
        WikiSpaceListRvView r102 = this.f240785a.getRecyclerViewFromXml();
        Intrinsics.checkNotNull(r101);
        r102.setCacheRelationIds(r101);
    }
}
