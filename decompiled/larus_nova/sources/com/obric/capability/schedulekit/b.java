package com.obric.capability.schedulekit;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f396036a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<a> f396037b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArraySet<Function0<Unit>> f396038c = null;

    /* JADX INFO: loaded from: classes33.dex */
    public interface a {
        void call();
    }

    static {
        f396036a = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new com.obric.capability.schedulekit.a())));
        f396037b = new ArrayList();
        f396038c = new CopyOnWriteArraySet();
    }

    public static void a() {
        ScheduleServiceConnection r100 = ScheduleServiceConnection.f396032a;
        throw new RuntimeException("you need to invoke CapabilityScheduleSdk.init!");
    }

    public static void b() {
        via.b r100 = via.b.f555361a;
        Intrinsics.checkNotNullParameter("CapabilityScheduleSdk", "tag");
        int r101 = via.a.f555360a;
        List<a> r102 = f396037b;
        monitor-enter(r102);
        Iterator r103 = ((ArrayList) r102).iterator();     // Catch: Throwable -> L12
    L6:
        if (r103.hasNext() == false) goto L8;
        a r104 = (a) r103.next();     // Catch: Throwable -> L12
        via.b r105 = via.b.f555361a;     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter("CapabilityScheduleSdk", "tag");     // Catch: Throwable -> L12
        int r106 = via.a.f555360a;     // Catch: Throwable -> L12
        r104.call();     // Catch: Throwable -> L12
        goto L6
    L8:
        ((ArrayList) f396037b).clear();     // Catch: Throwable -> L12
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r102);
        throw new RuntimeException("you need to invoke CapabilityScheduleSdk.init!");
    L12:
        th = move-exception;
        throw th;
    }

    public static void c() {
        Iterator<Function0<Unit>> r100 = f396038c.iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        Function0<Unit> r101 = r100.next();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        r101.invoke();     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L4;
        via.b r105 = via.b.f555361a;
        ExceptionsKt.stackTraceToString(r104);
        Intrinsics.checkNotNullParameter("CapabilityScheduleSdk", "tag");
        int r106 = via.a.f555360a;
        Intrinsics.checkNotNullParameter("ac_".concat("CapabilityScheduleSdk"), "tag");
    L8:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
