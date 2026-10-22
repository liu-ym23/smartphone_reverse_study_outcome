package com.bytedance.lynx.webview.internal;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.lynx.webview.TTWebSdk;
import com.bytedance.lynx.webview.bean.PrepareInfo;
import com.bytedance.lynx.webview.preparation.PrepareInfoNG;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class Setting {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f265158j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AtomicBoolean f265159k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f265160l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Setting f265161m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final AtomicBoolean f265162n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final AtomicBoolean f265163o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final c0 f265164p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f265165q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f265166r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f265167s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f265168t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f265169u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f265170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile ConcurrentHashMap<String, Object> f265171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TTWebSdk.g f265172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<Runnable> f265173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReadWriteLock f265174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CountDownLatch f265175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f265176g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PrepareInfo f265177h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicReference<RequestSource> f265178i;

    public static final enum RequestSource extends Enum<RequestSource> {
        public static final RequestSource LAUNCH = null;
        public static final RequestSource LAUNCH_CRASH = null;
        public static final RequestSource LAUNCH_LONG_TIME = null;
        public static final RequestSource LAUNCH_NO_CONFIG = null;
        public static final RequestSource LAUNCH_RETRY = null;
        public static final RequestSource LAUNCH_SDK_VERSION_CHANGED = null;
        public static final RequestSource LOOP = null;
        public static final RequestSource PUSH_ASYNC = null;
        public static final RequestSource PUSH_SYNC = null;
        public static final RequestSource RETRY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RequestSource[] f265179a = null;
        private final String value;

        static {
            RequestSource r100 = new RequestSource("PUSH_ASYNC", 0, "push:async");
            PUSH_ASYNC = r100;
            RequestSource r101 = new RequestSource("PUSH_SYNC", 1, "push:sync");
            PUSH_SYNC = r101;
            RequestSource r102 = new RequestSource("RETRY", 2, EventConstant.Value.RETRY);
            RETRY = r102;
            RequestSource r103 = new RequestSource("LAUNCH_NO_CONFIG", 3, "launch:no_config");
            LAUNCH_NO_CONFIG = r103;
            RequestSource r104 = new RequestSource("LAUNCH_RETRY", 4, "launch:retry");
            LAUNCH_RETRY = r104;
            RequestSource r105 = new RequestSource("LAUNCH_LONG_TIME", 5, "launch:long_time");
            LAUNCH_LONG_TIME = r105;
            RequestSource r110 = new RequestSource("LAUNCH_CRASH", 6, "launch:for_crash");
            LAUNCH_CRASH = r110;
            RequestSource r111 = new RequestSource("LAUNCH", 7, EventVerify.TYPE_LAUNCH);
            LAUNCH = r111;
            RequestSource r112 = new RequestSource("LOOP", 8, "loop");
            LOOP = r112;
            RequestSource r113 = new RequestSource("LAUNCH_SDK_VERSION_CHANGED", 9, "launch:sdk_version_changed");
            LAUNCH_SDK_VERSION_CHANGED = r113;
            f265179a = new RequestSource[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        }

        public static RequestSource[] values() {
            return (RequestSource[]) f265179a.clone();
        }

        public String getValue() {
            return this.value;
        }

        public static RequestSource valueOf(String r100) {
            return (RequestSource) r27.a.a(RequestSource.class, r100);
        }

        public RequestSource(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TTWebSdk.h f265180a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f265180a.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(TTWebSdk.h r100) {
            this.f265180a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Setting f265181a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f265181a.j();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(Setting r100) {
            this.f265181a = r100;
        }
    }

    public class c implements g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Setting f265182a;

        public c(Setting r100) {
            this.f265182a = r100;
        }

        @Override // com.bytedance.lynx.webview.internal.g.b
        public final void a(JSONObject r100) {
            TTWebSdk.g r101 = this.f265182a.f265172c;
            if (r101 == null) goto L6;
            ((g0) r101).f265319a.f265175f.countDown();
            this.f265182a.f265172c = null;
            return;
        }

        @Override // com.bytedance.lynx.webview.internal.g.b
        public final void b(JSONObject r210, boolean r211) {
            l17.k.d(new String[]{"Setting JCM Listener onConfigLoaded isValid " + r211});     // Catch: Throwable -> L99
            if (l17.d.f506995a == false) goto L6;
            JSONObject r100 = l17.d.a();     // Catch: Throwable -> L99
        L7:
            this.f265182a.p(r100);     // Catch: Throwable -> L99
            String r101 = JSONObjectProtectorUtils.getString(r100, "sdk_upto_so_versioncode");     // Catch: JSONException -> L17 Throwable -> L99
            String r102 = JSONObjectProtectorUtils.getString(r100, "sdk_upto_so_md5");     // Catch: JSONException -> L15 Throwable -> L99
            boolean r103 = r100.optBoolean("sdk_is_builtin", false);     // Catch: JSONException -> L13 Throwable -> L99
            String r110 = r101;
            String r111 = r102;
        L22:
            if (Setting.f265168t == false) goto L102;
        L31:
            r.d("[Settings] Config has loaded. update_version_code: " + r110);     // Catch: Throwable -> L99
            c0 r104 = Setting.f265164p;     // Catch: Throwable -> L99
            r104.f265273b.edit().putString("config_url", g.f265301i).apply();     // Catch: Throwable -> L99
            com.bytedance.lynx.webview.internal.e.c(r100, TTWebContext.h().getContext());     // Catch: Throwable -> L99
            TTWebContext.h();     // Catch: Throwable -> L99
            if (TextUtils.isEmpty(TTWebContext.f265209u) == false) goto L35;
            TTWebContext.f265209u = l17.n.b(TTWebContext.h().f265215a);     // Catch: Throwable -> L99
        L35:
            if (TTWebContext.b(TTWebContext.f265209u) == false) goto L37;
            int r105 = 1;
        L38:
            r104.f265273b.edit().putInt("enable_ttwebview_status", r105).apply();     // Catch: Throwable -> L99
            long r106 = this.f265182a.d("sdk_set_delay_download_on_the_stage", -1);     // Catch: Throwable -> L99
            if (r106 > 0) goto L43;
            r106 = 5000;
        L43:
            if (TTWebContext.f265212x == false) goto L52;
            if (this.f265182a.f265171b != null) goto L47;
        L50:
            l17.k.d(new String[]{"active download"});     // Catch: Throwable -> L99
            r106 = 10;
            goto L52
        L47:
            if (TextUtils.isEmpty(this.f265182a.g("sdk_download_url")) == false) goto L50;
            l17.k.d(new String[]{"Download url empty"});     // Catch: Throwable -> L99
            TTWebContext.j().d(-4);     // Catch: Throwable -> L99
            return;
        L52:
            if (Setting.f265160l == false) goto L54;
            r106 = 0;
        L54:
            if (r103 == false) goto L58;
            PrepareInfo.Source r107 = PrepareInfo.Source.BUILTIN;     // Catch: Throwable -> L99
        L56:
            PrepareInfo.Source r112 = r107;
            Setting r108 = this.f265182a;     // Catch: Throwable -> L99
            long r109 = r106;
            String r113 = r111;
            String r114 = r110;
            r108.f265177h = new PrepareInfo(r110, r111, r112, r108.g("sdk_download_url"), this.f265182a.g("sdk_signdata"), this.f265182a.g("sdk_hostabi"), r109);     // Catch: Throwable -> L99
            Setting.f265165q = true;     // Catch: Throwable -> L99
            r104.f265273b.edit().putLong("last_update_time", System.currentTimeMillis()).apply();     // Catch: Throwable -> L99
            r104.f265273b.edit().putString("last_settings_sdk_version", k17.a.f501381b).apply();     // Catch: Throwable -> L99
            r.d("[Settings] Local config has been updated.");     // Catch: Throwable -> L99
            if (this.f265182a.f265172c == null) goto L68;
            String r115 = r104.c();     // Catch: Throwable -> L99
            TTWebSdk.g r116 = this.f265182a.f265172c;     // Catch: Throwable -> L99
            if (r115.equals(r113) == true) goto L66;
            this.f265182a.f265177h.a();     // Catch: Throwable -> L99
        L66:
            ((g0) r116).f265319a.f265175f.countDown();     // Catch: Throwable -> L99
            this.f265182a.f265172c = null;     // Catch: Throwable -> L99
        L68:
            if (TextUtils.isEmpty(r114) == false) goto L70;
        L97:
            com.bytedance.lynx.webview.a.e(this.f265182a.f265177h, EventType.PREPARE_SETTING_NO_UPTO);     // Catch: Throwable -> L99
            return;
        L70:
            if (TextUtils.isEmpty(r113) == true) goto L97;
            if (l17.n.d(TTWebContext.h().getContext()) == false) goto L97;
            String r117 = this.f265182a.f265177h.f475074a;     // Catch: Throwable -> L99
            String r118 = r117.substring(r117.length() - 3);     // Catch: Throwable -> L99
            String r119 = TTWebContext.g();     // Catch: Throwable -> L99
            int r120 = CastIntegerProtector.parseInt(r118);     // Catch: Throwable -> L99
            if (r120 > 400) goto L76;
        L77:
            if (r120 < 400) goto L79;
        L81:
            boolean r121 = false;
        L82:
            if (r121 == false) goto L96;
            String r122 = r104.c();     // Catch: Throwable -> L99
            if (r122 == null) goto L89;
            if (r122.equals(r113) == true) goto L89;
            com.bytedance.lynx.webview.a.e(this.f265182a.f265177h, EventType.PREPARE_SETTING_NEW_UPTO);     // Catch: Throwable -> L99
        L89:
            if (TTWebContext.t() == false) goto L94;
            if (this.f265182a.b("sdk_is_builtin", false) == false) goto L94;
            Setting r123 = this.f265182a;     // Catch: Throwable -> L99
            r123.f265177h.f265079f = 0;     // Catch: Throwable -> L99
            r123.l(0, true);     // Catch: Throwable -> L99
            return;
        L94:
            if (TTWebContext.I == true) goto L112;
            this.f265182a.m(r109);     // Catch: Throwable -> L99
            return;
        L112:
            return;
        L96:
            com.bytedance.lynx.webview.a.e(this.f265182a.f265177h, EventType.PREPARE_SETTING_ABI_MISMATCH);     // Catch: Throwable -> L99
            return;
        L79:
            if (r119.equals(BDLocationException.ERROR_CONNECT_GOOGLE_FAIL) == false) goto L81;
        L80:
            r121 = true;
            goto L82
        L76:
            if (r119.equals(BDLocationException.ERROR_RESTRICTED_MODE_ON) == true) goto L80;
        L58:
            if (l17.d.f506995a == false) goto L60;
            r107 = PrepareInfo.Source.ASSET_DEBUG;     // Catch: Throwable -> L99
            goto L56
        L60:
            r107 = PrepareInfo.Source.SETTING;     // Catch: Throwable -> L99
            goto L56
        L37:
            r105 = 0;
            goto L38
        L102:
        L29:
            Setting.f265166r = true;     // Catch: Throwable -> L99
        L30:
            Setting.f265168t = true;     // Catch: Throwable -> L99
            goto L31
        L24:
            if (JSONObjectProtectorUtils.getBoolean(r100, "sdk_only_allow_prepare_after_use_webview") == true) goto L26;
            boolean r124 = true;
        L27:
            Setting.f265166r = r124;     // Catch: JSONException -> L29 Throwable -> L99
        L26:
            r124 = false;
        L13:
            e = e;
        L20:
            l17.k.b(new String[]{"get sdk_upto_so_md5", e.toString()});     // Catch: Throwable -> L99
            r110 = r101;
            r111 = r102;
            r103 = false;
        L15:
            e = e;
            r102 = null;
        L17:
            e = e;
            r101 = null;
            r102 = null;
            goto L20
        L6:
            r100 = r210;
        L99:
            th = move-exception;
            com.bytedance.lynx.webview.a.e(this.f265182a.f265177h, EventType.PREPARE_SETTING_LOAD_EXCEPTION);
            r.c("[Settings] onConfigLoaded failed.", th);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f265183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Setting f265184b;

        public final void a() {
        L12:
            th = move-exception;
            l17.k.b(new String[]{"PrepareAsync ", th.toString()});
            return;
        L4:
            if (l17.n.d(TTWebContext.h().getContext()) == true) goto L6;
            return;
        L6:
            Setting r100 = this.f265184b;     // Catch: Throwable -> L12
            long r101 = this.f265183a;     // Catch: Throwable -> L12
            r100.getClass();     // Catch: Throwable -> L12
            h0 r102 = new h0(r100);     // Catch: Throwable -> L12
            if (r100.b("sdk_preinit_download_adblock_engine", false) == false) goto L9;
            TTWebContext.A(r102);     // Catch: Throwable -> L12
        L10:
            r100.l(r101, false);     // Catch: Throwable -> L12
            return;
        L9:
            TTWebContext.x(r102, r101);     // Catch: Throwable -> L12
            goto L10
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

        public d(Setting r100, long r101) {
            this.f265184b = r100;
            this.f265183a = r101;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Setting f265185a;

        public final void a() {
            Setting.f265164p.f265273b.edit().commit();
            monitor-enter(this);
            ((HashSet) this.f265185a.f265173d).remove(null);     // Catch: Throwable -> L12
            Iterator r100 = ((HashSet) this.f265185a.f265173d).iterator();     // Catch: Throwable -> L12
        L6:
            if (r100.hasNext() == false) goto L10;
            Runnable r101 = (Runnable) r100.next();     // Catch: Throwable -> L12
            if (r101 == null) goto L6;
            r101.run();     // Catch: Throwable -> L12
            goto L6
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
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

        public e(Setting r100) {
            this.f265185a = r100;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f265186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Setting f265187b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f265188a;

            @Override // java.lang.Runnable
            public final void run() {
                f r100 = this.f265188a;     // Catch: Throwable -> L4
                r100.f265187b.m(r100.f265186a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(f r100) {
                this.f265188a = r100;
            }
        }

        public final void a() {
            r.d("[Downlaod] Run download task");
            AtomicBoolean r100 = Setting.f265159k;
            if (r100.compareAndSet(false, true) == true) goto L75;
            r.b("[Download] Download task is running.");
            boolean r101 = false;
        L46:
            if (r101 == false) goto L52;
            int r102 = Setting.c().d("sdk_delay_for_retry_download", 0);
            if (r102 != 0) goto L50;
            this.f265187b.m(this.f265186a);
            goto L52
        L50:
            r.b("[Download] Post download task will be delayed: " + r102);
            TTWebContext.w(new a(this), (long) (r102 * 1000));
        L52:
            if (this.f265187b.f265177h.b() == false) goto L68;
            TTWebContext.h().p().f265273b.edit().commit();
            monitor-enter(this);
            Iterator r103 = ((HashSet) this.f265187b.f265173d).iterator();     // Catch: Throwable -> L65
        L57:
            if (r103.hasNext() == false) goto L62;
            Runnable r104 = (Runnable) r103.next();     // Catch: Throwable -> L65
            if (r104 != null) goto L60;
            ((HashSet) this.f265187b.f265173d).remove(r103);     // Catch: Throwable -> L65
            goto L57
        L60:
            r104.run();     // Catch: Throwable -> L65
            goto L57
        L62:
            com.bytedance.lynx.webview.internal.e.b(TTWebContext.h().getContext(), true);     // Catch: Throwable -> L65
            monitor-exit(this);     // Catch: Throwable -> L65
            return;
        L65:
            th = move-exception;
            throw th;
        L68:
            return;
        L75:
            Setting r105 = this.f265187b;     // Catch: Throwable -> L37
            r105.f265170a.f(r105.f265177h);     // Catch: Throwable -> L37
            boolean r106 = this.f265187b.b("sdk_retry_download_after_failed", false);     // Catch: Throwable -> L37
            boolean r107 = this.f265187b.b("sdk_decompress_after_download", true);     // Catch: Throwable -> L37
            boolean r108 = this.f265187b.b("sdk_dexcompile_after_decompress", true);     // Catch: Throwable -> L37
            if (r106 == false) goto L36;
            String r109 = this.f265187b.g("sdk_download_url");     // Catch: Throwable -> L37
            if (TextUtils.isEmpty(r109) == false) goto L9;
            boolean r110 = false;
        L73:
            if (r110 == true) goto L12;
            Context r111 = TTWebContext.h().getContext();     // Catch: Throwable -> L37
            if (TextUtils.isEmpty(this.f265187b.f265177h.f265076c) == false) goto L29;
        L35:
            l17.k.b(new String[]{"No download env, do not start download"});     // Catch: Throwable -> L37
            goto L36
        L29:
            if (TextUtils.isEmpty(this.f265187b.f265177h.f475075b) == true) goto L35;
            if (l17.f.c(r111) == false) goto L35;
            l17.k.b(new String[]{"restart for download failed."});     // Catch: Throwable -> L24
        L33:
            r101 = true;
        L41:
            r100.set(false);
            goto L46
        L12:
            if (this.f265187b.f265177h.a() == false) goto L20;
            r.d("[Download] Download success!");     // Catch: Throwable -> L37
            if (this.f265187b.f265177h.b() == false) goto L17;
            TTWebContext.j().e();     // Catch: Throwable -> L37
            goto L36
        L17:
            if (r108 == false) goto L36;
            l17.k.b(new String[]{"restart for dexcompile failed."});     // Catch: Throwable -> L24
            goto L33
        L20:
            r.d("[Download] Download finished. But decompress pending");     // Catch: Throwable -> L37
            if (r107 == false) goto L36;
            l17.k.b(new String[]{"restart for decompress failed."});     // Catch: Throwable -> L24
        L24:
            th = th;
            r101 = true;
        L71:
            r.c("[Downlaod] Something error for restart donwload task.", th);     // Catch: Throwable -> L42
            r100 = Setting.f265159k;
        L42:
            th = move-exception;
            Setting.f265159k.set(false);
            throw th;
        L9:
            r110 = l17.e.e(r109);     // Catch: Throwable -> L37
        L36:
            r101 = false;
        L37:
            th = th;
            r101 = false;
            goto L71
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

        public f(Setting r100, long r101) {
            this.f265187b = r100;
            this.f265186a = r101;
        }
    }

    static {
        f265159k = new AtomicBoolean(false);
        f265160l = false;
        f265161m = null;
        f265162n = new AtomicBoolean(false);
        f265163o = new AtomicBoolean(false);
        f265164p = TTWebContext.h().p();
        f265165q = false;
        f265166r = true;
        f265167s = false;
        f265168t = false;
        TimeUnit r100 = TimeUnit.DAYS;
        r100.toMillis(7);
        f265169u = r100.toMillis(1);
    }

    public static Setting c() {
        if (f265161m != null) goto L15;
        monitor-enter(Setting.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f265161m != null) goto L9;
        f265161m = new Setting(TTWebContext.h().getContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(Setting.class);     // Catch: Throwable -> L11
    L15:
        return f265161m;
    }

    public final void i() {
        int r100 = TTWebContext.f265211w;
        if (5000 < r100) goto L7;
        r100 = 5000;
    L7:
        if (TTWebContext.f265212x == false) goto L9;
        r100 = 10;
    L9:
        r.d("[Settings] initSettings when App launch. delayTime: " + r100 + "ms");
        TTWebContext.y(new d0(this), (long) r100);
    }

    public final void j() {
        boolean r100 = false;
        com.bytedance.lynx.webview.internal.a r101 = TTWebContext.e();     // Catch: Throwable -> L45
        String r102 = null;
        if (r101 != null) goto L6;
        r.b("[Settings] appinfo is null!");     // Catch: Throwable -> L45
    L9:
        String r103 = null;
        String r104 = null;
        String r105 = null;
        String r110 = null;
    L29:
        String r106 = r102;
        r102 = r103;
        boolean r107 = false;
    L30:
        boolean r111 = true;
    L31:
        if (r107 == true) goto L61;
        if (r111 == false) goto L63;
        r.b("can't get appInfo, try at 1 min later!");
        f265158j = true;
        TTWebContext.y(new b(this), 60000);
        return;
    L63:
        return;
    L61:
        g.a r108 = new g.a();     // Catch: Throwable -> L43
        r108.f265314e = this.f265176g;     // Catch: Throwable -> L43
        r108.f265313d = r102;     // Catch: Throwable -> L43
        r108.f265315f = r104;     // Catch: Throwable -> L43
        r108.f265310a = r105;     // Catch: Throwable -> L43
        r108.f265312c = r106;     // Catch: Throwable -> L43
        r108.f265311b = r110;     // Catch: Throwable -> L43
        o(r108);     // Catch: Throwable -> L43
        if (TTWebContext.B == false) goto L38;
        g.e().g(TTWebContext.h().m());     // Catch: Throwable -> L43
    L59:
        f265158j = false;     // Catch: Throwable -> L41
        f265162n.set(true);     // Catch: Throwable -> L41
        TTWebContext.C(new f0());     // Catch: Throwable -> L41
        return;
    L41:
        th = th;
        r100 = true;
    L57:
        r.c("[Settings] InitSettingsDirectly Err ", th);     // Catch: Throwable -> L52
        if (r100 == true) goto L64;
        if (r111 == false) goto L65;
        r.b("can't get appInfo, try at 1 min later!");
        f265158j = true;
        TTWebContext.y(new b(this), 60000);
        return;
    L65:
        return;
    L64:
        return;
    L52:
        th = move-exception;
        if (r100 == true) goto L56;
        if (r111 == false) goto L56;
        r.b("can't get appInfo, try at 1 min later!");
        f265158j = true;
        TTWebContext.y(new b(this), 60000);
    L56:
        throw th;
    L38:
        g.e().i();     // Catch: Throwable -> L43
    L43:
        th = th;
        goto L57
    L6:
        AppInfo r109 = r101.a();     // Catch: Throwable -> L45
        if (r109 != null) goto L11;
        r.b("[Settings] minimumAppInfo is null!");     // Catch: Throwable -> L45
        goto L9
    L11:
        if (l17.n.d(TTWebContext.h().getContext()) == true) goto L13;
        r.b("[Settings] not allow to pull settings");     // Catch: Throwable -> L45
        r106 = null;
        r104 = null;
        r105 = null;
        r110 = null;
        r107 = false;
        r111 = false;
        goto L31
    L13:
        this.f265176g = r109.getAppId();     // Catch: Throwable -> L45
        r102 = r109.getChannel();     // Catch: Throwable -> L45
        r104 = r109.getUpdateVersionCode();     // Catch: Throwable -> L45
        r105 = r109.getDeviceId();     // Catch: Throwable -> L45
        r110 = r109.getUserId();     // Catch: Throwable -> L45
        r106 = r109.getTenantId();     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(this.f265176g) == false) goto L16;
    L27:
        r.b("appInfo missing, appId: " + this.f265176g + ", channel: " + r102 + ", updateVersion: " + r104 + ", deviceId: " + r105);     // Catch: Throwable -> L45
        com.bytedance.lynx.webview.a.f(EventType.SETTING_APP_INFO_ERROR);     // Catch: Throwable -> L45
        r103 = r102;
        r102 = r106;
        goto L29
    L16:
        if (TextUtils.isEmpty(r102) == true) goto L27;
        if (TextUtils.isEmpty(r104) == true) goto L27;
        if (TextUtils.isEmpty(r105) == true) goto L27;
        if (TTWebContext.B == true) goto L24;
    L26:
        r107 = true;
        goto L30
    L24:
        if (TextUtils.isEmpty(TTWebContext.h().m()) == false) goto L26;
    L45:
        th = th;
        r111 = true;
        goto L57
    }

    public final boolean k() {
        if (TextUtils.isEmpty(this.f265176g) == false) goto L12;
        com.bytedance.lynx.webview.internal.a r100 = TTWebContext.e();
        if (r100 == null) goto L12;
        AppInfo r101 = r100.a();
        if (r101 == null) goto L12;
        this.f265176g = r101.getAppId();
    L12:
        return b("sdk_enable_web_provider_proxy", !Arrays.asList(new String[]{InitSDKRequest.DEFAULT_APP_ID, "2916", "2600", "8641", "482431"}).contains(this.f265176g));
    }

    public static void a() {
        g r100 = g.e();
        monitor-enter(r100);
        r100.c();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public Setting(Context r110) {
        this.f265171b = null;
        this.f265172c = null;
        this.f265174e = new ReentrantReadWriteLock();
        this.f265175f = new CountDownLatch(1);
        this.f265176g = "";
        this.f265177h = null;
        this.f265178i = new AtomicReference(RequestSource.LAUNCH);
        this.f265170a = new o();
        g r100 = g.e();
        r100.getClass();
        r100.f265303a = r110.getSharedPreferences("TTWebView_Json_Config_Manager", 0);
        r100.f265304b = new g.c();
        r100.f();
        p(g.e().f());
        HashSet r111 = new HashSet();
        this.f265173d = r111;
        TTWebSdk.h r101 = TTWebContext.h().f265220f;
        if (r101 == null) goto L5;
        r111.add(new a(r101));
    L5:
        String r102 = g("sdk_upto_so_versioncode");
        String r103 = g("sdk_upto_so_md5");
        String r104 = g("sdk_download_url");
        String r105 = g("sdk_signdata");
        String r106 = g("sdk_hostabi");
        this.f265177h = new PrepareInfo(r102, r103, PrepareInfo.Source.SETTING, r104, r105, r106, 0);
    }

    public final Object e(String r100) {
        this.f265174e.readLock().lock();
        Object r101 = this.f265171b.get(r100);     // Catch: Throwable -> L6
        this.f265174e.readLock().unlock();
        return r101;
    L6:
        th = move-exception;
        this.f265174e.readLock().unlock();
        throw th;
    }

    public final String g(String r100) {
        return h(r100, "");
    }

    public final void m(long r110) {
        if (b("sdk_disallow_download", false) == false) goto L6;
        r.d("[Prepare] Disallow prepare by settings.");
        com.bytedance.lynx.webview.a.e(this.f265177h, EventType.PREPARE_DISALLOW_PREPARE);
        return;
    L6:
        long r100 = System.currentTimeMillis();
        c0 r101 = f265164p;
        long r102 = r101.f265273b.getLong("webview_last_used_time", 0);
        if (r102 != 0) goto L10;
        r102 = System.currentTimeMillis();
        r101.f265273b.edit().putLong("webview_last_used_time", r102).apply();
    L10:
        if ((r100 - r102) <= f265169u) goto L12;
        boolean r103 = true;
    L14:
        if (f265166r == true) goto L23;
        if (r103 == false) goto L23;
        r.d("[Prepare] Not appropriate time to prepare.");
        com.bytedance.lynx.webview.a.e(this.f265177h, EventType.PREPARE_NOT_ALLOW_PREPARE);
        if (b("sdk_pre_download", false) == false) goto L21;
        AtomicBoolean r111 = com.bytedance.lynx.webview.preparation.a.f265406c;
        if (j17.b.a().f496867a.getBoolean("download_task_incomplete", false) == false) goto L21;
        com.bytedance.lynx.webview.preparation.a r112 = new com.bytedance.lynx.webview.preparation.a();
        j17.b.a().f496867a.edit().putBoolean("download_task_incomplete", true).apply();
        r112.e(10, false, PrepareInfoNG.PreparePhase.DOWNLOADED);
    L21:
        f265167s = true;
        return;
    L23:
        TTWebContext.w(new r0(new d(this, r110)), 0);
        return;
    L12:
        r103 = false;
        goto L14
    }

    public final void n(RequestSource r100) {
        this.f265178i.set(r100);
    }

    public final void o(g.a r100) {
        g r101 = g.e();
        if (r100 == null) goto L14;
        r101.f265307e = r100;
        g.c r102 = r101.f265304b;
        if (r102 == null) goto L14;
        Set<g.b> r103 = r102.f265317a;
        monitor-enter(r103);
        ((HashSet) r102.f265317a).clear();     // Catch: Throwable -> L11
        monitor-exit(r103);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L14:
        l17.k.d(new String[]{"Settings setSettingListener "});
        r101.b(new c(this));
    }

    public final void p(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ConcurrentHashMap<String, Object> r101 = new ConcurrentHashMap();
        Iterator<String> r102 = r100.keys();     // Catch: JSONException -> L10
    L7:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();     // Catch: JSONException -> L10
        r101.put(r103, r100.get(r103));     // Catch: JSONException -> L10
    L12:
        this.f265174e.writeLock().lock();
        this.f265171b = r101;     // Catch: Throwable -> L16
        this.f265174e.writeLock().unlock();
        return;
    L16:
        th = move-exception;
        this.f265174e.writeLock().unlock();
        throw th;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public final boolean b(String r100, boolean r101) {
        if (this.f265171b != null) goto L13;
        return r101;
    L13:
        Object r102 = e(r100);     // Catch: Exception -> L10
        if (r102 != null) goto L8;
        return r101;
    L8:
        return ((Boolean) r102).booleanValue();
    L10:
        e = move-exception;
        l17.k.d(new String[]{"getBooleanByKey error:" + e.toString()});
        return r101;
    }

    public final int d(String r100, int r101) {
        if (this.f265171b != null) goto L13;
        return r101;
    L13:
        Object r102 = e(r100);     // Catch: Exception -> L10
        if (r102 != null) goto L8;
        return r101;
    L8:
        return CastIntegerProtector.parseInt(r102.toString());
    L10:
        e = move-exception;
        l17.k.d(new String[]{"getBooleanByKey error : " + e.toString()});
        return r101;
    }

    public final String h(String r100, String r101) {
        if (this.f265171b != null) goto L13;
        return r101;
    L13:
        Object r102 = e(r100);     // Catch: Exception -> L10
        if (r102 != null) goto L8;
        return r101;
    L8:
        return r102.toString();
    L10:
        e = move-exception;
        l17.k.d(new String[]{"getBooleanByKey error : " + e.toString()});
        return r101;
    }

    public final void l(long r100, boolean r101) {
        if (b("sdk_use_preparer_ng", false) == false) goto L7;
        r.d("Prepare TTWebView so with LibraryPreparerNG.");
        new com.bytedance.lynx.webview.preparation.a().e(r100, r101, PrepareInfoNG.PreparePhase.COMPILED);
        return;
    L7:
        if (this.f265177h.b() == false) goto L11;
        f265164p.n(this.f265177h);
        TTWebContext.j().e();
        r.d("[Download] No need to download. Because upto md5 " + this.f265177h.f475075b + " has dexCompile finished.");
        return;
    L11:
        if (b("sdk_is_builtin", false) == true) goto L15;
        if (TextUtils.isEmpty(this.f265177h.f265076c) == false) goto L15;
    L16:
        r.d("[Download] No need to download. Because url no updated:" + this.f265177h.f265076c);
        com.bytedance.lynx.webview.a.e(this.f265177h, EventType.PREPARE_SETTING_NO_NEED);
        return;
    L15:
        if (TextUtils.isEmpty(this.f265177h.f475075b) == true) goto L16;
        r.d("[Download] prepare to download. url :" + this.f265177h.f265076c + " delayMillis " + r100 + " withoutPost " + r101);
        if (r100 != 0) goto L28;
        l17.k.d(new String[]{"Prepare synchronously"});
        this.f265170a.f(this.f265177h);
        if (TTWebContext.t() == false) goto L26;
        if (b("sdk_is_builtin", false) == false) goto L26;
        String r102 = this.f265177h.f475075b;
        LibraryLoader.w();
    L26:
        if (this.f265177h.b() == false) goto L33;
        TTWebContext.C(new e(this));
        return;
    L33:
        return;
    L28:
        f r103 = new f(this, r100);
        if (r101 == false) goto L31;
        ThreadMethodProxy.start(new PthreadThreadV2(r103, "ernal/Setting"));
        return;
    L31:
        r.d("[Download] Post download Task to App");
        TTWebContext.x(r103, r100);
    }

    public static boolean f(String r100, int r101, boolean r102) {
        g r103 = g.e();
        monitor-enter(r103);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (r103.f265308f != null) goto L7;
        r103.j();     // Catch: Throwable -> L30
    L7:
        monitor-exit(r103);     // Catch: Throwable -> L30
        boolean r104 = false;
        Matcher r105 = PatternProtector.compile("\\d+$").matcher(r100);     // Catch: Exception -> L27
        if (r105.find() == true) goto L12;
    L14:
        Integer r106 = (Integer) ((ConcurrentHashMap) r103.f265308f).get(r100);     // Catch: Exception -> L27
        if (r106 != null) goto L17;
    L20:
        if (r101 == 1) goto L22;
        return r102;
    L22:
        if (r103.f265306d == (-1)) goto L38;
        if (r103.f265306d != 1) goto L39;
        r104 = true;
    L39:
        return r104;
    L38:
        return r102;
    L17:
        if ((r106.intValue() & (1 << (r101 - 1))) == 0) goto L19;
        r102 = true;
        goto L20
    L19:
        r102 = false;
        goto L20
    L12:
        if (r100.contains(":") == false) goto L14;
        r100 = r105.replaceAll("x");     // Catch: Exception -> L27
    L27:
        e = move-exception;
        l17.k.b(new String[]{"TT_WEBVIEW", "getProcessFeature error:" + e.toString()});
        return r102;
    }
}
