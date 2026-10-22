package com.bytedance.ee.bear.drive.render;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.basesdk.config.strategy.base.OfficePopLastWikiRoutePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.ee.bear.browser.plugin.o;
import com.bytedance.ee.bear.drive.biz.comment.DriveCommentPlugin;
import com.bytedance.ee.bear.drive.biz.extra_info.DriveSpaceFileExtraInfoViewPlugin;
import com.bytedance.ee.bear.drive.biz.extra_info.liked.DriveLikePlugin;
import com.bytedance.ee.bear.drive.biz.feed.DriveFeedPlugin;
import com.bytedance.ee.bear.drive.biz.multitask.DriveMultiTaskPlugin;
import com.bytedance.ee.bear.drive.biz.preview.loading.DriveLoadingPlugin;
import com.bytedance.ee.bear.drive.biz.preview.orientation.DriveOrientationPlugin;
import com.bytedance.ee.bear.office.export.docs.bridge.OfficeBridgePlugin;
import com.bytedance.ee.drive.preview.plugin.OfficeDriveAiInteractionPlugin;
import com.bytedance.ee.drive.preview.plugin.OfficeDriveContainerLoadingPlugin;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import o75.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements o {
    public final /* synthetic */ OfficeDriveOpenStrategy a;

    public a(OfficeDriveOpenStrategy r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.o
    public final n a(PluginHost r5) {
        d r0 = (d) this.a.a.getValue();
        Intrinsics.checkNotNull(r5);
        n r6 = r0.a(r5);
        r6.l(DriveLoadingPlugin.class);
        r6.l(DriveMultiTaskPlugin.class);
        if (c.a.a.g("ccm.mobile.doubao_drive_comment") == true) goto L5;
        r6.l(DriveCommentPlugin.class);
        r6.l(DriveSpaceFileExtraInfoViewPlugin.class);
        r6.l(DriveFeedPlugin.class);
    L5:
        r6.l(DriveLikePlugin.class);
        r6.l(DriveOrientationPlugin.class);
        return n.c(r6, new n(CollectionsKt.mutableListOf(new n.a[]{n.h(new OfficeBridgePlugin(), true), n.h(new OfficeDriveContainerLoadingPlugin(), true), n.h(new OfficeDriveAiInteractionPlugin(), true), n.h(new OfficePopLastWikiRoutePlugin(), true)})));
    }
}
