package com.ss.android.lark.auditsdk.screen;

import com.ss.android.lark.log.Log;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements d {

    /* JADX INFO: renamed from: com.ss.android.lark.auditsdk.screen.a$a, reason: collision with other inner class name */
    public static final class C4759a {
    }

    static {
    }

    @Inject
    public a() {
    }

    @Override // com.ss.android.lark.auditsdk.screen.d
    public final void a() {
        Intrinsics.checkNotNullParameter("", "currentPage");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        owa.a.a().getClass();     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter("", "currentPage");     // Catch: Throwable -> L5
        com.ss.android.lark.auditsdk.wrapper.b r101 = com.ss.android.lark.auditsdk.wrapper.b.d.f409722a;     // Catch: Throwable -> L5
        int r102 = com.ss.android.lark.auditsdk.wrapper.a.f409708a;     // Catch: Throwable -> L5
        r101.a(com.ss.android.lark.auditsdk.wrapper.a.C4763a.b());     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L13;
        Log.e("ScreenAudit", "report screen recording failed", r104);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.ss.android.lark.auditsdk.screen.d
    public final void b() {
        Intrinsics.checkNotNullParameter("", "currentPage");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        owa.a.a().getClass();     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter("", "currentPage");     // Catch: Throwable -> L5
        com.ss.android.lark.auditsdk.wrapper.b r101 = com.ss.android.lark.auditsdk.wrapper.b.d.f409722a;     // Catch: Throwable -> L5
        int r102 = com.ss.android.lark.auditsdk.wrapper.a.f409708a;     // Catch: Throwable -> L5
        r101.a(com.ss.android.lark.auditsdk.wrapper.a.C4763a.c());     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L13;
        Log.e("ScreenAudit", "report screenshot failed", r104);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
