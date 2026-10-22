package com.bytedance.ee.drive.impl.transfer.upload;

import com.bytedance.ee.drive.impl.transfer.queue.DriveTransferQueue;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveUploadQueue extends DriveTransferQueue<DriveUploadTask> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f242657e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f242658f;

    public static final class a {
    }

    static {
    }

    public DriveUploadQueue() {
        super("DriveUploadQueue");
        this.f242657e = LazyKt.lazy(DriveUploadQueue$okHttpClient$2.INSTANCE);
        this.f242658f = LazyKt.lazy(DriveUploadQueue$callingTaskMap$2.INSTANCE);
    }
}
