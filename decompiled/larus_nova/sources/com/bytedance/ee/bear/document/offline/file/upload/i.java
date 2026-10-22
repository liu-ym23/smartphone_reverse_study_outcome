package com.bytedance.ee.bear.document.offline.file.upload;

import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: classes16.dex */
public interface i {

    public interface a {
        void a(String r100);

        void b(String r100, Float r101);

        void c(String r100, UploadCallback.b r101, UploadCallback.a r102);
    }

    Flowable<UploadResult> a(String r100, a r101);

    Flowable<UploadResult> b(FileUploadModel r100, v r101, a r102);
}
