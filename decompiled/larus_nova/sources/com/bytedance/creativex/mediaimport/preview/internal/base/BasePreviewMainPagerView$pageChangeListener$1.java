package com.bytedance.creativex.mediaimport.preview.internal.base;

import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import ti4.s;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/bytedance/creativex/mediaimport/preview/internal/base/BasePreviewMainPagerView$pageChangeListener$1", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "onPageSelected", "", "position", "", "onPageScrollStateChanged", "state", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BasePreviewMainPagerView$pageChangeListener$1 extends ViewPager.SimpleOnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BasePreviewMainPagerView<DATA> f203429a;

    public BasePreviewMainPagerView$pageChangeListener$1(BasePreviewMainPagerView<DATA> r100) {
        this.f203429a = r100;
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r100) {
        this.f203429a.f203426e.onNext(Integer.valueOf(r100));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int r100) {
        s r101 = (s) CollectionsKt.getOrNull(this.f203429a.f203424c, r100);
        if (r101 == null) goto L6;
        this.f203429a.f203425d.onNext((Pair<s<DATA>, Integer>) TuplesKt.to(r101, Integer.valueOf(r100)));
        return;
    }
}
