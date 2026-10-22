package com.larus.avlink.gallery.business;

import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet<c> f292365a = null;

    static {
        f292365a = new CopyOnWriteArraySet();
    }

    public static void b(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        f292365a.add(r100);
        FLogger.f375446a.d("AlbumMediaChangeDispatcher", "Registered listener: ".concat(r100.getClass().getSimpleName()));
    }

    public static void c(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        f292365a.remove(r100);
        FLogger.f375446a.d("AlbumMediaChangeDispatcher", "Unregistered listener: ".concat(r100.getClass().getSimpleName()));
    }

    public static void a(List r100, List r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "uniqIds");
        Intrinsics.checkNotNullParameter(r101, "paths");
        Intrinsics.checkNotNullParameter(r102, "source");
        if (r100.isEmpty() == true) goto L5;
    L7:
        List r103 = CollectionsKt.distinct(r100);
        ArrayList r104 = new ArrayList();
        Iterator r105 = r101.iterator();
    L9:
        if (r105.hasNext() == false) goto L13;
        Object r106 = r105.next();
        if ((!StringsKt.isBlank((String) r106)) == false) goto L9;
        r104.add(r106);
        goto L9
    L13:
        b.a r107 = new b.a(r103, CollectionsKt.distinct(r104), r102);
        Intrinsics.checkNotNullParameter(r107, "event");
        FLogger r108 = FLogger.f375446a;
        StringBuilder r109 = new StringBuilder("notifyChanged: event=");
        r109.append(r107);
        r109.append(", listenerCount=");
        CopyOnWriteArraySet<c> r110 = f292365a;
        r109.append(r110.size());
        r108.i("AlbumMediaChangeDispatcher", r109.toString());
        Iterator<c> r111 = r110.iterator();
    L15:
        if (r111.hasNext() == false) goto L24;
        c r112 = r111.next();
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L19
        r112.a(r107);     // Catch: Throwable -> L19
        Object r114 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L15;
        FLogger.f375446a.e("AlbumMediaChangeDispatcher", "notifyChanged listener failed", r115);
    L19:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L24:
        return;
    L5:
        if (r101.isEmpty() == false) goto L7;
    }
}
