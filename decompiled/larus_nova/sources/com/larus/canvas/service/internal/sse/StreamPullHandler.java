package com.larus.canvas.service.internal.sse;

import com.larus.platform.service.z2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes26.dex */
public final class StreamPullHandler {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f323848k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f323849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f323850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineScope f323851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Job f323852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f323853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f323854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f323855g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f323856h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f323857i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final g f323858j;

    public static final class a {
    }

    static {
        f323848k = z2.f365865a.getCreationCanvasClientConfig().f486753b;
    }

    public final void a() {
        this.f323856h = System.currentTimeMillis();
        this.f323857i = 0;
        this.f323852d = BuildersKt.launch$default(this.f323851c, null, null, new StreamPullHandler$startChunkPull$1(this, null), 3, null);
    }

    public StreamPullHandler(Object r100, CanvasChunkReceiver r101) {
        Intrinsics.checkNotNullParameter("/creativity/canvas/generate", "path");
        Intrinsics.checkNotNullParameter(r100, "uplink");
        Intrinsics.checkNotNullParameter(r101, "dispatcher");
        this.f323849a = "/creativity/canvas/generate";
        this.f323850b = r100;
        this.f323851c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f323854f = f323848k;
        this.f323855g = 2000;
        this.f323858j = new g(r101, this);
    }
}
