package com.bytedance.ee.bear.drive.biz.preview.more;

import android.view.View;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.drive.biz.preview.titlebar.DriveTitleBarVisibilityPlugin;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.TitleBarViewModel;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.drive.preview.IDriveDownloadFilePlugin;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0016\u0010\u0010\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0004J\b\u0010\u0018\u001a\u00020\u000fH\u0004J\b\u0010\u0019\u001a\u00020\u000fH\u0004J!\u0010\u001a\u001a\u00020\b2\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u001c\"\u00020\u000fH\u0004¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001a\u001a\u00020\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0004J\b\u0010\u001e\u001a\u00020\bH\u0014J\b\u0010\u001f\u001a\u00020 H\u0004J\b\u0010!\u001a\u00020\"H\u0004R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/more/AbsDriveMoreMenuPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "Lcom/bytedance/ee/drive/preview/IDriveTitleMenuPlugin;", "<init>", "()V", "menusUpdateListener", "Lcom/bytedance/ee/drive/preview/IDriveTitleMenusUpdateListener;", "onAttachToUIContainer", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "getRightMenus", "", "Lcom/bytedance/ee/bear/browser/plugin/MenuItem;", "setRightMenus", "menuItems", "setUpdateListener", "listener", "createDownloadMenu", "createMoreMenuItem", "clickListener", "Landroid/view/View$OnClickListener;", "instancePresentationItem", "createOutlineMenuItem", "showRightMenu", "items", "", "([Lcom/bytedance/ee/bear/browser/plugin/MenuItem;)V", "addExtraMenu", "titleBarViewModel", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/TitleBarViewModel;", "drivePreviewViewModel", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/PreviewViewModel;", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsDriveMoreMenuPlugin extends AbsDrivePlugin {
    public static final String COMMENT_MENU_ID = "ccm_drive_comment_menu";
    public static final a Companion = null;
    public static final String DOWNLOAD_MENU_ID = "ccm_drive_download_file_menu";
    public static final String FEED_MENU_ID = "ccm_drive_feed_menu";
    public static final String GUEST_PRESENTATION_MENU_ID = "ccm_drive_guest_presentation_menu";
    public static final String MORE_MENU_ID = "ccm_drive_more_menu";
    public static final String OUTLINE_MENU_ID = "ccm_drive_outline_menu";
    public static final String SECRET_MENU_ID = "ccm_drive_secret_menu";
    public static final String SHARE_MENU_ID = "ccm_drive_share_menu";
    public static final String TAG = "AbsDriveMoreMenuPlugin";
    private com.bytedance.ee.drive.preview.g menusUpdateListener;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements MenuItem.b {
        public final /* synthetic */ AbsDriveMoreMenuPlugin a;

        public b(AbsDriveMoreMenuPlugin r1, MenuItem r2) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.browser.plugin.MenuItem.b
        public final void a(MenuItem r3, View r4) {
            IDriveDownloadFilePlugin r5 = (IDriveDownloadFilePlugin) AbsDriveMoreMenuPlugin.access$findPlugin(this.a, IDriveDownloadFilePlugin.class);
            if (r5 == null) goto L5;
            tt5.a.h(AbsDriveMoreMenuPlugin.TAG, "createDownloadMenuItem, downloadFilePlugin: " + r5);
            r5.downloadCurrentFile(null);
            return;
        L5:
            tt5.a.d(AbsDriveMoreMenuPlugin.TAG, "createDownloadMenuItem, downloadFilePlugin is null");
            Toast.showFailureText(r4.getContext(), 2131889802);
        }
    }

    public static final class c implements MenuItem.b {
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ AbsDriveMoreMenuPlugin b;

        public c(View.OnClickListener r1, AbsDriveMoreMenuPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.ee.bear.browser.plugin.MenuItem.b
        public final void a(MenuItem r4, View r5) {
            this.a.onClick(r5);
            Integer r6 = (Integer) this.b.getHost().c.livePreviewType().getValue();
            if (r6 != null) goto L6;
        L15:
            k75.a.c(this.b.getHost()).t(this.b.getHost().c.getFileModel(), "more", "ccm_space_docs_more_menu_view", null);
            com.bytedance.ee.bear.drive.report.c r7 = k75.a.c(this.b.getHost());
            w75.a r8 = this.b.getHost().c.getFileModel();
            if (r8 != null) goto L18;
            r7.getClass();
            return;
        L18:
            HashMap<String, Object> r0 = r7.i(r8);
            r7.c(r8.c().a, r0);
            r7.A("ccm_drive_file_menu_view", r0);
            return;
        L6:
            if (r6.intValue() != 4) goto L15;
            Integer r9 = (Integer) this.b.getHost().c.livePreviewType().getValue();
            if (r9 != null) goto L11;
        L13:
            String r10 = "card";
        L14:
            k75.a.c(this.b.getHost()).p(this.b.getHost().c.getFileModel(), "more", r10);
            goto L15
        L11:
            if (r9.intValue() != 4) goto L13;
            r10 = "preview";
            goto L14
        }
    }

    public static final class d implements MenuItem.b {
        public final /* synthetic */ AbsDriveMoreMenuPlugin a;

        public d(AbsDriveMoreMenuPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.browser.plugin.MenuItem.b
        public final void a(MenuItem r1, View r2) {
            rcb.c.d(r2);
            this.a.titleBarViewModel().showOutlineDialog();
        }
    }

    public static final class e implements MenuItem.b {
        public final /* synthetic */ AbsDriveMoreMenuPlugin a;

        public e(AbsDriveMoreMenuPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.browser.plugin.MenuItem.b
        public final void a(MenuItem r4, View r5) {
            rcb.c.d(r5);
            k75.a.c(this.a.getHost()).t(this.a.getHost().c.getFileModel(), "show", "none", null);
            k75.a.i(this.a.getHost()).liveOuterEnterPresentationMode().postValue(null);
        }
    }

    static {
        Companion = new a();
    }

    public void addExtraMenu() {
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.ee.bear.browser.plugin.PluginHost] */
    public final PreviewViewModel drivePreviewViewModel() {
        return (PreviewViewModel) com.bytedance.ee.bear.browser.plugin.q.c(getHost(), PreviewViewModel.class, null);
    }

    public final TitleBarViewModel titleBarViewModel() {
        return (TitleBarViewModel) viewModel(TitleBarViewModel.class);
    }

    public MenuItem createDownloadMenu() {
        MenuItem r1 = new MenuItem(DOWNLOAD_MENU_ID, com.bytedance.ee.util.ui.l.a(getContext(), 2131254269, 2131101926), "");
        r1.setClickListener(new b(this, r1));
        return r1;
    }

    public final MenuItem createOutlineMenuItem() {
        MenuItem r1 = new MenuItem(OUTLINE_MENU_ID, com.bytedance.ee.util.ui.l.a(getContext(), 2131255955, 2131101926), "");
        r1.setClickListener(new d(this));
        return r1;
    }

    public List<MenuItem> getRightMenus() {
        TitleBar r0 = getTitleBar();
        if (r0 == null) goto L7;
        List<MenuItem> r1 = r0.i(TitleBar.MenuType.Right);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    public final MenuItem instancePresentationItem() {
        MenuItem r1 = new MenuItem(GUEST_PRESENTATION_MENU_ID, com.bytedance.ee.util.ui.l.a(getContext(), 2131255445, 2131101926), "");
        r1.setClickListener(new e(this));
        return r1;
    }

    public AbsDriveMoreMenuPlugin() {
    }

    public final MenuItem createMoreMenuItem(View.OnClickListener r5) {
        Intrinsics.checkNotNullParameter(r5, "clickListener");
        MenuItem r1 = new MenuItem(MORE_MENU_ID, com.bytedance.ee.util.ui.l.a(getContext(), 2131255147, 2131101926), "");
        r1.setClickListener(new c(r5, this));
        return r1;
    }

    public void setRightMenus(List<? extends MenuItem> r3) {
        Intrinsics.checkNotNullParameter(r3, "menuItems");
        TitleBar r0 = getTitleBar();
        if (r0 == null) goto L6;
        r0.j(r3, TitleBar.MenuType.Right);
        return;
    }

    public void setUpdateListener(com.bytedance.ee.drive.preview.g r1) {
        this.menusUpdateListener = r1;
    }

    public final void showRightMenu(MenuItem... r3) {
        Intrinsics.checkNotNullParameter(r3, "items");
        DriveTitleBarVisibilityPlugin r0 = (DriveTitleBarVisibilityPlugin) findPlugin(DriveTitleBarVisibilityPlugin.class);
        if (r0 == null) goto L5;
        r0.updateMenuCount(r3.length);
    L5:
        TitleBar r1 = getTitleBar();
        if (r1 == null) goto L10;
        BaseTitleBar r2 = r1.getTitleBarLayout();
        if (r2 == null) goto L10;
        r2.g();
    L10:
        List<MenuItem> r4 = ArraysKt.asList(r3);
        com.bytedance.ee.drive.preview.g r5 = this.menusUpdateListener;
        if (r5 == null) goto L16;
        List<MenuItem> r6 = r5.a(r4);
        if (r6 == null) goto L16;
        r4 = r6;
    L16:
        TitleBar r7 = getTitleBar();
        if (r7 == null) goto L19;
        r7.j(r4, TitleBar.MenuType.Right);
    L19:
        addExtraMenu();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showRightMenu(List<? extends MenuItem> r3) {
        Intrinsics.checkNotNullParameter(r3, "items");
        DriveTitleBarVisibilityPlugin r0 = (DriveTitleBarVisibilityPlugin) findPlugin(DriveTitleBarVisibilityPlugin.class);
        if (r0 == null) goto L5;
        r0.updateMenuCount(r3.size());
    L5:
        TitleBar r1 = getTitleBar();
        if (r1 == null) goto L10;
        BaseTitleBar r2 = r1.getTitleBarLayout();
        if (r2 == null) goto L10;
        r2.g();
    L10:
        com.bytedance.ee.drive.preview.g r4 = this.menusUpdateListener;
        if (r4 == null) goto L16;
        List<MenuItem> r5 = r4.a(r3);
        if (r5 == null) goto L16;
        r3 = r5;
    L16:
        TitleBar r6 = getTitleBar();
        if (r6 == 0) goto L19;
        r6.j(r3, TitleBar.MenuType.Right);
    L19:
        addExtraMenu();
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$findPlugin(AbsDriveMoreMenuPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public void onAttachToUIContainer(DrivePluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onAttachToUIContainer(r2, r3);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }
}
