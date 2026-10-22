package com.larus.drive.sdk.impl;

import android.os.SystemClock;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J,\u0010\r\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"com/larus/drive/sdk/impl/DriveSdkServiceImpl$getMountUploadCallback$1", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback;", "updatingStatusInterval", "", "latestUpdatingStatusTime", "updateProgress", "", "key", "", "info", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$TransmissionInfo;", "extra", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$Extra;", "onFailed", "errorCode", "", "mountNodePoint", "bytesTotal", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSdkServiceImpl$getMountUploadCallback$1 implements UploadCallback {
    final /* synthetic */ y79.a $callback;
    private long latestUpdatingStatusTime;
    private final long updatingStatusInterval;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f341623a = null;

        static {
            int[] r100 = new int[DriveFile.Status.values().length];
            r100[DriveFile.Status.INFLIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[DriveFile.Status.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[DriveFile.Status.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[DriveFile.Status.PENDING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[DriveFile.Status.QUEUE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f341623a = r100;
        }
    }

    public DriveSdkServiceImpl$getMountUploadCallback$1(y79.a r100) {
        this.$callback = r100;
        this.updatingStatusInterval = 1000;
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.UploadCallback
    public boolean updateProgress(String r110, UploadCallback.b r111, UploadCallback.a r112) {
        Intrinsics.checkNotNullParameter(r111, "info");
        Intrinsics.checkNotNullParameter(r112, "extra");
        int r100 = a.f341623a[r111.f232490a.ordinal()];
        if (r100 != 1) goto L5;
        long r101 = SystemClock.elapsedRealtime();
        if ((r101 - this.latestUpdatingStatusTime) >= this.updatingStatusInterval) goto L22;
        return true;
    L22:
        this.latestUpdatingStatusTime = r101;
        FLogger.f375446a.d("DriveSdkServiceImpl", "mountUpload.updateProgress, key[" + r110 + "], info[" + r111 + ']');
        this.$callback.b(r111.f232491b, r111.f232492c);
    L23:
        return true;
    L5:
        if (r100 != 2) goto L7;
        FLogger.f375446a.i("DriveSdkServiceImpl", "mountUpload.success, key[" + r110 + "], fileToken[" + r112.f232476a + "], mountNodeToken[" + r112.f232478c + "], mountPoint[" + r112.f232479d + ']');
        y79.a r102 = this.$callback;
        String r113 = r112.f232476a;
        if (r113 != null) goto L18;
        r113 = "";
    L18:
        r102.a(r110, r113, r112.f232482g, r112.f232478c, r112.f232479d);
        goto L23
    L7:
        if (r100 != 3) goto L9;
        FLogger.f375446a.e("DriveSdkServiceImpl", "mountUpload.failed, key[" + r110 + "], info[" + r111 + ']');
        this.$callback.onFailed(r110, -1);
        goto L23
    L9:
        if (r100 == 4) goto L23;
        if (r100 == 5) goto L23;
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.UploadCallback
    public boolean onFailed(String r100, int r101, String r102, long r103) {
        FLogger.f375446a.e("DriveSdkServiceImpl", "mountUpload.onFailed, key[" + r100 + "], errorCode[" + r101 + "], mountNodePoint[" + r102 + "], bytesTotal[" + r103 + ']');
        this.$callback.onFailed(r100, r101);
        return true;
    }
}
