package com.bytedance.ee.bear.bitable.card.view.page;

import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.model.GXScroll;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/page/SingleRecordDetailScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "<init>", "()V", "mCurrDy", "", "mScrollListener", "Lcom/bytedance/ee/bear/bitable/card/view/ICardTabFragment$IOnScrollEvent;", GXScroll.TYPE_ON_SCROLLED, "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", GXScroll.TYPE_ON_SCROLL_STATE_CHANGED, "newState", "handleScrollDirectionChanged", "setScrollListener", "scrollListener", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SingleRecordDetailScrollListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f208567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gp4.i.a f208568b;

    public static final class a {
    }

    static {
    }

    public SingleRecordDetailScrollListener() {
    }

    public final void j(int r100) {
        if (r100 >= 0) goto L7;
        tt5.a.h("SingleRecordScroll", "change scroll to top");
        gp4.i.a r101 = this.f208568b;
        if (r101 == null) goto L12;
        r101.b(Boolean.FALSE);
        return;
    L12:
        return;
    L7:
        if (r100 <= 0) goto L14;
        tt5.a.h("SingleRecordScroll", "change scroll to bottom");
        gp4.i.a r102 = this.f208568b;
        if (r102 == null) goto L15;
        r102.b(Boolean.TRUE);
        return;
    L15:
        return;
    }

    public final void setScrollListener(gp4.i.a r100) {
        this.f208568b = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrollStateChanged(r100, r101);
        if (r101 != 0) goto L9;
        gp4.i.a r102 = this.f208568b;
        if (r102 == null) goto L7;
        r102.c();
    L7:
        tt5.a.b("SingleRecordScroll", "scroll idle dy=" + this.f208567a);
        j(this.f208567a);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrolled(r100, r101, r102);
        if (r102 == 0) goto L5;
    L9:
        tt5.a.b("SingleRecordScroll", "scroll dy=" + r102 + " mCurrDy=" + this.f208567a);
        if (r102 >= 0) goto L12;
    L13:
        if (r102 <= 0) goto L15;
    L17:
        this.f208567a = r102;
        return;
    L15:
        if (this.f208567a < 0) goto L17;
    L16:
        j(r102);
        goto L17
    L12:
        if (this.f208567a <= 0) goto L16;
    L5:
        if (r100.getScrollState() != 0) goto L9;
        gp4.i.a r103 = this.f208568b;
        if (r103 == null) goto L9;
        r103.c();
        goto L9
    }
}
