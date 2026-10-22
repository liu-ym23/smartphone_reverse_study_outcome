package mt3;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import ita.k;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements nu3.d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile h f515628f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public pt3.c f515629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile pt3.c f515630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public nt3.a f515631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f515632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile List<String> f515633e;

    static {
        f515628f = new h();
    }

    public final void c() {
        if (this.f515630b == null) goto L5;
        return;
    L5:
        this.f515630b = new pt3.c(ot3.e.a(), new PolarisFileWrapper(b.b(), "priority_persistent.bin"), b.d());
        c r100 = c.e.f515622a;
        r100.f515617e = this.f515630b;
    }

    public h() {
        this.f515632d = false;
        this.f515633e = null;
    }

    @Override // nu3.d
    public final void a(nu3.c r100) {
        if (this.f515632d == true) goto L36;
        monitor-enter(this);
    L33:
        th = move-exception;
        throw th;
    L6:
        if (this.f515632d == false) goto L10;
        monitor-exit(this);
        goto L36
    L10:
        if (xu3.a.a() == false) goto L12;
        List<String> r101 = a.f515607a;     // Catch: Throwable -> L33
        av3.b.a("APM-Slardar", "Initializing SlardarHandler...");     // Catch: Throwable -> L33
    L12:
        ot3.b.b().c();     // Catch: Throwable -> L33
        com.bytedance.apm6.consumer.slardar.send.downgrade.a.C2766a.f190733a.a(xu3.a.getContext());     // Catch: Throwable -> L33
        nt3.b r102 = (nt3.b) qu3.c.a(nt3.b.class);     // Catch: Throwable -> L33
        if (r102 == null) goto L15;
        d(r102.getConfig());     // Catch: Throwable -> L33
    L15:
        this.f515629a = new pt3.c(ot3.e.a(), b.c(), b.a());     // Catch: Throwable -> L33
        if (this.f515633e == null) goto L18;
        c();     // Catch: Throwable -> L33
    L18:
        c r103 = c.e.f515622a;     // Catch: Throwable -> L33
        r103.f515616d = this.f515629a;     // Catch: Throwable -> L33
        r103.f515617e = this.f515630b;     // Catch: Throwable -> L33
        rt3.d.f539191f.a(r103);     // Catch: Throwable -> L33
        rt3.d r104 = rt3.d.f539191f;     // Catch: Throwable -> L33
        com.bytedance.apm6.consumer.slardar.send.f r105 = com.bytedance.apm6.consumer.slardar.send.f.b.f190740a;     // Catch: Throwable -> L33
        r104.a(r105);     // Catch: Throwable -> L33
        rt3.d r106 = rt3.d.f539191f;     // Catch: Throwable -> L33
        r106.getClass();     // Catch: Throwable -> L33
        if (du3.a.o() == false) goto L22;
        cv3.b.a(AsyncTaskManagerType.IO).c(new rt3.c(r106));     // Catch: Throwable -> L33
    L22:
        r103.d();     // Catch: Throwable -> L33
        r105.getClass();     // Catch: Throwable -> L33
        r105.f190736b = new com.bytedance.apm6.consumer.slardar.send.e(r105);     // Catch: Throwable -> L33
        cv3.b.a(AsyncTaskManagerType.IO).c(r105.f190736b);     // Catch: Throwable -> L33
        uu3.a r107 = (uu3.a) qu3.c.a(uu3.a.class);     // Catch: Throwable -> L28
        if (r107 == null) goto L30;
        r107.a(new g(this));     // Catch: Throwable -> L28
    L30:
        this.f515632d = true;     // Catch: Throwable -> L33
        monitor-exit(this);
    L28:
        th = move-exception;
        List<String> r108 = a.f515607a;     // Catch: Throwable -> L33
        av3.b.c("APM-Slardar", "registerForegroundCallback failed", th);     // Catch: Throwable -> L33
    L36:
        JSONObject r109 = r100.a();
        if (a.f515607a.contains(r100.getLogType()) == false) goto L39;
    L59:
        b(r109, false);
    L61:
        if (xu3.a.a() == false) goto L63;
        ls3.a.a(r100.getLogType(), r109, true);
    L63:
        List<String> r110 = this.f515633e;
        pt3.c r111 = this.f515630b;
        if (r110 == null) goto L72;
        if (r111 == null) goto L72;
        if (r110.contains(r100.getLogType()) == false) goto L72;
        if (xu3.a.a() == false) goto L71;
        av3.b.a("APM-Slardar", "push to priority buffer, logType=" + r100.getLogType());
    L71:
        r111.e(r109);
        return;
    L72:
        this.f515629a.e(r109);
        return;
    L39:
        if (UploadTypeInf.TRACING.equals(r100.getLogType()) == true) goto L59;
        if (com.bytedance.apm6.consumer.slardar.send.downgrade.a.C2766a.f190733a.c(r109, du3.a.b()) == false) goto L44;
        b(r109, true);
        goto L61
    L44:
        if (xu3.a.a() == false) goto L80;
        String r112 = r100.getLogType();
        AtomicInteger r113 = ls3.a.f510531a;
        JSONObject r114 = r109.optJSONObject("DATA_DOCTOR");
        if (r114 != null) goto L78;
        r114 = new JSONObject();
    L78:
    L54:
        e = move-exception;
        e.printStackTrace();
    L56:
        List<String> r115 = a.f515607a;
        av3.b.a("APM-Slardar", "push failed: event(aid=" + du3.a.b() + " is downgraded: " + r109.toString());
        return;
    L50:
        if (r114.optInt("DATA_ID", -1) != (-1)) goto L52;
        r114.put("DATA_ID", ls3.a.f510531a.incrementAndGet());     // Catch: Exception -> L54
    L52:
        r114.put("DATA_PROCESS", k.c(xu3.a.getContext()));     // Catch: Exception -> L54
        r114.put("DATA_TYPE", r112);     // Catch: Exception -> L54
        r114.put("DATA_AID", du3.a.b());     // Catch: Exception -> L54
        r109.put("DATA_DOCTOR", r114);     // Catch: Exception -> L54
        DoctorManager.getInstance().a("DATA_DOWNGRADE", new JSONObject(r109.toString()));     // Catch: Exception -> L54
        goto L56
    }

    public final synchronized void d(nt3.a r110) {
        monitor-enter(this);
        this.f515631c = r110;     // Catch: Throwable -> L38
        boolean r100 = true;
        if (r110 == null) goto L30;
        com.bytedance.apm6.consumer.slardar.send.d.a.f190725a.f190723l = r110;     // Catch: Throwable -> L38
        c r101 = c.e.f515622a;     // Catch: Throwable -> L38
        r101.f(r110.f520482g);     // Catch: Throwable -> L38
        long r102 = r110.f520476a;     // Catch: Throwable -> L38
        if (r102 > 0) goto L9;
        r101.getClass();     // Catch: Throwable -> L38
    L10:
        rt3.d.f539191f.b(r110.f520483h, r110.f520484i, r110.f520485j);     // Catch: Throwable -> L38
        int r103 = r110.f520486k;     // Catch: Throwable -> L38
        if (r103 != 2) goto L15;
        HashMap<com.bytedance.apm6.consumer.slardar.send.h, com.bytedance.apm6.consumer.slardar.send.g> r104 = com.bytedance.apm6.consumer.slardar.send.g.f190744j;     // Catch: Throwable -> L38
        if ((System.currentTimeMillis() - xu3.a.getContext().getSharedPreferences("dict_interval", 0).getLong("force_zstd_timestamp", 0)) > 3600000) goto L15;
        com.bytedance.apm6.consumer.slardar.send.g.f190745k = 1;     // Catch: Throwable -> L38
    L16:
        List<String> r105 = r110.f520487l;     // Catch: Throwable -> L38
        if (r105 == null) goto L30;
        if (r105.isEmpty() == false) goto L21;
        List<String> r111 = null;
    L22:
        if (r111 != null) goto L24;
    L26:
        this.f515633e = r111;     // Catch: Throwable -> L38
        if (xu3.a.a() == false) goto L30;
        List<String> r106 = a.f515607a;     // Catch: Throwable -> L38
        av3.b.a("APM-Slardar", "priorityLogTypes updated: " + r111);     // Catch: Throwable -> L38
        goto L30
    L24:
        if (this.f515632d == false) goto L26;
        c();     // Catch: Throwable -> L38
        goto L26
    L21:
        r111 = r110.f520487l;     // Catch: Throwable -> L38
    L15:
        com.bytedance.apm6.consumer.slardar.send.g.f190745k = r103;     // Catch: Throwable -> L38
        goto L16
    L9:
        r101.f515614b = r102;     // Catch: Throwable -> L38
    L30:
        if (xu3.a.a() == false) goto L36;
        List<String> r112 = a.f515607a;     // Catch: Throwable -> L38
        StringBuilder r107 = new StringBuilder("setSlardarHandlerConfig: priorityLogTypes=");     // Catch: Throwable -> L38
        r107.append(this.f515633e);     // Catch: Throwable -> L38
        r107.append(", inited=");     // Catch: Throwable -> L38
        r107.append(this.f515632d);     // Catch: Throwable -> L38
        r107.append(", priorityBuffer=");     // Catch: Throwable -> L38
        if (this.f515630b != null) goto L35;
        r100 = false;
    L35:
        r107.append(r100);     // Catch: Throwable -> L38
        av3.b.a("APM-Slardar", r107.toString());     // Catch: Throwable -> L38
    L36:
        monitor-exit(this);
        return;
    L38:
        th = move-exception;
        throw th;
    }

    public static void b(JSONObject r100, boolean r101) {
    L42:
        List<String> r102 = a.f515607a;
        return;
    L4:
        if (TextUtils.isEmpty(du3.a.f470025c.getSessionId()) == true) goto L7;
        r100.put("session_id", du3.a.f470025c.getSessionId());     // Catch: Exception -> L42
    L7:
        if (r100.isNull("network_type") == false) goto L31;
        NetworkUtils.NetworkType r103 = NetworkUtils.getNetworkTypeFast(xu3.a.getContext());     // Catch: Exception -> L42
        r100.put("network_type", r103.getValue());     // Catch: Exception -> L42
        if (r103.is2G() == false) goto L11;
    L12:
        Application r104 = xu3.a.getContext();     // Catch: Exception -> L42
        ConnectivityManager r105 = (ConnectivityManager) r104.getSystemService("connectivity");     // Catch: Throwable -> L26
        if (ContextCompat.checkSelfPermission(r104, "android.permission.ACCESS_NETWORK_STATE") != 0) goto L17;
        NetworkInfo r106 = r105.getActiveNetworkInfo();     // Catch: Throwable -> L26
    L18:
        if (r106 == null) goto L27;
        if (r106.isAvailable() == false) goto L27;
        if (r106.getType() != 0) goto L27;
        int r107 = ((TelephonyManager) r104.getSystemService("phone")).getNetworkType();     // Catch: Throwable -> L26
    L28:
        if (r107 == (-10000)) goto L31;
        r100.put("network_type_code", r107);     // Catch: Exception -> L42
        goto L31
    L17:
        r106 = null;
    L27:
        r107 = -10000;
        goto L28
    L11:
        if (r103.is3GOrHigher() == true) goto L12;
    L31:
        if (r100.isNull("timestamp") == false) goto L33;
    L34:
        r100.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L42
    L36:
        if (r100.isNull(WsConstants.KEY_SESSION_ID) == false) goto L38;
        r100.put(WsConstants.KEY_SESSION_ID, du3.a.k());     // Catch: Exception -> L42
    L38:
        r100.put("process_name", du3.a.e());     // Catch: Exception -> L42
        if (r101 == false) goto L48;
        r100.put("seq_no", f.a.f515626a.a());     // Catch: Exception -> L42
        return;
    L48:
        return;
    L33:
        if (r100.optLong("timestamp") > 0) goto L36;
        goto L34
    }
}
