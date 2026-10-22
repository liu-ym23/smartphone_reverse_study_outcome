package com.bytedance.bdinstall;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes6.dex */
public final class p implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f199754a;

    public p() {
        this.f199754a = new q();
    }

    @Override // com.bytedance.bdinstall.g0
    public final String get(String r100, Map<String, String> r101) throws Exception {
        this.f199754a.getClass();
        d84.a r102 = q.b(0, r100, (HashMap) r101, null);
        if (r102 != null) goto L5;
        return "";
    L5:
        return r102.f467399d;
    }

    @Override // com.bytedance.bdinstall.g0
    public final String post(String r100, byte[] r101, Map<String, String> r102) throws Exception {
        this.f199754a.getClass();
        d84.a r103 = q.b(1, r100, (HashMap) r102, r101);
        if (r103 != null) goto L5;
        return "";
    L5:
        return r103.f467399d;
    }

    @Override // com.bytedance.bdinstall.g0
    public final byte[] postStream(String r100, byte[] r101, Map<String, String> r102) throws RangersHttpException {
        this.f199754a.getClass();
        int r103 = t.f199790a;
        byte[] r104 = null;
        HttpURLConnection r105 = (HttpURLConnection) q.a(new URL(r100));     // Catch: Throwable -> L44
        r105.setDoOutput(true);     // Catch: Throwable -> L44
        r105.setRequestMethod(q.f199774a[1]);     // Catch: Throwable -> L44
        HashMap r106 = (HashMap) r102;     // Catch: Throwable -> L44
        if (r106.isEmpty() == true) goto L14;
        Iterator r107 = r106.entrySet().iterator();     // Catch: Throwable -> L44
    L7:
        if (r107.hasNext() == false) goto L14;
        Map.Entry r108 = (Map.Entry) r107.next();     // Catch: Throwable -> L44
        if (TextUtils.isEmpty((CharSequence) r108.getKey()) == true) goto L13;
        if (TextUtils.isEmpty((CharSequence) r108.getValue()) == true) goto L13;
        r105.addRequestProperty((String) r108.getKey(), (String) r108.getValue());     // Catch: Throwable -> L44
    L13:
        t.e(null);     // Catch: Throwable -> L44
    L14:
        r105.setRequestProperty("Accept-Encoding", DownloadHelper.GZIP);     // Catch: Throwable -> L44
        if (r101 != null) goto L17;
    L20:
        DataOutputStream r109 = null;
    L21:
        int r110 = r105.getResponseCode();     // Catch: Throwable -> L41
        if (r110 != 200) goto L40;
        InputStream r111 = r105.getInputStream();     // Catch: Throwable -> L41
        if (DownloadHelper.GZIP.equalsIgnoreCase(r105.getContentEncoding()) == true) goto L26;
    L62:
        ByteArrayOutputStream r112 = new ByteArrayOutputStream();     // Catch: Throwable -> L37
        byte[] r113 = new byte[1024];     // Catch: Throwable -> L35
    L30:
        int r114 = r111.read(r113);     // Catch: Throwable -> L35
        if (r114 == (-1)) goto L33;
        r112.write(r113, 0, r114);     // Catch: Throwable -> L35
        goto L30
    L33:
        r104 = r112.toByteArray();     // Catch: Throwable -> L35
    L48:
        c1.d(r109);
        c1.d(r111);
        c1.d(r112);
        return r104;
    L35:
        RangersHttpException th10 = th;
    L57:
        t.e(th10);     // Catch: Throwable -> L52
        if ((th10 instanceof RangersHttpException) == false) goto L48;
        throw th10;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        c1.d(r109);
        c1.d(r111);
        c1.d(r112);
        throw th;
    L37:
        th = move-exception;
        th10 = th;
    L43:
        r112 = null;
        goto L57
    L26:
        r111 = new GZIPInputStream(r111);     // Catch: Throwable -> L41
        goto L62
    L40:
        throw new RangersHttpException(r110, r105.getResponseMessage());     // Catch: Throwable -> L41
    L17:
        if (r101.length <= 0) goto L20;
        r109 = new DataOutputStream(r105.getOutputStream());     // Catch: Throwable -> L44
        r109.write(r101);     // Catch: Throwable -> L41
        r109.flush();     // Catch: Throwable -> L41
        r109.close();     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        th10 = th;
        r111 = null;
    L44:
        th = move-exception;
        th10 = th;
        r112 = null;
        r111 = null;
        r109 = null;
        goto L57
    }
}
