package com.bytedance.ee.bear.drive.biz.preview.screen;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {
    public static final a a(DriveViewModel r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        w75.c r102 = r100.getIFileModel();
        if (r102 != null) goto L6;
        return null;
    L6:
        a r103 = new a();
        if (r101 == null) goto L9;
        boolean r104 = r101.booleanValue();
    L10:
        r103.f223712a = r104;
        if (TextUtils.isEmpty(r102.B()) == true) goto L13;
        String r105 = r102.B();
    L14:
        Intrinsics.checkNotNull(r105);
        r103.f223713b = r105;
        r103.f223714c = r102.getFileToken();
        r103.f223715d = r100.isVCFollowMode();
        return r103;
    L13:
        r105 = r102.getDetails().c().f558567k;
        goto L14
    L9:
        r104 = false;
        goto L10
    }
}
