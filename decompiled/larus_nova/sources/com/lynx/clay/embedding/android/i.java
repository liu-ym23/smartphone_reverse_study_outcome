package com.lynx.clay.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes32.dex */
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static i f380663c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LongSparseArray<MotionEvent> f380664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PriorityQueue<Long> f380665b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AtomicLong f380666a = null;

        static {
            f380666a = new AtomicLong(0);
        }
    }

    public i() {
        this.f380664a = new LongSparseArray();
        this.f380665b = new PriorityQueue();
    }
}
