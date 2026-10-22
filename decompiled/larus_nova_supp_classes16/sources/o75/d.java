package o75;

import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.ee.bear.browser.plugin.o;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.document.DocumentSplitWindowPlugin;
import com.bytedance.ee.bear.document.DocumentSwitchFullScreenPlugin;
import com.bytedance.ee.bear.document.more.SpaceMovPlugin;
import com.bytedance.ee.bear.document.restore.DocDeletedPlugin;
import com.bytedance.ee.bear.drive.biz.ability.WikiDriveFileHostPlugin;
import com.bytedance.ee.bear.drive.biz.ai.DriveInlineAIPlugin;
import com.bytedance.ee.bear.drive.biz.bubblemenu.DriveBubbleMenuPlugin;
import com.bytedance.ee.bear.drive.biz.cache.DriveImFileCachePlugin;
import com.bytedance.ee.bear.drive.biz.cache.DriveSpaceFileCachePlugin;
import com.bytedance.ee.bear.drive.biz.cache.WpsFileCachePlugin;
import com.bytedance.ee.bear.drive.biz.comment.DriveCommentPlugin;
import com.bytedance.ee.bear.drive.biz.copy.DriveCopyPlugin;
import com.bytedance.ee.bear.drive.biz.downgrade.DrivePreviewDowngradePlugin;
import com.bytedance.ee.bear.drive.biz.encryption.DriveEncryptionKeyDeletedPlugin;
import com.bytedance.ee.bear.drive.biz.expand.DriveIMActivityExpandPlugin;
import com.bytedance.ee.bear.drive.biz.expand.DriveSpaceActivityExpandPlugin;
import com.bytedance.ee.bear.drive.biz.external.DriveImFileOpenExternalPlugin;
import com.bytedance.ee.bear.drive.biz.external.DriveLocalFileOpenExternalPlugin;
import com.bytedance.ee.bear.drive.biz.external.DriveSpaceFileOpenExternalPlugin;
import com.bytedance.ee.bear.drive.biz.extra_info.DriveSpaceFileExtraInfoViewPlugin;
import com.bytedance.ee.bear.drive.biz.extra_info.liked.DriveLikePlugin;
import com.bytedance.ee.bear.drive.biz.extra_info.meta.DriveMetaInfoPlugin;
import com.bytedance.ee.bear.drive.biz.feed.DriveFeedPlugin;
import com.bytedance.ee.bear.drive.biz.fileinfo.DriveImFileInfoPlugin;
import com.bytedance.ee.bear.drive.biz.fileinfo.DriveSpaceFileInfoPlugin;
import com.bytedance.ee.bear.drive.biz.magic.DriveMagicPlugin;
import com.bytedance.ee.bear.drive.biz.memory.DriveMemoryOverLimitPlugin;
import com.bytedance.ee.bear.drive.biz.monitor.DriveMonitorPlugin;
import com.bytedance.ee.bear.drive.biz.multitask.DriveMultiTaskPlugin;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionPlugin;
import com.bytedance.ee.bear.drive.biz.permission.DriveSpaceAttachmentMGPermissionPlugin;
import com.bytedance.ee.bear.drive.biz.permission.DriveThirdPartyPermissionPlugin;
import com.bytedance.ee.bear.drive.biz.permission.push.DriveSpaceFilePermissionPushPlugin;
import com.bytedance.ee.bear.drive.biz.preview.DrivePreviewContentPlugin;
import com.bytedance.ee.bear.drive.biz.preview.Offline.DriveSpaceFileOfflinePlugin;
import com.bytedance.ee.bear.drive.biz.preview.banner.DriveBannerPlugin;
import com.bytedance.ee.bear.drive.biz.preview.banner.DriveNotificationPlugin;
import com.bytedance.ee.bear.drive.biz.preview.block.DriveBlockCapturePlugin;
import com.bytedance.ee.bear.drive.biz.preview.block.DriveBlockPreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.block.DriveBlockTitlePlugin;
import com.bytedance.ee.bear.drive.biz.preview.cache.DrivePreloadVideoCachePlugin;
import com.bytedance.ee.bear.drive.biz.preview.configuration.DriveConfigurationPlugin;
import com.bytedance.ee.bear.drive.biz.preview.copy.DriveCopyProtectPlugin;
import com.bytedance.ee.bear.drive.biz.preview.dlp.DriveDlpPlugin;
import com.bytedance.ee.bear.drive.biz.preview.edit.DriveEditModeSwitchPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error._default.DriveDlpFailedToRetryPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error._default.DriveFailedToRetryPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error._default.DriveImFailToRetryPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.action.DrivePreviewActionPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.copy.DriveCoppingPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.copy.DriveCopyFailedPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.net.DriveReConnectedPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.net.DriveTrafficDownloadPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.notfound.DriveFileNotFoundPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.notfound.DriveSpaceFileNotFoundPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.notsupport.DriveFileNotSupportPreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.ownerdeletefile.DriveOwnerDeletedFilePlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.ownerdeletefile.DriveSpaceOwnerDeleteFilePlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.password.DrivePreviewPasswordProtectedPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.permissionerror.DriveImFilePermissionErrorPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.permissionerror.DriveSpaceAttachmentPermissionErrorPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.permissionerror.DriveSpaceFilePermissionErrorPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.permissionerror.DriveThirdPartyAttachmentPermissionErrorPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.policy.DrivePolicyErrorPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.resourceblocked.DriveImFileBlockedByAdminPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.size.DriveFileSizeErrorPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.tns.DriveTnsBlockPlugin;
import com.bytedance.ee.bear.drive.biz.preview.image.DriveImageThumbLoadingPlugin;
import com.bytedance.ee.bear.drive.biz.preview.imattachment.DriveImAttachmentDefaultPreviewModelStatePlugin;
import com.bytedance.ee.bear.drive.biz.preview.loading.DriveDownloadingPlugin;
import com.bytedance.ee.bear.drive.biz.preview.loading.DriveGeneratingPlugin;
import com.bytedance.ee.bear.drive.biz.preview.loading.DriveLoadingPlugin;
import com.bytedance.ee.bear.drive.biz.preview.media.DriveMediaPlugin;
import com.bytedance.ee.bear.drive.biz.preview.more.DriveImFileMoreMenuPlugin;
import com.bytedance.ee.bear.drive.biz.preview.more.DriveLocalFileMoreMenuPlugin;
import com.bytedance.ee.bear.drive.biz.preview.more.DriveSpaceAttachmentMoreMenuPlugin;
import com.bytedance.ee.bear.drive.biz.preview.more.DriveSpaceFileMoreMenuPlugin;
import com.bytedance.ee.bear.drive.biz.preview.more.DriveSpaceThirdPartyAttachmentMoreMenuPlugin;
import com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.DriveSpaceFileDownloadPlugin;
import com.bytedance.ee.bear.drive.biz.preview.more.fresh.DriveFreshNessPlugin;
import com.bytedance.ee.bear.drive.biz.preview.more.menu.delete.DriveSpaceFileDeleteMenuPlugin;
import com.bytedance.ee.bear.drive.biz.preview.navigation.DrivePdfNavigationPlugin;
import com.bytedance.ee.bear.drive.biz.preview.navigation.DriveWpsNavigationPlugin;
import com.bytedance.ee.bear.drive.biz.preview.orientation.DriveOrientationPlugin;
import com.bytedance.ee.bear.drive.biz.preview.presentation.DrivePresentationPlugin;
import com.bytedance.ee.bear.drive.biz.preview.rename.DriveRenameUpdatePlugin;
import com.bytedance.ee.bear.drive.biz.preview.route.DrivePreviewRoutePlugin;
import com.bytedance.ee.bear.drive.biz.preview.route.DriveWikiNavPlugin;
import com.bytedance.ee.bear.drive.biz.preview.screen.DriveFullScreenImmersivePlugin;
import com.bytedance.ee.bear.drive.biz.preview.screen.DriveScreenStatePlugin;
import com.bytedance.ee.bear.drive.biz.preview.secret.DriveSecretLevelPlugin;
import com.bytedance.ee.bear.drive.biz.preview.secret.DriveSecurityPlugin;
import com.bytedance.ee.bear.drive.biz.preview.show.DrivePreviewShowResultPlugin;
import com.bytedance.ee.bear.drive.biz.preview.titlebar.DriveCenterTitlePositionPlugin;
import com.bytedance.ee.bear.drive.biz.preview.titlebar.DriveTitleBarPlugin;
import com.bytedance.ee.bear.drive.biz.preview.titlebar.DriveTitleBarVisibilityPlugin;
import com.bytedance.ee.bear.drive.biz.preview.uicallback.DriveFileLoaderManagementPlugin;
import com.bytedance.ee.bear.drive.biz.preview.uicallback.DriveOpenLifecyclePlugin;
import com.bytedance.ee.bear.drive.biz.preview.vc.DriveVCFollowPlugin;
import com.bytedance.ee.bear.drive.biz.preview.vc.DriveVCModePlugin;
import com.bytedance.ee.bear.drive.biz.preview.video.DriveVideoStreamingPlugin;
import com.bytedance.ee.bear.drive.biz.preview.viewfinder.DriveViewFinderPlugin;
import com.bytedance.ee.bear.drive.biz.preview.watermark.DriveWatermarkPlugin;
import com.bytedance.ee.bear.drive.biz.security.DriveImAttachmentAntiScreenshotsPlugin;
import com.bytedance.ee.bear.drive.biz.security.DriveMGAntiScreenshotsPlugin;
import com.bytedance.ee.bear.drive.biz.security.DriveSpaceAttachmentAntiScreenshotsPlugin;
import com.bytedance.ee.bear.drive.biz.security.DriveThirdPartyAntiScreenshotsPlugin;
import com.bytedance.ee.bear.drive.biz.sheet.DriveIMSheetPlugin;
import com.bytedance.ee.bear.drive.biz.similar.DriveSimilarFileOpenPlugin;
import com.bytedance.ee.bear.drive.biz.slides.DriveIMSlidesPlugin;
import com.bytedance.ee.bear.drive.biz.translate.DriveTranslatePlugin;
import com.bytedance.ee.bear.drive.biz.versions.history.DriveHistoryModePlugin;
import com.bytedance.ee.bear.drive.biz.versions.push.DriveMultiVersionPlugin;
import com.bytedance.ee.bear.drive.biz.wps.DriveWPSCommonPlugin;
import com.bytedance.ee.bear.drive.biz.wps.DriveWPSLoadingPlugin;
import com.bytedance.ee.bear.drive.biz.wps.DriveWpsCostOptimizationPlugin;
import com.bytedance.ee.bear.drive.biz.wps.edit.DriveIMWPSEditPlugin;
import com.bytedance.ee.bear.drive.biz.wps.edit.DriveSpaceWPSEditPlugin;
import com.bytedance.ee.bear.drive.config.plugin.DriveOfflineCacheCleanPlugin;
import com.bytedance.ee.bear.drive.config.plugin.DrivePluginLevel;
import com.bytedance.ee.bear.drive.core.DriveHostAbilityPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.module.nativepreview.SharedDriveBlockViewManagerPlugin;
import com.bytedance.ee.bear.drive.preload.pdf.DrivePdfPositionPlugin;
import com.bytedance.ee.bear.drive.report.DriveImFileReportPlugin;
import com.bytedance.ee.bear.drive.report.DriveReportPlugin;
import com.bytedance.ee.bear.drive.report.DriveSpaceFileReportPlugin;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.PDFOutlinePlugin;
import com.bytedance.ee.util.info.AppInfoUtils;
import java.util.ArrayList;
import jdb.g;
import kotlin.jvm.internal.Intrinsics;
import r75.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements o {
    public d() {
    }

    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v42 */
    @Override // com.bytedance.ee.bear.browser.plugin.o
    public final n a(PluginHost r29) {
        Intrinsics.checkNotNullParameter(r29, "host");
        DrivePluginHost r0 = (DrivePluginHost) r29;
        int r2 = r0.c.getBizType();
        tt5.a.h("DriveComponent", "createBizPluginList() bizType=" + r2);
        if (r2 != 1) goto L5;
        int r3 = r75.b.a;
        Intrinsics.checkNotNullParameter(r0, "host");
        n r4 = new n(new n.a[]{n.h(new DriveTitleBarPlugin(), true), n.h(new DriveLocalFileMoreMenuPlugin(), true), n.h(new DrivePreviewContentPlugin(), true), n.h(new DriveCenterTitlePositionPlugin(), true), n.h(new DriveFailedToRetryPlugin(), true), n.h(new DriveLocalFileOpenExternalPlugin(), true)});
    L96:
        int r5 = s75.a.a;
        Intrinsics.checkNotNullParameter(r0, "host");
        a95.a r1 = new a95.a(r0.getUserComponent());
        n.a[] r6 = new n.a[35];
        r6[0] = n.h(new DriveViewFinderPlugin(), true);
        r6[1] = n.h(new DriveMediaPlugin(), true);
        r6[2] = n.h(new DriveOrientationPlugin(), true);
        r6[3] = n.h(new DriveDlpFailedToRetryPlugin(), true);
        r6[4] = n.h(new DriveFileLoaderManagementPlugin(), true);
        r6[5] = n.e(new DriveLoadingPlugin(), DrivePluginLevel.Loading);
        r6[6] = n.h(new DriveFullScreenImmersivePlugin(), true);
        r6[7] = n.h(new DriveTrafficDownloadPlugin(), true);
        r6[8] = n.h(new DrivePolicyErrorPlugin(), true);
        r6[9] = n.h(new DriveOpenLifecyclePlugin(), true);
        r6[10] = n.h(new DriveReportPlugin(), true);
        r6[11] = n.h(new DrivePreviewRoutePlugin(), true);
        r6[12] = n.h(new DrivePreviewPasswordProtectedPlugin(), true);
        r6[13] = n.h(new DriveFileSizeErrorPlugin(), true);
        r6[14] = n.h(new DriveFileNotSupportPreviewPlugin(), true);
        r6[15] = n.h(new DrivePreviewDowngradePlugin(), true);
        r6[16] = n.h(new DriveConfigurationPlugin(), true);
        DriveViewModel r7 = r0.c;
        Integer r8 = (Integer) r7.livePreviewType().getValue();
        boolean r9 = r7.isInVcState();
        boolean r10 = r7.isHostInVcState();
        tt5.a.h("DriveCommonPlugins", "create, previewType: " + r8 + ", isInVcState: " + r9 + ", isHostInVcState: " + r10);
        DriveScreenStatePlugin r11 = new DriveScreenStatePlugin();
        if (r9 == true) goto L100;
        if (r10 == true) goto L100;
        boolean r12 = true;
    L101:
        r6[17] = n.h(r11, r12);
        r6[18] = n.h(new DriveMagicPlugin(), true);
        r6[19] = n.h(new DrivePreviewActionPlugin(), true);
        r6[20] = n.h(new DrivePreviewShowResultPlugin(), true);
        r6[21] = n.h(new PDFOutlinePlugin(), true);
        r6[22] = n.h(new DriveWPSLoadingPlugin(), true);
        r6[23] = n.h(new DriveWPSCommonPlugin(), true);
        r6[24] = n.h(new DriveTitleBarVisibilityPlugin(), true);
        r6[25] = n.h(new DriveImageThumbLoadingPlugin(), true);
        r6[26] = n.h(new DriveVideoStreamingPlugin(), a95.c.a(r1, "ccm.drive.mobile.video_little_rate"));
        r6[27] = n.h(new DriveSecurityPlugin(), true);
        r6[28] = n.h(new DriveMonitorPlugin(), a95.c.a(r1, "ccm.perf.monitor"));
        r6[29] = n.h(new SpaceMovPlugin(), true);
        r6[30] = n.h(new DriveCopyProtectPlugin(), true);
        r6[31] = n.h(new DrivePdfPositionPlugin(), a95.c.a(r1, "ccm.drive.pdf_location_persist"));
        r6[32] = n.h(new DriveSimilarFileOpenPlugin(), a95.c.a(r1, "ccm.drive.mobile.enable_user_download_video_during_transcoding"));
        r6[33] = n.h(new DocumentSwitchFullScreenPlugin(), ((Boolean) ForsetiHelper.i.getValue()).booleanValue());
        r6[34] = n.h(new DocumentSplitWindowPlugin(), ForsetiHelper.i());
        return n.c(new n(r6), r4);
    L100:
        r12 = false;
        goto L101
    L5:
        if (r2 == 2) goto L71;
        if (r2 == 3) goto L64;
        if (r2 == 4) goto L47;
        if (r2 == 5) goto L10;
        tt5.a.d("DriveComponent", "not found bizType in createBizPluginList()");
        r4 = new n(new n.a[0]);
        Intrinsics.checkNotNull(r4);
        goto L96
    L10:
        int r13 = e.a;
        Intrinsics.checkNotNullParameter(r0, "host");
        DriveViewModel r14 = r0.c;
        if (r14 == null) goto L17;
        BaseOpenEntity r16 = r14.getOpenEntity();
        if (r16 == null) goto L17;
        if (r16.getPreviewType() != 3) goto L17;
        boolean r17 = true;
    L18:
        n.a[] r18 = new n.a[29];
        r18[0] = n.h(new DrivePreviewContentPlugin(), true);
        r18[1] = n.h(new DriveWatermarkPlugin(), true);
        r18[2] = n.e(new DriveBannerPlugin(), DrivePluginLevel.Banner);
        r18[3] = n.e(new DriveDownloadingPlugin(), DrivePluginLevel.Downloading);
        DriveVCFollowPlugin r19 = new DriveVCFollowPlugin();
        DriveViewModel r110 = r0.c;
        if (r110 == null) goto L23;
        boolean r111 = true;
        if (r110.isVCFollowMode() != true) goto L24;
        boolean r112 = true;
    L25:
        r18[4] = n.h(r19, r112);
        r18[5] = n.h(new DrivePresentationPlugin(), r111);
        r18[6] = n.h(new DriveFailedToRetryPlugin(), r111);
        r18[7] = n.h(new DriveFileNotFoundPlugin(), r111);
        r18[8] = n.h(new DriveOwnerDeletedFilePlugin(), r111);
        r18[9] = n.h(new DriveThirdPartyAttachmentPermissionErrorPlugin(), r111);
        r18[10] = n.h(new DriveCopyFailedPlugin(), r111);
        r18[11] = n.h(new DriveCoppingPlugin(), r111);
        r18[12] = n.h(new DriveTitleBarPlugin(), r111);
        r18[13] = n.h(new DriveSpaceThirdPartyAttachmentMoreMenuPlugin(), r111);
        r18[14] = n.h(new DriveThirdPartyPermissionPlugin(), r111);
        r18[15] = n.h(new DriveSpaceFileInfoPlugin(), r111);
        r18[16] = n.h(new DriveSpaceFileOpenExternalPlugin(), r111);
        r18[17] = n.h(new DriveSpaceFileCachePlugin(), r111);
        r18[18] = n.h(new DriveVCModePlugin(), r111);
        r18[19] = n.h(new DriveReConnectedPlugin(), r111);
        r18[20] = n.h(new WpsFileCachePlugin(), r111);
        r18[21] = n.h(new DriveBlockPreviewPlugin(), r17);
        r18[22] = n.h(new DriveBlockTitlePlugin(), r17);
        r18[23] = n.h(new SharedDriveBlockViewManagerPlugin(), r17);
        r18[24] = n.h(new DriveBlockCapturePlugin(), r17);
        r18[25] = n.h(new DriveGeneratingPlugin(), true);
        r18[26] = n.h(new DriveEncryptionKeyDeletedPlugin(), true);
        DriveThirdPartyAntiScreenshotsPlugin r20 = new DriveThirdPartyAntiScreenshotsPlugin();
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("spacekit.mobile.screen_capture_prevent_enable") == false) goto L37;
        DriveViewModel r21 = r0.c;
        if (r21 != null) goto L30;
    L32:
        boolean r113 = false;
    L33:
        if (r113 == true) goto L37;
        Intrinsics.checkNotNullParameter("debug_config", "name");
        com.ss.android.lark.storage.kv.repo.a r22 = ay4.b.b("debug_config", true, ay4.b.a("debug_config"));
        Intrinsics.checkNotNullParameter(r22, "repo");
        new ArrayList();
        Intrinsics.checkNotNullParameter("screen_protection", "key");
        if (r22.getBoolean("screen_protection", true) == false) goto L37;
        boolean r23 = true;
    L38:
        r18[27] = n.h(r20, r23);
        DriveWpsCostOptimizationPlugin r24 = new DriveWpsCostOptimizationPlugin();
        Intrinsics.checkNotNullParameter(r0, "host");
        b0 r26 = (b0) org.koin.java.a.c(b0.class, null, null, 6);
        g r27 = ((dn4.a) r0.getUserComponent().a(dn4.a.class)).a();
        if (r26.f() == false) goto L41;
    L45:
        boolean r28 = false;
    L46:
        r18[28] = n.h(r24, r28);
        r4 = new n(r18);
        goto L96
    L41:
        if (r27.isEnable("ccm.drive.mobile_ppt_prefer_transcode_preview") == false) goto L43;
    L44:
        r28 = true;
        goto L46
    L43:
        if (r27.isEnable("ccm.drive.mobile_word_prefer_transcode_preview") == false) goto L45;
    L30:
        if (r21.isInBlockState() != true) goto L32;
        r113 = true;
    L37:
        r23 = false;
    L24:
        r112 = false;
        goto L25
    L23:
        r111 = true;
    L17:
        r17 = false;
        goto L18
    L47:
        int r30 = r75.c.a;
        Intrinsics.checkNotNullParameter(r0, "host");
        n.a[] r31 = new n.a[25];
        r31[0] = n.h(new DrivePreviewContentPlugin(), true);
        r31[1] = n.h(new DriveWatermarkPlugin(), true);
        r31[2] = n.e(new DriveBannerPlugin(), DrivePluginLevel.Banner);
        r31[3] = n.e(new DriveDownloadingPlugin(), DrivePluginLevel.Downloading);
        r31[4] = n.h(new DriveVCFollowPlugin(), r0.c.isVCFollowMode());
        r31[5] = n.h(new DrivePresentationPlugin(), true);
        r31[6] = n.h(new DriveFailedToRetryPlugin(), true);
        r31[7] = n.h(new DriveFileNotFoundPlugin(), true);
        r31[8] = n.h(new DriveOwnerDeletedFilePlugin(), true);
        r31[9] = n.h(new DriveSpaceAttachmentPermissionErrorPlugin(), true);
        r31[10] = n.h(new DriveCopyFailedPlugin(), true);
        r31[11] = n.h(new DriveCoppingPlugin(), true);
        r31[12] = n.h(new DriveTitleBarPlugin(), true);
        r31[13] = n.h(new DriveSpaceAttachmentMoreMenuPlugin(), true);
        r31[14] = n.h(new DriveSpaceAttachmentMGPermissionPlugin(), true);
        r31[15] = n.h(new DriveSpaceFileInfoPlugin(), true);
        r31[16] = n.h(new DriveSpaceFileOpenExternalPlugin(), true);
        r31[17] = n.h(new DriveSpaceFileCachePlugin(), true);
        r31[18] = n.h(new DriveVCModePlugin(), true);
        r31[19] = n.h(new DriveReConnectedPlugin(), true);
        r31[20] = n.h(new WpsFileCachePlugin(), true);
        r31[21] = n.h(new DriveEncryptionKeyDeletedPlugin(), true);
        r31[22] = n.h(new DriveGeneratingPlugin(), true);
        DriveSpaceAttachmentAntiScreenshotsPlugin r32 = new DriveSpaceAttachmentAntiScreenshotsPlugin();
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("spacekit.mobile.screen_capture_prevent_enable") == true) goto L50;
    L54:
        boolean r33 = false;
    L55:
        r31[23] = n.h(r32, r33);
        DriveWpsCostOptimizationPlugin r34 = new DriveWpsCostOptimizationPlugin();
        Intrinsics.checkNotNullParameter(r0, "host");
        b0 r36 = (b0) org.koin.java.a.c(b0.class, null, null, 6);
        g r37 = ((dn4.a) r0.getUserComponent().a(dn4.a.class)).a();
        if (r36.f() == false) goto L58;
    L62:
        boolean r38 = false;
    L63:
        r31[24] = n.h(r34, r38);
        r4 = new n(r31);
        goto L96
    L58:
        if (r37.isEnable("ccm.drive.mobile_ppt_prefer_transcode_preview") == false) goto L60;
    L61:
        r38 = true;
        goto L63
    L60:
        if (r37.isEnable("ccm.drive.mobile_word_prefer_transcode_preview") == false) goto L62;
    L50:
        if (r0.c.isInBlockState() == true) goto L54;
        Intrinsics.checkNotNullParameter("debug_config", "name");
        com.ss.android.lark.storage.kv.repo.a r39 = ay4.b.b("debug_config", true, ay4.b.a("debug_config"));
        Intrinsics.checkNotNullParameter(r39, "repo");
        new ArrayList();
        Intrinsics.checkNotNullParameter("screen_protection", "key");
        if (r39.getBoolean("screen_protection", true) == false) goto L54;
        r33 = true;
        goto L55
    L64:
        int r40 = r75.a.a;
        Intrinsics.checkNotNullParameter(r0, "host");
        n.a[] r41 = new n.a[26];
        r41[0] = n.h(new DrivePreviewContentPlugin(), true);
        r41[1] = n.h(new DriveImFilePermissionErrorPlugin(), true);
        r41[2] = n.h(new DriveImFileMoreMenuPlugin(), true);
        r41[3] = n.h(new DriveTitleBarPlugin(), true);
        r41[4] = n.e(new DriveDownloadingPlugin(), DrivePluginLevel.Downloading);
        r41[5] = n.h(new DriveImFailToRetryPlugin(), true);
        r41[6] = n.h(new DriveFileNotFoundPlugin(), true);
        r41[7] = n.h(new DriveImFileInfoPlugin(), true);
        r41[8] = n.h(new DriveImAttachmentDefaultPreviewModelStatePlugin(), true);
        r41[9] = n.h(new DriveImFileBlockedByAdminPlugin(), true);
        r41[10] = n.h(new DriveImFileReportPlugin(), true);
        r41[11] = n.h(new DriveImFileOpenExternalPlugin(), true);
        r41[12] = n.h(new DriveImFileCachePlugin(), true);
        r41[13] = n.h(new DriveGeneratingPlugin(), true);
        r41[14] = n.h(new DriveReConnectedPlugin(), true);
        r41[15] = n.h(new WpsFileCachePlugin(), true);
        r41[16] = n.h(new DriveCenterTitlePositionPlugin(), true);
        r41[17] = n.h(new DriveEncryptionKeyDeletedPlugin(), true);
        r41[18] = n.h(new DriveBannerPlugin(), true);
        DriveImAttachmentAntiScreenshotsPlugin r42 = new DriveImAttachmentAntiScreenshotsPlugin();
        com.bytedance.ee.bear.appsetting.c r114 = com.bytedance.ee.bear.appsetting.c.a.a;
        if (r114.g("spacekit.mobile.screen_capture_prevent_enable") == false) goto L69;
        Intrinsics.checkNotNullParameter("debug_config", "name");
        com.ss.android.lark.storage.kv.repo.a r43 = ay4.b.b("debug_config", true, ay4.b.a("debug_config"));
        Intrinsics.checkNotNullParameter(r43, "repo");
        new ArrayList();
        Intrinsics.checkNotNullParameter("screen_protection", "key");
        if (r43.getBoolean("screen_protection", true) == false) goto L69;
        boolean r44 = true;
    L70:
        r41[19] = n.h(r42, r44);
        r41[20] = n.h(new DriveIMSheetPlugin(), true);
        r41[21] = n.h(new DriveIMSlidesPlugin(), true);
        r41[22] = n.h(new DriveEditModeSwitchPlugin(), true);
        r41[23] = n.h(new DriveIMWPSEditPlugin(), true);
        r41[24] = n.h(new DriveIMActivityExpandPlugin(), true);
        r41[25] = n.h(new DriveOfflineCacheCleanPlugin(), r114.h("lark.security.offline_caching_policy"));
        r4 = new n(r41);
    L69:
        r44 = false;
        goto L70
    L71:
        int r46 = r75.d.a;
        Intrinsics.checkNotNullParameter(r0, "host");
        t75.a r47 = t75.b.a(r0);
        if (r0.c.isTypeWiki() == false) goto L74;
        tt5.a.h("DriveSpaceFilePlugins", "Create driveSpaceFilePlugins, add WikiPlugins. ");
        ?? r48 = 1;
        char r115 = 0;
        n r49 = n.c(((com.bytedance.ee.bear.contract.route.parcelable.n) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.n.class, null, null, 6)).a(r0), new n(new n.a[]{n.h(new WikiDriveFileHostPlugin(), true)}));
    L75:
        n.a[] r116 = new n.a[58];
        r116[r115] = n.h(new DriveSpaceFileNotFoundPlugin(), r48);
        r116[r48] = n.h(new DriveWatermarkPlugin(), r48);
        r116[2] = n.h(new DriveSpaceOwnerDeleteFilePlugin(), r48);
        r116[3] = n.h(new DriveVCFollowPlugin(), r0.c.isVCFollowMode());
        r116[4] = n.h(new DrivePresentationPlugin(), r48);
        r116[5] = n.h(new DriveSpaceFileInfoPlugin(), r48);
        r116[6] = n.h(new DriveSpaceFileOfflinePlugin(), r48);
        r116[7] = n.h(new DriveSpaceFileOpenExternalPlugin(), r48);
        r116[8] = n.h(new DriveSpaceFileCachePlugin(), r48);
        r116[9] = n.h(new DriveVCModePlugin(), r0.c.isVCFollowMode());
        r116[10] = n.h(new DriveGeneratingPlugin(), r48);
        r116[11] = n.h(new WpsFileCachePlugin(), r48);
        r116[12] = n.h(new DriveReConnectedPlugin(), r48);
        r116[13] = n.h(new DriveSpaceFileMoreMenuPlugin(), r48);
        r116[14] = n.h(new DriveSpaceFileDownloadPlugin(), r48);
        r116[15] = n.h(new DrivePreviewContentPlugin(), r48);
        r116[16] = n.e(new DriveBannerPlugin(), DrivePluginLevel.Banner);
        r116[17] = n.e(new DriveDownloadingPlugin(), DrivePluginLevel.Downloading);
        r116[18] = n.h(new DriveFailedToRetryPlugin(), true);
        r116[19] = n.h(new DriveCopyFailedPlugin(), true);
        r116[20] = n.h(new DriveCoppingPlugin(), true);
        r116[21] = n.h(new DriveTitleBarPlugin(), true);
        r116[22] = n.h(new DriveMGPermissionPlugin(), true);
        n r117 = r49;
        r116[23] = n.j(new DriveSpaceFileExtraInfoViewPlugin(), DrivePluginLevel.ExtraInfo.ordinal(), !AppInfoUtils.e().booleanValue(), null);
        r116[24] = n.h(new DriveMetaInfoPlugin(), true);
        r116[25] = n.h(new DriveMultiVersionPlugin(), true);
        r116[26] = n.h(new DriveHistoryModePlugin(), true);
        r116[27] = n.h(new DriveCommentPlugin(), !AppInfoUtils.e().booleanValue());
        r116[28] = n.h(new DriveSpaceFilePermissionPushPlugin(), true);
        r116[29] = n.h(new DriveSpaceFilePermissionErrorPlugin(), true);
        r116[30] = n.h(new DriveFeedPlugin(), !AppInfoUtils.e().booleanValue());
        r116[31] = n.h(new DriveMultiTaskPlugin(), true);
        r116[32] = n.h(new DriveSpaceActivityExpandPlugin(), !r0.c.isVCFollowMode());
        r116[33] = n.h(new DriveSpaceFileReportPlugin(), true);
        r116[34] = n.h(new DriveSpaceFileDeleteMenuPlugin(), true);
        r116[35] = n.h(new DriveLikePlugin(), !AppInfoUtils.e().booleanValue());
        r116[36] = n.h(new DriveEditModeSwitchPlugin(), true);
        r116[37] = n.h(new DrivePreloadVideoCachePlugin(), true);
        r116[38] = n.h(new DriveSpaceWPSEditPlugin(), true);
        r116[39] = n.h(new DriveMemoryOverLimitPlugin(), true);
        r116[40] = n.h(new DriveSecretLevelPlugin(), true);
        DriveFreshNessPlugin r50 = new DriveFreshNessPlugin();
        com.bytedance.ee.bear.appsetting.c r51 = com.bytedance.ee.bear.appsetting.c.a.a;
        r116[41] = n.h(r50, r51.g("ccm.mobile.more.fresh_content"));
        r116[42] = n.h(new DriveDlpPlugin(), true);
        r116[43] = n.h(new DriveTnsBlockPlugin(), true);
        r116[44] = n.h(new DriveRenameUpdatePlugin(), true);
        r116[45] = n.h(new DriveEncryptionKeyDeletedPlugin(), true);
        DriveMGAntiScreenshotsPlugin r52 = new DriveMGAntiScreenshotsPlugin();
        if (r51.g("spacekit.mobile.screen_capture_prevent_enable") == true) goto L78;
    L82:
        boolean r53 = false;
    L83:
        r116[46] = n.h(r52, r53);
        r116[47] = n.h(new DriveNotificationPlugin(), true);
        r116[48] = n.h(new DriveHostAbilityPlugin(), true);
        r116[49] = n.h(new DocDeletedPlugin(), true);
        r116[50] = n.h(new DriveWikiNavPlugin(), true);
        r116[51] = n.h(new DriveBubbleMenuPlugin(), w55.n.d);
        r116[52] = n.h(new DriveCopyPlugin(), w55.n.d);
        r116[53] = n.h(new DriveInlineAIPlugin(), r51.g("ccm.mobile.drive.pdf_rect"));
        r116[54] = n.h(new DriveWpsNavigationPlugin(), r51.g("ccm.mobile.enterprise_drive_anchor_link"));
        r116[55] = n.h(new DrivePdfNavigationPlugin(), r51.g("ccm.mobile.enterprise_drive_anchor_link"));
        DriveWpsCostOptimizationPlugin r54 = new DriveWpsCostOptimizationPlugin();
        Intrinsics.checkNotNullParameter(r0, "host");
        b0 r56 = (b0) org.koin.java.a.c(b0.class, null, null, 6);
        g r57 = ((dn4.a) r0.getUserComponent().a(dn4.a.class)).a();
        if (r56.f() == false) goto L86;
    L90:
        boolean r58 = false;
    L91:
        r116[56] = n.h(r54, r58);
        r116[57] = n.h(new DriveTranslatePlugin(), w55.n.d);
        r4 = n.c(new n(r116), r47.b(r0));
        if (r117 != null) goto L94;
        Intrinsics.checkNotNull(r4);
        goto L96
    L94:
        r4 = n.c(r117, r4);
        Intrinsics.checkNotNull(r4);
        goto L96
    L86:
        if (r57.isEnable("ccm.drive.mobile_ppt_prefer_transcode_preview") == false) goto L88;
    L89:
        r58 = true;
        goto L91
    L88:
        if (r57.isEnable("ccm.drive.mobile_word_prefer_transcode_preview") == false) goto L90;
    L78:
        if (r0.c.isInBlockState() == true) goto L82;
        Intrinsics.checkNotNullParameter("debug_config", "name");
        com.ss.android.lark.storage.kv.repo.a r59 = ay4.b.b("debug_config", true, ay4.b.a("debug_config"));
        Intrinsics.checkNotNullParameter(r59, "repo");
        new ArrayList();
        Intrinsics.checkNotNullParameter("screen_protection", "key");
        if (r59.getBoolean("screen_protection", true) == false) goto L82;
        r53 = true;
        goto L83
    L74:
        r48 = 1;
        r115 = 0;
        r49 = null;
        goto L75
    }
}
