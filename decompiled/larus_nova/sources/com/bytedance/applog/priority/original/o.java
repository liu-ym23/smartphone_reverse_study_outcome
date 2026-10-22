package com.bytedance.applog.priority.original;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventDatabasePool f192781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.applog.priority.h f192782b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f192781a, r101.f192781a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f192782b, r101.f192782b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f192781a.hashCode() * 31) + this.f192782b.hashCode();
    }

    public final String toString() {
        return "PriorityInnerContext(databasePool=" + this.f192781a + ", context=" + this.f192782b + ')';
    }

    public final com.bytedance.applog.priority.h getContext() {
        return this.f192782b;
    }

    public o(EventDatabasePool r100, com.bytedance.applog.priority.h r101) {
        Intrinsics.checkNotNullParameter(r100, "databasePool");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f192781a = r100;
        this.f192782b = r101;
    }
}
