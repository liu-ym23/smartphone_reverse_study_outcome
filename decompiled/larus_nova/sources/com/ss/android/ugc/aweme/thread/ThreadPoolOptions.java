package com.ss.android.ugc.aweme.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes40.dex */
public class ThreadPoolOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadPoolType f454324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f454325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f454326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BlockingQueue<Runnable> f454327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RejectedExecutionHandler f454328e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f454329f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f454330g;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadPoolType f454331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f454332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f454333c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final BlockingQueue<Runnable> f454334d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RejectedExecutionHandler f454335e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f454336f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f454337g;

        public final ThreadPoolOptions a() {
            return new ThreadPoolOptions(this);
        }

        public Builder(ThreadPoolType r100) {
            this.f454333c = 1;
            this.f454334d = new LinkedBlockingQueue();
            this.f454335e = new ThreadPoolExecutor.AbortPolicy();
            this.f454336f = -1;
            this.f454337g = 0;
            this.f454331a = r100;
        }
    }

    public ThreadPoolOptions(Builder r100) {
        this.f454324a = r100.f454331a;
        this.f454325b = r100.f454332b;
        this.f454326c = r100.f454333c;
        this.f454327d = r100.f454334d;
        this.f454328e = r100.f454335e;
        this.f454329f = r100.f454336f;
        this.f454330g = r100.f454337g;
    }

    public static Builder a(ThreadPoolType r100) {
        return new Builder(r100);
    }
}
