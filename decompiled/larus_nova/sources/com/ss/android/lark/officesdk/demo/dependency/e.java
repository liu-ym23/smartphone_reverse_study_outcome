package com.ss.android.lark.officesdk.demo.dependency;

import com.bytedance.crash.dumper.Scraps;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class e implements jzb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public epb.a f433165a;

    @Inject
    public e() {
    }

    @Override // jzb.a
    public final Pair<String, String> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, Scraps.INNER_UNIT);
        epb.a r101 = this.f433165a;
        epb.a r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mLarkDeviceIdApi");
        r101 = null;
    L6:
        String r103 = r101.getDeviceId();
        epb.a r104 = this.f433165a;
        if (r104 == null) goto L9;
        r102 = r104;
    L11:
        return new Pair(r103, r102.getInstallId());
    L9:
        Intrinsics.throwUninitializedPropertyAccessException("mLarkDeviceIdApi");
        goto L11
    }
}
