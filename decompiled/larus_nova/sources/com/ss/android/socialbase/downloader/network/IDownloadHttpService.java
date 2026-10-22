package com.ss.android.socialbase.downloader.network;

import com.ss.android.socialbase.downloader.model.HttpHeader;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public interface IDownloadHttpService {
    IDownloadHttpConnection downloadWithConnection(int r100, String r101, List<HttpHeader> r102) throws IOException;
}
