package lta;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.applog.c0;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.lark.lynxkit.xbridge.BuildConfig;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import jta.n;
import kta.j;
import kta.u;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes6.dex */
public abstract class h {
    public static final ThreadLocal<Boolean> A = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Object f510721r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static j f510722s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Bundle f510723t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile boolean f510724u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static volatile boolean f510725v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static volatile boolean f510726w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static long f510727x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static volatile long f510728y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final List<WeakReference<jta.g.a>> f510729z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f510730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f510731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f510732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f510733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final mta.a f510734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f510735f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SharedPreferences f510736g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f510737h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f510738i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f510739j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f510740k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f510741l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile n f510742m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f510743n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f510744o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final jta.i f510745p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public g f510746q;

    public class a extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f510747v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final /* synthetic */ h f510748w;

        /* JADX INFO: renamed from: lta.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes34.dex */
        public class RunnableC6736a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f510749a;

            public final void a() {
                h r100 = this.f510749a.f510748w;
                monitor-enter(r100);
            L9:
                th = move-exception;
                throw th;
            L5:
                if (this.f510749a.f510748w.f510742m == null) goto L7;
                this.f510749a.f510748w.f510742m.a();     // Catch: Throwable -> L9
                this.f510749a.f510748w.f510742m = null;     // Catch: Throwable -> L9
            L7:
                monitor-exit(r100);     // Catch: Throwable -> L9
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC6736a(a r100, String r101, String r102) {
                this.f510749a = r100;
            }
        }

