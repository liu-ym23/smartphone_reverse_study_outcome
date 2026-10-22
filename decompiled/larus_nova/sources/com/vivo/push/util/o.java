package com.vivo.push.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class o extends PthreadAsyncTask<String, Void, List<Bitmap>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f462596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InsideNotificationItem f462597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f462598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f462599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f462600e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private NotifyArriveCallbackByUser f462601f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.vivo.push.h.u.a f462602g;

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_vivo_push_util_o_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    private List<Bitmap> a(String... r110) {
        this.f462600e = this.f462597b.getNotifyDisplayStatus();
        InputStream r100 = null;
        if (this.f462599d == true) goto L6;
        t.d("ImageDownTask", "bitmap is not display by forbid net");
        return null;
    L6:
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L8:
        if (r102 >= 2) goto L41;
        String r103 = r110[r102];
        t.d("ImageDownTask", "imgUrl=" + r103 + " i=" + r102);
        if (TextUtils.isEmpty(r103) == false) goto L55;
        if (r102 != 0) goto L40;
        r101.add(null);
    L40:
        r102 = r102 + 1;
        goto L8
    L55:
        HttpURLConnection r104 = (HttpURLConnection) INVOKEVIRTUAL_com_vivo_push_util_o_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r103));     // Catch: Throwable -> L20 IOException -> L22 MalformedURLException -> L27
        r104.setConnectTimeout(30000);     // Catch: Throwable -> L20 IOException -> L22 MalformedURLException -> L27
        r104.setDoInput(true);     // Catch: Throwable -> L20 IOException -> L22 MalformedURLException -> L27
        r104.setUseCaches(false);     // Catch: Throwable -> L20 IOException -> L22 MalformedURLException -> L27
        r104.connect();     // Catch: Throwable -> L20 IOException -> L22 MalformedURLException -> L27
        int r105 = r104.getResponseCode();     // Catch: Throwable -> L20 IOException -> L22 MalformedURLException -> L27
        t.c("ImageDownTask", "code=".concat(String.valueOf(r105)));     // Catch: Throwable -> L20 IOException -> L22 MalformedURLException -> L27
        if (r105 != 200) goto L16;
        InputStream r106 = r104.getInputStream();     // Catch: Throwable -> L20 IOException -> L22 MalformedURLException -> L27
        Bitmap r107 = BitmapFactory.decodeStream(r106);     // Catch: IOException -> L43 MalformedURLException -> L45 Throwable -> L33
    L17:
        if (r106 != null) goto L47;
    L32:
        r101.add(r107);
        goto L40
    L47:
        r106.close();     // Catch: Exception -> L42
        goto L32
    L33:
        th = th;
        r100 = r106;
    L35:
        if (r100 != null) goto L53;
    L37:
        throw th;
    L53:
        r100.close();     // Catch: Exception -> L46
    L28:
        t.a("ImageDownTask", "MalformedURLException");     // Catch: Throwable -> L33
        if (r106 != null) goto L49;
    L31:
        r107 = null;
    L49:
        r106.close();     // Catch: Exception -> L44
    L23:
        t.a("ImageDownTask", "IOException");     // Catch: Throwable -> L33
        if (r106 == null) goto L31;
    L16:
        r106 = null;
        r107 = null;
    L27:
        r106 = null;
    L22:
        r106 = null;
    L20:
        th = th;
        goto L35
    L41:
        return r101;
    }

    public static /* synthetic */ long b(o r100) {
        return r100.f462598c;
    }

    public static /* synthetic */ Context c(o r100) {
        return r100.f462596a;
    }

    public static /* synthetic */ int d(o r100) {
        return r100.f462600e;
    }

    public static /* synthetic */ NotifyArriveCallbackByUser e(o r100) {
        return r100.f462601f;
    }

    public static /* synthetic */ com.vivo.push.h.u.a f(o r100) {
        return r100.f462602g;
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ Object doInBackground(Object[] r100) {
        return a((String[]) r100);
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(Object r100) {
        List r101 = (List) r100;
        super.onPostExecute(r101);
        t.c("ImageDownTask", "onPostExecute");
        com.vivo.push.t.b(new p(this, r101));
    }

    public static /* synthetic */ InsideNotificationItem a(o r100) {
        return r100.f462597b;
    }

    public o(Context r100, InsideNotificationItem r101, long r102, boolean r103, com.vivo.push.h.w r104, NotifyArriveCallbackByUser r105) {
        this.f462600e = 0;
        this.f462596a = r100;
        this.f462597b = r101;
        this.f462598c = r102;
        this.f462599d = r103;
        this.f462602g = r104;
        this.f462601f = r105;
    }
}
