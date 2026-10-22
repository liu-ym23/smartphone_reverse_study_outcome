package com.bytedance.ee.bear.document.offline.file.upload;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.thread.BearExecutors;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.c1;
import com.ss.android.lark.vfs.VFSFile;
import io.reactivex.Flowable;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Dispatcher;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements i {
    public final Context a;
    public final com.bytedance.ee.bear.contract.d b;
    public final NetService c;
    public com.bytedance.ee.bear.contract.f d;
    public com.bytedance.ee.bear.contract.j e;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.a;
    }

    public static UploadResult c(String r3) {
        UploadResult r0 = new UploadResult();
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        JSONObject r4 = new JSONObject(r3);     // Catch: Exception -> L16
        r0.setCode(r4.optInt("code"));     // Catch: Exception -> L16
        r0.setMessage(r4.optString("msg"));     // Catch: Exception -> L16
        JSONObject r5 = r4.optJSONObject("data");     // Catch: Exception -> L16
        if (r5 == null) goto L18;
        String r6 = r5.optString("url");     // Catch: Exception -> L16
        r0.setUrl(r6);     // Catch: Exception -> L16
        r0.setFileToken(r6);     // Catch: Exception -> L16
        r0.setFile_key(r5.optString("file_key"));     // Catch: Exception -> L16
        r0.setCdn_url(r5.optString("cdn_url"));     // Catch: Exception -> L16
        r0.setDecrypt_key(r5.optString("decrypt_key"));     // Catch: Exception -> L16
        r0.setThumbnail_url(r5.optString("webp_thumbnail_cdn_url"));     // Catch: Exception -> L16
    L18:
        return r0;
    L16:
        e = move-exception;
        tt5.a.f("DocFileUploadHelper", e, false);
        goto L18
    L11:
        return new UploadResult();
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.document.offline.file.upload.i
    public final Flowable<UploadResult> a(String r1, i.a r2) {
        return Flowable.just(new UploadResult());
    }

    public e(Context r2, com.bytedance.ee.bear.contract.d r3, NetService r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "analyticService");
        Intrinsics.checkNotNullParameter(r4, "netService");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    @Override // com.bytedance.ee.bear.document.offline.file.upload.i
    public final Flowable<UploadResult> b(FileUploadModel r19, v r20, i.a r21) {
        Intrinsics.checkNotNullParameter(r19, "model");
        Intrinsics.checkNotNullParameter(r20, "uploadFileParams");
        Intrinsics.checkNotNullParameter(r21, "callback");
        if (r20.d == null) goto L67;
        if (r20.a == false) goto L7;
        VFSFile r1 = ay4.d.a().i(c1.c(this.a, UriProtector.parse(r20.b)));
    L8:
        String r10 = r19.getUrl();
        Map<String, String> r0 = r20.d;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r1, "file");
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r1, "file");
        if (this.e != null) goto L11;
        this.e = com.bytedance.ee.bear.contract.j.a.a;
    L11:
        com.bytedance.ee.bear.contract.j r2 = this.e;
        if (r2 == null) goto L16;
        boolean r4 = true;
        if (r2.getNetworkState().a() != true) goto L16;
    L18:
        if (r4 == true) goto L21;
        tt5.a.h("DocFileUploadHelper", "uploadFile()...net not connected");
        UploadResult r3 = new UploadResult();
    L65:
        return Flowable.just(r3);
    L21:
        if (StringsKt.isBlank(r10) == false) goto L24;
        tt5.a.h("DocFileUploadHelper", "uploadFile()...url is null");
        r3 = new UploadResult();
        goto L65
    L24:
        if (r1.exists() == true) goto L26;
    L63:
        tt5.a.h("DocFileUploadHelper", "uploadFile()...file illegal");
        r3 = new UploadResult();
        goto L65
    L26:
        if (r1.isFile() == false) goto L63;
        long r13 = SystemClock.uptimeMillis();
        long r16 = r1.length();
        okhttp3.k.a r5 = new okhttp3.k.a();
        r5.e(okhttp3.k.f);
        Iterator<Map.Entry<String, String>> r6 = r0.entrySet().iterator();
    L30:
        if (r6.hasNext() == false) goto L32;
        Map.Entry<String, String> r7 = r6.next();
        r5.a(r7.getKey(), r7.getValue());
        goto L30
    L32:
        r5.b("file", r1.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), r1));
        Request.Builder r8 = new Request.Builder().url("https://" + s45.p.u + s45.p.a().s0(r10)).post(r5.d());
        int r9 = com.bytedance.ee.larkwebview.util.h.a;
        Request r11 = r8.addHeader("User-Agent", com.bytedance.ee.larkwebview.util.h.a(this.a)).build();
        lr5.a r12 = lr5.b.b().b();
        TimeUnit r14 = TimeUnit.MINUTES;
        r12.a.writeTimeout(2, r14);
        r12.a.readTimeout(2, r14);
        r12.a.dispatcher(new Dispatcher(BearExecutors.d()));
        okhttp3.h r17 = new nv4.a();
        nv4.b.a r18 = nv4.b.a;
        if (r18 == null) goto L35;
        r17 = r18.a();
    L35:
        r12.a.cookieJar(r17);
        Response r22 = r12.a().newCall(r11).execute();     // Catch: Exception -> L52
        if (r22 == null) goto L48;
        ResponseBody r23 = r22.body();     // Catch: Exception -> L52
        Intrinsics.checkNotNull(r23);     // Catch: Exception -> L52
        String r24 = r23.string();     // Catch: Exception -> L52
        tt5.a.h("DocFileUploadHelper", " response == " + r22.code() + "    responseStr: " + r24);     // Catch: Exception -> L52
        if (r22.code() == 200) goto L41;
    L62:
        r3 = new UploadResult();
        goto L65
    L41:
        if (r22.isSuccessful() == false) goto L62;
        Intrinsics.checkNotNull(r24);     // Catch: Exception -> L52
        r3 = c(r24);     // Catch: Exception -> L52
        if (r3.getCode() != 0) goto L47;
        int r26 = r3.getCode();     // Catch: Exception -> L52
        String r27 = r3.getMessage();     // Catch: Exception -> L52
        Intrinsics.checkNotNull(r11);     // Catch: Exception -> L52
        d(r13, r26, r27, r10, r16);     // Catch: Exception -> L50
        goto L65
    L47:
        tt5.a.h("DocFileUploadHelper", " uploadResult == " + r3 + ".code");     // Catch: Exception -> L50
        goto L62
    L48:
        tt5.a.k("DocFileUploadHelper", " response == null");     // Catch: Exception -> L50
    L50:
        e = e;
    L54:
        tt5.a.f("DocFileUploadHelper", e, false);
        String r28 = e.toString();
        if ((e instanceof SocketTimeoutException) == false) goto L57;
    L60:
        int r29 = -2;
    L61:
        Intrinsics.checkNotNull(r11);
        d(r13, r29, r28, r10, r16);
        goto L62
    L57:
        if ((e instanceof ConnectException) == true) goto L60;
        r29 = -3;
    L52:
        e = e;
    L16:
        r4 = false;
        goto L18
    L7:
        r1 = ay4.d.a().i(r20.b);
        goto L8
    L67:
        return Flowable.just(new UploadResult());
    }

    public final void d(long r6, int r8, String r9, String r10, long r11) {
        HashMap r0 = new HashMap();
        r0.put("cost_time", String.valueOf(SystemClock.uptimeMillis() - r6));     // Catch: Exception -> L15
        r0.put("code", String.valueOf(r8));     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r10) == false) goto L8;
        r10 = "";
    L8:
        r0.put("url", r10);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r9) == false) goto L12;
        r9 = "";
    L12:
        r0.put("errorMsg", r9);     // Catch: Exception -> L15
        r0.put("docs_body_length", String.valueOf(r11));     // Catch: Exception -> L15
        r0.put("docs_net_retry_count", 0);     // Catch: Exception -> L15
        Boolean r12 = null;
        if (this.d != null) goto L17;
        this.d = (com.bytedance.ee.bear.contract.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.f.class, null, null, 6);     // Catch: Exception -> L15
    L17:
        com.bytedance.ee.bear.contract.f r7 = this.d;     // Catch: Exception -> L15
        if (r7 == null) goto L20;
        r12 = Boolean.valueOf(r7.a());     // Catch: Exception -> L15
    L20:
        r0.put("app_visible", String.valueOf(r12));     // Catch: Exception -> L15
        this.b.v("dev_performance_native_picture_upload", r0);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        tt5.a.f("DocFileUploadHelper", e, false);
    }
}
