package com.bytedance.ee.bear.drive.loader.download.platform.abs;

import com.bytedance.ee.bear.drive.loader.download.platform.DownloadOptions;
import com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface IDownloader {

    public static class ICallback<T extends w75.a> {
        public ICallback() {
        }

        public void onFailure(DriveException r1) {
        }

        public void onHitCache(w75.c<T> r1) {
        }

        public void onNoDownload(w75.c<T> r1) {
        }

        public void onProgress(int r1) {
        }

        public void onRustFailed(String r1, int r2) {
        }

        public void onServerTransform(w75.c<T> r1) {
        }

        public void onSubmit(String r1) {
        }

        public void onSuccess(String r1, String r2) {
        }

        public void onTransStatusChanged(TransStatus r1) {
        }
    }

    public static final enum TransStatus extends Enum<TransStatus> {
        private static final /* synthetic */ TransStatus[] $VALUES = null;
        public static final TransStatus TRANSFORMING = null;
        public static final TransStatus TRANSFORM_COMPLETED = null;
        public static final TransStatus TRANSFORM_FAILED = null;

        static {
            TransStatus r0 = new TransStatus("TRANSFORMING", 0);
            TRANSFORMING = r0;
            TransStatus r1 = new TransStatus("TRANSFORM_COMPLETED", 1);
            TRANSFORM_COMPLETED = r1;
            TransStatus r3 = new TransStatus("TRANSFORM_FAILED", 2);
            TRANSFORM_FAILED = r3;
            $VALUES = new TransStatus[]{r0, r1, r3};
        }

        public static TransStatus[] values() {
            return (TransStatus[]) $VALUES.clone();
        }

        public static TransStatus valueOf(String r1) {
            return (TransStatus) r27.a.a(TransStatus.class, r1);
        }

        private TransStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    void addCustomizationAdjust(IPriorityAdjuster r1);

    void adjustPriority(w75.c r1);

    Flowable<Boolean> downloadManualCacheFile(w75.c r1, ICallback r2);

    Flowable<Boolean> downloadPreloadFile(w75.c r1, ICallback r2);

    Flowable<Boolean> downloadPreviewFile(w75.c r1, ICallback r2, DownloadOptions r3);

    Flowable<Boolean> downloadSourceFile(w75.c r1, ICallback r2, DownloadOptions r3);

    Flowable<Boolean> downloadSourceFilePreView(w75.c r1, ICallback r2);
}
