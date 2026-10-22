package com.bytedance.kmp.ec.yata.chain.trigger;

import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EventChain f251323d;

    @Override // com.bytedance.kmp.ec.yata.chain.trigger.a
    public final a a() {
        return new d(this.f251323d, MapsKt.toMutableMap(this.f251305a), this.f251306b, this.f251307c);
    }

    @Override // com.bytedance.kmp.ec.yata.chain.trigger.a
    public final Map<String, Object> b() {
        String r100 = YaTaLog.f251436a;
        YaTaLog.a("ChainTriggerParams", this.f251307c);
        Map<String, Object> r101 = MapsKt.mapOf(new Pair[]{TuplesKt.to("__biz", this.f251305a), TuplesKt.to("__local", this.f251323d.f251264j.toMap()), TuplesKt.to("__request", this.f251306b)});
        if (this.f251307c.isEmpty() == false) goto L5;
        return r101;
    L5:
        return MapsKt.plus(r101, this.f251307c);
    }

    public d(EventChain r100, Map<String, Object> r101, Map<String, ? extends Object> r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "eventChain");
        Intrinsics.checkNotNullParameter(r101, "bizParams");
        Intrinsics.checkNotNullParameter(r102, "requestParams");
        Intrinsics.checkNotNullParameter(r103, "customParams");
        super(r101, r102, r103);
        this.f251323d = r100;
    }
}
