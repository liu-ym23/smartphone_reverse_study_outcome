package com.ttnetuploader.uploader.task;

import com.ttnetuploader.uploader.api.ResultInfo;

/* JADX INFO: loaded from: classes41.dex */
public interface ITask {
    ResultInfo delete();

    String getCurrDevIp();

    long getUploadId();

    ResultInfo queryServerDisk();

    void start();

    void suspend();
}
