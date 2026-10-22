package com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarItemDirView;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemDirView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "init", "", "setExpand", "isExpand", "", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SidebarItemDirView extends WikItemDirView {
    public SidebarItemDirView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14, 0);
    }

    public SidebarItemDirView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12, 0);
    }

    public SidebarItemDirView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r110, 8, 0);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public void e() {
        super.e();
        ImageView r100 = this.f242225d;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        r101.width = n.d(16);
        r101.height = n.d(16);
        int r102 = n.d(3);
        r100.setPadding(r102, r102, r102, r102);
        BearLottieView r103 = this.f242224c;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        r104.width = n.d(16);
        r104.height = n.d(16);
        int r105 = n.d(1);
        r103.setPadding(r105, r105, r105, r105);
        ViewGroup.LayoutParams r106 = this.f242226e.getLayoutParams();
        if ((r106 instanceof LinearLayout.LayoutParams) == false) goto L5;
        LinearLayout.LayoutParams r107 = (LinearLayout.LayoutParams) r106;
    L7:
        if (r107 == null) goto L9;
        r107.setMarginStart(0);
        r107.setMarginEnd(n.d(4));
    L9:
        ViewGroup.LayoutParams r108 = this.f242228g.getLayoutParams();
        r108.width = n.d(20);
        r108.height = n.d(20);
        ViewGroup.LayoutParams r109 = this.f242229h.getLayoutParams();
        r109.width = n.d(20);
        r109.height = n.d(20);
        TextView r110 = this.f242230i;
        r110.setPadding(n.d(8), 0, n.d(16), 0);
        r110.setTextSize(n.F(getContext().getResources().getDimensionPixelSize(R.dimen.space_kit_font_16)));
        return;
    L5:
        r107 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView
    public void setExpand(boolean r100) {
        this.f242217u = r100;
        if (r100 == false) goto L5;
        int r101 = R.drawable.ud_icon_expand_down_filled;
    L6:
        this.f242225d.setImageResource(r101);
        l.c(this.f242225d, R.color.icon_n3);
        return;
    L5:
        r101 = R.drawable.ud_icon_expand_right_filled;
        goto L6
    }

    public SidebarItemDirView(Context r100, AttributeSet r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, r103);
    }

    public SidebarItemDirView(Context r100, AttributeSet r101, int r102, int r103, int r104) {
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
