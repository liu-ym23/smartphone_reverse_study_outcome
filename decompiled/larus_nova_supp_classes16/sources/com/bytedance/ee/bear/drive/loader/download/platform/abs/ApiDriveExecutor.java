package com.bytedance.ee.bear.drive.loader.download.platform.abs;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.core.model.PreviewMeta;
import com.bytedance.ee.bear.drive.loader.download.model.Content;
import com.bytedance.ee.bear.drive.loader.download.model.drive.DrivePreviewGetModel;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.model.DownloadParams;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.rust.RustDownloadPreviewUrl;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.rust.RustDownloadToken;
import com.bytedance.ee.bear.drive.loader.download.platform.api.IApiPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.IPoller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.Poller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.PreviewGetPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.PreviewGetV1Puller;
import com.bytedance.ee.bear.middleground.drive.export.DownloadCallback;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ApiDriveExecutor extends AbsDriveExecutor {
    private static final String TAG = "DrivePlatform_ApiV1Executor";

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.loader.download.platform.abs.ApiDriveExecutor$1, reason: invalid class name */
    public class AnonymousClass1 implements IApiExecutor.PreviewGet {
        IApiExecutor.TransformStartListener listener;
        IPoller<PreviewGetV1Puller.Params, DrivePreviewGetModel> poller;
        final /* synthetic */ ApiDriveExecutor this$0;

        public static /* synthetic */ void a(AnonymousClass1 r0) {
            r0.lambda$execute$0();
        }

        private /* synthetic */ void lambda$execute$0() {
            IApiExecutor.TransformStartListener r0 = this.listener;
            if (r0 == null) goto L6;
            r0.onTransformStart();
            return;
        }

        @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor.PreviewGet
        public void shutdown() {
            IPoller<PreviewGetV1Puller.Params, DrivePreviewGetModel> r0 = this.poller;
            if (r0 == null) goto L6;
            r0.shutdown();
            return;
        }

        public AnonymousClass1(ApiDriveExecutor r1) {
            this.this$0 = r1;
        }

        @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor.PreviewGet
        public IPreviewGetModel execute(final w75.c r11) throws Throwable {
            final f85.a r0 = ApiDriveExecutor.access$000(this.this$0, r11);
            IPoller<PreviewGetV1Puller.Params, DrivePreviewGetModel> r12 = PreviewGetPuller.V1Poller(new C01641(this, r11), new AnonymousClass2(this), new Poller.PushEntity(((f85.a.C0229a) r0.a).a), new AnonymousClass3(this, r0));
            this.poller = r12;
            r12.setPollingStartListener(new a(this));
            int r13 = w75.e.a;
            PreviewMeta r14 = w75.e.a.a(r0);
            if (r14 != null) goto L5;
        L7:
            IPoller<PreviewGetV1Puller.Params, DrivePreviewGetModel> r16 = this.poller;
            f85.a.C0229a r1 = (f85.a.C0229a) r0.a;
            DrivePreviewGetModel r17 = r16.poll(new PreviewGetV1Puller.Params(r1.a, r1.m, r1.n, r0.e, false, r1.o, r1.h));
        L9:
            return ApiDriveExecutor.access$300(this.this$0, r17, r0);
        L5:
            if (r14.getStatus() != 0) goto L7;
            r17 = ApiDriveExecutor.access$200(this.this$0, r0, r14);
            goto L9
        }

        @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor.PreviewGet
        public void setTransformStartListener(IApiExecutor.TransformStartListener r1) {
            this.listener = r1;
        }
    }

    public static class TransformResult implements Serializable {
        public Body body;
        public String data_version;
        public String file_token;

        public static class Body implements Serializable {
            public int preview_type;
            public int status;

            public Body() {
            }

            public String toString() {
                return "Body{preview_type=" + this.preview_type + ", status=" + this.status + '}';
            }
        }

        private TransformResult() {
        }

        public String toString() {
            return "TransformResult{file_token='" + yu5.c.j(this.file_token) + "', data_version='" + this.data_version + "', body=" + this.body + '}';
        }
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor
    public IApiExecutor.PreviewGet pollPreviewGet() {
        return new AnonymousClass1(this);
    }

    private f85.a getV1Details(w75.c r2) {
        w75.a r3 = r2.getDetails();
        if ((r3 instanceof f85.a) == false) goto L7;
        return (f85.a) r3;
    L7:
        throw new IllegalArgumentException("v1 detail not instance of DriveFileModel !!!");
    }

    private TransformResult parsePushData(String r4) {
        return (TransformResult) JSON.parseObject(r4, TransformResult.class);
    L4:
        e = move-exception;
        tt5.a.e(TAG, "ApiV1Executor: parse url json failed. ", e, false);
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor
    public boolean isDownloadSuccess(String r2) {
        return ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().isDownloadSuccess(r2);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor
    public IPreviewGetModel pullPreviewGet(w75.c r11) {
        f85.a r12 = getV1Details(r11);
        int r0 = w75.e.a;
        PreviewMeta r1 = w75.e.a.a(r12);
        if (r1 != null) goto L5;
    L7:
        IApiPuller<PreviewGetV1Puller.Params, DrivePreviewGetModel> r2 = PreviewGetPuller.V1();
        f85.a.C0229a r3 = (f85.a.C0229a) r12.a;
        DrivePreviewGetModel r4 = (DrivePreviewGetModel) r2.pull(new PreviewGetV1Puller.Params(r3.a, r3.m, r3.n, r12.e, false, r3.o, r3.h)).blockingSingle();
    L9:
        return wrapPreviewGet(r4, r12);
    L5:
        if (r1.getStatus() != 0) goto L7;
        r4 = getDrivePreviewGetModel(r12, r1);
        goto L9
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor
    public void stopDownload(String r1) {
        RustDownload.shutdown(r1);
    }

    public ApiDriveExecutor(String r1, a95.a r2) {
        super(r1, r2);
    }

    public static /* synthetic */ f85.a access$000(ApiDriveExecutor r0, w75.c r1) {
        return r0.getV1Details(r1);
    }

    public static /* synthetic */ TransformResult access$100(ApiDriveExecutor r0, String r1) {
        return r0.parsePushData(r1);
    }

    private DrivePreviewGetModel getDrivePreviewGetModel(f85.a r19, PreviewMeta r20) {
        PreviewMeta.Content r1 = r20.getContent();
        if (r1 != null) goto L5;
        Content r13 = Content.EMPTY;
    L6:
        w75.b r2 = r19.a;
        return new DrivePreviewGetModel(((f85.a.C0229a) r2).a, ((f85.a.C0229a) r2).m, ((f85.a.C0229a) r2).n, r19.e, ((f85.a.C0229a) r2).o, r20.getStatus(), r20.getInterval(), r20.getLongPushRetryInterval(), r13, r20.isLinearized(), r20.getPreviewFileSize(), r20.getExtra());
    L5:
        r13 = new Content(r1.type, r1.transcodeUrls);
        goto L6
    }

    private IPreviewGetModel wrapPreviewGet(final DrivePreviewGetModel r2, final f85.a r3) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass2(this, r2, r3);
    }

    public static /* synthetic */ DrivePreviewGetModel access$200(ApiDriveExecutor r0, f85.a r1, PreviewMeta r2) {
        return r0.getDrivePreviewGetModel(r1, r2);
    }

    public static /* synthetic */ IPreviewGetModel access$300(ApiDriveExecutor r0, DrivePreviewGetModel r1, f85.a r2) {
        return r0.wrapPreviewGet(r1, r2);
    }

    private String doRealDownloadAction(w75.c r16, DownloadCallback r17, DownloadParams r18) {
        f85.a r0 = getV1Details(r16);
        if (r18.isSaveToLocalFilePath() == false) goto L5;
        DriveFilePath r1 = r0.a();
    L6:
        String r3 = z75.b.a(r1, getUserComponentAbility().b);
        w75.b r2 = r0.a;
        return new RustDownloadToken(r3, ((f85.a.C0229a) r2).a, ((f85.a.C0229a) r2).p, ((f85.a.C0229a) r2).n, ((f85.a.C0229a) r2).m, ((f85.a.C0229a) r2).h, r18.getDownloadType(), r18.getPriority(), r17, r18.getDriveBizScene(), r18.getDriveWatermarkScene()).execute();
    L5:
        r1 = r0.b();
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor
    public String downloadByPreviewUrl(w75.c r13, long r14, DownloadCallback r16, DrivePriority.DownloadPriority r17) {
        f85.a r0 = getV1Details(r13);
        String r2 = z75.b.a(r0.a(), getUserComponentAbility().b);
        String r5 = r0.i;
        w75.b r1 = r0.a;
        return new RustDownloadPreviewUrl(r2, r14, r5, ((f85.a.C0229a) r1).p, ((f85.a.C0229a) r1).n, ((f85.a.C0229a) r1).h, r17, r16).execute();
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor
    public String downloadByToken(w75.c r1, long r2, DownloadCallback r4, DownloadParams r5) {
        return doRealDownloadAction(r1, r4, r5);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor
    public String downloadSimilarFile(w75.c r1, long r2, DownloadCallback r4, DownloadParams r5) {
        return doRealDownloadAction(r1, r4, r5);
    }

    private String doRealDownloadAction(w75.c r14, boolean r16, DownloadCallback r17, DrivePriority.DownloadPriority r18, DownloadRequestInfo.DownloadType r19) {
        f85.a r0 = getV1Details(r14);
        if (r16 == false) goto L5;
        DriveFilePath r1 = r0.a();
    L6:
        String r3 = z75.b.a(r1, getUserComponentAbility().b);
        w75.b r2 = r0.a;
        return new RustDownloadToken(r3, ((f85.a.C0229a) r2).a, ((f85.a.C0229a) r2).p, ((f85.a.C0229a) r2).n, ((f85.a.C0229a) r2).m, ((f85.a.C0229a) r2).h, r19, r18, r17).execute();
    L5:
        r1 = r0.b();
        goto L6
    }
}
