package com.bytedance.vodsetting;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import com.ss.ttvideoengine.AppInfo;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f272557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f272558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f272559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f272560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f272561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f272562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f272563g;

    public class a implements f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f272564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f272565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f272566c;

        public final void a(JSONObject r100, Error r101) {
            if (r101 == null) goto L6;
            b.a(this.f272566c, this.f272564a, this.f272565b);
            return;
        L6:
            if (r100 != null) goto L9;
            e.a("Fetcher", "response is null or empty");
            b.a(this.f272566c, this.f272564a, this.f272565b);
            return;
        L9:
            b r102 = this.f272566c;
            System.currentTimeMillis();
            r102.getClass();
            if (this.f272566c.f272558b == false) goto L12;
            e.b("Fetcher", "fetch suc, fetch count = " + this.f272566c.f272562f + ", response = " + r100.toString());
        L12:
            JSONObject r103 = r100.optJSONObject("data");
            d r104 = this.f272566c.f272557a;
            if (r104 == null) goto L16;
            ((SettingsManager.b) r104).a(r100.optInt("code"), r100.optString("msg"), r103, this.f272564a, this.f272565b);
            return;
        }

        public a(b r100, String r101, String r102) {
            this.f272566c = r100;
            this.f272564a = r101;
            this.f272565b = r102;
        }
    }

    public b(SettingsManager.b r100) {
        this.f272558b = false;
        this.f272559c = 0;
        this.f272560d = 100;
        this.f272561e = 0;
        this.f272562f = 0;
        this.f272557a = r100;
    }

    public final void b(long r100) {
        if (r100 >= 1) goto L6;
        e.a("Fetcher", "set config version fail. version = " + r100);
        return;
    L6:
        this.f272559c = r100;
    }

    public final void c(String r100, String r110) {
        int r101 = this.f272560d;
        if (r101 > 0) goto L5;
    L8:
        long r102 = this.f272562f;
        if (r102 < Long.MAX_VALUE) goto L11;
        this.f272562f = 1;
    L12:
        e.b("Fetcher", "start to fetch, module = " + r100 + ", fetch count = " + this.f272562f);
        if (this.f272563g != null) goto L18;
        d r103 = this.f272557a;
        if (r103 == null) goto L62;
        ((SettingsManager.b) r103).a(-996, "netClient is null", null, null, null);
        return;
    L62:
        return;
    L18:
        String r104 = com.bytedance.vodsetting.a.f272554d;
        if (TextUtils.isEmpty(r104) == false) goto L21;
        e.a("ConfigEnv", "region is null");
        String r105 = null;
    L32:
        if (TextUtils.isEmpty(r105) == false) goto L37;
        e.a("Fetcher", "get host is null");
        d r106 = this.f272557a;
        if (r106 == null) goto L63;
        ((SettingsManager.b) r106).a(-998, "host is null", null, null, null);
        return;
    L63:
        return;
    L37:
        this.f272561e++;
        HashMap r107 = new HashMap();
        r107.put(Constant.KEY_CALL_NAME, "VideoCloud");
        r107.put("device_platform", "android");
        r107.put("os_version", Build.VERSION.RELEASE);
        r107.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        r107.put("config_version", "" + this.f272559c);
        if (r107.containsKey("device_brand") == true) goto L41;
        r107.put("device_brand", Build.BRAND);
    L41:
        if (r107.containsKey("device_type") == true) goto L44;
        r107.put("device_type", Build.MODEL.toLowerCase());
    L44:
        if (TextUtils.isEmpty(r100) == true) goto L49;
        if (r100.equals("all") == true) goto L49;
        r107.put(EventConstant.Key.MODULE, r100);
    L49:
        if (this.f272558b == false) goto L52;
        r107.put("debug", "1");
    L52:
        if (TextUtils.isEmpty(r110) == true) goto L55;
        r107.put("config_key", r110);
    L55:
        if (com.bytedance.vodsetting.a.a(com.bytedance.vodsetting.a.f272555e) == null) goto L58;
        r107.putAll(com.bytedance.vodsetting.a.a(com.bytedance.vodsetting.a.f272555e));
    L58:
        if (com.bytedance.vodsetting.a.a(com.bytedance.vodsetting.a.f272556f) == null) goto L60;
        r107.putAll(com.bytedance.vodsetting.a.a(com.bytedance.vodsetting.a.f272556f));
    L60:
        e.b("Fetcher", "param = " + r107.toString());
        this.f272563g.start("https://" + r105 + "/vod/settings/v1", r107, new a(this, r100, r110));
        return;
    L21:
        String r108 = com.bytedance.vodsetting.a.f272553c;
        if (r104.equals("us-east-1") == false) goto L25;
        r105 = com.bytedance.vodsetting.a.f272551a;
        goto L32
    L25:
        if (r104.equals("ap-singapore-1") == false) goto L28;
        r105 = com.bytedance.vodsetting.a.f272552b;
        goto L32
    L28:
        if (r104.equals(AppInfo.APP_REGION_CN) == false) goto L30;
        r105 = com.bytedance.vodsetting.a.f272553c;
        goto L32
    L30:
        r105 = r108;
        goto L32
    L11:
        this.f272562f = r102 + 1;
        goto L12
    L5:
        if (this.f272562f <= r101) goto L8;
        e.b("Fetcher", "fetch reach max count, maxFetchTimes = " + this.f272560d);
    }

    public static void a(b r100, String r101, String r102) {
        r100.getClass();
        e.b("Fetcher", "retry fetch, count = " + r100.f272562f);
        if (r100.f272561e <= 10) goto L8;
        e.b("Fetcher", "fetch fail, module = " + r101 + ", retry times = " + r100.f272561e);
        d r103 = r100.f272557a;
        if (r103 == null) goto L7;
        ((SettingsManager.b) r103).a(-999, "fetch fail. try times = " + r100.f272561e + ", max = 10", null, null, null);
    L7:
        r100.f272561e = 0;
        return;
    L8:
        new PthreadTimer("tting/Fetcher").schedule(new c(r100, r101, r102), 5000);
    }
}
