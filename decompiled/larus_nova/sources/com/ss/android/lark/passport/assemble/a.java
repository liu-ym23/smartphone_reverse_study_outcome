package com.ss.android.lark.passport.assemble;

import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class a implements com.ss.android.lark.passport.dpop.a {
    @Inject
    public a() {
    }

    @Override // com.ss.android.lark.passport.dpop.a
    public final com.ss.android.lark.passport.dpop.a.b a() {
        Object r100 = ((Result) DPoPServiceInst.f437682a.getValue()).m9458unboximpl();
        if (Result.m9456isSuccessimpl(r100) == false) goto L11;
        com.bytedance.dpop.d r101 = ((com.bytedance.dpop.c) r100).a();
        String r102 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullParameter(r102, "str");
        r101.f204781b.put("jti", r102);
        Object r103 = r101.a();
        if (Result.m9456isSuccessimpl(r103) == false) goto L8;
        return new com.ss.android.lark.passport.dpop.a.f((String) r103);
    L8:
        if (Result.m9452exceptionOrNullimpl(r103) == null) goto L11;
        return new com.ss.android.lark.passport.dpop.a.e();
    L11:
        if (Result.m9452exceptionOrNullimpl(r100) == null) goto L14;
        return new com.ss.android.lark.passport.dpop.a.d();
    L14:
        return com.ss.android.lark.passport.dpop.a.c.f437723a;
    }
}
