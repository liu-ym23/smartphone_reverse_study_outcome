package com.bytedance.ee.bear.drive.biz.wps.edit;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.biz.permission.model.DrivePermissionInfoViewModel;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.view.preview.wps.WpsViewModel;
import com.bytedance.ee.bear.drive.view.preview.wps.c;
import com.bytedance.ee.bear.rn.RnPushProtocol;
import kotlin.Metadata;
import u55.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/wps/edit/DriveSpaceWPSEditPlugin;", "Lcom/bytedance/ee/bear/drive/biz/wps/edit/DriveBaseWPSEditPlugin;", "<init>", "()V", "mMemoryOverPush", "Lcom/bytedance/ee/bear/drive/view/preview/wps/DriveWpsMemoryOverPush;", "isEditable", "", "onAttachToHost", "", "pluginHost", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSpaceWPSEditPlugin extends DriveBaseWPSEditPlugin {
    private c mMemoryOverPush;

    public static final class a<T> implements Observer {
        public final /* synthetic */ DriveSpaceWPSEditPlugin a;

        public a(DriveSpaceWPSEditPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            b r5 = (b) r4;
            if (r5 == null) goto L6;
            DriveSpaceWPSEditPlugin r0 = this.a;
            tt5.a.h(DriveBaseWPSEditPlugin.TAG, "permission changed... token=" + du5.b.g(r5.a) + ", canEdit=" + r5.c() + ", isOwner=" + r5.k());
            ((DrivePermissionInfoViewModel) DriveSpaceWPSEditPlugin.access$viewModel(r0, DrivePermissionInfoViewModel.class)).getLiveInnerFilePermissionChanged().postValue(r5);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.wps.edit.DriveBaseWPSEditPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.wps.edit.DriveBaseWPSEditPlugin
    public boolean isEditable() {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.g("spacekit.mobile.drive_wps_edit_enable");
        boolean r1 = getHost().c.isHistoryMode();
        if (r0 == false) goto L6;
        if (r1 == true) goto L6;
        return true;
    L6:
        return false;
    }

    public DriveSpaceWPSEditPlugin() {
    }

    @Override // com.bytedance.ee.bear.drive.biz.wps.edit.DriveBaseWPSEditPlugin
    public void onAttachToHost(DrivePluginHost r3) {
        super.onAttachToHost(r3);
        if (isEditable() == false) goto L5;
        c r4 = new c(getHost().c.getFileId(), (WpsViewModel) viewModel(WpsViewModel.class));
        this.mMemoryOverPush = r4;
        r4.a();
    L5:
        ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().observe(getLifecycleOwner(), new a(this));
    }

    @Override // com.bytedance.ee.bear.drive.biz.wps.edit.DriveBaseWPSEditPlugin
    public void onDetachFromHost(DrivePluginHost r1) {
        super.onDetachFromHost(r1);
        c r2 = this.mMemoryOverPush;
        if (r2 == null) goto L7;
        RnPushProtocol r3 = r2.c;
        if (r3 == null) goto L7;
        r3.a();
    L7:
        this.mMemoryOverPush = null;
    }

    @Override // com.bytedance.ee.bear.drive.biz.wps.edit.DriveBaseWPSEditPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.biz.wps.edit.DriveBaseWPSEditPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveSpaceWPSEditPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }
}