        public final void l() {
            super.run();
            Throwable r100 = null;
            String r101 = this.f510748w.f510737h.optString("device_id", null);
            h r102 = this.f510748w;
            int r103 = 1;
            boolean r104 = !StringUtils.isEmpty(r101);
            r102.getClass();
            int r105 = h.f510729z.size();
            int r106 = 0;
        L3:
            if (r106 >= r105) goto L15;
            WeakReference r107 = (WeakReference) ListProtector.get(h.f510729z, r106);
            if (r107 == null) goto L14;
            jta.g.a r108 = (jta.g.a) r107.get();
            if (r108 == null) goto L14;
            r108.onDidLoadLocally(r104);     // Catch: Exception -> L12
        L12:
            e = move-exception;
            e.printStackTrace();
        L14:
            r106 = r106 + 1;
        L15:
            Object r109 = h.f510721r;
            if (h.f510726w == true) goto L18;
        L24:
            boolean r110 = false;
        L25:
            if (r110 == true) goto L26;
            long r111 = System.currentTimeMillis();
            if (this.f510748w.f510732c != u.e()) goto L43;
            boolean r112 = true;
        L45:
            if (lta.a.f510715b == false) goto L47;
        L50:
            long r113 = 21600000;
        L51:
            if (r112 == false) goto L53;
            long r114 = 180000;
        L55:
            if (c0.f(this.f510748w.c()) == false) goto L57;
        L60:
            boolean r115 = true;
        L61:
            if (r115 == false) goto L69;
            boolean r116 = NetworkUtils.isNetworkAvailable(this.f510748w.f510735f);
            int r117 = this.f510747v;
            if (r116 == false) goto L65;
            int r118 = 3;
        L66:
            if (r117 <= r118) goto L68;
            r115 = true;
            goto L69
        L68:
            r115 = false;
            goto L69
        L65:
            r118 = 10;
        L69:
            if (r115 == false) goto L71;
            int r119 = this.f510747v + r103;
            this.f510747v = r119;
        L72:
            long r120 = r119;
            if (r120 == 0) goto L75;
            r114 = 4000 * r120;
        L75:
            h r121 = this.f510748w;
            long r122 = r113 - (r111 - r121.f510738i);
            long r123 = r114 - (r111 - r121.f510739j);
            if (r122 > 0) goto L78;
        L80:
            long r124 = Math.max(r122, r123);
            h r125 = this.f510748w;
            if (r125.f510744o == true) goto L83;
        L85:
            r113 = r124;
        L87:
            if (Logger.debug() == true) goto L89;
            Throwable r126 = null;
        L94:
            Object r127 = this.f510748w.f510730a;
            monitor-enter(r127);
            if (r113 > 0) goto L118;
        L102:
            Object r128 = h.f510721r;     // Catch: Throwable -> L116
            monitor-exit(r127);     // Catch: Throwable -> L116
            monitor-enter(this);
            n();     // Catch: Throwable -> L111
            h r129 = this.f510748w;     // Catch: Throwable -> L111
            if (r129.f510744o == false) goto L108;
            r103 = 1;
            r129.f510733d++;     // Catch: Throwable -> L111
        L109:
            monitor-exit(this);     // Catch: Throwable -> L111
            r100 = r126;
            goto L15
        L108:
            r103 = 1;
        L111:
            th = move-exception;
            throw th;
        L118:
            this.f510748w.f510730a.wait(r113);     // Catch: InterruptedException -> L100 Throwable -> L116
        L100:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L116
        L116:
            th = move-exception;
            throw th;
        L89:
            if (r113 < 0) goto L92;
            r111 = r111 + r113;
        L92:
            r126 = null;
            ita.j.b("RegisterServiceController next query time : " + DateFormat.getDateTimeInstance().format(new Date(r111)), null);
            goto L94
        L83:
            if (r125.f510733d != jta.g.f500374h) goto L85;
            h.a(this.f510748w);
            this.f510748w.f510733d = 0;
            goto L87
        L78:
            if (r121.f510744o == false) goto L80;
            r121.f510733d = 0;
            goto L80
        L71:
            r119 = 0;
            goto L72
        L57:
            if (c0.f(this.f510748w.f510740k) == true) goto L60;
            r115 = false;
            goto L61
        L53:
            r114 = 30000;
            goto L55
        L47:
            if (h.f510727x >= 0) goto L50;
            if (r112 == false) goto L50;
            r113 = com.heytap.mcssdk.constant.a.f276320g;
            goto L51
        L43:
            r112 = false;
            goto L45
        L26:
            Object r130 = this.f510748w.f510730a;
            monitor-enter(r130);
            if (Logger.debug() == false) goto L126;
            ita.j.b("RegisterServiceController throttle by applog/settings sThrottleByAppLogConfig=" + h.f510726w + " did=" + this.f510748w.c() + " iid=" + this.f510748w.f510740k, r100);     // Catch: Throwable -> L37
        L126:
            this.f510748w.f510730a.wait(TimeUnit.MINUTES.toMillis(1));     // Catch: InterruptedException -> L33 Throwable -> L37
        L35:
            monitor-exit(r130);     // Catch: Throwable -> L37
            goto L15
        L33:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L37
        L37:
            th = move-exception;
            throw th;
        L18:
            if (c0.f(this.f510748w.c()) == true) goto L24;
            if (c0.f(this.f510748w.f510740k) == true) goto L24;
            if (this.f510748w.f510732c != u.e()) goto L24;
            r110 = true;
            goto L25
        }

