package com.larus.reach.runtime;

import com.larus.reach.api.ReachBannerHost;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes31.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f367352a = 0;

    static {
    }

    public static long b() {
        ns9.k r100 = ns9.k.f520390a;
        monitor-enter(r100);
        long r101 = ns9.k.f520392c;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public static void c() {
        ns9.k r100 = ns9.k.f520390a;
        monitor-enter(r100);
        ns9.k.f520392c++;     // Catch: Throwable -> L9
        Function0<Unit> r101 = ns9.k.f520391b;     // Catch: Throwable -> L9
        ns9.k.f520391b = null;     // Catch: Throwable -> L9
        monitor-exit(r100);
        if (r101 == null) goto L14;
        r101.invoke();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static ReachBannerHost d(final ns9.t r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Set r101 = ServiceManager.get().getServices(ReachBannerHost.class, true);
        if (r101 != null) goto L6;
        r101 = SetsKt.emptySet();
    L6:
        return (ReachBannerHost) SequencesKt.firstOrNull(SequencesKt.filter(CollectionsKt.asSequence(CollectionsKt.toList(r101)), new u(r100)));
    }

    public static boolean a(long r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r101, "waiter");
        ns9.k r102 = ns9.k.f520390a;
        Intrinsics.checkNotNullParameter(r101, "waiter");
        monitor-enter(r102);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (ns9.k.f520392c == r100) goto L7;
        boolean r103 = false;
    L9:
        monitor-exit(r102);
        return r103;
    L7:
        ns9.k.f520391b = r101;     // Catch: Throwable -> L11
        r103 = true;
        goto L9
    }
}
