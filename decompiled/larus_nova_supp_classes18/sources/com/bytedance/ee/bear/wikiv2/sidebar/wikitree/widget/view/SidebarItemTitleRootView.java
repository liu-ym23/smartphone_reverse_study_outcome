package com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.util.ui.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0007H\u0014J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarItemTitleRootView;", "Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarItemRootView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "init", "", "initListener", "setFocus", "isFocus", "", "getItemHeightInDp", "", "updateTopPadding", "position", "bindItemBackgroundPressedClickListener", "listener", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/IBackgroundPressedItemListener;", "getPressedGravityType", "getPressedInnerMarginStart", "getPressedContainerWidth", "getPressedContainerHeight", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SidebarItemTitleRootView extends SidebarItemRootView {
    public static final int D = 0;
    public static final int E = 0;
    public static final int F = 0;

    public static final class a {
    }

    public SidebarItemTitleRootView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public SidebarItemTitleRootView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public SidebarItemTitleRootView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemRootView, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public float getItemHeightInDp() {
        return 51.0f;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public int getPressedGravityType() {
        return 80;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemRootView, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public void setFocus(boolean r1) {
    }

    static {
        D = n.d(32);
        E = n.d(8);
        F = n.d(4);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public int getPressedContainerWidth() {
        return (this.i.getMeasuredWidth() + this.b.getMeasuredWidth()) + (F * 2);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemRootView, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public final void e() {
        super.e();
        TextView r0 = this.i;
        r0.setPadding(0, 0, 0, 0);
        r0.setTextSize(n.F(getContext().getResources().getDimensionPixelSize(2131168285)));
        int r1 = h18.e.a;
        r0.setTypeface(h18.e.b(getContext(), 1));
        r0.setTextColor(getContext().getResources().getColor(2131106622));
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if ((r2 instanceof LinearLayout.LayoutParams) == false) goto L5;
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) r2;
    L7:
        if (r3 == null) goto L9;
        r3.gravity = 48;
        r3.topMargin = n.d(11);
        r3.leftMargin = n.d(12);
    L9:
        FrameLayout r4 = this.b;
        if (r4 == null) goto L17;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if ((r5 instanceof LinearLayout.LayoutParams) == false) goto L14;
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) r5;
    L15:
        if (r6 == null) goto L17;
        r6.gravity = 48;
        r6.topMargin = n.d(16);
        goto L17
    L14:
        r6 = null;
    L17:
        AppCompatImageView r7 = this.y;
        if (r7 == null) goto L25;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if ((r8 instanceof FrameLayout.LayoutParams) == false) goto L22;
        FrameLayout.LayoutParams r9 = (FrameLayout.LayoutParams) r8;
    L23:
        if (r9 == null) goto L25;
        r9.gravity = 8388613;
        r9.topMargin = n.d(22);
        goto L25
    L22:
        r9 = null;
    L25:
        this.e.setOnClickListener(null);
        this.a.setOnClickListener(null);
        this.i.setOnClickListener(new com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view.a(this));
        this.b.setOnClickListener(new b(this));
        return;
    L5:
        r3 = null;
        goto L7
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
    public final void c(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.b r2) {
        if (r2 == null) goto L4;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.c.a(r2, this, this.b);
    L4:
        if (r2 == null) goto L7;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.c.a(r2, this, this.i);
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemRootView
    public final void k(int r1) {
        setPadding(0, 0, 0, 0);
    }

    public SidebarItemTitleRootView(Context r2, AttributeSet r3, int r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, 0);
    }
}
