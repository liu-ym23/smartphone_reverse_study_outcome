package com.bytedance.kmp.ec.yata.chain.core;

import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.bytedance.kmp.ec.yata.chain.trigger.b;
import com.bytedance.kmp.ec.yata.common.error.YataErrorManager;
import com.bytedance.kmp.ec.yata.common.error.d;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import v96.e;
import v96.g;
import v96.h;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EventChain f251266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public YataErrorManager f251267b;

    public abstract e d();

    public abstract g e();

    public abstract h f();

    public abstract void g(d r100, EventContext r101);

    public a() {
    }

    public YataErrorManager c() {
        return this.f251267b;
    }

    public com.bytedance.kmp.ec.yata.chain.trigger.a a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "chainContext");
        EventChain r101 = this.f251266a;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("eventChain");
        r101 = null;
    L6:
        LinkedHashMap r102 = new LinkedHashMap();
        Map<String, Object> r103 = r100.f251309a.f251326a.f251317d;
        if (r103 != null) goto L9;
        r103 = MapsKt.emptyMap();
    L9:
        r102.putAll(r103);
        return new com.bytedance.kmp.ec.yata.chain.trigger.d(r101, r102, MapsKt.emptyMap(), new LinkedHashMap());
    }

    public void h(YataErrorManager r100) {
        this.f251267b = r100;
    }

    public com.bytedance.kmp.ec.yata.chain.trigger.a b(com.bytedance.kmp.ec.yata.chain.trigger.a r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "preTriggerParams");
        Intrinsics.checkNotNullParameter(r101, "chainContext");
        return r100.a();
    }
}
