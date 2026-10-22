package com.bytedance.ee.bear.drive.loader.download.platform.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.loader.download.model.Content;
import com.bytedance.ee.bear.drive.loader.download.model.drive.DrivePreviewGetModel;
import com.bytedance.ee.bear.drive.loader.download.model.imfile.SdkPreviewGetModel;
import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.PreviewGetV1Puller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.imfile.PreviewGetV2Puller;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PreviewGetPuller {
    private static final String TAG = "DrivePlatform_PreviewGetPuller";

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.loader.download.platform.api.PreviewGetPuller$1, reason: invalid class name */
    public class AnonymousClass1 implements IApiPuller<PreviewGetV1Puller.Params, DrivePreviewGetModel> {
        final /* synthetic */ com.bytedance.ee.bear.drive.report.a val$report;
        final /* synthetic */ PreviewGetV1Puller val$v1Puller;

        public static /* synthetic */ Publisher a(PreviewGetV1Puller.Params r0, Throwable r1) {
            return lambda$pull$1(r0, r1);
        }

        public static /* synthetic */ void b(com.bytedance.ee.bear.drive.report.a r0, PreviewGetV1Puller.Params r1, DrivePreviewGetModel r2) {
            lambda$pull$0(r0, r1, r2);
        }

        /* JADX INFO: renamed from: pull, reason: avoid collision after fix types in other method */
        public Flowable<DrivePreviewGetModel> pull2(final PreviewGetV1Puller.Params r5) {
            this.val$report.b(r5.file_token, "request_preview_url", null);
            Flowable r0 = this.val$v1Puller.pull(r5).map(new V1ToModelConvert(r5));
            final com.bytedance.ee.bear.drive.report.a r1 = this.val$report;
            return r0.doOnNext(new k(r1, r5)).onErrorResumeNext(new l(r5));
        }

        @Override // com.bytedance.ee.bear.drive.loader.download.platform.api.IApiPuller
        public /* bridge */ /* synthetic */ Flowable<DrivePreviewGetModel> pull(PreviewGetV1Puller.Params r1) {
            return pull2(r1);
        }

        public AnonymousClass1(com.bytedance.ee.bear.drive.report.a r1, PreviewGetV1Puller r2) {
            this.val$report = r1;
            this.val$v1Puller = r2;
        }

        private static /* synthetic */ Publisher lambda$pull$1(PreviewGetV1Puller.Params r2, Throwable r3) throws Exception {
            tt5.a.d(PreviewGetPuller.TAG, String.format("V1 previewGet error, msg: %s, params: %s", new Object[]{r3, r2.toString()}));
            return Flowable.error(r3);
        }

        private static /* synthetic */ void lambda$pull$0(com.bytedance.ee.bear.drive.report.a r0, PreviewGetV1Puller.Params r1, DrivePreviewGetModel r2) throws Exception {
            r0.q(r1.file_token, "request_preview_url");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.loader.download.platform.api.PreviewGetPuller$2, reason: invalid class name */
    public class AnonymousClass2 implements IApiPuller<PreviewGetV2Puller.Params, SdkPreviewGetModel> {
        final /* synthetic */ com.bytedance.ee.bear.drive.report.a val$report;
        final /* synthetic */ PreviewGetV2Puller val$v2Puller;

        public static /* synthetic */ Publisher a(PreviewGetV2Puller.Params r0, Throwable r1) {
            return lambda$pull$1(r0, r1);
        }

        public static /* synthetic */ void b(com.bytedance.ee.bear.drive.report.a r0, PreviewGetV2Puller.Params r1, SdkPreviewGetModel r2) {
            lambda$pull$0(r0, r1, r2);
        }

        /* JADX INFO: renamed from: pull, reason: avoid collision after fix types in other method */
        public Flowable<SdkPreviewGetModel> pull2(final PreviewGetV2Puller.Params r5) {
            this.val$report.b(r5.app_file_id, "request_preview_url", null);
            Flowable r0 = this.val$v2Puller.pull(r5).map(new V2ToModelConvert(r5));
            final com.bytedance.ee.bear.drive.report.a r1 = this.val$report;
            return r0.doOnNext(new m(r1, r5)).onErrorResumeNext(new n(r5));
        }

        @Override // com.bytedance.ee.bear.drive.loader.download.platform.api.IApiPuller
        public /* bridge */ /* synthetic */ Flowable<SdkPreviewGetModel> pull(PreviewGetV2Puller.Params r1) {
            return pull2(r1);
        }

        public AnonymousClass2(com.bytedance.ee.bear.drive.report.a r1, PreviewGetV2Puller r2) {
            this.val$report = r1;
            this.val$v2Puller = r2;
        }

        private static /* synthetic */ Publisher lambda$pull$1(PreviewGetV2Puller.Params r2, Throwable r3) throws Exception {
            tt5.a.d(PreviewGetPuller.TAG, String.format("V2 previewGet error, msg: %s, params: %s", new Object[]{r3, r2.toString()}));
            return Flowable.error(r3);
        }

        private static /* synthetic */ void lambda$pull$0(com.bytedance.ee.bear.drive.report.a r0, PreviewGetV2Puller.Params r1, SdkPreviewGetModel r2) throws Exception {
            r0.q(r1.app_file_id, "request_preview_url");
        }
    }

    public static class V1ToModelConvert implements Function<PreviewGetV1Puller.Result, DrivePreviewGetModel> {
        private PreviewGetV1Puller.Params params;

        public V1ToModelConvert(PreviewGetV1Puller.Params r1) {
            this.params = r1;
        }

        public DrivePreviewGetModel apply(PreviewGetV1Puller.Result r19) throws Exception {
            if (r19.content != null) goto L5;
            Content r1 = Content.EMPTY;
        L6:
            PreviewGetV1Puller.Params r3 = this.params;
            String r5 = r3.file_token;
            String r6 = r3.mount_node_token;
            String r7 = r3.mount_point;
            int r8 = r3.preview_type;
            String r9 = r3.version;
            int r10 = r19.status;
            int r11 = r19.interval;
            int r12 = r19.longPushRetryInterval;
            return new DrivePreviewGetModel(r5, r6, r7, r8, r9, r10, r11, r12, r1, r19.linearized, r19.previewFileSize, r19.extra);
        L5:
            PreviewGetV1Puller.Content r2 = r19.content;
            r1 = new Content(r2.type, r2.transcodeUrls);
            goto L6
        }

        public /* bridge */ /* synthetic */ Object apply(Object r1) throws Exception {
            return apply((PreviewGetV1Puller.Result) r1);
        }
    }

    public static class V2ToModelConvert implements Function<PreviewGetV2Puller.Result, SdkPreviewGetModel> {
        private PreviewGetV2Puller.Params params;

        public V2ToModelConvert(PreviewGetV2Puller.Params r1) {
            this.params = r1;
        }

        public SdkPreviewGetModel apply(PreviewGetV2Puller.Result r17) throws Exception {
            if (r17.content != null) goto L5;
            Content r1 = Content.EMPTY;
        L6:
            PreviewGetV2Puller.Params r3 = this.params;
            String r5 = r3.app_id;
            String r6 = r3.app_file_id;
            String r7 = r3.auth_extra;
            int r8 = r17.status;
            int r9 = r17.interval;
            int r10 = r17.longPushRetryInterval;
            return new SdkPreviewGetModel(r5, r6, r7, r8, r9, r10, r1, r17.linearized, r17.previewFileSize, r17.extra);
        L5:
            PreviewGetV2Puller.Content r2 = r17.content;
            r1 = new Content(r2.type, r2.transcodeUrls);
            goto L6
        }

        public /* bridge */ /* synthetic */ Object apply(Object r1) throws Exception {
            return apply((PreviewGetV2Puller.Result) r1);
        }
    }

    public PreviewGetPuller() {
    }

    public static IApiPuller<PreviewGetV1Puller.Params, DrivePreviewGetModel> V1() {
        PreviewGetV1Puller r0 = new PreviewGetV1Puller((NetService) org.koin.java.a.a(NetService.class));
        return new AnonymousClass1(o75.b.a().Tb(), r0);
    }

    public static IApiPuller<PreviewGetV2Puller.Params, SdkPreviewGetModel> V2() {
        PreviewGetV2Puller r0 = new PreviewGetV2Puller((NetService) org.koin.java.a.a(NetService.class));
        return new AnonymousClass2(o75.b.a().Tb(), r0);
    }

    public static IPoller<PreviewGetV1Puller.Params, DrivePreviewGetModel> V1Poller(Poller.IPullResultChecker<DrivePreviewGetModel> r2, Poller.IPullIntervals<DrivePreviewGetModel> r3, Poller.PushEntity r4, Poller.IPushResultChecker r5) {
        Poller r0 = new Poller(V1(), r2, r3);
        r0.enablePush(r4, r5);
        return r0;
    }

    public static IPoller<PreviewGetV2Puller.Params, SdkPreviewGetModel> V2Poller(Poller.IPullResultChecker<SdkPreviewGetModel> r2, Poller.IPullIntervals<SdkPreviewGetModel> r3, Poller.PushEntity r4, Poller.IPushResultChecker r5) {
        Poller r0 = new Poller(V2(), r2, r3);
        r0.enablePush(r4, r5);
        return r0;
    }
}
