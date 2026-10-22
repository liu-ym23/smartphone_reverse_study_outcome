package com.bytedance.awemeopen.apps.framework.framework.recyclerview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jz3.a;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H&J$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/FeedRecyclerListViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/AosRecyclerListViewModel;", "Ljz3/a;", "", "sceneId", "", "data", "", "startIndex", "", "filterData", "removeData", "", "onFeedRemoved", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class FeedRecyclerListViewModel extends AosRecyclerListViewModel<a> {
    /* JADX INFO: renamed from: onFeedRemoved, reason: avoid collision after fix types in other method */
    public void onFeedRemoved2(a r100) {
        Intrinsics.checkNotNullParameter(r100, "removeData");
    }

    public abstract String sceneId();

    public FeedRecyclerListViewModel() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListViewModel
    public /* bridge */ /* synthetic */ void onFeedRemoved(a r100) {
        onFeedRemoved2(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListViewModel
    public List<a> filterData(List<? extends a> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        List<? extends a> r102 = r100;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
        int r105 = 0;
    L4:
        if (r104.hasNext() == false) goto L10;
        Object r106 = r104.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        a r108 = (a) r106;
        r108.f501176d = r105 + r101;
        r103.add(r108);
        r105 = r107;
        goto L4
    L10:
        return CollectionsKt.toMutableList(r103);
    }
}
