package com.bytedance.ee.bear.document.plugin.upload;

import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.middleground.drive.export.DownloadCallback;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements com.ss.android.lark.utils.h.c {
    public final /* synthetic */ OfficeDownloadPlugin.b a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ tb5.m f;

    public final void b(StoragePermissionUtils.c r24) {
        Intrinsics.checkNotNullParameter(r24, "state");
        if (r24.d == false) goto L17;
        OfficeDownloadPlugin.b r1 = this.a;
        String r4 = this.b;
        String r6 = this.c;
        final String r12 = this.d;
        final String r13 = this.e;
        final tb5.m r16 = this.f;
        r1.getClass();
        final ip5.b r8 = new ip5.b(OfficeDownloadPlugin.access$getContext(r1.a));
        OfficeDownloadPlugin r2 = r1.a;
        ip5.a r3 = new ip5.a(OfficeDownloadPlugin.access$getContext(r1.a)).title(2131887285);
        boolean r5 = false;
        r3.a = 0;
        OfficeDownloadPlugin.access$setProgressDialog$p(r2, r3.controller(r8).addActionButton(2131391777, 2131887716, new f(r1.a, r16)).width(303.0f).marginInDp(0).cancelOnTouchOutside(false).show());
        int r7 = ay4.c.a;
        final PolarisFileWrapper r11 = new PolarisFileWrapper(ay4.c.a.a(Biz.DOCS, "export", 12).getRealPath());
        if (r11.exists() == true) goto L7;
        r11.mkdirs();
    L7:
        final Ref.BooleanRef r10 = new Ref.BooleanRef();
        if (r12.length() <= 75) goto L10;
        r10.element = true;
        String r9 = du5.b.g(r4);
    L12:
        if (r13.length() <= 0) goto L14;
        r5 = true;
    L14:
        if (r5 == false) goto L16;
        r9 = r9 + '.' + r13;
    L16:
        final PolarisFileWrapper r14 = new PolarisFileWrapper(r11, r9);
        String r17 = r14.getAbsolutePath();
        final OfficeDownloadPlugin r18 = r1.a;
        DownloadCallback r19 = new OfficeDownloadPlugin$OfficeDownloadFileHandler$startDownload$downloadCallback$1(r8, r18, r10, r11, r12, r13, r14, r16);
        int r20 = DrivePriority.DownloadPriority.DEFAULT.getPriority();
        DownloadRequestInfo.DownloadType r21 = DownloadRequestInfo.DownloadType.DRIVE;
        DriveBizScene r22 = DriveBizScene.DriveBizScene_UNKNOWN;
        OfficeDownloadPlugin.access$setDownloadKey$p(r1.a, ((com.bytedance.ee.bear.drive.sdk.service.f) LarkContext.spiByDwarf(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().g(new DownloadRequestInfo(r17, r4, "", r6, r20, "", r21, "", 0, false, "", 2, r19, null, false, null, null, DriveBizScene.DriveBizScene_CCM, DriveWatermarkScene.DriveWatermarkScene_CCM_SPACE_FILE_DOWNLOAD)));
        return;
    L10:
        r9 = r12;
        goto L12
    L17:
        tt5.a.k("OfficeDownloadPlugin", "export fail, permission deny");
    }

    public e(OfficeDownloadPlugin.b r1, String r2, String r3, String r4, String r5, tb5.m r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
