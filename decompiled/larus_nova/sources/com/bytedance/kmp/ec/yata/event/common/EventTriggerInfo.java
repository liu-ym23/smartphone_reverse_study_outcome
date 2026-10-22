package com.bytedance.kmp.ec.yata.event.common;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class EventTriggerInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.chain.trigger.b f251648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f251649b;

    public final com.bytedance.kmp.ec.yata.store.node.c a() {
        String r100 = ((f) this.f251649b.getValue()).f251663c;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L13;
        return null;
    L13:
        return ((f) this.f251649b.getValue()).f251661a.o(r100);
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final String b() {
        return ((f) this.f251649b.getValue()).f251664d;
    }

    public EventTriggerInfo(com.bytedance.kmp.ec.yata.chain.trigger.b r100) {
        Intrinsics.checkNotNullParameter(r100, "chainContext");
        this.f251648a = r100;
        this.f251649b = LazyKt.lazy(new EventTriggerInfo$inputParams$2(this));
    }
}
