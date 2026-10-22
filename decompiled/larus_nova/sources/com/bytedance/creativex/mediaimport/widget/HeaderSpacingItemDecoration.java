package com.bytedance.creativex.mediaimport.widget;

import aj4.b;
import aj4.d;
import aj4.e;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ti4.c;
import ti4.y;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002BO\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0001H\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/creativex/mediaimport/widget/HeaderSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Lcom/bytedance/creativex/mediaimport/view/internal/IItemDecoration;", "delegate", "Lcom/bytedance/creativex/mediaimport/view/internal/IPositionMappedItemDecoration;", "enableHeader", "Lkotlin/Function0;", "", "headerFullSpan", "enableFooter", "footerFullSpan", "<init>", "(Lcom/bytedance/creativex/mediaimport/view/internal/IPositionMappedItemDecoration;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "asRawItemDecoration", "updateSpacing", "spacing", "", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeaderSpacingItemDecoration extends RecyclerView.ItemDecoration implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f204170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f204171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Boolean> f204172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f204173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Boolean> f204174e;

    @Override // ti4.c
    public final RecyclerView.ItemDecoration a() {
        return this;
    }

    @Override // ti4.c
    public final void g(int r100) {
        this.f204170a.g(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        RecyclerView.Adapter r105 = r102.getAdapter();
        if (r105 == null) goto L18;
        int r106 = r105.getItemCount();
        if (r104 != 0) goto L11;
        if (this.f204171b.invoke().booleanValue() == false) goto L11;
        if (this.f204172c.invoke().booleanValue() == false) goto L11;
        return;
    L11:
        if (r104 == (r106 - 1)) goto L13;
    L16:
        this.f204170a.a().getItemOffsets(r100, r101, r102, r103);
        return;
    L13:
        if (this.f204173d.invoke().booleanValue() == false) goto L16;
        if (this.f204174e.invoke().booleanValue() == false) goto L16;
        return;
    }

    public HeaderSpacingItemDecoration(y r100, b r101, aj4.c r102, d r103, e r104) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "enableHeader");
        Intrinsics.checkNotNullParameter(r102, "headerFullSpan");
        Intrinsics.checkNotNullParameter(r103, "enableFooter");
        Intrinsics.checkNotNullParameter(r104, "footerFullSpan");
        this.f204170a = r100;
        this.f204171b = r101;
        this.f204172c = r102;
        this.f204173d = r103;
        this.f204174e = r104;
    }
}
