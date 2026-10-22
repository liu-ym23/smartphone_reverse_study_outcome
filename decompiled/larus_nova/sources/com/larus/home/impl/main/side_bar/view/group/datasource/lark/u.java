package com.larus.home.impl.main.side_bar.view.group.datasource.lark;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class u {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f345445f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<eb9.l, g> f345446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Object> f345447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f345448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f345449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f345450e;

    public static final class a {
    }

    static {
    }

    public static String b(g r100) {
        return "port=" + com.larus.home.impl.main.side_bar.feed.arch.t.e(r100);
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        g r101 = this.f345448c;
        if (r101 != null) goto L5;
        return;
    L5:
        this.f345448c = null;
        this.f345449d = null;
        this.f345450e++;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        r101.release();     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L11:
        if (Result.m9456isSuccessimpl(r103) == false) goto L13;
        Unit r104 = (Unit) r103;
        int r105 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("human_port_release", b(r101) + " reason=" + r100);
    L13:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r103);
        if (r106 == null) goto L19;
        int r107 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.b("human_port_release_fail", b(r101) + " reason=" + r100, r106);
        return;
    L19:
        return;
    L8:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public u(s r100, t r101) {
        Intrinsics.checkNotNullParameter(r100, "createPort");
        Intrinsics.checkNotNullParameter(r101, "currentUserKey");
        this.f345446a = r100;
        this.f345447b = r101;
    }
}
