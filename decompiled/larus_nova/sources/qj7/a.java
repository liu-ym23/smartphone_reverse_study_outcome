package qj7;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.ug.sdk.luckycat.impl.bigredpacket.model.RedPacketModel;
import com.bytedance.ug.sdk.luckycat.impl.manager.LuckyCatSettingsManger;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.bytedance.ug.sdk.luckycat.impl.manager.q;
import com.bytedance.ug.sdk.luckycat.impl.utils.s;
import com.bytedance.ug.sdk.luckycat.impl.utils.u;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f533306a;

    /* JADX INFO: renamed from: qj7.a$a, reason: collision with other inner class name */
    public class RunnableC7336a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f533307a;

        @Override // java.lang.Runnable
        public final void run() {
            f r100 = this.f533307a.f533306a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            ((q.a) r100).a(90001, "");     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public RunnableC7336a(a r100) {
            this.f533307a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f533308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f533309b;

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = this.f533308a.optInt("err_no");     // Catch: Throwable -> L6
            String r101 = this.f533308a.optString("err_tips");     // Catch: Throwable -> L6
            f r102 = this.f533309b.f533306a;     // Catch: Throwable -> L6
            if (r102 == null) goto L9;
            ((q.a) r102).a(r100, r101);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(a r100, JSONObject r101) {
            this.f533309b = r100;
            this.f533308a = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RedPacketModel f533310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f533311b;

        @Override // java.lang.Runnable
        public final void run() {
            f r100 = this.f533311b.f533306a;     // Catch: Throwable -> L20
            if (r100 == null) goto L23;
            RedPacketModel r101 = this.f533310a;     // Catch: Throwable -> L20
            q.a r102 = (q.a) r100;     // Catch: Throwable -> L20
            r102.f271364a.f271363h = true;     // Catch: Throwable -> L20
            r102.f271364a.getClass();     // Catch: Throwable -> L20
            r102.f271364a.getClass();     // Catch: Throwable -> L20
            if (r101 != null) goto L7;
            com.bytedance.ug.sdk.luckycat.impl.model.d.e(90002, "data empty");     // Catch: Throwable -> L20
            return;
        L7:
            ej7.b.a.f472883a.f472881a = r101;     // Catch: Throwable -> L20
            boolean r103 = r101.isPop();     // Catch: Throwable -> L20
            JSONObject r104 = new JSONObject();     // Catch: Throwable -> L20
        L14:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L20
        L16:
            com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_big_red_packet_request", r104, true);     // Catch: Throwable -> L20
            if (r102.f271364a.f271362g == null) goto L29;
            ((ej7.a) r102.f271364a.f271362g).b(r101);     // Catch: Throwable -> L20
            r102.f271364a.f271362g = null;     // Catch: Throwable -> L20
            return;
        L29:
            return;
        L9:
            if (m.a.f271349a.r() == false) goto L11;
            int r105 = 1;
        L12:
            r104.put("is_login", r105);     // Catch: JSONException -> L14 Throwable -> L20
            r104.put("is_succ", "succ");     // Catch: JSONException -> L14 Throwable -> L20
            r104.put(com.bytedance.android.ec.core.event.a.KEY_IS_SHOW, r103 ? 1 : 0);     // Catch: JSONException -> L14 Throwable -> L20
            r104.put("from", "init");     // Catch: JSONException -> L14 Throwable -> L20
        L11:
            r105 = 0;
            goto L12
        L23:
            return;
        L20:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L30;
            throw th;
        }

        public c(a r100, RedPacketModel r101) {
            this.f533311b = r100;
            this.f533310a = r101;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f533312a;

        @Override // java.lang.Runnable
        public final void run() {
            f r100 = this.f533312a.f533306a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            ((q.a) r100).a(90002, "data null");     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public d(a r100) {
            this.f533312a = r100;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f533313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f533314b;

        @Override // java.lang.Runnable
        public final void run() {
            f r100 = this.f533314b.f533306a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            q.a r101 = (q.a) r100;     // Catch: Throwable -> L6
            r101.a(90003, this.f533313a.toString());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public e(a r100, Throwable r101) {
            this.f533314b = r100;
            this.f533313a = r101;
        }
    }

    public interface f {
    }

    public final void a() {
        LuckyCatSettingsManger r100 = LuckyCatSettingsManger.b.f271283a;
        r100.getClass();
        Object r101 = r100.c(new String[]{"common", "enable_intercept_network_request"});
        if ((r101 instanceof Boolean) == false) goto L5;
        boolean r102 = ((Boolean) r101).booleanValue();
    L6:
        if (r102 == false) goto L9;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("BigRedPacketRequest", "BigRedPacketRequest run");
        return;
    L9:
        Handler r103 = new Handler(Looper.getMainLooper());
        m r104 = m.a.f271349a;     // Catch: Throwable -> L30
        String r105 = r104.b(r104.j() + "task/luck_draw");     // Catch: Throwable -> L30
        StringBuilder r106 = new StringBuilder(r105);     // Catch: Throwable -> L30
        m r107 = m.a.f271349a;     // Catch: Throwable -> L30
        if (pj7.a.a() == false) goto L16;
        SsResponse r108 = pj7.a.b(r105);     // Catch: Throwable -> L30
        if (r108 == null) goto L15;
        String r109 = (String) r108.body();     // Catch: Throwable -> L30
    L18:
        if (TextUtils.isEmpty(r109) == false) goto L21;
        r103.post(new RunnableC7336a(this));     // Catch: Throwable -> L30
        return;
    L21:
        JSONObject r110 = new JSONObject(r109);     // Catch: Throwable -> L30
        if (s.a(r110) == true) goto L25;
        r103.post(new b(this, r110));     // Catch: Throwable -> L30
        return;
    L25:
        JSONObject r111 = r110.optJSONObject("data");     // Catch: Throwable -> L30
        if (r111 == null) goto L28;
        u.a().g("key_big_red_packet_data", "");     // Catch: Throwable -> L30
        r103.post(new c(this, RedPacketModel.extract(r111)));     // Catch: Throwable -> L30
        return;
    L28:
        r103.post(new d(this));     // Catch: Throwable -> L30
        return;
    L15:
        r109 = null;
        goto L18
    L16:
        r109 = r107.d(r106.toString());     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        r103.post(new e(this, th));
        return;
    L5:
        r102 = false;
        goto L6
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

    public a(q.a r100) {
        this.f533306a = r100;
    }
}
