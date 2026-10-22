package com.bytedance.ies.argus.aspect.eventCenter;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class BaseRuntimeContext extends com.bytedance.ies.argus.strategy.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f245828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f245829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArgusBizIdUpdateFrom f245830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f245831d;

    public abstract String g();

    public final String e() {
        return (String) this.f245828a.getValue();
    }

    public BaseRuntimeContext() {
        this.f245828a = LazyKt.lazy(BaseRuntimeContext$traceId$2.INSTANCE);
        this.f245830c = ArgusBizIdUpdateFrom.UNSET;
    }

    public final void f(String r100, ArgusBizIdUpdateFrom r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "updateFrom");
        if (this.f245829b != null) goto L5;
    L8:
        int r102 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.c("RuntimeContext", "set " + g() + "[bizId] " + this.f245829b + " -> " + r100 + ", [updateFrom] " + this.f245830c + " -> " + r101);
        this.f245830c = r101;
        this.f245829b = r100;
        return;
    L5:
        if (r101.getPriority() > this.f245830c.getPriority()) goto L8;
        int r103 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.b("RuntimeContext", "ignore set " + g() + " argus_biz_id=" + r100 + ", update from: " + r101 + "; now_argus_biz_id=" + this.f245829b + ", update from: " + this.f245830c, null, 12);
    }
}
