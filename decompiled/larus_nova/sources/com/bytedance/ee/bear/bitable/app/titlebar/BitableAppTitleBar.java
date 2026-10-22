package com.bytedance.ee.bear.bitable.app.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.bitable.infoarch.titlebar.BitableBaseTitleBar;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0014J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\tJ\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0014J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130#2\u0006\u0010 \u001a\u00020!H\u0002R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/bitable/app/titlebar/BitableAppTitleBar;", "Lcom/bytedance/ee/bear/bitable/infoarch/titlebar/BitableBaseTitleBar;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "immersive", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "adjustTitleBarCenterLayoutMarginParams", "", "getImageMenuLayout", "setLeftIconVisibility", "isVisible", "loadingView", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "setLoadingView", "(Landroid/view/View;)V", "setLoadingBg", "isShow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "adjustMenuSpacing", "menuSpacing", "adjustLayoutMenuSpacing", "layout", "Landroid/view/ViewGroup;", "getVisibleChildren", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableAppTitleBar extends BitableBaseTitleBar {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f206957y;

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar
    public int getImageMenuLayout() {
        return R.layout.bitable_app_menu_layout;
    }

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar
    public final void b() {
        int r100 = UIHelper.dp2px(8.0f);
        LinearLayout.LayoutParams r101 = (LinearLayout.LayoutParams) this.f240032g.getLayoutParams();
        if (r101 == null) goto L5;
        ((ViewGroup.MarginLayoutParams) r101).rightMargin = r100;
        ((ViewGroup.MarginLayoutParams) r101).leftMargin = r100;
        ((ViewGroup.MarginLayoutParams) r101).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) r101).bottomMargin = 0;
    L5:
        this.f240032g.setLayoutParams(r101);
    }

    public final View getLoadingView() {
        return this.f206957y;
    }

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar
    public void setLeftIconVisibility(boolean r100) {
        super.setLeftIconVisibility(r100);
        int r101 = UIHelper.dp2px(14.0f);
        this.f240029d.setPadding(r101, 0, 0, 0);
    }

    public final void setLoadingBg(boolean r100) {
        if (r100 == false) goto L4;
        View r101 = new View(getContext());
        r101.setLayoutParams(new LinearLayout.LayoutParams(UIHelper.dp2px(120.0f), UIHelper.dp2px(20.0f)));
        r101.setBackgroundResource(R.drawable.bitable_app_loading_bg);
        this.f206957y = r101;
        this.f240029d.addView(r101);
        return;
    L4:
        View r102 = this.f206957y;
        if (r102 == null) goto L9;
        this.f240029d.removeView(r102);
        return;
    }

    public final void setLoadingView(View r100) {
        this.f206957y = r100;
    }

    public BitableAppTitleBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, -1, false, 8);
    }

    public static void n(ViewGroup r100, int r101) {
        ArrayList r102 = new ArrayList();
        int r103 = r100.getChildCount();
        int r104 = 0;
        int r105 = 0;
    L3:
        boolean r106 = true;
        if (r105 >= r103) goto L12;
        View r107 = r100.getChildAt(r105);
        Intrinsics.checkNotNull(r107);
        if (r107.getVisibility() == 0) goto L9;
        r106 = false;
    L9:
        if (r106 == false) goto L11;
        r102.add(r107);
    L11:
        r105 = r105 + 1;
        goto L3
    L12:
        int r108 = r102.size() - 1;
    L13:
        if (r104 >= r108) goto L21;
        View r109 = (View) ListProtector.get(r102, r104);
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
        if ((r110 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
    L18:
        if (r111 == null) goto L20;
        r111.setMarginEnd(r101);
        r109.setLayoutParams(r111);
    L20:
        r104 = r104 + 1;
        goto L13
    L17:
        r111 = null;
        goto L18
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.titlebar.BitableBaseTitleBar, com.bytedance.ee.bear.widgets.BaseTitleBar, android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = UIHelper.dp2px(14.0f);
        n(getRightLayout(), r102);
        n(this.f240030e, r102);
        super.onMeasure(r100, r101);
    }

    public BitableAppTitleBar(Context r100, AttributeSet r101, int r102, boolean r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = -1;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = true;
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setLeftIconVisibility(false);
        setImmersive(r103);
    }
}
