package com.bytedance.applog.priority.original;

import com.bytedance.applog.priority.PriorityCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n {
    public final Engine a;
    public final t b;
    public final Model$PriorityName c;
    public final long d;
    public final long e;
    public final int f;
    public final long g;
    public final PriorityCallback h;

    public n(Engine r2, t r3, Model$PriorityName r4, long r5, long r7, int r9, long r10, PriorityCallback r12) {
        Intrinsics.checkNotNullParameter(r2, "engine");
        Intrinsics.checkNotNullParameter(r3, "version");
        Intrinsics.checkNotNullParameter(r4, "priorityName");
        Intrinsics.checkNotNullParameter(r12, "callback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r9;
        this.g = r10;
        this.h = r12;
    }
}
