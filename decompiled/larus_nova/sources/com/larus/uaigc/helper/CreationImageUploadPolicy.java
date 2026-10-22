package com.larus.uaigc.helper;

import android.app.Application;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common.apphost.AppHost;
import com.larus.network.NetConnectionTypeProvider;
import com.larus.platform.model.upload.ImageInstantUploadPolicyFamily;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.platform.spi.IAIChatUploadMediaService;
import com.larus.uaigc.createpage.utils.BitmapHelperKt;
import com.larus.utils.logger.FLogger;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.videosend.tools.VideoTools;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import hq9.i4;
import hq9.s1;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes31.dex */
public final class CreationImageUploadPolicy implements com.larus.uaigc.utils.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CreationImageUploadPolicy f372948a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f372949b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f372950c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f372951d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f372952e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f372953f = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap.CompressFormat f372954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f372955b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f372954a == r101.f372954a) goto L12;
            return false;
        L12:
            if (this.f372955b == r101.f372955b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f372954a.hashCode() * 31) + this.f372955b;
        }

        public final String toString() {
            return "EffectiveCompressParams(effectiveFormat=" + this.f372954a + ", effectiveQuality=" + this.f372955b + ')';
        }

        public a(Bitmap.CompressFormat r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "effectiveFormat");
            this.f372954a = r100;
            this.f372955b = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ic8.n0 f372956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f372957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f372958c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f372956a, r101.f372956a) == true) goto L12;
            return false;
        L12:
            if (this.f372957b == r101.f372957b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f372958c, r101.f372958c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            ic8.n0 r100 = this.f372956a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            long r102 = this.f372957b;
            return (((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f372958c.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReusablePreprocessResult(cachedProcessFileResult=" + this.f372956a + ", sourceFileSize=" + this.f372957b + ", sourceMd5=" + this.f372958c + ')';
        }

        public b(ic8.n0 r100, long r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "sourceMd5");
            this.f372956a = r100;
            this.f372957b = r101;
            this.f372958c = r102;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f372959a = null;

        static {
            int[] r100 = new int[ProcessFileResultCode.values().length];
            r100[ProcessFileResultCode.PREPARE_OPEN_FILE_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ProcessFileResultCode.PREPARE_GIF_PROCESS_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ProcessFileResultCode.PREPARE_TYPE_NO_MATCH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ProcessFileResultCode.PREPARE_CLONE_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f372959a = r100;
        }
    }

    public static final class d extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public d(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            FLogger.f375446a.e(CreationImageUploadPolicy.f372949b, "err! msg=" + r101);
        }
    }

    public CreationImageUploadPolicy() {
    }

    static {
        f372948a = new CreationImageUploadPolicy();
        f372949b = "CreationImageUploadPolicy";
        f372950c = LazyKt.lazy(new r());
        f372951d = LazyKt.lazy(new s());
        f372952e = new d(CoroutineExceptionHandler.Key);
        f372953f = LazyKt.lazy(new t());
    }

    public static s1 d() {
        return (s1) f372950c.getValue();
    }

    public static Bitmap.CompressFormat f(String r100) {
        switch(r100.hashCode()) {
            case -1638728877: goto L21;
            case 105441: goto L17;
            case 111145: goto L13;
            case 1520992383: goto L6;
            default: goto L27;
        };
    L27:
        return null;
    L6:
        if (r100.equals("webp_lossless") == false) goto L27;
        if (Build.VERSION.SDK_INT < 30) goto L30;
        return Bitmap.CompressFormat.WEBP_LOSSLESS;
    L30:
        return Bitmap.CompressFormat.WEBP;
    L13:
        if (r100.equals(LoadParams.ImageFormat.PNG) == false) goto L27;
        return Bitmap.CompressFormat.PNG;
    L17:
        if (r100.equals("jpg") == false) goto L27;
        return Bitmap.CompressFormat.JPEG;
    L21:
        if (r100.equals("webp_lossy") == false) goto L27;
        if (Build.VERSION.SDK_INT < 30) goto L34;
        return Bitmap.CompressFormat.WEBP_LOSSY;
    L34:
        return Bitmap.CompressFormat.WEBP;
    }

    public static ParcelFileDescriptor b(ContentResolver r210, Uri r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, "r"};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r111[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r111;
        f06.d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r210, r101, "android.os.ParcelFileDescriptor", r110);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r210, r211, "r");
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r111 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static void g(ic8.n0 r110, ns8.a r111) {
        ic8.m0 r100 = r110.f489243a;
        if (r100 == null) goto L145;
        mr9.c r101 = r100.f489234l;
        if (r101 != null) goto L133;
        int r102 = g.f373020a;
        ProcessFileResultCode r103 = r110.f489244b;
        if (r103 != null) goto L9;
        int r104 = -1;
    L10:
        String r112 = LoadParams.ImageFormat.JPEG;
        if (r104 == 1) goto L53;
        if (r104 == 2) goto L39;
        if (r104 == 3) goto L38;
        if (r104 == 4) goto L38;
        if (r104 != 5) goto L37;
        String r105 = r100.f489223a;
        if (r105 != null) goto L20;
    L34:
        boolean r106 = true;
    L35:
        if (r106 == false) goto L37;
        Map r107 = g.a(r103);
    L130:
        if (r107 != null) goto L132;
        r101 = null;
        goto L133
    L132:
        r101 = new mr9.c(ImageInstantUploadPolicyFamily.IMAGE_CREATION, 1, r107);
        goto L133
    L20:
        if ((!StringsKt.isBlank(r105)) == true) goto L23;
        r105 = null;
    L23:
        if (r105 == null) goto L34;
        String r108 = r100.f489227e;
        if (r108 == null) goto L34;
        if ((!StringsKt.isBlank(r108)) == true) goto L31;
        r108 = null;
    L31:
        if (r108 == null) goto L34;
        r106 = Intrinsics.areEqual(r105, r108);
    L37:
        r107 = null;
    L38:
        r107 = g.a(r103);
        goto L130
    L39:
        Pair[] r109 = new Pair[5];
        r109[0] = TuplesKt.to("data_type", UploadDataType.IMAGE.getType());
        r109[1] = TuplesKt.to("transform", "gif_first_frame");
        r109[2] = TuplesKt.to("output_format", LoadParams.ImageFormat.JPEG);
        r109[3] = TuplesKt.to(GearStrategyConsts.EV_QUALITY, "100");
        if (r103 == null) goto L42;
        String r113 = r103.getValue();
    L43:
        r109[4] = TuplesKt.to("result_code", r113);
        LinkedHashMap r114 = MapsKt.linkedMapOf(r109);
        LinkedHashMap r115 = new LinkedHashMap();
        Iterator r116 = r114.entrySet().iterator();
    L45:
        if (r116.hasNext() == false) goto L52;
        Map.Entry r117 = (Map.Entry) r116.next();
        if (((String) r117.getValue()) == null) goto L49;
        boolean r118 = true;
    L50:
        if (r118 == false) goto L45;
        r115.put(r117.getKey(), r117.getValue());
        goto L45
    L49:
        r118 = false;
    L52:
        r107 = r115;
        goto L130
    L42:
        r113 = null;
        goto L43
    L53:
        if (r111 == null) goto L57;
        Integer r119 = r111.f520345c;
        if (r119 == null) goto L57;
        int r120 = r119.intValue();
    L58:
        Pair[] r121 = new Pair[11];
        r121[0] = TuplesKt.to("data_type", UploadDataType.IMAGE.getType());
        r121[1] = TuplesKt.to("transform", VideoTools.ERROR_TYPE_COMPRESS);
        if (r103 == null) goto L61;
        String r122 = r103.getValue();
    L62:
        r121[2] = TuplesKt.to("result_code", r122);
        if (r111 == null) goto L67;
        Integer r123 = r111.f520343a;
        if (r123 == null) goto L67;
        String r124 = r123.toString();
    L68:
        r121[3] = TuplesKt.to("opt_short_size", r124);
        if (r111 == null) goto L73;
        Integer r125 = r111.f520344b;
        if (r125 == null) goto L73;
        String r126 = r125.toString();
    L74:
        r121[4] = TuplesKt.to("opt_long_size", r126);
        r121[5] = TuplesKt.to(GearStrategyConsts.EV_QUALITY, String.valueOf(r120));
        if (r111 == null) goto L77;
        Bitmap.CompressFormat r127 = r111.f520346d;
    L78:
        if (r127 == null) goto L87;
        String r128 = r127.toString();
        if (r128 == null) goto L87;
        if ((!StringsKt.isBlank(r128)) == true) goto L85;
        r128 = null;
    L85:
        if (r128 == null) goto L87;
        String r129 = r128.toLowerCase(Locale.ROOT);
    L88:
        if (r129 != null) goto L90;
        r129 = LoadParams.ImageFormat.JPEG;
    L90:
        r121[6] = TuplesKt.to("output_format", r129);
        if (r111 == null) goto L93;
        boolean r130 = r111.f520347e;
    L94:
        r121[7] = TuplesKt.to("keep_exif", String.valueOf(r130));
        if (r111 == null) goto L99;
        Integer r131 = r111.f520348f;
        if (r131 == null) goto L99;
        String r132 = r131.toString();
    L100:
        r121[8] = TuplesKt.to("quality_with_alpha", r132);
        if (r111 == null) goto L103;
        Bitmap.CompressFormat r133 = r111.f520349g;
    L104:
        if (r133 == null) goto L113;
        String r134 = r133.toString();
        if (r134 == null) goto L113;
        if ((!StringsKt.isBlank(r134)) == true) goto L111;
        r134 = null;
    L111:
        if (r134 == null) goto L113;
        String r135 = r134.toLowerCase(Locale.ROOT);
    L114:
        if (r135 == null) goto L117;
        r112 = r135;
    L117:
        r121[9] = TuplesKt.to("format_with_alpha", r112);
        if (r111 == null) goto L120;
        int r136 = r111.f520350h;
    L121:
        r121[10] = TuplesKt.to("min_size_to_compress", String.valueOf(r136));
        LinkedHashMap r137 = MapsKt.linkedMapOf(r121);
        r115 = new LinkedHashMap();
        Iterator r138 = r137.entrySet().iterator();
    L123:
        if (r138.hasNext() == false) goto L52;
        Map.Entry r139 = (Map.Entry) r138.next();
        if (((String) r139.getValue()) == null) goto L127;
        boolean r140 = true;
    L128:
        if (r140 == false) goto L123;
        r115.put(r139.getKey(), r139.getValue());
        goto L123
    L127:
        r140 = false;
        goto L128
    L120:
        r136 = 0;
    L113:
        r135 = null;
        goto L114
    L103:
        r133 = null;
    L99:
        r132 = null;
        goto L100
    L93:
        r130 = false;
    L87:
        r129 = null;
        goto L88
    L77:
        r127 = null;
    L73:
        r126 = null;
    L67:
        r124 = null;
        goto L68
    L61:
        r122 = null;
    L57:
        r120 = 100;
        goto L58
    L9:
        r104 = g.a.f373021a[r103.ordinal()];
    L133:
        r100.f489234l = r101;
        return;
    }

    public final Object c(Uri r110, ns8.a r111, Continuation<? super b> r112) {
        if ((r112 instanceof CreationImageUploadPolicy$findReusablePreprocessResult$1) == false) goto L7;
        CreationImageUploadPolicy$findReusablePreprocessResult$1 r100 = (CreationImageUploadPolicy$findReusablePreprocessResult$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r113 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L15;
        if (r103 != 1) goto L14;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L34
    L32:
        Object r104 = Result.m9449constructorimpl((b) r102);     // Catch: Throwable -> L34
    L36:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L40;
        FLogger.f375446a.e(f372949b, "findReusablePreprocessResult error", r105);
    L40:
        if (Result.m9455isFailureimpl(r104) == false) goto L43;
        return null;
    L43:
        return r104;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r102);
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L34
        f.f373014a.getClass();     // Catch: Throwable -> L34
        if (Intrinsics.areEqual(((kq9.h) f.f373016c.getValue()).a(), Boxing.boxBoolean(true)) == true) goto L19;
        return null;
    L19:
        String r107 = vqc.d.d(AppHost.f326268a.getApplication(), r110);     // Catch: Throwable -> L34
        if (r107 != null) goto L22;
        return null;
    L22:
        PolarisFileWrapper r108 = new PolarisFileWrapper(r107);     // Catch: Throwable -> L34
        long r109 = r108.length();     // Catch: Throwable -> L34
        if (r111 == null) goto L25;
        Integer r114 = Boxing.boxInt(r111.hashCode());     // Catch: Throwable -> L34
    L26:
        m.a r115 = m.f373032a.b(r110, Boxing.boxLong(r109), String.valueOf(r114));     // Catch: Throwable -> L34
        if (r115 != null) goto L29;
        return null;
    L29:
        CoroutineDispatcher r116 = Dispatchers.getIO();     // Catch: Throwable -> L34
        CreationImageUploadPolicy$findReusablePreprocessResult$2$1 r117 = new CreationImageUploadPolicy$findReusablePreprocessResult$2$1(r115, r108, r109, r107, this, null);     // Catch: Throwable -> L34
        r100.label = 1;     // Catch: Throwable -> L34
        r102 = BuildersKt.withContext(r116, r117, r100);     // Catch: Throwable -> L34
        if (r102 != r113) goto L32;
        return r113;
    L25:
        r114 = null;
    L34:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new CreationImageUploadPolicy$findReusablePreprocessResult$1(this, r112);
        goto L8
    }

    public static a e(String r100, Integer r101, Bitmap.CompressFormat r102, int r103) {
        if (r101 == null) goto L4;
        r103 = r101.intValue();
    L4:
        int r104 = Math.max(0, r103);
        if (Build.VERSION.SDK_INT < 30) goto L14;
        if (r100 == null) goto L27;
        Bitmap.CompressFormat r105 = f(r100);
        if (r105 == null) goto L27;
        r102 = r105;
    L27:
        return new a(r102, r104);
    L14:
        if (Intrinsics.areEqual(r100, "webp_lossless") == false) goto L17;
        return new a(Bitmap.CompressFormat.WEBP, 100);
    L17:
        if (Intrinsics.areEqual(r100, "webp_lossy") == false) goto L20;
        return new a(Bitmap.CompressFormat.WEBP, Math.min(r104, 99));
    L20:
        if (r100 == null) goto L26;
        Bitmap.CompressFormat r106 = f(r100);
        if (r106 == null) goto L26;
        r102 = r106;
    L26:
        return new a(r102, r104);
    }

    @Override // com.larus.uaigc.utils.a
    public final Object a(Uri r310, String r311, String r312, Continuation<? super ic8.n0> r410) {
        Uri r100 = r310;
        String r101 = r311;
        if ((r410 instanceof CreationImageUploadPolicy$compressAlbumImg$1) == false) goto L7;
        CreationImageUploadPolicy$compressAlbumImg$1 r102 = (CreationImageUploadPolicy$compressAlbumImg$1) r410;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        CreationImageUploadPolicy$compressAlbumImg$1 r110 = r102;
        Object r104 = r110.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r110.label;
        String r107 = "image/jpeg";
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        CreationImageUploadPolicy r108 = (CreationImageUploadPolicy) r110.L$5;
        CreationImageUploadPolicy r109 = (CreationImageUploadPolicy) r110.L$4;
        CreationImageUploadPolicy r111 = (CreationImageUploadPolicy) r110.L$3;
        b r112 = (b) r110.L$2;
        ns8.a r113 = (ns8.a) r110.L$1;
        Uri r114 = (Uri) r110.L$0;
        ResultKt.throwOnFailure(r104);
        b r115 = r112;
        ns8.a r116 = r113;
        Uri r117 = r114;
        Object r118 = r104;
        CreationImageUploadPolicy r119 = r111;
        String r120 = "image/jpeg";
        CreationImageUploadPolicy r121 = r109;
    L132:
        ic8.n0 r122 = (ic8.n0) r118;
        r108.getClass();
        f.f373014a.getClass();
        Boolean r123 = ((kq9.h) f.f373016c.getValue()).a();
        Boolean r124 = Boolean.TRUE;
        if (Intrinsics.areEqual(r123, r124) == false) goto L143;
        ProcessFileResultCode r125 = r122.f489244b;
        if (r125 != null) goto L137;
    L139:
        boolean r126 = false;
    L140:
        if (r126 == false) goto L143;
        BuildersKt.launch$default((CoroutineScope) f372953f.getValue(), null, null, new CreationImageUploadPolicy$reusePreprocessResult$1(r115, r117, r116, r122, null), 3, null);
        goto L143
    L137:
        if (r125.isSuccess() != true) goto L139;
        r126 = true;
    L143:
        r121.getClass();
        if (Intrinsics.areEqual(f.c().b(), r124) == false) goto L308;
        ProcessFileResultCode r127 = r122.f489244b;
        if (r127 != null) goto L149;
        int r128 = -1;
    L151:
        if (r128 != 1) goto L153;
    L159:
        Application r129 = AppHost.f326268a.getApplication();
        ImFileUtil.f314899a.getClass();     // Catch: Throwable -> L163
        String r130 = ImFileUtil.i(r117);     // Catch: Throwable -> L163
        if (r130 == null) goto L164;
        String r131 = r130.toLowerCase(Locale.US);     // Catch: Throwable -> L163
    L165:
        if (r131 != null) goto L167;
    L230:
        String r132 = "jpg";
    L231:
        PolarisFileWrapper r133 = BitmapHelperKt.a(r132);     // Catch: Throwable -> L163
        ParcelFileDescriptor r134 = b(r129.getContentResolver(), r117);     // Catch: Throwable -> L263
        if (r134 == null) goto L264;
        PolarisFileInputStreamWrapper r135 = new PolarisFileInputStreamWrapper(r134.getFileDescriptor());     // Catch: Throwable -> L256
        PolarisFileOutputStreamWrapper r136 = new PolarisFileOutputStreamWrapper(r133);     // Catch: Throwable -> L249
        ByteStreamsKt.copyTo$default(r135, r136, 0, 2, null);     // Catch: Throwable -> L242
        CloseableKt.closeFinally(r136, null);     // Catch: Throwable -> L249
        CloseableKt.closeFinally(r135, null);     // Catch: Throwable -> L256
        CloseableKt.closeFinally(r134, null);     // Catch: Throwable -> L263
        boolean r137 = true;
    L265:
        if (r137 == true) goto L289;
        InputStream r138 = ContentResolverWrapper.openInputStream(r129.getContentResolver(), r117);     // Catch: Throwable -> L163
        if (r138 == null) goto L288;
        PolarisFileOutputStreamWrapper r139 = new PolarisFileOutputStreamWrapper(r133);     // Catch: Throwable -> L281
        ByteStreamsKt.copyTo$default(r138, r139, 0, 2, null);     // Catch: Throwable -> L274
        CloseableKt.closeFinally(r139, null);     // Catch: Throwable -> L281
        CloseableKt.closeFinally(r138, null);     // Catch: Throwable -> L163
        goto L289
    L274:
        th = move-exception;
        throw th;     // Catch: Throwable -> L277
    L277:
        th = move-exception;
        CloseableKt.closeFinally(r139, th);     // Catch: Throwable -> L281
        throw th;     // Catch: Throwable -> L281
    L281:
        th = move-exception;
        throw th;     // Catch: Throwable -> L284
    L284:
        th = move-exception;
        CloseableKt.closeFinally(r138, th);     // Catch: Throwable -> L163
        throw th;     // Catch: Throwable -> L163
    L289:
        if (r133 == null) goto L301;
        ic8.m0 r140 = r122.f489243a;
        if (r140 == null) goto L299;
        String r141 = r133.getName();
        if (r141 != null) goto L295;
        r141 = "";
    L295:
        String r142 = r133.getAbsolutePath();
        if (r142 != null) goto L298;
        r142 = "";
    L298:
        ic8.m0 r143 = ic8.m0.a(r140, null, r141, r142, 16365);
    L300:
        r122 = new ic8.n0(r143, ProcessFileResultCode.SUCCESS);
        goto L308
    L299:
        r143 = null;
    L301:
        String r144 = vqc.d.d(AppHost.f326268a.getApplication(), r117);
        if (r144 == null) goto L308;
        ic8.m0 r145 = r122.f489243a;
        if (r145 == null) goto L306;
        ic8.m0 r146 = ic8.m0.a(r145, null, null, r144, 16367);
    L307:
        r122 = new ic8.n0(r146, ProcessFileResultCode.SUCCESS);
        goto L308
    L306:
        r146 = null;
        goto L307
    L242:
        th = move-exception;
        throw th;     // Catch: Throwable -> L245
    L245:
        th = move-exception;
        CloseableKt.closeFinally(r136, th);     // Catch: Throwable -> L249
        throw th;     // Catch: Throwable -> L249
    L249:
        th = move-exception;
        throw th;     // Catch: Throwable -> L252
    L252:
        th = move-exception;
        CloseableKt.closeFinally(r135, th);     // Catch: Throwable -> L256
        throw th;     // Catch: Throwable -> L256
    L256:
        th = move-exception;
        throw th;     // Catch: Throwable -> L259
    L259:
        th = move-exception;
        CloseableKt.closeFinally(r134, th);     // Catch: Throwable -> L263
        throw th;     // Catch: Throwable -> L263
    L264:
        r137 = false;
        goto L265
    L167:
        switch(r131.hashCode()) {
            case -1487662500: goto L226;
            case -1487656890: goto L222;
            case -1487464693: goto L218;
            case -1487464690: goto L214;
            case -1487394660: goto L211;
            case -1487103447: goto L208;
            case -1487018032: goto L204;
            case -879272239: goto L200;
            case -879267568: goto L196;
            case -879264467: goto L194;
            case -879258763: goto L191;
            case -227171396: goto L187;
            case 1140778788: goto L185;
            case 1146349984: goto L183;
            case 1176892386: goto L179;
            case 1177225566: goto L176;
            case 1544502791: goto L173;
            case 1578362927: goto L170;
            default: goto L230;
        };     // Catch: Throwable -> L163
    L185:
        String r147 = "image/pjpeg";
    L212:
        r131.equals(r147);     // Catch: Throwable -> L163
        goto L230
    L194:
        r147 = "image/jpg";
        goto L212
    L211:
        r147 = r120;
        goto L212
    L170:
        if (r131.equals("image/vnd.microsoft.icon") == false) goto L230;
    L181:
        r132 = "ico";
        goto L231
    L173:
        if (r131.equals("image/x-ms-bmp") == false) goto L230;
    L202:
        r132 = "bmp";
        goto L231
    L176:
        if (r131.equals("image/x-tiff") == false) goto L230;
    L210:
        r132 = "tiff";
        goto L231
    L179:
        if (r131.equals("image/x-icon") == true) goto L181;
    L183:
        if (r131.equals("image/x-png") == false) goto L230;
    L193:
        r132 = LoadParams.ImageFormat.PNG;
        goto L231
    L187:
        if (r131.equals("image/svg+xml") == false) goto L230;
        r132 = "svg";
        goto L231
    L191:
        if (r131.equals("image/png") == true) goto L193;
    L196:
        if (r131.equals(MimeType.GIF) == false) goto L230;
        r132 = "gif";
        goto L231
    L200:
        if (r131.equals("image/bmp") == true) goto L202;
    L204:
        if (r131.equals(MimeType.WEBP) == false) goto L230;
        r132 = "webp";
        goto L231
    L208:
        if (r131.equals(MimeType.TIFF) == true) goto L210;
    L214:
        if (r131.equals("image/heif") == false) goto L230;
        r132 = "heif";
        goto L231
    L218:
        if (r131.equals("image/heic") == false) goto L230;
        r132 = "heic";
        goto L231
    L222:
        if (r131.equals("image/avif") == false) goto L230;
        r132 = "avif";
        goto L231
    L226:
        if (r131.equals("image/apng") == false) goto L230;
        r132 = "apng";
        goto L231
    L164:
        r131 = null;
    L288:
        r133 = null;
        goto L289
    L153:
        if (r128 == 2) goto L159;
        if (r128 == 3) goto L159;
        if (r128 == 4) goto L301;
    L149:
        r128 = c.f372959a[r127.ordinal()];
    L308:
        r119.getClass();
        g(r122, r116);
        return r122;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r148 = r110.J$0;
        ns8.a r149 = (ns8.a) r110.L$3;
        String r150 = (String) r110.L$2;
        String r151 = (String) r110.L$1;
        Uri r152 = (Uri) r110.L$0;
        ResultKt.throwOnFailure(r104);
        r116 = r149;
        r100 = r152;
        r107 = "image/jpeg";
        Object r153 = r104;
        String r154 = r150;
        r101 = r151;
    L115:
        b r155 = (b) r153;
        if (r155 == null) goto L118;
        ic8.n0 r156 = r155.f372956a;
    L119:
        if (r156 == null) goto L125;
        g(r156, r116);
        FLogger.f375446a.i(f372949b, "findReusablePreprocessResult: " + r156);
        Lazy r157 = ImageUploadDuplicateStatHelper.f372998a;
        StringBuilder r158 = new StringBuilder();
        r158.append(r101);
        if (r154 != null) goto L123;
        r154 = "";
    L123:
        r158.append(r154);
        ImageUploadDuplicateStatHelper.b(r158.toString(), r100, r156, System.currentTimeMillis() - r148, true);
        return r156;
    L125:
        IAIChatUploadMediaService.Companion r159 = IAIChatUploadMediaService.f365908a;
        StringBuilder r160 = new StringBuilder();
        r160.append(r101);
        if (r154 != null) goto L128;
        r154 = "";
    L128:
        r160.append(r154);
        String r161 = r160.toString();
        r110.L$0 = r100;
        r110.L$1 = r116;
        r110.L$2 = r155;
        r110.L$3 = this;
        r110.L$4 = this;
        r110.L$5 = this;
        r110.label = 2;
        r120 = r107;
        r118 = IAIChatUploadMediaService.a.a(r159, r100, r116, false, true, r161, r110, 12);
        if (r118 != r105) goto L131;
        return r105;
    L131:
        r121 = this;
        r119 = r121;
        r115 = r155;
        r117 = r100;
        r108 = r119;
        goto L132
    L118:
        r156 = null;
        goto L119
    L16:
        ResultKt.throwOnFailure(r104);
        r148 = System.currentTimeMillis();
        ImFileUtil.f314899a.getClass();
        String r162 = ImFileUtil.i(r310);
        if (r162 == null) goto L19;
        String r163 = r162.toLowerCase(Locale.US);
    L20:
        Map<String, i4> r164 = d().f486768d;
        if (r164 == null) goto L23;
        i4 r165 = r164.get(r101);
    L25:
        if (Intrinsics.areEqual(r163, "image/jpeg") == false) goto L27;
    L30:
        boolean r166 = true;
    L31:
        if (r166 == false) goto L33;
        Bitmap.CompressFormat r167 = Bitmap.CompressFormat.JPEG;
    L34:
        Bitmap.CompressFormat r168 = Bitmap.CompressFormat.PNG;
        int r169 = d().f486767c;
        int r170 = d().f486767c;
        if (r165 != null) goto L41;
        Integer r171 = Integer.valueOf(d().f486765a);
        Integer r172 = Integer.valueOf(d().f486766b);
        Integer r210 = Integer.valueOf(d().f486767c);
        Integer r211 = Integer.valueOf(d().f486767c);
        f.f373014a.getClass();
        Integer r173 = f.c().c();
        if (r173 == null) goto L39;
        int r212 = r173.intValue();
    L40:
        ns8.a r174 = new ns8.a(r171, r172, r210, r167, false, r211, r168, r212);
        r107 = "image/jpeg";
    L111:
        r110.L$0 = r100;
        r110.L$1 = r101;
        r154 = r312;
        r110.L$2 = r154;
        r110.L$3 = r174;
        r110.J$0 = r148;
        r110.label = 1;
        r153 = c(r100, r174, r110);
        if (r153 != r105) goto L114;
        return r105;
    L114:
        r116 = r174;
        goto L115
    L39:
        r212 = 0;
        goto L40
    L41:
        int r175 = NetConnectionTypeProvider.f360084a.getValue();
        Integer r176 = ((kq9.l) f372951d.getValue()).a();
        if (r176 == null) goto L44;
        int r177 = r176.intValue();
    L45:
        if (r175 > r177) goto L47;
        boolean r178 = true;
    L48:
        if (r178 == false) goto L52;
        hq9.p0 r179 = r165.b();
        if (r179 == null) goto L55;
        String r180 = r179.a();
    L56:
        if (r178 == false) goto L60;
        hq9.p0 r181 = r165.b();
        if (r181 == null) goto L64;
        Integer r182 = r181.c();
    L63:
        Integer r183 = r182;
    L65:
        a r184 = e(r180, r183, r167, r169);
        if (r178 == false) goto L70;
        hq9.p0 r185 = r165.b();
        if (r185 == null) goto L73;
        String r186 = r185.b();
    L74:
        if (r178 == false) goto L78;
        hq9.p0 r187 = r165.b();
        if (r187 == null) goto L81;
        Integer r188 = r187.d();
    L82:
        a r189 = e(r186, r188, r168, r170);
        if (r178 == false) goto L87;
        hq9.p0 r190 = r165.b();
        if (r190 == null) goto L90;
        Integer r191 = r190.f();
    L91:
        if (r191 == null) goto L93;
        int r192 = r191.intValue();
    L94:
        Integer r213 = Integer.valueOf(r192);
        if (r178 == false) goto L99;
        hq9.p0 r193 = r165.b();
        if (r193 == null) goto L102;
        Integer r194 = r193.e();
    L103:
        if (r194 == null) goto L105;
        int r195 = r194.intValue();
    L106:
        Integer r214 = Integer.valueOf(r195);
        Integer r215 = Integer.valueOf(r184.f372955b);
        Bitmap.CompressFormat r196 = r184.f372954a;
        Integer r313 = Integer.valueOf(r189.f372955b);
        Bitmap.CompressFormat r197 = r189.f372954a;
        f.f373014a.getClass();
        Integer r198 = f.c().c();
        if (r198 == null) goto L109;
        int r314 = r198.intValue();
    L110:
        r174 = new ns8.a(r213, r214, r215, r196, false, r313, r197, r314);
        goto L111
    L109:
        r314 = 0;
        goto L110
    L105:
        r195 = d().f486766b;
    L102:
        r194 = null;
        goto L103
    L99:
        hq9.p0 r199 = r165.a();
        if (r199 == null) goto L102;
        r194 = r199.e();
        goto L103
    L93:
        r192 = d().f486765a;
    L90:
        r191 = null;
        goto L91
    L87:
        hq9.p0 r1100 = r165.a();
        if (r1100 == null) goto L90;
        r191 = r1100.f();
    L81:
        r188 = null;
        goto L82
    L78:
        hq9.p0 r1101 = r165.a();
        if (r1101 == null) goto L81;
        r188 = r1101.d();
    L73:
        r186 = null;
        goto L74
    L70:
        hq9.p0 r200 = r165.a();
        if (r200 == null) goto L73;
        r186 = r200.b();
    L64:
        r183 = null;
        goto L65
    L60:
        hq9.p0 r1102 = r165.a();
        if (r1102 == null) goto L64;
        r182 = r1102.c();
    L55:
        r180 = null;
        goto L56
    L52:
        hq9.p0 r1103 = r165.a();
        if (r1103 == null) goto L55;
        r180 = r1103.a();
        goto L56
    L47:
        r178 = false;
        goto L48
    L44:
        r177 = -2;
        goto L45
    L33:
        r167 = Bitmap.CompressFormat.PNG;
        goto L34
    L27:
        if (Intrinsics.areEqual(r163, "image/jpg") == true) goto L30;
        r166 = false;
        goto L31
    L23:
        r165 = null;
        goto L25
    L19:
        r163 = null;
    L7:
        r102 = new CreationImageUploadPolicy$compressAlbumImg$1(this, r410);
        goto L8
    }
}
