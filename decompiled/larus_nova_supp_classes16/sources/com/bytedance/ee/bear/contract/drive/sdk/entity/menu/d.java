package com.bytedance.ee.bear.contract.drive.sdk.entity.menu;

import android.os.Bundle;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.DriveProxyExtra;
import com.bytedance.ee.util.io.FileUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public final BaseMoreMenuAction a;

    public d(BaseMoreMenuAction r1) {
        this.a = r1;
    }

    public static void a(d r3, String r4, String r5, long r6, int r8) {
        String r1 = null;
        if ((r8 & 1) == 0) goto L9;
        BaseMoreMenuAction r0 = r3.a;
        if (r0 == null) goto L9;
        BaseOpenEntity r2 = r0.g;
        if (r2 == null) goto L9;
        String r7 = r2.getFileId();
    L11:
        if ((r8 & 2) == 0) goto L19;
        BaseMoreMenuAction r9 = r3.a;
        if (r9 == null) goto L17;
        BaseOpenEntity r10 = r9.g;
        if (r10 == null) goto L17;
        r4 = r10.getFileName();
    L17:
        r4 = null;
    L19:
        if ((r8 & 4) == 0) goto L27;
        BaseMoreMenuAction r11 = r3.a;
        if (r11 == null) goto L25;
        BaseOpenEntity r12 = r11.g;
        if (r12 == null) goto L25;
        r1 = r12.getFileName();
    L25:
        r5 = com.bytedance.ee.util.io.a.c(r1);
    L27:
        if ((r8 & 8) == 0) goto L36;
        BaseMoreMenuAction r13 = r3.a;
        if (r13 == null) goto L35;
        BaseOpenEntity r14 = r13.g;
        if (r14 == null) goto L35;
        String r16 = r14.getLocalPath();
        if (r16 == null) goto L35;
        r6 = FileUtils.y(r16);
    L35:
        r6 = 0;
    L36:
        BaseMoreMenuAction r17 = r3.a;
        if (r17 != null) goto L39;
    L44:
        BaseMoreMenuAction r18 = r3.a;
        if (r18 == null) goto L56;
        BinderDriveMenuAction r19 = r18.b;
        if (r19 == null) goto L57;
        r19.actionDone(r18.f);     // Catch: Throwable -> L51
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
        if (r17.f != null) goto L41;
        r17.f = new Bundle();
    L41:
        Bundle r20 = r17.f;
        if (r20 == null) goto L44;
        r20.putString(DriveProxyExtra.FileId.toString(), r7);
        r20.putString(DriveProxyExtra.FileName.toString(), r4);
        r20.putString(DriveProxyExtra.FileType.toString(), r5);
        r20.putLong(DriveProxyExtra.FileSize.toString(), r6);
    L9:
        r7 = null;
        goto L11
    }
}
