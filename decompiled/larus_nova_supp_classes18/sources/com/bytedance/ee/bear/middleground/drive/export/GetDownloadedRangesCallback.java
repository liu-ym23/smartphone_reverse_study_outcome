package com.bytedance.ee.bear.middleground.drive.export;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface GetDownloadedRangesCallback extends Serializable {
    boolean onError(int r1);

    boolean onSuccess(List<DownloadRequestInfo.c> r1);
}
