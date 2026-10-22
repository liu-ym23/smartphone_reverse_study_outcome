package com.bytedance.ee.bear.office.common.upload;

import android.os.Handler;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J,\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"com/bytedance/ee/bear/office/common/upload/OfficeUploadExecutor$callbackFor$1", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback;", "updateProgress", "", "key", "", "info", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$TransmissionInfo;", "extra", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$Extra;", "onFailed", "errorCode", "", "mountNodePoint", "bytesTotal", "", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeUploadExecutor$callbackFor$1 implements UploadCallback {
    final /* synthetic */ String $localId;

    public OfficeUploadExecutor$callbackFor$1(String r1) {
        this.$localId = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.UploadCallback
    public boolean updateProgress(final String r3, final UploadCallback.b r4, final UploadCallback.a r5) {
        Intrinsics.checkNotNullParameter(r4, "info");
        Intrinsics.checkNotNullParameter(r5, "extra");
        Handler r0 = OfficeUploadStore.a;
        final String r1 = this.$localId;
        OfficeUploadStore.f(r1, new OfficeUploadExecutor$callbackFor$1$updateProgress$1(r4, r1, r3, r5));
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.UploadCallback
    public boolean onFailed(final String r9, final int r10, String r11, final long r12) {
        StringBuilder r0 = new StringBuilder("upload failed, localId=");
        r0.append(this.$localId);
        r0.append(", keyHash=");
        if (r9 == null) goto L5;
        Integer r2 = Integer.valueOf(r9.hashCode());
    L6:
        r0.append(r2);
        r0.append(", code=");
        r0.append(r10);
        r0.append(", mountNodeHash=");
        if (r11 == null) goto L9;
        Integer r13 = Integer.valueOf(r11.hashCode());
    L10:
        r0.append(r13);
        r0.append(", bytesTotal=");
        r0.append(r12);
        tt5.a.k("OfficeUploadExecutor", r0.toString());
        k.a.getClass();
        final String r14 = k.d(r10, null);
        Handler r1 = OfficeUploadStore.a;
        OfficeUploadStore.f(this.$localId, new OfficeUploadExecutor$callbackFor$1$onFailed$1(r9, r12, r10, r14));
        k.b(r14);
        return false;
    L9:
        r13 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
