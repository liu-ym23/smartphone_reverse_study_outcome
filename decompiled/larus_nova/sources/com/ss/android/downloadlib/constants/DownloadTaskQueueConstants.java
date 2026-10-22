package com.ss.android.downloadlib.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes34.dex */
public interface DownloadTaskQueueConstants {

    @Retention(RetentionPolicy.SOURCE)
    public @interface failCode {
        public static final int GET_CANCELED_TASK_FAILED = 503;
        public static final int GET_DOWNLOADING_TASK_FAILED = 502;
        public static final int GET_DOWNLOAD_FAILED_TASK_FAILED = 504;
        public static final int GET_WAITING_TASK_FAILED = 501;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface queue {
        public static final String DOWNLOADING_QUEUE = "downloading_queue";
        public static final String WAITING_QUEUE = "waiting_queue";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface scene {
        public static final int TASK_CLICK_CANCEL = 105;
        public static final int TASK_CLICK_CONTINUE = 103;
        public static final int TASK_CLICK_PAUSE = 102;
        public static final int TASK_CLICK_START = 101;
        public static final int TASK_DOWNLOAD_FAILED = 106;
        public static final int TASK_DOWNLOAD_FINISH = 104;
    }
}
