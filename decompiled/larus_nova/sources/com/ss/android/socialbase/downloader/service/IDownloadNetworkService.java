package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface IDownloadNetworkService {

    /* JADX INFO: loaded from: classes38.dex */
    public static class DefaultDownloadNetworkService implements IDownloadNetworkService {
        public DefaultDownloadNetworkService() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetworkService
        public IDownloadHttpConnection downloadWithConnection(boolean r100, int r101, String r102, String r103, List<HttpHeader> r104, int r105, boolean r106, DownloadInfo r107) throws Exception {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetworkService
        public IDownloadHttpConnection downloadWithConnection(boolean r100, int r101, String r102, List<HttpHeader> r103) throws Exception {
            return null;
        }
    }

    IDownloadHttpConnection downloadWithConnection(boolean r100, int r101, String r102, String r103, List<HttpHeader> r104, int r105, boolean r106, DownloadInfo r107) throws Exception;

    IDownloadHttpConnection downloadWithConnection(boolean r100, int r101, String r102, List<HttpHeader> r103) throws Exception;
}
