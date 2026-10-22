package com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarItemTitleView;", "Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarItemRootView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "init", "", "setExpand", "isExpand", "", "getItemHeightInDp", "", "bindItemBackgroundPressedClickListener", "listener", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/IBackgroundPressedItemListener;", "getPressedInnerMarginStart", "getPressedContainerWidth", "getPressedContainerHeight", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SidebarItemTitleView extends SidebarItemRootView {
    public static final int D = 0;
    public static final int E = 0;
    public static final int F = 0;
    public static final int G = 0;
    public static final int H = 0;

    public static final class a {
    }

    public SidebarItemTitleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public SidebarItemTitleView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public SidebarItemTitleView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemRootView, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public float getItemHeightInDp() {
        return 40.0f;
    }

    static {
        D = n.d(32);
        E = n.d(12);
        F = n.d(14);
        G = n.d(16);
        H = n.d(6);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public int getPressedContainerWidth() {
        return ((this.f242230i.getMeasuredWidth() - F) - G) + (H * 2);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemRootView, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public final void e() {
        super.e();
        setExpand(false);
        this.f242223b.setVisibility(8);
        this.f242227f.setVisibility(8);
        TextView r100 = this.f242230i;
        r100.setPadding(F, 0, G, 0);
        r100.setTextSize(n.F(getContext().getResources().getDimensionPixelSize(R.dimen.space_kit_font_14)));
        int r101 = h18.e.f483540a;
        r100.setTypeface(h18.e.b(getContext(), 1));
        r100.setTextColor(getContext().getResources().getColor(R.color.text_caption));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public int getPressedContainerHeight() {
        return D;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public int getPressedInnerMarginStart() {
        return E;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public final void c(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.b r100) {
        if (r100 == null) goto L5;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.c.a(r100, this, this.f242226e);
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemRootView, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView
    public void setExpand(boolean r100) {
        this.f242217u = r100;
    }

    public SidebarItemTitleView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
    }
}
