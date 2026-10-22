package com.bytedance.ee.bear.bitable.itemview.record.list;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.model.GXScroll;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/record/list/HorizontalRecyclerView$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "lastVisibleItemPosition", "", "hasNewItemVisible", "", "updateLayoutRunnable", "Ljava/lang/Runnable;", GXScroll.TYPE_ON_SCROLLED, "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", GXScroll.TYPE_ON_SCROLL_STATE_CHANGED, "newState", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HorizontalRecyclerView$scrollListener$1 extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f214106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f214107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f214108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HorizontalRecyclerView f214109d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HorizontalRecyclerView f214110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HorizontalRecyclerView$scrollListener$1 f214111b;

        public a(HorizontalRecyclerView r100, HorizontalRecyclerView$scrollListener$1 r101) {
            this.f214110a = r100;
            this.f214111b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.b("HorizontalContainerItem", "stop scroll requestLayout");     // Catch: Throwable -> L4
            this.f214110a.requestLayout();     // Catch: Throwable -> L4
            this.f214111b.f214108c = null;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public HorizontalRecyclerView$scrollListener$1(HorizontalRecyclerView r100) {
        this.f214109d = r100;
        this.f214106a = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrollStateChanged(r100, r101);
        tt5.a.b("HorizontalContainerItem", "onScrollStateChanged SCROLL_STATE_IDLE");
        if (r101 == 0) goto L5;
        return;
    L5:
        if (this.f214107b == false) goto L11;
        this.f214107b = false;
        if (this.f214108c != null) goto L12;
        HorizontalRecyclerView r102 = this.f214109d;
        a r103 = new a(r102, this);
        this.f214108c = r103;
        r102.postDelayed(r103, 200);
        return;
    L12:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrolled(r100, r101, r102);
        RecyclerView.LayoutManager r103 = r100.getLayoutManager();
        if ((r103 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r104 = (LinearLayoutManager) r103;
    L6:
        if (r104 != null) goto L8;
        return;
    L8:
        int r105 = r104.findLastVisibleItemPosition();
        Runnable r106 = this.f214108c;
        if (r106 == null) goto L12;
        this.f214109d.removeCallbacks(r106);
        this.f214108c = null;
    L12:
        if (r105 == this.f214106a) goto L15;
        tt5.a.b("HorizontalContainerItem", "onScrolled visibleItemPosition Change");
        this.f214106a = r105;
        this.f214107b = true;
        this.f214109d.t();
        return;
    L15:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
