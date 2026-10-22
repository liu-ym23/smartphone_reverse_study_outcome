package com.ss.android.account;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.account.utils.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.token.AuthTokenMultiProcessSharedProvider;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class PassportExtraHeaderManager {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f406210k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile PassportExtraHeaderManager f406211l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f406212m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f406213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f406214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f406215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f406216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f406217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f406218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile c f406219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f406220h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AuthTokenMultiProcessSharedProvider.b f406221i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f406222j;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ConcurrentHashMap<String, AtomicBoolean> f406223a = null;

        static {
            f406223a = new ConcurrentHashMap();
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PassportExtraHeaderManager f406224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f406225b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f406226c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f406227d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Map f406228e;

        public c(PassportExtraHeaderManager r100, long r101, String r102, int r103, Map r104) {
            this.f406224a = r100;
            this.f406225b = r101;
            this.f406226c = r102;
            this.f406227d = r103;
            this.f406228e = r104;
        }

        public final void a() {
            StringBuilder r100 = new StringBuilder();
            StringBuilder r101 = new StringBuilder();
            Object r102 = this.f406224a.f406215c;
            monitor-enter(r102);
            long r103 = SystemClock.elapsedRealtime() - this.f406225b;     // Catch: Throwable -> L101
            tb7.a.d("PassportExtraHeaderManager", "delayCheckSp(), start, scene: " + this.f406226c + ", expectModifyFlag: " + this.f406227d);     // Catch: Throwable -> L101
            com.bytedance.sdk.account.settings.common.b.a();     // Catch: Throwable -> L101
            int r104 = com.bytedance.sdk.account.settings.common.b.f269408f;     // Catch: Throwable -> L101
            int r105 = this.f406224a.f406221i.d("passport_extra_header_modify_flag", -1);     // Catch: Throwable -> L101
            int r106 = this.f406227d;     // Catch: Throwable -> L101
            if (r106 != r105) goto L7;
            int r107 = 0;
        L10:
            if (r107 == 0) goto L12;
            boolean r108 = true;
        L13:
            Iterator r110 = this.f406228e.entrySet().iterator();     // Catch: Throwable -> L101
        L15:
            if (r110.hasNext() == false) goto L46;
            Map.Entry r111 = (Map.Entry) r110.next();     // Catch: Throwable -> L101
            String r112 = this.f406224a.f406221i.f((String) r111.getKey());     // Catch: Throwable -> L101
            if (Intrinsics.areEqual((String) r111.getValue(), r112) == false) goto L19;
            int r113 = 0;
        L38:
            if (r100.length() <= 0) goto L40;
            boolean r114 = true;
        L41:
            if (r114 == false) goto L43;
            r100.append(',');     // Catch: Throwable -> L101
        L43:
            r100.append((String) r111.getKey());     // Catch: Throwable -> L101
            r100.append(com.alipay.sdk.m.n.a.f25612h);     // Catch: Throwable -> L101
            r100.append(r113);     // Catch: Throwable -> L101
            if (r113 == 0) goto L15;
            r108 = true;
            goto L15
        L40:
            r114 = false;
            goto L41
        L19:
            CharSequence r115 = (CharSequence) r111.getValue();     // Catch: Throwable -> L101
            if (r115 != null) goto L22;
        L25:
            boolean r116 = true;
        L26:
            if (r116 == false) goto L28;
            r113 = -1;
            goto L38
        L28:
            if (r112 != null) goto L30;
        L33:
            boolean r117 = true;
        L34:
            if (r117 == false) goto L36;
            r113 = 1;
            goto L38
        L36:
            r113 = 2;
            goto L38
        L30:
            if (r112.length() == 0) goto L33;
            r117 = false;
            goto L34
        L22:
            if (r115.length() == 0) goto L25;
            r116 = false;
            goto L26
        L46:
            if (r104 <= 0) goto L90;
            int r109 = this.f406224a.b().getInt("passport_extra_header_modify_flag", -1);     // Catch: Throwable -> L101
            int r118 = this.f406227d;     // Catch: Throwable -> L101
            if (r118 != r109) goto L50;
            int r119 = 0;
        L53:
            if (r119 == 0) goto L55;
            r108 = true;
        L55:
            Iterator r120 = this.f406228e.entrySet().iterator();     // Catch: Throwable -> L101
        L57:
            if (r120.hasNext() == false) goto L89;
            Map.Entry r121 = (Map.Entry) r120.next();     // Catch: Throwable -> L101
            String r122 = this.f406224a.b().getString((String) r121.getKey(), "");     // Catch: Throwable -> L101
            if (Intrinsics.areEqual((String) r121.getValue(), r122) == false) goto L61;
            int r123 = 0;
        L80:
            if (r101.length() <= 0) goto L82;
            boolean r124 = true;
        L83:
            if (r124 == false) goto L85;
            r101.append(',');     // Catch: Throwable -> L101
        L85:
            r101.append((String) r121.getKey());     // Catch: Throwable -> L101
            r101.append(com.alipay.sdk.m.n.a.f25612h);     // Catch: Throwable -> L101
            r101.append(r123);     // Catch: Throwable -> L101
            if (r123 == 0) goto L57;
            r108 = true;
            goto L57
        L82:
            r124 = false;
            goto L83
        L61:
            CharSequence r125 = (CharSequence) r121.getValue();     // Catch: Throwable -> L101
            if (r125 != null) goto L64;
        L67:
            boolean r126 = true;
        L68:
            if (r126 == false) goto L70;
            r123 = -1;
            goto L80
        L70:
            if (r122 != null) goto L72;
        L75:
            boolean r127 = true;
        L76:
            if (r127 == false) goto L78;
            r123 = 1;
            goto L80
        L78:
            r123 = 2;
            goto L80
        L72:
            if (r122.length() == 0) goto L75;
            r127 = false;
            goto L76
        L64:
            if (r125.length() == 0) goto L67;
            r126 = false;
            goto L68
        L89:
            boolean r128 = r108;
            int r129 = r119;
            boolean r130 = r128;
        L91:
            Unit r131 = Unit.INSTANCE;     // Catch: Throwable -> L101
            monitor-exit(r102);
            if (r130 == false) goto L99;
            String r132 = this.f406226c;
            String r133 = r100.toString();
            String r134 = r101.toString();
            JSONObject r135 = new JSONObject();     // Catch: Throwable -> L97
            r135.put("scene", r132);     // Catch: Throwable -> L97
            r135.put("modify_flag_result", r107);     // Catch: Throwable -> L97
            r135.put(LocationMonitorConst.CHECK_RESULT, r133);     // Catch: Throwable -> L97
            r135.put("backup_modify_flag_result", r129);     // Catch: Throwable -> L97
            r135.put("backup_check_result", r134);     // Catch: Throwable -> L97
            r135.put("check_interval", r103);     // Catch: Throwable -> L97
            com.bytedance.sdk.account.monitor.a.a("passport_extra_header_sp_check_result", r135);     // Catch: Throwable -> L97
        L97:
            th = move-exception;
            tb7.a.b("AccountMonitorUtil", "extraHeaderSpCheckResult, " + th.getMessage());
        L99:
            tb7.a.d("PassportExtraHeaderManager", "delayCheckSp(), end, scene: " + this.f406226c + ", expectModifyFlag: " + this.f406227d + ", modifyFlagResult: " + r107 + ", backupModifyFlagResult: " + r129 + ", checkResult: " + r100 + ", backupCheckResult: " + r101 + ", checkInterval: " + r103);
            return;
        L50:
            if (r118 >= r109) goto L52;
            r119 = -1;
            goto L53
        L52:
            r119 = 1;
            goto L53
        L90:
            r130 = r108;
            r129 = -2;
            goto L91
        L12:
            r108 = false;
            goto L13
        L7:
            if (r106 >= r105) goto L9;
            r107 = -1;
            goto L10
        L9:
            r107 = 1;
        L101:
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
    }

    static {
        f406210k = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PassportExtraHeaderManager.class), "backupSp", "getBackupSp()Landroid/content/SharedPreferences;"))};
        f406212m = new a();
    }

    public final SharedPreferences b() {
        Lazy r100 = this.f406217e;
        KProperty r101 = f406210k[0];
        return (SharedPreferences) r100.getValue();
    }

    public final void f() {
        boolean r100 = false;
        this.f406214b = this.f406221i.d("passport_extra_header_modify_flag", 0);
        e();
        if (this.f406222j == false) goto L39;
        Object r101 = this.f406215c;
        monitor-enter(r101);
        com.bytedance.sdk.account.settings.common.b.a();     // Catch: Throwable -> L29
        int r102 = com.bytedance.sdk.account.settings.common.b.f269408f;     // Catch: Throwable -> L29
        AuthTokenMultiProcessSharedProvider.a r103 = this.f406221i.b();     // Catch: Throwable -> L29
        if (r102 <= 0) goto L10;
        SharedPreferences.Editor r104 = b().edit();     // Catch: Throwable -> L29
    L11:
        com.bytedance.sdk.account.settings.common.b.a();     // Catch: Throwable -> L29
        Iterator<String> r105 = com.bytedance.sdk.account.settings.common.b.f269406d.f269551c.iterator();     // Catch: Throwable -> L29
    L13:
        if (r105.hasNext() == false) goto L20;
        String r106 = r105.next();     // Catch: Throwable -> L29
        if (this.f406213a.containsKey(r106) == false) goto L13;
        this.f406213a.remove(r106);     // Catch: Throwable -> L29
        r103.f449628b.putNull(r106);     // Catch: Throwable -> L29
        if (r104 == null) goto L19;
        r104.remove(r106);     // Catch: Throwable -> L29
    L19:
        tb7.a.a("PassportExtraHeaderManager", "clear deprecate header " + r106);     // Catch: Throwable -> L29
        r100 = true;
        goto L13
    L20:
        if (r100 == false) goto L26;
        this.f406214b++;     // Catch: Throwable -> L29
        int r107 = this.f406214b;     // Catch: Throwable -> L29
        r103.f449628b.put("passport_extra_header_modify_flag", Integer.valueOf(r107));     // Catch: Throwable -> L29
        r103.a();     // Catch: Throwable -> L29
        if (r104 == null) goto L24;
        r104.putInt("passport_extra_header_modify_flag", r107);     // Catch: Throwable -> L29
    L24:
        if (r104 == null) goto L26;
        r104.apply();     // Catch: Throwable -> L29
    L26:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L29
        monitor-exit(r101);
        return;
    L10:
        r104 = null;
    L29:
        th = move-exception;
        throw th;
    }

    public final void g() {
        Uri r100 = UriProtector.parse("content://" + AuthTokenMultiProcessSharedProvider.d(this.f406220h, AuthTokenMultiProcessSharedProvider.class.getName()) + "/passport_extra_header_modify_flag/integer");
        StringBuilder r101 = new StringBuilder("PassportExtraHeaderManager.registerContentResolver: uri=");
        r101.append(r100);
        tb7.a.a("PassportExtraHeaderManager", r101.toString());
        this.f406220h.getContentResolver().registerContentObserver(r100, false, new g(this, r100, new Handler(Looper.getMainLooper())));
        e();
    }

    public final void h() {
        if (this.f406216d.get() == false) goto L5;
        return;
    L5:
        AtomicBoolean r100 = this.f406216d;
        monitor-enter(r100);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (this.f406216d.get() == false) goto L12;
        monitor-exit(r100);
        return;
    L12:
        if (this.f406222j == false) goto L14;
        f();     // Catch: Throwable -> L18
    L15:
        this.f406216d.set(true);     // Catch: Throwable -> L18
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r100);
        return;
    L14:
        g();     // Catch: Throwable -> L18
        goto L15
    }

    public final void e() {
        com.bytedance.sdk.account.settings.common.b.a();
        Collection<String> r100 = com.bytedance.sdk.account.settings.common.b.f269405c.f269551c;
        StringBuilder r101 = new StringBuilder();
        StringBuilder r102 = new StringBuilder();
        com.bytedance.sdk.account.settings.common.b.a();
        int r103 = com.bytedance.sdk.account.settings.common.b.f269408f;
        Iterator<String> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L41;
        String r105 = r104.next();
        boolean r106 = true;
        if (r105 != null) goto L8;
    L11:
        boolean r107 = true;
    L12:
        if (r107 == true) goto L4;
        r101.append(r105);
        r101.append(',');
        String r108 = this.f406221i.f(r105);
        if (r108 != null) goto L17;
    L20:
        String r109 = "";
        if (r106 == false) goto L28;
        if (r103 != 2) goto L28;
        r108 = b().getString(r105, "");
        if (n.a(r108) == false) goto L28;
        tb7.a.d("PassportExtraHeaderManager", "loadSaveHeaders(), " + r105 + " load from backup sp success");
    L28:
        if (n.a(r108) == false) goto L39;
        if (d(r105, r108, "load") == false) goto L34;
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.P == false) goto L34;
        String r110 = b().getString(r105, "");
        d(r105, r110, "load-backup");
        r108 = r110;
    L34:
        ConcurrentHashMap<String, String> r111 = this.f406213a;
        if (r108 == null) goto L37;
        r109 = r108;
    L37:
        r111.put(r105, r109);
    L39:
        if (n.a(r108) == false) goto L4;
        r102.append(r105);
        r102.append(',');
        goto L4
    L17:
        if (r108.length() == 0) goto L20;
        r106 = false;
        goto L20
    L8:
        if (r105.length() == 0) goto L11;
        r107 = false;
        goto L12
    L41:
        tb7.a.d("PassportExtraHeaderManager", "loadSaveHeaders(), settingsHeader=[" + r101 + "], loadSuccessHeader=[" + r102 + ']');
    }

    public PassportExtraHeaderManager(Context r100, AuthTokenMultiProcessSharedProvider.b r101, boolean r102) {
        this.f406220h = r100;
        this.f406221i = r101;
        this.f406222j = r102;
        this.f406213a = new ConcurrentHashMap();
        this.f406215c = new Object();
        this.f406216d = new AtomicBoolean(false);
        this.f406217e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new PassportExtraHeaderManager$backupSp$2(this));
        this.f406218f = new Handler(Looper.getMainLooper());
    }

    @JvmStatic
    public static final PassportExtraHeaderManager c(Context r100, AuthTokenMultiProcessSharedProvider.b r101, boolean r102) {
        f406212m.getClass();
        if (f406211l == null) goto L5;
    L15:
        PassportExtraHeaderManager r103 = f406211l;
        if (r103 != null) goto L18;
        Intrinsics.throwNpe();
    L18:
        return r103;
    L5:
        monitor-enter(PassportExtraHeaderManager.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f406211l != null) goto L9;
        f406211l = new PassportExtraHeaderManager(r100, r101, r102);     // Catch: Throwable -> L12
    L9:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(PassportExtraHeaderManager.class);
        goto L15
    }

    public final void a(String r110, int r111, Map<String, String> r112) {
        com.bytedance.sdk.account.settings.common.b.a();
        long r100 = com.bytedance.sdk.account.settings.common.b.f269409g;
        if (r100 > 0) goto L5;
        return;
    L5:
        c r101 = this.f406219g;
        if (r101 == null) goto L8;
        this.f406218f.removeCallbacks(r101);
    L8:
        c r102 = new c(this, SystemClock.elapsedRealtime(), r110, r111, r112);
        this.f406219g = r102;
        this.f406218f.postDelayed(r102, r100);
    }

    public final boolean d(String r110, String r111, String r112) {
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.M == true) goto L7;
        r110 = null;
    L7:
        if (r110 != null) goto L9;
        return false;
    L9:
        if (StringsKt.equals("x-tt-token-supplement", r110, true) == true) goto L12;
        r110 = null;
    L12:
        if (r110 == null) goto L67;
        com.bytedance.sdk.account.settings.common.a.a();
        String r113 = com.bytedance.sdk.account.settings.common.a.N;
        if (r113 != null) goto L16;
    L57:
        tb7.a.d("PassportExtraHeaderManager", "x-tt-token-supplement value ok, template=null/empty, supplement=" + r111 + ", scene=" + r112);
        return false;
    L16:
        if ((!StringsKt.isBlank(r113)) == false) goto L18;
        String r100 = r113;
    L19:
        if (r100 == null) goto L57;
        List r114 = StringsKt.split$default(r100, new String[]{","}, false, 0, 6, null);
        if (r114 == null) goto L57;
        List r115 = r114;
        if ((r115 instanceof Collection) == true) goto L25;
    L27:
        Iterator r116 = r115.iterator();
    L29:
        if (r116.hasNext() == false) goto L38;
        String r101 = (String) r116.next();
        if (r111 != null) goto L33;
    L35:
        boolean r102 = false;
    L36:
        if (r102 == false) goto L29;
        boolean r117 = true;
    L39:
        StringBuilder r103 = new StringBuilder("x-tt-token-supplement value ");
        if (r117 == false) goto L42;
        String r104 = "error";
    L43:
        r103.append(r104);
        r103.append(", template=");
        com.bytedance.sdk.account.settings.common.a.a();
        r103.append(com.bytedance.sdk.account.settings.common.a.N);
        r103.append(", supplement=");
        r103.append(r111);
        r103.append(", scene=");
        r103.append(r112);
        String r105 = r103.toString();
        if (r117 == false) goto L55;
        tb7.a.b("PassportExtraHeaderManager", r105);
        ConcurrentHashMap<String, AtomicBoolean> r106 = b.f406223a;
        AtomicBoolean r107 = new AtomicBoolean(false);
        AtomicBoolean r108 = b.f406223a.putIfAbsent(r112, r107);
        if (r108 == null) goto L49;
        r107 = r108;
    L49:
        if (r107.compareAndSet(false, true) == false) goto L68;
        com.bytedance.sdk.account.settings.common.a.a();
        String r109 = com.bytedance.sdk.account.settings.common.a.N;
        String r118 = this.f406213a.toString();
        JSONObject r119 = new JSONObject();     // Catch: Throwable -> L53
        r119.put("supplement", r111);     // Catch: Throwable -> L53
        r119.put("match_template", r109);     // Catch: Throwable -> L53
        r119.put("map_info", r118);     // Catch: Throwable -> L53
        r119.put("scene", r112);     // Catch: Throwable -> L53
        com.bytedance.sdk.account.monitor.a.a("passport_supplement_value_error", r119);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        tb7.a.c("AccountMonitorUtil", "onSupplementValueError", th);
    L68:
        return r117;
    L55:
        tb7.a.d("PassportExtraHeaderManager", r105);
        goto L68
    L42:
        r104 = com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE;
        goto L43
    L33:
        if (StringsKt.contains$default(r111, r101, false, 2, null) != true) goto L35;
        r102 = true;
    L38:
        r117 = false;
        goto L39
    L25:
        if (r115.isEmpty() == false) goto L27;
    L18:
        r100 = null;
        goto L19
    L67:
        return false;
    }
}
