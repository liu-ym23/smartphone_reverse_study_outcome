package com.bytedance.frameworks.baselib.netx.partner.mutable;

import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.mime.TypedOutput;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f244842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypedOutput f244843b;

    public c(Request r100) {
        Intrinsics.checkNotNullParameter(r100, "originRequest");
        String r101 = r100.getMethod();
        if (r101 == null) goto L7;
        this.f244842a = r101;
        this.f244843b = r100.getBody();
        r100.getRequestBody();
        return;
    L7:
        throw new NullPointerException("Method must not be null.");
    }
}
