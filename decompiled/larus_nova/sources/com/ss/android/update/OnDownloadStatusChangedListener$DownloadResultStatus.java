package com.ss.android.update;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes40.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface OnDownloadStatusChangedListener$DownloadResultStatus {
    public static final int STATUS_CANCEL = -2;
    public static final int STATUS_FAILURE = -1;
    public static final int STATUS_SUCCESS = 1;
}
