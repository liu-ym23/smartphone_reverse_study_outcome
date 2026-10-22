package n4a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class t4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static v3 f517756g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static w f517757h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f517758i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f517759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f517760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v3 f517761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public v3 f517762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f517763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f517764f;

    public t4(Context r100) {
        this.f517760b = null;
        this.f517761c = null;
        this.f517762d = null;
        this.f517763e = 0;
        this.f517764f = false;
        this.f517759a = r100.getApplicationContext();
    }

    public final void b() {
        if (this.f517764f == false) goto L16;
        return;
    L16:
    L12:
        th = move-exception;
        c4.g(th, "LastLocationManager", "<init>:DBOperation");
    L14:
        this.f517764f = true;
        return;
    L6:
        if (this.f517760b != null) goto L9;
        this.f517760b = t3.a("MD5", "");     // Catch: Throwable -> L12
    L9:
        if (f517757h != null) goto L14;
        v r100 = w.d(w3.class);     // Catch: Throwable -> L12
        f517757h = new w(this.f517759a, r100);     // Catch: Throwable -> L12
        goto L14
    }

    public final void e() {
        if (f517756g != null) goto L5;
    L6:
        v3 r100 = null;
        r100 = null;
        String r101 = null;
        r101 = null;
        r101 = null;
        r101 = null;
        String r102 = null;
        if (this.f517759a == null) goto L50;
        b();
        w r103 = f517757h;     // Catch: Throwable -> L46
        if (r103 == null) goto L50;
        List r104 = r103.c(v3.class);     // Catch: Throwable -> L46
        if (((ArrayList) r104).size() <= 0) goto L37;
        v3 r105 = (v3) ListProtector.get(r104, 0);     // Catch: Throwable -> L46
        byte[] r106 = y4.e(r105.f517827a);     // Catch: Throwable -> L44
        if (r106 != null) goto L20;
    L26:
        String r107 = null;
    L27:
        byte[] r108 = y4.e(r105.f517829c);     // Catch: Throwable -> L44
        if (r108 != null) goto L30;
    L36:
        r105.f517829c = r101;     // Catch: Throwable -> L44
        r102 = r107;
    L39:
        if (TextUtils.isEmpty(r102) == true) goto L49;
        AMapLocation r109 = new AMapLocation("");     // Catch: Throwable -> L44
        c4.e(r109, new JSONObject(r102));     // Catch: Throwable -> L44
        if (j4.w(r109) == false) goto L49;
        r105.f517830d = r109;     // Catch: Throwable -> L44
    L49:
        r100 = r105;
        goto L50
    L30:
        if (r108.length <= 0) goto L36;
        byte[] r110 = t3.e(r108, this.f517760b);     // Catch: Throwable -> L44
        if (r110 == null) goto L36;
        if (r110.length <= 0) goto L36;
        r101 = new String(r110, "UTF-8");     // Catch: Throwable -> L44
        goto L36
    L20:
        if (r106.length <= 0) goto L26;
        byte[] r111 = t3.e(r106, this.f517760b);     // Catch: Throwable -> L44
        if (r111 == null) goto L26;
        if (r111.length <= 0) goto L26;
        r107 = new String(r111, "UTF-8");     // Catch: Throwable -> L44
    L44:
        Throwable th10 = th;
    L48:
        c4.g(th10, "LastLocationManager", "readLastFix");
        goto L49
    L37:
        r105 = null;
    L46:
        th = move-exception;
        th10 = th;
        r105 = null;
    L50:
        f517758i = SystemClock.elapsedRealtime();
        if (r100 != null) goto L53;
        return;
    L53:
        if (j4.l(r100.f517830d) == false) goto L62;
        f517756g = r100;
        return;
    L62:
        return;
    L5:
        if ((SystemClock.elapsedRealtime() - f517758i) > 180000) goto L6;
    }

    public final void d() {
        b();     // Catch: Throwable -> L38
        v3 r100 = this.f517761c;     // Catch: Throwable -> L38
        if (r100 != null) goto L5;
        return;
    L5:
        if (j4.l(r100.f517830d) == true) goto L7;
        return;
    L7:
        if (f517757h == null) goto L45;
        v3 r101 = this.f517761c;     // Catch: Throwable -> L38
        if (r101 != this.f517762d) goto L11;
        return;
    L11:
        if (r101.f517828b != 0) goto L47;
        String r102 = r101.f517830d.toStr();     // Catch: Throwable -> L38
        v3 r103 = this.f517761c;     // Catch: Throwable -> L38
        String r104 = r103.f517829c;     // Catch: Throwable -> L38
        this.f517762d = r103;     // Catch: Throwable -> L38
        String r105 = null;
        if (TextUtils.isEmpty(r102) == true) goto L19;
        String r106 = y4.d(t3.c(r102.getBytes("UTF-8"), this.f517760b));     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r104) == true) goto L18;
        r105 = y4.d(t3.c(r104.getBytes("UTF-8"), this.f517760b));     // Catch: Throwable -> L38
    L18:
        String r107 = r105;
        r105 = r106;
        String r108 = r107;
    L21:
        if (TextUtils.isEmpty(r105) == true) goto L48;
        v3 r109 = new v3();     // Catch: Throwable -> L38
        r109.f517827a = r105;     // Catch: Throwable -> L38
        r109.f517828b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L38
        r109.f517829c = r108;     // Catch: Throwable -> L38
        w r110 = f517757h;     // Catch: Throwable -> L38
        v r111 = r110.f517842c;     // Catch: Throwable -> L38
        monitor-enter(r111);     // Catch: Throwable -> L38
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L25:
        if (((ArrayList) r110.c(v3.class)).size() != 0) goto L29;
        r110.e(r109);     // Catch: Throwable -> L27
    L30:
        monitor-exit(r111);     // Catch: Throwable -> L27
        this.f517763e = SystemClock.elapsedRealtime();     // Catch: Throwable -> L38
        v3 r112 = f517756g;     // Catch: Throwable -> L38
        if (r112 == null) goto L49;
        r112.f517828b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L38
        return;
    L49:
        return;
    L29:
        r110.h(r109);     // Catch: Throwable -> L27
        goto L30
    L48:
        return;
    L19:
        r108 = null;
        goto L21
    L47:
        return;
    L45:
        return;
    L38:
        th = move-exception;
        c4.g(th, "LastLocationManager", "saveLastFix");
    }

    public final boolean c(AMapLocation r100, String r101) {
        if (this.f517759a == null) goto L30;
        if (r100 == null) goto L30;
        if (j4.l(r100) == false) goto L30;
        if (r100.getLocationType() == 2) goto L30;
        if (r100.isMock() == true) goto L30;
        if (r100.isFixLastLocation() == true) goto L30;
        v3 r102 = new v3();
        r102.f517830d = r100;
        if (r100.getLocationType() != 1) goto L18;
        r102.f517829c = null;
    L31:
        f517756g = r102;     // Catch: Throwable -> L28
        f517758i = SystemClock.elapsedRealtime();     // Catch: Throwable -> L28
        this.f517761c = r102;     // Catch: Throwable -> L28
        v3 r103 = this.f517762d;     // Catch: Throwable -> L28
        if (r103 != null) goto L22;
    L24:
        if ((SystemClock.elapsedRealtime() - this.f517763e) <= 30000) goto L30;
        return true;
    L22:
        if (j4.a(r103.f517830d, r102.f517830d) > 500.0f) goto L24;
        return false;
    L28:
        th = move-exception;
        c4.g(th, "LastLocationManager", "setLastFix");
        goto L30
    L18:
        r102.f517829c = r101;
    L30:
        return false;
    }

    public final AMapLocation a(AMapLocation r100, String r101, long r110) {
        if (r100 != null) goto L5;
        return r100;
    L5:
        if (r100.getErrorCode() != 0) goto L7;
        return r100;
    L7:
        if (r100.getLocationType() != 1) goto L9;
        return r100;
    L9:
        if (r100.getErrorCode() == 7) goto L44;
        e();     // Catch: Throwable -> L33
        v3 r102 = f517756g;     // Catch: Throwable -> L33
        if (r102 != null) goto L14;
    L32:
        return r100;
    L14:
        if (r102.f517830d == null) goto L32;
        if (TextUtils.isEmpty(r101) == false) goto L25;
        long r103 = SystemClock.elapsedRealtime() - f517756g.f517828b;     // Catch: Throwable -> L33
        if (r103 >= 0) goto L21;
    L23:
        boolean r104 = false;
    L24:
        r100.setTrustedLevel(3);     // Catch: Throwable -> L33
    L26:
        if (r104 == false) goto L42;
        AMapLocation r105 = f517756g.f517830d;     // Catch: Throwable -> L33
        b4.a(r105);     // Catch: Throwable -> L30
        r105.setLocationType(9);     // Catch: Throwable -> L30
        r105.setFixLastLocation(true);     // Catch: Throwable -> L30
        r105.setLocationDetail(r100.getLocationDetail());     // Catch: Throwable -> L30
        return r105;
    L30:
        th = move-exception;
        th = th;
        r100 = r105;
    L34:
        c4.g(th, "LastLocationManager", "fixLastLocation");
        return r100;
    L42:
        return r100;
    L21:
        if (r103 > r110) goto L23;
        r104 = true;
        goto L24
    L25:
        r104 = j4.o(f517756g.f517829c, r101);     // Catch: Throwable -> L33
        r100.setTrustedLevel(2);     // Catch: Throwable -> L33
    L33:
        th = th;
        goto L34
    L44:
        return r100;
    }
}
