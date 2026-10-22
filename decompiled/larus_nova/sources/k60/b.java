package k60;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.q1;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.performance.fwatchdog.LiveFWatchDogV2Config;
import com.bytedance.fwatchdog.FWatchDogV2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import iy5.e;
import iy5.f;
import iy5.h;
import iy5.i;
import iy5.j;
import iy5.k;
import iy5.l;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k60.a f501937a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LiveFWatchDogV2Config f501938b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f501939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f501940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f501941e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f501942f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f501943g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C6510b f501944h = null;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.h();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: k60.b$b, reason: collision with other inner class name */
    public class C6510b implements j {
        public C6510b() {
        }

        @Override // iy5.j
        public final void i(String r100) {
            if (v.a() == true) goto L7;
            ALogger.i("FWatchDogV2", r100);
            return;
        }

        @Override // iy5.j
        public final void v(String r100) {
            if (v.a() == true) goto L7;
            ALogger.v("FWatchDog", r100);
            return;
        }

        @Override // iy5.j
        public final void d(String r100, String r101) {
            if (v.a() == true) goto L7;
            ALogger.d(r100, r101);
            return;
        }

        @Override // iy5.j
        public final void e(String r100, String r101) {
            if (v.a() == true) goto L7;
            ALogger.e(r100, r101);
            return;
        }

        @Override // iy5.j
        public final void w(String r100, String r101) {
            if (v.a() == true) goto L7;
            ALogger.w(r100, r101);
            return;
        }
    }

    static {
        f501937a = LiveInfraSettingKeys.LIVE_WIDGET_FRAMEWORK_OPT.getValue();
        f501938b = q1.f65389a.getValue();
        f501939c = -1;
        f501940d = false;
        f501941e = 0;
        f501942f = 0;
        f501943g = new a();
        f501944h = new C6510b();
    }

    public static boolean a() {
        k60.a r100 = f501937a;
        if (r100.mEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.mEnableAsync == false) goto L7;
        return true;
    }

    public static boolean b() {
        if (f501937a.mEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (f501938b.getEnterStartDelay() <= 0) goto L7;
        return true;
    }

    public static boolean c() {
        k60.a r100 = f501937a;
        if (r100.mEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.mEnableInsert == false) goto L7;
        return true;
    }

    public static boolean d() {
        k60.a r100 = f501937a;
        if (r100.mEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.mEnableRxJava == false) goto L7;
        return true;
    }

    public static boolean e() {
        k60.a r100 = f501937a;
        if (r100.mEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.mEnableThreadPool == false) goto L7;
        return true;
    }

    public static boolean f() {
        k60.a r100 = f501937a;
        if (r100.mEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.mEnableToolbar == false) goto L7;
        return true;
    }

    public static int g() {
        k60.a r100 = f501937a;
        if (r100.mEnable == true) goto L7;
        return -1;
    L7:
        return r100.mStrategyVersion;
    }

    public static int h() {
        MainThreadPostUtils.d(f501943g);
        if (f501940d == true) goto L5;
    L8:
        k60.a r100 = f501937a;
        if (r100.mEnable == true) goto L11;
    L13:
        boolean r101 = false;
    L15:
        if (r101 == false) goto L35;
        if (f501942f == 1) goto L35;
        h.a r102 = new h.a();
        LiveFWatchDogV2Config r103 = f501938b;
        r102.f496550a = r103.getEnableLog();
        r102.f496551b = r103.getLogLevel();
        r102.f496552c = r103.getMinSdkApi();
        r102.f496553d = r103.getMaxSdkApi();
        r102.f496555f = r103.getEnableRetryReflect();
        if (r103.getOnVsyncActionStrategy() != 0) goto L21;
        r102.f496554e = 0;
    L22:
        FWatchDogV2 r104 = FWatchDogV2.c();
        h r105 = new h(r102);
        r104.f244932j = r105;
        f r106 = r104.f244931i;
        r106.f496538a = r105.f496544a;
        int r107 = r105.f496545b;
        if (r107 < 0) goto L26;
        if (r107 > 5) goto L26;
        r106.f496540c = r107;
    L26:
        r104.f244923a = new l(new iy5.a(), r105.f496549f);
        int r108 = FWatchDogV2.c().f();
        f501942f = 2;
        if (r108 <= 0) goto L30;
        f501939c = r108;
        return r108;
    L30:
        f501940d = true;
        f501941e = r108;
        if (r103.getEnableFallback() == true) goto L35;
        f501939c = r108;
        return r108;
    L21:
        r102.f496554e = 1;
    L35:
        if (r100.mEnable == true) goto L37;
    L39:
        boolean r109 = false;
    L40:
        if (r109 == false) goto L132;
        f501942f = 1;
        e r110 = e.d();
        Application r111 = jc1.a.b();
        double r112 = r100.mMaxDropFrame;
        float r113 = r100.mDropFrameCheckTime;
        long r114 = r100.mDynamicIntervalFrames;
        long r115 = r100.mNRTimeConfig;
        boolean r116 = r100.mOptimizeReflect;
        boolean r117 = r100.mEnableLog;
        boolean r118 = r100.mEnableV2Opt;
        j r119 = f501944h;
        if (r110.f496506e == false) goto L45;
        r110.f496526y.e("FWatchDog", "FWatchDog is running!Config failed!");
    L83:
        e r120 = e.d();
        r120.getClass();
        if (Looper.myLooper() != Looper.getMainLooper()) goto L86;
        boolean r121 = true;
    L87:
        if (r121 == false) goto L131;
        boolean r122 = ((Boolean) new k(Choreographer.getInstance()).c("USE_VSYNC", new Class[0]).f496561a).booleanValue();     // Catch: Exception -> L134
    L103:
        if (r122 == true) goto L106;
        r120.f496526y.b("FWatchDog", "not use vsync!");
        int r123 = -2;
    L127:
        if (r123 <= 0) goto L129;
        f501939c = r123;
    L129:
        return r123;
    L106:
        if (r120.f496506e == false) goto L108;
        r120.f496526y.b("FWatchDog", "FWatchDog has started!");
        r123 = -3;
        goto L127
    L108:
        r120.f496506e = true;
        int r124 = e.M.addAndGet(1);
        if (r120.E == true) goto L111;
        r120.f496505d = r124;
    L111:
        r120.f496526y.a("FWatchDog", "startWatchDog");
        r120.f496513l = (long) (r120.C * r120.f496517p);
        r120.f496512k = r120.f496513l + r120.f496516o;
        Choreographer.getInstance().removeFrameCallback(r120.F);
        Choreographer.getInstance().postFrameCallback(r120.F);
        if (r120.f496520s == true) goto L114;
        e.d r125 = r120.f496507f;
        if (r125 == null) goto L124;
        if (r125 != null) goto L135;
    L125:
        ThreadMethodProxy.start(r120.f496507f);
    L126:
        r123 = r124;
        goto L127
    L135:
        r125.f496533y = true;     // Catch: Exception -> L122
        r120.f496507f.interrupt();     // Catch: Exception -> L122
    L122:
        e = move-exception;
        r120.f496526y.b("FWatchDog", e.getMessage());
        goto L125
    L124:
        r120.f496507f = new e.d(r120, r120.f496517p, r120.f496518q);
        goto L125
    L114:
        if (r120.f496508g == null) goto L116;
        r120.h();
    L116:
        e.HandlerThreadC6369e r126 = new e.HandlerThreadC6369e();
        r120.f496508g = r126;
        ThreadMethodProxy.setPriority(r126, 5);
        ThreadMethodProxy.start(r120.f496508g);
        r120.f496509h = true;
        r120.f496510i = new Handler(r120.f496508g.getLooper());
        r120.f496510i.removeCallbacks(r120.K);
        Handler r127 = r120.f496510i;
        e.c r128 = r120.K;
        r127.postDelayed(r128, r128.f496535a);
    L141:
        iy5.a r129 = r120.f496502a;     // Catch: Exception -> L101
        if (r129.f496496g != null) goto L97;
        r129.f496496g = r129.b(Choreographer.class, "USE_VSYNC", Boolean.class);     // Catch: Exception -> L101
    L97:
        Field r130 = r129.f496496g;     // Catch: Exception -> L101
        if (r130 == null) goto L102;
        r122 = r130.getBoolean(Choreographer.getInstance());     // Catch: Exception -> L101
    L102:
        r122 = false;
    L101:
        r120.f496526y.b("FWatchDog", "read vsync field error!");
        goto L102
    L131:
        throw new IllegalThreadStateException("FWatchDog must start from mainThread!");
    L86:
        r121 = false;
        goto L87
    L45:
        if (r112 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L48;
        r110.f496517p = r112;
    L48:
        if (r113 <= 0.0f) goto L51;
        r110.f496518q = r113;
    L51:
        if (r114 < 0) goto L54;
        r110.f496514m = r114;
    L54:
        if (r115 <= 0) goto L57;
        r110.f496519r = r115 * 1000000;
    L57:
        if (r111 != null) goto L59;
        i.f496558c = 60;
    L69:
        float r131 = 1000 / i.f496558c;
        i.f496559d = r131;
        i.f496560e = true;
        if (i.f496556a >= 0) goto L72;
        i.f496556a = (long) Math.ceil(r131 * 1000000.0f);
    L72:
        r110.C = i.f496556a;
        if (i.f496557b < 0) goto L75;
    L79:
        r110.D = i.f496557b;
        f r132 = r110.f496526y;
        if (r119 != null) goto L82;
        r119 = r110.f496501J;
    L82:
        r132.f496539b = r119;
        r132.f496538a = r117;
        r110.f496521t = r116;
        r110.f496520s = r118;
        goto L83
    L75:
        if (i.f496560e == false) goto L77;
        float r133 = i.f496559d;
    L78:
        i.f496557b = (long) Math.ceil(r133);
        goto L79
    L77:
        r133 = 16.666668f;
        goto L78
    L59:
        WindowManager r134 = (WindowManager) r111.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r134 == null) goto L65;
        Display r135 = r134.getDefaultDisplay();
        if (r135 == null) goto L64;
        i.f496558c = r135.getRefreshRate();
    L67:
        if (i.f496558c > 0.0f) goto L69;
        i.f496558c = 60;
        goto L69
    L64:
        i.f496558c = 60;
        goto L67
    L65:
        i.f496558c = 60;
        goto L67
    L132:
        return -1;
    L37:
        if (r100.mEnableFWatchDog == false) goto L39;
        r109 = true;
        goto L40
    L11:
        if (f501938b.getEnable() == false) goto L13;
        r101 = true;
        goto L15
    L5:
        if (f501938b.getEnableFallback() == true) goto L8;
        return f501941e;
    }

    public static void i() {
        MainThreadPostUtils.d(f501943g);
        j(f501939c);
    }

    public static void j(int r100) {
        int r101 = f501942f;
        if (r101 != 2) goto L6;
        FWatchDogV2.c().g(r100);
        return;
    L6:
        if (r101 != 1) goto L36;
        e r102 = e.d();
        r102.getClass();
        if (r100 >= 0) goto L11;
        return;
    L11:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L32;
        if (r102.f496505d == r100) goto L19;
        return;
    L19:
        if (r102.f496506e == false) goto L40;
        r102.f496506e = false;
        r102.f496526y.a("FWatchDog", "stopWatchDog");
        if (r102.f496520s == false) goto L34;
        r102.h();
    L30:
        Choreographer.getInstance().removeFrameCallback(r102.F);
        r102.e().removeCallbacks(r102.G);
        r102.e().removeCallbacks(r102.H);
        r102.e().removeCallbacks(r102.I);
        r102.g(r102.f496522u);
        r102.a();
        r102.f496511j = -1;
        r102.f496516o = 0;
        r102.f496515n = 0;
        r102.f496514m = 10;
        r102.f496523v = -1;
        r102.f496522u = -1;
        r102.f496524w = -1;
        r102.f496525x = false;
        r102.f496507f = null;
        r102.B = null;
        r102.E = false;
        return;
    L34:
        e.d r104 = r102.f496507f;     // Catch: Exception -> L28
        if (r104 == null) goto L30;
        r104.f496533y = true;     // Catch: Exception -> L28
        r102.f496507f.interrupt();     // Catch: Exception -> L28
    L28:
        e = move-exception;
        r102.f496526y.b("FWatchDog", e.getMessage());
        goto L30
    L40:
        return;
    L32:
        throw new IllegalThreadStateException("FWatchDog must stop from mainThread!");
    L13:
        r103 = false;
        goto L14
    }

    public static void k(float r110) {
        e r100 = e.d();
        if (r110 <= 0.0f) goto L12;
        r100.f496518q = r110;
        if (r100.f496520s == false) goto L9;
        e.c r101 = r100.K;
        if (r101 == null) goto L14;
        r101.f496535a = Math.max((long) ((r101.f496537c.D * r101.f496536b) * ((double) r110)), 1);
        r101.f496537c.f496526y.a("FWatchDog", "updateCheckInterval:" + r101.f496535a + "  mDropFrameCheckTime:" + r110);
        return;
    L14:
        return;
    L9:
        e.d r102 = r100.f496507f;
        if (r102 == null) goto L16;
        double r103 = r110;
        r102.f496531w = r103;
        r102.f496532x = Math.max((long) ((r102.f496534z.D * r102.f496530v) * r103), 1);
        r102.f496534z.f496526y.a("FWatchDog", "updateCheckInterval:" + r102.f496532x + "  dropFrameCheckTime:" + r110);
        return;
    L16:
        return;
    L12:
        r100.getClass();
    }
}
