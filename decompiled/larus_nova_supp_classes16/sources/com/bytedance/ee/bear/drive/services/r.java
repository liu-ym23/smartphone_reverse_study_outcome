package com.bytedance.ee.bear.drive.services;

import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.vfs.VFSFile;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r<T, R> implements Function {
    public final /* synthetic */ DriveFilePath a;
    public final /* synthetic */ UserSession b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ String d;
    public final /* synthetic */ VFSFile e;

    public r(DriveFilePath r1, UserSession r2, boolean r3, String r4, VFSFile r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object apply(Object r4) {
        Intrinsics.checkNotNullParameter((String) r4, "it");
        int r5 = v.a;
        y85.a r6 = v.a.a();
        if (r6 != null) goto L5;
    L9:
        boolean r7 = this.c;
        String r0 = this.d;
        DriveFilePath r1 = this.a;
        Intrinsics.checkNotNull(r1);
        FileUtils.i(r7, r0, z75.b.b(r1, this.b));
    L11:
        return Boolean.valueOf(this.e.exists());
    L5:
        if (r6.a == false) goto L9;
        if (FileUtils.F(r6.b, r6.c) == false) goto L9;
        tt5.a.h("DriveSaveCacheManager", "addUploadDriveFileCache use mock filePath");
        boolean r2 = r6.b;
        String r8 = r6.c;
        DriveFilePath r3 = this.a;
        Intrinsics.checkNotNull(r3);
        FileUtils.i(r2, r8, z75.b.b(r3, this.b));
        goto L11
    }
}
