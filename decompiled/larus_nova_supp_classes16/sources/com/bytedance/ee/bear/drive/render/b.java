package com.bytedance.ee.bear.drive.render;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.ee.bear.browser.plugin.o;
import com.bytedance.ee.bear.drive.biz.fileinfo.DriveSpaceFileInfoPlugin;
import com.bytedance.ee.bear.drive.biz.permission.OfficeDriveMGPermissionPlugin;
import com.bytedance.ee.bear.drive.biz.preview.DrivePreviewContentPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error._default.OfficeDriveFailedToRetryPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.net.DriveReConnectedPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.notsupport.DriveFileNotSupportPreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.password.DrivePreviewPasswordProtectedPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.size.DriveFileSizeErrorPlugin;
import com.bytedance.ee.bear.drive.biz.preview.loading.DriveDownloadingPlugin;
import com.bytedance.ee.bear.drive.biz.preview.loading.DriveGeneratingPlugin;
import com.bytedance.ee.bear.drive.biz.preview.route.DrivePreviewRoutePlugin;
import com.bytedance.ee.bear.drive.biz.preview.secret.DriveSecurityPlugin;
import com.bytedance.ee.bear.drive.biz.preview.show.DrivePreviewShowResultPlugin;
import com.bytedance.ee.bear.drive.biz.preview.titlebar.DriveAlwaysHideTitleBarPlugin;
import com.bytedance.ee.bear.drive.biz.preview.viewfinder.DriveViewFinderPlugin;
import com.bytedance.ee.bear.drive.biz.preview.watermark.DriveWatermarkPlugin;
import com.bytedance.ee.bear.drive.config.plugin.DrivePluginLevel;
import com.bytedance.ee.bear.drive.core.DriveHostAbilityPlugin;
import com.bytedance.ee.bear.drive.report.DriveReportPlugin;
import com.bytedance.ee.drive.preview.plugin.OfficeDriveContainerLoadingPlugin;
import com.bytedance.ee.drive.preview.plugin.OfficeDrivePermissionErrorPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements o {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.o
    public final n a(PluginHost r4) {
        return new n(new n.a[]{n.h(new DriveViewFinderPlugin(), true), n.e(new DriveDownloadingPlugin(), DrivePluginLevel.Downloading), n.h(new DriveFileSizeErrorPlugin(), true), n.h(new DriveFileNotSupportPreviewPlugin(), true), n.h(new DrivePreviewRoutePlugin(), true), n.h(new DrivePreviewContentPlugin(), true), n.h(new DrivePreviewShowResultPlugin(), true), n.h(new DriveSpaceFileInfoPlugin(), true), n.h(new DriveReConnectedPlugin(), true), n.h(new DriveHostAbilityPlugin(), true), n.h(new DrivePreviewPasswordProtectedPlugin(), true), n.h(new DriveReportPlugin(), true), n.h(new DriveGeneratingPlugin(), true), n.h(new DriveWatermarkPlugin(), true), n.h(new DriveSecurityPlugin(), true), n.h(new OfficeDriveContainerLoadingPlugin(), true), n.h(new DriveAlwaysHideTitleBarPlugin(), true), n.h(new OfficeDrivePermissionErrorPlugin(), true), n.h(new OfficeDriveFailedToRetryPlugin(), true), n.h(new OfficeDriveMGPermissionPlugin(), true)});
    }
}
