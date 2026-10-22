package com.bytedance.timon_monitor_impl;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/timonbase/apicache/a;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/timonbase/apicache/a;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class TimonCacheActionInvoker$initialCacheEnv$1$1$1$1 extends Lambda implements Function1<com.bytedance.timonbase.apicache.a, String> {
    public static final TimonCacheActionInvoker$initialCacheEnv$1$1$1$1 INSTANCE = null;

    static {
        INSTANCE = new TimonCacheActionInvoker$initialCacheEnv$1$1$1$1();
    }

    public TimonCacheActionInvoker$initialCacheEnv$1$1$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(com.bytedance.timonbase.apicache.a r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(com.bytedance.timonbase.apicache.a r100) {
        return com.bytedance.timonbase.apicache.b.a(r100);
    }
}
