package com.larus.bmhome.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.media.MediaUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class ImFileUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImFileUtil f314899a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f314900b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f314901c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f314902d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f314903e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f314904f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f314905g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f314906h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f314907i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f314908j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f314909k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f314910l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy f314911m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy f314912n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lazy f314913o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Lazy f314914p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Lazy f314915q = null;

    public ImFileUtil() {
    }

    static {
        f314899a = new ImFileUtil();
        f314900b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new t0());
        f314901c = LazyKt.lazy(new i1());
        f314902d = LazyKt.lazy(new j1());
        f314903e = LazyKt.lazy(new k1());
        f314904f = LazyKt.lazy(new u0());
        f314905g = LazyKt.lazy(new v0());
        f314906h = LazyKt.lazy(new w0());
        f314907i = LazyKt.lazy(new x0());
        f314908j = LazyKt.lazy(new y0());
        f314909k = LazyKt.lazy(new z0());
        f314910l = LazyKt.lazy(new c1());
        f314911m = LazyKt.lazy(new d1());
        f314912n = LazyKt.lazy(new e1());
        f314913o = LazyKt.lazy(new f1());
        f314914p = LazyKt.lazy(new g1());
        f314915q = LazyKt.lazy(new h1());
    }

    public static long j() {
        return ((Number) f314910l.getValue()).longValue();
    }

    public static int k() {
        return ((Number) f314912n.getValue()).intValue();
    }

    public static int l() {
        return ((Number) f314911m.getValue()).intValue();
    }

    public static int m() {
        String r100 = PollingConfigService.f326423a.f("vlm_cnt_dg");
        int r101 = 0;
        if (r100 == null) goto L7;
        Integer r102 = StringsKt.toIntOrNull(r100);
        if (r102 == null) goto L7;
        int r103 = r102.intValue();
    L8:
        if (r103 <= 0) goto L10;
        FLogger.f375446a.i("ImFileUtil", "supportMaxImageAndVideoCount downgradeCount = " + r103);
        return r103;
    L10:
        com.larus.platform.model.chat.t0 r104 = q().n();
        if (r104 == null) goto L17;
        com.larus.platform.model.chat.u0 r105 = r104.a();
        if (r105 == null) goto L17;
        Integer r106 = r105.c();
        if (r106 == null) goto L17;
        r101 = r106.intValue();
    L17:
        if (r101 > 0) goto L20;
        return 10;
    L20:
        return r101;
    L7:
        r103 = 0;
        goto L8
    }

    public static int n() {
        String r100 = PollingConfigService.f326423a.f("vlm_cnt_dg");
        int r101 = 0;
        if (r100 == null) goto L7;
        Integer r102 = StringsKt.toIntOrNull(r100);
        if (r102 == null) goto L7;
        int r103 = r102.intValue();
    L8:
        if (r103 <= 0) goto L10;
        FLogger.f375446a.i("ImFileUtil", "supportMaxImageCount downgradeCount = " + r103);
        return r103;
    L10:
        com.larus.platform.model.chat.s0 r104 = q().m();
        if (r104 == null) goto L15;
        Integer r105 = r104.c();
        if (r105 == null) goto L15;
        r101 = r105.intValue();
    L15:
        if (r101 > 0) goto L18;
        return 10;
    L18:
        return r101;
    L7:
        r103 = 0;
        goto L8
    }

    public static int o() {
        return ((Number) f314915q.getValue()).intValue();
    }

    public static com.larus.platform.model.chat.r0 p() {
        if (AccountService.f365697a.a() == false) goto L9;
        com.larus.platform.model.chat.r0 r100 = q().j();
        if (r100 != null) goto L10;
        return null;
    L10:
        return com.larus.platform.model.chat.r0.a(r100, new ArrayList());
    L9:
        return q().j();
    }

    public static com.larus.platform.model.chat.t q() {
        return (com.larus.platform.model.chat.t) f314901c.getValue();
    }

    public static boolean A(long r100) {
        if (r100 > 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 > ((Number) f314903e.getValue()).longValue()) goto L8;
        return false;
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = "h264";
        if (StringsKt.contains$default(r100, "avc", false, 2, null) == true) goto L18;
        if (StringsKt.contains$default(r100, "h264", false, 2, null) == true) goto L18;
        r101 = "h265";
        if (StringsKt.contains$default(r100, "hevc", false, 2, null) == true) goto L18;
        if (StringsKt.contains$default(r100, "h265", false, 2, null) == true) goto L18;
        if (StringsKt.contains$default(r100, "dolby-vision", false, 2, null) == true) goto L18;
        if (StringsKt.contains$default(r100, '/', false, 2, null) == true) goto L20;
        return r100;
    L20:
        return StringsKt.substringAfterLast$default(r100, '/', null, 2, null);
    L18:
        return r101;
    }

    public static String e(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((StringsKt.endsWith$default(r100, ".jpg", false, 2, null) | StringsKt.endsWith$default(r100, ".jpeg", false, 2, null)) == false) goto L9;
        return "image/jpeg";
    L9:
        if (StringsKt.endsWith$default(r100, RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT, false, 2, null) == false) goto L13;
        return "image/png";
    L13:
        return null;
    }

    public static ic8.m0 f(Uri r110) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        String r100 = i(r110);
        String r101 = null;
        long r102 = -1;
        if (Intrinsics.areEqual(r110.getScheme(), "content") == false) goto L45;
        Cursor r103 = b((ContentResolver) f314900b.getValue(), r110, null);     // Catch: Exception -> L42
        if (r103 != null) goto L61;
    L40:
        r102 = h(r110, r102, "getFileInfoFromUri");     // Catch: Exception -> L42
    L55:
        long r104 = r102;
        return new ic8.m0(r110.toString(), r101, r104, r100, null, null, null, 16368);
    L61:
        Cursor r105 = r103;     // Catch: Exception -> L42
        Cursor r106 = r105;     // Catch: Throwable -> L32
        if (r106.moveToFirst() == false) goto L27;
        f314899a.getClass();     // Catch: Throwable -> L32
        int r107 = r106.getColumnIndex("_display_name");     // Catch: Throwable -> L32
        if (r107 == (-1)) goto L12;
        String r108 = r106.getString(r107);     // Catch: Throwable -> L32
    L13:
        if (r108 != null) goto L64;
        int r109 = r106.getColumnIndex("_data");     // Catch: Throwable -> L32
        if (r109 == (-1)) goto L17;
        String r111 = r106.getString(r109);     // Catch: Throwable -> L32
    L18:
        if (r111 == null) goto L21;
        r108 = StringsKt.substringAfterLast$default(r111, '/', null, 2, null);     // Catch: Throwable -> L32
        goto L64
    L21:
        r108 = null;
        goto L64
    L17:
        r111 = null;
    L64:
        int r112 = r106.getColumnIndex("_size");     // Catch: Throwable -> L25
        if (r112 == (-1)) goto L28;
        r102 = r106.getLong(r112);     // Catch: Throwable -> L25
    L28:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r105, null);     // Catch: Exception -> L38
        r101 = r108;
    L25:
        Throwable th10 = th;
    L62:
        throw th10;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        CloseableKt.closeFinally(r105, th10);     // Catch: Exception -> L38
        throw th;     // Catch: Exception -> L38
    L12:
        r108 = null;
        goto L13
    L27:
        r108 = null;
    L32:
        th = move-exception;
        r108 = null;
        th10 = th;
    L38:
        e = e;
        r101 = r108;
    L43:
        FLogger.f375446a.e("ImFileUtil", "getFileInfoFromUri failed, uri: " + r110 + ", error: " + e);
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
    L42:
        e = e;
        goto L43
    L45:
        if (Intrinsics.areEqual(r110.getScheme(), "file") == false) goto L47;
        String r114 = r110.getPath();
    L48:
        if (r114 == null) goto L55;
        PolarisFileWrapper r115 = new PolarisFileWrapper(r114);
        if (r115.exists() == true) goto L53;
        r115 = null;
    L53:
        if (r115 == null) goto L55;
        r101 = r115.getName();
        r102 = r115.length();
        goto L55
    L47:
        r114 = r110.toString();
        goto L48
    }

    public static String g(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L15
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L15
        byte[] r103 = new byte[8192];     // Catch: Throwable -> L15
    L17:
        int r104 = r102.read(r103);     // Catch: Throwable -> L12
        if (r104 <= 0) goto L7;
        r101.update(r103, 0, r104);     // Catch: Throwable -> L12
        goto L17
    L7:
        byte[] r105 = r101.digest();     // Catch: Throwable -> L12
        StringBuilder r106 = new StringBuilder();     // Catch: Throwable -> L12
        int r107 = r105.length;     // Catch: Throwable -> L12
        int r108 = 0;
    L8:
        if (r108 >= r107) goto L10;
        byte r109 = r105[r108];     // Catch: Throwable -> L12
        StringCompanionObject r110 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L12
        r106.append(String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r109)}, 1)));     // Catch: Throwable -> L12
        r108 = r108 + 1;     // Catch: Throwable -> L12
        goto L8
    L10:
        String r111 = r106.toString();     // Catch: Throwable -> L12
        r102.close();     // Catch: Throwable -> L15
        return r111;
    L12:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        return null;
    }

    public static String i(Uri r110) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        if (Intrinsics.areEqual(r110.getScheme(), "content") == false) goto L6;
        return ((ContentResolver) f314900b.getValue()).getType(r110);
    L6:
        if (Intrinsics.areEqual(r110.getScheme(), "file") == false) goto L8;
        String r111 = r110.getPath();
    L9:
        MimeTypeMap r100 = MimeTypeMap.getSingleton();
        if (r111 == null) goto L28;
        int r101 = StringsKt.lastIndexOf$default(r111, '#', 0, false, 6, null);
        boolean r102 = false;
        if (r101 <= 0) goto L15;
        r111 = r111.substring(0, r101);
    L15:
        int r103 = StringsKt.lastIndexOf$default(r111, '?', 0, false, 6, null);
        if (r103 <= 0) goto L18;
        r111 = r111.substring(0, r103);
    L18:
        int r104 = StringsKt.lastIndexOf$default(r111, '/', 0, false, 6, null);
        if (r104 < 0) goto L22;
        r111 = r111.substring(r104 + 1);
    L22:
        if (r111.length() <= 0) goto L24;
        r102 = true;
    L24:
        if (r102 == false) goto L28;
        int r105 = StringsKt.lastIndexOf$default(r111, '.', 0, false, 6, null);
        if (r105 < 0) goto L28;
        String r112 = r111.substring(r105 + 1);
    L30:
        return r100.getMimeTypeFromExtension(r112);
    L28:
        r112 = "";
        goto L30
    L8:
        r111 = r110.toString();
        goto L9
    }

    public static float r(MediaMetadataRetriever r110) {
        Intrinsics.checkNotNullParameter(r110, "mediaMetadataRetriever");
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L26
        int r102 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L26
        if (r102 < 23) goto L6;
        String r103 = c(r110, 25);     // Catch: Throwable -> L26
    L7:
        if (r103 == null) goto L9;
        float r111 = CastFloatProtector.parseFloat(r103);     // Catch: Throwable -> L26
    L24:
        Object r112 = Result.m9449constructorimpl(Float.valueOf(r111));     // Catch: Throwable -> L26
    L28:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r112);
        if (r104 == null) goto L32;
        FLogger.f375446a.e("ImFileUtil", "[getVideoFps] " + r104);
    L32:
        if (Result.m9455isFailureimpl(r112) == true) goto L35;
        r100 = r112;
    L35:
        Float r105 = (Float) r100;
        if (r105 != null) goto L38;
        return 0.0f;
    L38:
        return r105.floatValue();
    L9:
        String r106 = c(r110, 9);     // Catch: Throwable -> L26
        if (r102 < 28) goto L13;
        String r113 = c(r110, 32);     // Catch: Throwable -> L26
    L20:
        if (r106 == null) goto L23;
        if (r113 == null) goto L23;
        r111 = CastIntegerProtector.parseInt(r113) / (CastLongProtector.parseLong(r106) / 1000.0f);     // Catch: Throwable -> L26
    L23:
        r111 = 0.0f;
        goto L24
    L13:
        if (r106 == null) goto L15;
        long r107 = CastLongProtector.parseLong(r106);     // Catch: Throwable -> L26
    L16:
        long r108 = r107 / ((long) 1000);     // Catch: Throwable -> L26
        if (r108 <= 0) goto L19;
        r113 = String.valueOf(((long) 25) * r108);     // Catch: Throwable -> L26
        goto L20
    L19:
        r113 = null;
        goto L20
    L15:
        r107 = 0;
        goto L16
    L6:
        r103 = null;
    L26:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    }

    public static boolean s(Uri r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = i(r100);
        if (r101 != null) goto L8;
        return false;
    L8:
        if (StringsKt.startsWith$default(r101, "audio/", false, 2, null) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean w(Uri r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return MediaUtils.isPhoto(i(r100));
    }

    public static boolean x(long r100) {
        File r101 = AppHost.f326268a.getApplication().getExternalFilesDir(null);
        if (r101 == null) goto L5;
        long r102 = r101.getFreeSpace();
    L7:
        if (r100 <= (r102 - 52428800)) goto L9;
        return true;
    L9:
        return false;
    L5:
        r102 = 0;
        goto L7
    }

    public static boolean y(Uri r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return MediaUtils.isVideo(i(r100));
    }

    public static String c(MediaMetadataRetriever r110, int r111) {
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

    public static Long d(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L15
        MediaMetadataRetriever r103 = new MediaMetadataRetriever();     // Catch: Throwable -> L15
        r103.setDataSource(r100, r101);     // Catch: Throwable -> L12
        String r104 = c(r103, 9);     // Catch: Throwable -> L12
        r103.release();     // Catch: Throwable -> L15
        if (r104 == null) goto L10;
        Long r105 = StringsKt.toLongOrNull(r104);     // Catch: Throwable -> L15
        if (r105 == null) goto L10;
        long r106 = r105.longValue();     // Catch: Throwable -> L15
    L11:
        Object r107 = Result.m9449constructorimpl(Long.valueOf(r106));     // Catch: Throwable -> L15
    L17:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L21;
        FLogger.f375446a.i("ImFileUtil", r108.toString());
    L21:
        if (Result.m9455isFailureimpl(r107) == false) goto L24;
        r107 = null;
    L24:
        return (Long) r107;
    L10:
        r106 = 0;
        goto L11
    L12:
        th = move-exception;
        r103.release();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public static boolean u(String r100, String r101) {
        if (r101 != null) goto L5;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L26;
        com.larus.platform.model.chat.r0 r103 = p();
        if (r103 == null) goto L24;
        List<String> r104 = r103.b();
        if (r104 == null) goto L24;
        if (r100 == null) goto L20;
        String r105 = StringsKt.substringAfterLast(r100, ".", "");
        if (r105 == null) goto L20;
        String r106 = r105.toLowerCase(Locale.getDefault());
    L22:
        if (r104.contains(r106) != true) goto L24;
        boolean r107 = true;
    L25:
        if (r107 == false) goto L26;
        return false;
    L20:
        r106 = null;
    L24:
        r107 = false;
    L26:
        return true;
    L5:
        if (r101.length() != 0) goto L7;
        boolean r108 = true;
    L8:
        if (r108 != true) goto L10;
        r102 = true;
        goto L11
    L7:
        r108 = false;
        goto L8
    }

    public static boolean v(long r100, boolean r101) {
        if (r101 == false) goto L4;
        long r102 = ((Number) f314910l.getValue()).longValue();
    L6:
        if (r100 > 0) goto L8;
    L11:
        return true;
    L8:
        if (r100 > r102) goto L11;
        return false;
    L4:
        r102 = ((Number) f314909k.getValue()).longValue();
        goto L6
    }

    public static boolean z(mr9.e r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "videoMeta");
        Integer r100 = r110.j();
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L6:
        Integer r102 = r110.h();
        if (r102 == null) goto L9;
        int r103 = r102.intValue();
    L11:
        if (r101 > 0) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r103 > 0) goto L19;
    L22:
        boolean r105 = true;
    L23:
        if (r104 == true) goto L27;
        if (r105 == true) goto L27;
        boolean r106 = false;
    L29:
        if (r106 == false) goto L32;
        FLogger.f375446a.e("ImFileUtil", "[isOverMetaLimit] isVideoOverResolution:true, h:" + r110.h() + ", w:" + r110.j());
        return true;
    L32:
        Integer r107 = r110.b();
        long r108 = 0;
        if (r107 == null) goto L35;
        long r109 = r107.intValue();
    L37:
        if (r109 > 0) goto L39;
    L42:
        boolean r112 = true;
    L43:
        if (r112 == false) goto L46;
        FLogger.f375446a.e("ImFileUtil", "[isOverMetaLimit] isVideoOverBitrate:true, bitrate:" + r110.b());
        return true;
    L46:
        Long r113 = r110.d();
        if (r113 == null) goto L49;
        r108 = r113.longValue();
    L49:
        int r114 = (int) (r108 / ((long) 1000));
        if (r111 == true) goto L60;
        if (r114 >= 0) goto L53;
    L56:
        boolean r115 = true;
    L57:
        if (r115 == false) goto L60;
        FLogger.f375446a.e("ImFileUtil", "[isOverMetaLimit] isVideoOverDuration:true, durationS:" + r114);
        return true;
    L53:
        if (r114 > ((Number) f314907i.getValue()).longValue()) goto L56;
        r115 = false;
    L60:
        Float r116 = r110.g();
        if (r116 == null) goto L63;
        float r117 = r116.floatValue();
    L65:
        if (r117 <= ((Number) f314908j.getValue()).floatValue()) goto L67;
        boolean r118 = true;
    L68:
        if (r118 == false) goto L71;
        FLogger.f375446a.e("ImFileUtil", "[isOverMetaLimit] isVideoOverFps:true, fps:" + r110.g());
        return true;
    L71:
        String r119 = r110.f();
        String r120 = null;
        if (r119 == null) goto L74;
        r120 = StringsKt.substringAfterLast$default(r119, '/', null, 2, null);
    L74:
        String r121 = "";
        if (r120 != null) goto L78;
        r120 = "";
    L78:
        if (r120.length() <= 0) goto L80;
        boolean r122 = true;
    L81:
        if (r122 == false) goto L94;
        com.larus.platform.model.chat.t0 r123 = q().n();
        if (r123 == null) goto L91;
        com.larus.platform.model.chat.u0 r124 = r123.a();
        if (r124 == null) goto L91;
        List<String> r125 = r124.b();
        if (r125 == null) goto L91;
        if (r125.contains(r120.toLowerCase(Locale.getDefault())) == true) goto L91;
        boolean r126 = true;
    L92:
        if (r126 == false) goto L94;
        boolean r127 = true;
    L95:
        if (r127 == false) goto L98;
        FLogger.f375446a.e("ImFileUtil", "[isOverMetaLimit] isDisallowedVideoType:true, format:" + r110.f());
        return true;
    L98:
        String r128 = r110.c();
        if (r128 == null) goto L103;
        r121 = r128;
    L103:
        if (r121.length() <= 0) goto L105;
        boolean r129 = true;
    L106:
        if (r129 == false) goto L119;
        com.larus.platform.model.chat.t0 r130 = q().n();
        if (r130 == null) goto L116;
        com.larus.platform.model.chat.u0 r131 = r130.a();
        if (r131 == null) goto L116;
        List<String> r132 = r131.a();
        if (r132 == null) goto L116;
        if (r132.contains(r121.toLowerCase(Locale.getDefault())) == true) goto L116;
        boolean r133 = true;
    L117:
        if (r133 == false) goto L119;
        boolean r134 = true;
    L120:
        if (r134 == false) goto L123;
        FLogger.f375446a.e("ImFileUtil", "[isOverMetaLimit] isDisallowedVideoCodec:true, codec:" + r110.c());
        return true;
    L123:
        return false;
    L116:
        r133 = false;
    L119:
        r134 = false;
        goto L120
    L105:
        r129 = false;
    L91:
        r126 = false;
    L94:
        r127 = false;
        goto L95
    L80:
        r122 = false;
        goto L81
    L67:
        r118 = false;
        goto L68
    L63:
        r117 = 0.0f;
        goto L65
    L39:
        if (r109 > ((Number) f314906h.getValue()).longValue()) goto L42;
        r112 = false;
        goto L43
    L35:
        r109 = 0;
    L27:
        r106 = true;
        goto L29
    L19:
        if (r103 > ((Number) f314905g.getValue()).intValue()) goto L22;
        r105 = false;
        goto L23
    L13:
        if (r101 > ((Number) f314904f.getValue()).intValue()) goto L16;
        r104 = false;
        goto L17
    L9:
        r103 = 0;
        goto L11
    L5:
        r101 = 0;
        goto L6
    }

    public static Cursor b(ContentResolver r110, Uri r111, String[] r112) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, null, null, null};
        f06.b r113 = new f06.b();
        f06.d r114 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r113);
        if (r114.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r113, false);
        return (Cursor) r114.f474983b;
    L6:
        Cursor r115 = r110.query(r111, r112, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r115, r113, true);
        return r115;
    }

    public static long h(Uri r100, long r110, String r111) {
        if (com.larus.platform.service.z2.f365865a.androidPreprocessOptFileSize() == true) goto L5;
        return r110;
    L5:
        FLogger r101 = FLogger.f375446a;
        r101.i("ImFileUtil", r111 + " fileSize from OpenableColumns.SIZE, uri: " + r100 + ", fileSize: " + r110);
        boolean r102 = false;
        Object r103 = null;
        long r104 = 0;
        if (r110 > 0) goto L45;
        r101.i("ImFileUtil", r111 + " fileSize <= 0, try query from MediaStore, uri: " + r100);
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L35
        Cursor r113 = b((ContentResolver) f314900b.getValue(), r100, new String[]{"_size"});     // Catch: Throwable -> L35
        if (r113 == null) goto L32;
        Cursor r114 = r113;     // Catch: Throwable -> L35
        Cursor r105 = r114;     // Catch: Throwable -> L27
        if (r105.moveToFirst() == false) goto L24;
        int r115 = r105.getColumnIndex("_size");     // Catch: Throwable -> L27
        if (r115 < 0) goto L24;
        if (r105.isNull(r115) == true) goto L24;
        Long r116 = Long.valueOf(r105.getLong(r115));     // Catch: Throwable -> L27
    L19:
        if (r116.longValue() <= 0) goto L21;
        boolean r106 = true;
    L22:
        if (r106 == false) goto L24;
    L25:
        CloseableKt.closeFinally(r114, null);     // Catch: Throwable -> L35
    L33:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L35
    L38:
        if (Result.m9455isFailureimpl(r117) == false) goto L40;
        r117 = null;
    L40:
        Long r118 = (Long) r117;
        if (r118 == null) goto L43;
        r110 = r118.longValue();
        goto L45
    L43:
        r110 = 0;
        goto L45
    L21:
        r106 = false;
    L24:
        r116 = null;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r114, th);     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L35
    L32:
        r116 = null;
    L35:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L45:
        if (r110 > 0) goto L87;
        FLogger.f375446a.w("ImFileUtil", r111 + " fileSize from MediaStore.MediaColumns.SIZE <= 0, uri: " + r100);
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L66
        AssetFileDescriptor r107 = ContentResolverWrapper.openAssetFileDescriptor((ContentResolver) f314900b.getValue(), r100, "r");     // Catch: Throwable -> L66
        if (r107 != null) goto L81;
        Long r121 = null;
    L64:
        Object r108 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L66
    L69:
        if (Result.m9455isFailureimpl(r108) == true) goto L72;
        r103 = r108;
    L72:
        Long r109 = (Long) r103;
        if (r109 == null) goto L76;
        r104 = r109.longValue();
    L76:
        return r104;
    L81:
        r121 = Long.valueOf(r107.getLength());     // Catch: Throwable -> L58
    L51:
        if (r121.longValue() <= 0) goto L53;
        r102 = true;
    L53:
        if (r102 == true) goto L56;
        r121 = null;
    L56:
        CloseableKt.closeFinally(r107, null);     // Catch: Throwable -> L66
    L58:
        th = move-exception;
        throw th;     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        CloseableKt.closeFinally(r107, th);     // Catch: Throwable -> L66
        throw th;     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L69
    L87:
        return r110;
    }

    public static Object t(Context r100, Uri r101, Continuation r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ImFileUtil$isAudioFileOverDuration$2(r100, r101, null), r102);
    }

    public static boolean B(final Context r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r102, "fileName");
        final FlowFileProtectionService r104 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r104 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L27;
        FLogger.f375446a.d("ImFileUtil", "external file open blocked by enterprise file security");
        com.larus.platform.service.o r106 = com.larus.platform.service.o.f365780a;
        JSONObject r107 = new JSONObject();
        r107.put("action", "open_external");
        r107.put("entry", "im_file_util");
        r107.put("content_type", "file");
        Unit r108 = Unit.INSTANCE;
        r106.reportEvent("flow_enterprise_file_egress_block", r107);
        com.larus.utils.y.c(new a1(r104, r100));
        return false;
    L27:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L21
        Uri r110 = FileProvider.getUriForFile(r100, AppHost.f326268a.getApplication().getPackageName() + ".sendimagesprovider", new PolarisFileWrapper(r101));     // Catch: Throwable -> L21
        if (r103 != null) goto L16;
        HashMap<String, String> r111 = FileMimeTypeUtils.f314884a;     // Catch: Throwable -> L21
        r103 = FileMimeTypeUtils.c(StringsKt.substringAfterLast$default(r102, '.', null, 2, null));     // Catch: Throwable -> L21
        if (r103 != null) goto L16;
        r103 = "*/*";
    L16:
        Intent r112 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Throwable -> L21
        r112.addFlags(1);     // Catch: Throwable -> L21
        r112.setDataAndType(r110, r103);     // Catch: Throwable -> L21
        if (r112.resolveActivity(r100.getPackageManager()) == null) goto L19;
        r100.startActivity(r112);     // Catch: Throwable -> L21
        Object r113 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L24:
        if (Result.m9452exceptionOrNullimpl(r113) == null) goto L26;
        return false;
    L26:
        return true;
    L19:
        com.larus.utils.y.c(new b1(r100));     // Catch: Throwable -> L21
        return false;
    L21:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L5:
        if (r104.I0() != true) goto L7;
        r105 = true;
        goto L8
    }
}
