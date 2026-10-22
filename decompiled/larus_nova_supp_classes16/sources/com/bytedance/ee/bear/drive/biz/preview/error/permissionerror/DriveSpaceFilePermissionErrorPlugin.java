package com.bytedance.ee.bear.drive.biz.preview.error.permissionerror;

import android.R;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.banner.DriveBannerPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView;
import com.bytedance.ee.bear.middleground.permission.foridden.ComplaintState;
import com.bytedance.ee.bear.middleground_permission_export.model.forbidden.GetComplaintResult;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0018\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/permissionerror/DriveSpaceFilePermissionErrorPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "Lcom/bytedance/ee/bear/facade/common/ActivityResultHandler;", "<init>", "()V", "SEND_COMPLAINT_REQUEST_CODE", "", "isForbidden", "", "isDlpUploadControl", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "getReplaceId", "getFragmentManger", "Landroidx/fragment/app/FragmentManager;", "checkContainerId", "containerId", "handleForbidden", "isUpdate", "onDetachFromHost", "onResume", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "isEnableForsetiFragmentManager", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSpaceFilePermissionErrorPlugin extends AbsDrivePreviewPlugin implements sa5.a {
    public static final a Companion = null;
    public static final String FG_FORSETI_FRAGMENT_MANAGER = "ccm.mobile.drive.forseti_fragment_manager";
    public static final String TAG = "DriveSpaceFilePermissionErrorPlugin";
    private final int SEND_COMPLAINT_REQUEST_CODE;
    private boolean isDlpUploadControl;
    private boolean isForbidden;
    private final CompositeDisposable mCompositeDisposable;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ DriveSpaceFilePermissionErrorPlugin a;
        public final /* synthetic */ boolean b;

        public b(DriveSpaceFilePermissionErrorPlugin r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            int r5 = ((GetComplaintResult) r4).getResult();
            if (r5 != ComplaintState.IN_THE_COMPLAINT.getResult()) goto L8;
            DriveBannerPlugin r6 = (DriveBannerPlugin) DriveSpaceFilePermissionErrorPlugin.access$findPlugin(this.a, DriveBannerPlugin.class);
            if (r6 == null) goto L21;
            r6.showForbiddenBanner(true, ForbiddenBannerView.ForbiddenState.IN_COMPLAINT, this.b);
            return;
        L21:
            return;
        L8:
            if (r5 != ComplaintState.COMPLAINT_FAIL.getResult()) goto L13;
            DriveBannerPlugin r7 = (DriveBannerPlugin) DriveSpaceFilePermissionErrorPlugin.access$findPlugin(this.a, DriveBannerPlugin.class);
            if (r7 == null) goto L23;
            r7.showForbiddenBanner(true, ForbiddenBannerView.ForbiddenState.COMPLAINT_FAIL, this.b);
            return;
        L23:
            return;
        L13:
            if (r5 != ComplaintState.COMPLAINT_SUCCESS.getResult()) goto L17;
            DriveBannerPlugin r8 = (DriveBannerPlugin) DriveSpaceFilePermissionErrorPlugin.access$findPlugin(this.a, DriveBannerPlugin.class);
            if (r8 == null) goto L25;
            r8.showForbiddenBanner(false, ForbiddenBannerView.ForbiddenState.COMPLAINT_SUCCESS, this.b);
            return;
        L25:
            return;
        L17:
            DriveBannerPlugin r9 = (DriveBannerPlugin) DriveSpaceFilePermissionErrorPlugin.access$findPlugin(this.a, DriveBannerPlugin.class);
            if (r9 == null) goto L27;
            r9.showForbiddenBanner(true, ForbiddenBannerView.ForbiddenState.WARNING, this.b);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ DriveSpaceFilePermissionErrorPlugin a;
        public final /* synthetic */ boolean b;

        public c(DriveSpaceFilePermissionErrorPlugin r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            if (ax4.d.b(r5, 3) == false) goto L8;
            DriveBannerPlugin r6 = (DriveBannerPlugin) DriveSpaceFilePermissionErrorPlugin.access$findPlugin(this.a, DriveBannerPlugin.class);
            if (r6 == null) goto L36;
            r6.showForbiddenBanner(true, ForbiddenBannerView.ForbiddenState.WARNING, this.b);
            return;
        L36:
            return;
        L8:
            if (ax4.d.b(r5, 10004) == false) goto L13;
            DriveBannerPlugin r7 = (DriveBannerPlugin) DriveSpaceFilePermissionErrorPlugin.access$findPlugin(this.a, DriveBannerPlugin.class);
            if (r7 == null) goto L38;
            r7.showForbiddenBanner(true, ForbiddenBannerView.ForbiddenState.COMPLAINT_EXCEED_LIMITS_DAY, this.b);
            return;
        L38:
            return;
        L13:
            if (ax4.d.b(r5, 10005) == false) goto L18;
            DriveBannerPlugin r8 = (DriveBannerPlugin) DriveSpaceFilePermissionErrorPlugin.access$findPlugin(this.a, DriveBannerPlugin.class);
            if (r8 == null) goto L40;
            r8.showForbiddenBanner(true, ForbiddenBannerView.ForbiddenState.COMPLAINT_EXCEED_LIMITS, this.b);
            return;
        L40:
            return;
        L18:
            if (ax4.d.b(r5, 10008) == false) goto L23;
            DriveBannerPlugin r9 = (DriveBannerPlugin) DriveSpaceFilePermissionErrorPlugin.access$findPlugin(this.a, DriveBannerPlugin.class);
            if (r9 == null) goto L42;
            r9.showForbiddenBanner(true, ForbiddenBannerView.ForbiddenState.COMPLAINT_FAIL, this.b);
            return;
        L42:
            return;
        L23:
            if (ax4.d.b(r5, 10000) == false) goto L28;
            DriveBannerPlugin r10 = (DriveBannerPlugin) DriveSpaceFilePermissionErrorPlugin.access$findPlugin(this.a, DriveBannerPlugin.class);
            if (r10 == null) goto L44;
            r10.showForbiddenBanner(true, ForbiddenBannerView.ForbiddenState.WARNING, this.b);
            return;
        L44:
            return;
        L28:
            if (ax4.d.b(r5, 10001) == false) goto L32;
            DriveBannerPlugin r11 = (DriveBannerPlugin) DriveSpaceFilePermissionErrorPlugin.access$findPlugin(this.a, DriveBannerPlugin.class);
            if (r11 == null) goto L46;
            r11.showForbiddenBanner(true, ForbiddenBannerView.ForbiddenState.IN_COMPLAINT, this.b);
            return;
        L46:
            return;
        L32:
            DriveBannerPlugin r12 = (DriveBannerPlugin) DriveSpaceFilePermissionErrorPlugin.access$findPlugin(this.a, DriveBannerPlugin.class);
            if (r12 == null) goto L48;
            r12.showForbiddenBanner(true, ForbiddenBannerView.ForbiddenState.WARNING, this.b);
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DriveSpaceFilePermissionErrorPlugin a;
        public final /* synthetic */ DrivePluginHost b;

        public d(DriveSpaceFilePermissionErrorPlugin r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r10) {
            u55.b r2 = (u55.b) r10;
            FragmentManager r1 = DriveSpaceFilePermissionErrorPlugin.access$getFragmentManger(this.a);
            if (r1 == null) goto L42;
            int r4 = DriveSpaceFilePermissionErrorPlugin.access$getReplaceId(this.a);
            tt5.a.h("DriveComponent", "DriveSpaceFilePermissionErrorPlugin  fm=" + r1 + " replaceId=" + r4);
            if (r2 == null) goto L37;
            DrivePluginHost r11 = this.b;
            DriveSpaceFilePermissionErrorPlugin r0 = this.a;
            if (r11 == null) goto L12;
            DriveViewModel r3 = r11.c;
            if (r3 == null) goto L12;
            r3.setCanRead(r2.e());
        L12:
            DriveSpaceFilePermissionErrorPlugin.access$setDlpUploadControl$p(r0, r2.i());
            if (r2.e() == true) goto L15;
        L30:
            r11.c.setIsAdminPerceiveControl(r2.h());
            ((DriveMGPermissionVM) DriveSpaceFilePermissionErrorPlugin.access$viewModel(r0, DriveMGPermissionVM.class)).setNoPermission(true);
            DriveSpaceFilePermissionErrorPlugin.access$removePreviewView(r0);
            int r5 = com.bytedance.ee.bear.drive.biz.permission.c.a;
            com.bytedance.ee.bear.drive.biz.preview.error.permissionerror.a r6 = new com.bytedance.ee.bear.drive.biz.preview.error.permissionerror.a(r0, r11);
            boolean r7 = true ^ r11.c.isVCFollowMode();
            w75.c r8 = r11.c.getIFileModel();
            if (r8 == null) goto L34;
            String r9 = r8.I();
            if (r9 == null) goto L34;
        L35:
            com.bytedance.ee.bear.drive.biz.permission.c.a.b(r0, r1, r2, r6, r4, r7, r9, r11.c.isVCFollowMode());
            o75.b.a().H7().a();
            int r12 = com.bytedance.ee.bear.drive.biz.cache.a.a;
            com.bytedance.ee.bear.drive.biz.cache.a.C0118a.b(r11.c, null, r11.b());
            return;
        L34:
            r9 = "";
            goto L35
        L15:
            if (r2.j() == true) goto L30;
            r11.c.setIsAdminPerceiveControl(r2.h());
            if (((DriveMGPermissionVM) DriveSpaceFilePermissionErrorPlugin.access$viewModel(r0, DriveMGPermissionVM.class)).isNoPermission() == false) goto L26;
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            jg5.e r13 = jg5.e.a.a;
            int r14 = com.bytedance.ee.bear.middleground.permission.b.a;
            if (com.bytedance.ee.bear.appsetting.c.a.a.f("spacekit.mobile.doc_monitor_permission_by_mailbox") == false) goto L26;
            ((DriveMGPermissionVM) DriveSpaceFilePermissionErrorPlugin.access$viewModel(r0, DriveMGPermissionVM.class)).setNoPermission(false);
            tt5.a.h(DriveSpaceFilePermissionErrorPlugin.TAG, "onAttachToHost enter restore frg");
            Fragment r16 = r1.findFragmentById(DriveSpaceFilePermissionErrorPlugin.access$checkContainerId(r0, r4));
            if (r16 == null) goto L24;
            r1.beginTransaction().remove(r16).commitAllowingStateLoss();
        L24:
            r11.c().load();
            return;
        L26:
            if (r2.k() == true) goto L28;
            return;
        L28:
            if (r2.f() != 10013) goto L40;
            DriveSpaceFilePermissionErrorPlugin.access$setForbidden$p(r0, true);
            DriveSpaceFilePermissionErrorPlugin.access$handleForbidden(r0, false);
            return;
        L40:
            return;
        L37:
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ DriveSpaceFilePermissionErrorPlugin a;
        public final /* synthetic */ DrivePluginHost b;

        public e(DriveSpaceFilePermissionErrorPlugin r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            if (((Boolean) r3).booleanValue() == true) goto L5;
            return;
        L5:
            if (DriveSpaceFilePermissionErrorPlugin.access$isDlpUploadControl$p(this.a) == false) goto L15;
            tt5.a.h(DriveSpaceFilePermissionErrorPlugin.TAG, "isDlpUploadControl enter");
            FragmentManager r4 = DriveSpaceFilePermissionErrorPlugin.access$getFragmentManger(this.a);
            if (r4 == null) goto L16;
            int r0 = DriveSpaceFilePermissionErrorPlugin.access$getReplaceId(this.a);
            Fragment r1 = r4.findFragmentById(DriveSpaceFilePermissionErrorPlugin.access$checkContainerId(this.a, r0));
            if (r1 == null) goto L12;
            r4.beginTransaction().remove(r1).commitAllowingStateLoss();
        L12:
            this.b.c().load();
            return;
        L16:
            return;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ DriveSpaceFilePermissionErrorPlugin a;

        public f(DriveSpaceFilePermissionErrorPlugin r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DriveMGPermissionVM.fetchPermission$default((DriveMGPermissionVM) DriveSpaceFilePermissionErrorPlugin.access$viewModel(this.a, DriveMGPermissionVM.class), k75.a.d(this.a), null, 2, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    private final int checkContainerId(int r2) {
        if (r2 != (-1)) goto L6;
        return R.id.content;
    L6:
        return r2;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveSpaceFilePermissionErrorPlugin() {
        this.SEND_COMPLAINT_REQUEST_CODE = 1;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    private final FragmentManager getFragmentManger() {
        Fragment r0 = getLifecycleOwner();
        if (r0 == null) goto L5;
        FragmentManager r1 = r0.getParentFragmentManager();
    L7:
        if (isUIContainerDetached() == true) goto L25;
        if (r1 == null) goto L25;
        if (isEnableForsetiFragmentManager() == false) goto L17;
        Fragment r2 = ForsetiHelper.g(getHost().getHostFragment());
        if (r2 == null) goto L17;
        return r2.getChildFragmentManager();
    L17:
        if (AppInfoUtils.f().booleanValue() == false) goto L21;
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L21;
        return r1;
    L21:
        if (getHost().c.isVCFollowMode() == false) goto L24;
        return r1;
    L24:
        return getActivity().getSupportFragmentManager();
    L25:
        tt5.a.d("DriveComponent", "DriveSpaceFilePermissionErrorPlugin isUIContainerDetached=" + isUIContainerDetached());
        return null;
    L5:
        r1 = null;
        goto L7
    }

    private final int getReplaceId() {
        if (AppInfoUtils.f().booleanValue() == false) goto L7;
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L7;
    L12:
        return 2131370283;
    L7:
        if (getHost().c.isVCFollowMode() == true) goto L12;
        if (isEnableForsetiFragmentManager() == true) goto L12;
        return -1;
    }

    private final boolean isEnableForsetiFragmentManager() {
        DrivePluginHost r0 = getHost();
        if (r0 == null) goto L5;
        Fragment r1 = r0.getHostFragment();
    L7:
        if (ForsetiHelper.s(r1) == true) goto L9;
    L11:
        return false;
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.drive.forseti_fragment_manager") == false) goto L11;
        return true;
    L5:
        r1 = null;
        goto L7
    }

    public static final /* synthetic */ FragmentManager access$getFragmentManger(DriveSpaceFilePermissionErrorPlugin r0) {
        return r0.getFragmentManger();
    }

    public static final /* synthetic */ int access$getReplaceId(DriveSpaceFilePermissionErrorPlugin r0) {
        return r0.getReplaceId();
    }

    public static final /* synthetic */ boolean access$isDlpUploadControl$p(DriveSpaceFilePermissionErrorPlugin r0) {
        return r0.isDlpUploadControl;
    }

    public static final /* synthetic */ boolean access$isUIContainerDetached(DriveSpaceFilePermissionErrorPlugin r0) {
        return r0.isUIContainerDetached();
    }

    public static final /* synthetic */ void access$removePreviewView(DriveSpaceFilePermissionErrorPlugin r0) {
        r0.removePreviewView();
    }

    private final void handleForbidden(boolean r6) {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.platform.appeal_v2");
        this.mCompositeDisposable.add(((com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a.class, null, null, 6)).d(12, k75.a.d(this), r0).subscribe(new b(this, r6), new c(this, r6)));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().observe(getLifecycleOwner(), new d(this, r4));
        ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).liveHardDelete().observe(getLifecycleOwner(), new e(this, r4));
        addErrorHandler(new f(this), new ErrCode[]{ErrCode.PERMISSION_DENIED});
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        this.mCompositeDisposable.clear();
    }

    public void onResume(DrivePluginHost r1) {
        super.onResume(r1);
        if (this.isForbidden == false) goto L6;
        handleForbidden(false);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onResume(PluginHost r1) {
        onResume((DrivePluginHost) r1);
    }

    public static final /* synthetic */ int access$checkContainerId(DriveSpaceFilePermissionErrorPlugin r0, int r1) {
        return r0.checkContainerId(r1);
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$findPlugin(DriveSpaceFilePermissionErrorPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ void access$handleForbidden(DriveSpaceFilePermissionErrorPlugin r0, boolean r1) {
        r0.handleForbidden(r1);
    }

    public static final /* synthetic */ void access$setDlpUploadControl$p(DriveSpaceFilePermissionErrorPlugin r0, boolean r1) {
        r0.isDlpUploadControl = r1;
    }

    public static final /* synthetic */ void access$setForbidden$p(DriveSpaceFilePermissionErrorPlugin r0, boolean r1) {
        r0.isForbidden = r1;
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveSpaceFilePermissionErrorPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }

    @Override // sa5.a
    public void onActivityResult(int r3, int r4, Intent r5) {
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.drive.mobile.forbidden", true) == true) goto L5;
        return;
    L5:
        if (r3 == this.SEND_COMPLAINT_REQUEST_CODE) goto L7;
        return;
    L7:
        if (r4 != (-1)) goto L12;
        handleForbidden(true);
        return;
    }
}
