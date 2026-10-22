package com.bytedance.ee.bear.contract.drive.sdk.entity.menu;

import android.os.Bundle;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.DriveProxyExtra;
import com.bytedance.ee.util.io.FileUtils;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseMoreMenuAction f217034a;

    public d(BaseMoreMenuAction r100) {
        this.f217034a = r100;
    }

    public static void a(d r100, String r101, String r102, long r103, int r104) {
        String r105 = null;
        if ((r104 & 1) == 0) goto L9;
        BaseMoreMenuAction r106 = r100.f217034a;
        if (r106 == null) goto L9;
        BaseOpenEntity r107 = r106.f217010g;
        if (r107 == null) goto L9;
        String r108 = r107.getFileId();
    L11:
        if ((r104 & 2) == 0) goto L19;
        BaseMoreMenuAction r109 = r100.f217034a;
        if (r109 == null) goto L17;
        BaseOpenEntity r110 = r109.f217010g;
        if (r110 == null) goto L17;
        r101 = r110.getFileName();
    L17:
        r101 = null;
    L19:
        if ((r104 & 4) == 0) goto L27;
        BaseMoreMenuAction r111 = r100.f217034a;
        if (r111 == null) goto L25;
        BaseOpenEntity r112 = r111.f217010g;
        if (r112 == null) goto L25;
        r105 = r112.getFileName();
    L25:
        r102 = com.bytedance.ee.util.io.a.c(r105);
    L27:
        if ((r104 & 8) == 0) goto L36;
        BaseMoreMenuAction r113 = r100.f217034a;
        if (r113 == null) goto L35;
        BaseOpenEntity r114 = r113.f217010g;
        if (r114 == null) goto L35;
        String r115 = r114.getLocalPath();
        if (r115 == null) goto L35;
        r103 = FileUtils.y(r115);
    L35:
        r103 = 0;
    L36:
        BaseMoreMenuAction r116 = r100.f217034a;
        if (r116 != null) goto L39;
    L44:
        BaseMoreMenuAction r117 = r100.f217034a;
        if (r117 == null) goto L56;
        BinderDriveMenuAction r118 = r117.f217005b;
        if (r118 == null) goto L57;
        r118.actionDone(r117.f217009f);     // Catch: Throwable -> L51
        tt5.a.h("DriveSdk#AbsMoreMenuAction", "handleDriveProxyAction() exec proxy action done.");     // Catch: Throwable -> L51
        return;
    L51:
        th = move-exception;
        tt5.a.e("DriveSdk#AbsMoreMenuAction", "executeDriveProxy() error=", th, false);
        return;
    L57:
        return;
    L56:
        return;
    L39:
        if (r116.f217009f != null) goto L41;
        r116.f217009f = new Bundle();
    L41:
        Bundle r119 = r116.f217009f;
        if (r119 == null) goto L44;
        r119.putString(DriveProxyExtra.FileId.toString(), r108);
        r119.putString(DriveProxyExtra.FileName.toString(), r101);
        r119.putString(DriveProxyExtra.FileType.toString(), r102);
        r119.putLong(DriveProxyExtra.FileSize.toString(), r103);
    L9:
        r108 = null;
        goto L11
    }
}
