package qm7;

import android.text.TextUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f533905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile tm7.a f533906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile String f533907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f533908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f533909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Gson f533910f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f533911a = null;

        static {
            f533911a = new d();
        }
    }

    public final synchronized void b() {
        monitor-enter(this);
        StringBuilder r100 = new StringBuilder("cleanCommonParams() on call; mCommonResp == null ? ");     // Catch: Throwable -> L18
        if (this.f533906b != null) goto L7;
        boolean r101 = true;
    L8:
        r100.append(r101);     // Catch: Throwable -> L18
        um7.e.b(r100.toString());     // Catch: Throwable -> L18
        if (this.f533905a == true) goto L11;
    L16:
        monitor-exit(this);
        return;
    L11:
        if (this.f533906b == null) goto L16;
        this.f533906b.actBase = "";     // Catch: Throwable -> L18
        this.f533906b.actData = "";     // Catch: Throwable -> L18
        tm7.a r102 = this.f533906b;     // Catch: Throwable -> L18
        r102.activityInfos = new ArrayList();     // Catch: Throwable -> L18
        this.f533906b.isAppLogin = false;     // Catch: Throwable -> L18
        this.f533907c = "";     // Catch: Throwable -> L18
        e.a().c("act_common", this.f533907c);     // Catch: Throwable -> L18
        this.f533909e = true;     // Catch: Throwable -> L18
        c.a.f533904a.a();     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L7:
        r101 = false;
    L18:
        th = move-exception;
        throw th;
    }

    public final synchronized void c() {
        monitor-enter(this);
        um7.e.b("initData() on call; mInitToken = " + this.f533905a);     // Catch: Throwable -> L23
        if (this.f533905a == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f533907c = e.a().b("act_common");     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(this.f533907c) == true) goto L15;
        this.f533906b = (tm7.a) this.f533910f.fromJson(this.f533907c, tm7.a.class);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        um7.e.b(th.getLocalizedMessage());     // Catch: Throwable -> L23
    L15:
        if (this.f533906b != null) goto L18;
        um7.e.b("initTokenData(); initToken finish; data is null; 初始化完成，数据为空");     // Catch: Throwable -> L23
        this.f533906b = new tm7.a();     // Catch: Throwable -> L23
    L18:
        if (a(this.f533906b) == true) goto L20;
        this.f533909e = true;     // Catch: Throwable -> L23
    L20:
        this.f533905a = true;     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public d() {
        this.f533908d = true;
        this.f533910f = new Gson();
    }

    public static boolean a(tm7.a r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (TextUtils.isEmpty(r100.actBase) == true) goto L6;
        return true;
    L6:
        if (TextUtils.isEmpty(r100.actData) == false) goto L16;
        List<tm7.a.C7743a> r101 = r100.activityInfos;
        if (r101 != null) goto L10;
        return false;
    L10:
        if (r101.size() <= 0) goto L19;
        return true;
    L19:
        return false;
    L16:
        return true;
    }

    public final synchronized void d(JSONObject r100) {
        monitor-enter(this);
        um7.e.b("updateCommonData() on call; mInitToken = mInitToken " + this.f533905a + ", commonResp == null ?false");     // Catch: Throwable -> L34
        if (this.f533905a == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        String r101 = r100.toString();     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r101) == false) goto L38;
        monitor-exit(this);
        return;
    L38:
        tm7.a r102 = (tm7.a) this.f533910f.fromJson(r101, tm7.a.class);     // Catch: Throwable -> L14
    L17:
        if (a(r102) == true) goto L22;
        um7.e.a("updateCommonData() 通参数据都为空，无效数据，返回return");     // Catch: Throwable -> L34
        monitor-exit(this);
        return;
    L22:
        if (TextUtils.isEmpty(r101) == true) goto L27;
        if (r101.equals(this.f533907c) == true) goto L27;
        um7.e.b("updateCommonData() 数据发生变化，执行更新数据。update data");     // Catch: Throwable -> L34
        this.f533906b = r102;     // Catch: Throwable -> L34
        this.f533907c = r101;     // Catch: Throwable -> L34
        e.a().c("act_common", this.f533907c);     // Catch: Throwable -> L34
        um7.e.b("updateActCommonData() 执行兼容数据更新");     // Catch: Throwable -> L34
        c r103 = c.a.f533904a;     // Catch: Throwable -> L34
        r103.e(this.f533906b.actBase);     // Catch: Throwable -> L34
        r103.f(this.f533906b.actData);     // Catch: Throwable -> L34
    L27:
        if (this.f533908d == false) goto L30;
        rm7.c.a.f538587a.getClass();     // Catch: Throwable -> L34
        rm7.c.f();     // Catch: Throwable -> L34
        this.f533908d = false;     // Catch: Throwable -> L34
    L30:
        if (this.f533909e == false) goto L32;
        rm7.c.a.f538587a.getClass();     // Catch: Throwable -> L34
        rm7.c.i();     // Catch: Throwable -> L34
        this.f533909e = false;     // Catch: Throwable -> L34
    L32:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        um7.e.b(th.getLocalizedMessage());     // Catch: Throwable -> L34
        r102 = null;
    L34:
        th = move-exception;
        throw th;
    }
}
