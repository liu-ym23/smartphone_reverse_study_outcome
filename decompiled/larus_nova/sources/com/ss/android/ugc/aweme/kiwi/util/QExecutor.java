package com.ss.android.ugc.aweme.kiwi.util;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/kiwi/util/QExecutor;", "", "<init>", "()V", "kiwi_release"}, k = 1, mv = {1, 4, 0})
public final class QExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Handler f450929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f450930b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final QExecutor f450931c = null;

    private QExecutor() {
    }

    static {
        f450931c = new QExecutor();
        f450930b = new Handler(Looper.getMainLooper());
    }

    public final Handler a() {
        if (f450929a != null) goto L14;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (f450929a != null) goto L8;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("QWorkThread");     // Catch: Throwable -> L11
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L11
        f450929a = new Handler(r100.getLooper());     // Catch: Throwable -> L11
    L8:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
    L14:
        Handler r102 = f450929a;
        if (r102 != null) goto L17;
        Intrinsics.throwNpe();
    L17:
        return r102;
    }
}
