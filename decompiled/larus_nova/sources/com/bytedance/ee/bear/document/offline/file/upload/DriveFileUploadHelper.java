package com.bytedance.ee.bear.document.offline.file.upload;

import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import java.util.HashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveFileUploadHelper implements i {

    public static class DriveFileUploadCallback implements UploadCallback {
        private final i.a callback;
        private final FlowableEmitter<UploadResult> emitter;

        public DriveFileUploadCallback(i.a r100, FlowableEmitter<UploadResult> r101) {
            this.callback = r100;
            this.emitter = r101;
        }

        @Override // com.bytedance.ee.bear.middleground.drive.export.UploadCallback
        public boolean updateProgress(String r100, UploadCallback.b r101, UploadCallback.a r102) {
            if (r101.f232490a != DriveFile.Status.SUCCESS) goto L11;
            UploadResult r103 = new UploadResult();
            r103.setFileToken(r102.f232476a);
            r103.setCode(0);
            if (this.emitter.isCancelled() == true) goto L7;
            this.emitter.onNext(r103);
            this.emitter.onComplete();
        L7:
            i.a r104 = this.callback;
            if (r104 == null) goto L11;
            r104.c(r100, r101, r102);
        L11:
            if (r101.f232490a != DriveFile.Status.INFLIGHT) goto L17;
            i.a r105 = this.callback;
            if (r105 == null) goto L18;
            r105.b(r100, Float.valueOf((r101.f232491b * 1.0f) / r101.f232492c));
            return true;
        L18:
            return true;
        L17:
            return true;
        }

        @Override // com.bytedance.ee.bear.middleground.drive.export.UploadCallback
        public boolean onFailed(String r100, int r101, String r102, long r103) {
            UploadResult r104 = new UploadResult();
            r104.setCode(r101);
            if (this.emitter.isCancelled() == true) goto L5;
            this.emitter.onNext(r104);
            this.emitter.onComplete();
        L5:
            i.a r105 = this.callback;
            if (r105 == null) goto L8;
            UploadCallback.b.a r106 = new UploadCallback.b.a();
            r106.f232493a = DriveFile.Status.FAILED;
            r106.f232495c = r103;
            UploadCallback.b r107 = new UploadCallback.b(r106);
            UploadCallback.a.C3324a r108 = new UploadCallback.a.C3324a();
            r108.f232486d = r102;
            r105.c(r100, r107, new UploadCallback.a(r108));
        L8:
            tt5.a.d("DriveFileUploadHelper", "onFailed()... key = " + du5.b.g(r100) + ", errorCode = " + r101);
            return false;
        }
    }

    public DriveFileUploadHelper() {
    }

    @Override // com.bytedance.ee.bear.document.offline.file.upload.i
    public final Flowable<UploadResult> a(final String r100, final i.a r101) {
        return Flowable.create(new f(r100, r101), BackpressureStrategy.BUFFER);
    }

    @Override // com.bytedance.ee.bear.document.offline.file.upload.i
    public final Flowable<UploadResult> b(final FileUploadModel r100, final v r101, final i.a r102) {
        if (r101.f220487e == null) goto L5;
        final HashMap r103 = new HashMap(r101.f220487e);
    L6:
        r103.put("size_checker", String.valueOf(((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).e()));
        return Flowable.create(new g(r101, r100, r103, r102), BackpressureStrategy.BUFFER);
    L5:
        r103 = new HashMap();
        goto L6
    }
}
