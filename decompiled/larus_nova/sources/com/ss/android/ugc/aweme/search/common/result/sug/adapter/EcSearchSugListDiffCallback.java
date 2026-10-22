package com.ss.android.ugc.aweme.search.common.result.sug.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.ss.android.ugc.aweme.search.common.result.sug.model.EcSearchSliceBffData;
import com.ss.android.ugc.aweme.search.common.result.sug.model.SearchSugEntity;
import com.ss.android.ugc.aweme.search.common.result.sug.model.SugExtraInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/sug/adapter/EcSearchSugListDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EcSearchSugListDiffCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SearchSugEntity> f451930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<SearchSugEntity> f451931b;

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f451931b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return this.f451930a.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EcSearchSugListDiffCallback(List<? extends SearchSugEntity> r100, List<? extends SearchSugEntity> r101) {
        Intrinsics.checkNotNullParameter(r100, "oldList");
        Intrinsics.checkNotNullParameter(r101, "newList");
        this.f451930a = r100;
        this.f451931b = r101;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        SearchSugEntity r102 = (SearchSugEntity) CollectionsKt.getOrNull(this.f451930a, r100);
        if (r102 != null) goto L5;
        return false;
    L5:
        SearchSugEntity r103 = (SearchSugEntity) CollectionsKt.getOrNull(this.f451931b, r101);
        if (r103 != null) goto L8;
        return false;
    L8:
        SugExtraInfo r104 = r102.c();
        String r105 = null;
        if (r104 == null) goto L13;
        EcSearchSliceBffData r106 = r104.getEcSearchSliceBffData();
        if (r106 == null) goto L13;
        String r107 = r106.getSliceName();
    L14:
        SugExtraInfo r108 = r103.c();
        if (r108 == null) goto L20;
        EcSearchSliceBffData r109 = r108.getEcSearchSliceBffData();
        if (r109 == null) goto L20;
        r105 = r109.getSliceName();
    L20:
        return Intrinsics.areEqual(r107, r105);
    L13:
        r107 = null;
        goto L14
    }
}
