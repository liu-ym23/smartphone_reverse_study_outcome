package com.bytedance.ee.bear.office.common.upload;

import android.os.Handler;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J,\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"com/bytedance/ee/bear/office/common/upload/OfficeUploadExecutor$callbackFor$1", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback;", "updateProgress", "", "key", "", "info", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$TransmissionInfo;", "extra", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$Extra;", "onFailed", "errorCode", "", "mountNodePoint", "bytesTotal", "", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeUploadExecutor$callbackFor$1 implements UploadCallback {
    final /* synthetic */ String $localId;

    public OfficeUploadExecutor$callbackFor$1(String r100) {
        this.$localId = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.UploadCallback
    public boolean updateProgress(final String r100, final UploadCallback.b r101, final UploadCallback.a r102) {
        Intrinsics.checkNotNullParameter(r101, "info");
        Intrinsics.checkNotNullParameter(r102, "extra");
        Handler r103 = OfficeUploadStore.f235310a;
        final String r104 = this.$localId;
        OfficeUploadStore.f(r104, new OfficeUploadExecutor$callbackFor$1$updateProgress$1(r101, r104, r100, r102));
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.UploadCallback
    public boolean onFailed(final String r100, final int r110, String r111, final long r112) {
        StringBuilder r101 = new StringBuilder("upload failed, localId=");
        r101.append(this.$localId);
        r101.append(", keyHash=");
        if (r100 == null) goto L5;
        Integer r102 = Integer.valueOf(r100.hashCode());
    L6:
        r101.append(r102);
        r101.append(", code=");
        r101.append(r110);
        r101.append(", mountNodeHash=");
        if (r111 == null) goto L9;
        Integer r113 = Integer.valueOf(r111.hashCode());
    L10:
        r101.append(r113);
        r101.append(", bytesTotal=");
        r101.append(r112);
        tt5.a.k("OfficeUploadExecutor", r101.toString());
        k.f235392a.getClass();
        final String r114 = k.d(r110, null);
        Handler r103 = OfficeUploadStore.f235310a;
        OfficeUploadStore.f(this.$localId, new OfficeUploadExecutor$callbackFor$1$onFailed$1(r100, r112, r110, r114));
        k.b(r114);
        return false;
    L9:
        r113 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }
}
