package com.larus.dora.impl.feedback;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.upload.ResourceUploadTokenProvider;
import com.larus.bmhome.upload.sdk.ResourceUploadEngine$upload$2$1;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.b4;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.service.z2;
import com.larus.uploader.api.IUploaderService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bduploader.BDImageXInfo;
import com.ss.bduploader.BDImageXUploader;
import com.ss.bduploader.BDImageXUploaderListener;
import com.ss.bduploader.BDMediaDataReader;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class p0 implements b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f335659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BDImageXUploader f335660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b4.a f335661c;

    public static final class a {
    }

    public final class b implements BDImageXUploaderListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final mr9.j f335662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p0 f335663b;

        public b(p0 r100, mr9.j r101) {
            Intrinsics.checkNotNullParameter(r101, "param");
            this.f335663b = r100;
            this.f335662a = r101;
        }

        @Override // com.ss.bduploader.BDImageXUploaderListener
        public final int imageXUploadCheckNetState(int r100, int r101) {
            return NetworkUtils.isNetworkAvailable(AppHost.f326268a.getApplication()) ? 1 : 0;
        }

        @Override // com.ss.bduploader.BDImageXUploaderListener
        public final void onLog(int r100, int r101, String r102) {
            FLogger.f375446a.i(this.f335663b.f335659a, "[onLog] what:" + r100 + ", code:" + r101 + ", info" + r102);
        }

        @Override // com.ss.bduploader.BDImageXUploaderListener
        public final void onNotify(int r210, long r211, BDImageXInfo r212) {
            FLogger r100 = FLogger.f375446a;
            r100.i(this.f335663b.f335659a, "[onNotify] what:" + r210 + ", parameter:" + r211);
            int r101 = 0;
            if (r211 == 0) goto L8;
            b4.a r102 = this.f335663b.f335661c;
            if (r102 == null) goto L8;
            r102.b(new mr9.k(Long.valueOf(r211), false));
        L8:
            if (r210 != 2) goto L10;
        L37:
            ResourceUploadTokenProvider r103 = ResourceUploadTokenProvider.f314735a;
            String r104 = null;
            if (r212 == null) goto L40;
            Long r105 = Long.valueOf(r212.mErrorCode);
        L41:
            r103.getClass();
            if (ResourceUploadTokenProvider.c(r105) == false) goto L44;
            ResourceUploadTokenProvider.b(this.f335662a);
        L44:
            StringBuilder r106 = new StringBuilder("upload failed, what:");
            r106.append(r210);
            r106.append(", error code(");
            if (r212 == null) goto L47;
            Long r107 = Long.valueOf(r212.mErrorCode);
        L48:
            r106.append(r107);
            r106.append("), error msg(");
            if (r212 == null) goto L51;
            r104 = r212.mErrorMsg;
        L51:
            r106.append(r104);
            r106.append(')');
            String r108 = r106.toString();
            r100.e("ImageXUploaderImpl", "[handleOnUploadFailed] " + r108);
            b4.a r109 = this.f335663b.f335661c;
            if (r109 == null) goto L65;
            r109.a(new ResourceUploadError(ResourceUploadError.UPLOAD_ERROR, r108));
            return;
        L65:
            return;
        L47:
            r107 = null;
            goto L48
        L40:
            r105 = null;
            goto L41
        L10:
            if (r210 != 3) goto L12;
            b4.a r110 = this.f335663b.f335661c;
            if (r110 == null) goto L63;
            r110.a(new ResourceUploadError(ResourceUploadError.UPLOAD_ERROR, "upload canceled"));
            return;
        L63:
            return;
        L12:
            if (r210 != 6) goto L14;
            if (r212 != null) goto L55;
            b4.a r111 = this.f335663b.f335661c;
            if (r111 == null) goto L61;
            r111.a(new ResourceUploadError(ResourceUploadError.UPLOAD_ERROR, "upload response tos key is null"));
            return;
        L61:
            return;
        L55:
            Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L22
            JSONObject r113 = new JSONObject(r212.mMetaInfo);     // Catch: Throwable -> L22
            int r114 = r113.optInt("ImageHeight");     // Catch: Throwable -> L22
            r101 = r113.optInt(ExifInterface.TAG_IMAGE_WIDTH);     // Catch: Throwable -> L20
            Object r115 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
        L25:
            p0 r116 = this.f335663b;
            Throwable r117 = Result.m9452exceptionOrNullimpl(r115);
            if (r117 == null) goto L28;
            FLogger r118 = FLogger.f375446a;
            r118.e(r116.f335659a, "[handleOnUploadSuccess] parse mMetaInfo failed, " + r117);
            r118.e(r116.f335659a, "[handleOnUploadSuccess] mMetaInfo:" + r212.mMetaInfo);
        L28:
            FLogger.f375446a.i(this.f335663b.f335659a, "[handleOnUploadSuccess] success, uri:" + r212.mImageTosKey);
            b4.a r119 = this.f335663b.f335661c;
            if (r119 == null) goto L59;
            r119.c(new mr9.l(r212.mImageTosKey, null, null, new mr9.d(r114, r101), null, false, null, 118));
            return;
        L59:
            return;
        L20:
            th = th;
            int r120 = r101;
            r101 = r114;
            int r121 = r120;
        L24:
            Result.Companion r122 = Result.Companion;
            r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            int r123 = r101;
            r101 = r121;
            r114 = r123;
        L22:
            th = th;
            r121 = 0;
            goto L24
        L14:
            if (r210 == 7) goto L37;
        }
    }

    static {
    }

    @Override // com.larus.platform.api.b4
    public final void a() {
        FLogger.f375446a.i(this.f335659a, "[doUpload] start");
        BDImageXUploader r100 = this.f335660b;
        if (r100 == null) goto L6;
        r100.start();
        return;
    }

    public p0(mr9.j r110) {
        Intrinsics.checkNotNullParameter(r110, "uploadParam");
        String r100 = "ImageXUploaderImpl_" + r110.f515010l;
        this.f335659a = r100;
        com.larus.platform.model.chat.d r101 = z2.f365865a.getBDImageXUploaderConfig();
        FLogger.f375446a.i(r100, "[createBDImageXUploader], params:" + r110);
        BDImageXUploader r102 = new BDImageXUploader();
        String r103 = null;
        if (r110.f515005g == false) goto L13;
        IUploaderService r104 = (IUploaderService) ServiceManager.get().getService(IUploaderService.class);
        if (r104 == null) goto L7;
        com.larus.uploader.impl.a r105 = r104.c(r110.getContext(), r110.f514999a);
    L9:
        if ((r105 instanceof BDMediaDataReader) == true) goto L12;
        r105 = null;
    L12:
        r102.setMediaDataReader(r105, r110.f515007i);
    L14:
        mr9.m r106 = r110.f515006h;
        if (r106 == null) goto L28;
        r102.setFilePrefix(r106.d());
        r102.setUploadDomain(r106.c());
        mr9.b r107 = r106.a();
        if (r107 == null) goto L19;
        String r108 = r107.a();
    L20:
        r102.setTopAccessKey(r108);
        mr9.b r109 = r106.a();
        if (r109 == null) goto L23;
        String r111 = r109.c();
    L24:
        r102.setTopSecretKey(r111);
        mr9.b r112 = r106.a();
        if (r112 == null) goto L27;
        r103 = r112.d();
    L27:
        r102.setTopSessionToken(r103);
        r102.setServiceID(r106.b());
        goto L28
    L23:
        r111 = null;
        goto L24
    L19:
        r108 = null;
    L28:
        String r113 = r110.f515009k;
        if (r113 != null) goto L31;
    L33:
        r102.setSocketNum(r101.h());
        r102.setSliceRetryCount(r101.g());
        r102.setFileRetryCount(r101.e());
        r102.setSDKMaxRetryTimeout(20);
        r102.setCustomNetworkTimeoutParams(10, 10, 15, 15, 0);
        if (ArraysKt.contains(new String[]{"html", "xml", "svg+xml"}, r110.f515009k) == false) goto L36;
        r102.setSpecifiedContentType(1, new String[]{"text/plain"});
    L36:
        r102.setOpenBoe(HttpExtKt.e().f360166a);
        this.f335660b = r102;
        r102.setListener(new b(this, r110));
        return;
    L31:
        if (com.larus.utils.o0.d(r113) == false) goto L33;
        r102.setFileExtension(".".concat(r113));
        goto L33
    L7:
        r105 = null;
        goto L9
    L13:
        r102.setFilePath(r110.f515007i, new String[]{r110.f514999a});
        goto L14
    }

    @Override // com.larus.platform.api.b4
    public final void b(ResourceUploadEngine$upload$2$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f335661c = r100;
    }

    @Override // com.larus.platform.api.b4
    public final void cancel(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        FLogger.f375446a.i(this.f335659a, "[cancel]");
        BDImageXUploader r102 = this.f335660b;
        if (r102 == null) goto L5;
        r102.cancelUpload();
    L5:
        this.f335661c = null;
    }
}
