package hr7;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.bytedance.webx.seclink.request.SecLinkVerifyApi;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile d f486902c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static dr7.b f486903d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f486904e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f486905f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f486906g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f486907h = 50;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f486908i = 1800000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f486909j = 1800000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hr7.a f486910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, List<f>> f486911b;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f486912a;

        public final JSONObject a() throws JSONException {
            JSONObject r100 = new JSONObject();
            Map<String, Object> r101 = this.f486912a.f486926i;
            if (r101 != null) goto L5;
        L13:
            r100.put("aid", this.f486912a.f486918a);
            r100.put("scene", this.f486912a.f486919b);
            r100.put("ts", this.f486912a.f486921d);
            r100.put(PickerReporterConstants.KEY.TARGET, this.f486912a.f486920c);
            r100.put(DocumentType.DOCX_SYNC_BLOCK_NAME, this.f486912a.f486923f);
            int r102 = 0;
            if (this.f486912a.f486924g >= 3) goto L16;
            r100.put(ForwardDependency$ForwardLocation.FLAG, true);
        L17:
            String r103 = this.f486912a.f486918a + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f486912a.f486919b + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f486912a.f486920c + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f486912a.f486921d + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f486912a.f486922e;
            if (r103 != null) goto L28;
            String r104 = null;
        L26:
            r100.put("token", r104);
            return r100;
        L28:
            MessageDigest r105 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L25
            r105.update(r103.getBytes());     // Catch: Exception -> L25
            byte[] r106 = r105.digest();     // Catch: Exception -> L25
            int r107 = r106.length;     // Catch: Exception -> L25
            StringBuilder r108 = new StringBuilder(r107 * 2);     // Catch: Exception -> L25
            int r109 = r107 + 0;     // Catch: Exception -> L25
        L21:
            if (r102 >= r109) goto L23;
            byte r110 = r106[r102];     // Catch: Exception -> L25
            char[] r111 = ir7.b.f495488a;     // Catch: Exception -> L25
            char r112 = r111[(r110 & 240) >> 4];     // Catch: Exception -> L25
            char r113 = r111[r110 & 15];     // Catch: Exception -> L25
            r108.append(r112);     // Catch: Exception -> L25
            r108.append(r113);     // Catch: Exception -> L25
            r102 = r102 + 1;     // Catch: Exception -> L25
            goto L21
        L23:
            r104 = r108.toString();     // Catch: Exception -> L25
        L25:
            r104 = "";
            goto L26
        L16:
            r100.put(ForwardDependency$ForwardLocation.FLAG, false);
            goto L17
        L5:
            if (r101.size() <= 0) goto L13;
            Iterator<String> r114 = r101.keySet().iterator();
        L8:
            if (r114.hasNext() == false) goto L13;
            String r115 = r114.next();
            Object r116 = r101.get(r115);
            if (TextUtils.isEmpty(r115) == true) goto L8;
            if (r116 == null) goto L8;
            r100.put(r115, r116);
            goto L8
        }

        public final String b() {
            if (ir7.c.d().endsWith(HTTP.URL_DEFAULT) == false) goto L5;
            String r100 = ir7.c.d() + "api/verify/v1";
        L6:
            HashMap r101 = (HashMap) ir7.e.a();
            r101.put("aid", this.f486912a.f486918a);
            String r102 = this.f486912a.f486927j;
            if (TextUtils.isEmpty(r102) == true) goto L10;
            r101.put("sec_link_biz_tag", r102);
        L10:
            if (TextUtils.isEmpty(r100) == true) goto L36;
            StringBuilder r103 = new StringBuilder(r100);
            if (r100.endsWith("?") == true) goto L15;
            r103.append("?");
        L15:
            Iterator r104 = r101.keySet().iterator();
        L17:
            if (r104.hasNext() == false) goto L26;
            String r105 = (String) r104.next();
            String r106 = (String) r101.get(r105);
            if (TextUtils.isEmpty(r105) == true) goto L17;
            if (TextUtils.isEmpty(r106) == true) goto L17;
            r103.append(r105);
            r103.append(ContainerUtils.KEY_VALUE_DELIMITER);
            r103.append(r106);
            if (r104.hasNext() == false) goto L17;
            r103.append("&");
            goto L17
        L26:
            return r103.toString();
        L36:
            return r100;
        L5:
            r100 = ir7.c.d() + "/api/verify/v1";
            goto L6
        }

        public a(f r100) {
            this.f486912a = r100;
        }

        public static hr7.c d(String r100) throws JSONException {
            JSONObject r101 = new JSONObject(r100);
            hr7.c r102 = new hr7.c(0);
            r102.f486896b = JSONObjectProtectorUtils.getInt(r101, "risk");
            r102.f486897c = JSONObjectProtectorUtils.getBoolean(r101, "show_mid_page");
            r102.f486898d = JSONObjectProtectorUtils.getLong(r101, "safe_duration");
            r102.f486899e = r101.optBoolean("show_banner", false);
            r102.f486900f = r101.optString("banner_text");
            r102.f486901g = r101.optString("str");
            if (r101.optBoolean("need_update_setting", false) == false) goto L5;
            ReportUtil.g("setting_version");
            com.bytedance.webx.seclink.setting.c r103 = com.bytedance.webx.seclink.setting.c.d();
            r103.f272632e = 0;
            r103.j();
        L5:
            r102.f486895a = true;
            return r102;
        }

        public final void e(hr7.c r100) {
            long r101 = r100.f486898d;
            if (r101 <= 0) goto L10;
            long r102 = r101 * 1000;
            fr7.a r103 = fr7.a.a();
            r103.getClass();
            if (r102 < 0) goto L10;
            if (r102 == fr7.a.f478612c) goto L10;
            fr7.a.f478612c = r102;
            r103.f478615b.edit().putLong("valid_time", r102).apply();
        L10:
            f r104 = this.f486912a;
            hr7.b r105 = r104.f486925h;
            if (r105 == null) goto L13;
            r105.a(r104.f486920c, r100);
        L13:
            d.a(d.b(), this.f486912a, r100, "");
        }

        public final void c(String r110, int r111) {
            String r100 = ReportUtil.ERROR_TYPE.Other.getType();
            JSONObject r101 = new JSONObject();     // Catch: JSONException -> L5
            r101.put("custom", "errorType:" + r100 + ";error_code:-1;errorMsg:" + r110);     // Catch: JSONException -> L5
            r101.put("key", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);     // Catch: JSONException -> L5
        L7:
            hr7.b r102 = this.f486912a.f486925h;
            if (r102 == null) goto L10;
            r102.onFail();
        L10:
            d.a(d.b(), this.f486912a, null, r110);
            if (1 != r111) goto L35;
            com.bytedance.webx.seclink.setting.c r112 = com.bytedance.webx.seclink.setting.c.d();
            monitor-enter(r112);
            int r103 = r112.f272628a + 1;     // Catch: Throwable -> L32
            r112.f272628a = r103;     // Catch: Throwable -> L32
            if ((r103 % 3) != 0) goto L30;
            r112.f272631d++;     // Catch: Throwable -> L32
            com.bytedance.webx.seclink.setting.a r104 = r112.c();     // Catch: Throwable -> L32
            if (r104 == null) goto L29;
            com.bytedance.webx.seclink.setting.a.C3815a r105 = r104.f272605a;     // Catch: Throwable -> L32
            if (r105 == null) goto L29;
            List<String> r106 = r105.f272616i;     // Catch: Throwable -> L32
            if (r106 == null) goto L29;
            ArrayList r107 = (ArrayList) r106;     // Catch: Throwable -> L32
            if (r107.size() <= 0) goto L29;
            int r108 = r112.f272631d;     // Catch: Throwable -> L32
            if (r108 <= 0) goto L29;
            if ((r108 % r107.size()) != 0) goto L29;
            ReportUtil.g("host_schedule");     // Catch: Throwable -> L32
            r112.f272632e = 0;     // Catch: Throwable -> L32
            r112.j();     // Catch: Throwable -> L32
        L29:
            r112.b("verify_host_index", r112.f272631d + "");     // Catch: Throwable -> L32
            ReportUtil.e("verify", r112.f272631d);     // Catch: Throwable -> L32
        L30:
            monitor-exit(r112);
        L32:
            th = move-exception;
            throw th;
        L35:
            int r113 = d.f486904e;
            if (r113 != 0) goto L39;
            d.f486904e = 1;
            d.f486905f = System.currentTimeMillis();
        L45:
            if (d.f486904e < d.f486907h) goto L66;
            ReportUtil.g("shield");
            com.bytedance.webx.seclink.setting.c r114 = com.bytedance.webx.seclink.setting.c.d();
            r114.f272632e = 0;
            r114.j();
            f r115 = this.f486912a;
            if (r115 == null) goto L49;
            String r109 = r115.f486920c;
        L50:
            if (r115 == null) goto L52;
            String r116 = r115.f486919b;
        L53:
            long r117 = d.f486907h;
            long r118 = d.f486908i;
            long r119 = d.f486909j;
            JSONObject r120 = new JSONObject();     // Catch: JSONException -> L56
            r120.put("custom", "maxErrorNum=" + r117 + ",errorDurationTime=" + r118 + ",shieldDurationTime=" + r119);     // Catch: JSONException -> L56
            r120.put("key", "shield");     // Catch: JSONException -> L56
            r120.put("url", r109);     // Catch: JSONException -> L56
            r120.put("scene", r116);     // Catch: JSONException -> L56
        L58:
            d.f486904e = 0;
            d.f486905f = 0;
            d.f486906g = System.currentTimeMillis();
            return;
        L56:
            e = move-exception;
            e.printStackTrace();
            goto L58
        L52:
            r116 = "";
            goto L53
        L49:
            r109 = "";
            goto L50
        L66:
            return;
        L39:
            if (r113 >= d.f486907h) goto L45;
            if ((System.currentTimeMillis() - d.f486905f) >= d.f486908i) goto L43;
            d.f486904e++;
            goto L45
        L43:
            d.f486904e = 1;
            d.f486905f = System.currentTimeMillis();
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }
    }

    public static class b extends a implements Callable<hr7.c> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public hr7.c call() {
            f r100 = this.f486912a;
            String r101 = "";
            if (r100 == null) goto L5;
            String r102 = r100.f486920c;
        L6:
            if (r100 == null) goto L8;
            String r103 = r100.f486919b;
        L9:
            if (r100 == null) goto L12;
            r101 = r100.f486927j;
        L12:
            if (TextUtils.isEmpty(r101) == false) goto L15;
            r101 = "unknown";
        L15:
            String r110 = r101;
            d r104 = d.b();
            f r105 = this.f486912a;
            r104.getClass();
            boolean r106 = false;
            if (r105 == null) goto L33;
            String r107 = r105.f486919b;
            String r108 = r105.f486920c;
            if (TextUtils.isEmpty(r108) == false) goto L24;
            hr7.b r109 = r105.f486925h;
            if (r109 == null) goto L33;
            r109.onFail();
            goto L33
        L24:
            if (com.bytedance.webx.seclink.setting.c.i(r107) == true) goto L29;
            hr7.b r111 = r105.f486925h;
            if (r111 == null) goto L33;
            r111.onFail();
            goto L33
        L29:
            if (ir7.c.g(r108) == false) goto L34;
            hr7.b r112 = r105.f486925h;
            if (r112 == null) goto L33;
            r112.onFail();
            goto L33
        L34:
            boolean r113 = true;
        L35:
            if (r113 == false) goto L37;
            hr7.c r114 = fr7.a.a().b(r103, r102);
            if (r114 != null) goto L41;
        L43:
            long r115 = System.currentTimeMillis();
            String r116 = ir7.c.d();
            if (r114 != null) goto L46;
        L77:
        L57:
            e = move-exception;
            hr7.c r117 = new hr7.c(0);
            c(e.getMessage(), 3);
            r114 = r117;
        L70:
            if (r114.f486895a == false) goto L72;
            int r118 = r114.f486896b;
            boolean r119 = r114.f486897c;
            r106 = true;
        L73:
            f r120 = this.f486912a;
            ReportUtil.h(r116, r106, r120.f486919b, r120.f486920c, r110, r119, System.currentTimeMillis() - r115, 1, "", r118);
            return r114;
        L72:
            r119 = false;
            r118 = 0;
            goto L73
        L48:
            if (d.f486903d != null) goto L50;
            d.f486903d = new c();     // Catch: Exception -> L57
        L50:
            String r121 = ((c) d.f486903d).a(b(), a());     // Catch: Exception -> L57
            if (TextUtils.isEmpty(r121) == false) goto L75;
            c("response body is empty", 1);     // Catch: Exception -> L57
            r114 = new hr7.c(0);     // Catch: Exception -> L57
            goto L70
        L75:
            r114 = a.d(r121);     // Catch: Exception -> L57 JSONException -> L59
            com.bytedance.webx.seclink.setting.a r122 = com.bytedance.webx.seclink.setting.c.d().c();     // Catch: Exception -> L57 JSONException -> L59
            if (r122 == null) goto L61;
            com.bytedance.webx.seclink.setting.a.C3815a r123 = r122.f272605a;     // Catch: Exception -> L57 JSONException -> L59
            if (r123 == null) goto L61;
            boolean r124 = r123.f272608a;     // Catch: Exception -> L57 JSONException -> L59
        L62:
            if (r124 == false) goto L70;
            fr7.a r125 = fr7.a.a();     // Catch: Exception -> L57 JSONException -> L59
            f r126 = this.f486912a;     // Catch: Exception -> L57 JSONException -> L59
            r125.d(r126.f486919b, r126.f486920c, r114);     // Catch: Exception -> L57 JSONException -> L59
        L61:
            r124 = false;
        L59:
            e = move-exception;
            hr7.c r127 = new hr7.c(0);     // Catch: Exception -> L57
            c("source:  " + r121 + "  case : " + e.getMessage(), 2);     // Catch: Exception -> L57
            r114 = r127;
            goto L70
        L46:
            if (r114.f486895a == true) goto L70;
        L41:
            if (r114.f486895a == false) goto L43;
            ReportUtil.d(r102, r103, r110, r114.f486897c, "send_http_sync");
            goto L43
        L37:
            return new hr7.c(0);
        L33:
            r113 = false;
            goto L35
        L8:
            r103 = "";
            goto L9
        L5:
            r102 = "";
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ hr7.c call() throws Exception {
            return call();
        }

        public b(f r100) {
            super(r100);
        }
    }

    public static class c implements dr7.b {
        public c() {
        }

        public final String a(String r100, JSONObject r101) throws Exception {
            if (TextUtils.isEmpty(r100) == true) goto L6;
            SecLinkVerifyApi r102 = (SecLinkVerifyApi) RetrofitUtils.createSsService(com.bytedance.webx.seclink.setting.c.d().g(), SecLinkVerifyApi.class);
            ArrayList r103 = new ArrayList();
            r103.add(new Header("Content-Type", "application/json"));
            return r102.executePost(r100, new TypedByteArray(null, r101.toString().getBytes(Charset.forName("UTF-8")), new String[0]), r103).execute().body();
        L6:
            return "";
        }

        public final void b(String r100, JSONObject r101, RunnableC6187d.a r102) {
            SecLinkVerifyApi r103 = (SecLinkVerifyApi) RetrofitUtils.createSsService(com.bytedance.webx.seclink.setting.c.d().g(), SecLinkVerifyApi.class);
            ArrayList r104 = new ArrayList();
            r104.add(new Header("Content-Type", "application/json"));
            r103.executePost(r100, new TypedByteArray(null, r101.toString().getBytes(Charset.forName("UTF-8")), new String[0]), r104).enqueue(new e(r102));
        }
    }

    /* JADX INFO: renamed from: hr7.d$d, reason: collision with other inner class name */
    public static class RunnableC6187d extends a implements Runnable {

        /* JADX INFO: renamed from: hr7.d$d$a */
        public class a implements dr7.b.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f486913a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f486914b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f486915c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ RunnableC6187d f486916d;

            public a(RunnableC6187d r100, String r101, String r102, long r103) {
                this.f486916d = r100;
                this.f486913a = r101;
                this.f486914b = r102;
                this.f486915c = r103;
            }
        }

        public final void f() {
            long r100 = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.f486912a.f486927j) == true) goto L5;
            String r101 = this.f486912a.f486927j;
        L6:
            String r102 = r101;
            String r210 = ir7.c.d();
            fr7.a r103 = fr7.a.a();     // Catch: Exception -> L25
            f r104 = this.f486912a;     // Catch: Exception -> L25
            hr7.c r105 = r103.b(r104.f486919b, r104.f486920c);     // Catch: Exception -> L25
            if (r105 == null) goto L17;
            if (r105.f486895a == false) goto L17;
            f r106 = this.f486912a;     // Catch: Exception -> L25
            hr7.b r107 = r106.f486925h;     // Catch: Exception -> L25
            if (r107 == null) goto L14;
            r107.a(r106.f486920c, r105);     // Catch: Exception -> L25
        L14:
            d.a(d.b(), this.f486912a, r105, "");     // Catch: Exception -> L25
            f r108 = this.f486912a;     // Catch: Exception -> L25
            ReportUtil.d(r108.f486920c, r108.f486919b, r102, r105.f486897c, "send_http_async");     // Catch: Exception -> L25
            f r109 = this.f486912a;     // Catch: Exception -> L25
            ReportUtil.h(r210, true, r109.f486919b, r109.f486920c, r102, r105.f486897c, System.currentTimeMillis() - r100, 0, "", r105.f486896b);     // Catch: Exception -> L25
            return;
        L17:
            if (d.f486903d != null) goto L19;
            d.f486903d = new c();     // Catch: Exception -> L25
        L19:
            dr7.b r110 = d.f486903d;     // Catch: Exception -> L25
            String r111 = b();     // Catch: Exception -> L25
            JSONObject r112 = a();     // Catch: Exception -> L25
            c r113 = (c) r110;     // Catch: Exception -> L23
            r113.b(r111, r112, new a(this, r210, r102, r100));     // Catch: Exception -> L23
            return;
        L23:
            e = e;
        L27:
            f r114 = this.f486912a;
            ReportUtil.h(r210, false, r114.f486919b, r114.f486920c, r102, false, System.currentTimeMillis() - r100, 0, e.getMessage(), 0);
            c(e.getMessage(), 3);
            return;
        L25:
            e = e;
            goto L27
        L5:
            r101 = "unknown";
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            f();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC6187d(f r100) {
            super(r100);
        }
    }

    public static d b() {
        if (f486902c != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f486902c != null) goto L9;
        f486902c = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f486902c;
    }

    public d() {
        this.f486911b = new ConcurrentHashMap();
    }

    public static void a(d r100, f r101, hr7.c r102, String r103) {
        r100.getClass();
        if (r101 == null) goto L55;
        String r104 = hr7.a.a(r101.f486918a, r101.f486919b, r101.f486920c);
        if (TextUtils.isEmpty(r104) == true) goto L56;
        hr7.a r105 = r100.f486910a;
        if (r105 == null) goto L45;
        monitor-enter(r105);
        r105.f486894f = true;     // Catch: Throwable -> L15
        monitor-exit(r105);
        hr7.a r106 = r100.f486910a;
        r106.f486893e = r102;
        r106.getClass();
    L15:
        th = move-exception;
        throw th;
    L45:
        List<f> r107 = r100.f486911b.remove(r104);     // Catch: Exception -> L38
        if (r107 != null) goto L21;
        return;
    L21:
        if (r107.size() <= 0) goto L54;
        int r108 = 0;
    L23:
        if (r108 >= r107.size()) goto L57;
        f r109 = (f) ListProtector.get(r107, r108);     // Catch: Exception -> L38
        if (r109 == null) goto L37;
        hr7.b r110 = r109.f486925h;     // Catch: Exception -> L35
        if (r110 == null) goto L37;
        if (r102 != null) goto L31;
    L33:
        r110.onFail();     // Catch: Exception -> L35
        goto L37
    L31:
        if (r102.f486895a == false) goto L33;
        r110.a(r101.f486920c, r102);     // Catch: Exception -> L35
        goto L37
    L35:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L38
    L37:
        r108 = r108 + 1;
        goto L23
    L57:
        return;
    L54:
        return;
    L38:
        e = move-exception;
        e.printStackTrace();
        return;
    L56:
        return;
    }
}
