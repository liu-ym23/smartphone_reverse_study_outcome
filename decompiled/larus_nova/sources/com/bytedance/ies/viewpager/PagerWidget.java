package com.bytedance.ies.viewpager;

import androidx.viewpager.widget.ViewPager;
import com.bytedance.ies.sve_core.PureWidget;
import com.bytedance.ies.sve_core.p;
import com.bytedance.ies.sve_core.q;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import m56.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0005J\u0011\u0010\u0006\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/viewpager/PagerWidget;", "Lcom/bytedance/ies/sve_core/p;", "P", "Landroidx/viewpager/widget/ViewPager;", "VP", "Lcom/bytedance/ies/sve_core/PureWidget;", "getViewPager", "()Landroid/support/v4/view/ViewPager;", "sve-view_release"}, k = 1, mv = {1, 4, 0})
public class PagerWidget<P extends p, VP extends ViewPager> extends PureWidget<P> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SimpleSVEViewPagerAdapter f249256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<a> f249257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<String, PagerItemWidget<?>> f249258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<VP, Object> f249259f;

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public int getLayoutId() {
        return R.layout.sve_view_pager;
    }

    @Override // com.bytedance.ies.sve_core.q
    public final void wj(P r100) {
    }

    public VP Nq() {
        return (VP) this.contentView.findViewById(R.id.sve_view_pager);
    }

    @Override // com.bytedance.ies.sve_core.PureWidget, com.bytedance.ies.sve_core.q
    public final List<q<?>> Zo() {
        SimpleSVEViewPagerAdapter r100 = this.f249256c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return CollectionsKt.filterNotNull(r100.f249260a);
    }

    @Override // com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        this.f249256c = new SimpleSVEViewPagerAdapter(this.f249257d, this, this.f249258e);
        ViewPager r100 = Nq();
        if (r100 == null) goto L8;
        r100.setAdapter(this.f249256c);
        Function1<VP, Object> r101 = this.f249259f;
        if (r101 == null) goto L9;
        r101.invoke((VP) r100);
        return;
    L9:
        return;
    }

    public final void Pq(String r100) {
        Iterator<T> r101 = this.f249257d.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L15;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (Intrinsics.areEqual(((a) r103).getTabId(), r100) == true) goto L10;
        r102 = r104;
        goto L4
    L10:
        ViewPager r105 = Nq();
        if (r105 == null) goto L18;
        r105.setCurrentItem(r102);
        return;
    L18:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PagerWidget(List<? extends a> r100, Function1<? super String, ? extends PagerItemWidget<?>> r101, Function1<? super VP, ? extends Object> r102) {
        super(null);
        this.f249257d = r100;
        this.f249258e = r101;
        this.f249259f = r102;
    }
}
