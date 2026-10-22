package com.bytedance.ee.bear.drive.biz.preview.more;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity;
import com.bytedance.ee.bear.drive.biz.encryption.DriveEncryptionVM;
import com.bytedance.ee.bear.drive.biz.permission.DriveSpaceAttachmentMGPermissionVM;
import com.bytedance.ee.bear.drive.biz.permission.handler.PermissionOperation;
import com.bytedance.ee.bear.drive.biz.preview.more.download.im.DriveImFileDownloadVM;
import com.bytedance.ee.bear.drive.biz.preview.more.menu.importfile.ImportFileItemV2;
import com.bytedance.ee.bear.drive.biz.preview.more.save2space.DriveImFileSaveToSpaceVM;
import com.bytedance.ee.bear.drive.biz.preview.titlebar.DriveTitleBarVisibilityPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToLocalMenuV2;
import com.bytedance.ee.util.info.AppInfoUtils;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/more/DriveSpaceAttachmentMoreMenuPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/more/AbsDriveMoreMenuPlugin;", "<init>", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "onAttachToUIContainer", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "enableShowMore", "", "drivePermissionInfo", "Lcom/bytedance/ee/bear/drive/biz/permission/model/DrivePermissionInfo;", "onDetachFromUIContainer", "showMore", "enableMore", "initMenuActions", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSpaceAttachmentMoreMenuPlugin extends AbsDriveMoreMenuPlugin {
    private final CompositeDisposable compositeDisposable;
    private boolean enableMore;
    private boolean showMore;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DriveSpaceAttachmentMoreMenuPlugin a;

        public a(DriveSpaceAttachmentMoreMenuPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r28) {
            e65.a r2 = new e65.a(new e65.a.C0217a(this.a.getHost().c, (DriveImFileSaveToSpaceVM) DriveSpaceAttachmentMoreMenuPlugin.access$viewModel(this.a, DriveImFileSaveToSpaceVM.class), (DriveImFileDownloadVM) DriveSpaceAttachmentMoreMenuPlugin.access$viewModel(this.a, DriveImFileDownloadVM.class)));
            FragmentActivity r3 = DriveSpaceAttachmentMoreMenuPlugin.access$getActivity(this.a);
            DriveSpaceAttachmentMoreMenuPlugin r4 = this.a;
            com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b.a r1 = new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b.a(r3, r4, DriveSpaceAttachmentMoreMenuPlugin.access$getUIContainer(r4));
            CompositeDisposable r5 = DriveSpaceAttachmentMoreMenuPlugin.access$getCompositeDisposable$p(this.a);
            Intrinsics.checkNotNullParameter(r5, "disposable");
            r1.d = r5;
            com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r6 = new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b(r1);
            final com.bytedance.ee.bear.drive.biz.preview.more.b r7 = new com.bytedance.ee.bear.drive.biz.preview.more.b(DriveSpaceAttachmentMoreMenuPlugin.access$getActivity(this.a), r2, r6);
            a95.a r8 = this.a.getHost().b();
            Intrinsics.checkNotNullParameter(r8, "userComponentAbility");
            BaseOpenEntity r9 = r7.b.a;
            float r10 = 1.0f;
            if (((SaveToLocalMenuV2) com.bytedance.ee.bear.drive.biz.preview.more.b.e(r9.getMoreMenuActions(), SaveToLocalMenuV2.class)) == null) goto L5;
            r7.h(SaveToLocalMenuV2.class, new com.bytedance.ee.bear.drive.biz.preview.more.c(r7, r8));
        L10:
            r7.c(this.a.getHost().b());
            if (AppInfoUtils.e().booleanValue() == true) goto L22;
            r7.d();
            BaseOpenEntity r11 = r7.b.a;
            if ((r11 instanceof BaseSpaceOpenEntity) == false) goto L22;
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity");
            final BaseSpaceOpenEntity r12 = (BaseSpaceOpenEntity) r11;
            final f85.a r13 = (f85.a) r7.b.b.getFileModel();
            if (n55.a.a(r13) == false) goto L22;
            View.OnClickListener r14 = new DriveAttachmentMoreMenuCreator$buildImportFileMenuItemForSpaceAttachment$listener$1(r12, r7, r13);
            s55.e r16 = new s55.e("CREATE_COPY", PermissionOperation.CREATE_COPY, 0, r12.getMountPoint(), r12.getFileId(), null, null, null, null, null, null, null, null, null, 32740);
            boolean r17 = s55.a.a.i(r16);
            com.bytedance.ee.bear.more.b r18 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
            String r19 = ImportFileItemV2.ID_IMPORT_FILE;
            boolean r20 = r18.l(r19);
            com.bytedance.ee.bear.widgets.a r110 = r7.d;
            String r21 = r7.a.getResources().getString(n55.a.b(r13));
            if (r17 == true) goto L21;
            r10 = 0.3f;
        L21:
            cp5.b r22 = new cp5.b();
            r22.a = r21;
            r22.d = r20;
            r22.e = null;
            r22.f = r14;
            r22.c = false;
            r22.b = -1;
            r22.g = true;
            r22.h = r10;
            r22.i = true;
            r110.f(r22);
            ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).b(r19);
        L22:
            r7.d.a();
            r7.d.q();
            return;
        L5:
            s55.e r23 = new s55.e("DOWNLOAD", PermissionOperation.DOWNLOAD, 0, r9.getMountPoint(), r9.getFileId(), null, null, null, null, null, null, null, null, null, 32740);
            boolean r24 = s55.a.a.i(r23);
            com.bytedance.ee.bear.widgets.a r26 = r7.d;
            CharSequence r111 = r7.a.getText(2131887287);
            if (r24 == false) goto L8;
            float r27 = 1.0f;
        L9:
            com.bytedance.ee.bear.drive.biz.preview.more.d r112 = new com.bytedance.ee.bear.drive.biz.preview.more.d(r7, r8);
            cp5.b r29 = new cp5.b();
            r29.a = r111;
            r29.d = false;
            r29.e = null;
            r29.f = r112;
            r29.c = false;
            r29.b = -1;
            r29.g = true;
            r29.h = r27;
            r29.i = true;
            r26.f(r29);
            goto L10
        L8:
            r27 = 0.3f;
            goto L9
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DriveSpaceAttachmentMoreMenuPlugin a;
        public final /* synthetic */ DriveSpaceAttachmentMGPermissionVM b;

        public b(DriveSpaceAttachmentMoreMenuPlugin r1, DriveSpaceAttachmentMGPermissionVM r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            ConnectionService.NetworkState r4 = (ConnectionService.NetworkState) r3;
            DriveSpaceAttachmentMoreMenuPlugin r0 = this.a;
            DriveSpaceAttachmentMoreMenuPlugin.access$setShowMore$p(r0, DriveSpaceAttachmentMoreMenuPlugin.access$enableShowMore(r0, (u55.b) this.b.livePerm().getValue()));
            DriveSpaceAttachmentMoreMenuPlugin r1 = this.a;
            if (r4 == null) goto L7;
            boolean r2 = true;
            if (r4.a() != true) goto L7;
        L8:
            DriveSpaceAttachmentMoreMenuPlugin.access$setEnableMore$p(r1, r2);
            DriveSpaceAttachmentMoreMenuPlugin.access$initMenuActions(this.a);
            return;
        L7:
            r2 = false;
            goto L8
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ DriveSpaceAttachmentMoreMenuPlugin a;

        public c(DriveSpaceAttachmentMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            DriveSpaceAttachmentMoreMenuPlugin r0 = this.a;
            DriveSpaceAttachmentMoreMenuPlugin.access$setShowMore$p(r0, DriveSpaceAttachmentMoreMenuPlugin.access$enableShowMore(r0, (u55.b) r3));
            DriveSpaceAttachmentMoreMenuPlugin r4 = this.a;
            com.bytedance.ee.bear.contract.j r1 = com.bytedance.ee.bear.contract.j.a.a;
            if (r1 == null) goto L7;
            boolean r2 = true;
            if (r1.getNetworkState().a() != true) goto L7;
        L8:
            DriveSpaceAttachmentMoreMenuPlugin.access$setEnableMore$p(r4, r2);
            DriveSpaceAttachmentMoreMenuPlugin.access$initMenuActions(this.a);
            return;
        L7:
            r2 = false;
            goto L8
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DriveSpaceAttachmentMoreMenuPlugin a;

        public d(DriveSpaceAttachmentMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DriveSpaceAttachmentMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ DriveSpaceAttachmentMoreMenuPlugin a;

        public e(DriveSpaceAttachmentMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DriveSpaceAttachmentMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ DriveSpaceAttachmentMoreMenuPlugin a;

        public f(DriveSpaceAttachmentMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DriveSpaceAttachmentMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.more.AbsDriveMoreMenuPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveSpaceAttachmentMoreMenuPlugin() {
        this.compositeDisposable = new CompositeDisposable();
    }

    private final void initMenuActions() {
        if (isUIContainerAttached() == true) goto L6;
        return;
    L6:
        if ((!((DriveEncryptionVM) viewModel(DriveEncryptionVM.class)).isEncryptionKeyDeleted()) == true) goto L9;
        tt5.a.h("DriveComponent", "DriveSpaceAttachmentMoreMenuPlugin#initMenuActions() block!");
        return;
    L9:
        ArrayList r0 = new ArrayList();
        Boolean r1 = Boolean.TRUE;
        if (r1.equals(drivePreviewViewModel().liveInnerShowWPSPresentationAction().getValue()) == false) goto L13;
        r0.add(instancePresentationItem());
    L13:
        if (Intrinsics.areEqual(titleBarViewModel().getOutlineEnable().getValue(), r1) == false) goto L16;
        r0.add(createOutlineMenuItem());
    L16:
        if (this.showMore == false) goto L18;
        MenuItem r2 = createMoreMenuItem(new a(this));
        r2.setEnable(this.enableMore);
        r0.add(r2);
    L18:
        DriveTitleBarVisibilityPlugin r3 = (DriveTitleBarVisibilityPlugin) findPlugin(DriveTitleBarVisibilityPlugin.class);
        if (r3 == null) goto L22;
        r3.updateMenuCount(hu5.a.c(r0));
    L22:
        if (hu5.a.d(r0) == false) goto L24;
        return;
    L24:
        showRightMenu(r0);
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveSpaceAttachmentMoreMenuPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ CompositeDisposable access$getCompositeDisposable$p(DriveSpaceAttachmentMoreMenuPlugin r0) {
        return r0.compositeDisposable;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.t access$getUIContainer(DriveSpaceAttachmentMoreMenuPlugin r0) {
        return r0.getUIContainer();
    }

    public static final /* synthetic */ void access$initMenuActions(DriveSpaceAttachmentMoreMenuPlugin r0) {
        r0.initMenuActions();
    }

    private final boolean enableShowMore(u55.b r4) {
        if (r4 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L18;
        if (r4 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == true) goto L19;
        return false;
    L19:
        return true;
    L11:
        if (r4.b.a.canConditionExport() != true) goto L13;
        r5 = true;
        goto L14
    L18:
        return true;
    L5:
        if (r4.d() != true) goto L7;
        r2 = true;
        goto L8
    }

    public static final /* synthetic */ boolean access$enableShowMore(DriveSpaceAttachmentMoreMenuPlugin r0, u55.b r1) {
        return r0.enableShowMore(r1);
    }

    public static final /* synthetic */ void access$setEnableMore$p(DriveSpaceAttachmentMoreMenuPlugin r0, boolean r1) {
        r0.enableMore = r1;
    }

    public static final /* synthetic */ void access$setShowMore$p(DriveSpaceAttachmentMoreMenuPlugin r0, boolean r1) {
        r0.showMore = r1;
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveSpaceAttachmentMoreMenuPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.more.AbsDriveMoreMenuPlugin
    public void onAttachToUIContainer(DrivePluginHost r3, com.bytedance.ee.bear.browser.plugin.t r4) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r4, "uiContainer");
        super.onAttachToUIContainer(r3, r4);
        DriveSpaceAttachmentMGPermissionVM r5 = (DriveSpaceAttachmentMGPermissionVM) viewModel(DriveSpaceAttachmentMGPermissionVM.class);
        k75.a.h(this, new b(this, r5));
        r5.livePerm().observe(getLifecycleOwner(), new c(this));
        k75.a.i(r3).liveInnerShowWPSPresentationAction().observe(getLifecycleOwner(), new d(this));
        titleBarViewModel().getOutlineEnable().observe(getLifecycleOwner(), new e(this));
        ((DriveEncryptionVM) viewModel(DriveEncryptionVM.class)).getEncryptionKeyDeleted().observe(getLifecycleOwner(), new f(this));
    }

    public void onDetachFromUIContainer(DrivePluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onDetachFromUIContainer(r2, r3);
        this.compositeDisposable.clear();
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
