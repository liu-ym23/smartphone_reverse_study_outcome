package rm7;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.model.DataUnionStrategy;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements nm7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f538594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f538595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f538596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f538597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f538598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile sm7.a f538599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile String f538600g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Context f538601h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile JSONObject f538602i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Gson f538603j;

    /* JADX INFO: loaded from: classes22.dex */
    public class a implements Runnable {
        public static void a() {
            StringBuilder r100 = new StringBuilder();
            StringBuilder r101 = new StringBuilder();
            if (c.a.f538587a.f538576a == null) goto L7;
            String r102 = null;
            if (TextUtils.isEmpty(null) == true) goto L7;
        L8:
            r101.append(r102);
            r101.append("/luckycat/activity/refresh_act_id/");
            r100.append(um7.f.a(r101.toString()));
            r100.append("?need_token_params=1");
            tm7.c.a(r100.toString());     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            um7.e.b(th.getMessage());
            return;
        L7:
            r102 = "https://polaris.zijieapi.com";
            goto L8
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

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f538604a = null;

        static {
            f538604a = new i();
        }
    }

    public final synchronized void h() {
        monitor-enter(this);
        um7.e.b("initDeviceIdInner() on call;");     // Catch: Throwable -> L21
        if (this.f538595b == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f538595b = true;     // Catch: Throwable -> L21
        this.f538600g = um7.c.c(this.f538602i);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(this.f538600g) == true) goto L11;
        um7.e.b("initDeviceIdInner() 从pendingAppSettings里面获取到configBean，进行存储");     // Catch: Throwable -> L21
        qm7.e.a().c("config_bean", this.f538600g);     // Catch: Throwable -> L21
    L13:
        if (TextUtils.isEmpty(this.f538600g) == false) goto L24;
    L19:
        monitor-exit(this);
        return;
    L24:
        this.f538599f = (sm7.a) this.f538603j.fromJson(this.f538600g, sm7.a.class);     // Catch: Throwable -> L16
    L18:
        i();     // Catch: Throwable -> L21
        f();     // Catch: Throwable -> L21
        goto L19
    L16:
        th = move-exception;
        um7.e.b(th.getLocalizedMessage());     // Catch: Throwable -> L21
        goto L18
    L11:
        this.f538600g = qm7.e.a().b("config_bean");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public final synchronized void i() {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L4:
        if (this.f538598e == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.f538599f != null) goto L10;
    L21:
        um7.e.a("initToken() passportData参数错误，开关没开，或者validKey为空; 需要等待appSettings传入开关配置");     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L10:
        if (this.f538599f.e() == false) goto L21;
        if (TextUtils.isEmpty(this.f538599f.d()) == true) goto L21;
        um7.e.b("initToken(); 进行处理");     // Catch: Throwable -> L24
        Set<DataUnionStrategy> r100 = um7.c.a(this.f538599f.a());     // Catch: Throwable -> L24
        Set<String> r101 = um7.c.d(this.f538599f.c(), false);     // Catch: Throwable -> L24
        boolean r102 = c.a.f538587a.f538579d;     // Catch: Throwable -> L24
        Context r103 = this.f538601h;     // Catch: Throwable -> L24
        pm7.b r104 = pm7.b.a.f529854a;     // Catch: Throwable -> L24
        um7.e.b("init() on call; mInit = " + r104.f529853b);     // Catch: Throwable -> L24
        if (r104.f529853b == true) goto L18;
        r104.f529852a = r103;     // Catch: Throwable -> L24
        pm7.a r105 = pm7.a.C7212a.f529851a;     // Catch: Throwable -> L24
        r105.f529847a = r101;     // Catch: Throwable -> L24
        r105.f529848b = r100;     // Catch: Throwable -> L24
        r104.f529853b = true;     // Catch: Throwable -> L24
    L18:
        qm7.d.a.f533911a.c();     // Catch: Throwable -> L24
        this.f538598e = true;     // Catch: Throwable -> L24
        monitor-exit(this);
    }

    public final String d() {
        if (this.f538598e == true) goto L6;
        um7.e.a("getLocalDeviceToken() on call; 没有初始化 return");
        return "";
    L6:
        String r100 = om7.e.b(e());
        if (TextUtils.isEmpty(r100) == false) goto L10;
        um7.e.a("getLocalDeviceToken() local token为空，返回空");
        return "";
    L10:
        return r100;
    }

    public final String e() {
        if (this.f538594a == true) goto L6;
    L4:
        String r100 = "";
    L12:
        if (TextUtils.isEmpty(r100) == false) goto L15;
        return "";
    L15:
        if (c.a.f538587a.f538579d == true) goto L17;
        return r100;
    L17:
        return "boe_" + r100;
    L6:
        if (this.f538599f == null) goto L4;
        r100 = this.f538599f.d();
        if (TextUtils.isEmpty(r100) == false) goto L12;
        goto L4
    }

    public final synchronized void f() {
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (this.f538599f != null) goto L7;
    L28:
        um7.e.a("handleToken() passportData参数错误，开关没开，或者validKey为空; 需要等待appSettings传入开关配置");     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L7:
        if (this.f538599f.e() == false) goto L28;
        if (TextUtils.isEmpty(e()) == true) goto L28;
        String r100 = e();     // Catch: Throwable -> L31
        qm7.c r101 = qm7.c.a.f533904a;     // Catch: Throwable -> L31
        String r102 = "";
        if (this.f538594a == true) goto L15;
    L21:
        r101.g(r102);     // Catch: Throwable -> L31
        String r103 = om7.e.b(r100);     // Catch: Throwable -> L31
        um7.e.b("handleToken() on call; key = " + r100 + ", token = " + r103);     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r103) == false) goto L24;
        om7.e.a(r100, this);     // Catch: Throwable -> L31
        um7.e.b("handleToken() 当前本地sp里面没有token，执行网络请求取token");     // Catch: Throwable -> L31
    L25:
        com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils.f.a(um7.c.d(this.f538599f.b(), c.a.f538587a.f538579d));     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L24:
        um7.e.b("handleToken() 从本地sp里面拿到token了，token = " + r103);     // Catch: Throwable -> L31
        c.a.f538587a.getClass();     // Catch: Throwable -> L31
        c.h(false);     // Catch: Throwable -> L31
        j();     // Catch: Throwable -> L31
        this.f538597d = true;     // Catch: Throwable -> L31
        goto L25
    L15:
        if (this.f538599f == null) goto L21;
        String r104 = this.f538599f.d();     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r104) == true) goto L21;
        r102 = r104;
        goto L21
    }

    public final void j() {
        if (this.f538599f != null) goto L5;
    L9:
        um7.e.b("refreshActHash() on call; refreshActHash is false; return");
        return;
    L5:
        if (this.f538599f.f() == false) goto L9;
        c.a.f538587a.b(new a());
    }

    public i() {
        this.f538603j = new Gson();
    }

    public Context getContext() {
        return this.f538601h;
    }

    public final synchronized void b(JSONObject r100) {
        monitor-enter(this);
        um7.e.b("doAppSettingsUpdate is called");     // Catch: Throwable -> L27
        if (r100 == null) goto L25;
        String r101 = um7.c.c(r100);     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r101) == true) goto L25;
        if (r101.equals(this.f538600g) == true) goto L25;
        sm7.a r102 = (sm7.a) this.f538603j.fromJson(r101, sm7.a.class);     // Catch: Throwable -> L12
    L14:
        if (r102 == null) goto L25;
        if (TextUtils.isEmpty(r102.d()) == true) goto L25;
        um7.e.b("doAppSettingsUpdate() 配置数据发生变化，curConfig = " + this.f538600g + ", newConfig = " + r101);     // Catch: Throwable -> L27
        String r103 = e();     // Catch: Throwable -> L27
        this.f538600g = r101;     // Catch: Throwable -> L27
        this.f538599f = r102;     // Catch: Throwable -> L27
        qm7.e.a().c("config_bean", this.f538600g);     // Catch: Throwable -> L27
        if (this.f538598e == true) goto L23;
        um7.e.b("doAppSettingsUpdate(); 没有初始化，执行初始化token操作，curKey = " + r103 + ", newKey = " + r102.d());     // Catch: Throwable -> L27
        i();     // Catch: Throwable -> L27
        f();     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L23:
        if (r102.d().equals(r103) == true) goto L25;
        um7.e.b("doAppSettingsUpdate(); key发生变化 handleToken()； curKey = " + r103 + ", key = " + r102.d());     // Catch: Throwable -> L27
        f();     // Catch: Throwable -> L27
        goto L25
    L12:
        th = move-exception;
        um7.e.b(th.getLocalizedMessage());     // Catch: Throwable -> L27
        r102 = null;
    L25:
        monitor-exit(this);
        return;
    L27:
        th = move-exception;
        throw th;
    }

    public final synchronized String c(String r100) {
        monitor-enter(this);
        um7.e.b("doRequestToken() on call; mIsTokenRequesting = " + this.f538596c);     // Catch: Throwable -> L41
        if (this.f538596c == true) goto L7;
        String r101 = om7.e.b(r100);     // Catch: Throwable -> L41
        if (TextUtils.isEmpty(r101) == true) goto L15;
        um7.e.b("doRequestToken() token 不为空了 return");     // Catch: Throwable -> L41
        monitor-exit(this);
        return r101;
    L15:
        this.f538596c = true;     // Catch: Throwable -> L41
        StringBuilder r102 = new StringBuilder();     // Catch: Throwable -> L41
        if (c.a.f538587a.f538576a == null) goto L20;
        String r103 = null;
        if (TextUtils.isEmpty(null) == true) goto L20;
    L21:
        r102.append(r103);     // Catch: Throwable -> L41
        r102.append("/luckycat/activity/apply_token/");     // Catch: Throwable -> L41
        String r104 = um7.f.a(r102.toString());     // Catch: Throwable -> L41
    L33:
        th = move-exception;
        um7.e.b(th.getMessage());     // Catch: Throwable -> L41
    L35:
        this.f538596c = false;     // Catch: Throwable -> L41
        if (TextUtils.isEmpty(r101) == false) goto L38;
        um7.e.a("doRequestToken() 从网络请求获取token失败了，抓包看apply_token接口请求是否正常");     // Catch: Throwable -> L41
    L39:
        monitor-exit(this);
        return r101;
    L38:
        um7.e.b("doRequestToken() 从网络请求获取token成功，token = " + r101);     // Catch: Throwable -> L41
        goto L39
    L23:
        if (r100.startsWith("boe_") == false) goto L25;
        r100 = r100.substring(4);     // Catch: Throwable -> L33
    L25:
        String r105 = tm7.c.a(r104 + "?valid_key=" + r100);     // Catch: Throwable -> L33
        StringBuilder r106 = new StringBuilder("doRequestToken() response = ");     // Catch: Throwable -> L33
        r106.append(r105);     // Catch: Throwable -> L33
        um7.e.b(r106.toString());     // Catch: Throwable -> L33
        if (TextUtils.isEmpty(r105) == true) goto L35;
        JSONObject r107 = new JSONObject(r105);     // Catch: Throwable -> L33
        if (r107.optInt("err_no", -1) != 0) goto L35;
        JSONObject r108 = r107.optJSONObject("data");     // Catch: Throwable -> L33
        if (r108 == null) goto L35;
        r101 = r108.optString("act_token");     // Catch: Throwable -> L33
    L20:
        r103 = "https://polaris.zijieapi.com";
        goto L21
    L7:
        monitor-exit(this);
        return "";
    L41:
        th = move-exception;
        throw th;
    }

    @Override // nm7.a
    public final synchronized void a(String r100, String r101) {
        monitor-enter(this);
        um7.e.b("onDataUnion() on call; key = " + r100 + "; value = " + r101);     // Catch: Throwable -> L20
        if (this.f538599f != null) goto L9;
        um7.e.a("onDataUnion() on call; mConfigBean is null, return;");     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L9:
        String r102 = e();     // Catch: Throwable -> L20
        if (r102.equals(r100) == true) goto L15;
        um7.e.b("onDataUnion() validKey != key; return; validKey = " + r102 + ", key = " + r100);     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L15:
        if (TextUtils.isEmpty(r101) == false) goto L17;
        String r103 = c(r100);     // Catch: Throwable -> L20
        this.f538597d = true;     // Catch: Throwable -> L20
        g(r100, r103);     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return;
    L17:
        j();     // Catch: Throwable -> L20
        c.a.f538587a.getClass();     // Catch: Throwable -> L20
        c.h(true);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public final void g(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L15;
        pm7.b r102 = pm7.b.a.f529854a;
        um7.e.b("setUnionValue() on call; key = " + r100 + "; value = " + r101 + "; mInit = " + r102.f529853b);
        if (r102.f529853b == true) goto L9;
    L12:
        com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils.b.a(r100, r101, com.alipay.sdk.m.k.b.f25406k, DataUnionStrategy.UNION_DEFAULT);
        c.a.f538587a.getClass();
        c.h(true);
        j();
        return;
    L9:
        if (TextUtils.isEmpty(r100) == true) goto L12;
        om7.d.b.f524309a.d(r100, r101);
        goto L12
    }
}
