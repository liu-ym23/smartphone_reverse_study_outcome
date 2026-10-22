package com.bytedance.ee.bear.drive.loader.download.platform.api.imfile;

import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.loader.download.platform.api.BasePuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.SlidesInfoPuller;
import com.bytedance.ee.bear.net.CloudReqFun;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.lynx.tasm.LynxError;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0011\u0012\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0014J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/imfile/SlidesInfoV2Puller;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/BasePuller;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/SlidesInfoPuller$Params;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/SlidesInfoPuller$Result;", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "<init>", "(Lcom/bytedance/ee/bear/contract/NetService;)V", "buildRequest", "Lcom/bytedance/ee/bear/contract/NetService$SimpleRequest;", "path", "", "params", "pull", "Lio/reactivex/Flowable;", "canRetry", "", "Companion", "PullSlidesInfoRetryFunction", "DriveSlidesTrainException", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlidesInfoV2Puller extends BasePuller<SlidesInfoPuller.Params, SlidesInfoPuller.Result> {
    public static final Companion Companion = null;
    private static final int MAX_RETRY_COUNT = 20;
    private static final String REQUEST_URL = "/space/api/slide/file_edit_type/";
    private static final String TAG = "DrivePlatform_SlidesInfoPuller";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/imfile/SlidesInfoV2Puller$Companion;", "", "<init>", "()V", "TAG", "", "REQUEST_URL", "MAX_RETRY_COUNT", "", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/imfile/SlidesInfoV2Puller$DriveSlidesTrainException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errMsg", "", "<init>", "(Lcom/bytedance/ee/bear/drive/loader/download/platform/api/imfile/SlidesInfoV2Puller;Ljava/lang/String;)V", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DriveSlidesTrainException extends Exception {
        private final String errMsg;
        final /* synthetic */ SlidesInfoV2Puller this$0;

        public DriveSlidesTrainException(SlidesInfoV2Puller r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errMsg");
            this.this$0 = r100;
            super(r101);
            this.errMsg = r101;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\u0004\u0018\u00002 \u0012\u0010\u0012\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0010\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/imfile/SlidesInfoV2Puller$PullSlidesInfoRetryFunction;", "Lio/reactivex/functions/Function;", "Lio/reactivex/Flowable;", "", "maxRetries", "", "canRetry", "", "<init>", "(Lcom/bytedance/ee/bear/drive/loader/download/platform/api/imfile/SlidesInfoV2Puller;IZ)V", DBDefinition.RETRY_COUNT, e1.REPLY_ACTION_APPLY, "flowable", "isIoException", LynxError.LYNX_THROWABLE, "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class PullSlidesInfoRetryFunction implements Function<Flowable<? extends Throwable>, Flowable<?>> {
        private final boolean canRetry;
        private final int maxRetries;
        private int retryCount;
        final /* synthetic */ SlidesInfoV2Puller this$0;

        public static final /* synthetic */ boolean access$getCanRetry$p(PullSlidesInfoRetryFunction r100) {
            return r100.canRetry;
        }

        public static final /* synthetic */ int access$getMaxRetries$p(PullSlidesInfoRetryFunction r100) {
            return r100.maxRetries;
        }

        public static final /* synthetic */ int access$getRetryCount$p(PullSlidesInfoRetryFunction r100) {
            return r100.retryCount;
        }

        private final boolean isIoException(Throwable r100) {
            if ((r100 instanceof IOException) == false) goto L5;
        L12:
            return true;
        L5:
            if ((r100.getCause() instanceof IOException) == true) goto L12;
            if ((r100 instanceof CloudReqFun.OkHttpReqException) == true) goto L12;
            if ((r100 instanceof DriveSlidesTrainException) == true) goto L12;
            return false;
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public Flowable<?> apply2(Flowable<? extends Throwable> r100) {
            Intrinsics.checkNotNullParameter(r100, "flowable");
            return r100.flatMap(new SlidesInfoV2Puller$PullSlidesInfoRetryFunction$apply$1(this));
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Flowable<?> apply(Flowable<? extends Throwable> r100) {
            return apply2(r100);
        }

        public static final /* synthetic */ boolean access$isIoException(PullSlidesInfoRetryFunction r100, Throwable r101) {
            return r100.isIoException(r101);
        }

        public static final /* synthetic */ void access$setRetryCount$p(PullSlidesInfoRetryFunction r100, int r101) {
            r100.retryCount = r101;
        }

        public PullSlidesInfoRetryFunction(SlidesInfoV2Puller r100, int r101, boolean r102) {
            this.this$0 = r100;
            this.maxRetries = r101;
            this.canRetry = r102;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SlidesInfoV2Puller(NetService r100) {
        Intrinsics.checkNotNullParameter(r100, "netService");
        super(r100, REQUEST_URL);
    }

    public NetService.f<?> buildRequest(String r100, SlidesInfoPuller.Params r101) {
        StringBuilder r102 = new StringBuilder();
        r102.append(r100);
        if (r101 == null) goto L5;
        String r103 = r101.getFileToken();
    L6:
        r102.append(r103);
        String r104 = r102.toString();
        a.h("DrivePlatform_SlidesInfoPuller", "buildRequest, requestPath=" + r104);
        NetService.f<?> r105 = new NetService.f(r104);
        r105.f216906c = 2;
        return r105;
    L5:
        r103 = null;
        goto L6
    }

    public final Flowable<SlidesInfoPuller.Result> pull(final SlidesInfoPuller.Params r100, boolean r101) {
        a.h("DrivePlatform_SlidesInfoPuller", "V2 pullSlidesInfo start");
        if (r100 == null) goto L5;
        String r102 = r100.getFileName();
    L6:
        String r103 = com.bytedance.ee.util.io.a.c(r102);
        boolean r104 = ExportFileExtension.PPTX.equalsIgnoreCase(r103);
        a.h("DrivePlatform_SlidesInfoPuller", "V2 pullSlidesInfo skip, extension=" + r103 + ", isSlidesSupport=" + r104);
        if (r104 == true) goto L11;
        return Flowable.just(SlidesInfoPuller.Result.Companion.buildWpsResult());
    L11:
        return pull(r100).flatMap(new AnonymousClass1(this)).retryWhen(new PullSlidesInfoRetryFunction(this, 20, r101)).onErrorResumeNext(new AnonymousClass2(r100)).flatMap(AnonymousClass3.INSTANCE);
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.api.BasePuller
    public /* bridge */ /* synthetic */ NetService.f buildRequest(String r100, BasePuller.Params r101) {
        return buildRequest(r100, (SlidesInfoPuller.Params) r101);
    }
}
