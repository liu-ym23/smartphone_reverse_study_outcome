package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import xi2.h0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y<T, R> implements Function {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ String b;

    public y(b0 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r6) {
        h0 r7 = (h0) r6;
        Intrinsics.checkNotNullParameter(r7, "ecUploadImageResponse");
        if (((com.bytedance.android.ec.model.g) r7).statusCode != 0) goto L10;
        r7.toString();
        String r0 = this.a.f;
        h0.a r8 = r7.data;
        if (r8 == null) goto L7;
        String r9 = r8.picTosKey;
    L8:
        String r2 = this.b;
        String r3 = vi2.h.a;
        String r4 = vi2.h.d(si2.g.A);
        return vi2.h.e(null, null, r4, new vi2.s(r0, r9, r2, r4));
    L7:
        r9 = null;
        goto L8
    L10:
        return null;
    }
}
