package com.bytedance.applog.priority.original;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class EventDatabasePool {
    public static final Lazy<ConcurrentHashMap<Model$PriorityName, d>> d = null;
    public final com.bytedance.applog.log.a a;
    public final Context b;
    public final String c;

    public static final class a {
    }

    static {
        d = LazyKt.lazy(EventDatabasePool$Companion$DB_POOL$2.INSTANCE);
    }

    public final Context getContext() {
        return this.b;
    }

    public final d a(Model$PriorityName r6) {
        Intrinsics.checkNotNullParameter(r6, "priorityName");
        ConcurrentHashMap r0 = (ConcurrentHashMap) d.getValue();
        Object r1 = r0.get(r6);
        if (r1 != null) goto L9;
        r1 = new EventDatabase(this.a, this.b, this.c, r6);
        Object r7 = r0.putIfAbsent(r6, r1);
        if (r7 == null) goto L9;
        r1 = r7;
    L9:
        return (d) r1;
    }

    public EventDatabasePool(com.bytedance.applog.log.a r2, Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "logger");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "appId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
