package com.ss.android.lark.compose.chatsetting.common.repository;

import com.lark.kmp.rustclient.api.d;
import com.ss.android.lark.passportc.entity.UserSession;
import gy7.q;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes35.dex */
public final class b {
    public static final d a(UserSession r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = iy7.a.b(new q(r100.f438138b, r100.f438137a)).a(Reflection.getOrCreateKotlinClass(d.class));
        if (r101 == null) goto L7;
        return (d) r101;
    L7:
        throw new IllegalArgumentException("No instance of " + Reflection.getOrCreateKotlinClass(d.class).getSimpleName() + " found");
    }
}
