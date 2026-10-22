package com.bytedance.ee.bear.document.plugin.offline;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.document.offline.drive.DriveCompressCheckerV2;
import com.bytedance.ee.bear.f;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import d25.d;
import e0c.k;
import j25.q;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import k25.e0;
import s45.p;
import yu5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements a {
    public final DriveCompressCheckerV2 a;
    public final Context b;
    public LazyHeaders c;
    public final h0 d;
    public final b0 e;
    public final String f;

    public b(Context r2) {
        this.b = r2;
        this.a = new DriveCompressCheckerV2(r2);
        this.d = (h0) org.koin.java.a.a(h0.class);
        b0 r3 = (b0) org.koin.java.a.a(b0.class);
        this.e = r3;
        this.f = r3.w();
    }

    public static Pair d(VFSPath r7) {
        Pair r0 = new Pair(null, new Pair(DiagramData$RESULT.FAIL, -1L));
        if (r7 != null) goto L5;
        return r0;
    L5:
        if (r7.toFile().exists() == false) goto L15;
        return new Pair(r7.toFile().newInputStream(), new Pair(DiagramData$RESULT.FAIL, Long.valueOf(r7.toFile().length())));
    L9:
        tt5.a.d("ImageResourceInterceptor", "File not found");
        return r0;
    L15:
        return r0;
    }

    public final void e(Map<String, String> r5) {
        AccountService$Account r0 = this.d.U5();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hasLogin() == false) goto L19;
        LazyHeaders.Builder r1 = new LazyHeaders.Builder();
        if (r5 != null) goto L9;
    L14:
        tt5.a.k("ImageResourceInterceptor", "initHeaders: headers is null");
    L15:
        this.c = r1.build();
        return;
    L9:
        if (r5.size() <= 0) goto L14;
        Iterator<String> r2 = r5.keySet().iterator();
    L12:
        if (r2.hasNext() == false) goto L15;
        String r3 = r2.next();
        r1.addHeader(r3, r5.get(r3));
        goto L12
    }

    public final boolean h(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(this.f) == true) goto L14;
        if (r4.endsWith(this.f) == false) goto L14;
        int r0 = (r4.length() - this.f.length()) - 1;
        if (r0 < 0) goto L14;
        if (r4.charAt(r0) != '.') goto L14;
        return true;
    }

    public static WebResourceResponse f(String r3, InputStream r4, Map r5) {
        if (r4 != null) goto L20;
    L13:
        if (r4 != null) goto L15;
        tt5.a.k("ImageResourceInterceptor", "WebResourceResponse input is null.");     // Catch: IOException -> L17
        return null;
    L15:
        tt5.a.k("ImageResourceInterceptor", "WebResourceResponse input is not available.");     // Catch: IOException -> L17
        return null;
    L20:
    L17:
        tt5.a.d("ImageResourceInterceptor", "  internalGetImageResponse(): ");
        return null;
    L5:
        if (r4.available() <= 0) goto L13;
        WebResourceResponse r1 = new WebResourceResponse(r3, n25.b.a, r4);     // Catch: IOException -> L17
        if (r5 != null) goto L9;
    L11:
        r1.setResponseHeaders(r5);     // Catch: IOException -> L17
        return r1;
    L9:
        if (r5.containsKey("Origin") == false) goto L11;
        r5.put("access-control-allow-credentials", "true");     // Catch: IOException -> L17
        r5.put("access-control-allow-methods", "POST, GET, OPTIONS, PUT, DELETE");     // Catch: IOException -> L17
        r5.put("access-control-allow-origin", (String) r5.get("Origin"));     // Catch: IOException -> L17
        goto L11
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:174:0x03b5 -> B:175:0x03b9). Please report as a decompilation issue!!! */
    @Override // com.bytedance.ee.bear.document.plugin.offline.a
    public final WebResourceResponse a(String r18, String r19, Map<String, String> r20) {
        InputStream r4 = null;
        if ("options".equalsIgnoreCase(r19) == false) goto L5;
        return null;
    L5:
        long r6 = SystemClock.uptimeMillis();
        boolean r5 = true;
        if (TextUtils.isEmpty(r18) == false) goto L188;
    L19:
        boolean r0 = false;
    L20:
        String r10 = "";
        if (r0 == false) goto L67;
        String r13 = d.g;
        Pair<Boolean, Integer> r1 = this.a.a(r18);
        boolean r7 = ((Boolean) r1.first).booleanValue();
        if (r7 == false) goto L25;
        DownloadRequestInfo.DownloadType r9 = DownloadRequestInfo.DownloadType.COVER;
    L26:
        if (r7 == false) goto L28;
        int r2 = ((Integer) r1.second).intValue();
    L29:
        int r12 = r2;
        Uri r3 = UriProtector.parse(r18);
        if (r3 == null) goto L36;
        q r8 = e0.m().y(r3.getLastPathSegment());
        if (r8 == null) goto L36;
        if (TextUtils.isEmpty(r8.f) == true) goto L36;
        VFSFile r11 = ay4.d.a().i(r8.d);
    L37:
        if (r11 != null) goto L39;
    L49:
        r9 = r9;
    L50:
        String r14 = d.d;
        w85.a.C0319a r16 = new w85.a.C0319a();
        r16.d = r18;
        r16.b = r9;
        r16.k = new DownloadRequestInfo.b(r12, r12);
        Pattern r17 = c.a;
        if (r14 == null) goto L54;
        r10 = r14;
    L54:
        r16.h = r10;
        r16.i = d.f;
        r16.g = ((f) org.koin.java.a.a(f.class)).d(d.g);
        w85.b r21 = ((w85.c) org.koin.java.a.a(w85.c.class)).d(new w85.a(r16));
        if (r21 != null) goto L57;
    L58:
        tt5.a.k("ImageResourceInterceptor", "internalGetDriveImageInputStream() downloadImageFile failed!");
    L59:
        if (r21 == null) goto L65;
        WebResourceResponse r22 = f("image/*", r21.a, r20);
        if (r22 == null) goto L63;
        e25.a.b(r21.c, r6, r21.d, r21.e, "customSchemeDrive", r12, r13);
    L64:
        return r22;
    L63:
        e25.a.a(r6, r21.e, "customSchemeDrive", r12, r13, "null_web_response");
        goto L64
    L65:
        e25.a.a(r6, -1, "customSchemeDrive", r12, r13, "failure");
        return null;
    L57:
        if (r21.e == 0) goto L59;
    L39:
        if (r11.exists() == false) goto L49;
        r21 = new w85.b(r11.newInputStream(), r11, r11.length());     // Catch: Exception -> L44
    L44:
        e = e;
    L48:
        tt5.a.e("ImageResourceInterceptor", "internalGetDriveImageInputStream() FileNotFoundException", e, false);
    L46:
        e = e;
    L36:
        r11 = null;
        goto L37
    L28:
        r2 = DriveCompressCheckerV2.CoverSize.ORIGINAL.size;
        goto L29
    L25:
        r9 = DownloadRequestInfo.DownloadType.IMG;
        goto L26
    L67:
        if (TextUtils.isEmpty(r18) == false) goto L179;
    L77:
        boolean r23 = false;
    L79:
        if (r23 == false) goto L89;
        if (h(UriProtector.parse(r18).getHost()) == false) goto L195;
        String r24 = d.g;
        Pair<InputStream, Pair<String, Long>> r26 = g(r18, r18, p.a().s0(UriProtector.parse(c.h(r18)).getPath()), r20);     // Catch: Exception -> L85
    L87:
        return c(r18, r20, r6, r26, r24);
    L85:
        tt5.a.d("ImageResourceInterceptor", "internalGetDriveCoverImageStream Exception e");
        r26 = new Pair(null, new Pair(DiagramData$RESULT.FAIL, -1L));
        goto L87
    L195:
        return null;
    L89:
        if (TextUtils.isEmpty(r18) == false) goto L91;
    L93:
        boolean r27 = false;
    L94:
        if (r27 == false) goto L119;
        int r28 = b35.a.a;
        Context r29 = this.b;
        q r30 = e0.m().x(c.h(r18));
        if (r30 == null) goto L98;
        r10 = r30.d;
        String r31 = r30.e;
    L99:
        tt5.a.b("BaseResourceInterceptor", "path = " + r10 + "---uri = " + r31);
    L114:
        e = move-exception;
        tt5.a.d("BaseResourceInterceptor", "internalGetLocalImageStream: " + e);
    L117:
        return f(d.c(r18), r4, r20);
    L101:
        if (TextUtils.isEmpty(r10) == true) goto L103;
    L106:
        InputStream r32 = (InputStream) b35.a.a(r29, r10, r31).first;     // Catch: IOException -> L114
        if (r32 != null) goto L109;
        tt5.a.k("BaseResourceInterceptor", "internalGetLocalImageStream()... end  inputStream is null ");     // Catch: IOException -> L114
    L181:
        goto L117
    L109:
        if (r32.available() <= 0) goto L111;
        r4 = r32;
        goto L181
    L111:
        r32.close();     // Catch: IOException -> L114
        goto L181
    L103:
        if (TextUtils.isEmpty(r31) == false) goto L106;
        tt5.a.h("BaseResourceInterceptor", "internalGetLocalImageStream()... end  cannot find fileModel by ");     // Catch: IOException -> L114
        goto L181
    L98:
        r31 = "";
        goto L99
    L119:
        if (TextUtils.isEmpty(r18) == false) goto L121;
    L127:
        boolean r33 = false;
    L128:
        if (r33 == false) goto L149;
        if (h(UriProtector.parse(r18).getHost()) == false) goto L196;
        String r34 = d.g;
        com.bytedance.ee.bear.appsetting.c r36 = com.bytedance.ee.bear.appsetting.c.a.a;     // Catch: Exception -> L143
        Application r37 = LarkContext.getApplication();     // Catch: Exception -> L143
        r36.getClass();     // Catch: Exception -> L143
        boolean r38 = ((dn4.a) k.b(((v) k.a(r37, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r37, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isEnable("ccm.docx.chart_ssr_mobile");     // Catch: Exception -> L143
        Uri r39 = UriProtector.parse(r18);     // Catch: Exception -> L143
        if (r38 == true) goto L135;
        String r110 = c.h(r18);     // Catch: Exception -> L143
    L136:
        String r40 = r39.getScheme() + "://" + p.u + p.a().s0(UriProtector.parse(r110).getPath());     // Catch: Exception -> L143
        if (r38 == false) goto L141;
        r40 = r40 + "?" + r39.getEncodedQuery();     // Catch: Exception -> L143
        if (TextUtils.equals(UriProtector.getQueryParameter(r39, "notIntercept"), "true") == false) goto L141;
        Pair<InputStream, Pair<String, Long>> r41 = new Pair(null, new Pair(DiagramData$RESULT.FAIL, -1L));     // Catch: Exception -> L143
    L144:
        Pair<InputStream, Pair<String, Long>> r42 = r41;
    L146:
        return c(r18, r20, r6, r42, r34);
    L141:
        r42 = g(r110, r40, r110, r20);     // Catch: Exception -> L143
        goto L146
    L135:
        r110 = r18;
    L143:
        tt5.a.d("ImageResourceInterceptor", "internalGetNetImageStream Exception e");
        r41 = new Pair(null, new Pair(DiagramData$RESULT.FAIL, -1L));
        goto L144
    L196:
        return null;
    L149:
        if (TextUtils.isEmpty(r18) == false) goto L151;
    L160:
        r5 = false;
    L161:
        if (r5 == false) goto L197;
        q r43 = e0.m().y(r18);
        if (r43 != null) goto L190;
    L175:
        InputStream r44 = null;
    L176:
        return f(r18, r44, r20);
    L173:
        e = move-exception;
        tt5.a.f("ImageResourceInterceptor", e, false);
        goto L175
    L190:
        if (TextUtils.isEmpty(r43.d) == true) goto L170;
        VFSFile r46 = ay4.d.a().i(r43.d);     // Catch: Exception -> L173
        if (r46.exists() == false) goto L175;
        r44 = r46.newInputStream();     // Catch: Exception -> L173
        goto L176
    L170:
        if (TextUtils.isEmpty(r43.e) == true) goto L175;
        r44 = ContentResolverWrapper.openInputStream(this.b.getContentResolver(), UriProtector.parse(r43.e));     // Catch: Exception -> L173
        goto L176
    L197:
        return null;
    L151:
        if (r18.contains("/obj/creation-image-system/") == false) goto L160;
        int r47 = r18.lastIndexOf("/");
        if (r47 < 0) goto L157;
        int r48 = r47 + 1;
        if (r48 > r18.length()) goto L157;
        boolean r49 = r18.substring(r48).startsWith("cover-");
    L158:
        if (r49 == false) goto L160;
    L157:
        r49 = false;
        goto L158
    L121:
        if (p.a().v6(r18) == false) goto L127;
        if (r18.contains("/file/f") == false) goto L125;
    L126:
        r33 = true;
        goto L128
    L125:
        if (r18.contains("//file/f") == false) goto L127;
    L91:
        if (r18.startsWith("docsource://com.bytedance.net/file/f/") == false) goto L93;
        r27 = true;
        goto L94
    L179:
        Uri r50 = UriProtector.parse(r18);     // Catch: Exception -> L75
        if (r50 == null) goto L77;
        String r51 = r50.getPath();     // Catch: Exception -> L75
        if (r51 == null) goto L77;
        if (r51.contains("/api/box/stream/download/v2/cover/") == false) goto L77;
        r23 = true;
    L75:
        e = move-exception;
        tt5.a.f("Doc_ImageUtil", e, false);
        goto L77
    L188:
        Uri r52 = UriProtector.parse(r18);     // Catch: Exception -> L17
        if (r52 == null) goto L19;
        if ("image".equalsIgnoreCase(UriProtector.getQueryParameter(r52, "type")) == true) goto L16;
        String r53 = r52.getPath();     // Catch: Exception -> L17
        if (r53 == null) goto L19;
        if (r53.contains("/api/box/stream/download/all/") == false) goto L19;
    L16:
        r0 = true;
    L17:
        e = move-exception;
        tt5.a.f("Doc_ImageUtil", e, false);
        goto L19
    }

    public final VFSPath b(String r5, String r6, String r7, Map<String, String> r8) {
        e(r8);     // Catch: Exception -> L13
        VFSPath r9 = ay4.d.a().t((File) Glide.with(this.b).load(new BearGlideUrl(r6, this.c)).downloadOnly(ShareItemModel.SRC_TINT_UNDEFINED, ShareItemModel.SRC_TINT_UNDEFINED).get());     // Catch: Exception -> L13
        if (com.bytedance.ee.util.io.b.c(r9) == false) goto L11;
        q r10 = new q();     // Catch: Exception -> L13
        r10.a = r9.getName() + OfflineDoc.DASH_DELIMITER + System.currentTimeMillis();     // Catch: Exception -> L13
        String r1 = d.d;     // Catch: Exception -> L13
        if (r1 == null) goto L8;
        r10.b = r1;     // Catch: Exception -> L13
        r10.c = r1;     // Catch: Exception -> L13
    L9:
        r10.d = e0.D(r9.getRealPath());     // Catch: Exception -> L13
        r10.h = Long.valueOf(FileUtils.v(r9));     // Catch: Exception -> L13
        r10.g = r7;     // Catch: Exception -> L13
        e0.m().u(r10);     // Catch: Exception -> L13
        return r9;
    L8:
        r10.b = r5;     // Catch: Exception -> L13
        r10.c = r5;     // Catch: Exception -> L13
        goto L9
    L11:
        tt5.a.k("ImageResourceInterceptor", "internalGetNetImageStream isImage not: ");     // Catch: Exception -> L13
        return null;
    L13:
        e = move-exception;
        tt5.a.e("ImageResourceInterceptor", "internalGetNetImageStream: downloadImage failed", e, false);
        return null;
    }

    public final Pair<InputStream, Pair<String, Long>> g(String r7, String r8, String r9, Map<String, String> r10) {
        e0 r3 = e0.m();     // Catch: IOException -> L24
        r3.getClass();     // Catch: IOException -> L24
        q r4 = ((j25.p) r3.q().d()).g(r9);     // Catch: Exception -> L6
        e0.a(r4);     // Catch: Exception -> L6
    L8:
        tt5.a.h("ImageResourceInterceptor", "internalGetNetImageStream()... end url = , path =" + r4);     // Catch: IOException -> L24
        if (r4 == null) goto L23;
        if (TextUtils.isEmpty(r4.d) == true) goto L23;
        int r2 = b35.a.a;     // Catch: IOException -> L24
        Pair r5 = b35.a.a(this.b, r4.d, r4.e);     // Catch: IOException -> L24
        InputStream r6 = (InputStream) r5.first;     // Catch: IOException -> L24
        if (r6 != null) goto L15;
    L18:
        if (r6 == null) goto L20;
        r6.close();     // Catch: IOException -> L24
    L20:
        tt5.a.h("ImageResourceInterceptor", "internalGetNetImageStream()... local file not valid, re-download it, path =" + r4);     // Catch: IOException -> L24
        return d(b(r7, r8, r9, r10));
    L15:
        if (r6.available() <= 0) goto L18;
        return new Pair(r6, new Pair(DiagramData$RESULT.SUCCESS, (Long) r5.second));
    L23:
        return d(b(r7, r8, r9, r10));
    L6:
        e = move-exception;
        iu5.d.c(e);     // Catch: IOException -> L24
        r4 = new q();     // Catch: IOException -> L24
    L24:
        tt5.a.d("ImageResourceInterceptor", "IOException e");
        return new Pair(null, new Pair(DiagramData$RESULT.FAIL, -1L));
    }

    public static WebResourceResponse c(String r18, Map r19, long r20, Pair r22, String r23) {
        InputStream r1 = (InputStream) r22.first;
        if (r1 == null) goto L10;
        WebResourceResponse r2 = f(d.c(r18), r1, r19);
        Pair r0 = (Pair) r22.second;
        if (r0 == null) goto L8;
        if (r2 == null) goto L8;
        e25.a.b((String) r0.first, r20, ((Long) r0.second).longValue(), 0, "customSchemeDocs", -1, r23);
    L9:
        return r2;
    L8:
        e25.a.a(r20, -1, "customSchemeDocs", -1, r23, "null_web_response");
        goto L9
    L10:
        e25.a.a(r20, -1, "customSchemeDocs", -1, r23, "failure");
        return null;
    }
}
