package com.larus.home.impl.main.side_bar.data;

import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class SideBarPreloadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SideBarPreloadManager f344463a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f344464b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static SideBarConfigModel f344465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f344466d;

    public SideBarPreloadManager() {
    }

    static {
        f344463a = new SideBarPreloadManager();
        f344464b = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.larus.home.impl.main.side_bar.data.SideBarConfigModel] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v18, types: [com.larus.home.impl.main.side_bar.data.SideBarConfigModel] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.home.impl.main.side_bar.data.SideBarPreloadManager$preloadData$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.home.impl.main.side_bar.data.SideBarConfigModel] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.larus.home.impl.main.side_bar.data.SideBarConfigModel, java.lang.Object] */
    public final Object a(Continuation<? super Unit> r100) {
        if ((r100 instanceof SideBarPreloadManager$preloadData$1) == false) goto L7;
        SideBarPreloadManager$preloadData$1 r101 = (SideBarPreloadManager$preloadData$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
        ?? r103 = r101;
    L8:
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        boolean r107 = true;
        if (r106 == 0) goto L22;
        if (r106 != 1) goto L21;
        r103 = (SideBarConfigModel) r103.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L14 Exception -> L16 CancellationException -> L18
        ?? r108 = r103;
    L35:
        Object r109 = f344464b;
        monitor-enter(r109);
    L45:
        th = move-exception;
        throw th;
    L38:
        if (f344465c != r108) goto L41;
        r107 = false;
    L41:
        f344466d = false;     // Catch: Throwable -> L45
        ?? r110 = r108;
        monitor-exit(r109);
        if (r107 == false) goto L69;
    L67:
        r110.d();
    L69:
        return Unit.INSTANCE;
    L18:
        e = e;
    L78:
        Object r111 = f344464b;     // Catch: Throwable -> L14
        monitor-enter(r111);     // Catch: Throwable -> L14
    L86:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L81:
        if (f344465c != r103) goto L83;
        f344465c = null;     // Catch: Throwable -> L86
    L83:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L86
        monitor-exit(r111);     // Catch: Throwable -> L14
        throw e;     // Catch: Throwable -> L14
    L16:
        e = e;
    L52:
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);     // Catch: Throwable -> L14
        Object r113 = f344464b;     // Catch: Throwable -> L14
        monitor-enter(r113);     // Catch: Throwable -> L14
    L73:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L55:
        if (f344465c != r103) goto L57;
        f344465c = null;     // Catch: Throwable -> L73
    L57:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L73
        monitor-exit(r113);     // Catch: Throwable -> L14
        monitor-enter(r113);
    L70:
        th = move-exception;
        throw th;
    L61:
        if (f344465c != r103) goto L64;
        r107 = false;
    L64:
        f344466d = false;     // Catch: Throwable -> L70
        r110 = r103;
        monitor-exit(r113);
        if (r107 == false) goto L69;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        ResultKt.throwOnFailure(r104);
        Object r115 = f344464b;
        monitor-enter(r115);
    L107:
        th = move-exception;
        throw th;
    L25:
        if (f344465c == null) goto L27;
    L104:
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L107
        monitor-exit(r115);
        return r116;
    L27:
        if (f344466d == true) goto L104;
        f344466d = true;     // Catch: Throwable -> L107
        ?? r117 = new SideBarConfigModel(true);     // Catch: Throwable -> L107
        f344465c = r117;     // Catch: Throwable -> L107
        monitor-exit(r115);
        r103.L$0 = r117;     // Catch: Throwable -> L48 Exception -> L50 CancellationException -> L76
        r103.label = 1;     // Catch: Throwable -> L48 Exception -> L50 CancellationException -> L76
        if (r117.i(null, r103) != r105) goto L34;
        return r105;
    L34:
        r108 = r117;
        goto L35
    L76:
        e = e;
        r103 = r117;
    L50:
        e = e;
        r103 = r117;
    L48:
        th = th;
    L90:
        Object r118 = f344464b;
        monitor-enter(r118);
    L101:
        th = move-exception;
        throw th;
    L93:
        if (f344465c != r117) goto L96;
        r107 = false;
    L96:
        f344466d = false;     // Catch: Throwable -> L101
        monitor-exit(r118);
        if (r107 == false) goto L100;
        r117.d();
    L100:
        throw th;
    L14:
        th = th;
        r117 = r103;
    L7:
        r103 = new SideBarPreloadManager$preloadData$1(this, r100);
        goto L8
    }
}
