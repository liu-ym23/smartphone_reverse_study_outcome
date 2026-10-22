package com.ss.android.socialbase.downloader.service;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadIdGeneratorService implements IDownloadIdGeneratorService {
    private IDownloadIdGenerator mDownloadIdGenerator;

    public DownloadIdGeneratorService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService, com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator
    public boolean isDefaultIdGenerator() {
        if (this.mDownloadIdGenerator != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService
    public int generate(DownloadInfo r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        String r101 = r100.getTaskKey();
        if (TextUtils.isEmpty(r101) == false) goto L9;
        r101 = r100.getUrl();
    L9:
        return generate(r101, r100.getSavePath());
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService
    public void setDownloadIdGenerator(IDownloadIdGenerator r100) {
        this.mDownloadIdGenerator = r100;
    }

    private int generateImpl(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L15:
        return 0;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        if (DownloadFileUtils.isMediaUri(r101) == false) goto L10;
        r101 = DownloadFileUtils.getContentUriString(r101);
    L10:
        String r102 = DownloadUtils.md5Hex(r100 + "_" + r101);
        if (TextUtils.isEmpty(r102) == false) goto L14;
        return 0;
    L14:
        return r102.hashCode();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator
    public int generate(String r100, String r101) {
        IDownloadIdGenerator r102 = this.mDownloadIdGenerator;
        if (r102 == null) goto L7;
        return r102.generate(r100, r101);
    L7:
        return generateImpl(r100, r101);
    }
}
