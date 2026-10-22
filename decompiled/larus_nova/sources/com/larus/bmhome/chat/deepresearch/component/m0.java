package com.larus.bmhome.chat.deepresearch.component;

import java.util.concurrent.LinkedBlockingQueue;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes25.dex */
public final class m0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f302204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<T> f302205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Job f302206c;

    public m0() {
        this.f302204a = 500;
        this.f302205b = new LinkedBlockingQueue();
    }
}
