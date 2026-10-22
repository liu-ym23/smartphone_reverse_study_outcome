package com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl;

import android.text.TextUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;
import com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings;
import com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.api.ILuckyDogCommonSettingRequestApi;
import com.google.gson.JsonObject;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import com.ttnet.org.chromium.base.TimeUtils;
import il7.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends xk7.e {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public JSONArray f271646t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f271647u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ILuckyDogCommonSettingsService.Channel f271648v;

    public static final class a {
    }

    static {
    }

    @Override // xk7.e
    public final long h() {
        Long r100 = (Long) k("data.settings_meta.static_settings_meta.polling_interval", Long.TYPE);
        if (r100 == null) goto L5;
        long r101 = r100.longValue();
    L7:
        return r101 * 1000;
    L5:
        r101 = TimeUtils.SECONDS_PER_HOUR;
        goto L7
    }

    @Override // xk7.e
    public final void n() {
        rk7.a.c();
        rk7.a.e("static_settings_parse_duration");
        LuckyDogLocalSettings r100 = this.f564233m;     // Catch: Exception -> L11
        if (r100 == null) goto L8;
        String r101 = r100.getStaticSettings();     // Catch: Exception -> L11
        if (r101 == null) goto L8;
    L9:
        JSONObject r102 = new JSONObject(r101);     // Catch: Exception -> L11
    L16:
        this.f564223c = r102;
        String r103 = r102.optString("key_setting_hash");     // Catch: Exception -> L19
        com.bytedance.ug.sdk.luckydog.api.log.d.d(this.f271647u, "loadCache hash key is" + r103);     // Catch: Exception -> L19
    L21:
        rk7.a.d("static_settings_parse_duration");
        return;
    L19:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b(this.f271647u, "opt key_setting_hash fail " + e);
    L8:
        r101 = "";
    L11:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b(this.f271647u, "load cache fail " + e);
        r102 = this.f564223c;
        if (r102 != null) goto L16;
        r102 = new JSONObject();
        goto L16
    }

    @Override // xk7.e
    public final void x() {
        LuckyDogLocalSettings r100 = this.f564233m;
        if (r100 == null) goto L6;
        r100.setStaticSettings(String.valueOf(this.f564223c));
        return;
    }

    public h() {
        this.f271647u = "LuckyDogStaticSettings";
        this.f271648v = ILuckyDogCommonSettingsService.Channel.STATIC;
    }

    @Override // xk7.e
    public final boolean b() {
        return super.b();
    }

    @Override // xk7.e
    public final ILuckyDogCommonSettingsService.Channel g() {
        return this.f271648v;
    }

    @Override // xk7.e
    public final String m() {
        return this.f271647u;
    }

    @Override // xk7.e
    public final void o() {
        rk7.a.c();
    }

    public final void B(JSONObject r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d(this.f271647u, "updateSettings called");
        if (r100 == null) goto L9;
        JSONObject r101 = r100.optJSONObject("sdk_key_LuckyDog");
        if (r101 == null) goto L9;
        JSONObject r102 = r101.optJSONObject("settings_config");
        if (r102 == null) goto L9;
    L10:
        this.f271646t = r102.optJSONArray("static_setting_proxy_keys");
        m r103 = m.a();
        JSONArray r104 = this.f271646t;
        if (r104 == null) goto L13;
        String r105 = r104.toString();
    L14:
        r103.k("static_setting_proxy_keys", r105);
        return;
    L13:
        r105 = null;
    L9:
        r102 = new JSONObject();
        goto L10
    }

    @Override // jl7.b
    public final void a(String r100) {
        final String r101 = r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f564230j.getAndSet(true) == false) goto L7;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(this.f271647u, "current has a request, ignore ".concat(r101));
        return;
    L7:
        com.bytedance.ug.sdk.luckydog.api.log.d.d(this.f271647u, "scene " + r101 + " cal onChange");
        ScheduledFuture<?> r102 = this.f564232l;
        if (r102 != null) goto L10;
    L12:
        this.f564232l = null;
        PThreadScheduledThreadPoolExecutor r103 = yk7.f.f568242a;
        yk7.f.b(new LuckyDogStaticSettings$onChange$$inlined$let$lambda$1(r101, this, r101));
        return;
    L10:
        if (r102.cancel(false) != true) goto L12;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(this.f271647u, "cancel success");
        this.f564231k = 0;
        goto L12
    }

    @Override // xk7.e
    public final int i(JSONObject r100) {
        rk7.a.c();
        if (r100 == null) goto L5;
        Object r101 = yk7.c.d(r100, "data.settings_meta.static_settings_meta.version");
    L6:
        com.bytedance.ug.sdk.luckydog.api.log.d.d(this.f271647u, "settings version = " + r101);
        if ((r101 instanceof Integer) == true) goto L11;
        return 0;
    L11:
        return ((Number) r101).intValue();
    L5:
        r101 = null;
        goto L6
    }

    @Override // xk7.e
    public final Object l(String r100) {
        Map<String, Object> r101 = i.f271649a;
        if (TextUtils.isEmpty(r100) == true) goto L6;
        rk7.a.b();
    L6:
        rk7.a.c();
        Object r102 = super.l(r100);
        if (rk7.m.f538357k == false) goto L15;
        StringBuilder r103 = new StringBuilder("disable snapshot, key : ");
        r103.append(r100);
        r103.append(", value : ");
        if (r102 == null) goto L13;
        String r104 = r102.toString();
        if (r104 == null) goto L13;
    L14:
        r103.append(r104);
        com.bytedance.ug.sdk.luckydog.api.log.a.c("launch_optimize", r103.toString());
    L13:
        r104 = "value is null";
    L15:
        return r102;
    }

    @Override // xk7.e
    public final Call<uk7.a<JsonObject>> t(int r100) {
        rk7.a.c();
        LinkedHashMap r101 = new LinkedHashMap();
        ILuckyDogCommonSettingRequestApi r102 = this.f564221a;
        if (r102 == null) goto L11;
        Pair[] r103 = new Pair[2];
        r103[0] = TuplesKt.to("scene", Integer.valueOf(r100));
        JSONObject r104 = this.f564223c;
        if (r104 == null) goto L9;
        String r105 = r104.optString("key_setting_hash");
        if (r105 == null) goto L9;
    L10:
        r103[1] = TuplesKt.to("settings_hash", r105);
        return r102.getStaticSettings(r101, MapsKt.mapOf(r103));
    L9:
        r105 = "";
        goto L10
    L11:
        return null;
    }

    @Override // xk7.e
    public final void w(JSONObject r100) {
        this.f564223c = r100;
    }

    @Override // xk7.e
    public final void y(JSONObject r100) {
        if ((!(this instanceof g)) == true) goto L5;
    L8:
        String r101 = m.a().e("static_setting_proxy_keys", "");
        if (TextUtils.isEmpty(r101) == false) goto L30;
        com.bytedance.ug.sdk.luckydog.api.log.d.b(this.f271647u, "proxy json is empty");
        return;
    L30:
        this.f271646t = new JSONArray(r101);     // Catch: Exception -> L15
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L15
        ArrayList r103 = new ArrayList();     // Catch: Exception -> L15
        JSONArray r104 = this.f271646t;     // Catch: Exception -> L15
        if (r104 == null) goto L24;
        ArrayList r105 = new ArrayList();     // Catch: Exception -> L15
        int r106 = r104.length();     // Catch: Exception -> L15
        int r107 = 0;
    L13:
        if (r107 >= r106) goto L17;
        r105.add(r104.optString(r107));     // Catch: Exception -> L15
        r107 = r107 + 1;     // Catch: Exception -> L15
        goto L13
    L17:
        Iterator r108 = r105.iterator();     // Catch: Exception -> L15
    L19:
        if (r108.hasNext() == false) goto L24;
        String r109 = (String) r108.next();     // Catch: Exception -> L15
        if (j(r109) != null) goto L19;
        com.bytedance.ug.sdk.luckydog.api.log.d.b(this.f271647u, "key:" + r109 + "proxy json is empty");     // Catch: Exception -> L15
        r103.add(r109);     // Catch: Exception -> L15
    L24:
        if (CollectionUtils.isEmpty(r103) == true) goto L38;
        r102.putOpt("static_settings_keys", r103.toString());     // Catch: Exception -> L15
        com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_settings_data", r102);     // Catch: Exception -> L15
        return;
    L38:
        return;
    L15:
        e = move-exception;
        String r110 = this.f271647u;
        StringBuilder r111 = new StringBuilder("syntax proxy json error");
        e.printStackTrace();
        r111.append(Unit.INSTANCE);
        com.bytedance.ug.sdk.luckydog.api.log.d.b(r110, r111.toString());
        return;
    L5:
        if (r100.optBoolean("no_update") == false) goto L8;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(this.f271647u, "not need update upload settings log");
    }
}
