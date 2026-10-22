package com.bytedance.ies.bullet.kit.resourceloader;

import android.content.res.AssetManager;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.geckox.GkFSUtils;
import com.bytedance.gkfs.io.GkFSFileInputStream;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f246830a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f246831b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f246832c = null;

    public j() {
    }

    static {
        f246830a = new j();
        f246831b = PatternProtector.compile("^/obj/[^/]+/[^/]+/gecko/resource");
        f246832c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    public static String b(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        if (Intrinsics.areEqual(r100.getScheme(), "http") == true) goto L13;
        if (Intrinsics.areEqual(r100.getScheme(), "https") == true) goto L13;
        String r101 = h("a_surl", r100);
        if (r101 != null) goto L14;
        String r102 = h("surl", r100);
        if (r102 == null) goto L16;
        return r102;
    L16:
        return h("url", r100);
    L14:
        return r101;
    L13:
        return r100.toString();
    }

    public static String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (StringsKt.endsWith$default(r100, ".js", false, 2, null) == false) goto L6;
        return "application/x-javascript";
    L6:
        if (StringsKt.endsWith$default(r100, InvRouter.FLOW_SUFFIX, false, 2, null) == false) goto L9;
        return "application/json";
    L9:
        if (StringsKt.endsWith$default(r100, ".css", false, 2, null) == false) goto L12;
        return "text/css";
    L12:
        if (StringsKt.endsWith$default(r100, ".html", false, 2, null) == false) goto L15;
        return "text/html";
    L15:
        if (StringsKt.endsWith$default(r100, ".ico", false, 2, null) == false) goto L18;
        return "image/x-icon";
    L18:
        if (StringsKt.endsWith$default(r100, ".jpeg", false, 2, null) == false) goto L20;
    L38:
        return "image/jpeg";
    L20:
        if (StringsKt.endsWith$default(r100, ".jpg", false, 2, null) == true) goto L38;
        if (StringsKt.endsWith$default(r100, RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT, false, 2, null) == false) goto L26;
        return "image/png";
    L26:
        if (StringsKt.endsWith$default(r100, EffectConstants.GIF_FILE_SUFFIX, false, 2, null) == false) goto L29;
        return MimeType.GIF;
    L29:
        if (StringsKt.endsWith$default(r100, ".woff", false, 2, null) == false) goto L32;
        return "font/woff";
    L32:
        if (StringsKt.endsWith$default(r100, ".svg", false, 2, null) == false) goto L35;
        return "image/svg+xml";
    L35:
        if (StringsKt.endsWith$default(r100, ".ttf", false, 2, null) == false) goto L37;
        return "font/ttf";
    L37:
        return "";
    }

    public static WebResourceResponse e(String r100) {
        DefaultConstructorMarker r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L23
        if (r100 == null) goto L21;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100);     // Catch: Throwable -> L23
        boolean r104 = false;
        if (r103.exists() == true) goto L8;
    L10:
        boolean r105 = false;
    L11:
        if (r105 == true) goto L14;
        r103 = null;
    L14:
        if (r103 == null) goto L21;
        f246830a.getClass();     // Catch: Throwable -> L23
        String r106 = c(r100);     // Catch: Throwable -> L23
        List<Function0<Unit>> r107 = GkFSUtils.f245072a;     // Catch: Throwable -> L23
        if (GkFSUtils.g(r103.getPath()) == false) goto L18;
        InputStream r108 = new GkFSFileInputStream(r103, r104, 2, r101);     // Catch: Throwable -> L23
    L20:
        return f(r106, r108);
    L18:
        r108 = new PolarisFileInputStreamWrapper(r103);     // Catch: Throwable -> L23
        goto L20
    L8:
        if (r103.isDirectory() == true) goto L10;
        r105 = true;
    L21:
        Result.m9449constructorimpl(null);     // Catch: Throwable -> L23
    L25:
        return null;
    L23:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    }

    public static String g(String r100) {
        if (r100 != null) goto L13;
    L10:
        return null;
    L13:
        if (r100.length() <= 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L10;
        MessageDigest r102 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L12
        r102.update(r100.getBytes(Charset.forName("UTF-8")));     // Catch: Exception -> L12
        return i(r102.digest());
    L6:
        r101 = false;
        goto L7
    }

    public static String i(byte[] r110) {
        if (r110 == null) goto L13;
        int r100 = r110.length;
        if ((r100 + 0) > r110.length) goto L11;
        int r101 = r100 * 2;
        char[] r102 = new char[r101];
        int r103 = 0;
        int r104 = 0;
    L6:
        if (r103 >= r100) goto L9;
        int r105 = r110[r103 + 0] & UByte.MAX_VALUE;
        int r106 = r104 + 1;
        char[] r107 = f246832c;
        r102[r104] = r107[r105 >> 4];
        r104 = r106 + 1;
        r102[r106] = r107[r105 & 15];
        r103 = r103 + 1;
        goto L6
    L9:
        return new String(r102, 0, r101);
    L11:
        throw new IndexOutOfBoundsException();
    L13:
        throw new NullPointerException("bytes is null");
    }

    public static String a(d1 r100, v26.l r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, "config");
        if (StringsKt.startsWith$default(r101.f552706i, HTTP.URL_DEFAULT, false, 2, null) == false) goto L9;
        String r102 = r101.f552706i;
        if (r102 == null) goto L8;
        String r103 = r102.substring(1);
    L11:
        return r101.f552698a + '_' + r101.f552705h + '_' + r103;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L9:
        r103 = r101.f552706i;
        goto L11
    }

    public static WebResourceResponse d(AssetManager r100, String r101) {
        if (r100 == null) goto L12;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L12;
        return f(c(r101), r100.open(r101));
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
    L12:
        return null;
    }

    public static WebResourceResponse f(String r100, InputStream r101) {
        if (r101 == null) goto L15;
        HashMap r102 = new HashMap();     // Catch: Exception -> L9
        r102.put("Access-Control-Allow-Origin", "*");     // Catch: Exception -> L9
        if (Intrinsics.areEqual("font/ttf", r100) == true) goto L14;
        WebResourceResponse r103 = new WebResourceResponse(r100, "", r101);     // Catch: Exception -> L9
        r103.setResponseHeaders(r102);     // Catch: Exception -> L9
        return r103;
    L14:
        return new WebResourceResponse(r100, "", 200, "OK", r102, r101);
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    L15:
        return null;
    }

    public static String h(String r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "uri");
        return UriProtector.getQueryParameter(r101, r100);
    L5:
        return null;
    }
}
