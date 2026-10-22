package com.bytedance.ee.bear.drive.loader.download.platform.abs;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.core.model.PreviewMeta;
import com.bytedance.ee.bear.drive.loader.download.model.Content;
import com.bytedance.ee.bear.drive.loader.download.model.imfile.SdkPreviewGetModel;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.model.DownloadParams;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.rust.RustDownloadPreviewUrl;
import com.bytedance.ee.bear.drive.loader.download.platform.api.IApiPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.IPoller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.Poller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.PreviewGetPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.imfile.PreviewGetV2Puller;
import com.bytedance.ee.bear.middleground.drive.export.DownloadCallback;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ApiImFileExecutor extends AbsDriveExecutor {
    private static final String TAG = "DrivePlatform_ApiV2Executor";

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.loader.download.platform.abs.ApiImFileExecutor$1, reason: invalid class name */
    public class AnonymousClass1 implements IApiExecutor.PreviewGet {
        IApiExecutor.TransformStartListener listener;
        IPoller<PreviewGetV2Puller.Params, SdkPreviewGetModel> poller;
        final /* synthetic */ ApiImFileExecutor this$0;

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
            IPoller<PreviewGetV2Puller.Params, SdkPreviewGetModel> r0 = this.poller;
            if (r0 == null) goto L6;
            r0.shutdown();
            return;
        }

        public AnonymousClass1(ApiImFileExecutor r1) {
            this.this$0 = r1;
        }

        @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor.PreviewGet
        public IPreviewGetModel execute(final w75.c r8) throws Throwable {
            final f85.b r0 = ApiImFileExecutor.access$000(this.this$0, r8);
            Poller.IPullResultChecker<SdkPreviewGetModel> r1 = new C01651(this, r8);
            Poller.IPullIntervals<SdkPreviewGetModel> r9 = new AnonymousClass2(this);
            f85.b.a r4 = (f85.b.a) r0.a;
            IPoller<PreviewGetV2Puller.Params, SdkPreviewGetModel> r10 = PreviewGetPuller.V2Poller(r1, r9, new Poller.PushEntity(String.format("%s_%s", new Object[]{r4.m, r4.a})), new AnonymousClass3(this, r0));
            this.poller = r10;
            r10.setPollingStartListener(new b(this));
            int r11 = w75.e.a;
            PreviewMeta r12 = w75.e.a.a(r0);
            if (r12 != null) goto L5;
        L7:
            IPoller<PreviewGetV2Puller.Params, SdkPreviewGetModel> r13 = this.poller;
            f85.b.a r2 = (f85.b.a) r0.a;
            SdkPreviewGetModel r14 = r13.poll(new PreviewGetV2Puller.Params(r2.m, r2.a, r0.e, r2.n));
        L9:
            return ApiImFileExecutor.access$300(this.this$0, r14, r0);
        L5:
            if (r12.getStatus() != 0) goto L7;
            r14 = ApiImFileExecutor.access$200(this.this$0, r0, r12);
            goto L9
        }

        @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor.PreviewGet
        public void setTransformStartListener(IApiExecutor.TransformStartListener r1) {
            this.listener = r1;
        }
    }

    public static class TransformResult implements Serializable {
        public String app_file_id;
        public String app_id;
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
            return "TransformResult{app_id='" + yu5.c.j(this.app_id) + "', app_file_id='" + yu5.c.j(this.app_file_id) + "', file_token='" + yu5.c.j(this.file_token) + "', data_version='" + this.data_version + "', body=" + this.body + '}';
        }
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor
    public IApiExecutor.PreviewGet pollPreviewGet() {
        return new AnonymousClass1(this);
    }

    private f85.b getV2Details(w75.c r2) {
        w75.a r3 = r2.getDetails();
        if ((r3 instanceof f85.b) == false) goto L7;
        return (f85.b) r3;
    L7:
        throw new IllegalArgumentException("v2 detail not instance of SdkFileModel !!!");
    }

    private TransformResult parsePushData(String r4) {
        return (TransformResult) JSON.parseObject(r4, TransformResult.class);
    L4:
        e = move-exception;
        tt5.a.e(TAG, "ApiV2Executor: parse url json failed. ", e, false);
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor
    public boolean isDownloadSuccess(String r1) {
        return RustDownload.downloadSuccess(r1);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor
    public IPreviewGetModel pullPreviewGet(w75.c r7) {
        f85.b r8 = getV2Details(r7);
        int r0 = w75.e.a;
        PreviewMeta r1 = w75.e.a.a(r8);
        if (r1 != null) goto L5;
    L7:
        IApiPuller<PreviewGetV2Puller.Params, SdkPreviewGetModel> r2 = PreviewGetPuller.V2();
        f85.b.a r3 = (f85.b.a) r8.a;
        SdkPreviewGetModel r4 = (SdkPreviewGetModel) r2.pull(new PreviewGetV2Puller.Params(r3.m, r3.a, r8.e, r3.n)).blockingSingle();
    L9:
        return wrapPreviewGet(r4, r8);
    L5:
        if (r1.getStatus() != 0) goto L7;
        r4 = getSdkPreviewGetModel(r8, r1);
        goto L9
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor
    public void stopDownload(String r1) {
        RustDownload.shutdown(r1);
    }

    public ApiImFileExecutor(String r1, a95.a r2) {
        super(r1, r2);
    }

    public static /* synthetic */ f85.b access$000(ApiImFileExecutor r0, w75.c r1) {
        return r0.getV2Details(r1);
    }

    public static /* synthetic */ TransformResult access$100(ApiImFileExecutor r0, String r1) {
        return r0.parsePushData(r1);
    }

    private SdkPreviewGetModel getSdkPreviewGetModel(f85.b r16, PreviewMeta r17) {
        PreviewMeta.Content r0 = r17.getContent();
        if (r0 != null) goto L5;
        Content r10 = Content.EMPTY;
    L6:
        w75.b r1 = r16.a;
        return new SdkPreviewGetModel(((f85.b.a) r1).m, ((f85.b.a) r1).a, ((f85.b.a) r1).n, r17.getStatus(), r17.getInterval(), r17.getLongPushRetryInterval(), r10, r17.isLinearized(), r17.getPreviewFileSize(), r17.getExtra());
    L5:
        r10 = new Content(r0.type, r0.transcodeUrls);
        goto L6
    }

    private IPreviewGetModel wrapPreviewGet(final SdkPreviewGetModel r2, final f85.b r3) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass2(this, r2, r3);
    }

    public static /* synthetic */ SdkPreviewGetModel access$200(ApiImFileExecutor r0, f85.b r1, PreviewMeta r2) {
        return r0.getSdkPreviewGetModel(r1, r2);
    }

    public static /* synthetic */ IPreviewGetModel access$300(ApiImFileExecutor r0, SdkPreviewGetModel r1, f85.b r2) {
        return r0.wrapPreviewGet(r1, r2);
    }

    private String doRealDownloadAction(w75.c r14, long r16, DownloadCallback r17, DownloadParams r18) {
        f85.b r0 = getV2Details(r14);
        if (r18.isSaveToLocalFilePath() == false) goto L5;
        DriveFilePath r1 = r0.a();
    L7:
        return new RustDownloadPreviewUrl(z75.b.a(r1, getUserComponentAbility().b), r16, UrlSplicer.spliceV2SourceUrl(r0), "", ((f85.b.a) r0.a).p, null, r18.getPriority(), r17).execute();
    L5:
        r1 = r0.b();
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor
    public String downloadByPreviewUrl(w75.c r13, long r14, DownloadCallback r16, DrivePriority.DownloadPriority r17) {
        f85.b r0 = getV2Details(r13);
        return new RustDownloadPreviewUrl(z75.b.a(r0.a(), getUserComponentAbility().b), r14, r0.i, "", ((f85.b.a) r0.a).p, null, r17, r16).execute();
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor
    public String downloadByToken(w75.c r1, long r2, DownloadCallback r4, DownloadParams r5) {
        return doRealDownloadAction(r1, r2, r4, r5);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor
    public String downloadSimilarFile(w75.c r1, long r2, DownloadCallback r4, DownloadParams r5) {
        return doRealDownloadAction(r1, r2, r4, r5);
    }
}
