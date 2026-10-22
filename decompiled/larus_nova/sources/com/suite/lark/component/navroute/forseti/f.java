package com.suite.lark.component.navroute.forseti;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.ss.android.lark.log.Log;
import com.suite.lark.component.navroute.NavRouter;
import com.suite.lark.component.navroute.group.NavRouterProvider;
import dagger.hilt.android.internal.managers.ViewComponentManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes40.dex */
public final class f {
    public static final g a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L15
        if ((r100 instanceof ViewComponentManager.FragmentContextWrapper) == false) goto L10;
        if ((((ViewComponentManager.FragmentContextWrapper) r100).getBaseContext() instanceof ViewComponentManager.FragmentContextWrapper) == true) goto L10;
        return a(((ViewComponentManager.FragmentContextWrapper) r100).getBaseContext());
    L10:
        if ((r100 instanceof FragmentActivity) == true) goto L12;
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L23;
        Log.e("ForsetiRouter", "Context.forsetiRouter throw Exception", r103);
        return null;
    L23:
        return null;
    L12:
        return c((FragmentActivity) r100, false);
    L15:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public static final g b(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        g.f460343a.getClass();
        return g.a.a(r100, null);
    }

    public static final g c(FragmentActivity r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        g.f460343a.getClass();
        Intrinsics.checkNotNullParameter(r100, "activity");
        com.suite.lark.component.navroute.api.a r102 = null;
        if (r101 == true) goto L19;
    L13:
        NavRouter.a r103 = NavRouter.f460191a;
        if (NavRouter.c(Reflection.getOrCreateKotlinClass(g.class)) == false) goto L18;
        NavRouterProvider r104 = NavRouter.f460192b;
        KClass r105 = Reflection.getOrCreateKotlinClass(g.class);
        r104.getClass();
        r102 = NavRouterProvider.b(r100, r105, null);
    L18:
        return (g) r102;
    L19:
        int r106 = j.f460349a;     // Catch: IllegalStateException -> L12
        Intrinsics.checkNotNullParameter(sua.a.class, "apiClass");     // Catch: IllegalStateException -> L12
        Fragment r107 = ((sua.a) ClaymoreServiceLoader.loadFirst(sua.a.class)).getChainManager(r100).E();     // Catch: IllegalStateException -> L12
        if (r107 == null) goto L13;
        NavRouter.a r108 = NavRouter.f460191a;     // Catch: IllegalStateException -> L12
        if (NavRouter.c(Reflection.getOrCreateKotlinClass(g.class)) == true) goto L9;
        com.suite.lark.component.navroute.api.a r109 = null;
    L10:
        return (g) r109;
    L9:
        NavRouterProvider r110 = NavRouter.f460192b;     // Catch: IllegalStateException -> L12
        KClass r111 = Reflection.getOrCreateKotlinClass(g.class);     // Catch: IllegalStateException -> L12
        r110.getClass();     // Catch: IllegalStateException -> L12
        r109 = NavRouterProvider.a(r107, r111, null);     // Catch: IllegalStateException -> L12
    L12:
        Log.w("NavRouter", "forseti chain manager not found in activity :".concat(r100.getClass().getName()));
        goto L13
    }
}
