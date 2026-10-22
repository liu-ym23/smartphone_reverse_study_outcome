package com.bytedance.ee.bear.drive.biz.preview.more.download.im;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b;
import com.bytedance.ee.bear.drive.biz.preview.more.save2space.DriveImFileSaveToSpaceVM;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveImFileDownloadPlugin extends BasePlugin<DrivePluginHost> {
    private Observer<com.bytedance.ee.bear.contract.drive.sdk.entity.menu.a> mObserver;

    public static /* synthetic */ void a(DriveImFileDownloadPlugin r0, DriveImFileDownloadVM r1, t r2, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.a r3) {
        r0.lambda$onAttachToUIContainer$0(r1, r2, r3);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveImFileDownloadPlugin() {
    }

    public void onAttachToUIContainer(DrivePluginHost r4, final t r5) {
        super.onAttachToUIContainer(r4, r5);
        final DriveImFileDownloadVM r0 = (DriveImFileDownloadVM) viewModel(DriveImFileDownloadVM.class);
        MutableLiveData<com.bytedance.ee.bear.contract.drive.sdk.entity.menu.a> r1 = r0.getLiveDownload();
        LifecycleOwner r6 = r4.getLifecycleOwner();
        Observer<com.bytedance.ee.bear.contract.drive.sdk.entity.menu.a> r2 = new a(this, r0, r5);
        this.mObserver = r2;
        r1.observe(r6, r2);
    }

    public void onDetachFromUIContainer(DrivePluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        if (this.mObserver == null) goto L6;
        ((DriveImFileDownloadVM) viewModel(DriveImFileDownloadVM.class)).getLiveDownload().removeObserver(this.mObserver);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DrivePluginHost) r1, r2);
    }

    private void lambda$onAttachToUIContainer$0(DriveImFileDownloadVM r4, t r5, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.a r6) {
        r4.handleFileDownloadMenuClick(new b(new b.a(getActivity(), this, r5)), new e65.a(new e65.a.C0217a(getHost().c, (DriveImFileSaveToSpaceVM) viewModel(DriveImFileSaveToSpaceVM.class), (DriveImFileDownloadVM) viewModel(DriveImFileDownloadVM.class))));
    }
}
