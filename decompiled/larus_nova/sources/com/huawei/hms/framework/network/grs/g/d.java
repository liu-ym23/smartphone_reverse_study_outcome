package com.huawei.hms.framework.network.grs.g;

import android.text.TextUtils;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class d {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f277218o = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, List<String>> f277219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f277220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f277221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f277222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f277223e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f277224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f277225g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f277226h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f277227i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f277228j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f277229k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f277230l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Exception f277231m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f277232n;

    public d(int r100, Map<String, List<String>> r101, byte[] r102, long r103) {
        this.f277226h = 2;
        this.f277227i = 9001;
        this.f277228j = "";
        this.f277229k = 0;
        this.f277230l = "";
        this.f277221c = r100;
        this.f277219a = r101;
        this.f277220b = ByteBuffer.wrap(r102).array();
        this.f277222d = r103;
        s();
    }

    public d(Exception r100, long r101) {
        this.f277221c = 0;
        this.f277226h = 2;
        this.f277227i = 9001;
        this.f277228j = "";
        this.f277229k = 0;
        this.f277230l = "";
        this.f277231m = r100;
        this.f277222d = r101;
    }

    private void a(Map<String, String> r100) {
        if (r100.containsKey("ETag") == false) goto L8;
        String r101 = r100.get("ETag");
        if (TextUtils.isEmpty(r101) == true) goto L7;
        Logger.i(f277218o, "success get Etag from server");
        a(r101);
        return;
    L7:
        String r102 = f277218o;
        String r103 = "The Response Heads Etag is Empty";
    L9:
        Logger.i(r102, r103);
        return;
    L8:
        r102 = f277218o;
        r103 = "Response Heads has not Etag";
        goto L9
    }

    private void b(int r100) {
        this.f277227i = r100;
    }

    private void b(Map<String, String> r110) {
        if (r110.containsKey("Cache-Control") == false) goto L19;
        String r111 = r110.get("Cache-Control");
        if (TextUtils.isEmpty(r111) == false) goto L7;
    L33:
        long r100 = 0;
    L35:
        if (r100 > 0) goto L37;
    L38:
        r100 = 86400;
    L39:
        long r101 = r100 * 1000;
        Logger.i(f277218o, "convert expireTime{%s}", new Object[]{Long.valueOf(r101)});
        c(String.valueOf(r101 + System.currentTimeMillis()));
        return;
    L37:
        if (r100 <= 2592000) goto L39;
    L7:
        if (r111.contains("max-age=") == false) goto L33;
        r100 = CastLongProtector.parseLong(r111.substring(r111.indexOf("max-age=") + 8));     // Catch: NumberFormatException -> L15
    L13:
        e = e;
    L17:
        Logger.w(f277218o, "getExpireTime addHeadersToResult NumberFormatException", e);
        goto L35
    L11:
        Logger.v(f277218o, "Cache-Control value{%s}", new Object[]{Long.valueOf(r100)});     // Catch: NumberFormatException -> L13
    L15:
        e = e;
        r100 = 0;
        goto L17
    L19:
        if (r110.containsKey("Expires") == false) goto L32;
        String r102 = r110.get("Expires");
        Logger.v(f277218o, "expires is{%s}", new Object[]{r102});
        SimpleDateFormat r103 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
        if (r110.containsKey("Date") == false) goto L23;
        String r112 = r110.get("Date");
    L45:
        Date r104 = r103.parse(r102);     // Catch: ParseException -> L30
        if (TextUtils.isEmpty(r112) == false) goto L27;
        Date r113 = new Date();     // Catch: ParseException -> L30
    L28:
        r100 = (r104.getTime() - r113.getTime()) / 1000;     // Catch: ParseException -> L30
        goto L35
    L27:
        r113 = r103.parse(r112);     // Catch: ParseException -> L30
    L30:
        e = move-exception;
        Logger.w(f277218o, "getExpireTime ParseException.", e);
        goto L33
    L23:
        r112 = null;
        goto L45
    L32:
        Logger.i(f277218o, "response headers neither contains Cache-Control nor Expires.");
        goto L33
    }

    private void c(int r100) {
        this.f277226h = r100;
    }

    private void c(long r100) {
        this.f277229k = r100;
    }

    private void c(String r100) {
        this.f277228j = r100;
    }

    private void c(Map<String, String> r100) {
        if (r100.containsKey("Retry-After") == false) goto L10;
        String r101 = r100.get("Retry-After");
        if (TextUtils.isEmpty(r101) == true) goto L10;
        long r102 = CastLongProtector.parseLong(r101);     // Catch: NumberFormatException -> L8
    L11:
        long r103 = r102 * 1000;
        Logger.v(f277218o, "convert retry-afterTime{%s}", new Object[]{Long.valueOf(r103)});
        c(r103);
        return;
    L8:
        e = move-exception;
        Logger.w(f277218o, "getRetryAfter addHeadersToResult NumberFormatException", e);
    L10:
        r102 = 0;
        goto L11
    }

    private void d(String r100) {
    }

    private void e(String r100) {
    }

    private void f(String r100) {
        this.f277225g = r100;
    }

    private void p() {
        if (m() == false) goto L7;
        Logger.i(f277218o, "GRSSDK get httpcode{304} not any changed.");
        c(1);
        return;
    L7:
        if (o() == true) goto L54;
        Logger.i(f277218o, "GRSSDK parse server body all failed.");
        c(2);
        return;
    L54:
        JSONObject r100 = new JSONObject(StringUtils.byte2Str(this.f277220b));     // Catch: JSONException -> L51
        if (r100.has("isSuccess") == false) goto L17;
        if (JSONObjectProtectorUtils.getInt(r100, "isSuccess") == 1) goto L20;
    L21:
        int r101 = 2;
    L25:
        if (r101 != 1) goto L27;
    L29:
        c(r101);     // Catch: JSONException -> L51
        String r102 = "";
        if (r101 == 1) goto L43;
        if (r101 == 0) goto L43;
        if (r100.has("errorCode") == false) goto L37;
        int r103 = JSONObjectProtectorUtils.getInt(r100, "errorCode");     // Catch: JSONException -> L51
    L38:
        b(r103);     // Catch: JSONException -> L51
        if (r100.has("errorDesc") == false) goto L41;
        r102 = JSONObjectProtectorUtils.getString(r100, "errorDesc");     // Catch: JSONException -> L51
    L41:
        d(r102);     // Catch: JSONException -> L51
        return;
    L37:
        r103 = 9001;
    L43:
        if (r100.has(PromotionProductPrivilegesStruct.SERVICES) == false) goto L45;
        String r104 = JSONObjectProtectorUtils.getJSONObject(r100, PromotionProductPrivilegesStruct.SERVICES).toString();     // Catch: JSONException -> L51
    L46:
        f(r104);     // Catch: JSONException -> L51
        if (r100.has("errorList") == false) goto L49;
        r102 = JSONObjectProtectorUtils.getJSONObject(r100, "errorList").toString();     // Catch: JSONException -> L51
    L49:
        e(r102);     // Catch: JSONException -> L51
        return;
    L45:
        r104 = "";
        goto L46
    L27:
        if (r100.has(PromotionProductPrivilegesStruct.SERVICES) == false) goto L29;
        r101 = 0;
    L20:
        r101 = 1;
        goto L25
    L17:
        if (r100.has("resultCode") == true) goto L19;
        Logger.e(f277218o, "sth. wrong because server errorcode's key.");     // Catch: JSONException -> L51
        r101 = -1;
        goto L25
    L19:
        if (JSONObjectProtectorUtils.getInt(r100, "resultCode") != 0) goto L21;
    L51:
        e = move-exception;
        Logger.w(f277218o, "GrsResponse GrsResponse(String result) JSONException: %s", new Object[]{StringUtils.anonymizeMessage(e.getMessage())});
        c(2);
    }

    private void q() {
        if (o() == false) goto L5;
    L9:
        Map<String, String> r100 = r();
        if (r100.size() > 0) goto L25;
        Logger.w(f277218o, "parseHeader {headers.size() <= 0}");
        return;
    L25:
    L22:
        e = move-exception;
        Logger.w(f277218o, "parseHeader catch JSONException: %s", new Object[]{StringUtils.anonymizeMessage(e.getMessage())});
        return;
    L14:
        if (o() == false) goto L16;
    L17:
        b(r100);     // Catch: JSONException -> L22
        a(r100);     // Catch: JSONException -> L22
    L19:
        if (n() == false) goto L27;
        c(r100);     // Catch: JSONException -> L22
        return;
    L27:
        return;
    L16:
        if (m() == false) goto L19;
    L5:
        if (n() == true) goto L9;
        if (m() == true) goto L9;
    }

    private Map<String, String> r() {
        HashMap r100 = new HashMap(16);
        Map<String, List<String>> r101 = this.f277219a;
        if (r101 != null) goto L5;
    L15:
        Logger.v(f277218o, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
        return r100;
    L5:
        if (r101.size() <= 0) goto L15;
        Iterator<Map.Entry<String, List<String>>> r102 = this.f277219a.entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<String, List<String>> r103 = r102.next();
        String r104 = r103.getKey();
        Iterator<String> r105 = r103.getValue().iterator();
    L12:
        if (r105.hasNext() == false) goto L9;
        r100.put(r104, r105.next());
        goto L12
    L14:
        return r100;
    }

    private void s() {
        q();
        p();
    }

    public String a() {
        return this.f277228j;
    }

    public void a(int r100) {
    }

    public void a(long r100) {
        this.f277224f = r100;
    }

    public void a(String r100) {
        this.f277230l = r100;
    }

    public int b() {
        return this.f277221c;
    }

    public void b(long r100) {
        this.f277223e = r100;
    }

    public void b(String r100) {
        this.f277232n = r100;
    }

    public int c() {
        return this.f277227i;
    }

    public Exception d() {
        return this.f277231m;
    }

    public String e() {
        return this.f277230l;
    }

    public int f() {
        return this.f277226h;
    }

    public long g() {
        return this.f277224f;
    }

    public long h() {
        return this.f277223e;
    }

    public long i() {
        return this.f277222d;
    }

    public String j() {
        return this.f277225g;
    }

    public long k() {
        return this.f277229k;
    }

    public String l() {
        return this.f277232n;
    }

    public boolean m() {
        if (this.f277221c != 304) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean n() {
        if (this.f277221c != 503) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean o() {
        if (this.f277221c != 200) goto L5;
        return true;
    L5:
        return false;
    }
}
