package com.bytedance.livesdk.ktvcommon.download.model;

import com.bytedance.livesdk.ktvcommon.download.TaskScheduler;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class o<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriorityBlockingQueue<T> f256005a;

    public o(TaskScheduler.b r100) {
        Intrinsics.checkNotNullParameter(r100, "comparator");
        this.f256005a = new PriorityBlockingQueue(16, r100);
    }
}
