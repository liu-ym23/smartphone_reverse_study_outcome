package com.ss.ugc.live.sdk.msg.network;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements l {

    /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.network.a$a, reason: collision with other inner class name */
    public static final class C5484a implements j {
        public C5484a() {
        }

        @Override // com.ss.ugc.live.sdk.msg.network.k
        public final boolean a() {
            return false;
        }

        @Override // com.ss.ugc.live.sdk.msg.network.j
        public final void b(tlc.f r100) {
            Intrinsics.checkNotNullParameter(r100, "payloadItem");
        }

        @Override // com.ss.ugc.live.sdk.msg.network.k
        public final void disconnect() {
        }

        @Override // com.ss.ugc.live.sdk.msg.network.k
        public final void e(tlc.f r100) {
            Intrinsics.checkNotNullParameter(r100, "payloadItem");
        }

        @Override // com.ss.ugc.live.sdk.msg.network.k
        public final void f(tlc.f r100) {
            Intrinsics.checkNotNullParameter(r100, "payloadItem");
        }
    }

    public a() {
    }

    @Override // com.ss.ugc.live.sdk.msg.network.l
    public final k a(String r100, Map<String, String> r101, m r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "onWSListener");
        C5484a r104 = new C5484a();
        r102.b("empty");
        return r104;
    }
}
