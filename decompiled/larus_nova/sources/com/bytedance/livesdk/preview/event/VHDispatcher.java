package com.bytedance.livesdk.preview.event;

import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class VHDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f256430a;

    public VHDispatcher() {
        this.f256430a = LazyKt.lazy(VHDispatcher$consumerList$2.INSTANCE);
    }

    public final void onEvent(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Iterator r101 = ((List) this.f256430a.getValue()).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((Function1) r101.next()).invoke(r100);
        goto L4
    }
}
