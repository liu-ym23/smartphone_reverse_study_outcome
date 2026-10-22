package com.bytedance.ee.bear.drive.loader.impl;

import com.bytedance.ee.bear.contract.drive.sdk.entity.open.LocalOpenEntity;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import i75.h;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import uu5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ b a;
    public final /* synthetic */ LocalOpenEntity b;

    public f(b r1, LocalOpenEntity r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        i r9 = (i) r8;
        tt5.a.h("LocalFileLoader", "exe1 completed.");
        if (r9.b() == false) goto L5;
        this.a.b.c(ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW);
        return;
    L5:
        f85.a r10 = (f85.a) r9.a();
        this.a.b.a(InfoCode.FileInfoSuccess, r10);
        z r1 = r10.i();
        r1.p = this.b.getAppId();
        r1.t = this.b.getMountPoint();
        this.a.c.c.setFileName(this.b.getFileName());
        if (((f85.a.C0229a) r10.a).c > 0) goto L9;
        tt5.a.h("LocalFileLoader", "fileSize is 0");
        this.a.b.c(ErrCode.DRIVE_FILE_ZERO_SIZE);
        return;
    L9:
        if (((g85.b) o75.b.a().getMimeTypeManager()).l(r1.c) == true) goto L12;
        tt5.a.h("LocalFileLoader", "isLocalSupport false for ext=" + r1.c);
        this.a.b.c(ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW);
        return;
    L12:
        if (h.b(r1.c) == true) goto L14;
    L16:
        tt5.a.h("LocalFileLoader", "isLocalSupport success, fileSize=" + ((f85.a.C0229a) r10.a).c + ", fileName=" + du5.b.g(((f85.a.C0229a) r10.a).b) + "filePath=" + du5.b.f(r10.a()));
        v75.a r11 = this.a.b;
        Intrinsics.checkNotNull(r1);
        r11.b(r1);
        return;
    L14:
        if (((f85.a.C0229a) r10.a).c <= (o75.b.a().getDriveConfig().a().getLocal_archive_max_size() * 1024)) goto L16;
        tt5.a.h("LocalFileLoader", "isArchiveLibSupportExt but file  too large");
        this.a.b.c(ErrCode.DRIVE_FILE_OVER_SIZE);
    }
}
