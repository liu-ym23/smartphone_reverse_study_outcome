package com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.bridge;

import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.caijing.sdk.infra.base.api.alog.ALogService;
import com.bytedance.caijing.sdk.infra.base.api.ttnet.TTNetService;
import com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
@XBridgeMethod(name = "ttcjpay.prefetchRes")
public final class m0 extends com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f202656m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final HashMap<String, String> f202657n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final HashMap<String, WebResourceResponse> f202658o = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f202659k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final char[] f202660l;

    public static final class a {
        public a() {
        }

        public static WebResourceResponse a(String r110) {
            String r100 = m0.f202657n.get(r110);
            if (r100 == null) goto L24;
            PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
            if (r101.exists() == true) goto L7;
        L9:
            boolean r102 = false;
        L10:
            if (r102 == true) goto L13;
            r101 = null;
        L13:
            if (r101 == null) goto L25;
            m0.f202656m.getClass();
            String r103 = b(r110);
            PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r101);
            HashMap r105 = new HashMap();     // Catch: Exception -> L20
            r105.put("Access-Control-Allow-Origin", "*");     // Catch: Exception -> L20
            r105.put("Content-Type", r103);     // Catch: Exception -> L20
            if (Intrinsics.areEqual("font/ttf", r103) == false) goto L18;
            WebResourceResponse r111 = new WebResourceResponse(r103, "", 200, "OK", r105, r104);     // Catch: Exception -> L20
        L26:
            return r111;
        L18:
            r111 = new WebResourceResponse(r103, "", r104);     // Catch: Exception -> L20
            r111.setResponseHeaders(r105);     // Catch: Exception -> L20
        L20:
            e = move-exception;
            e.printStackTrace();
            return null;
        L25:
            return null;
        L7:
            if (r101.length() <= 0) goto L9;
            r102 = true;
            goto L10
        L24:
            return null;
        }

        public static String b(String r110) {
            String r100 = MimeTypeMap.getFileExtensionFromUrl(r110);
            String r101 = "application/json";
            if (r100 != null) goto L5;
        L79:
            String r102 = "";
        L81:
            if (r102.length() != 0) goto L83;
            boolean r111 = true;
        L84:
            if (r111 == false) goto L124;
            m0.f202656m.getClass();
            if (StringsKt.endsWith$default(r110, ".js", false, 2, null) == false) goto L89;
            r101 = "application/x-javascript";
        L123:
            return r101;
        L89:
            if (StringsKt.endsWith$default(r110, InvRouter.FLOW_SUFFIX, false, 2, null) == true) goto L123;
            if (StringsKt.endsWith$default(r110, ".css", false, 2, null) == false) goto L95;
            r101 = "text/css";
            goto L123
        L95:
            if (StringsKt.endsWith$default(r110, ".html", false, 2, null) == false) goto L98;
            r101 = "text/html";
            goto L123
        L98:
            if (StringsKt.endsWith$default(r110, ".ico", false, 2, null) == false) goto L101;
            r101 = "image/x-icon";
            goto L123
        L101:
            if (StringsKt.endsWith$default(r110, ".jpeg", false, 2, null) == false) goto L103;
        L121:
            r101 = "image/jpeg";
            goto L123
        L103:
            if (StringsKt.endsWith$default(r110, ".jpg", false, 2, null) == true) goto L121;
            if (StringsKt.endsWith$default(r110, RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT, false, 2, null) == false) goto L109;
            r101 = "image/png";
            goto L123
        L109:
            if (StringsKt.endsWith$default(r110, EffectConstants.GIF_FILE_SUFFIX, false, 2, null) == false) goto L112;
            r101 = MimeType.GIF;
            goto L123
        L112:
            if (StringsKt.endsWith$default(r110, ".woff", false, 2, null) == false) goto L115;
            r101 = "font/woff";
            goto L123
        L115:
            if (StringsKt.endsWith$default(r110, ".svg", false, 2, null) == false) goto L118;
            r101 = "image/svg+xml";
            goto L123
        L118:
            if (StringsKt.endsWith$default(r110, ".ttf", false, 2, null) == false) goto L120;
            r101 = "font/ttf";
            goto L123
        L120:
            r101 = "";
            goto L123
        L124:
            return r102;
        L83:
            r111 = false;
            goto L84
        L5:
            switch(r100.hashCode()) {
                case 3401: goto L73;
                case 98819: goto L69;
                case 100618: goto L64;
                case 102340: goto L60;
                case 104085: goto L56;
                case 105441: goto L52;
                case 110369: goto L47;
                case 111145: goto L43;
                case 114276: goto L39;
                case 115174: goto L34;
                case 3213227: goto L30;
                case 3258482: goto L25;
                case 3268712: goto L22;
                case 3271912: goto L18;
                case 3655064: goto L13;
                case 113307034: goto L8;
                default: goto L77;
            };
        L77:
            r102 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r100);
            if (r102 != null) goto L81;
        L8:
            if (r100.equals("woff2") == false) goto L77;
            return "application/font-woff2";
        L13:
            if (r100.equals("woff") == false) goto L77;
            return "application/font-woff";
        L18:
            if (r100.equals("json") == false) goto L77;
            return "application/json";
        L22:
            if (r100.equals(LoadParams.ImageFormat.JPEG) == false) goto L77;
        L54:
            return "image/jpeg";
        L25:
            if (r100.equals("jepg") == false) goto L77;
            return "image/jepg";
        L30:
            if (r100.equals("html") == false) goto L77;
            return "text/html";
        L34:
            if (r100.equals("ttf") == false) goto L77;
            return "application/x-font-ttf";
        L39:
            if (r100.equals("svg") == false) goto L77;
            return "image/svg+xml";
        L43:
            if (r100.equals(LoadParams.ImageFormat.PNG) == false) goto L77;
            return "image/png";
        L47:
            if (r100.equals("otf") == false) goto L77;
            return "application/vnd.ms-opentype";
        L52:
            if (r100.equals("jpg") == true) goto L54;
        L56:
            if (r100.equals("ico") == false) goto L77;
            return "image/x-icon";
        L60:
            if (r100.equals("gif") == false) goto L77;
            return MimeType.GIF;
        L64:
            if (r100.equals("eot") == false) goto L77;
            return "application/vnd.ms-fontobject";
        L69:
            if (r100.equals(GXTemplateKey.GAIAX_CSS) == false) goto L77;
            return "text/css";
        L73:
            if (r100.equals(GXTemplateKey.GAIAX_JS) == false) goto L77;
            return "text/javascript";
        }
    }

    static {
        f202656m = new a();
        f202657n = new HashMap();
        f202658o = new HashMap();
    }

    public m0() {
        this.f202659k = "ttcjpay.prefetchRes";
        this.f202660l = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f202659k;
    }

    private final void delete(String r100) {
        HashMap<String, String> r101 = f202657n;
        String r102 = r101.get(r100);
        if (r102 == null) goto L8;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);
        if (r103.exists() == false) goto L7;
        r103.delete();
    L7:
        String r104 = r101.remove(r100);
    L8:
        f202658o.remove(r100);
    }

    public final String j(byte[] r110) {
        if (r110 != null) goto L6;
        ve4.a.f554342a.getClass();
        ALogService r111 = (ALogService) ve4.a.a(ALogService.class);
        if (r111 == null) goto L12;
        r111.e("ttcjpay.prefetchRes", "bytes is null");
    L12:
        return null;
    L6:
        int r100 = r110.length;
        if ((r100 + 0) > r110.length) goto L12;
        int r101 = r100 * 2;
        char[] r102 = new char[r101];
        int r103 = 0;
        int r104 = 0;
    L9:
        if (r103 >= r100) goto L15;
        int r105 = r110[r103 + 0] & UByte.MAX_VALUE;
        int r106 = r104 + 1;
        char[] r107 = this.f202660l;
        r102[r104] = r107[r105 >> 4];
        r104 = r106 + 1;
        r102[r106] = r107[r105 & 15];
        r103 = r103 + 1;
        goto L9
    L15:
        return new String(r102, 0, r101);
    }

    public static final /* synthetic */ void i(m0 r100, String r101) {
        r100.delete(r101);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.a, com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod
    public final void e(Context r100, JSONObject r110, IXPayBaseMethod.c r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        String r101 = r110.optString("action_type");
        JSONArray r102 = r110.optJSONArray(ScoreTags.STAR_URL_LIST);
        if (r102 != null) goto L55;
    L12:
        ArrayList r103 = null;
    L13:
        long r104 = r110.optLong("cache_time", 120000);
        if (Intrinsics.areEqual(r101, "fetch") == false) goto L41;
        if (r103 == null) goto L53;
        ArrayList r105 = new ArrayList();
        Iterator r112 = r103.iterator();
    L18:
        if (r112.hasNext() == false) goto L22;
        Object r106 = r112.next();
        if ((!StringsKt.isBlank((String) r106)) == false) goto L18;
        r105.add(r106);
        goto L18
    L22:
        Iterator r107 = r105.iterator();
    L24:
        if (r107.hasNext() == false) goto L53;
        String r113 = (String) r107.next();
        if (f202657n.get(r113) != null) goto L27;
        Uri r108 = UriProtector.parse(r113);
        f202656m.getClass();
        if (StringsKt.contains$default(a.b(r113), "image", false, 2, null) == true) goto L34;
        ve4.a.f554342a.getClass();
        TTNetService r109 = (TTNetService) ve4.a.a(TTNetService.class);
        if (r109 == null) goto L24;
        r109.getTTNet(r113, null, 5242880, new o0(this, r113, r104));
        goto L24
    L34:
        String r114 = r108.getScheme() + "://" + r108.getHost();
        ve4.a.f554342a.getClass();
        TTNetService r115 = (TTNetService) ve4.a.a(TTNetService.class);
        if (r115 == null) goto L24;
        r115.downloadFileTTNet(r114, r113, null, new n0(this, r113, r104));
        goto L24
    L27:
        HashMap<String, WebResourceResponse> r116 = f202658o;
        if (r116.get(r113) != null) goto L24;
        f202656m.getClass();
        WebResourceResponse r117 = a.a(r113);
        if (r117 == null) goto L24;
        r116.put(r113, r117);
    L53:
        r111.success(new LinkedHashMap());
        return;
    L41:
        if (Intrinsics.areEqual(r101, "clear") == false) goto L53;
        if (r103 == null) goto L53;
        ArrayList r118 = new ArrayList();
        Iterator r119 = r103.iterator();
    L45:
        if (r119.hasNext() == false) goto L49;
        Object r120 = r119.next();
        if ((!StringsKt.isBlank((String) r120)) == false) goto L45;
        r118.add(r120);
        goto L45
    L49:
        Iterator r121 = r118.iterator();
    L51:
        if (r121.hasNext() == false) goto L53;
        delete((String) r121.next());
        goto L51
    L55:
        r103 = new ArrayList();     // Catch: Exception -> L10
        int r122 = r102.length();     // Catch: Exception -> L10
        int r123 = 0;
    L5:
        if (r123 >= r122) goto L13;
        Object r124 = r102.opt(r123);     // Catch: Exception -> L10
        if ((r124 instanceof String) == false) goto L9;
        r103.add(r124);     // Catch: Exception -> L10
    L9:
        r123 = r123 + 1;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }
}
