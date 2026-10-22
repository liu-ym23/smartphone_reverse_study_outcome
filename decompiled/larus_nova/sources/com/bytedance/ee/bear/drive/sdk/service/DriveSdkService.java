package com.bytedance.ee.bear.drive.sdk.service;

import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@UserScope
public final class DriveSdkService implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<d> f224595a = null;

    @Override // com.bytedance.ee.bear.drive.sdk.service.f
    public final void onDestroy() {
    }

    static {
        f224595a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, DriveSdkService$INSTANCE$driveUploadDownloadService$2.INSTANCE);
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.f
    public final g d0() {
        return f224595a.getValue();
    }

    @Inject
    public DriveSdkService(by4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "kvStorage");
    }
}
