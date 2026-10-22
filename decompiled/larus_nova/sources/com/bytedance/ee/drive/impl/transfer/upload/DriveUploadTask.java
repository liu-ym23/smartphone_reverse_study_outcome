package com.bytedance.ee.drive.impl.transfer.upload;

import com.bytedance.ee.drive.impl.transfer.queue.DriveTransferTask;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001\"B\u0007¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/bytedance/ee/drive/impl/transfer/upload/DriveUploadTask;", "Lcom/bytedance/ee/drive/impl/transfer/queue/DriveTransferTask;", "", "Lhr5/a;", "uploadRequest", "", "parseFrom", "", DBDefinition.MIME_TYPE, "Ljava/lang/String;", "getMimeType", "()Ljava/lang/String;", "setMimeType", "(Ljava/lang/String;)V", "fileName", "getFileName", "setFileName", "", DBDefinition.TOTAL_BYTES, "J", "getTotalBytes", "()J", "setTotalBytes", "(J)V", "Lkotlin/Function1;", "callback", "Lkotlin/jvm/functions/Function1;", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "drive-impl_release"}, k = 1, mv = {1, 7, 1})
public final class DriveUploadTask extends DriveTransferTask {
    public static final a Companion = null;
    private Function1<Object, Unit> callback;
    private String fileName;
    private String mimeType;
    private long totalBytes;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DriveUploadTask() {
        super("DriveUploadTask");
    }

    public final Function1<Object, Unit> getCallback() {
        return this.callback;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final long getTotalBytes() {
        return this.totalBytes;
    }

    public final void parseFrom(hr5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "uploadRequest");
        throw null;
    }

    public final void setCallback(Function1<Object, Unit> r100) {
        this.callback = r100;
    }

    public final void setFileName(String r100) {
        this.fileName = r100;
    }

    public final void setMimeType(String r100) {
        this.mimeType = r100;
    }

    public final void setTotalBytes(long r100) {
        this.totalBytes = r100;
    }
}
