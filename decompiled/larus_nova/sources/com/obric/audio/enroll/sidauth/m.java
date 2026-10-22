package com.obric.audio.enroll.sidauth;

import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f395563a = null;

    static {
        f395563a = new m();
    }

    public m() {
    }

    public static void a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        pia.b r101 = pia.b.f529407a;     // Catch: Throwable -> L4
        pia.b.d("obric.sid_auth.registered_version");     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L12;
        FLogger.f375446a.e("SidAuthRegisterStateStore", "clear fail: " + r103.getMessage());
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static String b() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        pia.b r101 = pia.b.f529407a;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(pia.b.b("obric.sid_auth.registered_version"));     // Catch: Throwable -> L4
    L6:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L10;
        FLogger.f375446a.e("SidAuthRegisterStateStore", "getRegisteredVersion fail: " + r103.getMessage());
    L10:
        if (Result.m9455isFailureimpl(r102) == false) goto L13;
        r102 = "";
    L13:
        return (String) r102;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "version");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L19;
        return;
    L19:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        pia.b r103 = pia.b.f529407a;     // Catch: Throwable -> L10
        pia.b.c("obric.sid_auth.registered_version", r100);     // Catch: Throwable -> L10
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L16;
        FLogger.f375446a.e("SidAuthRegisterStateStore", "markRegistered fail version=" + r100 + ": " + r105.getMessage());
    L16:
        if (Result.m9456isSuccessimpl(r104) == false) goto L21;
        Unit r106 = (Unit) r104;
        FLogger.f375446a.i("SidAuthRegisterStateStore", "markRegistered version=".concat(r100));
        return;
    L21:
        return;
    L10:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L5:
        r101 = false;
        goto L6
    }
}
