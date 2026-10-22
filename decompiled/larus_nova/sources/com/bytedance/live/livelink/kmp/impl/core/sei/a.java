package com.bytedance.live.livelink.kmp.impl.core.sei;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Object> f255428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ei6.a f255429b;

    public ByteBuffer a(Object r100) {
        throw null;
    }

    public final ByteBuffer b() {
        List<Object> r100 = this.f255428a;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if ((!((ArrayList) this.f255428a).isEmpty()) == false) goto L7;
        Object r101 = ((ArrayList) this.f255428a).remove(0);     // Catch: Throwable -> L12
    L8:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r100);
        return a(r101);
    L7:
        r101 = null;
        goto L8
    }

    public a(ei6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "linkService");
        this.f255429b = r100;
        this.f255428a = new ArrayList();
    }
}
