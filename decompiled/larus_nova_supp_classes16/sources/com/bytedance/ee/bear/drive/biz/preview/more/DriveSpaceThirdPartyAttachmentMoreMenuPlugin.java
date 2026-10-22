package com.bytedance.ee.bear.drive.biz.preview.more;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderSaveCallback;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.drive.biz.encryption.DriveEncryptionVM;
import com.bytedance.ee.bear.drive.biz.permission.DriveThirdPartyPermissionVM;
import com.bytedance.ee.bear.drive.biz.permission.handler.PermissionOperation;
import com.bytedance.ee.bear.drive.biz.permission.model.ThirdPartyAttachmentPermission;
import com.bytedance.ee.bear.drive.biz.preview.more.download.im.DriveImFileDownloadVM;
import com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.SpaceFileDownloadManager;
import com.bytedance.ee.bear.drive.biz.preview.more.save2space.DriveImFileSaveToSpaceVM;
import com.bytedance.ee.bear.drive.biz.preview.titlebar.DriveTitleBarVisibilityPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToLocalMenu;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToLocalMenuV2;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.drive.preview.IDriveDownloadFilePlugin;
import com.bytedance.ee.drive.preview.IDriveThirdPartyTitleMenuPlugin;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.supervisor.token.Token;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001fB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0002J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/more/DriveSpaceThirdPartyAttachmentMoreMenuPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/more/AbsDriveMoreMenuPlugin;", "Lcom/bytedance/ee/drive/preview/IDriveDownloadFilePlugin;", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "Lcom/bytedance/ee/drive/preview/IDriveThirdPartyTitleMenuPlugin;", "<init>", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "onAttachToUIContainer", "", "host", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "enableShowMore", "", "permission", "Lcom/bytedance/ee/bear/drive/biz/permission/model/ThirdPartyAttachmentPermission;", "onDetachFromUIContainer", "downloadCurrentFile", "callback", "Lcom/bytedance/ee/drive/preview/IDriveDownloadFilePlugin$IDownloadCallback;", "showMore", "enableMore", "initMenuActions", "handleSaveToLocalMenu", "saveToLocalMenu", "Lcom/bytedance/ee/bear/drivesdk/plugin/model/menu/SaveToLocalMenu;", "actionWrapper", "Lcom/bytedance/ee/bear/contract/drive/sdk/entity/menu/MoreMenuActionWrapper;", "onDetachFromHost", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSpaceThirdPartyAttachmentMoreMenuPlugin extends AbsDriveMoreMenuPlugin implements IDriveDownloadFilePlugin<DrivePluginHost>, IDriveThirdPartyTitleMenuPlugin<DrivePluginHost> {
    public static final a Companion = null;
    public static final String SAVE_EMDIA_NOTIFY_SYSTEM = "LARK-PSDA-ccm_android_drive_third_party_save_media_notify_system";
    public static final String SAVE_FILE_NOTIFY_SYSTEM = "LARK-PSDA-ccm_android_drive_third_party_save_file_notify_system";
    private final CompositeDisposable compositeDisposable;
    private boolean enableMore;
    private boolean showMore;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ DriveSpaceThirdPartyAttachmentMoreMenuPlugin a;
        public final /* synthetic */ IDriveDownloadFilePlugin.a b;

        public static final class a implements SpaceFileDownloadManager.b {
            public final /* synthetic */ IDriveDownloadFilePlugin.a a;

            /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.more.DriveSpaceThirdPartyAttachmentMoreMenuPlugin$b$a$a, reason: collision with other inner class name */
            public static final class RunnableC0142a implements Runnable {
                public final /* synthetic */ IDriveDownloadFilePlugin.a a;
                public final /* synthetic */ IDriveDownloadFilePlugin.EDownloadResult b;

                public RunnableC0142a(IDriveDownloadFilePlugin.a r1, IDriveDownloadFilePlugin.EDownloadResult r2) {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(this.b);     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.more.DriveSpaceThirdPartyAttachmentMoreMenuPlugin$b$a$b, reason: collision with other inner class name */
            public /* synthetic */ class C0143b {
                public static final /* synthetic */ int[] a = null;

                static {
                    int[] r0 = new int[SpaceFileDownloadManager.EResult.values().length];
                    r0[SpaceFileDownloadManager.EResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
                L9:
                    r0[SpaceFileDownloadManager.EResult.USER_CANCELLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
                L5:
                    a = r0;
                }
            }

            public a(IDriveDownloadFilePlugin.a r1) {
                this.a = r1;
            }

            @Override // com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.SpaceFileDownloadManager.b
            public final void a(SpaceFileDownloadManager.EResult r3) {
                Intrinsics.checkNotNullParameter(r3, TipCallBackData.RESULT);
                int r4 = C0143b.a[r3.ordinal()];
                if (r4 != 1) goto L5;
                IDriveDownloadFilePlugin.EDownloadResult r5 = IDriveDownloadFilePlugin.EDownloadResult.SUCCESS;
            L9:
                com.bytedance.ee.util.ui.m.a(new RunnableC0142a(this.a, r5));
                return;
            L5:
                if (r4 == 2) goto L7;
                r5 = IDriveDownloadFilePlugin.EDownloadResult.FAILED;
                goto L9
            L7:
                r5 = IDriveDownloadFilePlugin.EDownloadResult.CANCELLED;
                goto L9
            }
        }

        public b(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r1, IDriveDownloadFilePlugin.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            Context r1 = DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$getContext(this.a);
            BaseOpenEntity r0 = this.a.getHost().c.getOpenEntity();
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity");
            SpaceFileDownloadManager r6 = new SpaceFileDownloadManager(r1, (BaseSpaceOpenEntity) r0, this.a.getHost().c.getFileModel(), new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d(null), this.a.getHost().b());
            IDriveDownloadFilePlugin.a r2 = this.b;
            if (r2 == null) goto L6;
            r6.f = new com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.c(new a(r2));
        L6:
            r6.c();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements com.bytedance.ee.bear.drive.biz.external.c.a {
        public final /* synthetic */ DriveSpaceThirdPartyAttachmentMoreMenuPlugin a;
        public final /* synthetic */ SaveToLocalMenu b;
        public final /* synthetic */ com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d c;
        public final /* synthetic */ long d;

        public static final class a implements Runnable {
            public final /* synthetic */ DriveSpaceThirdPartyAttachmentMoreMenuPlugin a;

            public a(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Toast.showSuccessText(DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$getContext(this.a), DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$getContext(this.a).getString(2131888447), 0);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public c(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r1, SaveToLocalMenu r2, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // com.bytedance.ee.bear.drive.biz.external.c.a
        public final void a(boolean r10, Uri r11) {
            if (r10 == true) goto L4;
        L10:
            com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d.a(this.c, null, null, this.d, 7);
            BinderSaveCallback r12 = this.b.p;
            if (r12 == null) goto L14;
            r12.onSaved(r10);
            return;
        L14:
            return;
        L4:
            if (DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$getContext(this.a) == null) goto L10;
            if (r11 == null) goto L10;
            com.bytedance.ee.util.ui.m.a(new a(this.a));
            if (this.b.o == false) goto L9;
            com.larksuite.framework.utils.i.i(DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$getContext(this.a), r11, new Token(DriveSpaceThirdPartyAttachmentMoreMenuPlugin.SAVE_EMDIA_NOTIFY_SYSTEM));
            goto L10
        L9:
            com.larksuite.framework.utils.i.h(DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$getContext(this.a), r11, new Token(DriveSpaceThirdPartyAttachmentMoreMenuPlugin.SAVE_FILE_NOTIFY_SYSTEM));
            goto L10
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ DriveSpaceThirdPartyAttachmentMoreMenuPlugin a;

        public static final class a implements com.bytedance.ee.bear.drive.biz.preview.more.a {
            public final /* synthetic */ DriveSpaceThirdPartyAttachmentMoreMenuPlugin a;

            /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.more.DriveSpaceThirdPartyAttachmentMoreMenuPlugin$d$a$a, reason: collision with other inner class name */
            public static final class RunnableC0144a implements Runnable {
                public final /* synthetic */ DriveSpaceThirdPartyAttachmentMoreMenuPlugin a;

                /* JADX INFO: Incorrect field signature: TT; */
                public final /* synthetic */ BaseMoreMenuAction b;

                /* JADX WARN: Incorrect types in method signature: (Lcom/bytedance/ee/bear/drive/biz/preview/more/DriveSpaceThirdPartyAttachmentMoreMenuPlugin;TT;)V */
                public RunnableC0144a(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r1, BaseMoreMenuAction r2) {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    DriveSpaceThirdPartyAttachmentMoreMenuPlugin r0 = this.a;     // Catch: Throwable -> L4
                    BaseMoreMenuAction r1 = this.b;     // Catch: Throwable -> L4
                    Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToLocalMenu");     // Catch: Throwable -> L4
                    DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$handleSaveToLocalMenu(r0, (SaveToLocalMenu) r1, new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d(this.b));     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            public a(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r1) {
                this.a = r1;
            }

            @Override // com.bytedance.ee.bear.drive.biz.preview.more.a
            public final <T extends BaseMoreMenuAction> void a(T r3) {
                Intrinsics.checkNotNullParameter(r3, "t");
                com.bytedance.ee.util.ui.m.a(new RunnableC0144a(this.a, r3));
            }
        }

        public static final class b implements com.bytedance.ee.bear.drive.biz.preview.more.a {
            public final /* synthetic */ DriveSpaceThirdPartyAttachmentMoreMenuPlugin a;

            public static final class a implements Runnable {
                public final /* synthetic */ DriveSpaceThirdPartyAttachmentMoreMenuPlugin a;

                /* JADX INFO: Incorrect field signature: TT; */
                public final /* synthetic */ BaseMoreMenuAction b;

                /* JADX WARN: Incorrect types in method signature: (Lcom/bytedance/ee/bear/drive/biz/preview/more/DriveSpaceThirdPartyAttachmentMoreMenuPlugin;TT;)V */
                public a(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r1, BaseMoreMenuAction r2) {
                    this.a = r1;
                    this.b = r2;
                }

                public final void a() {
                    Context r1 = DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$getContext(this.a);
                    BaseOpenEntity r0 = this.a.getHost().c.getOpenEntity();
                    Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity");
                    new SpaceFileDownloadManager(r1, (BaseSpaceOpenEntity) r0, this.a.getHost().c.getFileModel(), new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d(this.b), this.a.getHost().b()).c();
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a();     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            public b(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r1) {
                this.a = r1;
            }

            @Override // com.bytedance.ee.bear.drive.biz.preview.more.a
            public final <T extends BaseMoreMenuAction> void a(T r3) {
                Intrinsics.checkNotNullParameter(r3, "t");
                com.bytedance.ee.util.ui.m.a(new a(this.a, r3));
            }
        }

        public d(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            e65.a r0 = new e65.a(new e65.a.C0217a(this.a.getHost().c, (DriveImFileSaveToSpaceVM) DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$viewModel(this.a, DriveImFileSaveToSpaceVM.class), (DriveImFileDownloadVM) DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$viewModel(this.a, DriveImFileDownloadVM.class)));
            FragmentActivity r1 = DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$getActivity(this.a);
            DriveSpaceThirdPartyAttachmentMoreMenuPlugin r2 = this.a;
            com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b.a r6 = new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b.a(r1, r2, DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$getUIContainer(r2));
            CompositeDisposable r3 = DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$getCompositeDisposable$p(this.a);
            Intrinsics.checkNotNullParameter(r3, "disposable");
            r6.d = r3;
            com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r4 = new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b(r6);
            com.bytedance.ee.bear.drive.biz.preview.more.b r7 = new com.bytedance.ee.bear.drive.biz.preview.more.b(DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$getActivity(this.a), r0, r4);
            r7.c(this.a.getHost().b());
            if (AppInfoUtils.e().booleanValue() == true) goto L5;
            r7.d();
        L5:
            r7.h(SaveToLocalMenu.class, new a(this.a));
            r7.h(SaveToLocalMenuV2.class, new b(this.a));
            r7.d.a();
            r7.d.q();
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ DriveSpaceThirdPartyAttachmentMoreMenuPlugin a;
        public final /* synthetic */ LiveData<ThirdPartyAttachmentPermission> b;

        public e(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r1, LiveData<ThirdPartyAttachmentPermission> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            ConnectionService.NetworkState r4 = (ConnectionService.NetworkState) r3;
            DriveSpaceThirdPartyAttachmentMoreMenuPlugin r0 = this.a;
            DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$setShowMore$p(r0, DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$enableShowMore(r0, (ThirdPartyAttachmentPermission) this.b.getValue()));
            DriveSpaceThirdPartyAttachmentMoreMenuPlugin r1 = this.a;
            if (r4 == null) goto L7;
            boolean r2 = true;
            if (r4.a() != true) goto L7;
        L8:
            DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$setEnableMore$p(r1, r2);
            DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$initMenuActions(this.a);
            return;
        L7:
            r2 = false;
            goto L8
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ DriveSpaceThirdPartyAttachmentMoreMenuPlugin a;

        public f(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            DriveSpaceThirdPartyAttachmentMoreMenuPlugin r0 = this.a;
            DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$setShowMore$p(r0, DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$enableShowMore(r0, (ThirdPartyAttachmentPermission) r3));
            DriveSpaceThirdPartyAttachmentMoreMenuPlugin r4 = this.a;
            com.bytedance.ee.bear.contract.j r1 = com.bytedance.ee.bear.contract.j.a.a;
            if (r1 == null) goto L7;
            boolean r2 = true;
            if (r1.getNetworkState().a() != true) goto L7;
        L8:
            DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$setEnableMore$p(r4, r2);
            DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$initMenuActions(this.a);
            return;
        L7:
            r2 = false;
            goto L8
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ DriveSpaceThirdPartyAttachmentMoreMenuPlugin a;

        public g(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ DriveSpaceThirdPartyAttachmentMoreMenuPlugin a;

        public h(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ DriveSpaceThirdPartyAttachmentMoreMenuPlugin a;

        public i(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DriveSpaceThirdPartyAttachmentMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.more.AbsDriveMoreMenuPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveSpaceThirdPartyAttachmentMoreMenuPlugin() {
        this.compositeDisposable = new CompositeDisposable();
    }

    private final void initMenuActions() {
        if (isUIContainerAttached() == true) goto L6;
        return;
    L6:
        if ((!((DriveEncryptionVM) viewModel(DriveEncryptionVM.class)).isEncryptionKeyDeleted()) == true) goto L9;
        tt5.a.h("DriveComponent", "DriveSpaceThirdPartyAttachmentMoreMenuPlugin#initMenuActions() block!");
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
        MenuItem r2 = createMoreMenuItem(new d(this));
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

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ CompositeDisposable access$getCompositeDisposable$p(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r0) {
        return r0.compositeDisposable;
    }

    public static final /* synthetic */ Context access$getContext(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.t access$getUIContainer(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r0) {
        return r0.getUIContainer();
    }

    public static final /* synthetic */ void access$initMenuActions(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r0) {
        r0.initMenuActions();
    }

    private final boolean enableShowMore(ThirdPartyAttachmentPermission r5) {
        if (r5 == null) goto L9;
        ThirdPartyAttachmentPermission.PermissionV2 r3 = r5.getPermV2();
        if (r3 == null) goto L9;
        if (r3.getExport() != 2002) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L26;
        if (r5 == null) goto L17;
        ThirdPartyAttachmentPermission.PermissionV2 r6 = r5.getPermV2();
        if (r6 == null) goto L17;
        if (r6.getCopy() != 2002) goto L17;
        boolean r0 = true;
    L18:
        if (r0 == true) goto L27;
        if (r5 != null) goto L22;
    L24:
        return false;
    L22:
        if (r5.getExport() != 1) goto L24;
        return true;
    L27:
        return true;
    L17:
        r0 = false;
        goto L18
    L26:
        return true;
    L9:
        r4 = false;
        goto L10
    }

    @Override // com.bytedance.ee.drive.preview.IDriveDownloadFilePlugin
    public void downloadCurrentFile(IDriveDownloadFilePlugin.a r2) {
        com.bytedance.ee.util.ui.m.a(new b(this, r2));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ boolean access$enableShowMore(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r0, ThirdPartyAttachmentPermission r1) {
        return r0.enableShowMore(r1);
    }

    public static final /* synthetic */ void access$setEnableMore$p(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r0, boolean r1) {
        r0.enableMore = r1;
    }

    public static final /* synthetic */ void access$setShowMore$p(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r0, boolean r1) {
        r0.showMore = r1;
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }

    private final void handleSaveToLocalMenu(SaveToLocalMenu r24, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r26) {
        if (isUIContainerDetached() == false) goto L5;
        return;
    L5:
        DrivePluginHost r0 = getHost();
        String r1 = null;
        if (r0 == null) goto L10;
        DriveViewModel r2 = r0.c;
        if (r2 == null) goto L10;
        BaseOpenEntity r3 = r2.getOpenEntity();
    L11:
        PermissionOperation r9 = PermissionOperation.DOWNLOAD;
        if (r3 == null) goto L14;
        String r11 = r3.getMountPoint();
    L15:
        if (r3 == null) goto L18;
        r1 = r3.getFileId();
    L18:
        if (s55.a.a.k(new s55.e("DOWNLOAD", r9, 0, r11, r1, null, null, null, null, null, null, null, null, null, 32740), getContext()) == true) goto L24;
        tt5.a.h(AbsDriveMoreMenuPlugin.TAG, "handlePermissionUiAction return false");
        BinderSaveCallback r4 = r24.p;
        if (r4 == null) goto L22;
        r4.onSaved(false);
    L22:
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d.a(r26, null, null, 0, 15);
        return;
    L24:
        com.bytedance.ee.bear.drive.biz.external.f r7 = com.bytedance.ee.bear.drive.biz.external.f.e(getHost().c.getBizType(), getContext(), getHost().b());
        w75.c r5 = getHost().c.getIFileModel();
        if (r5 == null) goto L31;
        w75.a r6 = r5.getDetails();
        if (r6 == null) goto L31;
        w75.b r8 = r6.c();
        if (r8 == null) goto L31;
        long r10 = r8.c;
    L32:
        long r12 = r10;
        com.bytedance.ee.bear.drive.biz.external.c r13 = new com.bytedance.ee.bear.drive.biz.external.c(new c(this, r24, r26, r12));
        com.bytedance.ee.bear.drive.biz.external.a.C0122a r14 = new com.bytedance.ee.bear.drive.biz.external.a.C0122a();
        r14.b = r12;
        r14.a = getHost().c.getOpenEntity().getFileId();
        r14.c = getHost().c.getOpenEntity().getApiExtra();
        r14.d = getHost().c.getOpenEntity().getMountPoint();
        r14.e = getHost().c.getOpenEntity().getDownloadFrom();
        r14.f = getHost().c.getOpenEntity().getBizScene();
        r14.g = getHost().c.getOpenEntity().getWatermarkScene();
        r7.g(new com.bytedance.ee.bear.drive.biz.external.a(r14), r13, r24.m);
        return;
    L31:
        r10 = 0;
        goto L32
    L14:
        r11 = null;
    L10:
        r3 = null;
        goto L11
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.more.AbsDriveMoreMenuPlugin
    public void onAttachToUIContainer(DrivePluginHost r3, com.bytedance.ee.bear.browser.plugin.t r4) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r4, "uiContainer");
        super.onAttachToUIContainer(r3, r4);
        LiveData<ThirdPartyAttachmentPermission> r5 = ((DriveThirdPartyPermissionVM) viewModel(DriveThirdPartyPermissionVM.class)).livePerm();
        k75.a.h(this, new e(this, r5));
        r5.observe(getLifecycleOwner(), new f(this));
        k75.a.i(r3).liveInnerShowWPSPresentationAction().observe(getLifecycleOwner(), new g(this));
        titleBarViewModel().getOutlineEnable().observe(getLifecycleOwner(), new h(this));
        ((DriveEncryptionVM) viewModel(DriveEncryptionVM.class)).getEncryptionKeyDeleted().observe(getLifecycleOwner(), new i(this));
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

    public static final /* synthetic */ void access$handleSaveToLocalMenu(DriveSpaceThirdPartyAttachmentMoreMenuPlugin r0, SaveToLocalMenu r1, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r2) {
        r0.handleSaveToLocalMenu(r1, r2);
    }
}
