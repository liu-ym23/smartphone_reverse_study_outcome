package com.bytedance.applog.priority.original;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class EventDatabasePool {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<ConcurrentHashMap<Model$PriorityName, d>> f192673d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.applog.log.a f192674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f192675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f192676c;

    public static final class a {
    }

    static {
        f192673d = LazyKt.lazy(EventDatabasePool$Companion$DB_POOL$2.INSTANCE);
    }

    public final Context getContext() {
        return this.f192675b;
    }

    public final d a(Model$PriorityName r100) {
        Intrinsics.checkNotNullParameter(r100, "priorityName");
        ConcurrentHashMap<Model$PriorityName, d> r101 = f192673d.getValue();
        d r102 = r101.get(r100);
        if (r102 != null) goto L9;
        r102 = new EventDatabase(this.f192674a, this.f192675b, this.f192676c, r100);
        d r103 = r101.putIfAbsent(r100, r102);
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        return r102;
    }

    public EventDatabasePool(com.bytedance.applog.log.a r100, Context r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "appId");
        this.f192674a = r100;
        this.f192675b = r101;
        this.f192676c = r102;
    }
}
