package com.larus.voicecall.impl.tracer;

import java.util.concurrent.LinkedBlockingQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<b> f379113a;

    /* JADX INFO: renamed from: com.larus.voicecall.impl.tracer.a$a, reason: collision with other inner class name */
    public static final class C4534a {
    }

    static {
    }

    public a() {
        this.f379113a = new LinkedBlockingQueue();
    }

    public final void a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f379113a.put(r100);
    }
}
