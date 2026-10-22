package com.bytedance.ee.bear.drive.biz.permission;

import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements gj5.a {
    public final /* synthetic */ AbsDrivePlugin a;
    public final /* synthetic */ String b;

    public final void a(gj5.c r5) {
        Intrinsics.checkNotNullParameter(r5, TipCallBackData.RESULT);
        DrivePluginHost r0 = this.a.getHost();
        String r1 = null;
        if (r0 == null) goto L5;
        t r2 = r0.getUIContainer();
    L6:
        if (r2 == null) goto L8;
        boolean r3 = true;
    L9:
        DrivePluginHost r4 = this.a.getHost();
        if (r4 == null) goto L16;
        DriveViewModel r6 = r4.c;
        if (r6 == null) goto L16;
        BaseOpenEntity r7 = r6.getOpenEntity();
        if (r7 == null) goto L16;
        r1 = r7.getFileId();
    L16:
        tt5.a.h("DriveNoPerm", "checkCacAsync - onResult, fileId: " + this.b + ", currentFileId: " + r1 + ", isAttached: " + r3);
        if (r3 == true) goto L19;
        return;
    L19:
        if (Intrinsics.areEqual(r1, this.b) == false) goto L25;
        ValidateResult r8 = r5.c;
        if (r8 == null) goto L26;
        r8.handleAction();
        return;
    L26:
        return;
    L25:
        return;
    L8:
        r3 = false;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public b(AbsDrivePlugin r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
