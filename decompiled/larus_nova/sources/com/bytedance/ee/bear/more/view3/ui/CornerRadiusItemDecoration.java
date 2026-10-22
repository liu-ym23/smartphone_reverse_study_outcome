package com.bytedance.ee.bear.more.view3.ui;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.more.protocol3.panel.ItemUIStyle;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/more/view3/ui/CornerRadiusItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "hostStyle", "Lcom/bytedance/ee/bear/more/protocol3/panel/ItemUIStyle;", "<init>", "(Lcom/bytedance/ee/bear/more/protocol3/panel/ItemUIStyle;)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "setPositionBackground", "itemView", "itemCount", "", "position", "Companion", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CornerRadiusItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ItemUIStyle f235033a;

    public static final class a {
    }

    static {
    }

    public CornerRadiusItemDecoration() {
        this(ItemUIStyle.FEISHU);
    }

    public CornerRadiusItemDecoration(ItemUIStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "hostStyle");
        this.f235033a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        RecyclerView.Adapter r104 = r102.getAdapter();
        boolean r105 = false;
        if (r104 == null) goto L5;
        int r106 = r104.getItemCount();
    L6:
        if (r106 <= 0) goto L30;
        int r107 = r102.getChildAdapterPosition(r101);
        Intrinsics.checkNotNullParameter(r101, "itemView");
        if (r107 != 0) goto L10;
        boolean r108 = true;
    L12:
        if (r107 != (r106 - 1)) goto L14;
        boolean r109 = true;
    L15:
        if (r108 == false) goto L18;
        if (r109 == false) goto L18;
        r105 = true;
    L18:
        if (r105 == false) goto L20;
        int r110 = R.drawable.facade_round_around_l;
    L25:
        r101.setBackgroundResource(r110);
        Resources r111 = r101.getResources();
        if (this.f235033a != ItemUIStyle.DOUBAO) goto L28;
        int r112 = R.color.bg_body;
    L29:
        r101.setBackgroundTintList(r111.getColorStateList(r112));
        goto L30
    L28:
        r112 = R.color.facade_selector_item_float;
        goto L29
    L20:
        if (r108 == false) goto L22;
        r110 = R.drawable.facade_round_top_l;
        goto L25
    L22:
        if (r109 == false) goto L24;
        r110 = R.drawable.facade_round_bottom_l;
        goto L25
    L24:
        r110 = R.drawable.facade_rectangle;
        goto L25
    L14:
        r109 = false;
        goto L15
    L10:
        r108 = false;
    L30:
        super.getItemOffsets(r100, r101, r102, r103);
        return;
    L5:
        r106 = 0;
        goto L6
    }
}
