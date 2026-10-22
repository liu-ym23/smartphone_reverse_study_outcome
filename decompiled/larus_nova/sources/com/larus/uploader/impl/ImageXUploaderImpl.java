package com.larus.uploader.impl;

import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalDowngradeData;
import com.larus.bmhome.chat.input.ChatInputService;
import com.larus.bmhome.upload.UploadImageMetaResolver;
import com.larus.bmhome.upload.sdk.ResourceUploadEngine$upload$2$1;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.b4;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.bduploader.BDImageXInfo;
import com.ss.bduploader.BDImageXUploader;
import com.ss.bduploader.BDImageXUploaderListener;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import mr9.j;
import mr9.k;
import mr9.l;

/* JADX INFO: loaded from: classes31.dex */
public final class ImageXUploaderImpl implements b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f375296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BDImageXUploader f375297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineScope f375298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b4.a f375299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f375300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.platform.model.chat.c f375301f;

    public final class ImageXUploadListener implements BDImageXUploaderListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f375302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageXUploaderImpl f375303b;

        @Override // com.ss.bduploader.BDImageXUploaderListener
        public final int imageXUploadCheckNetState(int r100, int r101) {
            return 1;
        }

        public ImageXUploadListener(ImageXUploaderImpl r100, j r101) {
            Intrinsics.checkNotNullParameter(r101, "param");
            this.f375303b = r100;
            this.f375302a = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1, types: [T, mr9.d] */
        public static final Object a(ImageXUploadListener r110, BDImageXInfo r111, Continuation r112) {
            r110.getClass();
            if ((r112 instanceof ImageXUploaderImpl$ImageXUploadListener$prepareUploadResult$1) == false) goto L7;
            ImageXUploaderImpl$ImageXUploadListener$prepareUploadResult$1 r100 = (ImageXUploaderImpl$ImageXUploadListener$prepareUploadResult$1) r112;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r113 = r100.result;
            Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r103 = r100.label;
            if (r103 == 0) goto L18;
            if (r103 != 1) goto L17;
            Ref.ObjectRef r114 = (Ref.ObjectRef) r100.L$3;
            ImageXUploaderImpl r104 = (ImageXUploaderImpl) r100.L$2;
            Ref.ObjectRef r105 = (Ref.ObjectRef) r100.L$1;
            BDImageXInfo r106 = (BDImageXInfo) r100.L$0;
            ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L14
            T r115 = r113;
        L23:
            r114.element = r115;     // Catch: Throwable -> L14
            FLogger.f375446a.i(r104.f375296a, "[prepareUploadResult] local image size, height:" + ((mr9.d) r105.element).f514991a + ", width:" + ((mr9.d) r105.element).f514992b);     // Catch: Throwable -> L14
            Object r116 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
        L29:
            ImageXUploaderImpl r117 = r110.f375303b;
            Throwable r118 = Result.m9452exceptionOrNullimpl(r116);
            if (r118 == null) goto L32;
            FLogger.f375446a.e(r117.f375296a, "[handleOnUploadSuccess] parse local image size failed, " + r118);
        L32:
            FLogger.f375446a.i(r110.f375303b.f375296a, "[handleOnUploadSuccess] success, uri:" + r106.mImageTosKey);
            return new l(r106.mImageTosKey, null, null, (mr9.d) r105.element, null, false, null, 118);
        L14:
            Throwable th10 = th;
            Ref.ObjectRef r119 = r105;
        L28:
            Result.Companion r107 = Result.Companion;
            r116 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
            r105 = r119;
            goto L29
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            ResultKt.throwOnFailure(r113);
            r119 = new Ref.ObjectRef();
            r119.element = new mr9.d(0, 0);
            ImageXUploaderImpl r108 = r110.f375303b;
            Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L26
            UploadImageMetaResolver r120 = UploadImageMetaResolver.f314744a;     // Catch: Throwable -> L26
            j r121 = r110.f375302a;     // Catch: Throwable -> L26
            r100.L$0 = r111;     // Catch: Throwable -> L26
            r100.L$1 = r119;     // Catch: Throwable -> L26
            r100.L$2 = r108;     // Catch: Throwable -> L26
            r100.L$3 = r119;     // Catch: Throwable -> L26
            r100.label = 1;     // Catch: Throwable -> L26
            Object r122 = r120.b(r121, r100);     // Catch: Throwable -> L26
            if (r122 == r102) goto L38;
            r104 = r108;
            r105 = r119;
            r115 = r122;
            r106 = r111;
            r114 = r105;
            goto L23
        L38:
            return r102;
        L26:
            th = move-exception;
            r106 = r111;
            th10 = th;
        L7:
            r100 = new ImageXUploaderImpl$ImageXUploadListener$prepareUploadResult$1(r110, r112);
            goto L8
        }

        @Override // com.ss.bduploader.BDImageXUploaderListener
        public final void onLog(int r100, int r101, String r102) {
            Job r103 = this.f375303b.f375300e;
            if (r103 == null) goto L5;
            Job.DefaultImpls.cancel$default(r103, null, 1, null);
        L5:
            ImageXUploaderImpl r104 = this.f375303b;
            r104.f375300e = null;
            FLogger.f375446a.i(r104.f375296a, "[onLog] what:" + r100 + ", code:" + r101 + ", info" + r102);
        }

        @Override // com.ss.bduploader.BDImageXUploaderListener
        public final void onNotify(int r110, long r111, BDImageXInfo r112) {
            Job r100 = this.f375303b.f375300e;
            boolean r101 = true;
            if (r100 == null) goto L5;
            Job.DefaultImpls.cancel$default(r100, null, 1, null);
        L5:
            ImageXUploaderImpl r102 = this.f375303b;
            r102.f375300e = null;
            FLogger r103 = FLogger.f375446a;
            r103.i(r102.f375296a, "[onNotify] what:" + r110 + ", parameter:" + r111);
            if (r110 == 124) goto L8;
        L12:
            BuildersKt.launch$default(this.f375303b.f375298c, Dispatchers.getMain(), null, new ImageXUploaderImpl$ImageXUploadListener$onNotify$1(r111, this.f375303b, r110, r112, this, null), 2, null);
            return;
        L8:
            if (r111 == 1) goto L11;
            r101 = false;
        L11:
            r103.i(this.f375303b.f375296a, "[preheat] resultUsed hit=" + r101);
            goto L12
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.larus.platform.api.b4
    public final void a() {
        FLogger r100 = FLogger.f375446a;
        r100.i(this.f375296a, "[doUpload] start");
        BDImageXUploader r101 = this.f375297b;
        if (r101 == null) goto L5;
        r101.setPreheatUploader(3);
    L5:
        BDImageXUploader r102 = this.f375297b;
        if (r102 == null) goto L9;
        r102.start();
    L9:
        if (this.f375301f.f365572a == false) goto L17;
        r100.i(this.f375296a, "[doUpload] enable timeout, sdkTimeout: " + this.f375301f.f365573b);
        Job r103 = this.f375300e;
        if (r103 == null) goto L13;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L13:
        this.f375300e = BuildersKt.launch$default(this.f375298c, null, null, new ImageXUploaderImpl$doUpload$1(this, null), 3, null);
        b4.a r104 = this.f375299d;
        if (r104 == null) goto L18;
        r104.b(new k(0L, false));
        return;
    L18:
        return;
    }

    public final void c() {
        FLogger.f375446a.i(this.f375296a, "[destroy]");
        Job r100 = this.f375300e;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f375300e = null;
        BDImageXUploader r101 = this.f375297b;
        if (r101 == null) goto L8;
        r101.close();
    L8:
        this.f375297b = null;
        this.f375299d = null;
    }

    public ImageXUploaderImpl(j r110) {
        Intrinsics.checkNotNullParameter(r110, "uploadParam");
        String r100 = "ImageXUploaderImpl_" + r110.f515010l;
        this.f375296a = r100;
        z2 r101 = z2.f365865a;
        com.larus.platform.model.chat.d r102 = r101.getBDImageXUploaderConfig();
        this.f375298c = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.f375301f = r101.getBDImageXUploadOptConfig();
        FLogger.f375446a.i(r100, "[createBDImageXUploader], params:" + r110);
        BDImageXUploader r103 = new BDImageXUploader();
        if (r110.f515005g == false) goto L5;
        r103.setMediaDataReader(new com.larus.uploader.impl.a(r110.getContext(), r110.f514999a), r110.f515007i);
    L6:
        c.a(r103, r110.f515006h);
        String r104 = r110.f515009k;
        if (r104 != null) goto L9;
    L11:
        MultimodalDowngradeData r105 = ChatInputService.f303327b.A6();
        Integer r106 = null;
        if (r105 == null) goto L21;
        Integer r107 = r105.getUploadRetryCount();
        if (r107 == null) goto L21;
        if (r107.intValue() < 0) goto L18;
        boolean r108 = true;
    L19:
        if (r108 == false) goto L21;
    L22:
        if (r105 == null) goto L31;
        Integer r109 = r105.getUploadRetryTimeout();
        if (r109 == null) goto L31;
        if (r109.intValue() < 0) goto L28;
        boolean r111 = true;
    L29:
        if (r111 == false) goto L31;
        r106 = r109;
        goto L31
    L28:
        r111 = false;
    L31:
        r103.setSocketNum(r102.h());
        r103.setSliceRetryCount(r102.g());
        if (r107 == null) goto L34;
        int r112 = r107.intValue();
    L35:
        r103.setFileRetryCount(r112);
        r103.setEnableCommitUpload(0);
        if (r106 == null) goto L38;
        int r113 = r106.intValue();
    L39:
        r103.setSDKMaxRetryTimeout(r113);
        int r114 = r102.a();
        int r115 = r102.b();
        int r116 = r102.d();
        int r117 = r102.c();
        if (r107 == null) goto L42;
        int r118 = 1;
    L43:
        r103.setCustomNetworkTimeoutParams(r114, r115, r116, r117, r118);
        if (ArraysKt.contains(new String[]{"html", "xml", "svg+xml"}, r110.f515009k) == false) goto L55;
        r103.setSpecifiedContentType(1, new String[]{"text/plain"});
    L55:
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L48
        int r120 = com.larus.uploader.impl.preheat.c.f375326a;     // Catch: Throwable -> L48
        r103.setServerParameter(com.larus.uploader.impl.preheat.c.a(AccountService.f365697a.getUserId()));     // Catch: Throwable -> L48
        Object r121 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L48
    L50:
        Throwable r122 = Result.m9452exceptionOrNullimpl(r121);
        if (r122 == null) goto L53;
        FLogger.f375446a.e(this.f375296a, "setServerParameter failed", r122);
    L53:
        r103.setOpenBoe(HttpExtKt.e().f360166a);
        this.f375297b = r103;
        r103.setListener(new ImageXUploadListener(this, r110));
        return;
    L48:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L50
    L42:
        r118 = 0;
        goto L43
    L38:
        r113 = r102.f();
        goto L39
    L34:
        r112 = r102.e();
        goto L35
    L18:
        r108 = false;
    L21:
        r107 = null;
        goto L22
    L9:
        if (o0.d(r104) == false) goto L11;
        r103.setFileExtension(".".concat(r104));
        goto L11
    L5:
        r103.setFilePath(r110.f515007i, new String[]{r110.f514999a});
        goto L6
    }

    @Override // com.larus.platform.api.b4
    public final void b(ResourceUploadEngine$upload$2$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f375299d = r100;
    }

    @Override // com.larus.platform.api.b4
    public final void cancel(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        FLogger.f375446a.i(this.f375296a, "[cancel]");
        Job r102 = this.f375300e;
        if (r102 == null) goto L5;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L5:
        this.f375300e = null;
        b4.a r103 = this.f375299d;
        if (r103 == null) goto L8;
        r103.a(new ResourceUploadError(ResourceUploadError.CANCELED, r100));
    L8:
        BDImageXUploader r104 = this.f375297b;
        if (r104 == null) goto L11;
        r104.cancelUpload();
    L11:
        if (r101 == false) goto L14;
        c();
        return;
    }
}
