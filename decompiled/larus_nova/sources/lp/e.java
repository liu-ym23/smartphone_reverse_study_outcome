package lp;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.ec.window.base.shop.screenAdapt.unit.WindowSubunits;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ttvecamera.TECameraUtils;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes44.dex */
public final class e {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final e f510175s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final boolean f510176t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final e f510177u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f510178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mp.a f510179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final op.a f510180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f510181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f510182e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f510183f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f510184g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f510185h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f510186i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f510187j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f510188k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f510189l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f510190m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public lp.a f510191n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f510192o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f510193p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Field f510194q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public np.b f510195r;

    public static final class a {
        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static void a() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class.forName("androidx.fragment.app.FragmentActivity");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
            FastClassNotFoundHandler.a("androidx.fragment.app.FragmentActivity");     // Catch: Throwable -> L8
            return;
        L36:
            return;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("androidx.fragment.app.FragmentActivity");
        L12:
            throw th;
        L34:
            Class.forName("androidx.fragment.app.FragmentActivity");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
            FastClassNotFoundHandler.a("androidx.fragment.app.FragmentActivity");     // Catch: Throwable -> L17
            return;
        L37:
            return;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("androidx.fragment.app.FragmentActivity");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == false) goto L26;
        L29:
            MiraPluginFix.forName("androidx.fragment.app.FragmentActivity");
            return;
        L26:
            if ((th instanceof NoClassDefFoundError) == true) goto L29;
            throw th;
        }
    }

    static {
        f510175s = new e();
        a.a();     // Catch: ClassNotFoundException -> L5
        boolean r100 = true;
    L6:
        f510176t = r100;
        f510177u = f510175s;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final int a() {
        if (this.f510190m == false) goto L6;
        return this.f510188k;
    L6:
        return this.f510188k - this.f510189l;
    }

    public e() {
        this.f510179b = new mp.a();
        this.f510180c = new op.a();
        this.f510181d = -1.0f;
        this.f510190m = true;
    }

    public final void b(Application r110) {
        Intrinsics.checkNotNullParameter(r110, "application");
        Intrinsics.checkNotNullParameter(r110, "application");
        int r100 = 0;
        if (this.f510181d == (-1.0f)) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L46;
        this.f510178a = r110;
        Resources r102 = Resources.getSystem();
        DisplayMetrics r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics());
        Configuration r104 = Resources.getSystem().getConfiguration();
        if (f510177u.f510180c.f524677a != WindowSubunits.NONE) goto L11;
        this.f510185h = 360;
        this.f510186i = 640;
    L12:
        int r105 = th.a.f(r110).getConfiguration().orientation;
        int r106 = pp.c.f530157a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int[] r107 = new int[2];
        Object r108 = r110.getSystemService(LiveEndPageData.TAG_WINDOW);
        if ((r108 instanceof WindowManager) == true) goto L15;
        r108 = null;
    L15:
        WindowManager r109 = (WindowManager) r108;
        if (r109 == null) goto L18;
        Display r111 = r109.getDefaultDisplay();
    L19:
        DisplayMetrics r112 = new DisplayMetrics();
        if (r111 == null) goto L22;
        r111.getMetrics(r112);
    L22:
        int r113 = r112.widthPixels;
        r107[0] = r113;
        int r114 = r112.heightPixels;
        r107[1] = r114;
        this.f510187j = r113;
        this.f510188k = r114;
        int r115 = Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android");     // Catch: Resources.NotFoundException -> L27
        if (r115 <= 0) goto L29;
        r100 = Resources.getSystem().getDimensionPixelSize(r115);     // Catch: Resources.NotFoundException -> L27
    L29:
        this.f510189l = r100;
        this.f510181d = r103.density;
        this.f510182e = r103.densityDpi;
        this.f510183f = r103.scaledDensity;
        this.f510184g = r103.xdpi;
        int r116 = r104.screenWidthDp;
        int r117 = r104.screenHeightDp;
        r110.registerComponentCallbacks(new f(this, r107));
        lp.a r118 = new lp.a(new h(new g()));
        this.f510191n = r118;
        r110.registerActivityLifecycleCallbacks(r118);
        int r119 = pp.a.f530156a;
        pp.a.a("initDensity = " + this.f510181d + ", initScaledDensity = " + this.f510183f + ",callback:" + this.f510191n);
        if (Intrinsics.areEqual("MiuiResources", th.a.f(r110).getClass().getSimpleName()) == false) goto L32;
    L33:
        this.f510193p = true;
        Field r120 = Resources.class.getDeclaredField("mTmpMetrics");     // Catch: Exception -> L38
        this.f510194q = r120;     // Catch: Exception -> L38
        if (r120 == null) goto L45;
        r120.setAccessible(true);     // Catch: Exception -> L38
        return;
    L45:
        return;
    L38:
        this.f510194q = null;
        return;
    L32:
        if (Intrinsics.areEqual("XResources", th.a.f(r110).getClass().getSimpleName()) == true) goto L33;
        return;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L18:
        r111 = null;
        goto L19
    L11:
        this.f510185h = 1080;
        this.f510186i = TECameraUtils.CAPTURE_NORMAL;
        goto L12
    L46:
        return;
    L5:
        r101 = false;
        goto L6
    }
}
