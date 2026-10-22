package com.bytedance.ee.bear.document.offline.file.upload;

import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface i {

    public interface a {
        void a(String r1);

        void b(String r1, Float r2);

        void c(String r1, UploadCallback.b r2, UploadCallback.a r3);
    }

    Flowable<UploadResult> a(String r1, a r2);

    Flowable<UploadResult> b(FileUploadModel r1, v r2, a r3);
}
