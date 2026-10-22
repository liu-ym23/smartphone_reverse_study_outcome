package mk7;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.luckydog.api.log.d;
import il7.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import rk7.m;
import rk7.u;
import rm7.i;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f514322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, C6825a> f514323b;

    /* JADX INFO: renamed from: mk7.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes22.dex */
    public static class C6825a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f514324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f514325b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f514326c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f514327d;

        public C6825a() {
        }

        public C6825a(String r100, String r101) {
            this.f514324a = r100;
            this.f514325b = r101;
            Application r102 = m.f538347a;
            this.f514326c = String.valueOf(m.f());
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f514328a = null;

        static {
            f514328a = new a();
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f514329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f514330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f514331c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f514332d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f514333e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f514334f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f514335g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f514336h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f514337i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f514338j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f514339k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f514340l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f514341m;

        public c() {
        }
    }

    public a() {
        this.f514323b = new HashMap();
    }

    public static void d(c r100) {
        JSONObject r101 = new JSONObject();
        r101.put("url", r100.f514340l);     // Catch: Throwable -> L9
        r101.put("luckydog_from_aid", r100.f514330b);     // Catch: Throwable -> L9
        r101.put("luckydog_to_aid", r100.f514331c);     // Catch: Throwable -> L9
        r101.put("luckydog_from_token", r100.f514332d);     // Catch: Throwable -> L9
        r101.put("luckydog_cur_token", r100.f514333e);     // Catch: Throwable -> L9
        r101.put("luckydog_activity_id", r100.f514329a);     // Catch: Throwable -> L9
        r101.put("luckydog_token_is_union", r100.f514334f);     // Catch: Throwable -> L9
        r101.put("luckydog_from_did", r100.f514335g);     // Catch: Throwable -> L9
        r101.put("luckydog_cur_did", r100.f514336h);     // Catch: Throwable -> L9
        r101.put("luckydog_did_is_union", r100.f514337i);     // Catch: Throwable -> L9
        r101.put("luckydog_cross_ack_time", r100.f514338j);     // Catch: Throwable -> L9
        r101.put("luckydog_cross_reack_install", r100.f514339k);     // Catch: Throwable -> L9
        r101.put("luckydog_task_id", r100.f514341m);     // Catch: Throwable -> L9
        AtomicBoolean r102 = u.f538372v;     // Catch: Throwable -> L9
        if (u.c.f538395a.e() == false) goto L6;
        int r103 = 1;
    L7:
        r101.put("agree_privacy", r103);     // Catch: Throwable -> L9
        r101.put("luckydog_target_app_version", h.b(m.f538361o.e()));     // Catch: Throwable -> L9
        d.d("DeviceDialogManager", "sendTokenCheckEvent() EventName = luckydog_token_check; params = " + r101.toString());     // Catch: Throwable -> L9
    L11:
        com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_token_check", r101);
        return;
    L6:
        r103 = 0;
    L9:
        th = move-exception;
        d.b("DeviceDialogManager", th.getMessage());
        goto L11
    }

    public final void a(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return;
    L5:
        d.d("DeviceDialogManager", "checkAccountConflict() schema = " + r110);
        AtomicBoolean r100 = u.f538372v;
        if (u.c.f538395a.e() == true) goto L9;
        d.d("DeviceDialogManager", "checkAccountConflict() 隐私弹窗未同意，pending");
        this.f514322a = r110;
        return;
    L9:
        this.f514322a = "";
        Uri r101 = UriProtector.parse(r110);     // Catch: Throwable -> L61
        if (r101 != null) goto L13;
        return;
    L13:
        String r102 = UriProtector.getQueryParameter(r101, "luckydog_activity_id");     // Catch: Throwable -> L61
        String r103 = UriProtector.getQueryParameter(r101, "luckydog_token");     // Catch: Throwable -> L61
        String r104 = UriProtector.getQueryParameter(r101, "luckydog_hash");     // Catch: Throwable -> L61
        String r105 = UriProtector.getQueryParameter(r101, "luckydog_from_aid");     // Catch: Throwable -> L61
        String r106 = UriProtector.getQueryParameter(r101, "luckydog_from_did");     // Catch: Throwable -> L61
        String r107 = UriProtector.getQueryParameter(r101, "luckydog_cross_ack_time");     // Catch: Throwable -> L61
        String r108 = UriProtector.getQueryParameter(r101, "luckydog_cross_reack_install");     // Catch: Throwable -> L61
        String r109 = UriProtector.getQueryParameter(r101, "luckydog_task_id");     // Catch: Throwable -> L61
        uk7.m.b().getClass();     // Catch: Throwable -> L61
        String r111 = uk7.m.a("90000");     // Catch: Throwable -> L61
        qm7.d r112 = qm7.d.a.f533911a;     // Catch: Throwable -> L61
        if (r112.f533906b != null) goto L16;
        List r113 = new ArrayList();     // Catch: Throwable -> L61
    L17:
        if (r113 == null) goto L21;
        if (r113.isEmpty() == true) goto L21;
    L25:
        if (TextUtils.isEmpty(r104) == false) goto L27;
    L29:
        d.d("DeviceDialogManager", "checkAccountConflict()账号一致；");     // Catch: Throwable -> L61
    L31:
        if (TextUtils.isEmpty(r102) == true) goto L33;
        d.d("DeviceDialogManager", "checkAccountConflict() 账号冲突的activityId不为空");     // Catch: Throwable -> L61
        ((HashMap) this.f514323b).put(r102, new C6825a(r105, r104));     // Catch: Throwable -> L61
    L34:
        c r114 = new c();     // Catch: Throwable -> L61
        r114.f514329a = r102;     // Catch: Throwable -> L61
        r114.f514330b = r105;     // Catch: Throwable -> L61
        Application r115 = m.f538347a;     // Catch: Throwable -> L61
        r114.f514331c = String.valueOf(m.f());     // Catch: Throwable -> L61
        r114.f514332d = r103;     // Catch: Throwable -> L61
        r114.f514333e = i.b.f538604a.d();     // Catch: Throwable -> L61
        String r116 = "1";
        if (TextUtils.isEmpty(r114.f514332d) == false) goto L38;
    L42:
        String r117 = "0";
    L43:
        r114.f514334f = r117;     // Catch: Throwable -> L61
        r114.f514335g = r106;     // Catch: Throwable -> L61
        r114.f514336h = m.h();     // Catch: Throwable -> L61
        if (TextUtils.isEmpty(r114.f514335g) == false) goto L46;
    L50:
        r116 = "0";
    L51:
        r114.f514337i = r116;     // Catch: Throwable -> L61
        if (TextUtils.isEmpty(r107) == false) goto L55;
        r107 = "0";
    L55:
        r114.f514338j = r107;     // Catch: Throwable -> L61
        if (TextUtils.isEmpty(r108) == false) goto L59;
        r108 = "0";
    L59:
        r114.f514339k = r108;     // Catch: Throwable -> L61
        r114.f514340l = r110;     // Catch: Throwable -> L61
        r114.f514341m = r109;     // Catch: Throwable -> L61
        d(r114);     // Catch: Throwable -> L61
        return;
    L46:
        if (TextUtils.isEmpty(r114.f514336h) == true) goto L50;
        if (r114.f514335g.equals(r114.f514336h) == false) goto L50;
    L38:
        if (TextUtils.isEmpty(r114.f514333e) == true) goto L42;
        if (r114.f514332d.equals(r114.f514333e) == false) goto L42;
        r117 = "1";
        goto L43
    L33:
        d.b("DeviceDialogManager", "checkAccountConflict() schema里面activityId为空了 schema = " + r110);     // Catch: Throwable -> L61
        goto L34
    L27:
        if (r104.equals(r111) == true) goto L29;
        d.d("DeviceDialogManager", "checkAccountConflict() 账号冲突；");     // Catch: Throwable -> L61
    L21:
        if (TextUtils.isEmpty(r111) == false) goto L25;
        this.f514322a = r110;     // Catch: Throwable -> L61
        d.d("DeviceDialogManager", "checkAccountConflict() is pending return");     // Catch: Throwable -> L61
        return;
    L16:
        r113 = r112.f533906b.activityInfos;     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        d.b("DeviceDialogManager", th.getMessage());
    }

    public final synchronized void b(String r100) {
        monitor-enter(this);
        d.d("DeviceDialogManager", "deleteFromAppUnionInfo() 清除账号冲突信息 activityId = " + r100);     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r100) == true) goto L11;
        Map<String, C6825a> r101 = this.f514323b;     // Catch: Throwable -> L13
        if (r101 == null) goto L11;
        if (((HashMap) r101).containsKey(r100) == false) goto L11;
        ((HashMap) this.f514323b).remove(r100);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized C6825a c(String r100) {
        monitor-enter(this);
        d.d("DeviceDialogManager", "getFromAppUnionInfo() on call; activityId = " + r100);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r100) == true) goto L13;
        Map<String, C6825a> r101 = this.f514323b;     // Catch: Throwable -> L16
        if (r101 == null) goto L13;
        if (((HashMap) r101).containsKey(r100) == false) goto L13;
        C6825a r102 = (C6825a) ((HashMap) this.f514323b).get(r100);     // Catch: Throwable -> L16
        uk7.m.b().getClass();     // Catch: Throwable -> L16
        r102.f514327d = uk7.m.a(r100);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r102;
    L13:
        monitor-exit(this);
        return null;
    L16:
        th = move-exception;
        throw th;
    }
}
