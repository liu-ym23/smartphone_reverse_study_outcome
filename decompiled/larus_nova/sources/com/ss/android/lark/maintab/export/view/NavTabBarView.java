package com.ss.android.lark.maintab.export.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larus.nova.R;
import com.ss.android.lark.maintab.export.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.tab.NavigationTabItemView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vqb.b;
import y9c.d;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b(\b\u0016\u0018\u0000 O2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001OB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010$\u001a\u00020%H\u0002J\u000e\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020%J$\u0010*\u001a\u00020%2\b\u0010+\u001a\u0004\u0018\u00010\u00132\u0006\u0010,\u001a\u00020\u00152\b\u0010-\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010.\u001a\u00020%2\b\u0010/\u001a\u0004\u0018\u00010\u001bJ\u0010\u00100\u001a\u00020%2\b\u00101\u001a\u0004\u0018\u00010\u0015J\u0006\u00102\u001a\u00020%J\u001c\u00103\u001a\u00020%2\b\u0010+\u001a\u0004\u0018\u00010\u00132\b\u0010-\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u00104\u001a\u00020%2\u0006\u00105\u001a\u00020\u0017H\u0016J\u0010\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\tH\u0016J)\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\t2\b\u00108\u001a\u0004\u0018\u00010\t2\b\u00109\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010:J\u0010\u00106\u001a\u00020%2\u0006\u0010;\u001a\u00020\u0015H\u0016J\u0017\u0010<\u001a\u00020%2\b\u00109\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020\tH\u0016J\b\u0010@\u001a\u00020%H\u0016J\b\u0010A\u001a\u00020\u0017H\u0016J\u0018\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u0015H\u0016J\u0018\u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020\u00132\u0006\u0010G\u001a\u00020\u0013H\u0016J\u0006\u0010H\u001a\u00020%J\u0006\u0010I\u001a\u00020%J\b\u0010J\u001a\u00020%H\u0002J\b\u0010K\u001a\u00020%H\u0014J\b\u0010L\u001a\u00020%H\u0014J\u0010\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020\tH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u001a\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/ss/android/lark/maintab/export/view/NavTabBarView;", "Lcom/ss/android/lark/widget/tab/NavigationTabItemView;", "Lcom/ss/android/lark/maintab/export/ITabBadgeController;", "Lcom/ss/android/lark/maintab/export/view/ITabBarViewAction;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "redDotView", "Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "badgeHelper", "Lcom/ss/android/lark/maintab/export/TabBadgeHelper;", "currentConfig", "Lcom/ss/android/lark/maintab/export/TabBarConfig;", "baselineLogo", "Lcom/ss/android/lark/maintab/export/TabAppInfo$Logo;", "baselineTitle", "", "hasAppearanceApplied", "", "badgeAnchorView", "Landroid/widget/Space;", "defaultIcon", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getDefaultIcon", "()Landroid/graphics/drawable/Drawable;", "defaultIcon$delegate", "Lkotlin/Lazy;", "loadingView", "Lcom/airbnb/lottie/LottieAnimationView;", "isBadgeShouldShow", "addBadgeAnchor", "", "addDeleteIcon", "listener", "Landroid/view/View$OnClickListener;", "removeDeleteIcon", "bind", "logo", "remoteName", "config", "applyAppearanceIcon", "icon", "applyAppearanceTitle", "title", "restoreBaseline", "bindIcon", "setRemindInNav", "isRemind", "showBadge", "count", "textColor", "bgColorRes", "(ILjava/lang/Integer;Ljava/lang/Integer;)V", "text", "showRedDotBadge", "(Ljava/lang/Integer;)V", "showIconBadge", "iconRes", "hideBadge", "isBadgeShow", "updateTabName", "oldName", "newName", "updateLogo", "oldLogo", "newLogo", "startLoadingAnim", "stopLoadingAnim", "makeRedDotHide", "onAttachedToWindow", "onDetachedFromWindow", "initLoadingView", "animationRes", "Companion", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class NavTabBarView extends NavigationTabItemView {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f431629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f431630h;

    public static final class a {
    }

    static {
    }

    public NavTabBarView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public NavTabBarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final Drawable getDefaultIcon() {
        return (Drawable) this.f431630h.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setRemindInNav(boolean r100) {
        this.f431629g.getClass();
    }

    public NavTabBarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDBadgeView r103 = new UDBadgeView(r100, null, 0, R.style.UDBadge_Text);
        String r104 = r103.f284529h;
        if (r104 == null) goto L5;
        r103.setText(r104);
    L5:
        Drawable r105 = r103.f284534m;
        if (r105 == null) goto L8;
        r103.setIcon(r105);
    L8:
        r103.b();
        this.f431629g = new e(r100, r103);
        Space r106 = new Space(r100);
        this.f431630h = LazyKt.lazy(NavTabBarView$defaultIcon$2.INSTANCE);
        ConstraintLayout.LayoutParams r107 = new ConstraintLayout.LayoutParams(-2, -2);
        r107.bottomToTop = R.id.layout_container;
        r107.startToEnd = R.id.layout_container;
        ((ViewGroup.MarginLayoutParams) r107).bottomMargin = d.a(4);
        r107.setMarginStart(d.a(4));
        r106.setId(R.id.item_tab_badge_anchor);
        addView(r106, r107);
        ConstraintLayout.LayoutParams r108 = new ConstraintLayout.LayoutParams(-2, -2);
        r108.topToTop = R.id.item_tab_badge_anchor;
        r108.endToEnd = R.id.item_tab_badge_anchor;
        r103.setVisibility(8);
        addView(r103, r108);
        if (b.a().enableFgMainTabContainer() == false) goto L11;
        int r109 = R.color.bg_navigation_item;
    L12:
        setIconBgColor(r109);
        return;
    L11:
        r109 = R.color.ud_N900_05;
        goto L12
    }

    public /* synthetic */ NavTabBarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
