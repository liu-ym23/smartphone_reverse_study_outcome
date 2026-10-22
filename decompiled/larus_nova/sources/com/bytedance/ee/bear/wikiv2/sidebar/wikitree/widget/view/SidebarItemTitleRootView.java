package com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.GravityCompat;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0007H\u0014J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarItemTitleRootView;", "Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarItemRootView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "init", "", "initListener", "setFocus", "isFocus", "", "getItemHeightInDp", "", "updateTopPadding", "position", "bindItemBackgroundPressedClickListener", "listener", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/IBackgroundPressedItemListener;", "getPressedGravityType", "getPressedInnerMarginStart", "getPressedContainerWidth", "getPressedContainerHeight", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SidebarItemTitleRootView extends SidebarItemRootView {
    public static final int D = 0;
    public static final int E = 0;
    public static final int F = 0;

    public static final class a {
    }

    public SidebarItemTitleRootView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public SidebarItemTitleRootView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public SidebarItemTitleRootView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
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
    public void setFocus(boolean r100) {
    }

    static {
        D = n.d(32);
        E = n.d(8);
        F = n.d(4);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public int getPressedContainerWidth() {
        return (this.f242230i.getMeasuredWidth() + this.f242223b.getMeasuredWidth()) + (F * 2);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemRootView, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public final void e() {
        super.e();
        TextView r100 = this.f242230i;
        r100.setPadding(0, 0, 0, 0);
        r100.setTextSize(n.F(getContext().getResources().getDimensionPixelSize(R.dimen.space_kit_font_16)));
        int r101 = h18.e.f483540a;
        r100.setTypeface(h18.e.b(getContext(), 1));
        r100.setTextColor(getContext().getResources().getColor(R.color.text_title));
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof LinearLayout.LayoutParams) == false) goto L5;
        LinearLayout.LayoutParams r103 = (LinearLayout.LayoutParams) r102;
    L7:
        if (r103 == null) goto L9;
        r103.gravity = 48;
        r103.topMargin = n.d(11);
        r103.leftMargin = n.d(12);
    L9:
        FrameLayout r104 = this.f242223b;
        if (r104 == null) goto L17;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if ((r105 instanceof LinearLayout.LayoutParams) == false) goto L14;
        LinearLayout.LayoutParams r106 = (LinearLayout.LayoutParams) r105;
    L15:
        if (r106 == null) goto L17;
        r106.gravity = 48;
        r106.topMargin = n.d(16);
        goto L17
    L14:
        r106 = null;
    L17:
        AppCompatImageView r107 = this.f242245y;
        if (r107 == null) goto L25;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if ((r108 instanceof FrameLayout.LayoutParams) == false) goto L22;
        FrameLayout.LayoutParams r109 = (FrameLayout.LayoutParams) r108;
    L23:
        if (r109 == null) goto L25;
        r109.gravity = GravityCompat.END;
        r109.topMargin = n.d(22);
        goto L25
    L22:
        r109 = null;
    L25:
        this.f242226e.setOnClickListener(null);
        this.f242222a.setOnClickListener(null);
        this.f242230i.setOnClickListener(new com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view.a(this));
        this.f242223b.setOnClickListener(new b(this));
        return;
    L5:
        r103 = null;
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
    public final void c(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.b r100) {
        if (r100 == null) goto L4;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.c.a(r100, this, this.f242223b);
    L4:
        if (r100 == null) goto L7;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.c.a(r100, this, this.f242230i);
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemRootView
    public final void k(int r100) {
        setPadding(0, 0, 0, 0);
    }

    public SidebarItemTitleRootView(Context r100, AttributeSet r101, int r102, int r103) {
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
