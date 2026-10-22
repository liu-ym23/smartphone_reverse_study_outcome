package com.larus.dora.impl.util;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f338160a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f338161b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f338162c = null;

    public x() {
    }

    static {
        f338160a = new x();
        f338161b = LazyKt.lazy(new v());
        f338162c = LazyKt.lazy(new w());
    }

    public static com.larus.dora.impl.network.f0 a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        b0.f338123a.getClass();     // Catch: Throwable -> L4
        String r101 = b0.j().getString("dora_user_settings", "");     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl((com.larus.dora.impl.network.f0) ((Gson) f338162c.getValue()).fromJson(r101, com.larus.dora.impl.network.f0.class));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        return (com.larus.dora.impl.network.f0) r102;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static void b(com.larus.dora.impl.network.f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "settings");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        b0.f338123a.getClass();     // Catch: Throwable -> L5
        b0.j().storeString("dora_user_settings", ((Gson) f338162c.getValue()).toJson(r100));     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
