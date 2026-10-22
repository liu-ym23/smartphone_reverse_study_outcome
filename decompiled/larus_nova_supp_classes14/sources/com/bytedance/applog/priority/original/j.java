package com.bytedance.applog.priority.original;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j {
    public long a;
    public final int b;
    public final long c;
    public final Model$EventType d;
    public final boolean e;
    public final String f;
    public final String g;

    public final String toString() {
        return "id=" + this.a + "|g=" + this.b + "|n=" + this.g + '|' + this.f;
    }

    public j(long r2, int r4, long r5, Model$EventType r7, boolean r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "eventType");
        Intrinsics.checkNotNullParameter(r9, "monitorId");
        Intrinsics.checkNotNullParameter(r10, "eventName");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
    }
}
