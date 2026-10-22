package com.bytedance.ee.drive.impl.transfer.download;

import android.net.Uri;
import com.bytedance.ee.drive.impl.transfer.queue.DriveTransferTask;
import com.bytedance.ee.drive.model.transfer.download.DriveDownloadRequest;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.docs.sdk.domain.DomainService;
import com.ss.android.lark.docs.sdk.domain.EDomainType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u00012\u00020\u0002:\u0001\nB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/drive/impl/transfer/download/DriveDownloadTask;", "Lcom/bytedance/ee/drive/impl/transfer/queue/DriveTransferTask;", "Lgr5/a;", "Lcom/bytedance/ee/drive/model/transfer/download/DriveDownloadRequest;", "downloadRequest", "", "parseFrom", "<init>", "()V", "Companion", "a", "drive-impl_release"}, k = 1, mv = {1, 7, 1})
public final class DriveDownloadTask extends DriveTransferTask implements gr5.a {
    public static final a Companion = null;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DriveDownloadTask() {
        super("DriveDownloadTask");
    }

    public final void parseFrom(DriveDownloadRequest r6) {
        Intrinsics.checkNotNullParameter(r6, "downloadRequest");
        String r0 = r6.a;
        if (r0 != null) goto L14;
        String r1 = r6.b;
        if (r1 == null) goto L13;
        Uri r2 = new DomainService().a(EDomainType.DRIVE_STREAM, "space/api/box/stream/download/all");
        if (r2 == null) goto L13;
        r0 = r2.buildUpon().appendPath(r1).appendQueryParameter(DrivePreviewOpenItem.EXTRA_MOUNT_POINT, r6.c.getStrName()).build().toString();     // Catch: Exception -> L11
    L11:
        e = move-exception;
        Log.e("DriveDownloadTask", "parseFrom, buildUpon error", e);
        r0 = "";
    L13:
        r0 = null;
    L14:
        setRemoteUrl(r0);
        setLocalPath(r6.d);
    }
}
