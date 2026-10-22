package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import v19.m5;

/* JADX INFO: loaded from: classes25.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f299941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f299942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ExifInterface f299943c;

    public static final class a {
    }

    static {
    }

    public final kq9.t f() {
        return (kq9.t) this.f299941a.getValue();
    }

    public e() {
        this.f299941a = LazyKt.lazy(new c());
        this.f299942b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new d());
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        FLogger r101 = FLogger.f375446a;
        r101.i("BaseProcessor", "[checkDestExist] path:" + r100);
        if (m5.c(r100) == false) goto L5;
        return;
    L5:
        r101.i("BaseProcessor", "[checkDestExist] dest not exist");
        String r102 = StringsKt.substringBeforeLast$default(r100, '/', null, 2, null);
        r101.i("BaseProcessor", "[checkDestExist] dir:" + r102);
        if (m5.c(r102) == false) goto L20;
        return;
    L20:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L10
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(new PolarisFileWrapper(r102).mkdirs()));     // Catch: Throwable -> L10
    L12:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L15;
        FLogger.f375446a.e("BaseProcessor", "[checkDestExist] dir not exist, mkdirs exception: " + r105);
    L15:
        Boolean r106 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r104) == false) goto L18;
        r104 = r106;
    L18:
        boolean r107 = ((Boolean) r104).booleanValue();
        FLogger.f375446a.i("BaseProcessor", "[checkDestExist] dir not exist, mkdirs success:" + r107);
        return;
    L10:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static String e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List r101 = StringsKt.split$default(r100, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);
        String r102 = (String) CollectionsKt.getOrNull(r101, Math.max(1, CollectionsKt.getLastIndex(r101)));
        FLogger.f375446a.i("BaseProcessor", "getFormatSuffix: " + r102);
        return r102;
    }

    public final boolean g(Bitmap.CompressFormat r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Intrinsics.areEqual(i.a(r100), "webp") == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(f().f(), Boolean.TRUE) == false) goto L7;
        return true;
    }

    public static long c(FileDescriptor r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, "fileDescriptor");
        Intrinsics.checkNotNullParameter(r101, "uri");
        long r102 = -1;
        PolarisFileInputStreamWrapper r103 = null;
        PolarisFileWrapper r104 = null;
        if (z2.f365865a.androidPreprocessOptFileSize() == false) goto L72;
        ImFileUtil.f314899a.getClass();
        Intrinsics.checkNotNullParameter(r101, "uri");
        if (Intrinsics.areEqual(r101.getScheme(), "content") == false) goto L30;
        Cursor r105 = ImFileUtil.b((ContentResolver) ImFileUtil.f314900b.getValue(), r101, null);     // Catch: Exception -> L27
        if (r105 == null) goto L24;
        Cursor r106 = r105;     // Catch: Exception -> L27
        Cursor r107 = r106;     // Catch: Throwable -> L14
        if (r107.moveToFirst() == false) goto L16;
        int r108 = r107.getColumnIndex("_size");     // Catch: Throwable -> L14
        if (r108 == (-1)) goto L16;
        long r109 = r107.getLong(r108);     // Catch: Throwable -> L14
    L17:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r106, null);     // Catch: Exception -> L27
    L79:
        return ImFileUtil.h(r101, r109, "getFileSize");
    L16:
        r109 = -1;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r106, th);     // Catch: Exception -> L27
        throw th;     // Catch: Exception -> L27
    L24:
        r109 = -1;
    L27:
        e = move-exception;
        FLogger.f375446a.e("ImFileUtil", "getFileSize failed, uri: " + r101 + ", error: " + e);
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
        return -1;
    L30:
        if (Intrinsics.areEqual(r101.getScheme(), "file") == false) goto L32;
        String r111 = r101.getPath();
    L33:
        if (r111 == null) goto L77;
        PolarisFileWrapper r112 = new PolarisFileWrapper(r111);
        if (r112.exists() == false) goto L37;
        r104 = r112;
    L37:
        if (r104 != null) goto L39;
        return -1;
    L39:
        return r104.length();
    L77:
        return -1;
    L32:
        r111 = r101.toString();
        goto L33
    L72:
        PolarisFileInputStreamWrapper r113 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L47
        r102 = r113.available();     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter(r113, "<this>");
        r113.close();     // Catch: Throwable -> L58
    L65:
    L45:
        th = th;
        r103 = r113;
    L68:
        FLogger.f375446a.w("BaseProcessor", "checkSendFileSize failed, err:" + th);     // Catch: Throwable -> L53
        if (r103 == null) goto L52;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        r103.close();     // Catch: Throwable -> L58
    L53:
        th = move-exception;
        if (r103 == null) goto L57;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        r103.close();     // Catch: Throwable -> L59
    L57:
        throw th;
    L47:
        th = th;
    L52:
        return r102;
    }

    public static void d(ExifInterface r210, String r211) {
        Intrinsics.checkNotNullParameter(r211, "imageOutputPath");
        if (r210 != null) goto L5;
        return;
    L5:
        List r100 = CollectionsKt.mutableListOf(new String[]{ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_SHUTTER_SPEED_VALUE, ExifInterface.TAG_ISO_SPEED_RATINGS, ExifInterface.TAG_DATETIME, ExifInterface.TAG_DATETIME_ORIGINAL, ExifInterface.TAG_DATETIME_DIGITIZED, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_FLASH, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, ExifInterface.TAG_MAKE, ExifInterface.TAG_MODEL, ExifInterface.TAG_SUBSEC_TIME, ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, ExifInterface.TAG_WHITE_BALANCE, ExifInterface.TAG_COLOR_SPACE, ExifInterface.TAG_BRIGHTNESS_VALUE, ExifInterface.TAG_CONTRAST, ExifInterface.TAG_ISO_SPEED, ExifInterface.TAG_IMAGE_WIDTH, ExifInterface.TAG_IMAGE_LENGTH});
        ISettingRepoService r101 = (ISettingRepoService) ServiceManager.get().getService(ISettingRepoService.class);
        int r102 = 0;
        if (r101 == null) goto L10;
        boolean r103 = true;
        if (r101.H() != true) goto L10;
    L12:
        if (r103 == false) goto L25;
        FLogger.f375446a.d("BaseProcessor", "copyExif with location");
        r100.addAll(CollectionsKt.listOf(new String[]{ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_GPS_TIMESTAMP}));
    L25:
        ExifInterface r104 = new ExifInterface(r211);     // Catch: IOException -> L22
        Iterator r105 = r100.iterator();     // Catch: IOException -> L22
    L16:
        if (r105.hasNext() == false) goto L20;
        String r106 = (String) r105.next();     // Catch: IOException -> L22
        String r107 = r210.getAttribute(r106);     // Catch: IOException -> L22
        if (TextUtils.isEmpty(r107) == true) goto L16;
        r104.setAttribute(r106, r107);     // Catch: IOException -> L22
        r102 = r102 + 1;     // Catch: IOException -> L22
        goto L16
    L20:
        r104.resetOrientation();     // Catch: IOException -> L22
        r104.saveAttributes();     // Catch: IOException -> L22
        FLogger.f375446a.d("BaseProcessor", "copyExif success, setAttribute count: " + r102);     // Catch: IOException -> L22
        return;
    L22:
        e = move-exception;
        FLogger.f375446a.d("BaseProcessor", "copyExif failed, " + e.getMessage());
        return;
    L10:
        r103 = false;
        goto L12
    }

    public static String a(e r100, String r101, ns8.b r102, String r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r101 = LoadParams.ImageFormat.JPEG;
    L5:
        String r103 = r101;
        if ((r111 & 4) == 0) goto L8;
        ns8.b r104 = null;
    L10:
        if ((r111 & 8) == 0) goto L12;
        String r105 = null;
    L13:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "suffix");
        String r106 = SendResourcePreprocessManager.h(true, r103, false, r104, r105, null, 32);
        x.b(r106);
        return r106;
    L12:
        r105 = r110;
        goto L13
    L8:
        r104 = r102;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.io.FileOutputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.io.FileOutputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v8 */
    public final Pair<String, String> i(String r110, Uri r111, boolean r112, String r113, boolean r114, ns8.b r115) {
        Intrinsics.checkNotNullParameter(r111, "uri");
        StringBuilder r100 = new StringBuilder();
        if (r114 == false) goto L11;
        if (r115 != null) goto L6;
    L8:
        boolean r116 = false;
    L9:
        if (r116 == true) goto L11;
        boolean r117 = true;
    L12:
        InputStream r118 = null;
        String r119 = null;
        ?? r120 = 0;
        if (r117 == true) goto L95;
    L17:
        MessageDigest r101 = null;
    L19:
        if (r112 == true) goto L25;
        if (r110 != null) goto L117;
    L24:
        r113 = "emptyType";
        goto L25
    L117:
        r113 = e(r110);     // Catch: Throwable -> L68
        if (r113 != null) goto L25;
    L68:
        th = move-exception;
        Object th10 = th;
        String r121 = null;
        InputStream r122 = null;
    L70:
        ?? r123 = r122;
    L101:
        FLogger.f375446a.w("BaseProcessor", "tryCloneOriginalRes err: " + th10);     // Catch: Throwable -> L82
        if (r122 != null) goto L111;
    L76:
        if (r123 == 0) goto L79;
        Intrinsics.checkNotNullParameter(r123, "<this>");
        r123.close();     // Catch: Throwable -> L92
    L79:
        m5.b(r121);
        r100.setLength(0);
    L81:
        return TuplesKt.to(r119, r100.toString());
    L111:
        r122.close();     // Catch: Exception -> L75
    L82:
        th = move-exception;
        if (r122 != null) goto L113;
    L87:
        if (r123 == 0) goto L90;
        Intrinsics.checkNotNullParameter(r123, "<this>");
        r123.close();     // Catch: Throwable -> L93
    L90:
        m5.b(r121);
        r100.setLength(0);
        throw th;
    L113:
        r122.close();     // Catch: Exception -> L86
    L25:
        if (r113 != null) goto L27;
    L30:
        boolean r124 = true;
    L31:
        if (r124 == true) goto L59;
        Intrinsics.checkNotNullParameter(r113, "suffix");     // Catch: Throwable -> L68
        r121 = SendResourcePreprocessManager.f299934a.b(true, r113, r112);     // Catch: Throwable -> L68
        x.b(r121);     // Catch: Throwable -> L68
        r122 = ContentResolverWrapper.openInputStream((ContentResolver) this.f299942b.getValue(), r111);     // Catch: Throwable -> L57
        if (r122 != null) goto L115;
    L56:
        String r125 = r121;
        ?? r126 = r120;
        r118 = r122;
    L60:
        if (r118 != null) goto L103;
    L64:
        if (r126 == 0) goto L67;
        Intrinsics.checkNotNullParameter(r126, "<this>");
        r126.close();     // Catch: Throwable -> L94
    L67:
        r119 = r125;
        goto L81
    L103:
        r118.close();     // Catch: Exception -> L63
        goto L64
    L115:
        r123 = new PolarisFileOutputStreamWrapper(r121);     // Catch: Throwable -> L54
        byte[] r127 = new byte[10240];     // Catch: Throwable -> L52
        int r102 = r122.read(r127);     // Catch: Throwable -> L52
    L39:
        if ((-1) == r102) goto L44;
        r123.write(r127, 0, r102);     // Catch: Throwable -> L52
        if (r101 == null) goto L43;
        r101.update(r127, 0, r102);     // Catch: Throwable -> L52
    L43:
        r102 = r122.read(r127);     // Catch: Throwable -> L52
        goto L39
    L44:
        r123.flush();     // Catch: Throwable -> L52
        if (r117 == false) goto L51;
        if (r101 == null) goto L51;
        byte[] r128 = r101.digest();     // Catch: Throwable -> L52
        int r129 = r128.length;     // Catch: Throwable -> L52
        int r103 = 0;
    L48:
        if (r103 >= r129) goto L51;
        byte r104 = r128[r103];     // Catch: Throwable -> L52
        StringCompanionObject r105 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L52
        r100.append(String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r104)}, 1)));     // Catch: Throwable -> L52
        r103 = r103 + 1;
    L51:
        r120 = r123;
    L52:
        th10 = th;
    L54:
        th = move-exception;
        th10 = th;
        r123 = 0;
    L57:
        th = move-exception;
        th10 = th;
        r122 = null;
        goto L70
    L59:
        r126 = 0;
        r125 = null;
        goto L60
    L27:
        if (r113.length() == 0) goto L30;
        r124 = false;
        goto L31
    L95:
        r101 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L16
    L6:
        if (r115.f520356f != true) goto L8;
        r116 = true;
    L11:
        r117 = false;
        goto L12
    }

    public static Pair h(e r110, String r111, FileDescriptor r210, boolean r211, String r212, boolean r213, ns8.b r214, String r215, Uri r216, int r217) {
        if ((r217 & 4) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r217 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r217 & 16) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r217 & 32) == 0) goto L17;
        ns8.b r103 = null;
    L19:
        if ((r217 & 64) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r217 & 128) == 0) goto L25;
        Uri r105 = null;
    L26:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r210, "fileDescriptor");
        StringBuilder r106 = new StringBuilder();
        if (r102 == false) goto L35;
        if (r103 != null) goto L30;
    L32:
        boolean r112 = false;
    L33:
        if (r112 == true) goto L35;
        boolean r113 = true;
    L36:
        if (r113 == true) goto L162;
    L40:
        MessageDigest r114 = null;
    L42:
        if (r100 == false) goto L44;
        String r115 = r101;
    L51:
        if (r115 == null) goto L57;
        if (r115.length() == 0) goto L57;
        boolean r116 = false;
    L58:
        if (r116 == false) goto L138;
        r102 = r102;
        PolarisFileOutputStreamWrapper r107 = null;
        String r108 = null;
        PolarisFileInputStreamWrapper r117 = null;
    L94:
        if (r117 == null) goto L99;
        Intrinsics.checkNotNullParameter(r117, "<this>");
        r117.close();     // Catch: Throwable -> L98
    L99:
        if (r107 == null) goto L104;
        Intrinsics.checkNotNullParameter(r107, "<this>");
        r107.close();     // Catch: Throwable -> L103
    L104:
        Object r109 = null;
    L118:
        if (r109 == null) goto L124;
        if (r105 == null) goto L124;
        if (Intrinsics.areEqual(r110.f().a(), Boolean.TRUE) == false) goto L124;
        return r110.i(r111, r105, r100, r101, r102, r103);
    L124:
        return TuplesKt.to(r108, r106.toString());
    L138:
        Intrinsics.checkNotNullParameter(r115, "suffix");     // Catch: Throwable -> L91
        r108 = SendResourcePreprocessManager.h(true, r115, r100, r103, r104, null, 32);     // Catch: Throwable -> L91
        x.b(r108);     // Catch: Throwable -> L91
        r117 = new PolarisFileInputStreamWrapper(r210);     // Catch: Throwable -> L89
    L87:
        th = th;
        r102 = r102;
    L107:
        r107 = null;
    L142:
        FLogger.f375446a.w("BaseProcessor", "tryCloneOriginalRes err: " + th);     // Catch: Throwable -> L125
        if (r117 == null) goto L114;
        Intrinsics.checkNotNullParameter(r117, "<this>");
        r117.close();     // Catch: Throwable -> L113
    L114:
        if (r107 == null) goto L117;
        Intrinsics.checkNotNullParameter(r107, "<this>");
        r107.close();     // Catch: Throwable -> L136
    L117:
        m5.b(r108);
        r106.setLength(0);
        r109 = th;
        r108 = null;
    L125:
        th = move-exception;
        if (r117 == null) goto L131;
        Intrinsics.checkNotNullParameter(r117, "<this>");
        r117.close();     // Catch: Throwable -> L130
    L131:
        if (r107 == null) goto L134;
        Intrinsics.checkNotNullParameter(r107, "<this>");
        r107.close();     // Catch: Throwable -> L137
    L134:
        m5.b(r108);
        r106.setLength(0);
        throw th;
    L62:
        if (Intrinsics.areEqual(r110.f().a(), Boolean.TRUE) == false) goto L66;
        r102 = r102;
        r117.getChannel().position(0);     // Catch: Throwable -> L85
    L67:
        r107 = new PolarisFileOutputStreamWrapper(r108);     // Catch: Throwable -> L85
        byte[] r118 = new byte[10240];     // Catch: Throwable -> L83
        int r119 = r117.read(r118);     // Catch: Throwable -> L83
    L71:
        if ((-1) == r119) goto L76;
        r107.write(r118, 0, r119);     // Catch: Throwable -> L83
        if (r114 == null) goto L75;
        r114.update(r118, 0, r119);     // Catch: Throwable -> L83
    L75:
        r119 = r117.read(r118);     // Catch: Throwable -> L83
        goto L71
    L76:
        r107.flush();     // Catch: Throwable -> L83
        if (r113 == false) goto L94;
        if (r114 == null) goto L94;
        byte[] r120 = r114.digest();     // Catch: Throwable -> L83
        int r121 = r120.length;     // Catch: Throwable -> L83
        int r122 = 0;
    L80:
        if (r122 >= r121) goto L94;
        byte r123 = r120[r122];     // Catch: Throwable -> L83
        StringCompanionObject r124 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L83
        byte[] r218 = r120;
        r106.append(String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r123)}, 1)));     // Catch: Throwable -> L83
        r122 = r122 + 1;
        r120 = r218;
    L83:
        th = th;
    L85:
        th = th;
        goto L107
    L66:
        r102 = r102;
    L89:
        th = th;
    L106:
        r117 = null;
    L91:
        th = th;
        r108 = null;
    L48:
        th = th;
        r102 = r102;
        r107 = null;
        r108 = null;
        r117 = null;
    L57:
        r116 = true;
        goto L58
    L44:
        if (r111 != null) goto L146;
    L50:
        r115 = "emptyType";
        goto L51
    L146:
        r115 = e(r111);     // Catch: Throwable -> L48
        if (r115 != null) goto L51;
    L162:
        r114 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L39
    L30:
        if (r103.f520356f != true) goto L32;
        r112 = true;
    L35:
        r113 = false;
        goto L36
    L25:
        r105 = r216;
        goto L26
    L21:
        r104 = r215;
        goto L23
    L17:
        r103 = r214;
        goto L19
    L13:
        r102 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }
}
