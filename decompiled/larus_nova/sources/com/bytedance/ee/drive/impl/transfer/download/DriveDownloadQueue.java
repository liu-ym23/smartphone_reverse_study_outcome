package com.bytedance.ee.drive.impl.transfer.download;

import com.bytedance.ee.drive.impl.transfer.queue.DriveTransferQueue;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveDownloadQueue extends DriveTransferQueue<DriveDownloadTask> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f242650e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f242651f;

    public static final class a {
    }

    static {
    }

    public DriveDownloadQueue() {
        super("DriveDownloadQueue");
        this.f242650e = LazyKt.lazy(DriveDownloadQueue$okHttpClient$2.INSTANCE);
        this.f242651f = LazyKt.lazy(DriveDownloadQueue$callingTaskMap$2.INSTANCE);
    }
}
