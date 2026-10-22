package com.bytedance.ee.bear.middleground.comment.input;

import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f231893a = 0;

    static {
    }

    public static void a(FragmentActivity r100, kf5.b r101, Function0 r102, Function0 r103, Function0 r104) {
        Intrinsics.checkNotNullParameter(r100, "hostActivity");
        Intrinsics.checkNotNullParameter(r101, "inputComment");
        Intrinsics.checkNotNullParameter(r102, "onReturnToHost");
        Intrinsics.checkNotNullParameter(r104, MusicAppletPage.ROUTE_MODE_NAVIGATION);
        r101.a("BotConfigKeepAlive");
        z1 r105 = new z1(r100, r101, r102);
        AppLifecycle.a.f408803a.b(r105);
        r103.invoke();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L5
        Object r107 = Result.m9449constructorimpl(r104.invoke());     // Catch: Throwable -> L5
    L8:
        if (Result.m9452exceptionOrNullimpl(r107) == null) goto L13;
        AppLifecycle.a.f408803a.j(r105);
        r101.c("BotConfigKeepAlive");
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
