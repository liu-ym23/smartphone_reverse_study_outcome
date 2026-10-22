package com.cmic.sso.sdk.c.c;

import android.net.Network;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.wschannel.WsConstants;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.c.b.g;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f273439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f273440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, String> f273441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f273442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f273443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f273444f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Network f273445g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f273446h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f273447i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f273448j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final g f273449k;

    private void k() {
        this.f273441c.put(com.heytap.mcssdk.constant.b.C, AuthnHelper.SDK_VERSION);
        this.f273441c.put("Content-Type", "application/json");
        this.f273441c.put("CMCC-EncryptType", "STD");
        this.f273441c.put("traceId", this.f273444f);
        this.f273441c.put("appid", this.f273447i);
        this.f273441c.put(WsConstants.KEY_CONNECTION, HTTP.KEEP_ALIVE);
    }

    public boolean i() {
        int r100 = this.f273448j;
        this.f273448j = r100 + 1;
        if (r100 >= 2) goto L5;
        return true;
    L5:
        return false;
    }

    public String a() {
        return this.f273440b;
    }

    public boolean b() {
        return this.f273443e;
    }

    public Map<String, String> c() {
        return this.f273441c;
    }

    public String d() {
        return this.f273439a;
    }

    public String e() {
        return this.f273442d;
    }

    public String f() {
        return this.f273444f;
    }

    public Network g() {
        return this.f273445g;
    }

    public long h() {
        return this.f273446h;
    }

    public g j() {
        return this.f273449k;
    }

    public void a(long r100) {
        this.f273446h = r100;
    }

    public void a(Network r100) {
        this.f273445g = r100;
    }

    public void a(boolean r100) {
        this.f273443e = r100;
    }

    public void a(String r100, String r101) {
        this.f273441c.put(r100, r101);
    }

    public c(String r100, g r101, String r102, String r110) {
        this(r100, null, r101, r102, r110);
    }

    private c(String r100, Map<String, String> r101, g r102, String r103, String r104) {
        this.f273443e = false;
        this.f273440b = r100;
        this.f273449k = r102;
        if (r101 != null) goto L5;
        r101 = new HashMap();
    L5:
        this.f273441c = r101;
        String r105 = "";
        if (r102 != null) goto L8;
        String r106 = "";
    L9:
        this.f273439a = r106;
        this.f273442d = r103;
        this.f273444f = r104;
        if (r102 == null) goto L13;
        r105 = r102.a();
    L13:
        this.f273447i = r105;
        k();
        return;
    L8:
        r106 = r102.b().toString();
        goto L9
    }
}
