package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.model.GXScroll;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H$J\b\u0010\b\u001a\u00020\u0007H$J\b\u0010\t\u001a\u00020\u0007H$J\b\u0010\n\u001a\u00020\u0007H$J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J \u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleOnLoadMoreListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "<init>", "()V", "lastIndex", "", "onLoadingUp", "", "onLoadingDown", "onScrollIdle", GXScroll.TYPE_ON_SCROLLED, GXScroll.TYPE_ON_SCROLL_STATE_CHANGED, "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "dx", "dy", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class MmSubtitleOnLoadMoreListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f436466a;

    public abstract void j();

    public abstract void k();

    public abstract void l();

    public abstract void m();

    public MmSubtitleOnLoadMoreListener() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();
        if ((r102 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r103 = (LinearLayoutManager) r102;
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        int r104 = r103.findFirstVisibleItemPosition();
        int r105 = r103.findLastVisibleItemPosition();
        if (r104 == 0) goto L12;
        if (r104 == 1) goto L12;
    L14:
        if (r105 < this.f436466a) goto L18;
        this.f436466a = r105;
        if ((r103.getItemCount() - 1) != r105) goto L18;
        j();
    L18:
        if (r101 != 0) goto L21;
        l();
        return;
    L21:
        return;
    L12:
        k();
        goto L14
    L5:
        r103 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrolled(r100, r101, r102);
        RecyclerView.LayoutManager r103 = r100.getLayoutManager();
        if ((r103 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r104 = (LinearLayoutManager) r103;
    L6:
        if (r104 != null) goto L9;
        return;
    L9:
        if (r104.findLastVisibleItemPosition() >= 0) goto L11;
        return;
    L11:
        if (r104.getChildCount() == 0) goto L16;
        m();
        return;
    L16:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
