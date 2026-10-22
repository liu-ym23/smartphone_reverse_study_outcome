package com.bytedance.ee.drive.impl.transfer.download;

import android.net.Uri;
import com.bytedance.ee.drive.impl.transfer.queue.DriveTransferTask;
import com.bytedance.ee.drive.model.transfer.download.DriveDownloadRequest;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.docs.sdk.domain.DomainService;
import com.ss.android.lark.docs.sdk.domain.EDomainType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u00012\u00020\u0002:\u0001\nB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/drive/impl/transfer/download/DriveDownloadTask;", "Lcom/bytedance/ee/drive/impl/transfer/queue/DriveTransferTask;", "Lgr5/a;", "Lcom/bytedance/ee/drive/model/transfer/download/DriveDownloadRequest;", "downloadRequest", "", "parseFrom", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "drive-impl_release"}, k = 1, mv = {1, 7, 1})
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

    public final void parseFrom(DriveDownloadRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "downloadRequest");
        String r101 = r100.f242665a;
        if (r101 != null) goto L14;
        String r102 = r100.f242666b;
        if (r102 == null) goto L13;
        Uri r103 = new DomainService().a(EDomainType.DRIVE_STREAM, "space/api/box/stream/download/all");
        if (r103 == null) goto L13;
        r101 = r103.buildUpon().appendPath(r102).appendQueryParameter(DrivePreviewOpenItem.EXTRA_MOUNT_POINT, r100.f242667c.getStrName()).build().toString();     // Catch: Exception -> L11
    L11:
        e = move-exception;
        Log.e("DriveDownloadTask", "parseFrom, buildUpon error", e);
        r101 = "";
    L13:
        r101 = null;
    L14:
        setRemoteUrl(r101);
        setLocalPath(r100.f242668d);
    }
}
