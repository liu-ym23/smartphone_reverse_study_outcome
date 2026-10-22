package com.bytedance.ee.bear.drive.biz.security;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.permission.DriveThirdPartyPermissionVM;
import com.bytedance.ee.bear.drive.biz.permission.model.ThirdPartyAttachmentPermission;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/security/DriveThirdPartyAntiScreenshotsPlugin;", "Lcom/bytedance/ee/bear/drive/biz/security/BaseAntiScreenshotsPlugin;", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "permissionObserver", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ee/bear/drive/biz/permission/model/ThirdPartyAttachmentPermission;", "escapeObserver", "", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveThirdPartyAntiScreenshotsPlugin extends BaseAntiScreenshotsPlugin {
    private final String TAG;
    private final Observer<Boolean> escapeObserver;
    private final Observer<ThirdPartyAttachmentPermission> permissionObserver;

    public static final class a<T> implements Observer {
        public final /* synthetic */ DriveThirdPartyAntiScreenshotsPlugin a;

        public a(DriveThirdPartyAntiScreenshotsPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            boolean r3 = ((Boolean) r2).booleanValue();
            this.a.getEscapePerm().postValue(Boolean.valueOf(r3));
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DriveThirdPartyAntiScreenshotsPlugin a;

        public b(DriveThirdPartyAntiScreenshotsPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            ThirdPartyAttachmentPermission r4 = (ThirdPartyAttachmentPermission) r3;
            if (r4 == null) goto L11;
            MutableLiveData<Boolean> r0 = this.a.getDriveCopyPerm();
            boolean r1 = true;
            if (r4.getCopy() == 1) goto L9;
            r1 = false;
        L9:
            r0.postValue(Boolean.valueOf(r1));
            return;
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.security.BaseAntiScreenshotsPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveThirdPartyAntiScreenshotsPlugin() {
        this.TAG = "DriveThirdPartyAntiScreenshotsPlugin@" + Integer.toHexString(hashCode());
        this.permissionObserver = new b(this);
        this.escapeObserver = new a(this);
    }

    @Override // com.bytedance.ee.bear.drive.biz.security.BaseAntiScreenshotsPlugin
    public String getTAG() {
        return this.TAG;
    }

    @Override // com.bytedance.ee.bear.drive.biz.security.BaseAntiScreenshotsPlugin
    public void onAttachToHost(DrivePluginHost r3) {
        super.onAttachToHost(r3);
        ((DriveThirdPartyPermissionVM) viewModel(DriveThirdPartyPermissionVM.class)).livePerm().observe(getLifecycleOwner(), this.permissionObserver);
        if (isOfflinePermissionScreenshot() == false) goto L5;
        ((DriveThirdPartyPermissionVM) viewModel(DriveThirdPartyPermissionVM.class)).liveOfflinePerm().observe(getLifecycleOwner(), this.permissionObserver);
    L5:
        ((DriveThirdPartyPermissionVM) viewModel(DriveThirdPartyPermissionVM.class)).liveCopyEscape().observe(getLifecycleOwner(), this.escapeObserver);
    }

    @Override // com.bytedance.ee.bear.drive.biz.security.BaseAntiScreenshotsPlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        super.onDetachFromHost(r2);
        ((DriveThirdPartyPermissionVM) viewModel(DriveThirdPartyPermissionVM.class)).livePerm().removeObserver(this.permissionObserver);
        if (isOfflinePermissionScreenshot() == false) goto L5;
        ((DriveThirdPartyPermissionVM) viewModel(DriveThirdPartyPermissionVM.class)).liveOfflinePerm().removeObserver(this.permissionObserver);
    L5:
        ((DriveThirdPartyPermissionVM) viewModel(DriveThirdPartyPermissionVM.class)).liveCopyEscape().removeObserver(this.escapeObserver);
    }

    @Override // com.bytedance.ee.bear.drive.biz.security.BaseAntiScreenshotsPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.biz.security.BaseAntiScreenshotsPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }
}
