package com.bytedance.timon.permission.storage.manager;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes22.dex */
public final class TimonMediaManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f270659a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zg7.a f270660b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Function3<? super Throwable, ? super String, ? super Map<String, String>, Unit> f270661c = null;

    static {
        f270659a = LazyKt.lazy(TimonMediaManager$enableInsertRetry$2.INSTANCE);
        f270660b = zg7.a.f572099a;
        f270661c = TimonMediaManager$errorMonitor$1.INSTANCE;
    }
}
