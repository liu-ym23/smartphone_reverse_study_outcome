package com.volcengine.zeus.download;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements IDownloader {

    public class a extends AbsDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IZeusDownloadListener f462668a;

        public a(IZeusDownloadListener r100) {
            this.f462668a = r100;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onProgress(DownloadInfo r100) {
            this.f462668a.onProgress(r100.getCurBytes(), r100.getTotalBytes());
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onStart(DownloadInfo r100) {
            this.f462668a.onStart();
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onSuccessed(DownloadInfo r100) {
            this.f462668a.onSuccess(r100.getSavePath(), r100.getName(), r100.getDownloadTime());
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFailed(DownloadInfo r100, BaseException r101) {
            this.f462668a.onFailed(r101, r101.getErrorCode(), r101.getErrorMessage());
        }
    }

    /* JADX INFO: renamed from: com.volcengine.zeus.download.b$b, reason: collision with other inner class name */
    public class C5552b implements IDownloadInterceptor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IZeusDownloadInterceptor f462669a;

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
        public final boolean intercepte() {
            return this.f462669a.intercept();
        }

        public C5552b(IZeusDownloadInterceptor r100) {
            this.f462669a = r100;
        }
    }

    public b() {
    }

    @Override // com.volcengine.zeus.download.IDownloader
    public final void downloader(Context r100, String r101, String r102, boolean r103, String r104, int r105, String r106, List<String> r107, IZeusDownloadListener r110, IZeusDownloadInterceptor r111) {
        a r108 = new a(r110);
        C5552b r112 = new C5552b(r111);
        Downloader.with(r100).url(r101).name(r102).onlyWifi(r103).savePath(r104).retryCount(r105).mimeType(r106).backUpUrls(r107).subThreadListener(r108).interceptor(r112).download();
    }
}
