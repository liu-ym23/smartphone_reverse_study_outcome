package com.bytedance.ee.bear.drive.loader.impl;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.drive.DriveLocalFilePath;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.LocalOpenEntity;
import com.bytedance.ee.util.io.FileUtils;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import uu5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T, R> implements Function {
    public final /* synthetic */ b a;
    public final /* synthetic */ LocalOpenEntity b;

    public c(b r1, LocalOpenEntity r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r13) {
        Intrinsics.checkNotNullParameter((String) r13, "it");
        b r14 = this.a;
        LocalOpenEntity r0 = this.b;
        r14.getClass();
        f85.a r16 = new f85.a(new f85.a.C0229a(r0.getFileName(), FileUtils.y(r0.getLocalFilePath()), new int[0], "", k75.a.j(r0), "", "", 0));
        r16.k = new DriveLocalFilePath().localFilePath(r0.getLocalFilePath());
        if (TextUtils.isEmpty(r0.getFileType()) == false) goto L5;
        String r1 = com.bytedance.ee.util.io.a.c(r0.getFileName());
    L6:
        r16.f = r1;
        r16.n = true;
        r16.f(true);
        this.a.c.c.setFileModel(r16);
        return new i(r16);
    L5:
        r1 = r0.getFileType();
        goto L6
    }
}
