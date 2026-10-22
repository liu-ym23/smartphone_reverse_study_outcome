package com.bytedance.ee.drive.impl.transfer;

import com.bytedance.ee.drive.impl.transfer.download.DriveDownloadQueue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/drive/impl/transfer/download/DriveDownloadQueue;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class DriveTransferManager$downloadQueue$2 extends Lambda implements Function0<DriveDownloadQueue> {
    public static final DriveTransferManager$downloadQueue$2 INSTANCE = null;

    static {
        INSTANCE = new DriveTransferManager$downloadQueue$2();
    }

    public DriveTransferManager$downloadQueue$2() {
        super(0);
    }

    public final DriveDownloadQueue invoke() {
        return new DriveDownloadQueue();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m435invoke() {
        return invoke();
    }
}
