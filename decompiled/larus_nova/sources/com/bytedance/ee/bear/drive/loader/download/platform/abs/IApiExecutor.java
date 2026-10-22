package com.bytedance.ee.bear.drive.loader.download.platform.abs;

import com.bytedance.ee.bear.drive.loader.download.platform.abs.model.DownloadParams;
import com.bytedance.ee.bear.middleground.drive.export.DownloadCallback;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority$DownloadPriority;

/* JADX INFO: loaded from: classes16.dex */
public interface IApiExecutor {

    public interface PreviewGet {
        IPreviewGetModel execute(w75.c r100) throws Throwable;

        void setTransformStartListener(TransformStartListener r100);

        void shutdown();
    }

    public interface TransformStartListener {
        boolean isSupportDowngrade(int r100, w75.c r101);

        void onTransformStart();
    }

    String downloadByPreviewUrl(w75.c r100, long r101, DownloadCallback r102, DrivePriority$DownloadPriority r103);

    String downloadByToken(w75.c r100, long r101, DownloadCallback r102, DownloadParams r103);

    String downloadSimilarFile(w75.c r100, long r101, DownloadCallback r102, DownloadParams r103);

    String getAppId();

    boolean isDownloadSuccess(String r100);

    PreviewGet pollPreviewGet();

    IPreviewGetModel pullPreviewGet(w75.c r100) throws Throwable;

    void stopDownload(String r100);
}
