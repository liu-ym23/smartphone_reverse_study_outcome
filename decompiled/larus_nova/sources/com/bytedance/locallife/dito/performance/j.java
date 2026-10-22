package com.bytedance.locallife.dito.performance;

import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes21.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient LinkedBlockingQueue<uq6.h> f258554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<uq6.h> f258555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int f258556c;

    public final uq6.h a() {
        return this.f258554a.peek();
    }

    public j() {
        this.f258554a = new LinkedBlockingQueue();
        this.f258555b = new LinkedBlockingQueue();
    }
}
