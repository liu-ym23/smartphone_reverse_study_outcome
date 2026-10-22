package com.bytedance.ee.bear.document;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.api.bean.ForsetiScreenMode;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.utils.ApiUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\u0016\u0019\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0002J\u001c\u0010\u001e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001f\u001a\u00020 H\u0002J$\u0010!\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010\u00072\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020*H\u0002J\"\u0010+\u001a\u00020,2\u0006\u0010\"\u001a\u00020#2\u0006\u0010-\u001a\u00020*2\b\b\u0002\u0010.\u001a\u00020*H\u0002J\b\u0010/\u001a\u00020*H\u0002J\u0012\u00100\u001a\u00020\u000f2\b\b\u0002\u00101\u001a\u00020*H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/document/DocumentSplitWindowPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "chainManager", "Lcom/ss/android/lark/api/api/IForsetiActivityChainManager;", "mTitleBar", "Lcom/bytedance/ee/bear/browser/plugin/TitleBar;", "splitWindowManager", "Lcom/ss/android/lark/split/window/ISplitWindowManager;", "getSplitWindowManager", "()Lcom/ss/android/lark/split/window/ISplitWindowManager;", "splitWindowManager$delegate", "Lkotlin/Lazy;", "onAttachToUIContainer", "", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "doAddMenu", "screenModeChangedListener", "com/bytedance/ee/bear/document/DocumentSplitWindowPlugin$screenModeChangedListener$1", "Lcom/bytedance/ee/bear/document/DocumentSplitWindowPlugin$screenModeChangedListener$1;", "viewModeListener", "com/bytedance/ee/bear/document/DocumentSplitWindowPlugin$viewModeListener$1", "Lcom/bytedance/ee/bear/document/DocumentSplitWindowPlugin$viewModeListener$1;", "onStart", "registerScreenModeChangeListener", "registerViewModeChangeListener", "onDetachFromUIContainer", "getWindowId", "", "addMenu", "context", "Landroid/content/Context;", "titleBar", "clickListener", "Lcom/bytedance/ee/bear/browser/plugin/MenuItem$ClickListener;", "getAddMenuIndex", "", "checkIsPhone", "", "getSplitMenuDrawable", "Landroid/graphics/drawable/Drawable;", "showSplitBtn", "enable", "isBitable", "updateTitleBar", "showButton", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentSplitWindowPlugin extends DocumentPluginV2 {
    public static final String BASE_LEFT_BACK = "base_back";
    public static final a Companion = null;
    public static final int MIN_SMALLEST_WIDTH_IN_DP = 600;
    private static final String SCENE = "ccm_split_window";
    private static final String SPLIT_MENU_ID = "switch_split_screen_window";
    private static final String TAG = "DocumentSplitWindowPlugin";
    private tua.b chainManager;
    private TitleBar mTitleBar;
    private final c screenModeChangedListener;
    private final Lazy splitWindowManager$delegate;
    private final d viewModeListener;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements MenuItem.b {
        public final /* synthetic */ PluginHost a;
        public final /* synthetic */ DocumentSplitWindowPlugin b;

        public b(PluginHost r1, DocumentSplitWindowPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.ee.bear.browser.plugin.MenuItem.b
        public final void a(MenuItem r10, View r11) {
            PluginHost r1 = this.a;     // Catch: Exception -> L29
            if (r1 == null) goto L8;
            Fragment r2 = r1.getHostFragment();     // Catch: Exception -> L29
            if (r2 == null) goto L8;
            Fragment r3 = r2.getParentFragment();     // Catch: Exception -> L29
        L9:
            Fragment r6 = ForsetiHelper.g(r3);     // Catch: Exception -> L29
            StringBuilder r4 = new StringBuilder("onMenuItemClick: forsetiFragment is null = ");     // Catch: Exception -> L29
            if (r6 != null) goto L12;
            boolean r0 = true;
        L13:
            r4.append(r0);     // Catch: Exception -> L29
            tt5.a.h(DocumentSplitWindowPlugin.TAG, r4.toString());     // Catch: Exception -> L29
            if (r6 == null) goto L35;
            DocumentSplitWindowPlugin r5 = this.b;     // Catch: Exception -> L29
            if (DocumentSplitWindowPlugin.access$getSplitWindowManager(r5).isInSplitWindow(r6) == false) goto L24;
            boolean r7 = DocumentSplitWindowPlugin.access$getSplitWindowManager(r5).isFirstPage(r6);     // Catch: Exception -> L29
            tt5.a.h(DocumentSplitWindowPlugin.TAG, "onMenuItemClick: isInSplitWindow, deal exitSplitWindowByForseti. isFirstPage = " + r7);     // Catch: Exception -> L29
            if (r7 == false) goto L20;
            DocumentSplitWindowPlugin.access$getSplitWindowManager(r5).exitSplitWindowByForseti(DocumentSplitWindowPlugin.access$getContext(r5), r6, null);     // Catch: Exception -> L29
            return;
        L20:
            com.suite.lark.component.navroute.forseti.g.a.getClass();     // Catch: Exception -> L29
            com.suite.lark.component.navroute.forseti.g r12 = com.suite.lark.component.navroute.forseti.g.a.a(r6, null);     // Catch: Exception -> L29
            if (r12 == null) goto L34;
            r12.g(null);     // Catch: Exception -> L29
            return;
        L34:
            return;
        L24:
            tt5.a.h(DocumentSplitWindowPlugin.TAG, "onMenuItemClick: isInSplitWindow is false, deal goBack and launchSplitWindowByForseti");     // Catch: Exception -> L29
            com.suite.lark.component.navroute.forseti.g.a r13 = com.suite.lark.component.navroute.forseti.g.a;     // Catch: Exception -> L29
            com.suite.lark.component.navroute.forseti.g.a r8 = com.suite.lark.component.navroute.forseti.g.a.a;     // Catch: Exception -> L29
            r13.getClass();     // Catch: Exception -> L29
            com.suite.lark.component.navroute.forseti.g r14 = com.suite.lark.component.navroute.forseti.g.a.a(r6, null);     // Catch: Exception -> L29
            if (r14 == null) goto L27;
            r14.g(null);     // Catch: Exception -> L29
        L27:
            DocumentSplitWindowPlugin.access$getSplitWindowManager(r5).launchSplitWindowByForseti(DocumentSplitWindowPlugin.access$getContext(r5), DocumentSplitWindowPlugin.access$getWindowId(r5), r6, DocumentSplitWindowPlugin.SCENE, null);     // Catch: Exception -> L29
            return;
        L35:
            return;
        L12:
            r0 = false;
        L8:
            r3 = null;
        L29:
            e = move-exception;
            tt5.a.d(DocumentSplitWindowPlugin.TAG, "onMenuItemClick Exception: " + e.getMessage());
        }
    }

    public static final class c implements Function1<ForsetiScreenMode, Unit> {
        public final /* synthetic */ DocumentSplitWindowPlugin a;

        public c(DocumentSplitWindowPlugin r1) {
            this.a = r1;
        }

        public final Object invoke(Object r3) {
            ForsetiScreenMode r4 = (ForsetiScreenMode) r3;
            Intrinsics.checkNotNullParameter(r4, "mode");
            tt5.a.h(DocumentSplitWindowPlugin.TAG, "screenMode changed: screenMode=" + r4);
            DocumentSplitWindowPlugin r0 = this.a;
            if (r4 != ForsetiScreenMode.EXPAND) goto L5;
        L8:
            boolean r5 = true;
        L9:
            DocumentSplitWindowPlugin.access$updateTitleBar(r0, r5);
            return Unit.INSTANCE;
        L5:
            if (r4 == ForsetiScreenMode.MEDIUM) goto L8;
            r5 = false;
            goto L9
        }
    }

    public static final class d implements com.ss.android.lark.api.ui.j {
        public final /* synthetic */ DocumentSplitWindowPlugin a;

        public d(DocumentSplitWindowPlugin r1) {
            this.a = r1;
        }

        public final void a(ForsetiViewMode r4) {
            Intrinsics.checkNotNullParameter(r4, "viewMode");
            if (r4 != ForsetiViewMode.MEDIUM) goto L5;
        L8:
            boolean r0 = true;
        L9:
            tt5.a.h(DocumentSplitWindowPlugin.TAG, "onForsetiViewModeChanged changed: viewMode= " + r4);
            DocumentSplitWindowPlugin.access$updateTitleBar(this.a, r0);
            return;
        L5:
            if (r4 == ForsetiViewMode.EXPAND) goto L8;
            r0 = false;
            goto L9
        }
    }

    static {
        Companion = new a();
    }

    private final boolean isBitable() {
        DocViewModel r1 = getDocViewModel();     // Catch: Exception -> L7
        if (r1 == null) goto L12;
        return r1.isDocumentType(sbb.e.i);
    L12:
        return false;
    L7:
        e = move-exception;
        tt5.a.d(TAG, "isBitable: Exception: " + e.getMessage());
        return false;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final i5c.a getSplitWindowManager() {
        return (i5c.a) this.splitWindowManager$delegate.getValue();
    }

    private final String getWindowId() {
        DocViewModel r1 = getDocViewModel();     // Catch: Exception -> L18
        if (r1 == null) goto L23;
        BearUrl r2 = r1.getBearUrl();     // Catch: Exception -> L18
        if (r2 == null) goto L24;
        String r3 = r2.b;     // Catch: Exception -> L18
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        String r4 = r2.n;     // Catch: Exception -> L18
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        String r5 = r3.concat(r4);     // Catch: Exception -> L18
        if (r5 != null) goto L17;
        return "";
    L17:
        return r5;
    L24:
        return "";
    L23:
        return "";
    L18:
        e = move-exception;
        tt5.a.d(TAG, "getWindowId: Exception: " + e.getMessage());
        return "";
    }

    private final void registerScreenModeChangeListener() {
        tt5.a.h(TAG, "registerScreenModeChangeListener： screenModeChangedListener = " + this.screenModeChangedListener);
        tua.b r0 = this.chainManager;
        if (r0 == null) goto L5;
        r0.j(this.screenModeChangedListener);
    L5:
        tua.b r1 = this.chainManager;
        if (r1 == null) goto L9;
        r1.D(this.screenModeChangedListener);
        return;
    }

    private final void registerViewModeChangeListener() {
        tua.b r0 = this.chainManager;
        if (r0 == null) goto L5;
        r0.e(this.viewModeListener);
    L5:
        tua.b r1 = this.chainManager;
        if (r1 == null) goto L9;
        r1.P(this.viewModeListener);
        return;
    }

    public DocumentSplitWindowPlugin() {
        this.splitWindowManager$delegate = LazyKt.lazy(DocumentSplitWindowPlugin$splitWindowManager$2.INSTANCE);
        this.screenModeChangedListener = new c(this);
        this.viewModeListener = new d(this);
    }

    private final boolean checkIsPhone() {
        int r0 = com.bytedance.ee.util.ui.n.v();
        int r1 = com.bytedance.ee.util.ui.n.t();
        int r2 = com.bytedance.ee.util.ui.n.f(getContext(), MIN_SMALLEST_WIDTH_IN_DP);
        if (r0 < r2) goto L7;
        if (r1 < r2) goto L7;
        return false;
    L7:
        return true;
    }

    private final int getAddMenuIndex() {
        if (getTitleBar() != null) goto L5;
    L11:
        return 0;
    L5:
        if (isBitable() == false) goto L11;
        if (((Boolean) ForsetiHelper.m.getValue()).booleanValue() == false) goto L11;
        if (getTitleBar().findMenuView(BASE_LEFT_BACK) == null) goto L11;
        return 1;
    }

    public static final /* synthetic */ Context access$getContext(DocumentSplitWindowPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ i5c.a access$getSplitWindowManager(DocumentSplitWindowPlugin r0) {
        return r0.getSplitWindowManager();
    }

    public static final /* synthetic */ String access$getWindowId(DocumentSplitWindowPlugin r0) {
        return r0.getWindowId();
    }

    private final void doAddMenu(PluginHost r4) {
        if (checkIsPhone() == false) goto L6;
        tt5.a.h(TAG, "doAddMenu: is phone, not add menu");
        return;
    L6:
        if (r4 == null) goto L9;
        addMenu(r4.getActivity(), this.mTitleBar, new b(r4, this));
        return;
    }

    private final void updateTitleBar(boolean r10) {
        if (getTitleBar() != null) goto L6;
        tt5.a.d(TAG, "titleBar is null, failed to update title bar");
        return;
    L6:
        tt5.a.h(TAG, "updateTitleBar() called with: showButton = " + r10);
        View r0 = getTitleBar().findMenuView(SPLIT_MENU_ID);
        if (checkIsPhone() == false) goto L13;
        if (r0 == null) goto L10;
        r0.setVisibility(8);
    L10:
        tt5.a.h(TAG, "updateTitleBar: not enable split window");
        return;
    L13:
        if (isBitable() == true) goto L15;
    L20:
        if (r0 != null) goto L25;
        tt5.a.d(TAG, "menuView is null, failed to update title bar");
        if (checkIsPhone() == true) goto L24;
        doAddMenu(getHost());
        r0 = getTitleBar().findMenuView(SPLIT_MENU_ID);
        goto L25
    L24:
        return;
    L25:
        PluginHost r3 = getHost();
        if (r3 == null) goto L30;
        Fragment r4 = r3.getHostFragment();
        if (r4 == null) goto L30;
        Fragment r5 = r4.getParentFragment();
    L31:
        Fragment r6 = ForsetiHelper.g(r5);
        if (r6 != null) goto L34;
        return;
    L34:
        boolean r7 = getSplitWindowManager().isInSplitWindowState();
        boolean r8 = getSplitWindowManager().isInSplitWindow(r6);
        if (r10 == true) goto L42;
        if (r7 == false) goto L38;
        if (r8 == true) goto L38;
    L39:
        if (r0 == null) goto L65;
        r0.setVisibility(8);
        return;
    L65:
        return;
    L38:
        if (r7 == false) goto L39;
    L42:
        tt5.a.h(TAG, "updateTitleBar: enable split window");
        if (r0 == null) goto L45;
        r0.setVisibility(0);
    L45:
        boolean r9 = getSplitWindowManager().isFirstPage(r6);
        if (r8 == false) goto L54;
        getTitleBar().getTitleBarLayout().setLeftIconVisibility(false);
        if (isBitable() == false) goto L54;
        if (((Boolean) ForsetiHelper.m.getValue()).booleanValue() == false) goto L54;
        View r11 = getTitleBar().findMenuView(BASE_LEFT_BACK);
        if (r11 == null) goto L54;
        r11.setVisibility(8);
    L54:
        tt5.a.h(TAG, "updateTitleBar(), isInSplitWindowState = " + r7 + ", isInSplitWindow = " + r8 + ", showClose = " + r9);
        if (r7 == false) goto L63;
        if (r9 == false) goto L59;
        tt5.a.h(TAG, "updateTitleBar: show close button");
        getTitleBar().e(SPLIT_MENU_ID, getSplitMenuDrawable$default(this, getContext(), false, false, 4, null));
        return;
    L59:
        if (r8 == false) goto L61;
        getTitleBar().e(SPLIT_MENU_ID, getSplitMenuDrawable$default(this, getContext(), false, false, 4, null));
        return;
    L61:
        if (r0 == null) goto L67;
        r0.setVisibility(8);
        return;
    L67:
        return;
    L63:
        getTitleBar().e(SPLIT_MENU_ID, getSplitMenuDrawable$default(this, getContext(), true, false, 4, null));
        return;
    L30:
        r5 = null;
        goto L31
    L15:
        if (((Boolean) ForsetiHelper.m.getValue()).booleanValue() == true) goto L20;
        if (r0 == null) goto L18;
        r0.setVisibility(8);
    L18:
        tt5.a.h(TAG, "updateTitleBar: not enable bitable split window");
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onStart(PluginHost r1) {
        super.onStart(r1);
        registerViewModeChangeListener();
        registerScreenModeChangeListener();
    }

    public static final /* synthetic */ void access$updateTitleBar(DocumentSplitWindowPlugin r0, boolean r1) {
        r0.updateTitleBar(r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        super.onAttachToUIContainer(r2, r3);
        if (r3 == null) goto L16;
        TitleBar r4 = r3.getTitleBar();
        if (r4 == null) goto L16;
        this.mTitleBar = r4;
        sua.a r5 = (sua.a) ApiUtils.getApi(sua.a.class);
        if (r2 == null) goto L10;
        FragmentActivity r6 = r2.getActivity();
    L11:
        tua.b r7 = r5.tryGetChainManager(r6);
        if (r7 != null) goto L14;
        return;
    L14:
        this.chainManager = r7;
        tt5.a.h(TAG, "onAttachToUIContainer: ");
        return;
    L10:
        r6 = null;
    L16:
        tt5.a.d(TAG, "onAttachToUIContainer: titleBar is null");
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onDetachFromUIContainer(r1, r2);
        tt5.a.h(TAG, "onDetachFromUIContainer： screenModeChangedListener = " + this.screenModeChangedListener);
        tua.b r3 = this.chainManager;
        if (r3 == null) goto L5;
        r3.j(this.screenModeChangedListener);
    L5:
        tua.b r4 = this.chainManager;
        if (r4 == null) goto L8;
        r4.e(this.viewModeListener);
    L8:
        this.chainManager = null;
    }

    private final void addMenu(Context r11, TitleBar r12, MenuItem.b r13) {
        tt5.a.h(TAG, "addMenu: ");
        if (r12 != null) goto L5;
        return;
    L5:
        View r3 = r12.findMenuView(SPLIT_MENU_ID);
        if (r3 == null) goto L9;
        r3.setVisibility(0);
        return;
    L9:
        if (r11 != null) goto L11;
        return;
    L11:
        MenuItem r4 = new MenuItem();
        r4.setId(SPLIT_MENU_ID);
        r4.setClickListener(r13);
        r4.setIcon(getSplitMenuDrawable$default(this, r11, true, false, 4, null));
        int r14 = getAddMenuIndex();     // Catch: Exception -> L14
        tt5.a.h(TAG, "addMenu: index = " + r14);     // Catch: Exception -> L14
        TitleBar.MenuType r16 = TitleBar.MenuType.Left;     // Catch: Exception -> L14
        List<MenuItem> r0 = r12.i(r16);     // Catch: Exception -> L14
        ListProtector.add(r0, r14, r4);     // Catch: Exception -> L14
        r12.j(r0, r16);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        tt5.a.d(TAG, "addMenu Exception: " + e.getMessage());
    }

    private final Drawable getSplitMenuDrawable(Context r3, boolean r4, boolean r5) {
        tt5.a.h(TAG, "getMenuDrawable() called with: showSplitBtn = " + r4 + " ,enable = " + r5);
        if (r4 == false) goto L5;
        int r6 = 2131255641;
    L6:
        if (r5 == false) goto L8;
        int r7 = 2131102418;
    L10:
        return UDIconUtils.getIconDrawable(r3, r6, UDColorUtils.getColor(r3, r7));
    L8:
        r7 = 2131102417;
        goto L10
    L5:
        r6 = 2131254123;
        goto L6
    }

    public static /* synthetic */ void updateTitleBar$default(DocumentSplitWindowPlugin r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.updateTitleBar(r1);
    }

    public static /* synthetic */ Drawable getSplitMenuDrawable$default(DocumentSplitWindowPlugin r0, Context r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = true;
    L6:
        return r0.getSplitMenuDrawable(r1, r2, r3);
    }
}
