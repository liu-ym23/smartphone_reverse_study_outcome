package com.bytedance.ee.bear.document.offline.file.upload;

import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveFileUploadHelper implements i {

    public static class DriveFileUploadCallback implements UploadCallback {
        private final i.a callback;
        private final FlowableEmitter<UploadResult> emitter;

        public DriveFileUploadCallback(i.a r1, FlowableEmitter<UploadResult> r2) {
            this.callback = r1;
            this.emitter = r2;
        }

        public boolean updateProgress(String r4, UploadCallback.b r5, UploadCallback.a r6) {
            if (r5.a != DriveFile.Status.SUCCESS) goto L11;
            UploadResult r0 = new UploadResult();
            r0.setFileToken(r6.a);
            r0.setCode(0);
            if (this.emitter.isCancelled() == true) goto L7;
            this.emitter.onNext(r0);
            this.emitter.onComplete();
        L7:
            i.a r1 = this.callback;
            if (r1 == null) goto L11;
            r1.c(r4, r5, r6);
        L11:
            if (r5.a != DriveFile.Status.INFLIGHT) goto L17;
            i.a r7 = this.callback;
            if (r7 == null) goto L18;
            r7.b(r4, Float.valueOf((r5.b * 1.0f) / r5.c));
            return true;
        L18:
            return true;
        L17:
            return true;
        }

        public boolean onFailed(String r4, int r5, String r6, long r7) {
            UploadResult r0 = new UploadResult();
            r0.setCode(r5);
            if (this.emitter.isCancelled() == true) goto L5;
            this.emitter.onNext(r0);
            this.emitter.onComplete();
        L5:
            i.a r1 = this.callback;
            if (r1 == null) goto L8;
            UploadCallback.b.a r2 = new UploadCallback.b.a();
            r2.a = DriveFile.Status.FAILED;
            r2.c = r7;
            UploadCallback.b r8 = new UploadCallback.b(r2);
            UploadCallback.a.a r9 = new UploadCallback.a.a();
            r9.d = r6;
            r1.c(r4, r8, new UploadCallback.a(r9));
        L8:
            tt5.a.d("DriveFileUploadHelper", "onFailed()... key = " + du5.b.g(r4) + ", errorCode = " + r5);
            return false;
        }
    }

    public DriveFileUploadHelper() {
    }

    @Override // com.bytedance.ee.bear.document.offline.file.upload.i
    public final Flowable<UploadResult> a(final String r2, final i.a r3) {
        return Flowable.create(new f(r2, r3), BackpressureStrategy.BUFFER);
    }

    @Override // com.bytedance.ee.bear.document.offline.file.upload.i
    public final Flowable<UploadResult> b(final FileUploadModel r4, final v r5, final i.a r6) {
        if (r5.e == null) goto L5;
        final HashMap r0 = new HashMap(r5.e);
    L6:
        r0.put("size_checker", String.valueOf(((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).e()));
        return Flowable.create(new g(r5, r4, r0, r6), BackpressureStrategy.BUFFER);
    L5:
        r0 = new HashMap();
        goto L6
    }
}
