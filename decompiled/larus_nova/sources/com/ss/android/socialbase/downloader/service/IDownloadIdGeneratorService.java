package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes5.dex */
public interface IDownloadIdGeneratorService extends IDownloadIdGenerator {

    /* JADX INFO: loaded from: classes38.dex */
    public static class DefaultDownloadIdGeneratorService implements IDownloadIdGeneratorService {
        public DefaultDownloadIdGeneratorService() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService
        public int generate(DownloadInfo r100) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator
        public int generate(String r100, String r101) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService, com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator
        public boolean isDefaultIdGenerator() {
            return true;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService
        public void setDownloadIdGenerator(IDownloadIdGenerator r100) {
        }
    }

    int generate(DownloadInfo r100);

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator
    boolean isDefaultIdGenerator();

    void setDownloadIdGenerator(IDownloadIdGenerator r100);
}
