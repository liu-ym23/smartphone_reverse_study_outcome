package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.ConfigReader;
import com.huawei.agconnect.core.Service;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b implements AGConnectOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f276699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f276700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f276701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AGCRoutePolicy f276702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConfigReader f276703e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e f276704f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<String, String> f276705g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<Service> f276706h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, String> f276707i;

    public b(Context r100, String r101, AGCRoutePolicy r102, InputStream r103, Map<String, String> r104, List<Service> r105, String r106) {
        this.f276707i = new HashMap();
        if (r100.getApplicationContext() == null) goto L5;
        r100 = r100.getApplicationContext();
    L5:
        this.f276700b = r100;
        if (r101 != null) goto L8;
        r101 = r100.getPackageName();
    L8:
        this.f276701c = r101;
        if (r103 == null) goto L11;
        this.f276703e = new i(r103, r101);
        Utils.closeQuietly(r103);
    L12:
        this.f276704f = new e(this.f276703e);
        AGCRoutePolicy r107 = AGCRoutePolicy.UNKNOWN;
        if (r102 != r107) goto L15;
    L19:
        if (r102 == null) goto L21;
        if (r102 == r107) goto L21;
    L22:
        this.f276702d = r102;
        this.f276705g = Utils.fixKeyPathMap(r104);
        this.f276706h = r105;
        if (r106 != null) goto L26;
        r106 = b();
    L26:
        this.f276699a = r106;
        return;
    L21:
        r102 = Utils.getRoutePolicyFromJson(this.f276703e.getString("/region", null), this.f276703e.getString("/agcgw/url", null));
        goto L22
    L15:
        if ("1.0".equals(this.f276703e.getString("/configuration_version", null)) == false) goto L19;
        throw new RuntimeException("The file version does not match,please download the latest agconnect-services.json from the AGC website.");
    L11:
        this.f276703e = new m(r100, r101);
        goto L12
    }

    private String a(String r100) {
        Map<String, JsonProcessingFactory.JsonProcessor> r101 = JsonProcessingFactory.getProcessors();
        if (r101.containsKey(r100) == true) goto L6;
        return null;
    L6:
        if (this.f276707i.containsKey(r100) == true) goto L8;
        JsonProcessingFactory.JsonProcessor r102 = r101.get(r100);
        if (r102 != null) goto L12;
        return null;
    L12:
        String r103 = r102.processOption(this);
        this.f276707i.put(r100, r103);
        return r103;
    L8:
        return this.f276707i.get(r100);
    }

    private String b() {
        return String.valueOf(("{packageName='" + this.f276701c + "', routePolicy=" + this.f276702d + ", reader=" + this.f276703e.toString().hashCode() + ", customConfigMap=" + new JSONObject(this.f276705g).toString().hashCode() + '}').hashCode());
    }

    public List<Service> a() {
        return this.f276706h;
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
        return this.f276700b;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getIdentifier() {
        return this.f276699a;
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
        return this.f276701c;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public AGCRoutePolicy getRoutePolicy() {
        AGCRoutePolicy r100 = this.f276702d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return AGCRoutePolicy.UNKNOWN;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String r100) {
        return getString(r100, null);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String r100, String r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        String r102 = Utils.fixPath(r100);
        String r103 = this.f276705g.get(r102);
        if (r103 == null) goto L7;
        return r103;
    L7:
        String r104 = a(r102);
        if (r104 == null) goto L10;
        return r104;
    L10:
        String r105 = this.f276703e.getString(r102, r101);
        if (e.a(r105) == true) goto L13;
        return r105;
    L13:
        return this.f276704f.decrypt(r105, r101);
    }
}
