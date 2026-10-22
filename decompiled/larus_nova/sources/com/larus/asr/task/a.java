package com.larus.asr.task;

import com.larus.audio.audiov3.task.asr.AsrDataSourceState;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements h68.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile AsrDataSourceState f288072a;

    /* JADX INFO: renamed from: com.larus.asr.task.a$a, reason: collision with other inner class name */
    public static final class C3950a {
    }

    static {
    }

    @Override // h68.c
    public final int b() {
        return 3200;
    }

    @Override // h68.c
    public final h68.a prepare() {
        this.f288072a = AsrDataSourceState.INITIALIZED;
        return new h68.a.b(null);
    }

    @Override // h68.c
    public final h68.a release() {
        this.f288072a = AsrDataSourceState.UNINITIALIZED;
        return new h68.a.b(null);
    }

    @Override // h68.c
    public final h68.a start() {
        this.f288072a = AsrDataSourceState.STARTED;
        return new h68.a.b(null);
    }

    @Override // h68.c
    public final h68.a stop() {
        this.f288072a = AsrDataSourceState.STOPPED;
        return new h68.a.b(null);
    }

    public a() {
        this.f288072a = AsrDataSourceState.UNINITIALIZED;
    }

    @Override // h68.c
    public final AsrDataSourceState a() {
        return this.f288072a;
    }

    @Override // h68.c
    public final h68.a read(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        if (this.f288072a != AsrDataSourceState.STARTED) goto L9;
        Thread.sleep(50);     // Catch: InterruptedException -> L7
    L7:
        ThreadMethodProxy.currentThread().interrupt();
    L9:
        return new h68.a.b(0);
    }
}
