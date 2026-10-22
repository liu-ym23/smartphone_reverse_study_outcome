package com.bytedance.ee.plugin.common.ttpdfreader;

import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public interface IStreamingDownloader {

    public interface DownloadCallback {
        void onResult(String r100, int r101, List<Range> r102);
    }

    public interface Status {
        public static final int CANCEL = 6;
        public static final int FAILED = 2;
        public static final int INFLIGHT = 1;
        public static final int PENDING = 0;
        public static final int QUEUE = 4;
        public static final int RANGE_FINISH = 7;
        public static final int READY = 5;
        public static final int SUCCESS = 3;
        public static final int UNKNOWN = -1;
    }

    void cancelTask(String... r100);

    void deleteRecord();

    String download(DownloadCallback r100, List<Range> r101);

    String filePath();

    long fileSize();

    void getDownloadedRanges(DownloadCallback r100);

    void onPageReady(int r100);

    long requiredHeadTailSize();
}
