package com.bytedance.ee.bear.drive.sdk.service;

import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@UserScope
public final class DriveSdkService implements f {
    public static final Lazy<d> a = null;

    @Override // com.bytedance.ee.bear.drive.sdk.service.f
    public final void onDestroy() {
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, DriveSdkService$INSTANCE$driveUploadDownloadService$2.INSTANCE);
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.f
    public final g d0() {
        return (g) a.getValue();
    }

    @Inject
    public DriveSdkService(by4.b r2) {
        Intrinsics.checkNotNullParameter(r2, "kvStorage");
    }
}
