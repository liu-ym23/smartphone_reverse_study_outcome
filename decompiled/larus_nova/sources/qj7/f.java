package qj7;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.bytedance.ug.sdk.luckycat.impl.utils.s;
import com.bytedance.ug.sdk.luckycat.impl.utils.z;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pi7.f f533352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f533353b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f533354a;

        @Override // java.lang.Runnable
        public final void run() {
            pi7.f r100 = this.f533354a.f533352a;     // Catch: Throwable -> L6
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

        public a(f r100) {
            this.f533354a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f533355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f533356b;

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = this.f533355a.optInt("err_no");     // Catch: Throwable -> L6
            this.f533355a.optString("err_tips");     // Catch: Throwable -> L6
            pi7.f r101 = this.f533356b.f533352a;     // Catch: Throwable -> L6
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

        public b(f r100, JSONObject r101) {
            this.f533356b = r100;
            this.f533355a = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f533357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f533358b;

        @Override // java.lang.Runnable
        public final void run() {
            pi7.f r100 = this.f533358b.f533352a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onSuccess(this.f533357a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public c(f r100, JSONObject r101) {
            this.f533358b = r100;
            this.f533357a = r101;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f533359a;

        @Override // java.lang.Runnable
        public final void run() {
            pi7.f r100 = this.f533359a.f533352a;     // Catch: Throwable -> L6
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

        public d(f r100) {
            this.f533359a = r100;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f533360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f533361b;

        @Override // java.lang.Runnable
        public final void run() {
            pi7.f r100 = this.f533361b.f533352a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            this.f533360a.toString();     // Catch: Throwable -> L6
            r100.onFailed(90003);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public e(f r100, Throwable r101) {
            this.f533361b = r100;
            this.f533360a = r101;
        }
    }

    public final void b() {
        Handler r100 = new Handler(Looper.getMainLooper());
        m r101 = m.a.f271349a;     // Catch: Throwable -> L23
        TextUtils.isEmpty("widget/entry");     // Catch: Throwable -> L23
        String r102 = a(r101.b(r101.j() + "widget/entry"));     // Catch: Throwable -> L23
        if (pj7.a.a() == false) goto L9;
        SsResponse r103 = pj7.a.b(r102);     // Catch: Throwable -> L23
        if (r103 == null) goto L8;
        String r104 = (String) r103.body();     // Catch: Throwable -> L23
    L11:
        if (TextUtils.isEmpty(r104) == false) goto L14;
        r100.post(new a(this));     // Catch: Throwable -> L23
        return;
    L14:
        JSONObject r105 = new JSONObject(r104);     // Catch: Throwable -> L23
        if (s.a(r105) == true) goto L18;
        r100.post(new b(this, r105));     // Catch: Throwable -> L23
        return;
    L18:
        JSONObject r106 = r105.optJSONObject("data");     // Catch: Throwable -> L23
        if (r106 == null) goto L21;
        new Handler(Looper.getMainLooper()).post(new c(this, r106));     // Catch: Throwable -> L23
        return;
    L21:
        new Handler(Looper.getMainLooper()).post(new d(this));     // Catch: Throwable -> L23
        return;
    L8:
        r104 = null;
        goto L11
    L9:
        r104 = r101.d(r102);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r100.post(new e(this, th));
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public final String a(String r100) {
        StringBuilder r101 = new StringBuilder(r100);
        if (r101.toString().indexOf(63) >= 0) goto L5;
        r101.append("?");
    L6:
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("scene", this.f533353b);
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        Map.Entry r105 = (Map.Entry) r104.next();
        r103.add(new Pair(r105.getKey(), r105.getValue()));
        goto L8
    L10:
        r101.append(z.a(r103));
        return r101.toString();
    L5:
        r101.append("&");
        goto L6
    }

    public f(vj7.b.a r100, String r101) {
        this.f533352a = r100;
        this.f533353b = r101;
    }
}
