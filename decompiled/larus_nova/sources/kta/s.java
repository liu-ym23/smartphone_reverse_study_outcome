package kta;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class s {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile s f506124h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f506125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f506126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f506127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f506128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f506129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Future<p> f506130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p f506131g;

    public class a implements Callable<p> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f506132a;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public p call2() {
            s r100 = this.f506132a;
            String r101 = r100.f506126b.f506122a.getString("oaid", "");
            int r110 = -1;
            if (TextUtils.isEmpty(r101) == false) goto L56;
        L29:
            p r102 = null;
        L30:
            Objects.toString(r102);
            if (r102 == null) goto L33;
            r100.f506131g = r102;
        L33:
            Context r103 = r100.f506128d;
            long r104 = SystemClock.elapsedRealtime();
            o r105 = r100.f506125a;
            if (r105 == null) goto L49;
            o.a r106 = r105.getOaid(r103);
            if (r106 == null) goto L49;
            int r107 = 1;
            if (r102 == null) goto L40;
            String r111 = r102.f506116b;
            r110 = r102.f506120f.intValue() + 1;
        L42:
            if (TextUtils.isEmpty(r111) == false) goto L44;
            r111 = UUID.randomUUID().toString();
        L44:
            String r112 = r111;
            if (r110 <= 0) goto L48;
            r107 = r110;
        L48:
            p r113 = new p(r106.f506112a, r112, Boolean.valueOf(r106.f506113b), Long.valueOf(SystemClock.elapsedRealtime() - r104), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(r107), Long.valueOf(r106.f506114c));
        L50:
            if (r113 == null) goto L52;
            r100.f506126b.f506122a.edit().putString("oaid", r113.a().toString()).apply();
        L52:
            if (r113 == null) goto L54;
            r100.f506131g = r113;
        L54:
            Objects.toString(r113);
            return r113;
        L40:
            r111 = null;
        L49:
            r113 = null;
            goto L50
        L56:
            JSONObject r108 = new JSONObject(r101);     // Catch: JSONException -> L27
            String r114 = r108.optString("id", null);     // Catch: JSONException -> L27
            String r115 = r108.optString("req_id", null);     // Catch: JSONException -> L27
            if (r108.has("is_track_limited") == false) goto L8;
            Boolean r116 = Boolean.valueOf(r108.optBoolean("is_track_limited"));     // Catch: JSONException -> L27
        L10:
            if (r108.has("take_ms") == false) goto L12;
            Long r117 = Long.valueOf(r108.optLong("take_ms", -1));     // Catch: JSONException -> L27
        L14:
            if (r108.has("time") == false) goto L16;
            Long r118 = Long.valueOf(r108.optLong("time", -1));     // Catch: JSONException -> L27
        L18:
            if (r108.has("query_times") == false) goto L20;
            Integer r119 = Integer.valueOf(r108.optInt("query_times", -1));     // Catch: JSONException -> L27
        L22:
            if (r108.has("hw_id_version_code") == false) goto L24;
            Long r120 = Long.valueOf(r108.optLong("hw_id_version_code", -1));     // Catch: JSONException -> L27
        L25:
            r102 = new p(r114, r115, r116, r117, r118, r119, r120);     // Catch: JSONException -> L27
            goto L30
        L24:
            r120 = null;
            goto L25
        L20:
            r119 = null;
            goto L22
        L16:
            r118 = null;
            goto L18
        L12:
            r117 = null;
            goto L14
        L8:
            r116 = null;
        L27:
            e = move-exception;
            e.printStackTrace();
            goto L29
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ p call() throws Exception {
            return call2();
        }

        public a(s r100) {
            this.f506132a = r100;
        }
    }

    public final void a() {
        if (this.f506129e.compareAndSet(false, true) == false) goto L6;
        this.f506130f = TTExecutors.getIOThreadPool().submit(new a(this));
        return;
    }

    public s(Context r100) {
        this.f506129e = new AtomicBoolean(false);
        Context r101 = r100.getApplicationContext();
        this.f506128d = r101;
        if (pta.d.g() == false) goto L5;
        o r102 = new t(new x());
    L85:
        this.f506125a = r102;
        if (r102 == null) goto L88;
        this.f506127c = r102.a(r100);
    L89:
        this.f506126b = new q(r101);
        return;
    L88:
        this.f506127c = false;
        goto L89
    L5:
        boolean r103 = true;
        if (x.f506164b != null) goto L8;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == false) goto L16;
        r102 = new x();
        goto L85
    L16:
        if (r.f506123a.b(new Object[0]).booleanValue() == false) goto L19;
        r102 = new r();
        goto L85
    L19:
        if (pta.d.i() == false) goto L24;
        if (pta.d.f() == false) goto L24;
        r102 = new g();
    L24:
        if (pta.d.i() == false) goto L29;
        if (pta.d.f() == true) goto L29;
        r102 = new i();
    L29:
        if (pta.d.j() == false) goto L31;
        r102 = new g();
        goto L85
    L31:
        String r105 = Build.MANUFACTURER;
        if ("OnePlus".equalsIgnoreCase(r105) == false) goto L34;
        r102 = new t(null);
        goto L85
    L34:
        String r106 = Build.BRAND;
        if (r106 != null) goto L37;
        boolean r107 = false;
    L38:
        if (r107 == false) goto L41;
        r102 = new l();
        goto L85
    L41:
        if (Build.VERSION.SDK_INT <= 28) goto L80;
        if (SmEditTextLeakOpt.SAMSUNG.equalsIgnoreCase(r106) == false) goto L45;
    L48:
        boolean r108 = true;
    L49:
        if (r108 == false) goto L51;
        r102 = new v();
        goto L85
    L51:
        String r109 = "";
        if (r105 != null) goto L54;
        String r110 = "";
    L56:
        if (r110.toUpperCase().contains(RomUtils.ROM_NUBIA) == false) goto L58;
        r102 = new m();
        goto L85
    L58:
        String r111 = Build.FINGERPRINT;
        if (TextUtils.isEmpty(r111) == true) goto L61;
        r103 = r111.contains("VIBEUI_V2");
    L67:
        if (r103 == false) goto L69;
        r102 = new k();
        goto L85
    L69:
        if (r105 == null) goto L73;
        r109 = r105.trim();
    L73:
        if (r109.toUpperCase().contains("ASUS") == false) goto L75;
        r102 = new kta.a();
        goto L85
    L75:
        r102 = new e(r100);
        if (r102.a(r100) == true) goto L85;
        r102 = new d();
        goto L85
    L61:
        String r112 = pta.d.e("ro.build.version.incremental");
        if (TextUtils.isEmpty(r112) == false) goto L64;
    L66:
        r103 = false;
        goto L67
    L64:
        if (r112.contains("VIBEUI_V2") == false) goto L66;
    L54:
        r110 = r105.trim();
        goto L56
    L45:
        if (SmEditTextLeakOpt.SAMSUNG.equalsIgnoreCase(r105) == true) goto L48;
        r108 = false;
        goto L49
    L80:
        if (ita.k.j() == false) goto L82;
    L84:
        r102 = null;
        goto L85
    L82:
        if (g.f506105a.b(new Object[]{r100}).booleanValue() == false) goto L84;
        r102 = new g();
        goto L85
    L37:
        r107 = r106.toLowerCase(Locale.ENGLISH).contains("meizu");
        goto L38
    L8:
        if (x.f506163a == null) goto L12;
        if (x.f506165c == null) goto L12;
        r104 = true;
        goto L13
    }

    public static s b(Context r100) {
        if (f506124h != null) goto L15;
        monitor-enter(s.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f506124h != null) goto L9;
        f506124h = new s(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(s.class);     // Catch: Throwable -> L11
    L15:
        return f506124h;
    }

    public static void c(JSONObject r100, String r101, Object r102) {
        if (TextUtils.isEmpty(r101) == true) goto L12;
        if (r102 == null) goto L13;
        r100.put(r101, r102);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        return;
    }

    public static <K, V> void d(Map<K, V> r100, K r101, V r102) {
        if (r102 == null) goto L5;
        ((HashMap) r100).put(r101, r102);
        return;
    }
}
