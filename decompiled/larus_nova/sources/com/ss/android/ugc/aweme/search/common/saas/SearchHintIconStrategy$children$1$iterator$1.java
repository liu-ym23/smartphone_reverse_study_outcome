package com.ss.android.ugc.aweme.search.common.saas;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/ss/android/ugc/aweme/search/common/saas/SearchHintIconStrategy$children$1$iterator$1", "", "Landroid/view/View;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchHintIconStrategy$children$1$iterator$1 implements Iterator<View>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f452006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchHintIconStrategy$children$1 f452007b;

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f452006a >= this.f452007b.f452005a.getChildCount()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final View next() {
        ViewGroup r100 = this.f452007b.f452005a;
        int r101 = this.f452006a;
        this.f452006a = r101 + 1;
        return r100.getChildAt(r101);
    }

    public SearchHintIconStrategy$children$1$iterator$1(SearchHintIconStrategy$children$1 r100) {
        this.f452007b = r100;
    }
}
