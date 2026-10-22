package com.bytedance.push.settings;

import a87.k;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import j77.b;
import j77.c;
import j77.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class LocalFrequencySettings$$SettingImpl implements LocalFrequencySettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f267011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f267012b;

    public class a implements c {
        public a() {
        }

        @Override // j77.c
        public final <T> T create(Class<T> r100) {
            if (r100 != j77.k.class) goto L7;
            return (T) new j77.k();
        L7:
            if (r100 == f.class) goto L9;
            return null;
        L9:
            return (T) new f();
        }
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final String A() {
        k r100 = this.f267011a;
        if (r100 != null) goto L5;
    L7:
        return "";
    L5:
        if (r100.contains("last_update_sender_supported") == false) goto L7;
        return this.f267011a.getString("last_update_sender_supported");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final int F() {
        k r100 = this.f267011a;
        if (r100 != null) goto L5;
    L7:
        return -1;
    L5:
        if (r100.contains("inner_switcher_stat") == false) goto L7;
        return this.f267011a.getInt("inner_switcher_stat");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final String H() {
        k r100 = this.f267011a;
        if (r100 != null) goto L5;
    L7:
        return "";
    L5:
        if (r100.contains("last_update_sender_did") == false) goto L7;
        return this.f267011a.getString("last_update_sender_did");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final String L() {
        k r100 = this.f267011a;
        if (r100 != null) goto L5;
    L7:
        return "";
    L5:
        if (r100.contains("last_request_settings_gray_vc") == false) goto L7;
        return this.f267011a.getString("last_request_settings_gray_vc");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final int P() {
        k r100 = this.f267011a;
        if (r100 != null) goto L5;
    L7:
        return -2;
    L5:
        if (r100.contains("sys_switcher_stat") == false) goto L7;
        return this.f267011a.getInt("sys_switcher_stat");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final boolean W() {
        k r100 = this.f267011a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.contains("last_send_switcher_stat") == false) goto L7;
        return this.f267011a.getBoolean("last_send_switcher_stat");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final String Y() {
        k r100 = this.f267011a;
        if (r100 != null) goto L5;
    L7:
        return "";
    L5:
        if (r100.contains("last_request_settings_channel") == false) goto L7;
        return this.f267011a.getString("last_request_settings_channel");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final String a0() {
        k r100 = this.f267011a;
        if (r100 != null) goto L5;
    L7:
        return "";
    L5:
        if (r100.contains("last_request_settings_vc") == false) goto L7;
        return this.f267011a.getString("last_request_settings_vc");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final String d() {
        k r100 = this.f267011a;
        if (r100 != null) goto L5;
    L7:
        return "";
    L5:
        if (r100.contains("last_update_sender_vc") == false) goto L7;
        return this.f267011a.getString("last_update_sender_vc");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final List<y67.c> j() {
        k r100 = this.f267011a;
        if (r100 != null) goto L5;
    L17:
        ((f) b.a(f.class, this.f267012b)).getClass();
        return new ArrayList();
    L5:
        if (r100.contains("revoke_rid_list") == false) goto L17;
        String r101 = this.f267011a.getString("revoke_rid_list");
        ((f) b.a(f.class, this.f267012b)).getClass();
        ArrayList r102 = new ArrayList();
        JSONArray r103 = new JSONArray(r101);     // Catch: Throwable -> L15
        int r104 = 0;
    L9:
        if (r104 >= r103.length()) goto L25;
        JSONObject r105 = r103.optJSONObject(r104);     // Catch: Throwable -> L15
        if (r105 == null) goto L14;
        y67.c r106 = new y67.c();     // Catch: Throwable -> L15
        r106.f566374c = r105.optLong("ts");     // Catch: Throwable -> L15
        r106.f566372a = r105.optLong("rid");     // Catch: Throwable -> L15
        r106.f566373b = r105.optLong("revoke_id");     // Catch: Throwable -> L15
        r106.f566375d = r105.optInt("sender");     // Catch: Throwable -> L15
        r102.add(r106);     // Catch: Throwable -> L15
    L14:
        r104 = r104 + 1;
        goto L9
    L25:
        return r102;
    L15:
        th = move-exception;
        th.printStackTrace();
        return r102;
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final String k0() {
        k r100 = this.f267011a;
        if (r100 != null) goto L5;
    L7:
        return "";
    L5:
        if (r100.contains("last_update_sender_alias") == false) goto L7;
        return this.f267011a.getString("last_update_sender_alias");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final long l0() {
        k r100 = this.f267011a;
        if (r100 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r100.contains("last_update_sender_time_mil") == false) goto L7;
        return this.f267011a.getLong("last_update_sender_time_mil");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final String m0() {
        k r100 = this.f267011a;
        if (r100 != null) goto L5;
    L7:
        return "";
    L5:
        if (r100.contains("notify_channel_stat") == false) goto L7;
        return this.f267011a.getString("notify_channel_stat");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final List<y67.f> n0() {
        k r100 = this.f267011a;
        if (r100 != null) goto L5;
    L22:
        ((j77.k) b.a(j77.k.class, this.f267012b)).getClass();
        return new ArrayList();
    L5:
        if (r100.contains("token_cache") == false) goto L22;
        String r101 = this.f267011a.getString("token_cache");
        ((j77.k) b.a(j77.k.class, this.f267012b)).getClass();
        ArrayList r102 = new ArrayList();
        JSONArray r103 = new JSONArray(r101);     // Catch: JSONException -> L20
        int r104 = 0;
    L8:
        if (r104 >= r103.length()) goto L30;
        JSONObject r105 = r103.optJSONObject(r104);     // Catch: JSONException -> L20
        y67.f r106 = null;
        if (r105 == null) goto L17;
        int r107 = r105.optInt("type");     // Catch: JSONException -> L20
        String r108 = r105.optString("token");     // Catch: JSONException -> L20
        String r109 = r105.optString(com.bytedance.android.ec.core.event.a.KEY_DID);     // Catch: JSONException -> L20
        String r110 = r105.optString(ThumbGlideUrl.SOURCE_VC);     // Catch: JSONException -> L20
        long r111 = r105.optLong("t");     // Catch: JSONException -> L20
        String r112 = r105.optString("alias", null);     // Catch: JSONException -> L20
        if (r107 <= 0) goto L17;
        r106 = new y67.f(r107, r108, r109, r110, r111, r112);     // Catch: JSONException -> L20
    L17:
        if (r106 == null) goto L19;
        r102.add(r106);     // Catch: JSONException -> L20
    L19:
        r104 = r104 + 1;
        goto L8
    L30:
        return r102;
    L20:
        e = move-exception;
        e.printStackTrace();
        return r102;
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final String p0() {
        k r100 = this.f267011a;
        if (r100 != null) goto L5;
    L7:
        return "";
    L5:
        if (r100.contains("last_update_sender_gray_vc") == false) goto L7;
        return this.f267011a.getString("last_update_sender_gray_vc");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final long r0() {
        k r100 = this.f267011a;
        if (r100 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r100.contains("last_request_settings_time_mil") == false) goto L7;
        return this.f267011a.getLong("last_request_settings_time_mil");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final String s0() {
        k r100 = this.f267011a;
        if (r100 != null) goto L5;
    L7:
        return "";
    L5:
        if (r100.contains("last_update_sender_channel") == false) goto L7;
        return this.f267011a.getString("last_update_sender_channel");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final long t() {
        k r100 = this.f267011a;
        if (r100 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r100.contains("last_upload_switch_ts") == false) goto L7;
        return this.f267011a.getLong("last_upload_switch_ts");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final void C(String r100) {
        k r101 = this.f267011a;
        if (r101 == null) goto L6;
        SharedPreferences.Editor r102 = r101.edit();
        r102.putString("last_request_settings_gray_vc", r100);
        r102.apply();
        return;
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final void M(String r100) {
        k r101 = this.f267011a;
        if (r101 == null) goto L6;
        SharedPreferences.Editor r102 = r101.edit();
        r102.putString("last_update_sender_supported", r100);
        r102.apply();
        return;
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final void O(String r100) {
        k r101 = this.f267011a;
        if (r101 == null) goto L6;
        SharedPreferences.Editor r102 = r101.edit();
        r102.putString("last_update_sender_alias", r100);
        r102.apply();
        return;
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final void S(String r100) {
        k r101 = this.f267011a;
        if (r101 == null) goto L6;
        SharedPreferences.Editor r102 = r101.edit();
        r102.putString("last_update_sender_did", r100);
        r102.apply();
        return;
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final void a(String r100) {
        k r101 = this.f267011a;
        if (r101 == null) goto L6;
        SharedPreferences.Editor r102 = r101.edit();
        r102.putString("last_update_sender_vc", r100);
        r102.apply();
        return;
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final void b0(List<y67.c> r100) {
        k r101 = this.f267011a;
        if (r101 == null) goto L25;
        SharedPreferences.Editor r102 = r101.edit();
        ((f) b.a(f.class, this.f267012b)).getClass();
        JSONArray r103 = new JSONArray();
        Iterator r104 = ((ArrayList) r100).iterator();
    L6:
        if (r104.hasNext() == false) goto L16;
        y67.c r105 = (y67.c) r104.next();
        if (r105 == null) goto L6;
        JSONObject r106 = new JSONObject();
        r106.put("ts", r105.f566374c);     // Catch: JSONException -> L13
        r106.put("rid", r105.f566372a);     // Catch: JSONException -> L13
        r106.put("revoke_id", r105.f566373b);     // Catch: JSONException -> L13
        r106.put("sender", r105.f566375d);     // Catch: JSONException -> L13
    L15:
        r103.put(r106);
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L16:
        r102.putString("revoke_rid_list", r103.toString());
        r102.apply();
        return;
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final void c0(List<y67.f> r100) {
        k r101 = this.f267011a;
        if (r101 == null) goto L31;
        SharedPreferences.Editor r102 = r101.edit();
        ((j77.k) b.a(j77.k.class, this.f267012b)).getClass();
        JSONArray r103 = new JSONArray();
        Iterator r104 = ((ArrayList) r100).iterator();
    L6:
        if (r104.hasNext() == false) goto L22;
        y67.f r105 = (y67.f) r104.next();
        if (r105 == null) goto L6;
        if (r105.f566393e > 0) goto L13;
        JSONObject r106 = null;
    L21:
        r103.put(r106);
        goto L6
    L13:
        JSONObject r107 = new JSONObject();
        r107.put("type", r105.f566393e);     // Catch: JSONException -> L18
        r107.put("token", r105.f566392d);     // Catch: JSONException -> L18
        r107.put(com.bytedance.android.ec.core.event.a.KEY_DID, r105.f566390b);     // Catch: JSONException -> L18
        r107.put(ThumbGlideUrl.SOURCE_VC, r105.f566391c);     // Catch: JSONException -> L18
        r107.put("t", r105.f566389a);     // Catch: JSONException -> L18
        if (TextUtils.isEmpty(r105.f566394f) == true) goto L20;
        r107.put("alias", r105.f566394f);     // Catch: JSONException -> L18
    L20:
        r106 = r107;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L22:
        r102.putString("token_cache", r103.toString());
        r102.apply();
        return;
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final void f0(boolean r100) {
        k r101 = this.f267011a;
        if (r101 == null) goto L6;
        SharedPreferences.Editor r102 = r101.edit();
        r102.putBoolean("last_send_switcher_stat", r100);
        r102.apply();
        return;
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final void g(long r100) {
        k r101 = this.f267011a;
        if (r101 == null) goto L6;
        SharedPreferences.Editor r102 = r101.edit();
        r102.putLong("last_upload_switch_ts", r100);
        r102.apply();
        return;
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final void i(long r100) {
        k r101 = this.f267011a;
        if (r101 == null) goto L6;
        SharedPreferences.Editor r102 = r101.edit();
        r102.putLong("last_update_sender_time_mil", r100);
        r102.apply();
        return;
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final void i0(String r100) {
        k r101 = this.f267011a;
        if (r101 == null) goto L6;
        SharedPreferences.Editor r102 = r101.edit();
        r102.putString("last_update_sender_channel", r100);
        r102.apply();
        return;
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final void j0(long r100) {
        k r101 = this.f267011a;
        if (r101 == null) goto L6;
        SharedPreferences.Editor r102 = r101.edit();
        r102.putLong("last_request_settings_time_mil", r100);
        r102.apply();
        return;
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final void m(String r100) {
        k r101 = this.f267011a;
        if (r101 == null) goto L6;
        SharedPreferences.Editor r102 = r101.edit();
        r102.putString("last_request_settings_channel", r100);
        r102.apply();
        return;
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final void p(int r100) {
        k r101 = this.f267011a;
        if (r101 == null) goto L6;
        SharedPreferences.Editor r102 = r101.edit();
        r102.putInt("inner_switcher_stat", r100);
        r102.apply();
        return;
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final void q(String r100) {
        k r101 = this.f267011a;
        if (r101 == null) goto L6;
        SharedPreferences.Editor r102 = r101.edit();
        r102.putString("notify_channel_stat", r100);
        r102.apply();
        return;
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final void s(String r100) {
        k r101 = this.f267011a;
        if (r101 == null) goto L6;
        SharedPreferences.Editor r102 = r101.edit();
        r102.putString("last_request_settings_vc", r100);
        r102.apply();
        return;
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final void u0(int r100) {
        k r101 = this.f267011a;
        if (r101 == null) goto L6;
        SharedPreferences.Editor r102 = r101.edit();
        r102.putInt("sys_switcher_stat", r100);
        r102.apply();
        return;
    }

    @Override // com.bytedance.push.settings.ILocalSettings
    public final void unregisterValChanged(j77.a r100) {
        k r101 = this.f267011a;
        if (r101 == null) goto L6;
        r101.unregisterValChanged(r100);
        return;
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public final void v0(String r100) {
        k r101 = this.f267011a;
        if (r101 == null) goto L6;
        SharedPreferences.Editor r102 = r101.edit();
        r102.putString("last_update_sender_gray_vc", r100);
        r102.apply();
        return;
    }

    public LocalFrequencySettings$$SettingImpl(Context r100, k r101) {
        this.f267012b = new a();
        this.f267011a = r101;
    }

    @Override // com.bytedance.push.settings.ILocalSettings
    public final void registerValChanged(Context r100, String r101, String r102, j77.a r103) {
        k r104 = this.f267011a;
        if (r104 == null) goto L6;
        r104.registerValChanged(r100, r101, r102, r103);
        return;
    }
}
