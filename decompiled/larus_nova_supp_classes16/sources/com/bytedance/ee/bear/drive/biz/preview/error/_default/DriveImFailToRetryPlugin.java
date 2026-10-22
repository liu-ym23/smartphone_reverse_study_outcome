package com.bytedance.ee.bear.drive.biz.preview.error._default;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.view.preview.retryview.FailedToRetryView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/_default/DriveImFailToRetryPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/error/_default/DriveFailedToRetryPlugin;", "<init>", "()V", "showFailedToRetryView", "Lcom/bytedance/ee/bear/drive/view/preview/retryview/FailedToRetryView;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveImFailToRetryPlugin extends DriveFailedToRetryPlugin {
    @Override // com.bytedance.ee.bear.drive.biz.preview.error._default.DriveFailedToRetryPlugin, com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.error._default.DriveFailedToRetryPlugin
    public FailedToRetryView showFailedToRetryView() {
        FailedToRetryView r0 = super.showFailedToRetryView();
        if (Intrinsics.areEqual(k75.a.i(getHost()).liveOuterExportVisible().getValue(), Boolean.TRUE) == false) goto L5;
        int r1 = c.a;
        c.a.a(r0, getHost().c.getOpenEntity().getFileId());
    L5:
        return r0;
    }

    public DriveImFailToRetryPlugin() {
    }
}