        public final void n() {
            if (h.f510725v == false) goto L5;
            return;
        L5:
            jta.g r100 = jta.g.f500367a;
            long r101 = System.currentTimeMillis();     // Catch: Exception -> L98
            if (h.f510728y > 0) goto L9;
            h.f510728y = r101;     // Catch: Exception -> L98
        L9:
            h r102 = this.f510748w;     // Catch: Exception -> L98
            r102.f510739j = r101;     // Catch: Exception -> L98
            if (NetworkUtils.isNetworkAvailable(r102.f510735f) == true) goto L13;
            com.ss.android.common.applog.e.a().b(StatsCountKeys.NO_NETWORK_COUNT, 1);     // Catch: Exception -> L98
            h.a(this.f510748w);     // Catch: Exception -> L98
            return;
        L13:
            Context r103 = this.f510748w.f510735f;     // Catch: Exception -> L98
            if (StringUtils.isEmpty(u.f506147k) == false) goto L16;
            u.f506147k = r103.getSharedPreferences(kta.b.f506097a, 0).getString(com.alipay.sdk.m.l.b.f25480b, null);     // Catch: Exception -> L98
        L16:
            String r104 = u.f506147k;     // Catch: Exception -> L98
            if (StringUtils.isEmpty(r104) == true) goto L19;
            this.f510748w.f510737h.put(com.alipay.sdk.m.l.b.f25480b, r104);     // Catch: Exception -> L98
        L19:
            this.f510748w.getClass();     // Catch: Exception -> L98
            if (StringUtils.isEmpty(null) == true) goto L22;
            this.f510748w.f510737h.put("app_track", null);     // Catch: Exception -> L98
        L22:
            JSONObject r105 = new JSONObject(new JSONTokener(this.f510748w.f510737h.toString()));     // Catch: Exception -> L98
            r105.put("req_id", jta.g.f500376j.getRequestId());     // Catch: Exception -> L98
            if (this.f510748w.f510731b == false) goto L25;
            r105.put("scene", 2);     // Catch: Exception -> L98
        L25:
            r105.put("device_platform", "android");     // Catch: Exception -> L98
            lta.b.a(r105);     // Catch: Exception -> L98
            Bundle r106 = new Bundle();     // Catch: Throwable -> L57
            Bundle r107 = h.f510723t;     // Catch: Throwable -> L57
            monitor-enter(r107);     // Catch: Throwable -> L57
            r106.putAll(r107);     // Catch: Throwable -> L54
            monitor-exit(r107);     // Catch: Throwable -> L54
        L31:
            if (r106.size() <= 0) goto L38;
            JSONObject r108 = new JSONObject();     // Catch: Throwable -> L57
            Iterator<String> r109 = r106.keySet().iterator();     // Catch: Throwable -> L57
        L34:
            if (r109.hasNext() == false) goto L36;
            String r110 = r109.next();     // Catch: Throwable -> L57
            r108.put(r110, r106.get(r110));     // Catch: Throwable -> L57
            goto L34
        L36:
            r105.put("custom", r108);     // Catch: Throwable -> L57
        L38:
            if (TextUtils.isEmpty(null) == true) goto L41;
            r105.put("app_trait", null);     // Catch: Throwable -> L57
        L41:
            if (this.f510748w.f510731b == true) goto L48;
            if (jta.g.g(this.f510748w.f510735f) == true) goto L48;
            if (jta.g.f500372f == true) goto L48;
            Context r111 = this.f510748w.f510735f;     // Catch: Throwable -> L57
        L48:
            if (StringUtils.isEmpty(null) == true) goto L51;
            r105.put(EffectConfiguration.KEY_APP_LANGUAGE, null);     // Catch: Throwable -> L57
        L51:
            if (StringUtils.isEmpty(null) == true) goto L58;
            r105.put("app_region", null);     // Catch: Throwable -> L57
        L58:
            h r112 = this.f510748w;     // Catch: Exception -> L98
            r112.getClass();     // Catch: Exception -> L98
            PackageInfo r113 = r112.f510735f.getPackageManager().getPackageInfo(r112.f510735f.getPackageName(), 0);     // Catch: Throwable -> L67
            if (r113 == null) goto L69;
            r105.put("apk_first_install_time", r113.firstInstallTime);     // Catch: Throwable -> L67
            if ((r113.applicationInfo.flags & 1) != 1) goto L64;
            int r114 = 1;
        L65:
            r105.put("is_system_app", r114);     // Catch: Throwable -> L67
        L64:
            r114 = 0;
        L69:
            r105.put("sdk_version", "3.10.6");     // Catch: Exception -> L98
            r105.put("sdk_flavor", BuildConfig.FLAVOR);     // Catch: Exception -> L98
            if (jta.g.f500372f == false) goto L72;
            int r115 = 1;
        L73:
            r105.put("guest_mode", r115);     // Catch: Exception -> L98
            u.b(r105);     // Catch: Exception -> L98
            JSONObject r116 = new JSONObject();     // Catch: Exception -> L98
            r116.put("magic_tag", "ss_app_log");     // Catch: Exception -> L98
            r116.put("header", r105);     // Catch: Exception -> L98
            r116.put("_gen_time", System.currentTimeMillis());     // Catch: Exception -> L98
            h.f510725v = true;     // Catch: Exception -> L98
            h.A.set(Boolean.TRUE);     // Catch: Exception -> L98
            boolean r117 = m(r116.toString(), r105);     // Catch: Exception -> L98
            if (r117 == false) goto L83;
            System.currentTimeMillis();     // Catch: Exception -> L98
            if (h.f510728y <= 0) goto L78;
            h.f510728y = 0;     // Catch: Exception -> L98
        L78:
            h r118 = this.f510748w;     // Catch: Exception -> L98
            g r119 = r118.f510746q;     // Catch: Exception -> L98
            if (r119 == null) goto L83;
            b r120 = r118.f510743n;     // Catch: Exception -> L98
            if (r120 == null) goto L83;
            r120.b(r119);     // Catch: Exception -> L98
        L83:
            Object r121 = h.f510721r;     // Catch: Exception -> L98
            monitor-enter(r121);     // Catch: Exception -> L98
            h.f510725v = false;     // Catch: Throwable -> L95
            r121.notifyAll();     // Catch: Exception -> L88 Throwable -> L95
        L90:
            monitor-exit(r121);     // Catch: Throwable -> L95
            h.f510724u = true;     // Catch: Exception -> L98
            h.A.remove();     // Catch: Exception -> L98
            if (r117 == true) goto L112;
            String r122 = ((jta.a) this.f510748w.f510734e).c();     // Catch: Exception -> L98
            h.b(this.f510748w, false, StringUtils.isEmpty(r122));     // Catch: Exception -> L98
            return;
        L112:
            return;
        L88:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L95
        L95:
            th = move-exception;
            throw th;     // Catch: Exception -> L98
        L72:
            r115 = 0;
        L67:
            th = move-exception;
            th.printStackTrace();     // Catch: Exception -> L98
        L54:
            th = move-exception;
            throw th;     // Catch: Throwable -> L57
        L57:
            com.ss.android.common.applog.e.a().b(StatsCountKeys.JSON_ERROR_COUNT, 1);     // Catch: Exception -> L98
        L98:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            l();     // Catch: Throwable -> L4
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(e r100) {
            this.f510748w = r100;
            super("DeviceRegisterThread");
            this.f510747v = 0;
        }

        public final boolean o(JSONObject r110) {
            this.f510748w.f510732c = u.e();
            r110.optInt("new_user", 0);
            Object r100 = h.f510721r;
            SharedPreferences.Editor r101 = this.f510748w.f510736g.edit();
            r101.putInt("last_config_version", this.f510748w.f510732c);
            r101.putString("dr_channel", u.c(this.f510748w.f510735f));
            h r102 = this.f510748w;
            String r103 = r102.f510740k;
            String r104 = ((jta.a) r102.f510734e).c();
            boolean r105 = StringUtils.isEmpty(r104);
            String r106 = r110.optString("install_id", null);
            String r107 = r110.optString("device_id", null);
            String r108 = r110.optString(RemoteMessageConst.DEVICE_TOKEN, "");
            String r109 = r110.optString("klink_egdi", "");
            boolean r111 = c0.f(r107);
            boolean r112 = c0.f(r106);
            c0.f(r109);
            jta.g r113 = jta.g.f500367a;
            if (r111 == true) goto L7;
            if (r112 == true) goto L7;
            this.f510748w.f510738i = System.currentTimeMillis();
            r101.putLong("last_config_time", this.f510748w.f510738i);
        L7:
            if (r112 == false) goto L9;
        L18:
            boolean r114 = false;
        L19:
            if (r111 == false) goto L21;
        L45:
            if (r111 == false) goto L47;
            Object r115 = h.f510721r;
        L47:
            if (r114 == true) goto L89;
        L51:
            r101.putString(RemoteMessageConst.DEVICE_TOKEN, r108);
            r101.commit();
            if (r114 == false) goto L84;
            jta.a r116 = (jta.a) this.f510748w.f510734e;
            r116.getClass();
            if (c0.f(r107) == false) goto L56;
        L59:
            h r117 = this.f510748w;
            String r118 = ((jta.a) r117.f510734e).c();
            String r119 = r117.f510740k;
            Object r120 = u.f506149m;
            monitor-enter(r120);
        L81:
            th = move-exception;
            throw th;
        L62:
            if (u.f506145i != null) goto L99;
        L67:
            monitor-exit(r120);     // Catch: Throwable -> L81
            int r121 = h.f510729z.size();
            int r122 = 0;
        L69:
            if (r122 >= r121) goto L84;
            WeakReference r123 = (WeakReference) ListProtector.get(h.f510729z, r122);
            if (r123 == null) goto L80;
            jta.g.a r124 = (jta.g.a) r123.get();
            if (r124 == null) goto L80;
            r124.onDeviceRegistrationInfoChanged(((jta.a) r117.f510734e).c(), r117.f510740k);     // Catch: Exception -> L78
        L78:
            e = move-exception;
            e.printStackTrace();
        L80:
            r122 = r122 + 1;
            goto L69
        L99:
            u.f506145i.put("device_id", r118);     // Catch: JSONException -> L65 Throwable -> L81
            u.f506145i.put("install_id", r119);     // Catch: JSONException -> L65 Throwable -> L81
        L65:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L81
            goto L67
        L56:
            if (StringUtils.equal(r107, jta.a.f500345g) == true) goto L59;
            jta.a.f500345g = r116.f500347b.d(r107, jta.a.f500345g);
        L84:
            h.b(this.f510748w, true, r105);
            if (this.f510748w.f510742m == null) goto L88;
            new Handler(Looper.getMainLooper()).post(new RunnableC6736a(this, r107, r106));
        L88:
            return !r111;
        L89:
            h r125 = this.f510748w;     // Catch: Exception -> L50
            r125.f510737h.put("install_id", r125.f510740k);     // Catch: Exception -> L50
            this.f510748w.f510737h.put("device_id", r107);     // Catch: Exception -> L50
            this.f510748w.f510737h.put("klink_egdi", r109);     // Catch: Exception -> L50
            r101.putString("install_id", this.f510748w.f510740k);     // Catch: Exception -> L50
            r101.putString("device_id", r107);     // Catch: Exception -> L50
            r101.putString("klink_egdi", r109);     // Catch: Exception -> L50
            goto L51
        L21:
            if (r107.equals(r104) == true) goto L45;
            e r126 = (e) this.f510748w;
            r126.getClass();
            if (StringUtils.isEmpty(r104) == false) goto L95;
        L44:
            r114 = true;
            goto L45
        L95:
            JSONObject r127 = new JSONObject();     // Catch: Exception -> L43
            String r128 = r126.e();     // Catch: Exception -> L43
            if (jta.g.f500372f == true) goto L39;
            String r129 = ((jta.e) r126.f510734e).g();     // Catch: Exception -> L43
            String r130 = ((jta.e) r126.f510734e).e();     // Catch: Exception -> L43
            if (StringUtils.isEmpty(r129) == true) goto L30;
            r127.put("udid", r129);     // Catch: Exception -> L43
        L30:
            if (StringUtils.isEmpty(r130) == true) goto L33;
            r127.put("serial_number", r130);     // Catch: Exception -> L43
        L33:
            if ((!u.f506152p) == false) goto L39;
            String[] r131 = ((jta.e) r126.f510734e).f();     // Catch: Exception -> L43
            if (r131 == null) goto L39;
            if (r131.length <= 0) goto L39;
            r127.put("sim_serial_number", Arrays.toString(r131));     // Catch: Exception -> L43
        L39:
            String r132 = ((jta.a) r126.f510734e).b();     // Catch: Exception -> L43
            r127.put("old_id", r104);     // Catch: Exception -> L43
            r127.put("new_id", r107);     // Catch: Exception -> L43
            r127.put("openudid", r128);     // Catch: Exception -> L43
            r127.put("clientudid", r132);     // Catch: Exception -> L43
            if (h.f510722s == null) goto L44;
            AppLogNewUtils.onEventV3("did_change", r127);     // Catch: Exception -> L43
            goto L44
        L9:
            if (r106.equals(this.f510748w.f510740k) == true) goto L18;
            this.f510748w.f510740k = r106;
            if (StringUtils.isEmpty(r103) == false) goto L97;
        L17:
            r114 = true;
            goto L19
        L97:
            JSONObject r133 = new JSONObject();     // Catch: Exception -> L16
            r133.put("old_id", r103);     // Catch: Exception -> L16
            r133.put("new_id", r106);     // Catch: Exception -> L16
            this.f510748w.getClass();     // Catch: Exception -> L16
            if (h.f510722s == null) goto L17;
            AppLogNewUtils.onEventV3("iid_change", r133);     // Catch: Exception -> L16
            goto L17
        }

        public final boolean m(String r210, JSONObject r211) {
            ita.j.b("RegisterServiceController app_log_config: " + r210, null);     // Catch: Throwable -> L70
            byte[] r100 = r210.getBytes("UTF-8");     // Catch: Throwable -> L70
            h r101 = this.f510748w;     // Catch: Throwable -> L70
            System.currentTimeMillis();     // Catch: Throwable -> L70
            r101.getClass();     // Catch: Throwable -> L70
            String[] r102 = lta.a.f510714a;     // Catch: Throwable -> L70
            if (r102 != null) goto L6;
        L10:
            String[] r103 = {"https://ib.snssdk.com/service/2/device_register/", "https://ib.snssdk.com/service/2/device_register/"};     // Catch: Throwable -> L70
        L11:
            String[] r110 = r103;
            if (r110 == null) goto L69;
            int r111 = r110.length;     // Catch: Throwable -> L70
            int r112 = 0;
        L14:
            if (r112 >= r111) goto L67;
            String r104 = r110[r112];     // Catch: Throwable -> L70
            byte[] r113 = (byte[]) r100.clone();     // Catch: Throwable -> L70
            if (StringUtils.isEmpty(r104) == false) goto L19;
            r112 = r112;
            r111 = r111;
        L65:
            r112 = r112 + 1;     // Catch: Throwable -> L70
            r111 = r111;
            goto L14
        L19:
            if (Logger.debug() == false) goto L22;
            ita.j.b("RegisterServiceController request url : " + r104, null);     // Catch: Throwable -> L70
        L22:
            if (TextUtils.isEmpty(r211.optString("device_id")) == false) goto L24;
        L27:
            boolean r105 = true;
        L71:
            if (r104.indexOf(63) >= 0) goto L32;
            String r106 = r104 + "?";     // Catch: Throwable -> L35 RuntimeException -> L37
        L33:
            String r107 = c0.h(null, r106, r113, this.f510748w.f510735f, false, null, null, r105, false);     // Catch: Throwable -> L35 RuntimeException -> L37
        L73:
            ita.j.f("device_register response: " + r107);     // Catch: Throwable -> L50
            if (r107 != null) goto L43;
        L48:
            com.ss.android.common.applog.e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);     // Catch: Throwable -> L50
            goto L65
        L43:
            if (r107.length() == 0) goto L48;
            if (o(new JSONObject(r107)) == false) goto L65;
            return true;
        L50:
            th = th;
        L51:
            com.ss.android.common.applog.e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);     // Catch: Throwable -> L70
            h r108 = this.f510748w;     // Catch: Throwable -> L70
            r108.getClass();     // Catch: Throwable -> L70
            if ((th instanceof CommonHttpException) == false) goto L63;
            int r109 = th.getResponseCode();     // Catch: Throwable -> L70
            if (r108.f510744o == true) goto L63;
            if (r109 < 200) goto L63;
            if (r109 == 301) goto L63;
            if (r109 == 302) goto L63;
            boolean r114 = false;
        L64:
            if (r114 == true) goto L65;
            throw th;     // Catch: Throwable -> L70
        L63:
            r114 = true;
            goto L64
        L32:
            r106 = r104 + "&";     // Catch: Throwable -> L35 RuntimeException -> L37
            goto L33
        L37:
            com.ss.android.common.applog.e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);     // Catch: Throwable -> L35
            r107 = c0.e(null, r104, r100, true, "application/json; charset=utf-8", null, r105, false);     // Catch: Throwable -> L50
        L35:
            th = th;
            r112 = r112;
            r111 = r111;
            goto L51
        L24:
            if (TextUtils.isEmpty(r211.optString("install_id")) == true) goto L27;
            r105 = false;
            goto L71
        L67:
            return false;
        L69:
            throw new IllegalArgumentException("url is null");     // Catch: Throwable -> L70
        L6:
            if (r102.length <= 0) goto L10;
            if (StringUtils.isEmpty(r102[0]) == true) goto L10;
            r103 = lta.a.f510714a;     // Catch: Throwable -> L70
        L70:
            return false;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<WeakReference<a>> f510750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f510751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Context f510752c;

        public interface a {
            void onNetworkReady();
        }

        public b(Context r100) {
            this.f510750a = Collections.synchronizedSet(new HashSet());
            this.f510751b = new AtomicBoolean(false);
            this.f510752c = r100;
        }

        public final synchronized void b(g r100) {
            monitor-enter(this);
            Iterator<WeakReference<a>> r101 = this.f510750a.iterator();     // Catch: Throwable -> L14
        L5:
            if (r101.hasNext() == false) goto L12;
            WeakReference<a> r102 = r101.next();     // Catch: Throwable -> L14
            if (r102 == null) goto L8;
            if (r102.get() != r100) goto L5;
            r101.remove();     // Catch: Throwable -> L14
            goto L12
        L8:
            r101.remove();     // Catch: Throwable -> L14
        L12:
            monitor-exit(this);
            return;
        L14:
            th = move-exception;
            throw th;
        }

        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
        public static void a(Context r100, i r101, IntentFilter r110) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        L39:
        L33:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
            ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
            return;
        L38:
            throw e;
        L6:
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
            if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
            int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L33
            if (r102 != 1) goto L12;
            r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
            return;
        L12:
            if (r102 != 2) goto L14;
            new Intent();     // Catch: Exception -> L33
            return;
        L14:
            if (r102 == 3) goto L40;
            r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
            return;
        L40:
            return;
        L22:
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
            ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
            r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
            return;
        L26:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
        L31:
            r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
            return;
        L28:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L31;
            ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
            ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
        }
    }

    static {
        f510721r = new Object();
        f510723t = new Bundle();
        f510724u = false;
        f510725v = false;
        f510726w = false;
        f510727x = 0;
        f510729z = Collections.synchronizedList(new ArrayList());
        A = new ThreadLocal();
    }

    public final String c() {
        return ((jta.a) this.f510734e).c();
    }

    public final String d() {
        jta.i r100 = this.f510745p;
        if (TextUtils.isEmpty(r100.f500380a) == false) goto L7;
        ita.j.e("[egdi] get egdi from sp.");
        String r101 = r100.f500381b.getString("klink_egdi", "");
        r100.f500380a = r101;
        return r101;
    L7:
        return r100.f500380a;
    }

    public final String e() {
        if (this.f510731b == false) goto L6;
        return "";
    L6:
        jta.a r100 = (jta.a) this.f510734e;
        r100.getClass();
        if (StringUtils.isEmpty(jta.a.f500343e) == false) goto L48;
        Context r101 = r100.f500346a;
        pta.c.a r102 = pta.c.f530684a;
        String r103 = pta.c.e(r101.getContentResolver());     // Catch: Exception -> L12
    L15:
        if (r103 != null) goto L43;
    L20:
        SharedPreferences r104 = r100.f500346a.getSharedPreferences(kta.b.a(), 0);     // Catch: Exception -> L33
        String r105 = r104.getString("openudid", null);     // Catch: Exception -> L33
        if (pta.b.b(r105) == true) goto L32;
        r105 = new BigInteger(80, new SecureRandom()).toString(16);     // Catch: Exception -> L33
        if (r105.charAt(0) != '-') goto L25;
        r105 = r105.substring(1);     // Catch: Exception -> L33
    L25:
        int r106 = 13 - r105.length();     // Catch: Exception -> L33
        if (r106 <= 0) goto L31;
        StringBuilder r107 = new StringBuilder();     // Catch: Exception -> L33
    L28:
        if (r106 <= 0) goto L30;
        r107.append('F');     // Catch: Exception -> L33
        r106 = r106 - 1;     // Catch: Exception -> L33
        goto L28
    L30:
        r107.append(r105);     // Catch: Exception -> L33
        r105 = r107.toString();     // Catch: Exception -> L33
    L31:
        SharedPreferences.Editor r108 = r104.edit();     // Catch: Exception -> L33
        r108.putString("openudid", r105);     // Catch: Exception -> L33
        r108.commit();     // Catch: Exception -> L33
    L33:
        e = move-exception;
        ita.j.c("DeviceParamsProviderexception when making openudid: ", e);
    L36:
        if (StringUtils.isEmpty(r103) == true) goto L38;
        String r109 = r103 + r100.f500349d;
    L40:
        if (StringUtils.isEmpty(r109) == true) goto L49;
        jta.a.f500343e = r109;
        return r109;
    L49:
        return r109;
    L38:
        r109 = r103;
    L32:
        r103 = r105;
        goto L36
    L43:
        if (r103.equals("9774d56d682e549c") == true) goto L20;
        if (r103.length() >= 13) goto L36;
    L12:
        e = move-exception;
        e.printStackTrace();
        r103 = null;
        goto L15
    L48:
        return jta.a.f500343e;
    }

    public final void f() {
        Object r100 = this.f510730a;
        monitor-enter(r100);
        this.f510730a.notifyAll();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void a(h r100) {
        if (r100.f510743n != null) goto L5;
        r100.f510743n = new b(r100.f510735f);
    L5:
        r100.f510746q = new g(r100);
        b r101 = r100.f510743n;
        g r102 = r100.f510746q;
        monitor-enter(r101);
        r101.f510750a.add(new WeakReference(r102));     // Catch: Throwable -> L16
        if (r101.f510751b.compareAndSet(false, true) == false) goto L14;
        i r103 = new i(r101);     // Catch: Throwable -> L16
        IntentFilter r104 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L16
        b.a(r101.f510752c, r103, r104);     // Catch: Exception -> L12 Throwable -> L16
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
    L14:
        monitor-exit(r101);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public h(Context r100, boolean r101) {
        this.f510730a = new Object();
        this.f510738i = 0;
        this.f510739j = 0;
        this.f510735f = r100;
        this.f510734e = jta.h.a(r100);
        boolean r102 = false;
        this.f510736g = r100.getSharedPreferences(kta.b.f506097a, 0);
        this.f510731b = r101;
        if (jta.g.f500374h == (-1)) goto L5;
        r102 = true;
    L5:
        this.f510744o = r102;
        this.f510745p = new jta.i(r100);
    }

    public static void g(Context r100, long r101) {
        if (A.get() == null) goto L5;
        return;
    L5:
        String r102 = null;
        String r103 = ((jta.a) jta.h.a(r100)).c();     // Catch: Exception -> L8
    L10:
        if (StringUtils.isEmpty(r103) == true) goto L12;
        return;
    L12:
        Object r104 = f510721r;
        monitor-enter(r104);
    L41:
        th = move-exception;
        throw th;
    L15:
        if (f510724u == false) goto L46;
        monitor-exit(r104);     // Catch: Throwable -> L41
        return;
    L46:
        r102 = ((jta.a) jta.h.a(r100)).c();     // Catch: Exception -> L44 Throwable -> L41
    L20:
        if (StringUtils.isEmpty(r102) == true) goto L24;
        monitor-exit(r104);     // Catch: Throwable -> L41
        return;
    L24:
        if (f510725v == false) goto L26;
        long r105 = 4000;
    L28:
        if (r101 != (-1)) goto L30;
    L49:
        r104.wait(r105);     // Catch: Exception -> L45 Throwable -> L41
    L38:
        f510724u = true;     // Catch: Throwable -> L41
        monitor-exit(r104);     // Catch: Throwable -> L41
        return;
    L30:
        if (r101 <= 120000) goto L33;
        r101 = 120000;
    L35:
        r105 = r101;
        goto L49
    L33:
        if (r101 >= 0) goto L35;
        r101 = 1000;
        goto L35
    L26:
        r105 = 1500;
    L8:
        r103 = null;
        goto L10
    }

    public static void b(h r100, boolean r101, boolean r102) {
        r100.getClass();
        int r103 = f510729z.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L15;
        WeakReference r105 = (WeakReference) ListProtector.get(f510729z, r104);
        if (r105 == null) goto L14;
        jta.g.a r106 = (jta.g.a) r105.get();
        if (r106 == null) goto L14;
        r106.onRemoteConfigUpdate(r101, r102);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        r104 = r104 + 1;
        goto L3
    }
}
