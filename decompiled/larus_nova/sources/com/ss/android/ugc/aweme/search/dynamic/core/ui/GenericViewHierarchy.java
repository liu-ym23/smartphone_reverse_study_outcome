package com.ss.android.ugc.aweme.search.dynamic.core.ui;

import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.ss.android.ugc.aweme.search.dynamic.core.DynamicCardContext;
import com.ss.android.ugc.aweme.search.dynamic.core.ui.view.DynamicWrapperView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/ui/GenericViewHierarchy;", "Lcom/ss/android/ugc/aweme/search/dynamic/core/ui/DynamicViewHierarchy;", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public class GenericViewHierarchy implements DynamicViewHierarchy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DynamicCardContext f452740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f452741b;

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ui.DynamicViewHierarchy
    public final DynamicWrapperView a() {
        return (DynamicWrapperView) this.f452741b.getValue();
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ui.DynamicViewHierarchy
    public final DynamicWrapperView c() {
        return (DynamicWrapperView) this.f452741b.getValue();
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ui.DynamicViewHierarchy
    public final void clear() {
        ((DynamicWrapperView) this.f452741b.getValue()).removeAllViews();
    }

    public GenericViewHierarchy(DynamicCardContext r100) {
        Intrinsics.checkNotNullParameter(r100, "cardContext");
        this.f452740a = r100;
        this.f452741b = LazyKt.lazy(new GenericViewHierarchy$dynamicWrapperView$2(this));
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ui.DynamicViewHierarchy
    public final void b(AnnieXLynxView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ((DynamicWrapperView) this.f452741b.getValue()).setAnnieXLynxView(r100);
        ((DynamicWrapperView) this.f452741b.getValue()).addView(r100);
    }
}
