package gm7;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import rk7.m;
import uk7.n;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f481680a = 0;

    public interface a {
        void a(hm7.d r100);

        void onFail(int r100, String r101);
    }

    /* JADX INFO: renamed from: gm7.b$b, reason: collision with other inner class name */
    public interface InterfaceC6037b {
        void onFail(int r100, String r101);

        void onSuccess();
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f481681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f481682b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f481683c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f481684d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f481685e;

        public c(String r100, String r101, int r102, a r103, boolean r104) {
            this.f481681a = r100;
            this.f481682b = r101;
            this.f481683c = r102;
            this.f481684d = r103;
            this.f481685e = r104;
        }

        public final void a() {
            JSONObject r100 = new JSONObject();     // Catch: Throwable -> L15
            r100.put("task_token", this.f481681a);     // Catch: Throwable -> L15
            r100.put("key", this.f481682b);     // Catch: Throwable -> L15
            r100.put("report_interval", this.f481683c);     // Catch: Throwable -> L15
            String r101 = (String) n.c("https://polaris.zijieapi.com/luckycat/crossover/v:version/get_timer_widget/", r100).body();     // Catch: Throwable -> L15
            int r102 = -1;
            if (TextUtils.isEmpty(r101) == true) goto L13;
            JSONObject r103 = new JSONObject(r101);     // Catch: Throwable -> L15
            r102 = r103.optInt("err_no", -1);     // Catch: Throwable -> L15
            if (r102 != 0) goto L12;
            JSONObject r104 = r103.optJSONObject("data");     // Catch: Throwable -> L15
            Gson r105 = new Gson();     // Catch: Throwable -> L15
            if (r104 == null) goto L9;
            String r106 = r104.toString();     // Catch: Throwable -> L15
        L10:
            this.f481684d.a((hm7.d) r105.fromJson(r106, hm7.d.class));     // Catch: Throwable -> L15
            return;
        L9:
            r106 = null;
            goto L10
        L12:
            String r107 = r103.optString("err_tips");     // Catch: Throwable -> L15
        L17:
            com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyTaskTimerReqManager", "getTimePendant callback errCode = " + r102 + ", errMsg = " + r107);
            if (this.f481685e == false) goto L20;
        L23:
            com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyTaskTimerReqManager", "getTimePendant callback");
            this.f481684d.onFail(r102, r107);
            return;
        L20:
            if (r102 == 19010) goto L23;
            com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyTaskTimerReqManager", "retry getTimePendant");
            int r108 = b.f481680a;
            b.a(this.f481681a, this.f481682b, this.f481683c, this.f481684d, true);
            return;
        L13:
            r107 = "response is empty";
        L15:
            th = move-exception;
            r107 = "throw " + th.getMessage();
            r102 = -2;
            goto L17
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

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f481686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f481687b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f481688c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ InterfaceC6037b f481689d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f481690e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f481691f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f481692g;

        public d(String r100, long r101, int r102, InterfaceC6037b r103, Ref.IntRef r104, Ref.ObjectRef r105, boolean r106) {
            this.f481686a = r100;
            this.f481687b = r101;
            this.f481688c = r102;
            this.f481689d = r103;
            this.f481690e = r104;
            this.f481691f = r105;
            this.f481692g = r106;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v20, types: [T, java.lang.String] */
        public final void a() {
            JSONObject r100 = new JSONObject();     // Catch: Throwable -> L11
            r100.put("token", this.f481686a);     // Catch: Throwable -> L11
            r100.put(BdpAppEventConstant.PARAMS_UNIQUEID, this.f481687b);     // Catch: Throwable -> L11
            r100.put("current_times", this.f481688c);     // Catch: Throwable -> L11
            String r101 = (String) n.c("https://polaris.zijieapi.com/luckycat/crossover/v:version/task_center_ack_time/", r100).body();     // Catch: Throwable -> L11
            if (TextUtils.isEmpty(r101) == true) goto L9;
            JSONObject r102 = new JSONObject(r101);     // Catch: Throwable -> L11
            int r103 = r102.optInt("err_no", -1);     // Catch: Throwable -> L11
            if (r103 != 0) goto L8;
            r102.optJSONObject("data");     // Catch: Throwable -> L11
            this.f481689d.onSuccess();     // Catch: Throwable -> L11
            return;
        L8:
            this.f481690e.element = r103;     // Catch: Throwable -> L11
            this.f481691f.element = r102.optString("err_tips");     // Catch: Throwable -> L11
        L13:
            com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyTaskTimerReqManager", "uploadTime callback errCode = " + this.f481690e.element + ", errMsg = " + ((String) this.f481691f.element));
            if (this.f481692g == false) goto L16;
        L19:
            com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyTaskTimerReqManager", "uploadTime callback");
            this.f481689d.onFail(this.f481690e.element, (String) this.f481691f.element);
            return;
        L16:
            if (this.f481690e.element == 19011) goto L19;
            com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyTaskTimerReqManager", "retry uploadTimer");
            int r104 = b.f481680a;
            b.b(this.f481686a, this.f481687b, this.f481688c, this.f481689d, true);
            return;
        L9:
            this.f481690e.element = -1;     // Catch: Throwable -> L11
            this.f481691f.element = "response is empty";     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            this.f481690e.element = -2;
            this.f481691f.element = "throw " + th.getMessage();
            goto L13
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
    }

    public static void a(String r100, String r101, int r102, a r110, boolean r111) {
        com.bytedance.ug.sdk.luckydog.api.log.d.a("LuckyTaskTimerReqManager", "uploadTime, token = " + r100 + ", key = " + r101 + ", reportInterval = " + r102 + ", isRetry = " + r111);
        Application r103 = m.f538347a;
        m.d(new c(r100, r101, r102, r110, r111));
    }

    public static void b(String r110, long r111, int r112, InterfaceC6037b r113, boolean r114) {
        com.bytedance.ug.sdk.luckydog.api.log.d.a("LuckyTaskTimerReqManager", "uploadTime, token = " + r110 + ", uniqueId = " + r111 + ", isRetry = " + r114);
        Ref.IntRef r100 = new Ref.IntRef();
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        Application r102 = m.f538347a;
        m.d(new d(r110, r111, r112, r113, r100, r101, r114));
    }
}
