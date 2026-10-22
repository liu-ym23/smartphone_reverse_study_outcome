package com.bytedance.ee.bear.drive.biz.security;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/security/DriveImAttachmentAntiScreenshotsPlugin;", "Lcom/bytedance/ee/bear/drive/biz/security/BaseAntiScreenshotsPlugin;", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveImAttachmentAntiScreenshotsPlugin extends BaseAntiScreenshotsPlugin {
    private final String TAG;

    @Override // com.bytedance.ee.bear.drive.biz.security.BaseAntiScreenshotsPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public DriveImAttachmentAntiScreenshotsPlugin() {
        this.TAG = "DriveImAttachmentAntiScreenshotsPlugin@" + Integer.toHexString(hashCode());
    }

    @Override // com.bytedance.ee.bear.drive.biz.security.BaseAntiScreenshotsPlugin
    public String getTAG() {
        return this.TAG;
    }

    @Override // com.bytedance.ee.bear.drive.biz.security.BaseAntiScreenshotsPlugin
    public void onAttachToHost(DrivePluginHost r100) {
        super.onAttachToHost(r100);
        getDriveCopyPerm().postValue(Boolean.TRUE);
    }

    @Override // com.bytedance.ee.bear.drive.biz.security.BaseAntiScreenshotsPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DrivePluginHost) r100);
    }
}
