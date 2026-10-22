package com.bytedance.ee.drive.impl.transfer.download;

import com.bytedance.ee.drive.impl.transfer.queue.DriveTransferQueue;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveDownloadQueue extends DriveTransferQueue<DriveDownloadTask> {
    public final Lazy e;
    public final Lazy f;

    public static final class a {
    }

    static {
    }

    public DriveDownloadQueue() {
        super("DriveDownloadQueue");
        this.e = LazyKt.lazy(DriveDownloadQueue$okHttpClient$2.INSTANCE);
        this.f = LazyKt.lazy(DriveDownloadQueue$callingTaskMap$2.INSTANCE);
    }
}
