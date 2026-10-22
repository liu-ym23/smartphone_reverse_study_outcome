package com.obric.assistant.keepalive;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes6.dex */
public final class ObricKeepAliveLevelController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricKeepAliveLevelController f390015a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f390016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f390017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile String f390018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CopyOnWriteArrayList<Function1<String, Unit>> f390019e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CoroutineScope f390020f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Job f390021g;

    public ObricKeepAliveLevelController() {
    }

    public final synchronized void a() {
        monitor-enter(this);
        Job r100 = f390021g;     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);     // Catch: Throwable -> L9
    L6:
        f390021g = BuildersKt.launch$default(f390020f, null, null, new ObricKeepAliveLevelController$scheduleClearDoraPrivateLinkOverlay$1(null), 3, null);     // Catch: Throwable -> L9
        FLogger.f375446a.i("ObricKeepAliveLevel", "schedule clear dora private link overlay after 5000ms");     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    static {
        f390015a = new ObricKeepAliveLevelController();
        f390019e = new CopyOnWriteArrayList();
        f390020f = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
    }

    public final synchronized boolean b(String r100) {
        String r101 = "dora_private_link";
        monitor-enter(this);
        Intrinsics.checkNotNullParameter("dora_private_link", "scene");     // Catch: Throwable -> L35
        String r102 = f390017c;     // Catch: Throwable -> L35
        if (r102 != null) goto L8;
        r102 = ObricFeatureServiceDelegate.f387839b.f();     // Catch: Throwable -> L35
    L8:
        if (Intrinsics.areEqual(f390017c, r100) == false) goto L13;
        FLogger.f375446a.i("ObricKeepAliveLevel", "setKeepAliveLevelOverlay skip, scene=dora_private_link, overlay=" + r100 + ", overlayScene=" + f390018d + ", level=" + r102);     // Catch: Throwable -> L35
        monitor-exit(this);
        return false;
    L13:
        f390017c = r100;     // Catch: Throwable -> L35
        if (r100 != null) goto L16;
        r101 = null;
    L16:
        f390018d = r101;     // Catch: Throwable -> L35
        String r103 = f390017c;     // Catch: Throwable -> L35
        if (r103 != null) goto L19;
        r103 = ObricFeatureServiceDelegate.f387839b.f();     // Catch: Throwable -> L35
    L19:
        FLogger.f375446a.i("ObricKeepAliveLevel", "setKeepAliveLevelOverlay scene=dora_private_link, overlay=" + r100 + ", oldLevel=" + r102 + ", newLevel=" + r103);     // Catch: Throwable -> L35
        boolean r104 = Intrinsics.areEqual(r102, r103) ^ true;     // Catch: Throwable -> L35
        if (r104 == false) goto L33;
        Iterator<Function1<String, Unit>> r105 = f390019e.iterator();     // Catch: Throwable -> L35
    L23:
        if (r105.hasNext() == false) goto L33;
        Function1<String, Unit> r106 = r105.next();     // Catch: Throwable -> L35
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L27
        r106.invoke(r103);     // Catch: Throwable -> L27
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L35
        if (r109 == null) goto L23;
        FLogger.f375446a.e("ObricKeepAliveLevel", "notify keep alive level listener failed", r109);     // Catch: Throwable -> L35
        goto L23
    L27:
        th = move-exception;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L35
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L35
    L33:
        monitor-exit(this);
        return r104;
    L35:
        th = move-exception;
        throw th;
    }
}
