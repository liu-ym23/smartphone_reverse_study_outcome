package com.ss.android.lark.integrator.security.compliance.screen_audit;

import com.ss.android.lark.log.Log;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f428127a;

    public c(b r100) {
        this.f428127a = r100;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        b r102 = this.f428127a;
        Intrinsics.checkNotNull(r101);
        int r103 = r101.intValue();
        if (r103 == r102.f428126c) goto L11;
        r102.f428126c = r103;
        if (r103 != 1) goto L8;
        Log.i("OfficeSDKScreenAudit", "screen recording entered VISIBLE");
        r102.f428124a.a();
        return;
    L8:
        Log.i("OfficeSDKScreenAudit", "screen recording state changed: " + r103);
        return;
    }
}
