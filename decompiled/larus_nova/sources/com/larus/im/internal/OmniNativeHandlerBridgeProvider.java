package com.larus.im.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class OmniNativeHandlerBridgeProvider implements hd9.p {

    public static final class a {
    }

    public static final class b implements hd9.r {
        public b() {
        }
    }

    static {
    }

    @Override // hd9.p
    public final hd9.j a() {
        return new OmniNativeHandlerBridgeProvider$conversationHandlerBridge$1();
    }

    @Override // hd9.p
    public final hd9.o b() {
        return new OmniNativeHandlerBridgeProvider$messageHandlerBridge$1();
    }

    @Override // hd9.p
    public final hd9.r c() {
        return new b();
    }

    public OmniNativeHandlerBridgeProvider(gd9.r r100) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
    }
}
