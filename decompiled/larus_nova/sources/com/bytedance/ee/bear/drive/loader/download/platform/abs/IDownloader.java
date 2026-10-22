package com.bytedance.ee.bear.drive.loader.download.platform.abs;

import com.bytedance.ee.bear.drive.loader.download.platform.DownloadOptions;
import com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: classes16.dex */
public interface IDownloader {

    public static class ICallback<T extends w75.a> {
        public ICallback() {
        }

        public void onFailure(DriveException r100) {
        }

        public void onHitCache(w75.c<T> r100) {
        }

        public void onNoDownload(w75.c<T> r100) {
        }

        public void onProgress(int r100) {
        }

        public void onRustFailed(String r100, int r101) {
        }

        public void onServerTransform(w75.c<T> r100) {
        }

        public void onSubmit(String r100) {
        }

        public void onSuccess(String r100, String r101) {
        }

        public void onTransStatusChanged(TransStatus r100) {
        }
    }

    public static final enum TransStatus extends Enum<TransStatus> {
        private static final /* synthetic */ TransStatus[] $VALUES = null;
        public static final TransStatus TRANSFORMING = null;
        public static final TransStatus TRANSFORM_COMPLETED = null;
        public static final TransStatus TRANSFORM_FAILED = null;

        static {
            TransStatus r100 = new TransStatus("TRANSFORMING", 0);
            TRANSFORMING = r100;
            TransStatus r101 = new TransStatus("TRANSFORM_COMPLETED", 1);
            TRANSFORM_COMPLETED = r101;
            TransStatus r102 = new TransStatus("TRANSFORM_FAILED", 2);
            TRANSFORM_FAILED = r102;
            $VALUES = new TransStatus[]{r100, r101, r102};
        }

        public static TransStatus[] values() {
            return (TransStatus[]) $VALUES.clone();
        }

        public static TransStatus valueOf(String r100) {
            return (TransStatus) r27.a.a(TransStatus.class, r100);
        }

        private TransStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    void addCustomizationAdjust(IPriorityAdjuster r100);

    void adjustPriority(w75.c r100);

    Flowable<Boolean> downloadManualCacheFile(w75.c r100, ICallback r101);

    Flowable<Boolean> downloadPreloadFile(w75.c r100, ICallback r101);

    Flowable<Boolean> downloadPreviewFile(w75.c r100, ICallback r101, DownloadOptions r102);

    Flowable<Boolean> downloadSourceFile(w75.c r100, ICallback r101, DownloadOptions r102);

    Flowable<Boolean> downloadSourceFilePreView(w75.c r100, ICallback r101);
}
