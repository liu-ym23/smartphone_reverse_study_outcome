package com.larus.uploader.impl;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.bmhome.upload.ResourceUploadTokenProvider;
import com.larus.bmhome.upload.h;
import com.larus.bmhome.upload.l;
import com.larus.bmhome.upload.sdk.ResourceUploadEngine$upload$2$1;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.b4;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.service.o3;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.p0;
import com.ss.bduploader.BDVideoInfo;
import com.ss.bduploader.BDVideoUploader;
import com.ss.bduploader.BDVideoUploaderListener;
import com.ss.ttvideoengine.model.BarrageMaskInfo;
import com.tencent.connect.share.QzonePublish;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mr9.j;
import mr9.k;
import mr9.m;
import mr9.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class g implements b4 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final com.larus.platform.model.chat.e f375313i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f375314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f375315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BDVideoUploader f375316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b4.a f375317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f375318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long[] f375319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long[] f375320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f375321h;

    public static final class a {
    }

    public final class b implements BDVideoUploaderListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f375322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f375323b;

        @Override // com.ss.bduploader.BDVideoUploaderListener
        public final String getStringFromExtern(int r100) {
            return null;
        }

        @Override // com.ss.bduploader.BDVideoUploaderListener
        public final int videoUploadCheckNetState(int r100, int r101) {
            return 1;
        }

        public b(g r100, j r101) {
            Intrinsics.checkNotNullParameter(r101, "param");
            this.f375323b = r100;
            this.f375322a = r101;
        }

        @Override // com.ss.bduploader.BDVideoUploaderListener
        public final void onUploadVideoStage(int r100, long r101) {
            FLogger.f375446a.i(this.f375323b.f375315b, "[onUploadVideoStage] what:" + r100 + ", p1:" + r101);
        }

        @Override // com.ss.bduploader.BDVideoUploaderListener
        public final void onLog(int r100, int r101, String r102) {
            FLogger.f375446a.d(this.f375323b.f375315b, "[onLog] what:" + r100 + ", code:" + r101 + ", info:" + r102);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v1, types: [T, mr9.e] */
        @Override // com.ss.bduploader.BDVideoUploaderListener
        public final void onNotify(int r310, long r311, BDVideoInfo r312) {
            FLogger r100 = FLogger.f375446a;
            r100.i(this.f375323b.f375315b, "[onNotify] what: " + r310 + ", parameter: " + r311);
            if (r311 == 0) goto L10;
            long r101 = (long) ((r311 * 0.7f) + 30.000002f);
            g r102 = this.f375323b;
            if (r101 == r102.f375321h) goto L10;
            r100.i(r102.f375315b, "[onNotify] upload progress: " + r311 + ", mapped: " + r101);
            g r103 = this.f375323b;
            r103.f375321h = r101;
            b4.a r104 = r103.f375317d;
            if (r104 == null) goto L10;
            r104.b(new k(Long.valueOf(r101), false));
        L10:
            if (r310 != 0) goto L12;
            if (r312 == null) goto L93;
            this.f375323b.f375320g[1] = System.currentTimeMillis();
            g r105 = this.f375323b;
            long[] r106 = r105.f375320g;
            long r107 = r106[1] - r106[0];
            r100.i(r105.f375315b, "[handleUploadSuccess] cost:" + r107 + "ms, uri:" + r312.mTosKey);
            m r108 = this.f375322a.f515006h;
            if (r108 == null) goto L46;
            String r109 = r108.b();
        L48:
            if (r109 != null) goto L50;
            String r110 = "";
        L51:
            b4.a r111 = this.f375323b.f375317d;
            if (r111 == null) goto L91;
            String r112 = "vod://" + r110 + '/' + r312.mVideoId;
            String r113 = r312.mVideoId;
            if (r113 != null) goto L56;
            String r114 = "";
        L57:
            Ref.ObjectRef r115 = new Ref.ObjectRef();
            h r116 = h.f314760a;
            String r117 = this.f375322a.f515010l;
            if (r117 != null) goto L60;
            r117 = "";
        L60:
            r115.element = r116.query(r117);
            g r118 = this.f375323b;
            Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L77
            JSONObject r120 = new JSONObject(r312.mVideoMediaInfo);     // Catch: Throwable -> L77
            r100.d(r118.f375315b, "[onNotify] metaObj:" + r120);     // Catch: Throwable -> L77
            mr9.e r121 = (mr9.e) r115.element;     // Catch: Throwable -> L77
            if (r121 == null) goto L79;
            int r122 = JSONObjectProtectorUtils.getInt(r120, BarrageMaskInfo.KEY_VER4_MASK_BITRATE);     // Catch: Throwable -> L77
            int r123 = p0.f375454a;     // Catch: Throwable -> L77
            String r124 = p0.a(l.a(JSONObjectProtectorUtils.getString(r120, "Codec")));     // Catch: Throwable -> L77
            if (r124 != null) goto L69;
            mr9.e r125 = (mr9.e) r115.element;     // Catch: Throwable -> L77
            if (r125 == null) goto L68;
            r124 = r125.c();     // Catch: Throwable -> L77
            goto L69
        L68:
            String r210 = null;
        L70:
            long r126 = (long) (1000 * JSONObjectProtectorUtils.getDouble(r120, "Duration"));     // Catch: Throwable -> L77
            long r127 = JSONObjectProtectorUtils.getLong(r120, "Size");     // Catch: Throwable -> L77
            int r128 = JSONObjectProtectorUtils.getInt(r120, "Width");     // Catch: Throwable -> L77
            int r129 = JSONObjectProtectorUtils.getInt(r120, "Height");     // Catch: Throwable -> L77
            mr9.e r130 = mr9.e.a(r121, Long.valueOf(r126), null, Long.valueOf(r127), JSONObjectProtectorUtils.getString(r120, "Format"), r210, Integer.valueOf(r129), Integer.valueOf(r128), Integer.valueOf(r122), 15371);     // Catch: Throwable -> L77
            T r131 = r130;
            if (o0.d(this.f375322a.f515010l) == false) goto L80;
            String r132 = this.f375322a.f515010l;     // Catch: Throwable -> L77
            if (r132 != null) goto L75;
            String r133 = "";
        L76:
            h.a(r133, r130, "BDVideoUploader#parseVideoMeta");     // Catch: Throwable -> L77
            r131 = r130;
            goto L80
        L75:
            r133 = r132;
        L80:
            r115.element = r131;     // Catch: Throwable -> L77
            Object r134 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L77
        L83:
            g r135 = this.f375323b;
            if (Result.m9452exceptionOrNullimpl(r134) == null) goto L86;
            FLogger.f375446a.e(r135.f375315b, "[parseVideoMeta] failed, error(" + r312.mErrorCode + ", " + r312.mTosKey + ')');
        L86:
            mr9.e r136 = (mr9.e) r115.element;
            if (r136 != null) goto L89;
            r136 = new mr9.e(null, null, null, null, null, null, null, null, null, null, null, null, 16383);
        L89:
            r111.c(new mr9.l(r112, null, null, null, new n(r114, r110, r136), false, null, 110));
        L69:
            r210 = r124;
            goto L70
        L79:
            r131 = 0;
        L77:
            th = move-exception;
            Result.Companion r137 = Result.Companion;
            r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L83
        L56:
            r114 = r113;
        L91:
            if (this.f375323b.f375318e == false) goto L96;
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new VideoUploaderImpl$VideoUploadListener$handleUploadSuccess$1(this, null), 3, null);
        L96:
            this.f375323b.c();
            return;
        L50:
            r110 = r109;
            goto L51
        L46:
            r109 = null;
            goto L48
        L93:
            b4.a r138 = this.f375323b.f375317d;
            if (r138 == null) goto L96;
            r138.a(new ResourceUploadError(ResourceUploadError.UPLOAD_ERROR, "upload response BDVideoInfo is null"));
            goto L96
        L12:
            if (r310 != 2) goto L14;
            StringBuilder r139 = new StringBuilder("upload failed, what:");
            r139.append(r310);
            r139.append(", error code(");
            if (r312 == null) goto L23;
            Long r140 = Long.valueOf(r312.mErrorCode);
        L24:
            r139.append(r140);
            r139.append("), error msg(");
            if (r312 == null) goto L27;
            String r141 = r312.mErrorMsg;
        L28:
            r139.append(r141);
            r139.append(')');
            String r142 = r139.toString();
            r100.e(this.f375323b.f375315b, "[handleOnUploadFailed] " + r142);
            ResourceUploadTokenProvider r143 = ResourceUploadTokenProvider.f314735a;
            if (r312 == null) goto L31;
            Long r144 = Long.valueOf(r312.mErrorCode);
        L32:
            r143.getClass();
            if (ResourceUploadTokenProvider.c(r144) == false) goto L35;
            ResourceUploadTokenProvider.b(this.f375322a);
        L35:
            b4.a r145 = this.f375323b.f375317d;
            if (r145 == null) goto L38;
            r145.a(new ResourceUploadError(ResourceUploadError.UPLOAD_ERROR, r142));
        L38:
            BDVideoUploader r146 = this.f375323b.f375316c;
            if (r146 == null) goto L41;
            r146.close();
        L41:
            this.f375323b.c();
            return;
        L31:
            r144 = null;
            goto L32
        L27:
            r141 = null;
            goto L28
        L23:
            r140 = null;
            goto L24
        L14:
            if (r310 != 3) goto L102;
            b4.a r147 = this.f375323b.f375317d;
            if (r147 == null) goto L19;
            r147.a(new ResourceUploadError(ResourceUploadError.UPLOAD_ERROR, "upload canceled"));
        L19:
            this.f375323b.c();
            return;
        }
    }

    static {
        f375313i = z2.f365865a.getBDVideoUploaderConfig();
    }

    /* JADX WARN: Type inference failed for: r3v9, types: [com.larus.uploader.impl.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v21, types: [com.larus.uploader.impl.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.larus.uploader.impl.f, java.lang.Object] */
    @Override // com.larus.platform.api.b4
    public final void a() {
        com.larus.bmhome.upload.j.f314779a.getClass();
        if (com.larus.bmhome.upload.j.a().a() == false) goto L122;
        FLogger r100 = FLogger.f375446a;
        r100.i(this.f375315b, "[uploadAfterTranscoding] start");
        this.f375319f[0] = System.currentTimeMillis();
        h r101 = h.f314760a;
        String r102 = this.f375314a.f515010l;
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        mr9.e r103 = r101.query(r102);
        if (r103 == null) goto L121;
        String r104 = this.f375314a.f515010l;
        if (r104 != null) goto L12;
    L15:
        boolean r105 = true;
    L16:
        if (r105 == true) goto L121;
        Intrinsics.checkNotNullParameter(r103, "videoMeta");
        Integer r106 = r103.j();
        if (r106 == null) goto L42;
        int r107 = RangesKt.coerceAtLeast(r106.intValue(), 1);
        Integer r108 = r103.h();
        if (r108 == null) goto L41;
        int r109 = RangesKt.coerceAtLeast(r108.intValue(), 1);
        Integer r110 = com.larus.bmhome.upload.j.a().e();
        if (r110 == null) goto L25;
        int r111 = r110.intValue();
    L26:
        Integer r112 = com.larus.bmhome.upload.j.a().g();
        if (r112 == null) goto L29;
        int r113 = r112.intValue();
    L30:
        float r114 = r107 / r109;
        if (r114 <= 0.0f) goto L37;
        if (r114 > 1.0f) goto L37;
        if (r107 <= r113) goto L37;
        com.larus.bmhome.upload.j.a r115 = new com.larus.bmhome.upload.j.a(Integer.valueOf(r113), Integer.valueOf((int) (r113 / r114)));
    L44:
        Integer r116 = r115.f314781a;
        Integer r117 = r115.f314782b;
        Integer r118 = com.larus.bmhome.upload.j.a().d();
        if (r118 == null) goto L51;
        int r119 = r118.intValue();
        Float r120 = r103.g();
        if (r120 == null) goto L51;
        if (((int) r120.floatValue()) <= r119) goto L51;
        Integer r121 = Integer.valueOf(r119);
    L52:
        Integer r122 = r103.b();
        if (r122 == null) goto L59;
        int r123 = r122.intValue();
        Long r124 = com.larus.bmhome.upload.j.a().b();
        if (r124 == null) goto L59;
        long r125 = r124.longValue();
        if (r123 <= r125) goto L59;
        Long r126 = Long.valueOf(r125);
    L60:
        String r127 = r103.f();
        if (r127 == null) goto L65;
        String r128 = StringsKt.substringAfterLast$default(r127, '/', null, 2, null);
        if (r128 == null) goto L65;
        String r129 = r128.toLowerCase(Locale.getDefault());
    L66:
        if (r129 != null) goto L69;
        r129 = "";
    L69:
        if (r129.length() <= 0) goto L71;
        boolean r130 = true;
    L72:
        if (r130 == true) goto L74;
    L76:
        String r131 = null;
    L77:
        pq9.l r132 = new pq9.l(r116, r117, r121, r126, null, r131);
        if (pq9.m.a(r132) == false) goto L80;
        r100.i("VideoTranscodeHelper", "[buildVideoTranscodeParam] all empty, ignore codec");
    L96:
        final pq9.l r133 = r132;
        if (pq9.m.a(r133) == false) goto L99;
        r100.i("VideoUploaderImpl", "[uploadAfterTranscoding] no need to transcode");
        this.f375320g[0] = System.currentTimeMillis();
        d();
        return;
    L99:
        j r134 = this.f375314a;
        String r135 = r134.f515010l;
        if (r135 != null) goto L102;
        String r136 = "";
    L103:
        String r137 = r134.f514999a;
        ?? r138 = new d(this);
        ?? r139 = new e(this, r133);
        ?? r140 = new f(this);
        Intrinsics.checkNotNullParameter(r136, LocationMonitorConst.IDENTIFIER);
        Intrinsics.checkNotNullParameter(r137, QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
        Intrinsics.checkNotNullParameter(r133, "transcodeParam");
        Intrinsics.checkNotNullParameter(r138, "onProgress");
        Intrinsics.checkNotNullParameter(r139, "onComplete");
        Intrinsics.checkNotNullParameter(r140, LynxVideoManagerLite.EVENT_ON_ERROR);
        r100.i("VideoTranscodeHelper", "[tryTranscodeVideo] identifier:".concat(r136));
        int r141 = r137.length() - 1;
        if (r141 < 0) goto L114;
    L105:
        int r142 = r141 - 1;
        if (r137.charAt(r141) != '.') goto L108;
        boolean r143 = true;
    L109:
        if (r143 == true) goto L115;
        if (r142 < 0) goto L114;
        r141 = r142;
    L115:
        if (r141 == (-1)) goto L117;
        String r144 = r137.substring(0, r141) + "_formatted" + r137.substring(r141);
    L119:
        if (o3.f365784b.j(r136, r137, r144, r133, new com.larus.bmhome.upload.k(r140, r139, r144, r138)) == true) goto L127;
        r140.invoke("transcodeVideo exec failed");
        return;
    L127:
        return;
    L117:
        r144 = r137;
        goto L119
    L108:
        r143 = false;
    L114:
        r141 = -1;
        goto L115
    L102:
        r136 = r135;
        goto L103
    L80:
        String r145 = r103.c();
        if (r145 == null) goto L83;
        String r146 = r145.toLowerCase(Locale.getDefault());
    L85:
        if (o0.d(r146) == true) goto L87;
    L89:
        String r147 = null;
    L90:
        r132 = pq9.l.a(r132, null, null, r147, 47);
        if (r132.f530300a != null) goto L94;
        r132 = pq9.l.a(r132, r103.j(), null, null, 62);
    L94:
        if (r132.f530301b != null) goto L96;
        r132 = pq9.l.a(r132, null, r103.h(), null, 61);
        goto L96
    L87:
        if (Intrinsics.areEqual(r146, com.larus.bmhome.upload.j.a().c()) == true) goto L89;
        r147 = com.larus.bmhome.upload.j.a().c();
        goto L90
    L83:
        r146 = null;
        goto L85
    L74:
        if (Intrinsics.areEqual(r129, com.larus.bmhome.upload.j.a().f()) == true) goto L76;
        r131 = com.larus.bmhome.upload.j.a().f();
        goto L77
    L71:
        r130 = false;
    L65:
        r129 = null;
    L59:
        r126 = null;
    L51:
        r121 = null;
    L37:
        if (r114 <= 1.0f) goto L40;
        if (r109 <= r111) goto L40;
        r115 = new com.larus.bmhome.upload.j.a(Integer.valueOf((int) (r111 * r114)), Integer.valueOf(r111));
    L40:
        com.larus.bmhome.upload.j.a r148 = new com.larus.bmhome.upload.j.a(null, null);
    L43:
        r115 = r148;
        goto L44
    L29:
        r113 = r107;
        goto L30
    L25:
        r111 = r109;
        goto L26
    L41:
        r148 = new com.larus.bmhome.upload.j.a(null, null);
        goto L43
    L42:
        r148 = new com.larus.bmhome.upload.j.a(null, null);
        goto L43
    L12:
        if (r104.length() == 0) goto L15;
        r105 = false;
    L121:
        this.f375314a.f515004f.invoke(new ResourceUploadError(ResourceUploadError.UPLOAD_ERROR, "videoMeta is null"));
        return;
    L122:
        this.f375320g[0] = System.currentTimeMillis();
        d();
    }

    public final void c() {
        FLogger.f375446a.i(this.f375315b, "[cancel]");
        BDVideoUploader r100 = this.f375316c;
        if (r100 == null) goto L5;
        r100.close();
    L5:
        this.f375316c = null;
        this.f375317d = null;
    }

    public final void d() {
        FLogger r100 = FLogger.f375446a;
        r100.i(this.f375315b, "[uploadToServer] start");
        j r101 = this.f375314a;
        r100.i(this.f375315b, "[createBDVideoUploader], params:" + r101);
        BDVideoUploader r102 = new BDVideoUploader();
        if (r101.f515005g == false) goto L5;
        r102.setMediaDataReader(new com.larus.uploader.impl.a(r101.getContext(), r101.f514999a));
    L6:
        m r103 = r101.f515006h;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        if (r103 == null) goto L20;
        r102.setUploadDomain(r103.c());
        mr9.b r104 = r103.a();
        String r105 = null;
        if (r104 == null) goto L11;
        String r106 = r104.a();
    L12:
        r102.setTopAccessKey(r106);
        mr9.b r107 = r103.a();
        if (r107 == null) goto L15;
        String r108 = r107.c();
    L16:
        r102.setTopSecretKey(r108);
        mr9.b r109 = r103.a();
        if (r109 == null) goto L19;
        r105 = r109.d();
    L19:
        r102.setTopSessionToken(r105);
        r102.setSpaceName(r103.b());
        goto L20
    L15:
        r108 = null;
        goto L16
    L11:
        r106 = null;
    L20:
        com.larus.platform.model.chat.e r110 = f375313i;
        r102.setSocketNum(r110.h());
        r102.setSliceReTryCount(r110.g());
        r102.setFileRetryCount(r110.e());
        r102.setSDKMaxRetryTimeout(r110.f());
        r102.setCustomNetworkTimeoutParams(r110.a(), r110.b(), r110.d(), r110.c(), 0);
        r102.setOpenBoe(HttpExtKt.e().f360166a);
        this.f375316c = r102;
        r102.setListener(new b(this, r101));
        BDVideoUploader r111 = this.f375316c;
        if (r111 == null) goto L24;
        r111.start();
        return;
    L24:
        return;
    L5:
        r102.setPathName(r101.f514999a);
        goto L6
    }

    public g(j r100) {
        Intrinsics.checkNotNullParameter(r100, "uploadParam");
        this.f375314a = r100;
        this.f375315b = "VideoUploaderImpl_" + this.f375314a.f515010l;
        this.f375319f = new long[2];
        this.f375320g = new long[2];
        this.f375321h = -1;
    }

    @Override // com.larus.platform.api.b4
    public final void b(ResourceUploadEngine$upload$2$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f375317d = r100;
    }

    @Override // com.larus.platform.api.b4
    public final void cancel(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        FLogger r102 = FLogger.f375446a;
        r102.i(this.f375315b, "[cancel]");
        com.larus.bmhome.upload.j r103 = com.larus.bmhome.upload.j.f314779a;
        String r104 = this.f375314a.f515010l;
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, LocationMonitorConst.IDENTIFIER);
        r102.i("VideoTranscodeHelper", "[cancelTranscoding] identifier:".concat(r104));
        o3.f365784b.b(r104);
        b4.a r105 = this.f375317d;
        if (r105 == null) goto L8;
        r105.a(new ResourceUploadError(ResourceUploadError.CANCELED, r100));
    L8:
        BDVideoUploader r106 = this.f375316c;
        if (r106 == null) goto L11;
        r106.cancelUpload();
    L11:
        if (r101 == false) goto L14;
        c();
        return;
    }
}
