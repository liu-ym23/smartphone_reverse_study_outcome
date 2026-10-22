package com.bytedance.ee.bear.drive.biz.preview.screen;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final a a(DriveViewModel r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        w75.c r0 = r2.getIFileModel();
        if (r0 != null) goto L6;
        return null;
    L6:
        a r1 = new a();
        if (r3 == null) goto L9;
        boolean r4 = r3.booleanValue();
    L10:
        r1.a = r4;
        if (TextUtils.isEmpty(r0.B()) == true) goto L13;
        String r5 = r0.B();
    L14:
        Intrinsics.checkNotNull(r5);
        r1.b = r5;
        r1.c = r0.getFileToken();
        r1.d = r2.isVCFollowMode();
        return r1;
    L13:
        r5 = r0.getDetails().c().k;
        goto L14
    L9:
        r4 = false;
        goto L10
    }
}
