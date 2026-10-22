package com.obric.aiagent.ipc.utils;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public static final Map<String, String> b(Map<Object, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<Map.Entry<Object, ? extends Object>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        Map.Entry<Object, ? extends Object> r103 = r102.next();
        Object r104 = r103.getKey();
        Object r105 = r103.getValue();
        r101.add(TuplesKt.to(String.valueOf(r104), String.valueOf(r105)));
        goto L4
    L7:
        return MapsKt.toMap(r101);
    }

    public static final <S extends IInterface> void a(RemoteCallbackList<S> r100, Function1<? super S, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "action");
        monitor-enter(r100);
        int r102 = r100.beginBroadcast();     // Catch: Throwable -> L24
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L21;
        IInterface r104 = r100.getBroadcastItem(r103);     // Catch: Throwable -> L24
        if (r104 == null) goto L14;
        IBinder r105 = r104.asBinder();     // Catch: Throwable -> L24
        if (r105 == null) goto L14;
        boolean r106 = true;
        if (r105.isBinderAlive() != true) goto L14;
    L15:
        if (r106 == false) goto L20;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L18
        Result.m9449constructorimpl(r101.invoke(r104));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L24
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L24
    L20:
        r103 = r103 + 1;     // Catch: Throwable -> L24
    L14:
        r106 = false;
        goto L15
    L21:
        r100.finishBroadcast();     // Catch: Throwable -> L24
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r100);
        return;
    L24:
        th = move-exception;
        throw th;
    }
}
