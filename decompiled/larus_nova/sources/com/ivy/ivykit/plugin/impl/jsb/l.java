package com.ivy.ivykit.plugin.impl.jsb;

import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class l extends MethodFinder {
    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final String f() {
        return "";
    }

    public l() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final IDLXBridgeMethod h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        j r101 = j.f278398b;
        Iterator<T> r102 = j.f278399c.f278400a.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((IDLXBridgeMethod) r103).getName(), r100) == false) goto L4;
    L10:
        return (IDLXBridgeMethod) r103;
    L8:
        r103 = null;
        goto L10
    }
}
