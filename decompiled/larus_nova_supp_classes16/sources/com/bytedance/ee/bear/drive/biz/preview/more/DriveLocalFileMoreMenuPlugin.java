package com.bytedance.ee.bear.drive.biz.preview.more;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.LocalOpenEntity;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.drive.biz.permission.handler.PermissionOperation;
import com.bytedance.ee.bear.drive.biz.preview.more.download.im.DriveImFileDownloadVM;
import com.bytedance.ee.bear.drive.biz.preview.more.save2space.DriveImFileSaveToSpaceVM;
import com.bytedance.ee.bear.drive.biz.preview.titlebar.DriveTitleBarVisibilityPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.OpenExternalMenu;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToLocalMenuV2;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.DriveData;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.supervisor.token.Token;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.c1;
import com.ss.android.lark.utils.y0;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.lark.android.encryption.CipherManager;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/more/DriveLocalFileMoreMenuPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/more/AbsDriveMoreMenuPlugin;", "<init>", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "onAttachPreview", "", "initMenuActions", "onDetachPreview", "saveToLocalDefault", "menuActionWrapper", "Lcom/bytedance/ee/bear/contract/drive/sdk/entity/menu/MoreMenuActionWrapper;", "doAuditDownload", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "openEntity", "Lcom/bytedance/ee/bear/contract/drive/sdk/entity/open/LocalOpenEntity;", "isSuccess", "", "auditDownload", "initExportVisible", "openExternal", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveLocalFileMoreMenuPlugin extends AbsDriveMoreMenuPlugin {
    public static final a Companion = null;
    public static final String SAVE_FILE_NOTIFY_SYSTEM = "LARK-PSDA-ccm_android_drive_local_save_file_notify_system";
    public static final String SAVE_MEDIA_NOTIFY_SYSTEM = "LARK-PSDA-ccm_android_drive_local_save_media_notify_system";
    private final CompositeDisposable compositeDisposable;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ DriveLocalFileMoreMenuPlugin a;

        public static final class a implements com.bytedance.ee.bear.drive.biz.preview.more.a {
            public final /* synthetic */ DriveLocalFileMoreMenuPlugin a;

            /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.more.DriveLocalFileMoreMenuPlugin$b$a$a, reason: collision with other inner class name */
            public static final class RunnableC0140a implements Runnable {
                public final /* synthetic */ DriveLocalFileMoreMenuPlugin a;

                /* JADX INFO: Incorrect field signature: TT; */
                public final /* synthetic */ BaseMoreMenuAction b;

                /* JADX WARN: Incorrect types in method signature: (Lcom/bytedance/ee/bear/drive/biz/preview/more/DriveLocalFileMoreMenuPlugin;TT;)V */
                public RunnableC0140a(DriveLocalFileMoreMenuPlugin r1, BaseMoreMenuAction r2) {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    DriveLocalFileMoreMenuPlugin.access$openExternal(this.a, new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d(this.b));     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            public a(DriveLocalFileMoreMenuPlugin r1) {
                this.a = r1;
            }

            @Override // com.bytedance.ee.bear.drive.biz.preview.more.a
            public final <T extends BaseMoreMenuAction> void a(T r3) {
                Intrinsics.checkNotNullParameter(r3, "t");
                com.bytedance.ee.util.ui.m.a(new RunnableC0140a(this.a, r3));
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.more.DriveLocalFileMoreMenuPlugin$b$b, reason: collision with other inner class name */
        public static final class C0141b implements com.bytedance.ee.bear.drive.biz.preview.more.a {
            public final /* synthetic */ DriveLocalFileMoreMenuPlugin a;

            /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.more.DriveLocalFileMoreMenuPlugin$b$b$a */
            public static final class a implements Runnable {
                public final /* synthetic */ DriveLocalFileMoreMenuPlugin a;

                /* JADX INFO: Incorrect field signature: TT; */
                public final /* synthetic */ BaseMoreMenuAction b;

                /* JADX WARN: Incorrect types in method signature: (Lcom/bytedance/ee/bear/drive/biz/preview/more/DriveLocalFileMoreMenuPlugin;TT;)V */
                public a(DriveLocalFileMoreMenuPlugin r1, BaseMoreMenuAction r2) {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    DriveLocalFileMoreMenuPlugin.access$saveToLocalDefault(this.a, new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d(this.b));     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            public C0141b(DriveLocalFileMoreMenuPlugin r1) {
                this.a = r1;
            }

            @Override // com.bytedance.ee.bear.drive.biz.preview.more.a
            public final <T extends BaseMoreMenuAction> void a(T r3) {
                Intrinsics.checkNotNullParameter(r3, "t");
                com.bytedance.ee.util.ui.m.a(new a(this.a, r3));
            }
        }

        public static final class c implements DialogInterface.OnCancelListener {
            public final /* synthetic */ DriveLocalFileMoreMenuPlugin a;

            public c(DriveLocalFileMoreMenuPlugin r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface r4) {
                o75.b.a().Ke().n(this.a.getHost().c.getFileModel(), "cancel", "none");
            }
        }

        public b(DriveLocalFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            e65.a r0 = new e65.a(new e65.a.C0217a(this.a.getHost().c, (DriveImFileSaveToSpaceVM) DriveLocalFileMoreMenuPlugin.access$viewModel(this.a, DriveImFileSaveToSpaceVM.class), (DriveImFileDownloadVM) DriveLocalFileMoreMenuPlugin.access$viewModel(this.a, DriveImFileDownloadVM.class)));
            FragmentActivity r1 = DriveLocalFileMoreMenuPlugin.access$getActivity(this.a);
            DriveLocalFileMoreMenuPlugin r2 = this.a;
            com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b.a r6 = new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b.a(r1, r2, DriveLocalFileMoreMenuPlugin.access$getUIContainer(r2));
            CompositeDisposable r3 = DriveLocalFileMoreMenuPlugin.access$getCompositeDisposable$p(this.a);
            Intrinsics.checkNotNullParameter(r3, "disposable");
            r6.d = r3;
            com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r4 = new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b(r6);
            com.bytedance.ee.bear.drive.biz.preview.more.b r7 = new com.bytedance.ee.bear.drive.biz.preview.more.b(DriveLocalFileMoreMenuPlugin.access$getActivity(this.a), r0, r4);
            r7.d.a();
            r7.h(OpenExternalMenu.class, new a(this.a));
            r7.h(SaveToLocalMenuV2.class, new C0141b(this.a));
            r7.d.q();
            com.bytedance.ee.bear.widgets.a r8 = r7.d;
            c r9 = new c(this.a);
            ((com.larksuite.component.ui.dialog.d) r8.b).c.onCancelListener(r9);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ DriveLocalFileMoreMenuPlugin a;

        public c(DriveLocalFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DriveLocalFileMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DriveLocalFileMoreMenuPlugin a;

        public d(DriveLocalFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DriveLocalFileMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ DriveLocalFileMoreMenuPlugin a;
        public final /* synthetic */ com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d b;

        public e(DriveLocalFileMoreMenuPlugin r1, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r9) {
            Intrinsics.checkNotNullParameter((String) r9, "it");
            BaseOpenEntity r10 = this.a.getHost().c.getOpenEntity();
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.drive.sdk.entity.open.LocalOpenEntity");
            LocalOpenEntity r11 = (LocalOpenEntity) r10;
            DriveLocalFileMoreMenuPlugin r0 = this.a;
            boolean r2 = true;
            DriveLocalFileMoreMenuPlugin.access$auditDownload(r0, r0.getHost(), r11, true);
            VFSPath r12 = ay4.d.a().z(r11.getLocalFilePath());
            w75.a r1 = this.a.getHost().c.getFileModel();
            String r3 = "";
            if (r1 == null) goto L6;
            String r4 = r1.f;
            if (r4 == null) goto L6;
        L7:
            boolean r5 = i75.h.e(r4);
            boolean r6 = i75.h.n(r4);
            if (r5 == true) goto L12;
            if (r6 == true) goto L12;
            r2 = false;
        L12:
            w75.a r7 = this.a.getHost().c.getFileModel();
            if (r7 == null) goto L18;
            String r8 = r7.r;
            if (r8 == null) goto L18;
            r3 = r8;
        L18:
            Uri r13 = com.larksuite.framework.utils.i.e(DriveLocalFileMoreMenuPlugin.access$getContext(this.a), r12.getName(), r3, null, null);
            Context r14 = DriveLocalFileMoreMenuPlugin.access$getContext(this.a);
            Map r16 = FileUtils.a;
            com.larksuite.framework.utils.i.a(r14, r12.getRealPath(), r13);     // Catch: Exception -> L21
        L23:
            if (r2 == false) goto L25;
            com.larksuite.framework.utils.i.i(DriveLocalFileMoreMenuPlugin.access$getContext(this.a), r13, new Token(DriveLocalFileMoreMenuPlugin.SAVE_MEDIA_NOTIFY_SYSTEM));
        L26:
            if (r2 == false) goto L28;
            String r17 = DriveLocalFileMoreMenuPlugin.access$getContext(this.a).getString(2131887289);
        L29:
            Intrinsics.checkNotNull(r17);
            com.bytedance.ee.util.ui.m.a(new r(this.a, r17));
            com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d.a(this.b, null, null, 0, 15);
            return Unit.INSTANCE;
        L28:
            r17 = DriveLocalFileMoreMenuPlugin.access$getContext(this.a).getString(2131887288) + c1.c(DriveLocalFileMoreMenuPlugin.access$getContext(this.a), r13);
            goto L29
        L25:
            com.larksuite.framework.utils.i.h(DriveLocalFileMoreMenuPlugin.access$getContext(this.a), r13, new Token(DriveLocalFileMoreMenuPlugin.SAVE_FILE_NOTIFY_SYSTEM));
        L21:
            e = move-exception;
            tt5.a.f("FileUtils", e, false);
        L6:
            r4 = "";
            goto L7
        }
    }

    public static final class f<T> implements Consumer {
        public static final f<T> a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Unit r2 = (Unit) r1;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ DriveLocalFileMoreMenuPlugin a;
        public final /* synthetic */ com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d b;

        public g(DriveLocalFileMoreMenuPlugin r1, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            com.bytedance.ee.util.ui.m.a(new s(this.a, this.b));
            tt5.a.f(AbsDriveMoreMenuPlugin.TAG, (Throwable) r4, false);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.more.AbsDriveMoreMenuPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveLocalFileMoreMenuPlugin() {
        this.compositeDisposable = new CompositeDisposable();
    }

    private final void initExportVisible() {
        Bundle r0 = getHost().c.getOpenEntity().getExtras();
        boolean r2 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        k75.a.i(getHost()).liveOuterExportVisible().postValue(Boolean.FALSE);
        return;
    L11:
        Iterator<BaseMoreMenuAction> r3 = getHost().c.getOpenEntity().getMoreMenuActions().iterator();
    L13:
        if (r3.hasNext() == false) goto L17;
        if ((r3.next() instanceof OpenExternalMenu) == false) goto L13;
        r2 = true;
        goto L13
    L17:
        k75.a.i(getHost()).liveOuterExportVisible().postValue(Boolean.valueOf(r2));
        return;
    L5:
        if (r0.getBoolean("archive_inner_file") != true) goto L7;
        r1 = true;
        goto L8
    }

    private final void initMenuActions() {
        if (isUIContainerAttached() == true) goto L5;
        return;
    L5:
        BaseOpenEntity r0 = ((DrivePluginHost) getHost()).c.getOpenEntity();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.drive.sdk.entity.open.LocalOpenEntity");
        LocalOpenEntity r1 = (LocalOpenEntity) r0;
        ArrayList r2 = new ArrayList();
        Boolean r3 = Boolean.TRUE;
        if (r3.equals(drivePreviewViewModel().liveInnerShowWPSPresentationAction().getValue()) == false) goto L9;
        r2.add(instancePresentationItem());
    L9:
        if (titleBarViewModel().getOutlineEnable().getValue() != r3) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L15;
        r2.add(createOutlineMenuItem());
    L15:
        if ((!hu5.a.d(r1.getMoreMenuActions())) == false) goto L17;
        r2.add(createMoreMenuItem(new b(this)));
    L17:
        DriveTitleBarVisibilityPlugin r5 = (DriveTitleBarVisibilityPlugin) findPlugin(DriveTitleBarVisibilityPlugin.class);
        if (r5 == null) goto L21;
        r5.updateMenuCount(hu5.a.c(r2));
    L21:
        if (hu5.a.d(r2) == false) goto L23;
        return;
    L23:
        showRightMenu(r2);
        return;
    L11:
        r4 = false;
        goto L12
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        initExportVisible();
        initMenuActions();
        k75.a.i(getHost()).liveInnerShowWPSPresentationAction().observe(getLifecycleOwner(), new c(this));
        titleBarViewModel().getOutlineEnable().observe(getLifecycleOwner(), new d(this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        this.compositeDisposable.clear();
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveLocalFileMoreMenuPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ CompositeDisposable access$getCompositeDisposable$p(DriveLocalFileMoreMenuPlugin r0) {
        return r0.compositeDisposable;
    }

    public static final /* synthetic */ Context access$getContext(DriveLocalFileMoreMenuPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.t access$getUIContainer(DriveLocalFileMoreMenuPlugin r0) {
        return r0.getUIContainer();
    }

    public static final /* synthetic */ void access$initMenuActions(DriveLocalFileMoreMenuPlugin r0) {
        r0.initMenuActions();
    }

    private final void openExternal(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r20) {
        if (isUIContainerDetached() == false) goto L5;
        return;
    L5:
        BaseOpenEntity r0 = getHost().c.getOpenEntity();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.drive.sdk.entity.open.LocalOpenEntity");
        LocalOpenEntity r1 = (LocalOpenEntity) r0;
        if (s55.a.a.k(new s55.e("DOWNLOAD", PermissionOperation.DOWNLOAD, 0, r1.getMountPoint(), r1.getFileId(), null, null, null, null, null, null, null, null, null, 32740), getContext()) == true) goto L10;
        tt5.a.h(AbsDriveMoreMenuPlugin.TAG, "handlePermission return false");
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d.a(r20, null, null, 0, 15);
        return;
    L10:
        if (CipherManager.d() != 1) goto L14;
        Toast.showText(eu5.b.a, 2131887290);
        tt5.a.h(AbsDriveMoreMenuPlugin.TAG, "CipherManager status is " + CipherManager.d());
        CipherManager.h();
        return;
    L14:
        if (TextUtils.isEmpty(r1.getFileId()) == true) goto L16;
        ((com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6)).k(r1.getAppId(), r1.getFileId(), Boolean.TRUE, r1.getThirdPartyAppID());
        ((zk5.a) org.koin.java.a.c(zk5.a.class, null, null, 6)).a(sbb.e.l.b, r1.getFileId(), "open_with_other_app");
    L16:
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d.a(r20, null, null, 0, 15);
        if (TextUtils.isEmpty(r1.getBizContentProviderAuthority()) == false) goto L19;
        tt5.a.h(AbsDriveMoreMenuPlugin.TAG, "local file openFile");
        FileUtils.I(getContext(), ay4.d.a().z(r1.getLocalFilePath()), "");
        return;
    L19:
        tt5.a.h(AbsDriveMoreMenuPlugin.TAG, "local file openFileWithAuthority");
        FileUtils.K(getContext(), ay4.d.a().z(r1.getLocalFilePath()), r1.getBizContentProviderAuthority());
    }

    private final void saveToLocalDefault(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r26) {
        if (isUIContainerDetached() == false) goto L5;
        return;
    L5:
        BaseOpenEntity r2 = getHost().c.getOpenEntity();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.drive.sdk.entity.open.LocalOpenEntity");
        LocalOpenEntity r7 = (LocalOpenEntity) r2;
        if (s55.a.a.k(new s55.e("DOWNLOAD", PermissionOperation.DOWNLOAD, 0, r7.getMountPoint(), r7.getFileId(), null, null, null, null, null, null, null, null, null, 32740), getContext()) == true) goto L10;
        tt5.a.h(AbsDriveMoreMenuPlugin.TAG, "handlePermissionUiAction return false");
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d.a(r26, null, null, 0, 15);
        auditDownload(getHost(), r7, false);
        return;
    L10:
        if (CipherManager.d() != 1) goto L13;
        Toast.showText(eu5.b.a, 2131887290);
        tt5.a.h(AbsDriveMoreMenuPlugin.TAG, "CipherManager status is " + CipherManager.d());
        CipherManager.h();
        auditDownload(getHost(), r7, false);
        return;
    L13:
        this.compositeDisposable.add(Flowable.just("").observeOn(fo5.d.b()).map(new e(this, r26)).observeOn(fo5.d.d()).subscribe(f.a, new g(this, r26)));
    }

    public static final /* synthetic */ void access$openExternal(DriveLocalFileMoreMenuPlugin r0, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r1) {
        r0.openExternal(r1);
    }

    public static final /* synthetic */ void access$saveToLocalDefault(DriveLocalFileMoreMenuPlugin r0, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r1) {
        r0.saveToLocalDefault(r1);
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveLocalFileMoreMenuPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }

    private final void auditDownload(DrivePluginHost r2, LocalOpenEntity r3, boolean r4) {
        doAuditDownload(r2, r3, r4);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        tt5.a.e(AbsDriveMoreMenuPlugin.TAG, "auditDownload() error", e, false);
    }

    private final void doAuditDownload(DrivePluginHost r10, LocalOpenEntity r11, boolean r12) {
        boolean r0 = com.bytedance.ee.bear.middleground.permission.audit.d.h();
        tt5.a.h(AbsDriveMoreMenuPlugin.TAG, "doAuditDownload() isSuccess=" + r12 + "， isDisableDriveDownload = " + r0 + ", openEntity.appId = " + r11.getAppId());
        if (r0 == true) goto L5;
    L10:
        w75.a r1 = r10.c.getFileModel();
        String r2 = "";
        if (r1 == null) goto L14;
        String r3 = r1.f;
        if (r3 == null) goto L14;
    L15:
        boolean r4 = i75.h.e(r3);
        boolean r5 = i75.h.n(r3);
        WikiInfo r6 = r10.c.getWikiInfo();
        w75.a r7 = r10.c.getFileModel();
        String r8 = null;
        if (r6 == null) goto L18;
        String r9 = r6.getWikiToken();
    L19:
        if (r6 == null) goto L21;
        String r13 = r6.getSpaceId();
    L22:
        dj5.a r14 = new dj5.a(r9, r13, null, 28);
        HostDocumentInfo r16 = r10.c.getOpenEntity().getHostDocumentInfo();
        if (r16 != null) goto L31;
        r16 = new HostDocumentInfo();
        BaseOpenEntity r17 = r10.c.getOpenEntity();
        if (r17 == null) goto L30;
        String r18 = r17.getFileId();
        if (r18 == null) goto L30;
        r2 = r18;
    L30:
        r16.setObjToken(r2);
        r16.setTitle(r10.c.getOpenEntity().getFileName());
    L31:
        com.bytedance.ee.bear.middleground_permission_export.model.c r19 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6);
        DriveData r20 = new DriveData();
        r20.setToken(r11.getFileId());
        if (y0.d(r11.getFileName()) == false) goto L38;
        if (r7 == null) goto L37;
        w75.b r21 = r7.c();
        if (r21 == null) goto L37;
        String r22 = r21.b;
    L39:
        r20.setName(r22);
        if (r7 == null) goto L43;
        String r23 = r7.a.f;
        if (r23 == null) goto L43;
    L48:
        r20.setMimeType(r23);
        r20.setAppId(r11.getAppId());
        r20.setAppFileId(r11.getFileId());
        r20.setImage(Boolean.valueOf(r4));
        r20.setVideo(Boolean.valueOf(r5));
        Unit r110 = Unit.INSTANCE;
        r19.i(r16, r14, r20, Boolean.valueOf(!r12));
        return;
    L43:
        if (r7 == null) goto L45;
        r8 = r7.r;
    L45:
        if (r8 != null) goto L47;
        r23 = r11.getMimeType();
        goto L48
    L47:
        r23 = r8;
    L37:
        r22 = null;
        goto L39
    L38:
        r22 = r11.getFileName();
        goto L39
    L21:
        r13 = null;
        goto L22
    L18:
        r9 = null;
    L14:
        r3 = "";
        goto L15
    L5:
        if (Intrinsics.areEqual(r11.getAppId(), "2") == false) goto L7;
    L8:
        tt5.a.h(AbsDriveMoreMenuPlugin.TAG, "doAuditDownload() audit disabled, appId=" + r11.getAppId());
        return;
    L7:
        if (Intrinsics.areEqual(r11.getAppId(), "56") == false) goto L10;
        goto L8
    }

    public static final /* synthetic */ void access$auditDownload(DriveLocalFileMoreMenuPlugin r0, DrivePluginHost r1, LocalOpenEntity r2, boolean r3) {
        r0.auditDownload(r1, r2, r3);
    }
}
