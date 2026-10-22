package com.bytedance.applog.priority.original;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o {
    public final EventDatabasePool a;
    public final com.bytedance.applog.priority.h b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o) == true) goto L8;
        return false;
    L8:
        o r6 = (o) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "PriorityInnerContext(databasePool=" + this.a + ", context=" + this.b + ')';
    }

    public final com.bytedance.applog.priority.h getContext() {
        return this.b;
    }

    public o(EventDatabasePool r2, com.bytedance.applog.priority.h r3) {
        Intrinsics.checkNotNullParameter(r2, "databasePool");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r2;
        this.b = r3;
    }
}
