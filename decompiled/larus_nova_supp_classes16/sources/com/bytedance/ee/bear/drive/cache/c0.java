package com.bytedance.ee.bear.drive.cache;

import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public final void F8(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "logKey");
        Intrinsics.checkNotNullParameter(r3, "fileId");
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void J6(String r3) {
        Intrinsics.checkNotNullParameter("DriveDataService-put", "logKey");
        Intrinsics.checkNotNullParameter(r3, "fileId");
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void Z3() {
        Intrinsics.checkNotNullParameter("DriveDataService-cleanTempFileWhenInit", "logKey");
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void i6(List r3) {
        Intrinsics.checkNotNullParameter("DriveDataService-removeAll", "logKey");
        Intrinsics.checkNotNullParameter(r3, "fileIds");
    }

    @Inject
    public c0(by4.b r2, com.ss.android.lark.passportc.api.m r3) {
        Intrinsics.checkNotNullParameter(r2, "kvStorage");
        Intrinsics.checkNotNullParameter(r3, "userService");
        super("OfficeDriveCacheService", r2, r3);
    }
}
