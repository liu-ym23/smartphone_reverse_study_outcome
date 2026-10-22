package com.cmic.ida.sdk;

import android.net.Network;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.wschannel.WsConstants;
import com.cmic.ida.sdk.auth.IdaAuthnHelper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f273153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f273154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f273155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f273156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f273157e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f273158f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Network f273159g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f273160h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f273161i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final i0 f273162j;

    private void a() {
        this.f273154b.put(com.heytap.mcssdk.constant.b.C, IdaAuthnHelper.SDK_VERSION);
        this.f273154b.put("Content-Type", "application/json");
        this.f273154b.put("CMCC-EncryptType", "STD");
        this.f273154b.put("traceId", this.f273158f);
        this.f273154b.put("appId", this.f273161i);
        this.f273154b.put(WsConstants.KEY_CONNECTION, HTTP.KEEP_ALIVE);
    }

    public String b() {
        return this.f273155c;
    }

    public Map<String, String> c() {
        return this.f273154b;
    }

    public String d() {
        return this.f273156d;
    }

    public Network e() {
        return this.f273159g;
    }

    public i0 f() {
        return this.f273162j;
    }

    public long g() {
        return this.f273160h;
    }

    public String h() {
        return this.f273153a;
    }

    public void a(long r100) {
        this.f273160h = r100;
    }

    public m(String r100, i0 r101, String r102, String r110) {
        this(r100, null, r101, r102, r110);
    }

    private m(String r100, Map<String, String> r101, i0 r102, String r103, String r104) {
        this.f273157e = false;
        this.f273153a = r100;
        this.f273162j = r102;
        if (r101 != null) goto L5;
        r101 = new HashMap();
    L5:
        this.f273154b = r101;
        String r105 = "";
        if (r102 != null) goto L8;
        String r106 = "";
    L9:
        this.f273155c = r106;
        this.f273156d = r103;
        this.f273158f = r104;
        if (r102 == null) goto L13;
        r105 = r102.a();
    L13:
        this.f273161i = r105;
        r101.put("interfaceVersion", "1.0");
        a();
        return;
    L8:
        r106 = r102.b().toString();
        goto L9
    }
}
