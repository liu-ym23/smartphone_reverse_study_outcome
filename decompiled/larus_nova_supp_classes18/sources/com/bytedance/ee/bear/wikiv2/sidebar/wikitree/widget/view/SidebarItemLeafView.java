package com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;
import com.bytedance.ee.util.ui.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0014¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarItemLeafView;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemLeafView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "init", "", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SidebarItemLeafView extends WikItemLeafView {
    public SidebarItemLeafView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 14, 0);
    }

    public SidebarItemLeafView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 12, 0);
    }

    public SidebarItemLeafView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, r10, 8, 0);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public final void e() {
        super.e();
        ImageView r0 = this.d;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.width = n.d(16);
        r1.height = n.d(16);
        int r2 = n.d(3);
        r0.setPadding(r2, r2, r2, r2);
        BearLottieView r3 = this.c;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        r4.width = n.d(16);
        r4.height = n.d(16);
        int r5 = n.d(1);
        r3.setPadding(r5, r5, r5, r5);
        ViewGroup.LayoutParams r6 = this.e.getLayoutParams();
        if ((r6 instanceof LinearLayout.LayoutParams) == false) goto L5;
        LinearLayout.LayoutParams r7 = (LinearLayout.LayoutParams) r6;
    L7:
        if (r7 == null) goto L9;
        r7.setMarginStart(0);
        r7.setMarginEnd(n.d(4));
    L9:
        ViewGroup.LayoutParams r8 = this.g.getLayoutParams();
        r8.width = n.d(20);
        r8.height = n.d(20);
        ViewGroup.LayoutParams r9 = this.h.getLayoutParams();
        r9.width = n.d(20);
        r9.height = n.d(20);
        TextView r10 = this.i;
        r10.setPadding(n.d(8), 0, n.d(8), 0);
        r10.setTextSize(n.F(getContext().getResources().getDimensionPixelSize(2131168285)));
        return;
    L5:
        r7 = null;
        goto L7
    }

    public SidebarItemLeafView(Context r2, AttributeSet r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, r5);
    }

    public SidebarItemLeafView(Context r1, AttributeSet r2, int r3, int r4, int r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r1, "context");
        super(r1, r2, r3, 0);
    }
}
