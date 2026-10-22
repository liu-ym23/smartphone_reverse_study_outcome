package com.bytedance.creativex.mediaimport.view.internal.validator;

import com.bytedance.services.apm.api.EnsureManager;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import ki4.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements ei4.b<r> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f204101a = null;

    static {
        f204101a = new f();
    }

    public f() {
    }

    @Override // ei4.b
    public final void a(Object r100) {
        r r101 = (r) r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        if (r101.getWidth() != 0) goto L5;
    L14:
        b.a(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        FLogger.f375446a.e("BuiltinValidators", "MediaDimensionUpdatePreviewValidator tryUpdateWidthHeight error", th);
        EnsureManager.ensureNotReachHere(th, "BuiltinValidators");
        if (AppHost.f326268a.isDebug() == true) goto L13;
        return;
    L13:
        throw th;
    L5:
        if (r101.getHeight() == 0) goto L14;
    }
}
