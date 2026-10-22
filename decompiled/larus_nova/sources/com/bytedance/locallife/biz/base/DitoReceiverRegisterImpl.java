package com.bytedance.locallife.biz.base;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class DitoReceiverRegisterImpl implements pp6.a, at6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f256528a;

    @Override // at6.c
    public final void OZ() {
        Intrinsics.checkNotNullParameter(null, "event");
    }

    public DitoReceiverRegisterImpl() {
        this.f256528a = LazyKt.lazy(LazyThreadSafetyMode.NONE, DitoReceiverRegisterImpl$lifeEventService$2.INSTANCE);
    }

    @Override // pp6.a
    public final void a(pp6.a.InterfaceC7224a r100) {
        Intrinsics.checkNotNullParameter(r100, "eventReceiver");
        ((at6.b) this.f256528a.getValue()).b(this);
    }

    @Override // pp6.a
    public final void b(pp6.a.InterfaceC7224a r100) {
        Intrinsics.checkNotNullParameter(r100, "eventReceiver");
        ((at6.b) this.f256528a.getValue()).a(this);
    }

    @Override // at6.c
    public final void Pd(String r100, JSONObject r101) {
        at6.c.a.a(r100, r101);
    }
}
