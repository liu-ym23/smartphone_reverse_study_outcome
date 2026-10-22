package com.bytedance.sdk.xbridge.cn.protocol;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class i extends com.bytedance.sdk.xbridge.cn.registry.core.a {
    public i() {
        super(50);
    }

    public final void c() {
        ConcurrentHashMap<String, ConcurrentHashMap<String, IDLXBridgeMethod>> r100 = this.f270084b;
        if ((!r100.isEmpty()) == false) goto L13;
        Iterator<Map.Entry<String, ConcurrentHashMap<String, IDLXBridgeMethod>>> r101 = r100.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L13;
        Iterator<Map.Entry<String, IDLXBridgeMethod>> r102 = r101.next().getValue().entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, IDLXBridgeMethod> r103 = r102.next();
        if ((r103.getValue() instanceof h) == false) goto L9;
        IDLXBridgeMethod r104 = r103.getValue();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod");
        ((h) r104).release();
    L13:
        this.f270084b.clear();
    }
}
