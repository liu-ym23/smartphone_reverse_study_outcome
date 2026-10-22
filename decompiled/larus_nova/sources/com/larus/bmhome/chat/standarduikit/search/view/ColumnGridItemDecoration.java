package com.larus.bmhome.chat.standarduikit.search.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/search/view/ColumnGridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "columnSize", "", "marginStart", "spaceHorizontal", "spaceVertical", "marginTop", "marginEnd", "marginBottom", "<init>", "(IIIIIII)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColumnGridItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f309727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f309728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f309729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f309730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f309731e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f309732f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f309733g;

    public ColumnGridItemDecoration() {
        this(2, 0, 0, 0, 0, 0, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r110, View r111, RecyclerView r112, RecyclerView.State r113) {
        Intrinsics.checkNotNullParameter(r110, "outRect");
        Intrinsics.checkNotNullParameter(r111, "view");
        Intrinsics.checkNotNullParameter(r112, "parent");
        Intrinsics.checkNotNullParameter(r113, "state");
        super.getItemOffsets(r110, r111, r112, r113);
        int r114 = r112.getChildAdapterPosition(r111);
        if (r114 != (-1)) goto L6;
        r110.setEmpty();
        return;
    L6:
        boolean r100 = true;
        int r115 = RangesKt.coerceAtLeast(this.f309727a, 1);
        FLogger r101 = FLogger.f375446a;
        r101.i("PureVideoView", "position: " + r114 + ", outRect: " + r110);
        int r102 = r114 % r115;
        int r103 = 0;
        if (r102 != 0) goto L9;
        boolean r104 = true;
    L10:
        if (r114 < 0) goto L13;
        if (r114 >= r115) goto L13;
        boolean r105 = true;
    L15:
        if (r102 != (r115 - 1)) goto L17;
        boolean r106 = true;
    L19:
        if (r113.getItemCount() <= 0) goto L21;
        int r116 = ((r113.getItemCount() - 1) / r115) * r115;
    L22:
        if (r114 >= r116) goto L25;
        r100 = false;
    L25:
        if (r104 == false) goto L27;
        int r117 = this.f309728b;
    L28:
        if (r105 == false) goto L30;
        int r118 = this.f309731e;
    L31:
        if (r106 == false) goto L33;
        int r107 = this.f309732f;
    L34:
        if (r100 == false) goto L36;
        r103 = this.f309733g;
    L36:
        r110.set(r117, r118, r107, r103);
        r101.i("PureVideoView", "position: " + r114 + ", outRect: " + r110 + " after");
        return;
    L33:
        r107 = 0;
        goto L34
    L30:
        r118 = this.f309730d;
        goto L31
    L27:
        r117 = this.f309729c;
        goto L28
    L21:
        r116 = 0;
        goto L22
    L17:
        r106 = false;
    L13:
        r105 = false;
        goto L15
    L9:
        r104 = false;
        goto L10
    }

    public ColumnGridItemDecoration(int r100, int r101, int r102, int r103, int r104, int r105, int r106) {
        this.f309727a = r100;
        this.f309728b = r101;
        this.f309729c = r102;
        this.f309730d = r103;
        this.f309731e = r104;
        this.f309732f = r105;
        this.f309733g = r106;
    }
}
