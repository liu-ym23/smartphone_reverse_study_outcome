package com.bytedance.ee.bear.drive.loader.download.platform.api.imfile;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.loader.download.platform.api.BasePuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.SheetInfoPuller;
import com.bytedance.ee.bear.net.CloudReqFun;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0011\u0012\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0014J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/imfile/SheetInfoV2Puller;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/BasePuller;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/SheetInfoPuller$Params;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/SheetInfoPuller$Result;", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "<init>", "(Lcom/bytedance/ee/bear/contract/NetService;)V", "buildRequest", "Lcom/bytedance/ee/bear/contract/NetService$SimpleRequest;", "path", "", "params", "pull", "Lio/reactivex/Flowable;", "canRetry", "", "Companion", "PullSheetInfoRetryFunction", "DriveSheetTrainException", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SheetInfoV2Puller extends BasePuller<SheetInfoPuller.Params, SheetInfoPuller.Result> {
    public static final Companion Companion = null;
    private static final int MAX_RETRY_COUNT = 10;
    private static final String REQUEST_URL = "/space/api/v2/sheet/file_edit_type/";
    private static final String TAG = "DrivePlatform_SheetInfoPuller";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/imfile/SheetInfoV2Puller$Companion;", "", "<init>", "()V", "TAG", "", "REQUEST_URL", "MAX_RETRY_COUNT", "", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/imfile/SheetInfoV2Puller$DriveSheetTrainException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errMsg", "", "<init>", "(Lcom/bytedance/ee/bear/drive/loader/download/platform/api/imfile/SheetInfoV2Puller;Ljava/lang/String;)V", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DriveSheetTrainException extends Exception {
        private final String errMsg;
        final /* synthetic */ SheetInfoV2Puller this$0;

        public DriveSheetTrainException(SheetInfoV2Puller r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "errMsg");
            this.this$0 = r2;
            super(r3);
            this.errMsg = r3;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\u0004\u0018\u00002 \u0012\u0010\u0012\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0010\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/imfile/SheetInfoV2Puller$PullSheetInfoRetryFunction;", "Lio/reactivex/functions/Function;", "Lio/reactivex/Flowable;", "", "maxRetries", "", "canRetry", "", "<init>", "(Lcom/bytedance/ee/bear/drive/loader/download/platform/api/imfile/SheetInfoV2Puller;IZ)V", "retryCount", "apply", "flowable", "isIoException", "throwable", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class PullSheetInfoRetryFunction implements Function<Flowable<? extends Throwable>, Flowable<?>> {
        private final boolean canRetry;
        private final int maxRetries;
        private int retryCount;
        final /* synthetic */ SheetInfoV2Puller this$0;

        public static final /* synthetic */ boolean access$getCanRetry$p(PullSheetInfoRetryFunction r0) {
            return r0.canRetry;
        }

        public static final /* synthetic */ int access$getMaxRetries$p(PullSheetInfoRetryFunction r0) {
            return r0.maxRetries;
        }

        public static final /* synthetic */ int access$getRetryCount$p(PullSheetInfoRetryFunction r0) {
            return r0.retryCount;
        }

        private final boolean isIoException(Throwable r2) {
            if ((r2 instanceof IOException) == false) goto L5;
        L12:
            return true;
        L5:
            if ((r2.getCause() instanceof IOException) == true) goto L12;
            if ((r2 instanceof CloudReqFun.OkHttpReqException) == true) goto L12;
            if ((r2 instanceof DriveSheetTrainException) == true) goto L12;
            return false;
        }

        public Flowable<?> apply(Flowable<? extends Throwable> r2) {
            Intrinsics.checkNotNullParameter(r2, "flowable");
            return r2.flatMap(new SheetInfoV2Puller$PullSheetInfoRetryFunction$apply$1(this));
        }

        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply((Flowable) r1);
        }

        public static final /* synthetic */ boolean access$isIoException(PullSheetInfoRetryFunction r0, Throwable r1) {
            return r0.isIoException(r1);
        }

        public static final /* synthetic */ void access$setRetryCount$p(PullSheetInfoRetryFunction r0, int r1) {
            r0.retryCount = r1;
        }

        public PullSheetInfoRetryFunction(SheetInfoV2Puller r1, int r2, boolean r3) {
            this.this$0 = r1;
            this.maxRetries = r2;
            this.canRetry = r3;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SheetInfoV2Puller(NetService r2) {
        Intrinsics.checkNotNullParameter(r2, "netService");
        super(r2, REQUEST_URL);
    }

    public NetService.f<?> buildRequest(String r2, SheetInfoPuller.Params r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r2);
        if (r3 == null) goto L5;
        String r4 = r3.getFileToken();
    L6:
        r0.append(r4);
        String r5 = r0.toString();
        a.h("DrivePlatform_SheetInfoPuller", "buildRequest, requestPath=" + r5);
        NetService.f<?> r6 = new NetService.f(r5);
        r6.c = 2;
        return r6;
    L5:
        r4 = null;
        goto L6
    }

    public final Flowable<SheetInfoPuller.Result> pull(final SheetInfoPuller.Params r7, boolean r8) {
        a.h("DrivePlatform_SheetInfoPuller", "V2 pullSheetInfo start");
        boolean r1 = c.a.a.g("ccm.drive.im_wps_edit_enable");
        if (r7 == null) goto L5;
        String r2 = r7.getFileName();
    L6:
        String r3 = com.bytedance.ee.util.io.a.c(r2);
        boolean r4 = "xlsx".equalsIgnoreCase(r3);
        a.h("DrivePlatform_SheetInfoPuller", "V2 pullSheetInfo skip, extension=" + r3 + ", isSheetSupport=" + r4 + ", isWpsEditEnable=" + r1);
        if (r4 == false) goto L13;
        if (r1 == false) goto L13;
        return pull(r7).flatMap(new AnonymousClass1(this)).retryWhen(new PullSheetInfoRetryFunction(this, 10, r8)).onErrorResumeNext(new AnonymousClass2(r7)).flatMap(AnonymousClass3.INSTANCE);
    L13:
        return Flowable.just(SheetInfoPuller.Result.Companion.buildWpsOnlyReaderResult());
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.api.BasePuller
    public /* bridge */ /* synthetic */ NetService.f buildRequest(String r1, BasePuller.Params r2) {
        return buildRequest(r1, (SheetInfoPuller.Params) r2);
    }
}
