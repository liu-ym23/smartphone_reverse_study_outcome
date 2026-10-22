package com.bytedance.ee.bear.drive.loader.download.platform.abs;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes16.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface PreviewStatus {
    public static final int OVER_MUCH_NODES_IN_DIRECTORY = 1003;
    public static final int OVER_MUCH_NODES_IN_TOTAL = 1002;
    public static final int STATE_CANNOT_PREVIEW = 4;
    public static final int STATE_FAIL = 3;
    public static final int STATE_FILE_ENCRYPTED = 1006;
    public static final int STATE_FILE_ENCRYPTION = 9;
    public static final int STATE_FILE_TYPE_ERROR = 10;
    public static final int STATE_GENERATING = 1;
    public static final int STATE_MULTI_GENERATE_ERROR = 7;
    public static final int STATE_NO_NEED_WATEMARK = 1005;
    public static final int STATE_READY = 0;
    public static final int STATE_RETRY = 2;
    public static final int STATE_SIZE_ENDLESS = 5;
    public static final int STATE_SIZE_ZERO = 6;
    public static final int STATE_THIRD_SECRET_FILE = 1004;
    public static final int STATE_TYPE_NOT_MATCH = 8;
    public static final int UNEXPECTED_COMPRESS_FORMAT = 1001;
}
