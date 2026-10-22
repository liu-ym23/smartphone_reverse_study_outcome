package com.bytedance.ee.bear.drive.loader.download.platform.abs;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface IPreviewGetModel<T> {
    T getDetails();

    String getExtra();

    boolean getLinearized();

    long getPreviewFileSize();

    String getPreviewSubUrl();

    String getPreviewUrl();

    int getStatus();

    Map<String, String> getVideoTranscodeUrls();
}
