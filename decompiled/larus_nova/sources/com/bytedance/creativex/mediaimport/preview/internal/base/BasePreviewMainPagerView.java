package com.bytedance.creativex.mediaimport.preview.internal.base;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.creativex.mediaimport.view.internal.base.c;
import fi4.b;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import ti4.s;

/* JADX INFO: loaded from: classes15.dex */
public abstract class BasePreviewMainPagerView<DATA> extends c<DATA> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<s<DATA>> f203424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PublishSubject<Pair<s<DATA>, Integer>> f203425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PublishSubject<Integer> f203426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f203427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BasePreviewMainPagerView$pageChangeListener$1 f203428g;

    @Override // com.bytedance.creativex.mediaimport.view.internal.base.c
    public final PagerAdapter b() {
        return ((b) this.f203427f.getValue()).b();
    }

    @Override // com.bytedance.creativex.mediaimport.view.internal.base.c
    public final List<s<DATA>> a() {
        return this.f203424c;
    }

    public BasePreviewMainPagerView(ViewPager r100) {
        Intrinsics.checkNotNullParameter(r100, "innerViewPager");
        super(r100);
        this.f203424c = new ArrayList();
        this.f203425d = PublishSubject.create();
        this.f203426e = PublishSubject.create();
        this.f203427f = LazyKt.lazy(new gi4.b(this));
        BasePreviewMainPagerView$pageChangeListener$1 r101 = new BasePreviewMainPagerView$pageChangeListener$1(this);
        this.f203428g = r101;
        r100.addOnPageChangeListener(r101);
    }
}
