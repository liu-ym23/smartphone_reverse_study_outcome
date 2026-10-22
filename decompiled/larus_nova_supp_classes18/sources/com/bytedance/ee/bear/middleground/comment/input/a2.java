package com.bytedance.ee.bear.middleground.comment.input;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a2 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(FragmentActivity r2, kf5.b r3, Function0 r4, Function0 r5, Function0 r6) {
        Intrinsics.checkNotNullParameter(r2, "hostActivity");
        Intrinsics.checkNotNullParameter(r3, "inputComment");
        Intrinsics.checkNotNullParameter(r4, "onReturnToHost");
        Intrinsics.checkNotNullParameter(r6, "navigate");
        r3.a("BotConfigKeepAlive");
        z1 r1 = new z1(r2, r3, r4);
        AppLifecycle.a.a.b(r1);
        r5.invoke();
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl(r6.invoke());     // Catch: Throwable -> L5
    L8:
        if (Result.exceptionOrNull-impl(r8) == null) goto L13;
        AppLifecycle.a.a.j(r1);
        r3.c("BotConfigKeepAlive");
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
