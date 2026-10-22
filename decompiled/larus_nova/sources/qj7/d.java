package qj7;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ug.sdk.luckycat.api.depend.l;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.bytedance.ug.sdk.luckycat.impl.manager.z;
import com.bytedance.ug.sdk.luckycat.impl.utils.s;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f533334a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f533335a;

        @Override // java.lang.Runnable
        public final void run() {
            f r100 = this.f533335a.f533334a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            ((z) r100).f271377a.f271303b = false;     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(d r100) {
            this.f533335a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f533336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f533337b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f533336a.optInt("err_no");     // Catch: Throwable -> L6
            this.f533336a.optString("err_tips");     // Catch: Throwable -> L6
            f r100 = this.f533337b.f533334a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            ((z) r100).f271377a.f271303b = false;     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(d r100, JSONObject r101) {
            this.f533337b = r100;
            this.f533336a = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f533338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f533339b;

        public final void a() {
            JSONObject r100 = this.f533338a;
            if (r100 == null) goto L9;
            JSONObject r101 = r100.optJSONObject("image_info");
            if (r101 == null) goto L8;
            r101.optString("url", "");
            r101.optInt("width", 0);
            r101.optInt("height", 0);
        L8:
            r100.optBoolean("pop_up", false);
            r100.optString("pop_key", "");
            r100.optString("callback_url", "");
            r100.optString("action_url", "");
            r100.optString(com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "");
        L9:
            f r102 = this.f533339b.f533334a;
            if (r102 == null) goto L29;
            z r103 = (z) r102;
            r103.f271377a.f271303b = false;
            r103.f271377a.getClass();
            if (to7.c.b() == null) goto L30;
            l r104 = m.a.f271349a.f271339g;
            if (r104 == null) goto L17;
            r104.c();
        L17:
            l r105 = com.bytedance.ug.sdk.luckycat.impl.manager.c.b();
            if (r105 == null) goto L20;
            r105.c();
        L20:
            JSONObject r106 = new JSONObject();
            r106.put("key", "pop_up");     // Catch: JSONException -> L23
        L25:
            com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_other_dialog_show", r106, true);
            return;
        L23:
            e = move-exception;
            e.printStackTrace();
            goto L25
        L30:
            return;
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

        public c(d r100, JSONObject r101) {
            this.f533339b = r100;
            this.f533338a = r101;
        }
    }

    /* JADX INFO: renamed from: qj7.d$d, reason: collision with other inner class name */
    public class RunnableC7339d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f533340a;

        @Override // java.lang.Runnable
        public final void run() {
            f r100 = this.f533340a.f533334a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            ((z) r100).f271377a.f271303b = false;     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public RunnableC7339d(d r100) {
            this.f533340a = r100;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f533341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f533342b;

        @Override // java.lang.Runnable
        public final void run() {
            f r100 = this.f533342b.f533334a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            this.f533341a.toString();     // Catch: Throwable -> L6
            ((z) r100).f271377a.f271303b = false;     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public e(d r100, Throwable r101) {
            this.f533342b = r100;
            this.f533341a = r101;
        }
    }

    public interface f {
    }

    public final void a() {
        Handler r100 = new Handler(Looper.getMainLooper());
        m r101 = m.a.f271349a;     // Catch: Throwable -> L16
        StringBuilder r102 = new StringBuilder(r101.b(r101.j() + "popup/get"));     // Catch: Throwable -> L16
        r102.append("&key=my_tab&page=my_tab");     // Catch: Throwable -> L16
        String r103 = r101.d(r102.toString());     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r103) == false) goto L7;
        r100.post(new a(this));     // Catch: Throwable -> L16
        return;
    L7:
        JSONObject r104 = new JSONObject(r103);     // Catch: Throwable -> L16
        if (s.a(r104) == true) goto L11;
        r100.post(new b(this, r104));     // Catch: Throwable -> L16
        return;
    L11:
        JSONObject r105 = r104.optJSONObject("data");     // Catch: Throwable -> L16
        if (r105 == null) goto L14;
        r100.post(new c(this, r105));     // Catch: Throwable -> L16
        return;
    L14:
        r100.post(new RunnableC7339d(this));     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        r100.post(new e(this, th));
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

    public d(z r100) {
        this.f533334a = r100;
    }
}
