package com.ivy.ivykit.plugin.impl.utils;

import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class h implements c47.a {
    public h() {
    }

    @Override // c47.a
    public final com.bytedance.pia.core.setting.b getPIAConfig() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return (com.bytedance.pia.core.setting.b) r101.n0(com.bytedance.pia.core.setting.b.class);
    }

    @Override // c47.a
    public final <T> T a(String r100, Type r101, T r110) {
        if (r100 == null) goto L17;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Object r103 = com.bytedance.dataplatform.o.d(r100, r101, r110, false, true, null);     // Catch: Throwable -> L8
        if (r103 != null) goto L6;
        Intrinsics.throwNpe();     // Catch: Throwable -> L8
    L6:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r104) == false) goto L14;
        return r110;
    L14:
        return (T) r104;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    L17:
        return r110;
    }
}
