package com.ss.android.lark.maintab.export.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larus.nova.R;
import com.ss.android.lark.maintab.export.MainTabNavigationMode;
import com.ss.android.lark.maintab.export.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.tab.MainTabItemView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b,\b\u0016\u0018\u0000 m2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001mB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000200J\b\u00104\u001a\u000200H\u0016J\b\u00105\u001a\u000200H\u0016J,\u00106\u001a\u0002002\u0006\u00107\u001a\u00020\u00152\b\u00108\u001a\u0004\u0018\u00010\u00172\u0006\u00109\u001a\u00020\u00192\b\u0010:\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010;\u001a\u0002002\u0006\u00107\u001a\u00020\u00152\b\u0010:\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010<\u001a\u0002002\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\u001a\u0010?\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\u00152\b\u0010:\u001a\u0004\u0018\u00010\u0013H\u0002J,\u0010@\u001a\u0002002\u0006\u0010A\u001a\u00020B2\b\u0010:\u001a\u0004\u0018\u00010\u00132\b\u00108\u001a\u0004\u0018\u00010\u00172\u0006\u0010C\u001a\u00020\u001bH\u0002J$\u0010D\u001a\u0002002\b\b\u0001\u0010E\u001a\u00020\t2\b\b\u0001\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u001bH\u0002J\u001a\u0010H\u001a\u0002002\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010I\u001a\u0004\u0018\u00010 J\u0010\u0010J\u001a\u0002002\b\u0010K\u001a\u0004\u0018\u00010\u0019J\u0006\u0010L\u001a\u000200J\u0010\u0010M\u001a\u0002002\u0006\u0010N\u001a\u00020\u001bH\u0016J\u0010\u0010O\u001a\u0002002\u0006\u0010P\u001a\u00020\tH\u0016J)\u0010O\u001a\u0002002\u0006\u0010P\u001a\u00020\t2\b\u0010Q\u001a\u0004\u0018\u00010\t2\b\u0010R\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010SJ\u0010\u0010O\u001a\u0002002\u0006\u0010T\u001a\u00020\u0019H\u0016J\u0017\u0010U\u001a\u0002002\b\u0010R\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010VJ\u0010\u0010W\u001a\u0002002\u0006\u0010X\u001a\u00020\tH\u0016J\b\u0010Y\u001a\u000200H\u0016J\b\u0010Z\u001a\u00020\u001bH\u0016J\r\u0010[\u001a\u00020\u001bH\u0014¢\u0006\u0002\u0010\\J\u000e\u0010]\u001a\u0002002\u0006\u0010^\u001a\u00020\u001dJ\u0006\u0010_\u001a\u00020\u001dJ\u0018\u0010`\u001a\u0002002\u0006\u0010a\u001a\u00020\u00192\u0006\u0010b\u001a\u00020\u0019H\u0016J\u0018\u0010c\u001a\u0002002\u0006\u0010d\u001a\u00020B2\u0006\u0010e\u001a\u00020BH\u0016J\b\u0010f\u001a\u000200H\u0016J\b\u0010g\u001a\u000200H\u0016J\b\u0010h\u001a\u000200H\u0014J\b\u0010i\u001a\u000200H\u0014J\b\u0010j\u001a\u000200H\u0014J\u0010\u0010k\u001a\u0002002\u0006\u0010l\u001a\u00020\tH\u0002R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u001f\u001a\n !*\u0004\u0018\u00010 0 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\u001bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u001bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+¨\u0006n"}, d2 = {"Lcom/ss/android/lark/maintab/export/view/MainTabBarView;", "Lcom/ss/android/lark/widget/tab/MainTabItemView;", "Lcom/ss/android/lark/maintab/export/ITabBadgeController;", "Lcom/ss/android/lark/maintab/export/view/ITabBarViewAction;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "redDotView", "Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "getRedDotView", "()Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "badgeHelper", "Lcom/ss/android/lark/maintab/export/TabBadgeHelper;", "currentConfig", "Lcom/ss/android/lark/maintab/export/TabBarConfig;", "currentTabAppInfo", "Lcom/ss/android/lark/maintab/export/TabAppInfo;", "baselineOpenMode", "Lcom/ss/android/lark/maintab/export/TabAppInfo$NavigationOpenMode;", "baselineTitle", "", "hasAppearanceApplied", "", "navMode", "Lcom/ss/android/lark/maintab/export/MainTabNavigationMode;", "hasClearColor", "defaultIcon", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getDefaultIcon", "()Landroid/graphics/drawable/Drawable;", "defaultIcon$delegate", "Lkotlin/Lazy;", "loadingView", "Lcom/airbnb/lottie/LottieAnimationView;", "isBadgeShouldShow", "()Z", "setBadgeShouldShow", "(Z)V", "hasDetached", "getHasDetached", "setHasDetached", "addDeleteIcon", "", "listener", "Landroid/view/View$OnClickListener;", "removeDeleteIcon", "handleTabSelected", "handleTabUnSelected", "bind", "tabAppInfo", "openMode", "remoteName", "config", "applyTabUiExtraConfig", "applyPrimaryIconShape", "shape", "Lcom/ss/android/lark/maintab/export/TabUiExtraConfig$IconShapeStrategy;", "shouldDisableIconTintByStrategy", "bindRemoteIcon", "logo", "Lcom/ss/android/lark/maintab/export/TabAppInfo$Logo;", "clearColor", "bindLocalIcon", "defaultIconRes", "selectedIconRes", "defaultTintEnable", "applyAppearanceIcons", "selectedIcon", "applyAppearanceTitle", "title", "restoreBaseline", "setRemindInNav", "isRemind", "showBadge", "count", "textColor", "bgColorRes", "(ILjava/lang/Integer;Ljava/lang/Integer;)V", "text", "showRedDotBadge", "(Ljava/lang/Integer;)V", "showIconBadge", "iconRes", "hideBadge", "isBadgeShow", "useContentCenterStyle", "()Ljava/lang/Boolean;", "setTabNavMode", "mode", "getTabNavMode", "updateTabName", "oldName", "newName", "updateLogo", "oldLogo", "newLogo", "startLoadingAnim", "stopLoadingAnim", "onAttachedToWindow", "onDetachedFromWindow", "makeRedDotHide", "initLoadingView", "animationRes", "Companion", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class MainTabBarView extends MainTabItemView {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final UDBadgeView f431624m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f431625n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public MainTabNavigationMode f431626o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f431627p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f431628q;

    public static final class a {
    }

    static {
    }

    public MainTabBarView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MainTabBarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setBadgeShouldShow(boolean r100) {
    }

    private final Drawable getDefaultIcon() {
        return (Drawable) this.f431627p.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f431628q == true) goto L5;
        return;
    L5:
        this.f431628q = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f431628q = true;
    }

    @Override // com.ss.android.lark.widget.tab.MainTabItemView
    public final Boolean T5() {
        return Boolean.FALSE;
    }

    public final boolean getHasDetached() {
        return this.f431628q;
    }

    public final UDBadgeView getRedDotView() {
        return this.f431624m;
    }

    public final MainTabNavigationMode getTabNavMode() {
        return this.f431626o;
    }

    public final void setHasDetached(boolean r100) {
        this.f431628q = r100;
    }

    public void setRemindInNav(boolean r100) {
        this.f431625n.getClass();
    }

    public final void setTabNavMode(MainTabNavigationMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f431626o = r100;
    }

    public MainTabBarView(Context r100, AttributeSet r101, int r102) {
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
        this.f431624m = r103;
        this.f431625n = new e(r100, r103);
        this.f431626o = MainTabNavigationMode.BOTTOM_MODE;
        this.f431627p = LazyKt.lazy(MainTabBarView$defaultIcon$2.INSTANCE);
        ConstraintLayout.LayoutParams r106 = new ConstraintLayout.LayoutParams(-2, -2);
        r106.topToTop = R.id.layout_container;
        r106.endToEnd = R.id.layout_container;
        r103.setVisibility(8);
        addView(r103, r106);
    }

    public /* synthetic */ MainTabBarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
