package com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import com.bytedance.ee.util.ui.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0014J8\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00120\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u001eR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarWikiTreeEmptyView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "emptyView", "Landroid/widget/LinearLayout;", "getEmptyView", "()Landroid/widget/LinearLayout;", "setEmptyView", "(Landroid/widget/LinearLayout;)V", "errorView", "getErrorView", "setErrorView", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "showResult", "state", "Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarEmptyState;", "canCreateNode", "", "listener", "Lkotlin/Function1;", "addListener", "Lkotlin/Function0;", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SidebarWikiTreeEmptyView extends FrameLayout {
    public LinearLayout a;
    public LinearLayout b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SidebarEmptyState.values().length];
            r0[SidebarEmptyState.ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[SidebarEmptyState.EMPTY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[SidebarEmptyState.OK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public final LinearLayout getEmptyView() {
        return this.a;
    }

    public final LinearLayout getErrorView() {
        return this.b;
    }

    public final void setEmptyView(LinearLayout r1) {
        this.a = r1;
    }

    public final void setErrorView(LinearLayout r1) {
        this.b = r1;
    }

    public SidebarWikiTreeEmptyView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        int r3 = com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a.f;
        WikiTreeCtrlView r4 = com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a.C0214a.c(this);
        if (r4 == null) goto L8;
        int r5 = r4.getMeasuredWidth();
        if (r5 <= 0) goto L9;
        setMeasuredDimension(r5 - n.d(24), getMeasuredHeight());
        return;
    L9:
        return;
    }
}
