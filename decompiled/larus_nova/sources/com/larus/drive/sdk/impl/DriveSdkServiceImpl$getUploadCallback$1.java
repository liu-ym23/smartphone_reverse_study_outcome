package com.larus.drive.sdk.impl;

import android.os.SystemClock;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import com.larus.drive.biz.api.model.DriveUploadStatus;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J,\u0010\r\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"com/larus/drive/sdk/impl/DriveSdkServiceImpl$getUploadCallback$1", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback;", "updatingStatusInterval", "", "latestUpdatingStatusTime", "updateProgress", "", "key", "", "info", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$TransmissionInfo;", "extra", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$Extra;", "onFailed", "errorCode", "", "mountNodePoint", "bytesTotal", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSdkServiceImpl$getUploadCallback$1 implements UploadCallback {
    final /* synthetic */ y79.b $callback;
    private long latestUpdatingStatusTime;
    private final long updatingStatusInterval;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f341624a = null;

        static {
            int[] r100 = new int[DriveFile.Status.values().length];
            r100[DriveFile.Status.INFLIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[DriveFile.Status.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[DriveFile.Status.PENDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[DriveFile.Status.QUEUE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[DriveFile.Status.FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f341624a = r100;
        }
    }

    public DriveSdkServiceImpl$getUploadCallback$1(y79.b r100) {
        this.$callback = r100;
        this.updatingStatusInterval = 1000;
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.UploadCallback
    public boolean updateProgress(String r100, UploadCallback.b r110, UploadCallback.a r111) {
        Intrinsics.checkNotNullParameter(r110, "info");
        Intrinsics.checkNotNullParameter(r111, "extra");
        int r112 = a.f341624a[r110.f232490a.ordinal()];
        if (r112 != 1) goto L5;
        long r101 = SystemClock.elapsedRealtime();
        if ((r101 - this.latestUpdatingStatusTime) >= this.updatingStatusInterval) goto L21;
        return true;
    L21:
        this.latestUpdatingStatusTime = r101;
        DriveUploadStatus r113 = DriveUploadStatus.UPLOADING;
    L17:
        DriveUploadStatus r102 = r113;
        if (r110.f232490a != DriveFile.Status.INFLIGHT) goto L25;
        FLogger.f375446a.d("DriveSdkServiceImpl", "updateProgress, key[" + r100 + "], info[" + r110 + ']');
    L26:
        this.$callback.a(r100, r102, r110.f232491b, r110.f232492c);
        return true;
    L25:
        FLogger.f375446a.i("DriveSdkServiceImpl", "updateProgress, key[" + r100 + "], info[" + r110 + ']');
        goto L26
    L5:
        if (r112 != 2) goto L7;
        r113 = DriveUploadStatus.FINISH;
        goto L17
    L7:
        if (r112 != 3) goto L9;
    L15:
        r113 = DriveUploadStatus.UNSTARTED;
        goto L17
    L9:
        if (r112 == 4) goto L15;
        if (r112 == 5) goto L14;
        return false;
    L14:
        r113 = DriveUploadStatus.FAILED;
        goto L17
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.UploadCallback
    public boolean onFailed(String r100, int r101, String r102, long r103) {
        FLogger.f375446a.e("DriveSdkServiceImpl", "updateFailed, key[" + r100 + "], errorCode[" + r101 + "], mountNodePoint[" + r102 + "], bytesTotal[" + r103 + ']');
        this.$callback.onFailed(r100, r101);
        return true;
    }
}
