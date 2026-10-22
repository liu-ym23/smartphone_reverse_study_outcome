package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f246288a = 0;

    static {
    }

    public static m a(com.bytedance.ies.bullet.service.base.bridge.b r100) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        if ((r100 instanceof com.bytedance.sdk.xbridge.cn.protocol.h) == false) goto L7;
        return new e(r100);
    L7:
        return new m(r100);
    }

    public static b b(IBridgeMethod r100) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        if ((r100 instanceof com.bytedance.sdk.xbridge.cn.protocol.h) == false) goto L7;
        return new f(r100);
    L7:
        return new b(r100);
    }

    public static q c(IDLXBridgeMethod r100) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        if ((r100 instanceof com.bytedance.sdk.xbridge.cn.protocol.h) == false) goto L7;
        return new h(r100);
    L7:
        return new q(r100);
    }
}
