package com.bytedance.ee.bear.drive.preload;

import com.bytedance.ee.bear.drive.loader.download.model.drive.DrivePreviewGetModel;
import com.bytedance.ee.bear.drive.loader.download.platform.api.IApiPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.PreviewGetV1Puller;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    @JvmStatic
    public static final DrivePreviewGetModel a(IApiPuller<PreviewGetV1Puller.Params, DrivePreviewGetModel> r9, f85.a r10) {
        Intrinsics.checkNotNullParameter(r9, "puller");
        Intrinsics.checkNotNullParameter(r10, "fileModel");
        f85.a.C0229a r1 = (f85.a.C0229a) r10.a;
        if (r1 == null) goto L5;
        String r3 = r1.a;
    L6:
        if (r1 == null) goto L8;
        String r4 = r1.m;
    L9:
        if (r1 == null) goto L11;
        String r5 = r1.n;
    L12:
        int r11 = r10.e;
        if (r1 == null) goto L15;
        String r7 = r1.p;
    L16:
        if (r1 == null) goto L18;
        String r8 = r1.h;
    L20:
        return (DrivePreviewGetModel) r9.pull(new PreviewGetV1Puller.Params(r3, r4, r5, r11, false, r7, r8)).blockingSingle();
    L18:
        r8 = null;
        goto L20
    L15:
        r7 = null;
        goto L16
    L11:
        r5 = null;
        goto L12
    L8:
        r4 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }
}
