package com.ss.ttvideoengine;

import com.ss.mediakit.medialoader.AVMDLDataLoaderNotifyInfo;

/* JADX INFO: loaded from: classes34.dex */
public class DataLoaderHelperAdapter {

    public static class HlsProxyQueryParam {
        public boolean enableInfoCallback;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f457052id;
        public String[] urlExpires;

        public HlsProxyQueryParam() {
        }

        public String buildQuery() {
            throw new UnsupportedOperationException("hp only");
        }
    }

    public DataLoaderHelperAdapter() {
    }

    public void cancelAll() {
        throw new UnsupportedOperationException("hp only");
    }

    public long getAllCacheSize() {
        throw new UnsupportedOperationException("hp only");
    }

    public void initHLSCacheModule() {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean isHlsProxyValid() {
        throw new UnsupportedOperationException("hp only");
    }

    public void onMDLStartComplete() {
        throw new UnsupportedOperationException("hp only");
    }

    public void removeAllHLSCache() {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean cancelDownload(String r100) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean cancelPreload(String r100) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean convertHLSProxyUrl(StringBuffer r100) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean downloadHlsSource(String r100) {
        throw new UnsupportedOperationException("hp only");
    }

    public long getCacheSize(String r100) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean onDownloadCompleted(AVMDLDataLoaderNotifyInfo r100) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean onDownloadFail(AVMDLDataLoaderNotifyInfo r100) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean onDownloadProgress(AVMDLDataLoaderNotifyInfo r100) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean onLoaderCancel(AVMDLDataLoaderNotifyInfo r100) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean onLoaderFail(AVMDLDataLoaderNotifyInfo r100) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean onLoaderOpen(AVMDLDataLoaderNotifyInfo r100) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean onLoaderProgress(AVMDLDataLoaderNotifyInfo r100) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean removeCache(String r100) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean removeCacheFile(String r100) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean removeDownloadFile(String r100) {
        throw new UnsupportedOperationException("hp only");
    }

    public void setEnablePreloadAllTs(int r100) {
        throw new UnsupportedOperationException("hp only");
    }

    public void setEnablePreloadFirstTs(int r100) {
        throw new UnsupportedOperationException("hp only");
    }

    public void setHLSCacheDir(String r100) {
        throw new UnsupportedOperationException("hp only");
    }

    public void setHLSDownloadDir(String r100) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean preloadHLSSource(String r100, long r101) {
        throw new UnsupportedOperationException("hp only");
    }
}
