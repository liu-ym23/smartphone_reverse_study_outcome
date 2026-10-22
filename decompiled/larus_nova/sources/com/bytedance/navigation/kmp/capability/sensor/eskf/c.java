package com.bytedance.navigation.kmp.capability.sensor.eskf;

import android.content.Context;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f265819a = null;

    static {
        f265819a = new c();
    }

    public c() {
    }

    public static bv5.f a(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Function0 r101 = new a();
        Function0 r102 = new b(r100);
        Intrinsics.checkNotNullParameter(r101, "settingsJson");
        Intrinsics.checkNotNullParameter(r102, "assetsJson");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl((String) r101.invoke());     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r104) == false) goto L10;
        r104 = null;
    L10:
        String r105 = (String) r104;
        if (r105 != null) goto L13;
    L16:
        boolean r106 = true;
    L17:
        if (r106 == false) goto L30;
    L28:
        int r107 = f.f265823a;
        return f.a((String) r102.invoke());
    L30:
        Object r108 = Result.m9449constructorimpl(f.a(r105));     // Catch: Throwable -> L20
    L23:
        if (Result.m9456isSuccessimpl(r108) == false) goto L25;
        bv5.f r109 = (bv5.f) r108;
        d37.i.f466749a.h("EskfConfigSource", "ESKF config from settings");
        return r109;
    L25:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r108);
        if (r110 == null) goto L28;
        d37.i.f466749a.j("EskfConfigSource", "settings ESKF config parse failed, fallback to assets", r110);
    L20:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L13:
        if (StringsKt.isBlank(r105) == true) goto L16;
        r106 = false;
    L5:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
