package com.bytedance.sdk.open.douyin.settings;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.open.aweme.commonbase.net.OpenNetworkManager;
import com.bytedance.sdk.open.aweme.core.OpenHostInfoService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.core.net.OpenHostRequest;
import com.bytedance.sdk.open.aweme.core.net.OpenHostResponse;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.aweme.utils.NetUtils;
import com.bytedance.sdk.open.aweme.utils.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f269690h = "OpenSettingsUpdater";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f269691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile int f269692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long f269693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f269694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<Integer> f269695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e f269696f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected b f269697g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f269698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f269699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f269700c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f269701d;

        public a(c r100, boolean r101, String r102, Map r103) {
            this.f269701d = r100;
            this.f269698a = r101;
            this.f269699b = r102;
            this.f269700c = r103;
        }

        public void com_bytedance_sdk_open_douyin_settings_c$a__run$___twin___() {
            f r100 = c.a(this.f269701d).c();
            if (c.a(this.f269701d, this.f269698a, r100) == true) goto L6;
            LogUtils.d(c.f269690h, new Object[]{"cannot update " + r100.b()});
            return;
        L6:
            monitor-enter(this);
        L32:
            th = move-exception;
            throw th;
        L8:
            if (c.b(this.f269701d) == true) goto L10;
            c.a(this.f269701d, true);     // Catch: Throwable -> L32
            monitor-exit(this);     // Catch: Throwable -> L32
            c r101 = this.f269701d;     // Catch: Throwable -> L25 Exception -> L27
            f r102 = c.a(r101, c.c(r101), r100, this.f269700c, this.f269699b);     // Catch: Throwable -> L25 Exception -> L27
            if (r102 != null) goto L20;
            c.e(this.f269701d);     // Catch: Throwable -> L25 Exception -> L27
            c r103 = this.f269701d;
            c.a(r103, c.b(r103, c.d(r103)));
            c.a(this.f269701d, false);
            return;
        L20:
            c.a(this.f269701d, 0);     // Catch: Throwable -> L25 Exception -> L27
            com.bytedance.sdk.open.tt.e.a(c.c(this.f269701d)).a(r102.e());     // Catch: Throwable -> L25 Exception -> L27
            boolean r104 = c.a(this.f269701d).a(r102);     // Catch: Throwable -> L25 Exception -> L27
            this.f269701d.f269697g.a(r102);     // Catch: Throwable -> L25 Exception -> L27
            if (r104 == false) goto L23;
        L28:
            c r105 = this.f269701d;
            c.a(r105, c.b(r105, c.d(r105)));
            c.a(this.f269701d, false);
            return;
        L23:
            LogUtils.w(c.f269690h, new Object[]{"saveSettingsModel fail"});     // Catch: Throwable -> L25 Exception -> L27
        L27:
            c.e(this.f269701d);     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            c r106 = this.f269701d;
            c.a(r106, c.b(r106, c.d(r106)));
            c.a(this.f269701d, false);
            throw th;
        L10:
            LogUtils.i(c.f269690h, new Object[]{"is updating, ignore " + this.f269699b});     // Catch: Throwable -> L32
            monitor-exit(this);     // Catch: Throwable -> L32
        }

        @Override // java.lang.Runnable
        public void run() {
            com_bytedance_sdk_open_douyin_settings_c$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_sdk_open_douyin_settings_c$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_bytedance_sdk_open_douyin_settings_c$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public interface b {
        void a(f r100);
    }

    public c(Context r100, e r101, b r102) {
        this.f269692b = 0;
        this.f269693c = 0;
        this.f269694d = false;
        this.f269695e = Arrays.asList(new Integer[]{0, 60, 60, 120, 240, 600});
        this.f269691a = r100;
        this.f269696f = r101;
        this.f269697g = r102;
    }

    public static /* synthetic */ int a(c r100, int r101) {
        r100.f269692b = r101;
        return r101;
    }

    private long a(int r100) {
        if (r100 != 0) goto L6;
        long r101 = System.currentTimeMillis();
        long r102 = 3600000;
    L5:
        return r101 + r102;
    L6:
        int r103 = Math.min(r100, this.f269695e.size() - 1);
        r101 = System.currentTimeMillis();
        r102 = ((long) ((Integer) ListProtector.get(this.f269695e, r103)).intValue()) * 1000;
        goto L5
    }

    public static /* synthetic */ long a(c r100, long r101) {
        r100.f269693c = r101;
        return r101;
    }

    public static /* synthetic */ e a(c r100) {
        return r100.f269696f;
    }

    private f a(Context r100, f r101, Map<String, String> r110, String r111) throws Exception {
        System.currentTimeMillis();
        OpenHostInfoService r102 = (OpenHostInfoService) OpenServiceManager.getInst().getService(OpenHostInfoService.class);
        if (r102 != null) goto L6;
        LogUtils.w(f269690h, new Object[]{"OpenHostInfoService is not init"});
        return null;
    L6:
        g r112 = new g.b().a(r110).e(r101.a()).a(r101.d()).a(r102.getAppId()).j(r102.getInstallId()).g(r102.getDeviceId()).d(r102.getChannel()).n(r102.getVersionCode()).b(r102.getAppName()).h("Android").i(Build.MODEL).f(Build.BRAND).k(Build.VERSION.RELEASE).a(Build.VERSION.SDK_INT).m(r102.getUpdateVersionCode()).o(r102.getVersionName()).a();
        LogUtils.i(f269690h, new Object[]{"requestSettingsModel"});
        OpenHostResponse r103 = OpenNetworkManager.with(r100).newCall(new OpenHostRequest.Builder(r112.a()).addHostCommonParams(true).get().build()).execute();
        h r113 = new h();
        r113.f269760a = r103.code;
        r113.f269761b = r103.message;
        JSONObject r104 = new JSONObject(r103.body.stringBody());     // Catch: Exception -> L13
        r113.a(r104);     // Catch: Exception -> L13
        boolean r105 = TextUtils.equals("success", JSONObjectProtectorUtils.getString(r104, "message"));     // Catch: Exception -> L13
        r113.f269762c = r105;     // Catch: Exception -> L13
        if (r105 == false) goto L15;
        r113.f269765f = JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(r104, "data"), "ctx_infos");     // Catch: Exception -> L13
        r113.f269764e = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r104, "data"), f.f269710g);     // Catch: Exception -> L13
        r113.f269766g = JSONObjectProtectorUtils.getJSONObject(r104, "data").optLong("settings_time", 0);     // Catch: Exception -> L13
        r113.f269763d = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r104, "data"), "settings");     // Catch: Exception -> L13
    L15:
        if (r113.f269760a == 200) goto L18;
        return null;
    L18:
        return a(r101, r113);
    }

    public static /* synthetic */ f a(c r100, Context r101, f r102, Map r103, String r104) throws Exception {
        return r100.a(r101, r102, r103, r104);
    }

    private f a(f r110, h r111) throws Exception {
        JSONObject r100 = r111.f269764e;
        if (r100 != null) goto L5;
        r100 = new JSONObject();
    L5:
        JSONObject r101 = r100;
        if (TextUtils.isEmpty(r111.f269765f) == false) goto L8;
        String r102 = "";
    L9:
        String r103 = r102;
        long r104 = r111.f269766g;
        long r105 = System.currentTimeMillis();
        JSONObject r106 = new JSONObject();
        if (r110.b() != 0) goto L14;
        JSONObject r112 = r111.f269763d;
        if (r112 == null) goto L23;
        JSONObject r107 = r112;
    L25:
        return new f(r105, r103, r107, r101, r104);
    L23:
        r107 = r106;
        goto L25
    L14:
        r106 = new JSONObject(r110.c().toString());
        JSONObject r113 = r111.f269763d;
        if (r113 == null) goto L23;
        Iterator<String> r114 = r113.keys();
    L18:
        if (r114.hasNext() == false) goto L23;
        String r108 = r114.next();
        r106.put(r108, r111.f269763d.get(r108));     // Catch: Exception -> L22
        goto L18
    L8:
        r102 = r111.f269765f;
        goto L9
    }

    public static /* synthetic */ boolean a(c r100, boolean r101) {
        r100.f269694d = r101;
        return r101;
    }

    public static /* synthetic */ boolean a(c r100, boolean r101, f r102) {
        return r100.a(r101, r102);
    }

    private boolean a(boolean r100, f r101) {
        if (NetUtils.isNetworkAvailable(this.f269691a) == true) goto L6;
        LogUtils.i(f269690h, new Object[]{"network not available"});
        return false;
    L6:
        if (r100 == false) goto L10;
        LogUtils.i(f269690h, new Object[]{"force update"});
        return true;
    L10:
        if (r101.f() == false) goto L14;
        LogUtils.i(f269690h, new Object[]{"settings is valid"});
        return false;
    L14:
        if (System.currentTimeMillis() >= this.f269693c) goto L17;
        LogUtils.i(f269690h, new Object[]{"frequency limit " + System.currentTimeMillis() + this.f269693c});
        return false;
    L17:
        return true;
    }

    public static /* synthetic */ long b(c r100, int r101) {
        return r100.a(r101);
    }

    public static /* synthetic */ boolean b(c r100) {
        return r100.f269694d;
    }

    public static /* synthetic */ Context c(c r100) {
        return r100.f269691a;
    }

    public static /* synthetic */ int d(c r100) {
        return r100.f269692b;
    }

    public static /* synthetic */ int e(c r100) {
        int r101 = r100.f269692b;
        r100.f269692b = r101 + 1;
        return r101;
    }

    public void a(Map<String, String> r100, boolean r101, String r102) {
        ThreadUtils.summit(new a(this, r101, r102, r100));
    }
}
