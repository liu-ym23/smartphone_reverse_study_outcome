package com.ss.android.lark.scs.policy.engine.manage;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f439851a = 0;

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        ke6.d.h("USER_ID", Long.valueOf(CastLongProtector.parseLong(r100)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        n3c.b.f517015a.e("ParamsInjector", "inject userId error e = " + e);
    }
}
