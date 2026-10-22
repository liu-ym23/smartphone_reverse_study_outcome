package com.larus.init.task.imsdk;

import com.larus.home.impl.sdk.p1;
import com.larus.im.internal.jni.dependency.OmniWebSocketCallByNative;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.p2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements gd9.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f351360a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, p2> f351361b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArraySet<Function1<byte[], Unit>> f351362c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f351363d = null;

    public e() {
    }

    @Override // gd9.n
    public final synchronized void a() {
        monitor-enter(this);
        ConcurrentHashMap<Integer, p2> r100 = f351361b;     // Catch: Throwable -> L18
        if (r100.containsKey(Integer.valueOf(OmniWebSocketCallByNative.DISPATCH_COMMAND_SERVICE_ID)) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        IFlowSdkDepend r101 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L18
        if (r101 == null) goto L10;
        p1 r102 = r101.B(OmniWebSocketCallByNative.DISPATCH_COMMAND_SERVICE_ID);     // Catch: Throwable -> L18
    L11:
        if (r102 != null) goto L15;
        FLogger.f375446a.e("ExtraFrontierDependImpl", "registerService failed, serviceId=33555736 frontier is null");     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L15:
        r102.b(f351363d);     // Catch: Throwable -> L18
        r100.put(Integer.valueOf(OmniWebSocketCallByNative.DISPATCH_COMMAND_SERVICE_ID), r102);     // Catch: Throwable -> L18
        FLogger.f375446a.i("ExtraFrontierDependImpl", "registerService success, serviceId=33555736");     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L10:
        r102 = null;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // gd9.n
    public final synchronized void b() {
        monitor-enter(this);
        p2 r100 = f351361b.remove(Integer.valueOf(OmniWebSocketCallByNative.DISPATCH_COMMAND_SERVICE_ID));     // Catch: Throwable -> L10
        if (r100 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        r100.d(f351363d);     // Catch: Throwable -> L10
        FLogger.f375446a.i("ExtraFrontierDependImpl", "unregisterService success, serviceId=33555736");     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.init.task.imsdk.d] */
    static {
        f351360a = new e();
        f351361b = new ConcurrentHashMap();
        f351362c = new CopyOnWriteArraySet();
        f351363d = new d();
    }

    @Override // gd9.n
    public final void d(Function1<? super byte[], Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        f351362c.remove(r100);
    }

    @Override // gd9.n
    public final void e(Function1<? super byte[], Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        f351362c.add(r100);
    }
}
