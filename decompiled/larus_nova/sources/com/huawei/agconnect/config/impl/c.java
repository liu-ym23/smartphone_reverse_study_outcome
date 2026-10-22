package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.ConfigReader;
import com.huawei.agconnect.config.LazyInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class c extends AGConnectServicesConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f276708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f276709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LazyInputStream f276710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile ConfigReader f276711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f276712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AGCRoutePolicy f276713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<String, String> f276714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile e f276715h;

    public c(Context r100, String r101) {
        this.f276712e = new Object();
        this.f276713f = AGCRoutePolicy.UNKNOWN;
        this.f276714g = new HashMap();
        this.f276708a = r100;
        this.f276709b = r101;
    }

    private static LazyInputStream a(final Context r100, final InputStream r101) {
        return new AnonymousClass1(r100, r101);
    }

    private static String a(String r100) {
        int r101 = 0;
        if (r100.length() <= 0) goto L8;
    L5:
        if (r100.charAt(r101) != '/') goto L8;
        r101 = r101 + 1;
    L8:
        return HTTP.URL_DEFAULT + r100.substring(r101);
    }

    private void a() {
        if (this.f276711d != null) goto L19;
        Object r100 = this.f276712e;
        monitor-enter(r100);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (this.f276711d != null) goto L13;
        LazyInputStream r101 = this.f276710c;     // Catch: Throwable -> L16
        if (r101 == null) goto L11;
        this.f276711d = new i(r101.loadInputStream(), "UTF-8");     // Catch: Throwable -> L16
        this.f276710c.close();     // Catch: Throwable -> L16
        this.f276710c = null;     // Catch: Throwable -> L16
    L12:
        this.f276715h = new e(this.f276711d);     // Catch: Throwable -> L16
        goto L13
    L11:
        this.f276711d = new m(this.f276708a, this.f276709b);     // Catch: Throwable -> L16
    L13:
        b();     // Catch: Throwable -> L16
        monitor-exit(r100);     // Catch: Throwable -> L16
        return;
    }

    private String b(String r100) {
        Map<String, JsonProcessingFactory.JsonProcessor> r101 = JsonProcessingFactory.getProcessors();
        if (r101.containsKey(r100) == true) goto L5;
        return null;
    L5:
        JsonProcessingFactory.JsonProcessor r102 = r101.get(r100);
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.processOption(this);
    }

    private void b() {
        if (this.f276713f == AGCRoutePolicy.UNKNOWN) goto L5;
        return;
    L5:
        if (this.f276711d == null) goto L9;
        this.f276713f = Utils.getRoutePolicyFromJson(this.f276711d.getString("/region", null), this.f276711d.getString("/agcgw/url", null));
        return;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public boolean getBoolean(String r100) {
        return getBoolean(r100, false);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public boolean getBoolean(String r100, boolean r101) {
        return Boolean.parseBoolean(getString(r100, String.valueOf(r101)));
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public Context getContext() {
        return this.f276708a;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getIdentifier() {
        return Utils.DEFAULT_NAME;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public int getInt(String r100) {
        return getInt(r100, 0);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public int getInt(String r100, int r101) {
        return CastIntegerProtector.parseInt(getString(r100, String.valueOf(r101)));
    L4:
        return r101;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getPackageName() {
        return this.f276709b;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public AGCRoutePolicy getRoutePolicy() {
        if (this.f276713f != null) goto L5;
        this.f276713f = AGCRoutePolicy.UNKNOWN;
    L5:
        AGCRoutePolicy r100 = this.f276713f;
        AGCRoutePolicy r101 = AGCRoutePolicy.UNKNOWN;
        if (r100 == r101) goto L8;
    L10:
        AGCRoutePolicy r102 = this.f276713f;
        if (r102 != null) goto L14;
        return r101;
    L14:
        return r102;
    L8:
        if (this.f276711d != null) goto L10;
        a();
        goto L10
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String r100) {
        return getString(r100, null);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String r100, String r101) {
        if (r100 == null) goto L17;
        if (this.f276711d != null) goto L6;
        a();
    L6:
        String r102 = a(r100);
        String r103 = this.f276714g.get(r102);
        if (r103 == null) goto L9;
        return r103;
    L9:
        String r104 = b(r102);
        if (r104 == null) goto L12;
        return r104;
    L12:
        String r105 = this.f276711d.getString(r102, r101);
        if (e.a(r105) == true) goto L15;
        return r105;
    L15:
        return this.f276715h.decrypt(r105, r101);
    L17:
        throw new NullPointerException("path must not be null.");
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(LazyInputStream r100) {
        this.f276710c = r100;
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(InputStream r100) {
        overlayWith(a(this.f276708a, r100));
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void setParam(String r100, String r101) {
        this.f276714g.put(Utils.fixPath(r100), r101);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void setRoutePolicy(AGCRoutePolicy r100) {
        this.f276713f = r100;
    }
}
