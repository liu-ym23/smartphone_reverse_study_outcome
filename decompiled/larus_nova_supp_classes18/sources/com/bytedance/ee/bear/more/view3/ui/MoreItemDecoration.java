package com.bytedance.ee.bear.more.view3.ui;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.more.protocol3.panel.ItemUIStyle;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/more/view3/ui/MoreItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "hostStyle", "Lcom/bytedance/ee/bear/more/protocol3/panel/ItemUIStyle;", "<init>", "(Lcom/bytedance/ee/bear/more/protocol3/panel/ItemUIStyle;)V", "screenWidth", "", "itemMinWidth", "sidePaddingWidth", "itemPaddingWidth", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getDimension", ResourceData.KEY_ID, "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoreItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;

    public MoreItemDecoration() {
        this(ItemUIStyle.FEISHU);
    }

    public MoreItemDecoration(ItemUIStyle r4) {
        Intrinsics.checkNotNullParameter(r4, "hostStyle");
        n.v();
        eu5.b.a.getResources().getDimensionPixelSize(2131167781);
        ItemUIStyle r0 = ItemUIStyle.DOUBAO;
        int r1 = 0;
        if (r4 != r0) goto L5;
        int r2 = 0;
    L6:
        this.a = r2;
        if (r4 == r0) goto L10;
        r1 = 4;
    L10:
        this.b = r1;
        return;
    L5:
        r2 = 18;
        goto L6
    }

    public final void getItemOffsets(Rect r3, View r4, RecyclerView r5, RecyclerView.State r6) {
        Intrinsics.checkNotNullParameter(r3, "outRect");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, "state");
        if (r5.getAdapter() != null) goto L5;
        return;
    L5:
        RecyclerView.Adapter r7 = r5.getAdapter();
        Intrinsics.checkNotNull(r7);
        int r8 = r7.getItemCount();
        int r9 = r5.getChildAdapterPosition(r4);
        boolean r10 = true;
        if (r9 != 0) goto L8;
        boolean r1 = true;
    L10:
        if (r9 == (r8 - 1)) goto L13;
        r10 = false;
    L13:
        if (r1 == false) goto L15;
        int r11 = this.a;
    L16:
        int r12 = n.d(r11);
        if (r10 == false) goto L19;
        int r13 = this.a;
    L20:
        r3.set(r12, 0, n.d(r13), 0);
        return;
    L19:
        r13 = this.b;
        goto L20
    L15:
        r11 = this.b;
        goto L16
    L8:
        r1 = false;
        goto L10
    }
}
