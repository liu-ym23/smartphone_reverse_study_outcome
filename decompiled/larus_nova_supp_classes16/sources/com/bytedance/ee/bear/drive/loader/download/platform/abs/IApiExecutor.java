package com.bytedance.ee.bear.drive.loader.download.platform.abs;

import com.bytedance.ee.bear.drive.loader.download.platform.abs.model.DownloadParams;
import com.bytedance.ee.bear.middleground.drive.export.DownloadCallback;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface IApiExecutor {

    public interface PreviewGet {
        IPreviewGetModel execute(w75.c r1) throws Throwable;

        void setTransformStartListener(TransformStartListener r1);

        void shutdown();
    }

    public interface TransformStartListener {
        boolean isSupportDowngrade(int r1, w75.c r2);

        void onTransformStart();
    }

    String downloadByPreviewUrl(w75.c r1, long r2, DownloadCallback r4, DrivePriority.DownloadPriority r5);

    String downloadByToken(w75.c r1, long r2, DownloadCallback r4, DownloadParams r5);

    String downloadSimilarFile(w75.c r1, long r2, DownloadCallback r4, DownloadParams r5);

    String getAppId();

    boolean isDownloadSuccess(String r1);

    PreviewGet pollPreviewGet();

    IPreviewGetModel pullPreviewGet(w75.c r1) throws Throwable;

    void stopDownload(String r1);
}
