package com.bytedance.ee.drive.impl.transfer.upload;

import com.bytedance.ee.drive.impl.transfer.queue.DriveTransferQueue;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveUploadQueue extends DriveTransferQueue<DriveUploadTask> {
    public final Lazy e;
    public final Lazy f;

    public static final class a {
    }

    static {
    }

    public DriveUploadQueue() {
        super("DriveUploadQueue");
        this.e = LazyKt.lazy(DriveUploadQueue$okHttpClient$2.INSTANCE);
        this.f = LazyKt.lazy(DriveUploadQueue$callingTaskMap$2.INSTANCE);
    }
}
