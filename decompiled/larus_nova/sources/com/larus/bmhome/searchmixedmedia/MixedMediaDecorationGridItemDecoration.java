package com.larus.bmhome.searchmixedmedia;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.video.b;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/searchmixedmedia/MixedMediaDecorationGridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "defaultSpanCount", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MixedMediaDecorationGridItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f313797a;

    public MixedMediaDecorationGridItemDecoration() {
        this.f313797a = 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        RecyclerView.LayoutManager r104 = r102.getLayoutManager();
        if ((r104 instanceof GridLayoutManager) == false) goto L5;
        GridLayoutManager r105 = (GridLayoutManager) r104;
    L6:
        if (r105 == null) goto L8;
        int r106 = r105.getSpanCount();
    L9:
        int r107 = r102.getChildAdapterPosition(r101);
        if (r107 != (-1)) goto L13;
        r100.set(0, 0, 0, 0);
        return;
    L13:
        int r108 = r107 % r106;
        Lazy r109 = b.f315193a;
        int r110 = b.b(false);
        if (r108 != 0) goto L16;
        int r111 = r110;
    L18:
        if (r108 == (r106 - 1)) goto L21;
        r110 = 0;
    L21:
        r100.set(r111, 0, r110, 0);
        return;
    L16:
        r111 = 0;
        goto L18
    L8:
        r106 = this.f313797a;
        goto L9
    L5:
        r105 = null;
        goto L6
    }
}
