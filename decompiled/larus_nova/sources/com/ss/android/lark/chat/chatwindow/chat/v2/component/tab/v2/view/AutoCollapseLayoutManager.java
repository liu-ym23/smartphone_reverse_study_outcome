package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v2.view;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u000201B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J,\u0010\u001c\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u001fR\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0016J\u001c\u0010%\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u001fR\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0014\u0010&\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u001fR\u00020 H\u0002J\u0014\u0010'\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u001fR\u00020 H\u0002J\u0014\u0010(\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u001fR\u00020 H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u0007H\u0016J\b\u0010.\u001a\u00020\u0007H\u0016J\u0006\u0010/\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u00062"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/AutoCollapseLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "itemSize", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/AutoCollapseLayoutManager$ItemMinSize;", "<init>", "(Landroid/content/Context;IZLcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/AutoCollapseLayoutManager$ItemMinSize;)V", "getContext", "()Landroid/content/Context;", "mSettledListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/AutoCollapseLayoutManager$OnItemSettledListener;", "getMSettledListener", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/AutoCollapseLayoutManager$OnItemSettledListener;", "setMSettledListener", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/AutoCollapseLayoutManager$OnItemSettledListener;)V", "totalCount", "getTotalCount", "()I", "setTotalCount", "(I)V", "isAutoMeasureEnabled", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "onMeasure", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "widthSpec", "heightSpec", "onLayoutChildren", "calculateSuiteChildrenSite", "calculateVerticalSite", "calculateHorizontalSite", "measureChildView", "", "view", "Landroid/view/View;", "canScrollHorizontally", "canScrollVertically", "getVisibleCount", "OnItemSettledListener", "ItemMinSize", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoCollapseLayoutManager extends LinearLayoutManager {
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollHorizontally() {
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        return false;
    }

    public final Context getContext() {
        return null;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean isAutoMeasureEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public final int[] p(View r100) {
        measureChildWithMargins(r100, 0, 0);
        return new int[]{getDecoratedMeasuredWidth(r100), getDecoratedMeasuredHeight(r100)};
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r110, RecyclerView.State r111) {
        Intrinsics.checkNotNullParameter(r110, "recycler");
        Intrinsics.checkNotNullParameter(r111, "state");
        if (getItemCount() > 0) goto L5;
        return;
    L5:
        if (r111.isPreLayout() == true) goto L42;
        detachAndScrapAttachedViews(r110);
        int r100 = 0;
        if (getOrientation() != 1) goto L22;
        View r101 = r110.getViewForPosition(getItemCount() - 1);
        int r112 = p(r101)[1];
        if (r112 > getHeight()) goto L43;
        int r102 = getItemCount() - 1;
        int r103 = 0;
    L13:
        if (r100 >= r102) goto L21;
        View r104 = r110.getViewForPosition(r100);
        Integer r105 = (Integer) r104.getTag(R.id.tag_tab_title_last);
        if (r105 == null) goto L17;
        r104.getLayoutParams().height = r105.intValue();
    L17:
        int r106 = p(r104)[1];
        if (r106 > ((getHeight() - r112) - r103)) goto L20;
        addView(r104);
        int r113 = r103 + r106;
        layoutDecorated(r104, 0, r103, getWidth(), r113);
        r100 = r100 + 1;
        r103 = r113;
        goto L13
    L20:
        throw null;
    L21:
        addView(r101);
        layoutDecorated(r101, 0, r103, getWidth(), r103 + r112);
        return;
    L43:
        return;
    L22:
        View r107 = r110.getViewForPosition(getItemCount() - 1);
        int r114 = p(r107)[0];
        if (r114 > getWidth()) goto L44;
        int r108 = getItemCount() - 1;
        int r109 = 0;
        int r115 = 0;
    L26:
        if (r109 >= r108) goto L34;
        View r116 = r110.getViewForPosition(r109);
        Integer r117 = (Integer) r116.getTag(R.id.tag_tab_title_last);
        if (r117 == null) goto L30;
        r116.getLayoutParams().width = r117.intValue();
    L30:
        int r118 = p(r116)[0];
        if (r118 > ((getWidth() - r114) - r115)) goto L33;
        addView(r116);
        int r119 = r115 + r118;
        layoutDecorated(r116, r115, 0, r119, getHeight());
        r109 = r109 + 1;
        r115 = r119;
        goto L26
    L33:
        throw null;
    L34:
        addView(r107);
        layoutDecorated(r107, r115, 0, r115 + r114, getHeight());
        return;
    L44:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onMeasure(RecyclerView.Recycler r100, RecyclerView.State r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "recycler");
        Intrinsics.checkNotNullParameter(r101, "state");
        super.onMeasure(r100, r101, r102, r103);
    }
}
