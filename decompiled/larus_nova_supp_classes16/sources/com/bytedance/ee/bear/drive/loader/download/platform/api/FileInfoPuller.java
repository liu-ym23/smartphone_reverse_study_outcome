package com.bytedance.ee.bear.drive.loader.download.platform.api;

import android.util.SparseArray;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.core.model.PreviewMeta;
import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.FileInfoV1Puller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.imfile.FileInfoV2Puller;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.net.CloudReqFun;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FileInfoPuller {
    public static final String CALLER_EXPLORER = "explorer";
    public static final String CALLER_WIKI = "wiki";
    private static final String TAG = "DrivePlatform_FileInfoPuller";

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller$1, reason: invalid class name */
    public class AnonymousClass1 implements IApiPuller<FileInfoV1Puller.Params, f85.a> {
        final /* synthetic */ boolean val$retry;
        final /* synthetic */ FileInfoV1Puller val$v1Puller;

        public static /* synthetic */ Publisher a(FileInfoV1Puller.Params r0, Throwable r1) {
            return lambda$pull$0(r0, r1);
        }

        /* JADX INFO: renamed from: pull, reason: avoid collision after fix types in other method */
        public Flowable<f85.a> pull2(final FileInfoV1Puller.Params r5) {
            return this.val$v1Puller.pull(r5).retryWhen(new PullFileInfoRetryFunction(1, this.val$retry)).map(new V1ToModelConverter(r5)).onErrorResumeNext(new b(r5));
        }

        @Override // com.bytedance.ee.bear.drive.loader.download.platform.api.IApiPuller
        public /* bridge */ /* synthetic */ Flowable<f85.a> pull(FileInfoV1Puller.Params r1) {
            return pull2(r1);
        }

        public AnonymousClass1(FileInfoV1Puller r1, boolean r2) {
            this.val$v1Puller = r1;
            this.val$retry = r2;
        }

        private static /* synthetic */ Publisher lambda$pull$0(FileInfoV1Puller.Params r2, Throwable r3) throws Exception {
            tt5.a.d(FileInfoPuller.TAG, String.format("V1 pullFileInfo error, msg: %s, params: %s", new Object[]{r3, r2.toString()}));
            return Flowable.error(ServerErrParser.parseErr(r3, ErrCode.REQUEST_FILE_INFO_EXP));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller$2, reason: invalid class name */
    public class AnonymousClass2 implements IApiPuller<FileInfoV2Puller.Params, f85.b> {
        final /* synthetic */ boolean val$retry;
        final /* synthetic */ FileInfoV2Puller val$v2Puller;

        public static /* synthetic */ Publisher a(FileInfoV2Puller.Params r0, Throwable r1) {
            return lambda$pull$0(r0, r1);
        }

        /* JADX INFO: renamed from: pull, reason: avoid collision after fix types in other method */
        public Flowable<f85.b> pull2(final FileInfoV2Puller.Params r5) {
            return this.val$v2Puller.pull(r5).retryWhen(new PullFileInfoRetryFunction(1, this.val$retry)).map(new V2ToModelConvert(r5)).onErrorResumeNext(new c(r5));
        }

        @Override // com.bytedance.ee.bear.drive.loader.download.platform.api.IApiPuller
        public /* bridge */ /* synthetic */ Flowable<f85.b> pull(FileInfoV2Puller.Params r1) {
            return pull2(r1);
        }

        public AnonymousClass2(FileInfoV2Puller r1, boolean r2) {
            this.val$v2Puller = r1;
            this.val$retry = r2;
        }

        private static /* synthetic */ Publisher lambda$pull$0(FileInfoV2Puller.Params r2, Throwable r3) throws Exception {
            tt5.a.d(FileInfoPuller.TAG, String.format("V2 pullFileInfo error, msg: %s, params: %s", new Object[]{r3, r2.toString()}));
            return Flowable.error(ServerErrParser.parseErr(r3, ErrCode.REQUEST_FILE_INFO_EXP));
        }
    }

    public static class PullFileInfoRetryFunction implements Function<Flowable<? extends Throwable>, Flowable<?>> {
        private final int maxRetries;
        private final boolean retry;
        private int retryCount;

        public static /* synthetic */ Publisher c(PullFileInfoRetryFunction r0, Throwable r1) {
            return r0.lambda$apply$0(r1);
        }

        private boolean isIoException(Throwable r2) {
            if ((r2 instanceof IOException) == false) goto L5;
        L10:
            return true;
        L5:
            if ((r2.getCause() instanceof IOException) == true) goto L10;
            if ((r2 instanceof CloudReqFun.OkHttpReqException) == true) goto L10;
            return false;
        }

        private /* synthetic */ Publisher lambda$apply$0(Throwable r3) throws Exception {
            if (isIoException(r3) == false) goto L11;
            if (this.retry == false) goto L11;
            int r0 = this.retryCount + 1;
            this.retryCount = r0;
            if (r0 > this.maxRetries) goto L11;
            tt5.a.h(FileInfoPuller.TAG, "pull file info failed because of IOException! perform retry. retryCount = " + this.retryCount);
            return Flowable.timer(100, TimeUnit.MILLISECONDS);
        L11:
            return Flowable.error(r3);
        }

        public Flowable<?> apply(Flowable<? extends Throwable> r2) {
            return r2.flatMap(new d(this));
        }

        public /* bridge */ /* synthetic */ Object apply(Object r1) throws Exception {
            return apply((Flowable) r1);
        }

        public PullFileInfoRetryFunction(int r1, boolean r2) {
            this.maxRetries = r1;
            this.retry = r2;
        }
    }

    public static class V1ToModelConverter implements Function<FileInfoV1Puller.Result, f85.a> {
        private FileInfoV1Puller.Params params;

        public V1ToModelConverter(FileInfoV1Puller.Params r1) {
            this.params = r1;
        }

        public f85.a apply(FileInfoV1Puller.Result r24) throws Exception {
            SparseArray<PreviewMeta> r1 = r24.getPreviewMetaMap();
            int[] r2 = FileInfoPuller.access$000(r1, r24.availablePreviewType);
            tt5.a.h(FileInfoPuller.TAG, "V1ToModelConverter - apply, result: " + r24 + ", new availablePreviewType: " + Arrays.toString(r2));
            String r3 = r24.name;
            long r4 = r24.size;
            int r6 = r24.previewStatus;
            String r7 = r24.mimeType;
            boolean r8 = r24.webOffice;
            FileInfoV1Puller.Params r13 = this.params;
            return new f85.a(new f85.a.C0229a(r3, r4, r2, r6, r7, r8, r13.file_token, r13.mount_node_token, r13.mount_point, r24.version, r24.dataVersion, r24.creatorTenantId, r24.commentFlag, r24.permissionStatusCode, r13.extra, r1, r24.riskStatus));
        }

        public /* bridge */ /* synthetic */ Object apply(Object r1) throws Exception {
            return apply((FileInfoV1Puller.Result) r1);
        }
    }

    public static class V2ToModelConvert implements Function<FileInfoV2Puller.Result, f85.b> {
        private FileInfoV2Puller.Params params;

        public V2ToModelConvert(FileInfoV2Puller.Params r1) {
            this.params = r1;
        }

        public f85.b apply(FileInfoV2Puller.Result r19) throws Exception {
            SparseArray<PreviewMeta> r13 = r19.getPreviewMetaMap();
            int[] r4 = FileInfoPuller.access$000(r13, r19.availablePreviewType);
            tt5.a.h(FileInfoPuller.TAG, "V2ToModelConvert - apply, result: " + r19 + ", new availablePreviewType: " + Arrays.toString(r4));
            String r1 = r19.name;
            long r2 = r19.size;
            int r5 = r19.previewStatus;
            String r6 = r19.mimeType;
            boolean r7 = r19.webOffice;
            FileInfoV2Puller.Params r8 = this.params;
            return new f85.b(new f85.b.a(r1, r2, r4, r5, r6, r7, r8.app_id, r8.app_file_id, r8.auth_extra, r19.fileToken, r8.mount_point, r13));
        }

        public /* bridge */ /* synthetic */ Object apply(Object r1) throws Exception {
            return apply((FileInfoV2Puller.Result) r1);
        }
    }

    public FileInfoPuller() {
    }

    public static IApiPuller<FileInfoV1Puller.Params, f85.a> V1(NetService r1) {
        return V1(r1, true);
    }

    public static IApiPuller<FileInfoV2Puller.Params, f85.b> V2(NetService r1) {
        return V2(r1, true);
    }

    public static IApiPuller<FileInfoV1Puller.Params, f85.a> V1(NetService r1, boolean r2) {
        return new AnonymousClass1(new FileInfoV1Puller(r1), r2);
    }

    public static IApiPuller<FileInfoV2Puller.Params, f85.b> V2(NetService r1, boolean r2) {
        return new AnonymousClass2(new FileInfoV2Puller(r1), r2);
    }

    public static /* synthetic */ int[] access$000(SparseArray r0, int[] r1) {
        return toAvailableType(r0, r1);
    }

    private static int[] toAvailableType(SparseArray<PreviewMeta> r3, int[] r4) {
        if (r3 == null) goto L9;
        int r0 = r3.size();
        if (r0 == 0) goto L9;
        r4 = new int[r0];
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L9;
        r4[r1] = r3.keyAt(r1);
        r1 = r1 + 1;
    L9:
        return r4;
    }
}
