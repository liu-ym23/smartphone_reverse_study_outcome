package com.larus.init.task;

import android.os.Process;
import com.larus.common.apphost.AppHost;
import com.larus.init.task.idle.InitOfficeSdkIdleTask;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes4.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f351465a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f351466b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f351467c = null;

    static {
        f351465a = new AtomicBoolean(false);
        f351466b = new AtomicBoolean(false);
        f351467c = LazyKt.lazy(new w0());
    }

    public static boolean a() {
        if (ObricFeatureServiceDelegate.f387839b.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) f351467c.getValue()).booleanValue() == false) goto L7;
        return true;
    }

    public static void b() {
        if (a() == true) goto L7;
        FLogger.f375446a.i("OfficeSdkLazyInitController", "tryInit skipped: lazy path not enabled");
        return;
    L7:
        if (f351465a.compareAndSet(false, true) == true) goto L11;
        FLogger.f375446a.i("OfficeSdkLazyInitController", "office sdk lazy init already triggered, skip");
        return;
    L11:
        if (com.bytedance.apm.util.u.a() == true) goto L13;
        FLogger.f375446a.e("OfficeSdkLazyInitController", "tryInit must be called on main thread, current=" + ThreadMethodProxy.currentThread().getName());
    L13:
        FLogger.f375446a.i("OfficeSdkLazyInitController", "tryInit: start, replay Launch + Idle, process=" + Process.myPid());
        InitOfficeSdkLaunchTask r100 = new InitOfficeSdkLaunchTask();     // Catch: Exception -> L16
        r100.f351071a = true;     // Catch: Exception -> L16
        r100.run();     // Catch: Exception -> L16
    L29:
        InitOfficeSdkIdleTask r101 = new InitOfficeSdkIdleTask();     // Catch: Exception -> L21
        r101.f351338a = true;     // Catch: Exception -> L21
        r101.run();     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        FLogger.f375446a.e("OfficeSdkLazyInitController", "InitOfficeSdkIdleTask failed", e);
        if (AppHost.f326268a.isTestChannel() == true) goto L25;
        return;
    L25:
        throw e;
    L16:
        e = move-exception;
        FLogger.f375446a.e("OfficeSdkLazyInitController", "InitOfficeSdkLaunchTask failed", e);
        if (AppHost.f326268a.isTestChannel() == false) goto L29;
        throw e;
    }
}
