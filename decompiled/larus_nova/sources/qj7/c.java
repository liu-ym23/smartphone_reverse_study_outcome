package qj7;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.bytedance.ug.sdk.luckycat.impl.manager.r;
import com.bytedance.ug.sdk.luckycat.impl.utils.s;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pi7.f f533324a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f533325a;

        @Override // java.lang.Runnable
        public final void run() {
            pi7.f r100 = this.f533325a.f533324a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onFailed(90043);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(c r100) {
            this.f533325a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f533326a;

        @Override // java.lang.Runnable
        public final void run() {
            pi7.f r100 = this.f533326a.f533324a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onFailed(90001);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(c r100) {
            this.f533326a = r100;
        }
    }

    /* JADX INFO: renamed from: qj7.c$c, reason: collision with other inner class name */
    public class RunnableC7338c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f533327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f533328b;

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = this.f533327a.optInt("err_no");     // Catch: Throwable -> L6
            this.f533327a.optString("err_tips");     // Catch: Throwable -> L6
            pi7.f r101 = this.f533328b.f533324a;     // Catch: Throwable -> L6
            if (r101 == null) goto L9;
            r101.onFailed(r100);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public RunnableC7338c(c r100, JSONObject r101) {
            this.f533328b = r100;
            this.f533327a = r101;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f533329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f533330b;

        @Override // java.lang.Runnable
        public final void run() {
            pi7.f r100 = this.f533330b.f533324a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onSuccess(this.f533329a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public d(c r100, JSONObject r101) {
            this.f533330b = r100;
            this.f533329a = r101;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f533331a;

        @Override // java.lang.Runnable
        public final void run() {
            pi7.f r100 = this.f533331a.f533324a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onFailed(90002);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public e(c r100) {
            this.f533331a = r100;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f533332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f533333b;

        @Override // java.lang.Runnable
        public final void run() {
            pi7.f r100 = this.f533333b.f533324a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            this.f533332a.toString();     // Catch: Throwable -> L6
            r100.onFailed(90003);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public f(c r100, Throwable r101) {
            this.f533333b = r100;
            this.f533332a = r101;
        }
    }

    public c() {
        this.f533324a = r.f271366b;
    }

    public final void a() {
        Handler r100 = new Handler(Looper.getMainLooper());
        m r101 = m.a.f271349a;     // Catch: Throwable -> L26
        NetworkInfo r102 = ((ConnectivityManager) r101.f().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L29 Throwable -> L26
        if (r102 == null) goto L9;
        if (r102.isConnected() == false) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L13;
        r100.post(new a(this));     // Catch: Throwable -> L26
        return;
    L13:
        String r104 = r101.d(r101.b(r101.j() + "gecko/get_gecko_conf"));     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r104) == false) goto L17;
        r100.post(new b(this));     // Catch: Throwable -> L26
        return;
    L17:
        JSONObject r105 = new JSONObject(r104);     // Catch: Throwable -> L26
        if (s.a(r105) == true) goto L21;
        r100.post(new RunnableC7338c(this, r105));     // Catch: Throwable -> L26
        return;
    L21:
        JSONObject r106 = r105.optJSONObject("data");     // Catch: Throwable -> L26
        if (r106 == null) goto L24;
        new Handler(Looper.getMainLooper()).post(new d(this, r106));     // Catch: Throwable -> L26
        return;
    L24:
        new Handler(Looper.getMainLooper()).post(new e(this));     // Catch: Throwable -> L26
        return;
    L9:
        r103 = false;
    L26:
        th = move-exception;
        r100.post(new f(this, th));
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
