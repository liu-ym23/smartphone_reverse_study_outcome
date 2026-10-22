package com.bytedance.ee.bear.bitable.titlebar;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller.OfficeBaseMainHeaderAppBarBehavior;
import com.bytedance.ee.bear.bitable.core.infoarch.basemain.view.OfficeBaseMainHeaderClipLayout;
import com.bytedance.ee.bear.bitable.infoarch.header.BitableHeaderContainer;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentSplitWindowPlugin;
import com.bytedance.ee.bear.document.titlebar.OfficeTitlePlugin;
import com.bytedance.ee.bear.list.homepage.KeepWithinParentBoundsScrollingBehavior;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.google.android.material.appbar.AppBarLayout;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.ContainerType;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J%\u0010\u000f\u001a\u00020\b2\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0011\"\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u001aH\u0002J \u0010%\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u0018H\u0002J\b\u0010'\u001a\u00020(H\u0014J\b\u0010)\u001a\u00020\bH\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/bitable/titlebar/OfficeBaseMainTitlePlugin;", "Lcom/bytedance/ee/bear/document/titlebar/OfficeTitlePlugin;", "Lcom/bytedance/ee/bear/bitable/plugin/more/BitableMorePanelAnchorAbility;", "<init>", "()V", "morePanelAnchorView", "Landroid/view/View;", "onAttachToUIContainer", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "getMorePanelAnchorView", "clearBitableHostBackground", "views", "", "([Landroid/view/View;)V", "configureLeftActions", "createBackAction", "Lcom/bytedance/ee/bear/browser/plugin/MenuItem;", "ensureDocMainTip", "titleContentLayout", "Landroid/view/ViewGroup;", "ensureHeaderContainer", "Lcom/bytedance/ee/bear/bitable/infoarch/header/BitableHeaderContainer;", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "ensureHeaderClipContainer", "Lcom/bytedance/ee/bear/bitable/core/infoarch/basemain/view/OfficeBaseMainHeaderClipLayout;", "createHeaderClipLayoutParams", "Lcom/google/android/material/appbar/AppBarLayout$LayoutParams;", "createHeaderLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "ensureHeaderLayoutParams", "header", "configureHeaderOnlyNestedScroll", "contentContainer", "shouldManageNestedScroll", "", "updateContentContainerPaddingTop", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeBaseMainTitlePlugin extends OfficeTitlePlugin implements com.bytedance.ee.bear.bitable.plugin.more.a {
    public static final a Companion = null;
    private static final String TAG = "OfficeBaseMainTitlePlugin";
    private View morePanelAnchorView;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ChameleonPluginHost a;

        public b(ChameleonPluginHost r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.getActivity().getOnBackPressedDispatcher().onBackPressed();
        }
    }

    public static final class c implements MenuItem.b {
        public final /* synthetic */ ChameleonPluginHost a;

        public c(ChameleonPluginHost r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.browser.plugin.MenuItem.b
        public final void a(MenuItem r1, View r2) {
            com.bytedance.ee.bear.bitable.core.basemain.ability.b r3 = this.a.getHostAbilityOrNull(com.bytedance.ee.bear.bitable.core.basemain.ability.b.class);
            if (r3 == null) goto L6;
            r3.m1();
            return;
        }
    }

    public static final class d implements MenuItem.b {
        public final /* synthetic */ ChameleonPluginHost a;

        public d(ChameleonPluginHost r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.browser.plugin.MenuItem.b
        public final void a(MenuItem r1, View r2) {
            this.a.getActivity().getOnBackPressedDispatcher().onBackPressed();
        }
    }

    static {
        Companion = new a();
    }

    public OfficeBaseMainTitlePlugin() {
        super(false, false, false);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.OfficeTitlePlugin, com.bytedance.ee.bear.document.x2.b
    public /* bridge */ /* synthetic */ void onLoadCancel() {
    }

    @Override // com.bytedance.ee.bear.document.titlebar.OfficeTitlePlugin, com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.titlebar.OfficeTitlePlugin, com.bytedance.ee.bear.document.x2.b
    public /* bridge */ /* synthetic */ void onSSRLoadSuccess() {
    }

    @Override // com.bytedance.ee.bear.document.titlebar.OfficeTitlePlugin
    public boolean shouldManageNestedScroll() {
        return false;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.OfficeTitlePlugin
    public void updateContentContainerPaddingTop() {
    }

    private final AppBarLayout.LayoutParams createHeaderClipLayoutParams() {
        return new AppBarLayout.LayoutParams(-1, -2);
    }

    private final FrameLayout.LayoutParams createHeaderLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -2, 80);
    }

    public View getMorePanelAnchorView() {
        return this.morePanelAnchorView;
    }

    private final void clearBitableHostBackground(View... r5) {
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        View r3 = r5[r2];
        if (r3 == null) goto L7;
        r3.setBackgroundColor(0);
    L7:
        r2 = r2 + 1;
        goto L3
    }

    private final MenuItem createBackAction(ChameleonPluginHost r5) {
        MenuItem r0 = new MenuItem(DocumentSplitWindowPlugin.BASE_LEFT_BACK, l.a(r5.getContext(), 2131254998, 2131101926), DocumentSplitWindowPlugin.BASE_LEFT_BACK);
        r0.setClickListener(new d(r5));
        return r0;
    }

    private final void ensureHeaderLayoutParams(BitableHeaderContainer r3) {
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == false) goto L5;
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
    L6:
        if (r1 != null) goto L8;
    L9:
        r3.setLayoutParams(createHeaderLayoutParams());
        return;
    L8:
        if (r1.gravity != 80) goto L9;
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void configureLeftActions(ChameleonPluginHost r6, t r7) {
        TitleBar r8 = r7.getTitleBar();
        if (r8 != null) goto L5;
        return;
    L5:
        LarkAppContext.Companion.getClass();
        boolean r0 = LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
        r8.setLeftIconVisibility(r0);
        BaseTitleBar r1 = r8.getTitleBarLayout();
        if (r0 == false) goto L8;
        b r2 = new b(r6);
    L9:
        r1.setLeftClickListener(r2);
        MenuItem r3 = new MenuItem("base_drawer", l.a(r6.getContext(), 2131255762, 2131101926), "base_drawer");
        r3.setClickListener(new c(r6));
        if (r0 == false) goto L12;
        List<MenuItem> r9 = CollectionsKt.listOf(r3);
    L13:
        r8.j(r9, TitleBar.MenuType.Left);
        return;
    L12:
        r9 = CollectionsKt.listOf(new MenuItem[]{createBackAction(r6), r3});
        goto L13
    L8:
        r2 = null;
        goto L9
    }

    private final void ensureDocMainTip(ChameleonPluginHost r5, ViewGroup r6) {
        View r1 = r6.findViewById(2131369336);
        if ((r1 instanceof ViewStub) == false) goto L6;
        ((ViewStub) r1).setLayoutResource(2131560089);
        return;
    L6:
        if (r1 != null) goto L9;
        ViewStub r2 = new ViewStub(r5.getContext());
        r2.setId(2131369336);
        r2.setLayoutResource(2131560089);
        r6.addView(r2, new LinearLayout.LayoutParams(-1, -2));
        return;
    }

    private final OfficeBaseMainHeaderClipLayout ensureHeaderClipContainer(ChameleonPluginHost r7, AppBarLayout r8) {
        OfficeBaseMainHeaderClipLayout r1 = (OfficeBaseMainHeaderClipLayout) r8.findViewById(2131364210);
        ViewGroup r2 = null;
        if (r1 == null) goto L13;
        r1.setClipChildren(true);
        r1.setClipToPadding(true);
        if (r1.getParent() == r8) goto L12;
        ViewParent r9 = r1.getParent();
        if ((r9 instanceof ViewGroup) == false) goto L9;
        r2 = (ViewGroup) r9;
    L9:
        if (r2 == null) goto L11;
        r2.removeView(r1);
    L11:
        r8.addView(r1, createHeaderClipLayoutParams());
    L12:
        return r1;
    L13:
        OfficeBaseMainHeaderClipLayout r3 = new OfficeBaseMainHeaderClipLayout(r7.getContext(), null, 6, 0);
        r3.setId(2131364210);
        r3.setClipChildren(true);
        r3.setClipToPadding(true);
        r8.addView(r3, createHeaderClipLayoutParams());
        return r3;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.OfficeTitlePlugin
    public void onAttachToUIContainer(ChameleonPluginHost r8, t r9) {
        Intrinsics.checkNotNullParameter(r8, "host");
        Intrinsics.checkNotNullParameter(r9, "uiContainer");
        super.onAttachToUIContainer(r8, r9);
        View r0 = r9.findView(2131369266);
        FrameLayout r2 = null;
        if ((r0 instanceof AppBarLayout) == false) goto L5;
        AppBarLayout r1 = (AppBarLayout) r0;
    L6:
        View r3 = r9.findView(2131388779);
        if ((r3 instanceof ViewGroup) == false) goto L9;
        ViewGroup r4 = (ViewGroup) r3;
    L10:
        View r5 = r9.findView(2131369339);
        if ((r5 instanceof FrameLayout) == false) goto L14;
        r2 = (FrameLayout) r5;
    L14:
        if (r1 == null) goto L32;
        if (r4 == null) goto L32;
        if (r2 == null) goto L32;
        this.morePanelAnchorView = r2;
        r8.registerHostAbility(this);
        configureLeftActions(r8, r9);
        ensureDocMainTip(r8, r4);
        k r10 = r8.getWeb();
        if (r10 == null) goto L23;
        WebView r11 = r10.getWebView();
        if (r11 == null) goto L23;
        r11.setNestedScrollingEnabled(true);
    L23:
        ViewGroup r12 = r8.getContainer(ContainerType.Content.getValue());
        ViewGroup r6 = r8.getContainer(ContainerType.Top.getValue());
        ViewGroup r7 = r8.getContainer(ContainerType.Web.getValue());
        if (r12 == null) goto L30;
        if (r6 == null) goto L30;
        if (r7 == null) goto L30;
        ensureHeaderContainer(r8, r1, r4);
        configureHeaderOnlyNestedScroll(r1, r4, r12);
        clearBitableHostBackground(new View[]{r1, r4, r2, r12, r6, r7});
        return;
    L30:
        tt5.a.d(TAG, "attach failed, contentContainer:" + r12 + ", topSlotContainer:" + r6 + ", webSurfaceContainer:" + r7);
        return;
    L32:
        tt5.a.d(TAG, "attach failed, appBarLayout:" + r1 + ", titleContentLayout:" + r4 + ", mainTitleContainer:" + r2);
        return;
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.titlebar.OfficeTitlePlugin
    public void onDetachFromUIContainer(ChameleonPluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        r2.unregisterHostAbility(this);
        this.morePanelAnchorView = null;
        super.onDetachFromUIContainer(r2, r3);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.OfficeTitlePlugin, com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.OfficeTitlePlugin, com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }

    private final void configureHeaderOnlyNestedScroll(AppBarLayout r4, ViewGroup r5, ViewGroup r6) {
        AppBarLayout.LayoutParams r0 = r5.getLayoutParams();
        CoordinatorLayout.LayoutParams r2 = null;
        if ((r0 instanceof AppBarLayout.LayoutParams) == false) goto L5;
        AppBarLayout.LayoutParams r1 = r0;
    L6:
        if (r1 != null) goto L8;
    L10:
        ViewCompat.setTranslationZ(r5, n.d(1));
        int r7 = OfficeBaseMainHeaderAppBarBehavior.e;
        Intrinsics.checkNotNullParameter(r4, "appBarLayout");
        CoordinatorLayout.LayoutParams r8 = r4.getLayoutParams();
        if ((r8 instanceof CoordinatorLayout.LayoutParams) == false) goto L13;
        CoordinatorLayout.LayoutParams r9 = r8;
    L14:
        if (r9 != null) goto L16;
        tt5.a.d("OfficeBaseMainHeaderAppBarBehavior", "ensure failed, layoutParams is not CoordinatorLayout.LayoutParams");
    L23:
        ViewGroup.LayoutParams r10 = r6.getLayoutParams();
        if ((r10 instanceof CoordinatorLayout.LayoutParams) == false) goto L26;
        r2 = (CoordinatorLayout.LayoutParams) r10;
    L26:
        if (r2 != null) goto L28;
        return;
    L28:
        if ((r2.getBehavior() instanceof KeepWithinParentBoundsScrollingBehavior) == true) goto L32;
        r2.setBehavior(new KeepWithinParentBoundsScrollingBehavior());
        r6.setLayoutParams(r2);
        return;
    L32:
        return;
    L16:
        OfficeBaseMainHeaderAppBarBehavior r3 = r9.getBehavior();
        if ((r3 instanceof OfficeBaseMainHeaderAppBarBehavior) == false) goto L19;
        OfficeBaseMainHeaderAppBarBehavior r11 = r3;
    L20:
        if (r11 != null) goto L23;
        r9.setBehavior(new OfficeBaseMainHeaderAppBarBehavior());
        r4.setLayoutParams(r9);
        goto L23
    L19:
        r11 = null;
        goto L20
    L13:
        r9 = null;
        goto L14
    L8:
        if (r1.getScrollFlags() == 0) goto L10;
        r1.setScrollFlags(0);
        r5.setLayoutParams(r1);
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    private final BitableHeaderContainer ensureHeaderContainer(ChameleonPluginHost r5, AppBarLayout r6, ViewGroup r7) {
        OfficeBaseMainHeaderClipLayout r0 = ensureHeaderClipContainer(r5, r6);
        BitableHeaderContainer r2 = (BitableHeaderContainer) r0.findViewById(2131364211);
        if (r2 == null) goto L6;
        ensureHeaderLayoutParams(r2);
        return r2;
    L6:
        BitableHeaderContainer r8 = (BitableHeaderContainer) r6.findViewById(2131364211);
        ViewGroup r3 = null;
        if (r8 == null) goto L15;
        ViewParent r9 = r8.getParent();
        if ((r9 instanceof ViewGroup) == false) goto L11;
        r3 = (ViewGroup) r9;
    L11:
        if (r3 == null) goto L13;
        r3.removeView(r8);
    L13:
        r0.addView(r8, createHeaderLayoutParams());
        ensureHeaderLayoutParams(r8);
        return r8;
    L15:
        BitableHeaderContainer r10 = (BitableHeaderContainer) r7.findViewById(2131364211);
        if (r10 == null) goto L24;
        ViewParent r11 = r10.getParent();
        if ((r11 instanceof ViewGroup) == false) goto L20;
        r3 = (ViewGroup) r11;
    L20:
        if (r3 == null) goto L22;
        r3.removeView(r10);
    L22:
        r0.addView(r10, createHeaderLayoutParams());
        ensureHeaderLayoutParams(r10);
        return r10;
    L24:
        BitableHeaderContainer r12 = new BitableHeaderContainer(r5.getContext(), null, 6, 0);
        r12.setId(2131364211);
        r12.setPadding(r12.getPaddingLeft(), r12.getPaddingTop(), r12.getPaddingRight(), n.d(12));
        r0.addView(r12, createHeaderLayoutParams());
        return r12;
    }
}
