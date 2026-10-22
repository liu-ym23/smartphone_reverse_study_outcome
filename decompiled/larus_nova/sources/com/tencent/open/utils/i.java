package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, i> f461848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f461849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f461850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f461851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f461852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f461853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f461854g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f461855h;

    static {
        f461848a = Collections.synchronizedMap(new HashMap());
        f461849b = null;
    }

    private void a() {
        this.f461852e = new JSONObject(c("com.tencent.open.config.json"));     // Catch: JSONException -> L5
        return;
    L5:
        this.f461852e = new JSONObject();
    }

    private void b() {
        if (this.f461854g == 0) goto L6;
        d("update thread is running, return");
        return;
    L6:
        this.f461854g = 1;
        final HashMap r100 = new HashMap();
        r100.put("appid", this.f461851d);
        r100.put("status_os", Build.VERSION.RELEASE);
        r100.put("status_machine", f.a().c(g.a()));
        r100.put("status_version", Build.VERSION.SDK);
        r100.put("sdkv", Constants.SDK_VERSION);
        r100.put("sdkp", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        l.a(new AnonymousClass1(this, r100));
    }

    private void c() {
        int r100 = this.f461852e.optInt("Common_frequency");
        if (r100 != 0) goto L6;
        r100 = 1;
    L6:
        if ((SystemClock.elapsedRealtime() - this.f461853f) < (r100 * BaseConstants.Time.HOUR)) goto L9;
        b();
        return;
    }

    private String c(String r100) {
        String r101 = "";
    L9:
        InputStream r102 = this.f461850c.getAssets().open(r100);     // Catch: IOException -> L30
    L10:
        BufferedReader r103 = new BufferedReader(new InputStreamReader(r102, Charset.forName("UTF-8")));
        StringBuffer r104 = new StringBuffer();
    L33:
        String r105 = r103.readLine();     // Catch: Throwable -> L19 IOException -> L21
        if (r105 == null) goto L14;
        r104.append(r105);     // Catch: Throwable -> L19 IOException -> L21
        goto L33
    L14:
        r101 = r104.toString();     // Catch: Throwable -> L19 IOException -> L21
        r102.close();     // Catch: IOException -> L17
        r103.close();     // Catch: IOException -> L17
    L24:
        return r101;
    L17:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
        r102.close();     // Catch: IOException -> L17
        r103.close();     // Catch: IOException -> L17
    L19:
        th = move-exception;
        r102.close();     // Catch: IOException -> L27
        r103.close();     // Catch: IOException -> L27
    L29:
        throw th;
    L27:
        e = move-exception;
        e.printStackTrace();
    L30:
        e = move-exception;
        e.printStackTrace();
        return "";
    L4:
        if (this.f461851d == null) goto L6;
        String r106 = r100 + "." + this.f461851d;     // Catch: FileNotFoundException -> L9
    L7:
        r102 = this.f461850c.openFileInput(r106);     // Catch: FileNotFoundException -> L9
        goto L10
    L6:
        r106 = r100;
        goto L7
    }

    private void d(String r100) {
        if (this.f461855h == false) goto L6;
        SLog.v("openSDK_LOG.OpenConfig", r100 + "; appid: " + this.f461851d);
        return;
    }

    public int a(String r100) {
        d("get " + r100);
        c();
        return this.f461852e.optInt(r100);
    }

    public boolean b(String r100) {
        d("get " + r100);
        c();
        Object r101 = this.f461852e.opt(r100);
        if (r101 != null) goto L6;
        return false;
    L6:
        if ((r101 instanceof Integer) == false) goto L10;
        return !r101.equals(0);
    L10:
        if ((r101 instanceof Boolean) == true) goto L12;
        return false;
    L12:
        return ((Boolean) r101).booleanValue();
    }

    private void a(JSONObject r100) {
        d("cgi back, do update");
        this.f461852e = r100;
        a("com.tencent.open.config.json", r100.toString());
        this.f461853f = SystemClock.elapsedRealtime();
    }

    private i(Context r100, String r101) {
        this.f461850c = null;
        this.f461851d = null;
        this.f461852e = null;
        this.f461853f = 0;
        this.f461854g = 0;
        this.f461855h = true;
        this.f461850c = r100.getApplicationContext();
        this.f461851d = r101;
        a();
        b();
    }

    private void a(String r100, String r101) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.f461851d == null) goto L5;
        r100 = r100 + "." + this.f461851d;     // Catch: IOException -> L7
    L5:
        OutputStreamWriter r102 = new OutputStreamWriter(this.f461850c.openFileOutput(r100, 0), Charset.forName("UTF-8"));     // Catch: IOException -> L7
        r102.write(r101);     // Catch: IOException -> L7
        r102.flush();     // Catch: IOException -> L7
        r102.close();     // Catch: IOException -> L7
    }

    public static i a(Context r100, String r101) {
        Map<String, i> r102 = f461848a;
        monitor-enter(r102);
        SLog.v("openSDK_LOG.OpenConfig", "getInstance begin");     // Catch: Throwable -> L18
        if (r101 == null) goto L7;
        f461849b = r101;     // Catch: Throwable -> L18
    L7:
        if (r101 != null) goto L12;
        r101 = f461849b;     // Catch: Throwable -> L18
        if (r101 != null) goto L12;
        r101 = "0";
    L12:
        i r103 = f461848a.get(r101);     // Catch: Throwable -> L18
        if (r103 != null) goto L15;
        r103 = new i(r100, r101);     // Catch: Throwable -> L18
        f461848a.put(r101, r103);     // Catch: Throwable -> L18
    L15:
        SLog.v("openSDK_LOG.OpenConfig", "getInstance end");     // Catch: Throwable -> L18
        monitor-exit(r102);     // Catch: Throwable -> L18
        return r103;
    L18:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void a(i r100, JSONObject r101) {
        r100.a(r101);
    }

    public static /* synthetic */ int a(i r100, int r101) {
        r100.f461854g = r101;
        return r101;
    }
}
