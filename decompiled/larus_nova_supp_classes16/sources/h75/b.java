package h75;

import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.FileInfoV1Puller;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface b {
    void onError(Throwable r1);

    void onSuccess(FileInfoV1Puller.Result r1);
}
