package com.ss.android.socialbase.downloader.thread;

import android.util.Pair;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public interface IDownloadRunnableCallback {
    void checkMaxBytes(long r100, int r101) throws BaseException;

    void handleFirstConnection(String r100, IDownloadHeadHttpConnection r101, long r102) throws BaseException;

    boolean onProgress(long r100) throws BaseException;

    void onReceiveData(byte[] r100, int r101);

    void onReceiveHeader(List<Pair<String, String>> r100);

    void onReceiveRequestLog(String r100);

    void onReceiveSegmentData(long r100, byte[] r101, int r102);
}
