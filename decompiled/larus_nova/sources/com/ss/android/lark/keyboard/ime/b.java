package com.ss.android.lark.keyboard.ime;

import com.ss.android.lark.KeyboardBaseModule;
import com.ss.android.lark.log.Log;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f429377a = null;

    static {
        f429377a = new b();
    }

    public b() {
    }

    public static void a(String r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        if (KeyboardBaseModule.a().isFeatureGatingEnable("messenger.im.disable_ime_diag_log") == true) goto L6;
        boolean r103 = true;
    L7:
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(r103));     // Catch: Throwable -> L9
    L11:
        Boolean r105 = Boolean.TRUE;
        if (Result.m9455isFailureimpl(r104) == false) goto L15;
        r104 = r105;
    L15:
        if (((Boolean) r104).booleanValue() == false) goto L20;
        Log.i(r100, (String) r101.invoke());
        return;
    L20:
        return;
    L6:
        r103 = false;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
