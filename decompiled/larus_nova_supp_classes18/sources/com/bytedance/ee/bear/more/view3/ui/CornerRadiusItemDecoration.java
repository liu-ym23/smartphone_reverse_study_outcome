package com.bytedance.ee.bear.more.view3.ui;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.more.protocol3.panel.ItemUIStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/more/view3/ui/CornerRadiusItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "hostStyle", "Lcom/bytedance/ee/bear/more/protocol3/panel/ItemUIStyle;", "<init>", "(Lcom/bytedance/ee/bear/more/protocol3/panel/ItemUIStyle;)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "setPositionBackground", "itemView", "itemCount", "", "position", "Companion", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CornerRadiusItemDecoration extends RecyclerView.ItemDecoration {
    public final ItemUIStyle a;

    public static final class a {
    }

    static {
    }

    public CornerRadiusItemDecoration() {
        this(ItemUIStyle.FEISHU);
    }

    public CornerRadiusItemDecoration(ItemUIStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "hostStyle");
        this.a = r2;
    }

    public final void getItemOffsets(Rect r6, View r7, RecyclerView r8, RecyclerView.State r9) {
        Intrinsics.checkNotNullParameter(r6, "outRect");
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "parent");
        Intrinsics.checkNotNullParameter(r9, "state");
        RecyclerView.Adapter r0 = r8.getAdapter();
        boolean r1 = false;
        if (r0 == null) goto L5;
        int r2 = r0.getItemCount();
    L6:
        if (r2 <= 0) goto L30;
        int r3 = r8.getChildAdapterPosition(r7);
        Intrinsics.checkNotNullParameter(r7, "itemView");
        if (r3 != 0) goto L10;
        boolean r4 = true;
    L12:
        if (r3 != (r2 - 1)) goto L14;
        boolean r5 = true;
    L15:
        if (r4 == false) goto L18;
        if (r5 == false) goto L18;
        r1 = true;
    L18:
        if (r1 == false) goto L20;
        int r10 = 2131235310;
    L25:
        r7.setBackgroundResource(r10);
        Resources r11 = r7.getResources();
        if (this.a != ItemUIStyle.DOUBAO) goto L28;
        int r12 = 2131100548;
    L29:
        r7.setBackgroundTintList(r11.getColorStateList(r12));
        goto L30
    L28:
        r12 = 2131101932;
        goto L29
    L20:
        if (r4 == false) goto L22;
        r10 = 2131235322;
        goto L25
    L22:
        if (r5 == false) goto L24;
        r10 = 2131235316;
        goto L25
    L24:
        r10 = 2131235305;
        goto L25
    L14:
        r5 = false;
        goto L15
    L10:
        r4 = false;
    L30:
        super.getItemOffsets(r6, r7, r8, r9);
        return;
    L5:
        r2 = 0;
        goto L6
    }
}
