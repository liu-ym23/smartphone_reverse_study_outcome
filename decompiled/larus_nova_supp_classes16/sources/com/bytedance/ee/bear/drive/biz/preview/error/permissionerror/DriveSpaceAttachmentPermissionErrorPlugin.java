package com.bytedance.ee.bear.drive.biz.preview.error.permissionerror;

import android.R;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.security.DlpUploadAction;
import com.bytedance.ee.bear.drive.biz.permission.DriveSpaceAttachmentMGPermissionVM;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.larus.apm.impl.protector.RunnableProtector;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0002¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/permissionerror/DriveSpaceAttachmentPermissionErrorPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "getReplaceId", "", "getReplaceFragmentManager", "Landroidx/fragment/app/FragmentManager;", "handleNoPermission", "handleDlpCheckResult", JSEventListener.ACTION, "Lcom/bytedance/ee/bear/document/security/DlpUploadAction;", "reload", "replaceId", "fm", "checkContainerId", "containerId", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSpaceAttachmentPermissionErrorPlugin extends AbsDrivePreviewPlugin {
    public static final a Companion = null;
    public static final String TAG = "DriveSpaceAttachmentPermissionErrorPlugin";

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ DriveSpaceAttachmentPermissionErrorPlugin a;

        public b(DriveSpaceAttachmentPermissionErrorPlugin r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DriveSpaceAttachmentPermissionErrorPlugin.access$handleNoPermission(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ DriveSpaceAttachmentPermissionErrorPlugin a;

        public c(DriveSpaceAttachmentPermissionErrorPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            u55.b r3 = (u55.b) r2;
            if (r3 == null) goto L8;
            DriveSpaceAttachmentPermissionErrorPlugin r0 = this.a;
            if (r3.e() == true) goto L9;
            DriveSpaceAttachmentPermissionErrorPlugin.access$handleNoPermission(r0);
            return;
        L9:
            return;
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

    private final FragmentManager getReplaceFragmentManager() {
        Fragment r0 = getLifecycleOwner();
        if (r0 == null) goto L5;
        FragmentManager r1 = r0.getParentFragmentManager();
    L7:
        if (isUIContainerDetached() == true) goto L15;
        if (r1 == null) goto L15;
        if (getHost().c.isVCFollowMode() == false) goto L14;
        return r1;
    L14:
        return getActivity().getSupportFragmentManager();
    L15:
        tt5.a.d("DriveComponent", "getReplaceFragmentManager isUIContainerDetached=" + isUIContainerDetached());
        return null;
    L5:
        r1 = null;
        goto L7
    }

    private final int getReplaceId() {
        if (getHost().c.isVCFollowMode() == false) goto L5;
        return 2131370283;
    L5:
        return -1;
    }

    private final void handleNoPermission() {
        removePreviewView();
        FragmentManager r1 = getReplaceFragmentManager();
        if (r1 != null) goto L5;
        return;
    L5:
        int r4 = getReplaceId();
        String r6 = com.bytedance.ee.util.io.a.c(getHost().c.getFileName());
        boolean r7 = getHost().c.isVCFollowMode();
        u55.b r2 = (u55.b) ((DriveSpaceAttachmentMGPermissionVM) viewModel(DriveSpaceAttachmentMGPermissionVM.class)).livePerm().getValue();
        if (r2 != null) goto L8;
    L10:
        boolean r5 = false;
    L11:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.a.d() == false) goto L17;
        if (r2 == null) goto L17;
        if (r2.g() != 2004) goto L17;
        int r0 = com.bytedance.ee.bear.drive.biz.permission.c.a;
        com.bytedance.ee.bear.drive.biz.permission.c.a.b(this, r1, r2, null, r4, true, r6, r7);
    L18:
        int r3 = com.bytedance.ee.bear.drive.biz.cache.a.a;
        com.bytedance.ee.bear.drive.biz.cache.a.C0118a.b(getHost().c, null, getHost().b());
        return;
    L17:
        int r8 = com.bytedance.ee.bear.drive.biz.permission.c.a;
        com.bytedance.ee.bear.drive.biz.permission.c.a.c(r1, r4, true, r6, Boolean.valueOf(r7), r5, 64);
        goto L18
    L8:
        if (r2.b.a.isConditionAccessView() == false) goto L10;
        r5 = true;
        goto L11
    }

    public DriveSpaceAttachmentPermissionErrorPlugin() {
    }

    public static final /* synthetic */ void access$handleNoPermission(DriveSpaceAttachmentPermissionErrorPlugin r0) {
        r0.handleNoPermission();
    }

    public final void handleDlpCheckResult(DlpUploadAction r3) {
        Intrinsics.checkNotNullParameter(r3, JSEventListener.ACTION);
        tt5.a.h(TAG, "handleDlpCheckResult " + r3.b);
        if (TextUtils.isEmpty(r3.a) == false) goto L5;
        return;
    L5:
        if (r3.a.equals(getHost().c.getFileId()) == false) goto L11;
        FragmentManager r4 = getReplaceFragmentManager();
        int r0 = getReplaceId();
        if (r4 == null) goto L12;
        reload(r0, r4);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        addErrorHandler(new b(this), new ErrCode[]{ErrCode.PERMISSION_DENIED});
        ((DriveSpaceAttachmentMGPermissionVM) viewModel(DriveSpaceAttachmentMGPermissionVM.class)).livePerm().observe(getLifecycleOwner(), new c(this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    private final void reload(int r1, FragmentManager r2) {
        Fragment r3 = r2.findFragmentById(checkContainerId(r1));
        if (r3 == null) goto L5;
        r2.beginTransaction().remove(r3).commitAllowingStateLoss();
    L5:
        getHost().c().load();
    }
}
