package com.bytedance.frameworks.baselib.netx.partner;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class NetworkChain$chainData$2 extends Lambda implements Function0<Map<Object, Object>> {
    public static final NetworkChain$chainData$2 INSTANCE = null;

    static {
        INSTANCE = new NetworkChain$chainData$2();
    }

    public NetworkChain$chainData$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Object, Object> invoke2() {
        return new LinkedHashMap();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Object, Object> invoke() {
        return invoke2();
    }
}
