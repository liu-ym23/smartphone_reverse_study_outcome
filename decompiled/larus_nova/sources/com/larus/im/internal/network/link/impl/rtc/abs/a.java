package com.larus.im.internal.network.link.impl.rtc.abs;

import com.larus.im.internal.audio.proto.RTCToken;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class a {
    public void a() {
    }

    public abstract boolean b(i r100, j r101, k r102);

    public RTCToken c() {
        return null;
    }

    public abstract void d();

    public void e() {
    }

    public a(String r100, com.larus.im.internal.network.link.impl.rtc.p r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "config");
    }
}
