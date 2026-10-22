package com.ss.android.downloadlib.addownload.interceptor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\fJ\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/ss/android/downloadlib/addownload/interceptor/TTDownloadInterceptor;", "", "tag", "", "getTag", "()Ljava/lang/String;", "intercept", "", "chain", "Lcom/ss/android/downloadlib/addownload/interceptor/TTDownloadInterceptor$Chain;", "index", "", "Chain", "download-impl_release"}, k = 1, mv = {1, 1, 16})
public interface TTDownloadInterceptor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/ss/android/downloadlib/addownload/interceptor/TTDownloadInterceptor$Chain;", "", "info", "Lcom/ss/android/downloadlib/addownload/interceptor/DownloadChainInfo;", "getInfo", "()Lcom/ss/android/downloadlib/addownload/interceptor/DownloadChainInfo;", "add", "interceptor", "Lcom/ss/android/downloadlib/addownload/interceptor/TTDownloadInterceptor;", "proceed", "", "index", "", "download-impl_release"}, k = 1, mv = {1, 1, 16})
    public interface Chain {
        Chain add(TTDownloadInterceptor r100);

        DownloadChainInfo getInfo();

        void proceed(int r100);
    }

    String getTag();

    void intercept(Chain r100, int r101);
}
