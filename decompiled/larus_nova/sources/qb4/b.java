package qb4;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.comonui.VerifyConfirmDialogActivity;
import com.bytedance.bdturing.identityverify.IdentityVerifyService;
import com.bytedance.bdturing.livedetect.LiveDetectService;
import com.bytedance.bdturing.loginverify.LoginVerifyService;
import com.bytedance.bdturing.senseless.SenselessVerifyService;
import com.bytedance.bdturing.ttnet.TTNetHttpClient;
import com.bytedance.bdturing.uc_twiceverify.UCTwiceVerifyService;
import com.bytedance.bdturing.verify.ITuringVerifyService;
import com.bytedance.bdturing.verify.RiskControlService;
import com.bytedance.bdturing.verify.TwiceVerifyService;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BdTuringConfig f532302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f532303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RiskControlService f532304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f532305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, ic4.a> f532306e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VerifyConfirmDialogActivity.c f532307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public jc4.m f532308g;

    /* JADX INFO: loaded from: classes12.dex */
    public class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jc4.a f532309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f532310b;

        public a(jc4.a r100, f r101) {
            this.f532309a = r100;
            this.f532310b = r101;
        }

        @Override // qb4.f
        public final void onFail(int r100, JSONObject r101) {
            EventReport.i(r100, r101, this.f532309a);
            f r102 = this.f532310b;
            if (r102 == null) goto L6;
            r102.onFail(r100, r101);
            return;
        }

        @Override // qb4.f
        public final void onSuccess(int r100, JSONObject r101) {
            EventReport.i(r100, r101, this.f532309a);
            f r102 = this.f532310b;
            if (r102 == null) goto L6;
            r102.onSuccess(r100, r101);
            return;
        }
    }

    /* JADX INFO: renamed from: qb4.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes12.dex */
    public class C7305b implements vb4.g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f532311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f532312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ jc4.a f532313c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f532314d;

        public final void a() {
            qb4.c r100 = new qb4.c(this);
            b r101 = this.f532314d;
            Activity r102 = this.f532311a;
            jc4.a r103 = this.f532313c;
            r101.getClass();
            if (r103.f498094e == false) goto L5;
            r101.h(r102, r103, r100);
            return;
        L5:
            r101.e(r103, r100);
        }

        public C7305b(b r100, Activity r101, f r102, jc4.a r103) {
            this.f532314d = r100;
            this.f532311a = r101;
            this.f532312b = r102;
            this.f532313c = r103;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f532315a = null;

        static {
            f532315a = new b();
        }
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.bdturing.verify.IdentityService");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.bdturing.verify.IdentityService");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.bdturing.verify.IdentityService");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.bdturing.verify.IdentityService");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.bdturing.verify.IdentityService");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.bdturing.verify.IdentityService");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.bdturing.verify.IdentityService");
    }

    public final void d() {
        if (this.f532302a.getInjectHeader() == false) goto L6;
        ec4.h.a();
    L6:
        if (this.f532302a.isTTNetProcessorEnable() == false) goto L9;
        NetworkParams.setRetryRequestCallback(new ec4.f());
    L9:
        if (this.f532302a.isBypassBdTuring() == false) goto L12;
        HashMap r100 = new HashMap();
        r100.put(NetworkParams.BYPASS_BDTURING_HEADER_KEY, "1");
        RetrofitUtils.addInterceptor(new ec4.g(r100));
        return;
    }

    public b() {
        this.f532303b = false;
        this.f532304c = null;
        this.f532305d = 0;
        this.f532306e = new HashMap();
    }

    public static void c(BdTuringConfig r100) {
        if (r100.getApplicationContext() == null) goto L43;
        if (r100.getHttpClient() != null) goto L8;
        r100.setHttpClient(new TTNetHttpClient(r100.getApplicationContext()));
    L8:
        if (r100.getHttpClient() == null) goto L41;
        if (r100.getEventClient() == null) goto L41;
        if (r100.getUcTwiceVerifyDepend() == null) goto L39;
        if (r100.getLoginVerifyDepend() == null) goto L37;
        if (r100.getByteNNDepend() != null) goto L20;
        r100.setByteNNDepend(new vb4.a());
    L20:
        if (TextUtils.isEmpty(r100.getAppId()) == true) goto L35;
        if (TextUtils.isEmpty(r100.getAppVersion()) == true) goto L33;
        if (TextUtils.isEmpty(r100.getAppVersionCode()) == true) goto L31;
        if (TextUtils.isEmpty(r100.getAppName()) == true) goto L29;
        return;
    L29:
        throw new RuntimeException("appName is null");
    L31:
        throw new RuntimeException("appVersionCode is null");
    L33:
        throw new RuntimeException("appVersion is null");
    L35:
        throw new RuntimeException("appId is null");
    L37:
        throw new RuntimeException("LoginVerifyDepend is null");
    L39:
        throw new RuntimeException("TwiceVerifyDepend is null");
    L41:
        throw new RuntimeException("httpClient or eventClient is null");
    L43:
        throw new RuntimeException("config or applicationContext is null");
    }

    public final void b(ic4.a r100) {
        if (this.f532306e.containsKey(r100.getClass().getName()) == false) goto L5;
        return;
    L5:
        this.f532306e.put(r100.getClass().getName(), r100);
    }

    public final synchronized void f(BdTuringConfig r100) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f532303b == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L10
        this.f532302a = r100;     // Catch: Throwable -> L10
        c(r100);     // Catch: Throwable -> L10
        d();     // Catch: Throwable -> L10
        c0.a.f532328a.d();     // Catch: Throwable -> L10
        g(r100);     // Catch: Throwable -> L10
        tb4.a.a(r100);     // Catch: Throwable -> L10
        com.bytedance.bdturing.twiceverify.a r102 = com.bytedance.bdturing.twiceverify.a.a();     // Catch: Throwable -> L10
        r102.f202111a = this.f532302a.getTwiceVerifyDepend();     // Catch: Throwable -> L10
        this.f532303b = true;     // Catch: Throwable -> L10
        EventReport.M(System.currentTimeMillis() - r101, r100);     // Catch: Throwable -> L10
        cc4.g.d().i();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final void g(BdTuringConfig r100) {
        RiskControlService r101 = RiskControlService.INSTANCE;
        this.f532304c = r101;
        b(r101);
        b(new TwiceVerifyService());
        b(new UCTwiceVerifyService());
        b(IdentityVerifyService.getInstance());
        b(new LoginVerifyService());
        b(LiveDetectService.getInstance());
        b(SenselessVerifyService.getInstance());
        LiveDetectService.getInstance().init(r100.getApplicationContext());
        b((ic4.a) a().newInstance());     // Catch: InstantiationException -> L5 IllegalAccessException -> L7 ClassNotFoundException -> L9
    L16:
        return;
    L9:
        e = move-exception;
        int r102 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        int r103 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
        return;
    L5:
        e = move-exception;
        int r104 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public final void e(jc4.a r110, f r111) {
        Iterator<ic4.a> r100 = this.f532306e.values().iterator();
    L3:
        int r101 = 1;
        if (r100.hasNext() == false) goto L8;
        ic4.a r102 = r100.next();
        if (r102.isProcess(r110.getType()) == false) goto L3;
        boolean r103 = r102.execute(r110, r111);
        boolean r104 = true;
    L23:
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L18
        r105.put("key", "handle_verify");     // Catch: Exception -> L18
        if (r102 == null) goto L12;
        String r106 = r102.getClass().getName();     // Catch: Exception -> L18
    L13:
        r105.put("custom", r106);     // Catch: Exception -> L18
        if (r103 == false) goto L16;
        r101 = 0;
    L16:
        r105.put("result", r101);     // Catch: Exception -> L18
        EventReport.w("turing_verify_sdk", r105, r110);     // Catch: Exception -> L18
    L20:
        if (r104 == true) goto L28;
        r111.onFail(996, null);
        return;
    L28:
        return;
    L12:
        r106 = "";
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L8:
        r102 = null;
        r103 = false;
        r104 = false;
        goto L23
    }

    public final synchronized void h(Activity r100, jc4.a r101, qb4.c r102) {
        monitor-enter(this);
        Iterator<ic4.a> r103 = this.f532306e.values().iterator();     // Catch: Throwable -> L28
    L4:
        boolean r104 = false;
        if (r103.hasNext() == false) goto L13;
        ic4.a r105 = r103.next();     // Catch: Throwable -> L28
        if ((r105 instanceof ITuringVerifyService) == false) goto L4;
        ITuringVerifyService r106 = (ITuringVerifyService) r105;     // Catch: Throwable -> L28
        if (r106.isOnVerify() == false) goto L13;
        if (r106.isSenseless() == true) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == false) goto L16;
    L17:
        r104 = true;
    L18:
        if (r104 == false) goto L23;
        r102.onFail(998, null);     // Catch: Throwable -> L28
        EventReport.S(r101, "popConfirmDialog");     // Catch: Throwable -> L28
        bc4.b.a().d(r101);     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L23:
        if ((r101 instanceof jc4.m) == false) goto L25;
        this.f532308g = (jc4.m) r101;     // Catch: Throwable -> L28
    L25:
        this.f532307f = new e(this, r101, r102);     // Catch: Throwable -> L28
        VerifyConfirmDialogActivity.startActivity(r100);     // Catch: Throwable -> L28
        EventReport.startActivity(true, VerifyConfirmDialogActivity.class.getName(), r101);     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L16:
        if (this.f532307f == null) goto L18;
    L13:
        r107 = false;
    L28:
        th = move-exception;
        throw th;
    }

    public final void i(Activity r100, jc4.a r101, f r102) {
        j(r100, r101, new a(r101, r102), true);
    }

    public final void j(Activity r100, jc4.a r101, f r110, boolean r111) {
        boolean r102 = true;
        if (r101 != null) goto L7;
        r110.onFail(1, null);
        return;
    L7:
        if (r101.f498097h == (-1)) goto L9;
    L12:
        JSONObject r103 = new JSONObject();
        r103.put("key", "verify_param_received");     // Catch: JSONException -> L15
        EventReport.w("turing_verify_sdk", r103, r101);
    L18:
        if (r111 == true) goto L20;
    L40:
        int r112 = q.a.f532380a;
        r101.getType();
        EventReport.f201690c = r101.f498093d;
        EventReport.f201691d = r101.g();
        EventReport.f201693f = r101.getType();
        EventReport.f201692e = r101.f498095f;
        EventReport.f201695h = r101.f498094e;
        EventReport.f201694g = r101.f498097h;
        EventReport.f201697j = r101.f498101l;
        EventReport.f201696i = Long.valueOf(r101.f498100k);
        if (vb4.g.f554021a == null) goto L43;
    L52:
        vb4.g r113 = vb4.g.f554021a;
        C7305b r104 = new C7305b(this, r100, r110, r101);
        r113.getClass();
        if ((r101 instanceof jc4.m) == true) goto L56;
        r104.a();
        return;
    L56:
        if ((((jc4.m) r101).f498122o instanceof jc4.i) == true) goto L67;
        r104.a();
        return;
    L67:
    L63:
        e = move-exception;
        EventReport.t(false, "_1", "errorMessage:" + e, r101);
        r104.a();
        e.printStackTrace();
        return;
    L59:
        if (LiveDetectService.getInstance().useByteNN() == false) goto L61;
        r113.a(r101, r110, r104);     // Catch: Exception -> L63
    L66:
        return;
    L61:
        r113.b(r101, r110, r104);     // Catch: Exception -> L63
        goto L66
    L43:
        monitor-enter(vb4.g.class);
    L49:
        th = move-exception;
        throw th;
    L45:
        if (vb4.g.f554021a != null) goto L47;
        vb4.g.f554021a = new vb4.g();     // Catch: Throwable -> L49
    L47:
        monitor-exit(vb4.g.class);     // Catch: Throwable -> L49
        goto L52
    L20:
        if (this.f532303b == false) goto L22;
        if (r100 == null) goto L22;
    L28:
        if ((System.currentTimeMillis() - this.f532305d) < 500) goto L31;
        r102 = false;
    L31:
        this.f532305d = System.currentTimeMillis();
        if (r102 == false) goto L34;
        int r114 = n.f532367a;
        r110.onFail(1000, null);
        Pair r115 = new Pair(Boolean.FALSE, "invoke multi times");
    L37:
        if (((Boolean) r115.first).booleanValue() == true) goto L40;
        bc4.b r105 = bc4.b.a();
        String r116 = (String) r115.second;
        r105.d(r101);
        EventReport.A(r101, "BdTuring_" + ((String) r115.second));
        return;
    L34:
        r115 = new Pair(Boolean.TRUE, "");
    L22:
        if (r100 == null) goto L24;
    L35:
        r110.onFail(2, null);
        r115 = new Pair(Boolean.FALSE, "isInitDone=" + this.f532303b + ";activity=" + r100);
        goto L37
    L24:
        if ("nocaptcha".equals(r101.f498101l) == true) goto L28;
        if ("nocaptcha_collect".equals(r101.f498101l) == false) goto L35;
    L15:
        e = move-exception;
        int r106 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
        goto L18
    L9:
        if ((r101 instanceof jc4.m) == false) goto L11;
        r101.f498097h = 1;
        goto L12
    L11:
        r101.f498097h = 2;
        goto L12
    }
}
