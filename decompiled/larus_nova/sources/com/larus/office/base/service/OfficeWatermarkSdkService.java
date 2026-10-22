package com.larus.office.base.service;

import android.app.Dialog;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import okio.ByteString;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0001\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001aJ,\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096@¢\u0006\u0002\u0010!R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/office/base/service/OfficeWatermarkSdkService;", "Lcom/larus/office/base/service/IOfficeWatermarkSdkService;", "Lcom/larus/office/base/service/ISdkLifecycleV2;", "<init>", "()V", "watermarkService", "Lcom/ss/android/lark/integrator/security/compliance/export/IWatermarkService;", "watermarkDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "initDocSdk", "", "officeSDKUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "destroyDocSdk", "lifecycleOrder", "", "lifecycleCategory", "", "detachDialogWatermark", "dialog", "Landroid/app/Dialog;", "attachDialogWatermark", "awaitWatermarkService", "", "timeoutMs", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWatermarkedImageResource", "Lcom/larus/office/base/service/WatermarkedImageResource;", "scene", "path", "data", "", "(Ljava/lang/String;Ljava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeWatermarkSdkService implements IOfficeWatermarkSdkService, ISdkLifecycleV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.ss.android.lark.integrator.security.compliance.export.d f361093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CompletableDeferred<com.ss.android.lark.integrator.security.compliance.export.d> f361094b;

    public static final class a {
    }

    public static final class b implements IGetWaterMarkResourceCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<o> f361095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f361096b;

        @Override // com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback
        public final void onGetFailed() {
            FLogger.f375446a.w("OfficeWatermarkSdkSvc", "getWaterMarkResource onGetFailed scene=" + this.f361096b);
            if (this.f361095a.isActive() == false) goto L6;
            this.f361095a.resumeWith(Result.m9449constructorimpl(null));
            return;
        }

        public b(kotlinx.coroutines.j r100, String r101) {
            this.f361095a = r100;
            this.f361096b = r101;
        }

        @Override // com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback
        public final void onGetSuccess(String r100, ByteString r101) {
            Intrinsics.checkNotNullParameter(r101, HTTP.CONTENT_RANGE_BYTES);
            o r102 = new o(r100, r101.toByteArray());
            if (this.f361095a.isActive() == false) goto L6;
            this.f361095a.resumeWith(Result.m9449constructorimpl(r102));
            return;
        }
    }

    static {
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void destroyDocSdk() {
        this.f361093a = null;
        this.f361094b = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final String lifecycleCategory() {
        return "watermark";
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final int lifecycleOrder() {
        return 1;
    }

    public OfficeWatermarkSdkService() {
        this.f361094b = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    }

    @Override // com.larus.office.base.service.IOfficeWatermarkSdkService
    public final void K(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        com.ss.android.lark.integrator.security.compliance.export.d r101 = this.f361093a;
        if (r101 == null) goto L6;
        r101.K(r100);
        return;
    }

    @Override // com.larus.office.base.service.IOfficeWatermarkSdkService
    public final void M(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        com.ss.android.lark.integrator.security.compliance.export.d r101 = this.f361093a;
        if (r101 == null) goto L6;
        r101.L8(r100);
        return;
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void initDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
        this.f361093a = (com.ss.android.lark.integrator.security.compliance.export.d) r100.getService(com.ss.android.lark.integrator.security.compliance.export.d.class);
        FLogger.f375446a.i("OfficeWatermarkSdkSvc", "initDocSdk: watermarkService=" + this.f361093a);
        if (this.f361093a != null) goto L5;
        return;
    L5:
        if (this.f361094b.isCompleted() == true) goto L9;
        this.f361094b.complete(this.f361093a);
        return;
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void postInitDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void preInitDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
    }

    @Override // com.larus.office.base.service.IOfficeWatermarkSdkService
    public final Object N(long r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof OfficeWatermarkSdkService$awaitWatermarkService$1) == false) goto L7;
        OfficeWatermarkSdkService$awaitWatermarkService$1 r102 = (OfficeWatermarkSdkService$awaitWatermarkService$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = false;
        if (r106 == 0) goto L19;
        if (r106 != 1) goto L18;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L13 TimeoutCancellationException -> L15
    L26:
        boolean r108 = ((Boolean) r104).booleanValue();     // Catch: Exception -> L13 TimeoutCancellationException -> L15
    L36:
        return Boxing.boxBoolean(r108);
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r104);
        if (this.f361093a != null) goto L22;
        OfficeWatermarkSdkService$awaitWatermarkService$2 r109 = new OfficeWatermarkSdkService$awaitWatermarkService$2(this, null);     // Catch: Exception -> L13 TimeoutCancellationException -> L15
        r102.label = 1;     // Catch: Exception -> L13 TimeoutCancellationException -> L15
        r104 = TimeoutKt.b(r100, r109, r102);     // Catch: Exception -> L13 TimeoutCancellationException -> L15
        if (r104 != r105) goto L26;
        return r105;
    L22:
        return Boxing.boxBoolean(true);
    L15:
        e = move-exception;
        FLogger.f375446a.e("OfficeWatermarkSdkSvc", "awaitWatermarkService timeout: " + e.getMessage());
        if (this.f361093a == null) goto L34;
    L33:
        r107 = true;
    L34:
        r108 = r107;
    L13:
        e = move-exception;
        FLogger.f375446a.e("OfficeWatermarkSdkSvc", "awaitWatermarkService failed: " + e.getMessage());
        if (this.f361093a == null) goto L34;
    L7:
        r102 = new OfficeWatermarkSdkService$awaitWatermarkService$1(this, r101);
        goto L8
    }

    @Override // com.larus.office.base.service.IOfficeWatermarkSdkService
    public final Object L(String r100, String r101, byte[] r102, Continuation<? super o> r110) {
        com.ss.android.lark.integrator.security.compliance.export.d r103 = this.f361093a;
        if (r103 != null) goto L6;
        FLogger.f375446a.w("OfficeWatermarkSdkSvc", "getWatermarkedImageResource failed: watermarkService is null");
        return null;
    L6:
        if (r102 == null) goto L8;
        ByteString r104 = ByteString.a.e(ByteString.Companion, r102);
    L9:
        kotlinx.coroutines.j r105 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r110), 1);
        r105.C();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L12
        r103.w0(r100, r101, r104, new b(r105, r100));     // Catch: Throwable -> L12
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L19;
        FLogger.f375446a.w("OfficeWatermarkSdkSvc", "getWaterMarkResource exception: " + r108);
        if (r105.isActive() == false) goto L19;
        r105.resumeWith(Result.m9449constructorimpl(null));
    L19:
        Object r109 = r105.B();
        if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        DebugProbesKt.probeCoroutineSuspended(r110);
    L22:
        return r109;
    L12:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L8:
        r104 = null;
        goto L9
    }
}
