package sk3;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.shopping.store.utils.screenAdapt.unit.Subunits;
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

/* JADX INFO: loaded from: classes14.dex */
public final class e {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final e f542341s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final boolean f542342t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final e f542343u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f542344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tk3.a f542345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vk3.a f542346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f542347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f542348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f542349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f542350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f542351h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f542352i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f542353j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f542354k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f542355l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f542356m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public sk3.a f542357n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f542358o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f542359p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Field f542360q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public uk3.b f542361r;

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
        f542341s = new e();
        a.a();     // Catch: ClassNotFoundException -> L5
        boolean r100 = true;
    L6:
        f542342t = r100;
        f542343u = f542341s;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final int a() {
        if (this.f542356m == false) goto L6;
        return this.f542354k;
    L6:
        return this.f542354k - this.f542355l;
    }

    public e() {
        this.f542345b = new tk3.a();
        this.f542346c = new vk3.a();
        this.f542347d = -1.0f;
        this.f542356m = true;
    }

    public final void b(Application r110) {
        Intrinsics.checkNotNullParameter(r110, "application");
        Intrinsics.checkNotNullParameter(r110, "application");
        int r100 = 0;
        if (this.f542347d == (-1.0f)) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L46;
        this.f542344a = r110;
        Resources r102 = Resources.getSystem();
        DisplayMetrics r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics());
        Configuration r104 = Resources.getSystem().getConfiguration();
        if (f542343u.f542346c.f555470a != Subunits.NONE) goto L11;
        this.f542351h = 360;
        this.f542352i = 640;
    L12:
        int r105 = r110.getResources().getConfiguration().orientation;
        int r106 = wk3.c.f560095a;
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
        this.f542353j = r113;
        this.f542354k = r114;
        int r115 = Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android");     // Catch: Resources.NotFoundException -> L27
        if (r115 <= 0) goto L29;
        r100 = Resources.getSystem().getDimensionPixelSize(r115);     // Catch: Resources.NotFoundException -> L27
    L29:
        this.f542355l = r100;
        this.f542347d = r103.density;
        this.f542348e = r103.densityDpi;
        this.f542349f = r103.scaledDensity;
        this.f542350g = r103.xdpi;
        int r116 = r104.screenWidthDp;
        int r117 = r104.screenHeightDp;
        r110.registerComponentCallbacks(new f(this, r107));
        sk3.a r118 = new sk3.a(new h(new g()));
        this.f542357n = r118;
        r110.registerActivityLifecycleCallbacks(r118);
        int r119 = wk3.a.f560094a;
        wk3.a.a("initDensity = " + this.f542347d + ", initScaledDensity = " + this.f542349f + ",callback:" + this.f542357n);
        if (Intrinsics.areEqual("MiuiResources", r110.getResources().getClass().getSimpleName()) == false) goto L32;
    L33:
        this.f542359p = true;
        Field r120 = Resources.class.getDeclaredField("mTmpMetrics");     // Catch: Exception -> L38
        this.f542360q = r120;     // Catch: Exception -> L38
        if (r120 == null) goto L45;
        r120.setAccessible(true);     // Catch: Exception -> L38
        return;
    L45:
        return;
    L38:
        this.f542360q = null;
        return;
    L32:
        if (Intrinsics.areEqual("XResources", r110.getResources().getClass().getSimpleName()) == true) goto L33;
        return;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L18:
        r111 = null;
        goto L19
    L11:
        this.f542351h = 1080;
        this.f542352i = TECameraUtils.CAPTURE_NORMAL;
        goto L12
    L46:
        return;
    L5:
        r101 = false;
        goto L6
    }
}
