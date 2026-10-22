package qj7;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.ug.sdk.luckycat.impl.manager.d0;
import com.bytedance.ug.sdk.luckycat.impl.manager.h;
import com.bytedance.ug.sdk.luckycat.impl.manager.i;
import com.bytedance.ug.sdk.luckycat.impl.manager.j;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.bytedance.ug.sdk.luckycat.impl.utils.s;
import com.bytedance.ug.sdk.luckycat.impl.utils.u;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f533315a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f533316a;

        @Override // java.lang.Runnable
        public final void run() {
            f r100 = this.f533316a.f533315a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            ((h) r100).a(90001, "response_empty");     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(b r100) {
            this.f533316a = r100;
        }
    }

    /* JADX INFO: renamed from: qj7.b$b, reason: collision with other inner class name */
    public class RunnableC7337b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f533317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f533318b;

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = this.f533317a.optInt("err_no");     // Catch: Throwable -> L6
            String r101 = this.f533317a.optString("err_tips");     // Catch: Throwable -> L6
            f r102 = this.f533318b.f533315a;     // Catch: Throwable -> L6
            if (r102 == null) goto L9;
            ((h) r102).a(r100, r101);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public RunnableC7337b(b r100, JSONObject r101) {
            this.f533318b = r100;
            this.f533317a = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f533319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f533320b;

        public final void a() {
            f r100 = this.f533320b.f533315a;
            if (r100 == null) goto L20;
            String r101 = this.f533319a.toString();
            h r102 = (h) r100;
            r102.getClass();
            cj7.a.b("update_setting");
            r102.f271318a.f271320b = true;
            r102.f271318a.f271319a = r101;
            Context r103 = m.a.f271349a.f();
            if (d0.f271316a == null) goto L7;
        L16:
            d0.f271316a.getClass();
            j.f271323f.b();
            i.a(r102.f271318a, true);
            return;
        L7:
            monitor-enter(d0.class);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (d0.f271316a != null) goto L11;
            d0.f271316a = new d0(r103);     // Catch: Throwable -> L13
        L11:
            monitor-exit(d0.class);     // Catch: Throwable -> L13
            goto L16
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

        public c(b r100, JSONObject r101) {
            this.f533320b = r100;
            this.f533319a = r101;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f533321a;

        @Override // java.lang.Runnable
        public final void run() {
            f r100 = this.f533321a.f533315a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            ((h) r100).a(90002, "data_empty");     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public d(b r100) {
            this.f533321a = r100;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f533322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f533323b;

        @Override // java.lang.Runnable
        public final void run() {
            f r100 = this.f533323b.f533315a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            h r101 = (h) r100;     // Catch: Throwable -> L6
            r101.a(90003, this.f533322a.toString());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public e(b r100, Throwable r101) {
            this.f533323b = r100;
            this.f533322a = r101;
        }
    }

    public interface f {
    }

    public final void a() {
        Handler r100 = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L23
        m r101 = m.a.f271349a;     // Catch: Throwable -> L23
        StringBuilder r102 = new StringBuilder(r101.b(r101.j() + "widget/kvs"));     // Catch: Throwable -> L23
        r102.append("&keys=next_req_interval,req_frequency_control_switch,next_refresh,max_get_inv_code_t,inv_code_patterns");     // Catch: Throwable -> L23
        String r103 = r102.toString();     // Catch: Throwable -> L23
        if (pj7.a.a() == false) goto L9;
        SsResponse r104 = pj7.a.b(r103);     // Catch: Throwable -> L23
        if (r104 == null) goto L8;
        String r105 = (String) r104.body();     // Catch: Throwable -> L23
    L11:
        if (TextUtils.isEmpty(r105) == false) goto L14;
        r100.post(new a(this));     // Catch: Throwable -> L23
        return;
    L14:
        JSONObject r106 = new JSONObject(r105);     // Catch: Throwable -> L23
        if (s.a(r106) == true) goto L18;
        r100.post(new RunnableC7337b(this, r106));     // Catch: Throwable -> L23
        return;
    L18:
        JSONObject r107 = r106.optJSONObject("data");     // Catch: Throwable -> L23
        if (r107 == null) goto L21;
        r100.post(new c(this, r107));     // Catch: Throwable -> L23
        u.a().g("init_settings", r107.toString());     // Catch: Throwable -> L23
        return;
    L21:
        r100.post(new d(this));     // Catch: Throwable -> L23
        return;
    L8:
        r105 = null;
        goto L11
    L9:
        r105 = r101.d(r103);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        new Handler(Looper.getMainLooper()).post(new e(this, th));
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

    public b(h r100) {
        this.f533315a = r100;
    }
}
