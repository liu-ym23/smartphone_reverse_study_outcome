package com.bytedance.ee.drive.impl.transfer;

import com.bytedance.ee.drive.impl.transfer.upload.DriveUploadQueue;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/drive/impl/transfer/upload/DriveUploadQueue;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class DriveTransferManager$uploadQueue$2 extends Lambda implements Function0<DriveUploadQueue> {
    public static final DriveTransferManager$uploadQueue$2 INSTANCE = null;

    static {
        INSTANCE = new DriveTransferManager$uploadQueue$2();
    }

    public DriveTransferManager$uploadQueue$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final DriveUploadQueue invoke() {
        return new DriveUploadQueue();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ DriveUploadQueue invoke() {
        return invoke();
    }
}
