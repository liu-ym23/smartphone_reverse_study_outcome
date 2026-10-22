package com.larus.bmhome.chat.search.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/search/view/FixedColumnGridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "marginStart", "", "spaceHorizontal", "spaceVertical", "marginEnd", "splitHorizontalSpacingAcrossSpans", "", "<init>", "(IIIIZ)V", "columnSize", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FixedColumnGridItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f308684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f308685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f308686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f308687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f308688e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f308689f;

    public FixedColumnGridItemDecoration() {
        this(0, 0, 0, 0, 31);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r110, View r111, RecyclerView r112, RecyclerView.State r113) {
        Intrinsics.checkNotNullParameter(r110, "outRect");
        Intrinsics.checkNotNullParameter(r111, "view");
        Intrinsics.checkNotNullParameter(r112, "parent");
        Intrinsics.checkNotNullParameter(r113, "state");
        super.getItemOffsets(r110, r111, r112, r113);
        int r114 = r112.getChildAdapterPosition(r111);
        FLogger r115 = FLogger.f375446a;
        r115.i("SearchListBox_Decoration", "position: " + r114 + ", outRect: " + r110);
        int r116 = this.f308689f;
        boolean r100 = true;
        if ((r114 % r116) != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r114 < 0) goto L9;
        if (r114 >= r116) goto L9;
        boolean r102 = true;
    L11:
        if ((r114 % r116) == (r116 - 1)) goto L14;
        r100 = false;
    L14:
        int r117 = this.f308685b;
        int r103 = r117 / 2;
        boolean r104 = this.f308688e;
        if (r104 == false) goto L19;
        if (r101 == false) goto L18;
        int r105 = this.f308684a;
    L22:
        if (r102 == false) goto L24;
        int r106 = 0;
    L25:
        if (r104 == false) goto L29;
        if (r100 == false) goto L28;
        int r118 = this.f308687d;
    L32:
        r110.set(r105, r106, r118, 0);
        r115.i("SearchListBox_Decoration", "position: " + r114 + ", outRect: " + r110 + " after");
        return;
    L28:
        r118 = r117 - r103;
        goto L32
    L29:
        if (r100 == false) goto L31;
        r118 = this.f308687d;
        goto L32
    L31:
        r118 = 0;
        goto L32
    L24:
        r106 = this.f308686c;
        goto L25
    L18:
        r105 = r103;
        goto L22
    L19:
        if (r101 == false) goto L21;
        r105 = this.f308684a;
        goto L22
    L21:
        r105 = r117;
    L9:
        r102 = false;
        goto L11
    L5:
        r101 = false;
        goto L6
    }

    public FixedColumnGridItemDecoration(int r100, int r101, int r102, int r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this.f308684a = r100;
        this.f308685b = r101;
        this.f308686c = r102;
        this.f308687d = r103;
        this.f308688e = false;
        this.f308689f = 2;
    }
}
