package com.bytedance.ee.bear.drive.services;

import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.vfs.VFSFile;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class r<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DriveFilePath f224627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserSession f224628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f224629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f224630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ VFSFile f224631e;

    public r(DriveFilePath r100, UserSession r101, boolean r102, String r103, VFSFile r104) {
        this.f224627a = r100;
        this.f224628b = r101;
        this.f224629c = r102;
        this.f224630d = r103;
        this.f224631e = r104;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((String) r100, "it");
        int r101 = v.f224636a;
        y85.a r102 = v.a.a();
        if (r102 != null) goto L5;
    L9:
        boolean r103 = this.f224629c;
        String r104 = this.f224630d;
        DriveFilePath r105 = this.f224627a;
        Intrinsics.checkNotNull(r105);
        FileUtils.i(r103, r104, z75.b.b(r105, this.f224628b));
    L11:
        return Boolean.valueOf(this.f224631e.exists());
    L5:
        if (r102.f566908a == false) goto L9;
        if (FileUtils.F(r102.f566909b, r102.f566910c) == false) goto L9;
        tt5.a.h("DriveSaveCacheManager", "addUploadDriveFileCache use mock filePath");
        boolean r106 = r102.f566909b;
        String r107 = r102.f566910c;
        DriveFilePath r108 = this.f224627a;
        Intrinsics.checkNotNull(r108);
        FileUtils.i(r106, r107, z75.b.b(r108, this.f224628b));
        goto L11
    }
}
