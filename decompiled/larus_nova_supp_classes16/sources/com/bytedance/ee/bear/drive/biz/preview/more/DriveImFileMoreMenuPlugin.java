package com.bytedance.ee.bear.drive.biz.preview.more;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.drive.biz.encryption.DriveEncryptionVM;
import com.bytedance.ee.bear.drive.biz.preview.more.download.im.DriveImFileDownloadVM;
import com.bytedance.ee.bear.drive.biz.preview.more.manager.DriveIMAttachmentMoreMenuManager;
import com.bytedance.ee.bear.drive.biz.preview.more.save2space.DriveImFileSaveToSpaceVM;
import com.bytedance.ee.bear.drive.biz.preview.titlebar.DriveTitleBarVisibilityPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveImFileMoreMenuPlugin extends AbsDriveMoreMenuPlugin {
    private com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b clickContext;
    private CompositeDisposable compositeDisposable;
    private boolean enableMore;
    private e65.a menuInfoContext;
    private DriveIMAttachmentMoreMenuManager moreMenuManager;

    public class a implements Observer<Boolean> {
        public final /* synthetic */ DriveImFileMoreMenuPlugin a;

        public a(DriveImFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DriveImFileMoreMenuPlugin.access$000(this.a);
        }
    }

    public class b implements Observer<Boolean> {
        public final /* synthetic */ DriveImFileMoreMenuPlugin a;

        public b(DriveImFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DriveImFileMoreMenuPlugin.access$000(this.a);
        }
    }

    public static /* synthetic */ void a(DriveImFileMoreMenuPlugin r0, Boolean r1) {
        r0.lambda$onAttachToUIContainer$1(r1);
    }

    public static /* synthetic */ void c(DriveImFileMoreMenuPlugin r0, ConnectionService.NetworkState r1) {
        r0.lambda$onAttachToUIContainer$0(r1);
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.more.AbsDriveMoreMenuPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b getClickContext() {
        if (this.clickContext != null) goto L6;
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b.a r0 = new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b.a(getActivity(), this, getUIContainer());
        CompositeDisposable r1 = this.compositeDisposable;
        Intrinsics.checkNotNullParameter(r1, "disposable");
        r0.d = r1;
        this.clickContext = new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b(r0);
    L6:
        return this.clickContext;
    }

    private e65.a getMenuInfoContext() {
        if (this.menuInfoContext != null) goto L6;
        this.menuInfoContext = new e65.a(new e65.a.C0217a(getHost().c, (DriveImFileSaveToSpaceVM) viewModel(DriveImFileSaveToSpaceVM.class), (DriveImFileDownloadVM) viewModel(DriveImFileDownloadVM.class)));
    L6:
        return this.menuInfoContext;
    }

    public DriveImFileMoreMenuPlugin() {
        this.compositeDisposable = new CompositeDisposable();
        this.enableMore = false;
    }

    private void initMenuActions() {
        if (isUIContainerAttached() == true) goto L5;
        return;
    L5:
        boolean r1 = true;
        if ((!((DriveEncryptionVM) viewModel(DriveEncryptionVM.class)).isEncryptionKeyDeleted()) == true) goto L9;
        tt5.a.h("DriveComponent", "DriveImFileMoreMenuPlugin#initMenuActions() block!");
        return;
    L9:
        ArrayList r0 = new ArrayList();
        Boolean r2 = Boolean.TRUE;
        if (r2.equals(drivePreviewViewModel().liveInnerShowWPSPresentationAction().getValue()) == false) goto L13;
        r0.add(instancePresentationItem());
    L13:
        if (titleBarViewModel().getOutlineEnable().getValue() == r2) goto L16;
        r1 = false;
    L16:
        if (r1 == false) goto L18;
        r0.add(createOutlineMenuItem());
    L18:
        MenuItem r3 = createMoreMenuItem(this.moreMenuManager.c(getClickContext()));
        r3.setEnable(this.enableMore);
        r0.add(r3);
        DriveTitleBarVisibilityPlugin r4 = (DriveTitleBarVisibilityPlugin) findPlugin(DriveTitleBarVisibilityPlugin.class);
        if (r4 == null) goto L22;
        r4.updateMenuCount(hu5.a.c(r0));
    L22:
        if (hu5.a.d(r0) == false) goto L24;
        return;
    L24:
        showRightMenu(r0);
    }

    public static /* synthetic */ void access$000(DriveImFileMoreMenuPlugin r0) {
        r0.initMenuActions();
    }

    private /* synthetic */ void lambda$onAttachToUIContainer$0(ConnectionService.NetworkState r1) {
        if (r1 != null) goto L4;
    L6:
        boolean r2 = false;
    L7:
        this.enableMore = r2;
        initMenuActions();
        return;
    L4:
        if (r1.a() == false) goto L6;
        r2 = true;
        goto L7
    }

    private /* synthetic */ void lambda$onAttachToUIContainer$1(Boolean r1) {
        initMenuActions();
    }

    public DriveIMAttachmentMoreMenuManager createMoreMenuManager(DriveIMAttachmentMoreMenuManager.Sence r3) {
        return new DriveIMAttachmentMoreMenuManager(getMenuInfoContext(), r3);
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.more.AbsDriveMoreMenuPlugin
    public void onAttachToUIContainer(DrivePluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        super.onAttachToUIContainer(r2, r3);
        DriveViewModel r4 = r2.c;
        this.moreMenuManager = createMoreMenuManager(DriveIMAttachmentMoreMenuManager.Sence.UNKNOW);
        this.moreMenuManager.d(getClickContext());
        drivePreviewViewModel().liveInnerShowWPSPresentationAction().observe(getLifecycleOwner(), new a(this));
        titleBarViewModel().getOutlineEnable().observe(getLifecycleOwner(), new b(this));
        com.bytedance.ee.bear.contract.j.a.a.a().observe(getLifecycleOwner(), new o(this));
        ((DriveEncryptionVM) viewModel(DriveEncryptionVM.class)).getEncryptionKeyDeleted().observe(getLifecycleOwner(), new p(this));
    }

    public void onDetachFromUIContainer(DrivePluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onDetachFromUIContainer(r1, r2);
        this.compositeDisposable.clear();
        DriveIMAttachmentMoreMenuManager r3 = this.moreMenuManager;
        if (r3 == null) goto L6;
        r3.a(getClickContext());
        return;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.more.AbsDriveMoreMenuPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DrivePluginHost) r1, r2);
    }
}
