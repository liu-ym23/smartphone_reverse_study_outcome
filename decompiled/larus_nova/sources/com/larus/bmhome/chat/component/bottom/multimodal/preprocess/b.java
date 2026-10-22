package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.core.content.FileProvider;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import ic8.m0;
import java.io.File;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import v19.m5;
import yc9.l1;
import yc9.n1;

/* JADX INFO: loaded from: classes25.dex */
public final class b extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f299940d;

    public static final class a {
    }

    static {
    }

    public b() {
        StringBuilder r100 = new StringBuilder();
        String r101 = null;
        File r102 = AppHost.f326268a.getApplication().getExternalFilesDir(null);
        if (r102 == null) goto L5;
        r101 = r102.getCanonicalPath();
    L5:
        r100.append(r101);
        r100.append("/images/sendimages/");
        this.f299940d = r100.toString();
    }

    public static Image j(MediaMetadataRetriever r210) {
        SendResourcePreprocessManager r100 = SendResourcePreprocessManager.f299934a;
        String r101 = SendResourcePreprocessManager.i("video_cover_" + SendResourcePreprocessManager.j() + '_' + Random.Default.nextLong(10000, 99999) + ".jpeg");
        x.b(r101);
        String r102 = null;
        int r103 = 0;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L27
        Bitmap r105 = r210.getFrameAtTime(0);     // Catch: Throwable -> L27
        if (r105 == null) goto L7;
        int r106 = r105.getWidth();     // Catch: Throwable -> L27
    L8:
        if (r105 != null) goto L66;
    L12:
        PolarisFileWrapper r107 = new PolarisFileWrapper(r101);     // Catch: Throwable -> L10
        PolarisFileOutputStreamWrapper r108 = new PolarisFileOutputStreamWrapper(r107);     // Catch: Throwable -> L10
        if (r105 != null) goto L58;
    L15:
        r108.flush();     // Catch: Throwable -> L20
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r108, null);     // Catch: Throwable -> L18
        Object r110 = Result.m9449constructorimpl(Uri.fromFile(r107));     // Catch: Throwable -> L18
    L31:
        int r111 = r106;
        PolarisFileOutputStreamWrapper r211 = r108;
        int r112 = r103;
        Throwable r113 = Result.m9452exceptionOrNullimpl(r110);
        if (r113 == null) goto L38;
        FLogger.f375446a.e("AlbumVideoProcessor", "[buildCoverImage] " + r113);
        if (r211 == null) goto L37;
        Intrinsics.checkNotNullParameter(r211, "<this>");
        r211.close();     // Catch: Throwable -> L54
    L37:
        m5.b(r101);
        r101 = "";
    L38:
        String r114 = r101;
        if (Result.m9456isSuccessimpl(r110) == false) goto L47;
        Uri r115 = (Uri) r110;
        FLogger.f375446a.i("AlbumVideoProcessor", "[buildCoverImage] success");
        if (r211 == null) goto L47;
        Intrinsics.checkNotNullParameter(r211, "<this>");
        r211.close();     // Catch: Throwable -> L45
    L47:
        if (Result.m9455isFailureimpl(r110) == false) goto L49;
        r110 = null;
    L49:
        Uri r116 = (Uri) r110;
        if (r116 == null) goto L53;
        r102 = r116.toString();
    L53:
        return new Image(r102, null, null, new ImageObj(null, r111, r112, null, null, 25, null), null, r114, null, null, null, null, null, null, null, null, 16342, null);
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r108, th);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L58:
        r105.compress(Bitmap.CompressFormat.JPEG, 100, r108);     // Catch: Throwable -> L20
    L18:
        th = th;
    L30:
        Result.Companion r117 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L10:
        th = th;
    L29:
        r108 = null;
        goto L30
    L66:
        r103 = r105.getHeight();     // Catch: Throwable -> L10
        goto L12
    L7:
        r106 = 0;
    L27:
        th = th;
        r106 = 0;
        goto L29
    }

    public final mr9.e o(UplinkFileEntity r110) {
        Intrinsics.checkNotNullParameter(r110, "entity");
        Object r100 = null;
        if (n1.e(r110) == true) goto L34;
        return null;
    L34:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L21
        UplinkEntityContent r102 = r110.getUplinkEntityContent();     // Catch: Throwable -> L21
        if (r102 == null) goto L23;
        UplinkFileInfo r103 = r102.getUplinkFileInfo();     // Catch: Throwable -> L21
        if (r103 == null) goto L23;
        VideoExtension r104 = r103.getVideo();     // Catch: Throwable -> L21
        if (r104 == null) goto L23;
        String r105 = r104.getPath();     // Catch: Throwable -> L21
        if (r105 == null) goto L23;
        String r106 = p0.a(r105);     // Catch: Throwable -> L21
        if (r106 == null) goto L23;
        String r107 = this.f299940d + StringsKt.substringAfterLast$default(r106, '/', null, 2, null);     // Catch: Throwable -> L21
        AppHost.Companion r108 = AppHost.f326268a;     // Catch: Throwable -> L21
        Uri r109 = FileProvider.getUriForFile(r108.getApplication().getApplicationContext(), r108.getApplication().getPackageName() + ".sendimagesprovider", new PolarisFileWrapper(r107));     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r109);     // Catch: Throwable -> L21
        m0 r111 = new m0(r109.toString(), l1.a(r110), l1.b(r110), null, null, null, null, 16376);     // Catch: Throwable -> L21
        String r112 = r110.getFileIdentifier();     // Catch: Throwable -> L21
        if (r112 != null) goto L19;
        r112 = "";
    L19:
        Object r113 = Result.m9449constructorimpl(n(r109, r111, r112, true));     // Catch: Throwable -> L21
    L25:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L29;
        FLogger.f375446a.e("AlbumVideoProcessor", "[retrieveMetaInfoFromFile] from entity failed, " + r114);
    L29:
        if (Result.m9455isFailureimpl(r113) == true) goto L33;
        r100 = r113;
    L33:
        return (mr9.e) r100;
    L23:
        return null;
    L21:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    }

    public static ParcelFileDescriptor l(ContentResolver r210, Uri r211) {
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

    public static String m(MediaMetadataRetriever r110, int r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111)};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return r110.extractMetadata(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public final boolean k(Uri r100, m0 r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r110, "fileInfo");
        Intrinsics.checkNotNullParameter(r111, LocationMonitorConst.IDENTIFIER);
        ImFileUtil.f314899a.getClass();
        boolean r101 = false;
        if (ImFileUtil.y(r100) == true) goto L37;
        return false;
    L37:
        ParcelFileDescriptor r102 = l((ContentResolver) this.f299942b.getValue(), r100);     // Catch: Throwable -> L7
    L9:
        if (r102 != null) goto L35;
        return false;
    L35:
        long r103 = r110.f489225c;     // Catch: Throwable -> L25
        if (r103 > 0) goto L15;
        r103 = e.c(r102.getFileDescriptor(), r100);     // Catch: Throwable -> L25
    L15:
        r110.f489225c = r103;     // Catch: Throwable -> L25
        ImFileUtil.f314899a.getClass();     // Catch: Throwable -> L25
        if (ImFileUtil.A(r103) == true) goto L22;
        mr9.e r104 = n(r100, r110, r111, false);     // Catch: Throwable -> L25
        if (r104 == null) goto L22;
        if (ImFileUtil.z(r104, true) == true) goto L22;
        r101 = true;
    L22:
        Intrinsics.checkNotNullParameter(r102, "<this>");
        r102.close();     // Catch: Throwable -> L29
    L24:
        return r101;
    L25:
        th = move-exception;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        r102.close();     // Catch: Throwable -> L30
    L28:
        throw th;
    L7:
        th = move-exception;
        FLogger.f375446a.e("AlbumVideoProcessor", "[canProcessAsVideo] openFileDescriptor failed: " + th);
        r102 = null;
        goto L9
    }

    public static mr9.e n(Uri r210, m0 r211, String r212, boolean r213) {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L54
        MediaMetadataRetriever r102 = new MediaMetadataRetriever();     // Catch: Throwable -> L54
        r102.setDataSource(AppHost.f326268a.getApplication(), r210);     // Catch: Throwable -> L51
        String r103 = m(r102, 9);     // Catch: Throwable -> L51
        if (r103 == null) goto L7;
        Long r104 = Long.valueOf(Long.parseLong(r103));     // Catch: Throwable -> L51
    L8:
        if (r213 == false) goto L10;
        Image r110 = j(r102);     // Catch: Throwable -> L51
    L11:
        String r105 = m(r102, 24);     // Catch: Throwable -> L51
        if (r105 == null) goto L14;
        Object r106 = Integer.valueOf(Integer.parseInt(r105));     // Catch: Throwable -> L51
    L15:
        String r107 = m(r102, 18);     // Catch: Throwable -> L51
        if (r107 == null) goto L18;
        Integer r108 = Integer.valueOf(Integer.parseInt(r107));     // Catch: Throwable -> L51
    L19:
        String r109 = m(r102, 19);     // Catch: Throwable -> L51
        if (r109 == null) goto L22;
        Integer r111 = Integer.valueOf(Integer.parseInt(r109));     // Catch: Throwable -> L51
    L24:
        if (Intrinsics.areEqual(r106, 90) == false) goto L26;
    L29:
        boolean r112 = true;
    L31:
        if (Build.VERSION.SDK_INT < 30) goto L33;
        String r113 = m(r102, 37);     // Catch: Throwable -> L51
    L34:
        FLogger.f375446a.i("AlbumVideoProcessor", "[retrieveMetaInfo] rotationAngle:" + r106 + ", tradeWH:" + r112);     // Catch: Throwable -> L51
        String r114 = r211.f489224b;     // Catch: Throwable -> L51
        if (r112 == false) goto L37;
        Integer r115 = r111;
    L38:
        if (r112 == false) goto L40;
        Integer r116 = r108;
    L41:
        String r117 = m(r102, 20);     // Catch: Throwable -> L51
        if (r117 == null) goto L44;
        Integer r118 = Integer.valueOf(Integer.parseInt(r117));     // Catch: Throwable -> L51
    L45:
        String r119 = m(r102, 12);     // Catch: Throwable -> L51
        long r120 = r211.f489225c;     // Catch: Throwable -> L51
        ImFileUtil.f314899a.getClass();     // Catch: Throwable -> L51
        float r121 = ImFileUtil.r(r102);     // Catch: Throwable -> L51
        String r122 = m(r102, 40);     // Catch: Throwable -> L51
        if (r122 == null) goto L48;
        String r123 = com.larus.bmhome.upload.l.a(r122);     // Catch: Throwable -> L51
    L49:
        mr9.e r214 = new mr9.e(r114, r212, r104, Float.valueOf(r121), Long.valueOf(r120), r119, r123, r116, r115, r118, r113, r110, 3072);     // Catch: Throwable -> L51
        r102.release();     // Catch: Throwable -> L54
        Object r124 = Result.m9449constructorimpl(r214);     // Catch: Throwable -> L54
    L56:
        Throwable r125 = Result.m9452exceptionOrNullimpl(r124);
        if (r125 == null) goto L60;
        FLogger.f375446a.e("AlbumVideoProcessor", "[retrieveMetaInfo] " + r125);
    L60:
        if (Result.m9455isFailureimpl(r124) == true) goto L64;
        r100 = r124;
    L64:
        return (mr9.e) r100;
    L48:
        r123 = null;
        goto L49
    L44:
        r118 = null;
        goto L45
    L40:
        r116 = r111;
        goto L41
    L37:
        r115 = r108;
        goto L38
    L33:
        r113 = null;
        goto L34
    L26:
        if (Intrinsics.areEqual(r106, 270) == true) goto L29;
        r112 = false;
        goto L31
    L22:
        r111 = null;
        goto L24
    L18:
        r108 = null;
        goto L19
    L14:
        r106 = Float.valueOf(0.0f);     // Catch: Throwable -> L51
        goto L15
    L10:
        r110 = null;
        goto L11
    L7:
        r104 = null;
    L51:
        th = move-exception;
        r102.release();     // Catch: Throwable -> L54
        throw th;     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L56
    }
}
