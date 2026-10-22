package org.koin.android.ext.koin;

import android.app.Application;
import android.content.Context;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.b;
import org.koin.core.logger.Level;

/* JADX INFO: loaded from: classes42.dex */
public final class a {
    public static final void a(b r100, final Context r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "androidContext");
        jwc.a r102 = r100.f526127a.f526124c;
        Level r103 = Level.INFO;
        if (r102.c(r103) == false) goto L6;
        jwc.a r104 = r100.f526127a.f526124c;
        r104.getClass();
        Intrinsics.checkNotNullParameter("[init] declare Android Context", "msg");
        r104.b(r103, "[init] declare Android Context");
    L6:
        if ((r101 instanceof Application) == false) goto L8;
        r100.f526127a.c(CollectionsKt.listOf(owc.b.a(new KoinExtKt$androidContext$1(r101))), false);
        return;
    L8:
        r100.f526127a.c(CollectionsKt.listOf(owc.b.a(new KoinExtKt$androidContext$2(r101))), false);
    }
}
