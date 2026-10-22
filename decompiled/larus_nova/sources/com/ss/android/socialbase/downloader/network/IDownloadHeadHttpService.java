package com.ss.android.socialbase.downloader.network;

import com.ss.android.socialbase.downloader.model.HttpHeader;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public interface IDownloadHeadHttpService {
    IDownloadHeadHttpConnection downloadWithConnection(String r100, List<HttpHeader> r101) throws IOException;
}
