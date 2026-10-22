package io.ktor.client.plugins.observer;

import io.ktor.client.call.HttpClientCall;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends HttpClientCall {
    public a(io.ktor.client.a r100, ByteReadChannel r101, HttpClientCall r102) {
        Intrinsics.checkNotNullParameter(r100, "client");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "originCall");
        super(r100);
        c r103 = new c(this, r102.c());
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f491623b = r103;
        d r104 = new d(this, r101, r102.d());
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f491624c = r104;
    }
}
