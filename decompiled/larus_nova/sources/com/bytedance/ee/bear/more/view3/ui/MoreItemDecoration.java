package com.bytedance.ee.bear.more.view3.ui;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.more.protocol3.panel.ItemUIStyle;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/more/view3/ui/MoreItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "hostStyle", "Lcom/bytedance/ee/bear/more/protocol3/panel/ItemUIStyle;", "<init>", "(Lcom/bytedance/ee/bear/more/protocol3/panel/ItemUIStyle;)V", "screenWidth", "", "itemMinWidth", "sidePaddingWidth", "itemPaddingWidth", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getDimension", "id", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoreItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f235038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f235039b;

    public MoreItemDecoration() {
        this(ItemUIStyle.FEISHU);
    }

    public MoreItemDecoration(ItemUIStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "hostStyle");
        n.v();
        eu5.b.f474075a.getResources().getDimensionPixelSize(R.dimen.more_item_width);
        ItemUIStyle r101 = ItemUIStyle.DOUBAO;
        int r102 = 0;
        if (r100 != r101) goto L5;
        int r103 = 0;
    L6:
        this.f235038a = r103;
        if (r100 == r101) goto L10;
        r102 = 4;
    L10:
        this.f235039b = r102;
        return;
    L5:
        r103 = 18;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        if (r102.getAdapter() != null) goto L5;
        return;
    L5:
        RecyclerView.Adapter r104 = r102.getAdapter();
        Intrinsics.checkNotNull(r104);
        int r105 = r104.getItemCount();
        int r106 = r102.getChildAdapterPosition(r101);
        boolean r107 = true;
        if (r106 != 0) goto L8;
        boolean r108 = true;
    L10:
        if (r106 == (r105 - 1)) goto L13;
        r107 = false;
    L13:
        if (r108 == false) goto L15;
        int r109 = this.f235038a;
    L16:
        int r110 = n.d(r109);
        if (r107 == false) goto L19;
        int r111 = this.f235038a;
    L20:
        r100.set(r110, 0, n.d(r111), 0);
        return;
    L19:
        r111 = this.f235039b;
        goto L20
    L15:
        r109 = this.f235039b;
        goto L16
    L8:
        r108 = false;
        goto L10
    }
}
