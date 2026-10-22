package com.bytedance.ee.bear.drive.loader.download.platform.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.drive.loader.download.model.drive.DriveVideoPreviewResponse;
import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.FileInfoV1Puller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.PreviewGetV1Puller;
import io.reactivex.Flowable;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J.\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180!2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/DriveVideoPreviewLoader;", "Lcom/bytedance/ee/bear/drive/loader/IDriveVideoPreviewLoader;", "<init>", "()V", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "getNetService", "()Lcom/bytedance/ee/bear/contract/NetService;", "netService$delegate", "Lkotlin/Lazy;", "infoProvideService", "Lcom/bytedance/ee/bear/contract/InfoProvideService;", "getInfoProvideService", "()Lcom/bytedance/ee/bear/contract/InfoProvideService;", "infoProvideService$delegate", "fetchDriveVideoPreview", "Lcom/bytedance/ee/bear/drive/callback/ICancelable;", "fileToken", "", "callback", "Lcom/bytedance/ee/bear/drive/callback/IDriveVideoPreviewCallBack;", "params", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/drive/FileInfoV1Puller$Params;", "fileInfoTranscode", "Lcom/bytedance/ee/bear/drive/loader/download/model/drive/DriveVideoPreviewResponse;", "videoMeta", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/FileInfoMeta;", "originUrl", "buildPreviewParams", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/drive/PreviewGetV1Puller$Params;", TipCallBackData.RESULT, "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/drive/FileInfoV1Puller$Result;", "previewGetTranscodeFlow", "Lio/reactivex/Flowable;", "previewParams", "statusHolder", "Ljava/util/concurrent/atomic/AtomicInteger;", "attemptHolder", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveVideoPreviewLoader implements a85.c {
    public static final Companion Companion = null;
    private static final int DEFAULT_PREVIEW_GET_INTERVAL = 3000;
    private static final int MAX_POLLING_ATTEMPTS = 50;
    private static final long MAX_TOTAL_TIME_SEC = 150;
    private static final String TAG = "DriveVideoPreviewLoader";
    private final Lazy infoProvideService$delegate;
    private final Lazy netService$delegate;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/DriveVideoPreviewLoader$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_PREVIEW_GET_INTERVAL", "", "MAX_POLLING_ATTEMPTS", "MAX_TOTAL_TIME_SEC", "", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final b0 getInfoProvideService() {
        return (b0) this.infoProvideService$delegate.getValue();
    }

    private final NetService getNetService() {
        return (NetService) this.netService$delegate.getValue();
    }

    public DriveVideoPreviewLoader() {
        this.netService$delegate = LazyKt.lazy(DriveVideoPreviewLoader$netService$2.INSTANCE);
        this.infoProvideService$delegate = LazyKt.lazy(DriveVideoPreviewLoader$infoProvideService$2.INSTANCE);
    }

    private final PreviewGetV1Puller.Params buildPreviewParams(FileInfoV1Puller.Result r10, FileInfoV1Puller.Params r11) {
        return new PreviewGetV1Puller.Params(r11.file_token, r11.mount_node_token, r11.mount_point, 3, false, r10.version, r11.extra);
    }

    private final DriveVideoPreviewResponse fileInfoTranscode(FileInfoMeta r4, String r5) {
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r4.status != 0) goto L16;
        FileInfoMeta.Content r1 = r4.content;
        if (r1 == null) goto L9;
        LinkedHashMap<String, String> r2 = r1.transcodeUrls;
    L10:
        if (r2 != null) goto L12;
        return null;
    L12:
        if ((!r1.transcodeUrls.isEmpty()) == false) goto L18;
        tt5.a.h(TAG, "fast path success via file/info, urlCount=" + r4.content.transcodeUrls.size());
        return new DriveVideoPreviewResponse(r4.content.transcodeUrls, r5, r4.status);
    L18:
        return null;
    L9:
        r2 = null;
        goto L10
    L16:
        return null;
    }

    public final h75.a fetchDriveVideoPreview(final FileInfoV1Puller.Params r16, final h75.d r17) {
        Intrinsics.checkNotNullParameter(r16, "params");
        Intrinsics.checkNotNullParameter(r17, "callback");
        final io.reactivex.disposables.a r8 = new io.reactivex.disposables.a();
        String r0 = r16.file_token;
        if (r0 != null) goto L5;
        final String r9 = "";
    L6:
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        r10.element = "";
        final AtomicInteger r11 = new AtomicInteger(-1);
        final AtomicInteger r12 = new AtomicInteger(0);
        Flowable r13 = new FileInfoV1Puller(getNetService()).pull(r16).doOnSubscribe(new AnonymousClass1(r9, r16)).subscribeOn(fo5.d.e());
        final String r1 = r9;
        final String r2 = r9;
        r8.b(r13.flatMap(new AnonymousClass2(r1, r10, r11, this, r16, r12)).timeout(150, TimeUnit.SECONDS).onErrorResumeNext(new AnonymousClass3(r9, r11, r12)).observeOn(fo5.d.d()).subscribeWith(new AnonymousClass4(r2, r17, r11, r12, r10)));
        return new AnonymousClass6(r9, r12, r11, r8);
    L5:
        r9 = r0;
        goto L6
    }

    @Override // a85.c
    public h75.a fetchDriveVideoPreview(String r9, h75.d r10) {
        Intrinsics.checkNotNullParameter(r9, "fileToken");
        Intrinsics.checkNotNullParameter(r10, "callback");
        return fetchDriveVideoPreview(new FileInfoV1Puller.Params(r9, null, FileInfoPuller.CALLER_EXPLORER, null, null, null), r10);
    }

    public static final /* synthetic */ PreviewGetV1Puller.Params access$buildPreviewParams(DriveVideoPreviewLoader r0, FileInfoV1Puller.Result r1, FileInfoV1Puller.Params r2) {
        return r0.buildPreviewParams(r1, r2);
    }

    public static final /* synthetic */ DriveVideoPreviewResponse access$fileInfoTranscode(DriveVideoPreviewLoader r0, FileInfoMeta r1, String r2) {
        return r0.fileInfoTranscode(r1, r2);
    }

    private final Flowable<DriveVideoPreviewResponse> previewGetTranscodeFlow(PreviewGetV1Puller.Params r11, final String r12, final AtomicInteger r13, final AtomicInteger r14) {
        final AtomicInteger r0 = new AtomicInteger(DEFAULT_PREVIEW_GET_INTERVAL);
        final String r1 = r11.file_token;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r4 = r1;
        return new PreviewGetV1Puller(getNetService()).pull(r11).doOnNext(new C03481(r13, r0, r1)).flatMap(new C03492(r1, r0)).repeatWhen(new C03503(r14, r1, r0)).take(1).switchIfEmpty(Flowable.error(new DriveVideoPreviewException("preview/get not ready within max attempts", r4, r13.get(), r14.get(), null, 16, null))).map(new C03514(r1, r14, r12));
    }

    public static final /* synthetic */ Flowable access$previewGetTranscodeFlow(DriveVideoPreviewLoader r0, PreviewGetV1Puller.Params r1, String r2, AtomicInteger r3, AtomicInteger r4) {
        return r0.previewGetTranscodeFlow(r1, r2, r3, r4);
    }
}
