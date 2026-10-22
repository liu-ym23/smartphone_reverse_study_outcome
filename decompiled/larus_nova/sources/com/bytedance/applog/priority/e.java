package com.bytedance.applog.priority;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class e implements com.bytedance.applog.log.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriorityCallback f192610a;

    public e(PriorityCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "priorityCallback");
        this.f192610a = r100;
    }

    @Override // com.bytedance.applog.log.a
    public final void a(String r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f192610a.printLog(2, "Priority-" + r100 + ": " + r101.invoke());
    }

    @Override // com.bytedance.applog.log.a
    public final void b(String r100, Throwable r101, Function0<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, "message");
        this.f192610a.printLog(4, "Priority-" + r100 + ": " + r102.invoke() + ", throwable: " + r101);
    }
}
