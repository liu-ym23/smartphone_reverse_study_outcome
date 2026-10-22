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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.utils.ApiUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002\r\u0010\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\u001c\u0010\u001b\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0014\u0010\u001c\u001a\u00020\u00132\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\"\u0010\u001f\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0002J$\u0010#\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010 \u001a\u0004\u0018\u00010\u000b2\u0006\u0010&\u001a\u00020'H\u0002J\u0018\u0010(\u001a\u00020)2\u0006\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/document/DocumentSwitchFullScreenPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "isFullScreen", "", "fragmentController", "Lcom/ss/android/lark/api/api/IForsetiFragmentDisplayController;", "chainManager", "Lcom/ss/android/lark/api/api/IForsetiActivityChainManager;", "mTitleBar", "Lcom/bytedance/ee/bear/browser/plugin/TitleBar;", "fullscreenChangeListener", "com/bytedance/ee/bear/document/DocumentSwitchFullScreenPlugin$fullscreenChangeListener$1", "Lcom/bytedance/ee/bear/document/DocumentSwitchFullScreenPlugin$fullscreenChangeListener$1;", "viewModeListener", "com/bytedance/ee/bear/document/DocumentSwitchFullScreenPlugin$viewModeListener$1", "Lcom/bytedance/ee/bear/document/DocumentSwitchFullScreenPlugin$viewModeListener$1;", "onAttachToUIContainer", "", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onStart", "registerFullscreenChangeListener", "registerViewModeChangeListener", "onDetachFromUIContainer", "refreshPageSizeButton", "viewMode", "Lcom/ss/android/lark/api/bean/ForsetiViewMode;", "updateMenu", "titleBar", "isShow", "makeFull", "addMenu", "context", "Landroid/content/Context;", "clickListener", "Lcom/bytedance/ee/bear/browser/plugin/MenuItem$ClickListener;", "getMenuDrawable", "Landroid/graphics/drawable/Drawable;", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentSwitchFullScreenPlugin extends DocumentPluginV2 {
    public static final a Companion = null;
    private static final String MENU_ID = "switch_full_screen_menu";
    private static final String TAG = "DocumentSwitchFullScreenPlugin";
    private tua.b chainManager;
    private tua.c fragmentController;
    private final b fullscreenChangeListener;
    private boolean isFullScreen;
    private TitleBar mTitleBar;
    private final d viewModeListener;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements tua.c.a {
        public final /* synthetic */ DocumentSwitchFullScreenPlugin a;

        public b(DocumentSwitchFullScreenPlugin r1) {
            this.a = r1;
        }

        public final void a(boolean r3) {
            tt5.a.h(DocumentSwitchFullScreenPlugin.TAG, "onFullscreenChanged: isFullscreen:" + r3);
            DocumentSwitchFullScreenPlugin.access$setFullScreen$p(this.a, r3);
            DocumentSwitchFullScreenPlugin.refreshPageSizeButton$default(this.a, null, 1, null);
        }
    }

    public static final class c implements MenuItem.b {
        public final /* synthetic */ DocumentSwitchFullScreenPlugin a;

        public c(DocumentSwitchFullScreenPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.browser.plugin.MenuItem.b
        public final void a(MenuItem r3, View r4) {
            tt5.a.h(DocumentSwitchFullScreenPlugin.TAG, "onMenuItemClick: isFullScreen:" + DocumentSwitchFullScreenPlugin.access$isFullScreen$p(this.a));
        L12:
            e = move-exception;
            tt5.a.d(DocumentSwitchFullScreenPlugin.TAG, "onMenuItemClick Exception: " + e.getMessage());
            return;
        L4:
            if (DocumentSwitchFullScreenPlugin.access$isFullScreen$p(this.a) == false) goto L8;
            tua.c r5 = DocumentSwitchFullScreenPlugin.access$getFragmentController$p(this.a);     // Catch: Exception -> L12
            if (r5 == null) goto L15;
            r5.c(true);     // Catch: Exception -> L12
        L15:
            return;
        L8:
            tua.c r6 = DocumentSwitchFullScreenPlugin.access$getFragmentController$p(this.a);     // Catch: Exception -> L12
            if (r6 == null) goto L15;
            r6.d(true);     // Catch: Exception -> L12
            goto L15
        }
    }

    public static final class d implements com.ss.android.lark.api.ui.j {
        public final /* synthetic */ DocumentSwitchFullScreenPlugin a;

        public d(DocumentSwitchFullScreenPlugin r1) {
            this.a = r1;
        }

        public final void a(ForsetiViewMode r3) {
            Intrinsics.checkNotNullParameter(r3, "viewMode");
            tt5.a.h(DocumentSwitchFullScreenPlugin.TAG, "onForsetiViewModeChanged: viewMode:" + r3.isCompact());
            DocumentSwitchFullScreenPlugin.access$refreshPageSizeButton(this.a, r3);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void registerFullscreenChangeListener() {
        tua.c r0 = this.fragmentController;
        if (r0 == null) goto L5;
        r0.a(this.fullscreenChangeListener);
    L5:
        tua.c r1 = this.fragmentController;
        if (r1 == null) goto L9;
        r1.b(this.fullscreenChangeListener);
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

    public DocumentSwitchFullScreenPlugin() {
        this.isFullScreen = true;
        this.fullscreenChangeListener = new b(this);
        this.viewModeListener = new d(this);
    }

    public static final /* synthetic */ tua.c access$getFragmentController$p(DocumentSwitchFullScreenPlugin r0) {
        return r0.fragmentController;
    }

    public static final /* synthetic */ boolean access$isFullScreen$p(DocumentSwitchFullScreenPlugin r0) {
        return r0.isFullScreen;
    }

    private final void refreshPageSizeButton(ForsetiViewMode r4) {
        if (r4 != null) goto L5;
    L10:
        boolean r5 = true;
    L12:
        if (this.chainManager == null) goto L15;
        boolean r1 = this.isFullScreen;
        updateMenu(this.mTitleBar, r5, true ^ r1);
        return;
    L15:
        return;
    L5:
        if (r4 == ForsetiViewMode.MEDIUM) goto L10;
        if (r4 == ForsetiViewMode.EXPAND) goto L10;
        r5 = false;
        goto L12
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onStart(PluginHost r1) {
        super.onStart(r1);
        registerFullscreenChangeListener();
        registerViewModeChangeListener();
    }

    public static final /* synthetic */ void access$refreshPageSizeButton(DocumentSwitchFullScreenPlugin r0, ForsetiViewMode r1) {
        r0.refreshPageSizeButton(r1);
    }

    public static final /* synthetic */ void access$setFullScreen$p(DocumentSwitchFullScreenPlugin r0, boolean r1) {
        r0.isFullScreen = r1;
    }

    private final Drawable getMenuDrawable(Context r3, boolean r4) {
        tt5.a.h(TAG, "getMenuDrawable() called with: context = " + r3 + ", makeFull = " + r4);
        if (r4 == false) goto L5;
        int r5 = 2131255063;
    L7:
        return UDIconUtils.getIconDrawable(r3, r5, UDColorUtils.getColor(r3, 2131102418));
    L5:
        r5 = 2131255132;
        goto L7
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r3, com.bytedance.ee.bear.browser.plugin.t r4) {
        super.onAttachToUIContainer(r3, r4);
        if (r4 == null) goto L27;
        TitleBar r5 = r4.getTitleBar();
        if (r5 == null) goto L27;
        this.mTitleBar = r5;
        sua.a r6 = (sua.a) ApiUtils.getApi(sua.a.class);
        tua.c r0 = null;
        if (r3 == null) goto L10;
        FragmentActivity r1 = r3.getActivity();
    L11:
        tua.b r7 = r6.tryGetChainManager(r1);
        if (r7 != null) goto L14;
        return;
    L14:
        this.chainManager = r7;
        if (r3 == null) goto L17;
        Fragment r8 = r3.getHostFragment();
    L18:
        Fragment r9 = ForsetiHelper.g(r8);
        if (r9 == null) goto L24;
        tua.b r2 = this.chainManager;
        if (r2 == null) goto L23;
        r0 = r2.g(r9);
    L23:
        this.fragmentController = r0;
    L24:
        if (r3 == null) goto L29;
        addMenu(r3.getActivity(), this.mTitleBar, new c(this));
        return;
    L29:
        return;
    L17:
        r8 = null;
        goto L18
    L10:
        r1 = null;
    L27:
        tt5.a.d(TAG, "onAttachToUIContainer: titleBar is null");
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onDetachFromUIContainer(r1, r2);
        tua.c r3 = this.fragmentController;
        if (r3 == null) goto L5;
        r3.a(this.fullscreenChangeListener);
    L5:
        tua.b r4 = this.chainManager;
        if (r4 == null) goto L8;
        r4.e(this.viewModeListener);
    L8:
        this.fragmentController = null;
        this.chainManager = null;
    }

    private final void addMenu(Context r3, TitleBar r4, MenuItem.b r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        View r1 = r4.findMenuView(MENU_ID);
        if (r1 == null) goto L8;
        r1.setVisibility(0);
        return;
    L8:
        if (r3 != null) goto L10;
        return;
    L10:
        MenuItem r2 = new MenuItem();
        r2.setId(MENU_ID);
        r2.setClickListener(r5);
        r2.setIcon(getMenuDrawable(r3, !this.isFullScreen));
        TitleBar.MenuType r6 = TitleBar.MenuType.Left;
        List<MenuItem> r7 = r4.i(r6);
        Intrinsics.checkNotNull(r7);
        ListProtector.add(r7, r7.size(), r2);
        r4.j(r7, r6);
    }

    private final void updateMenu(TitleBar r4, boolean r5, boolean r6) {
        tt5.a.h(TAG, "updateMenu() called with: titleBar = " + r4 + ", isShow = " + r5 + ", makeFull = " + r6);
        if (r4 != null) goto L5;
        return;
    L5:
        View r1 = r4.findMenuView(MENU_ID);
        if (r1 != null) goto L8;
        return;
    L8:
        if (r5 == false) goto L10;
        int r2 = 0;
    L11:
        r1.setVisibility(r2);
        if (r5 == false) goto L15;
        r4.e(MENU_ID, getMenuDrawable(getContext(), r6));
        return;
    L15:
        return;
    L10:
        r2 = 8;
        goto L11
    }

    public static /* synthetic */ void refreshPageSizeButton$default(DocumentSwitchFullScreenPlugin r0, ForsetiViewMode r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.refreshPageSizeButton(r1);
    }
}
