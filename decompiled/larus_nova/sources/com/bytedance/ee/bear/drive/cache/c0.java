package com.bytedance.ee.bear.drive.cache;

import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c0 extends DriveCacheService {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void E8() {
        Intrinsics.checkNotNullParameter("DriveDatabaseManager-Migration78", "logKey");
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void F8(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "logKey");
        Intrinsics.checkNotNullParameter(r101, "fileId");
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void J6(String r100) {
        Intrinsics.checkNotNullParameter("DriveDataService-put", "logKey");
        Intrinsics.checkNotNullParameter(r100, "fileId");
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void Z3() {
        Intrinsics.checkNotNullParameter("DriveDataService-cleanTempFileWhenInit", "logKey");
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void i6(List r100) {
        Intrinsics.checkNotNullParameter("DriveDataService-removeAll", "logKey");
        Intrinsics.checkNotNullParameter(r100, "fileIds");
    }

    @Inject
    public c0(by4.b r100, com.ss.android.lark.passportc.api.m r101) {
        Intrinsics.checkNotNullParameter(r100, "kvStorage");
        Intrinsics.checkNotNullParameter(r101, "userService");
        super("OfficeDriveCacheService", r100, r101);
    }
}
